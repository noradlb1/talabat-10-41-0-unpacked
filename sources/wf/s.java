package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsListener;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class s implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsInteractor f57946b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsListener f57947c;

    public /* synthetic */ s(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, QuickFilterRestaurantsListener quickFilterRestaurantsListener) {
        this.f57946b = quickFilterRestaurantsInteractor;
        this.f57947c = quickFilterRestaurantsListener;
    }

    public final void accept(Object obj) {
        QuickFilterRestaurantsInteractor.m9557getTerms$lambda2(this.f57946b, this.f57947c, (Throwable) obj);
    }
}
