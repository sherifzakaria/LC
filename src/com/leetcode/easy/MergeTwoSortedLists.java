package com.leetcode.easy;


//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        MergeTwoSortedLists obj = new MergeTwoSortedLists();

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode firstNode = null;
        ListNode sortedList = null;

        while (l1 != null || l2 != null) {
            if (firstNode == null) {
                firstNode = new ListNode();
                sortedList = firstNode;
            } else {
                sortedList.next = new ListNode();
                sortedList = sortedList.next;
            }
            if (l1 != null) {
                if (l2 != null) {
                    if (l1.val <= l2.val) {
                        sortedList.val = l1.val;
                        l1 = l1.next;
                    } else {
                        sortedList.val = l2.val;
                        l2 = l2.next;
                    }
                } else {
                    sortedList.val = l1.val;
                    l1 = l1.next;
                }
            } else {
                sortedList.val = l2.val;
                l2 = l2.next;
            }
        }

        return firstNode;
    }
}
