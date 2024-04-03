package com.talabat;

import android.view.View;
import com.talabat.GroceryMenuScreen;
import datamodels.MenuItem;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen.GroceryRowAdapter f56663b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem f56664c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen.GroceryRowAdapter.GroceryRowListViewHolder f56665d;

    public /* synthetic */ l(GroceryMenuScreen.GroceryRowAdapter groceryRowAdapter, MenuItem menuItem, GroceryMenuScreen.GroceryRowAdapter.GroceryRowListViewHolder groceryRowListViewHolder) {
        this.f56663b = groceryRowAdapter;
        this.f56664c = menuItem;
        this.f56665d = groceryRowListViewHolder;
    }

    public final void onClick(View view) {
        this.f56663b.lambda$onBindViewHolder$3(this.f56664c, this.f56665d, view);
    }
}
