package com.deliveryhero.customerchat.analytics.service;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/service/AnalyticsServiceResult;", "T", "", "()V", "Exception", "Failure", "Success", "Lcom/deliveryhero/customerchat/analytics/service/AnalyticsServiceResult$Success;", "Lcom/deliveryhero/customerchat/analytics/service/AnalyticsServiceResult$Failure;", "Lcom/deliveryhero/customerchat/analytics/service/AnalyticsServiceResult$Exception;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AnalyticsServiceResult<T> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/service/AnalyticsServiceResult$Exception;", "Lcom/deliveryhero/customerchat/analytics/service/AnalyticsServiceResult;", "", "e", "", "(Ljava/lang/Throwable;)V", "getE", "()Ljava/lang/Throwable;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Exception extends AnalyticsServiceResult {
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        private final Throwable f29814e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Exception(@NotNull Throwable th2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th2, "e");
            this.f29814e = th2;
        }

        @NotNull
        public final Throwable getE() {
            return this.f29814e;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/service/AnalyticsServiceResult$Failure;", "Lcom/deliveryhero/customerchat/analytics/service/AnalyticsServiceResult;", "", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Failure extends AnalyticsServiceResult {
        private final int code;
        @Nullable
        private final String message;

        public Failure(int i11, @Nullable String str) {
            super((DefaultConstructorMarker) null);
            this.code = i11;
            this.message = str;
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/service/AnalyticsServiceResult$Success;", "T", "Lcom/deliveryhero/customerchat/analytics/service/AnalyticsServiceResult;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Success<T> extends AnalyticsServiceResult<T> {
        @Nullable
        private final T data;

        public Success(@Nullable T t11) {
            super((DefaultConstructorMarker) null);
            this.data = t11;
        }

        @Nullable
        public final T getData() {
            return this.data;
        }
    }

    private AnalyticsServiceResult() {
    }

    public /* synthetic */ AnalyticsServiceResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
