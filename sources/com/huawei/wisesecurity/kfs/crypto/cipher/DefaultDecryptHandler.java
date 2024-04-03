package com.huawei.wisesecurity.kfs.crypto.cipher;

import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.crypto.codec.Encoder;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DefaultDecryptHandler implements DecryptHandler {
    public final CipherText cipherText;
    public final Key key;
    public final AlgorithmParameterSpec parameterSpec;

    public DefaultDecryptHandler(Key key2, CipherText cipherText2, AlgorithmParameterSpec algorithmParameterSpec) {
        this.key = key2;
        this.parameterSpec = algorithmParameterSpec;
        this.cipherText = cipherText2;
    }

    private byte[] doDecrypt() throws CryptoException {
        try {
            Cipher instance = Cipher.getInstance(this.cipherText.getAlgId().getTransformation());
            instance.init(2, this.key, this.parameterSpec);
            return instance.doFinal(this.cipherText.getCipherBytes());
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e11) {
            throw new CryptoException("Fail to decrypt: " + e11.getMessage());
        }
    }

    private DefaultDecryptHandler from(String str, Decoder decoder) throws CryptoException {
        try {
            from(decoder.decode(str));
            return this;
        } catch (CodecException e11) {
            throw new CryptoException("Fail to decode cipher text: " + e11.getMessage());
        }
    }

    private String to(Encoder encoder) throws CryptoException {
        try {
            return encoder.encode(to());
        } catch (CodecException e11) {
            throw new CryptoException("Fail to encode plain text: " + e11.getMessage());
        }
    }

    public DefaultDecryptHandler from(byte[] bArr) throws CryptoException {
        this.cipherText.setCipherBytes(bArr);
        return this;
    }

    public DefaultDecryptHandler fromBase64(String str) throws CryptoException {
        return from(str, Decoder.BASE64);
    }

    public DefaultDecryptHandler fromBase64Url(String str) throws CryptoException {
        return from(str, Decoder.BASE64Url);
    }

    public DefaultDecryptHandler fromHex(String str) throws CryptoException {
        return from(str, Decoder.HEX);
    }

    public byte[] to() throws CryptoException {
        return doDecrypt();
    }

    public String toBase64() throws CryptoException {
        return to(Encoder.BASE64);
    }

    public String toHex() throws CryptoException {
        return to(Encoder.HEX);
    }

    public String toRawString() throws CryptoException {
        return to(Encoder.RAW);
    }
}
