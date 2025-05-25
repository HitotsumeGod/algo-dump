#include <stdlib.h>
#include "lal.h"

void free_rmatrix(uint16_t dims, uint16_t size, rmatrix *m) {

	free_mmatrix_rec(dims, size, m -> matrix);

}

mmatrix *free_mmatrix_rec(uint16_t dims, uint16_t size, mmatrix *m) {

	if (dims == 1) {
		free(m -> vector_form);
		return m;
	}
	for (int i = 0; i < size; i++)
		free_mmatrix_rec(dims - 1, size, m -> matrix_form + i);

}
