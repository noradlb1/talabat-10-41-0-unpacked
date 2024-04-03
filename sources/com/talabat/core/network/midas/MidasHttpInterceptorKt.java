package com.talabat.core.network.midas;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.talabatcore.logger.LogManager;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\"\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"KEY_MIDAS", "", "KEY_RESULT", "<set-?>", "midasRequestId", "getMidasRequestId", "()Ljava/lang/String;", "readResponseAsString", "response", "Lokhttp3/Response;", "updateMidasRequestId", "", "responseText", "com_talabat_core_network_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MidasHttpInterceptorKt {
    @NotNull
    private static final String KEY_MIDAS = "midas_request_id";
    @NotNull
    private static final String KEY_RESULT = "result";
    @Nullable
    private static String midasRequestId;

    @Nullable
    public static final String getMidasRequestId() {
        return midasRequestId;
    }

    /* access modifiers changed from: private */
    public static final String readResponseAsString(Response response) {
        Object obj;
        BufferedSource bufferedSource;
        String str;
        Buffer buffer;
        Buffer clone;
        String str2 = null;
        try {
            Result.Companion companion = Result.Companion;
            ResponseBody body = response.body();
            if (body != null) {
                bufferedSource = body.source();
            } else {
                bufferedSource = null;
            }
            if (bufferedSource != null) {
                bufferedSource.request(Long.MAX_VALUE);
            }
            if (bufferedSource == null || (buffer = bufferedSource.buffer()) == null || (clone = buffer.clone()) == null) {
                str = null;
            } else {
                Charset defaultCharset = Charset.defaultCharset();
                Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
                str = clone.readString(defaultCharset);
            }
            obj = Result.m6329constructorimpl(str);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 != null) {
            LogManager.error$default(r12, (String) null, 2, (Object) null);
        }
        if (!Result.m6335isFailureimpl(obj)) {
            str2 = obj;
        }
        return str2;
    }

    /* access modifiers changed from: private */
    public static final void updateMidasRequestId(String str) {
        Object obj;
        MidasResult result;
        String midasRequestId2;
        try {
            Result.Companion companion = Result.Companion;
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "result", false, 2, (Object) null) && StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) KEY_MIDAS, false, 2, (Object) null) && (result = ((MidasResponse) GsonInstrumentation.fromJson(new Gson(), str, MidasResponse.class)).getResult()) != null && (midasRequestId2 = result.getMidasRequestId()) != null) {
                midasRequestId = midasRequestId2;
                LogManager.info("MIDAS : " + midasRequestId2);
            }
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r42 = Result.m6332exceptionOrNullimpl(obj);
        if (r42 != null) {
            LogManager.error$default(r42, (String) null, 2, (Object) null);
        }
    }
}
