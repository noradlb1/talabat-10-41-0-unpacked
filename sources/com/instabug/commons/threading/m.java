package com.instabug.commons.threading;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

final class m extends Lambda implements Function2 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Thread f46362g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f46363h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(Thread thread, int i11) {
        super(2);
        this.f46362g = thread;
        this.f46363h = i11;
    }

    @NotNull
    public final JSONObject a(int i11, @NotNull Thread thread) {
        boolean z11;
        Intrinsics.checkNotNullParameter(thread, "thread");
        Thread thread2 = this.f46362g;
        int i12 = this.f46363h;
        if (i11 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        return o.a(thread, thread2, i12, z11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a(((Number) obj).intValue(), (Thread) obj2);
    }
}
