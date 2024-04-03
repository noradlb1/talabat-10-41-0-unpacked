package com.talabat.userandlocation.login.domain.usecase.business;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase;", "", "verifyLoginEmail", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result;", "email", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Result", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VerifyLoginEmailUseCase {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result;", "", "()V", "EmptyEmail", "InvalidEmail", "InvalidEmailFormat", "RegisteredUser", "UnhandledError", "UnregisteredUser", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result$EmptyEmail;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result$InvalidEmailFormat;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result$RegisteredUser;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result$UnregisteredUser;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result$InvalidEmail;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result$UnhandledError;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Result {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result$EmptyEmail;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class EmptyEmail extends Result {
            @NotNull
            public static final EmptyEmail INSTANCE = new EmptyEmail();

            private EmptyEmail() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result$InvalidEmail;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class InvalidEmail extends Result {
            @NotNull
            public static final InvalidEmail INSTANCE = new InvalidEmail();

            private InvalidEmail() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result$InvalidEmailFormat;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class InvalidEmailFormat extends Result {
            @NotNull
            public static final InvalidEmailFormat INSTANCE = new InvalidEmailFormat();

            private InvalidEmailFormat() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result$RegisteredUser;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class RegisteredUser extends Result {
            @NotNull
            public static final RegisteredUser INSTANCE = new RegisteredUser();

            private RegisteredUser() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result$UnhandledError;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class UnhandledError extends Result {
            @NotNull
            private final String message;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UnhandledError(@NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.message = str;
            }

            public static /* synthetic */ UnhandledError copy$default(UnhandledError unhandledError, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = unhandledError.message;
                }
                return unhandledError.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.message;
            }

            @NotNull
            public final UnhandledError copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "message");
                return new UnhandledError(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof UnhandledError) && Intrinsics.areEqual((Object) this.message, (Object) ((UnhandledError) obj).message);
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
                return "UnhandledError(message=" + str + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result$UnregisteredUser;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class UnregisteredUser extends Result {
            @NotNull
            public static final UnregisteredUser INSTANCE = new UnregisteredUser();

            private UnregisteredUser() {
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
    Object verifyLoginEmail(@NotNull String str, @NotNull Continuation<? super Result> continuation);
}
