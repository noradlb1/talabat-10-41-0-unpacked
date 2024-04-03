package j10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.homemap.HomeMapInteractor;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMapInteractor f24346b;

    public /* synthetic */ b(HomeMapInteractor homeMapInteractor) {
        this.f24346b = homeMapInteractor;
    }

    public final void accept(Object obj) {
        HomeMapInteractor.m7886loadAppinitCountrySpecficData$lambda4(this.f24346b, (Throwable) obj);
    }
}
