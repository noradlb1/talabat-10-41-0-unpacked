package um;

import com.talabat.feature.darkstoresvendor.data.repository.VendorRepositoryImpl;
import com.talabat.feature.darkstoresvendor.domain.model.VendorParams;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorRepositoryImpl f62942b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VendorParams f62943c;

    public /* synthetic */ b(VendorRepositoryImpl vendorRepositoryImpl, VendorParams vendorParams) {
        this.f62942b = vendorRepositoryImpl;
        this.f62943c = vendorParams;
    }

    public final Object apply(Object obj) {
        return VendorRepositoryImpl.m10216getVendor$lambda1(this.f62942b, this.f62943c, (Throwable) obj);
    }
}
