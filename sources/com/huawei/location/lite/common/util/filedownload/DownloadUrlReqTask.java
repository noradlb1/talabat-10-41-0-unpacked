package com.huawei.location.lite.common.util.filedownload;

import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.chain.Data;
import com.huawei.location.lite.common.chain.Result;
import com.huawei.location.lite.common.chain.Task;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.http.HttpClientEx;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.request.HeadBuilder;
import com.huawei.location.lite.common.http.request.RequestJsonBody;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.UUID;

public class DownloadUrlReqTask extends DownloadBaseTask {
    private static final String TAG = "ReqDownloadUrlTask";

    private void requestDownloadUrl(String str, String str2) {
        StringBuilder sb2;
        OnFailureException onFailureException;
        String str3;
        BaseRequest.Builder method = new BaseRequest.Builder(DownloadConstants.REQUEST_DOWNLOAD_FILE).setHeads(new HeadBuilder(UUID.randomUUID().toString())).setBody(new RequestJsonBody.Builder().add(DownloadConstants.PARAM_SERVICE_TYPE, str).add(DownloadConstants.PARAM_SUB_TYPE, str2).build()).setBaseUrl(LocationNlpGrsHelper.getGrsHostAddress("com.huawei.hms.location")).setMethod("POST");
        try {
            DownLoadFileBean downLoadFileBean = (DownLoadFileBean) new HttpClientEx(ContextUtil.getHMSContext()).newSubmit(method.build()).execute(DownLoadFileBean.class);
            LogConsole.i(TAG, "url request success url and fileVersion:" + downLoadFileBean.getFileAccessInfo().getVersion());
            setNextSuccess(downLoadFileBean);
            return;
        } catch (OnErrorException e11) {
            sb2 = new StringBuilder();
            sb2.append("apiErrorCode====");
            sb2.append(e11.getApiCode());
            sb2.append("apiErrorMsg=====");
            str3 = e11.getApiMsg();
            onFailureException = e11;
        } catch (OnFailureException e12) {
            sb2 = new StringBuilder();
            sb2.append("errorCode====");
            sb2.append(e12.getErrorCode().code);
            sb2.append("errorMsg=====");
            str3 = e12.getErrorCode().msg;
            onFailureException = e12;
        }
        sb2.append(str3);
        LogConsole.e(TAG, sb2.toString());
        a(onFailureException.getErrorCode().code, onFailureException.getErrorCode().msg);
    }

    private void setNextSuccess(DownLoadFileBean downLoadFileBean) {
        this.f50157a.setResult(Result.success(new Data.Builder().putAll(this.f50157a.getOutputData()).putParcelable(DownloadConstants.REQUEST_DOWNLOAD_FILE_BEAN, downLoadFileBean).build()), this.f50158b);
    }

    public void runTask(Task.Chain chain) {
        super.runTask(chain);
        DownloadFileParam downloadFileParam = this.f50159c;
        if (downloadFileParam == null) {
            a(10000, "param error");
            return;
        }
        String serviceType = downloadFileParam.getServiceType();
        String subType = this.f50159c.getSubType();
        if (TextUtils.isEmpty(serviceType) || TextUtils.isEmpty(subType)) {
            a(10000, "param error");
        } else {
            requestDownloadUrl(serviceType, subType);
        }
    }
}
