package com.talabat.userandlocation.otp.domain.repo;

import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository;", "", "requestOtp", "Lio/reactivex/Single;", "Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult;", "countryCode", "", "mobileNumber", "", "RequestOtpResult", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RequestOtpRepository {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult;", "", "()V", "FailedToRequestOtp", "MaxRequestsReached", "MobileNumberValidationError", "Success", "UnknownResult", "Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult$Success;", "Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult$FailedToRequestOtp;", "Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult$MobileNumberValidationError;", "Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult$MaxRequestsReached;", "Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult$UnknownResult;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class RequestOtpResult {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult$FailedToRequestOtp;", "Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class FailedToRequestOtp extends RequestOtpResult {
            @NotNull
            private final String message;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public FailedToRequestOtp(@NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.message = str;
            }

            public static /* synthetic */ FailedToRequestOtp copy$default(FailedToRequestOtp failedToRequestOtp, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = failedToRequestOtp.message;
                }
                return failedToRequestOtp.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.message;
            }

            @NotNull
            public final FailedToRequestOtp copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "message");
                return new FailedToRequestOtp(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof FailedToRequestOtp) && Intrinsics.areEqual((Object) this.message, (Object) ((FailedToRequestOtp) obj).message);
            }

            @NotNull
            public final String getMessage() {
                return this.message;
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.message;
                return "FailedToRequestOtp(message=" + str + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult$MaxRequestsReached;", "Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class MaxRequestsReached extends RequestOtpResult {
            @NotNull
            private final String message;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MaxRequestsReached(@NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.message = str;
            }

            public static /* synthetic */ MaxRequestsReached copy$default(MaxRequestsReached maxRequestsReached, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = maxRequestsReached.message;
                }
                return maxRequestsReached.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.message;
            }

            @NotNull
            public final MaxRequestsReached copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "message");
                return new MaxRequestsReached(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof MaxRequestsReached) && Intrinsics.areEqual((Object) this.message, (Object) ((MaxRequestsReached) obj).message);
            }

            @NotNull
            public final String getMessage() {
                return this.message;
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.message;
                return "MaxRequestsReached(message=" + str + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult$MobileNumberValidationError;", "Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class MobileNumberValidationError extends RequestOtpResult {
            @NotNull
            private final String message;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MobileNumberValidationError(@NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.message = str;
            }

            public static /* synthetic */ MobileNumberValidationError copy$default(MobileNumberValidationError mobileNumberValidationError, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = mobileNumberValidationError.message;
                }
                return mobileNumberValidationError.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.message;
            }

            @NotNull
            public final MobileNumberValidationError copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "message");
                return new MobileNumberValidationError(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof MobileNumberValidationError) && Intrinsics.areEqual((Object) this.message, (Object) ((MobileNumberValidationError) obj).message);
            }

            @NotNull
            public final String getMessage() {
                return this.message;
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.message;
                return "MobileNumberValidationError(message=" + str + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult$Success;", "Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult;", "message", "", "remainingRequests", "", "(Ljava/lang/String;I)V", "getMessage", "()Ljava/lang/String;", "getRemainingRequests", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Success extends RequestOtpResult {
            @NotNull
            private final String message;
            private final int remainingRequests;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(@NotNull String str, int i11) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.message = str;
                this.remainingRequests = i11;
            }

            public static /* synthetic */ Success copy$default(Success success, String str, int i11, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    str = success.message;
                }
                if ((i12 & 2) != 0) {
                    i11 = success.remainingRequests;
                }
                return success.copy(str, i11);
            }

            @NotNull
            public final String component1() {
                return this.message;
            }

            public final int component2() {
                return this.remainingRequests;
            }

            @NotNull
            public final Success copy(@NotNull String str, int i11) {
                Intrinsics.checkNotNullParameter(str, "message");
                return new Success(str, i11);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Success)) {
                    return false;
                }
                Success success = (Success) obj;
                return Intrinsics.areEqual((Object) this.message, (Object) success.message) && this.remainingRequests == success.remainingRequests;
            }

            @NotNull
            public final String getMessage() {
                return this.message;
            }

            public final int getRemainingRequests() {
                return this.remainingRequests;
            }

            public int hashCode() {
                return (this.message.hashCode() * 31) + this.remainingRequests;
            }

            @NotNull
            public String toString() {
                String str = this.message;
                int i11 = this.remainingRequests;
                return "Success(message=" + str + ", remainingRequests=" + i11 + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult$UnknownResult;", "Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult;", "()V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class UnknownResult extends RequestOtpResult {
            @NotNull
            public static final UnknownResult INSTANCE = new UnknownResult();

            private UnknownResult() {
                super((DefaultConstructorMarker) null);
            }
        }

        private RequestOtpResult() {
        }

        public /* synthetic */ RequestOtpResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    Single<RequestOtpResult> requestOtp(int i11, @NotNull String str);
}
