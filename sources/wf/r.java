package wf;

import JsonModels.Response.TermsResponse;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsListener;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class r implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsInteractor f57944b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsListener f57945c;

    public /* synthetic */ r(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, QuickFilterRestaurantsListener quickFilterRestaurantsListener) {
        this.f57944b = quickFilterRestaurantsInteractor;
        this.f57945c = quickFilterRestaurantsListener;
    }

    public final void accept(Object obj) {
        QuickFilterRestaurantsInteractor.m9556getTerms$lambda1(this.f57944b, this.f57945c, (TermsResponse) obj);
    }
}
