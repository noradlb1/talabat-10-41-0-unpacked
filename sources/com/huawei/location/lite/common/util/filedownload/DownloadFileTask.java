package com.huawei.location.lite.common.util.filedownload;

import android.os.Parcelable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.chain.Data;
import com.huawei.location.lite.common.chain.Result;
import com.huawei.location.lite.common.chain.Task;
import com.huawei.location.lite.common.http.HttpClientEx;
import com.huawei.location.lite.common.http.adapter.HttpClientBuilder;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.request.HeadBuilder;
import com.huawei.location.lite.common.http.request.RequestJsonBody;
import com.huawei.location.lite.common.log.LogConsole;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import net.bytebuddy.description.type.TypeDescription;

public class DownloadFileTask extends DownloadBaseTask {
    private static final String TAG = "DownloadFileTask";
    private IDownloadSupport iDownloadSupport;

    private void downLoadSuccessDeal(byte[] bArr) {
        DownloadFileParam downloadFileParam;
        if (bArr == null || bArr.length <= 0 || (downloadFileParam = this.f50159c) == null) {
            LogConsole.e(TAG, "responseBody is null");
            return;
        }
        this.f50157a.setResult(Result.success(new Data.Builder().putAll(this.f50157a.getOutputData()).put(DownloadConstants.DOWNLOAD_FILE, saveToSd(downloadFileParam.getSaveFilePath(), this.f50159c.getFileName(), bArr)).build()), this.f50158b);
    }

    private StringBuilder getRequestPath(URI uri) {
        StringBuilder sb2 = new StringBuilder(0);
        sb2.append(uri.getPath());
        if (!TextUtils.isEmpty(uri.getQuery())) {
            sb2.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
            sb2.append(uri.getQuery());
        }
        return sb2;
    }

    private boolean isDownLoadFileVality(String str, String str2) {
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && URLUtil.isHttpsUrl(str);
    }

    private void requestDownLoadFileStream(DownLoadFileBean downLoadFileBean) {
        OnFailureException onFailureException;
        String str;
        StringBuilder sb2;
        String version = downLoadFileBean.getFileAccessInfo().getVersion();
        String url = downLoadFileBean.getFileAccessInfo().getUrl();
        String fileSha256 = downLoadFileBean.getFileAccessInfo().getFileSha256();
        if (TextUtils.isEmpty(version) || TextUtils.isEmpty(url) || TextUtils.isEmpty(fileSha256)) {
            a(DownloadConstants.DOWNLOAD_URL_ERROR_CODE, "download url format error with empty data");
            return;
        } else if (!isDownLoadFileVality(url, fileSha256)) {
            a(DownloadConstants.DOWNLOAD_URL_ERROR_CODE, "download url not https or sha256 error");
            return;
        } else {
            try {
                URI uri = new URI(url);
                if (!uriCheck(uri)) {
                    a(DownloadConstants.DOWNLOAD_URL_ERROR_CODE, "download url format error");
                    return;
                }
                StringBuilder sb3 = new StringBuilder(0);
                sb3.append(uri.getScheme());
                sb3.append("://");
                sb3.append(uri.getHost());
                StringBuilder requestPath = getRequestPath(uri);
                BaseRequest.Builder method = new BaseRequest.Builder(requestPath.toString()).setHeads(new HeadBuilder(UUID.randomUUID().toString())).setBody(new RequestJsonBody.Builder().build()).setBaseUrl(sb3.toString()).setMethod("GET");
                try {
                    downLoadSuccessDeal(new HttpClientEx(ContextUtil.getHMSContext(), new HttpClientBuilder().setNeedInterceptor(false)).newSubmit(method.build()).executeOriginal());
                    return;
                } catch (OnErrorException e11) {
                    sb2 = new StringBuilder();
                    sb2.append("apiErrorCode====");
                    sb2.append(e11.getApiCode());
                    sb2.append("apiErrorMsg=====");
                    str = e11.getApiMsg();
                    onFailureException = e11;
                } catch (OnFailureException e12) {
                    sb2 = new StringBuilder();
                    sb2.append("errorCode====");
                    sb2.append(e12.getErrorCode().code);
                    sb2.append("errorMsg=====");
                    str = e12.getErrorCode().msg;
                    onFailureException = e12;
                }
            } catch (URISyntaxException unused) {
                a(DownloadConstants.DOWNLOAD_URL_ERROR_CODE, "download url MalformedURLException");
                LogConsole.e(TAG, "MalformedURLException");
                return;
            }
        }
        sb2.append(str);
        LogConsole.e(TAG, sb2.toString());
        a(onFailureException.getErrorCode().code, onFailureException.getErrorCode().msg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File saveToSd(java.lang.String r3, java.lang.String r4, byte[] r5) {
        /*
            r2 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r3, r4)
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0022 }
            r4 = 0
            r3.<init>(r0, r4)     // Catch:{ IOException -> 0x0022 }
            int r1 = r5.length     // Catch:{ all -> 0x0016 }
            r3.write(r5, r4, r1)     // Catch:{ all -> 0x0016 }
            r3.flush()     // Catch:{ all -> 0x0016 }
            r3.close()     // Catch:{ IOException -> 0x0022 }
            goto L_0x0029
        L_0x0016:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0018 }
        L_0x0018:
            r5 = move-exception
            r3.close()     // Catch:{ all -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch:{ IOException -> 0x0022 }
        L_0x0021:
            throw r5     // Catch:{ IOException -> 0x0022 }
        L_0x0022:
            java.lang.String r3 = "DownloadFileTask"
            java.lang.String r4 = "saveToSd createSdFile stream read write exception"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r4)
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.filedownload.DownloadFileTask.saveToSd(java.lang.String, java.lang.String, byte[]):java.io.File");
    }

    private boolean uriCheck(URI uri) {
        String str;
        if (uri == null) {
            str = "uri is null";
        } else if (TextUtils.isEmpty(uri.getScheme())) {
            str = "uri scheme is undefined";
        } else if (TextUtils.isEmpty(uri.getHost())) {
            str = "uri host is undefined";
        } else if (!TextUtils.isEmpty(uri.getPath())) {
            return true;
        } else {
            str = "uri path is undefined";
        }
        LogConsole.e(TAG, str);
        return false;
    }

    public void runTask(Task.Chain chain) {
        int i11;
        String str;
        super.runTask(chain);
        Parcelable parcelable = this.f50157a.getOutputData().getParcelable(DownloadConstants.REQUEST_DOWNLOAD_FILE_BEAN);
        if (!(parcelable instanceof DownLoadFileBean)) {
            i11 = 10003;
            str = "The data format error";
        } else {
            DownLoadFileBean downLoadFileBean = (DownLoadFileBean) parcelable;
            IDownloadSupport iDownloadSupport2 = this.iDownloadSupport;
            if (iDownloadSupport2 == null || iDownloadSupport2.isSupportDownloadFile(downLoadFileBean)) {
                requestDownLoadFileStream(downLoadFileBean);
                return;
            } else {
                i11 = DownloadConstants.REQUEST_NOT_SUPPORT_DOWNLOAD;
                str = "business not need download file";
            }
        }
        a(i11, str);
    }

    public void setiDownloadSupport(IDownloadSupport iDownloadSupport2) {
        this.iDownloadSupport = iDownloadSupport2;
    }
}
