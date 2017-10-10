package com.okio;

/**
 * Created by aliouswang on 17/10/10.
 */
public class SegmentPool {

    static final SegmentPool INSTANCE = new SegmentPool();

    public static final int MAX_SIZE = 64 * 1024; //64kb

    private long byteCount;
    private Segment next;

    Segment take() {
        synchronized (this) {
            if (next != null) {
                Segment newNext = next;
                next = newNext.next;
                newNext.next = null;
                byteCount -= Segment.DEFAULT_SIZE;
                return newNext;
            }
        }
        return new Segment();
    }

    void recycle(Segment segment) {
        if (segment.next != null || segment.prev != null)
            throw new IllegalStateException("Recycle segment 's next or prev is not null");
        synchronized (this) {
            if (byteCount + Segment.DEFAULT_SIZE > MAX_SIZE) return;
            segment.next = next;
            segment.pos = 0;
            segment.limit = 0;
            byteCount += Segment.DEFAULT_SIZE;
            next = segment;
        }
    }

}
