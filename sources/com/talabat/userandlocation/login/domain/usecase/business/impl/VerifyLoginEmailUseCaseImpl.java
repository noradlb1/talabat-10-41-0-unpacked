package com.talabat.userandlocation.login.domain.usecase.business.impl;

import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.userandlocation.login.domain.entity.VerifiedEmail;
import com.talabat.userandlocation.login.domain.repository.EmailVerificationRepository;
import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginEmailUseCase;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0011\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\f\u0010\u0012\u001a\u00020\n*\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/impl/VerifyLoginEmailUseCaseImpl;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "emailVerificationRepository", "Lcom/talabat/userandlocation/login/domain/repository/EmailVerificationRepository;", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/userandlocation/login/domain/repository/EmailVerificationRepository;Lcom/talabat/authentication/token/domain/repository/TokenRepository;)V", "checkEmailExists", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase$Result;", "email", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginClient", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyLoginEmail", "toResult", "Lcom/talabat/userandlocation/login/domain/entity/VerifiedEmail$Success;", "Companion", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyLoginEmailUseCaseImpl implements VerifyLoginEmailUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    @Deprecated
    public static final Pattern EMAIL_PATTERN;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @NotNull
    private final EmailVerificationRepository emailVerificationRepository;
    @NotNull
    private final TokenRepository tokenRepository;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/impl/VerifyLoginEmailUseCaseImpl$Companion;", "", "()V", "EMAIL_PATTERN", "Ljava/util/regex/Pattern;", "getEMAIL_PATTERN", "()Ljava/util/regex/Pattern;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Pattern getEMAIL_PATTERN() {
            return VerifyLoginEmailUseCaseImpl.EMAIL_PATTERN;
        }
    }

    static {
        Pattern compile = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(\n            \"[a…           \")+\"\n        )");
        EMAIL_PATTERN = compile;
    }

    public VerifyLoginEmailUseCaseImpl(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull EmailVerificationRepository emailVerificationRepository2, @NotNull TokenRepository tokenRepository2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(emailVerificationRepository2, "emailVerificationRepository");
        Intrinsics.checkNotNullParameter(tokenRepository2, "tokenRepository");
        this.dispatcher = coroutineDispatcher;
        this.emailVerificationRepository = emailVerificationRepository2;
        this.tokenRepository = tokenRepository2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkEmailExists(java.lang.String r6, kotlin.coroutines.Continuation<? super com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginEmailUseCase.Result> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginEmailUseCaseImpl$checkEmailExists$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginEmailUseCaseImpl$checkEmailExists$1 r0 = (com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginEmailUseCaseImpl$checkEmailExists$1) r0
            int r1 = r0.f12366l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12366l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginEmailUseCaseImpl$checkEmailExists$1 r0 = new com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginEmailUseCaseImpl$checkEmailExists$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f12364j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12366l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r6 = r0.f12362h
            com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginEmailUseCaseImpl r6 = (com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginEmailUseCaseImpl) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0068
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            java.lang.Object r6 = r0.f12363i
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r0.f12362h
            com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginEmailUseCaseImpl r2 = (com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginEmailUseCaseImpl) r2
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            r6 = r2
            goto L_0x0058
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.f12362h = r5
            r0.f12363i = r6
            r0.f12366l = r4
            java.lang.Object r7 = r5.loginClient(r0)
            if (r7 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r7 = r6
            r6 = r5
        L_0x0058:
            com.talabat.userandlocation.login.domain.repository.EmailVerificationRepository r2 = r6.emailVerificationRepository
            r0.f12362h = r6
            r4 = 0
            r0.f12363i = r4
            r0.f12366l = r3
            java.lang.Object r7 = r2.verifyEmail(r7, r0)
            if (r7 != r1) goto L_0x0068
            return r1
        L_0x0068:
            com.talabat.userandlocation.login.domain.entity.VerifiedEmail r7 = (com.talabat.userandlocation.login.domain.entity.VerifiedEmail) r7
            boolean r0 = r7 instanceof com.talabat.userandlocation.login.domain.entity.VerifiedEmail.Success
            if (r0 == 0) goto L_0x0075
            com.talabat.userandlocation.login.domain.entity.VerifiedEmail$Success r7 = (com.talabat.userandlocation.login.domain.entity.VerifiedEmail.Success) r7
            com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginEmailUseCase$Result r6 = r6.toResult(r7)
            goto L_0x008f
        L_0x0075:
            boolean r6 = r7 instanceof com.talabat.userandlocation.login.domain.entity.VerifiedEmail.Error
            if (r6 == 0) goto L_0x0085
            com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginEmailUseCase$Result$UnhandledError r6 = new com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginEmailUseCase$Result$UnhandledError
            com.talabat.userandlocation.login.domain.entity.VerifiedEmail$Error r7 = (com.talabat.userandlocation.login.domain.entity.VerifiedEmail.Error) r7
            java.lang.String r7 = r7.getMessage()
            r6.<init>(r7)
            goto L_0x008f
        L_0x0085:
            com.talabat.userandlocation.login.domain.entity.VerifiedEmail$InvalidEmail r6 = com.talabat.userandlocation.login.domain.entity.VerifiedEmail.InvalidEmail.INSTANCE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0090
            com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginEmailUseCase$Result$InvalidEmail r6 = com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginEmailUseCase.Result.InvalidEmail.INSTANCE
        L_0x008f:
            return r6
        L_0x0090:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginEmailUseCaseImpl.checkEmailExists(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object loginClient(Continuation<? super Unit> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.tokenRepository.loginClient().subscribe(new VerifyLoginEmailUseCaseImpl$loginClient$2$1(safeContinuation), new VerifyLoginEmailUseCaseImpl$loginClient$2$2(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    private final VerifyLoginEmailUseCase.Result toResult(VerifiedEmail.Success success) {
        return success.isKnown() ? VerifyLoginEmailUseCase.Result.RegisteredUser.INSTANCE : VerifyLoginEmailUseCase.Result.UnregisteredUser.INSTANCE;
    }

    @Nullable
    public Object verifyLoginEmail(@NotNull String str, @NotNull Continuation<? super VerifyLoginEmailUseCase.Result> continuation) {
        return BuildersKt.withContext(this.dispatcher, new VerifyLoginEmailUseCaseImpl$verifyLoginEmail$2(str, this, (Continuation<? super VerifyLoginEmailUseCaseImpl$verifyLoginEmail$2>) null), continuation);
    }
}
