package com.talabat.core.deeplink.data;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.deeplink.data.DefaultDeepLinkNavigator", f = "DefaultDeepLinkNavigator.kt", i = {}, l = {93}, m = "isAppLinkSupported", n = {}, s = {})
public final class DefaultDeepLinkNavigator$isAppLinkSupported$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f55790h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DefaultDeepLinkNavigator f55791i;

    /* renamed from: j  reason: collision with root package name */
    public int f55792j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultDeepLinkNavigator$isAppLinkSupported$1(DefaultDeepLinkNavigator defaultDeepLinkNavigator, Continuation<? super DefaultDeepLinkNavigator$isAppLinkSupported$1> continuation) {
        super(continuation);
        this.f55791i = defaultDeepLinkNavigator;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55790h = obj;
        this.f55792j |= Integer.MIN_VALUE;
        return this.f55791i.isAppLinkSupported((Uri) null, (String) null, this);
    }
}
