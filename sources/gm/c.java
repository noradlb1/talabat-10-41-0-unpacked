package gm;

import com.talabat.feature.darkstorescart.data.model.CartInfo;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62093b;

    public /* synthetic */ c(DarkstoresCartRepository darkstoresCartRepository) {
        this.f62093b = darkstoresCartRepository;
    }

    public final Object apply(Object obj) {
        return DarkstoresCartRepository.m10177getCartOwner$lambda15(this.f62093b, (CartInfo) obj);
    }
}
