package gm;

import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62094b;

    public /* synthetic */ d(DarkstoresCartRepository darkstoresCartRepository) {
        this.f62094b = darkstoresCartRepository;
    }

    public final Object call() {
        return DarkstoresCartRepository.m10166addProductToCart$lambda4(this.f62094b);
    }
}
