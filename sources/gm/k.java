package gm;

import com.talabat.feature.darkstorescart.data.model.CartVendor;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import io.reactivex.functions.Function;

public final /* synthetic */ class k implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62103b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62104c;

    public /* synthetic */ k(DarkstoresCartRepository darkstoresCartRepository, String str) {
        this.f62103b = darkstoresCartRepository;
        this.f62104c = str;
    }

    public final Object apply(Object obj) {
        return DarkstoresCartRepository.m10174createCartInfo$lambda20(this.f62103b, this.f62104c, (CartVendor) obj);
    }
}
