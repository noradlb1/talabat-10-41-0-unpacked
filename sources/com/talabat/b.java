package com.talabat;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.GroceryDetailsViewScreen;
import datamodels.MenuItem;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen f55522b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem f55523c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f55524d;

    public /* synthetic */ b(GroceryDetailsViewScreen groceryDetailsViewScreen, MenuItem menuItem, RecyclerView.ViewHolder viewHolder) {
        this.f55522b = groceryDetailsViewScreen;
        this.f55523c = menuItem;
        this.f55524d = viewHolder;
    }

    public final void onClick(View view) {
        GroceryDetailsViewScreen.ItemListAdapter.m9452onBindViewHolder$lambda6$lambda1(this.f55522b, this.f55523c, this.f55524d, view);
    }
}
