package com.huawei.wisesecurity.kfs.crypto.key;

import com.huawei.wisesecurity.kfs.exception.KfsException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

public interface KfsKeyManager {
    void generate(KeyGenerateParam keyGenerateParam) throws KfsException;

    Key getKey(String str) throws KfsException;

    PrivateKey getPrivateKey(String str) throws KfsException;

    PublicKey getPublicKey(String str) throws KfsException;

    boolean hasAlias(String str) throws KfsException;
}
