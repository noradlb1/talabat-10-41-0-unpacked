package ue;

import android.view.View;
import com.talabat.CartScreen;
import datamodels.Promotion;

public final /* synthetic */ class d2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen.CartRecyclerviewAdapter f57482b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Promotion f57483c;

    public /* synthetic */ d2(CartScreen.CartRecyclerviewAdapter cartRecyclerviewAdapter, Promotion promotion) {
        this.f57482b = cartRecyclerviewAdapter;
        this.f57483c = promotion;
    }

    public final void onClick(View view) {
        this.f57482b.lambda$onBindViewHolder$6(this.f57483c, view);
    }
}
