package com.talabat.feature.tpro.presentation.management.details;

import android.content.Context;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment$onChangePaymentClick$1", f = "TProSubscriptionDetailsFragment.kt", i = {}, l = {619}, m = "invokeSuspend", n = {}, s = {})
public final class TProSubscriptionDetailsFragment$onChangePaymentClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59313h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TProSubscriptionDetailsFragment f59314i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProSubscriptionDetailsFragment$onChangePaymentClick$1(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment, Continuation<? super TProSubscriptionDetailsFragment$onChangePaymentClick$1> continuation) {
        super(2, continuation);
        this.f59314i = tProSubscriptionDetailsFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TProSubscriptionDetailsFragment$onChangePaymentClick$1(this.f59314i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TProSubscriptionDetailsFragment$onChangePaymentClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59313h;
        boolean z11 = true;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DeepLinkNavigator deepLinkNavigator = this.f59314i.getDeepLinkNavigator();
            String access$getChangePaymentDeeplink$p = this.f59314i.changePaymentDeeplink;
            this.f59313h = 1;
            obj = deepLinkNavigator.canHandleDeepLink(access$getChangePaymentDeeplink$p, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            if (this.f59314i.changePaymentDeeplink.length() <= 0) {
                z11 = false;
            }
            if (z11) {
                DeepLinkNavigator deepLinkNavigator2 = this.f59314i.getDeepLinkNavigator();
                Context requireContext = this.f59314i.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                DeepLinkNavigator.DefaultImpls.navigateTo$default(deepLinkNavigator2, requireContext, this.f59314i.changePaymentDeeplink, (Function0) null, 4, (Object) null);
            }
        }
        return Unit.INSTANCE;
    }
}
