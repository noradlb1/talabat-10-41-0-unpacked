package com.talabat.flutter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.gem.FlutterGemCollectionScreen;
import com.talabat.core.navigation.domain.screen.gem.GemCollectionEntrypoint;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.flutter.channels.GemCollectionMethodCallHandler;
import com.talabat.flutter.channels.IGemCollectionMethodCallback;
import com.talabat.flutter.di.DaggerGemCollectionFlutterActivityComponent;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorController;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorModel;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J(\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0019H\u0016J\u0012\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lcom/talabat/flutter/GemCollectionFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/flutter/channels/IGemCollectionMethodCallback;", "()V", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getRoute", "", "navigateBack", "", "navigateToMenu", "branchId", "", "isProVendor", "", "deliveryMode", "shopClickOrigin", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemCollectionFlutterActivity extends TalabatFlutterFragmentActivity implements IGemCollectionMethodCallback {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @Inject
    public ITalabatFeatureFlag featureFlag;
    @Inject
    public Navigator navigator;

    public GemCollectionFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
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
    public final DeepLinkNavigator getDeepLinkNavigator() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
        return null;
    }

    @NotNull
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.DEEPLINK;
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlag");
        return null;
    }

    @NotNull
    public final Navigator getNavigator() {
        Navigator navigator2 = this.navigator;
        if (navigator2 != null) {
            return navigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    @NotNull
    public String getRoute() {
        String str;
        GemCollectionEntrypoint entrypoint;
        FlutterGemCollectionScreen.FlutterGemCollectionData flutterGemCollectionData = (FlutterGemCollectionScreen.FlutterGemCollectionData) getIntent().getParcelableExtra("navigatorData");
        if (flutterGemCollectionData == null || (entrypoint = flutterGemCollectionData.getEntrypoint()) == null || (str = entrypoint.getValue()) == null) {
            str = "";
        }
        return "/flutter-gem-collection?from=" + str;
    }

    public void navigateBack() {
        finish();
    }

    public void navigateToMenu(int i11, boolean z11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "deliveryMode");
        Intrinsics.checkNotNullParameter(str2, "shopClickOrigin");
        MenuNavigatorController.INSTANCE.navigateToMenu(this, new MenuNavigatorModel(i11, str, str2, Boolean.valueOf(z11), (Integer) null, 16, (DefaultConstructorMarker) null), getFeatureFlag(), getDeepLinkNavigator(), getNavigator());
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerGemCollectionFlutterActivityComponent.factory().create((NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DeepLinkCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlag = iTalabatFeatureFlag;
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.GEM_COLLECTION_CHANNEL);
        GemCollectionMethodCallHandler gemCollectionMethodCallHandler = new GemCollectionMethodCallHandler();
        gemCollectionMethodCallHandler.setCallback(this);
        methodChannel.setMethodCallHandler(gemCollectionMethodCallHandler);
    }
}
