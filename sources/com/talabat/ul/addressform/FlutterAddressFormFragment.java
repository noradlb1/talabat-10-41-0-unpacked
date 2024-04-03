package com.talabat.ul.addressform;

import JsonModels.parser.UniversalGson;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import buisnessmodels.Customer;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.domain.address.Address;
import com.talabat.feature.uladdressform.domain.AddressFormFeatureApi;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.engine.PreWarmedEngines;
import com.talabat.fluttercore.presentation.PreWarmedFlutterFragment;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.talabatcore.logger.LogManager;
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
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0012\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u000bH\u0016J\b\u0010*\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006,"}, d2 = {"Lcom/talabat/ul/addressform/FlutterAddressFormFragment;", "Lcom/talabat/fluttercore/presentation/PreWarmedFlutterFragment;", "Lcom/uladdressform/presentation/channel/IAddressFormMethodChannel;", "()V", "addressFormMethodChannel", "Lio/flutter/plugin/common/MethodChannel;", "channel", "Lcom/uladdressform/presentation/channel/AddressFormMethodChannel;", "formUIRequestInfo", "Lcom/uladdressform/presentation/channel/AddressFormRequestParamBundle;", "refreshingLocation", "", "getRefreshingLocation", "()Z", "setRefreshingLocation", "(Z)V", "AddressFormRequestParamBundle", "delete", "", "addressId", "", "getAddressFormUIRequestInfo", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getRoute", "moveForward", "address", "Lcom/uladdressform/presentation/channel/AddressFormBundle;", "navigateToMapScreen", "mapData", "Lcom/uladdressform/presentation/channel/AddressFormMapBundle;", "onAddAddressSuccessfully", "it", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditAddressSuccessfully", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "shouldAttachEngineToActivity", "shouldDestroyEngineWithHost", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterAddressFormFragment extends PreWarmedFlutterFragment implements IAddressFormMethodChannel {
    @NotNull
    private static final String ADDRESS_FORM_METHOD_CHANNEL = "com.talabat.flutter/address-form";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EXTRAS_LATITUDE = "AddNewAddressFlutterActivity_latitude";
    @NotNull
    private static final String EXTRAS_LONGITUDE = "AddNewAddressFlutterActivity_longitude";
    @NotNull
    private static final String FROM = "from";
    @NotNull
    private static final String REFRESH_LOCATION = "refreshLocation";
    @NotNull
    private static final String VALUE = "value";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private MethodChannel addressFormMethodChannel;
    @Nullable
    private AddressFormMethodChannel channel;
    @Nullable
    private AddressFormRequestParamBundle formUIRequestInfo;
    private boolean refreshingLocation;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/ul/addressform/FlutterAddressFormFragment$Companion;", "", "()V", "ADDRESS_FORM_METHOD_CHANNEL", "", "EXTRAS_LATITUDE", "EXTRAS_LONGITUDE", "FROM", "REFRESH_LOCATION", "VALUE", "bundle", "Landroid/os/Bundle;", "latitude", "", "longitude", "addressString", "eventOrgin", "refreshLocation", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Bundle bundle(double d11, double d12, @Nullable String str, @NotNull String str2, boolean z11) {
            Intrinsics.checkNotNullParameter(str2, "eventOrgin");
            Bundle bundle = new Bundle();
            bundle.putDouble(FlutterAddressFormFragment.EXTRAS_LATITUDE, d11);
            bundle.putDouble(FlutterAddressFormFragment.EXTRAS_LONGITUDE, d12);
            bundle.putString("from", str2);
            bundle.putString("value", str);
            bundle.putBoolean(FlutterAddressFormFragment.REFRESH_LOCATION, z11);
            return bundle;
        }
    }

    public FlutterAddressFormFragment() {
        super(PreWarmedEngines.ENGINE_FOR_ADDRESS_FORM, (RemoteConfiguration) null, 2, (DefaultConstructorMarker) null);
    }

    private final AddressFormRequestParamBundle AddressFormRequestParamBundle() {
        String str;
        Object obj;
        String str2;
        Bundle arguments = getArguments();
        if (arguments != null) {
            double d11 = arguments.getDouble(EXTRAS_LATITUDE, Double.NaN);
            double d12 = arguments.getDouble(EXTRAS_LONGITUDE, Double.NaN);
            String string = arguments.getString("from", "");
            String string2 = arguments.getString("value", (String) null);
            boolean z11 = false;
            this.refreshingLocation = arguments.getBoolean(REFRESH_LOCATION, false);
            if (string2 != null) {
                if (string2.length() > 0) {
                    z11 = true;
                }
                if (z11) {
                    Gson gson = UniversalGson.INSTANCE.gson;
                    Intrinsics.checkNotNullExpressionValue(gson, "INSTANCE.gson");
                    Class cls = Address.class;
                    if (!(gson instanceof Gson)) {
                        obj = gson.fromJson(string2, cls);
                    } else {
                        obj = GsonInstrumentation.fromJson(gson, string2, cls);
                    }
                    Address address = (Address) obj;
                    if (address != null) {
                        str2 = address.f58343id;
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        str = address.f58343id;
                        Context context = getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        boolean flutterAddressFormMultiLayoutEnable = ((AddressFormFeatureApi) AndroidComponentsKt.apiContainer(context).getFeature(AddressFormFeatureApi.class)).getAddressFormRouteUseCase().flutterAddressFormMultiLayoutEnable();
                        if (!Double.isNaN(d11) && !Double.isNaN(d12)) {
                            Intrinsics.checkNotNullExpressionValue(string, "eventOrigin");
                            return new AddressFormRequestParamBundle(d11, d12, str, string, "", this.refreshingLocation, flutterAddressFormMultiLayoutEnable);
                        }
                    }
                }
            }
            str = "";
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            boolean flutterAddressFormMultiLayoutEnable2 = ((AddressFormFeatureApi) AndroidComponentsKt.apiContainer(context2).getFeature(AddressFormFeatureApi.class)).getAddressFormRouteUseCase().flutterAddressFormMultiLayoutEnable();
            Intrinsics.checkNotNullExpressionValue(string, "eventOrigin");
            return new AddressFormRequestParamBundle(d11, d12, str, string, "", this.refreshingLocation, flutterAddressFormMultiLayoutEnable2);
        }
        return null;
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void delete(@Nullable String str) {
        if (str != null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((FlutterAddressFormActivity) activity).onAddressesDeleted(str);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.ul.addressform.FlutterAddressFormActivity");
        }
    }

    @NotNull
    public AddressFormRequestParamBundle getAddressFormUIRequestInfo() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            LatLng geoCodinates = ((FlutterAddressFormActivity) activity).getGeoCodinates();
            AddressFormRequestParamBundle addressFormRequestParamBundle = this.formUIRequestInfo;
            if (addressFormRequestParamBundle != null) {
                addressFormRequestParamBundle.setLatitude(geoCodinates.getLatitude());
                addressFormRequestParamBundle.setLongitude(geoCodinates.getLongitude());
                addressFormRequestParamBundle.setRefreshLocation(this.refreshingLocation);
                AddressFormRequestParamBundle addressFormRequestParamBundle2 = this.formUIRequestInfo;
                if (addressFormRequestParamBundle2 != null) {
                    return addressFormRequestParamBundle2;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.uladdressform.presentation.channel.AddressFormRequestParamBundle");
            }
            throw new IllegalStateException("method channel called before address form request info loaded");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.ul.addressform.FlutterAddressFormActivity");
    }

    @NotNull
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.ADDRESS_FORM_MAIN;
    }

    public final boolean getRefreshingLocation() {
        return this.refreshingLocation;
    }

    @NotNull
    public String getRoute() {
        return "/address-form";
    }

    public void moveForward(@NotNull AddressFormBundle addressFormBundle) {
        Intrinsics.checkNotNullParameter(addressFormBundle, "address");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((FlutterAddressFormActivity) activity).onAddressAddSuccess(addressFormBundle.toAddress());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.ul.addressform.FlutterAddressFormActivity");
    }

    public void navigateToMapScreen(@NotNull AddressFormMapBundle addressFormMapBundle) {
        Unit unit;
        Intrinsics.checkNotNullParameter(addressFormMapBundle, "mapData");
        AddressFormRequestParamBundle addressFormRequestParamBundle = this.formUIRequestInfo;
        if (addressFormRequestParamBundle != null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((FlutterAddressFormActivity) activity).flutterOnRedirectToMapScreen(addressFormRequestParamBundle.getLatitude(), addressFormRequestParamBundle.getLongitude(), false, false);
                unit = Unit.INSTANCE;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.ul.addressform.FlutterAddressFormActivity");
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                ((FlutterAddressFormActivity) activity2).flutterOnRedirectToMapScreen(false, false);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.ul.addressform.FlutterAddressFormActivity");
        }
    }

    public void onAddAddressSuccessfully(@NotNull AddressFormBundle addressFormBundle) {
        Intrinsics.checkNotNullParameter(addressFormBundle, "it");
        Customer.getInstance().AddCustomerAddress(addressFormBundle.toAddress());
    }

    public void onCreate(@Nullable Bundle bundle) {
        FragmentActivity activity;
        super.onCreate(bundle);
        LogManager.debug("fred FlutterAddressFormFragment.onCreate()");
        AddressFormRequestParamBundle AddressFormRequestParamBundle = AddressFormRequestParamBundle();
        this.formUIRequestInfo = AddressFormRequestParamBundle;
        if (AddressFormRequestParamBundle == null && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        AddressFormMethodChannel addressFormMethodChannel2 = this.channel;
        if (addressFormMethodChannel2 != null) {
            addressFormMethodChannel2.setCallback((IAddressFormMethodChannel) null);
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onEditAddressSuccessfully(@NotNull AddressFormBundle addressFormBundle) {
        Intrinsics.checkNotNullParameter(addressFormBundle, "it");
        Customer.getInstance().EditCustomerAddress(getContext(), addressFormBundle.toAddress());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((FlutterAddressFormActivity) activity).onAddressEditSuccess(addressFormBundle.toAddress());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.ul.addressform.FlutterAddressFormActivity");
    }

    public final void setRefreshingLocation(boolean z11) {
        this.refreshingLocation = z11;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.setUpExtraChannels(flutterEngine);
        AddressFormMethodChannel addressFormMethodChannel2 = new AddressFormMethodChannel();
        this.channel = addressFormMethodChannel2;
        addressFormMethodChannel2.setCallback(this);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), ADDRESS_FORM_METHOD_CHANNEL);
        this.addressFormMethodChannel = methodChannel;
        methodChannel.setMethodCallHandler(this.channel);
    }

    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    public boolean shouldDestroyEngineWithHost() {
        return true;
    }
}
