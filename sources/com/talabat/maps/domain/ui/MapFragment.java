package com.talabat.maps.domain.ui;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.talabat.maps.domain.OnMapReadyCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/maps/domain/ui/MapFragment;", "", "androidFragment", "Landroidx/fragment/app/Fragment;", "getMapAsync", "", "callback", "Lcom/talabat/maps/domain/OnMapReadyCallback;", "legacyHideLocationButton", "click", "", "setWrappingView", "wrappingView", "Landroid/view/ViewGroup;", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MapFragment {
    @NotNull
    Fragment androidFragment();

    void getMapAsync(@NotNull OnMapReadyCallback onMapReadyCallback);

    void legacyHideLocationButton(boolean z11);

    void setWrappingView(@NotNull ViewGroup viewGroup);
}
