package gt;

import android.view.View;
import com.talabat.restaurants.tmart.DarkstoreEntryView;
import datamodels.Restaurant;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Restaurant f62118b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DarkstoreEntryView f62119c;

    public /* synthetic */ a(Restaurant restaurant, DarkstoreEntryView darkstoreEntryView) {
        this.f62118b = restaurant;
        this.f62119c = darkstoreEntryView;
    }

    public final void onClick(View view) {
        DarkstoreEntryView.m10728darkstoreSuccess$lambda1(this.f62118b, this.f62119c, view);
    }
}
