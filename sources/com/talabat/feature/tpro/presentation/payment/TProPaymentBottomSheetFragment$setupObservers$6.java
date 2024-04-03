package com.talabat.feature.tpro.presentation.payment;

import com.talabat.feature.subscriptions.domain.model.SubscriptionOTPPaymentStatus;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionOTPPaymentStatus;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TProPaymentBottomSheetFragment$setupObservers$6 extends Lambda implements Function1<SubscriptionOTPPaymentStatus, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TProPaymentBottomSheetFragment f59367g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TProPlanDisplayModel f59368h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProPaymentBottomSheetFragment$setupObservers$6(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment, TProPlanDisplayModel tProPlanDisplayModel) {
        super(1);
        this.f59367g = tProPaymentBottomSheetFragment;
        this.f59368h = tProPlanDisplayModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SubscriptionOTPPaymentStatus) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable SubscriptionOTPPaymentStatus subscriptionOTPPaymentStatus) {
        this.f59367g.showProgresses(false);
        this.f59367g.trackSubscriptionSuccess(this.f59368h);
        this.f59367g.handleOtpResponse(subscriptionOTPPaymentStatus);
    }
}
