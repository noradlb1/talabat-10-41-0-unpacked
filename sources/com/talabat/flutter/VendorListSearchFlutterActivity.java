package com.talabat.flutter;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.flutter.channels.E2ETestChannel;
import com.talabat.flutter.channels.VendorListSearchMethodChannel;
import com.talabat.flutter.utils.FlutterRoutes;
import com.talabat.flutter.utils.HomeSearchChannelTestNameConstant;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.domain.entities.FlutterVertical;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.gem.adapters.flutter.channel.GemMethodChannel;
import com.talabat.search.domain.callback.SearchMethodHandlerCallback;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.vendormenu.presentation.flutter.GemFlutterEngineBinder;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u001a"}, d2 = {"Lcom/talabat/flutter/VendorListSearchFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/search/domain/callback/SearchMethodHandlerCallback;", "()V", "getAvailableVertical", "", "Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "()[Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getRoute", "", "getSelectedCollectionId", "", "getSelectedCuisine", "getSelectedFliterIds", "()[Ljava/lang/Integer;", "setUpE2ETestChannel", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "setUpExtraChannels", "setUpGemChannel", "setUpSearchChannel", "setUpTestingChannels", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorListSearchFlutterActivity extends TalabatFlutterFragmentActivity implements SearchMethodHandlerCallback {
    @NotNull
    public static final String COLLECTION_ID_KEY = "collectionId";
    @NotNull
    public static final String CUISINE_ID_KEY = "cuisineId";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String IS_EXISTING_PICKUP_CUSTOMER = "isExistingPickupCustomers";
    @NotNull
    public static final String VERTICAL_IDS_KEY = "verticalIds";
    @NotNull
    public static final String VERTICAL_ID_KEY = "verticalId";
    @NotNull
    public static final String VERTICAL_NAME_KEY = "verticalName";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/flutter/VendorListSearchFlutterActivity$Companion;", "", "()V", "COLLECTION_ID_KEY", "", "CUISINE_ID_KEY", "IS_EXISTING_PICKUP_CUSTOMER", "VERTICAL_IDS_KEY", "VERTICAL_ID_KEY", "VERTICAL_NAME_KEY", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public VendorListSearchFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
    }

    private final void setUpE2ETestChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/localhostMock").setMethodCallHandler(new E2ETestChannel(HomeSearchChannelTestNameConstant.Companion.getTestName(), this));
    }

    private final void setUpGemChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/gem");
        methodChannel.setMethodCallHandler(new GemMethodChannel());
        new GemFlutterEngineBinder(methodChannel).accept((FragmentActivity) this);
    }

    private final void setUpSearchChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.SEARCH_CHANNEL);
        VendorListSearchMethodChannel vendorListSearchMethodChannel = new VendorListSearchMethodChannel(getIntent().getBooleanExtra(IS_EXISTING_PICKUP_CUSTOMER, false));
        vendorListSearchMethodChannel.setSearchMethodChannelCallbacks(this);
        methodChannel.setMethodCallHandler(vendorListSearchMethodChannel);
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
    public FlutterVertical[] getAvailableVertical() {
        List list;
        String valueOf = String.valueOf(getIntent().getIntExtra("verticalId", 0));
        String stringExtra = getIntent().getStringExtra("verticalName");
        if (stringExtra == null) {
            stringExtra = "";
        }
        ArrayList<Integer> integerArrayListExtra = getIntent().getIntegerArrayListExtra("verticalIds");
        if (integerArrayListExtra == null || (list = CollectionsKt___CollectionsKt.toList(integerArrayListExtra)) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return new FlutterVertical[]{new FlutterVertical(valueOf, stringExtra, list)};
    }

    @NotNull
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.DEEPLINK;
    }

    @NotNull
    public String getRoute() {
        return FlutterRoutes.LIST_SEARCH_ROUTE;
    }

    public int getSelectedCollectionId() {
        return getIntent().getIntExtra(COLLECTION_ID_KEY, 0);
    }

    public int getSelectedCuisine() {
        return getIntent().getIntExtra(CUISINE_ID_KEY, 0);
    }

    @NotNull
    public Integer[] getSelectedFliterIds() {
        return new Integer[0];
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setUpSearchChannel(flutterEngine);
        setUpGemChannel(flutterEngine);
    }

    public void setUpTestingChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setUpE2ETestChannel(flutterEngine);
    }
}
