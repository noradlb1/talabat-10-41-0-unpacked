package com.talabat.adapters.grocery;

import android.view.View;
import com.talabat.adapters.grocery.GroceryMenuSearchAdapter;
import datamodels.MenuItem;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuSearchAdapter f55272b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem f55273c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuSearchAdapter.MenuViewHolder f55274d;

    public /* synthetic */ b(GroceryMenuSearchAdapter groceryMenuSearchAdapter, MenuItem menuItem, GroceryMenuSearchAdapter.MenuViewHolder menuViewHolder) {
        this.f55272b = groceryMenuSearchAdapter;
        this.f55273c = menuItem;
        this.f55274d = menuViewHolder;
    }

    public final void onClick(View view) {
        this.f55272b.lambda$onBindViewHolder$1(this.f55273c, this.f55274d, view);
    }
}
