package com.huawei.wisesecurity.kfs.crypto.signer;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

public interface VerifyHandler {
    VerifyHandler fromBase64Data(String str) throws CryptoException;

    VerifyHandler fromBase64UrlData(String str) throws CryptoException;

    VerifyHandler fromData(String str) throws CryptoException;

    VerifyHandler fromData(byte[] bArr) throws CryptoException;

    VerifyHandler fromHexData(String str) throws CryptoException;

    boolean verify(String str) throws CryptoException;

    boolean verify(byte[] bArr) throws CryptoException;

    boolean verifyBase64(String str) throws CryptoException;

    boolean verifyBase64Url(String str) throws CryptoException;

    boolean verifyHex(String str) throws CryptoException;
}
