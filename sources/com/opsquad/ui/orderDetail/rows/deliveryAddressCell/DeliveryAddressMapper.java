package com.opsquad.ui.orderDetail.rows.deliveryAddressCell;

import com.opsquad.features.orderDetails.models.responses.OrderAddressResponse;
import com.opsquad.features.orderDetails.models.responses.OrderDetailResponse;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/deliveryAddressCell/DeliveryAddressMapper;", "", "()V", "getAddressDescription", "", "address", "Lcom/opsquad/features/orderDetails/models/responses/OrderAddressResponse;", "getExtraDirections", "getLandLineNumber", "getMobileNumber", "mapDeliveryAddressDataModel", "Lcom/opsquad/ui/orderDetail/rows/deliveryAddressCell/DeliveryAddressDisplayModel;", "field", "Lcom/opsquad/features/orderDetails/models/responses/OrderDetailResponse;", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryAddressMapper {
    private final String getAddressDescription(OrderAddressResponse orderAddressResponse) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.valueOf(orderAddressResponse.getBlock()));
        arrayList.add(String.valueOf(orderAddressResponse.getStreet()));
        arrayList.add(String.valueOf(orderAddressResponse.getBuildingNo()));
        arrayList.add(String.valueOf(orderAddressResponse.getJudda()));
        arrayList.add(String.valueOf(orderAddressResponse.getFloor()));
        arrayList.add(String.valueOf(orderAddressResponse.getSuite()));
        arrayList.removeAll(CollectionsKt__CollectionsKt.mutableListOf(""));
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, DeliveryAddressMapper$getAddressDescription$1.INSTANCE, 31, (Object) null);
    }

    private final String getExtraDirections(OrderAddressResponse orderAddressResponse) {
        boolean z11;
        String extraDirections = orderAddressResponse.getExtraDirections();
        if (extraDirections == null || StringsKt__StringsJVMKt.isBlank(extraDirections)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return extraDirections;
        }
        return "";
    }

    private final String getLandLineNumber(OrderAddressResponse orderAddressResponse) {
        boolean z11;
        String phoneNumber = orderAddressResponse.getPhoneNumber();
        if (phoneNumber == null || StringsKt__StringsJVMKt.isBlank(phoneNumber)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "";
        }
        return "Landline Number: " + phoneNumber;
    }

    private final String getMobileNumber(OrderAddressResponse orderAddressResponse) {
        boolean z11;
        String mobileNumber = orderAddressResponse.getMobileNumber();
        boolean z12 = false;
        if (mobileNumber == null || mobileNumber.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "";
        }
        String mobilNumberCountryCode = orderAddressResponse.getMobilNumberCountryCode();
        if (mobilNumberCountryCode == null || mobilNumberCountryCode.length() == 0) {
            z12 = true;
        }
        if (!z12) {
            mobileNumber = "+" + orderAddressResponse.getMobilNumberCountryCode() + " " + mobileNumber;
        }
        return "Mobile Number: " + mobileNumber;
    }

    @NotNull
    public final DeliveryAddressDisplayModel mapDeliveryAddressDataModel(@NotNull OrderDetailResponse orderDetailResponse) {
        String str;
        Intrinsics.checkNotNullParameter(orderDetailResponse, "field");
        DeliveryAddressDisplayModel deliveryAddressDisplayModel = new DeliveryAddressDisplayModel();
        String fullName = orderDetailResponse.getFullName();
        if (fullName != null) {
            str = StringsKt__StringsJVMKt.capitalize(fullName);
        } else {
            str = null;
        }
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        deliveryAddressDisplayModel.setProfileName(str);
        OrderAddressResponse deliveryOrderAddress = orderDetailResponse.getDeliveryOrderAddress();
        if (deliveryOrderAddress != null) {
            String areaName = deliveryOrderAddress.getAreaName();
            if (areaName == null) {
                areaName = str2;
            }
            deliveryAddressDisplayModel.setAreaName(areaName);
            String addressDescription = getAddressDescription(deliveryOrderAddress);
            if (addressDescription == null) {
                addressDescription = str2;
            }
            deliveryAddressDisplayModel.setAddressDescription(addressDescription);
            String mobileNumber = getMobileNumber(deliveryOrderAddress);
            if (mobileNumber == null) {
                mobileNumber = str2;
            }
            deliveryAddressDisplayModel.setMobileNumber(mobileNumber);
            String extraDirections = getExtraDirections(deliveryOrderAddress);
            if (extraDirections == null) {
                extraDirections = str2;
            }
            deliveryAddressDisplayModel.setExtraDirections(extraDirections);
            String landLineNumber = getLandLineNumber(deliveryOrderAddress);
            if (landLineNumber != null) {
                str2 = landLineNumber;
            }
            deliveryAddressDisplayModel.setLandLineNumber(str2);
        }
        return deliveryAddressDisplayModel;
    }
}
