package com.instabug.bug.utils;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.nio.charset.Charset;

public abstract class f {
    public static String a(@NonNull String str) {
        return new String(Base64.decode(str, 2), Charset.forName("UTF-8"));
    }

    public static String b(@NonNull String str) {
        return Base64.encodeToString(str.getBytes(Charset.forName("UTF-8")), 2);
    }
}
