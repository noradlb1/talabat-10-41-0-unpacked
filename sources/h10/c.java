package h10;

import io.reactivex.functions.Action;
import library.talabat.mvp.home.HomeView;

public final /* synthetic */ class c implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeView f24332b;

    public /* synthetic */ c(HomeView homeView) {
        this.f24332b = homeView;
    }

    public final void run() {
        this.f24332b.userAccountClicked();
    }
}
