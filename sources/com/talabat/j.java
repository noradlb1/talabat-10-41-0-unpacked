package com.talabat;

import android.view.View;
import com.talabat.GroceryMenuScreen;
import datamodels.MenuItem;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen.GroceryRowAdapter f56657b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen.GroceryRowAdapter.GroceryRowListViewHolder f56658c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MenuItem f56659d;

    public /* synthetic */ j(GroceryMenuScreen.GroceryRowAdapter groceryRowAdapter, GroceryMenuScreen.GroceryRowAdapter.GroceryRowListViewHolder groceryRowListViewHolder, MenuItem menuItem) {
        this.f56657b = groceryRowAdapter;
        this.f56658c = groceryRowListViewHolder;
        this.f56659d = menuItem;
    }

    public final void onClick(View view) {
        this.f56657b.lambda$onBindViewHolder$1(this.f56658c, this.f56659d, view);
    }
}
