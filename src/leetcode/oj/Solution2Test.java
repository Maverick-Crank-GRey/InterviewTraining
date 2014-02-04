package leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;

import static leetcode.oj.Solution.ListNode;
import static leetcode.oj.Solution.TreeNode;
import static leetcode.oj.TestUtils.*;

/**
 * Author: Sobercheg on 1/29/14.
 * Unit tests for LeetCode OJ solutions.
 */
public class Solution2Test {
    private final Solution2 solution = new Solution2();

    public static void main(String[] args) {
        Solution2Test solutionTest = new Solution2Test();
        solutionTest.testMinPathSum();
        solutionTest.testMergeTwoLists();
        solutionTest.testAddBinary();
        solutionTest.testPlusOne();
        solutionTest.testIsNumber();
        solutionTest.testFullJustify();
        solutionTest.testClimbStairs();
        solutionTest.testSimplifyPath();
        solutionTest.testMinDistance();
        solutionTest.testSetZeros();
        solutionTest.testMinWindow();
        solutionTest.testSearchMatrix();
        solutionTest.testSortColors();
        solutionTest.testExist();
        solutionTest.testCombine();
        solutionTest.testSubsets();
        solutionTest.testRemoveDuplicates();
        solutionTest.testSearch();
        solutionTest.testDeleteDuplicates();
        solutionTest.testDeleteDuplicatesII();
        solutionTest.testLargestRectangleArea();
        solutionTest.testInorderTraversal();
        solutionTest.testNumTrees();
        solutionTest.testGenerateTrees();
        solutionTest.testIsValidBST();
        solutionTest.testIsSameTree();
        solutionTest.testBuildTree();
        solutionTest.testIsSymmetric();
        solutionTest.testMaximalRectangle();
        solutionTest.testPartition();
    }

    public void testMinPathSum() {
        assertEquals(18, solution.minPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 5},
                {6, 8, 7},
        })); // 1 2 3 5 7

        assertEquals(1, solution.minPathSum(new int[][]{
                {1}
        }));
    }

    public void testMergeTwoLists() {
        ListNode list1 = ListNode.build(1, 3, 5);
        ListNode list2 = ListNode.build(2, 4, 6);
        ListNode actualMerged = solution.mergeTwoLists(list1, list2);
        ListNode expectedMerged = ListNode.build(1, 2, 3, 4, 5, 6);
        assertEquals(expectedMerged, actualMerged);

        list2 = ListNode.build(1);
        actualMerged = solution.mergeTwoLists(null, list2);
        expectedMerged = ListNode.build(1);
        assertEquals(expectedMerged, actualMerged);

        list1 = ListNode.build(2);
        list2 = ListNode.build(1);
        actualMerged = solution.mergeTwoLists(list1, list2);
        expectedMerged = ListNode.build(1, 2);
        assertEquals(expectedMerged, actualMerged);
    }

    public void testAddBinary() {
        assertEquals("100", solution.addBinary("11", "1"));
    }

    public void testPlusOne() {
        assertEquals(new int[]{1, 0, 0}, solution.plusOne(new int[]{9, 9}));
    }

    public void testIsNumber() {
        assertEquals(true, solution.isNumber("1"));
        assertEquals(true, solution.isNumber("1e1"));
        assertEquals(true, solution.isNumber("-1e1"));
        assertEquals(true, solution.isNumber("-1."));
        assertEquals(true, solution.isNumber("-1.2 "));
        assertEquals(true, solution.isNumber("-1.2e23"));
        assertEquals(true, solution.isNumber("-1.2e-23"));
        assertEquals(false, solution.isNumber("-1.2e-23e"));
        assertEquals(false, solution.isNumber("a"));
        assertEquals(false, solution.isNumber(" -."));
    }

    public void testFullJustify() {
        assertEquals(Arrays.asList(
                "This    is    an",
                "example  of text",
                "justification.  "),
                solution.fullJustify(
                        new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));

        assertEquals(Arrays.asList(
                "                "),
                solution.fullJustify(
                        new String[]{""}, 16));

        assertEquals(Arrays.asList("a"), solution.fullJustify(new String[]{"a"}, 1));

        assertEquals(Arrays.asList(
                "Listen",
                "to    ",
                "many, ",
                "speak ",
                "to   a",
                "few.  "),
                solution.fullJustify(
                        new String[]{"Listen", "to", "many,", "speak", "to", "a", "few."}, 6));

        assertEquals(Arrays.asList(
                "world  owes  you a living; the",
                "world                         "),
                solution.fullJustify(
                        new String[]{"world", "owes", "you", "a", "living;", "the", "world"}, 30));

    }

    public void testClimbStairs() {
        assertEquals(3, solution.climbStairs(3));
        assertEquals(5, solution.climbStairs(4));
    }

    public void testSimplifyPath() {
        assertEquals("/home", solution.simplifyPath("/home/"));
        assertEquals("/c", solution.simplifyPath("/a/./b/../../c/"));
    }

    public void testMinDistance() {
        assertEquals(3, solution.minDistance("bugaga", "bgzgz"));
        assertEquals(1, solution.minDistance("a", ""));
    }

    public void testSetZeros() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {1, 0, 4},
                {1, 1, 1},
        };
        solution.setZeroes(matrix);
        assertArrayEquals(matrix, new int[][]{
                {1, 0, 3},
                {0, 0, 0},
                {1, 0, 1},
        });

        matrix = new int[][]{
                {1, 2},
                {1, 0},
        };
        solution.setZeroes(matrix);
        assertArrayEquals(matrix, new int[][]{
                {1, 0},
                {0, 0},
        });

        matrix = new int[][]{
                {0, 0, 0, 5},
                {4, 3, 1, 4},
                {0, 1, 1, 4},
                {1, 2, 1, 3},
                {0, 0, 1, 1}
        };
        solution.setZeroes(matrix);
        assertArrayEquals(matrix, new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 4},
                {0, 0, 0, 0},
                {0, 0, 0, 3},
                {0, 0, 0, 0}
        });
    }

    public void testMinWindow() {
        assertEquals("ba", solution.minWindow("bba", "ab"));
        assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("", solution.minWindow("ADOBECODEBANC", "ABQ"));
        assertEquals("a", solution.minWindow("a", "a"));
        assertEquals("b", solution.minWindow("ab", "b"));
        assertEquals("aa", solution.minWindow("aa", "aa"));
        assertEquals("aec", solution.minWindow("cabefgecdaecf", "cae"));
        assertEquals("cwae", solution.minWindow("cabwefgewcwaefgcf", "cae"));
    }

    public void testSearchMatrix() {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
        };
        assertEquals(true, solution.searchMatrix(matrix, 3));
        assertEquals(false, solution.searchMatrix(matrix, 4));
        assertEquals(false, solution.searchMatrix(matrix, 0));
        assertEquals(false, solution.searchMatrix(matrix, 70));
        assertEquals(true, solution.searchMatrix(matrix, 11));

        matrix = new int[][]{
                {1, 3},
        };
        assertEquals(true, solution.searchMatrix(matrix, 1));
        assertEquals(true, solution.searchMatrix(matrix, 3));
        assertEquals(false, solution.searchMatrix(matrix, 2));
    }

    public void testSortColors() {
        int[] colors = new int[]{1, 0, 2, 0, 1, 1, 0, 2, 0};
        solution.sortColors(colors);
        assertEquals(new int[]{0, 0, 0, 0, 1, 1, 1, 2, 2}, colors);

        colors = new int[]{2, 1};
        solution.sortColors(colors);
        assertEquals(new int[]{1, 2}, colors);
    }

    public void testExist() {
        char[][] board = new char[][]{
                "abce".toCharArray(),
                "sfcs".toCharArray(),
                "adee".toCharArray(),
        };

        assertEquals(true, solution.exist(board, "abcced"));
        assertEquals(true, solution.exist(board, "see"));
        assertEquals(false, solution.exist(board, "abcb"));

        board = new char[][]{
                {'a'}
        };

        assertEquals(true, solution.exist(board, "a"));
    }

    public void testCombine() {
        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        expected.add(arrayListOf(1, 2));
        expected.add(arrayListOf(1, 3));
        expected.add(arrayListOf(1, 4));
        expected.add(arrayListOf(2, 3));
        expected.add(arrayListOf(2, 4));
        expected.add(arrayListOf(3, 4));

        assertEquals(expected, solution.combine(4, 2));
    }

    public void testSubsets() {
        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        expected.add(new ArrayList<Integer>());
        expected.add(arrayListOf(1));
        expected.add(arrayListOf(2));
        expected.add(arrayListOf(1, 2));
        expected.add(arrayListOf(3));
        expected.add(arrayListOf(1, 3));
        expected.add(arrayListOf(2, 3));
        expected.add(arrayListOf(1, 2, 3));

        assertEquals(expected, solution.subsets(new int[]{1, 2, 3}));

        expected = new ArrayList<ArrayList<Integer>>();
        expected.add(new ArrayList<Integer>());
        expected.add(new ArrayList<Integer>(Arrays.asList(0)));

        assertEquals(expected, solution.subsets(new int[]{0}));
    }

    public void testRemoveDuplicates() {
        int[] a = new int[]{1, 1, 1, 2, 2, 3};
        assertEquals(5, solution.removeDuplicates(a));
        assertEquals(new int[]{1, 1, 2, 2, 3}, a, 5);

        a = new int[]{1, 2, 3};
        assertEquals(3, solution.removeDuplicates(a));
        assertEquals(new int[]{1, 2, 3}, a, 3);

        a = new int[]{1};
        assertEquals(1, solution.removeDuplicates(a));
        assertEquals(new int[]{1}, a, 1);

        a = new int[]{1, 1, 1, 1, 1};
        assertEquals(2, solution.removeDuplicates(a));
        assertEquals(new int[]{1, 1}, a, 2);

        a = new int[]{1, 1, 1, 1, 2};
        assertEquals(3, solution.removeDuplicates(a));
        assertEquals(new int[]{1, 1, 2}, a, 3);
    }

    public void testSearch() {
        assertEquals(true, solution.search(new int[]{1, 2, 1, 1, 1}, 1));
        assertEquals(true, solution.search(new int[]{1, 2, 1, 1, 1}, 2));
        assertEquals(false, solution.search(new int[]{1, 2, 1, 1, 1}, 3));
        assertEquals(false, solution.search(new int[]{1, 2, 1, 1, 1}, 0));
        assertEquals(true, solution.search(new int[]{1, 2, 3, 4, 1}, 4));
        assertEquals(false, solution.search(new int[]{1}, 0));
    }

    public void testDeleteDuplicates() {
        ListNode root = ListNode.build(1);
        ListNode noDuplicates = solution.deleteDuplicates(root);
        ListNode expected = ListNode.build(1);
        assertEquals(expected, noDuplicates);

        root = ListNode.build(1, 2, 3);
        noDuplicates = solution.deleteDuplicates(root);
        expected = ListNode.build(1, 2, 3);
        assertEquals(expected, noDuplicates);

        root = ListNode.build(1, 1, 1, 2);
        noDuplicates = solution.deleteDuplicates(root);
        expected = ListNode.build(1, 2);
        assertEquals(expected, noDuplicates);
    }

    public void testDeleteDuplicatesII() {
        ListNode root = ListNode.build(1);
        ListNode noDuplicatesActual = solution.deleteDuplicatesII(root);
        ListNode noDuplicatesExpected = ListNode.build(1);
        assertEquals(noDuplicatesExpected, noDuplicatesActual);

        root = ListNode.build(1, 2, 3);
        noDuplicatesActual = solution.deleteDuplicatesII(root);
        noDuplicatesExpected = ListNode.build(1, 2, 3);
        assertEquals(noDuplicatesExpected, noDuplicatesActual);

        root = ListNode.build(1, 1, 1, 2, 3);
        noDuplicatesActual = solution.deleteDuplicatesII(root);
        noDuplicatesExpected = ListNode.build(2, 3);
        assertEquals(noDuplicatesExpected, noDuplicatesActual);

        root = ListNode.build(1, 2, 3, 3, 4, 4, 5);
        noDuplicatesActual = solution.deleteDuplicatesII(root);
        noDuplicatesExpected = ListNode.build(1, 2, 5);
        assertEquals(noDuplicatesExpected, noDuplicatesActual);

    }

    public void testLargestRectangleArea() {
        assertEquals(10, solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        assertEquals(10, solution.largestRectangleArea(new int[]{10}));
        assertEquals(20, solution.largestRectangleArea(new int[]{10, 10}));
        assertEquals(20, solution.largestRectangleArea(new int[]{10, 11}));
        assertEquals(3, solution.largestRectangleArea(new int[]{2, 1, 2}));
        assertEquals(10, solution.largestRectangleArea(new int[]{4, 2, 0, 3, 2, 4, 3, 4}));
    }

    public void testInorderTraversal() {
        Solution.TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        assertEquals(Arrays.asList(1, 3, 2), solution.inorderTraversal(root));

        root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), new TreeNode(5, new TreeNode(6), null)), null);
        assertEquals(Arrays.asList(4, 3, 2, 6, 5, 1), solution.inorderTraversal(root));
    }

    public void testNumTrees() {
        assertEquals(5, solution.numTrees(3));
        assertEquals(1, solution.numTrees(1));
    }

    public void testGenerateTrees() {
        ArrayList<TreeNode> expectedTrees = new ArrayList<TreeNode>();
        expectedTrees.add(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3))));
        expectedTrees.add(new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null)));
        expectedTrees.add(new TreeNode(2, new TreeNode(1), new TreeNode(3)));
        expectedTrees.add(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null));
        expectedTrees.add(new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null));
        ArrayList<TreeNode> generatedTrees = solution.generateTrees(3);
        assertEquals(expectedTrees, generatedTrees);

        expectedTrees = new ArrayList<TreeNode>();
        expectedTrees.add(new TreeNode(1));
        generatedTrees = solution.generateTrees(1);
        assertEquals(expectedTrees, generatedTrees);
    }

    public void testIsValidBST() {
        assertEquals(true, solution.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        assertEquals(false, solution.isValidBST(new TreeNode(2, new TreeNode(2), new TreeNode(3))));
    }

    public void testIsSameTree() {
        TreeNode tree1 = new TreeNode(1, new TreeNode(2), null);
        TreeNode tree2 = new TreeNode(1, new TreeNode(2), null);
        assertEquals(true, solution.isSameTree(tree1, tree2));

        tree1 = new TreeNode(1, new TreeNode(2), null);
        tree2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertEquals(false, solution.isSameTree(tree1, tree2));
    }

    public void testBuildTree() {
        TreeNode root = solution.buildTree(new int[]{1, 2, 3, 5, 6, 7, 4}, new int[]{3, 2, 5, 7, 6, 1, 4});
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(4, root.right.val);
        assertEquals(null, root.right.right);
        assertEquals(null, root.right.left);
        assertEquals(3, root.left.left.val);
        assertEquals(5, root.left.right.val);
        assertEquals(6, root.left.right.right.val);
        assertEquals(7, root.left.right.right.left.val);
    }

    public void testIsSymmetric() {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, new TreeNode(3), null));
        assertEquals(true, solution.isSymmetric(root));

        root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        assertEquals(false, solution.isSymmetric(root));

        assertEquals(true, solution.isSymmetric(null));

        assertEquals(true, solution.isSymmetric(new TreeNode(1)));
    }

    public void testMaximalRectangle() {
        char[][] matrix = new char[][]{
                "000000011".toCharArray(),
                "000011100".toCharArray(),
                "000011100".toCharArray(),
                "111100011".toCharArray(),
                "111000001".toCharArray(),
        };

        assertEquals(6, solution.maximalRectangle(matrix));
    }

    public void testPartition() {
        ListNode list = ListNode.build(1, 4, 3, 2, 5, 2);
        ListNode partitioned = solution.partition(list, 3);
        assertEquals(ListNode.build(1, 2, 2, 4, 3, 5), partitioned);

        list = ListNode.build(1, 4, 3, 2, 5, 2);
        partitioned = solution.partition(list, 6);
        assertEquals(ListNode.build(1, 4, 3, 2, 5, 2), partitioned);

        list = ListNode.build(1, 4, 3, 2, 5, 2);
        partitioned = solution.partition(list, 0);
        assertEquals(ListNode.build(1, 4, 3, 2, 5, 2), partitioned);
    }

}
