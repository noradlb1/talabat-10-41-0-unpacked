package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class z implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsInteractor f57953b;

    public /* synthetic */ z(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor) {
        this.f57953b = quickFilterRestaurantsInteractor;
    }

    public final Object apply(Object obj) {
        return QuickFilterRestaurantsInteractor.m9559handleCuisineSelection$lambda24(this.f57953b, (List) obj);
    }
}
