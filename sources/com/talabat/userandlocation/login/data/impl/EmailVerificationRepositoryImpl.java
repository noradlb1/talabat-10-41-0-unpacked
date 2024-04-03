package com.talabat.userandlocation.login.data.impl;

import com.talabat.userandlocation.login.data.model.EmailVerification;
import com.talabat.userandlocation.login.data.remote.EmailVerificationRemoteDataSource;
import com.talabat.userandlocation.login.domain.repository.EmailVerificationRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/userandlocation/login/data/impl/EmailVerificationRepositoryImpl;", "Lcom/talabat/userandlocation/login/domain/repository/EmailVerificationRepository;", "emailVerificationRemoteDataSource", "Lcom/talabat/userandlocation/login/data/remote/EmailVerificationRemoteDataSource;", "(Lcom/talabat/userandlocation/login/data/remote/EmailVerificationRemoteDataSource;)V", "verifyEmail", "Lcom/talabat/userandlocation/login/domain/entity/VerifiedEmail;", "email", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EmailVerificationRepositoryImpl implements EmailVerificationRepository {
    @NotNull
    private final EmailVerificationRemoteDataSource emailVerificationRemoteDataSource;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EmailVerification.Error.ErrorType.values().length];
            iArr[EmailVerification.Error.ErrorType.OAUTH_OAUTH_FAILED_EXCEPTION.ordinal()] = 1;
            iArr[EmailVerification.Error.ErrorType.INVALID_EMAIL.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public EmailVerificationRepositoryImpl(@NotNull EmailVerificationRemoteDataSource emailVerificationRemoteDataSource2) {
        Intrinsics.checkNotNullParameter(emailVerificationRemoteDataSource2, "emailVerificationRemoteDataSource");
        this.emailVerificationRemoteDataSource = emailVerificationRemoteDataSource2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object verifyEmail(@org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.userandlocation.login.domain.entity.VerifiedEmail> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.talabat.userandlocation.login.data.impl.EmailVerificationRepositoryImpl$verifyEmail$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.talabat.userandlocation.login.data.impl.EmailVerificationRepositoryImpl$verifyEmail$1 r0 = (com.talabat.userandlocation.login.data.impl.EmailVerificationRepositoryImpl$verifyEmail$1) r0
            int r1 = r0.f12338k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12338k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.login.data.impl.EmailVerificationRepositoryImpl$verifyEmail$1 r0 = new com.talabat.userandlocation.login.data.impl.EmailVerificationRepositoryImpl$verifyEmail$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f12336i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12338k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r11 = r0.f12335h
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x004e }
            goto L_0x0047
        L_0x002d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch:{ all -> 0x004e }
            com.talabat.userandlocation.login.data.remote.EmailVerificationRemoteDataSource r12 = r10.emailVerificationRemoteDataSource     // Catch:{ all -> 0x004e }
            r0.f12335h = r11     // Catch:{ all -> 0x004e }
            r0.f12338k = r3     // Catch:{ all -> 0x004e }
            java.lang.Object r12 = r12.verifyEmail(r11, r0)     // Catch:{ all -> 0x004e }
            if (r12 != r1) goto L_0x0047
            return r1
        L_0x0047:
            com.talabat.userandlocation.login.data.model.EmailVerification r12 = (com.talabat.userandlocation.login.data.model.EmailVerification) r12     // Catch:{ all -> 0x004e }
            java.lang.Object r12 = kotlin.Result.m6329constructorimpl(r12)     // Catch:{ all -> 0x004e }
            goto L_0x0059
        L_0x004e:
            r12 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m6329constructorimpl(r12)
        L_0x0059:
            r5 = r11
            java.lang.Throwable r11 = kotlin.Result.m6332exceptionOrNullimpl(r12)
            if (r11 != 0) goto L_0x00c0
            com.talabat.userandlocation.login.data.model.EmailVerification r12 = (com.talabat.userandlocation.login.data.model.EmailVerification) r12
            boolean r11 = r12 instanceof com.talabat.userandlocation.login.data.model.EmailVerification.Data
            if (r11 == 0) goto L_0x007f
            com.talabat.userandlocation.login.domain.entity.VerifiedEmail$Success r11 = new com.talabat.userandlocation.login.domain.entity.VerifiedEmail$Success
            com.talabat.userandlocation.login.data.model.EmailVerification$Data r12 = (com.talabat.userandlocation.login.data.model.EmailVerification.Data) r12
            boolean r6 = r12.isKnown()
            boolean r7 = r12.isB2BCustomer()
            boolean r8 = r12.getHasSocialLogin()
            boolean r9 = r12.getHasPassword()
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x00b9
        L_0x007f:
            boolean r11 = r12 instanceof com.talabat.userandlocation.login.data.model.EmailVerification.Error
            if (r11 == 0) goto L_0x00ba
            com.talabat.userandlocation.login.data.model.EmailVerification$Error r12 = (com.talabat.userandlocation.login.data.model.EmailVerification.Error) r12
            com.talabat.userandlocation.login.data.model.EmailVerification$Error$ErrorType r11 = r12.getErrorType()
            r0 = -1
            if (r11 != 0) goto L_0x008e
            r11 = r0
            goto L_0x0096
        L_0x008e:
            int[] r1 = com.talabat.userandlocation.login.data.impl.EmailVerificationRepositoryImpl.WhenMappings.$EnumSwitchMapping$0
            int r11 = r11.ordinal()
            r11 = r1[r11]
        L_0x0096:
            if (r11 == r0) goto L_0x00b0
            if (r11 == r3) goto L_0x00a6
            r12 = 2
            if (r11 != r12) goto L_0x00a0
            com.talabat.userandlocation.login.domain.entity.VerifiedEmail$InvalidEmail r11 = com.talabat.userandlocation.login.domain.entity.VerifiedEmail.InvalidEmail.INSTANCE
            goto L_0x00b9
        L_0x00a0:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L_0x00a6:
            com.talabat.userandlocation.login.domain.entity.VerifiedEmail$Error r11 = new com.talabat.userandlocation.login.domain.entity.VerifiedEmail$Error
            java.lang.String r12 = r12.getMessage()
            r11.<init>(r12)
            goto L_0x00b9
        L_0x00b0:
            com.talabat.userandlocation.login.domain.entity.VerifiedEmail$Error r11 = new com.talabat.userandlocation.login.domain.entity.VerifiedEmail$Error
            java.lang.String r12 = r12.getMessage()
            r11.<init>(r12)
        L_0x00b9:
            return r11
        L_0x00ba:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L_0x00c0:
            com.talabat.userandlocation.login.data.impl.VerifyEmailRepositoryException r12 = new com.talabat.userandlocation.login.data.impl.VerifyEmailRepositoryException
            r0 = 0
            r12.<init>(r0, r11, r3, r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.login.data.impl.EmailVerificationRepositoryImpl.verifyEmail(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
