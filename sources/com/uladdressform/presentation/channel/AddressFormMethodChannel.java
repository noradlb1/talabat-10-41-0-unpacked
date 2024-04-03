package com.uladdressform.presentation.channel;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/uladdressform/presentation/channel/AddressFormMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/uladdressform/presentation/channel/IAddressFormMethodChannel;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setCallback", "Companion", "com_talabat_feature_ul-address-form_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class AddressFormMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String METHOD_getAddressFormRequestInfo = "getAddressFormRequestInfo";
    @NotNull
    public static final String METHOD_navigateFromAddressToCheckout = "addressFormCompletion";
    @NotNull
    public static final String METHOD_navigateToMapScreen = "navigateToMap";
    @Nullable
    private IAddressFormMethodChannel callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/uladdressform/presentation/channel/AddressFormMethodChannel$Companion;", "", "()V", "METHOD_getAddressFormRequestInfo", "", "METHOD_navigateFromAddressToCheckout", "METHOD_navigateToMapScreen", "com_talabat_feature_ul-address-form_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Map map;
        AddressFormMapBundle fromFlutterMap;
        IAddressFormMethodChannel iAddressFormMethodChannel;
        IAddressFormMethodChannel iAddressFormMethodChannel2;
        AddressFormBundle fromFlutterMap2;
        AddressFormBundle fromFlutterMap3;
        IAddressFormMethodChannel iAddressFormMethodChannel3;
        Object obj;
        AddressFormRequestParamBundle addressFormRequestParamBundle;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -411004432) {
                if (hashCode != -61991724) {
                    if (hashCode == 600592603 && str.equals(METHOD_getAddressFormRequestInfo)) {
                        Map<String, Object> map2 = null;
                        try {
                            Result.Companion companion = Result.Companion;
                            IAddressFormMethodChannel iAddressFormMethodChannel4 = this.callback;
                            if (iAddressFormMethodChannel4 != null) {
                                addressFormRequestParamBundle = iAddressFormMethodChannel4.getAddressFormUIRequestInfo();
                            } else {
                                addressFormRequestParamBundle = null;
                            }
                            obj = Result.m6329constructorimpl(addressFormRequestParamBundle);
                        } catch (Throwable th2) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
                        }
                        if (Result.m6336isSuccessimpl(obj)) {
                            AddressFormRequestParamBundle addressFormRequestParamBundle2 = (AddressFormRequestParamBundle) obj;
                            if (addressFormRequestParamBundle2 != null) {
                                map2 = addressFormRequestParamBundle2.toMap();
                            }
                            result.success(map2);
                        }
                        Result.m6332exceptionOrNullimpl(obj);
                    }
                } else if (str.equals(METHOD_navigateFromAddressToCheckout)) {
                    Map map3 = (Map) methodCall.argument("address");
                    String str2 = (String) methodCall.argument("addressActionType");
                    String str3 = (String) methodCall.argument("addressId");
                    if (str2 != null) {
                        int hashCode2 = str2.hashCode();
                        if (hashCode2 != -1335458389) {
                            if (hashCode2 != 96417) {
                                if (hashCode2 == 3108362 && str2.equals("edit") && map3 != null && (fromFlutterMap3 = AddressFormBundle.Companion.fromFlutterMap(map3)) != null && (iAddressFormMethodChannel3 = this.callback) != null) {
                                    iAddressFormMethodChannel3.onEditAddressSuccessfully(fromFlutterMap3);
                                }
                            } else if (str2.equals(ProductAction.ACTION_ADD) && map3 != null && (fromFlutterMap2 = AddressFormBundle.Companion.fromFlutterMap(map3)) != null) {
                                IAddressFormMethodChannel iAddressFormMethodChannel5 = this.callback;
                                if (iAddressFormMethodChannel5 != null) {
                                    iAddressFormMethodChannel5.onAddAddressSuccessfully(fromFlutterMap2);
                                }
                                IAddressFormMethodChannel iAddressFormMethodChannel6 = this.callback;
                                if (iAddressFormMethodChannel6 != null) {
                                    iAddressFormMethodChannel6.moveForward(fromFlutterMap2);
                                }
                            }
                        } else if (str2.equals("delete") && (iAddressFormMethodChannel2 = this.callback) != null) {
                            iAddressFormMethodChannel2.delete(str3);
                        }
                    }
                }
            } else if (str.equals(METHOD_navigateToMapScreen) && (map = (Map) methodCall.argument("mapData")) != null && (fromFlutterMap = AddressFormMapBundle.Companion.fromFlutterMap(map)) != null && (iAddressFormMethodChannel = this.callback) != null) {
                iAddressFormMethodChannel.navigateToMapScreen(fromFlutterMap);
            }
        }
    }

    public final void setCallback(@Nullable IAddressFormMethodChannel iAddressFormMethodChannel) {
        this.callback = iAddressFormMethodChannel;
    }
}
