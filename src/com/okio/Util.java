package com.okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by aliouswang on 17/10/9.
 */
public class Util {

    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static final void readFully(InputStream inputStream, byte[] data) {
        if (inputStream == null || data == null) {
            throw new NullPointerException("inputStream or data is null!");
        }
        try {
            inputStream.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
