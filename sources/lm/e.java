package lm;

import com.talabat.feature.darkstoresflutter.data.repository.DarkstoresCartFlutterRepositoryImpl;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartFlutterRepositoryImpl f62247b;

    public /* synthetic */ e(DarkstoresCartFlutterRepositoryImpl darkstoresCartFlutterRepositoryImpl) {
        this.f62247b = darkstoresCartFlutterRepositoryImpl;
    }

    public final Object call() {
        return DarkstoresCartFlutterRepositoryImpl.m10205refreshCart$lambda3(this.f62247b);
    }
}
