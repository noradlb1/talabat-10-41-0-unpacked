package com.huawei.wisesecurity.kfs.crypto.cipher;

import com.google.common.base.Ascii;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum CipherAlg {
    UNKNOWN((byte) -1, "unknown", 0),
    AES_CBC((byte) 0, "AES/CBC/PKCS5Padding", 16),
    KEY_STORE_AES_CBC((byte) 0, "AES/CBC/PKCS7Padding", 16),
    AES_GCM((byte) 1, "AES/GCM/NoPadding", 12),
    RSA_OAEP(Ascii.DLE, "RSA/ECB/OAEPWithSHA-256AndMGF1Padding", 0),
    ECIES((byte) 32, "ECIESwithAES/NONE/PKCS7Padding", 0),
    ECIES_CBC((byte) 33, "ECIESwithAES-CBC/NONE/PKCS7Padding", 0);
    
    public static final Map<Byte, CipherAlg> MAPPING = null;
    public static final Map<String, CipherAlg> PREFERRED_ALGS = null;

    /* renamed from: id  reason: collision with root package name */
    public final byte f44851id;
    public final int ivLen;
    public final String transformation;

    /* access modifiers changed from: public */
    static {
        MAPPING = new HashMap();
        PREFERRED_ALGS = new HashMap();
        Iterator<E> it = EnumSet.allOf(CipherAlg.class).iterator();
        while (it.hasNext()) {
            CipherAlg cipherAlg = (CipherAlg) it.next();
            MAPPING.put(Byte.valueOf(cipherAlg.f44851id), cipherAlg);
        }
        Map<String, CipherAlg> map = PREFERRED_ALGS;
        map.put("EC", ECIES);
        map.put("RSA", RSA_OAEP);
        map.put("AES", AES_GCM);
    }

    /* access modifiers changed from: public */
    CipherAlg(byte b11, String str, int i11) {
        this.f44851id = b11;
        this.transformation = str;
        this.ivLen = i11;
    }

    public static CipherAlg getPreferredAlg(String str) {
        return PREFERRED_ALGS.get(str);
    }

    public static CipherAlg id2Alg(byte b11) {
        return MAPPING.get(Byte.valueOf(b11));
    }

    public byte getId() {
        return this.f44851id;
    }

    public int getIvLen() {
        return this.ivLen;
    }

    public String getTransformation() {
        return this.transformation;
    }

    public String toString() {
        return this.transformation;
    }
}
