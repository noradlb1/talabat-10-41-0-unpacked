package com.talabat.core.social.login.domain;

import com.talabat.core.facebook.login.domain.integration.FacebookLoginActivityIntegration;
import com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository;
import com.talabat.core.google.login.domain.repository.GoogleLoginRepository;
import com.talabat.core.social.login.domain.AaaAuthenticationForSocialLoginRepository;
import com.talabat.core.social.login.domain.SocialLoginException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J=\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\"\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ!\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJa\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2F\u0010\u001a\u001aB\b\u0001\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0#H@ø\u0001\u0000¢\u0006\u0002\u0010&J!\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/talabat/core/social/login/domain/SocialLoginUseCase;", "Lcom/talabat/core/social/login/domain/FacebookLoginUseCase;", "Lcom/talabat/core/social/login/domain/GoogleLoginUseCase;", "Lcom/talabat/core/social/login/domain/InitializeGoogleLoginUseCase;", "Lcom/talabat/core/social/login/domain/InitializeFacebookLoginUseCase;", "googleLoginRepository", "Lcom/talabat/core/google/login/domain/repository/GoogleLoginRepository;", "facebookLoginRepository", "Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository;", "aaaAuthenticationRepository", "Lcom/talabat/core/social/login/domain/AaaAuthenticationForSocialLoginRepository;", "facebookLoginActivityIntegration", "Lcom/talabat/core/facebook/login/domain/integration/FacebookLoginActivityIntegration;", "(Lcom/talabat/core/google/login/domain/repository/GoogleLoginRepository;Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository;Lcom/talabat/core/social/login/domain/AaaAuthenticationForSocialLoginRepository;Lcom/talabat/core/facebook/login/domain/integration/FacebookLoginActivityIntegration;)V", "check", "", "email", "", "token", "initFacebook", "initGoogle", "requestIdToken", "requestFacebookAuth", "Lcom/talabat/core/social/login/domain/FacebookUserData;", "activity", "Landroid/app/Activity;", "registrationBlock", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestGoogleAuth", "requestCode", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "(ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_core_social-login_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SocialLoginUseCase implements FacebookLoginUseCase, GoogleLoginUseCase, InitializeGoogleLoginUseCase, InitializeFacebookLoginUseCase {
    @NotNull
    private final AaaAuthenticationForSocialLoginRepository aaaAuthenticationRepository;
    @NotNull
    private final FacebookLoginActivityIntegration facebookLoginActivityIntegration;
    @NotNull
    private final FacebookLoginRepository facebookLoginRepository;
    @NotNull
    private final GoogleLoginRepository googleLoginRepository;

    public SocialLoginUseCase(@NotNull GoogleLoginRepository googleLoginRepository2, @NotNull FacebookLoginRepository facebookLoginRepository2, @NotNull AaaAuthenticationForSocialLoginRepository aaaAuthenticationForSocialLoginRepository, @NotNull FacebookLoginActivityIntegration facebookLoginActivityIntegration2) {
        Intrinsics.checkNotNullParameter(googleLoginRepository2, "googleLoginRepository");
        Intrinsics.checkNotNullParameter(facebookLoginRepository2, "facebookLoginRepository");
        Intrinsics.checkNotNullParameter(aaaAuthenticationForSocialLoginRepository, "aaaAuthenticationRepository");
        Intrinsics.checkNotNullParameter(facebookLoginActivityIntegration2, "facebookLoginActivityIntegration");
        this.googleLoginRepository = googleLoginRepository2;
        this.facebookLoginRepository = facebookLoginRepository2;
        this.aaaAuthenticationRepository = aaaAuthenticationForSocialLoginRepository;
        this.facebookLoginActivityIntegration = facebookLoginActivityIntegration2;
    }

    private final void check(String str, String str2) throws SocialLoginException {
        if (StringsKt__StringsJVMKt.isBlank(str)) {
            throw new SocialLoginException(SocialLoginException.Type.FAILURE_TO_FETCH_EMAIL);
        } else if (StringsKt__StringsJVMKt.isBlank(str2)) {
            throw new SocialLoginException(SocialLoginException.Type.EMPTY_SOCIAL_TOKEN);
        }
    }

    /* access modifiers changed from: private */
    public final Object requestGoogleAuth(String str, String str2, Continuation<? super Unit> continuation) throws AaaAuthenticationForSocialLoginRepository.AaaAuthenticationException {
        Object authenticateWithGoogleAuth = this.aaaAuthenticationRepository.authenticateWithGoogleAuth(str, str2, continuation);
        return authenticateWithGoogleAuth == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? authenticateWithGoogleAuth : Unit.INSTANCE;
    }

    public void initFacebook() {
        this.facebookLoginRepository.initialize();
    }

    public void initGoogle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "requestIdToken");
        this.googleLoginRepository.initialize(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x017c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object requestFacebookAuth(@org.jetbrains.annotations.NotNull android.app.Activity r19, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super com.talabat.core.social.login.domain.FacebookUserData, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.core.social.login.domain.FacebookUserData> r21) throws com.talabat.core.social.login.domain.SocialLoginException {
        /*
            r18 = this;
            r1 = r18
            r0 = r21
            boolean r2 = r0 instanceof com.talabat.core.social.login.domain.SocialLoginUseCase$requestFacebookAuth$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.talabat.core.social.login.domain.SocialLoginUseCase$requestFacebookAuth$1 r2 = (com.talabat.core.social.login.domain.SocialLoginUseCase$requestFacebookAuth$1) r2
            int r3 = r2.f55990o
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f55990o = r3
            goto L_0x001c
        L_0x0017:
            com.talabat.core.social.login.domain.SocialLoginUseCase$requestFacebookAuth$1 r2 = new com.talabat.core.social.login.domain.SocialLoginUseCase$requestFacebookAuth$1
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f55988m
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f55990o
            r5 = 3
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L_0x007a
            if (r4 == r7) goto L_0x0058
            if (r4 == r6) goto L_0x0040
            if (r4 != r5) goto L_0x0038
            java.lang.Object r2 = r2.f55983h
            com.talabat.core.social.login.domain.FacebookUserData r2 = (com.talabat.core.social.login.domain.FacebookUserData) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x017e
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0040:
            java.lang.Object r4 = r2.f55987l
            java.lang.Object r6 = r2.f55986k
            com.talabat.core.social.login.domain.FacebookUserData r6 = (com.talabat.core.social.login.domain.FacebookUserData) r6
            java.lang.Object r7 = r2.f55985j
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r2.f55984i
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.f55983h
            com.talabat.core.social.login.domain.SocialLoginUseCase r9 = (com.talabat.core.social.login.domain.SocialLoginUseCase) r9
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r6
            goto L_0x0169
        L_0x0058:
            java.lang.Object r4 = r2.f55987l
            com.talabat.core.social.login.domain.FacebookUserData r4 = (com.talabat.core.social.login.domain.FacebookUserData) r4
            java.lang.Object r7 = r2.f55986k
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r2.f55985j
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.f55984i
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.Object r10 = r2.f55983h
            com.talabat.core.social.login.domain.SocialLoginUseCase r10 = (com.talabat.core.social.login.domain.SocialLoginUseCase) r10
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0071 }
            goto L_0x0125
        L_0x0071:
            r0 = move-exception
            r17 = r9
            r9 = r0
            r0 = r10
            r10 = r17
            goto L_0x013a
        L_0x007a:
            kotlin.ResultKt.throwOnFailure(r0)
            com.talabat.core.facebook.login.domain.integration.FacebookLoginActivityIntegration r0 = r1.facebookLoginActivityIntegration
            r4 = r19
            r0.setActivity(r4)
            com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository r0 = r1.facebookLoginRepository
            com.talabat.core.facebook.login.domain.FacebookPermission[] r4 = new com.talabat.core.facebook.login.domain.FacebookPermission[r6]
            r8 = 0
            com.talabat.core.facebook.login.domain.FacebookPermission r9 = com.talabat.core.facebook.login.domain.FacebookPermission.EMAIL
            r4[r8] = r9
            com.talabat.core.facebook.login.domain.FacebookPermission r8 = com.talabat.core.facebook.login.domain.FacebookPermission.PUBLIC_PROFILE
            r4[r7] = r8
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r4)
            io.reactivex.Single r0 = r0.login(r4)
            java.lang.Object r0 = r0.blockingGet()
            com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository$LoginResult r0 = (com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository.LoginResult) r0
            com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository r4 = r1.facebookLoginRepository
            com.talabat.core.facebook.login.domain.FacebookProfileData[] r8 = com.talabat.core.facebook.login.domain.FacebookProfileData.values()
            java.util.List r8 = kotlin.collections.ArraysKt___ArraysKt.toList((T[]) r8)
            io.reactivex.Single r4 = r4.requestData(r8)
            java.lang.Object r4 = r4.blockingGet()
            com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository$DataResult r4 = (com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository.DataResult) r4
            java.util.Map r8 = r4.getData()
            com.talabat.core.facebook.login.domain.FacebookProfileData r9 = com.talabat.core.facebook.login.domain.FacebookProfileData.EMAIL
            java.lang.Object r8 = r8.get(r9)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r9 = ""
            if (r8 != 0) goto L_0x00c4
            r8 = r9
        L_0x00c4:
            java.util.Map r10 = r4.getData()
            com.talabat.core.facebook.login.domain.FacebookProfileData r11 = com.talabat.core.facebook.login.domain.FacebookProfileData.FIRST_NAME
            java.lang.Object r10 = r10.get(r11)
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L_0x00d4
            r13 = r9
            goto L_0x00d5
        L_0x00d4:
            r13 = r10
        L_0x00d5:
            java.util.Map r10 = r4.getData()
            com.talabat.core.facebook.login.domain.FacebookProfileData r11 = com.talabat.core.facebook.login.domain.FacebookProfileData.LAST_NAME
            java.lang.Object r10 = r10.get(r11)
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L_0x00e5
            r14 = r9
            goto L_0x00e6
        L_0x00e5:
            r14 = r10
        L_0x00e6:
            java.util.Map r4 = r4.getData()
            com.talabat.core.facebook.login.domain.FacebookProfileData r10 = com.talabat.core.facebook.login.domain.FacebookProfileData.ID
            java.lang.Object r4 = r4.get(r10)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x00f6
            r15 = r9
            goto L_0x00f7
        L_0x00f6:
            r15 = r4
        L_0x00f7:
            java.lang.String r4 = r0.getToken()
            java.lang.String r16 = r0.getUserId()
            r1.check(r8, r4)
            com.talabat.core.social.login.domain.FacebookUserData r9 = new com.talabat.core.social.login.domain.FacebookUserData
            r10 = r9
            r11 = r8
            r12 = r4
            r10.<init>(r11, r12, r13, r14, r15, r16)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0133 }
            r2.f55983h = r1     // Catch:{ all -> 0x0133 }
            r10 = r20
            r2.f55984i = r10     // Catch:{ all -> 0x0131 }
            r2.f55985j = r8     // Catch:{ all -> 0x0131 }
            r2.f55986k = r4     // Catch:{ all -> 0x0131 }
            r2.f55987l = r9     // Catch:{ all -> 0x0131 }
            r2.f55990o = r7     // Catch:{ all -> 0x0131 }
            java.lang.Object r0 = r1.requestFacebookAuth((java.lang.String) r8, (java.lang.String) r4, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r2)     // Catch:{ all -> 0x0131 }
            if (r0 != r3) goto L_0x0121
            return r3
        L_0x0121:
            r7 = r4
            r4 = r9
            r9 = r10
            r10 = r1
        L_0x0125:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0071 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x0071 }
            r17 = r4
            r4 = r0
            r0 = r17
            goto L_0x014b
        L_0x0131:
            r0 = move-exception
            goto L_0x0136
        L_0x0133:
            r0 = move-exception
            r10 = r20
        L_0x0136:
            r7 = r4
            r4 = r9
            r9 = r0
            r0 = r1
        L_0x013a:
            kotlin.Result$Companion r11 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)
            r17 = r10
            r10 = r0
            r0 = r4
            r4 = r9
            r9 = r17
        L_0x014b:
            java.lang.Throwable r11 = kotlin.Result.m6332exceptionOrNullimpl(r4)
            if (r11 == 0) goto L_0x0181
            boolean r12 = r11 instanceof com.talabat.core.social.login.domain.AaaAuthenticationForSocialLoginRepository.UnregisteredUserException
            if (r12 == 0) goto L_0x0180
            r2.f55983h = r10
            r2.f55984i = r8
            r2.f55985j = r7
            r2.f55986k = r0
            r2.f55987l = r4
            r2.f55990o = r6
            java.lang.Object r6 = r9.invoke(r0, r2)
            if (r6 != r3) goto L_0x0168
            return r3
        L_0x0168:
            r9 = r10
        L_0x0169:
            r2.f55983h = r0
            r2.f55984i = r4
            r4 = 0
            r2.f55985j = r4
            r2.f55986k = r4
            r2.f55987l = r4
            r2.f55990o = r5
            java.lang.Object r2 = r9.requestFacebookAuth((java.lang.String) r8, (java.lang.String) r7, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r2)
            if (r2 != r3) goto L_0x017d
            return r3
        L_0x017d:
            r2 = r0
        L_0x017e:
            r0 = r2
            goto L_0x0181
        L_0x0180:
            throw r11
        L_0x0181:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.social.login.domain.SocialLoginUseCase.requestFacebookAuth(android.app.Activity, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00dc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object requestGoogleAuth(int r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.String, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws com.talabat.core.social.login.domain.SocialLoginException {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.talabat.core.social.login.domain.SocialLoginUseCase$requestGoogleAuth$2
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.talabat.core.social.login.domain.SocialLoginUseCase$requestGoogleAuth$2 r0 = (com.talabat.core.social.login.domain.SocialLoginUseCase$requestGoogleAuth$2) r0
            int r1 = r0.f55996m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55996m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.core.social.login.domain.SocialLoginUseCase$requestGoogleAuth$2 r0 = new com.talabat.core.social.login.domain.SocialLoginUseCase$requestGoogleAuth$2
            r0.<init>(r8, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f55994k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55996m
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0059
            if (r2 == r5) goto L_0x0047
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00de
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0038:
            java.lang.Object r9 = r0.f55993j
            java.lang.Object r10 = r0.f55992i
            com.talabat.core.google.login.domain.repository.GoogleLoginRepository$GoogleLoginResult r10 = (com.talabat.core.google.login.domain.repository.GoogleLoginRepository.GoogleLoginResult) r10
            java.lang.Object r2 = r0.f55991h
            com.talabat.core.social.login.domain.SocialLoginUseCase r2 = (com.talabat.core.social.login.domain.SocialLoginUseCase) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c5
        L_0x0047:
            java.lang.Object r9 = r0.f55993j
            com.talabat.core.google.login.domain.repository.GoogleLoginRepository$GoogleLoginResult r9 = (com.talabat.core.google.login.domain.repository.GoogleLoginRepository.GoogleLoginResult) r9
            java.lang.Object r10 = r0.f55992i
            kotlin.jvm.functions.Function3 r10 = (kotlin.jvm.functions.Function3) r10
            java.lang.Object r2 = r0.f55991h
            com.talabat.core.social.login.domain.SocialLoginUseCase r2 = (com.talabat.core.social.login.domain.SocialLoginUseCase) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0057 }
            goto L_0x008d
        L_0x0057:
            r11 = move-exception
            goto L_0x0096
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r11)
            com.talabat.core.google.login.domain.repository.GoogleLoginRepository r11 = r8.googleLoginRepository
            io.reactivex.Single r9 = r11.login(r9)
            java.lang.Object r9 = r9.blockingGet()
            com.talabat.core.google.login.domain.repository.GoogleLoginRepository$GoogleLoginResult r9 = (com.talabat.core.google.login.domain.repository.GoogleLoginRepository.GoogleLoginResult) r9
            java.lang.String r11 = r9.getEmail()
            java.lang.String r2 = r9.getIdToken()
            r8.check(r11, r2)
            kotlin.Result$Companion r11 = kotlin.Result.Companion     // Catch:{ all -> 0x0094 }
            java.lang.String r11 = r9.getEmail()     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = r9.getIdToken()     // Catch:{ all -> 0x0094 }
            r0.f55991h = r8     // Catch:{ all -> 0x0094 }
            r0.f55992i = r10     // Catch:{ all -> 0x0094 }
            r0.f55993j = r9     // Catch:{ all -> 0x0094 }
            r0.f55996m = r5     // Catch:{ all -> 0x0094 }
            java.lang.Object r11 = r8.requestGoogleAuth((java.lang.String) r11, (java.lang.String) r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)     // Catch:{ all -> 0x0094 }
            if (r11 != r1) goto L_0x008c
            return r1
        L_0x008c:
            r2 = r8
        L_0x008d:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0057 }
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)     // Catch:{ all -> 0x0057 }
            goto L_0x00a0
        L_0x0094:
            r11 = move-exception
            r2 = r8
        L_0x0096:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)
        L_0x00a0:
            r7 = r11
            r11 = r9
            r9 = r7
            java.lang.Throwable r5 = kotlin.Result.m6332exceptionOrNullimpl(r9)
            if (r5 == 0) goto L_0x00de
            boolean r6 = r5 instanceof com.talabat.core.social.login.domain.AaaAuthenticationForSocialLoginRepository.UnregisteredUserException
            if (r6 == 0) goto L_0x00dd
            java.lang.String r5 = r11.getEmail()
            java.lang.String r6 = r11.getIdToken()
            r0.f55991h = r2
            r0.f55992i = r11
            r0.f55993j = r9
            r0.f55996m = r4
            java.lang.Object r10 = r10.invoke(r5, r6, r0)
            if (r10 != r1) goto L_0x00c4
            return r1
        L_0x00c4:
            r10 = r11
        L_0x00c5:
            java.lang.String r11 = r10.getEmail()
            java.lang.String r10 = r10.getIdToken()
            r0.f55991h = r9
            r9 = 0
            r0.f55992i = r9
            r0.f55993j = r9
            r0.f55996m = r3
            java.lang.Object r9 = r2.requestGoogleAuth((java.lang.String) r11, (java.lang.String) r10, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r9 != r1) goto L_0x00de
            return r1
        L_0x00dd:
            throw r5
        L_0x00de:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.social.login.domain.SocialLoginUseCase.requestGoogleAuth(int, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object requestFacebookAuth(String str, String str2, Continuation<? super Unit> continuation) throws AaaAuthenticationForSocialLoginRepository.AaaAuthenticationException {
        Object authenticateWithFacebookAuth = this.aaaAuthenticationRepository.authenticateWithFacebookAuth(str, str2, continuation);
        return authenticateWithFacebookAuth == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? authenticateWithFacebookAuth : Unit.INSTANCE;
    }
}
