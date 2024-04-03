package com.instabug.commons.threading;

import android.os.Looper;
import com.instabug.commons.threading.a;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public final class e extends a.b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final e f46356a = new e();

    private e() {
        super((DefaultConstructorMarker) null);
    }

    @NotNull
    public JSONObject a() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Thread thread = Looper.getMainLooper().getThread();
            Intrinsics.checkNotNullExpressionValue(thread, "getMainLooper().thread");
            obj = Result.m6329constructorimpl(o.a(thread));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        return (JSONObject) com.instabug.commons.logging.a.a(obj, new JSONObject(), "Failed parsing main thread data", false, 4, (Object) null);
    }
}
