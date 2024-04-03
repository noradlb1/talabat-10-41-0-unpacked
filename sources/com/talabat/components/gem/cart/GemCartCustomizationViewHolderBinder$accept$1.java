package com.talabat.components.gem.cart;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.CartScreen;
import com.talabat.R;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutDiscountView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCartCustomizationViewHolderBinder$accept$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f55707g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CartScreen f55708h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCartCustomizationViewHolderBinder$accept$1(RecyclerView.ViewHolder viewHolder, CartScreen cartScreen) {
        super(0);
        this.f55707g = viewHolder;
        this.f55708h = cartScreen;
    }

    public final void invoke() {
        View view = this.f55707g.itemView;
        ((GemCheckoutDiscountView) view.findViewById(R.id.gemCartDiscountView)).invoke(new GemCartCustomizationViewHolderBinder$accept$1$1$1(view, this.f55708h));
    }
}
