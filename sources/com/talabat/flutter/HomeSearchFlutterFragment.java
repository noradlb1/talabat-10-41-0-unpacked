package com.talabat.flutter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.flutter.channels.E2ETestChannel;
import com.talabat.flutter.channels.HomeSearchMethodChannel;
import com.talabat.flutter.utils.HomeSearchChannelTestNameConstant;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.domain.entities.FlutterVertical;
import com.talabat.fluttercore.engine.PreWarmedEngines;
import com.talabat.fluttercore.presentation.PreWarmedFlutterFragment;
import com.talabat.gem.adapters.flutter.channel.GemMethodChannel;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.search.domain.callback.SearchMethodHandlerCallback;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.vendormenu.presentation.flutter.GemFlutterEngineBinder;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016R#\u0010#\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/talabat/flutter/HomeSearchFlutterFragment;", "Lcom/talabat/fluttercore/presentation/PreWarmedFlutterFragment;", "Lcom/talabat/search/domain/callback/SearchMethodHandlerCallback;", "Lio/flutter/embedding/engine/FlutterEngine;", "flutterEngine", "", "setUpSearchChannel", "setUpGemChannel", "setUpE2ETestChannel", "", "getRoute", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getEntryPoint", "setUpExtraChannels", "k0", "", "Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "getAvailableVertical", "()[Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "", "getSelectedCollectionId", "getSelectedCuisine", "getSelectedFliterIds", "()[Ljava/lang/Integer;", "Landroid/content/Context;", "context", "onAttach", "onDetach", "onBackPressed", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson$delegate", "Lkotlin/Lazy;", "getGson", "()Lcom/google/gson/Gson;", "gson", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatFeatureFlag$delegate", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatFeatureFlag", "<init>", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0})
public final class HomeSearchFlutterFragment extends PreWarmedFlutterFragment implements SearchMethodHandlerCallback {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final Lazy gson$delegate;
    @NotNull
    private final Lazy talabatFeatureFlag$delegate;

    public HomeSearchFlutterFragment() {
        super(PreWarmedEngines.ENGINE_FOR_SEARCH, (RemoteConfiguration) null, 2, (DefaultConstructorMarker) null);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.gson$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, HomeSearchFlutterFragment$gson$2.INSTANCE);
        this.talabatFeatureFlag$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new HomeSearchFlutterFragment$talabatFeatureFlag$2(this));
    }

    private final Gson getGson() {
        return (Gson) this.gson$delegate.getValue();
    }

    private final ITalabatFeatureFlag getTalabatFeatureFlag() {
        return (ITalabatFeatureFlag) this.talabatFeatureFlag$delegate.getValue();
    }

    private final void setUpE2ETestChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/localhostMock");
        String testName = HomeSearchChannelTestNameConstant.Companion.getTestName();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        methodChannel.setMethodCallHandler(new E2ETestChannel(testName, requireContext));
    }

    private final void setUpGemChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/gem");
        methodChannel.setMethodCallHandler(new GemMethodChannel());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            new GemFlutterEngineBinder(methodChannel).accept(activity);
        }
    }

    private final void setUpSearchChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.SEARCH_CHANNEL);
        HomeSearchMethodChannel homeSearchMethodChannel = new HomeSearchMethodChannel(true);
        homeSearchMethodChannel.setSearchMethodChannelCallbacks(this);
        methodChannel.setMethodCallHandler(homeSearchMethodChannel);
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

    @NotNull
    public FlutterVertical[] getAvailableVertical() {
        String str;
        boolean z11;
        Object obj;
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("verticals");
        } else {
            str = null;
        }
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new FlutterVertical[0];
        }
        Gson gson = getGson();
        Class cls = FlutterVertical[].class;
        if (!(gson instanceof Gson)) {
            obj = gson.fromJson(str, cls);
        } else {
            obj = GsonInstrumentation.fromJson(gson, str, cls);
        }
        Intrinsics.checkNotNullExpressionValue(obj, "gson.fromJson(verticals,…terVertical>::class.java)");
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

    public void k0(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setUpE2ETestChannel(flutterEngine);
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        GlobalDataModel.isSearchActive = true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        GlobalDataModel.isSearchActive = false;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        super.onDetach();
        GlobalDataModel.isSearchActive = false;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.setUpExtraChannels(flutterEngine);
        setUpSearchChannel(flutterEngine);
        setUpGemChannel(flutterEngine);
    }
}
