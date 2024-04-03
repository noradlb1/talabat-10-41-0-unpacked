package com.instabug.bug;

import androidx.annotation.Nullable;
import com.instabug.library.core.eventbus.EventBus;

public class v extends EventBus {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static v f45792a;

    public static v a() {
        if (f45792a == null) {
            f45792a = new v();
        }
        return f45792a;
    }

    public static void b() {
        f45792a = null;
    }
}
