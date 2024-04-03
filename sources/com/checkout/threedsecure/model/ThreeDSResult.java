package com.checkout.threedsecure.model;

import com.checkout.threedsecure.error.ThreeDSError;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/checkout/threedsecure/model/ThreeDSResult;", "", "()V", "Error", "Failure", "Success", "Lcom/checkout/threedsecure/model/ThreeDSResult$Error;", "Lcom/checkout/threedsecure/model/ThreeDSResult$Failure;", "Lcom/checkout/threedsecure/model/ThreeDSResult$Success;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ThreeDSResult {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/checkout/threedsecure/model/ThreeDSResult$Error;", "Lcom/checkout/threedsecure/model/ThreeDSResult;", "error", "Lcom/checkout/threedsecure/error/ThreeDSError;", "(Lcom/checkout/threedsecure/error/ThreeDSError;)V", "getError", "()Lcom/checkout/threedsecure/error/ThreeDSError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error extends ThreeDSResult {
        @NotNull
        private final ThreeDSError error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull ThreeDSError threeDSError) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(threeDSError, "error");
            this.error = threeDSError;
        }

        public static /* synthetic */ Error copy$default(Error error2, ThreeDSError threeDSError, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                threeDSError = error2.error;
            }
            return error2.copy(threeDSError);
        }

        @NotNull
        public final ThreeDSError component1() {
            return this.error;
        }

        @NotNull
        public final Error copy(@NotNull ThreeDSError threeDSError) {
            Intrinsics.checkNotNullParameter(threeDSError, "error");
            return new Error(threeDSError);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual((Object) this.error, (Object) ((Error) obj).error);
        }

        @NotNull
        public final ThreeDSError getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        @NotNull
        public String toString() {
            ThreeDSError threeDSError = this.error;
            return "Error(error=" + threeDSError + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/checkout/threedsecure/model/ThreeDSResult$Failure;", "Lcom/checkout/threedsecure/model/ThreeDSResult;", "()V", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Failure extends ThreeDSResult {
        @NotNull
        public static final Failure INSTANCE = new Failure();

        private Failure() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/checkout/threedsecure/model/ThreeDSResult$Success;", "Lcom/checkout/threedsecure/model/ThreeDSResult;", "token", "", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Success extends ThreeDSResult {
        @NotNull
        private final String token;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
            this.token = str;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = success.token;
            }
            return success.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.token;
        }

        @NotNull
        public final Success copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
            return new Success(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.token, (Object) ((Success) obj).token);
        }

        @NotNull
        public final String getToken() {
            return this.token;
        }

        public int hashCode() {
            return this.token.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.token;
            return "Success(token=" + str + ")";
        }
    }

    private ThreeDSResult() {
    }

    public /* synthetic */ ThreeDSResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
