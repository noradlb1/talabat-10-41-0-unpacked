package com.talabat.feature.tpro.presentation.savings.account;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SideMenuTProSavingsViewPresenter$bindData$2$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProSavingsViewHolder f59400g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SubscriptionSavingsInfo f59401h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LocationConfigurationRepository f59402i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProSavingsViewPresenter$bindData$2$1(SideMenuTProSavingsViewHolder sideMenuTProSavingsViewHolder, SubscriptionSavingsInfo subscriptionSavingsInfo, LocationConfigurationRepository locationConfigurationRepository) {
        super(0);
        this.f59400g = sideMenuTProSavingsViewHolder;
        this.f59401h = subscriptionSavingsInfo;
        this.f59402i = locationConfigurationRepository;
    }

    public final void invoke() {
        this.f59400g.bindSavingsInfo(this.f59401h, this.f59402i);
    }
}
