section		.data
	vals	dw 5, 2, 3, 4, 5
section		.text
global 		_start
_start:
	mov	bl, 3
upper:
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
	dec	bl
	jnz	upper
exit:
	mov	al, 60
	mov	dil, 0
	syscall
