package com.huawei.location.lite.common.agc;

import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.location.lite.common.agc.net.yn;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.security.LocationSecurityManager;
import com.huawei.location.lite.common.util.PreferencesHelper;

public class AGCManager {
    private static final String EXPIRE_TIME_KEY = "ExpireTime";
    private static final String SECURITY_AGC = "AGC_INFO";
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "AGCManager";
    private static final String TOKEN_KEY = "Token";
    private static volatile AGCManager instance;
    private volatile yn mAgcInfo;
    private yn mOnlineAgcService;
    private final PreferencesHelper preferencesHelper = new PreferencesHelper("AGCInfo");

    private AGCManager() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0127 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.location.lite.common.agc.yn asyncGetAgcInfo() {
        /*
            r9 = this;
            java.lang.String r0 = ", msg is "
            com.huawei.location.lite.common.agc.net.yn r1 = r9.mOnlineAgcService
            if (r1 != 0) goto L_0x000d
            com.huawei.location.lite.common.agc.net.yn r1 = new com.huawei.location.lite.common.agc.net.yn
            r1.<init>()
            r9.mOnlineAgcService = r1
        L_0x000d:
            com.huawei.location.lite.common.agc.net.yn r1 = r9.mOnlineAgcService
            r1.getClass()
            java.lang.String r1 = "getOnlineAgcInfo"
            java.lang.String r2 = "OnlineAgcService"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r1)
            com.huawei.location.lite.common.agc.net.AGCResponse r1 = new com.huawei.location.lite.common.agc.net.AGCResponse
            r1.<init>()
            com.huawei.location.lite.common.http.request.RequestJsonBody$Builder r3 = new com.huawei.location.lite.common.http.request.RequestJsonBody$Builder     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            r3.<init>()     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            java.lang.String r4 = "fingerprint"
            android.content.Context r5 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            java.lang.String r5 = com.huawei.location.lite.common.util.APKUtil.getSignatureForPkgName(r5)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            com.huawei.location.lite.common.http.request.RequestJsonBody$Builder r3 = r3.add(r4, r5)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            com.huawei.location.lite.common.http.request.RequestJsonBody r3 = r3.build()     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            java.util.UUID r4 = java.util.UUID.randomUUID()     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            java.lang.String r4 = r4.toString()     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            java.lang.String r5 = "com.huawei.hms.location"
            java.lang.String r5 = com.huawei.location.lite.common.grs.LocationNlpGrsHelper.getGrsHostAddress(r5)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            if (r6 == 0) goto L_0x0054
            java.lang.String r3 = "grsHostAddress is null"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r3)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            goto L_0x0101
        L_0x0054:
            android.content.Context r6 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            com.huawei.location.lite.common.http.request.HeadBuilder r7 = new com.huawei.location.lite.common.http.request.HeadBuilder     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            r7.<init>(r4)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            com.huawei.location.lite.common.http.request.HeadBuilder r4 = r7.setPackageName(r6)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            com.huawei.location.lite.common.http.request.BaseRequest$Builder r6 = new com.huawei.location.lite.common.http.request.BaseRequest$Builder     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            java.lang.String r7 = "/location/v1/getToken"
            r6.<init>(r7)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            com.huawei.location.lite.common.http.request.BaseRequest$Builder r5 = r6.setBaseUrl(r5)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            com.huawei.location.lite.common.http.request.BaseRequest$Builder r4 = r5.setHeads(r4)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            com.huawei.location.lite.common.http.request.BaseRequest$Builder r3 = r4.setBody((com.huawei.location.lite.common.http.request.RequestJsonBody) r3)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            com.huawei.location.lite.common.http.HttpClientEx r4 = new com.huawei.location.lite.common.http.HttpClientEx     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            android.content.Context r5 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            com.huawei.location.lite.common.http.adapter.HttpClientBuilder r6 = new com.huawei.location.lite.common.http.adapter.HttpClientBuilder     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            r6.<init>()     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            r7 = 0
            com.huawei.location.lite.common.http.adapter.HttpClientBuilder r6 = r6.setNeedCheckAGC(r7)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            r4.<init>(r5, r6)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            com.huawei.location.lite.common.http.request.BaseRequest r3 = r3.build()     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            com.huawei.location.lite.common.http.adapter.ISubmitAdapter r3 = r4.newSubmit(r3)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            java.lang.Class<com.huawei.location.lite.common.agc.net.AGCResponse> r4 = com.huawei.location.lite.common.agc.net.AGCResponse.class
            com.huawei.location.lite.common.http.response.BaseResponse r3 = r3.execute(r4)     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            com.huawei.location.lite.common.agc.net.AGCResponse r3 = (com.huawei.location.lite.common.agc.net.AGCResponse) r3     // Catch:{ OnFailureException -> 0x00de, OnErrorException -> 0x00c4, Exception -> 0x00c1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ OnFailureException -> 0x00bc, OnErrorException -> 0x00b7, Exception -> 0x00b5 }
            r1.<init>()     // Catch:{ OnFailureException -> 0x00bc, OnErrorException -> 0x00b7, Exception -> 0x00b5 }
            java.lang.String r4 = "doHttp, response code is "
            r1.append(r4)     // Catch:{ OnFailureException -> 0x00bc, OnErrorException -> 0x00b7, Exception -> 0x00b5 }
            java.lang.String r4 = r3.getApiCode()     // Catch:{ OnFailureException -> 0x00bc, OnErrorException -> 0x00b7, Exception -> 0x00b5 }
            r1.append(r4)     // Catch:{ OnFailureException -> 0x00bc, OnErrorException -> 0x00b7, Exception -> 0x00b5 }
            java.lang.String r1 = r1.toString()     // Catch:{ OnFailureException -> 0x00bc, OnErrorException -> 0x00b7, Exception -> 0x00b5 }
            com.huawei.location.lite.common.log.LogConsole.i(r2, r1)     // Catch:{ OnFailureException -> 0x00bc, OnErrorException -> 0x00b7, Exception -> 0x00b5 }
            r1 = r3
            goto L_0x0101
        L_0x00b5:
            r1 = r3
            goto L_0x00c1
        L_0x00b7:
            r1 = move-exception
            r8 = r3
            r3 = r1
            r1 = r8
            goto L_0x00c5
        L_0x00bc:
            r1 = move-exception
            r8 = r3
            r3 = r1
            r1 = r8
            goto L_0x00df
        L_0x00c1:
            java.lang.String r0 = "unknown exception"
            goto L_0x00fe
        L_0x00c4:
            r3 = move-exception
        L_0x00c5:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "doHttp, OnErrorException: code is "
            r4.append(r5)
            java.lang.String r5 = r3.getApiCode()
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r3.getApiMsg()
            goto L_0x00f7
        L_0x00de:
            r3 = move-exception
        L_0x00df:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "doHttp, OnFailureException: code is "
            r4.append(r5)
            com.huawei.location.lite.common.http.exception.ErrorCode r5 = r3.getErrorCode()
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r3.getMessage()
        L_0x00f7:
            r4.append(r0)
            java.lang.String r0 = r4.toString()
        L_0x00fe:
            com.huawei.location.lite.common.log.LogConsole.e(r2, r0)
        L_0x0101:
            boolean r0 = r1.isSuccess()
            if (r0 == 0) goto L_0x0127
            java.lang.String r0 = "getOnlineAgcInfo success,save to cache"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r0)
            com.huawei.location.lite.common.agc.yn r0 = new com.huawei.location.lite.common.agc.yn
            r0.<init>()
            long r2 = r1.getExpireTime()
            r0.yn((long) r2)
            java.lang.String r1 = r1.getToken()
            r0.yn((java.lang.String) r1)
            com.huawei.location.lite.common.agc.AGCManager r1 = getInstance()
            r1.setAgcCache(r0)
            goto L_0x0128
        L_0x0127:
            r0 = 0
        L_0x0128:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.agc.AGCManager.asyncGetAgcInfo():com.huawei.location.lite.common.agc.yn");
    }

    public static AGCManager getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                if (instance == null) {
                    instance = new AGCManager();
                }
            }
        }
        return instance;
    }

    public boolean checkAgc() {
        return getInstance().getAgcInfo() != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.huawei.location.lite.common.agc.yn getAgcInfo() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.huawei.location.lite.common.agc.yn r0 = r6.mAgcInfo     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x001e
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x007c }
            com.huawei.location.lite.common.agc.yn r2 = r6.mAgcInfo     // Catch:{ all -> 0x007c }
            long r2 = r2.yn()     // Catch:{ all -> 0x007c }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x001e
            java.lang.String r0 = "AGCManager"
            java.lang.String r1 = "use cache agcInfo"
            com.huawei.location.lite.common.log.LogConsole.i(r0, r1)     // Catch:{ all -> 0x007c }
            com.huawei.location.lite.common.agc.yn r0 = r6.mAgcInfo     // Catch:{ all -> 0x007c }
            monitor-exit(r6)
            return r0
        L_0x001e:
            com.huawei.location.lite.common.agc.yn r0 = r6.asyncGetAgcInfo()     // Catch:{ all -> 0x007c }
            r6.mAgcInfo = r0     // Catch:{ all -> 0x007c }
            com.huawei.location.lite.common.agc.yn r0 = r6.mAgcInfo     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = "AGCManager"
            java.lang.String r1 = "use agcInfo from online"
            com.huawei.location.lite.common.log.LogConsole.i(r0, r1)     // Catch:{ all -> 0x007c }
            com.huawei.location.lite.common.agc.yn r0 = r6.mAgcInfo     // Catch:{ all -> 0x007c }
            monitor-exit(r6)
            return r0
        L_0x0033:
            com.huawei.location.lite.common.util.PreferencesHelper r0 = r6.preferencesHelper     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "ExpireTime"
            long r0 = r0.getLong(r1)     // Catch:{ all -> 0x007c }
            com.huawei.location.lite.common.util.PreferencesHelper r2 = r6.preferencesHelper     // Catch:{ all -> 0x007c }
            java.lang.String r3 = "Token"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ all -> 0x007c }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x007c }
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x0079
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x007c }
            if (r3 != 0) goto L_0x0079
            java.lang.String r3 = "AGCManager"
            java.lang.String r4 = "use agcInfo from sp"
            com.huawei.location.lite.common.log.LogConsole.i(r3, r4)     // Catch:{ all -> 0x007c }
            com.huawei.location.lite.common.security.LocationSecurityManager r3 = new com.huawei.location.lite.common.security.LocationSecurityManager     // Catch:{ all -> 0x007c }
            r4 = 3
            r3.<init>(r4)     // Catch:{ all -> 0x007c }
            com.huawei.location.lite.common.agc.yn r4 = new com.huawei.location.lite.common.agc.yn     // Catch:{ all -> 0x007c }
            r4.<init>()     // Catch:{ all -> 0x007c }
            r6.mAgcInfo = r4     // Catch:{ all -> 0x007c }
            com.huawei.location.lite.common.agc.yn r4 = r6.mAgcInfo     // Catch:{ all -> 0x007c }
            java.lang.String r5 = "AGC_INFO"
            java.lang.String r2 = r3.decrypt(r2, r5)     // Catch:{ all -> 0x007c }
            r4.yn((java.lang.String) r2)     // Catch:{ all -> 0x007c }
            com.huawei.location.lite.common.agc.yn r2 = r6.mAgcInfo     // Catch:{ all -> 0x007c }
            r2.yn((long) r0)     // Catch:{ all -> 0x007c }
            com.huawei.location.lite.common.agc.yn r0 = r6.mAgcInfo     // Catch:{ all -> 0x007c }
            monitor-exit(r6)
            return r0
        L_0x0079:
            monitor-exit(r6)
            r0 = 0
            return r0
        L_0x007c:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.agc.AGCManager.getAgcInfo():com.huawei.location.lite.common.agc.yn");
    }

    public String getAppId() {
        try {
            AGConnectServicesConfig fromContext = AGConnectServicesConfig.fromContext(ContextUtil.getContext());
            return TextUtils.isEmpty(fromContext.getString("client/app_id")) ? "" : fromContext.getString("client/app_id");
        } catch (Exception unused) {
            LogConsole.e(TAG, "get agc appId by exception");
            return "";
        }
    }

    public synchronized void notifyAkChange() {
        this.mAgcInfo = null;
    }

    public synchronized void setAgcCache(yn ynVar) {
        this.mAgcInfo = ynVar;
        this.preferencesHelper.saveString(TOKEN_KEY, new LocationSecurityManager(3).encrypt(ynVar.Vw(), SECURITY_AGC));
        this.preferencesHelper.saveLong(EXPIRE_TIME_KEY, ynVar.yn());
    }
}
