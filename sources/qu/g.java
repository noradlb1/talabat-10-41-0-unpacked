package qu;

import com.talabat.sidemenu.SideMenuInteractor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SideMenuInteractor f62849b;

    public /* synthetic */ g(SideMenuInteractor sideMenuInteractor) {
        this.f62849b = sideMenuInteractor;
    }

    public final void accept(Object obj) {
        SideMenuInteractor.m10902loadUserActiveVoucherCount$lambda4(this.f62849b, (Throwable) obj);
    }
}
