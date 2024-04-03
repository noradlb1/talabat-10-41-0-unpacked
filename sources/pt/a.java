package pt;

import com.talabat.restaurants.v2.domain.vendors.GetInlineAdsUseCase;
import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f62810b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f62811c;

    public /* synthetic */ a(List list, List list2) {
        this.f62810b = list;
        this.f62811c = list2;
    }

    public final Object call() {
        return GetInlineAdsUseCase.m10746invoke$lambda8$lambda5$lambda4(this.f62810b, this.f62811c);
    }
}
