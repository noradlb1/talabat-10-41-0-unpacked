package im;

import com.talabat.feature.darkstorescartlist.data.repository.DarkstoresCartListRepositoryImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartListRepositoryImpl f62153b;

    public /* synthetic */ a(DarkstoresCartListRepositoryImpl darkstoresCartListRepositoryImpl) {
        this.f62153b = darkstoresCartListRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return DarkstoresCartListRepositoryImpl.m10184getCartInfoList$lambda0(this.f62153b, (List) obj);
    }
}
