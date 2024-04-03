package com.huawei.hms.flutter.map.utils;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.huawei.hms.flutter.map.circle.CircleMethods;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.flutter.map.groundoverlay.GroundOverlayMethods;
import com.huawei.hms.flutter.map.heatmap.HeatMapMethods;
import com.huawei.hms.flutter.map.map.MapMethods;
import com.huawei.hms.flutter.map.marker.MarkerMethods;
import com.huawei.hms.flutter.map.polygon.PolygonMethods;
import com.huawei.hms.flutter.map.polyline.PolylineMethods;
import com.huawei.hms.flutter.map.tileoverlay.TileOverlayMethods;
import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.model.BitmapDescriptorFactory;
import com.huawei.hms.maps.model.CameraPosition;
import com.huawei.hms.maps.model.HeatMapOptions;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.model.MyLocationStyle;
import com.huawei.hms.maps.model.Tile;
import com.huawei.hms.maps.model.TileProvider;
import com.huawei.hms.maps.model.UrlTileProvider;
import com.huawei.hms.maps.model.animation.AlphaAnimation;
import com.huawei.hms.maps.model.animation.Animation;
import com.huawei.hms.maps.model.animation.AnimationSet;
import com.huawei.hms.maps.model.animation.RotateAnimation;
import com.huawei.hms.maps.model.animation.ScaleAnimation;
import com.huawei.hms.maps.model.animation.TranslateAnimation;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ya.a;
import ya.b;

@Instrumented
public class Convert {
    private static BitmapDescriptor getBitmapFromBytes(List<?> list) {
        if (list.size() == 2) {
            try {
                return BitmapDescriptorFactory.fromBitmap(toBitmap(list.get(1)));
            } catch (Exception unused) {
                throw new IllegalArgumentException(Param.ERROR);
            }
        } else {
            throw new IllegalArgumentException(Param.ERROR);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Tile lambda$toTileProvider$0(HashMap hashMap, int i11, int i12, int i13) {
        String str;
        int i14 = 0;
        List asList = Arrays.asList(new Integer[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)});
        if (hashMap.containsKey(asList) && (str = (String) hashMap.get(asList)) != null && str.length() > 0) {
            String[] split = str.substring(1, str.length() - 1).split(",");
            int length = split.length;
            byte[] bArr = new byte[length];
            while (i14 < length) {
                try {
                    bArr[i14] = Byte.parseByte(split[i14].trim());
                    i14++;
                } catch (Exception unused) {
                    Log.e("TileProvider Error", "Please provide a valid image", (Throwable) null);
                }
            }
            return new Tile(256, 256, bArr);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Tile lambda$toTileProvider$1(List list, byte[] bArr, int i11, int i12, int i13) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Integer) it.next()).intValue() == i13) {
                return new Tile(256, 256, bArr);
            }
        }
        return null;
    }

    public static Animation processAnimationOptions(Object obj, BinaryMessenger binaryMessenger) throws JSONException {
        Animation animation;
        Animation animation2;
        JSONObject jSONObject = (JSONObject) obj;
        final MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.huawei.hms.flutter.map/animation_" + jSONObject.get(Param.ANIMATION_ID));
        String str = (String) jSONObject.get(Param.ANIMATION_TYPE);
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1586046364:
                if (str.equals("HmsTranslateAnimation")) {
                    c11 = 0;
                    break;
                }
                break;
            case 899392340:
                if (str.equals("HmsAlphaAnimation")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1035646619:
                if (str.equals("HmsRotateAnimation")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1709733096:
                if (str.equals("HmsScaleAnimation")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                JSONArray jSONArray = (JSONArray) jSONObject.get(Param.LAT_LNG);
                animation = new TranslateAnimation(new LatLng(toDouble(jSONArray.get(0)), toDouble(jSONArray.get(1))));
                break;
            case 1:
                animation2 = new AlphaAnimation(toFloat(jSONObject.get(Param.FROM_ALPHA)), toFloat(jSONObject.get(Param.TO_ALPHA)));
                break;
            case 2:
                animation2 = new RotateAnimation(toFloat(jSONObject.get(Param.FROM_DEGREE)), toFloat(jSONObject.get(Param.TO_DEGREE)));
                break;
            case 3:
                animation = new ScaleAnimation(toFloat(jSONObject.get(Param.FROM_X)), toFloat(jSONObject.get(Param.TO_X)), toFloat(jSONObject.get(Param.FROM_Y)), toFloat(jSONObject.get(Param.TO_Y)));
                break;
            default:
                animation = null;
                break;
        }
        animation = animation2;
        Object obj2 = jSONObject.get("duration");
        if (animation != null) {
            animation.setDuration((long) toInt(obj2));
        }
        Object obj3 = jSONObject.get(Param.FILL_MODE);
        if (animation != null) {
            animation.setFillMode(toInt(obj3));
        }
        Object obj4 = jSONObject.get(Param.REPEAT_COUNT);
        if (animation != null) {
            animation.setRepeatCount(toInt(obj4));
        }
        Object obj5 = jSONObject.get(Param.REPEAT_MODE);
        if (animation != null) {
            animation.setRepeatMode(toInt(obj5));
        }
        Object obj6 = jSONObject.get(Param.INTERPOLATOR);
        if (animation != null) {
            animation.setInterpolator(toInterpolator(toInt(obj6)));
        }
        if (animation != null) {
            animation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd() {
                    MethodChannel.this.invokeMethod("onAnimationEnd", (Object) null);
                }

                public void onAnimationStart() {
                    MethodChannel.this.invokeMethod("onAnimationStart", (Object) null);
                }
            });
        }
        return animation;
    }

    public static AnimationSet processAnimationSet(Object obj, BinaryMessenger binaryMessenger) {
        AnimationSet animationSet = new AnimationSet(false);
        try {
            JSONArray jSONArray = new JSONArray((String) obj);
            for (int i11 = 0; i11 <= jSONArray.length() - 1; i11++) {
                animationSet.addAnimation(processAnimationOptions(jSONArray.getJSONObject(i11), binaryMessenger));
            }
        } catch (JSONException e11) {
            Log.e("Convert", e11.getMessage());
        }
        return animationSet;
    }

    public static String processCircleOptions(Object obj, CircleMethods circleMethods, BinaryMessenger binaryMessenger) {
        Map<?, ?> map = toMap(obj);
        Object obj2 = map.get(Param.CLICKABLE);
        if (obj2 != null) {
            circleMethods.setClickable(toBoolean(obj2));
        }
        Object obj3 = map.get(Param.FILL_COLOR);
        if (obj3 != null) {
            circleMethods.setFillColor(toInt(obj3));
        }
        Object obj4 = map.get(Param.STROKE_COLOR);
        if (obj4 != null) {
            circleMethods.setStrokeColor(toInt(obj4));
        }
        Object obj5 = map.get(Param.VISIBLE);
        if (obj5 != null) {
            circleMethods.setVisible(toBoolean(obj5));
        }
        Object obj6 = map.get(Param.STROKE_WIDTH);
        if (obj6 != null) {
            circleMethods.setStrokeWidth((float) toInt(obj6));
        }
        Object obj7 = map.get(Param.Z_INDEX);
        if (obj7 != null) {
            circleMethods.setZIndex(toFloat(obj7));
        }
        Object obj8 = map.get("center");
        if (obj8 != null) {
            circleMethods.setCenter(toLatLng(obj8));
        }
        Object obj9 = map.get(Param.RADIUS);
        if (obj9 != null) {
            circleMethods.setRadius(toDouble(obj9));
        }
        Object obj10 = map.get(Param.STROKE_PATTERN);
        if (obj10 != null) {
            circleMethods.setStrokePattern(toPattern(obj10));
        }
        Object obj11 = map.get(Param.ANIMATION);
        if (obj11 != null) {
            try {
                circleMethods.setAnimation(processAnimationOptions(new JSONObject((String) obj11), binaryMessenger));
            } catch (JSONException e11) {
                Log.e("processCircleOptions", e11.getMessage());
            }
        }
        String str = (String) map.get(Param.CIRCLE_ID);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException(Param.ERROR);
    }

    public static String processGroundOverlayOptions(Object obj, GroundOverlayMethods groundOverlayMethods) {
        Map<?, ?> map = toMap(obj);
        Object obj2 = map.get(Param.BEARING);
        if (obj2 != null) {
            groundOverlayMethods.setBearing(toFloat(obj2));
        }
        Object obj3 = map.get(Param.CLICKABLE);
        if (obj3 != null) {
            groundOverlayMethods.setClickable(toBoolean(obj3));
        }
        Object obj4 = map.get(Param.IMAGE_DESCRIPTOR);
        if (obj4 != null) {
            groundOverlayMethods.setImage(toBitmapDescriptor(obj4));
        }
        Object obj5 = map.get("position");
        Object obj6 = map.get("width");
        Object obj7 = map.get("height");
        if (obj5 != null) {
            groundOverlayMethods.setPosition(toLatLng(obj5), toFloat(obj6), toFloat(obj7));
        }
        Object obj8 = map.get(Param.ANCHOR);
        if (obj8 != null) {
            List<?> list = toList(obj8);
            groundOverlayMethods.setAnchor(toFloat(list.get(0)), toFloat(list.get(1)));
        }
        Object obj9 = map.get(Param.BOUNDS);
        if (obj9 != null) {
            groundOverlayMethods.setPositionFromBounds(toLatLngBounds(obj9));
        }
        Object obj10 = map.get(Param.VISIBLE);
        if (obj10 != null) {
            groundOverlayMethods.setVisible(toBoolean(obj10));
        }
        Object obj11 = map.get(Param.TRANSPARENCY);
        if (obj11 != null) {
            groundOverlayMethods.setTransparency(toFloat(obj11));
        }
        Object obj12 = map.get(Param.Z_INDEX);
        if (obj12 != null) {
            groundOverlayMethods.setZIndex(toFloat(obj12));
        }
        String str = (String) map.get(Param.GROUND_OVERLAY_ID);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException(Param.ERROR);
    }

    public static String processHeatMapOptions(Object obj, HeatMapMethods heatMapMethods) {
        Map<?, ?> map = toMap(obj);
        Object obj2 = map.get("color");
        if (obj2 != null) {
            heatMapMethods.setColor(toColorMap(obj2));
        }
        Object obj3 = map.get(Param.RESOURCE_ID);
        if (obj3 != null) {
            heatMapMethods.setDataSet(toInt(obj3));
            heatMapMethods.setResourceId(toInt(obj3));
        }
        Object obj4 = map.get(Param.JSON_DATA);
        if (obj4 != null) {
            heatMapMethods.setDataSet(toString(obj4));
        }
        Object obj5 = map.get(Param.INTENSITY);
        if (obj5 != null) {
            heatMapMethods.setIntensity(toFloat(obj5));
        }
        Object obj6 = map.get(Param.INTENSITY_MAP);
        if (obj6 != null) {
            heatMapMethods.setIntensity(toFloatMap(obj6));
        }
        Object obj7 = map.get(Param.OPACITY);
        if (obj7 != null) {
            heatMapMethods.setOpacity(toFloat(obj7));
        }
        Object obj8 = map.get(Param.OPACITY_MAP);
        if (obj8 != null) {
            heatMapMethods.setOpacity(toFloatMap(obj8));
        }
        Object obj9 = map.get(Param.RADIUS);
        if (obj9 != null) {
            heatMapMethods.setRadius(toFloat(obj9));
        }
        Object obj10 = map.get(Param.RADIUS_MAP);
        if (obj10 != null) {
            heatMapMethods.setRadius(toFloatMap(obj10));
        }
        Object obj11 = map.get(Param.RADIUS_UNIT);
        if (obj11 != null) {
            int i11 = toInt(obj11);
            if (i11 == 0) {
                heatMapMethods.setRadiusUnit(HeatMapOptions.RadiusUnit.PIXEL);
            } else if (i11 != 1) {
                Log.e("processHeatMapOptions", "Invalid RadiusUnit", (Throwable) null);
            } else {
                heatMapMethods.setRadiusUnit(HeatMapOptions.RadiusUnit.METER);
            }
        }
        String str = (String) map.get(Param.HEAT_MAP_ID);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException(Param.ERROR);
    }

    public static void processHuaweiMapOptions(Object obj, MapMethods mapMethods) {
        Map<?, ?> map = toMap(obj);
        Object obj2 = map.get(Param.CAMERA_TARGET_BOUNDS);
        if (obj2 != null) {
            mapMethods.setCameraTargetBounds(toLatLngBounds(toList(obj2).get(0)));
        }
        Object obj3 = map.get(Param.COMPASS_ENABLED);
        if (obj3 != null) {
            mapMethods.setCompassEnabled(toBoolean(obj3));
        }
        Object obj4 = map.get(Param.IS_DARK);
        if (obj4 != null) {
            mapMethods.setDark(toBoolean(obj4));
        }
        Object obj5 = map.get(Param.MAP_TOOLBAR_ENABLED);
        if (obj5 != null) {
            mapMethods.setMapToolbarEnabled(toBoolean(obj5));
        }
        Object obj6 = map.get(Param.MAP_TYPE);
        if (obj6 != null) {
            mapMethods.setMapType(toInt(obj6));
        }
        Object obj7 = map.get(Param.MIN_MAX_ZOOM_PREFERENCE);
        if (obj7 != null) {
            List<?> list = toList(obj7);
            mapMethods.setMinMaxZoomPreference(toFloatWrapper(list.get(0)), toFloatWrapper(list.get(1)));
        }
        Object obj8 = map.get(Param.PADDING);
        if (obj8 != null) {
            List<?> list2 = toList(obj8);
            mapMethods.setPadding(toFloat(list2.get(0)), toFloat(list2.get(1)), toFloat(list2.get(2)), toFloat(list2.get(3)));
        }
        Object obj9 = map.get(Param.TRACK_CAMERA_POSITION);
        if (obj9 != null) {
            mapMethods.setTrackCameraPosition(toBoolean(obj9));
        }
        Object obj10 = map.get(Param.MY_LOCATION_ENABLED);
        if (obj10 != null) {
            mapMethods.setMyLocationEnabled(toBoolean(obj10));
        }
        Object obj11 = map.get(Param.ZOOM_CONTROLS_ENABLED);
        if (obj11 != null) {
            mapMethods.setZoomControlsEnabled(toBoolean(obj11));
        }
        Object obj12 = map.get(Param.MY_LOCATION_BUTTON_ENABLED);
        if (obj12 != null) {
            mapMethods.setMyLocationButtonEnabled(toBoolean(obj12));
        }
        Object obj13 = map.get(Param.TRAFFIC_ENABLED);
        if (obj13 != null) {
            mapMethods.setTrafficEnabled(toBoolean(obj13));
        }
        Object obj14 = map.get(Param.MARKERS_CLUSTERING_ENABLED);
        if (obj14 != null) {
            mapMethods.setMarkersClustering(toBoolean(obj14));
        }
        Object obj15 = map.get(Param.BUILDINGS_ENABLED);
        if (obj15 != null) {
            mapMethods.setBuildingsEnabled(toBoolean(obj15));
        }
        Object obj16 = map.get(Param.ALL_GESTURES_ENABLED);
        if (obj16 != null) {
            mapMethods.setAllGesturesEnabled(Boolean.valueOf(toBoolean(obj16)));
        }
        Object obj17 = map.get(Param.IS_SCROLL_GESTURES_ENABLED_DURING_ROTATE_OR_ZOOM);
        if (obj17 != null) {
            mapMethods.setScrollGesturesEnabledDuringRotateOrZoom(toBoolean(obj17));
        }
        Object obj18 = map.get(Param.GESTURE_SCALE_BY_MAP_CENTER);
        if (obj18 != null) {
            mapMethods.setGestureScaleByMapCenter(toBoolean(obj18));
        }
        Object obj19 = map.get(Param.POINT_TO_CENTER);
        if (obj19 != null) {
            mapMethods.setPointToCenter(toPoint(obj19));
        }
        Object obj20 = map.get(Param.CLUSTER_MARKER_COLOR);
        if (obj20 != null) {
            mapMethods.setClusterMarkerColor(toIntegerWrapper(obj20));
        }
        Object obj21 = map.get(Param.CLUSTER_MARKER_TEXT_COLOR);
        if (obj21 != null) {
            mapMethods.setClusterMarkerTextColor(toIntegerWrapper(obj21));
        }
        Object obj22 = map.get(Param.CLUSTER_MARKER_ICON);
        if (obj22 != null) {
            mapMethods.setClusterMarkerIcon(toBitmapDescriptor(obj22));
        }
        Object obj23 = map.get(Param.LOGO_POSITION);
        if (obj23 != null) {
            mapMethods.setLogoPosition(toInt(obj23));
        }
        Object obj24 = map.get(Param.LOGO_PADDING);
        if (obj24 != null) {
            List<?> list3 = toList(obj24);
            mapMethods.setLogoPadding(toInt(list3.get(1)), toInt(list3.get(0)), toInt(list3.get(3)), toInt(list3.get(2)));
        }
        Object obj25 = map.get(Param.PREVIEW_ID);
        if (obj25 != null) {
            mapMethods.setPreviewId(toString(obj25));
        }
        Object obj26 = map.get(Param.STYLE_ID);
        if (obj26 != null) {
            mapMethods.setStyleId(toString(obj26));
        }
        Object obj27 = map.get(Param.LITE_MODE);
        if (obj27 != null) {
            mapMethods.setLiteMode(Boolean.valueOf(toBoolean(obj27)));
        }
        Object obj28 = map.get(Param.MYLOCATION_STYLE);
        if (obj28 != null) {
            mapMethods.setMyLocationStyle(toMyLocationStyle(obj28));
        }
        processHuaweiMapOptionsGestures(map, mapMethods);
    }

    private static void processHuaweiMapOptionsGestures(Map<?, ?> map, MapMethods mapMethods) {
        Object obj = map.get(Param.ROTATE_GESTURES_ENABLED);
        if (obj != null) {
            mapMethods.setRotateGesturesEnabled(toBoolean(obj));
        }
        Object obj2 = map.get(Param.SCROLL_GESTURES_ENABLED);
        if (obj2 != null) {
            mapMethods.setScrollGesturesEnabled(toBoolean(obj2));
        }
        Object obj3 = map.get(Param.TILT_GESTURES_ENABLED);
        if (obj3 != null) {
            mapMethods.setTiltGesturesEnabled(toBoolean(obj3));
        }
        Object obj4 = map.get(Param.ZOOM_GESTURES_ENABLED);
        if (obj4 != null) {
            mapMethods.setZoomGesturesEnabled(toBoolean(obj4));
        }
    }

    private static void processInfoWindowOptions(Map<String, Object> map, MarkerMethods markerMethods) {
        String str = (String) map.get("title");
        String str2 = (String) map.get(Param.SNIPPET);
        if (str != null) {
            markerMethods.setInfoWindowText(str, str2);
        }
        Object obj = map.get(Param.ANCHOR);
        if (obj != null) {
            List<?> list = toList(obj);
            markerMethods.setInfoWindowAnchor(toFloat(list.get(0)), toFloat(list.get(1)));
        }
    }

    public static String processMarkerOptions(Object obj, MarkerMethods markerMethods, BinaryMessenger binaryMessenger) {
        Map<?, ?> map = toMap(obj);
        Object obj2 = map.get(Param.INFO_WINDOW);
        if (obj2 != null) {
            processInfoWindowOptions((Map) obj2, markerMethods);
        }
        Object obj3 = map.get("alpha");
        if (obj3 != null) {
            markerMethods.setAlpha(toFloat(obj3));
        }
        Object obj4 = map.get(Param.ANCHOR);
        if (obj4 != null) {
            List<?> list = toList(obj4);
            markerMethods.setAnchor(toFloat(list.get(0)), toFloat(list.get(1)));
        }
        Object obj5 = map.get(Param.CLICKABLE);
        if (obj5 != null) {
            markerMethods.setClickable(toBoolean(obj5));
        }
        Object obj6 = map.get(Param.CLUSTERABLE);
        if (obj6 != null) {
            markerMethods.setClusterable(toBoolean(obj6));
        }
        Object obj7 = map.get(Param.DRAGGABLE);
        if (obj7 != null) {
            markerMethods.setDraggable(toBoolean(obj7));
        }
        Object obj8 = map.get(Param.FLAT);
        if (obj8 != null) {
            markerMethods.setFlat(toBoolean(obj8));
        }
        Object obj9 = map.get("icon");
        if (obj9 != null) {
            markerMethods.setIcon(toBitmapDescriptor(obj9));
        }
        Object obj10 = map.get("position");
        if (obj10 != null) {
            markerMethods.setPosition(toLatLng(obj10));
        }
        Object obj11 = map.get("rotation");
        if (obj11 != null) {
            markerMethods.setRotation(toFloat(obj11));
        }
        Object obj12 = map.get(Param.VISIBLE);
        if (obj12 != null) {
            markerMethods.setVisible(toBoolean(obj12));
        }
        Object obj13 = map.get(Param.Z_INDEX);
        if (obj13 != null) {
            markerMethods.setZIndex(toFloat(obj13));
        }
        Object obj14 = map.get(Param.ANIMATION);
        if (obj14 != null) {
            markerMethods.setAnimationSet(processAnimationSet(obj14, binaryMessenger));
        }
        String str = (String) map.get(Param.MARKER_ID);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException(Param.ERROR);
    }

    public static String processPolygonOptions(Object obj, PolygonMethods polygonMethods) {
        Map<?, ?> map = toMap(obj);
        Object obj2 = map.get(Param.CLICKABLE);
        if (obj2 != null) {
            polygonMethods.setClickable(toBoolean(obj2));
        }
        Object obj3 = map.get(Param.GEODESIC);
        if (obj3 != null) {
            polygonMethods.setGeodesic(toBoolean(obj3));
        }
        Object obj4 = map.get(Param.VISIBLE);
        if (obj4 != null) {
            polygonMethods.setVisible(toBoolean(obj4));
        }
        Object obj5 = map.get(Param.FILL_COLOR);
        if (obj5 != null) {
            polygonMethods.setFillColor(toInt(obj5));
        }
        Object obj6 = map.get(Param.STROKE_COLOR);
        if (obj6 != null) {
            polygonMethods.setStrokeColor(toInt(obj6));
        }
        Object obj7 = map.get(Param.STROKE_WIDTH);
        if (obj7 != null) {
            polygonMethods.setStrokeWidth((float) toInt(obj7));
        }
        Object obj8 = map.get(Param.Z_INDEX);
        if (obj8 != null) {
            polygonMethods.setZIndex(toFloat(obj8));
        }
        Object obj9 = map.get(Param.POINTS);
        if (obj9 != null) {
            polygonMethods.setPoints(toPoints(obj9));
        }
        Object obj10 = map.get(Param.HOLES);
        if (obj10 != null) {
            polygonMethods.setHoles(toHoles(obj10));
        }
        Object obj11 = map.get(Param.STROKE_JOINT_TYPE);
        if (obj11 != null) {
            polygonMethods.setStrokeJointType(toInt(obj11));
        }
        Object obj12 = map.get(Param.STROKE_PATTERN);
        if (obj12 != null) {
            polygonMethods.setStrokePattern(toPattern(obj12));
        }
        String str = (String) map.get(Param.POLYGON_ID);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException(Param.ERROR);
    }

    public static String processPolylineOptions(Object obj, PolylineMethods polylineMethods) {
        Map<?, ?> map = toMap(obj);
        Object obj2 = map.get(Param.CLICKABLE);
        if (obj2 != null) {
            polylineMethods.setClickable(toBoolean(obj2));
        }
        Object obj3 = map.get("color");
        if (obj3 != null) {
            polylineMethods.setColor(toInt(obj3));
        }
        Object obj4 = map.get(Param.END_CAP);
        if (obj4 != null) {
            polylineMethods.setEndCap(toCap(obj4));
        }
        Object obj5 = map.get(Param.GEODESIC);
        if (obj5 != null) {
            polylineMethods.setGeodesic(toBoolean(obj5));
        }
        Object obj6 = map.get(Param.JOINT_TYPE);
        if (obj6 != null) {
            polylineMethods.setJointType(toInt(obj6));
        }
        Object obj7 = map.get(Param.START_CAP);
        if (obj7 != null) {
            polylineMethods.setStartCap(toCap(obj7));
        }
        Object obj8 = map.get(Param.VISIBLE);
        if (obj8 != null) {
            polylineMethods.setVisible(toBoolean(obj8));
        }
        Object obj9 = map.get("width");
        if (obj9 != null) {
            polylineMethods.setWidth((float) toInt(obj9));
        }
        Object obj10 = map.get(Param.Z_INDEX);
        if (obj10 != null) {
            polylineMethods.setZIndex(toFloat(obj10));
        }
        Object obj11 = map.get(Param.POINTS);
        if (obj11 != null) {
            polylineMethods.setPoints(toPoints(obj11));
        }
        Object obj12 = map.get(Param.PATTERN);
        if (obj12 != null) {
            polylineMethods.setPattern(toPattern(obj12));
        }
        Object obj13 = map.get(Param.GRADIENT);
        if (obj13 != null) {
            polylineMethods.setGradient(toBoolean(obj13));
        }
        Object obj14 = map.get(Param.COLOR_VALUES);
        if (obj14 != null) {
            polylineMethods.setColorValues(toIntegerList(obj14));
        }
        String str = (String) map.get(Param.POLYLINE_ID);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException(Param.ERROR);
    }

    public static String processTileOverlayOptions(Object obj, TileOverlayMethods tileOverlayMethods) {
        Map<?, ?> map = toMap(obj);
        Object obj2 = map.get(Param.TILE_PROVIDER);
        if (obj2 != null) {
            try {
                tileOverlayMethods.setTileProvider(toTileProvider(obj2));
            } catch (JSONException e11) {
                Log.e("Convert", e11.getMessage());
            }
        }
        Object obj3 = map.get(Param.FADE_IN);
        if (obj3 != null) {
            tileOverlayMethods.setFadeIn(toBoolean(obj3));
        }
        Object obj4 = map.get(Param.TRANSPARENCY);
        if (obj4 != null) {
            tileOverlayMethods.setTransparency(toFloat(obj4));
        }
        Object obj5 = map.get(Param.VISIBLE);
        if (obj5 != null) {
            tileOverlayMethods.setVisible(toBoolean(obj5));
        }
        Object obj6 = map.get(Param.Z_INDEX);
        if (obj6 != null) {
            tileOverlayMethods.setZIndex(toFloat(obj6));
        }
        String str = (String) map.get(Param.TILE_OVERLAY_ID);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException(Param.ERROR);
    }

    private static Bitmap toBitmap(Object obj) {
        byte[] bArr = (byte[]) obj;
        Bitmap decodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(bArr, 0, bArr.length);
        if (decodeByteArray != null) {
            return decodeByteArray;
        }
        throw new IllegalArgumentException(Param.ERROR);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (r1.equals(com.huawei.hms.flutter.map.constants.Param.FROM_ASSET_IMAGE) == false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.huawei.hms.maps.model.BitmapDescriptor toBitmapDescriptor(java.lang.Object r7) {
        /*
            java.util.List r7 = toList(r7)
            r0 = 0
            java.lang.Object r1 = r7.get(r0)
            java.lang.String r1 = toString(r1)
            r1.hashCode()
            int r2 = r1.hashCode()
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = -1
            switch(r2) {
                case -458749035: goto L_0x003e;
                case 52960614: goto L_0x0033;
                case 54063841: goto L_0x0028;
                case 784458203: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            r0 = r6
            goto L_0x0047
        L_0x001d:
            java.lang.String r0 = "defaultMarker"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0026
            goto L_0x001b
        L_0x0026:
            r0 = r3
            goto L_0x0047
        L_0x0028:
            java.lang.String r0 = "fromBytes"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0031
            goto L_0x001b
        L_0x0031:
            r0 = r4
            goto L_0x0047
        L_0x0033:
            java.lang.String r0 = "fromAsset"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x003c
            goto L_0x001b
        L_0x003c:
            r0 = r5
            goto L_0x0047
        L_0x003e:
            java.lang.String r2 = "fromAssetImage"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0047
            goto L_0x001b
        L_0x0047:
            java.lang.String r1 = "ERROR"
            switch(r0) {
                case 0: goto L_0x009f;
                case 1: goto L_0x006f;
                case 2: goto L_0x006a;
                case 3: goto L_0x0052;
                default: goto L_0x004c;
            }
        L_0x004c:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>(r1)
            throw r7
        L_0x0052:
            int r0 = r7.size()
            if (r0 != r5) goto L_0x005d
            com.huawei.hms.maps.model.BitmapDescriptor r7 = com.huawei.hms.maps.model.BitmapDescriptorFactory.defaultMarker()
            return r7
        L_0x005d:
            java.lang.Object r7 = r7.get(r5)
            float r7 = toFloat(r7)
            com.huawei.hms.maps.model.BitmapDescriptor r7 = com.huawei.hms.maps.model.BitmapDescriptorFactory.defaultMarker(r7)
            return r7
        L_0x006a:
            com.huawei.hms.maps.model.BitmapDescriptor r7 = getBitmapFromBytes(r7)
            return r7
        L_0x006f:
            int r0 = r7.size()
            if (r0 != r4) goto L_0x0086
            java.lang.Object r7 = r7.get(r5)
            java.lang.String r7 = toString(r7)
            java.lang.String r7 = io.flutter.view.FlutterMain.getLookupKeyForAsset(r7)
            com.huawei.hms.maps.model.BitmapDescriptor r7 = com.huawei.hms.maps.model.BitmapDescriptorFactory.fromAsset(r7)
            return r7
        L_0x0086:
            java.lang.Object r0 = r7.get(r5)
            java.lang.String r0 = toString(r0)
            java.lang.Object r7 = r7.get(r4)
            java.lang.String r7 = toString(r7)
            java.lang.String r7 = io.flutter.view.FlutterMain.getLookupKeyForAsset(r0, r7)
            com.huawei.hms.maps.model.BitmapDescriptor r7 = com.huawei.hms.maps.model.BitmapDescriptorFactory.fromAsset(r7)
            return r7
        L_0x009f:
            int r0 = r7.size()
            if (r0 != r3) goto L_0x00b6
            java.lang.Object r7 = r7.get(r5)
            java.lang.String r7 = toString(r7)
            java.lang.String r7 = io.flutter.view.FlutterMain.getLookupKeyForAsset(r7)
            com.huawei.hms.maps.model.BitmapDescriptor r7 = com.huawei.hms.maps.model.BitmapDescriptorFactory.fromAsset(r7)
            return r7
        L_0x00b6:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.flutter.map.utils.Convert.toBitmapDescriptor(java.lang.Object):com.huawei.hms.maps.model.BitmapDescriptor");
    }

    private static boolean toBoolean(Object obj) {
        return ((Boolean) obj).booleanValue();
    }

    public static CameraPosition toCameraPosition(Object obj) {
        Map<?, ?> map = toMap(obj);
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.bearing(toFloat(map.get(Param.BEARING)));
        builder.target(toLatLng(map.get("target")));
        builder.tilt(toFloat(map.get(Param.TILT)));
        builder.zoom(toFloat(map.get(Param.ZOOM)));
        return builder.build();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
        if (r1.equals(com.huawei.hms.flutter.map.constants.Param.NEW_LAT_LNG) == false) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.hms.maps.CameraUpdate toCameraUpdate(java.lang.Object r6, float r7) {
        /*
            java.util.List r6 = toList(r6)
            r0 = 0
            java.lang.Object r1 = r6.get(r0)
            java.lang.String r1 = toString(r1)
            r1.hashCode()
            int r2 = r1.hashCode()
            r3 = 2
            r4 = 1
            r5 = -1
            switch(r2) {
                case -813625658: goto L_0x0077;
                case -696286326: goto L_0x006c;
                case -696286120: goto L_0x0061;
                case -696285778: goto L_0x0056;
                case -402165756: goto L_0x004b;
                case -145042503: goto L_0x0040;
                case -110027141: goto L_0x0035;
                case 354871598: goto L_0x002a;
                case 1661158683: goto L_0x001d;
                default: goto L_0x001a;
            }
        L_0x001a:
            r0 = r5
            goto L_0x0080
        L_0x001d:
            java.lang.String r0 = "newLatLngBounds"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0026
            goto L_0x001a
        L_0x0026:
            r0 = 8
            goto L_0x0080
        L_0x002a:
            java.lang.String r0 = "newCameraPosition"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0033
            goto L_0x001a
        L_0x0033:
            r0 = 7
            goto L_0x0080
        L_0x0035:
            java.lang.String r0 = "zoomOut"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x003e
            goto L_0x001a
        L_0x003e:
            r0 = 6
            goto L_0x0080
        L_0x0040:
            java.lang.String r0 = "newLatLngZoom"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0049
            goto L_0x001a
        L_0x0049:
            r0 = 5
            goto L_0x0080
        L_0x004b:
            java.lang.String r0 = "scrollBy"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0054
            goto L_0x001a
        L_0x0054:
            r0 = 4
            goto L_0x0080
        L_0x0056:
            java.lang.String r0 = "zoomTo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x001a
        L_0x005f:
            r0 = 3
            goto L_0x0080
        L_0x0061:
            java.lang.String r0 = "zoomIn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x006a
            goto L_0x001a
        L_0x006a:
            r0 = r3
            goto L_0x0080
        L_0x006c:
            java.lang.String r0 = "zoomBy"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0075
            goto L_0x001a
        L_0x0075:
            r0 = r4
            goto L_0x0080
        L_0x0077:
            java.lang.String r2 = "newLatLng"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0080
            goto L_0x001a
        L_0x0080:
            switch(r0) {
                case 0: goto L_0x0116;
                case 1: goto L_0x00ee;
                case 2: goto L_0x00e9;
                case 3: goto L_0x00dc;
                case 4: goto L_0x00c7;
                case 5: goto L_0x00b2;
                case 6: goto L_0x00ad;
                case 7: goto L_0x00a0;
                case 8: goto L_0x008b;
                default: goto L_0x0083;
            }
        L_0x0083:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "ERROR"
            r6.<init>(r7)
            throw r6
        L_0x008b:
            java.lang.Object r0 = r6.get(r4)
            com.huawei.hms.maps.model.LatLngBounds r0 = toLatLngBounds(r0)
            java.lang.Object r6 = r6.get(r3)
            int r6 = toPixels(r6, r7)
            com.huawei.hms.maps.CameraUpdate r6 = com.huawei.hms.maps.CameraUpdateFactory.newLatLngBounds(r0, r6)
            return r6
        L_0x00a0:
            java.lang.Object r6 = r6.get(r4)
            com.huawei.hms.maps.model.CameraPosition r6 = toCameraPosition(r6)
            com.huawei.hms.maps.CameraUpdate r6 = com.huawei.hms.maps.CameraUpdateFactory.newCameraPosition(r6)
            return r6
        L_0x00ad:
            com.huawei.hms.maps.CameraUpdate r6 = com.huawei.hms.maps.CameraUpdateFactory.zoomOut()
            return r6
        L_0x00b2:
            java.lang.Object r7 = r6.get(r4)
            com.huawei.hms.maps.model.LatLng r7 = toLatLng(r7)
            java.lang.Object r6 = r6.get(r3)
            float r6 = toFloat(r6)
            com.huawei.hms.maps.CameraUpdate r6 = com.huawei.hms.maps.CameraUpdateFactory.newLatLngZoom(r7, r6)
            return r6
        L_0x00c7:
            java.lang.Object r0 = r6.get(r4)
            float r0 = toFinePixels(r0, r7)
            java.lang.Object r6 = r6.get(r3)
            float r6 = toFinePixels(r6, r7)
            com.huawei.hms.maps.CameraUpdate r6 = com.huawei.hms.maps.CameraUpdateFactory.scrollBy(r0, r6)
            return r6
        L_0x00dc:
            java.lang.Object r6 = r6.get(r4)
            float r6 = toFloat(r6)
            com.huawei.hms.maps.CameraUpdate r6 = com.huawei.hms.maps.CameraUpdateFactory.zoomTo(r6)
            return r6
        L_0x00e9:
            com.huawei.hms.maps.CameraUpdate r6 = com.huawei.hms.maps.CameraUpdateFactory.zoomIn()
            return r6
        L_0x00ee:
            int r0 = r6.size()
            if (r0 != r3) goto L_0x0101
            java.lang.Object r6 = r6.get(r4)
            float r6 = toFloat(r6)
            com.huawei.hms.maps.CameraUpdate r6 = com.huawei.hms.maps.CameraUpdateFactory.zoomBy(r6)
            return r6
        L_0x0101:
            java.lang.Object r0 = r6.get(r4)
            float r0 = toFloat(r0)
            java.lang.Object r6 = r6.get(r3)
            android.graphics.Point r6 = toPoint(r6, r7)
            com.huawei.hms.maps.CameraUpdate r6 = com.huawei.hms.maps.CameraUpdateFactory.zoomBy(r0, r6)
            return r6
        L_0x0116:
            java.lang.Object r6 = r6.get(r4)
            com.huawei.hms.maps.model.LatLng r6 = toLatLng(r6)
            com.huawei.hms.maps.CameraUpdate r6 = com.huawei.hms.maps.CameraUpdateFactory.newLatLng(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.flutter.map.utils.Convert.toCameraUpdate(java.lang.Object, float):com.huawei.hms.maps.CameraUpdate");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        if (r1.equals(com.huawei.hms.flutter.map.constants.Param.ROUND_CAP) == false) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.huawei.hms.maps.model.Cap toCap(java.lang.Object r6) {
        /*
            java.util.List r6 = toList(r6)
            r0 = 0
            java.lang.Object r1 = r6.get(r0)
            java.lang.String r1 = toString(r1)
            r1.hashCode()
            int r2 = r1.hashCode()
            r3 = 2
            r4 = 1
            r5 = -1
            switch(r2) {
                case -179356: goto L_0x003d;
                case 241309887: goto L_0x0032;
                case 1314340213: goto L_0x0027;
                case 1611528865: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            r0 = r5
            goto L_0x0046
        L_0x001c:
            java.lang.String r0 = "customCap"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0025
            goto L_0x001a
        L_0x0025:
            r0 = 3
            goto L_0x0046
        L_0x0027:
            java.lang.String r0 = "squareCap"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0030
            goto L_0x001a
        L_0x0030:
            r0 = r3
            goto L_0x0046
        L_0x0032:
            java.lang.String r0 = "buttCap"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x003b
            goto L_0x001a
        L_0x003b:
            r0 = r4
            goto L_0x0046
        L_0x003d:
            java.lang.String r2 = "roundCap"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0046
            goto L_0x001a
        L_0x0046:
            switch(r0) {
                case 0: goto L_0x0087;
                case 1: goto L_0x0081;
                case 2: goto L_0x007b;
                case 3: goto L_0x0051;
                default: goto L_0x0049;
            }
        L_0x0049:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "ERROR"
            r6.<init>(r0)
            throw r6
        L_0x0051:
            int r0 = r6.size()
            if (r0 != r3) goto L_0x0065
            com.huawei.hms.maps.model.CustomCap r0 = new com.huawei.hms.maps.model.CustomCap
            java.lang.Object r6 = r6.get(r4)
            com.huawei.hms.maps.model.BitmapDescriptor r6 = toBitmapDescriptor(r6)
            r0.<init>(r6)
            return r0
        L_0x0065:
            com.huawei.hms.maps.model.CustomCap r0 = new com.huawei.hms.maps.model.CustomCap
            java.lang.Object r1 = r6.get(r4)
            com.huawei.hms.maps.model.BitmapDescriptor r1 = toBitmapDescriptor(r1)
            java.lang.Object r6 = r6.get(r3)
            float r6 = toFloat(r6)
            r0.<init>(r1, r6)
            return r0
        L_0x007b:
            com.huawei.hms.maps.model.SquareCap r6 = new com.huawei.hms.maps.model.SquareCap
            r6.<init>()
            return r6
        L_0x0081:
            com.huawei.hms.maps.model.ButtCap r6 = new com.huawei.hms.maps.model.ButtCap
            r6.<init>()
            return r6
        L_0x0087:
            com.huawei.hms.maps.model.RoundCap r6 = new com.huawei.hms.maps.model.RoundCap
            r6.<init>()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.flutter.map.utils.Convert.toCap(java.lang.Object):com.huawei.hms.maps.model.Cap");
    }

    private static Map<Float, Integer> toColorMap(Object obj) {
        Map<?, ?> map = toMap(obj);
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(toFloatWrapper(next.getKey()), toIntegerWrapper(Long.valueOf(Long.parseLong((String) next.getValue()))));
        }
        return hashMap;
    }

    private static double toDouble(Object obj) {
        return ((Number) obj).doubleValue();
    }

    private static float toFinePixels(Object obj, float f11) {
        return toFloat(obj) * f11;
    }

    private static float toFloat(Object obj) {
        return ((Number) obj).floatValue();
    }

    private static Map<Float, Float> toFloatMap(Object obj) {
        Map<?, ?> map = toMap(obj);
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(toFloatWrapper(next.getKey()), toFloatWrapper(next.getValue()));
        }
        return hashMap;
    }

    private static Float toFloatWrapper(Object obj) {
        if (obj == null) {
            return null;
        }
        return Float.valueOf(toFloat(obj));
    }

    private static List<List<LatLng>> toHoles(Object obj) {
        List<?> list = toList(obj);
        ArrayList arrayList = new ArrayList(list.size());
        for (Object points : list) {
            arrayList.add(toPoints(points));
        }
        return arrayList;
    }

    private static int toInt(Object obj) {
        return ((Number) obj).intValue();
    }

    private static List<Integer> toIntegerList(Object obj) {
        List<?> list = toList(obj);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            arrayList.add(Integer.valueOf(toInt(obj2)));
        }
        return arrayList;
    }

    private static Integer toIntegerWrapper(Object obj) {
        if (obj == null) {
            return null;
        }
        return Integer.valueOf(toInt(obj));
    }

    public static Interpolator toInterpolator(int i11) {
        switch (i11) {
            case 1:
                return new AccelerateInterpolator();
            case 2:
                return new AnticipateInterpolator();
            case 3:
                return new BounceInterpolator();
            case 4:
                return new DecelerateInterpolator();
            case 5:
                return new OvershootInterpolator();
            case 6:
                return new AccelerateDecelerateInterpolator();
            case 7:
                return new FastOutLinearInInterpolator();
            case 8:
                return new FastOutSlowInInterpolator();
            case 9:
                return new LinearOutSlowInInterpolator();
            default:
                return new LinearInterpolator();
        }
    }

    public static LatLng toLatLng(Object obj) {
        List<?> list = toList(obj);
        return new LatLng(toDouble(list.get(0)), toDouble(list.get(1)));
    }

    private static LatLngBounds toLatLngBounds(Object obj) {
        if (obj == null) {
            return null;
        }
        List<?> list = toList(obj);
        return new LatLngBounds(toLatLng(list.get(0)), toLatLng(list.get(1)));
    }

    public static LatLng[] toLatLngList(Object obj) {
        List<?> list = toList(obj);
        LatLng[] latLngArr = new LatLng[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            latLngArr[i11] = toLatLng(list.get(i11));
        }
        return latLngArr;
    }

    public static List<LatLng> toLatLngStartEnd(Object obj) {
        List<?> list = toList(obj);
        List<?> list2 = toList(list.get(0));
        List<?> list3 = toList(list.get(1));
        return new ArrayList(Arrays.asList(new LatLng[]{new LatLng(toDouble(list2.get(0)), toDouble(list2.get(1))), new LatLng(toDouble(list3.get(0)), toDouble(list3.get(1)))}));
    }

    private static List<?> toList(Object obj) {
        return (List) obj;
    }

    private static Map<?, ?> toMap(Object obj) {
        return (Map) obj;
    }

    private static MyLocationStyle toMyLocationStyle(Object obj) {
        Map<?, ?> map = toMap(obj);
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        Object obj2 = map.get(Param.ANCHOR);
        if (obj2 != null) {
            List<?> list = toList(obj2);
            myLocationStyle.anchor(toFloat(list.get(0)), toFloat(list.get(1)));
        }
        Object obj3 = map.get(Param.RADIUS_FILL_COLOR);
        if (obj3 != null) {
            myLocationStyle.radiusFillColor(toInt(obj3));
        }
        Object obj4 = map.get("icon");
        if (obj4 != null) {
            myLocationStyle.myLocationIcon(toBitmapDescriptor(obj4));
        }
        return myLocationStyle;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        if (r3.equals("dot") == false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.huawei.hms.maps.model.PatternItem> toPattern(java.lang.Object r7) {
        /*
            java.util.List r7 = toList(r7)
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L_0x000c
            r7 = 0
            return r7
        L_0x000c:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.size()
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L_0x0019:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0093
            java.lang.Object r1 = r7.next()
            java.util.List r1 = toList(r1)
            r2 = 0
            java.lang.Object r3 = r1.get(r2)
            java.lang.String r3 = toString(r3)
            r3.hashCode()
            int r4 = r3.hashCode()
            r5 = 1
            r6 = -1
            switch(r4) {
                case 99657: goto L_0x0054;
                case 102102: goto L_0x0049;
                case 3075986: goto L_0x003e;
                default: goto L_0x003c;
            }
        L_0x003c:
            r2 = r6
            goto L_0x005d
        L_0x003e:
            java.lang.String r2 = "dash"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0047
            goto L_0x003c
        L_0x0047:
            r2 = 2
            goto L_0x005d
        L_0x0049:
            java.lang.String r2 = "gap"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0052
            goto L_0x003c
        L_0x0052:
            r2 = r5
            goto L_0x005d
        L_0x0054:
            java.lang.String r4 = "dot"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x005d
            goto L_0x003c
        L_0x005d:
            switch(r2) {
                case 0: goto L_0x008a;
                case 1: goto L_0x0079;
                case 2: goto L_0x0068;
                default: goto L_0x0060;
            }
        L_0x0060:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "ERROR"
            r7.<init>(r0)
            throw r7
        L_0x0068:
            com.huawei.hms.maps.model.Dash r2 = new com.huawei.hms.maps.model.Dash
            java.lang.Object r1 = r1.get(r5)
            float r1 = toFloat(r1)
            r2.<init>(r1)
            r0.add(r2)
            goto L_0x0019
        L_0x0079:
            com.huawei.hms.maps.model.Gap r2 = new com.huawei.hms.maps.model.Gap
            java.lang.Object r1 = r1.get(r5)
            float r1 = toFloat(r1)
            r2.<init>(r1)
            r0.add(r2)
            goto L_0x0019
        L_0x008a:
            com.huawei.hms.maps.model.Dot r1 = new com.huawei.hms.maps.model.Dot
            r1.<init>()
            r0.add(r1)
            goto L_0x0019
        L_0x0093:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.flutter.map.utils.Convert.toPattern(java.lang.Object):java.util.List");
    }

    private static int toPixels(Object obj, float f11) {
        return (int) toFinePixels(obj, f11);
    }

    public static Point toPoint(Object obj) {
        Map map = (Map) obj;
        return new Point(((Integer) map.get(Param.X)).intValue(), ((Integer) map.get(Param.Y)).intValue());
    }

    private static List<LatLng> toPoints(Object obj) {
        List<?> list = toList(obj);
        ArrayList arrayList = new ArrayList(list.size());
        for (Object list2 : list) {
            List<?> list3 = toList(list2);
            arrayList.add(new LatLng((double) toFloat(list3.get(0)), (double) toFloat(list3.get(1))));
        }
        return arrayList;
    }

    public static String toString(Object obj) {
        return (String) obj;
    }

    private static TileProvider toTileProvider(Object obj) throws JSONException {
        if (obj instanceof List) {
            JSONArray jSONArray = new JSONArray((Collection<?>) (ArrayList) obj);
            HashMap hashMap = new HashMap();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                hashMap.put(Arrays.asList(new Integer[]{Integer.valueOf(jSONObject.optInt(Param.X)), Integer.valueOf(jSONObject.optInt(Param.Y)), Integer.valueOf(jSONObject.optInt(Param.ZOOM))}), jSONObject.optString(Param.IMAGE_DATA));
            }
            return new a(hashMap);
        }
        final Map<?, ?> map = toMap(obj);
        if (map.containsKey("uri")) {
            return new UrlTileProvider(256, 256) {
                public URL getTileUrl(int i11, int i12, int i13) {
                    String str = (String) map.get("uri");
                    if (str != null) {
                        try {
                            return new URL(str.replace("{x}", String.valueOf(i11)).replace("{y}", String.valueOf(i12)).replace("{z}", String.valueOf(i13)));
                        } catch (MalformedURLException e11) {
                            Log.w("UrlTileProvider", e11.getMessage());
                        }
                    }
                    return null;
                }
            };
        }
        return new b((List) map.get(Param.ZOOM), (byte[]) map.get(Param.IMAGE_DATA));
    }

    private static Point toPoint(Object obj, float f11) {
        List<?> list = toList(obj);
        return new Point(toPixels(list.get(0), f11), toPixels(list.get(1), f11));
    }
}
