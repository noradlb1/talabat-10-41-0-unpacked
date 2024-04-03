package gm;

import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import java.util.concurrent.Callable;
import kotlin.reflect.KMutableProperty0;

public final /* synthetic */ class j implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KMutableProperty0 f62102b;

    public /* synthetic */ j(KMutableProperty0 kMutableProperty0) {
        this.f62102b = kMutableProperty0;
    }

    public final Object call() {
        return DarkstoresCartRepository.m10173createCartInfo$lambda18(this.f62102b);
    }
}
