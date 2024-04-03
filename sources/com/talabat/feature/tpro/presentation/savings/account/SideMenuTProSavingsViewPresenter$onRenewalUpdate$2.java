package com.talabat.feature.tpro.presentation.savings.account;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SideMenuTProSavingsViewPresenter$onRenewalUpdate$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f59408g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProSavingsViewPresenter f59409h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProSavingsViewPresenter$onRenewalUpdate$2(boolean z11, SideMenuTProSavingsViewPresenter sideMenuTProSavingsViewPresenter) {
        super(0);
        this.f59408g = z11;
        this.f59409h = sideMenuTProSavingsViewPresenter;
    }

    public final void invoke() {
        if (this.f59408g) {
            this.f59409h.trackReactivateSuccess();
        }
        this.f59409h.onUpdateRenewalResult.invoke(Boolean.valueOf(this.f59408g));
    }
}
