package com.talabat.splash.presentation.ui;

import android.content.Intent;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.splash.presentation.ui.SplashActivity$loadScreenDeepLinkRedirection$1", f = "SplashActivity.kt", i = {0}, l = {382}, m = "invokeSuspend", n = {"uri"}, s = {"L$0"})
public final class SplashActivity$loadScreenDeepLinkRedirection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f61523h;

    /* renamed from: i  reason: collision with root package name */
    public int f61524i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SplashActivity f61525j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashActivity$loadScreenDeepLinkRedirection$1(SplashActivity splashActivity, Continuation<? super SplashActivity$loadScreenDeepLinkRedirection$1> continuation) {
        super(2, continuation);
        this.f61525j = splashActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SplashActivity$loadScreenDeepLinkRedirection$1(this.f61525j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SplashActivity$loadScreenDeepLinkRedirection$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Uri uri;
        Uri uri2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61524i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Intent intent = this.f61525j.getIntent();
            if (intent != null) {
                uri2 = intent.getData();
            } else {
                uri2 = null;
            }
            this.f61525j.stopAppStartToInteractiveTrackingForDeepLink(uri2);
            if (uri2 != null) {
                DeepLinkNavigator deepLinkNavigator$com_talabat_talabat_talabat = this.f61525j.getDeepLinkNavigator$com_talabat_talabat_talabat();
                String uri3 = uri2.toString();
                Intrinsics.checkNotNullExpressionValue(uri3, "uri.toString()");
                this.f61523h = uri2;
                this.f61524i = 1;
                Object canHandleDeepLink = deepLinkNavigator$com_talabat_talabat_talabat.canHandleDeepLink(uri3, this);
                if (canHandleDeepLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                uri = uri2;
                obj = canHandleDeepLink;
            }
            this.f61525j.getDeepLinkPresenter().redirectToDeepLink();
            uri = uri2;
            this.f61525j.sendNewRelicTrackingForDeeplink(uri);
            return Unit.INSTANCE;
        } else if (i11 == 1) {
            uri = (Uri) this.f61523h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            this.f61525j.getNavigator$com_talabat_talabat_talabat().openHomeScreenToHandleDeepLink(this.f61525j, uri);
            this.f61525j.finish();
            this.f61525j.sendNewRelicTrackingForDeeplink(uri);
            return Unit.INSTANCE;
        }
        uri2 = uri;
        this.f61525j.getDeepLinkPresenter().redirectToDeepLink();
        uri = uri2;
        this.f61525j.sendNewRelicTrackingForDeeplink(uri);
        return Unit.INSTANCE;
    }
}
