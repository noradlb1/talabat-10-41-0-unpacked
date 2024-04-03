package com.talabat;

import android.view.View;
import com.talabat.GroceryMenuScreen;
import datamodels.MenuItem;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen.GroceryRowAdapter f56654b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen.GroceryRowAdapter.GroceryRowListViewHolder f56655c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MenuItem f56656d;

    public /* synthetic */ i(GroceryMenuScreen.GroceryRowAdapter groceryRowAdapter, GroceryMenuScreen.GroceryRowAdapter.GroceryRowListViewHolder groceryRowListViewHolder, MenuItem menuItem) {
        this.f56654b = groceryRowAdapter;
        this.f56655c = groceryRowListViewHolder;
        this.f56656d = menuItem;
    }

    public final void onClick(View view) {
        this.f56654b.lambda$onBindViewHolder$0(this.f56655c, this.f56656d, view);
    }
}
