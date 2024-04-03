package com.opsquad.ui.orderDetail.rows.vendorInfoCell;

import com.opsquad.features.orderDetails.models.responses.OrderDetailResponse;
import com.opsquad.ui.orderDetail.model.enums.EOrderStatus;
import com.opsquad.ui.orderDetail.model.enums.OrderStatusStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004¨\u0006\u000e"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/vendorInfoCell/VendorInfoMapper;", "", "()V", "getOrderID", "", "orderDetailResponse", "Lcom/opsquad/features/orderDetails/models/responses/OrderDetailResponse;", "getOrderStatus", "getOrderStatusStyle", "Lcom/opsquad/ui/orderDetail/model/enums/OrderStatusStyle;", "getVendorInfoRow", "Lcom/opsquad/ui/orderDetail/rows/vendorInfoCell/VendorInfoRowDisplayModel;", "field", "baseUrl", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorInfoMapper {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EOrderStatus.values().length];
            iArr[EOrderStatus.PREPARING.ordinal()] = 1;
            iArr[EOrderStatus.PLACED.ordinal()] = 2;
            iArr[EOrderStatus.DELIVERING.ordinal()] = 3;
            iArr[EOrderStatus.DELIVERED.ordinal()] = 4;
            iArr[EOrderStatus.CANCELLED.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final String getOrderID(OrderDetailResponse orderDetailResponse) {
        String orderID = orderDetailResponse.getOrderID();
        return orderID == null ? "" : orderID;
    }

    private final String getOrderStatus(OrderDetailResponse orderDetailResponse) {
        String str;
        if (!orderDetailResponse.getStatus()) {
            orderDetailResponse.getOrderStatus();
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[EOrderStatus.Companion.create(Integer.valueOf(orderDetailResponse.getNewOrderStatus())).ordinal()];
        if (i11 == 1) {
            str = "Preparing";
        } else if (i11 == 2) {
            str = "Order Placed";
        } else if (i11 == 3) {
            str = "Delivering";
        } else if (i11 == 4) {
            str = "Delivered";
        } else if (i11 == 5) {
            str = orderDetailResponse.getOrderStatus();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final OrderStatusStyle getOrderStatusStyle(OrderDetailResponse orderDetailResponse) {
        if (!orderDetailResponse.getStatus()) {
            return OrderStatusStyle.NEGATIVE;
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[EOrderStatus.Companion.create(Integer.valueOf(orderDetailResponse.getNewOrderStatus())).ordinal()];
        if (i11 == 1) {
            return OrderStatusStyle.POSITIVE;
        }
        if (i11 == 2) {
            return OrderStatusStyle.POSITIVE;
        }
        if (i11 == 3) {
            return OrderStatusStyle.POSITIVE;
        }
        if (i11 == 4) {
            return OrderStatusStyle.POSITIVE;
        }
        if (Intrinsics.areEqual((Object) orderDetailResponse.getOrderStatus(), (Object) "Successful")) {
            return OrderStatusStyle.POSITIVE;
        }
        return OrderStatusStyle.NEGATIVE;
    }

    @NotNull
    public final VendorInfoRowDisplayModel getVendorInfoRow(@NotNull OrderDetailResponse orderDetailResponse, @Nullable String str) {
        Intrinsics.checkNotNullParameter(orderDetailResponse, "field");
        VendorInfoRowDisplayModel vendorInfoRowDisplayModel = new VendorInfoRowDisplayModel();
        String restaurantName = orderDetailResponse.getRestaurantName();
        String str2 = "";
        if (restaurantName == null) {
            restaurantName = str2;
        }
        vendorInfoRowDisplayModel.setVendorName(restaurantName);
        vendorInfoRowDisplayModel.setOrderStatus(getOrderStatus(orderDetailResponse));
        String orderTime = orderDetailResponse.getOrderTime();
        if (orderTime == null) {
            orderTime = str2;
        }
        vendorInfoRowDisplayModel.setOrderTime(orderTime);
        String restaurantLogo = orderDetailResponse.getRestaurantLogo();
        if (restaurantLogo != null) {
            str2 = restaurantLogo;
        }
        vendorInfoRowDisplayModel.setRestaurantLogoUrl(str + "restaurants/" + str2);
        vendorInfoRowDisplayModel.setOrderID(getOrderID(orderDetailResponse));
        vendorInfoRowDisplayModel.setOrderStatusStyle(getOrderStatusStyle(orderDetailResponse));
        return vendorInfoRowDisplayModel;
    }
}
