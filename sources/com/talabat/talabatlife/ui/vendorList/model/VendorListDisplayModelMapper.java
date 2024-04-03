package com.talabat.talabatlife.ui.vendorList.model;

import com.talabat.talabatcommon.extentions.DoubleKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatlife.features.vendors.vendorList.models.response.Vendor;
import com.talabat.talabatlife.features.vendors.vendorList.models.response.VendorList;
import com.talabat.talabatlife.features.vendors.vendorList.models.response.VendorListRootResponse;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModelMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorListDisplayModelMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ:\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0014\u001a\u00020\bJ,\u0010\r\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0002J\u0014\u0010\u0016\u001a\u00020\u0015*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModelMapper$Companion;", "", "()V", "getVendorDisplayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "vendor", "Lcom/talabat/talabatlife/features/vendors/vendorList/models/response/Vendor;", "newText", "", "mapToVendorListDisplayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;", "rootResponse", "Lcom/talabat/talabatlife/features/vendors/vendorList/models/response/VendorListRootResponse;", "sectionTheList", "", "mapVendorsList", "", "data", "", "vendors", "newTagText", "", "formatRating", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void formatRating(VendorDisplayModel vendorDisplayModel, Vendor vendor) {
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
            String format = decimalFormat.format(DoubleKt.orZero(vendor.getRating()));
            Intrinsics.checkNotNullExpressionValue(format, "DecimalFormat(DECIMAL_FO…t(vendor.rating.orZero())");
            vendorDisplayModel.setRating(format);
        }

        private final void sectionTheList(boolean z11, List<Vendor> list, List<VendorDisplayModel> list2) {
            if (z11) {
                int i11 = 0;
                for (Object next : list) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    Boolean insideSelectedArea = ((Vendor) next).getInsideSelectedArea();
                    if (insideSelectedArea == null || !insideSelectedArea.booleanValue()) {
                        List<VendorDisplayModel> list3 = list2;
                        i11 = i12;
                    } else {
                        list2.add(i11, new VendorDisplayModel(0, (String) null, (String) null, (String) null, (String) null, 0, 0.0d, (String) null, (String) null, 0.0f, (List) null, false, false, (String) null, 14335, (DefaultConstructorMarker) null));
                        return;
                    }
                }
            }
        }

        @NotNull
        public final VendorDisplayModel getVendorDisplayModel(@Nullable Vendor vendor, @NotNull String str) {
            boolean z11;
            boolean z12;
            Vendor vendor2 = vendor;
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "newText");
            VendorDisplayModel vendorDisplayModel = new VendorDisplayModel(0, (String) null, (String) null, (String) null, (String) null, 0, 0.0d, (String) null, (String) null, 0.0f, (List) null, false, false, (String) null, 16383, (DefaultConstructorMarker) null);
            if (vendor2 != null) {
                vendorDisplayModel.setRestaurantId(IntKt.orZero(vendor.getRestaurantId()));
                String imageUrl = vendor.getImageUrl();
                String str3 = "";
                if (imageUrl == null) {
                    imageUrl = str3;
                }
                vendorDisplayModel.setImageUrl(imageUrl);
                String logoUrl = vendor.getLogoUrl();
                if (logoUrl == null) {
                    logoUrl = str3;
                }
                vendorDisplayModel.setLogoUrl(logoUrl);
                String name2 = vendor.getName();
                if (name2 == null) {
                    name2 = str3;
                }
                vendorDisplayModel.setName(name2);
                Boolean isNew = vendor.isNew();
                boolean z13 = false;
                if (isNew != null) {
                    z11 = isNew.booleanValue();
                } else {
                    z11 = false;
                }
                if (z11) {
                    if (str.length() > 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        z13 = true;
                    }
                }
                vendorDisplayModel.setNew(z13);
                vendorDisplayModel.setNewTagText(str2);
                VendorListDisplayModelMapper.Companion.formatRating(vendorDisplayModel, vendor2);
                vendorDisplayModel.setReviewsCount(IntKt.orZero(vendor.getReviewsCount()));
                vendorDisplayModel.setOutletsCount(String.valueOf(IntKt.orZero(vendor.getOutletsCount())));
                String cuisines = vendor.getCuisines();
                if (cuisines != null) {
                    str3 = cuisines;
                }
                vendorDisplayModel.setCuisines(str3);
                vendorDisplayModel.setMinimumDistanceFromCustomer((double) IntKt.orZero(vendor.getMinimumDistanceFromCustomer()));
                List<String> offers = vendor.getOffers();
                if (offers == null) {
                    offers = CollectionsKt__CollectionsKt.emptyList();
                }
                vendorDisplayModel.setOffers(offers);
            }
            return vendorDisplayModel;
        }

        @NotNull
        public final VendorListDisplayModel mapToVendorListDisplayModel(@Nullable VendorListRootResponse vendorListRootResponse, boolean z11) {
            VendorList vendorList;
            VendorListDisplayModel vendorListDisplayModel = new VendorListDisplayModel();
            if (!(vendorListRootResponse == null || (vendorList = (VendorList) vendorListRootResponse.getResult()) == null)) {
                vendorListDisplayModel.setPageNumber(IntKt.orZero(vendorList.getPageNumber()));
                vendorListDisplayModel.setPageSize(IntKt.orZero(vendorList.getPageSize()));
                vendorListDisplayModel.setTotalCount(IntKt.orZero(vendorList.getTotalCount()));
                List<Vendor> data = vendorList.getData();
                if (data != null) {
                    VendorListDisplayModelMapper.Companion.mapVendorsList(data, z11, vendorListDisplayModel.getVendors(), vendorList.getNewTagText());
                }
            }
            return vendorListDisplayModel;
        }

        @NotNull
        public final List<VendorDisplayModel> mapVendorsList(@Nullable List<Vendor> list, boolean z11, @NotNull List<VendorDisplayModel> list2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(list2, "vendors");
            Intrinsics.checkNotNullParameter(str, "newTagText");
            if (list != null) {
                for (Vendor vendorDisplayModel : list) {
                    list2.add(VendorListDisplayModelMapper.Companion.getVendorDisplayModel(vendorDisplayModel, str));
                }
                VendorListDisplayModelMapper.Companion.sectionTheList(z11, list, list2);
            }
            return list2;
        }
    }
}
