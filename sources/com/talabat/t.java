package com.talabat;

import android.view.View;
import com.talabat.RestaurantMenuScreenR;
import datamodels.MenuItem;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantMenuScreenR.MenuRecyclerViewAdapter f56681b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem f56682c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RestaurantMenuScreenR.MenuRecyclerViewAdapter.MenuItemViewHolder f56683d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f56684e;

    public /* synthetic */ t(RestaurantMenuScreenR.MenuRecyclerViewAdapter menuRecyclerViewAdapter, MenuItem menuItem, RestaurantMenuScreenR.MenuRecyclerViewAdapter.MenuItemViewHolder menuItemViewHolder, int i11) {
        this.f56681b = menuRecyclerViewAdapter;
        this.f56682c = menuItem;
        this.f56683d = menuItemViewHolder;
        this.f56684e = i11;
    }

    public final void onClick(View view) {
        this.f56681b.lambda$onBindViewHolder$0(this.f56682c, this.f56683d, this.f56684e, view);
    }
}
