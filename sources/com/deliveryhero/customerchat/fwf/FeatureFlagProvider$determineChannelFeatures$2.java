package com.deliveryhero.customerchat.fwf;

import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.model.Events;
import com.deliveryhero.contract.model.UserInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.customerchat.fwf.FeatureFlagProvider$determineChannelFeatures$2", f = "FeatureFlagProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FeatureFlagProvider$determineChannelFeatures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f29983h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FeatureFlagProvider f29984i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f29985j;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/deliveryhero/customerchat/fwf/ChannelFeatureFlags;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.deliveryhero.customerchat.fwf.FeatureFlagProvider$determineChannelFeatures$2$1", f = "FeatureFlagProvider.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.deliveryhero.customerchat.fwf.FeatureFlagProvider$determineChannelFeatures$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChannelFeatureFlags>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f29986h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(access$getChatConfig, featureFlagProvider, str, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ChannelFeatureFlags> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f29986h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                if (!access$getChatConfig.isFWFEnabled()) {
                    return new ChannelFeatureFlags(true);
                }
                FeatureFlagProvider featureFlagProvider = featureFlagProvider;
                String str = str;
                Custom access$getCustomAttributes = featureFlagProvider.getCustomAttributes();
                if (access$getCustomAttributes == null) {
                    return new ChannelFeatureFlags(false, 1, (DefaultConstructorMarker) null);
                }
                this.f29986h = 1;
                obj = featureFlagProvider.fetchChannelFeatureFlags(str, access$getCustomAttributes, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return (ChannelFeatureFlags) obj;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeatureFlagProvider$determineChannelFeatures$2(FeatureFlagProvider featureFlagProvider, String str, Continuation<? super FeatureFlagProvider$determineChannelFeatures$2> continuation) {
        super(2, continuation);
        this.f29984i = featureFlagProvider;
        this.f29985j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeatureFlagProvider$determineChannelFeatures$2 featureFlagProvider$determineChannelFeatures$2 = new FeatureFlagProvider$determineChannelFeatures$2(this.f29984i, this.f29985j, continuation);
        featureFlagProvider$determineChannelFeatures$2.L$0 = obj;
        return featureFlagProvider$determineChannelFeatures$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeatureFlagProvider$determineChannelFeatures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        UserInfo userInfo;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f29983h == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (this.f29984i.isVoipSDKEnabled) {
                Deferred access$getChannelFeatureFlags$p = this.f29984i.channelFeatureFlags;
                boolean z11 = false;
                if (access$getChannelFeatureFlags$p != null && access$getChannelFeatureFlags$p.isActive()) {
                    z11 = true;
                }
                if (z11) {
                    return Unit.INSTANCE;
                }
                final ChatConfiguration access$getChatConfig = this.f29984i.getChatConfig();
                if (access$getChatConfig != null) {
                    userInfo = access$getChatConfig.getUserInfoOrNull();
                } else {
                    userInfo = null;
                }
                if (userInfo == null) {
                    ChatLogger access$getChatLogger$p = this.f29984i.chatLogger;
                    if (access$getChatLogger$p != null) {
                        access$getChatLogger$p.log(Events.GCC_FWF_NOT_READY, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("EVENT", Events.GCC_USER_NOT_REGISTERED)));
                    }
                    return Unit.INSTANCE;
                } else if (access$getChatConfig.getClientConfigOrNull() == null) {
                    ChatLogger access$getChatLogger$p2 = this.f29984i.chatLogger;
                    if (access$getChatLogger$p2 != null) {
                        access$getChatLogger$p2.log(Events.GCC_FWF_NOT_READY, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("EVENT", Events.GCC_CLIENT_CONFIG_NOT_SET)));
                    }
                    return Unit.INSTANCE;
                } else {
                    final FeatureFlagProvider featureFlagProvider = this.f29984i;
                    final String str = this.f29985j;
                    featureFlagProvider.channelFeatureFlags = BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
