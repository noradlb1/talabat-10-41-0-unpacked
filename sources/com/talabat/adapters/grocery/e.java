package com.talabat.adapters.grocery;

import android.view.View;
import com.talabat.adapters.grocery.GroceryMenuSearchAdapter;
import datamodels.MenuItem;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuSearchAdapter f55282b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem f55283c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f55284d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuSearchAdapter.MenuViewHolder f55285e;

    public /* synthetic */ e(GroceryMenuSearchAdapter groceryMenuSearchAdapter, MenuItem menuItem, int i11, GroceryMenuSearchAdapter.MenuViewHolder menuViewHolder) {
        this.f55282b = groceryMenuSearchAdapter;
        this.f55283c = menuItem;
        this.f55284d = i11;
        this.f55285e = menuViewHolder;
    }

    public final void onClick(View view) {
        this.f55282b.lambda$onBindViewHolder$4(this.f55283c, this.f55284d, this.f55285e, view);
    }
}
