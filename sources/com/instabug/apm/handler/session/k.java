package com.instabug.apm.handler.session;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.di.a;
import com.instabug.library.model.common.Session;

public abstract class k {
    public static void a(@NonNull a aVar) {
        a.Z().a(aVar);
    }

    public static void b(@NonNull Session session, @Nullable Session session2) {
        for (a onNewSessionStarted : a.Z().a()) {
            onNewSessionStarted.onNewSessionStarted(session, session2);
        }
    }
}
