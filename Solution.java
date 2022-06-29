public class Solution {
    /**
     * The definition for the linked list. DO NOT modify for this class
     */
    public static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * The method for you to implement
     * <p>
     * DO NOT change the method header
     */
    // The method for you to implement
    public ListNode merge(ListNode l1, ListNode l2) {
        // TODO
        ListNode MergeResult; // I create a new list --> STORED number if elements of the list

        if(l1 == null && l2 == null){ //Check whether if both of lists is empty --> Return null because there is no INTERSECTION
            return null;} // No merge point

        //Return the numbers that LEFT of the other list
        if(l1 == null){ //Check whether if list 1 is empty
            return l2; //EMPTY --> return list 2
        }else if(l2 == null){ //Check whether if list 2 is empty
            return l1; // EMPTY --> return list 1
        }

        if(l1.value < l2.value){ //Check which value is SMALLER --> USE that list
            MergeResult = l1; //HOLDS all the values of l1 --> Looping through the list
            MergeResult.next = merge(l1.next, l2); // Updating for the new list -> l1.next --> MOVE list 1 to the right
        }else{ //otherwise
            MergeResult = l2; //HOLDS all the values of l2 --> Looping through the list
            MergeResult.next = merge(l1, l2.next); // Updating for the new list -> l2.next --> MOVE list 2 to the right
        }
        return MergeResult; // Lastly, I use MergeResult to return because the list must return from the beginning of the list (whole list)
}
    /**
     * The main method is for test only and won't be evaluated
     */
    public static void main (String[] args){
        Solution solution = new Solution();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode nextA = a;
        ListNode nextB = b;
        for (int i = 1; i < 5; ++i){
            nextA.next = new ListNode(nextA.value + 2);
            nextB.next = new ListNode(nextB.value + 2);
            nextA = nextA.next;
            nextB = nextB.next;
        }
        ListNode c = solution.merge(a, b);
        //Should print 1 to 10
        while (null != c){
            System.out.println(c.value);
            c = c.next;
        }
    }
}
