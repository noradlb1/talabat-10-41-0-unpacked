package com.talabat.login;

import com.talabat.core.social.login.domain.FacebookUserData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import library.talabat.mvp.login.ILoginInteractor;
import library.talabat.mvp.login.ILoginPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/core/social/login/domain/FacebookUserData;", "facebookRegistrationModel", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.login.FacebookLoginScreenDelegate$doFacebookLogin$2$1$1", f = "FacebookLoginScreenDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FacebookLoginScreenDelegate$doFacebookLogin$2$1$1 extends SuspendLambda implements Function2<FacebookUserData, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61050h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61051i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FacebookLoginScreenDelegate f61052j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ILoginPresenter f61053k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ILoginInteractor f61054l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FacebookLoginScreenDelegate$doFacebookLogin$2$1$1(FacebookLoginScreenDelegate facebookLoginScreenDelegate, ILoginPresenter iLoginPresenter, ILoginInteractor iLoginInteractor, Continuation<? super FacebookLoginScreenDelegate$doFacebookLogin$2$1$1> continuation) {
        super(2, continuation);
        this.f61052j = facebookLoginScreenDelegate;
        this.f61053k = iLoginPresenter;
        this.f61054l = iLoginInteractor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FacebookLoginScreenDelegate$doFacebookLogin$2$1$1 facebookLoginScreenDelegate$doFacebookLogin$2$1$1 = new FacebookLoginScreenDelegate$doFacebookLogin$2$1$1(this.f61052j, this.f61053k, this.f61054l, continuation);
        facebookLoginScreenDelegate$doFacebookLogin$2$1$1.f61051i = obj;
        return facebookLoginScreenDelegate$doFacebookLogin$2$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull FacebookUserData facebookUserData, @Nullable Continuation<? super Unit> continuation) {
        return ((FacebookLoginScreenDelegate$doFacebookLogin$2$1$1) create(facebookUserData, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f61050h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f61052j.facebookSuccessfulLoginHandler.onRegisterNewUser((FacebookUserData) this.f61051i, this.f61053k, this.f61054l);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
