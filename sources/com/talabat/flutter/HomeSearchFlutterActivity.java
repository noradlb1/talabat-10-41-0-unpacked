package com.talabat.flutter;

import JsonModels.parser.UniversalGson;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.flutter.channels.E2ETestChannel;
import com.talabat.flutter.channels.HomeSearchMethodChannel;
import com.talabat.flutter.utils.HomeSearchChannelTestNameConstant;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.domain.entities.FlutterVertical;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.gem.adapters.flutter.channel.GemMethodChannel;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.search.domain.callback.SearchMethodHandlerCallback;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.vendormenu.presentation.flutter.GemFlutterEngineBinder;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0014J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¨\u0006\u001f"}, d2 = {"Lcom/talabat/flutter/HomeSearchFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/search/domain/callback/SearchMethodHandlerCallback;", "()V", "getAvailableVertical", "", "Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "()[Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getRoute", "", "getSelectedCollectionId", "", "getSelectedCuisine", "getSelectedFliterIds", "()[Ljava/lang/Integer;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setUpE2ETestChannel", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "setUpExtraChannels", "setUpGemChannel", "setUpSearchChannel", "setUpTestingChannels", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeSearchFlutterActivity extends TalabatFlutterFragmentActivity implements SearchMethodHandlerCallback {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String GEM_CHANNEL = "com.talabat.flutter/gem";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/flutter/HomeSearchFlutterActivity$Companion;", "", "()V", "GEM_CHANNEL", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HomeSearchFlutterActivity() {
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
        HomeSearchMethodChannel homeSearchMethodChannel = new HomeSearchMethodChannel(false, 1, (DefaultConstructorMarker) null);
        homeSearchMethodChannel.setSearchMethodChannelCallbacks(this);
        methodChannel.setMethodCallHandler(homeSearchMethodChannel);
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
        boolean z11;
        Object obj;
        String stringExtra = getIntent().getStringExtra("verticals");
        if (stringExtra == null || StringsKt__StringsJVMKt.isBlank(stringExtra)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new FlutterVertical[0];
        }
        Gson gson = UniversalGson.INSTANCE.gson;
        Class cls = FlutterVertical[].class;
        if (!(gson instanceof Gson)) {
            obj = gson.fromJson(stringExtra, cls);
        } else {
            obj = GsonInstrumentation.fromJson(gson, stringExtra, cls);
        }
        Intrinsics.checkNotNullExpressionValue(obj, "INSTANCE.gson.fromJson(v…terVertical>::class.java)");
        return (FlutterVertical[]) obj;
    }

    @NotNull
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.DEEPLINK;
    }

    @NotNull
    public String getRoute() {
        return "/search";
    }

    public int getSelectedCollectionId() {
        return 0;
    }

    public int getSelectedCuisine() {
        return 0;
    }

    @NotNull
    public Integer[] getSelectedFliterIds() {
        return new Integer[0];
    }

    public void onBackPressed() {
        super.onBackPressed();
        GlobalDataModel.isSearchActive = false;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        GlobalDataModel.isSearchActive = true;
    }

    public void onDestroy() {
        super.onDestroy();
        GlobalDataModel.isSearchActive = false;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.setUpExtraChannels(flutterEngine);
        setUpSearchChannel(flutterEngine);
        setUpGemChannel(flutterEngine);
    }

    public void setUpTestingChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setUpE2ETestChannel(flutterEngine);
    }
}
