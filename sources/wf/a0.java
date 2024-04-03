package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class a0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsInteractor f57919b;

    public /* synthetic */ a0(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor) {
        this.f57919b = quickFilterRestaurantsInteractor;
    }

    public final Object apply(Object obj) {
        return QuickFilterRestaurantsInteractor.m9560handleCuisineSelection$lambda25(this.f57919b, (List) obj);
    }
}
