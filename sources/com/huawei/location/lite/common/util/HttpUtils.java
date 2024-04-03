package com.huawei.location.lite.common.util;

import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.location.lite.common.log.LogConsole;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class HttpUtils {
    private static final String TAG = "HttpUtils";
    private static final String UTF8_CHARSET = "UTF-8";

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j11 = 0;
        if (inputStream != null && outputStream != null) {
            String packageName = ContextHolder.getAppContext() != null ? ContextHolder.getAppContext().getPackageName() : "";
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    break;
                } else if (j11 <= 16777216 || "com.huawei.health".equals(packageName)) {
                    outputStream.write(bArr, 0, read);
                    j11 += (long) read;
                } else {
                    throw new IOException("input data too large for byte.");
                }
            }
        }
        return j11;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            copy(inputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException unused) {
            LogConsole.d(TAG, "toByteArray error");
            return new byte[0];
        }
    }

    public static String urlDecode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }
}
