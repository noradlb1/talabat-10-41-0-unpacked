package com.huawei.hms.analytics;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.analytics.core.log.HiLog;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

public final class dz {
    private static final String[] lmn = {"e2f856b9f9a4fd4cb2795aeaf83268e4bff189aaec05d691ffde76e075b82648", "173cf86fe9894a0f70dadd09d4fd88c380836099d4939f8c3754361bdc16a32b", "b368b110e3b565fe97c91f786e11bc48754cc8e4e6f21d8a94a68ac6ad67aaaf", "db48223fd9e143f7e133c57f5d08a4e38549ce3ebd921fe3b4003c26e5e35bed", "4bdecdf772491e35c4e8b48f88aee22bae1311984f2e1da4dfad0b78ee7f5163", "3081a0adab3018d57165e6dd24074bdbac640f6dbe21a9e24d3474a87ebf38b8", "db53fcdc9ab71e9bdd4eab257fe1aba7989ad2b24fbe3a85dfef72ea1dd6bae2", "d80f18e8081b624cc64985f87f70118f1702985d2e10dbc985ee7be334fd3c7d", "5fed96c85bd58c58aadbd465c172a4c9a794d8eb2f86cbc7bcee6caf4c7a2c5f", "07ff9b7aeeff969173c45b285fe0fecdbaae244576ff7a2796a36f1c0c11adb4", "92974c6802419e4d18b5ec536cbfa167b8e8eff09ec4c8510a5b95750b1e0c82", "403f14ad2f0e5eb3c4f3a0bcd5c1592cc4492662ad53191c92905255d4990656", "4230baa077b401374d0fc012375047e79ea0790d58d095ef18d97d95470c738d", "f8d927750a0952ffb5bd87dfb83d781ae65f7bed043a7886d1d3cdcfc94bb77a"};

    @TargetApi(9)
    private static String klm(String str) {
        if (TextUtils.isEmpty(str)) {
            HiLog.w("UriToolsKit", "url is null");
            return str;
        }
        try {
            if (URLUtil.isNetworkUrl(str)) {
                if (!str.toLowerCase(Locale.US).startsWith("http:")) {
                    return new URI(str).getHost();
                }
            }
            HiLog.e("UriToolsKit", "url don't starts with https");
            return null;
        } catch (URISyntaxException unused) {
            HiLog.e("UriToolsKit", "getHostByURI error : ");
            return null;
        }
    }

    public static boolean lmn(String str) {
        for (String lmn2 : lmn) {
            if (lmn(str, lmn2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean lmn(java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r8 = klm(r8)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r1 = "."
            r2 = 1
            r3 = 0
            java.lang.String r4 = "UriToolsKit"
            if (r0 != 0) goto L_0x0057
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L_0x0017
            goto L_0x0057
        L_0x0017:
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L_0x0024
            java.lang.String r0 = "url is null"
            com.huawei.hms.analytics.core.log.HiLog.i(r4, r0)
            r0 = r8
            goto L_0x004c
        L_0x0024:
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r8.split(r0)
            int r5 = r0.length
            r6 = 2
            if (r5 >= r6) goto L_0x0031
            java.lang.String r0 = ""
            goto L_0x004c
        L_0x0031:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            r5.<init>()
            int r7 = r0.length
            int r7 = r7 - r6
            r7 = r0[r7]
            r5.append(r7)
            r5.append(r1)
            int r7 = r0.length
            int r7 = r7 - r6
            int r7 = r7 + r2
            r0 = r0[r7]
            r5.append(r0)
            java.lang.String r0 = r5.toString()
        L_0x004c:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 == 0) goto L_0x0055
            java.lang.String r0 = "get urlLastNStr is null"
            goto L_0x0059
        L_0x0055:
            r3 = r0
            goto L_0x005c
        L_0x0057:
            java.lang.String r0 = "url or allowlistHash is null"
        L_0x0059:
            com.huawei.hms.analytics.core.log.HiLog.e(r4, r0)
        L_0x005c:
            r0 = 0
            if (r3 != 0) goto L_0x0060
            return r0
        L_0x0060:
            java.lang.String r5 = com.huawei.hms.analytics.dn.lmn(r8)
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x006b
            return r2
        L_0x006b:
            java.lang.String r2 = com.huawei.hms.analytics.dn.lmn(r3)
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0099
            int r9 = r8.length()     // Catch:{ IndexOutOfBoundsException -> 0x0096, Exception -> 0x0090 }
            int r2 = r3.length()     // Catch:{ IndexOutOfBoundsException -> 0x0096, Exception -> 0x0090 }
            int r9 = r9 - r2
            java.lang.String r8 = r8.substring(r0, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0096, Exception -> 0x0090 }
            boolean r9 = r8.endsWith(r1)     // Catch:{ IndexOutOfBoundsException -> 0x0096, Exception -> 0x0090 }
            if (r9 != 0) goto L_0x0089
            return r0
        L_0x0089:
            java.lang.String r9 = "^[A-Za-z0-9.-]+$"
            boolean r8 = r8.matches(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0096, Exception -> 0x0090 }
            return r8
        L_0x0090:
            java.lang.String r8 = "other Exception!"
        L_0x0092:
            com.huawei.hms.analytics.core.log.HiLog.e(r4, r8)
            return r0
        L_0x0096:
            java.lang.String r8 = "IndexOutOfBounds Exception"
            goto L_0x0092
        L_0x0099:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.dz.lmn(java.lang.String, java.lang.String):boolean");
    }
}
