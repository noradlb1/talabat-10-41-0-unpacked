package qu;

import com.talabat.sidemenu.SideMenuInteractor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SideMenuInteractor f62851b;

    public /* synthetic */ i(SideMenuInteractor sideMenuInteractor) {
        this.f62851b = sideMenuInteractor;
    }

    public final void accept(Object obj) {
        this.f62851b.trackUnExpectedBnplScenario((Throwable) obj);
    }
}
