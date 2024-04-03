package com.huawei.location.crowdsourcing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.location.crowdsourcing.Config;
import com.huawei.location.crowdsourcing.common.yn;
import com.huawei.location.crowdsourcing.upload.entity.Vw;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.GsonUtil;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;

@Instrumented
final class LW implements yn {
    @NonNull
    private com.huawei.location.crowdsourcing.upload.entity.yn FB = com.huawei.location.crowdsourcing.upload.entity.yn.f50083yn;
    private final Map<String, String> LW = new TreeMap();
    @Nullable
    private Vw Vw;
    private final File dC;
    @Nullable

    /* renamed from: yn  reason: collision with root package name */
    private Vw f50034yn;

    public LW(String str) {
        this.dC = new File(str + File.separator + "crowdsourcing_upload");
        FB();
    }

    private void FB() {
        Object obj;
        String e11 = Config.FB.f50027yn.e();
        if (!e11.isEmpty()) {
            LogConsole.i("Uploader", "read patch policy");
            try {
                Gson instance = GsonUtil.getInstance();
                Class cls = com.huawei.location.crowdsourcing.upload.entity.yn.class;
                if (!(instance instanceof Gson)) {
                    obj = instance.fromJson(e11, cls);
                } else {
                    obj = GsonInstrumentation.fromJson(instance, e11, cls);
                }
                this.FB = (com.huawei.location.crowdsourcing.upload.entity.yn) obj;
            } catch (JsonSyntaxException unused) {
                LogConsole.e("Uploader", "read patch policy failed");
            }
        }
        if (this.FB == null) {
            this.FB = com.huawei.location.crowdsourcing.upload.entity.yn.f50083yn;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: com.huawei.location.crowdsourcing.upload.entity.FB} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01c0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void LW() {
        /*
            r18 = this;
            r0 = r18
            java.io.File r1 = r0.dC
            java.io.File[] r1 = r1.listFiles()
            java.lang.String r2 = "Uploader"
            if (r1 != 0) goto L_0x0012
            java.lang.String r1 = "upload folder not valid"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r1)
            return
        L_0x0012:
            int r3 = r1.length
            if (r3 != 0) goto L_0x001b
            java.lang.String r1 = "files length is 0"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r1)
            return
        L_0x001b:
            android.content.Context r3 = com.huawei.location.crowdsourcing.Vw.b()
            java.lang.String r4 = "connectivity"
            java.lang.Object r3 = r3.getSystemService(r4)
            boolean r4 = r3 instanceof android.net.ConnectivityManager
            r6 = 0
            if (r4 != 0) goto L_0x0031
            java.lang.String r3 = "not get CONNECTIVITY_SERVICE, treat as connected"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r3)
        L_0x002f:
            r3 = 1
            goto L_0x0041
        L_0x0031:
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3
            android.net.NetworkInfo r3 = r3.getActiveNetworkInfo()
            if (r3 == 0) goto L_0x0040
            boolean r3 = r3.isConnectedOrConnecting()
            if (r3 == 0) goto L_0x0040
            goto L_0x002f
        L_0x0040:
            r3 = r6
        L_0x0041:
            if (r3 != 0) goto L_0x0049
            java.lang.String r1 = "network not available"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r1)
            return
        L_0x0049:
            int r3 = r1.length
            r4 = r6
        L_0x004b:
            if (r4 >= r3) goto L_0x01d7
            r7 = r1[r4]
            java.lang.String r14 = r7.getCanonicalPath()     // Catch:{ IOException -> 0x01d0 }
            android.content.Context r8 = com.huawei.location.crowdsourcing.Vw.b()
            java.lang.String r8 = com.huawei.location.crowdsourcing.common.util.dC.Vw(r8)
            java.util.Map<java.lang.String, java.lang.String> r9 = r0.LW
            java.lang.String r10 = "countryCode"
            java.lang.Object r9 = r9.get(r10)
            java.lang.String r9 = (java.lang.String) r9
            boolean r9 = android.text.TextUtils.equals(r9, r8)
            if (r9 == 0) goto L_0x006d
            r8 = r6
            goto L_0x0087
        L_0x006d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = "update mcc:"
            r9.append(r11)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            com.huawei.location.lite.common.log.LogConsole.d(r2, r9)
            java.util.Map<java.lang.String, java.lang.String> r9 = r0.LW
            r9.put(r10, r8)
            r8 = 1
        L_0x0087:
            r15 = 0
            if (r8 == 0) goto L_0x008c
            r0.f50034yn = r15
        L_0x008c:
            com.huawei.location.crowdsourcing.upload.entity.Vw r8 = r0.f50034yn
            if (r8 != 0) goto L_0x00f1
            r0.Vw = r15
            java.lang.String r8 = "get log server"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r8)
            java.lang.String r9 = "LOGSERVERROUTE"
            java.lang.String r9 = com.huawei.location.lite.common.grs.LocationNlpGrsHelper.getGrsHostAddress(r9)
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            if (r10 == 0) goto L_0x00aa
            java.lang.String r9 = "not get log server domain"
        L_0x00a5:
            com.huawei.location.lite.common.log.LogConsole.e(r2, r9)
        L_0x00a8:
            r10 = r15
            goto L_0x00e4
        L_0x00aa:
            android.net.Uri r9 = android.net.Uri.parse(r9)
            java.lang.String r10 = r9.getScheme()
            if (r10 == 0) goto L_0x00de
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r10 = r10.toLowerCase(r11)
            java.lang.String r11 = "https"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x00c3
            goto L_0x00de
        L_0x00c3:
            java.lang.String r9 = r9.getAuthority()
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            if (r10 == 0) goto L_0x00d0
            java.lang.String r9 = "not get domain"
            goto L_0x00a5
        L_0x00d0:
            com.huawei.location.crowdsourcing.upload.entity.Vw r10 = new com.huawei.location.crowdsourcing.upload.entity.Vw
            com.huawei.location.crowdsourcing.Config r11 = com.huawei.location.crowdsourcing.Config.FB.f50027yn
            java.lang.String r11 = r11.g()
            r10.<init>(r9, r11)
            goto L_0x00e4
        L_0x00de:
            java.lang.String r9 = "not https"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r9)
            goto L_0x00a8
        L_0x00e4:
            r0.f50034yn = r10
            if (r10 != 0) goto L_0x00ee
            java.lang.String r8 = "not get log server"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r8)
            goto L_0x010d
        L_0x00ee:
            com.huawei.location.lite.common.log.LogConsole.i(r2, r8)
        L_0x00f1:
            com.huawei.location.crowdsourcing.upload.entity.Vw r8 = r0.Vw
            if (r8 != 0) goto L_0x0115
            com.huawei.location.crowdsourcing.upload.entity.Vw r8 = r0.f50034yn
            com.huawei.location.crowdsourcing.upload.yn r9 = new com.huawei.location.crowdsourcing.upload.yn
            r9.<init>()
            java.util.Map<java.lang.String, java.lang.String> r10 = r0.LW
            java.lang.String r11 = "1063"
            com.huawei.location.crowdsourcing.upload.entity.Vw r8 = r9.yn(r8, r10, r11)
            r0.Vw = r8
            if (r8 != 0) goto L_0x0110
            java.lang.String r8 = "not get server domain"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r8)
        L_0x010d:
            r5 = r6
            goto L_0x01be
        L_0x0110:
            java.lang.String r8 = "got server domain"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r8)
        L_0x0115:
            com.huawei.location.crowdsourcing.upload.entity.Vw r9 = r0.Vw
            com.huawei.location.crowdsourcing.upload.entity.yn r8 = r0.FB
            java.lang.String r13 = r8.FB()
            com.huawei.location.crowdsourcing.upload.Vw r8 = new com.huawei.location.crowdsourcing.upload.Vw
            r8.<init>()
            java.util.Map<java.lang.String, java.lang.String> r11 = r0.LW
            com.huawei.location.crowdsourcing.upload.entity.yn r12 = r0.FB
            java.lang.String r16 = "1063"
            r10 = r14
            r17 = r12
            r12 = r16
            r5 = r13
            r13 = r17
            android.util.Pair r8 = r8.yn(r9, r10, r11, r12, r13)
            if (r8 != 0) goto L_0x0137
            goto L_0x016b
        L_0x0137:
            java.lang.Object r9 = r8.first
            com.huawei.location.crowdsourcing.upload.entity.yn r9 = (com.huawei.location.crowdsourcing.upload.entity.yn) r9
            r0.FB = r9
            java.lang.String r9 = r9.FB()
            boolean r5 = android.text.TextUtils.equals(r9, r5)
            if (r5 != 0) goto L_0x0166
            java.lang.String r5 = "save policy"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r5)
            com.huawei.location.crowdsourcing.upload.entity.yn r5 = r0.FB
            com.huawei.location.crowdsourcing.Config r9 = com.huawei.location.crowdsourcing.Config.FB.f50027yn
            com.google.gson.Gson r10 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            boolean r11 = r10 instanceof com.google.gson.Gson
            if (r11 != 0) goto L_0x015f
            java.lang.String r5 = r10.toJson((java.lang.Object) r5)
            goto L_0x0163
        L_0x015f:
            java.lang.String r5 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.toJson((com.google.gson.Gson) r10, (java.lang.Object) r5)
        L_0x0163:
            r9.j(r5)
        L_0x0166:
            java.lang.Object r5 = r8.second
            r15 = r5
            com.huawei.location.crowdsourcing.upload.entity.FB r15 = (com.huawei.location.crowdsourcing.upload.entity.FB) r15
        L_0x016b:
            if (r15 != 0) goto L_0x0173
            java.lang.String r5 = "not get upload info"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r5)
            goto L_0x010d
        L_0x0173:
            java.lang.String r5 = "got upload info"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r5)
            java.util.List<com.huawei.location.crowdsourcing.upload.entity.FB$yn> r5 = r15.FB
            com.huawei.location.crowdsourcing.upload.LW r8 = new com.huawei.location.crowdsourcing.upload.LW
            r8.<init>()
            boolean r5 = r8.yn(r5, r14)
            if (r5 != 0) goto L_0x018b
            java.lang.String r5 = "upload file failed"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r5)
            goto L_0x010d
        L_0x018b:
            java.lang.String r5 = "upload file"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r5)
            com.huawei.location.crowdsourcing.upload.entity.Vw r10 = r0.Vw
            java.lang.String r12 = r15.f50080yn
            java.lang.String r13 = r15.Vw
            if (r12 == 0) goto L_0x01a9
            if (r13 != 0) goto L_0x019b
            goto L_0x01a9
        L_0x019b:
            com.huawei.location.crowdsourcing.upload.FB r8 = new com.huawei.location.crowdsourcing.upload.FB
            r8.<init>()
            java.util.Map<java.lang.String, java.lang.String> r9 = r0.LW
            java.lang.String r11 = "1063"
            boolean r5 = r8.yn(r9, r10, r11, r12, r13)
            goto L_0x01af
        L_0x01a9:
            java.lang.String r5 = "param check failed"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r5)
            r5 = r6
        L_0x01af:
            if (r5 != 0) goto L_0x01b8
            java.lang.String r5 = "notify success failed"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r5)
            goto L_0x010d
        L_0x01b8:
            java.lang.String r5 = "notify success finish"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r5)
            r5 = 1
        L_0x01be:
            if (r5 != 0) goto L_0x01c3
            java.lang.String r1 = "upload cloud failed"
            goto L_0x01d2
        L_0x01c3:
            boolean r5 = r7.delete()
            if (r5 != 0) goto L_0x01cc
            java.lang.String r1 = "delete file failed"
            goto L_0x01d2
        L_0x01cc:
            int r4 = r4 + 1
            goto L_0x004b
        L_0x01d0:
            java.lang.String r1 = "get path failed"
        L_0x01d2:
            com.huawei.location.lite.common.log.LogConsole.e(r2, r1)
            r5 = r6
            goto L_0x01d8
        L_0x01d7:
            r5 = 1
        L_0x01d8:
            if (r5 != 0) goto L_0x01e2
            com.huawei.location.crowdsourcing.Config r1 = com.huawei.location.crowdsourcing.Config.FB.f50027yn
            r1.r()
            return
        L_0x01e2:
            java.lang.String r1 = "upload cloud success"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r1)
            com.huawei.location.crowdsourcing.Config r1 = com.huawei.location.crowdsourcing.Config.FB.f50027yn
            r1.s()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.LW.LW():void");
    }

    private static String yn(String str) {
        return str.replaceAll("[^a-zA-Z0-9().]", SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cb, code lost:
        r12 = "AesGcm.decrypt Exception";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f9, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00fe, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r12.addSuppressed(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0103, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0108, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x010d, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        r12.addSuppressed(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0112, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0117, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x011c, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        r12.addSuppressed(r14);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:54:0x00eb, B:63:0x00f8, B:66:0x00fa] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:56:0x00ee, B:75:0x0107, B:78:0x0109] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:58:0x00f1, B:87:0x0116, B:90:0x0118] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean yn(byte[] r12, java.lang.String r13, java.lang.String r14) {
        /*
            r11 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r13)
            java.io.File r13 = new java.io.File
            r13.<init>(r14)
            r14 = 16
            byte[] r14 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(r14)
            java.lang.String r1 = com.huawei.location.crowdsourcing.Config.t()
            byte[] r1 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(r1)
            java.lang.String r2 = com.huawei.location.crowdsourcing.Config.t()
            byte[] r2 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(r2)
            com.huawei.location.crowdsourcing.Config r3 = com.huawei.location.crowdsourcing.Config.FB.f50027yn
            java.lang.String r3 = r3.p()
            java.security.interfaces.RSAPublicKey r3 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.getPublicKey(r3)
            byte[] r2 = com.huawei.secure.android.common.encrypt.rsa.RSAEncrypt.encrypt((byte[]) r2, (java.security.PublicKey) r3)
            r3 = 1
            r4 = 0
            java.lang.String r5 = "Uploader"
            if (r2 == 0) goto L_0x0047
            int r6 = r2.length
            r7 = 384(0x180, float:5.38E-43)
            if (r6 == r7) goto L_0x003c
            goto L_0x0047
        L_0x003c:
            if (r1 == 0) goto L_0x0044
            int r6 = r1.length
            if (r6 != 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r6 = r3
            goto L_0x004d
        L_0x0044:
            java.lang.String r6 = "store get aes key error"
            goto L_0x0049
        L_0x0047:
            java.lang.String r6 = "encrypt key get error"
        L_0x0049:
            com.huawei.location.lite.common.log.LogConsole.e(r5, r6)
            r6 = r4
        L_0x004d:
            if (r6 != 0) goto L_0x0050
            return r4
        L_0x0050:
            javax.crypto.Cipher r6 = com.huawei.secure.android.common.encrypt.aes.CipherUtil.getAesGcmEncryptCipher(r1, r14)
            if (r6 != 0) goto L_0x005c
            java.lang.String r12 = "get cipher failed"
            com.huawei.location.lite.common.log.LogConsole.e(r5, r12)
            return r4
        L_0x005c:
            java.lang.String r7 = "get cipher success. file"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r7)
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0125, IOException -> 0x0121 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0125, IOException -> 0x0121 }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0125, IOException -> 0x0121 }
            r9.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0125, IOException -> 0x0121 }
            java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ FileNotFoundException -> 0x0125, IOException -> 0x0121 }
            r8.<init>(r9, r10)     // Catch:{ FileNotFoundException -> 0x0125, IOException -> 0x0121 }
            r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0125, IOException -> 0x0121 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x0114 }
            r8.<init>(r13)     // Catch:{ all -> 0x0114 }
            java.util.zip.ZipOutputStream r13 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x0105 }
            javax.crypto.CipherOutputStream r9 = new javax.crypto.CipherOutputStream     // Catch:{ all -> 0x0105 }
            r9.<init>(r8, r6)     // Catch:{ all -> 0x0105 }
            r13.<init>(r9)     // Catch:{ all -> 0x0105 }
            r8.write(r2)     // Catch:{ all -> 0x00f6 }
            r8.write(r14)     // Catch:{ all -> 0x00f6 }
            java.util.zip.ZipEntry r14 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x00f6 }
            java.lang.String r2 = r0.getName()     // Catch:{ all -> 0x00f6 }
            r14.<init>(r2)     // Catch:{ all -> 0x00f6 }
            r13.putNextEntry(r14)     // Catch:{ all -> 0x00f6 }
            r13.write(r12)     // Catch:{ all -> 0x00f6 }
            java.lang.String r12 = java.lang.System.lineSeparator()     // Catch:{ all -> 0x00f6 }
            byte[] r12 = com.huawei.hms.framework.common.StringUtils.getBytes((java.lang.String) r12)     // Catch:{ all -> 0x00f6 }
            r13.write(r12)     // Catch:{ all -> 0x00f6 }
        L_0x00a1:
            java.lang.String r12 = r7.readLine()     // Catch:{ all -> 0x00f6 }
            if (r12 == 0) goto L_0x00d6
            byte[] r12 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(r12)     // Catch:{ all -> 0x00f6 }
            if (r12 == 0) goto L_0x00d1
            int r14 = r12.length     // Catch:{ all -> 0x00f6 }
            if (r14 > 0) goto L_0x00b1
            goto L_0x00d1
        L_0x00b1:
            byte[] r12 = com.huawei.secure.android.common.encrypt.aes.AesGcm.decrypt((byte[]) r12, (byte[]) r1)     // Catch:{ all -> 0x00f6 }
            if (r12 == 0) goto L_0x00cb
            int r14 = r12.length     // Catch:{ all -> 0x00f6 }
            if (r14 != 0) goto L_0x00bb
            goto L_0x00cb
        L_0x00bb:
            int r14 = r12.length     // Catch:{ all -> 0x00f6 }
            r13.write(r12, r4, r14)     // Catch:{ all -> 0x00f6 }
            java.lang.String r12 = java.lang.System.lineSeparator()     // Catch:{ all -> 0x00f6 }
            byte[] r12 = com.huawei.hms.framework.common.StringUtils.getBytes((java.lang.String) r12)     // Catch:{ all -> 0x00f6 }
            r13.write(r12)     // Catch:{ all -> 0x00f6 }
            goto L_0x00a1
        L_0x00cb:
            java.lang.String r12 = "AesGcm.decrypt Exception"
        L_0x00cd:
            com.huawei.location.lite.common.log.LogConsole.e(r5, r12)     // Catch:{ all -> 0x00f6 }
            goto L_0x00d4
        L_0x00d1:
            java.lang.String r12 = "HexUtil.hexStr2ByteArray Exception"
            goto L_0x00cd
        L_0x00d4:
            r12 = r4
            goto L_0x00d7
        L_0x00d6:
            r12 = r3
        L_0x00d7:
            r12 = r12 ^ r3
            r13.finish()     // Catch:{ all -> 0x00f6 }
            if (r12 != 0) goto L_0x00e5
            java.lang.String r14 = "compress success"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r14)     // Catch:{ all -> 0x00e3 }
            goto L_0x00eb
        L_0x00e3:
            r12 = move-exception
            goto L_0x00f8
        L_0x00e5:
            java.lang.String r14 = "compress error, key or file has been illegal changed!"
            com.huawei.location.lite.common.log.LogConsole.e(r5, r14)     // Catch:{ all -> 0x00f6 }
            r3 = r4
        L_0x00eb:
            r13.close()     // Catch:{ all -> 0x0103 }
            r8.close()     // Catch:{ all -> 0x0112 }
            r7.close()     // Catch:{ FileNotFoundException -> 0x0126, IOException -> 0x0122 }
            r4 = r12
            goto L_0x012b
        L_0x00f6:
            r12 = move-exception
            r3 = r4
        L_0x00f8:
            throw r12     // Catch:{ all -> 0x00f9 }
        L_0x00f9:
            r14 = move-exception
            r13.close()     // Catch:{ all -> 0x00fe }
            goto L_0x0102
        L_0x00fe:
            r13 = move-exception
            r12.addSuppressed(r13)     // Catch:{ all -> 0x0103 }
        L_0x0102:
            throw r14     // Catch:{ all -> 0x0103 }
        L_0x0103:
            r12 = move-exception
            goto L_0x0107
        L_0x0105:
            r12 = move-exception
            r3 = r4
        L_0x0107:
            throw r12     // Catch:{ all -> 0x0108 }
        L_0x0108:
            r13 = move-exception
            r8.close()     // Catch:{ all -> 0x010d }
            goto L_0x0111
        L_0x010d:
            r14 = move-exception
            r12.addSuppressed(r14)     // Catch:{ all -> 0x0112 }
        L_0x0111:
            throw r13     // Catch:{ all -> 0x0112 }
        L_0x0112:
            r12 = move-exception
            goto L_0x0116
        L_0x0114:
            r12 = move-exception
            r3 = r4
        L_0x0116:
            throw r12     // Catch:{ all -> 0x0117 }
        L_0x0117:
            r13 = move-exception
            r7.close()     // Catch:{ all -> 0x011c }
            goto L_0x0120
        L_0x011c:
            r14 = move-exception
            r12.addSuppressed(r14)     // Catch:{ FileNotFoundException -> 0x0126, IOException -> 0x0122 }
        L_0x0120:
            throw r13     // Catch:{ FileNotFoundException -> 0x0126, IOException -> 0x0122 }
        L_0x0121:
            r3 = r4
        L_0x0122:
            java.lang.String r12 = "compress IOException"
            goto L_0x0128
        L_0x0125:
            r3 = r4
        L_0x0126:
            java.lang.String r12 = "compress FileNotFoundException"
        L_0x0128:
            com.huawei.location.lite.common.log.LogConsole.e(r5, r12)
        L_0x012b:
            if (r4 == 0) goto L_0x0130
            r0.delete()
        L_0x0130:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.LW.yn(byte[], java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a() {
        /*
            r5 = this;
            java.io.File r0 = r5.dC
            boolean r1 = r0.exists()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0028
            boolean r1 = r0.isDirectory()
            java.lang.String r4 = "FileUtil"
            if (r1 != 0) goto L_0x001b
            boolean r0 = r0.delete()
            if (r0 != 0) goto L_0x0028
            java.lang.String r0 = "folder delete failed"
            goto L_0x0023
        L_0x001b:
            boolean r0 = r0.canWrite()
            if (r0 != 0) goto L_0x0028
            java.lang.String r0 = "folder can not write"
        L_0x0023:
            com.huawei.location.lite.common.log.LogConsole.e(r4, r0)
            r0 = r3
            goto L_0x0029
        L_0x0028:
            r0 = r2
        L_0x0029:
            java.lang.String r1 = "Uploader"
            if (r0 != 0) goto L_0x0033
            java.lang.String r0 = "regularize folder failed"
        L_0x002f:
            com.huawei.location.lite.common.log.LogConsole.e(r1, r0)
            return r3
        L_0x0033:
            java.io.File r0 = r5.dC
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0046
            java.io.File r0 = r5.dC
            boolean r0 = r0.mkdir()
            if (r0 != 0) goto L_0x0046
            java.lang.String r0 = "create folder failed"
            goto L_0x002f
        L_0x0046:
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.LW
            com.huawei.location.crowdsourcing.Config r1 = com.huawei.location.crowdsourcing.Config.FB.f50027yn
            java.lang.String r1 = r1.l()
            java.lang.String r3 = "shaSN"
            r0.put(r3, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.LW
            java.lang.String r1 = android.os.Build.PRODUCT
            java.lang.String r3 = "model"
            r0.put(r3, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.LW
            java.lang.String r1 = com.huawei.location.lite.common.util.SystemPropertiesUtil.getVersion()
            java.lang.String r3 = "romVersion"
            r0.put(r3, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.LW
            java.lang.String r1 = com.huawei.location.lite.common.util.SystemPropertiesUtil.getEMUIVersion()
            java.lang.String r3 = "emuiVersion"
            r0.put(r3, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.LW
            java.lang.String r1 = com.huawei.location.lite.common.util.SystemPropertiesUtil.getAndroidVersion()
            java.lang.String r3 = "osVersion"
            r0.put(r3, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.LW.a():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x01d9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(@androidx.annotation.NonNull java.lang.String r15) {
        /*
            r14 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "packageName is "
            r0.append(r1)
            android.content.Context r1 = com.huawei.location.crowdsourcing.Vw.b()
            java.lang.String r1 = r1.getPackageName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Uploader"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r0)
            com.huawei.location.crowdsourcing.Config r0 = com.huawei.location.crowdsourcing.Config.FB.f50027yn
            boolean r0 = r0.c()
            r2 = 0
            if (r0 != 0) goto L_0x002f
            java.lang.String r15 = "not reach upload interval"
            com.huawei.location.lite.common.log.LogConsole.d(r1, r15)
            return r2
        L_0x002f:
            java.lang.String r0 = "start upload"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r0)
            java.io.File r0 = r14.dC
            boolean r0 = r0.isDirectory()
            if (r0 != 0) goto L_0x0042
            java.lang.String r15 = "not folder"
            com.huawei.location.lite.common.log.LogConsole.e(r1, r15)
            return r2
        L_0x0042:
            java.io.File r0 = r14.dC
            java.io.File[] r0 = r0.listFiles()
            java.lang.String r3 = "upload folder not valid"
            if (r0 != 0) goto L_0x0050
            com.huawei.location.lite.common.log.LogConsole.e(r1, r3)
            goto L_0x0098
        L_0x0050:
            int r4 = r0.length
            r5 = r2
        L_0x0052:
            if (r5 >= r4) goto L_0x0098
            r6 = r0[r5]
            boolean r7 = r6.isFile()
            if (r7 != 0) goto L_0x006b
            boolean r6 = r6.delete()
            if (r6 == 0) goto L_0x0065
            java.lang.String r6 = "delete invalid success"
            goto L_0x0067
        L_0x0065:
            java.lang.String r6 = "delete invalid failed"
        L_0x0067:
            com.huawei.location.lite.common.log.LogConsole.e(r1, r6)
            goto L_0x0095
        L_0x006b:
            long r7 = r6.lastModified()
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r7
            long r7 = java.lang.Math.abs(r9)
            com.huawei.location.crowdsourcing.Config unused = com.huawei.location.crowdsourcing.Config.FB.f50027yn
            r9 = 2592000000(0x9a7ec800, double:1.280618154E-314)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L_0x0095
            boolean r6 = r6.delete()
            if (r6 == 0) goto L_0x0090
            java.lang.String r6 = "delete expired success"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r6)
            goto L_0x0095
        L_0x0090:
            java.lang.String r6 = "delete expired failed"
            com.huawei.location.lite.common.log.LogConsole.e(r1, r6)
        L_0x0095:
            int r5 = r5 + 1
            goto L_0x0052
        L_0x0098:
            r14.LW()
            java.lang.String r0 = "first upload end"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r0)
            java.io.File r0 = r14.dC
            java.lang.String[] r0 = r0.list()
            r4 = 1
            if (r0 != 0) goto L_0x00af
            com.huawei.location.lite.common.log.LogConsole.e(r1, r3)
        L_0x00ac:
            r15 = r2
            goto L_0x01d7
        L_0x00af:
            int r0 = r0.length
            if (r0 == 0) goto L_0x00b8
            java.lang.String r15 = "upload folder not empty, can not compress"
            com.huawei.location.lite.common.log.LogConsole.e(r1, r15)
            goto L_0x00ac
        L_0x00b8:
            java.io.File r0 = r14.dC     // Catch:{ IOException -> 0x01d0 }
            java.lang.String r0 = r0.getCanonicalPath()     // Catch:{ IOException -> 0x01d0 }
            java.util.UUID r3 = java.util.UUID.randomUUID()
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.lang.String r0 = java.io.File.separator
            r5.append(r0)
            java.lang.String r0 = android.os.Build.PRODUCT
            java.lang.String r6 = yn(r0)
            java.lang.String r7 = com.huawei.location.lite.common.util.SystemPropertiesUtil.getVersion()
            java.lang.String r7 = yn(r7)
            java.util.Locale r8 = java.util.Locale.ENGLISH
            r9 = 4
            java.lang.Object[] r9 = new java.lang.Object[r9]
            r9[r2] = r6
            r9[r4] = r7
            r6 = 2
            r9[r6] = r3
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat
            java.util.Locale r7 = java.util.Locale.US
            java.lang.String r10 = "yyyyMMddHHmmssSSS"
            r6.<init>(r10, r7)
            java.util.Date r7 = new java.util.Date
            long r10 = java.lang.System.currentTimeMillis()
            r7.<init>(r10)
            java.lang.String r6 = r6.format(r7)
            r7 = 3
            r9[r7] = r6
            java.lang.String r6 = "%s_%s_%s_%s.zip"
            java.lang.String r6 = java.lang.String.format(r8, r6, r9)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r6 = 13
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r7 = 10
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r0 = yn(r0)
            java.lang.String r8 = com.huawei.location.lite.common.util.SystemPropertiesUtil.getVersion()
            java.lang.String r8 = yn(r8)
            android.content.Context r9 = com.huawei.location.crowdsourcing.Vw.b()
            java.lang.String r9 = r9.getPackageName()
            java.lang.String r10 = com.huawei.location.lite.common.util.ROMUtil.getEmuiVerName()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 == 0) goto L_0x013f
            java.lang.String r10 = android.os.Build.VERSION.RELEASE
        L_0x013f:
            if (r10 != 0) goto L_0x0143
            java.lang.String r10 = ""
        L_0x0143:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = android.os.Build.BRAND
            r11.append(r12)
            java.lang.String r12 = " "
            r11.append(r12)
            java.lang.String r12 = android.os.Build.MODEL
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "{\"LogVersion\":\"002\",\"LogSubversion\":\"101\",\"ProductName\":\""
            r12.append(r13)
            r12.append(r0)
            java.lang.String r0 = "\",\"ProductVersion\":\""
            r12.append(r0)
            r12.append(r8)
            java.lang.String r0 = "\",\"hms\":\"true\",\"S1\":\""
            r12.append(r0)
            r12.append(r3)
            java.lang.String r0 = "\",\"VERSION\":\""
            r12.append(r0)
            java.lang.String r0 = com.huawei.location.lite.common.util.APKUtil.getVersionName()
            r12.append(r0)
            java.lang.String r0 = "\",\"PVer\":\"\",\"package_name\":\""
            r12.append(r0)
            r12.append(r9)
            java.lang.String r0 = "\",\"Os_version\":\""
            r12.append(r0)
            r12.append(r10)
            java.lang.String r0 = "\",\"Product_info\":\""
            r12.append(r0)
            r12.append(r11)
            java.lang.String r0 = "\"}"
            r12.append(r0)
            r12.append(r6)
            r12.append(r7)
            java.lang.String r0 = r12.toString()
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r0 = r0.getBytes(r3)
            boolean r15 = r14.yn(r0, r15, r5)
            if (r15 != 0) goto L_0x01ce
            java.lang.String r15 = "compress file failed"
            com.huawei.location.lite.common.log.LogConsole.e(r1, r15)
            java.io.File r15 = new java.io.File
            r15.<init>(r5)
            boolean r15 = r15.delete()
            if (r15 == 0) goto L_0x00ac
            java.lang.String r15 = "delete failed file success"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r15)
            goto L_0x00ac
        L_0x01ce:
            r15 = r4
            goto L_0x01d7
        L_0x01d0:
            java.lang.String r15 = "get path failed"
            com.huawei.location.lite.common.log.LogConsole.e(r1, r15)
            goto L_0x00ac
        L_0x01d7:
            if (r15 != 0) goto L_0x01da
            return r2
        L_0x01da:
            r14.LW()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.LW.b(java.lang.String):boolean");
    }

    public void yn() {
        LogConsole.w("Uploader", "Stop");
    }
}
