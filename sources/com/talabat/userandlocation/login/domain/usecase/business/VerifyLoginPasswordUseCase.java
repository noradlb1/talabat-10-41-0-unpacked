package com.talabat.userandlocation.login.domain.usecase.business;

import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx2.RxSingleKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000 \b2\u00020\u0001:\u0002\b\tJ!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase;", "", "verifyLoginPassword", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result;", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Result", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VerifyLoginPasswordUseCase {
    @NotNull
    public static final Companion Companion = Companion.f12343a;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Companion;", "", "()V", "verifyLoginPasswordSingle", "Lio/reactivex/Single;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result;", "verifyLoginPasswordUseCase", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase;", "email", "", "password", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f12343a = new Companion();

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final Single<Result> verifyLoginPasswordSingle(@NotNull VerifyLoginPasswordUseCase verifyLoginPasswordUseCase, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(verifyLoginPasswordUseCase, "verifyLoginPasswordUseCase");
            Intrinsics.checkNotNullParameter(str, "email");
            Intrinsics.checkNotNullParameter(str2, "password");
            return RxSingleKt.rxSingle$default((CoroutineContext) null, new VerifyLoginPasswordUseCase$Companion$verifyLoginPasswordSingle$1(verifyLoginPasswordUseCase, str, str2, (Continuation<? super VerifyLoginPasswordUseCase$Companion$verifyLoginPasswordSingle$1>) null), 1, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result;", "", "()V", "Error", "InvalidCredentials", "PasswordIsEmpty", "PasswordLengthIsInvalid", "Success", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result$PasswordIsEmpty;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result$PasswordLengthIsInvalid;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result$Success;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result$InvalidCredentials;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result$Error;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Result {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result$Error;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Error extends Result {
            @NotNull
            private final String message;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.message = str;
            }

            public static /* synthetic */ Error copy$default(Error error, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = error.message;
                }
                return error.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.message;
            }

            @NotNull
            public final Error copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "message");
                return new Error(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && Intrinsics.areEqual((Object) this.message, (Object) ((Error) obj).message);
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
                return "Error(message=" + str + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result$InvalidCredentials;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class InvalidCredentials extends Result {
            @NotNull
            public static final InvalidCredentials INSTANCE = new InvalidCredentials();

            private InvalidCredentials() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result$PasswordIsEmpty;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class PasswordIsEmpty extends Result {
            @NotNull
            public static final PasswordIsEmpty INSTANCE = new PasswordIsEmpty();

            private PasswordIsEmpty() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result$PasswordLengthIsInvalid;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class PasswordLengthIsInvalid extends Result {
            @NotNull
            public static final PasswordLengthIsInvalid INSTANCE = new PasswordLengthIsInvalid();

            private PasswordLengthIsInvalid() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result$Success;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    Object verifyLoginPassword(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super Result> continuation);
}
