package com.huawei.hms.location;

import com.huawei.hms.core.aidl.IMessageEntity;
import java.util.HashMap;

public class LocationSceneRequest implements IMessageEntity {
    public static final int SCENE_CAR_BT_STATUS = 1;
    public static final int SCENE_PARKING_LOCATION = 101;
    private int sceneMode;
    private HashMap<String, String> sceneParam;

    public LocationSceneRequest(int i11) {
        this.sceneMode = i11;
    }

    public int getSceneMode() {
        return this.sceneMode;
    }

    public HashMap<String, String> getSceneParam() {
        return this.sceneParam;
    }

    public void setSceneMode(int i11) {
        this.sceneMode = i11;
    }

    public void setSceneParam(HashMap<String, String> hashMap) {
        this.sceneParam = hashMap;
    }
}
