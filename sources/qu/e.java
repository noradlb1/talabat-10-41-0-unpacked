package qu;

import com.talabat.sidemenu.SideMenuInteractor;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public final /* synthetic */ class e implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideMenuInteractor f62847a;

    public /* synthetic */ e(SideMenuInteractor sideMenuInteractor) {
        this.f62847a = sideMenuInteractor;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        SideMenuInteractor.m10900loadUserActiveVoucherCount$lambda2(this.f62847a, singleEmitter);
    }
}
