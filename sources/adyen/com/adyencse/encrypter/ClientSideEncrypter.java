package adyen.com.adyencse.encrypter;

import adyen.com.adyencse.encrypter.exception.EncrypterException;
import android.util.Base64;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class ClientSideEncrypter {
    private static final String PREFIX = "adyenan";
    private static final String SEPARATOR = "$";
    private static final String VERSION = "0_1_1";
    private Cipher aesCipher;
    private PublicKey pubKey;
    private Cipher rsaCipher;
    private SecureRandom srandom = new SecureRandom();

    public ClientSideEncrypter(String str) throws EncrypterException {
        PRNGFixes.apply();
        String[] split = str.split("\\|");
        try {
            try {
                this.pubKey = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(split[1].toLowerCase(Locale.getDefault()), 16), new BigInteger(split[0].toLowerCase(Locale.getDefault()), 16)));
                try {
                    this.aesCipher = Cipher.getInstance("AES/CCM/NoPadding", "BC");
                } catch (NoSuchAlgorithmException e11) {
                    throw new EncrypterException("Problem instantiation AES Cipher Algorithm", e11);
                } catch (NoSuchPaddingException e12) {
                    throw new EncrypterException("Problem instantiation AES Cipher Padding", e12);
                } catch (NoSuchProviderException e13) {
                    e13.printStackTrace();
                }
                try {
                    Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
                    this.rsaCipher = instance;
                    instance.init(1, this.pubKey);
                } catch (NoSuchAlgorithmException e14) {
                    throw new EncrypterException("Problem instantiation RSA Cipher Algorithm", e14);
                } catch (NoSuchPaddingException e15) {
                    throw new EncrypterException("Problem instantiation RSA Cipher Padding", e15);
                } catch (InvalidKeyException e16) {
                    throw new EncrypterException("Invalid public key: " + str, e16);
                }
            } catch (InvalidKeySpecException e17) {
                throw new EncrypterException("Problem reading public key: " + str, e17);
            }
        } catch (NoSuchAlgorithmException e18) {
            e18.printStackTrace();
        }
    }

    private SecretKey generateAESKey(int i11) throws EncrypterException {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(i11);
            return instance.generateKey();
        } catch (NoSuchAlgorithmException e11) {
            throw new EncrypterException("Unable to get AES algorithm", e11);
        }
    }

    private synchronized byte[] generateIV(int i11) {
        byte[] bArr;
        bArr = new byte[i11];
        this.srandom.nextBytes(bArr);
        return bArr;
    }

    public String encrypt(String str) throws EncrypterException {
        SecretKey generateAESKey = generateAESKey(256);
        byte[] generateIV = generateIV(12);
        try {
            this.aesCipher.init(1, generateAESKey, new IvParameterSpec(generateIV));
            byte[] doFinal = this.aesCipher.doFinal(str.getBytes());
            byte[] bArr = new byte[(generateIV.length + doFinal.length)];
            System.arraycopy(generateIV, 0, bArr, 0, generateIV.length);
            System.arraycopy(doFinal, 0, bArr, generateIV.length, doFinal.length);
            try {
                return String.format("%s%s%s%s%s%s", new Object[]{PREFIX, VERSION, SEPARATOR, Base64.encodeToString(this.rsaCipher.doFinal(generateAESKey.getEncoded()), 2), SEPARATOR, Base64.encodeToString(bArr, 2)});
            } catch (IllegalBlockSizeException e11) {
                throw new EncrypterException("Incorrect RSA Block Size", e11);
            } catch (BadPaddingException e12) {
                throw new EncrypterException("Incorrect RSA Padding", e12);
            }
        } catch (IllegalBlockSizeException e13) {
            throw new EncrypterException("Incorrect AES Block Size", e13);
        } catch (BadPaddingException e14) {
            throw new EncrypterException("Incorrect AES Padding", e14);
        } catch (InvalidKeyException e15) {
            throw new EncrypterException("Invalid AES Key", e15);
        } catch (InvalidAlgorithmParameterException e16) {
            throw new EncrypterException("Invalid AES Parameters", e16);
        }
    }
}
