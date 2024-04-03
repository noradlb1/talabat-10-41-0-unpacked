package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.ProfileTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.ProfileReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.secure.android.common.encrypt.hash.SHA;

public class HmsProfile {
    public static final int CUSTOM_PROFILE = 2;
    public static final int HUAWEI_PROFILE = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final String f49697c = "HmsProfile";

    /* renamed from: a  reason: collision with root package name */
    private Context f49698a = null;

    /* renamed from: b  reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f49699b;

    private HmsProfile(Context context) {
        Preconditions.checkNotNull(context);
        this.f49698a = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f49699b = new HuaweiApi<>((Activity) context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f49699b = new HuaweiApi<>(context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        }
        this.f49699b.setKitSdkVersion(60700300);
    }

    private Task<Void> a(int i11, String str, int i12, String str2) {
        if (!isSupportProfile()) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
            return taskCompletionSource.getTask();
        }
        if (!TextUtils.isEmpty(str)) {
            String a11 = a(this.f49698a);
            if (TextUtils.isEmpty(a11)) {
                HMSLog.i(f49697c, "agc connect services config missing project id.");
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                taskCompletionSource2.setException(ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException());
                return taskCompletionSource2.getTask();
            } else if (str.equals(a11)) {
                str = "";
            }
        }
        ProfileReq profileReq = new ProfileReq();
        if (i11 == 0) {
            profileReq.setOperation(0);
            profileReq.setType(i12);
        } else {
            profileReq.setOperation(1);
        }
        String reportEntry = PushBiUtil.reportEntry(this.f49698a, PushNaming.PUSH_PROFILE);
        try {
            profileReq.setSubjectId(str);
            profileReq.setProfileId(SHA.sha256Encrypt(str2));
            profileReq.setPkgName(this.f49698a.getPackageName());
            return this.f49699b.doWrite(new ProfileTask(PushNaming.PUSH_PROFILE, JsonUtil.createJsonString(profileReq), reportEntry));
        } catch (Exception e11) {
            if (e11.getCause() instanceof ApiException) {
                TaskCompletionSource taskCompletionSource3 = new TaskCompletionSource();
                ApiException apiException = (ApiException) e11.getCause();
                taskCompletionSource3.setException(apiException);
                PushBiUtil.reportExit(this.f49698a, PushNaming.PUSH_PROFILE, reportEntry, apiException.getStatusCode());
                return taskCompletionSource3.getTask();
            }
            TaskCompletionSource taskCompletionSource4 = new TaskCompletionSource();
            Context context = this.f49698a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            PushBiUtil.reportExit(context, PushNaming.PUSH_PROFILE, reportEntry, errorEnum);
            taskCompletionSource4.setException(errorEnum.toApiException());
            return taskCompletionSource4.getTask();
        }
    }

    private boolean b(Context context) {
        return c.b(context) >= 110001400;
    }

    public static HmsProfile getInstance(Context context) {
        return new HmsProfile(context);
    }

    public Task<Void> addProfile(int i11, String str) {
        return addProfile("", i11, str);
    }

    public Task<Void> deleteProfile(String str) {
        return deleteProfile("", str);
    }

    public boolean isSupportProfile() {
        if (!c.d(this.f49698a)) {
            return true;
        }
        if (c.c()) {
            HMSLog.i(f49697c, "current EMUI version below 9.1, not support profile operation.");
            return false;
        } else if (b(this.f49698a)) {
            return true;
        } else {
            HMSLog.i(f49697c, "current HwPushService.apk version below 11.0.1.400,please upgrade your HwPushService.apk version.");
            return false;
        }
    }

    public Task<Void> addProfile(String str, int i11, String str2) {
        if (i11 != 1 && i11 != 2) {
            HMSLog.i(f49697c, "add profile type undefined.");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
            return taskCompletionSource.getTask();
        } else if (!TextUtils.isEmpty(str2)) {
            return a(0, str, i11, str2);
        } else {
            HMSLog.i(f49697c, "add profile params is empty.");
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            taskCompletionSource2.setException(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
            return taskCompletionSource2.getTask();
        }
    }

    public Task<Void> deleteProfile(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return a(1, str, -1, str2);
        }
        HMSLog.e(f49697c, "del profile params is empty.");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
        return taskCompletionSource.getTask();
    }

    private static String a(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }
}
