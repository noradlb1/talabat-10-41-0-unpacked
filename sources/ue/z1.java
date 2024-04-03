package ue;

import android.view.View;
import com.talabat.CartScreen;
import datamodels.CartMenuItem;

public final /* synthetic */ class z1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen.CartRecyclerviewAdapter f57851b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CartMenuItem f57852c;

    public /* synthetic */ z1(CartScreen.CartRecyclerviewAdapter cartRecyclerviewAdapter, CartMenuItem cartMenuItem) {
        this.f57851b = cartRecyclerviewAdapter;
        this.f57852c = cartMenuItem;
    }

    public final void onClick(View view) {
        this.f57851b.lambda$onBindViewHolder$2(this.f57852c, view);
    }
}
