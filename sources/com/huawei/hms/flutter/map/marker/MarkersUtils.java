package com.huawei.hms.flutter.map.marker;

import android.app.Application;
import com.huawei.hms.flutter.map.constants.Method;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.flutter.map.logger.HMSLogger;
import com.huawei.hms.flutter.map.utils.Convert;
import com.huawei.hms.flutter.map.utils.ToJson;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.Marker;
import com.huawei.hms.maps.model.MarkerOptions;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkersUtils {
    private HuaweiMap huaweiMap;
    private final Map<String, String> ids = new HashMap();
    private final Map<String, MarkerController> idsOnMap = new HashMap();
    private final HMSLogger logger;
    private final MethodChannel mChannel;
    private BinaryMessenger messenger;

    public MarkersUtils(MethodChannel methodChannel, Application application) {
        this.mChannel = methodChannel;
        this.logger = HMSLogger.getInstance(application);
    }

    private static String getId(HashMap<String, Object> hashMap) {
        return (String) hashMap.get(Param.MARKER_ID);
    }

    private void insert(HashMap<String, Object> hashMap, BinaryMessenger binaryMessenger) {
        if (this.huaweiMap != null && hashMap != null) {
            MarkerBuilder markerBuilder = new MarkerBuilder();
            String processMarkerOptions = Convert.processMarkerOptions(hashMap, markerBuilder, binaryMessenger);
            MarkerOptions build = markerBuilder.build();
            this.logger.startMethodExecutionTimer("addMarker");
            Marker addMarker = this.huaweiMap.addMarker(build);
            this.logger.sendSingleEvent("addMarker");
            MarkerController markerController = new MarkerController(addMarker, markerBuilder.isClusterable());
            markerController.setAnimationSet(markerBuilder.getAnimationSet());
            this.idsOnMap.put(processMarkerOptions, markerController);
            this.ids.put(addMarker.getId(), processMarkerOptions);
        }
    }

    private static HashMap<String, Object> markerIdToJson(String str) {
        if (str == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Param.MARKER_ID, str);
        return hashMap;
    }

    private void update(HashMap<String, Object> hashMap) {
        MarkerController markerController;
        if (hashMap != null && (markerController = this.idsOnMap.get(getId(hashMap))) != null) {
            Convert.processMarkerOptions(hashMap, markerController, this.messenger);
        }
    }

    public void deleteMulti(List<String> list) {
        MarkerController remove;
        if (list != null) {
            for (String next : list) {
                if (!(next == null || (remove = this.idsOnMap.remove(next)) == null)) {
                    this.logger.startMethodExecutionTimer("removeMarker");
                    remove.delete();
                    this.logger.sendSingleEvent("removeMarker");
                    this.ids.remove(remove.getMapMarkerId());
                }
            }
        }
    }

    public void hideInfoWindow(String str, MethodChannel.Result result) {
        MarkerController markerController = this.idsOnMap.get(str);
        if (markerController != null) {
            markerController.hideInfoWindow();
            result.success((Object) null);
        }
    }

    public void insertMulti(List<HashMap<String, Object>> list, BinaryMessenger binaryMessenger) {
        this.messenger = binaryMessenger;
        if (list != null) {
            for (HashMap<String, Object> insert : list) {
                insert(insert, binaryMessenger);
            }
        }
    }

    public void isInfoWindowShown(String str, MethodChannel.Result result) {
        MarkerController markerController = this.idsOnMap.get(str);
        if (markerController != null) {
            result.success(Boolean.valueOf(markerController.isInfoWindowShown()));
        }
    }

    public void isMarkerClusterable(String str, MethodChannel.Result result) {
        MarkerController markerController = this.idsOnMap.get(str);
        if (markerController != null) {
            result.success(Boolean.valueOf(markerController.isClusterable()));
        }
    }

    public void onInfoWindowClick(String str) {
        String str2 = this.ids.get(str);
        if (str2 != null) {
            this.mChannel.invokeMethod(Method.INFO_WINDOW_CLICK, markerIdToJson(str2));
        }
    }

    public void onInfoWindowClose(String str) {
        String str2 = this.ids.get(str);
        if (str2 != null) {
            this.mChannel.invokeMethod(Method.INFO_WINDOW_CLOSE, markerIdToJson(str2));
        }
    }

    public void onInfoWindowLongClick(String str) {
        String str2 = this.ids.get(str);
        if (str2 != null) {
            this.mChannel.invokeMethod(Method.INFO_WINDOW_LONG_CLICK, markerIdToJson(str2));
        }
    }

    public boolean onMarkerClick(String str) {
        this.logger.startMethodExecutionTimer("onMarkerClick");
        String str2 = this.ids.get(str);
        if (str2 == null) {
            return false;
        }
        this.mChannel.invokeMethod(Method.MARKER_CLICK, markerIdToJson(str2));
        this.logger.sendSingleEvent("onMarkerClick");
        MarkerController markerController = this.idsOnMap.get(str2);
        if (markerController == null) {
            return false;
        }
        markerController.showInfoWindow();
        return markerController.isClickable();
    }

    public void onMarkerDrag(String str, LatLng latLng) {
        String str2 = this.ids.get(str);
        if (str2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Param.MARKER_ID, str2);
            hashMap.put("position", ToJson.latLng(latLng));
            this.mChannel.invokeMethod(Method.MARKER_ON_DRAG, hashMap);
        }
    }

    public void onMarkerDragEnd(String str, LatLng latLng) {
        String str2 = this.ids.get(str);
        if (str2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Param.MARKER_ID, str2);
            hashMap.put("position", ToJson.latLng(latLng));
            this.mChannel.invokeMethod(Method.MARKER_ON_DRAG_END, hashMap);
        }
    }

    public void onMarkerDragStart(String str, LatLng latLng) {
        String str2 = this.ids.get(str);
        if (str2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Param.MARKER_ID, str2);
            hashMap.put("position", ToJson.latLng(latLng));
            this.mChannel.invokeMethod(Method.MARKER_ON_DRAG_START, hashMap);
        }
    }

    public void setMap(HuaweiMap huaweiMap2) {
        this.huaweiMap = huaweiMap2;
    }

    public void showInfoWindow(String str, MethodChannel.Result result) {
        MarkerController markerController = this.idsOnMap.get(str);
        if (markerController != null) {
            markerController.showInfoWindow();
            result.success((Object) null);
        }
    }

    public void startAnimation(String str) {
        MarkerController markerController = this.idsOnMap.get(str);
        if (markerController != null) {
            markerController.startAnimation();
        }
    }

    public void updateMulti(List<HashMap<String, Object>> list) {
        if (list != null) {
            for (HashMap<String, Object> update : list) {
                update(update);
            }
        }
    }
}
