section		.data
	vals	dw 5, 4, 3, 2, 3
section		.text
global 		_start
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
exit:
	mov	al, 60
	mov	dil, 0
	syscall
