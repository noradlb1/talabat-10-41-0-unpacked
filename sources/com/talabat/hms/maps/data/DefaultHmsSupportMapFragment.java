package com.talabat.hms.maps.data;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import as.a;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.SupportMapFragment;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.hms.maps.data.di.DaggerDefaultHmsSupportMapFragmentComponent;
import com.talabat.maps.domain.OnMapReadyCallback;
import com.talabat.maps.domain.ui.MapFragment;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0000H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/hms/maps/data/DefaultHmsSupportMapFragment;", "Lcom/huawei/hms/maps/SupportMapFragment;", "Lcom/talabat/maps/domain/ui/MapFragment;", "()V", "mapReady", "", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "shouldClickOnLocationButton", "shouldHideLocationButton", "wrappingView", "Landroid/view/ViewGroup;", "androidFragment", "getMapAsync", "", "callback", "Lcom/talabat/maps/domain/OnMapReadyCallback;", "legacyHideLocationButton", "click", "onCreateView", "Landroid/view/View;", "p0", "Landroid/view/LayoutInflater;", "p1", "p2", "Landroid/os/Bundle;", "setWrappingView", "Companion", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultHmsSupportMapFragment extends SupportMapFragment implements MapFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String HUAWEI_BUTTON_TAG = "MapMyLocationButton";
    private boolean mapReady;
    @Inject
    public IObservabilityManager observabilityManager;
    private boolean shouldClickOnLocationButton;
    private boolean shouldHideLocationButton;
    @Nullable
    private ViewGroup wrappingView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/hms/maps/data/DefaultHmsSupportMapFragment$Companion;", "", "()V", "HUAWEI_BUTTON_TAG", "", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getMapAsync$lambda-0  reason: not valid java name */
    public static final void m10630getMapAsync$lambda0(DefaultHmsSupportMapFragment defaultHmsSupportMapFragment, OnMapReadyCallback onMapReadyCallback, HuaweiMap huaweiMap) {
        Intrinsics.checkNotNullParameter(defaultHmsSupportMapFragment, "this$0");
        Intrinsics.checkNotNullParameter(onMapReadyCallback, "$callback");
        huaweiMap.getUiSettings().setZoomControlsEnabled(false);
        defaultHmsSupportMapFragment.mapReady = true;
        if (defaultHmsSupportMapFragment.shouldHideLocationButton) {
            defaultHmsSupportMapFragment.legacyHideLocationButton(defaultHmsSupportMapFragment.shouldClickOnLocationButton);
        }
        Intrinsics.checkNotNullExpressionValue(huaweiMap, "huaweiMap");
        onMapReadyCallback.onMapReady(new HuaweiFrameworkMap(huaweiMap));
    }

    @NotNull
    public DefaultHmsSupportMapFragment androidFragment() {
        return this;
    }

    public void getMapAsync(@NotNull OnMapReadyCallback onMapReadyCallback) {
        Intrinsics.checkNotNullParameter(onMapReadyCallback, "callback");
        super.getMapAsync(new a(this, onMapReadyCallback));
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    public void legacyHideLocationButton(boolean z11) {
        Unit unit;
        View findViewWithTag;
        if (!this.mapReady) {
            this.shouldHideLocationButton = true;
            this.shouldClickOnLocationButton = z11;
            return;
        }
        this.shouldHideLocationButton = false;
        this.shouldClickOnLocationButton = false;
        try {
            ViewGroup viewGroup = this.wrappingView;
            if (viewGroup == null || (findViewWithTag = viewGroup.findViewWithTag(HUAWEI_BUTTON_TAG)) == null) {
                unit = null;
            } else {
                if (z11) {
                    findViewWithTag.performClick();
                }
                findViewWithTag.setAlpha(0.0f);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(getObservabilityManager(), "Huawei Map location button not found", (Map) null, 2, (Object) null);
            }
        } catch (Throwable unused) {
            IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(getObservabilityManager(), "Unable to do magic for location button", (Map) null, 2, (Object) null);
        }
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "p0");
        DaggerDefaultHmsSupportMapFragmentComponent.factory().create((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ViewGroup viewGroup2 = this.wrappingView;
        if (viewGroup2 == null) {
            return onCreateView;
        }
        viewGroup2.addView(onCreateView);
        return viewGroup2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public void setWrappingView(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "wrappingView");
        this.wrappingView = viewGroup;
    }
}
