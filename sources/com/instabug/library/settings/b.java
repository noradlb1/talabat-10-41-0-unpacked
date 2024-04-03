package com.instabug.library.settings;

import android.content.SharedPreferences;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class b extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ d f51880g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(d dVar) {
        super(0);
        this.f51880g = dVar;
    }

    /* renamed from: a */
    public final SharedPreferences.Editor invoke() {
        return this.f51880g.b().edit();
    }
}
