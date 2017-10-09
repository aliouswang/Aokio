package com.okio;

/**
 * Created by aliouswang on 17/10/9.
 */
public interface Sink {

    void write(OkBuffer buffer, long byteCount, Timeout timeout);

    void close(Timeout timeout);

    void flush(Timeout timeout);

}
