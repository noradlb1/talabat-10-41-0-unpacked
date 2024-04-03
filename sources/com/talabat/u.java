package com.talabat;

import android.view.View;
import com.talabat.RestaurantMenuScreenR;
import datamodels.MenuItem;

public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantMenuScreenR.MenuRecyclerViewAdapter f56685b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RestaurantMenuScreenR.MenuRecyclerViewAdapter.MenuItemViewHolder f56686c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MenuItem f56687d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f56688e;

    public /* synthetic */ u(RestaurantMenuScreenR.MenuRecyclerViewAdapter menuRecyclerViewAdapter, RestaurantMenuScreenR.MenuRecyclerViewAdapter.MenuItemViewHolder menuItemViewHolder, MenuItem menuItem, int i11) {
        this.f56685b = menuRecyclerViewAdapter;
        this.f56686c = menuItemViewHolder;
        this.f56687d = menuItem;
        this.f56688e = i11;
    }

    public final void onClick(View view) {
        this.f56685b.lambda$onBindViewHolder$2(this.f56686c, this.f56687d, this.f56688e, view);
    }
}
