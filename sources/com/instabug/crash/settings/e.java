package com.instabug.crash.settings;

import android.content.SharedPreferences;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class e extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ f f46442g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(f fVar) {
        super(0);
        this.f46442g = fVar;
    }

    /* renamed from: a */
    public final SharedPreferences invoke() {
        return this.f46442g.f46443a.getSharedPreferences("instabug_crash_minimal", 0);
    }
}
