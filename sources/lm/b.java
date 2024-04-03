package lm;

import com.talabat.feature.darkstoresflutter.data.repository.DarkstoresCartFlutterRepositoryImpl;
import java.util.Map;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartFlutterRepositoryImpl f62242b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f62243c;

    public /* synthetic */ b(DarkstoresCartFlutterRepositoryImpl darkstoresCartFlutterRepositoryImpl, Map map) {
        this.f62242b = darkstoresCartFlutterRepositoryImpl;
        this.f62243c = map;
    }

    public final Object call() {
        return DarkstoresCartFlutterRepositoryImpl.m10200addProductToCart$lambda0(this.f62242b, this.f62243c);
    }
}
