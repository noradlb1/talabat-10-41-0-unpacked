package com.talabat.core.flutter.channels.data.navigation;

import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationChannelCallback;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.core.flutter.channels.data.navigation.DeepLinkNativeNavigationChannel$onMethodCall$1", f = "DeepLinkNativeNavigationChannel.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
public final class DeepLinkNativeNavigationChannel$onMethodCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f55894h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DeepLinkNativeNavigationChannel f55895i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f55896j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f55897k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeepLinkNativeNavigationChannel$onMethodCall$1(DeepLinkNativeNavigationChannel deepLinkNativeNavigationChannel, String str, MethodChannel.Result result, Continuation<? super DeepLinkNativeNavigationChannel$onMethodCall$1> continuation) {
        super(2, continuation);
        this.f55895i = deepLinkNativeNavigationChannel;
        this.f55896j = str;
        this.f55897k = result;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DeepLinkNativeNavigationChannel$onMethodCall$1(this.f55895i, this.f55896j, this.f55897k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DeepLinkNativeNavigationChannel$onMethodCall$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f55894h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DeeplinkNavigationChannelCallback access$getFromNativeCallback$p = this.f55895i.fromNativeCallback;
            String str = this.f55896j;
            this.f55894h = 1;
            obj = access$getFromNativeCallback$p.onCanOpenDeeplink(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f55897k.success(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
        return Unit.INSTANCE;
    }
}
