package aj;

import com.talabat.darkstores.feature.categories.subcategories.list.ProductTileViewHolder;
import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Product f50832b;

    public /* synthetic */ b(Product product) {
        this.f50832b = product;
    }

    public final Object apply(Object obj) {
        return ProductTileViewHolder.m9930collectEvents$lambda9(this.f50832b, (Integer) obj);
    }
}
