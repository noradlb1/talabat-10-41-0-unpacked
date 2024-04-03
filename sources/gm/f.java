package gm;

import com.talabat.feature.darkstorescart.data.model.CartInfo;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import io.reactivex.functions.Function;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62096b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62097c;

    public /* synthetic */ f(DarkstoresCartRepository darkstoresCartRepository, String str) {
        this.f62096b = darkstoresCartRepository;
        this.f62097c = str;
    }

    public final Object apply(Object obj) {
        return DarkstoresCartRepository.m10168addProductToCart$lambda6(this.f62096b, this.f62097c, (CartInfo) obj);
    }
}
