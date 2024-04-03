package com.talabat.flutter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.flutter.channels.CollectionMethodCallHandler;
import com.talabat.flutter.channels.ICollectionMethodCallback;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.observability.performance.PerformanceTracker;
import com.talabat.observability.performance.Traces;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/flutter/CollectionFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/flutter/channels/ICollectionMethodCallback;", "()V", "vendorCollectionMethodCallHandler", "Lcom/talabat/flutter/channels/CollectionMethodCallHandler;", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getRoute", "", "getTileType", "", "navigateToMenu", "", "branchId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionFlutterActivity extends TalabatFlutterFragmentActivity implements ICollectionMethodCallback {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private CollectionMethodCallHandler vendorCollectionMethodCallHandler;

    public CollectionFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
    }

    private final int getTileType() {
        return SharedPreferencesManager.getInstance(this).isCardViewFavStyle(Boolean.FALSE) ^ true ? 1 : 0;
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

    @NotNull
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.VENDOR_LIST_COLLECTION_SCREEN;
    }

    @NotNull
    public String getRoute() {
        String str;
        String str2;
        boolean z11;
        Bundle extras;
        Bundle extras2;
        String string;
        Bundle extras3;
        Intent intent = getIntent();
        if (intent == null || (extras3 = intent.getExtras()) == null || (str = extras3.getString("deeplink")) == null) {
            str = CollectionFlutterActivityKt.COFFEE_JOY_DEEPLINK_PATH;
        }
        Intent intent2 = getIntent();
        String str3 = "channel";
        if (!(intent2 == null || (extras2 = intent2.getExtras()) == null || (string = extras2.getString(str3)) == null)) {
            str3 = string;
        }
        Intent intent3 = getIntent();
        String str4 = "";
        if (intent3 == null || (extras = intent3.getExtras()) == null || (str2 = extras.getString("from")) == null) {
            str2 = str4;
        }
        int tileType = getTileType();
        if (str2.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str4 = "&from=" + str2;
        }
        return "/vendor-list-collection?deeplink=" + str + "&collectionChannel=" + str3 + "&vendorTileType=" + tileType + "&canShowFilterBarOnFlutterCollection=true" + str4;
    }

    public void navigateToMenu(int i11) {
        Navigator.Companion.navigate((Context) this, new NavigatorModel("talabat.action.flutter.vendorMenu", (Bundle) null, new CollectionFlutterActivity$navigateToMenu$model$1(i11), 2, (DefaultConstructorMarker) null));
    }

    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        PerformanceTracker.INSTANCE.startTrace(Traces.COLLECTION_SCREEN_START_TIME);
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        String str;
        Bundle extras;
        String string;
        Bundle extras2;
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        Intent intent = getIntent();
        if (intent == null || (extras2 = intent.getExtras()) == null || (str = extras2.getString("deeplink")) == null) {
            str = CollectionFlutterActivityKt.COFFEE_JOY_DEEPLINK_PATH;
        }
        Intent intent2 = getIntent();
        String str2 = "channel";
        if (!(intent2 == null || (extras = intent2.getExtras()) == null || (string = extras.getString(str2)) == null)) {
            str2 = string;
        }
        CollectionMethodCallHandler collectionMethodCallHandler = new CollectionMethodCallHandler(!SharedPreferencesManager.getInstance(this).isCardViewFavStyle(Boolean.FALSE), str2, str);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.VENDOR_COLLECTION_CHANNEL);
        collectionMethodCallHandler.setCallback(this);
        methodChannel.setMethodCallHandler(collectionMethodCallHandler);
        this.vendorCollectionMethodCallHandler = collectionMethodCallHandler;
    }
}
