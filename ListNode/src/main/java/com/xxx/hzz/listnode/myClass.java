package com.xxx.hzz.listnode;

public class myClass {
    public static void main(String[] args) {
        System.out.println("myClass ListNode test");
        ListNodeOperation operation = new ListNodeOperation();

//        int[] a = {1, 2, 4, 3};
//        ListNode l1 = ListNode.buildFromArray(a);
//        System.out.println("l1:" + l1.toString());
//
//        ListNode l2 = ListNode.buildFromNumber(5, 10);
//        System.out.println("l2:" + l2.toString());


        //test two listnode add
//        ListNode p = operation.addTwoNumbers(l1,l2);
//        System.out.println(p.toString());


        //test listnode reverse
//        ListNode reverse = operation.reverse(l1);
//        if(reverse!=null){
//            System.out.println(reverse.toString());
//        }
//
//        ListNode reverse2 = operation.reverse2(l1);
//        System.out.println("reverse2:" + operation.m_phead.toString());
//        System.out.println();
//
//        ListNode reverse3 = operation.reverse3(l2);
//        if (reverse3 != null) {
//            System.out.println("reverse3:" + reverse3.toString());
//        }
//        System.out.println();


        // 两个链表相加，表头为高位
        // 先反转，再相加，最后再反转回来
//        int[] aaa = {5, 6, 2, 3, 7};
//        int[] bbb = {1, 7, 0, 9, 2};
//        ListNode la = ListNode.buildFromArray(aaa);
//        ListNode lb = ListNode.buildFromArray(bbb);
//        System.out.println(la.toString());
//        System.out.println(lb.toString());
//        ListNode p = operation.addTwoNumbers(operation.reverse(la), operation.reverse(lb));
//        System.out.println(operation.reverse(p).toString());
//        System.out.println();


        //两个链表相交
        int[] aaa = {6, 2, 3, 7};
        int[] bbb = {8,1, 7, 2, 3, 7};
        ListNode la = ListNode.buildFromArray(aaa);
        ListNode lb = ListNode.buildFromArray(bbb);
        System.out.println(la.toString());
        System.out.println(lb.toString());
        ListNode p = operation.getIntersectionNode1(la, lb);
        System.out.println(p.toString());
        System.out.println();

    }
}
