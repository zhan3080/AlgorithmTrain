package com.xxx.hzz.listnode;

/**
 * Created by huangzezhan on 2020/3/1.
 */

public class ListNodeOperation {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        System.out.println("ListNodeOperation addTwoNumbers");
        int count = 0;
        int sum;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            sum = a + b + count;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            count = sum / 10;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if (count > 0) {
            cur.next = new ListNode(count);
        }

        return head.next;
    }

    public ListNode reverse(ListNode l) {
        System.out.println("ListNodeOperation reverse");
        if (l == null || l.next == null) {
            return l;
        }
        //三个指针遍历，逐个反转
        ListNode pre = null;
        ListNode cur = l;
        ListNode next = null;

        // 用cur遍历链表
        while (cur != null) {
            next = cur.next;//next指向下一个节点
            cur.next = pre;//当前节点反转指向前一个节点
            pre = cur;//前一个节点往后移一位
            cur = next;//当前节点也往后移一位。next充当一个临时变量
            //最后cur必然指向null，所以返回了pre作为新的头指针
        }
        return pre;
    }

    // 跟reverse类似，使用head遍历链表，可以少用一个next节点
    public ListNode reverse1(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode newHead = null;
        ListNode cur;
        while(head!=null){
            cur = head;
            head = head.next;

            cur.next = newHead;
            newHead = cur;
        }
        return newHead;
    }


    ListNode m_phead = null;
    // 递归
    public ListNode reverse2(ListNode head) {

        if (head == null)
            return null;
        if (head.next == null) {
            m_phead = head;
//            System.out.println("m_phead:"+m_phead.toString());
            //递归到最后，链表只有一个节点，head.next肯定为null，head既是头节点也尾节点
            //用m_phead记录该节点，反转后就是头节点
            return head;
        }
//        System.out.println("head:"+head.toString());
        //输出的是链表尾
        ListNode new_tail = reverse2(head.next);
        new_tail.next = head;
        head.next = null;
        return head; //输出: head变成新链表的尾指针
    }

    //头插法
    public ListNode reverse3(ListNode head){
        if(head == null){
            return null;
        }

        ListNode p = head.next;
        ListNode q;

        while (p.next!=null){
            q = p.next;
            p.next = q.next;
            q.next = head.next;
            head.next = q;

        }
        //这个时候，轮询完了所有插入，如：原1->2->3->4变成了1->4->3->2
        //所以还需要把头节点移动尾部（形成环，把head移动一下，再把环断开）

        p.next=head;//相当于成环，p指向头指针就形成了一个环
        head=p.next.next;//新head变为原head的next，即head往后移一位
        p.next.next=null;//断掉环，原来尾指针是p，现在p.next（即原来的head）

        //换成下面这段应该会好理解点
//        ListNode m = head; //m指向原来的head节点
//        head = head.next;  //原来head往后移一位
//        p.next = m;        //再把原来头节点移到尾部
//        m.next = null;

        return head;
    }


    //链表相交
    //根据长度
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode a = headA;
        ListNode b = headB;
        int lenA = 0;
        int lenB = 0;

        while(a!=null){
            lenA ++;
            a = a.next;
        }
        while(b!=null){
            lenB ++;
            b = b.next;
        }
        int s = lenA - lenB;
        if(lenA>lenB){
            a = headA;
            b = headB;
        }else {
            a = headB;
            b = headA;
            s = -s;
        }

        while(s-->0){
            a = a.next;
        }

        while (a.val!=b.val){
            a = a.next;
            b = b.next;
        }
        return a;

    }

    //链表相交
    //链表叠加，相交点之后的长度相同
    // {1，2，3，4，5，6，NULL，9，5，6}
    // {9，5，6，NULL，1，2，3，4，5，6}
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        //应该是a == b?，为了测试使用以下判断条件
        while (a.val!=b.val){
            a = a.next==null?headB:a.next;
            b = b.next==null?headA:b.next;
        }
        return a;
    }

}
