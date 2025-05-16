section		.data
	;integer array to process. MUST be terminated with a null byte
	vals	dw 5, 7, 4, 70, 3, 100, 2, 4, 1, 5, 10, 3, 4, 17, 12, 2, 3, 0x0
	;initial size of vals array, minus terminating null byte
	isiz	equ $-vals-2
	;size of the currently-used type (byte, word, dword, etc)
	tsiz	equ 2
	valsiz	db 0x0
section		.text
global 		_start
;iterates over the array to confirm whether or not it is sorted; aborts upon encountering a single unsorted pair and sets r8b to indicate this
check_if_sorted:
	mov	edi, vals-tsiz
	sortit:
	add	edi, tsiz
	mov	ax, [edi]
	mov	bx, [edi+tsiz]
	cmp	bx, 0x00
	je 	done
	cmp	ax, bx
	jbe	sortit
	mov	r8b, 0x99
	ret
	done:
	xor	r8b, r8b
	ret
_start:
	mov 	ax, isiz
	mov	bl, tsiz
	div	bl
	mov	[valsiz], al	
upper:
	mov	edi, vals
	mov	cl, [valsiz]
	dec	cl	
loop:
	mov 	ax, [edi]
	cmp	ax, [edi+tsiz]	
	jbe 	skip
	mov	dx, [edi+tsiz]
	mov	[edi+tsiz], ax
	mov	[edi], dx
skip:
	add	edi, tsiz
	dec	cl
	jnz	loop
	call 	check_if_sorted
	cmp	r8b, 0x99
	je	upper
exit:
	mov	al, 60
	mov	dil, 0
	syscall
