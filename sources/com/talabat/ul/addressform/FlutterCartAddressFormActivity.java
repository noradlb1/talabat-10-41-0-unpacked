package com.talabat.ul.addressform;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import buisnessmodels.Customer;
import com.talabat.R;
import com.talabat.domain.address.Address;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.uladdressform.presentation.channel.AddressFormBundle;
import com.uladdressform.presentation.channel.AddressFormMapBundle;
import com.uladdressform.presentation.channel.AddressFormMethodChannel;
import com.uladdressform.presentation.channel.AddressFormRequestParamBundle;
import com.uladdressform.presentation.channel.IAddressFormMethodChannel;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010'\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020!2\u0006\u0010-\u001a\u00020.H\u0002J\u0012\u00100\u001a\u00020!2\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u00102\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u000104H\u0014J\b\u00105\u001a\u00020!H\u0014J\u0010\u00106\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\b\u00107\u001a\u00020!H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020:H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\t¨\u0006;"}, d2 = {"Lcom/talabat/ul/addressform/FlutterCartAddressFormActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/uladdressform/presentation/channel/IAddressFormMethodChannel;", "()V", "addressFormMethodChannel", "Lio/flutter/plugin/common/MethodChannel;", "addressId", "", "getAddressId", "()Ljava/lang/String;", "channel", "Lcom/uladdressform/presentation/channel/AddressFormMethodChannel;", "flutterAddressFormFragment", "Lcom/talabat/ul/addressform/FlutterAddressFormFragment;", "latitude", "", "getLatitude", "()Ljava/lang/Double;", "longitude", "getLongitude", "origin", "getOrigin", "refreshLocation", "", "getRefreshLocation", "()Z", "setRefreshLocation", "(Z)V", "vendorId", "getVendorId", "createAddressFormRequestParamBundle", "Lcom/uladdressform/presentation/channel/AddressFormRequestParamBundle;", "delete", "", "getAddressFormUIRequestInfo", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getRoute", "moveForward", "it", "Lcom/uladdressform/presentation/channel/AddressFormBundle;", "navigateToMapScreen", "Lcom/uladdressform/presentation/channel/AddressFormMapBundle;", "onAddAddressSuccessfully", "onAddressAddSuccess", "address", "Lcom/talabat/domain/address/Address;", "onAddressEditSuccess", "onAddressesDeleted", "selectedId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditAddressSuccessfully", "setOrientation", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterCartAddressFormActivity extends TalabatFlutterFragmentActivity implements IAddressFormMethodChannel {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private MethodChannel addressFormMethodChannel;
    @Nullable
    private AddressFormMethodChannel channel;
    @Nullable
    private FlutterAddressFormFragment flutterAddressFormFragment;
    private boolean refreshLocation;

    public FlutterCartAddressFormActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
    }

    private final AddressFormRequestParamBundle createAddressFormRequestParamBundle() {
        String str;
        String str2;
        String str3;
        Double latitude = getLatitude();
        Double longitude = getLongitude();
        if (latitude == null || longitude == null) {
            return null;
        }
        String addressId = getAddressId();
        if (addressId == null) {
            str = "";
        } else {
            str = addressId;
        }
        String origin = getOrigin();
        if (origin == null) {
            str2 = "";
        } else {
            str2 = origin;
        }
        boolean z11 = this.refreshLocation;
        String vendorId = getVendorId();
        if (vendorId == null) {
            str3 = "";
        } else {
            str3 = vendorId;
        }
        return new AddressFormRequestParamBundle(latitude.doubleValue(), longitude.doubleValue(), str, str2, str3, z11, true);
    }

    private final String getAddressId() {
        return getIntent().getStringExtra("addressId");
    }

    private final Double getLatitude() {
        String stringExtra = getIntent().getStringExtra("latitude");
        if (stringExtra != null) {
            return StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(stringExtra);
        }
        return null;
    }

    private final Double getLongitude() {
        String stringExtra = getIntent().getStringExtra("longitude");
        if (stringExtra != null) {
            return StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(stringExtra);
        }
        return null;
    }

    private final String getOrigin() {
        return getIntent().getStringExtra("origin");
    }

    private final String getVendorId() {
        return getIntent().getStringExtra("vendorId");
    }

    private final void onAddressAddSuccess(Address address) {
        Customer.getInstance().setSelectedCustomerAddress(this, address.f58343id, address.areaId);
        Toast.makeText(this, R.string.address_saved_successfully, 0).show();
        finish();
    }

    private final void onAddressEditSuccess(Address address) {
        if (Intrinsics.areEqual((Object) getOrigin(), (Object) "checkout")) {
            Customer.getInstance().setSelectedCustomerAddress(this, address.f58343id, address.areaId);
            GlobalDataModel.GEO_CORDINATES.isRefreshBrandAddress = true;
        }
        finish();
    }

    private final void onAddressesDeleted(String str) {
        Customer.getInstance().RemoveCustomerAddress(str);
    }

    private final void setOrientation() {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
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

    public void delete(@Nullable String str) {
        if (str != null) {
            onAddressesDeleted(str);
        }
    }

    @NotNull
    public AddressFormRequestParamBundle getAddressFormUIRequestInfo() {
        AddressFormRequestParamBundle createAddressFormRequestParamBundle = createAddressFormRequestParamBundle();
        if (createAddressFormRequestParamBundle != null) {
            return createAddressFormRequestParamBundle;
        }
        throw new IllegalStateException("method channel called before address form request info loaded");
    }

    @NotNull
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.ADDRESS_FORM_MAIN;
    }

    public final boolean getRefreshLocation() {
        return this.refreshLocation;
    }

    @NotNull
    public String getRoute() {
        return "/address-form";
    }

    public void moveForward(@NotNull AddressFormBundle addressFormBundle) {
        Intrinsics.checkNotNullParameter(addressFormBundle, "it");
        onAddressAddSuccess(addressFormBundle.toAddress());
    }

    public void navigateToMapScreen(@NotNull AddressFormMapBundle addressFormMapBundle) {
        Intrinsics.checkNotNullParameter(addressFormMapBundle, "it");
    }

    public void onAddAddressSuccessfully(@NotNull AddressFormBundle addressFormBundle) {
        Intrinsics.checkNotNullParameter(addressFormBundle, "it");
        Customer.getInstance().AddCustomerAddress(addressFormBundle.toAddress());
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setOrientation();
    }

    public void onDestroy() {
        super.onDestroy();
        this.flutterAddressFormFragment = null;
        AddressFormMethodChannel addressFormMethodChannel2 = this.channel;
        if (addressFormMethodChannel2 != null) {
            addressFormMethodChannel2.setCallback((IAddressFormMethodChannel) null);
        }
    }

    public void onEditAddressSuccessfully(@NotNull AddressFormBundle addressFormBundle) {
        Intrinsics.checkNotNullParameter(addressFormBundle, "it");
        Customer.getInstance().EditCustomerAddress(this, addressFormBundle.toAddress());
        onAddressEditSuccess(addressFormBundle.toAddress());
    }

    public final void setRefreshLocation(boolean z11) {
        this.refreshLocation = z11;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.setUpExtraChannels(flutterEngine);
        AddressFormMethodChannel addressFormMethodChannel2 = new AddressFormMethodChannel();
        this.channel = addressFormMethodChannel2;
        addressFormMethodChannel2.setCallback(this);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/address-form");
        this.addressFormMethodChannel = methodChannel;
        methodChannel.setMethodCallHandler(this.channel);
    }
}
