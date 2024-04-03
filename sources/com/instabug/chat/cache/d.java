package com.instabug.chat.cache;

import android.content.Context;
import com.instabug.library.util.threading.PoolProvider;

public abstract class d {
    public static void a() {
        PoolProvider.getSingleThreadExecutor("chats-cache-executor").execute(new b());
    }

    public static void a(Context context) {
        PoolProvider.getSingleThreadExecutor("chats-cache-executor").execute(new a(context));
    }

    public static void b() {
        PoolProvider.getSingleThreadExecutor("chats-cache-executor").execute(new c());
    }
}
