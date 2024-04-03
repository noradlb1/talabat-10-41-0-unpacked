package com.talabat.adapters.grocery;

import android.view.View;
import com.talabat.adapters.grocery.GroceryMenuSearchAdapter;
import datamodels.MenuItem;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuSearchAdapter f55279b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem f55280c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuSearchAdapter.MenuViewHolder f55281d;

    public /* synthetic */ d(GroceryMenuSearchAdapter groceryMenuSearchAdapter, MenuItem menuItem, GroceryMenuSearchAdapter.MenuViewHolder menuViewHolder) {
        this.f55279b = groceryMenuSearchAdapter;
        this.f55280c = menuItem;
        this.f55281d = menuViewHolder;
    }

    public final void onClick(View view) {
        this.f55279b.lambda$onBindViewHolder$3(this.f55280c, this.f55281d, view);
    }
}
