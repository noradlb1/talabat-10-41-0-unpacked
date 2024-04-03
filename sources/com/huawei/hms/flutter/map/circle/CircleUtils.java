package com.huawei.hms.flutter.map.circle;

import android.app.Application;
import com.huawei.hms.flutter.map.constants.Method;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.flutter.map.logger.HMSLogger;
import com.huawei.hms.flutter.map.utils.Convert;
import com.huawei.hms.flutter.map.utils.ToJson;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.model.Circle;
import com.huawei.hms.maps.model.CircleOptions;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircleUtils {
    private final float compactness;
    private HuaweiMap huaweiMap;
    private final Map<String, String> ids = new HashMap();
    private final Map<String, CircleController> idsOnMap = new HashMap();
    private final HMSLogger logger;
    private final MethodChannel mChannel;
    private BinaryMessenger messenger;

    public CircleUtils(MethodChannel methodChannel, float f11, Application application) {
        this.mChannel = methodChannel;
        this.compactness = f11;
        this.logger = HMSLogger.getInstance(application);
    }

    private static String getId(HashMap<String, Object> hashMap) {
        return (String) hashMap.get(Param.CIRCLE_ID);
    }

    private void insert(HashMap<String, Object> hashMap, BinaryMessenger binaryMessenger) {
        if (this.huaweiMap != null && hashMap != null) {
            CircleBuilder circleBuilder = new CircleBuilder(this.compactness);
            String processCircleOptions = Convert.processCircleOptions(hashMap, circleBuilder, binaryMessenger);
            CircleOptions build = circleBuilder.build();
            this.logger.startMethodExecutionTimer("addCircle");
            Circle addCircle = this.huaweiMap.addCircle(build);
            this.logger.sendSingleEvent("addCircle");
            CircleController circleController = new CircleController(addCircle, circleBuilder.isClickable(), this.compactness);
            if (circleBuilder.getAnimation() != null) {
                circleController.setAnimation(circleBuilder.getAnimation());
            }
            this.idsOnMap.put(processCircleOptions, circleController);
            this.ids.put(addCircle.getId(), processCircleOptions);
        }
    }

    private void update(HashMap<String, Object> hashMap) {
        CircleController circleController;
        if (hashMap != null && (circleController = this.idsOnMap.get(getId(hashMap))) != null) {
            Convert.processCircleOptions(hashMap, circleController, this.messenger);
        }
    }

    public void deleteMulti(List<String> list) {
        CircleController remove;
        if (list != null) {
            for (String next : list) {
                if (!(next == null || (remove = this.idsOnMap.remove(next)) == null)) {
                    this.logger.startMethodExecutionTimer("removeCircle");
                    remove.delete();
                    this.logger.sendSingleEvent("removeCircle");
                    this.ids.remove(remove.getIdOnMap());
                }
            }
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

    public boolean onCircleClick(String str) {
        String str2 = this.ids.get(str);
        if (str2 == null) {
            return false;
        }
        this.mChannel.invokeMethod(Method.CIRCLE_CLICK, ToJson.circleId(str2));
        CircleController circleController = this.idsOnMap.get(str2);
        if (circleController == null || !circleController.isClickable()) {
            return false;
        }
        return true;
    }

    public void setMap(HuaweiMap huaweiMap2) {
        this.huaweiMap = huaweiMap2;
    }

    public void startAnimation(String str) {
        CircleController circleController = this.idsOnMap.get(str);
        if (circleController != null) {
            circleController.startAnimation();
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
