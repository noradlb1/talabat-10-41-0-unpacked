package com.huawei.hms.support.api.client;

import com.huawei.hms.core.aidl.IAIDLInvoke;
import java.util.List;

public interface AidlApiClient extends ApiClient {
    List<String> getApiNameList();

    IAIDLInvoke getService();
}
