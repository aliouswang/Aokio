package com.okio;

/**
 * Created by aliouswang on 17/10/9.
 */
public class Segment {

    private static final int DEFAULT_SIZE = 2048;// 2KB

    private Segment prev;
    private Segment next;

    private byte[] data;

    public Segment() {
        data = new byte[DEFAULT_SIZE];
    }

    /**
     * Removes the head of a circularly-linked list, recycles it, and returns the
     * new head of the list, Returns null if the list is empty.
     * @return
     */
    public Segment pop() {
        if (next != null) {
            if (prev != null) {
                prev.next = next;
                next.prev = prev;
            }else {
                next.prev = null;
            }
        }else {
            if (prev != null) {
                prev.next = null;
            }
        }
        Segment result = next != null ? next : null;
        next = null;
        prev = null;
        return result;
    }

    public Segment push() {

    }

}
