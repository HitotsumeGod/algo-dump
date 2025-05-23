#include <stdlib.h>
#include <errno.h>
#include "lal.h"

void free_rmatrix(rmatrix_storage *box) {

	for (int i = 0; i < box -> size; i++) {
		free(box -> matrices + i);
	}

}
