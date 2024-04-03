package com.talabat.userandlocation.compliance.verification.domain.usecase.business;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\tJ)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase;", "", "updateUserProfile", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase$Result;", "firstName", "", "lastName", "dateOfBirth", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Result", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UpdateUserProfileUseCase {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase$Result;", "", "()V", "InvalidCharacterError", "Success", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase$Result$Success;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase$Result$InvalidCharacterError;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Result {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase$Result$InvalidCharacterError;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase$Result;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class InvalidCharacterError extends Result {
            @NotNull
            private final String message;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public InvalidCharacterError(@NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.message = str;
            }

            public static /* synthetic */ InvalidCharacterError copy$default(InvalidCharacterError invalidCharacterError, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = invalidCharacterError.message;
                }
                return invalidCharacterError.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.message;
            }

            @NotNull
            public final InvalidCharacterError copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "message");
                return new InvalidCharacterError(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof InvalidCharacterError) && Intrinsics.areEqual((Object) this.message, (Object) ((InvalidCharacterError) obj).message);
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
                return "InvalidCharacterError(message=" + str + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase$Result$Success;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Success extends Result {
            @NotNull
            public static final Success INSTANCE = new Success();

            private Success() {
                super((DefaultConstructorMarker) null);
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Nullable
    Object updateUserProfile(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super Result> continuation);
}
