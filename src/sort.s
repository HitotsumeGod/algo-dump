section		.data
	vals	dw 5, 4, 3, 2, 3
section		.text
global 		_start
check_if_sorted:
	mov	edi, vals-2
sortit:
	add	edi, 2
	mov	ax, [edi]
	mov	bx, [edi+2]
	cmp	ax, 0x0
	je 	done
	cmp	ax, bx
	jbe	sortit
	mov	r8b, 0x99
	ret
done:
	xor	r8b, r8b
	ret
_start:
	mov	edi, vals
	mov	cl, 5	
loop:
	mov 	ax, [edi]
	cmp	ax, [edi+2]	
	jbe 	skip
	mov	dx, [edi+2]
	mov	[edi+2], ax
	mov	[edi], dx
skip:
	add	edi, 2
	dec	cl
	jnz	loop
	call 	check_if_sorted
	cmp	r8b, 0x99
	je	_start
exit:
	mov	al, 60
	mov	dil, 0
	syscall
