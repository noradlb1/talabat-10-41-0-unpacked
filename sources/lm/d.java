package lm;

import com.talabat.feature.darkstoresflutter.data.repository.DarkstoresCartFlutterRepositoryImpl;
import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartFlutterRepositoryImpl f62246b;

    public /* synthetic */ d(DarkstoresCartFlutterRepositoryImpl darkstoresCartFlutterRepositoryImpl) {
        this.f62246b = darkstoresCartFlutterRepositoryImpl;
    }

    public final Object call() {
        return DarkstoresCartFlutterRepositoryImpl.m10202clearCart$lambda2(this.f62246b);
    }
}
