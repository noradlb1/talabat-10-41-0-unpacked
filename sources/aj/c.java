package aj;

import com.talabat.darkstores.feature.categories.subcategories.list.ProductTileViewHolder;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductTileViewHolder f50833b;

    public /* synthetic */ c(ProductTileViewHolder productTileViewHolder) {
        this.f50833b = productTileViewHolder;
    }

    public final void accept(Object obj) {
        ProductTileViewHolder.m9928collectEvents$lambda11(this.f50833b, (Boolean) obj);
    }
}
