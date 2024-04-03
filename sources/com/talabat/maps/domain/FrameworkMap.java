package com.talabat.maps.domain;

import com.talabat.maps.domain.model.CameraPosition;
import com.talabat.maps.domain.model.Circle;
import com.talabat.maps.domain.model.CircleOptions;
import com.talabat.maps.domain.model.LatLngBounds;
import com.talabat.maps.domain.model.Marker;
import com.talabat.maps.domain.model.MarkerOptions;
import com.talabat.maps.domain.model.Polygon;
import com.talabat.maps.domain.model.PolygonOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001:\u0006UVWXYZJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H&J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H&J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H&J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H&J \u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H&J\b\u00104\u001a\u00020-H&J\u0010\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020/H&J\u0012\u00107\u001a\u00020-2\b\u00108\u001a\u0004\u0018\u000109H&J\u0010\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020\u0016H&J\u0010\u0010<\u001a\u00020-2\u0006\u0010=\u001a\u00020\u0016H&J\u0010\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020@H&J\u0010\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020CH&J\u0010\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020FH&J\u0010\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020IH&J\u0010\u0010J\u001a\u00020-2\u0006\u0010K\u001a\u00020LH&J\u0016\u0010M\u001a\u00020-2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020-0OH&J(\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u0002012\u0006\u0010R\u001a\u0002012\u0006\u0010S\u001a\u0002012\u0006\u0010T\u001a\u000201H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0005\"\u0004\b\u000e\u0010\u0007R\u0018\u0010\u000f\u001a\u00020\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0005\"\u0004\b\u001b\u0010\u0007R\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006["}, d2 = {"Lcom/talabat/maps/domain/FrameworkMap;", "", "buildingsEnabled", "", "getBuildingsEnabled", "()Z", "setBuildingsEnabled", "(Z)V", "cameraPosition", "Lcom/talabat/maps/domain/model/CameraPosition;", "getCameraPosition", "()Lcom/talabat/maps/domain/model/CameraPosition;", "indoorEnabled", "getIndoorEnabled", "setIndoorEnabled", "mapType", "Lcom/talabat/maps/domain/FrameworkMap$MapType;", "getMapType", "()Lcom/talabat/maps/domain/FrameworkMap$MapType;", "setMapType", "(Lcom/talabat/maps/domain/FrameworkMap$MapType;)V", "maxZoomLevel", "", "getMaxZoomLevel", "()F", "myLocationEnabled", "getMyLocationEnabled", "setMyLocationEnabled", "uiSettings", "Lcom/talabat/maps/domain/UiSettingsWrapper;", "getUiSettings", "()Lcom/talabat/maps/domain/UiSettingsWrapper;", "addCircle", "Lcom/talabat/maps/domain/model/Circle;", "circleOptions", "Lcom/talabat/maps/domain/model/CircleOptions;", "addMarker", "Lcom/talabat/maps/domain/model/Marker;", "markerOptions", "Lcom/talabat/maps/domain/model/MarkerOptions;", "addPolygon", "Lcom/talabat/maps/domain/model/Polygon;", "polygonOptions", "Lcom/talabat/maps/domain/model/PolygonOptions;", "animateCamera", "", "update", "Lcom/talabat/maps/domain/CameraUpdate;", "max", "", "cancelableCallback", "Lcom/talabat/maps/domain/FrameworkMap$CancelableCallback;", "clear", "moveCamera", "cameraUpdate", "setLatLngBoundsForCameraTarget", "latLngBounds", "Lcom/talabat/maps/domain/model/LatLngBounds;", "setMaxZoomPreference", "maxZoom", "setMinZoomPreference", "minZoom", "setOnCameraIdleListener", "onCameraIdleListener", "Lcom/talabat/maps/domain/FrameworkMap$OnCameraIdleListener;", "setOnCameraMoveCanceledListener", "onCameraMoveCanceledListener", "Lcom/talabat/maps/domain/FrameworkMap$OnCameraMoveCanceledListener;", "setOnCameraMoveListener", "listenerWrapper", "Lcom/talabat/maps/domain/FrameworkMap$OnCameraMoveListener;", "setOnCameraMoveStartedListener", "listener", "Lcom/talabat/maps/domain/FrameworkMap$OnCameraMoveStartedListener;", "setOnMapClickListener", "onMapClickListener", "Lcom/talabat/maps/domain/OnMapClickListener;", "setOnMapLoadedCallback", "callback", "Lkotlin/Function0;", "setPadding", "left", "top", "right", "bottom", "CancelableCallback", "MapType", "OnCameraIdleListener", "OnCameraMoveCanceledListener", "OnCameraMoveListener", "OnCameraMoveStartedListener", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FrameworkMap {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/maps/domain/FrameworkMap$CancelableCallback;", "", "onCancel", "", "onFinish", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/maps/domain/FrameworkMap$MapType;", "", "(Ljava/lang/String;I)V", "MAP_TYPE_NORMAL", "MAP_TYPE_SATELLITE", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum MapType {
        MAP_TYPE_NORMAL,
        MAP_TYPE_SATELLITE
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/maps/domain/FrameworkMap$OnCameraIdleListener;", "", "onCameraIdle", "", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCameraIdleListener {
        void onCameraIdle();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/maps/domain/FrameworkMap$OnCameraMoveCanceledListener;", "", "onCameraMoveCanceled", "", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCameraMoveCanceledListener {
        void onCameraMoveCanceled();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/maps/domain/FrameworkMap$OnCameraMoveListener;", "", "onCameraMove", "", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCameraMoveListener {
        void onCameraMove();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/maps/domain/FrameworkMap$OnCameraMoveStartedListener;", "", "onCameraMoveStarted", "", "i", "", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCameraMoveStartedListener {
        void onCameraMoveStarted(int i11);
    }

    @NotNull
    Circle addCircle(@NotNull CircleOptions circleOptions);

    @Nullable
    Marker addMarker(@NotNull MarkerOptions markerOptions);

    @NotNull
    Polygon addPolygon(@NotNull PolygonOptions polygonOptions);

    void animateCamera(@NotNull CameraUpdate cameraUpdate);

    void animateCamera(@NotNull CameraUpdate cameraUpdate, int i11, @NotNull CancelableCallback cancelableCallback);

    void clear();

    boolean getBuildingsEnabled();

    @NotNull
    CameraPosition getCameraPosition();

    boolean getIndoorEnabled();

    @NotNull
    MapType getMapType();

    float getMaxZoomLevel();

    boolean getMyLocationEnabled();

    @NotNull
    UiSettingsWrapper getUiSettings();

    void moveCamera(@NotNull CameraUpdate cameraUpdate);

    void setBuildingsEnabled(boolean z11);

    void setIndoorEnabled(boolean z11);

    void setLatLngBoundsForCameraTarget(@Nullable LatLngBounds latLngBounds);

    void setMapType(@NotNull MapType mapType);

    void setMaxZoomPreference(float f11);

    void setMinZoomPreference(float f11);

    void setMyLocationEnabled(boolean z11);

    void setOnCameraIdleListener(@NotNull OnCameraIdleListener onCameraIdleListener);

    void setOnCameraMoveCanceledListener(@NotNull OnCameraMoveCanceledListener onCameraMoveCanceledListener);

    void setOnCameraMoveListener(@NotNull OnCameraMoveListener onCameraMoveListener);

    void setOnCameraMoveStartedListener(@NotNull OnCameraMoveStartedListener onCameraMoveStartedListener);

    void setOnMapClickListener(@NotNull OnMapClickListener onMapClickListener);

    void setOnMapLoadedCallback(@NotNull Function0<Unit> function0);

    void setPadding(int i11, int i12, int i13, int i14);
}
