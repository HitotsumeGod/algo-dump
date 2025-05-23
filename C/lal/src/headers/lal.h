#ifndef __LAL_H__
#define __LAL_H__

#include <stdint.h>

#define MALLOC_ERR -2
#define REALLOC_ERR -3
#define FORMAT_ERR -4
#define BAD_ARGS_ERR -5

typedef union __mutable_matrix {
	signed int *vector_form;
	union __mutable_matrix *matrix_form;
} mmatrix;

typedef struct __arbitrary_matrix {
	uint16_t dimensions;
	mmatrix *matrix;
} rmatrix;

typedef struct {
	size_t size;
	rmatrix *matrices;
} rmatrix_storage;

extern rmatrix *mk_rmatrix(uint16_t dimensions, signed int filler);
extern rmatrix *clone_rmatrix(rmatrix *matrix);
extern void free_rmatrix(rmatrix_storage *matrices);
extern signed int get_matrix_sum(rmatrix_storage *matrices);
extern rmatrix *add_matrices(rmatrix_storage *matrices);
extern rmatrix *sub_matrices(rmatrix_storage *matrices);
extern rmatrix *scale_matrix(signed int scalar, rmatrix *operand);
extern rmatrix *matrix_product(rmatrix_storage *matrices);
extern rmatrix *matrix_vector_product(rmatrix *vector, rmatrix *operand);
extern rmatrix *invert_matrix(rmatrix *operand);

#endif //__LAL_H__