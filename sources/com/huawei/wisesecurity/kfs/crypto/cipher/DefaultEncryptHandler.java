package com.huawei.wisesecurity.kfs.crypto.cipher;

import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.crypto.codec.Encoder;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.kfs.util.ByteUtil;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DefaultEncryptHandler implements EncryptHandler {
    public final CipherText cipherText;
    public final Key key;
    public final AlgorithmParameterSpec parameterSpec;

    public DefaultEncryptHandler(Key key2, CipherText cipherText2, AlgorithmParameterSpec algorithmParameterSpec) {
        this.key = key2;
        this.parameterSpec = algorithmParameterSpec;
        this.cipherText = cipherText2;
    }

    private void doEncrypt() throws CryptoException {
        try {
            Cipher instance = Cipher.getInstance(this.cipherText.getAlgId().getTransformation());
            instance.init(1, this.key, this.parameterSpec);
            CipherText cipherText2 = this.cipherText;
            cipherText2.setCipherBytes(instance.doFinal(cipherText2.getPlainBytes()));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e11) {
            throw new CryptoException("Fail to encrypt: " + e11.getMessage());
        }
    }

    private DefaultEncryptHandler from(String str, Decoder decoder) throws CryptoException {
        try {
            from(decoder.decode(str));
            return this;
        } catch (CodecException e11) {
            throw new CryptoException("Fail to decode plain text : " + e11.getMessage());
        }
    }

    private String to(Encoder encoder) throws CryptoException {
        try {
            doEncrypt();
            return encoder.encode(this.cipherText.getCipherBytes());
        } catch (CodecException e11) {
            throw new CryptoException("Fail to encode cipher bytes: " + e11.getMessage());
        }
    }

    public DefaultEncryptHandler from(String str) throws CryptoException {
        return from(str.getBytes(StandardCharsets.UTF_8));
    }

    public DefaultEncryptHandler from(byte[] bArr) throws CryptoException {
        this.cipherText.setPlainBytes(ByteUtil.clone(bArr));
        return this;
    }

    public DefaultEncryptHandler fromBase64(String str) throws CryptoException {
        return from(str, Decoder.BASE64);
    }

    public DefaultEncryptHandler fromBase64Url(String str) throws CryptoException {
        return from(str, Decoder.BASE64Url);
    }

    public DefaultEncryptHandler fromHex(String str) throws CryptoException {
        return from(str, Decoder.HEX);
    }

    public byte[] to() throws CryptoException {
        doEncrypt();
        return this.cipherText.getCipherBytes();
    }

    public String toBase64() throws CryptoException {
        return to(Encoder.BASE64);
    }

    public String toBase64Url() throws CryptoException {
        return to(Encoder.BASE64Url);
    }

    public String toHex() throws CryptoException {
        return to(Encoder.HEX);
    }
}
