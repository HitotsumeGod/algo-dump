#include <stdio.h>
#include <errno.h>
#include "lal.h"

int main(void) {

	free_rmatrix(mk_rmatrix(16, 1));
	return 0;

}
