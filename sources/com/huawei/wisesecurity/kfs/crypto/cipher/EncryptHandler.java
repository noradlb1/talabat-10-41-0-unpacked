package com.huawei.wisesecurity.kfs.crypto.cipher;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

public interface EncryptHandler {
    EncryptHandler from(String str) throws CryptoException;

    EncryptHandler from(byte[] bArr) throws CryptoException;

    EncryptHandler fromBase64(String str) throws CryptoException;

    EncryptHandler fromBase64Url(String str) throws CryptoException;

    EncryptHandler fromHex(String str) throws CryptoException;

    byte[] to() throws CryptoException;

    String toBase64() throws CryptoException;

    String toBase64Url() throws CryptoException;

    String toHex() throws CryptoException;
}
