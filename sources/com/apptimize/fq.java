package com.apptimize;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class fq {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42462a = "fq";

    /* renamed from: b  reason: collision with root package name */
    private PublicKey f42463b;

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public fq() {
        try {
            this.f42463b = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(fd.f42417a));
        } catch (InvalidKeySpecException e11) {
            bo.b(f42462a, "Unable to read the Apptimize public key", e11);
        } catch (NoSuchAlgorithmException e12) {
            bo.b(f42462a, "Unable to read the Apptimize public key", e12);
        }
    }

    private a a(String str, Exception exc) throws a {
        if (exc != null) {
            String str2 = f42462a;
            bo.a(str2, str + " " + exc.getMessage(), exc);
        } else {
            bo.a(f42462a, str);
        }
        throw new a(str);
    }

    public JSONObject a(InputStream inputStream) throws a {
        try {
            int read = inputStream.read();
            int read2 = inputStream.read();
            if (read < 0 || 255 < read || read2 < 0 || 255 < read2) {
                throw a("The signature size bytes were too small", (Exception) null);
            }
            int i11 = (read << 8) | read2;
            byte[] bArr = new byte[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                int read3 = inputStream.read();
                if (read3 < 0 || 255 < read3) {
                    throw a("Unexpectedly short signature section", (Exception) null);
                }
                bArr[i12] = (byte) read3;
            }
            try {
                byte[] a11 = fd.a(inputStream);
                try {
                    Signature instance = Signature.getInstance("SHA1withRSA");
                    PublicKey publicKey = this.f42463b;
                    if (publicKey != null) {
                        instance.initVerify(publicKey);
                        instance.update(a11);
                        if (instance.verify(bArr)) {
                            try {
                                return new JSONObject(fd.a(a11));
                            } catch (JSONException e11) {
                                throw a("Response is not valid json", e11);
                            } catch (IOException e12) {
                                throw a("IOException while processing the signed response", e12);
                            }
                        } else {
                            throw a("Signature of message was not valid", (Exception) null);
                        }
                    } else {
                        throw a("No public key", (Exception) null);
                    }
                } catch (InvalidKeyException e13) {
                    throw a("Could not verify signature of Apptimize meta-data", e13);
                } catch (SignatureException e14) {
                    throw a("Could not verify signature of Apptimize meta-data", e14);
                } catch (NoSuchAlgorithmException e15) {
                    throw a("Could not verify signature of Apptimize meta-data", e15);
                }
            } catch (IOException e16) {
                throw a("IOException while processing the signed message", e16);
            }
        } catch (IOException e17) {
            throw a("IOException while processing the signature section", e17);
        }
    }

    public fq(PublicKey publicKey) {
        this.f42463b = publicKey;
    }
}
