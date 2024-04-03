package com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation;

import android.view.View;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities.Creative;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation.AdDisplaySession$start$1", f = "AdDisplaySession.kt", i = {0}, l = {31}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class AdDisplaySession$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f40035h;

    /* renamed from: i  reason: collision with root package name */
    public int f40036i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AdDisplaySession f40037j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Creative f40038k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ View f40039l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdDisplaySession$start$1(AdDisplaySession adDisplaySession, Creative creative, View view, Continuation<? super AdDisplaySession$start$1> continuation) {
        super(2, continuation);
        this.f40037j = adDisplaySession;
        this.f40038k = creative;
        this.f40039l = view;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AdDisplaySession$start$1 adDisplaySession$start$1 = new AdDisplaySession$start$1(this.f40037j, this.f40038k, this.f40039l, continuation);
        adDisplaySession$start$1.L$0 = obj;
        return adDisplaySession$start$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AdDisplaySession$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f40036i
            r2 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r0 = r6.f40035h
            com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation.AdDisplaySession r0 = (com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation.AdDisplaySession) r0
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0044
        L_0x0017:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation.AdDisplaySession r7 = r6.f40037j     // Catch:{ Exception -> 0x0057 }
            com.adtechsdk.dh_adtech_sdk_flutter.viewability.data.ViewabilityRepository r3 = r7.adViewabilityRepository     // Catch:{ Exception -> 0x0057 }
            com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities.Creative r4 = r6.f40038k     // Catch:{ Exception -> 0x0057 }
            com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation.AdDisplaySession r5 = r6.f40037j     // Catch:{ Exception -> 0x0057 }
            android.content.Context r5 = r5.context     // Catch:{ Exception -> 0x0057 }
            r6.L$0 = r1     // Catch:{ Exception -> 0x0057 }
            r6.f40035h = r7     // Catch:{ Exception -> 0x0057 }
            r6.f40036i = r2     // Catch:{ Exception -> 0x0057 }
            java.lang.Object r2 = r3.createDisplayViewabilitySession(r4, r5, r6)     // Catch:{ Exception -> 0x0057 }
            if (r2 != r0) goto L_0x0042
            return r0
        L_0x0042:
            r0 = r7
            r7 = r2
        L_0x0044:
            com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities.DisplayViewabilitySession r7 = (com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities.DisplayViewabilitySession) r7     // Catch:{ Exception -> 0x0057 }
            r0.viewabilitySession = r7     // Catch:{ Exception -> 0x0057 }
            boolean r7 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)     // Catch:{ Exception -> 0x0057 }
            if (r7 == 0) goto L_0x006b
            com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation.AdDisplaySession r7 = r6.f40037j     // Catch:{ Exception -> 0x0057 }
            android.view.View r0 = r6.f40039l     // Catch:{ Exception -> 0x0057 }
            r7.startViewabilitySession(r0)     // Catch:{ Exception -> 0x0057 }
            goto L_0x006b
        L_0x0057:
            r7 = move-exception
            com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation.AdDisplaySession r0 = r6.f40037j
            com.adtechsdk.dh_adtech_sdk_flutter.viewability.ViewabilityMethodChannel r0 = r0.viewabilityMethodChannel
            java.lang.String r7 = r7.getMessage()
            if (r7 != 0) goto L_0x0066
            java.lang.String r7 = ""
        L_0x0066:
            java.lang.String r1 = "Error Creating Display Viewability Session"
            r0.logError(r1, r7)
        L_0x006b:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation.AdDisplaySession$start$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
