package dv;

import com.talabat.talabatcommon.feature.vendorTags.data.VendorTagsRepositoryImpl;
import io.reactivex.functions.Consumer;
import library.talabat.com.talabatlib.VendorTagsResponse;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorTagsRepositoryImpl f61963b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61964c;

    public /* synthetic */ a(VendorTagsRepositoryImpl vendorTagsRepositoryImpl, String str) {
        this.f61963b = vendorTagsRepositoryImpl;
        this.f61964c = str;
    }

    public final void accept(Object obj) {
        VendorTagsRepositoryImpl.m10930getVendorTags$lambda0(this.f61963b, this.f61964c, (VendorTagsResponse) obj);
    }
}
