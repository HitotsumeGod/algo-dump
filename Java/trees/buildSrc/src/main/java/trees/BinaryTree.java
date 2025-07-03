package trees;

public class BinaryTree {

    private static class BinaryTreeNode {

        private final BinaryTreeNode left, right;
        private final Object contents;

        private BinaryTreeNode(BinaryTreeNode either) {

            right = either;
            left = null;
            contents = null;

        }

        private BinaryTreeNode(BinaryTreeNode either, ) {

            right = either;
            left = null;
            contents = null;

        }

        private BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right) {

            this.left = left;
            this.right = right;
            contents = null;

        }

    }

    private BinaryTreeNode root;

    public BinaryTree()

}
