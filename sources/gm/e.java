package gm;

import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import io.reactivex.functions.Function;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62095b;

    public /* synthetic */ e(DarkstoresCartRepository darkstoresCartRepository) {
        this.f62095b = darkstoresCartRepository;
    }

    public final Object apply(Object obj) {
        return DarkstoresCartRepository.m10167addProductToCart$lambda5(this.f62095b, (String) obj);
    }
}
