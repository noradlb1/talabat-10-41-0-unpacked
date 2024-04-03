package com.talabat.wallet.ui.subscriptionManagement.view.fragment;

import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionDetailFragment$observatory$5 extends Lambda implements Function1<SubscriptionSavingsInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubscriptionDetailFragment f12731g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionDetailFragment$observatory$5(SubscriptionDetailFragment subscriptionDetailFragment) {
        super(1);
        this.f12731g = subscriptionDetailFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SubscriptionSavingsInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable SubscriptionSavingsInfo subscriptionSavingsInfo) {
        this.f12731g.enableCancelSubscriptionButton(true);
    }
}
