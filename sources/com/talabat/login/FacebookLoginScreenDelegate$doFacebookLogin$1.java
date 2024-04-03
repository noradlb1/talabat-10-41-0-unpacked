package com.talabat.login;

import androidx.activity.ComponentActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import library.talabat.mvp.login.ILoginInteractor;
import library.talabat.mvp.login.ILoginPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.login.FacebookLoginScreenDelegate", f = "FacebookLoginScreenDelegate.kt", i = {0, 0, 0}, l = {66}, m = "doFacebookLogin", n = {"this", "loginPresenter", "loginInteractor"}, s = {"L$0", "L$1", "L$2"})
public final class FacebookLoginScreenDelegate$doFacebookLogin$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61039h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61040i;

    /* renamed from: j  reason: collision with root package name */
    public Object f61041j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f61042k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FacebookLoginScreenDelegate f61043l;

    /* renamed from: m  reason: collision with root package name */
    public int f61044m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FacebookLoginScreenDelegate$doFacebookLogin$1(FacebookLoginScreenDelegate facebookLoginScreenDelegate, Continuation<? super FacebookLoginScreenDelegate$doFacebookLogin$1> continuation) {
        super(continuation);
        this.f61043l = facebookLoginScreenDelegate;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61042k = obj;
        this.f61044m |= Integer.MIN_VALUE;
        return this.f61043l.doFacebookLogin((ComponentActivity) null, (ILoginPresenter) null, (ILoginInteractor) null, this);
    }
}
