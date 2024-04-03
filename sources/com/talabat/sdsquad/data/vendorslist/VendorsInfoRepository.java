package com.talabat.sdsquad.data.vendorslist;

import com.talabat.sdsquad.data.vendorslist.requests.VendorInfoRequest;
import com.talabat.sdsquad.data.vendorslist.response.Collections;
import com.talabat.sdsquad.data.vendorslist.response.Cuisine;
import com.talabat.sdsquad.data.vendorslist.response.Filter;
import com.talabat.sdsquad.data.vendorslist.response.VendorsInfoResponse;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0003H&J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0003H&J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;", "", "getCollections", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/data/vendorslist/response/Collections;", "getCuisines", "Lcom/talabat/sdsquad/data/vendorslist/response/Cuisine;", "getFilters", "Lcom/talabat/sdsquad/data/vendorslist/response/Filter;", "getVendorInfo", "Lcom/talabat/sdsquad/data/vendorslist/response/VendorsInfoResponse;", "isForceUpdate", "", "vendorInfoRequest", "Lcom/talabat/sdsquad/data/vendorslist/requests/VendorInfoRequest;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorsInfoRepository {
    @NotNull
    Flowable<List<Collections>> getCollections();

    @NotNull
    Flowable<List<Cuisine>> getCuisines();

    @NotNull
    Flowable<List<Filter>> getFilters();

    @NotNull
    Flowable<VendorsInfoResponse> getVendorInfo(boolean z11, @NotNull VendorInfoRequest vendorInfoRequest);
}
