package com.talabat.sdsquad.data.vendorslist;

import com.talabat.sdsquad.data.vendorslist.response.ActiveEvent;
import com.talabat.sdsquad.data.vendorslist.response.Vendor;
import com.talabat.sdsquad.data.vendorslist.response.VendorsListResponse;
import io.reactivex.Flowable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&¨\u0006\u0010"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/VendorRepository;", "", "getPolygonEvent", "Lcom/talabat/sdsquad/data/vendorslist/response/ActiveEvent;", "getVendorById", "Lcom/talabat/sdsquad/data/vendorslist/response/Vendor;", "vendorId", "", "getVendors", "Lio/reactivex/Flowable;", "Lcom/talabat/sdsquad/data/vendorslist/response/VendorsListResponse;", "isForceUpdate", "", "latitude", "", "longitude", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorRepository {
    @Nullable
    ActiveEvent getPolygonEvent();

    @Nullable
    Vendor getVendorById(int i11);

    @NotNull
    Flowable<VendorsListResponse> getVendors(boolean z11, @NotNull String str, @NotNull String str2);
}
