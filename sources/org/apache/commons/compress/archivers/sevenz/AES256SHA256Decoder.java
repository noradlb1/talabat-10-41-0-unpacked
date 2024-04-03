package org.apache.commons.compress.archivers.sevenz;

import com.adjust.sdk.Constants;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;
import org.apache.commons.compress.PasswordRequiredException;

class AES256SHA256Decoder extends CoderBase {
    public AES256SHA256Decoder() {
        super(new Class[0]);
    }

    public InputStream b(String str, InputStream inputStream, long j11, Coder coder, byte[] bArr, int i11) throws IOException {
        final Coder coder2 = coder;
        final String str2 = str;
        final byte[] bArr2 = bArr;
        final InputStream inputStream2 = inputStream;
        return new InputStream() {
            private CipherInputStream cipherInputStream;
            private boolean isInitialized;

            private CipherInputStream init() throws IOException {
                byte[] bArr;
                if (this.isInitialized) {
                    return this.cipherInputStream;
                }
                byte[] bArr2 = coder2.f27611d;
                if (bArr2 == null) {
                    throw new IOException("Missing AES256 properties in " + str2);
                } else if (bArr2.length >= 2) {
                    byte b11 = bArr2[0] & 255;
                    byte b12 = b11 & Utf8.REPLACEMENT_BYTE;
                    byte b13 = bArr2[1] & 255;
                    int i11 = ((b11 >> 6) & 1) + (b13 & Ascii.SI);
                    int i12 = ((b11 >> 7) & 1) + (b13 >> 4);
                    int i13 = i12 + 2;
                    if (i13 + i11 <= bArr2.length) {
                        byte[] bArr3 = new byte[i12];
                        System.arraycopy(bArr2, 2, bArr3, 0, i12);
                        byte[] bArr4 = new byte[16];
                        System.arraycopy(coder2.f27611d, i13, bArr4, 0, i11);
                        if (bArr2 != null) {
                            if (b12 == 63) {
                                bArr = new byte[32];
                                System.arraycopy(bArr3, 0, bArr, 0, i12);
                                byte[] bArr5 = bArr2;
                                System.arraycopy(bArr5, 0, bArr, i12, Math.min(bArr5.length, 32 - i12));
                            } else {
                                try {
                                    MessageDigest instance = MessageDigest.getInstance(Constants.SHA256);
                                    byte[] bArr6 = new byte[8];
                                    for (long j11 = 0; j11 < (1 << b12); j11++) {
                                        instance.update(bArr3);
                                        instance.update(bArr2);
                                        instance.update(bArr6);
                                        for (int i14 = 0; i14 < 8; i14++) {
                                            byte b14 = (byte) (bArr6[i14] + 1);
                                            bArr6[i14] = b14;
                                            if (b14 != 0) {
                                                break;
                                            }
                                        }
                                    }
                                    bArr = instance.digest();
                                } catch (NoSuchAlgorithmException e11) {
                                    throw new IOException("SHA-256 is unsupported by your Java implementation", e11);
                                }
                            }
                            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                            try {
                                Cipher instance2 = Cipher.getInstance("AES/CBC/NoPadding");
                                instance2.init(2, secretKeySpec, new IvParameterSpec(bArr4));
                                CipherInputStream cipherInputStream2 = new CipherInputStream(inputStream2, instance2);
                                this.cipherInputStream = cipherInputStream2;
                                this.isInitialized = true;
                                return cipherInputStream2;
                            } catch (GeneralSecurityException e12) {
                                throw new IOException("Decryption error (do you have the JCE Unlimited Strength Jurisdiction Policy Files installed?)", e12);
                            }
                        } else {
                            throw new PasswordRequiredException(str2);
                        }
                    } else {
                        throw new IOException("Salt size + IV size too long in " + str2);
                    }
                } else {
                    throw new IOException("AES256 properties too short in " + str2);
                }
            }

            public void close() throws IOException {
                CipherInputStream cipherInputStream2 = this.cipherInputStream;
                if (cipherInputStream2 != null) {
                    cipherInputStream2.close();
                }
            }

            public int read() throws IOException {
                return init().read();
            }

            public int read(byte[] bArr, int i11, int i12) throws IOException {
                return init().read(bArr, i11, i12);
            }
        };
    }
}
