package gm;

import com.talabat.feature.darkstorescart.data.model.CartInfo;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import io.reactivex.functions.Function;

public final /* synthetic */ class g implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62098b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Product f62099c;

    public /* synthetic */ g(DarkstoresCartRepository darkstoresCartRepository, Product product) {
        this.f62098b = darkstoresCartRepository;
        this.f62099c = product;
    }

    public final Object apply(Object obj) {
        return DarkstoresCartRepository.m10169addProductToCart$lambda7(this.f62098b, this.f62099c, (CartInfo) obj);
    }
}
