package com.instabug.commons.threading;

import com.instabug.commons.threading.a;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public final class d extends a.b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Thread f46355a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(@NotNull Thread thread) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(thread, "thread");
        this.f46355a = thread;
    }

    @NotNull
    public JSONObject a() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(o.a(this.f46355a));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        return (JSONObject) com.instabug.commons.logging.a.a(obj, new JSONObject(), "Failed parsing crashing thread", false, 4, (Object) null);
    }
}
