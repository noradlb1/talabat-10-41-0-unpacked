package com.talabat.gms.maps.data;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.gms.maps.data.di.DaggerDefaultSupportMapFragmentComponent;
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
import zq.a;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0000H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/talabat/gms/maps/data/DefaultSupportMapFragment;", "Lcom/google/android/gms/maps/SupportMapFragment;", "Lcom/talabat/maps/domain/ui/MapFragment;", "()V", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "shouldClickOnLocationButton", "", "shouldHideLocationButton", "viewCreated", "wrappingView", "Landroid/view/ViewGroup;", "androidFragment", "getMapAsync", "", "callback", "Lcom/talabat/maps/domain/OnMapReadyCallback;", "legacyHideLocationButton", "click", "onCreateView", "Landroid/view/View;", "p0", "Landroid/view/LayoutInflater;", "p1", "p2", "Landroid/os/Bundle;", "onViewCreated", "view", "savedInstanceState", "setWrappingView", "Companion", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultSupportMapFragment extends SupportMapFragment implements MapFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SuppressLint({"ResourceType"})
    @IdRes
    private static final int GOOGLE_BUTTON_ID = 2;
    @Inject
    public IObservabilityManager observabilityManager;
    private boolean shouldClickOnLocationButton;
    private boolean shouldHideLocationButton;
    private boolean viewCreated;
    @Nullable
    private ViewGroup wrappingView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0002XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/gms/maps/data/DefaultSupportMapFragment$Companion;", "", "()V", "GOOGLE_BUTTON_ID", "", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getMapAsync$lambda-0  reason: not valid java name */
    public static final void m10589getMapAsync$lambda0(OnMapReadyCallback onMapReadyCallback, GoogleMap googleMap) {
        Intrinsics.checkNotNullParameter(onMapReadyCallback, "$callback");
        Intrinsics.checkNotNullParameter(googleMap, "googleMap");
        onMapReadyCallback.onMapReady(new GoogleFrameworkMap(googleMap));
    }

    @NotNull
    public DefaultSupportMapFragment androidFragment() {
        return this;
    }

    public void getMapAsync(@NotNull OnMapReadyCallback onMapReadyCallback) {
        Intrinsics.checkNotNullParameter(onMapReadyCallback, "callback");
        super.getMapAsync(new a(onMapReadyCallback));
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
        View findViewById;
        if (!this.viewCreated) {
            this.shouldHideLocationButton = true;
            this.shouldClickOnLocationButton = z11;
            return;
        }
        this.shouldHideLocationButton = false;
        this.shouldClickOnLocationButton = false;
        try {
            View view = getView();
            if (view == null || (findViewById = view.findViewById(2)) == null) {
                unit = null;
            } else {
                if (z11) {
                    findViewById.performClick();
                }
                findViewById.setVisibility(4);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(getObservabilityManager(), "Google Map location button not found", (Map) null, 2, (Object) null);
            }
        } catch (Throwable unused) {
            IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(getObservabilityManager(), "Unable to do magic for location button", (Map) null, 2, (Object) null);
        }
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "p0");
        DaggerDefaultSupportMapFragmentComponent.factory().create((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Intrinsics.checkNotNullExpressionValue(onCreateView, "super.onCreateView(p0, p1, p2)");
        ViewGroup viewGroup2 = this.wrappingView;
        if (viewGroup2 == null) {
            return onCreateView;
        }
        viewGroup2.addView(onCreateView);
        return viewGroup2;
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.viewCreated = true;
        if (this.shouldHideLocationButton) {
            legacyHideLocationButton(this.shouldClickOnLocationButton);
        }
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
