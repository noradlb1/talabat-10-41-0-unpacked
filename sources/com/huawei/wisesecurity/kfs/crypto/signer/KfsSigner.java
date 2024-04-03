package com.huawei.wisesecurity.kfs.crypto.signer;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

public interface KfsSigner {
    SignHandler getSignHandler() throws CryptoException;

    VerifyHandler getVerifyHandler() throws CryptoException;
}
