package com.talabat;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.GroceryDetailsViewScreen;
import datamodels.MenuItem;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuItem f56648b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen f56649c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f56650d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen.ItemListAdapter f56651e;

    public /* synthetic */ f(MenuItem menuItem, GroceryDetailsViewScreen groceryDetailsViewScreen, RecyclerView.ViewHolder viewHolder, GroceryDetailsViewScreen.ItemListAdapter itemListAdapter) {
        this.f56648b = menuItem;
        this.f56649c = groceryDetailsViewScreen;
        this.f56650d = viewHolder;
        this.f56651e = itemListAdapter;
    }

    public final void onClick(View view) {
        GroceryDetailsViewScreen.ItemListAdapter.m9456onBindViewHolder$lambda6$lambda5(this.f56648b, this.f56649c, this.f56650d, this.f56651e, view);
    }
}
