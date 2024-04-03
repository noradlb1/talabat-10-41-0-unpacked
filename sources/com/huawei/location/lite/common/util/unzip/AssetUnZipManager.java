package com.huawei.location.lite.common.util.unzip;

import android.os.Bundle;
import com.google.gson.Gson;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.plug.IPluginResult;
import com.huawei.location.lite.common.plug.PluginManager;
import com.huawei.location.lite.common.plug.PluginReqMessage;
import com.huawei.location.lite.common.report.ReportBuilder;
import com.huawei.location.lite.common.report.Tracker;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.SDKComponentType;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.List;

@Instrumented
public class AssetUnZipManager {
    private static final int ASSET_FOR_ERROR = 100;
    private static final String TAG = "AssetUnZipManager";
    private static final int UN7Z_ERROR = 101;
    private String assetDirPath;
    private int errorCode;
    private List<String> filterZipDirs;
    private List<String> filterZipFiles;
    private IUnzip iUnzip;
    private final int maxTryTimes;
    private int tryTime;

    public AssetUnZipManager() {
        this((String) null, new Un7Z());
    }

    public AssetUnZipManager(String str, IUnzip iUnzip2) {
        this.maxTryTimes = 3;
        this.tryTime = 0;
        this.errorCode = 101;
        this.assetDirPath = str;
        this.iUnzip = iUnzip2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r5.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0053, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0056, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0057, code lost:
        if (r3 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0061, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File createFileFromInputStream(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.io.File r0 = new java.io.File
            java.io.File r1 = r3.getCacheDir()
            r0.<init>(r1, r4)
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            java.lang.String r5 = java.io.File.separator
            r1.append(r5)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
        L_0x0024:
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch:{ IOException -> 0x0062 }
            r5 = 3
            java.io.InputStream r3 = r3.open(r4, r5)     // Catch:{ IOException -> 0x0062 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0054 }
            r4.<init>(r0)     // Catch:{ all -> 0x0054 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0048 }
        L_0x0036:
            int r1 = r3.read(r5)     // Catch:{ all -> 0x0048 }
            if (r1 <= 0) goto L_0x0041
            r2 = 0
            r4.write(r5, r2, r1)     // Catch:{ all -> 0x0048 }
            goto L_0x0036
        L_0x0041:
            r4.close()     // Catch:{ all -> 0x0054 }
            r3.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0069
        L_0x0048:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x004a }
        L_0x004a:
            r1 = move-exception
            r4.close()     // Catch:{ all -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r4 = move-exception
            r5.addSuppressed(r4)     // Catch:{ all -> 0x0054 }
        L_0x0053:
            throw r1     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r5 = move-exception
            if (r3 == 0) goto L_0x0061
            r3.close()     // Catch:{ all -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch:{ IOException -> 0x0062 }
        L_0x0061:
            throw r5     // Catch:{ IOException -> 0x0062 }
        L_0x0062:
            java.lang.String r3 = "AssetUnZipManager"
            java.lang.String r4 = "createFileFromInputStream : IOException"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r4)
        L_0x0069:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.unzip.AssetUnZipManager.createFileFromInputStream(android.content.Context, java.lang.String, java.lang.String):java.io.File");
    }

    private void reportAssetUnZipResult() {
        ReportBuilder reportBuilder = new ReportBuilder();
        reportBuilder.setApiName(TAG);
        reportBuilder.setErrorCode(String.valueOf(this.errorCode));
        LogConsole.i(TAG, reportBuilder.build().toString());
        if (SDKComponentType.getComponentType() == 200) {
            PluginReqMessage pluginReqMessage = new PluginReqMessage();
            Gson instance = GsonUtil.getInstance();
            pluginReqMessage.setData(!(instance instanceof Gson) ? instance.toJson((Object) reportBuilder) : GsonInstrumentation.toJson(instance, (Object) reportBuilder));
            Bundle bundle = new Bundle();
            bundle.putString("report_type", "event_operation");
            pluginReqMessage.setExtraData(bundle);
            PluginManager.getInstance().startFunction(102, "report", pluginReqMessage, (IPluginResult) null);
            return;
        }
        Tracker.getInstance().onMaintEvent(reportBuilder);
        Tracker.getInstance().onOperationEvent(reportBuilder);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0081 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean copyZipFileFromAssets(java.lang.String r10) {
        /*
            r9 = this;
            int r0 = r9.tryTime
            r1 = 3
            r2 = 0
            java.lang.String r3 = "AssetUnZipManager"
            if (r0 < r1) goto L_0x0011
            java.lang.String r10 = "maxTryTime failed"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r10)
            r9.reportAssetUnZipResult()
            return r2
        L_0x0011:
            android.content.Context r0 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()
            android.content.res.AssetManager r0 = r0.getAssets()
            java.lang.String r1 = r9.assetDirPath     // Catch:{ IOException -> 0x006a }
            java.lang.String[] r0 = r0.list(r1)     // Catch:{ IOException -> 0x006a }
            if (r0 == 0) goto L_0x0060
            int r1 = r0.length     // Catch:{ IOException -> 0x006a }
            if (r1 > 0) goto L_0x0025
            goto L_0x0060
        L_0x0025:
            r1 = r2
        L_0x0026:
            int r4 = r0.length     // Catch:{ IOException -> 0x005e }
            if (r2 >= r4) goto L_0x005c
            com.huawei.location.lite.common.util.unzip.IUnzip r4 = r9.iUnzip     // Catch:{ IOException -> 0x005e }
            r5 = r0[r2]     // Catch:{ IOException -> 0x005e }
            boolean r4 = r4.isSupportUnZip(r5)     // Catch:{ IOException -> 0x005e }
            if (r4 != 0) goto L_0x0034
            goto L_0x0059
        L_0x0034:
            android.content.Context r4 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()     // Catch:{ IOException -> 0x005e }
            r5 = r0[r2]     // Catch:{ IOException -> 0x005e }
            java.lang.String r6 = r9.assetDirPath     // Catch:{ IOException -> 0x005e }
            java.io.File r4 = createFileFromInputStream(r4, r5, r6)     // Catch:{ IOException -> 0x005e }
            com.huawei.location.lite.common.util.unzip.IUnzip r5 = r9.iUnzip     // Catch:{ IOException -> 0x005e }
            java.lang.String r6 = r4.getCanonicalPath()     // Catch:{ IOException -> 0x005e }
            java.util.List<java.lang.String> r7 = r9.filterZipDirs     // Catch:{ IOException -> 0x005e }
            java.util.List<java.lang.String> r8 = r9.filterZipFiles     // Catch:{ IOException -> 0x005e }
            boolean r1 = r5.doUnzip(r6, r10, r7, r8)     // Catch:{ IOException -> 0x005e }
            boolean r4 = r4.delete()     // Catch:{ IOException -> 0x005e }
            if (r4 != 0) goto L_0x0059
            java.lang.String r4 = "delete file exception"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r4)     // Catch:{ IOException -> 0x005e }
        L_0x0059:
            int r2 = r2 + 1
            goto L_0x0026
        L_0x005c:
            r2 = r1
            goto L_0x006f
        L_0x005e:
            r2 = r1
            goto L_0x006a
        L_0x0060:
            java.lang.String r0 = "jnilib  asset file have not content"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r0)     // Catch:{ IOException -> 0x006a }
            r0 = 100
            r9.errorCode = r0     // Catch:{ IOException -> 0x006a }
            goto L_0x006f
        L_0x006a:
            java.lang.String r0 = "copyFileFromAssets stream get asset exception"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r0)
        L_0x006f:
            r0 = 1
            if (r2 != 0) goto L_0x0081
            java.lang.String r1 = "doUnzip fail"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r1)
            int r1 = r9.tryTime
            int r1 = r1 + r0
            r9.tryTime = r1
            boolean r10 = r9.copyZipFileFromAssets(r10)
            return r10
        L_0x0081:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.unzip.AssetUnZipManager.copyZipFileFromAssets(java.lang.String):boolean");
    }

    public void setFilterZipDirs(List<String> list) {
        this.filterZipDirs = list;
    }

    public void setFilterZipFiles(List<String> list) {
        this.filterZipFiles = list;
    }
}
