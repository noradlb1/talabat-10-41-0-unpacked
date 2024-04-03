package com.deliveryhero.customerchat;

import android.content.Context;
import com.deliveryhero.contract.configuration.CustomerChatConfigurationBuilder;
import com.deliveryhero.contract.model.DeliveryInfo;
import com.deliveryhero.customerchat.commons.BlankChannelIDException;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CustomerChatModule$startChat$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f29782g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f29783h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CustomerChatModule f29784i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Context f29785j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DeliveryInfo f29786k;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.deliveryhero.customerchat.CustomerChatModule$startChat$1$2", f = "CustomerChatModule.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.deliveryhero.customerchat.CustomerChatModule$startChat$1$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f29789h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(customerChatModule2, str2, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f29789h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                FeatureFlagProvider access$getFeatureFlagProvider = customerChatModule2.getFeatureFlagProvider();
                String str = str2;
                this.f29789h = 1;
                if (access$getFeatureFlagProvider.determineChannelFeatures(str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatModule$startChat$1(String str, Function1<? super Throwable, Unit> function1, CustomerChatModule customerChatModule, Context context, DeliveryInfo deliveryInfo) {
        super(0);
        this.f29782g = str;
        this.f29783h = function1;
        this.f29784i = customerChatModule;
        this.f29785j = context;
        this.f29786k = deliveryInfo;
    }

    public final void invoke() {
        if (StringsKt__StringsJVMKt.isBlank(this.f29782g)) {
            Function1<Throwable, Unit> function1 = this.f29783h;
            if (function1 != null) {
                function1.invoke(new BlankChannelIDException((String) null, 1, (DefaultConstructorMarker) null));
                return;
            }
            return;
        }
        CustomerChatModule customerChatModule = this.f29784i;
        final String str = this.f29782g;
        final DeliveryInfo deliveryInfo = this.f29786k;
        customerChatModule.setConfiguration((Function1<? super CustomerChatConfigurationBuilder, Unit>) new Function1<CustomerChatConfigurationBuilder, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomerChatConfigurationBuilder) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull CustomerChatConfigurationBuilder customerChatConfigurationBuilder) {
                Intrinsics.checkNotNullParameter(customerChatConfigurationBuilder, "$this$setConfiguration");
                customerChatConfigurationBuilder.channelId(str);
                customerChatConfigurationBuilder.deliveryInfo(deliveryInfo);
            }
        });
        CoroutineScope access$getFeatureFlagCoroutineScope$p = this.f29784i.featureFlagCoroutineScope;
        final CustomerChatModule customerChatModule2 = this.f29784i;
        final String str2 = this.f29782g;
        Job unused = BuildersKt__Builders_commonKt.launch$default(access$getFeatureFlagCoroutineScope$p, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2((Continuation<? super AnonymousClass2>) null), 3, (Object) null);
        this.f29784i.setAnalyticsProperties();
        this.f29784i.getChatService().startChat(this.f29785j, this.f29783h);
    }
}
