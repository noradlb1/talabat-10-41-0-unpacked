package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResp;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class f extends TaskApiCall<PushClient, TokenResult> {

    /* renamed from: a  reason: collision with root package name */
    private Context f49643a;

    /* renamed from: b  reason: collision with root package name */
    private TokenReq f49644b;

    public f(String str, TokenReq tokenReq, Context context, String str2) {
        super(str, JsonUtil.createJsonString(tokenReq), str2);
        this.f49643a = context;
        this.f49644b = tokenReq;
    }

    /* renamed from: a */
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<TokenResult> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() != 0) {
            String str2 = HmsInstanceId.TAG;
            HMSLog.e(str2, "TokenTask failed, ErrorCode:" + responseErrorCode.getErrorCode());
            a(responseErrorCode, taskCompletionSource);
        } else {
            TokenResp tokenResp = (TokenResp) JsonUtil.jsonToEntity(str, new TokenResp());
            ErrorEnum fromCode = ErrorEnum.fromCode(tokenResp.getRetCode());
            if (fromCode != ErrorEnum.SUCCESS) {
                taskCompletionSource.setException(fromCode.toApiException());
                String str3 = HmsInstanceId.TAG;
                HMSLog.e(str3, "TokenTask failed, StatusCode:" + fromCode.getExternalCode());
            } else {
                TokenResult tokenResult = new TokenResult();
                tokenResult.setToken(tokenResp.getToken());
                tokenResult.setBelongId(tokenResp.getBelongId());
                tokenResult.setRetCode(ErrorEnum.fromCode(tokenResp.getRetCode()).getExternalCode());
                taskCompletionSource.setResult(tokenResult);
                String token = tokenResp.getToken();
                if (TextUtils.isEmpty(token)) {
                    HMSLog.i(HmsInstanceId.TAG, "GetTokenTask receive a empty token, please check HmsMessageService.onNewToken receive result.");
                    h.a(pushClient.getContext(), getUri(), responseErrorCode);
                    return;
                }
                a(token, this.f49644b.getSubjectId());
                m.a(this.f49643a, token);
            }
        }
        h.a(pushClient.getContext(), getUri(), responseErrorCode);
    }

    public int getMinApkVersion() {
        return this.f49644b.isMultiSender() ? 50004300 : 30000000;
    }

    private void a(ResponseErrorCode responseErrorCode, TaskCompletionSource<TokenResult> taskCompletionSource) {
        ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
        if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
            taskCompletionSource.setException(fromCode.toApiException());
        } else {
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }

    private void a(String str, String str2) {
        if (!i.a(this.f49643a).b(str2).equals(str)) {
            HMSLog.i(HmsInstanceId.TAG, "receive a token, refresh the local token");
            i.a(this.f49643a).b(str2, str);
        }
    }
}
