package com.talabat.login;

import androidx.activity.ComponentActivity;
import com.talabat.core.social.login.domain.FacebookLoginUseCase;
import com.talabat.core.social.login.domain.FacebookUserData;
import kotlin.Metadata;
import kotlin.Result;
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

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "Lcom/talabat/core/social/login/domain/FacebookUserData;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.login.FacebookLoginScreenDelegate$doFacebookLogin$2", f = "FacebookLoginScreenDelegate.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
public final class FacebookLoginScreenDelegate$doFacebookLogin$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends FacebookUserData>>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f61045h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FacebookLoginScreenDelegate f61046i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f61047j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ILoginPresenter f61048k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ILoginInteractor f61049l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FacebookLoginScreenDelegate$doFacebookLogin$2(FacebookLoginScreenDelegate facebookLoginScreenDelegate, ComponentActivity componentActivity, ILoginPresenter iLoginPresenter, ILoginInteractor iLoginInteractor, Continuation<? super FacebookLoginScreenDelegate$doFacebookLogin$2> continuation) {
        super(2, continuation);
        this.f61046i = facebookLoginScreenDelegate;
        this.f61047j = componentActivity;
        this.f61048k = iLoginPresenter;
        this.f61049l = iLoginInteractor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FacebookLoginScreenDelegate$doFacebookLogin$2 facebookLoginScreenDelegate$doFacebookLogin$2 = new FacebookLoginScreenDelegate$doFacebookLogin$2(this.f61046i, this.f61047j, this.f61048k, this.f61049l, continuation);
        facebookLoginScreenDelegate$doFacebookLogin$2.L$0 = obj;
        return facebookLoginScreenDelegate$doFacebookLogin$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Result<FacebookUserData>> continuation) {
        return ((FacebookLoginScreenDelegate$doFacebookLogin$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61045h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            FacebookLoginScreenDelegate facebookLoginScreenDelegate = this.f61046i;
            ComponentActivity componentActivity = this.f61047j;
            ILoginPresenter iLoginPresenter = this.f61048k;
            ILoginInteractor iLoginInteractor = this.f61049l;
            Result.Companion companion = Result.Companion;
            FacebookLoginUseCase access$getFacebookLoginUseCase$p = facebookLoginScreenDelegate.facebookLoginUseCase;
            FacebookLoginScreenDelegate$doFacebookLogin$2$1$1 facebookLoginScreenDelegate$doFacebookLogin$2$1$1 = new FacebookLoginScreenDelegate$doFacebookLogin$2$1$1(facebookLoginScreenDelegate, iLoginPresenter, iLoginInteractor, (Continuation<? super FacebookLoginScreenDelegate$doFacebookLogin$2$1$1>) null);
            this.f61045h = 1;
            obj = access$getFacebookLoginUseCase$p.requestFacebookAuth(componentActivity, facebookLoginScreenDelegate$doFacebookLogin$2$1$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl((FacebookUserData) obj);
        return Result.m6328boximpl(obj2);
    }
}
