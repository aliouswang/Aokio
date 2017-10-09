package com.okio;

import sun.jvm.hotspot.runtime.Bytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by aliouswang on 17/10/9.
 */
public class ByteString {

    final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    public static ByteString of(byte... data) {
        return new ByteString(data.clone());
    }

    public static ByteString encodeUtf8(String s) {
        ByteString byteString = new ByteString(s.getBytes(Util.UTF_8));
        byteString.utf8 = s;
        return byteString;
    }

    public ByteString(byte[] data) {
        this.data = data;
    }

    public String urf8() {
        String result = utf8;
        if (result == null) {
            utf8 = new String(data, Util.UTF_8);
        }
        return result;
    }

    public static ByteString read(InputStream in, int count) throws IOException{
        byte[] result = new byte[count];
        Util.readFully(in, result);
        return new ByteString(result);
    }

    public int size() {
        return data.length;
    }

    public byte[] toByteArray() {
        return data.clone();
    }

    public void write(OutputStream out) throws IOException {
        out.write(data);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof ByteString && Arrays.equals(data, ((ByteString) obj).data))
                || this == obj;
    }

    @Override
    public int hashCode() {
        int result = this.hashCode;
        return result != 0 ? result : (hashCode = Arrays.hashCode(data));
    }
}
