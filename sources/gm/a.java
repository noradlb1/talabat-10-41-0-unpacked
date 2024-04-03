package gm;

import com.talabat.feature.darkstorescart.data.model.CartInfo;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62090b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CartInfo f62091c;

    public /* synthetic */ a(DarkstoresCartRepository darkstoresCartRepository, CartInfo cartInfo) {
        this.f62090b = darkstoresCartRepository;
        this.f62091c = cartInfo;
    }

    public final Object call() {
        return DarkstoresCartRepository.m10171clearCartIfDifferentVendor$lambda16(this.f62090b, this.f62091c);
    }
}
