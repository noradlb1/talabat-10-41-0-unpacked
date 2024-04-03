package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class i implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsInteractor f57936b;

    public /* synthetic */ i(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor) {
        this.f57936b = quickFilterRestaurantsInteractor;
    }

    public final Object apply(Object obj) {
        return QuickFilterRestaurantsInteractor.m9562handleFilterSelection$lambda14(this.f57936b, (List) obj);
    }
}
