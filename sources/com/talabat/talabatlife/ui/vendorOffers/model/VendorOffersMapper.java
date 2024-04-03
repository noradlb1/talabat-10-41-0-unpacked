package com.talabat.talabatlife.ui.vendorOffers.model;

import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.DoubleKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatlife.features.vendors.branches.models.VendorBranchListResponse;
import com.talabat.talabatlife.features.vendors.branches.models.VendorBranchListRootResponse;
import com.talabat.talabatlife.features.vendors.branches.models.VendorBranchResponse;
import com.talabat.talabatlife.features.vendors.offers.models.VendorOfferListResponse;
import com.talabat.talabatlife.features.vendors.offers.models.VendorOfferResponse;
import com.talabat.talabatlife.features.vendors.offers.models.VendorOfferRootResponse;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOffersMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorOffersMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001e\u0010\u001c\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u001e\u0010\u001f\u001a\u00020\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u00192\u0006\u0010\u001e\u001a\u00020!H\u0002¨\u0006\""}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOffersMapper$Companion;", "", "()V", "getOfferLimitModel", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel$OfferLimitModel;", "offerLimitResponse", "Lcom/talabat/talabatlife/features/vendors/offers/models/VendorOfferResponse$OfferLimitResponse;", "getVendorBranchDisplayModel", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchDisplayModel;", "branch", "Lcom/talabat/talabatlife/features/vendors/branches/models/VendorBranchResponse;", "getVendorOfferDisplayModel", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel;", "offerResponse", "Lcom/talabat/talabatlife/features/vendors/offers/models/VendorOfferResponse;", "mapToVendorBranchListDisplayModel", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchListDisplayModel;", "rootResponse", "Lcom/talabat/talabatlife/features/vendors/branches/models/VendorBranchListRootResponse;", "mapToVendorOffersListDisplayModel", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "Lcom/talabat/talabatlife/features/vendors/offers/models/VendorOfferRootResponse;", "mapVendorBranchList", "", "branches", "", "branchListResponse", "Lcom/talabat/talabatlife/features/vendors/branches/models/VendorBranchListResponse;", "mapVendorOfferLimitsList", "offerLimitList", "offerListResponse", "mapVendorOfferList", "offerListDisplayModel", "Lcom/talabat/talabatlife/features/vendors/offers/models/VendorOfferListResponse;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final VendorOfferDisplayModel.OfferLimitModel getOfferLimitModel(VendorOfferResponse.OfferLimitResponse offerLimitResponse) {
            VendorOfferDisplayModel.OfferLimitModel offerLimitModel = new VendorOfferDisplayModel.OfferLimitModel();
            String type = offerLimitResponse.getType();
            if (type == null) {
                type = VendorOfferDisplayModel.LimitType.None.name();
            }
            offerLimitModel.setType(VendorOfferDisplayModel.LimitType.valueOf(type));
            offerLimitModel.setReached(BooleanKt.orFalse(offerLimitResponse.isReached()));
            return offerLimitModel;
        }

        private final VendorBranchDisplayModel getVendorBranchDisplayModel(VendorBranchResponse vendorBranchResponse) {
            VendorBranchDisplayModel vendorBranchDisplayModel = new VendorBranchDisplayModel();
            vendorBranchDisplayModel.setId(IntKt.orZero(vendorBranchResponse.getId()));
            String area = vendorBranchResponse.getArea();
            String str = "";
            if (area == null) {
                area = str;
            }
            vendorBranchDisplayModel.setName(area);
            String city = vendorBranchResponse.getCity();
            if (city != null) {
                str = city;
            }
            vendorBranchDisplayModel.setAddress(str);
            vendorBranchDisplayModel.setLatitude(DoubleKt.orZero(vendorBranchResponse.getLatitude()));
            vendorBranchDisplayModel.setLongitude(DoubleKt.orZero(vendorBranchResponse.getLongitude()));
            vendorBranchDisplayModel.setDistanceInMeters(DoubleKt.orZero(vendorBranchResponse.getDistanceInMeters()));
            return vendorBranchDisplayModel;
        }

        private final VendorOfferDisplayModel getVendorOfferDisplayModel(VendorOfferResponse vendorOfferResponse) {
            VendorOfferDisplayModel vendorOfferDisplayModel = new VendorOfferDisplayModel();
            vendorOfferDisplayModel.setId(IntKt.orZero(vendorOfferResponse.getId()));
            String title = vendorOfferResponse.getTitle();
            String str = "";
            if (title == null) {
                title = str;
            }
            vendorOfferDisplayModel.setTitle(title);
            String subtitle = vendorOfferResponse.getSubtitle();
            if (subtitle == null) {
                subtitle = str;
            }
            vendorOfferDisplayModel.setSubtitle(subtitle);
            String info = vendorOfferResponse.getInfo();
            if (info != null) {
                str = info;
            }
            vendorOfferDisplayModel.setInfo(str);
            vendorOfferDisplayModel.setEnabled(BooleanKt.orFalse(vendorOfferResponse.isEnabled()));
            VendorOffersMapper.Companion.mapVendorOfferLimitsList(vendorOfferDisplayModel.getLimits(), vendorOfferResponse);
            return vendorOfferDisplayModel;
        }

        private final void mapVendorBranchList(List<VendorBranchDisplayModel> list, VendorBranchListResponse vendorBranchListResponse) {
            List<VendorBranchResponse> branches = vendorBranchListResponse.getBranches();
            if (branches != null) {
                for (VendorBranchResponse next : branches) {
                    if (next != null) {
                        list.add(VendorOffersMapper.Companion.getVendorBranchDisplayModel(next));
                    }
                }
            }
        }

        private final void mapVendorOfferLimitsList(List<VendorOfferDisplayModel.OfferLimitModel> list, VendorOfferResponse vendorOfferResponse) {
            List<VendorOfferResponse.OfferLimitResponse> limits = vendorOfferResponse.getLimits();
            if (limits != null) {
                for (VendorOfferResponse.OfferLimitResponse next : limits) {
                    if (next != null) {
                        list.add(VendorOffersMapper.Companion.getOfferLimitModel(next));
                    }
                }
            }
        }

        private final void mapVendorOfferList(List<VendorOfferDisplayModel> list, VendorOfferListResponse vendorOfferListResponse) {
            List<VendorOfferResponse> offers = vendorOfferListResponse.getOffers();
            if (offers != null) {
                for (VendorOfferResponse next : offers) {
                    if (next != null) {
                        list.add(VendorOffersMapper.Companion.getVendorOfferDisplayModel(next));
                    }
                }
            }
        }

        @NotNull
        public final VendorBranchListDisplayModel mapToVendorBranchListDisplayModel(@NotNull VendorBranchListRootResponse vendorBranchListRootResponse) {
            Intrinsics.checkNotNullParameter(vendorBranchListRootResponse, "rootResponse");
            VendorBranchListDisplayModel vendorBranchListDisplayModel = new VendorBranchListDisplayModel();
            VendorBranchListResponse vendorBranchListResponse = (VendorBranchListResponse) vendorBranchListRootResponse.getResult();
            if (vendorBranchListResponse != null) {
                VendorOffersMapper.Companion.mapVendorBranchList(vendorBranchListDisplayModel.getBranches(), vendorBranchListResponse);
            }
            return vendorBranchListDisplayModel;
        }

        @NotNull
        public final VendorOfferListDisplayModel mapToVendorOffersListDisplayModel(@NotNull VendorOfferRootResponse vendorOfferRootResponse) {
            Intrinsics.checkNotNullParameter(vendorOfferRootResponse, "rootResponse");
            VendorOfferListDisplayModel vendorOfferListDisplayModel = new VendorOfferListDisplayModel();
            VendorOfferListResponse vendorOfferListResponse = (VendorOfferListResponse) vendorOfferRootResponse.getResult();
            if (vendorOfferListResponse != null) {
                VendorOffersMapper.Companion.mapVendorOfferList(vendorOfferListDisplayModel.getOfferList(), vendorOfferListResponse);
            }
            return vendorOfferListDisplayModel;
        }
    }
}
