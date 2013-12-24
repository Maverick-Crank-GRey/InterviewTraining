package leetcode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sobercheg on 12/22/13.
 */
public class TreeFromInPreOrder {
    /*
         ______7______
       /              \
    __10__          ___2
   /      \        /
   4       3      _8
            \    /
             1  11


   preorder = {7,10,4,3,1,2,8,11}
   inorder = {4,10,3,1,7,11,8,2}
     */

    class MutableInt {
        int i;

        MutableInt(int i) {
            this.i = i;
        }
    }

    public TreeNode buildInorderPreorder(int[] pre, int[] in) {
        return buildInorderPreorder(pre, new MutableInt(0), pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode buildInorderPreorder(int[] pre, MutableInt preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart.i > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(pre[preStart.i]);
        int inPos = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[preStart.i]) {
                inPos = i;
                break;
            }
        }
        preStart.i++;
        TreeNode left = buildInorderPreorder(pre, preStart, preEnd, in, inStart, inPos - 1);
        TreeNode right = buildInorderPreorder(pre, preStart, preEnd, in, inPos + 1, inEnd);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        TreeFromInPreOrder treeFromInPreOrder = new TreeFromInPreOrder();
        TreeNode root = treeFromInPreOrder.buildInorderPreorder(
                new int[]{7, 10, 4, 3, 1, 2, 8, 11},
                new int[]{4, 10, 3, 1, 7, 11, 8, 2});

        printLevelByLevel(root);

    }

    private static void printLevelByLevel(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> indent = new LinkedList<Integer>();
        int counter1 = 0;
        int counter2 = 0;
        q.offer(root);
        int initialIndent = 80;
        indent.offer(initialIndent);
        int prevInd = 0;
        counter2++;
        int level = 1;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int ind = indent.poll();
            System.out.print(String.format("%" + (ind - prevInd + 2) + "s", "{" + node + "}"));
            prevInd = ind;

            if (node.left != null) {
                counter1++;
                q.offer(node.left);
                indent.offer(ind - initialIndent / (level + 1) + 4);
            }

            if (node.right != null) {
                counter1++;
                q.offer(node.right);
                indent.offer(ind + initialIndent / (level + 1) - 4);
            }

            counter2--;
            if (counter2 == 0) {
                System.out.println();
                counter2 = counter1;
                counter1 = 0;
                prevInd = 0;
                level++;
            }
        }
    }
}
