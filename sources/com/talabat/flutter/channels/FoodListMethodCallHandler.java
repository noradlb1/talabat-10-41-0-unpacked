package com.talabat.flutter.channels;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import buisnessmodels.Customer;
import com.talabat.domain.address.Address;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.location.SelectedLocationProviderImpl;
import com.talabat.location.UserLocation;
import com.talabat.talabatcommon.extentions.DoubleKt;
import datamodels.CustomerInfo;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.perseus.TalabatPerseus;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/flutter/channels/FoodListMethodCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "isListView", "", "latitude", "", "longitude", "areaId", "", "cityId", "countryId", "", "areaName", "(ZDDLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "callback", "Lcom/talabat/flutter/channels/IFoodListMethodCallback;", "handleGetLocationInfo", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "setCallback", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FoodListMethodCallHandler implements MethodChannel.MethodCallHandler {
    @NotNull
    private final String areaId;
    @NotNull
    private final String areaName;
    private IFoodListMethodCallback callback;
    @NotNull
    private final String cityId;
    private final int countryId;
    private final boolean isListView;
    private final double latitude;
    private final double longitude;

    public FoodListMethodCallHandler(boolean z11, double d11, double d12, @NotNull String str, @NotNull String str2, int i11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "areaId");
        Intrinsics.checkNotNullParameter(str2, "cityId");
        Intrinsics.checkNotNullParameter(str3, "areaName");
        this.isListView = z11;
        this.latitude = d11;
        this.longitude = d12;
        this.areaId = str;
        this.cityId = str2;
        this.countryId = i11;
        this.areaName = str3;
    }

    private final void handleGetLocationInfo(MethodChannel.Result result) {
        UserLocation.WithAddress withAddress;
        String str;
        Address address;
        Address address2;
        Address address3;
        Customer instance = Customer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "customer");
        UserLocation selectedUserLocation = new SelectedLocationProviderImpl(instance).getSelectedUserLocation();
        String str2 = null;
        if (selectedUserLocation instanceof UserLocation.WithAddress) {
            withAddress = (UserLocation.WithAddress) selectedUserLocation;
        } else {
            withAddress = null;
        }
        String str3 = "";
        if (withAddress == null || (address3 = withAddress.getAddress()) == null || (str = address3.profileName) == null) {
            if (withAddress == null || (address2 = withAddress.getAddress()) == null) {
                str = null;
            } else {
                str = address2.geoAddressTitle;
            }
            if (str == null) {
                str = str3;
            }
        }
        if (!(withAddress == null || (address = withAddress.getAddress()) == null)) {
            str2 = address.block;
        }
        if (str2 != null) {
            str3 = str2;
        }
        result.success(MapsKt__MapsKt.mapOf(TuplesKt.to("countryId", Integer.valueOf(this.countryId)), TuplesKt.to("areaId", this.areaId), TuplesKt.to("areaName", this.areaName), TuplesKt.to("cityId", this.cityId), TuplesKt.to("latitude", Double.valueOf(this.latitude)), TuplesKt.to("longitude", Double.valueOf(this.longitude)), TuplesKt.to("title", str), TuplesKt.to("buildingName", str3)));
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Integer num;
        String str;
        String str2;
        int i11;
        Double d11;
        MethodCall methodCall2 = methodCall;
        MethodChannel.Result result2 = result;
        Intrinsics.checkNotNullParameter(methodCall2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result2, "result");
        String str3 = methodCall2.method;
        if (str3 != null) {
            IFoodListMethodCallback iFoodListMethodCallback = null;
            switch (str3.hashCode()) {
                case -1796047165:
                    if (str3.equals("food_list_screen_configuration")) {
                        result2.success(MapsKt__MapsJVMKt.mapOf(TuplesKt.to("vendorTileType", Integer.valueOf(this.isListView ? 1 : 0))));
                        return;
                    }
                    return;
                case -1745715089:
                    if (str3.equals("food-list-get-location-info")) {
                        handleGetLocationInfo(result2);
                        return;
                    }
                    return;
                case -1573762402:
                    if (str3.equals("navigate_to_search")) {
                        IFoodListMethodCallback iFoodListMethodCallback2 = this.callback;
                        if (iFoodListMethodCallback2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("callback");
                        } else {
                            iFoodListMethodCallback = iFoodListMethodCallback2;
                        }
                        iFoodListMethodCallback.navigateToSearch();
                        return;
                    }
                    return;
                case -1449267278:
                    if (str3.equals("vendor_selected")) {
                        Object obj = methodCall2.arguments;
                        if (obj != null) {
                            Object obj2 = ((HashMap) obj).get("vendor");
                            if (obj2 != null) {
                                Object obj3 = ((HashMap) obj2).get("branchId");
                                if (obj3 instanceof Integer) {
                                    num = (Integer) obj3;
                                } else {
                                    num = null;
                                }
                                if (num != null) {
                                    num.intValue();
                                    IFoodListMethodCallback iFoodListMethodCallback3 = this.callback;
                                    if (iFoodListMethodCallback3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("callback");
                                    } else {
                                        iFoodListMethodCallback = iFoodListMethodCallback3;
                                    }
                                    iFoodListMethodCallback.navigateToMenu(num.intValue());
                                    return;
                                }
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
                    }
                    return;
                case -804452580:
                    if (str3.equals("collection_selected")) {
                        Object obj4 = methodCall2.arguments;
                        if (obj4 != null) {
                            Object obj5 = ((HashMap) obj4).get("deeplink");
                            if (obj5 instanceof String) {
                                str = (String) obj5;
                            } else {
                                str = null;
                            }
                            if (str != null) {
                                IFoodListMethodCallback iFoodListMethodCallback4 = this.callback;
                                if (iFoodListMethodCallback4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                                } else {
                                    iFoodListMethodCallback = iFoodListMethodCallback4;
                                }
                                iFoodListMethodCallback.navigateToCollection(str);
                                return;
                            }
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
                    }
                    return;
                case -401213707:
                    if (str3.equals("navigate_back")) {
                        IFoodListMethodCallback iFoodListMethodCallback5 = this.callback;
                        if (iFoodListMethodCallback5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("callback");
                        } else {
                            iFoodListMethodCallback = iFoodListMethodCallback5;
                        }
                        iFoodListMethodCallback.onBackPressed();
                        return;
                    }
                    return;
                case 816276712:
                    if (str3.equals("pickup_tab_selected")) {
                        IFoodListMethodCallback iFoodListMethodCallback6 = this.callback;
                        if (iFoodListMethodCallback6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("callback");
                        } else {
                            iFoodListMethodCallback = iFoodListMethodCallback6;
                        }
                        iFoodListMethodCallback.navigateToPickup();
                        return;
                    }
                    return;
                case 959581849:
                    if (str3.equals("food-list-get-user-info")) {
                        Customer instance = Customer.getInstance();
                        CustomerInfo customerInfo = instance.getCustomerInfo();
                        if (customerInfo != null) {
                            str2 = customerInfo.encgid;
                        } else {
                            str2 = null;
                        }
                        if (str2 == null) {
                            str2 = "";
                        }
                        CustomerInfo customerInfo2 = instance.getCustomerInfo();
                        if (customerInfo2 != null) {
                            i11 = customerInfo2.f13850id;
                        } else {
                            i11 = 0;
                        }
                        CustomerInfo customerInfo3 = instance.getCustomerInfo();
                        if (customerInfo3 != null) {
                            d11 = Double.valueOf((double) customerInfo3.talabatCredit);
                        } else {
                            d11 = null;
                        }
                        result2.success(MapsKt__MapsKt.mapOf(TuplesKt.to("countryCode", new LocationDataFactory((Function0) null, (Function0) null, (Function0) null, (Function0) null, 15, (DefaultConstructorMarker) null).createLocationData(instance.getSelectedCustomerAddress()).getCountry()), TuplesKt.to("perseusClientId", TalabatPerseus.Companion.getMyClientId$default(TalabatPerseus.Companion, (Context) null, 1, (Object) null)), TuplesKt.to("customerId", Integer.valueOf(i11)), TuplesKt.to("talabatCredit", Double.valueOf(DoubleKt.orZero(d11))), TuplesKt.to("encgid", str2)));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void setCallback(@NotNull IFoodListMethodCallback iFoodListMethodCallback) {
        Intrinsics.checkNotNullParameter(iFoodListMethodCallback, "callback");
        this.callback = iFoodListMethodCallback;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FoodListMethodCallHandler(boolean z11, double d11, double d12, String str, String str2, int i11, String str3, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? true : z11, d11, d12, str, str2, i11, str3);
    }
}
