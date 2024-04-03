package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.common.api.Backend;
import com.huawei.agconnect.common.api.BackendService;
import com.huawei.agconnect.common.api.BaseRequest;
import com.huawei.agconnect.common.api.Logger;
import com.huawei.agconnect.common.api.RequestThrottle;
import com.huawei.agconnect.exception.AGCServerException;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import okhttp3.Authenticator;

public class o {
    private static AGConnectInstance a(BackendService.Options options) {
        return (options == null || options.getApp() == null) ? AGConnectInstance.getInstance() : options.getApp();
    }

    public static <Rsp> Task<Rsp> a(BaseRequest baseRequest, int i11, Class<Rsp> cls, BackendService.Options options) {
        Logger.i("BackendServiceImpl", "sendRequest2");
        BackendService.Options build = options == null ? new BackendService.Options.Builder().app(AGConnectInstance.getInstance()).build() : options;
        if (build.getApp() == null) {
            build = build.newBuilder().app(AGConnectInstance.getInstance()).build();
        }
        BaseRequest baseRequest2 = baseRequest;
        baseRequest.initBase(build.getApp());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new u(build));
        if (!build.isClientToken()) {
            return Backend.call(baseRequest, i11, cls, build.getFactory(), build.getTimeout(), build.getTimeUnit(), arrayList, (Authenticator) null, a(build).getOptions());
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final RequestThrottle.Throttle throttle = build.getThrottle();
        Logger.i("BackendServiceImpl", "clientToken:" + build.isClientToken());
        if (build.isClientToken()) {
            arrayList.add(new q(build.getApp()));
        }
        Logger.i("BackendServiceImpl", "accessToken:" + build.isAccessToken());
        if (build.isAccessToken()) {
            arrayList.add(new m(build.getApp(), build.getAccessTokenType() == BackendService.AccessTokenType.MUST));
        }
        if (build.getThrottle() != null) {
            if (build.getThrottle().getEndTime() > 0) {
                taskCompletionSource.setException(new AGCServerException("fetch throttled, try again later", 1));
            }
            build.getThrottle().addForStart();
        }
        Backend.call(baseRequest, i11, cls, build.getFactory(), build.getTimeout(), build.getTimeUnit(), arrayList, new k(build), a(build).getOptions()).addOnSuccessListener(TaskExecutors.immediate(), new OnSuccessListener<Rsp>() {
            public void onSuccess(Rsp rsp) {
                RequestThrottle.Throttle throttle = throttle;
                if (throttle != null) {
                    throttle.addForSuccess();
                }
                taskCompletionSource.setResult(rsp);
            }
        }).addOnFailureListener(TaskExecutors.immediate(), (OnFailureListener) new OnFailureListener() {
            public void onFailure(Exception exc) {
                RequestThrottle.Throttle throttle = throttle;
                if (throttle != null && throttle.checkFail(exc)) {
                    throttle.addForFail();
                }
                taskCompletionSource.setException(exc);
            }
        });
        return taskCompletionSource.getTask();
    }
}
