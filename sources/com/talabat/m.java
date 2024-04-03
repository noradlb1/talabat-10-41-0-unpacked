package com.talabat;

import android.view.View;
import com.talabat.GroceryMenuScreen;
import datamodels.MenuItem;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen.GroceryRowAdapter f56666b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem f56667c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen.GroceryRowAdapter.GroceryRowListViewHolder f56668d;

    public /* synthetic */ m(GroceryMenuScreen.GroceryRowAdapter groceryRowAdapter, MenuItem menuItem, GroceryMenuScreen.GroceryRowAdapter.GroceryRowListViewHolder groceryRowListViewHolder) {
        this.f56666b = groceryRowAdapter;
        this.f56667c = menuItem;
        this.f56668d = groceryRowListViewHolder;
    }

    public final void onClick(View view) {
        this.f56666b.lambda$onBindViewHolder$4(this.f56667c, this.f56668d, view);
    }
}
