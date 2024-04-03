package im;

import com.talabat.feature.darkstorescartlist.data.repository.DarkstoresCartListRepositoryImpl;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartListRepositoryImpl f62155b;

    public /* synthetic */ c(DarkstoresCartListRepositoryImpl darkstoresCartListRepositoryImpl) {
        this.f62155b = darkstoresCartListRepositoryImpl;
    }

    public final void accept(Object obj) {
        this.f62155b.trackCartSummaryAPIObservability((Throwable) obj);
    }
}
