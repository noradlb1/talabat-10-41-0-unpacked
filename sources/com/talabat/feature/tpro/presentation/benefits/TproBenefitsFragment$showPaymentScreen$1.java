package com.talabat.feature.tpro.presentation.benefits;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.navigation.domain.screen.tpro.TproBenefitsScreen;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragmentKt;
import java.util.Map;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment$showPaymentScreen$1", f = "TproBenefitsFragment.kt", i = {}, l = {325}, m = "invokeSuspend", n = {}, s = {})
public final class TproBenefitsFragment$showPaymentScreen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59253h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsFragment f59254i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f59255j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TProPlanDisplayModel f59256k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproBenefitsFragment$showPaymentScreen$1(TproBenefitsFragment tproBenefitsFragment, String str, TProPlanDisplayModel tProPlanDisplayModel, Continuation<? super TproBenefitsFragment$showPaymentScreen$1> continuation) {
        super(2, continuation);
        this.f59254i = tproBenefitsFragment;
        this.f59255j = str;
        this.f59256k = tProPlanDisplayModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TproBenefitsFragment$showPaymentScreen$1(this.f59254i, this.f59255j, this.f59256k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TproBenefitsFragment$showPaymentScreen$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59253h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DeepLinkNavigator deepLinkNavigator = this.f59254i.getDeepLinkNavigator();
            String str = this.f59255j;
            this.f59253h = 1;
            obj = deepLinkNavigator.canHandleDeepLink(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            DeepLinkNavigator deepLinkNavigator2 = this.f59254i.getDeepLinkNavigator();
            Context requireContext = this.f59254i.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            DeepLinkNavigator.DefaultImpls.navigateTo$default(deepLinkNavigator2, requireContext, this.f59254i.subscriptionPaymentDeeplinkBuilder.build(this.f59256k.getPlanId(), this.f59254i.getSubscriptionCode(), TproBenefitsFragmentKt.BENEFIT_STRATEGY), (Function0) null, 4, (Object) null);
        } else {
            IObservabilityManager observabilityManager = this.f59254i.getObservabilityManager();
            String str2 = this.f59255j;
            IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(observabilityManager, "TproBenefitsFragment - Failed to handle deeplink: " + str2, (Map) null, 2, (Object) null);
            FragmentActivity requireActivity = this.f59254i.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            TProPlanDisplayModel tProPlanDisplayModel = this.f59256k;
            TproBenefitsScreen.TproBenefitsData access$getDeeplinkData = this.f59254i.getDeeplinkData();
            if (access$getDeeplinkData != null) {
                z11 = access$getDeeplinkData.isReactivate();
            } else {
                z11 = false;
            }
            TProPaymentBottomSheetFragmentKt.showPaymentBottomSheet(requireActivity, tProPlanDisplayModel, z11, this.f59254i.getSubscriptionCode());
        }
        return Unit.INSTANCE;
    }
}
