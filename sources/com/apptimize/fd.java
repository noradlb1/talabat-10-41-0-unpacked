package com.apptimize;

import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.zip.Adler32;
import java.util.zip.Checksum;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import okio.Utf8;
import org.apache.commons.compress.archivers.tar.TarConstants;

public class fd {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f42417a = {TarConstants.LF_NORMAL, -126, 1, 34, TarConstants.LF_NORMAL, Ascii.CR, 6, 9, 42, -122, 72, -122, -9, Ascii.CR, 1, 1, 1, 5, 0, 3, -126, 1, Ascii.SI, 0, TarConstants.LF_NORMAL, -126, 1, 10, 2, -126, 1, 1, 0, -96, TarConstants.LF_GNUTYPE_LONGNAME, -18, TarConstants.LF_BLK, 74, 73, 119, -12, -114, -81, TarConstants.LF_CONTIG, 125, 35, -54, -1, Ascii.SI, -68, 60, -45, 46, TarConstants.LF_GNUTYPE_LONGLINK, -64, 125, 6, -39, -94, -44, -99, -106, TarConstants.LF_SYMLINK, Ascii.ESC, 73, 113, TarConstants.LF_FIFO, 86, 80, -51, -122, -79, -44, -76, -87, -107, -48, Ascii.CR, 115, -15, -96, -102, -70, Ascii.FS, 101, -60, 62, 0, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, -43, -48, 36, -41, 123, -77, 95, Utf8.REPLACEMENT_BYTE, -54, -54, 104, -111, TarConstants.LF_CHR, 87, -99, -56, 91, Ascii.ESC, Ascii.NAK, 113, -41, -14, -88, 62, -96, 112, 97, -116, 80, -23, -35, Utf8.REPLACEMENT_BYTE, Ascii.FS, -20, -126, -93, -38, -9, 121, -48, 99, 72, 86, 11, 5, -63, 35, 74, 45, 94, -56, 108, -24, 19, 81, -88, 19, 79, 59, 102, -17, -60, 0, -29, 47, 39, 118, Utf8.REPLACEMENT_BYTE, 47, -32, 77, -82, 11, -127, Utf8.REPLACEMENT_BYTE, -39, -47, -59, 41, 71, -29, Ascii.SUB, TarConstants.LF_GNUTYPE_LONGLINK, Ascii.US, 123, 57, 57, TarConstants.LF_NORMAL, 81, 40, 115, -66, TarConstants.LF_CONTIG, -12, -28, -69, -62, -26, Ascii.SYN, Ascii.DLE, 95, TarConstants.LF_LINK, -9, 74, -32, TarConstants.LF_FIFO, Ascii.SUB, 104, Ascii.SYN, TarConstants.LF_BLK, -97, 86, 108, -3, 125, -103, 104, -1, -47, 41, -6, 86, -89, -89, -17, -32, -91, -48, 109, Ascii.ETB, TarConstants.LF_GNUTYPE_LONGNAME, -10, -58, -93, -116, -48, -85, Ascii.FS, -117, -51, -4, -33, 74, 42, -43, -123, -84, Ascii.SYN, -8, Ascii.RS, -28, -100, 110, -37, -24, -39, Ascii.DC4, TarConstants.LF_CONTIG, -2, -8, -116, -20, -18, 62, Byte.MAX_VALUE, -84, 2, -12, TarConstants.LF_GNUTYPE_SPARSE, 74, -27, 126, -96, 58, 114, -102, TarConstants.LF_FIFO, 84, 47, -107, -74, 47, 47, -66, Utf8.REPLACEMENT_BYTE, -89, 94, 34, 87, 110, 107, -51, 99, 8, Ascii.US, -89, Ascii.EM, -94, 0, 57, 2, 3, 1, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final String f42418b = "fd";

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } finally {
            inputStream.close();
            byteArrayOutputStream.close();
        }
    }

    public static String b(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        int length = bArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            sb2.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i11])}));
        }
        return sb2.toString();
    }

    private static Object c(Object obj) {
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            long j11 = (long) doubleValue;
            if (doubleValue == ((double) j11)) {
                return Long.valueOf(j11);
            }
            return obj;
        } else if (!(obj instanceof Float)) {
            return obj;
        } else {
            float floatValue = ((Float) obj).floatValue();
            long j12 = (long) floatValue;
            if (floatValue == ((float) j12)) {
                return Long.valueOf(j12);
            }
            return obj;
        }
    }

    public static String b(String str) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(f42417a));
            Cipher instance = Cipher.getInstance("RSA");
            instance.init(1, generatePublic);
            return ew.a(a(str.getBytes("UTF-8"), 1, instance));
        } catch (GeneralSecurityException e11) {
            bo.e(f42418b, "Error in crypto: ", e11);
            return "";
        } catch (UnsupportedEncodingException e12) {
            bo.e(f42418b, "Error in crypto: ", e12);
            return "";
        }
    }

    /* JADX INFO: finally extract failed */
    public static byte[] a(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = str.getBytes("utf-8");
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bytes);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            throw th2;
        }
    }

    public static void b(Object obj) {
        if (av.f41255r) {
            try {
                new ObjectOutputStream(new ByteArrayOutputStream()).writeObject(obj);
            } catch (IOException e11) {
                bo.b(f42418b, "Error serializing object; may cause problems in multiprocess mode: ", e11);
            }
        }
    }

    public static String a(byte[] bArr) throws IOException {
        return new String(a((InputStream) new GZIPInputStream(new ByteArrayInputStream(bArr))), "UTF-8");
    }

    private static byte[] a(byte[] bArr, int i11, Cipher cipher) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2 = new byte[0];
        int i12 = i11 == 1 ? 100 : 128;
        byte[] bArr3 = new byte[i12];
        for (int i13 = 0; i13 < bArr.length; i13++) {
            if (i13 > 0 && i13 % i12 == 0) {
                bArr2 = a(bArr2, cipher.doFinal(bArr3));
                bArr3 = new byte[(i13 + i12 > bArr.length ? bArr.length - i13 : i12)];
            }
            bArr3[i13 % i12] = bArr[i13];
        }
        return a(bArr2, cipher.doFinal(bArr3));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String a(List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        try {
            TreeSet<String> treeSet = new TreeSet<>();
            if (list != null) {
                treeSet.addAll(list);
            }
            if (list2 != null) {
                treeSet.addAll(list2);
            }
            if (list3 != null) {
                treeSet.addAll(list3);
            }
            if (list4 != null) {
                treeSet.addAll(list4);
            }
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            for (String bytes : treeSet) {
                instance.update((byte) 0);
                instance.update((byte) 0);
                instance.update(bytes.getBytes("utf-8"));
            }
            return b(instance.digest());
        } catch (NoSuchAlgorithmException e11) {
            bo.b(f42418b, "platform is missing SHA-1?", e11);
            return "";
        } catch (UnsupportedEncodingException e12) {
            bo.b(f42418b, "platform is missing utf-8?", e12);
            return "";
        }
    }

    public static long a(Object obj) {
        Adler32 adler32 = new Adler32();
        if (obj instanceof Collection) {
            long j11 = 0;
            for (Object a11 : (Collection) obj) {
                j11 ^= a(a11);
            }
            a((Checksum) adler32, j11);
        } else if (obj instanceof Map) {
            a((Checksum) adler32, a((Map<?, ?>) (Map) obj));
        } else if (obj == null) {
            adler32.update("null".getBytes());
        } else {
            adler32.update(c(obj).toString().getBytes());
        }
        return adler32.getValue();
    }

    public static long a(Map<?, ?> map) {
        Adler32 adler32 = new Adler32();
        long j11 = 0;
        for (Map.Entry next : map.entrySet()) {
            a((Checksum) adler32, a(next.getKey()));
            a((Checksum) adler32, a(next.getValue()));
            j11 ^= adler32.getValue();
            adler32.reset();
        }
        return j11;
    }

    public static void a(Checksum checksum, long j11) {
        byte[] array = ByteBuffer.allocate(8).putLong(j11).array();
        checksum.update(array, 0, array.length);
    }
}
