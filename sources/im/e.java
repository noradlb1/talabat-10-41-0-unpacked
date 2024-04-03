package im;

import com.talabat.feature.darkstorescartlist.data.repository.DarkstoresCartListRepositoryImpl;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartListRepositoryImpl f62156b;

    public /* synthetic */ e(DarkstoresCartListRepositoryImpl darkstoresCartListRepositoryImpl) {
        this.f62156b = darkstoresCartListRepositoryImpl;
    }

    public final void accept(Object obj) {
        DarkstoresCartListRepositoryImpl.m10186getRemoteCartInfoList$lambda3(this.f62156b, (List) obj);
    }
}
