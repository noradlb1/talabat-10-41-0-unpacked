package com.huawei.location.crowdsourcing.upload;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class Vw {

    /* renamed from: com.huawei.location.crowdsourcing.upload.Vw$Vw  reason: collision with other inner class name */
    public static class C0079Vw extends com.huawei.location.crowdsourcing.upload.http.yn {
        @SerializedName("reason")

        /* renamed from: a  reason: collision with root package name */
        String f50067a = "";
        @SerializedName("resCode")

        /* renamed from: b  reason: collision with root package name */
        int f50068b = -1;
        @SerializedName("fileUniqueFlag")

        /* renamed from: c  reason: collision with root package name */
        String f50069c = "";
        @SerializedName("currentTime")

        /* renamed from: d  reason: collision with root package name */
        String f50070d = "";
        @SerializedName("uploadInfoList")

        /* renamed from: e  reason: collision with root package name */
        List<yn> f50071e = new ArrayList();
        @SerializedName("patchPolicyList")

        /* renamed from: f  reason: collision with root package name */
        com.huawei.location.crowdsourcing.upload.entity.yn f50072f;

        /* renamed from: com.huawei.location.crowdsourcing.upload.Vw$Vw$yn */
        public static class yn {
            @SerializedName("uploadUrl")

            /* renamed from: a  reason: collision with root package name */
            String f50073a = "";
            @SerializedName("method")

            /* renamed from: b  reason: collision with root package name */
            String f50074b = "";
            @SerializedName("objectId")

            /* renamed from: c  reason: collision with root package name */
            String f50075c = "";
            @SerializedName("headers")

            /* renamed from: d  reason: collision with root package name */
            Map<String, String> f50076d = new HashMap();

            public String toString() {
                return "UploadInfo{method='" + this.f50074b + AbstractJsonLexerKt.END_OBJ;
            }
        }

        private C0079Vw() {
        }

        public String toString() {
            return "Resp{reason='" + this.f50067a + '\'' + ", resCode='" + this.f50068b + '\'' + ", fileUniqueFlag='" + this.f50069c + '\'' + ", currentTime='" + this.f50070d + '\'' + ", uploadInfoList=" + this.f50071e + ", patchPolicyList=" + this.f50072f + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static class yn {
        @SerializedName("fileMd5")

        /* renamed from: a  reason: collision with root package name */
        final String f50077a = "";
        @SerializedName("fileSha256")

        /* renamed from: b  reason: collision with root package name */
        final String f50078b;
        @SerializedName("fileSize")

        /* renamed from: c  reason: collision with root package name */
        final long f50079c;

        public yn(String str, long j11) {
            this.f50078b = str;
            this.f50079c = j11;
        }
    }

    private static long yn(com.huawei.location.crowdsourcing.upload.entity.yn ynVar, long j11) {
        long Vw = ynVar.Vw();
        long ceil = (long) Math.ceil(((double) j11) / ((double) ynVar.yn()));
        return ceil > ynVar.Vw() ? ceil : Vw;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0057 A[EDGE_INSN: B:35:0x0057->B:36:? ?: BREAK  , SYNTHETIC, Splitter:B:35:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005b A[SYNTHETIC, Splitter:B:37:0x005b] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.huawei.location.crowdsourcing.upload.Vw.yn> yn(java.io.File r13, long r14) {
        /*
            java.lang.String r0 = "GetUploadInfo"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x006a }
            r2.<init>(r13)     // Catch:{ IOException -> 0x006a }
        L_0x000c:
            r13 = 0
            java.lang.String r3 = "SHA-256"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0052 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r4]     // Catch:{ all -> 0x0050 }
            r6 = r14
        L_0x0018:
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x003b
            long r10 = (long) r4
            int r10 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x0025
            int r10 = (int) r6
            goto L_0x0026
        L_0x0025:
            r10 = r4
        L_0x0026:
            r11 = 0
            int r10 = r2.read(r5, r11, r10)     // Catch:{ IOException -> 0x0035 }
            r12 = -1
            if (r10 != r12) goto L_0x002f
            goto L_0x003b
        L_0x002f:
            r3.update(r5, r11, r10)     // Catch:{ all -> 0x0050 }
            long r8 = (long) r10     // Catch:{ all -> 0x0050 }
            long r6 = r6 - r8
            goto L_0x0018
        L_0x0035:
            java.lang.String r3 = "read file error"
        L_0x0037:
            com.huawei.location.lite.common.log.LogConsole.e(r0, r3)     // Catch:{ all -> 0x0050 }
            goto L_0x0055
        L_0x003b:
            long r4 = r14 - r6
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x0042
            goto L_0x0055
        L_0x0042:
            com.huawei.location.crowdsourcing.upload.Vw$yn r13 = new com.huawei.location.crowdsourcing.upload.Vw$yn     // Catch:{ all -> 0x0050 }
            byte[] r3 = r3.digest()     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = com.huawei.secure.android.common.util.HexUtil.byteArray2HexStr((byte[]) r3)     // Catch:{ all -> 0x0050 }
            r13.<init>(r3, r4)     // Catch:{ all -> 0x0050 }
            goto L_0x0055
        L_0x0050:
            r13 = move-exception
            goto L_0x005f
        L_0x0052:
            java.lang.String r3 = "NoSuchAlgorithmException SHA-256"
            goto L_0x0037
        L_0x0055:
            if (r13 != 0) goto L_0x005b
            r2.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006f
        L_0x005b:
            r1.add(r13)     // Catch:{ all -> 0x0050 }
            goto L_0x000c
        L_0x005f:
            throw r13     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r14 = move-exception
            r2.close()     // Catch:{ all -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r15 = move-exception
            r13.addSuppressed(r15)     // Catch:{ IOException -> 0x006a }
        L_0x0069:
            throw r14     // Catch:{ IOException -> 0x006a }
        L_0x006a:
            java.lang.String r13 = "IOException"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r13)
        L_0x006f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.upload.Vw.yn(java.io.File, long):java.util.List");
    }

    /* JADX WARNING: type inference failed for: r2v19, types: [com.huawei.location.crowdsourcing.upload.http.yn] */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<com.huawei.location.crowdsourcing.upload.entity.yn, com.huawei.location.crowdsourcing.upload.entity.FB> yn(@androidx.annotation.NonNull com.huawei.location.crowdsourcing.upload.entity.Vw r18, @androidx.annotation.NonNull java.lang.String r19, java.util.Map<java.lang.String, java.lang.String> r20, @androidx.annotation.NonNull java.lang.String r21, com.huawei.location.crowdsourcing.upload.entity.yn r22) {
        /*
            r17 = this;
            r0 = r18
            r1 = r21
            java.io.File r2 = new java.io.File
            r3 = r19
            r2.<init>(r3)
            boolean r3 = r2.exists()
            java.lang.String r4 = "GetUploadInfo"
            r5 = 0
            if (r3 != 0) goto L_0x001a
            java.lang.String r0 = "file not exist"
            com.huawei.location.lite.common.log.LogConsole.e(r4, r0)
            return r5
        L_0x001a:
            long r6 = r2.length()
            com.huawei.location.crowdsourcing.upload.http.FB r3 = new com.huawei.location.crowdsourcing.upload.http.FB
            java.lang.String r8 = r0.f50082yn
            java.lang.String r9 = "/v2/getUploadInfo"
            r3.<init>(r8, r9)
            r8 = r20
            com.huawei.location.crowdsourcing.upload.http.FB r8 = r3.yn(r8)
            java.lang.String r9 = "logType"
            java.lang.String r10 = "0"
            com.huawei.location.crowdsourcing.upload.http.FB r8 = r8.FB(r9, r10)
            java.lang.String r9 = r2.getName()
            java.lang.String r11 = "fileName"
            com.huawei.location.crowdsourcing.upload.http.FB r8 = r8.FB(r11, r9)
            java.lang.String r9 = java.lang.String.valueOf(r6)
            java.lang.String r11 = "fileSize"
            com.huawei.location.crowdsourcing.upload.http.FB r8 = r8.FB(r11, r9)
            java.lang.String r9 = "encryptKey"
            com.huawei.location.crowdsourcing.upload.http.FB r8 = r8.FB(r9, r10)
            java.lang.String r9 = "others"
            com.huawei.location.crowdsourcing.upload.http.FB r8 = r8.FB(r9, r9)
            java.lang.String r0 = r0.Vw
            com.huawei.location.crowdsourcing.upload.http.FB r0 = r8.dC(r0, r1)
            java.lang.String r8 = "appID"
            r0.Vw(r8, r1)
            r0 = r22
            long r8 = yn((com.huawei.location.crowdsourcing.upload.entity.yn) r0, (long) r6)
            java.util.List r1 = yn((java.io.File) r2, (long) r8)
            com.google.gson.Gson r10 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            java.lang.Class r11 = r1.getClass()
            com.google.gson.JsonElement r10 = r10.toJsonTree(r1, r11)
            com.google.gson.JsonArray r10 = r10.getAsJsonArray()
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = "fileHashList"
            com.huawei.location.crowdsourcing.upload.http.FB r10 = r3.LW(r11, r10)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r9 = "patchSize"
            com.huawei.location.crowdsourcing.upload.http.FB r8 = r10.FB(r9, r8)
            r10 = r1
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            int r10 = r10.size()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r12 = "patchNum"
            com.huawei.location.crowdsourcing.upload.http.FB r8 = r8.FB(r12, r10)
            java.lang.String r10 = r22.FB()
            java.lang.String r13 = "patchVer"
            com.huawei.location.crowdsourcing.upload.http.FB r8 = r8.FB(r13, r10)
            java.lang.Class<com.huawei.location.crowdsourcing.upload.Vw$Vw> r10 = com.huawei.location.crowdsourcing.upload.Vw.C0079Vw.class
            com.huawei.location.crowdsourcing.upload.http.yn r8 = r8.yn(r10)
            com.huawei.location.crowdsourcing.upload.Vw$Vw r8 = (com.huawei.location.crowdsourcing.upload.Vw.C0079Vw) r8
            if (r8 != 0) goto L_0x00b9
            java.lang.String r0 = "server return null"
            com.huawei.location.lite.common.log.LogConsole.e(r4, r0)
            return r5
        L_0x00b9:
            int r14 = r8.f50068b
            r15 = 200009(0x30d49, float:2.80272E-40)
            r16 = 0
            if (r14 != r15) goto L_0x00c4
            r14 = 1
            goto L_0x00c6
        L_0x00c4:
            r14 = r16
        L_0x00c6:
            if (r14 == 0) goto L_0x0120
            com.huawei.location.crowdsourcing.upload.entity.yn r0 = r8.f50072f
            if (r0 != 0) goto L_0x00d2
            java.lang.String r0 = "200009 without patchPolicy"
            com.huawei.location.lite.common.log.LogConsole.e(r4, r0)
            return r5
        L_0x00d2:
            long r6 = yn((com.huawei.location.crowdsourcing.upload.entity.yn) r0, (long) r6)
            java.util.List r1 = yn((java.io.File) r2, (long) r6)
            com.google.gson.Gson r2 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            java.lang.Class r8 = r1.getClass()
            com.google.gson.JsonElement r2 = r2.toJsonTree(r1, r8)
            com.google.gson.JsonArray r2 = r2.getAsJsonArray()
            java.lang.String r2 = r2.toString()
            com.huawei.location.crowdsourcing.upload.http.FB r2 = r3.LW(r11, r2)
            java.lang.String r3 = java.lang.String.valueOf(r6)
            com.huawei.location.crowdsourcing.upload.http.FB r2 = r2.FB(r9, r3)
            r3 = r1
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r3 = r3.size()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            com.huawei.location.crowdsourcing.upload.http.FB r2 = r2.FB(r12, r3)
            java.lang.String r3 = r0.FB()
            com.huawei.location.crowdsourcing.upload.http.FB r2 = r2.FB(r13, r3)
            com.huawei.location.crowdsourcing.upload.http.yn r2 = r2.yn(r10)
            r8 = r2
            com.huawei.location.crowdsourcing.upload.Vw$Vw r8 = (com.huawei.location.crowdsourcing.upload.Vw.C0079Vw) r8
            if (r8 != 0) goto L_0x0120
            java.lang.String r0 = "redo failed"
            com.huawei.location.lite.common.log.LogConsole.e(r4, r0)
            return r5
        L_0x0120:
            int r2 = r8.f50068b
            boolean r2 = com.huawei.location.activity.model.Vw.Vw((int) r2)
            if (r2 != 0) goto L_0x0143
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "server return not success. error info:"
            r0.append(r1)
            int r1 = r8.f50068b
            java.lang.String r1 = com.huawei.location.activity.model.Vw.yn((int) r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.huawei.location.lite.common.log.LogConsole.e(r4, r0)
            return r5
        L_0x0143:
            java.util.List<com.huawei.location.crowdsourcing.upload.Vw$Vw$yn> r2 = r8.f50071e
            if (r2 == 0) goto L_0x0198
            int r2 = r1.size()
            java.util.List<com.huawei.location.crowdsourcing.upload.Vw$Vw$yn> r3 = r8.f50071e
            int r3 = r3.size()
            if (r2 == r3) goto L_0x0154
            goto L_0x0198
        L_0x0154:
            java.lang.String r2 = r8.f50069c
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x015b
            r2 = r3
        L_0x015b:
            java.lang.String r4 = r8.f50070d
            if (r4 != 0) goto L_0x0160
            r4 = r3
        L_0x0160:
            com.huawei.location.crowdsourcing.upload.entity.FB r6 = new com.huawei.location.crowdsourcing.upload.entity.FB
            r6.<init>(r2, r4)
            r2 = r16
        L_0x0167:
            int r4 = r1.size()
            if (r2 >= r4) goto L_0x019e
            java.util.List<com.huawei.location.crowdsourcing.upload.Vw$Vw$yn> r4 = r8.f50071e
            java.lang.Object r4 = r4.get(r2)
            com.huawei.location.crowdsourcing.upload.Vw$Vw$yn r4 = (com.huawei.location.crowdsourcing.upload.Vw.C0079Vw.yn) r4
            java.lang.String r7 = r4.f50073a
            if (r7 != 0) goto L_0x017a
            r7 = r3
        L_0x017a:
            java.util.Map<java.lang.String, java.lang.String> r4 = r4.f50076d
            if (r4 != 0) goto L_0x0183
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
        L_0x0183:
            java.util.List<com.huawei.location.crowdsourcing.upload.entity.FB$yn> r9 = r6.FB
            com.huawei.location.crowdsourcing.upload.entity.FB$yn r10 = new com.huawei.location.crowdsourcing.upload.entity.FB$yn
            java.lang.Object r11 = r1.get(r2)
            com.huawei.location.crowdsourcing.upload.Vw$yn r11 = (com.huawei.location.crowdsourcing.upload.Vw.yn) r11
            long r11 = r11.f50079c
            r10.<init>(r7, r11, r4)
            r9.add(r10)
            int r2 = r2 + 1
            goto L_0x0167
        L_0x0198:
            java.lang.String r1 = "size diff"
            com.huawei.location.lite.common.log.LogConsole.e(r4, r1)
            r6 = r5
        L_0x019e:
            if (r6 != 0) goto L_0x01a1
            return r5
        L_0x01a1:
            android.util.Pair r1 = new android.util.Pair
            r1.<init>(r0, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.upload.Vw.yn(com.huawei.location.crowdsourcing.upload.entity.Vw, java.lang.String, java.util.Map, java.lang.String, com.huawei.location.crowdsourcing.upload.entity.yn):android.util.Pair");
    }
}
