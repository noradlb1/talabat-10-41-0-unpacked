package com.huawei.hms.support.api.entity.location.offlinelocation;

import com.huawei.hms.support.api.client.Result;
import java.util.HashMap;
import java.util.List;

public class OfflineLocationResponse extends Result {
    private HashMap<String, String> extras;
    private List<OfflineLocationResponseData> responseDataList;

    public HashMap<String, String> getExtras() {
        return this.extras;
    }

    public List<OfflineLocationResponseData> getResponseDataList() {
        return this.responseDataList;
    }

    public void setExtras(HashMap<String, String> hashMap) {
        this.extras = hashMap;
    }

    public void setResponseDataList(List<OfflineLocationResponseData> list) {
        this.responseDataList = list;
    }
}
