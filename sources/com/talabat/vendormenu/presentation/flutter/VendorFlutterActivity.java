package com.talabat.vendormenu.presentation.flutter;

import android.view.View;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.vendormenu.presentation.flutter.channels.VendorFlutterApiCallsMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.VendorInfoMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.VendorInfoMethodChannelCallback;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMethodChannel;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u0010"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/VendorFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/vendormenu/presentation/flutter/channels/VendorInfoMethodChannelCallback;", "()V", "getBranchId", "", "()Ljava/lang/Integer;", "setUpE2ETestChannel", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "setUpExtraChannels", "setUpTestingChannels", "setUpVendorChannel", "setUpVendorInfoChannel", "CompanionObject", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PlumbingWork
public abstract class VendorFlutterActivity extends TalabatFlutterFragmentActivity implements VendorInfoMethodChannelCallback {
    @NotNull
    public static final String BRANCH_ID_KEY = "branchId";
    @NotNull
    public static final CompanionObject CompanionObject = new CompanionObject((DefaultConstructorMarker) null);
    @NotNull
    public static final String VENDOR_CHANNEL = "com.talabat.flutter/vendor";
    @NotNull
    public static final String VENDOR_E2E_TEST_CHANNEL = "com.talabat.flutter/localhostMock";
    @NotNull
    public static final String VENDOR_INFO_CHANNEL = "com.talabat.flutter/vendor-info";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/VendorFlutterActivity$CompanionObject;", "", "()V", "BRANCH_ID_KEY", "", "VENDOR_CHANNEL", "VENDOR_E2E_TEST_CHANNEL", "VENDOR_INFO_CHANNEL", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CompanionObject {
        private CompanionObject() {
        }

        public /* synthetic */ CompanionObject(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public VendorFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
    }

    private final void setUpE2ETestChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/localhostMock").setMethodCallHandler(new VendorFlutterApiCallsMethodChannel(this, (String) null, false, 6, (DefaultConstructorMarker) null));
    }

    private final void setUpVendorChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor").setMethodCallHandler(new VendorMethodChannel());
    }

    private final void setUpVendorInfoChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), VENDOR_INFO_CHANNEL);
        VendorInfoMethodChannel vendorInfoMethodChannel = new VendorInfoMethodChannel();
        vendorInfoMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(vendorInfoMethodChannel);
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
    public Integer getBranchId() {
        if (getIntent().hasExtra("branchId")) {
            return Integer.valueOf(getIntent().getIntExtra("branchId", -1));
        }
        return null;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setUpVendorInfoChannel(flutterEngine);
        setUpVendorChannel(flutterEngine);
    }

    public void setUpTestingChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setUpE2ETestChannel(flutterEngine);
    }
}
