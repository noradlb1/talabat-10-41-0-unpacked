package io.flutter.plugins.googlemaps;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Tile;
import com.huawei.hms.flutter.map.constants.Param;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Instrumented
class Convert {
    public static Object a(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Param.BEARING, Float.valueOf(cameraPosition.bearing));
        hashMap.put("target", j(cameraPosition.target));
        hashMap.put(Param.TILT, Float.valueOf(cameraPosition.tilt));
        hashMap.put(Param.ZOOM, Float.valueOf(cameraPosition.zoom));
        return hashMap;
    }

    public static Object b(String str) {
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(Param.CIRCLE_ID, str);
        return hashMap;
    }

    public static String c(Object obj, CircleOptionsSink circleOptionsSink) {
        Map<?, ?> map = toMap(obj);
        Object obj2 = map.get("consumeTapEvents");
        if (obj2 != null) {
            circleOptionsSink.setConsumeTapEvents(toBoolean(obj2));
        }
        Object obj3 = map.get(Param.FILL_COLOR);
        if (obj3 != null) {
            circleOptionsSink.setFillColor(toInt(obj3));
        }
        Object obj4 = map.get(Param.STROKE_COLOR);
        if (obj4 != null) {
            circleOptionsSink.setStrokeColor(toInt(obj4));
        }
        Object obj5 = map.get(Param.VISIBLE);
        if (obj5 != null) {
            circleOptionsSink.setVisible(toBoolean(obj5));
        }
        Object obj6 = map.get(Param.STROKE_WIDTH);
        if (obj6 != null) {
            circleOptionsSink.setStrokeWidth((float) toInt(obj6));
        }
        Object obj7 = map.get(Param.Z_INDEX);
        if (obj7 != null) {
            circleOptionsSink.setZIndex(toFloat(obj7));
        }
        Object obj8 = map.get("center");
        if (obj8 != null) {
            circleOptionsSink.setCenter(s(obj8));
        }
        Object obj9 = map.get(Param.RADIUS);
        if (obj9 != null) {
            circleOptionsSink.setRadius(toDouble(obj9));
        }
        String str = (String) map.get(Param.CIRCLE_ID);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("circleId was null");
    }

    public static void d(Object obj, GoogleMapOptionsSink googleMapOptionsSink) {
        Map<?, ?> map = toMap(obj);
        Object obj2 = map.get(Param.CAMERA_TARGET_BOUNDS);
        if (obj2 != null) {
            googleMapOptionsSink.setCameraTargetBounds(toLatLngBounds(toList(obj2).get(0)));
        }
        Object obj3 = map.get(Param.COMPASS_ENABLED);
        if (obj3 != null) {
            googleMapOptionsSink.setCompassEnabled(toBoolean(obj3));
        }
        Object obj4 = map.get(Param.MAP_TOOLBAR_ENABLED);
        if (obj4 != null) {
            googleMapOptionsSink.setMapToolbarEnabled(toBoolean(obj4));
        }
        Object obj5 = map.get(Param.MAP_TYPE);
        if (obj5 != null) {
            googleMapOptionsSink.setMapType(toInt(obj5));
        }
        Object obj6 = map.get(Param.MIN_MAX_ZOOM_PREFERENCE);
        if (obj6 != null) {
            List<?> list = toList(obj6);
            googleMapOptionsSink.setMinMaxZoomPreference(toFloatWrapper(list.get(0)), toFloatWrapper(list.get(1)));
        }
        Object obj7 = map.get(Param.PADDING);
        if (obj7 != null) {
            List<?> list2 = toList(obj7);
            googleMapOptionsSink.setPadding(toFloat(list2.get(0)), toFloat(list2.get(1)), toFloat(list2.get(2)), toFloat(list2.get(3)));
        }
        Object obj8 = map.get(Param.ROTATE_GESTURES_ENABLED);
        if (obj8 != null) {
            googleMapOptionsSink.setRotateGesturesEnabled(toBoolean(obj8));
        }
        Object obj9 = map.get(Param.SCROLL_GESTURES_ENABLED);
        if (obj9 != null) {
            googleMapOptionsSink.setScrollGesturesEnabled(toBoolean(obj9));
        }
        Object obj10 = map.get(Param.TILT_GESTURES_ENABLED);
        if (obj10 != null) {
            googleMapOptionsSink.setTiltGesturesEnabled(toBoolean(obj10));
        }
        Object obj11 = map.get(Param.TRACK_CAMERA_POSITION);
        if (obj11 != null) {
            googleMapOptionsSink.setTrackCameraPosition(toBoolean(obj11));
        }
        Object obj12 = map.get(Param.ZOOM_GESTURES_ENABLED);
        if (obj12 != null) {
            googleMapOptionsSink.setZoomGesturesEnabled(toBoolean(obj12));
        }
        Object obj13 = map.get("liteModeEnabled");
        if (obj13 != null) {
            googleMapOptionsSink.setLiteModeEnabled(toBoolean(obj13));
        }
        Object obj14 = map.get(Param.MY_LOCATION_ENABLED);
        if (obj14 != null) {
            googleMapOptionsSink.setMyLocationEnabled(toBoolean(obj14));
        }
        Object obj15 = map.get(Param.ZOOM_CONTROLS_ENABLED);
        if (obj15 != null) {
            googleMapOptionsSink.setZoomControlsEnabled(toBoolean(obj15));
        }
        Object obj16 = map.get(Param.MY_LOCATION_BUTTON_ENABLED);
        if (obj16 != null) {
            googleMapOptionsSink.setMyLocationButtonEnabled(toBoolean(obj16));
        }
        Object obj17 = map.get("indoorEnabled");
        if (obj17 != null) {
            googleMapOptionsSink.setIndoorEnabled(toBoolean(obj17));
        }
        Object obj18 = map.get(Param.TRAFFIC_ENABLED);
        if (obj18 != null) {
            googleMapOptionsSink.setTrafficEnabled(toBoolean(obj18));
        }
        Object obj19 = map.get(Param.BUILDINGS_ENABLED);
        if (obj19 != null) {
            googleMapOptionsSink.setBuildingsEnabled(toBoolean(obj19));
        }
    }

    public static String e(Object obj, MarkerOptionsSink markerOptionsSink) {
        Map<?, ?> map = toMap(obj);
        Object obj2 = map.get("alpha");
        if (obj2 != null) {
            markerOptionsSink.setAlpha(toFloat(obj2));
        }
        Object obj3 = map.get(Param.ANCHOR);
        if (obj3 != null) {
            List<?> list = toList(obj3);
            markerOptionsSink.setAnchor(toFloat(list.get(0)), toFloat(list.get(1)));
        }
        Object obj4 = map.get("consumeTapEvents");
        if (obj4 != null) {
            markerOptionsSink.setConsumeTapEvents(toBoolean(obj4));
        }
        Object obj5 = map.get(Param.DRAGGABLE);
        if (obj5 != null) {
            markerOptionsSink.setDraggable(toBoolean(obj5));
        }
        Object obj6 = map.get(Param.FLAT);
        if (obj6 != null) {
            markerOptionsSink.setFlat(toBoolean(obj6));
        }
        Object obj7 = map.get("icon");
        if (obj7 != null) {
            markerOptionsSink.setIcon(toBitmapDescriptor(obj7));
        }
        Object obj8 = map.get(Param.INFO_WINDOW);
        if (obj8 != null) {
            interpretInfoWindowOptions(markerOptionsSink, toObjectMap(obj8));
        }
        Object obj9 = map.get("position");
        if (obj9 != null) {
            markerOptionsSink.setPosition(s(obj9));
        }
        Object obj10 = map.get("rotation");
        if (obj10 != null) {
            markerOptionsSink.setRotation(toFloat(obj10));
        }
        Object obj11 = map.get(Param.VISIBLE);
        if (obj11 != null) {
            markerOptionsSink.setVisible(toBoolean(obj11));
        }
        Object obj12 = map.get(Param.Z_INDEX);
        if (obj12 != null) {
            markerOptionsSink.setZIndex(toFloat(obj12));
        }
        String str = (String) map.get(Param.MARKER_ID);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("markerId was null");
    }

    public static String f(Object obj, PolygonOptionsSink polygonOptionsSink) {
        Map<?, ?> map = toMap(obj);
        Object obj2 = map.get("consumeTapEvents");
        if (obj2 != null) {
            polygonOptionsSink.setConsumeTapEvents(toBoolean(obj2));
        }
        Object obj3 = map.get(Param.GEODESIC);
        if (obj3 != null) {
            polygonOptionsSink.setGeodesic(toBoolean(obj3));
        }
        Object obj4 = map.get(Param.VISIBLE);
        if (obj4 != null) {
            polygonOptionsSink.setVisible(toBoolean(obj4));
        }
        Object obj5 = map.get(Param.FILL_COLOR);
        if (obj5 != null) {
            polygonOptionsSink.setFillColor(toInt(obj5));
        }
        Object obj6 = map.get(Param.STROKE_COLOR);
        if (obj6 != null) {
            polygonOptionsSink.setStrokeColor(toInt(obj6));
        }
        Object obj7 = map.get(Param.STROKE_WIDTH);
        if (obj7 != null) {
            polygonOptionsSink.setStrokeWidth((float) toInt(obj7));
        }
        Object obj8 = map.get(Param.Z_INDEX);
        if (obj8 != null) {
            polygonOptionsSink.setZIndex(toFloat(obj8));
        }
        Object obj9 = map.get(Param.POINTS);
        if (obj9 != null) {
            polygonOptionsSink.setPoints(toPoints(obj9));
        }
        Object obj10 = map.get(Param.HOLES);
        if (obj10 != null) {
            polygonOptionsSink.setHoles(toHoles(obj10));
        }
        String str = (String) map.get(Param.POLYGON_ID);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("polygonId was null");
    }

    public static String g(Object obj, PolylineOptionsSink polylineOptionsSink) {
        Map<?, ?> map = toMap(obj);
        Object obj2 = map.get("consumeTapEvents");
        if (obj2 != null) {
            polylineOptionsSink.setConsumeTapEvents(toBoolean(obj2));
        }
        Object obj3 = map.get("color");
        if (obj3 != null) {
            polylineOptionsSink.setColor(toInt(obj3));
        }
        Object obj4 = map.get(Param.END_CAP);
        if (obj4 != null) {
            polylineOptionsSink.setEndCap(toCap(obj4));
        }
        Object obj5 = map.get(Param.GEODESIC);
        if (obj5 != null) {
            polylineOptionsSink.setGeodesic(toBoolean(obj5));
        }
        Object obj6 = map.get(Param.JOINT_TYPE);
        if (obj6 != null) {
            polylineOptionsSink.setJointType(toInt(obj6));
        }
        Object obj7 = map.get(Param.START_CAP);
        if (obj7 != null) {
            polylineOptionsSink.setStartCap(toCap(obj7));
        }
        Object obj8 = map.get(Param.VISIBLE);
        if (obj8 != null) {
            polylineOptionsSink.setVisible(toBoolean(obj8));
        }
        Object obj9 = map.get("width");
        if (obj9 != null) {
            polylineOptionsSink.setWidth((float) toInt(obj9));
        }
        Object obj10 = map.get(Param.Z_INDEX);
        if (obj10 != null) {
            polylineOptionsSink.setZIndex(toFloat(obj10));
        }
        Object obj11 = map.get(Param.POINTS);
        if (obj11 != null) {
            polylineOptionsSink.setPoints(toPoints(obj11));
        }
        Object obj12 = map.get(Param.PATTERN);
        if (obj12 != null) {
            polylineOptionsSink.setPattern(toPattern(obj12));
        }
        String str = (String) map.get(Param.POLYLINE_ID);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("polylineId was null");
    }

    private static BitmapDescriptor getBitmapFromBytes(List<?> list) {
        if (list.size() == 2) {
            try {
                return BitmapDescriptorFactory.fromBitmap(toBitmap(list.get(1)));
            } catch (Exception e11) {
                throw new IllegalArgumentException("Unable to interpret bytes as a valid image.", e11);
            }
        } else {
            throw new IllegalArgumentException("fromBytes should have exactly one argument, interpretTileOverlayOptions the bytes. Got: " + list.size());
        }
    }

    public static Tile h(Map<String, ?> map) {
        byte[] bArr;
        int i11 = toInt(map.get("width"));
        int i12 = toInt(map.get("height"));
        if (map.get("data") != null) {
            bArr = (byte[]) map.get("data");
        } else {
            bArr = null;
        }
        return new Tile(i11, i12, bArr);
    }

    public static String i(Map<String, ?> map, TileOverlaySink tileOverlaySink) {
        Object obj = map.get(Param.FADE_IN);
        if (obj != null) {
            tileOverlaySink.setFadeIn(toBoolean(obj));
        }
        Object obj2 = map.get(Param.TRANSPARENCY);
        if (obj2 != null) {
            tileOverlaySink.setTransparency(toFloat(obj2));
        }
        Object obj3 = map.get(Param.Z_INDEX);
        if (obj3 != null) {
            tileOverlaySink.setZIndex(toFloat(obj3));
        }
        Object obj4 = map.get(Param.VISIBLE);
        if (obj4 != null) {
            tileOverlaySink.setVisible(toBoolean(obj4));
        }
        String str = (String) map.get(Param.TILE_OVERLAY_ID);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("tileOverlayId was null");
    }

    private static void interpretInfoWindowOptions(MarkerOptionsSink markerOptionsSink, Map<String, Object> map) {
        String str = (String) map.get("title");
        String str2 = (String) map.get(Param.SNIPPET);
        if (str != null) {
            markerOptionsSink.setInfoWindowText(str, str2);
        }
        Object obj = map.get(Param.ANCHOR);
        if (obj != null) {
            List<?> list = toList(obj);
            markerOptionsSink.setInfoWindowAnchor(toFloat(list.get(0)), toFloat(list.get(1)));
        }
    }

    public static Object j(LatLng latLng) {
        return Arrays.asList(new Double[]{Double.valueOf(latLng.latitude), Double.valueOf(latLng.longitude)});
    }

    public static Object k(LatLngBounds latLngBounds) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(Param.SOUTHWEST, j(latLngBounds.southwest));
        hashMap.put(Param.NORTHEAST, j(latLngBounds.northeast));
        return hashMap;
    }

    public static Object l(String str) {
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(Param.MARKER_ID, str);
        return hashMap;
    }

    public static Map<String, Integer> m(Point point) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(Param.X, Integer.valueOf(point.x));
        hashMap.put(Param.Y, Integer.valueOf(point.y));
        return hashMap;
    }

    public static Object n(String str) {
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(Param.POLYGON_ID, str);
        return hashMap;
    }

    public static Object o(String str) {
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(Param.POLYLINE_ID, str);
        return hashMap;
    }

    public static Map<String, Object> p(String str, int i11, int i12, int i13) {
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put(Param.TILE_OVERLAY_ID, str);
        hashMap.put(Param.X, Integer.valueOf(i11));
        hashMap.put(Param.Y, Integer.valueOf(i12));
        hashMap.put(Param.ZOOM, Integer.valueOf(i13));
        return hashMap;
    }

    public static CameraPosition q(Object obj) {
        Map<?, ?> map = toMap(obj);
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.bearing(toFloat(map.get(Param.BEARING)));
        builder.target(s(map.get("target")));
        builder.tilt(toFloat(map.get(Param.TILT)));
        builder.zoom(toFloat(map.get(Param.ZOOM)));
        return builder.build();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
        if (r2.equals(com.huawei.hms.flutter.map.constants.Param.NEW_LAT_LNG) == false) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.maps.CameraUpdate r(java.lang.Object r7, float r8) {
        /*
            java.util.List r0 = toList(r7)
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            java.lang.String r2 = toString(r2)
            r2.hashCode()
            int r3 = r2.hashCode()
            r4 = 2
            r5 = 1
            r6 = -1
            switch(r3) {
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
            r1 = r6
            goto L_0x0080
        L_0x001d:
            java.lang.String r1 = "newLatLngBounds"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0026
            goto L_0x001a
        L_0x0026:
            r1 = 8
            goto L_0x0080
        L_0x002a:
            java.lang.String r1 = "newCameraPosition"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0033
            goto L_0x001a
        L_0x0033:
            r1 = 7
            goto L_0x0080
        L_0x0035:
            java.lang.String r1 = "zoomOut"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x003e
            goto L_0x001a
        L_0x003e:
            r1 = 6
            goto L_0x0080
        L_0x0040:
            java.lang.String r1 = "newLatLngZoom"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0049
            goto L_0x001a
        L_0x0049:
            r1 = 5
            goto L_0x0080
        L_0x004b:
            java.lang.String r1 = "scrollBy"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0054
            goto L_0x001a
        L_0x0054:
            r1 = 4
            goto L_0x0080
        L_0x0056:
            java.lang.String r1 = "zoomTo"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x005f
            goto L_0x001a
        L_0x005f:
            r1 = 3
            goto L_0x0080
        L_0x0061:
            java.lang.String r1 = "zoomIn"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x006a
            goto L_0x001a
        L_0x006a:
            r1 = r4
            goto L_0x0080
        L_0x006c:
            java.lang.String r1 = "zoomBy"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0075
            goto L_0x001a
        L_0x0075:
            r1 = r5
            goto L_0x0080
        L_0x0077:
            java.lang.String r3 = "newLatLng"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0080
            goto L_0x001a
        L_0x0080:
            switch(r1) {
                case 0: goto L_0x012a;
                case 1: goto L_0x0102;
                case 2: goto L_0x00fd;
                case 3: goto L_0x00f0;
                case 4: goto L_0x00db;
                case 5: goto L_0x00c6;
                case 6: goto L_0x00c1;
                case 7: goto L_0x00b4;
                case 8: goto L_0x009f;
                default: goto L_0x0083;
            }
        L_0x0083:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot interpret "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = " as CameraUpdate"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.<init>(r7)
            throw r8
        L_0x009f:
            java.lang.Object r7 = r0.get(r5)
            com.google.android.gms.maps.model.LatLngBounds r7 = toLatLngBounds(r7)
            java.lang.Object r0 = r0.get(r4)
            int r8 = toPixels(r0, r8)
            com.google.android.gms.maps.CameraUpdate r7 = com.google.android.gms.maps.CameraUpdateFactory.newLatLngBounds(r7, r8)
            return r7
        L_0x00b4:
            java.lang.Object r7 = r0.get(r5)
            com.google.android.gms.maps.model.CameraPosition r7 = q(r7)
            com.google.android.gms.maps.CameraUpdate r7 = com.google.android.gms.maps.CameraUpdateFactory.newCameraPosition(r7)
            return r7
        L_0x00c1:
            com.google.android.gms.maps.CameraUpdate r7 = com.google.android.gms.maps.CameraUpdateFactory.zoomOut()
            return r7
        L_0x00c6:
            java.lang.Object r7 = r0.get(r5)
            com.google.android.gms.maps.model.LatLng r7 = s(r7)
            java.lang.Object r8 = r0.get(r4)
            float r8 = toFloat(r8)
            com.google.android.gms.maps.CameraUpdate r7 = com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(r7, r8)
            return r7
        L_0x00db:
            java.lang.Object r7 = r0.get(r5)
            float r7 = toFractionalPixels(r7, r8)
            java.lang.Object r0 = r0.get(r4)
            float r8 = toFractionalPixels(r0, r8)
            com.google.android.gms.maps.CameraUpdate r7 = com.google.android.gms.maps.CameraUpdateFactory.scrollBy(r7, r8)
            return r7
        L_0x00f0:
            java.lang.Object r7 = r0.get(r5)
            float r7 = toFloat(r7)
            com.google.android.gms.maps.CameraUpdate r7 = com.google.android.gms.maps.CameraUpdateFactory.zoomTo(r7)
            return r7
        L_0x00fd:
            com.google.android.gms.maps.CameraUpdate r7 = com.google.android.gms.maps.CameraUpdateFactory.zoomIn()
            return r7
        L_0x0102:
            int r7 = r0.size()
            if (r7 != r4) goto L_0x0115
            java.lang.Object r7 = r0.get(r5)
            float r7 = toFloat(r7)
            com.google.android.gms.maps.CameraUpdate r7 = com.google.android.gms.maps.CameraUpdateFactory.zoomBy(r7)
            return r7
        L_0x0115:
            java.lang.Object r7 = r0.get(r5)
            float r7 = toFloat(r7)
            java.lang.Object r0 = r0.get(r4)
            android.graphics.Point r8 = toPoint(r0, r8)
            com.google.android.gms.maps.CameraUpdate r7 = com.google.android.gms.maps.CameraUpdateFactory.zoomBy(r7, r8)
            return r7
        L_0x012a:
            java.lang.Object r7 = r0.get(r5)
            com.google.android.gms.maps.model.LatLng r7 = s(r7)
            com.google.android.gms.maps.CameraUpdate r7 = com.google.android.gms.maps.CameraUpdateFactory.newLatLng(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.Convert.r(java.lang.Object, float):com.google.android.gms.maps.CameraUpdate");
    }

    public static LatLng s(Object obj) {
        List<?> list = toList(obj);
        return new LatLng(toDouble(list.get(0)), toDouble(list.get(1)));
    }

    public static Point t(Object obj) {
        return new Point(((Integer) toMap(obj).get(Param.X)).intValue(), ((Integer) toMap(obj).get(Param.Y)).intValue());
    }

    private static Bitmap toBitmap(Object obj) {
        byte[] bArr = (byte[]) obj;
        Bitmap decodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(bArr, 0, bArr.length);
        if (decodeByteArray != null) {
            return decodeByteArray;
        }
        throw new IllegalArgumentException("Unable to decode bytes as a valid bitmap.");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (r2.equals(com.huawei.hms.flutter.map.constants.Param.FROM_ASSET_IMAGE) == false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.maps.model.BitmapDescriptor toBitmapDescriptor(java.lang.Object r8) {
        /*
            java.util.List r0 = toList(r8)
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            java.lang.String r2 = toString(r2)
            r2.hashCode()
            int r3 = r2.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = -1
            switch(r3) {
                case -458749035: goto L_0x003e;
                case 52960614: goto L_0x0033;
                case 54063841: goto L_0x0028;
                case 784458203: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            r1 = r7
            goto L_0x0047
        L_0x001d:
            java.lang.String r1 = "defaultMarker"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0026
            goto L_0x001b
        L_0x0026:
            r1 = r4
            goto L_0x0047
        L_0x0028:
            java.lang.String r1 = "fromBytes"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0031
            goto L_0x001b
        L_0x0031:
            r1 = r5
            goto L_0x0047
        L_0x0033:
            java.lang.String r1 = "fromAsset"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x003c
            goto L_0x001b
        L_0x003c:
            r1 = r6
            goto L_0x0047
        L_0x003e:
            java.lang.String r3 = "fromAssetImage"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0047
            goto L_0x001b
        L_0x0047:
            switch(r1) {
                case 0: goto L_0x00b3;
                case 1: goto L_0x0083;
                case 2: goto L_0x007e;
                case 3: goto L_0x0066;
                default: goto L_0x004a;
            }
        L_0x004a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = " as BitmapDescriptor"
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L_0x0066:
            int r8 = r0.size()
            if (r8 != r6) goto L_0x0071
            com.google.android.gms.maps.model.BitmapDescriptor r8 = com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker()
            return r8
        L_0x0071:
            java.lang.Object r8 = r0.get(r6)
            float r8 = toFloat(r8)
            com.google.android.gms.maps.model.BitmapDescriptor r8 = com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker(r8)
            return r8
        L_0x007e:
            com.google.android.gms.maps.model.BitmapDescriptor r8 = getBitmapFromBytes(r0)
            return r8
        L_0x0083:
            int r8 = r0.size()
            if (r8 != r5) goto L_0x009a
            java.lang.Object r8 = r0.get(r6)
            java.lang.String r8 = toString(r8)
            java.lang.String r8 = io.flutter.view.FlutterMain.getLookupKeyForAsset(r8)
            com.google.android.gms.maps.model.BitmapDescriptor r8 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(r8)
            return r8
        L_0x009a:
            java.lang.Object r8 = r0.get(r6)
            java.lang.String r8 = toString(r8)
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = toString(r0)
            java.lang.String r8 = io.flutter.view.FlutterMain.getLookupKeyForAsset(r8, r0)
            com.google.android.gms.maps.model.BitmapDescriptor r8 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(r8)
            return r8
        L_0x00b3:
            int r8 = r0.size()
            if (r8 != r4) goto L_0x00ca
            java.lang.Object r8 = r0.get(r6)
            java.lang.String r8 = toString(r8)
            java.lang.String r8 = io.flutter.view.FlutterMain.getLookupKeyForAsset(r8)
            com.google.android.gms.maps.model.BitmapDescriptor r8 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(r8)
            return r8
        L_0x00ca:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "'fromAssetImage' Expected exactly 3 arguments, got: "
            r1.append(r2)
            int r0 = r0.size()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.Convert.toBitmapDescriptor(java.lang.Object):com.google.android.gms.maps.model.BitmapDescriptor");
    }

    private static boolean toBoolean(Object obj) {
        return ((Boolean) obj).booleanValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        if (r2.equals(com.huawei.hms.flutter.map.constants.Param.ROUND_CAP) == false) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.maps.model.Cap toCap(java.lang.Object r7) {
        /*
            java.util.List r0 = toList(r7)
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            java.lang.String r2 = toString(r2)
            r2.hashCode()
            int r3 = r2.hashCode()
            r4 = 2
            r5 = 1
            r6 = -1
            switch(r3) {
                case -179356: goto L_0x003d;
                case 241309887: goto L_0x0032;
                case 1314340213: goto L_0x0027;
                case 1611528865: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            r1 = r6
            goto L_0x0046
        L_0x001c:
            java.lang.String r1 = "customCap"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0025
            goto L_0x001a
        L_0x0025:
            r1 = 3
            goto L_0x0046
        L_0x0027:
            java.lang.String r1 = "squareCap"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0030
            goto L_0x001a
        L_0x0030:
            r1 = r4
            goto L_0x0046
        L_0x0032:
            java.lang.String r1 = "buttCap"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x003b
            goto L_0x001a
        L_0x003b:
            r1 = r5
            goto L_0x0046
        L_0x003d:
            java.lang.String r3 = "roundCap"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0046
            goto L_0x001a
        L_0x0046:
            switch(r1) {
                case 0: goto L_0x009b;
                case 1: goto L_0x0095;
                case 2: goto L_0x008f;
                case 3: goto L_0x0065;
                default: goto L_0x0049;
            }
        L_0x0049:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = " as Cap"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x0065:
            int r7 = r0.size()
            if (r7 != r4) goto L_0x0079
            com.google.android.gms.maps.model.CustomCap r7 = new com.google.android.gms.maps.model.CustomCap
            java.lang.Object r0 = r0.get(r5)
            com.google.android.gms.maps.model.BitmapDescriptor r0 = toBitmapDescriptor(r0)
            r7.<init>(r0)
            return r7
        L_0x0079:
            com.google.android.gms.maps.model.CustomCap r7 = new com.google.android.gms.maps.model.CustomCap
            java.lang.Object r1 = r0.get(r5)
            com.google.android.gms.maps.model.BitmapDescriptor r1 = toBitmapDescriptor(r1)
            java.lang.Object r0 = r0.get(r4)
            float r0 = toFloat(r0)
            r7.<init>(r1, r0)
            return r7
        L_0x008f:
            com.google.android.gms.maps.model.SquareCap r7 = new com.google.android.gms.maps.model.SquareCap
            r7.<init>()
            return r7
        L_0x0095:
            com.google.android.gms.maps.model.ButtCap r7 = new com.google.android.gms.maps.model.ButtCap
            r7.<init>()
            return r7
        L_0x009b:
            com.google.android.gms.maps.model.RoundCap r7 = new com.google.android.gms.maps.model.RoundCap
            r7.<init>()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.Convert.toCap(java.lang.Object):com.google.android.gms.maps.model.Cap");
    }

    private static double toDouble(Object obj) {
        return ((Number) obj).doubleValue();
    }

    private static float toFloat(Object obj) {
        return ((Number) obj).floatValue();
    }

    private static Float toFloatWrapper(Object obj) {
        if (obj == null) {
            return null;
        }
        return Float.valueOf(toFloat(obj));
    }

    private static float toFractionalPixels(Object obj, float f11) {
        return toFloat(obj) * f11;
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

    private static LatLngBounds toLatLngBounds(Object obj) {
        if (obj == null) {
            return null;
        }
        List<?> list = toList(obj);
        return new LatLngBounds(s(list.get(0)), s(list.get(1)));
    }

    private static List<?> toList(Object obj) {
        return (List) obj;
    }

    private static Map<?, ?> toMap(Object obj) {
        return (Map) obj;
    }

    private static Map<String, Object> toObjectMap(Object obj) {
        HashMap hashMap = new HashMap();
        Map map = (Map) obj;
        for (Object next : map.keySet()) {
            Object obj2 = map.get(next);
            if (obj2 != null) {
                hashMap.put((String) next, obj2);
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        if (r3.equals("dot") == false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.google.android.gms.maps.model.PatternItem> toPattern(java.lang.Object r7) {
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
            if (r1 == 0) goto L_0x00a9
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
                case 0: goto L_0x009f;
                case 1: goto L_0x008d;
                case 2: goto L_0x007c;
                default: goto L_0x0060;
            }
        L_0x0060:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " as PatternItem"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r7.<init>(r0)
            throw r7
        L_0x007c:
            com.google.android.gms.maps.model.Dash r2 = new com.google.android.gms.maps.model.Dash
            java.lang.Object r1 = r1.get(r5)
            float r1 = toFloat(r1)
            r2.<init>(r1)
            r0.add(r2)
            goto L_0x0019
        L_0x008d:
            com.google.android.gms.maps.model.Gap r2 = new com.google.android.gms.maps.model.Gap
            java.lang.Object r1 = r1.get(r5)
            float r1 = toFloat(r1)
            r2.<init>(r1)
            r0.add(r2)
            goto L_0x0019
        L_0x009f:
            com.google.android.gms.maps.model.Dot r1 = new com.google.android.gms.maps.model.Dot
            r1.<init>()
            r0.add(r1)
            goto L_0x0019
        L_0x00a9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.Convert.toPattern(java.lang.Object):java.util.List");
    }

    private static int toPixels(Object obj, float f11) {
        return (int) toFractionalPixels(obj, f11);
    }

    private static Point toPoint(Object obj, float f11) {
        List<?> list = toList(obj);
        return new Point(toPixels(list.get(0), f11), toPixels(list.get(1), f11));
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

    private static String toString(Object obj) {
        return (String) obj;
    }
}
