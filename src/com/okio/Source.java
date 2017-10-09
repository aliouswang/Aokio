package com.okio;

/**
 * An alternative to InputStream
 *
 * Created by aliouswang on 17/10/9.
 */
public interface Source {

    long read(OkBuffer buffer, long byteCount, Timeout timeout);

    long index(byte b, Timeout timeout);

    void close(Timeout timeout);

}
