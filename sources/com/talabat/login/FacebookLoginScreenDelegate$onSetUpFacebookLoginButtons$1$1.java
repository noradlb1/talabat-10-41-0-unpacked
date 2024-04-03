package com.talabat.login;

import androidx.activity.ComponentActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import library.talabat.mvp.login.ILoginInteractor;
import library.talabat.mvp.login.ILoginPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.login.FacebookLoginScreenDelegate$onSetUpFacebookLoginButtons$1$1", f = "FacebookLoginScreenDelegate.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
public final class FacebookLoginScreenDelegate$onSetUpFacebookLoginButtons$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61055h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FacebookLoginScreenDelegate f61056i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f61057j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ILoginPresenter f61058k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ILoginInteractor f61059l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FacebookLoginScreenDelegate$onSetUpFacebookLoginButtons$1$1(FacebookLoginScreenDelegate facebookLoginScreenDelegate, ComponentActivity componentActivity, ILoginPresenter iLoginPresenter, ILoginInteractor iLoginInteractor, Continuation<? super FacebookLoginScreenDelegate$onSetUpFacebookLoginButtons$1$1> continuation) {
        super(2, continuation);
        this.f61056i = facebookLoginScreenDelegate;
        this.f61057j = componentActivity;
        this.f61058k = iLoginPresenter;
        this.f61059l = iLoginInteractor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FacebookLoginScreenDelegate$onSetUpFacebookLoginButtons$1$1(this.f61056i, this.f61057j, this.f61058k, this.f61059l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FacebookLoginScreenDelegate$onSetUpFacebookLoginButtons$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61055h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FacebookLoginScreenDelegate facebookLoginScreenDelegate = this.f61056i;
            ComponentActivity componentActivity = this.f61057j;
            ILoginPresenter iLoginPresenter = this.f61058k;
            ILoginInteractor iLoginInteractor = this.f61059l;
            this.f61055h = 1;
            if (facebookLoginScreenDelegate.doFacebookLogin(componentActivity, iLoginPresenter, iLoginInteractor, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
