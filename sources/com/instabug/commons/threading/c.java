package com.instabug.commons.threading;

import android.os.Looper;
import com.instabug.commons.threading.a;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class c extends a.C0054a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f46353a;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final String f46354b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }

    public c(@Nullable String str, @Nullable String str2) {
        super((DefaultConstructorMarker) null);
        this.f46353a = str;
        this.f46354b = str2;
    }

    @NotNull
    public JSONObject a() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = new JSONObject();
            Thread thread = Looper.getMainLooper().getThread();
            Intrinsics.checkNotNullExpressionValue(thread, "getMainLooper().thread");
            String str = this.f46353a;
            if (str != null) {
                jSONObject.put("name", (Object) str);
            }
            String str2 = this.f46354b;
            if (str2 != null) {
                jSONObject.put("exception", (Object) str2);
            }
            StackTraceElement[] stackTrace = thread.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "mainThread.stackTrace");
            StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt___ArraysKt.getOrNull((T[]) stackTrace, 0);
            if (stackTraceElement != null) {
                String fileName = stackTraceElement.getFileName();
                if (fileName != null) {
                    String str3 = fileName + AbstractJsonLexerKt.COLON + stackTraceElement.getLineNumber();
                    if (str3 != null) {
                        jSONObject.put("location", (Object) str3);
                    }
                }
            }
            jSONObject.put("stackTrace", (Object) o.a(thread, -1, false, new b(this), 2, (Object) null));
            obj = Result.m6329constructorimpl(jSONObject);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        return (JSONObject) com.instabug.commons.logging.a.a(obj, new JSONObject(), "Failed parsing main thread error", false, 4, (Object) null);
    }
}
