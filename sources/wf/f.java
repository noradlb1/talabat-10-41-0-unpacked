package wf;

import android.view.View;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsActivity;
import datamodels.Restaurant;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsActivity f57930b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f57931c;

    public /* synthetic */ f(QuickFilterRestaurantsActivity quickFilterRestaurantsActivity, Restaurant restaurant) {
        this.f57930b = quickFilterRestaurantsActivity;
        this.f57931c = restaurant;
    }

    public final void onClick(View view) {
        this.f57930b.lambda$darkstoreSuccess$2(this.f57931c, view);
    }
}
