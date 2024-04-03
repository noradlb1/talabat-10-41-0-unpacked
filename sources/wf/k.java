package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import io.reactivex.functions.Function;
import kotlin.Triple;

public final /* synthetic */ class k implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsInteractor f57937b;

    public /* synthetic */ k(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor) {
        this.f57937b = quickFilterRestaurantsInteractor;
    }

    public final Object apply(Object obj) {
        return QuickFilterRestaurantsInteractor.m9549getDarkStoresInfo$lambda4(this.f57937b, (Triple) obj);
    }
}
