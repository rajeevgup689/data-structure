package linkedlist;

import java.util.LinkedList;

public class NthElementFromLast {
    static void main() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("10");
        linkedList.add("20");
        linkedList.add("30");
        linkedList.add("40");
        linkedList.add("50");
        linkedList.add("60");
        linkedList.add("70");
        linkedList.add("80");
        linkedList.add("90");
        linkedList.add("100");

        System.out.println(linkedList.get(linkedList.size() - (6)));

        // using CustomLinkedList
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.add("10");
        customLinkedList.add("20");
        customLinkedList.add("30");
        customLinkedList.add("40");
        customLinkedList.add("50");
        customLinkedList.add("60");
        customLinkedList.add("70");
        customLinkedList.add("80");
        customLinkedList.add("90");
        customLinkedList.add("100");
        //System.out.println(nthElementFromLast(customLinkedList, 6));
    }


}
