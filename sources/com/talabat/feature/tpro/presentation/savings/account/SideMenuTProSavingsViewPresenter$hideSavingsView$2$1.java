package com.talabat.feature.tpro.presentation.savings.account;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SideMenuTProSavingsViewPresenter$hideSavingsView$2$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProSavingsViewHolder f59407g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProSavingsViewPresenter$hideSavingsView$2$1(SideMenuTProSavingsViewHolder sideMenuTProSavingsViewHolder) {
        super(0);
        this.f59407g = sideMenuTProSavingsViewHolder;
    }

    public final void invoke() {
        this.f59407g.setSavingsViewVisibility(false);
    }
}
