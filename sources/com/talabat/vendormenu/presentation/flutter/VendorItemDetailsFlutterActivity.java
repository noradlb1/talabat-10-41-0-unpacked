package com.talabat.vendormenu.presentation.flutter;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.gem.adapters.flutter.channel.GemMethodChannel;
import com.talabat.talabatcommon.R;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.vendormenu.presentation.flutter.channels.CartMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.VendorFlutterApiCallsMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.VendorItemDetailsMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.VendorItemDetailsMethodChannelCallback;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMenuMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMethodChannel;
import com.talabat.vendormenu.presentation.flutter.dto.AddToBasketCallArguments;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\r\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¨\u0006\u001f"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/VendorItemDetailsFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/vendormenu/presentation/flutter/channels/VendorItemDetailsMethodChannelCallback;", "()V", "getCartSize", "", "()Ljava/lang/Integer;", "getCartVendorId", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getRoute", "", "getVendorItemDetailsInfo", "", "", "onAddToBasketClicked", "", "args", "Lcom/talabat/vendormenu/presentation/flutter/dto/AddToBasketCallArguments;", "onBackPressedFromFlutter", "setUpCartChannel", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "setUpE2ETestChannel", "setUpExtraChannels", "setUpItemDetailsChannel", "setUpMenuChannel", "setUpTestingChannels", "setUpVendorChannel", "setupGemChannel", "CompanionObject", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PlumbingWork
public class VendorItemDetailsFlutterActivity extends TalabatFlutterFragmentActivity implements VendorItemDetailsMethodChannelCallback {
    @NotNull
    public static final String CART_CHANNEL = "com.talabat.flutter/vendor-cart";
    @NotNull
    public static final CompanionObject CompanionObject = new CompanionObject((DefaultConstructorMarker) null);
    @NotNull
    public static final String VENDOR_CHANNEL = "com.talabat.flutter/vendor";
    @NotNull
    public static final String VENDOR_ITEM_DETAIL_CHANNEL = "com.talabat.flutter/vendor-item-details";
    @NotNull
    public static final String VENDOR_MENU_CHANNEL = "com.talabat.flutter/vendor-menu";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/VendorItemDetailsFlutterActivity$CompanionObject;", "", "()V", "CART_CHANNEL", "", "VENDOR_CHANNEL", "VENDOR_ITEM_DETAIL_CHANNEL", "VENDOR_MENU_CHANNEL", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CompanionObject {
        private CompanionObject() {
        }

        public /* synthetic */ CompanionObject(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public VendorItemDetailsFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
    }

    private final void setUpCartChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor-cart").setMethodCallHandler(new CartMethodChannel(this));
    }

    private final void setUpE2ETestChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/localhostMock").setMethodCallHandler(new VendorFlutterApiCallsMethodChannel(this, (String) null, false, 6, (DefaultConstructorMarker) null));
    }

    private final void setUpItemDetailsChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), VENDOR_ITEM_DETAIL_CHANNEL);
        VendorItemDetailsMethodChannel vendorItemDetailsMethodChannel = new VendorItemDetailsMethodChannel();
        vendorItemDetailsMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(vendorItemDetailsMethodChannel);
    }

    private final void setUpMenuChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor-menu").setMethodCallHandler(new VendorMenuMethodChannel());
    }

    private final void setUpVendorChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor").setMethodCallHandler(new VendorMethodChannel());
    }

    private final void setupGemChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/gem");
        methodChannel.setMethodCallHandler(new GemMethodChannel());
        new GemFlutterEngineBinder(methodChannel).accept((FragmentActivity) this);
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

    @Nullable
    public final Integer getCartSize() {
        if (getIntent().hasExtra("cartSize")) {
            return Integer.valueOf(getIntent().getIntExtra("cartSize", -1));
        }
        return null;
    }

    @Nullable
    public final Integer getCartVendorId() {
        if (getIntent().hasExtra("cartVendorId")) {
            return Integer.valueOf(getIntent().getIntExtra("cartVendorId", -1));
        }
        return null;
    }

    @NotNull
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.VENDOR_ITEM_DETAILS;
    }

    @NotNull
    public String getRoute() {
        return "/vendor-item-details";
    }

    @NotNull
    public Map<String, Object> getVendorItemDetailsInfo() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("isGemFlow", Boolean.valueOf(getIntent().getBooleanExtra("isGemFlow", false))), TuplesKt.to("branchId", Integer.valueOf(getIntent().getIntExtra("branchId", -1))), TuplesKt.to("origin", getIntent().getStringExtra("origin")), TuplesKt.to("itemId", Integer.valueOf(getIntent().getIntExtra("itemId", -1))), TuplesKt.to("cartVendorId", getCartVendorId()), TuplesKt.to("cartItemsCount", getCartSize()), TuplesKt.to("cartVendorName", getIntent().getStringExtra("cartVendorName")));
    }

    public void onAddToBasketClicked(@NotNull AddToBasketCallArguments addToBasketCallArguments) {
        Intrinsics.checkNotNullParameter(addToBasketCallArguments, StepData.ARGS);
        Intent intent = new Intent();
        intent.putExtra(FirebaseAnalytics.Param.QUANTITY, addToBasketCallArguments.getQuantity());
        intent.putExtra("itemId", addToBasketCallArguments.getItemId());
        intent.putExtra("specialRequest", addToBasketCallArguments.getSpecialRequest());
        setResult(-1, intent);
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void onBackPressedFromFlutter() {
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setUpItemDetailsChannel(flutterEngine);
        setUpMenuChannel(flutterEngine);
        setUpVendorChannel(flutterEngine);
        setupGemChannel(flutterEngine);
        setUpCartChannel(flutterEngine);
    }

    public void setUpTestingChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setUpE2ETestChannel(flutterEngine);
    }
}
