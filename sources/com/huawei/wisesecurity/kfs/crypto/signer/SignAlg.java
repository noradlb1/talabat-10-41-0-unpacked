package com.huawei.wisesecurity.kfs.crypto.signer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum SignAlg {
    UNKNOWN("UNKNOWN", "UNKNOWN"),
    ECDSA("EC", "SHA256WithECDSA"),
    RSA_SHA256("RSA_SHA256", "SHA256WithRSA"),
    RSA_SHA256_PSS("RSA_SHA256_PSS", "SHA256withRSA/PSS"),
    HMAC_SHA256("HmacSHA256", "HmacSHA256");
    
    public static final Map<String, String> MAPPING = null;
    public static final Map<String, SignAlg> PREFERRED_ALGS = null;
    public final String alg;
    public final String keyType;

    /* access modifiers changed from: public */
    static {
        MAPPING = new HashMap();
        PREFERRED_ALGS = new HashMap();
        Iterator<E> it = EnumSet.allOf(SignAlg.class).iterator();
        while (it.hasNext()) {
            SignAlg signAlg = (SignAlg) it.next();
            MAPPING.put(signAlg.keyType, signAlg.alg);
        }
        Map<String, SignAlg> map = PREFERRED_ALGS;
        map.put("EC", ECDSA);
        map.put("RSA", RSA_SHA256);
        map.put("HMAC", HMAC_SHA256);
    }

    /* access modifiers changed from: public */
    SignAlg(String str, String str2) {
        this.keyType = str;
        this.alg = str2;
    }

    public static SignAlg getPreferredAlg(String str) {
        return PREFERRED_ALGS.get(str);
    }

    public String getTransformation() {
        return this.alg;
    }
}
