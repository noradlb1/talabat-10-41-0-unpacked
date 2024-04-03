package com.instabug.library.session;

import android.content.Context;
import com.instabug.library.Instabug;
import com.instabug.library.internal.utils.PreferencesUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class d extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final d f51744a = new d();

    public d() {
        super(0);
    }

    @Nullable
    /* renamed from: a */
    public final PreferencesUtils invoke() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return l.a(applicationContext);
    }
}
