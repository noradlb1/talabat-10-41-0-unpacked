package com.talabat;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.GroceryDetailsViewScreen;
import datamodels.MenuItem;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f55526b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen f55527c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MenuItem f55528d;

    public /* synthetic */ c(RecyclerView.ViewHolder viewHolder, GroceryDetailsViewScreen groceryDetailsViewScreen, MenuItem menuItem) {
        this.f55526b = viewHolder;
        this.f55527c = groceryDetailsViewScreen;
        this.f55528d = menuItem;
    }

    public final void onClick(View view) {
        GroceryDetailsViewScreen.ItemListAdapter.m9453onBindViewHolder$lambda6$lambda2(this.f55526b, this.f55527c, this.f55528d, view);
    }
}
