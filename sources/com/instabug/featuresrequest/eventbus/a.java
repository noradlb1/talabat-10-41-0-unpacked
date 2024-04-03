package com.instabug.featuresrequest.eventbus;

import com.instabug.library.core.eventbus.EventBus;

public class a extends EventBus {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f46518a;

    private a() {
        if (f46518a != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class");
        }
    }

    public static a a() {
        if (f46518a == null) {
            synchronized (a.class) {
                if (f46518a == null) {
                    f46518a = new a();
                }
            }
        }
        return f46518a;
    }
}
