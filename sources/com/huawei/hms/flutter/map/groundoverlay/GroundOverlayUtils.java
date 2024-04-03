package com.huawei.hms.flutter.map.groundoverlay;

import android.app.Application;
import com.huawei.hms.flutter.map.constants.Method;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.flutter.map.logger.HMSLogger;
import com.huawei.hms.flutter.map.utils.Convert;
import com.huawei.hms.flutter.map.utils.ToJson;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.model.GroundOverlay;
import com.huawei.hms.maps.model.GroundOverlayOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroundOverlayUtils {
    private HuaweiMap huaweiMap;
    private final Map<String, String> ids = new HashMap();
    private final Map<String, GroundOverlayController> idsOnMap = new HashMap();
    private final HMSLogger logger;
    private final MethodChannel mChannel;

    public GroundOverlayUtils(MethodChannel methodChannel, Application application) {
        this.mChannel = methodChannel;
        this.logger = HMSLogger.getInstance(application);
    }

    private static String getId(HashMap<String, Object> hashMap) {
        return (String) hashMap.get(Param.GROUND_OVERLAY_ID);
    }

    private void insert(HashMap<String, Object> hashMap) {
        if (this.huaweiMap != null && hashMap != null) {
            GroundOverlayBuilder groundOverlayBuilder = new GroundOverlayBuilder();
            String processGroundOverlayOptions = Convert.processGroundOverlayOptions(hashMap, groundOverlayBuilder);
            GroundOverlayOptions build = groundOverlayBuilder.build();
            this.logger.startMethodExecutionTimer("addGroundOverlay");
            GroundOverlay addGroundOverlay = this.huaweiMap.addGroundOverlay(build);
            this.logger.sendSingleEvent("addGroundOverlay");
            this.idsOnMap.put(processGroundOverlayOptions, new GroundOverlayController(addGroundOverlay, groundOverlayBuilder.isClickable()));
            this.ids.put(addGroundOverlay.getId(), processGroundOverlayOptions);
        }
    }

    private void update(HashMap<String, Object> hashMap) {
        GroundOverlayController groundOverlayController;
        if (hashMap != null && (groundOverlayController = this.idsOnMap.get(getId(hashMap))) != null) {
            Convert.processGroundOverlayOptions(hashMap, groundOverlayController);
        }
    }

    public void deleteMulti(List<String> list) {
        GroundOverlayController remove;
        if (list != null) {
            for (String next : list) {
                if (!(next == null || (remove = this.idsOnMap.remove(next)) == null)) {
                    this.logger.startMethodExecutionTimer("removeGroundOverlay");
                    remove.delete();
                    this.logger.sendSingleEvent("removeGroundOverlay");
                    this.ids.remove(remove.getMapGroundOverlayId());
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

    public boolean onGroundOverlayClick(String str) {
        String str2 = this.ids.get(str);
        if (str2 == null) {
            return false;
        }
        this.mChannel.invokeMethod(Method.GROUND_OVERLAY_CLICK, ToJson.groundOverlayId(str2));
        GroundOverlayController groundOverlayController = this.idsOnMap.get(str2);
        if (groundOverlayController != null) {
            return groundOverlayController.isClickable();
        }
        return false;
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
