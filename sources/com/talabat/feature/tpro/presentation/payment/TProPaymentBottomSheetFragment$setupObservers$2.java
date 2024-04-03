package com.talabat.feature.tpro.presentation.payment;

import androidx.fragment.app.FragmentActivity;
import com.talabat.feature.subscriptions.data.tracking.events.TProEvent;
import com.talabat.feature.subscriptions.domain.model.CurrencyAmount;
import com.talabat.feature.subscriptions.domain.model.FreeTrialInfo;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionType;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.feature.tpro.presentation.welcome.TProWelcomeBottomSheetFragment;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TProPaymentBottomSheetFragment$setupObservers$2 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TProPaymentBottomSheetFragment f59362g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TProPlanDisplayModel f59363h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProPaymentBottomSheetFragment$setupObservers$2(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment, TProPlanDisplayModel tProPlanDisplayModel) {
        super(1);
        this.f59362g = tProPaymentBottomSheetFragment;
        this.f59363h = tProPlanDisplayModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Boolean bool) {
        Map access$getParameters$p = this.f59362g.parameters;
        if (access$getParameters$p != null) {
            this.f59362g.firebaseTracker.sendEvent(TProEvent.NAME_SUBSCRIPTION_COMPLETED, access$getParameters$p);
        }
        Subscription subscription = new Subscription((String) null, false, false, (LocalDateTime) null, this.f59363h.getEndDate(), (SubscriptionType) null, new SubscriptionPlan((String) null, (String) null, (String) null, (String) null, 0, (String) null, false, 0.0f, false, (List) null, (CurrencyAmount) null, (FreeTrialInfo) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, this.f59363h.getCategory(), (SubscriptionCancellationType) null, (String) null, (String) null, (String) null, (String) null, this.f59363h.getRenewType(), (LocalDateTime) null, 50069503, (DefaultConstructorMarker) null), false, (List) null, 431, (DefaultConstructorMarker) null);
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            TProWelcomeBottomSheetFragment.Companion companion = TProWelcomeBottomSheetFragment.Companion;
            FragmentActivity requireActivity = this.f59362g.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.showForShahid(requireActivity, subscription, true);
        }
    }
}
