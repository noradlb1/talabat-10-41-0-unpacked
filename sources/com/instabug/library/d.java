package com.instabug.library;

import android.util.Log;
import androidx.annotation.Nullable;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.internal.utils.c;
import com.instabug.library.util.StringUtility;
import java.util.HashMap;
import java.util.Map;

class d {

    /* renamed from: a  reason: collision with root package name */
    private final Map f50550a = new HashMap();

    @Nullable
    public String a(InstabugCustomTextPlaceHolder.Key key) {
        return (String) this.f50550a.get(key);
    }

    public void b(Map map) {
        this.f50550a.clear();
        this.f50550a.putAll(map);
    }

    public void c(InstabugCustomTextPlaceHolder.Key key, String str) {
        c.a(key);
        this.f50550a.put(key, a(key, str));
    }

    private String a(InstabugCustomTextPlaceHolder.Key key, String str) {
        if (key.a() <= -1 || str.length() <= key.a()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("The max ");
        sb2.append(key.a() == 35 ? "title" : "description");
        sb2.append(" length is ");
        sb2.append(key.a());
        sb2.append(". Any extra characters will be trimmed.");
        Log.w("INSTABUG", sb2.toString());
        return StringUtility.ellipsize(str, key.a());
    }
}
