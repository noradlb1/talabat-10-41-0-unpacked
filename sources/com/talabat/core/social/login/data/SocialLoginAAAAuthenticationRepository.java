package com.talabat.core.social.login.data;

import com.talabat.authentication.authenticate.domain.model.PasswordAuthentication;
import com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository;
import com.talabat.core.social.login.domain.AaaAuthenticationForSocialLoginRepository;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\f\u0010\f\u001a\u00020\u0006*\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/core/social/login/data/SocialLoginAAAAuthenticationRepository;", "Lcom/talabat/core/social/login/domain/AaaAuthenticationForSocialLoginRepository;", "authenticationRepository", "Lcom/talabat/authentication/authenticate/domain/repository/SocialAuthenticationRepository;", "(Lcom/talabat/authentication/authenticate/domain/repository/SocialAuthenticationRepository;)V", "authenticateWithFacebookAuth", "", "email", "", "socialToken", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticateWithGoogleAuth", "throwError", "Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication$Error;", "com_talabat_core_social-login_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SocialLoginAAAAuthenticationRepository implements AaaAuthenticationForSocialLoginRepository {
    @NotNull
    private final SocialAuthenticationRepository authenticationRepository;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PasswordAuthentication.Error.Type.values().length];
            iArr[PasswordAuthentication.Error.Type.INVALID_CREDENTIALS.ordinal()] = 1;
            iArr[PasswordAuthentication.Error.Type.SOCIAL_LOGIN_USER_NOT_FOUND.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SocialLoginAAAAuthenticationRepository(@NotNull SocialAuthenticationRepository socialAuthenticationRepository) {
        Intrinsics.checkNotNullParameter(socialAuthenticationRepository, "authenticationRepository");
        this.authenticationRepository = socialAuthenticationRepository;
    }

    private final void throwError(PasswordAuthentication.Error error) {
        int i11;
        PasswordAuthentication.Error.Type type = error.getType();
        if (type == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        if (i11 == -1) {
            throw new Exception();
        } else if (i11 == 1) {
            throw new AaaAuthenticationForSocialLoginRepository.InvalidCredentialsException();
        } else if (i11 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            throw new AaaAuthenticationForSocialLoginRepository.UnregisteredUserException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object authenticateWithFacebookAuth(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository$authenticateWithFacebookAuth$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository$authenticateWithFacebookAuth$1 r0 = (com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository$authenticateWithFacebookAuth$1) r0
            int r1 = r0.f55974k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55974k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository$authenticateWithFacebookAuth$1 r0 = new com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository$authenticateWithFacebookAuth$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f55972i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55974k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f55971h
            com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository r5 = (com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0048
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository r7 = r4.authenticationRepository
            com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository$Platform r2 = com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository.Platform.FACEBOOK
            r0.f55971h = r4
            r0.f55974k = r3
            java.lang.Object r7 = r7.authenticateWithSocialLogin(r5, r2, r6, r0)
            if (r7 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r5 = r4
        L_0x0048:
            boolean r6 = r7 instanceof com.talabat.authentication.authenticate.domain.model.PasswordAuthentication.Error
            if (r6 == 0) goto L_0x004f
            com.talabat.authentication.authenticate.domain.model.PasswordAuthentication$Error r7 = (com.talabat.authentication.authenticate.domain.model.PasswordAuthentication.Error) r7
            goto L_0x0050
        L_0x004f:
            r7 = 0
        L_0x0050:
            if (r7 == 0) goto L_0x0055
            r5.throwError(r7)
        L_0x0055:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository.authenticateWithFacebookAuth(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object authenticateWithGoogleAuth(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository$authenticateWithGoogleAuth$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository$authenticateWithGoogleAuth$1 r0 = (com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository$authenticateWithGoogleAuth$1) r0
            int r1 = r0.f55978k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55978k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository$authenticateWithGoogleAuth$1 r0 = new com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository$authenticateWithGoogleAuth$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f55976i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55978k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f55975h
            com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository r5 = (com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0048
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository r7 = r4.authenticationRepository
            com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository$Platform r2 = com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository.Platform.GOOGLE
            r0.f55975h = r4
            r0.f55978k = r3
            java.lang.Object r7 = r7.authenticateWithSocialLogin(r5, r2, r6, r0)
            if (r7 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r5 = r4
        L_0x0048:
            boolean r6 = r7 instanceof com.talabat.authentication.authenticate.domain.model.PasswordAuthentication.Error
            if (r6 == 0) goto L_0x004f
            com.talabat.authentication.authenticate.domain.model.PasswordAuthentication$Error r7 = (com.talabat.authentication.authenticate.domain.model.PasswordAuthentication.Error) r7
            goto L_0x0050
        L_0x004f:
            r7 = 0
        L_0x0050:
            if (r7 == 0) goto L_0x0055
            r5.throwError(r7)
        L_0x0055:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository.authenticateWithGoogleAuth(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
