package bm;

import com.talabat.feature.darkstorescarrierbag.data.DarkstoresCarrierBagRepositoryImpl;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCarrierBagRepositoryImpl f58139b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f58140c;

    public /* synthetic */ b(DarkstoresCarrierBagRepositoryImpl darkstoresCarrierBagRepositoryImpl, boolean z11) {
        this.f58139b = darkstoresCarrierBagRepositoryImpl;
        this.f58140c = z11;
    }

    public final Object call() {
        return DarkstoresCarrierBagRepositoryImpl.m10154setDarkstoresCarrierBagFakeDoorTestShown$lambda1(this.f58139b, this.f58140c);
    }
}
