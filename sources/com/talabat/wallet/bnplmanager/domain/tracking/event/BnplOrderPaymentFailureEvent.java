package com.talabat.wallet.bnplmanager.domain.tracking.event;

import JsonModels.PolygonEvents;
import buisnessmodels.Customer;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.wallet.ui.tracking.event.WalletTopUpCreditCardSelectionEventKt;
import datamodels.Restaurant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.models.pay.BNPLOrderPaymentFailureTrackingModel;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bHÖ\u0003J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\t\u0010\u0018\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/tracking/event/BnplOrderPaymentFailureEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "failureTrackingModel", "Ltracking/models/pay/BNPLOrderPaymentFailureTrackingModel;", "(Ltracking/models/pay/BNPLOrderPaymentFailureTrackingModel;)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "copy", "equals", "", "other", "featureName", "getPaymentMethods", "restaurant", "Ldatamodels/Restaurant;", "getShopStatus", "statusType", "", "getTalabatCreditBalance", "hashCode", "name", "platforms", "", "restaurantTypeForOrderingExperience", "toString", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BnplOrderPaymentFailureEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "transaction_failed";
    @NotNull
    private final BNPLOrderPaymentFailureTrackingModel failureTrackingModel;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/tracking/event/BnplOrderPaymentFailureEvent$Companion;", "", "()V", "EVENT_NAME", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BnplOrderPaymentFailureEvent(@NotNull BNPLOrderPaymentFailureTrackingModel bNPLOrderPaymentFailureTrackingModel) {
        Intrinsics.checkNotNullParameter(bNPLOrderPaymentFailureTrackingModel, "failureTrackingModel");
        this.failureTrackingModel = bNPLOrderPaymentFailureTrackingModel;
    }

    private final BNPLOrderPaymentFailureTrackingModel component1() {
        return this.failureTrackingModel;
    }

    public static /* synthetic */ BnplOrderPaymentFailureEvent copy$default(BnplOrderPaymentFailureEvent bnplOrderPaymentFailureEvent, BNPLOrderPaymentFailureTrackingModel bNPLOrderPaymentFailureTrackingModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bNPLOrderPaymentFailureTrackingModel = bnplOrderPaymentFailureEvent.failureTrackingModel;
        }
        return bnplOrderPaymentFailureEvent.copy(bNPLOrderPaymentFailureTrackingModel);
    }

    private final String getPaymentMethods(Restaurant restaurant) {
        String str;
        boolean z11;
        boolean z12;
        if (restaurant != null) {
            StringBuilder sb2 = new StringBuilder();
            boolean z13 = true;
            if (restaurant.acceptsCash) {
                if (sb2.length() > 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    sb2.append(",");
                }
                sb2.append("cash");
            }
            if (restaurant.acceptsDebit) {
                if (sb2.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    sb2.append(",");
                }
                sb2.append("debit_card");
            }
            if (restaurant.acceptsCredit) {
                if (sb2.length() <= 0) {
                    z13 = false;
                }
                if (z13) {
                    sb2.append(",");
                }
                sb2.append(WalletTopUpCreditCardSelectionEventKt.ATTRIBUTE_VALUE_ORDER_PAYMENT_METHOD);
            }
            str = sb2.toString();
        } else {
            str = null;
        }
        if (str == null) {
            return "0.0";
        }
        return str;
    }

    private final String getShopStatus(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 4 ? i11 != 5 ? "0.0" : "pre-order" : "prayer" : SDKCoreEvent.ForegroundStatus.VALUE_BUSY : "closed" : "open";
    }

    private final String getTalabatCreditBalance() {
        Customer instance = Customer.getInstance();
        if (instance == null || !instance.isLoggedIn() || instance.getCustomerInfo() == null) {
            return "0.0";
        }
        return String.valueOf(instance.getCustomerInfo().talabatCredit);
    }

    private final String restaurantTypeForOrderingExperience(Restaurant restaurant) {
        return restaurant != null ? (restaurant.isTalabatGo || restaurant.providesTrackorder || restaurant.provideOrderSatus) ? "TGO" : "shop_delivery" : "0.0";
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Boolean bool;
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        boolean z11;
        String str5;
        String str6;
        boolean z12;
        String str7;
        int i11;
        boolean z13;
        String str8;
        Boolean bool2;
        String str9;
        boolean z14;
        String str10;
        boolean z15;
        String str11;
        String str12;
        String num2;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        PolygonEvents polygonEvents = this.failureTrackingModel.getPolygonEvents();
        if (polygonEvents != null) {
            bool = Boolean.valueOf(polygonEvents.isActive);
        } else {
            bool = "0.0";
        }
        PolygonEvents polygonEvents2 = this.failureTrackingModel.getPolygonEvents();
        if (polygonEvents2 != null) {
            str = polygonEvents2.eventType;
        } else {
            str = null;
        }
        if (str == null) {
            str = "0.0";
        }
        PolygonEvents polygonEvents3 = this.failureTrackingModel.getPolygonEvents();
        if (polygonEvents3 != null) {
            str2 = polygonEvents3.eventMsg;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "0.0";
        }
        PolygonEvents polygonEvents4 = this.failureTrackingModel.getPolygonEvents();
        if (polygonEvents4 != null) {
            num = Integer.valueOf(polygonEvents4.eventValue);
        } else {
            num = "0.0";
        }
        Restaurant restaurant = this.failureTrackingModel.getRestaurant();
        String str13 = "";
        if (restaurant == null || (str3 = Integer.valueOf(restaurant.f13872id).toString()) == null) {
            str3 = str13;
        }
        Restaurant restaurant2 = this.failureTrackingModel.getRestaurant();
        if (restaurant2 != null) {
            str4 = restaurant2.f13873name;
        } else {
            str4 = null;
        }
        if (str4 == null || str4.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str5 = "0.0";
        } else {
            Restaurant restaurant3 = this.failureTrackingModel.getRestaurant();
            if (restaurant3 != null) {
                str5 = restaurant3.f13873name;
            } else {
                str5 = null;
            }
        }
        Restaurant restaurant4 = this.failureTrackingModel.getRestaurant();
        if (restaurant4 != null) {
            str6 = restaurant4.branchName;
        } else {
            str6 = null;
        }
        if (str6 == null || str6.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            str7 = "0.0";
        } else {
            Restaurant restaurant5 = this.failureTrackingModel.getRestaurant();
            if (restaurant5 != null) {
                str7 = restaurant5.branchName;
            } else {
                str7 = null;
            }
        }
        Restaurant restaurant6 = this.failureTrackingModel.getRestaurant();
        if (!(restaurant6 == null || (num2 = Integer.valueOf(restaurant6.branchId).toString()) == null)) {
            str13 = num2;
        }
        Restaurant restaurant7 = this.failureTrackingModel.getRestaurant();
        if (restaurant7 != null) {
            i11 = restaurant7.statusType;
        } else {
            i11 = 0;
        }
        String shopStatus = getShopStatus(i11);
        Restaurant restaurant8 = this.failureTrackingModel.getRestaurant();
        if (restaurant8 != null) {
            z13 = Intrinsics.areEqual((Object) restaurant8.isPickup(), (Object) Boolean.TRUE);
        } else {
            z13 = false;
        }
        if (z13) {
            Restaurant restaurant9 = this.failureTrackingModel.getRestaurant();
            if (restaurant9 != null) {
                str8 = restaurant9.deliveryMode();
            } else {
                str8 = null;
            }
        } else {
            str8 = restaurantTypeForOrderingExperience(this.failureTrackingModel.getRestaurant());
        }
        Restaurant restaurant10 = this.failureTrackingModel.getRestaurant();
        if (restaurant10 != null) {
            bool2 = restaurant10.isPickup();
        } else {
            bool2 = null;
        }
        String valueOf = String.valueOf(bool2);
        Restaurant restaurant11 = this.failureTrackingModel.getRestaurant();
        if (restaurant11 != null) {
            str9 = restaurant11.deliveryTime;
        } else {
            str9 = null;
        }
        String str14 = getPaymentMethods(this.failureTrackingModel.getRestaurant()) + ",bnpl";
        String defaultPaymentMethod = this.failureTrackingModel.getDefaultPaymentMethod();
        if (defaultPaymentMethod == null || defaultPaymentMethod.length() == 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            str10 = "0.0";
        } else {
            str10 = this.failureTrackingModel.getDefaultPaymentMethod();
        }
        String paymentMethod = this.failureTrackingModel.getPaymentMethod();
        String errorMessage = this.failureTrackingModel.getErrorMessage();
        if (errorMessage == null || errorMessage.length() == 0) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            str11 = "0.0";
        } else {
            str11 = this.failureTrackingModel.getErrorMessage();
        }
        String errorCode = this.failureTrackingModel.getErrorCode();
        String errorDetail = this.failureTrackingModel.getErrorDetail();
        if (this.failureTrackingModel.getContactlessEnabled()) {
            str12 = "contactless";
        } else {
            str12 = "regular";
        }
        return MapsKt__MapsKt.mapOf(TuplesKt.to("floodActive", bool), TuplesKt.to("floodType", str), TuplesKt.to("floodMessage", str2), TuplesKt.to("floodValue", num), TuplesKt.to("chainId", str3), TuplesKt.to("chainShops", "0.0"), TuplesKt.to("chainName", str5), TuplesKt.to("shopName", str7), TuplesKt.to("shopId", str13), TuplesKt.to("shopStatus", shopStatus), TuplesKt.to("deliveryProvider", str8), TuplesKt.to("orderPickup", valueOf), TuplesKt.to("shopDeliveryTime", str9), TuplesKt.to("shopPaymentMethods", str14), TuplesKt.to(BnplOrderPaymentFailureEventKt.ATTRIBUTE_KEY_OTHERS_ORDER_PAYMENT_METHOD_DEFAULT, str10), TuplesKt.to("orderPaymentMethod", paymentMethod), TuplesKt.to("transactionId", "0.0"), TuplesKt.to(BnplOrderPaymentFailureEventKt.ATTRIBUTE_KEY_OTHERS_TRANSACTION_FAIL_REASON, str11), TuplesKt.to("errorCode", errorCode), TuplesKt.to("errorDetail", errorDetail), TuplesKt.to(BnplOrderPaymentFailureEventKt.ATTRIBUTE_KEY_OTHERS_EXPEDITION_TYPE, "delivery"), TuplesKt.to(BnplOrderPaymentFailureEventKt.ATTRIBUTE_KEY_OTHERS_CONTACTLESS_DELIVERY, str12), TuplesKt.to(BnplOrderPaymentFailureEventKt.ATTRIBUTE_KEY_OTHERS_DELIVERY_ADDRESS_STATUS, "0.0"), TuplesKt.to("userOnlinePaymentMethods", "credit:" + getTalabatCreditBalance()));
    }

    @NotNull
    public final BnplOrderPaymentFailureEvent copy(@NotNull BNPLOrderPaymentFailureTrackingModel bNPLOrderPaymentFailureTrackingModel) {
        Intrinsics.checkNotNullParameter(bNPLOrderPaymentFailureTrackingModel, "failureTrackingModel");
        return new BnplOrderPaymentFailureEvent(bNPLOrderPaymentFailureTrackingModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BnplOrderPaymentFailureEvent) && Intrinsics.areEqual((Object) this.failureTrackingModel, (Object) ((BnplOrderPaymentFailureEvent) obj).failureTrackingModel);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "BNPL";
    }

    public int hashCode() {
        return this.failureTrackingModel.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EVENT_NAME;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public String toString() {
        BNPLOrderPaymentFailureTrackingModel bNPLOrderPaymentFailureTrackingModel = this.failureTrackingModel;
        return "BnplOrderPaymentFailureEvent(failureTrackingModel=" + bNPLOrderPaymentFailureTrackingModel + ")";
    }
}
