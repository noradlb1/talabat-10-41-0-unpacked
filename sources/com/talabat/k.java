package com.talabat;

import android.view.View;
import com.talabat.GroceryMenuScreen;
import datamodels.MenuItem;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen.GroceryRowAdapter f56660b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem f56661c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen.GroceryRowAdapter.GroceryRowListViewHolder f56662d;

    public /* synthetic */ k(GroceryMenuScreen.GroceryRowAdapter groceryRowAdapter, MenuItem menuItem, GroceryMenuScreen.GroceryRowAdapter.GroceryRowListViewHolder groceryRowListViewHolder) {
        this.f56660b = groceryRowAdapter;
        this.f56661c = menuItem;
        this.f56662d = groceryRowListViewHolder;
    }

    public final void onClick(View view) {
        this.f56660b.lambda$onBindViewHolder$2(this.f56661c, this.f56662d, view);
    }
}
