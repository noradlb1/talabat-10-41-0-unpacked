package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import io.reactivex.functions.Function;

public final /* synthetic */ class q implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsInteractor f57942b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57943c;

    public /* synthetic */ q(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, int i11) {
        this.f57942b = quickFilterRestaurantsInteractor;
        this.f57943c = i11;
    }

    public final Object apply(Object obj) {
        return QuickFilterRestaurantsInteractor.m9555getTerms$lambda0(this.f57942b, this.f57943c, (Integer) obj);
    }
}
