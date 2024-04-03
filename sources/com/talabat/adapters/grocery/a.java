package com.talabat.adapters.grocery;

import android.view.View;
import com.talabat.adapters.grocery.GroceryMenuSearchAdapter;
import datamodels.MenuItem;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuSearchAdapter f55269b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuSearchAdapter.MenuViewHolder f55270c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MenuItem f55271d;

    public /* synthetic */ a(GroceryMenuSearchAdapter groceryMenuSearchAdapter, GroceryMenuSearchAdapter.MenuViewHolder menuViewHolder, MenuItem menuItem) {
        this.f55269b = groceryMenuSearchAdapter;
        this.f55270c = menuViewHolder;
        this.f55271d = menuItem;
    }

    public final void onClick(View view) {
        this.f55269b.lambda$onBindViewHolder$0(this.f55270c, this.f55271d, view);
    }
}
