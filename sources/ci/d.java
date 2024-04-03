package ci;

import android.view.View;
import com.talabat.darkstores.common.view.CartItemViewHolder;
import com.talabat.feature.darkstorescart.data.model.Product;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartItemViewHolder f50935b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Product f50936c;

    public /* synthetic */ d(CartItemViewHolder cartItemViewHolder, Product product) {
        this.f50935b = cartItemViewHolder;
        this.f50936c = product;
    }

    public final void onClick(View view) {
        CartItemViewHolder.m9641checkIfCampaignMatched$lambda4$lambda3(this.f50935b, this.f50936c, view);
    }
}
