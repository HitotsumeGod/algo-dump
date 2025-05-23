#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include "lal.h"

rmatrix *mk_rmatrix(uint16_t dims, signed int filler) {

	rmatrix *m;
	mmatrix *mm;
	size_t v_size = 8;

	if ((m = malloc(sizeof(rmatrix))) == NULL || (m -> matrix = malloc(sizeof(mmatrix))) == NULL) {
		errno = MALLOC_ERR;
		return NULL;
	}
	m -> dimensions = dims;
	if ((m -> matrix -> matrix_form = malloc(sizeof(mmatrix) * dims)) == NULL) {
		errno = MALLOC_ERR;
		return NULL;
	}
	mm = m -> matrix -> matrix_form;
	for (int i = 0; i < dims; i++) {
		if (((mm + i) -> vector_form = malloc(sizeof(signed int) * v_size)) == NULL) {
			errno = MALLOC_ERR;
			return NULL;
		}
		for (int ii = 0; ii < v_size; ii++)
			*((mm + i) -> vector_form + ii) = filler;
		for (int ii = 0; ii < v_size; ii++)
			printf("%d\t", *((mm + i) -> vector_form + ii));
		printf("\n");
	}
	return m;

}
