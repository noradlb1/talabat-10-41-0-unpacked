package bf;

import android.view.View;
import com.talabat.adapters.restaurantslist.SearchRestaurantsAdapter;
import datamodels.Restaurant;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchRestaurantsAdapter f50851b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f50852c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f50853d;

    public /* synthetic */ g(SearchRestaurantsAdapter searchRestaurantsAdapter, Restaurant restaurant, int i11) {
        this.f50851b = searchRestaurantsAdapter;
        this.f50852c = restaurant;
        this.f50853d = i11;
    }

    public final void onClick(View view) {
        this.f50851b.lambda$onBindViewHolder$0(this.f50852c, this.f50853d, view);
    }
}
