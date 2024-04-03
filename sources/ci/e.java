package ci;

import com.talabat.darkstores.common.view.CartItemViewHolderCompact;
import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartItemViewHolderCompact f50937b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Product f50938c;

    public /* synthetic */ e(CartItemViewHolderCompact cartItemViewHolderCompact, Product product) {
        this.f50937b = cartItemViewHolderCompact;
        this.f50938c = product;
    }

    public final void accept(Object obj) {
        CartItemViewHolderCompact.m9643collectEvents$lambda2(this.f50937b, this.f50938c, (Pair) obj);
    }
}
