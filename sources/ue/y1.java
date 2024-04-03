package ue;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.CartScreen;
import datamodels.CartMenuItem;

public final /* synthetic */ class y1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen.CartRecyclerviewAdapter f57833b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CartMenuItem f57834c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f57835d;

    public /* synthetic */ y1(CartScreen.CartRecyclerviewAdapter cartRecyclerviewAdapter, CartMenuItem cartMenuItem, RecyclerView.ViewHolder viewHolder) {
        this.f57833b = cartRecyclerviewAdapter;
        this.f57834c = cartMenuItem;
        this.f57835d = viewHolder;
    }

    public final void onClick(View view) {
        this.f57833b.lambda$onBindViewHolder$1(this.f57834c, this.f57835d, view);
    }
}
