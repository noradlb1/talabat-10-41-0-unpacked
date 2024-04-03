package com.huawei.wisesecurity.kfs.crypto.signer;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

public interface SignHandler {
    SignHandler from(String str) throws CryptoException;

    SignHandler from(byte[] bArr) throws CryptoException;

    SignHandler fromBase64(String str) throws CryptoException;

    SignHandler fromBase64Url(String str) throws CryptoException;

    SignHandler fromHex(String str) throws CryptoException;

    byte[] sign() throws CryptoException;

    String signBase64() throws CryptoException;

    String signBase64Url() throws CryptoException;

    String signHex() throws CryptoException;
}
