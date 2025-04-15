#ifndef __TREES_H__
#define __TREES_H__

struct TreeNode {
	void *val;
	struct TreeNode *parent;
	struct TreeNode **children;
};
typedef struct TreeNode TreeNode;

extern TreeNode *mktroot(void *val, int children);						//GIVEN A VALUE AND CHILDREN CHILDREN, CREATES A TREENODE DESIGNED TO BE THE ROOT OF A TREE, AND CREATES A CHILD ARRAY WITH CHILDREN POTENTIAL CHILDREN
extern TreeNode *mktnode(void *val, TreeNode *parent, int children);				//GIVEN A VALUE, A PARENT, AND CHILDREN CHILDREN, CREATES A TREENODE AND CREATES A CHILD ARRAY WITH CHILDREN POTENTIAL CHILDREN
extern TreeNode *mkutree(void *val, int depth, int children);					//GIVEN A VOID POINTER, DEPTH DEPTH AND CHILDREN CHILDREN, CREATES A UNIFORM TREE (ALL NODES HAVE SAME NUMBER OF CHILDREN AND THE SAME VALUE) AND RETURNS A POINTER TO THE ROOT NODE
void growr(TreeNode *node, TreeNode *parent, void *val, int depth, int children);		//RECURSIVELY GENERATES A UNIFORM TREE ACCORDING TO THE PASSED ARGUMENTS
void trimr(TreeNode *node, TreeNode *parent, int children);					//RECURSIVELY FREES A UNIFORM TREE THAT ABIDES BY THE PASSED ARGUMENTS

#endif	//__TREES_H__
