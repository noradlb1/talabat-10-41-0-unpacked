package com.talabat.feature.nfvinvendorsearch.presentation.handler;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.feature.darkstoresvendor.domain.model.VendorParams;
import com.talabat.feature.darkstoresvendor.domain.usecase.GetVendorUseCase;
import com.talabat.feature.nfvinvendorsearch.presentation.mapper.FlutterVendorToMapMapper;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.model.NavigationCommand;
import com.talabat.feature.nfvinvendorsearch.presentation.model.ProductInfo;
import com.talabat.feature.nfvinvendorsearch.presentation.model.VoucherDetails;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import javax.inject.Inject;
import jn.a;
import jn.b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/handler/QCommerceMethodHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "getVendorUseCase", "Lcom/talabat/feature/darkstoresvendor/domain/usecase/GetVendorUseCase;", "vendorMapper", "Lcom/talabat/feature/nfvinvendorsearch/presentation/mapper/FlutterVendorToMapMapper;", "(Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;Lcom/talabat/feature/darkstoresvendor/domain/usecase/GetVendorUseCase;Lcom/talabat/feature/nfvinvendorsearch/presentation/mapper/FlutterVendorToMapMapper;)V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "navigationCommands", "Landroidx/lifecycle/LiveData;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand;", "getNavigationCommands", "()Landroidx/lifecycle/LiveData;", "navigationCommandsMutable", "Landroidx/lifecycle/MutableLiveData;", "dispose", "", "getVendor", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "openCampaignProductListing", "arguments", "", "openCart", "openCheckout", "openProductDetails", "openVendorLanding", "openVoucherProductListing", "setUp", "dartExecutor", "Lio/flutter/embedding/engine/dart/DartExecutor;", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QCommerceMethodHandler implements MethodChannel.MethodCallHandler {
    @NotNull
    private final FlutterConfigurationParams configurationParams;
    @NotNull
    private final CompositeDisposable disposable = new CompositeDisposable();
    @NotNull
    private final GetVendorUseCase getVendorUseCase;
    @NotNull
    private final LiveData<NavigationCommand> navigationCommands;
    @NotNull
    private final MutableLiveData<NavigationCommand> navigationCommandsMutable;
    @NotNull
    private final FlutterVendorToMapMapper vendorMapper;

    @Inject
    public QCommerceMethodHandler(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull GetVendorUseCase getVendorUseCase2, @NotNull FlutterVendorToMapMapper flutterVendorToMapMapper) {
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
        Intrinsics.checkNotNullParameter(getVendorUseCase2, "getVendorUseCase");
        Intrinsics.checkNotNullParameter(flutterVendorToMapMapper, "vendorMapper");
        this.configurationParams = flutterConfigurationParams;
        this.getVendorUseCase = getVendorUseCase2;
        this.vendorMapper = flutterVendorToMapMapper;
        MutableLiveData<NavigationCommand> mutableLiveData = new MutableLiveData<>();
        this.navigationCommandsMutable = mutableLiveData;
        this.navigationCommands = mutableLiveData;
    }

    private final void getVendor(MethodChannel.Result result) {
        this.disposable.add(this.getVendorUseCase.invoke(new VendorParams(this.configurationParams.getVendorCode(), this.configurationParams.getGlobalEntityId(), this.configurationParams.getLatitude(), this.configurationParams.getLongitude(), this.configurationParams.getCustomerId())).subscribe(new a(result, this), new b(result)));
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendor$lambda-10  reason: not valid java name */
    public static final void m10233getVendor$lambda10(MethodChannel.Result result, Throwable th2) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.error("0", th2.getMessage(), th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendor$lambda-9  reason: not valid java name */
    public static final void m10234getVendor$lambda9(MethodChannel.Result result, QCommerceMethodHandler qCommerceMethodHandler, Vendor vendor) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(qCommerceMethodHandler, "this$0");
        result.success(qCommerceMethodHandler.vendorMapper.apply((Pair<Vendor, FlutterConfigurationParams>) new Pair(vendor, qCommerceMethodHandler.configurationParams)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void openCampaignProductListing(java.lang.Object r4, io.flutter.plugin.common.MethodChannel.Result r5) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x0008
            java.util.Map r4 = (java.util.Map) r4
            goto L_0x0009
        L_0x0008:
            r4 = r1
        L_0x0009:
            if (r4 == 0) goto L_0x002d
            java.lang.String r0 = "bannerId"
            java.lang.Object r4 = r4.get(r0)
            boolean r0 = r4 instanceof java.lang.String
            if (r0 == 0) goto L_0x0018
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0019
        L_0x0018:
            r4 = r1
        L_0x0019:
            if (r4 == 0) goto L_0x002d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "campaign-"
            r0.append(r2)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            goto L_0x002e
        L_0x002d:
            r4 = r1
        L_0x002e:
            if (r4 == 0) goto L_0x0039
            int r0 = r4.length()
            if (r0 != 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r0 = 0
            goto L_0x003a
        L_0x0039:
            r0 = 1
        L_0x003a:
            if (r0 == 0) goto L_0x0044
            java.lang.String r4 = "Can not find 'bannerId' in arguments for method channel 'openCampaignProductListing'"
            java.lang.String r0 = "101"
            r5.error(r0, r4, r1)
            goto L_0x0051
        L_0x0044:
            androidx.lifecycle.MutableLiveData<com.talabat.feature.nfvinvendorsearch.presentation.model.NavigationCommand> r0 = r3.navigationCommandsMutable
            com.talabat.feature.nfvinvendorsearch.presentation.model.NavigationCommand$BannerCampaignProductListing r2 = new com.talabat.feature.nfvinvendorsearch.presentation.model.NavigationCommand$BannerCampaignProductListing
            r2.<init>(r4)
            r0.postValue(r2)
            r5.success(r1)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.nfvinvendorsearch.presentation.handler.QCommerceMethodHandler.openCampaignProductListing(java.lang.Object, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    private final void openCart(MethodChannel.Result result) {
        this.navigationCommandsMutable.postValue(NavigationCommand.Cart.INSTANCE);
        result.success((Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void openCheckout(java.lang.Object r4, io.flutter.plugin.common.MethodChannel.Result r5) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x0008
            java.util.Map r4 = (java.util.Map) r4
            goto L_0x0009
        L_0x0008:
            r4 = r1
        L_0x0009:
            if (r4 == 0) goto L_0x0018
            java.lang.String r0 = "specialRequest"
            java.lang.Object r4 = r4.get(r0)
            boolean r0 = r4 instanceof java.lang.String
            if (r0 == 0) goto L_0x0018
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0019
        L_0x0018:
            r4 = r1
        L_0x0019:
            if (r4 != 0) goto L_0x001d
            java.lang.String r4 = ""
        L_0x001d:
            androidx.lifecycle.MutableLiveData<com.talabat.feature.nfvinvendorsearch.presentation.model.NavigationCommand> r0 = r3.navigationCommandsMutable
            com.talabat.feature.nfvinvendorsearch.presentation.model.NavigationCommand$Checkout r2 = new com.talabat.feature.nfvinvendorsearch.presentation.model.NavigationCommand$Checkout
            r2.<init>(r4)
            r0.postValue(r2)
            r5.success(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.nfvinvendorsearch.presentation.handler.QCommerceMethodHandler.openCheckout(java.lang.Object, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    private final void openProductDetails(Object obj, MethodChannel.Result result) {
        Map map;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z11;
        if (obj instanceof Map) {
            map = (Map) obj;
        } else {
            map = null;
        }
        if (map != null) {
            Object obj2 = map.get("productId");
            if (obj2 instanceof String) {
                str = (String) obj2;
            } else {
                str = null;
            }
            String str5 = "";
            if (str == null) {
                str = str5;
            }
            Object obj3 = map.get("swimlaneRequestId");
            if (obj3 instanceof String) {
                str2 = (String) obj3;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = str5;
            }
            Object obj4 = map.get("searchRequestId");
            if (obj4 instanceof String) {
                str3 = (String) obj4;
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = str5;
            }
            Object obj5 = map.get("eventOrigin");
            if (obj5 instanceof String) {
                str4 = (String) obj5;
            } else {
                str4 = null;
            }
            if (str4 != null) {
                str5 = str4;
            }
            ProductInfo productInfo = new ProductInfo(str, str5, str2, str3);
            if (productInfo.getProductId().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                productInfo = null;
            }
            if (productInfo != null) {
                this.navigationCommandsMutable.postValue(new NavigationCommand.ProductDetails(productInfo));
            }
        }
        result.success((Object) null);
    }

    private final void openVendorLanding(MethodChannel.Result result) {
        this.navigationCommandsMutable.postValue(NavigationCommand.VendorLanding.INSTANCE);
        result.success((Object) null);
    }

    private final void openVoucherProductListing(Object obj, MethodChannel.Result result) {
        Map map;
        String str;
        String str2;
        String str3;
        boolean z11;
        if (obj instanceof Map) {
            map = (Map) obj;
        } else {
            map = null;
        }
        if (map != null) {
            Object obj2 = map.get("id");
            if (obj2 instanceof String) {
                str = (String) obj2;
            } else {
                str = null;
            }
            String str4 = "";
            if (str == null) {
                str = str4;
            }
            Object obj3 = map.get("name");
            if (obj3 instanceof String) {
                str2 = (String) obj3;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = str4;
            }
            Object obj4 = map.get("eventOrigin");
            if (obj4 instanceof String) {
                str3 = (String) obj4;
            } else {
                str3 = null;
            }
            if (str3 != null) {
                str4 = str3;
            }
            VoucherDetails voucherDetails = new VoucherDetails(str, str2, str4);
            if (voucherDetails.getId().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                voucherDetails = null;
            }
            if (voucherDetails != null) {
                this.navigationCommandsMutable.postValue(new NavigationCommand.VoucherProductListing(voucherDetails));
            }
        }
        result.success((Object) null);
    }

    public final void dispose() {
        this.disposable.clear();
    }

    @NotNull
    public final LiveData<NavigationCommand> getNavigationCommands() {
        return this.navigationCommands;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1502331515:
                    if (str.equals("openVendorLanding")) {
                        openVendorLanding(result);
                        return;
                    }
                    break;
                case -521611079:
                    if (str.equals("openVoucherProductListing")) {
                        Object obj = methodCall.arguments;
                        Intrinsics.checkNotNullExpressionValue(obj, "call.arguments");
                        openVoucherProductListing(obj, result);
                        return;
                    }
                    break;
                case -505159542:
                    if (str.equals("openCart")) {
                        openCart(result);
                        return;
                    }
                    break;
                case -269750864:
                    if (str.equals("openCheckout")) {
                        Object obj2 = methodCall.arguments;
                        Intrinsics.checkNotNullExpressionValue(obj2, "call.arguments");
                        openCheckout(obj2, result);
                        return;
                    }
                    break;
                case 875939902:
                    if (str.equals("getVendor")) {
                        getVendor(result);
                        return;
                    }
                    break;
                case 965495613:
                    if (str.equals("openProductDetails")) {
                        Object obj3 = methodCall.arguments;
                        Intrinsics.checkNotNullExpressionValue(obj3, "call.arguments");
                        openProductDetails(obj3, result);
                        return;
                    }
                    break;
                case 1002584751:
                    if (str.equals("openCampaignProductListing")) {
                        Object obj4 = methodCall.arguments;
                        Intrinsics.checkNotNullExpressionValue(obj4, "call.arguments");
                        openCampaignProductListing(obj4, result);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    public final void setUp(@NotNull DartExecutor dartExecutor) {
        Intrinsics.checkNotNullParameter(dartExecutor, "dartExecutor");
        new MethodChannel(dartExecutor, "com.talabat.flutter/qcommerce").setMethodCallHandler(this);
    }
}
