package ue;

import android.view.View;
import com.talabat.RestaurantMenuScreenR;
import datamodels.MenuItem;

public final /* synthetic */ class ud implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantMenuScreenR.MenuRecyclerViewAdapter f57783b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem f57784c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f57785d;

    public /* synthetic */ ud(RestaurantMenuScreenR.MenuRecyclerViewAdapter menuRecyclerViewAdapter, MenuItem menuItem, int i11) {
        this.f57783b = menuRecyclerViewAdapter;
        this.f57784c = menuItem;
        this.f57785d = i11;
    }

    public final void onClick(View view) {
        this.f57783b.lambda$onBindViewHolder$1(this.f57784c, this.f57785d, view);
    }
}
