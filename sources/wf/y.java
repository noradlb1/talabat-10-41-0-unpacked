package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class y implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsInteractor f57952b;

    public /* synthetic */ y(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor) {
        this.f57952b = quickFilterRestaurantsInteractor;
    }

    public final Object apply(Object obj) {
        return QuickFilterRestaurantsInteractor.m9558handleCuisineSelection$lambda23(this.f57952b, (List) obj);
    }
}
