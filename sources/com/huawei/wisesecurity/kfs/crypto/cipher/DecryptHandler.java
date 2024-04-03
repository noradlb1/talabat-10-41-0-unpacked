package com.huawei.wisesecurity.kfs.crypto.cipher;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

public interface DecryptHandler {
    DecryptHandler from(byte[] bArr) throws CryptoException;

    DecryptHandler fromBase64(String str) throws CryptoException;

    DecryptHandler fromBase64Url(String str) throws CryptoException;

    DecryptHandler fromHex(String str) throws CryptoException;

    byte[] to() throws CryptoException;

    String toBase64() throws CryptoException;

    String toHex() throws CryptoException;

    String toRawString() throws CryptoException;
}
