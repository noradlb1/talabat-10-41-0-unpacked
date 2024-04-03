package ki;

import com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepositoryImpl f56973b;

    public /* synthetic */ c(DarkstoresRepositoryImpl darkstoresRepositoryImpl) {
        this.f56973b = darkstoresRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return DarkstoresRepositoryImpl.m9729getCartVendor$lambda0(this.f56973b, (String) obj);
    }
}
