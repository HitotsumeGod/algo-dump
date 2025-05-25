#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include "lal.h"

uint32_t tag_counter;

rmatrix *mk_rmatrix(uint16_t dims, uint16_t size, size_t v_size, signed int filler) {

	rmatrix *m;

	tag_counter = 0;
	if ((m = malloc(sizeof(rmatrix))) == NULL || (m -> matrix = malloc(sizeof(mmatrix))) == NULL) {
		errno = MALLOC_ERR;
		return NULL;
	}
	m -> dimensions = dims;
	mk_dims_rec(dims, size, v_size, filler, m -> matrix);
	printf("Generated %d vectors within a(n) %d dimensional matrix.\n", tag_counter, dims);
	return m;

}

void mk_dims_rec(uint16_t dims, uint16_t size, size_t vsz, int filler, mmatrix *m) {

	if (dims == 1) {
		if ((m -> vector_form = malloc(sizeof(signed int) * vsz)) == NULL) {
			perror("Internal malloc err in recursive loop.");
			exit(EXIT_FAILURE);
		}
		for (int i = 0; i < vsz; i++)
			*(m -> vector_form + i) = filler;
		++tag_counter;
		return;
	}
	if ((m -> matrix_form = malloc(sizeof(mmatrix) * size)) == NULL) {
		perror("Internal malloc err in recursive loop.");
		exit(EXIT_FAILURE);
	}
	for (int i = 0; i < size; i++)
		mk_dims_rec(dims - 1, size, vsz, filler, m -> matrix_form + i);

}
