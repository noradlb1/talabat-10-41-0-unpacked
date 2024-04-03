package qu;

import com.talabat.sidemenu.SideMenuInteractor;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public final /* synthetic */ class b implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideMenuInteractor f62844a;

    public /* synthetic */ b(SideMenuInteractor sideMenuInteractor) {
        this.f62844a = sideMenuInteractor;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        SideMenuInteractor.m10897loadRafSenderVoucherLabel$lambda10(this.f62844a, singleEmitter);
    }
}
