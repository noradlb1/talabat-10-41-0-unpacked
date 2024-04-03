package gm;

import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import java.util.concurrent.Callable;

public final /* synthetic */ class q implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62110b;

    public /* synthetic */ q(DarkstoresCartRepository darkstoresCartRepository) {
        this.f62110b = darkstoresCartRepository;
    }

    public final Object call() {
        return DarkstoresCartRepository.m10175getCartOwner$lambda13(this.f62110b);
    }
}
