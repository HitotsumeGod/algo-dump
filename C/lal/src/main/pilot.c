#include <stdio.h>
#include <errno.h>
#include "lal.h"

int main(void) {
	
	rmatrix_storage s;
	s.size = 1;
	s.matrices = mk_rmatrix(4, 4, 8, 1);
	free_rmatrix(&s);
	return 0;

}
