package ue;

import android.view.View;
import com.talabat.CartScreen;
import datamodels.Promotion;

public final /* synthetic */ class e2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen.CartRecyclerviewAdapter f57500b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Promotion f57501c;

    public /* synthetic */ e2(CartScreen.CartRecyclerviewAdapter cartRecyclerviewAdapter, Promotion promotion) {
        this.f57500b = cartRecyclerviewAdapter;
        this.f57501c = promotion;
    }

    public final void onClick(View view) {
        this.f57500b.lambda$onBindViewHolder$7(this.f57501c, view);
    }
}
