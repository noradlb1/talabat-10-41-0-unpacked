package j10;

import io.reactivex.functions.Action;
import library.talabat.mvp.homemap.HomeMapInteractor;

public final /* synthetic */ class a implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMapInteractor f24345b;

    public /* synthetic */ a(HomeMapInteractor homeMapInteractor) {
        this.f24345b = homeMapInteractor;
    }

    public final void run() {
        HomeMapInteractor.m7885loadAppinitCountrySpecficData$lambda3(this.f24345b);
    }
}
