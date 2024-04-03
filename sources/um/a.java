package um;

import com.talabat.feature.darkstoresvendor.data.repository.VendorRepositoryImpl;
import com.talabat.feature.darkstoresvendor.domain.model.VendorParams;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorRepositoryImpl f62940b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VendorParams f62941c;

    public /* synthetic */ a(VendorRepositoryImpl vendorRepositoryImpl, VendorParams vendorParams) {
        this.f62940b = vendorRepositoryImpl;
        this.f62941c = vendorParams;
    }

    public final Object call() {
        return VendorRepositoryImpl.m10215getVendor$lambda0(this.f62940b, this.f62941c);
    }
}
