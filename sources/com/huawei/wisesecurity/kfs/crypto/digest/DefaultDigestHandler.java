package com.huawei.wisesecurity.kfs.crypto.digest;

import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.crypto.codec.Encoder;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.kfs.util.ByteUtil;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DefaultDigestHandler implements DigestHandler {
    public byte[] data;
    public final DigestAlg digestAlg;

    public DefaultDigestHandler(DigestAlg digestAlg2) {
        this.digestAlg = digestAlg2;
    }

    private String digest(Encoder encoder) throws CryptoException {
        try {
            return encoder.encode(digest());
        } catch (CodecException e11) {
            throw new CryptoException("Fail to encode signature bytes: " + e11.getMessage());
        }
    }

    private DigestHandler from(String str, Decoder decoder) throws CryptoException {
        try {
            from(decoder.decode(str));
            return this;
        } catch (CodecException e11) {
            throw new CryptoException("Fail to decode plain text : " + e11.getMessage());
        }
    }

    public byte[] digest() throws CryptoException {
        try {
            return MessageDigest.getInstance(this.digestAlg.getTransformation()).digest(this.data);
        } catch (NoSuchAlgorithmException e11) {
            throw new CryptoException("MessageDigest error : " + e11.getMessage());
        }
    }

    public String digestBase64() throws CryptoException {
        return digest(Encoder.BASE64);
    }

    public String digestBase64Url() throws CryptoException {
        return digest(Encoder.BASE64Url);
    }

    public String digestHex() throws CryptoException {
        return digest(Encoder.HEX);
    }

    public DigestHandler from(String str) throws CryptoException {
        return from(str.getBytes(StandardCharsets.UTF_8));
    }

    public DigestHandler from(byte[] bArr) throws CryptoException {
        this.data = ByteUtil.clone(bArr);
        return this;
    }

    public DigestHandler fromBase64(String str) throws CryptoException {
        return from(str, Decoder.BASE64);
    }

    public DigestHandler fromBase64Url(String str) throws CryptoException {
        return from(str, Decoder.BASE64Url);
    }

    public DigestHandler fromHex(String str) throws CryptoException {
        return from(str, Decoder.HEX);
    }
}
