#include <stdio.h>
#include "trees.h"

#define DEPTH 7
#define CHILDREN 7

int main(void) {

	TreeNode *root;
	char c = 61;
	long sum;
	
	sum = 0L;
	root = mkutree(&c, DEPTH, CHILDREN);
	trimr(root, NULL, CHILDREN);
	for (int i = 1; i <= DEPTH; i++)
		sum += i * CHILDREN;
	printf("\nThis tree has %ld leaves!\n", sum);
	return 0;

}
