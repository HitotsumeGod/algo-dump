#include <stdio.h>
#include "trees.h"

#define DEPTH 4
#define CHILDREN 4

int main(void) {

	TreeNode *root;
	char c = 61;
	
	root = mkutree(&c, DEPTH, CHILDREN);
	trimr(root, NULL, CHILDREN);
	printf("This tree has %d leaves!\n", COUNTLEAVES(DEPTH, CHILDREN));
	return 0;

}
