package com.instabug.bug.settings;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;

public class e {

    /* renamed from: c  reason: collision with root package name */
    private static e f45786c;

    /* renamed from: a  reason: collision with root package name */
    private Map f45787a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f45788b = true;

    private e() {
        b();
    }

    public static e a() {
        if (f45786c == null) {
            f45786c = new e();
        }
        return f45786c;
    }

    private void b() {
        HashMap hashMap = new HashMap();
        this.f45787a = hashMap;
        hashMap.put("feedback", Boolean.valueOf(this.f45788b));
        this.f45787a.put("bug", Boolean.valueOf(this.f45788b));
        this.f45787a.put("ask a question", Boolean.valueOf(this.f45788b));
    }

    public void a(String str, boolean z11) {
        this.f45787a.put(str, Boolean.valueOf(z11));
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public boolean a(String str) {
        return ((Boolean) this.f45787a.get(str)).booleanValue();
    }
}
