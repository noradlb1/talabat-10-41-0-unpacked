package qu;

import com.talabat.sidemenu.SideMenuInteractor;
import io.reactivex.functions.Consumer;
import library.talabat.mvp.home.VoucherStateDomainModel;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SideMenuInteractor f62848b;

    public /* synthetic */ f(SideMenuInteractor sideMenuInteractor) {
        this.f62848b = sideMenuInteractor;
    }

    public final void accept(Object obj) {
        SideMenuInteractor.m10901loadUserActiveVoucherCount$lambda3(this.f62848b, (VoucherStateDomainModel) obj);
    }
}
