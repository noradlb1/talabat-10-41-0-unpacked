package com.talabat.maps.presentation;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.talabat.core.maps.presentation.R;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.maps.domain.MapViewsRepository;
import com.talabat.maps.domain.OnMapReadyCallback;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.maps.domain.ui.MapFragment;
import com.talabat.maps.presentation.di.DaggerMapContainerFragmentComponent;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u00020\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0015\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/talabat/maps/presentation/MapContainerFragment;", "Landroidx/fragment/app/Fragment;", "()V", "mapFragment", "Lcom/talabat/maps/domain/ui/MapFragment;", "mapViewsRepository", "Lcom/talabat/maps/domain/MapViewsRepository;", "getMapViewsRepository", "()Lcom/talabat/maps/domain/MapViewsRepository;", "setMapViewsRepository", "(Lcom/talabat/maps/domain/MapViewsRepository;)V", "getMapAsync", "", "callback", "Lcom/talabat/maps/domain/OnMapReadyCallback;", "(Lcom/talabat/maps/domain/OnMapReadyCallback;)Lkotlin/Unit;", "init", "wrappingView", "Landroid/view/ViewGroup;", "legacyHideLocationButton", "click", "", "(Z)Lkotlin/Unit;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "com_talabat_core_maps_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MapContainerFragment extends Fragment implements TraceFieldInterface {
    public Trace _nr_trace;
    @Nullable
    private MapFragment mapFragment;
    @Inject
    public MapViewsRepository mapViewsRepository;

    public MapContainerFragment() {
        super(R.layout.fragment_map_container);
    }

    public static /* synthetic */ void init$default(MapContainerFragment mapContainerFragment, ViewGroup viewGroup, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            viewGroup = null;
        }
        mapContainerFragment.init(viewGroup);
    }

    @Nullable
    public final Unit getMapAsync(@NotNull OnMapReadyCallback onMapReadyCallback) {
        Intrinsics.checkNotNullParameter(onMapReadyCallback, "callback");
        MapFragment mapFragment2 = this.mapFragment;
        if (mapFragment2 == null) {
            return null;
        }
        mapFragment2.getMapAsync(onMapReadyCallback);
        return Unit.INSTANCE;
    }

    @NotNull
    public final MapViewsRepository getMapViewsRepository() {
        MapViewsRepository mapViewsRepository2 = this.mapViewsRepository;
        if (mapViewsRepository2 != null) {
            return mapViewsRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mapViewsRepository");
        return null;
    }

    public final void init(@Nullable ViewGroup viewGroup) {
        MapFragment supportMapFragment = getMapViewsRepository().getSupportMapFragment();
        if (viewGroup != null) {
            supportMapFragment.setWrappingView(viewGroup);
        }
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_map_container_root, supportMapFragment.androidFragment()).commit();
        this.mapFragment = supportMapFragment;
    }

    @Nullable
    public final Unit legacyHideLocationButton(boolean z11) {
        MapFragment mapFragment2 = this.mapFragment;
        if (mapFragment2 == null) {
            return null;
        }
        mapFragment2.legacyHideLocationButton(z11);
        return Unit.INSTANCE;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        DaggerMapContainerFragmentComponent.factory().create((MapsCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(MapsCoreLibApi.class)).inject(this);
    }

    public final void setMapViewsRepository(@NotNull MapViewsRepository mapViewsRepository2) {
        Intrinsics.checkNotNullParameter(mapViewsRepository2, "<set-?>");
        this.mapViewsRepository = mapViewsRepository2;
    }
}
