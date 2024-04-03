package com.talabat;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.GroceryDetailsViewScreen;
import datamodels.MenuItem;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuItem f56644b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen f56645c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen.ItemListAdapter f56646d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f56647e;

    public /* synthetic */ e(MenuItem menuItem, GroceryDetailsViewScreen groceryDetailsViewScreen, GroceryDetailsViewScreen.ItemListAdapter itemListAdapter, RecyclerView.ViewHolder viewHolder) {
        this.f56644b = menuItem;
        this.f56645c = groceryDetailsViewScreen;
        this.f56646d = itemListAdapter;
        this.f56647e = viewHolder;
    }

    public final void onClick(View view) {
        GroceryDetailsViewScreen.ItemListAdapter.m9455onBindViewHolder$lambda6$lambda4(this.f56644b, this.f56645c, this.f56646d, this.f56647e, view);
    }
}
