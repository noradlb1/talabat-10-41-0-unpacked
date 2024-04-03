package ci;

import com.talabat.darkstores.common.view.CartItemViewHolder;
import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartItemViewHolder f50933b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Product f50934c;

    public /* synthetic */ c(CartItemViewHolder cartItemViewHolder, Product product) {
        this.f50933b = cartItemViewHolder;
        this.f50934c = product;
    }

    public final void accept(Object obj) {
        CartItemViewHolder.m9642collectEvents$lambda6(this.f50933b, this.f50934c, (Pair) obj);
    }
}
