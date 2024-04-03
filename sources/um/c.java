package um;

import com.talabat.feature.darkstoresvendor.data.model.VendorResponse;
import com.talabat.feature.darkstoresvendor.data.repository.VendorRepositoryImpl;
import com.talabat.feature.darkstoresvendor.domain.model.VendorParams;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorRepositoryImpl f62944b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VendorParams f62945c;

    public /* synthetic */ c(VendorRepositoryImpl vendorRepositoryImpl, VendorParams vendorParams) {
        this.f62944b = vendorRepositoryImpl;
        this.f62945c = vendorParams;
    }

    public final void accept(Object obj) {
        VendorRepositoryImpl.m10217getVendorFromApi$lambda3$lambda2(this.f62944b, this.f62945c, (VendorResponse) obj);
    }
}
