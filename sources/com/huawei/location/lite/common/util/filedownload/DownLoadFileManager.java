package com.huawei.location.lite.common.util.filedownload;

import android.os.Parcelable;
import com.huawei.location.lite.common.chain.Data;
import com.huawei.location.lite.common.chain.TaskClient;
import com.huawei.location.lite.common.chain.TaskFinishCallBack;
import com.huawei.location.lite.common.chain.TaskRequest;
import com.huawei.location.lite.common.chain.TaskTimeOutException;
import com.huawei.location.lite.common.log.LogConsole;
import java.io.File;

public class DownLoadFileManager implements TaskFinishCallBack {
    private static final String TAG = "DownLoadFileManager";
    private DownloadFileParam downloadFileParam;
    private IDownloadResult iDownloadResult;
    private IDownloadSupport iDownloadSupport;

    public DownLoadFileManager(DownloadFileParam downloadFileParam2) {
        this.downloadFileParam = downloadFileParam2;
    }

    public DownLoadFileManager(DownloadFileParam downloadFileParam2, IDownloadSupport iDownloadSupport2) {
        this(downloadFileParam2);
        this.iDownloadSupport = iDownloadSupport2;
    }

    public void onFail(Data data) {
        IDownloadResult iDownloadResult2 = this.iDownloadResult;
        if (iDownloadResult2 != null) {
            iDownloadResult2.onFail(data.getInt(DownloadConstants.DOWONLOAD_RESULT_CODE_KEY, 0), data.getString(DownloadConstants.DOWONLOAD_RESULT_DESC_KEY));
        }
    }

    public void onSuccess(Data data) {
        String str;
        LogConsole.i(TAG, "download file Success.");
        if (this.iDownloadResult == null) {
            str = "iDownloadResult is empty.please setting";
        } else {
            Parcelable parcelable = data.getParcelable(DownloadConstants.REQUEST_DOWNLOAD_FILE_BEAN);
            if (!(parcelable instanceof DownLoadFileBean)) {
                str = "return data exception";
            } else {
                DownLoadFileBean downLoadFileBean = (DownLoadFileBean) parcelable;
                if (data.getKeyValueMap().get(DownloadConstants.DOWNLOAD_FILE) instanceof File) {
                    this.iDownloadResult.onSuccess(downLoadFileBean, (File) data.getKeyValueMap().get(DownloadConstants.DOWNLOAD_FILE));
                    return;
                }
                return;
            }
        }
        LogConsole.e(TAG, str);
    }

    public void startDownloadTask(IDownloadResult iDownloadResult2) {
        this.iDownloadResult = iDownloadResult2;
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setMaxTimeOut(DownloadConstants.DOWNLOAD_TASK_OUT_TIME);
        taskRequest.setInputData(new Data.Builder().putParcelable(DownloadConstants.PARAM_DOWNLOAD_FILE, this.downloadFileParam).build());
        taskRequest.setTaskFinishCallBack(this);
        TaskClient.Builder builder = new TaskClient.Builder();
        builder.addTask(new DownloadUrlReqTask());
        DownloadFileTask downloadFileTask = new DownloadFileTask();
        downloadFileTask.setiDownloadSupport(this.iDownloadSupport);
        builder.addTask(downloadFileTask);
        try {
            builder.withTaskRequest(taskRequest).build().runTasks();
        } catch (TaskTimeOutException unused) {
            LogConsole.e(TAG, "download file timeout");
        }
    }
}
