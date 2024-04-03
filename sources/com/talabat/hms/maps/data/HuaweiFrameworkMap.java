package com.talabat.hms.maps.data;

import as.b;
import as.c;
import as.d;
import as.e;
import as.f;
import as.g;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.UiSettings;
import com.huawei.hms.maps.model.LatLng;
import com.talabat.hms.maps.data.model.HmsCameraPositionWrapper;
import com.talabat.hms.maps.data.model.HmsCircleOptionsWrapper;
import com.talabat.hms.maps.data.model.HmsCircleWrapper;
import com.talabat.hms.maps.data.model.HmsLatLngWrapper;
import com.talabat.hms.maps.data.model.HmsMarkerOptionsWrapper;
import com.talabat.hms.maps.data.model.HmsMarkerWrapper;
import com.talabat.hms.maps.data.model.HmsPolygonWrapper;
import com.talabat.maps.domain.CameraUpdate;
import com.talabat.maps.domain.FrameworkMap;
import com.talabat.maps.domain.OnMapClickListener;
import com.talabat.maps.domain.UiSettingsWrapper;
import com.talabat.maps.domain.model.CameraPosition;
import com.talabat.maps.domain.model.Circle;
import com.talabat.maps.domain.model.CircleOptions;
import com.talabat.maps.domain.model.LatLngBounds;
import com.talabat.maps.domain.model.Marker;
import com.talabat.maps.domain.model.MarkerOptions;
import com.talabat.maps.domain.model.Polygon;
import com.talabat.maps.domain.model.PolygonOptions;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016J \u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000201H\u0016J\u0010\u00109\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u000205H\u0002J\u0010\u0010:\u001a\u0002012\u0006\u0010;\u001a\u000203H\u0016J\u0012\u0010<\u001a\u0002012\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010?\u001a\u0002012\u0006\u0010@\u001a\u00020\u001aH\u0016J\u0010\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020\u001aH\u0016J\u0010\u0010C\u001a\u0002012\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010L\u001a\u0002012\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u0002012\u0006\u0010P\u001a\u00020QH\u0016J\u0016\u0010R\u001a\u0002012\f\u0010S\u001a\b\u0012\u0004\u0012\u0002010TH\u0016J(\u0010U\u001a\u0002012\u0006\u0010V\u001a\u0002052\u0006\u0010W\u001a\u0002052\u0006\u0010X\u001a\u0002052\u0006\u0010Y\u001a\u000205H\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00138V@VX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR\u0014\u0010 \u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006Z"}, d2 = {"Lcom/talabat/hms/maps/data/HuaweiFrameworkMap;", "Lcom/talabat/maps/domain/FrameworkMap;", "huaweiMapInstance", "Lcom/huawei/hms/maps/HuaweiMap;", "(Lcom/huawei/hms/maps/HuaweiMap;)V", "value", "", "buildingsEnabled", "getBuildingsEnabled", "()Z", "setBuildingsEnabled", "(Z)V", "cameraPosition", "Lcom/talabat/maps/domain/model/CameraPosition;", "getCameraPosition", "()Lcom/talabat/maps/domain/model/CameraPosition;", "indoorEnabled", "getIndoorEnabled", "setIndoorEnabled", "Lcom/talabat/maps/domain/FrameworkMap$MapType;", "mapType", "getMapType", "()Lcom/talabat/maps/domain/FrameworkMap$MapType;", "setMapType", "(Lcom/talabat/maps/domain/FrameworkMap$MapType;)V", "maxZoomLevel", "", "getMaxZoomLevel", "()F", "myLocationEnabled", "getMyLocationEnabled", "setMyLocationEnabled", "uiSettings", "Lcom/talabat/maps/domain/UiSettingsWrapper;", "getUiSettings", "()Lcom/talabat/maps/domain/UiSettingsWrapper;", "addCircle", "Lcom/talabat/maps/domain/model/Circle;", "circleOptions", "Lcom/talabat/maps/domain/model/CircleOptions;", "addMarker", "Lcom/talabat/maps/domain/model/Marker;", "markerOptions", "Lcom/talabat/maps/domain/model/MarkerOptions;", "addPolygon", "Lcom/talabat/maps/domain/model/Polygon;", "polygonOptions", "Lcom/talabat/maps/domain/model/PolygonOptions;", "animateCamera", "", "update", "Lcom/talabat/maps/domain/CameraUpdate;", "max", "", "cancelableCallback", "Lcom/talabat/maps/domain/FrameworkMap$CancelableCallback;", "clear", "convertMapType", "moveCamera", "cameraUpdate", "setLatLngBoundsForCameraTarget", "latLngBounds", "Lcom/talabat/maps/domain/model/LatLngBounds;", "setMaxZoomPreference", "maxZoom", "setMinZoomPreference", "minZoom", "setOnCameraIdleListener", "onCameraIdleListener", "Lcom/talabat/maps/domain/FrameworkMap$OnCameraIdleListener;", "setOnCameraMoveCanceledListener", "onCameraMoveCanceledListener", "Lcom/talabat/maps/domain/FrameworkMap$OnCameraMoveCanceledListener;", "setOnCameraMoveListener", "listenerWrapper", "Lcom/talabat/maps/domain/FrameworkMap$OnCameraMoveListener;", "setOnCameraMoveStartedListener", "listener", "Lcom/talabat/maps/domain/FrameworkMap$OnCameraMoveStartedListener;", "setOnMapClickListener", "onMapClickListener", "Lcom/talabat/maps/domain/OnMapClickListener;", "setOnMapLoadedCallback", "callback", "Lkotlin/Function0;", "setPadding", "left", "top", "right", "bottom", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HuaweiFrameworkMap implements FrameworkMap {
    @NotNull
    private final HuaweiMap huaweiMapInstance;
    @NotNull
    private final UiSettingsWrapper uiSettings;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FrameworkMap.MapType.values().length];
            iArr[FrameworkMap.MapType.MAP_TYPE_SATELLITE.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HuaweiFrameworkMap(@NotNull HuaweiMap huaweiMap) {
        Intrinsics.checkNotNullParameter(huaweiMap, "huaweiMapInstance");
        this.huaweiMapInstance = huaweiMap;
        UiSettings uiSettings2 = huaweiMap.getUiSettings();
        Intrinsics.checkNotNullExpressionValue(uiSettings2, "huaweiMapInstance.uiSettings");
        this.uiSettings = new HuaweiMapUiSettingsWrapper(uiSettings2);
    }

    private final FrameworkMap.MapType convertMapType(int i11) {
        if (i11 == 3) {
            return FrameworkMap.MapType.MAP_TYPE_SATELLITE;
        }
        return FrameworkMap.MapType.MAP_TYPE_NORMAL;
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnCameraIdleListener$lambda-3  reason: not valid java name */
    public static final void m10631setOnCameraIdleListener$lambda3(FrameworkMap.OnCameraIdleListener onCameraIdleListener) {
        Intrinsics.checkNotNullParameter(onCameraIdleListener, "$onCameraIdleListener");
        onCameraIdleListener.onCameraIdle();
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnCameraMoveCanceledListener$lambda-2  reason: not valid java name */
    public static final void m10632setOnCameraMoveCanceledListener$lambda2(FrameworkMap.OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        Intrinsics.checkNotNullParameter(onCameraMoveCanceledListener, "$onCameraMoveCanceledListener");
        onCameraMoveCanceledListener.onCameraMoveCanceled();
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnCameraMoveListener$lambda-1  reason: not valid java name */
    public static final void m10633setOnCameraMoveListener$lambda1(FrameworkMap.OnCameraMoveListener onCameraMoveListener) {
        Intrinsics.checkNotNullParameter(onCameraMoveListener, "$listenerWrapper");
        onCameraMoveListener.onCameraMove();
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnCameraMoveStartedListener$lambda-0  reason: not valid java name */
    public static final void m10634setOnCameraMoveStartedListener$lambda0(FrameworkMap.OnCameraMoveStartedListener onCameraMoveStartedListener, int i11) {
        Intrinsics.checkNotNullParameter(onCameraMoveStartedListener, "$listener");
        onCameraMoveStartedListener.onCameraMoveStarted(i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnMapClickListener$lambda-4  reason: not valid java name */
    public static final void m10635setOnMapClickListener$lambda4(OnMapClickListener onMapClickListener, LatLng latLng) {
        Intrinsics.checkNotNullParameter(onMapClickListener, "$onMapClickListener");
        Intrinsics.checkNotNullExpressionValue(latLng, "it");
        onMapClickListener.onMapClick(new HmsLatLngWrapper(latLng));
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnMapLoadedCallback$lambda-5  reason: not valid java name */
    public static final void m10636setOnMapLoadedCallback$lambda5(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    @NotNull
    public Circle addCircle(@NotNull CircleOptions circleOptions) {
        Intrinsics.checkNotNullParameter(circleOptions, "circleOptions");
        com.huawei.hms.maps.model.Circle addCircle = this.huaweiMapInstance.addCircle(((HmsCircleOptionsWrapper) circleOptions).getHuaweiCircleOptions());
        Intrinsics.checkNotNullExpressionValue(addCircle, "huaweiMapInstance.addCir…rcleOptions\n            )");
        return new HmsCircleWrapper(addCircle);
    }

    @Nullable
    public Marker addMarker(@NotNull MarkerOptions markerOptions) {
        Intrinsics.checkNotNullParameter(markerOptions, "markerOptions");
        com.huawei.hms.maps.model.Marker addMarker = this.huaweiMapInstance.addMarker(((HmsMarkerOptionsWrapper) markerOptions).getHuaweiMarkerOptions());
        if (addMarker == null) {
            return null;
        }
        return new HmsMarkerWrapper(addMarker);
    }

    @NotNull
    public Polygon addPolygon(@NotNull PolygonOptions polygonOptions) {
        Intrinsics.checkNotNullParameter(polygonOptions, "polygonOptions");
        com.huawei.hms.maps.model.Polygon addPolygon = this.huaweiMapInstance.addPolygon(ExtensionsKt.huaweiPolygonOptions(polygonOptions));
        Intrinsics.checkNotNullExpressionValue(addPolygon, "huaweiMapInstance.addPol…s.huaweiPolygonOptions())");
        return new HmsPolygonWrapper(addPolygon);
    }

    public void animateCamera(@NotNull CameraUpdate cameraUpdate) {
        Intrinsics.checkNotNullParameter(cameraUpdate, Constant.METHOD_UPDATE);
        this.huaweiMapInstance.animateCamera(ExtensionsKt.huaweiCameraUpdate(cameraUpdate));
    }

    public void clear() {
        this.huaweiMapInstance.clear();
    }

    public boolean getBuildingsEnabled() {
        return this.huaweiMapInstance.isBuildingsEnabled();
    }

    @NotNull
    public CameraPosition getCameraPosition() {
        com.huawei.hms.maps.model.CameraPosition cameraPosition = this.huaweiMapInstance.getCameraPosition();
        Intrinsics.checkNotNullExpressionValue(cameraPosition, "huaweiMapInstance.cameraPosition");
        return new HmsCameraPositionWrapper(cameraPosition);
    }

    public boolean getIndoorEnabled() {
        return this.huaweiMapInstance.isIndoorEnabled();
    }

    @NotNull
    public FrameworkMap.MapType getMapType() {
        return convertMapType(this.huaweiMapInstance.getMapType());
    }

    public float getMaxZoomLevel() {
        return this.huaweiMapInstance.getMaxZoomLevel();
    }

    public boolean getMyLocationEnabled() {
        return this.huaweiMapInstance.isMyLocationEnabled();
    }

    @NotNull
    public UiSettingsWrapper getUiSettings() {
        return this.uiSettings;
    }

    public void moveCamera(@NotNull CameraUpdate cameraUpdate) {
        Intrinsics.checkNotNullParameter(cameraUpdate, Param.CAMERA_UPDATE);
        this.huaweiMapInstance.moveCamera(ExtensionsKt.huaweiCameraUpdate(cameraUpdate));
    }

    public void setBuildingsEnabled(boolean z11) {
        this.huaweiMapInstance.setBuildingsEnabled(z11);
    }

    public void setIndoorEnabled(boolean z11) {
        this.huaweiMapInstance.setIndoorEnabled(z11);
    }

    public void setLatLngBoundsForCameraTarget(@Nullable LatLngBounds latLngBounds) {
        com.huawei.hms.maps.model.LatLngBounds latLngBounds2;
        HuaweiMap huaweiMap = this.huaweiMapInstance;
        if (latLngBounds != null) {
            latLngBounds2 = ExtensionsKt.huaweiLatLngBounds(latLngBounds);
        } else {
            latLngBounds2 = null;
        }
        huaweiMap.setLatLngBoundsForCameraTarget(latLngBounds2);
    }

    public void setMapType(@NotNull FrameworkMap.MapType mapType) {
        Intrinsics.checkNotNullParameter(mapType, "value");
        HuaweiMap huaweiMap = this.huaweiMapInstance;
        int i11 = 1;
        if (WhenMappings.$EnumSwitchMapping$0[mapType.ordinal()] == 1) {
            i11 = 3;
        }
        huaweiMap.setMapType(i11);
    }

    public void setMaxZoomPreference(float f11) {
        this.huaweiMapInstance.setMaxZoomPreference(f11);
    }

    public void setMinZoomPreference(float f11) {
        this.huaweiMapInstance.setMinZoomPreference(f11);
    }

    public void setMyLocationEnabled(boolean z11) {
        try {
            this.huaweiMapInstance.setMyLocationEnabled(z11);
        } catch (Throwable unused) {
        }
    }

    public void setOnCameraIdleListener(@NotNull FrameworkMap.OnCameraIdleListener onCameraIdleListener) {
        Intrinsics.checkNotNullParameter(onCameraIdleListener, "onCameraIdleListener");
        this.huaweiMapInstance.setOnCameraIdleListener(new d(onCameraIdleListener));
    }

    public void setOnCameraMoveCanceledListener(@NotNull FrameworkMap.OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        Intrinsics.checkNotNullParameter(onCameraMoveCanceledListener, "onCameraMoveCanceledListener");
        this.huaweiMapInstance.setOnCameraMoveCanceledListener(new b(onCameraMoveCanceledListener));
    }

    public void setOnCameraMoveListener(@NotNull FrameworkMap.OnCameraMoveListener onCameraMoveListener) {
        Intrinsics.checkNotNullParameter(onCameraMoveListener, "listenerWrapper");
        this.huaweiMapInstance.setOnCameraMoveListener(new f(onCameraMoveListener));
    }

    public void setOnCameraMoveStartedListener(@NotNull FrameworkMap.OnCameraMoveStartedListener onCameraMoveStartedListener) {
        Intrinsics.checkNotNullParameter(onCameraMoveStartedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.huaweiMapInstance.setOnCameraMoveStartedListener(new g(onCameraMoveStartedListener));
    }

    public void setOnMapClickListener(@NotNull OnMapClickListener onMapClickListener) {
        Intrinsics.checkNotNullParameter(onMapClickListener, "onMapClickListener");
        this.huaweiMapInstance.setOnMapClickListener(new e(onMapClickListener));
    }

    public void setOnMapLoadedCallback(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.huaweiMapInstance.setOnMapLoadedCallback(new c(function0));
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        this.huaweiMapInstance.setPadding(i11, i12, i13, i14);
    }

    public void animateCamera(@NotNull CameraUpdate cameraUpdate, int i11, @NotNull FrameworkMap.CancelableCallback cancelableCallback) {
        Intrinsics.checkNotNullParameter(cameraUpdate, Constant.METHOD_UPDATE);
        Intrinsics.checkNotNullParameter(cancelableCallback, "cancelableCallback");
        this.huaweiMapInstance.animateCamera(ExtensionsKt.huaweiCameraUpdate(cameraUpdate), i11, new HuaweiFrameworkMap$animateCamera$1(cancelableCallback));
    }
}
