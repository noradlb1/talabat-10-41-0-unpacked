package com.instabug.commons.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.Instabug;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class a extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f46331a = new a();

    public a() {
        super(0);
    }

    @Nullable
    /* renamed from: a */
    public final SharedPreferences invoke() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return CoreServiceLocator.getInstabugSharedPreferences(applicationContext, "instabug_crash");
    }
}
