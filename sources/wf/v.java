package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class v implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsInteractor f57949b;

    public /* synthetic */ v(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor) {
        this.f57949b = quickFilterRestaurantsInteractor;
    }

    public final Object apply(Object obj) {
        return QuickFilterRestaurantsInteractor.m9565handleFilterSelection$lambda20(this.f57949b, (List) obj);
    }
}
