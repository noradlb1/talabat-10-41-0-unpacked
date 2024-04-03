package gm;

import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import java.util.concurrent.Callable;

public final /* synthetic */ class m implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62105b;

    public /* synthetic */ m(DarkstoresCartRepository darkstoresCartRepository) {
        this.f62105b = darkstoresCartRepository;
    }

    public final Object call() {
        return DarkstoresCartRepository.m10182removeProductFromCart$lambda9(this.f62105b);
    }
}
