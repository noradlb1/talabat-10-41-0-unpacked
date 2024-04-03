package lj;

import com.talabat.darkstores.feature.product.views.AddToCartButton;
import com.talabat.darkstores.feature.product.views.CartButtonState;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddToCartButton f57009b;

    public /* synthetic */ a(AddToCartButton addToCartButton) {
        this.f57009b = addToCartButton;
    }

    public final void accept(Object obj) {
        this.f57009b.handleViewState((CartButtonState) obj);
    }
}
