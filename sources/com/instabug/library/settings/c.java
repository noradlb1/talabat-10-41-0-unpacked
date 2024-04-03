package com.instabug.library.settings;

import android.content.SharedPreferences;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class c extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ d f51881g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar) {
        super(0);
        this.f51881g = dVar;
    }

    /* renamed from: a */
    public final SharedPreferences invoke() {
        return this.f51881g.f51882a.getSharedPreferences("instabug_minimal", 0);
    }
}
