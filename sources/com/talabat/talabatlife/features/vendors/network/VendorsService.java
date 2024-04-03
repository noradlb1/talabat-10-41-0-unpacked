package com.talabat.talabatlife.features.vendors.network;

import com.adjust.sdk.Constants;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatlife.features.UrlConstantsKt;
import com.talabat.talabatlife.features.vendors.branches.models.VendorBranchListRootResponse;
import com.talabat.talabatlife.features.vendors.offers.models.VendorOfferRootResponse;
import com.talabat.talabatlife.features.vendors.vendorAreas.models.VendorAreasRootResponse;
import com.talabat.talabatlife.features.vendors.vendorList.models.response.VendorListRootResponse;
import com.talabat.talabatlife.features.vendors.vendorList.models.response.VendorRootResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J2\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016Jn\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00112\b\u0010 \u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006#"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/network/VendorsService;", "Lcom/talabat/talabatlife/features/vendors/network/VendorsApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "api", "getApi", "()Lcom/talabat/talabatlife/features/vendors/network/VendorsApi;", "api$delegate", "Lkotlin/Lazy;", "getVendorBranchList", "Lretrofit2/Call;", "Lcom/talabat/talabatlife/features/vendors/branches/models/VendorBranchListRootResponse;", "restaurantID", "", "apiVersion", "lat", "", "long", "getVendorInfo", "Lcom/talabat/talabatlife/features/vendors/vendorList/models/response/VendorRootResponse;", "getVendorOfferList", "Lcom/talabat/talabatlife/features/vendors/offers/models/VendorOfferRootResponse;", "country", "getVendorsAreas", "Lcom/talabat/talabatlife/features/vendors/vendorAreas/models/VendorAreasRootResponse;", "getVendorsList", "Lcom/talabat/talabatlife/features/vendors/vendorList/models/response/VendorListRootResponse;", "featured", "page", "size", "searchString", "areaID", "offerType", "cuisineId", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsService implements VendorsApi {
    @NotNull
    private final Lazy api$delegate;

    public VendorsService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.api$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new VendorsService$api$2(talabatAPIBuilder));
    }

    private final VendorsApi getApi() {
        return (VendorsApi) this.api$delegate.getValue();
    }

    @NotNull
    public Call<VendorBranchListRootResponse> getVendorBranchList(int i11, int i12, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "lat");
        Intrinsics.checkNotNullParameter(str2, Constants.LONG);
        return getApi().getVendorBranchList(i11, i12, str, str2);
    }

    @NotNull
    public Call<VendorRootResponse> getVendorInfo(int i11, int i12) {
        return getApi().getVendorInfo(i11, i12);
    }

    @NotNull
    public Call<VendorOfferRootResponse> getVendorOfferList(int i11, int i12, int i13) {
        return getApi().getVendorOfferList(i11, i12, i13);
    }

    @NotNull
    public Call<VendorAreasRootResponse> getVendorsAreas(int i11, int i12, @Nullable String str, @Nullable String str2) {
        return getApi().getVendorsAreas(i11, i12, str, str2);
    }

    @NotNull
    public Call<VendorListRootResponse> getVendorsList(int i11, int i12, @NotNull String str, @Nullable String str2, @Nullable String str3, int i13, int i14, @Nullable String str4, @Nullable String str5, int i15, int i16) {
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, UrlConstantsKt.PATH_FEATURED);
        return getApi().getVendorsList(i11, i12, str6, str2, str3, i13, i14, str4, str5, i15, i16);
    }
}
