package com.uxcam.internals;

import android.util.Base64;
import androidx.annotation.RequiresApi;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

@RequiresApi(api = 8)
public class hp {
    public static byte[] a(byte[] bArr) {
        PublicKey publicKey;
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        try {
            publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNUf8CVU/4PRJebkLWYKQIMAiN\nl8n/7/F76ExbRAC8B9SxjU+weoDH25P41j3NWAV6K1t3R5Ws7NPre524akdwFqTH\nhJzkFTHpvSqjxfqTbLepDkhInppZDMvpX6INOBGZQwEdaV37QgLp6cgfsK2oRhur\nUGCDTwVQhY8SdO6riQIDAQAB", 0)));
        } catch (NoSuchAlgorithmException e11) {
            e11.printStackTrace();
            publicKey = null;
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (InvalidKeySpecException e12) {
            e12.printStackTrace();
            publicKey = null;
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        }
        instance.init(1, publicKey);
        return instance.doFinal(bArr);
    }
}
