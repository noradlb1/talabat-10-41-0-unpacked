package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class w implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsInteractor f57950b;

    public /* synthetic */ w(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor) {
        this.f57950b = quickFilterRestaurantsInteractor;
    }

    public final Object apply(Object obj) {
        return QuickFilterRestaurantsInteractor.m9566handleFilterSelection$lambda21(this.f57950b, (List) obj);
    }
}
