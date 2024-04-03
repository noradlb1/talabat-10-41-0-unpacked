package com.instabug.chat.eventbus;

import com.instabug.library.core.eventbus.EventBus;

public class b extends EventBus {

    /* renamed from: a  reason: collision with root package name */
    private static b f46008a;

    public static b a() {
        if (f46008a == null) {
            f46008a = new b();
        }
        return f46008a;
    }
}
