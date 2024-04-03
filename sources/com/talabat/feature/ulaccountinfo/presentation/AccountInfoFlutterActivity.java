package com.talabat.feature.ulaccountinfo.presentation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import buisnessmodels.Customer;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.feature.ulaccountinfo.presentation.channels.AccountInfoMethodChannel;
import com.talabat.feature.ulaccountinfo.presentation.channels.AccountInfoMethodChannelCallback;
import com.talabat.feature.ulaccountinfo.presentation.utils.AccountInfoFlutterConstants;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import datamodels.CustomerInfo;
import datamodels.RegistrationType;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J,\u0010\u0011\u001a\u00020\u00072\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0014`\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/ulaccountinfo/presentation/AccountInfoFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/feature/ulaccountinfo/presentation/channels/AccountInfoMethodChannelCallback;", "()V", "accountInfoMethodChannel", "Lio/flutter/plugin/common/MethodChannel;", "closeAccountInfoScreen", "", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getRegistrationType", "Ldatamodels/RegistrationType;", "registrationType", "", "getRoute", "logOutAndClearCache", "onBackPressed", "saveSuccessResult", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "com_talabat_feature_ul-account-info_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AccountInfoFlutterActivity extends TalabatFlutterFragmentActivity implements AccountInfoMethodChannelCallback {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private MethodChannel accountInfoMethodChannel;

    public AccountInfoFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
    }

    private final RegistrationType getRegistrationType(String str) {
        if (str == null) {
            return RegistrationType.UNDEFINED;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "0")) {
            return RegistrationType.EMAIL;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "1")) {
            return RegistrationType.MOBILE_NUMBER;
        }
        return RegistrationType.UNDEFINED;
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void closeAccountInfoScreen() {
        onBackPressed();
    }

    @NotNull
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.DEEPLINK;
    }

    @NotNull
    public String getRoute() {
        return AccountInfoFlutterConstants.ACCOUNT_INFO_ROUTE;
    }

    public void logOutAndClearCache() {
        setResult(2003);
        finish();
    }

    public void onBackPressed() {
        if (isTaskRoot()) {
            Navigator.Companion.navigate((Context) this, new NavigatorModel("talabat.action.homeScreen", (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
        }
        finish();
    }

    public void saveSuccessResult(@NotNull HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, Param.MAP);
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        Intrinsics.checkNotNullExpressionValue(customerInfo, "getInstance().customerInfo");
        customerInfo.firstName = String.valueOf(hashMap.get("firstName"));
        customerInfo.lastName = String.valueOf(hashMap.get("lastName"));
        customerInfo.subscribedToSMS = Boolean.parseBoolean(String.valueOf(hashMap.get("subscribedToSMS")));
        customerInfo.subscribedToNewsletter = Boolean.parseBoolean(String.valueOf(hashMap.get("subscribedToNewsletter")));
        customerInfo.setGender(Boolean.parseBoolean(String.valueOf(hashMap.get("gender"))));
        customerInfo.birthday = String.valueOf(hashMap.get("birthDate"));
        customerInfo.registrationType = getRegistrationType(String.valueOf(hashMap.get("registrationType")));
        Customer.getInstance().setCustomerInfo(customerInfo);
        closeAccountInfoScreen();
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        this.accountInfoMethodChannel = new MethodChannel(flutterEngine.getDartExecutor(), AccountInfoFlutterConstants.ACCOUNT_INFO_CHANNEL);
        AccountInfoMethodChannel accountInfoMethodChannel2 = new AccountInfoMethodChannel();
        accountInfoMethodChannel2.setCallback(this);
        MethodChannel methodChannel = this.accountInfoMethodChannel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountInfoMethodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(accountInfoMethodChannel2);
    }
}
