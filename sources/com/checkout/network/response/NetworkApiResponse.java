package com.checkout.network.response;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0004\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/checkout/network/response/NetworkApiResponse;", "S", "", "()V", "InternalError", "NetworkError", "ServerError", "Success", "Lcom/checkout/network/response/NetworkApiResponse$InternalError;", "Lcom/checkout/network/response/NetworkApiResponse$NetworkError;", "Lcom/checkout/network/response/NetworkApiResponse$ServerError;", "Lcom/checkout/network/response/NetworkApiResponse$Success;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class NetworkApiResponse<S> {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/checkout/network/response/NetworkApiResponse$InternalError;", "Lcom/checkout/network/response/NetworkApiResponse;", "", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InternalError extends NetworkApiResponse {
        @NotNull
        private final Throwable throwable;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InternalError(@NotNull Throwable th2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th2, "throwable");
            this.throwable = th2;
        }

        public static /* synthetic */ InternalError copy$default(InternalError internalError, Throwable th2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                th2 = internalError.throwable;
            }
            return internalError.copy(th2);
        }

        @NotNull
        public final Throwable component1() {
            return this.throwable;
        }

        @NotNull
        public final InternalError copy(@NotNull Throwable th2) {
            Intrinsics.checkNotNullParameter(th2, "throwable");
            return new InternalError(th2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InternalError) && Intrinsics.areEqual((Object) this.throwable, (Object) ((InternalError) obj).throwable);
        }

        @NotNull
        public final Throwable getThrowable() {
            return this.throwable;
        }

        public int hashCode() {
            return this.throwable.hashCode();
        }

        @NotNull
        public String toString() {
            Throwable th2 = this.throwable;
            return "InternalError(throwable=" + th2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/checkout/network/response/NetworkApiResponse$NetworkError;", "Lcom/checkout/network/response/NetworkApiResponse;", "", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class NetworkError extends NetworkApiResponse {
        @NotNull
        private final Throwable throwable;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NetworkError(@NotNull Throwable th2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th2, "throwable");
            this.throwable = th2;
        }

        public static /* synthetic */ NetworkError copy$default(NetworkError networkError, Throwable th2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                th2 = networkError.throwable;
            }
            return networkError.copy(th2);
        }

        @NotNull
        public final Throwable component1() {
            return this.throwable;
        }

        @NotNull
        public final NetworkError copy(@NotNull Throwable th2) {
            Intrinsics.checkNotNullParameter(th2, "throwable");
            return new NetworkError(th2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NetworkError) && Intrinsics.areEqual((Object) this.throwable, (Object) ((NetworkError) obj).throwable);
        }

        @NotNull
        public final Throwable getThrowable() {
            return this.throwable;
        }

        public int hashCode() {
            return this.throwable.hashCode();
        }

        @NotNull
        public String toString() {
            Throwable th2 = this.throwable;
            return "NetworkError(throwable=" + th2 + ")";
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/checkout/network/response/NetworkApiResponse$ServerError;", "Lcom/checkout/network/response/NetworkApiResponse;", "", "body", "Lcom/checkout/network/response/ErrorResponse;", "code", "", "(Lcom/checkout/network/response/ErrorResponse;I)V", "getBody", "()Lcom/checkout/network/response/ErrorResponse;", "getCode", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ServerError extends NetworkApiResponse {
        @Nullable
        private final ErrorResponse body;
        private final int code;

        public ServerError(@Nullable ErrorResponse errorResponse, int i11) {
            super((DefaultConstructorMarker) null);
            this.body = errorResponse;
            this.code = i11;
        }

        public static /* synthetic */ ServerError copy$default(ServerError serverError, ErrorResponse errorResponse, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                errorResponse = serverError.body;
            }
            if ((i12 & 2) != 0) {
                i11 = serverError.code;
            }
            return serverError.copy(errorResponse, i11);
        }

        @Nullable
        public final ErrorResponse component1() {
            return this.body;
        }

        public final int component2() {
            return this.code;
        }

        @NotNull
        public final ServerError copy(@Nullable ErrorResponse errorResponse, int i11) {
            return new ServerError(errorResponse, i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ServerError)) {
                return false;
            }
            ServerError serverError = (ServerError) obj;
            return Intrinsics.areEqual((Object) this.body, (Object) serverError.body) && this.code == serverError.code;
        }

        @Nullable
        public final ErrorResponse getBody() {
            return this.body;
        }

        public final int getCode() {
            return this.code;
        }

        public int hashCode() {
            ErrorResponse errorResponse = this.body;
            return ((errorResponse == null ? 0 : errorResponse.hashCode()) * 31) + this.code;
        }

        @NotNull
        public String toString() {
            ErrorResponse errorResponse = this.body;
            int i11 = this.code;
            return "ServerError(body=" + errorResponse + ", code=" + i11 + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/checkout/network/response/NetworkApiResponse$Success;", "T", "Lcom/checkout/network/response/NetworkApiResponse;", "body", "(Ljava/lang/Object;)V", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/checkout/network/response/NetworkApiResponse$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Success<T> extends NetworkApiResponse<T> {
        private final T body;

        public Success(T t11) {
            super((DefaultConstructorMarker) null);
            this.body = t11;
        }

        public static /* synthetic */ Success copy$default(Success success, T t11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                t11 = success.body;
            }
            return success.copy(t11);
        }

        public final T component1() {
            return this.body;
        }

        @NotNull
        public final Success<T> copy(T t11) {
            return new Success<>(t11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.body, (Object) ((Success) obj).body);
        }

        public final T getBody() {
            return this.body;
        }

        public int hashCode() {
            T t11 = this.body;
            if (t11 == null) {
                return 0;
            }
            return t11.hashCode();
        }

        @NotNull
        public String toString() {
            T t11 = this.body;
            return "Success(body=" + t11 + ")";
        }
    }

    private NetworkApiResponse() {
    }

    public /* synthetic */ NetworkApiResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
