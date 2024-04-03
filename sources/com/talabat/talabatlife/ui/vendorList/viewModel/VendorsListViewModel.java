package com.talabat.talabatlife.ui.vendorList.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.extentions.DoubleKt;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.talabatlife.domain.entity.Cuisine;
import com.talabat.talabatlife.domain.entity.Filter;
import com.talabat.talabatlife.ui.vendorList.model.VendorAreasDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorListDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorLocationFilterDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u000105H&Jd\u00107\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u0001052\u0006\u00108\u001a\u0002032\u0006\u00109\u001a\u0002032\b\u0010:\u001a\u0004\u0018\u0001052\n\b\u0002\u0010;\u001a\u0004\u0018\u0001052\b\b\u0002\u0010<\u001a\u0002032\b\b\u0002\u0010=\u001a\u000203H&R&\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\u0018\u0010\u0015\u001a\u00020\u0016X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R \u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\nR \u0010-\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\b\"\u0004\b/\u0010\n¨\u0006>"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/viewModel/VendorsListViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "CuisineButtonLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/talabat/talabatlife/domain/entity/Cuisine;", "getCuisineButtonLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setCuisineButtonLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "defaultResult", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;", "getDefaultResult", "()Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;", "setDefaultResult", "(Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;)V", "filterButtonLiveData", "Lcom/talabat/talabatlife/domain/entity/Filter;", "getFilterButtonLiveData", "setFilterButtonLiveData", "isFirstLoading", "", "()Z", "setFirstLoading", "(Z)V", "selectedArea", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorLocationFilterDisplayModel;", "getSelectedArea", "()Lcom/talabat/talabatlife/ui/vendorList/model/VendorLocationFilterDisplayModel;", "setSelectedArea", "(Lcom/talabat/talabatlife/ui/vendorList/model/VendorLocationFilterDisplayModel;)V", "userLatitude", "", "getUserLatitude", "()D", "setUserLatitude", "(D)V", "userLongitude", "getUserLongitude", "setUserLongitude", "vendorAreasListData", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorAreasDisplayModel;", "getVendorAreasListData", "setVendorAreasListData", "vendorListData", "getVendorListData", "setVendorListData", "getVendorsAreasList", "", "countryCode", "", "lat", "", "long", "getVendorsList", "pageNumber", "pageSize", "searchString", "areaID", "offerFilterId", "cuisineId", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class VendorsListViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<List<Cuisine>> CuisineButtonLiveData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Filter> filterButtonLiveData = new MutableLiveData<>();
    @Nullable
    private VendorLocationFilterDisplayModel selectedArea;
    private double userLatitude;
    private double userLongitude;
    @NotNull
    private MutableLiveData<VendorAreasDisplayModel> vendorAreasListData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<VendorListDisplayModel> vendorListData = new MutableLiveData<>();

    public VendorsListViewModel() {
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        this.userLatitude = DoubleKt.orZero(doubleCompanionObject);
        this.userLongitude = DoubleKt.orZero(doubleCompanionObject);
    }

    public static /* synthetic */ void getVendorsAreasList$default(VendorsListViewModel vendorsListViewModel, int i11, String str, String str2, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            }
            if ((i12 & 2) != 0) {
                str = String.valueOf(vendorsListViewModel.userLatitude);
            }
            if ((i12 & 4) != 0) {
                str2 = String.valueOf(vendorsListViewModel.userLongitude);
            }
            vendorsListViewModel.getVendorsAreasList(i11, str, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorsAreasList");
    }

    public static /* synthetic */ void getVendorsList$default(VendorsListViewModel vendorsListViewModel, int i11, String str, String str2, int i12, int i13, String str3, String str4, int i14, int i15, int i16, Object obj) {
        int i17;
        String str5;
        String str6;
        String str7;
        int i18;
        int i19;
        int i21 = i16;
        if (obj == null) {
            if ((i21 & 1) != 0) {
                i17 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            } else {
                i17 = i11;
            }
            if ((i21 & 2) != 0) {
                str5 = null;
            } else {
                str5 = str;
            }
            if ((i21 & 4) != 0) {
                str6 = null;
            } else {
                str6 = str2;
            }
            if ((i21 & 64) != 0) {
                str7 = null;
            } else {
                str7 = str4;
            }
            if ((i21 & 128) != 0) {
                i18 = 0;
            } else {
                i18 = i14;
            }
            if ((i21 & 256) != 0) {
                i19 = 0;
            } else {
                i19 = i15;
            }
            vendorsListViewModel.getVendorsList(i17, str5, str6, i12, i13, str3, str7, i18, i19);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorsList");
    }

    @NotNull
    public final MutableLiveData<List<Cuisine>> getCuisineButtonLiveData() {
        return this.CuisineButtonLiveData;
    }

    @NotNull
    public abstract VendorListDisplayModel getDefaultResult();

    @NotNull
    public final MutableLiveData<Filter> getFilterButtonLiveData() {
        return this.filterButtonLiveData;
    }

    @Nullable
    public final VendorLocationFilterDisplayModel getSelectedArea() {
        return this.selectedArea;
    }

    public final double getUserLatitude() {
        return this.userLatitude;
    }

    public final double getUserLongitude() {
        return this.userLongitude;
    }

    @NotNull
    public final MutableLiveData<VendorAreasDisplayModel> getVendorAreasListData() {
        return this.vendorAreasListData;
    }

    @NotNull
    public final MutableLiveData<VendorListDisplayModel> getVendorListData() {
        return this.vendorListData;
    }

    public abstract void getVendorsAreasList(int i11, @Nullable String str, @Nullable String str2);

    public abstract void getVendorsList(int i11, @Nullable String str, @Nullable String str2, int i12, int i13, @Nullable String str3, @Nullable String str4, int i14, int i15);

    public abstract boolean isFirstLoading();

    public final void setCuisineButtonLiveData(@NotNull MutableLiveData<List<Cuisine>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.CuisineButtonLiveData = mutableLiveData;
    }

    public abstract void setDefaultResult(@NotNull VendorListDisplayModel vendorListDisplayModel);

    public final void setFilterButtonLiveData(@NotNull MutableLiveData<Filter> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.filterButtonLiveData = mutableLiveData;
    }

    public abstract void setFirstLoading(boolean z11);

    public final void setSelectedArea(@Nullable VendorLocationFilterDisplayModel vendorLocationFilterDisplayModel) {
        this.selectedArea = vendorLocationFilterDisplayModel;
    }

    public final void setUserLatitude(double d11) {
        this.userLatitude = d11;
    }

    public final void setUserLongitude(double d11) {
        this.userLongitude = d11;
    }

    public final void setVendorAreasListData(@NotNull MutableLiveData<VendorAreasDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.vendorAreasListData = mutableLiveData;
    }

    public final void setVendorListData(@NotNull MutableLiveData<VendorListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.vendorListData = mutableLiveData;
    }
}
