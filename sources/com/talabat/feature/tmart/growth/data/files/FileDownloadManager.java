package com.talabat.feature.tmart.growth.data.files;

import androidx.core.app.NotificationCompat;
import com.deliveryhero.customerchat.eventTracking.constants.ContactDetailsKeys;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00020\u0006*\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\f\u0010\r\u001a\u00020\u000e*\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/files/FileDownloadManager;", "", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "download", "Lokhttp3/ResponseBody;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "await", "Lokhttp3/Call;", "(Lokhttp3/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildRequest", "Lokhttp3/Request;", "Companion", "ContinuationCallback", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FileDownloadManager {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String NULL_ERROR_MESSAGE = "Response body cannot be null";
    @NotNull
    private final OkHttpClient client;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/files/FileDownloadManager$Companion;", "", "()V", "NULL_ERROR_MESSAGE", "", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012#\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\bB\u001b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/files/FileDownloadManager$ContinuationCallback;", "Lokhttp3/Callback;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "call", "Lokhttp3/Call;", "continuation", "Lkotlin/coroutines/Continuation;", "Lokhttp3/ResponseBody;", "(Lokhttp3/Call;Lkotlin/coroutines/Continuation;)V", "invoke", "onFailure", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ContinuationCallback implements Callback, Function1<Throwable, Unit> {
        @NotNull
        private final Call call;
        @NotNull
        private final Continuation<ResponseBody> continuation;

        public ContinuationCallback(@NotNull Call call2, @NotNull Continuation<? super ResponseBody> continuation2) {
            Intrinsics.checkNotNullParameter(call2, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(continuation2, "continuation");
            this.call = call2;
            this.continuation = continuation2;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.INSTANCE;
        }

        public void onFailure(@NotNull Call call2, @NotNull IOException iOException) {
            Intrinsics.checkNotNullParameter(call2, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(iOException, "e");
            Continuation<ResponseBody> continuation2 = this.continuation;
            Result.Companion companion = Result.Companion;
            continuation2.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(iOException)));
        }

        public void onResponse(@NotNull Call call2, @NotNull Response response) {
            Unit unit;
            Intrinsics.checkNotNullParameter(call2, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(response, "response");
            ResponseBody body = response.body();
            if (body != null) {
                this.continuation.resumeWith(Result.m6329constructorimpl(body));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                Continuation<ResponseBody> continuation2 = this.continuation;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(new IllegalArgumentException(FileDownloadManager.NULL_ERROR_MESSAGE))));
            }
        }

        public void invoke(@Nullable Throwable th2) {
            Call call2 = this.call;
            try {
                Result.Companion companion = Result.Companion;
                call2.cancel();
                Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.Companion;
                Result.m6329constructorimpl(ResultKt.createFailure(th3));
            }
        }
    }

    @Inject
    public FileDownloadManager(@NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, ContactDetailsKeys.SENT_FROM_VALUE);
        this.client = okHttpClient;
    }

    /* access modifiers changed from: private */
    public final Object await(Call call, Continuation<? super ResponseBody> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        ContinuationCallback continuationCallback = new ContinuationCallback(call, cancellableContinuationImpl);
        FirebasePerfOkHttpClient.enqueue(call, continuationCallback);
        cancellableContinuationImpl.invokeOnCancellation(continuationCallback);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final Request buildRequest(String str) {
        Request.Builder url = new Request.Builder().url(str);
        return !(url instanceof Request.Builder) ? url.build() : OkHttp3Instrumentation.build(url);
    }

    @Nullable
    public final Object download(@NotNull String str, @NotNull Continuation<? super ResponseBody> continuation) {
        Call call;
        OkHttpClient okHttpClient = this.client;
        Request buildRequest = buildRequest(str);
        if (!(okHttpClient instanceof OkHttpClient)) {
            call = okHttpClient.newCall(buildRequest);
        } else {
            call = OkHttp3Instrumentation.newCall(okHttpClient, buildRequest);
        }
        return await(call, continuation);
    }
}
