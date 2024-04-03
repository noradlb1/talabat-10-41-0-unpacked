package com.huawei.location.crowdsourcing.common.util;

public final class FB {

    public enum yn {
        DEFAULT_ALG("HmacSHA256");
        
        private final String FB;

        private yn(String str) {
            this.FB = str;
        }

        public String yn() {
            return this.FB;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String yn(java.lang.String r3, byte[] r4) {
        /*
            java.lang.String r0 = "HmacUtil"
            com.huawei.location.crowdsourcing.common.util.FB$yn r1 = com.huawei.location.crowdsourcing.common.util.FB.yn.DEFAULT_ALG
            javax.crypto.spec.SecretKeySpec r2 = new javax.crypto.spec.SecretKeySpec
            java.lang.String r1 = r1.yn()
            r2.<init>(r4, r1)
            r4 = 0
            java.lang.String r1 = r2.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x0027 }
            javax.crypto.Mac r1 = javax.crypto.Mac.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0027 }
            r1.init(r2)     // Catch:{ InvalidKeyException -> 0x0024 }
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r3 = r3.getBytes(r0)
            byte[] r3 = r1.doFinal(r3)
            goto L_0x002d
        L_0x0024:
            java.lang.String r3 = "InvalidKeyException"
            goto L_0x0029
        L_0x0027:
            java.lang.String r3 = "NoSuchAlgorithmException"
        L_0x0029:
            com.huawei.location.lite.common.log.LogConsole.e(r0, r3)
            r3 = r4
        L_0x002d:
            if (r3 != 0) goto L_0x0030
            goto L_0x003f
        L_0x0030:
            r0 = 2
            byte[] r3 = com.huawei.secure.android.common.util.SafeBase64.encode(r3, r0)
            if (r3 != 0) goto L_0x0038
            goto L_0x003f
        L_0x0038:
            java.lang.String r4 = new java.lang.String
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8
            r4.<init>(r3, r0)
        L_0x003f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.common.util.FB.yn(java.lang.String, byte[]):java.lang.String");
    }
}
