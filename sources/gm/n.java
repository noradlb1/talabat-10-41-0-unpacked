package gm;

import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import io.reactivex.functions.Function;

public final /* synthetic */ class n implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62106b;

    public /* synthetic */ n(DarkstoresCartRepository darkstoresCartRepository) {
        this.f62106b = darkstoresCartRepository;
    }

    public final Object apply(Object obj) {
        return DarkstoresCartRepository.m10179removeProductFromCart$lambda10(this.f62106b, (String) obj);
    }
}
