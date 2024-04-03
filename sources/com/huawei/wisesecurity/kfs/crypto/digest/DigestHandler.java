package com.huawei.wisesecurity.kfs.crypto.digest;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

public interface DigestHandler {
    byte[] digest() throws CryptoException;

    String digestBase64() throws CryptoException;

    String digestBase64Url() throws CryptoException;

    String digestHex() throws CryptoException;

    DigestHandler from(String str) throws CryptoException;

    DigestHandler from(byte[] bArr) throws CryptoException;

    DigestHandler fromBase64(String str) throws CryptoException;

    DigestHandler fromBase64Url(String str) throws CryptoException;

    DigestHandler fromHex(String str) throws CryptoException;
}
