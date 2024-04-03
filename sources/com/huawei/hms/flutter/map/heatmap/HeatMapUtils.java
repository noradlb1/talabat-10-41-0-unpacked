package com.huawei.hms.flutter.map.heatmap;

import android.app.Application;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.flutter.map.logger.HMSLogger;
import com.huawei.hms.flutter.map.utils.Convert;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.model.HeatMap;
import com.huawei.hms.maps.model.HeatMapOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeatMapUtils {
    private final Application application;
    private HuaweiMap huaweiMap;
    private final Map<String, String> ids = new HashMap();
    private final Map<String, HeatMapController> idsOnMap = new HashMap();
    private final HMSLogger logger;
    private final MethodChannel mChannel;

    public HeatMapUtils(MethodChannel methodChannel, Application application2) {
        this.mChannel = methodChannel;
        this.logger = HMSLogger.getInstance(application2);
        this.application = application2;
    }

    private static String getId(HashMap<String, Object> hashMap) {
        return (String) hashMap.get(Param.HEAT_MAP_ID);
    }

    private static HashMap<String, Object> heatMapIdToJson(String str) {
        if (str == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Param.HEAT_MAP_ID, str);
        return hashMap;
    }

    private void insert(HashMap<String, Object> hashMap) {
        if (this.huaweiMap != null && hashMap != null) {
            HeatMapBuilder heatMapBuilder = new HeatMapBuilder();
            String processHeatMapOptions = Convert.processHeatMapOptions(hashMap, heatMapBuilder);
            HeatMapOptions build = heatMapBuilder.build();
            this.logger.startMethodExecutionTimer("addHeatMap");
            HeatMap addHeatMap = this.huaweiMap.addHeatMap(processHeatMapOptions, build);
            this.logger.sendSingleEvent("addHeatMap");
            this.idsOnMap.put(processHeatMapOptions, new HeatMapController(addHeatMap, this.application));
            this.ids.put(addHeatMap.getId(), processHeatMapOptions);
        }
    }

    private void update(HashMap<String, Object> hashMap) {
        HeatMapController heatMapController;
        if (hashMap != null && (heatMapController = this.idsOnMap.get(getId(hashMap))) != null) {
            Convert.processHeatMapOptions(hashMap, heatMapController);
        }
    }

    public void deleteMulti(List<String> list) {
        HeatMapController remove;
        if (list != null) {
            for (String next : list) {
                if (!(next == null || (remove = this.idsOnMap.remove(next)) == null)) {
                    this.logger.startMethodExecutionTimer("removeHeatMap");
                    remove.delete();
                    this.logger.sendSingleEvent("removeHeatMap");
                    this.ids.remove(remove.getHeatMapId());
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
