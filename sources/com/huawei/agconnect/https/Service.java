package com.huawei.agconnect.https;

import com.huawei.hmf.tasks.Task;

public interface Service {

    public static class Factory {
        public static Service get(HttpsKit httpsKit) {
            return new d(httpsKit.client(), httpsKit.executor());
        }
    }

    Task<HttpsResult> execute(Method method);
}
