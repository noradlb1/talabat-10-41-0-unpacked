package com.talabat;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.GroceryDetailsViewScreen;
import datamodels.MenuItem;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen f56095b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem f56096c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f56097d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen.ItemListAdapter f56098e;

    public /* synthetic */ d(GroceryDetailsViewScreen groceryDetailsViewScreen, MenuItem menuItem, RecyclerView.ViewHolder viewHolder, GroceryDetailsViewScreen.ItemListAdapter itemListAdapter) {
        this.f56095b = groceryDetailsViewScreen;
        this.f56096c = menuItem;
        this.f56097d = viewHolder;
        this.f56098e = itemListAdapter;
    }

    public final void onClick(View view) {
        GroceryDetailsViewScreen.ItemListAdapter.m9454onBindViewHolder$lambda6$lambda3(this.f56095b, this.f56096c, this.f56097d, this.f56098e, view);
    }
}
