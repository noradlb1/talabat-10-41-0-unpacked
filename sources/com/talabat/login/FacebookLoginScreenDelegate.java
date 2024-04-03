package com.talabat.login;

import android.app.Application;
import android.view.View;
import androidx.activity.ComponentActivity;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.social.login.domain.FacebookLoginUseCase;
import com.talabat.core.social.login.domain.InitializeFacebookLoginUseCase;
import com.talabat.helpers.TalabatApplication;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import library.talabat.mvp.login.ILoginInteractor;
import library.talabat.mvp.login.ILoginPresenter;
import org.jetbrains.annotations.NotNull;
import qs.a;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ)\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ4\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110 J\u0006\u0010!\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/talabat/login/FacebookLoginScreenDelegate;", "", "initializeFacebookLoginUseCase", "Lcom/talabat/core/social/login/domain/InitializeFacebookLoginUseCase;", "facebookLoginUseCase", "Lcom/talabat/core/social/login/domain/FacebookLoginUseCase;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "facebookSuccessfulLoginHandler", "Lcom/talabat/login/FacebookSuccessfulLoginHandler;", "facebookLoginErrorHandler", "Lcom/talabat/login/FacebookLoginErrorHandler;", "(Lcom/talabat/core/social/login/domain/InitializeFacebookLoginUseCase;Lcom/talabat/core/social/login/domain/FacebookLoginUseCase;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;Lcom/talabat/login/FacebookSuccessfulLoginHandler;Lcom/talabat/login/FacebookLoginErrorHandler;)V", "facebookLoginErrorView", "Ljava/lang/ref/WeakReference;", "Lcom/talabat/login/FacebookLoginErrorView;", "attachErrorView", "", "errorView", "doFacebookLogin", "activity", "Landroidx/activity/ComponentActivity;", "loginPresenter", "Llibrary/talabat/mvp/login/ILoginPresenter;", "loginInteractor", "Llibrary/talabat/mvp/login/ILoginInteractor;", "(Landroidx/activity/ComponentActivity;Llibrary/talabat/mvp/login/ILoginPresenter;Llibrary/talabat/mvp/login/ILoginInteractor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSetUpFacebookLoginButtons", "Landroid/view/View$OnClickListener;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "showLoading", "Lkotlin/Function0;", "sdkInitialize", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FacebookLoginScreenDelegate {
    @NotNull
    private final CoroutineDispatchersFactory coroutineDispatchersFactory;
    @NotNull
    private final FacebookLoginErrorHandler facebookLoginErrorHandler;
    @NotNull
    private WeakReference<FacebookLoginErrorView> facebookLoginErrorView = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    @NotNull
    public final FacebookLoginUseCase facebookLoginUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final FacebookSuccessfulLoginHandler facebookSuccessfulLoginHandler;
    @NotNull
    private final InitializeFacebookLoginUseCase initializeFacebookLoginUseCase;

    @Inject
    public FacebookLoginScreenDelegate(@NotNull InitializeFacebookLoginUseCase initializeFacebookLoginUseCase2, @NotNull FacebookLoginUseCase facebookLoginUseCase2, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2, @NotNull FacebookSuccessfulLoginHandler facebookSuccessfulLoginHandler2, @NotNull FacebookLoginErrorHandler facebookLoginErrorHandler2) {
        Intrinsics.checkNotNullParameter(initializeFacebookLoginUseCase2, "initializeFacebookLoginUseCase");
        Intrinsics.checkNotNullParameter(facebookLoginUseCase2, "facebookLoginUseCase");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "coroutineDispatchersFactory");
        Intrinsics.checkNotNullParameter(facebookSuccessfulLoginHandler2, "facebookSuccessfulLoginHandler");
        Intrinsics.checkNotNullParameter(facebookLoginErrorHandler2, "facebookLoginErrorHandler");
        this.initializeFacebookLoginUseCase = initializeFacebookLoginUseCase2;
        this.facebookLoginUseCase = facebookLoginUseCase2;
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
        this.facebookSuccessfulLoginHandler = facebookSuccessfulLoginHandler2;
        this.facebookLoginErrorHandler = facebookLoginErrorHandler2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: library.talabat.mvp.login.ILoginInteractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: library.talabat.mvp.login.ILoginPresenter} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object doFacebookLogin(androidx.activity.ComponentActivity r11, library.talabat.mvp.login.ILoginPresenter r12, library.talabat.mvp.login.ILoginInteractor r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.talabat.login.FacebookLoginScreenDelegate$doFacebookLogin$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.talabat.login.FacebookLoginScreenDelegate$doFacebookLogin$1 r0 = (com.talabat.login.FacebookLoginScreenDelegate$doFacebookLogin$1) r0
            int r1 = r0.f61044m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61044m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.login.FacebookLoginScreenDelegate$doFacebookLogin$1 r0 = new com.talabat.login.FacebookLoginScreenDelegate$doFacebookLogin$1
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f61042k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61044m
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r11 = r0.f61041j
            r13 = r11
            library.talabat.mvp.login.ILoginInteractor r13 = (library.talabat.mvp.login.ILoginInteractor) r13
            java.lang.Object r11 = r0.f61040i
            r12 = r11
            library.talabat.mvp.login.ILoginPresenter r12 = (library.talabat.mvp.login.ILoginPresenter) r12
            java.lang.Object r11 = r0.f61039h
            com.talabat.login.FacebookLoginScreenDelegate r11 = (com.talabat.login.FacebookLoginScreenDelegate) r11
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0063
        L_0x0037:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r14)
            com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory r14 = r10.coroutineDispatchersFactory
            kotlinx.coroutines.CoroutineDispatcher r14 = r14.io()
            com.talabat.login.FacebookLoginScreenDelegate$doFacebookLogin$2 r2 = new com.talabat.login.FacebookLoginScreenDelegate$doFacebookLogin$2
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r11
            r7 = r12
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f61039h = r10
            r0.f61040i = r12
            r0.f61041j = r13
            r0.f61044m = r3
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r14, r2, r0)
            if (r14 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r11 = r10
        L_0x0063:
            kotlin.Result r14 = (kotlin.Result) r14
            java.lang.Object r14 = r14.m6338unboximpl()
            boolean r0 = kotlin.Result.m6336isSuccessimpl(r14)
            if (r0 == 0) goto L_0x0077
            r0 = r14
            com.talabat.core.social.login.domain.FacebookUserData r0 = (com.talabat.core.social.login.domain.FacebookUserData) r0
            com.talabat.login.FacebookSuccessfulLoginHandler r1 = r11.facebookSuccessfulLoginHandler
            r1.onSuccessFulFBLogin(r0, r12, r13)
        L_0x0077:
            java.lang.Throwable r12 = kotlin.Result.m6332exceptionOrNullimpl(r14)
            if (r12 == 0) goto L_0x008a
            com.talabat.login.FacebookLoginErrorHandler r14 = r11.facebookLoginErrorHandler
            java.lang.ref.WeakReference<com.talabat.login.FacebookLoginErrorView> r11 = r11.facebookLoginErrorView
            java.lang.Object r11 = r11.get()
            com.talabat.login.FacebookLoginErrorView r11 = (com.talabat.login.FacebookLoginErrorView) r11
            r14.onFacebookLoginFailure(r12, r13, r11)
        L_0x008a:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.login.FacebookLoginScreenDelegate.doFacebookLogin(androidx.activity.ComponentActivity, library.talabat.mvp.login.ILoginPresenter, library.talabat.mvp.login.ILoginInteractor, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: onSetUpFacebookLoginButtons$lambda-0  reason: not valid java name */
    public static final void m10682onSetUpFacebookLoginButtons$lambda0(ComponentActivity componentActivity, Function0 function0, CoroutineScope coroutineScope, FacebookLoginScreenDelegate facebookLoginScreenDelegate, ILoginPresenter iLoginPresenter, ILoginInteractor iLoginInteractor, View view) {
        TalabatApplication talabatApplication;
        Intrinsics.checkNotNullParameter(componentActivity, "$activity");
        Intrinsics.checkNotNullParameter(function0, "$showLoading");
        Intrinsics.checkNotNullParameter(coroutineScope, "$coroutineScope");
        Intrinsics.checkNotNullParameter(facebookLoginScreenDelegate, "this$0");
        Intrinsics.checkNotNullParameter(iLoginPresenter, "$loginPresenter");
        Intrinsics.checkNotNullParameter(iLoginInteractor, "$loginInteractor");
        Application application = componentActivity.getApplication();
        if (application instanceof TalabatApplication) {
            talabatApplication = (TalabatApplication) application;
        } else {
            talabatApplication = null;
        }
        if (talabatApplication != null) {
            talabatApplication.pauseBannerForNextScreen();
        }
        function0.invoke();
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new FacebookLoginScreenDelegate$onSetUpFacebookLoginButtons$1$1(facebookLoginScreenDelegate, componentActivity, iLoginPresenter, iLoginInteractor, (Continuation<? super FacebookLoginScreenDelegate$onSetUpFacebookLoginButtons$1$1>) null), 3, (Object) null);
    }

    public final void attachErrorView(@NotNull FacebookLoginErrorView facebookLoginErrorView2) {
        Intrinsics.checkNotNullParameter(facebookLoginErrorView2, "errorView");
        this.facebookLoginErrorView = new WeakReference<>(facebookLoginErrorView2);
    }

    @NotNull
    public final View.OnClickListener onSetUpFacebookLoginButtons(@NotNull ComponentActivity componentActivity, @NotNull ILoginPresenter iLoginPresenter, @NotNull ILoginInteractor iLoginInteractor, @NotNull CoroutineScope coroutineScope, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        Intrinsics.checkNotNullParameter(iLoginPresenter, "loginPresenter");
        Intrinsics.checkNotNullParameter(iLoginInteractor, "loginInteractor");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(function0, "showLoading");
        return new a(componentActivity, function0, coroutineScope, this, iLoginPresenter, iLoginInteractor);
    }

    public final void sdkInitialize() {
        this.initializeFacebookLoginUseCase.initFacebook();
    }
}
