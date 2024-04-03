package com.talabat.feature.tpro.presentation.benefits;

import androidx.fragment.app.FragmentActivity;
import com.talabat.core.navigation.domain.screen.tpro.TproBenefitsScreen;
import com.talabat.feature.tpro.presentation.model.TProMultiPlanDisplayModel;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.feature.tpro.presentation.multiplan.TProPlanSelectionFragment;
import com.tracking.TrackerKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TproBenefitsFragment$displayPlanBenefitsForMultiplan$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsFragment f59250g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TProMultiPlanDisplayModel f59251h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproBenefitsFragment$displayPlanBenefitsForMultiplan$2(TproBenefitsFragment tproBenefitsFragment, TProMultiPlanDisplayModel tProMultiPlanDisplayModel) {
        super(0);
        this.f59250g = tproBenefitsFragment;
        this.f59251h = tProMultiPlanDisplayModel;
    }

    public final void invoke() {
        Map access$getParameters$p = this.f59250g.parameters;
        String access$getSubscriptionCode = this.f59250g.getSubscriptionCode();
        if (access$getSubscriptionCode == null) {
            access$getSubscriptionCode = "";
        }
        TrackerKt.addParameter(access$getParameters$p, TproBenefitsFragment.APPLIED_VOUCHER_CODE, access$getSubscriptionCode);
        this.f59250g.firebaseTracker.sendEvent("subscription_started_clicked", this.f59250g.parameters);
        if (this.f59251h.getPlans().size() > 1) {
            TProPlanSelectionFragment.Companion companion = TProPlanSelectionFragment.Companion;
            FragmentActivity requireActivity = this.f59250g.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            TProMultiPlanDisplayModel tProMultiPlanDisplayModel = this.f59251h;
            TproBenefitsScreen.TproBenefitsData access$getDeeplinkData = this.f59250g.getDeeplinkData();
            boolean isReactivate = access$getDeeplinkData != null ? access$getDeeplinkData.isReactivate() : false;
            final TproBenefitsFragment tproBenefitsFragment = this.f59250g;
            companion.show(requireActivity, tProMultiPlanDisplayModel, isReactivate, new Function1<TProPlanDisplayModel, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((TProPlanDisplayModel) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull TProPlanDisplayModel tProPlanDisplayModel) {
                    Intrinsics.checkNotNullParameter(tProPlanDisplayModel, "selectedPlan");
                    tproBenefitsFragment.showPaymentScreen(tProPlanDisplayModel);
                }
            });
        } else if (this.f59250g.getShahidPlanActive((TProPlanDisplayModel) CollectionsKt___CollectionsKt.first(this.f59251h.getPlans()))) {
            this.f59250g.showPaymentScreen((TProPlanDisplayModel) CollectionsKt___CollectionsKt.first(this.f59251h.getPlans()));
        } else if (this.f59250g.getSubscriptionCode() == null || !this.f59250g.isB2B()) {
            this.f59250g.showPaymentScreen((TProPlanDisplayModel) CollectionsKt___CollectionsKt.first(this.f59251h.getPlans()));
        } else {
            String access$getSubscriptionCode2 = this.f59250g.getSubscriptionCode();
            if (access$getSubscriptionCode2 != null) {
                TproBenefitsFragment tproBenefitsFragment2 = this.f59250g;
                tproBenefitsFragment2.showProgressBar(true);
                tproBenefitsFragment2.getViewModel().subscribeWithB2BVoucher(access$getSubscriptionCode2);
            }
        }
    }
}
