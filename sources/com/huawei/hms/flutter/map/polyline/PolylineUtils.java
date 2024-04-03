package com.huawei.hms.flutter.map.polyline;

import android.app.Application;
import com.huawei.hms.flutter.map.constants.Method;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.flutter.map.logger.HMSLogger;
import com.huawei.hms.flutter.map.utils.Convert;
import com.huawei.hms.flutter.map.utils.ToJson;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.model.Polyline;
import com.huawei.hms.maps.model.PolylineOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolylineUtils {
    private final float compactness;
    private HuaweiMap huaweiMap;
    private final Map<String, String> ids = new HashMap();
    private final Map<String, PolylineController> idsOnMap = new HashMap();
    private final HMSLogger logger;
    private final MethodChannel mChannel;

    public PolylineUtils(MethodChannel methodChannel, float f11, Application application) {
        this.mChannel = methodChannel;
        this.compactness = f11;
        this.logger = HMSLogger.getInstance(application);
    }

    private static String getId(HashMap<String, Object> hashMap) {
        return (String) hashMap.get(Param.POLYLINE_ID);
    }

    private void insert(HashMap<String, Object> hashMap) {
        if (this.huaweiMap != null && hashMap != null) {
            PolylineBuilder polylineBuilder = new PolylineBuilder(this.compactness);
            String processPolylineOptions = Convert.processPolylineOptions(hashMap, polylineBuilder);
            PolylineOptions build = polylineBuilder.build();
            this.logger.startMethodExecutionTimer("addPolyline");
            Polyline addPolyline = this.huaweiMap.addPolyline(build);
            this.logger.sendSingleEvent("addPolyline");
            this.idsOnMap.put(processPolylineOptions, new PolylineController(addPolyline, polylineBuilder.isClickable(), this.compactness));
            this.ids.put(addPolyline.getId(), processPolylineOptions);
        }
    }

    private void update(HashMap<String, Object> hashMap) {
        PolylineController polylineController;
        if (hashMap != null && (polylineController = this.idsOnMap.get(getId(hashMap))) != null) {
            Convert.processPolylineOptions(hashMap, polylineController);
        }
    }

    public void deleteMulti(List<String> list) {
        PolylineController remove;
        if (list != null) {
            for (String next : list) {
                if (!(next == null || (remove = this.idsOnMap.remove(next)) == null)) {
                    this.logger.startMethodExecutionTimer("removePolyline");
                    remove.delete();
                    this.logger.sendSingleEvent("removePolyline");
                    this.ids.remove(remove.getMapPolylineId());
                }
            }
        }
    }

    public void insertMulti(List<HashMap<String, Object>> list) {
        if (list != null) {
            for (HashMap<String, Object> insert : list) {
                insert(insert);
            }
        }
    }

    public boolean onPolylineClick(String str) {
        String str2 = this.ids.get(str);
        if (str2 == null) {
            return false;
        }
        this.mChannel.invokeMethod(Method.POLYLINE_CLICK, ToJson.polylineId(str2));
        PolylineController polylineController = this.idsOnMap.get(str2);
        if (polylineController == null || !polylineController.isClickable()) {
            return false;
        }
        return true;
    }

    public void setMap(HuaweiMap huaweiMap2) {
        this.huaweiMap = huaweiMap2;
    }

    public void updateMulti(List<HashMap<String, Object>> list) {
        if (list != null) {
            for (HashMap<String, Object> update : list) {
                update(update);
            }
        }
    }
}
