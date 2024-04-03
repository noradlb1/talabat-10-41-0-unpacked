package com.huawei.hms.location;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationSceneResponse implements IMessageEntity {
    private HashMap<String, String> responseMap;
    private int sceneMode;

    public HWLocation getLocationFromMap() {
        String str;
        HashMap<String, String> hashMap = this.responseMap;
        if (!(hashMap == null || hashMap.size() == 0 || (str = this.responseMap.get("hwLocation")) == null || str.isEmpty())) {
            try {
                return LocationJsonUtil.parseLocationFromJsonObject(new JSONObject(str));
            } catch (ApiException | JSONException unused) {
            }
        }
        return null;
    }

    public HashMap<String, String> getResponseMap() {
        return this.responseMap;
    }

    public int getSceneMode() {
        return this.sceneMode;
    }

    public void setResponseMap(HashMap<String, String> hashMap) {
        this.responseMap = hashMap;
    }

    public void setSceneMode(int i11) {
        this.sceneMode = i11;
    }
}
