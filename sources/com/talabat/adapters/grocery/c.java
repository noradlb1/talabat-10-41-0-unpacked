package com.talabat.adapters.grocery;

import android.view.View;
import com.talabat.adapters.grocery.GroceryMenuSearchAdapter;
import datamodels.MenuItem;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuSearchAdapter f55275b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f55276c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuSearchAdapter.MenuViewHolder f55277d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MenuItem f55278e;

    public /* synthetic */ c(GroceryMenuSearchAdapter groceryMenuSearchAdapter, int i11, GroceryMenuSearchAdapter.MenuViewHolder menuViewHolder, MenuItem menuItem) {
        this.f55275b = groceryMenuSearchAdapter;
        this.f55276c = i11;
        this.f55277d = menuViewHolder;
        this.f55278e = menuItem;
    }

    public final void onClick(View view) {
        this.f55275b.lambda$onBindViewHolder$2(this.f55276c, this.f55277d, this.f55278e, view);
    }
}
