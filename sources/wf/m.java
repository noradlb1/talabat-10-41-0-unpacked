package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsListener;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class m implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsListener f57939b;

    public /* synthetic */ m(QuickFilterRestaurantsListener quickFilterRestaurantsListener) {
        this.f57939b = quickFilterRestaurantsListener;
    }

    public final void accept(Object obj) {
        QuickFilterRestaurantsInteractor.m9551getDarkStoresInfo$lambda6(this.f57939b, (Throwable) obj);
    }
}
