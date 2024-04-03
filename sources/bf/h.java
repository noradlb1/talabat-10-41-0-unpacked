package bf;

import android.view.View;
import com.talabat.adapters.restaurantslist.SwimlaneRestaurantsAdapter;
import datamodels.Restaurant;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwimlaneRestaurantsAdapter f50854b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f50855c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f50856d;

    public /* synthetic */ h(SwimlaneRestaurantsAdapter swimlaneRestaurantsAdapter, Restaurant restaurant, int i11) {
        this.f50854b = swimlaneRestaurantsAdapter;
        this.f50855c = restaurant;
        this.f50856d = i11;
    }

    public final void onClick(View view) {
        this.f50854b.lambda$restaurantClickListener$0(this.f50855c, this.f50856d, view);
    }
}
