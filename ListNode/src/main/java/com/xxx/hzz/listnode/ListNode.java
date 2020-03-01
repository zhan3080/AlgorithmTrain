package com.xxx.hzz.listnode;

import java.util.Random;

/**
 * Created by huangzezhan on 2020/3/1.
 */

public class ListNode {
    ListNode next;
    int val;
    public ListNode(int v){
        val = v;
    }

    public static ListNode buildFromArray(int[] arr) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int a : arr) {
            curr.next = new ListNode(a);
            curr = curr.next;
        }

        return head.next;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(val);

        ListNode nextNode = this.next;
        while(nextNode != null) {
            out.append(" -> ").append(nextNode.val);
            nextNode = nextNode.next;
        }

        return out.toString();
    }

    public static ListNode buildFromNumber(int num, int range) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        Random rand = new Random();
        int val;
        while(true) {

            val=rand.nextInt(range);
            curr.next = new ListNode((int)val);
            curr = curr.next;
            num --;
            if (num <= 0) {
                break;
            }
        }

        return head.next;
    }
}
