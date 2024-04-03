package com.instabug.crash.settings;

import android.content.SharedPreferences;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class d extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ f f46441g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(f fVar) {
        super(0);
        this.f46441g = fVar;
    }

    /* renamed from: a */
    public final SharedPreferences.Editor invoke() {
        return this.f46441g.b().edit();
    }
}
