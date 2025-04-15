#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "trees.h"

TreeNode *mktroot(void *v, int ch) {

	TreeNode *root, **children;

	if ((root = malloc(sizeof(TreeNode))) == NULL || (children = malloc(sizeof(TreeNode *) * ch)) == NULL) {
		perror("malloc err");
		exit(EXIT_FAILURE);
	}
	root -> val = v;
	root -> parent = NULL;
	root -> children = children;
	return root;

}

TreeNode *mktnode(void *v, TreeNode *p, int ch) {

	TreeNode *node, **children;

	if ((node = malloc(sizeof(TreeNode))) == NULL || (children = malloc(sizeof(TreeNode *) * ch)) == NULL) {
		perror("malloc err");
		exit(EXIT_FAILURE);
	}
	node -> val = v;
	node -> parent = p;
	node -> children = children;
	//printf("%c", *((char *) node -> val));
	return node;

}

TreeNode *mkutree(void *v, int d, int ch) {

	TreeNode *root;

	root = mktroot(v, ch);
	for (int i = 0; i < ch; i++)
		growr(*(root -> children + i), NULL, v, d, ch);
	return root;

}

void growr(TreeNode *node, TreeNode *p, void *v, int d, int ch) {

	if (d == 0) {
		node = NULL;
		return;
	}
	node = mktnode(v, p, ch);
	for (int i = 0; i < ch; i++)
		growr(*(node -> children + i), node, v, d - 1, ch);

}

void trimr(TreeNode *node, TreeNode *p, int ch) {

	if (*(node -> children) == NULL) {
		while (node -> parent != NULL) {
			node = node -> parent;
			for (int i = 0; i < ch; i++)
				free(*(node -> children + i));
		}	
		free(node);
		return;
	}
	trimr(*(node -> children), node, ch);

}
