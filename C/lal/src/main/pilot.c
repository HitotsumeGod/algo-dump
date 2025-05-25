#include <stdio.h>
#include <errno.h>
#include "lal.h"

int main(void) {
	
	rmatrix_storage s;
	s.size = 1;
	s.matrices = mk_rmatrix(2, 7, 8, 1);
	free_rmatrix(2, 7, s.matrices);
	s.matrices = mk_rmatrix(7, 7, 8, 1);
	free_rmatrix(7, 7, s.matrices);
	return 0;

}
