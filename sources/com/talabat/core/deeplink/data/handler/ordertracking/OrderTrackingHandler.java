package com.talabat.core.deeplink.data.handler.ordertracking;

import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.talabat.configuration.country.Country;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.ordertracking.OrderTrackingScreen;
import com.talabat.domain.address.Address;
import com.talabat.domain.address.AddressesKt;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import com.talabat.helpers.GlobalDataModel;
import datamodels.CartMenuItem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.Purchase;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\nH\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/ordertracking/OrderTrackingHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generatePurchaseObj", "Ltracking/Purchase;", "firstOrder", "selectedPaymentMethod", "", "addToPayMethod", "transactionId", "purchaseEventsEnabled", "handle", "", "context", "Landroid/content/Context;", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingHandler implements Handler {
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final String screenName = "tracking";

    public OrderTrackingHandler(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        this.navigator = navigator2;
    }

    @Nullable
    public Object canHandle(@NotNull ParsedLinkModel parsedLinkModel, @NotNull Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(Intrinsics.areEqual((Object) parsedLinkModel.getScreenName(), (Object) getScreenName()));
    }

    @NotNull
    @VisibleForTesting
    public final Purchase generatePurchaseObj(boolean z11, int i11, int i12, @NotNull String str, boolean z12) {
        boolean z13;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(str, "transactionId");
        Purchase purchase = new Purchase();
        purchase.setFirstOrder(z11);
        ArrayList<CartMenuItem> cartItems = Cart.getInstance().getCartItems();
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }
        purchase.setCart(cartItems);
        float cartTotalPrice = Cart.getInstance().getCartTotalPrice();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cartTotalPrice);
        purchase.setTotal(sb2.toString());
        purchase.setTouristTax(Cart.getInstance().getTouristTax());
        purchase.setMunciplityTax(Cart.getInstance().getMuncipalityTax());
        float deliveryCharges = Cart.getInstance().getDeliveryCharges();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(deliveryCharges);
        purchase.setDelCharges(sb3.toString());
        purchase.setRestaurant(Cart.getInstance().getRestaurant());
        purchase.setRiderTip(Cart.getInstance().getRiderTip());
        purchase.setPurchaseEventsEnabled(z12);
        boolean z14 = false;
        if (i12 == 1) {
            z13 = true;
        } else {
            z13 = false;
        }
        purchase.setPaymentMethod(i11, z13, -1);
        purchase.setEncyptedTransactionId(str);
        if (Customer.getInstance().getSelectedCustomerAddress() != null) {
            Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
            Intrinsics.checkNotNull(selectedCustomerAddress);
            if (GlobalDataModel.SelectedCountryId == Country.LEBANON.getCountryId()) {
                z14 = true;
            }
            purchase.setAddress(AddressesKt.description(selectedCustomerAddress, z14));
        }
        if (Cart.getInstance().hasVoucherApplied()) {
            String voucherCode = Cart.getInstance().getVoucherCode();
            float f11 = Cart.getInstance().voucherDiscount;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(f11);
            purchase.setVoucher(voucherCode, sb4.toString());
            if (Cart.getInstance().getRestaurantCampaignVoucher() != null) {
                str3 = Cart.getInstance().getRestaurantCampaignVoucher().getVoucherTypeForTracking();
            } else {
                str3 = "normal";
            }
            purchase.setVoucherType(str3);
        }
        if (!(!Cart.getInstance().isLoyaltyAvailable() || Cart.getInstance().getLoyaltyVoucher() == null || Cart.getInstance().getLoyaltyVoucher().result == null)) {
            LoyaltyVoucherResult loyaltyVoucherResult = Cart.getInstance().getLoyaltyVoucher().result;
            Intrinsics.checkNotNull(loyaltyVoucherResult);
            purchase.setOfferVoucherId(loyaltyVoucherResult.f476id);
        }
        try {
            String str4 = "";
            if (Customer.getInstance().getSelectedCustomerAddress() != null) {
                Address selectedCustomerAddress2 = Customer.getInstance().getSelectedCustomerAddress();
                Intrinsics.checkNotNull(selectedCustomerAddress2);
                str2 = selectedCustomerAddress2.mobileNumber;
            } else {
                str2 = str4;
            }
            if (Customer.getInstance().getSelectedCustomerAddress() != null) {
                Address selectedCustomerAddress3 = Customer.getInstance().getSelectedCustomerAddress();
                Intrinsics.checkNotNull(selectedCustomerAddress3);
                str4 = selectedCustomerAddress3.mobilNumberCountryCode;
            }
            purchase.setMobileCountryCode(str4);
            purchase.setMobileNumber(str2);
        } catch (Exception unused) {
        }
        return purchase;
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    public void handle(@NotNull Context context, @NotNull ParsedLinkModel parsedLinkModel) {
        String str;
        String str2;
        boolean z11;
        boolean z12;
        int i11;
        boolean z13;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        String str3 = parsedLinkModel.getData().get("orderId");
        if (str3 == null && (str3 = parsedLinkModel.getData().get("i")) == null) {
            str = "";
        } else {
            str = str3;
        }
        String str4 = parsedLinkModel.getData().get("transactionId");
        if (str4 == null) {
            str2 = "";
        } else {
            str2 = str4;
        }
        String str5 = parsedLinkModel.getData().get("shouldClearNavigationStack");
        if (str5 != null) {
            z11 = Boolean.parseBoolean(str5);
        } else {
            z11 = false;
        }
        String str6 = parsedLinkModel.getData().get(NavigationMethodChannel.IS_FIRST_ORDER);
        if (str6 != null) {
            z12 = Boolean.parseBoolean(str6);
        } else {
            z12 = false;
        }
        String str7 = parsedLinkModel.getData().get(NavigationMethodChannel.SELECTED_PAYMENT_METHOD);
        int i12 = -1;
        if (str7 != null) {
            i11 = Integer.parseInt(str7);
        } else {
            i11 = -1;
        }
        String str8 = parsedLinkModel.getData().get(NavigationMethodChannel.ADD_TO_PAY_METHOD);
        if (str8 != null) {
            i12 = Integer.parseInt(str8);
        }
        String str9 = parsedLinkModel.getData().get(NavigationMethodChannel.IS_PURCHASED_EVENTS_ENABLED);
        if (str9 != null) {
            z13 = Boolean.parseBoolean(str9);
        } else {
            z13 = false;
        }
        OrderTrackingScreen.OrderTrackingScreenData orderTrackingScreenData = new OrderTrackingScreen.OrderTrackingScreenData(str, str2, z11, z12, i11, i12, z13);
        this.navigator.navigateTo(context, new OrderTrackingScreen(orderTrackingScreenData), new OrderTrackingHandler$handle$1(orderTrackingScreenData, this));
    }
}
