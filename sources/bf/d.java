package bf;

import android.view.View;
import com.talabat.adapters.restaurantslist.RestaurantsListAdapterRefactor;
import library.talabat.inlineadsengine.AdsWrapper;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsListAdapterRefactor f50847b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdsWrapper f50848c;

    public /* synthetic */ d(RestaurantsListAdapterRefactor restaurantsListAdapterRefactor, AdsWrapper adsWrapper) {
        this.f50847b = restaurantsListAdapterRefactor;
        this.f50848c = adsWrapper;
    }

    public final void onClick(View view) {
        this.f50847b.lambda$onBindViewHolder$2(this.f50848c, view);
    }
}
