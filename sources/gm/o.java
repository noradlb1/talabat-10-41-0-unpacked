package gm;

import com.talabat.feature.darkstorescart.data.model.CartInfo;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import io.reactivex.functions.Function;

public final /* synthetic */ class o implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62107b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62108c;

    public /* synthetic */ o(DarkstoresCartRepository darkstoresCartRepository, String str) {
        this.f62107b = darkstoresCartRepository;
        this.f62108c = str;
    }

    public final Object apply(Object obj) {
        return DarkstoresCartRepository.m10180removeProductFromCart$lambda11(this.f62107b, this.f62108c, (CartInfo) obj);
    }
}
