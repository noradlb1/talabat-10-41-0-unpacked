package com.talabat.core.deeplink.data;

import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.core.deeplink.data.DefaultDeepLinkNavigator$handleHttpsNavigation$2$1", f = "DefaultDeepLinkNavigator.kt", i = {}, l = {153, 155}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultDeepLinkNavigator$handleHttpsNavigation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f55784h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DefaultDeepLinkNavigator f55785i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ParsedLinkModel f55786j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Context f55787k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Uri f55788l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultDeepLinkNavigator$handleHttpsNavigation$2$1(DefaultDeepLinkNavigator defaultDeepLinkNavigator, ParsedLinkModel parsedLinkModel, Context context, Uri uri, Continuation<? super DefaultDeepLinkNavigator$handleHttpsNavigation$2$1> continuation) {
        super(2, continuation);
        this.f55785i = defaultDeepLinkNavigator;
        this.f55786j = parsedLinkModel;
        this.f55787k = context;
        this.f55788l = uri;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultDeepLinkNavigator$handleHttpsNavigation$2$1(this.f55785i, this.f55786j, this.f55787k, this.f55788l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultDeepLinkNavigator$handleHttpsNavigation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f55784h
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004b
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0032
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r5)
            com.talabat.core.deeplink.data.DefaultDeepLinkNavigator r5 = r4.f55785i
            com.talabat.core.deeplink.data.registry.LinkHandlerRegistry r5 = r5.appLinkHandlerRegistry
            com.talabat.core.deeplink.data.ParsedLinkModel r1 = r4.f55786j
            r4.f55784h = r3
            java.lang.Object r5 = r5.canHandle(r1, r4)
            if (r5 != r0) goto L_0x0032
            return r0
        L_0x0032:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0057
            com.talabat.core.deeplink.data.DefaultDeepLinkNavigator r5 = r4.f55785i
            com.talabat.core.deeplink.data.registry.LinkHandlerRegistry r5 = r5.appLinkHandlerRegistry
            com.talabat.core.deeplink.data.ParsedLinkModel r1 = r4.f55786j
            r4.f55784h = r2
            java.lang.Object r5 = r5.loadHandler(r1, r4)
            if (r5 != r0) goto L_0x004b
            return r0
        L_0x004b:
            com.talabat.core.deeplink.data.handler.Handler r5 = (com.talabat.core.deeplink.data.handler.Handler) r5
            if (r5 == 0) goto L_0x0070
            android.content.Context r0 = r4.f55787k
            com.talabat.core.deeplink.data.ParsedLinkModel r1 = r4.f55786j
            r5.handle(r0, r1)
            goto L_0x0070
        L_0x0057:
            com.talabat.core.deeplink.data.DefaultDeepLinkNavigator r5 = r4.f55785i
            android.net.Uri r0 = r4.f55788l
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "uri.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.talabat.core.deeplink.data.ParsedLinkModel r1 = r4.f55786j
            java.util.Map r1 = r1.getData()
            java.lang.String r2 = "handleAppLinkNavigation::UnRegisteredHandler"
            r5.observe(r2, r0, r1)
        L_0x0070:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.deeplink.data.DefaultDeepLinkNavigator$handleHttpsNavigation$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
