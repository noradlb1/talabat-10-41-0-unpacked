package com.talabat.userandlocation.choosecountry.di.module;

import android.content.Context;
import buisnessmodels.Customer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import library.talabat.mvp.homemap.HomeMapTemp;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DomainModule$provideOnUserChooseCountryUseCase$9 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f12213g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DomainModule$provideOnUserChooseCountryUseCase$9(Context context) {
        super(0);
        this.f12213g = context;
    }

    public final void invoke() {
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        homeMapTemp.resetPref(this.f12213g);
        homeMapTemp.recentRecentLocation();
        if (Customer.getInstance().isLoggedIn() && Customer.getInstance().getSelectedCustomerAddress() != null) {
            Customer.getInstance().deselectCustomerAddress();
        }
    }
}
