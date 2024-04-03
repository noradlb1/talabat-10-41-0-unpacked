package com.huawei.hms.flutter.map.polygon;

import android.app.Application;
import com.huawei.hms.flutter.map.constants.Method;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.flutter.map.logger.HMSLogger;
import com.huawei.hms.flutter.map.utils.Convert;
import com.huawei.hms.flutter.map.utils.ToJson;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.model.Polygon;
import com.huawei.hms.maps.model.PolygonOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolygonUtils {
    private final float compactness;
    private HuaweiMap huaweiMap;
    private final Map<String, String> ids = new HashMap();
    private final Map<String, PolygonController> idsOnMap = new HashMap();
    private final HMSLogger logger;
    private final MethodChannel mChannel;

    public PolygonUtils(MethodChannel methodChannel, float f11, Application application) {
        this.mChannel = methodChannel;
        this.compactness = f11;
        this.logger = HMSLogger.getInstance(application);
    }

    private static String getId(HashMap<String, Object> hashMap) {
        return (String) hashMap.get(Param.POLYGON_ID);
    }

    private void insert(HashMap<String, Object> hashMap) {
        if (this.huaweiMap != null && hashMap != null) {
            PolygonBuilder polygonBuilder = new PolygonBuilder(this.compactness);
            String processPolygonOptions = Convert.processPolygonOptions(hashMap, polygonBuilder);
            PolygonOptions build = polygonBuilder.build();
            this.logger.startMethodExecutionTimer("addPolygon");
            Polygon addPolygon = this.huaweiMap.addPolygon(build);
            this.logger.sendSingleEvent("addPolygon");
            this.idsOnMap.put(processPolygonOptions, new PolygonController(addPolygon, polygonBuilder.isClickable(), this.compactness));
            this.ids.put(addPolygon.getId(), processPolygonOptions);
        }
    }

    private void update(HashMap<String, Object> hashMap) {
        PolygonController polygonController;
        if (hashMap != null && (polygonController = this.idsOnMap.get(getId(hashMap))) != null) {
            Convert.processPolygonOptions(hashMap, polygonController);
        }
    }

    public void deleteMulti(List<String> list) {
        PolygonController remove;
        if (list != null) {
            for (String next : list) {
                if (!(next == null || (remove = this.idsOnMap.remove(next)) == null)) {
                    this.logger.startMethodExecutionTimer("removePolygon");
                    remove.delete();
                    this.logger.sendSingleEvent("removePolygon");
                    this.ids.remove(remove.getMapPolygonId());
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

    public boolean onPolygonClick(String str) {
        String str2 = this.ids.get(str);
        if (str2 == null) {
            return false;
        }
        this.mChannel.invokeMethod(Method.POLYGON_CLICK, ToJson.polygonId(str2));
        PolygonController polygonController = this.idsOnMap.get(str2);
        if (polygonController == null || !polygonController.isClickable()) {
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
