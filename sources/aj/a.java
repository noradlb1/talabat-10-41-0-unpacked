package aj;

import com.talabat.darkstores.feature.categories.subcategories.list.ProductTileViewHolder;
import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductTileViewHolder f50830b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Product f50831c;

    public /* synthetic */ a(ProductTileViewHolder productTileViewHolder, Product product) {
        this.f50830b = productTileViewHolder;
        this.f50831c = product;
    }

    public final void accept(Object obj) {
        ProductTileViewHolder.m9929collectEvents$lambda6(this.f50830b, this.f50831c, (Pair) obj);
    }
}
