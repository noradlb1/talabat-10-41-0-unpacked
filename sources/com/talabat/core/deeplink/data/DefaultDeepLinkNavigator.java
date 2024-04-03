package com.talabat.core.deeplink.data;

import android.content.Context;
import android.net.Uri;
import com.talabat.core.deeplink.data.di.AppLink;
import com.talabat.core.deeplink.data.di.DeepLink;
import com.talabat.core.deeplink.data.parser.LinkParser;
import com.talabat.core.deeplink.data.registry.LinkHandlerRegistry;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0000\b\u0000\u0018\u00002\u00020\u0001BG\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001dH\u0002J(\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001dH\u0002J!\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010 J!\u0010!\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010 J(\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001dH\u0016J.\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140&H\u0002R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/talabat/core/deeplink/data/DefaultDeepLinkNavigator;", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "deepLinkParser", "Lcom/talabat/core/deeplink/data/parser/LinkParser;", "deepLinkHandlerRegistry", "Lcom/talabat/core/deeplink/data/registry/LinkHandlerRegistry;", "appLinkParser", "appLinkHandlerRegistry", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/deeplink/data/parser/LinkParser;Lcom/talabat/core/deeplink/data/registry/LinkHandlerRegistry;Lcom/talabat/core/deeplink/data/parser/LinkParser;Lcom/talabat/core/deeplink/data/registry/LinkHandlerRegistry;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "mainCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "canHandleDeepLink", "", "link", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleDeepLinkNavigation", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "onNavigationCompletionCallback", "Lkotlin/Function0;", "handleHttpsNavigation", "isAppLinkSupported", "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDeepLinkSupported", "navigateTo", "observe", "reason", "additionalAttributes", "", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultDeepLinkNavigator implements DeepLinkNavigator {
    /* access modifiers changed from: private */
    @NotNull
    public final LinkHandlerRegistry appLinkHandlerRegistry;
    @NotNull
    private final LinkParser appLinkParser;
    @NotNull
    private final CoroutineDispatchersFactory coroutineDispatchersFactory;
    /* access modifiers changed from: private */
    @NotNull
    public final LinkHandlerRegistry deepLinkHandlerRegistry;
    @NotNull
    private final LinkParser deepLinkParser;
    @NotNull
    private final CoroutineScope mainCoroutineScope;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Schemes.values().length];
            iArr[Schemes.DEEPLINK.ordinal()] = 1;
            iArr[Schemes.URL.ordinal()] = 2;
            iArr[Schemes.UNKNOWN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public DefaultDeepLinkNavigator(@NotNull @DeepLink LinkParser linkParser, @NotNull @DeepLink LinkHandlerRegistry linkHandlerRegistry, @NotNull @AppLink LinkParser linkParser2, @NotNull @AppLink LinkHandlerRegistry linkHandlerRegistry2, @NotNull IObservabilityManager iObservabilityManager, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(linkParser, "deepLinkParser");
        Intrinsics.checkNotNullParameter(linkHandlerRegistry, "deepLinkHandlerRegistry");
        Intrinsics.checkNotNullParameter(linkParser2, "appLinkParser");
        Intrinsics.checkNotNullParameter(linkHandlerRegistry2, "appLinkHandlerRegistry");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "coroutineDispatchersFactory");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.deepLinkParser = linkParser;
        this.deepLinkHandlerRegistry = linkHandlerRegistry;
        this.appLinkParser = linkParser2;
        this.appLinkHandlerRegistry = linkHandlerRegistry2;
        this.observabilityManager = iObservabilityManager;
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.mainCoroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatchersFactory2.main());
    }

    public static /* synthetic */ void a(DefaultDeepLinkNavigator defaultDeepLinkNavigator, String str, String str2, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        defaultDeepLinkNavigator.observe(str, str2, map);
    }

    private final void handleDeepLinkNavigation(Context context, Uri uri, Function0<Unit> function0) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(this.deepLinkParser.parse(uri));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6336isSuccessimpl(obj)) {
            BuildersKt__Builders_commonKt.launch$default(this.mainCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultDeepLinkNavigator$handleDeepLinkNavigation$2$1(this, (ParsedLinkModel) obj, context, uri, (Continuation<? super DefaultDeepLinkNavigator$handleDeepLinkNavigation$2$1>) null), 3, (Object) null).invokeOnCompletion(new DefaultDeepLinkNavigator$handleDeepLinkNavigation$2$2(function0));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 != null) {
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            String message = r12.getMessage();
            if (message == null) {
                message = "";
            }
            observe("handleDeepLinkNavigation::DeepLinkParsingError", uri2, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("exception", message)));
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    private final void handleHttpsNavigation(Context context, Uri uri, Function0<Unit> function0) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(this.appLinkParser.parse(uri));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6336isSuccessimpl(obj)) {
            BuildersKt__Builders_commonKt.launch$default(this.mainCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultDeepLinkNavigator$handleHttpsNavigation$2$1(this, (ParsedLinkModel) obj, context, uri, (Continuation<? super DefaultDeepLinkNavigator$handleHttpsNavigation$2$1>) null), 3, (Object) null).invokeOnCompletion(new DefaultDeepLinkNavigator$handleHttpsNavigation$2$2(function0));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 != null) {
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            String message = r12.getMessage();
            if (message == null) {
                message = "";
            }
            observe("handleAppLinkNavigation::DeepLinkParsingError", uri2, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("exception", message)));
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object isAppLinkSupported(android.net.Uri r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.talabat.core.deeplink.data.DefaultDeepLinkNavigator$isAppLinkSupported$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.core.deeplink.data.DefaultDeepLinkNavigator$isAppLinkSupported$1 r0 = (com.talabat.core.deeplink.data.DefaultDeepLinkNavigator$isAppLinkSupported$1) r0
            int r1 = r0.f55792j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55792j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.core.deeplink.data.DefaultDeepLinkNavigator$isAppLinkSupported$1 r0 = new com.talabat.core.deeplink.data.DefaultDeepLinkNavigator$isAppLinkSupported$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f55790h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55792j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x0041 }
            com.talabat.core.deeplink.data.parser.LinkParser r7 = r4.appLinkParser     // Catch:{ all -> 0x0041 }
            com.talabat.core.deeplink.data.ParsedLinkModel r5 = r7.parse(r5)     // Catch:{ all -> 0x0041 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0041 }
            goto L_0x004c
        L_0x0041:
            r5 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x004c:
            java.lang.Throwable r7 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r7 != 0) goto L_0x006a
            com.talabat.core.deeplink.data.ParsedLinkModel r5 = (com.talabat.core.deeplink.data.ParsedLinkModel) r5
            com.talabat.core.deeplink.data.registry.LinkHandlerRegistry r6 = r4.appLinkHandlerRegistry
            r0.f55792j = r3
            java.lang.Object r7 = r6.canHandle(r5, r0)
            if (r7 != r1) goto L_0x005f
            return r1
        L_0x005f:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r5 = r7.booleanValue()
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            goto L_0x0086
        L_0x006a:
            java.lang.String r5 = r7.getMessage()
            if (r5 != 0) goto L_0x0072
            java.lang.String r5 = ""
        L_0x0072:
            java.lang.String r7 = "exception"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r7, r5)
            java.util.Map r5 = kotlin.collections.MapsKt__MapsJVMKt.mapOf(r5)
            java.lang.String r7 = "canHandleAppLink::DeepLinkParsingError"
            r4.observe(r7, r6, r5)
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
        L_0x0086:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.deeplink.data.DefaultDeepLinkNavigator.isAppLinkSupported(android.net.Uri, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object isDeepLinkSupported(android.net.Uri r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.talabat.core.deeplink.data.DefaultDeepLinkNavigator$isDeepLinkSupported$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.core.deeplink.data.DefaultDeepLinkNavigator$isDeepLinkSupported$1 r0 = (com.talabat.core.deeplink.data.DefaultDeepLinkNavigator$isDeepLinkSupported$1) r0
            int r1 = r0.f55795j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55795j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.core.deeplink.data.DefaultDeepLinkNavigator$isDeepLinkSupported$1 r0 = new com.talabat.core.deeplink.data.DefaultDeepLinkNavigator$isDeepLinkSupported$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f55793h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55795j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x0041 }
            com.talabat.core.deeplink.data.parser.LinkParser r7 = r4.deepLinkParser     // Catch:{ all -> 0x0041 }
            com.talabat.core.deeplink.data.ParsedLinkModel r5 = r7.parse(r5)     // Catch:{ all -> 0x0041 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0041 }
            goto L_0x004c
        L_0x0041:
            r5 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x004c:
            java.lang.Throwable r7 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r7 != 0) goto L_0x006a
            com.talabat.core.deeplink.data.ParsedLinkModel r5 = (com.talabat.core.deeplink.data.ParsedLinkModel) r5
            com.talabat.core.deeplink.data.registry.LinkHandlerRegistry r6 = r4.deepLinkHandlerRegistry
            r0.f55795j = r3
            java.lang.Object r7 = r6.canHandle(r5, r0)
            if (r7 != r1) goto L_0x005f
            return r1
        L_0x005f:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r5 = r7.booleanValue()
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            goto L_0x0086
        L_0x006a:
            java.lang.String r5 = r7.getMessage()
            if (r5 != 0) goto L_0x0072
            java.lang.String r5 = ""
        L_0x0072:
            java.lang.String r7 = "exception"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r7, r5)
            java.util.Map r5 = kotlin.collections.MapsKt__MapsJVMKt.mapOf(r5)
            java.lang.String r7 = "canHandleDeepLink::DeepLinkParsingError"
            r4.observe(r7, r6, r5)
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
        L_0x0086:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.deeplink.data.DefaultDeepLinkNavigator.isDeepLinkSupported(android.net.Uri, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void observe(String str, String str2, Map<String, String> map) {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("link", str2));
        mutableMapOf.putAll(map);
        Unit unit = Unit.INSTANCE;
        iObservabilityManager.trackUnExpectedScenario(str, mutableMapOf);
    }

    @Nullable
    public Object canHandleDeepLink(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        Uri parse = Uri.parse(str);
        int i11 = WhenMappings.$EnumSwitchMapping$0[Schemes.Companion.from(parse.getScheme()).ordinal()];
        if (i11 == 1) {
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            return isDeepLinkSupported(parse, str, continuation);
        } else if (i11 != 2) {
            a(this, "canHandleDeepLink::UnsupportedScheme", str, (Map) null, 4, (Object) null);
            return Boxing.boxBoolean(false);
        } else {
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            return isAppLinkSupported(parse, str, continuation);
        }
    }

    public void navigateTo(@NotNull Context context, @NotNull String str, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "link");
        Uri parse = Uri.parse(str);
        int i11 = WhenMappings.$EnumSwitchMapping$0[Schemes.Companion.from(parse.getScheme()).ordinal()];
        if (i11 == 1) {
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            handleDeepLinkNavigation(context, parse, function0);
        } else if (i11 == 2) {
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            handleHttpsNavigation(context, parse, function0);
        } else if (i11 == 3) {
            a(this, "navigateTo::UnsupportedScheme", str, (Map) null, 4, (Object) null);
            if (function0 != null) {
                function0.invoke();
            }
        }
    }
}
