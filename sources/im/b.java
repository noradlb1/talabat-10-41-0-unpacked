package im;

import com.talabat.feature.darkstorescartlist.data.repository.DarkstoresCartListRepositoryImpl;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartListRepositoryImpl f62154b;

    public /* synthetic */ b(DarkstoresCartListRepositoryImpl darkstoresCartListRepositoryImpl) {
        this.f62154b = darkstoresCartListRepositoryImpl;
    }

    public final Object call() {
        return DarkstoresCartListRepositoryImpl.m10183getCachedCartInfoList$lambda4(this.f62154b);
    }
}
