package com.instabug.library.tracking;

import android.app.Application;
import android.content.Context;
import com.instabug.library.Instabug;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class t extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final t f51946a = new t();

    public t() {
        super(0);
    }

    @Nullable
    /* renamed from: a */
    public final i invoke() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return CoreServiceLocator.getScreenOffEventMonitor((Application) applicationContext);
    }
}
