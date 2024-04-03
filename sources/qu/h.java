package qu;

import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.sidemenu.SideMenuInteractor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SideMenuInteractor f62850b;

    public /* synthetic */ h(SideMenuInteractor sideMenuInteractor) {
        this.f62850b = sideMenuInteractor;
    }

    public final void accept(Object obj) {
        SideMenuInteractor.m10896loadBnplOverdues$lambda6(this.f62850b, (GetOverdueUseCase.OverdueResult) obj);
    }
}
