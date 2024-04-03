package com.talabat.core.deeplink.data;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.deeplink.data.DefaultDeepLinkNavigator", f = "DefaultDeepLinkNavigator.kt", i = {}, l = {77}, m = "isDeepLinkSupported", n = {}, s = {})
public final class DefaultDeepLinkNavigator$isDeepLinkSupported$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f55793h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DefaultDeepLinkNavigator f55794i;

    /* renamed from: j  reason: collision with root package name */
    public int f55795j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultDeepLinkNavigator$isDeepLinkSupported$1(DefaultDeepLinkNavigator defaultDeepLinkNavigator, Continuation<? super DefaultDeepLinkNavigator$isDeepLinkSupported$1> continuation) {
        super(continuation);
        this.f55794i = defaultDeepLinkNavigator;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55793h = obj;
        this.f55795j |= Integer.MIN_VALUE;
        return this.f55794i.isDeepLinkSupported((Uri) null, (String) null, this);
    }
}
