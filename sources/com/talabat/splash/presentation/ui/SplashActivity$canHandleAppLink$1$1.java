package com.talabat.splash.presentation.ui;

import android.net.Uri;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.splash.presentation.ui.SplashActivity$canHandleAppLink$1$1", f = "SplashActivity.kt", i = {}, l = {303}, m = "invokeSuspend", n = {}, s = {})
public final class SplashActivity$canHandleAppLink$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61520h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SplashActivity f61521i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Uri f61522j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashActivity$canHandleAppLink$1$1(SplashActivity splashActivity, Uri uri, Continuation<? super SplashActivity$canHandleAppLink$1$1> continuation) {
        super(2, continuation);
        this.f61521i = splashActivity;
        this.f61522j = uri;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SplashActivity$canHandleAppLink$1$1(this.f61521i, this.f61522j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((SplashActivity$canHandleAppLink$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61520h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DeepLinkNavigator deepLinkNavigator$com_talabat_talabat_talabat = this.f61521i.getDeepLinkNavigator$com_talabat_talabat_talabat();
            String uri = this.f61522j.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "it.toString()");
            this.f61520h = 1;
            obj = deepLinkNavigator$com_talabat_talabat_talabat.canHandleDeepLink(uri, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
