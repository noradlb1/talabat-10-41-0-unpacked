package wf;

import JsonModels.Response.Darkstores.DarkStoresEntryPointResponse;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsListener;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class l implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsListener f57938b;

    public /* synthetic */ l(QuickFilterRestaurantsListener quickFilterRestaurantsListener) {
        this.f57938b = quickFilterRestaurantsListener;
    }

    public final void accept(Object obj) {
        QuickFilterRestaurantsInteractor.m9550getDarkStoresInfo$lambda5(this.f57938b, (DarkStoresEntryPointResponse) obj);
    }
}
