package com.huawei.wisesecurity.kfs.crypto.digest;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

public class KfsDigest {
    public static DigestHandler getDigestHandler(DigestAlg digestAlg) throws CryptoException {
        return new DefaultDigestHandler(digestAlg);
    }
}
