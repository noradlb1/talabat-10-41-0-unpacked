package com.apptimize;

import com.apptimize.t;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.compress.archivers.tar.TarConstants;

public class av {
    public static PublicKey A = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f41238a = "av";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f41239b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f41240c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f41241d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f41242e = false;

    /* renamed from: f  reason: collision with root package name */
    public static long f41243f;

    /* renamed from: g  reason: collision with root package name */
    public static t.b f41244g = t.b.UNINITIALIZED;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f41245h = false;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f41246i;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f41247j;

    /* renamed from: k  reason: collision with root package name */
    public static boolean f41248k;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f41249l = true;

    /* renamed from: m  reason: collision with root package name */
    public static boolean f41250m = false;

    /* renamed from: n  reason: collision with root package name */
    public static int f41251n = 0;

    /* renamed from: o  reason: collision with root package name */
    public static boolean f41252o = false;

    /* renamed from: p  reason: collision with root package name */
    public static boolean f41253p;

    /* renamed from: q  reason: collision with root package name */
    public static boolean f41254q;

    /* renamed from: r  reason: collision with root package name */
    public static boolean f41255r;

    /* renamed from: s  reason: collision with root package name */
    public static boolean f41256s;

    /* renamed from: t  reason: collision with root package name */
    public static boolean f41257t;

    /* renamed from: u  reason: collision with root package name */
    public static boolean f41258u;

    /* renamed from: v  reason: collision with root package name */
    public static String f41259v;

    /* renamed from: w  reason: collision with root package name */
    public static String f41260w;

    /* renamed from: x  reason: collision with root package name */
    public static String f41261x;

    /* renamed from: y  reason: collision with root package name */
    public static boolean f41262y;

    /* renamed from: z  reason: collision with root package name */
    public static boolean f41263z;

    static {
        f41246i = false;
        f41247j = false;
        f41248k = false;
        f41253p = false;
        f41254q = false;
        f41255r = false;
        f41256s = false;
        f41257t = false;
        f41258u = false;
        f41259v = null;
        f41260w = null;
        f41261x = null;
        f41262y = false;
        f41263z = false;
        if (fn.a()) {
            f41246i = false;
            f41247j = false;
            f41248k = false;
            f41253p = false;
            f41254q = false;
            f41255r = false;
            f41256s = false;
            f41257t = false;
            f41258u = false;
            f41259v = null;
            f41260w = null;
            f41261x = null;
            f41262y = false;
            f41263z = false;
        }
    }

    public static void a() {
        try {
            bo.c(f41238a, "loading custom public key");
            A = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(new byte[]{TarConstants.LF_NORMAL, -126, 1, 34, TarConstants.LF_NORMAL, Ascii.CR, 6, 9, 42, -122, 72, -122, -9, Ascii.CR, 1, 1, 1, 5, 0, 3, -126, 1, Ascii.SI, 0, TarConstants.LF_NORMAL, -126, 1, 10, 2, -126, 1, 1, 0, -93, -102, -86, -6, -1, TarConstants.LF_LINK, 90, 65, -117, -121, 117, -87, 12, -109, 9, TarConstants.LF_NORMAL, -90, -45, TarConstants.LF_GNUTYPE_SPARSE, -28, 35, -74, -54, -97, -42, 33, -71, -124, -18, -29, 47, -57, -115, -78, Ascii.EM, 115, 79, -5, -53, Byte.MIN_VALUE, -98, 118, -30, -48, -15, -6, -59, -121, 69, 109, 72, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, -28, Ascii.DC2, 19, -41, -44, -126, 80, -113, 9, -48, -91, -63, -123, 11, 69, -72, -4, 2, -2, -123, 104, -20, 107, -22, 38, -69, 87, -59, -81, Ascii.GS, 72, 89, 19, 9, Byte.MAX_VALUE, -87, Ascii.DC4, -66, 106, -44, -50, 6, -89, -44, 65, -49, 123, 39, -66, 126, -120, TarConstants.LF_NORMAL, TarConstants.LF_DIR, 114, 123, Ascii.ESC, TarConstants.LF_SYMLINK, -57, 113, 32, -109, -102, TarConstants.LF_NORMAL, 91, -48, Ascii.DC2, -3, -105, -114, 38, -12, -35, SignedBytes.MAX_POWER_OF_TWO, 74, -17, -104, 10, 66, Ascii.FS, 70, -125, 96, -85, -50, 115, 102, -108, -44, -123, 93, -99, -78, -43, -93, -75, TarConstants.LF_FIFO, -67, Ascii.DC4, 104, -103, -24, 100, -31, -43, -47, 78, -23, -2, TarConstants.LF_NORMAL, -27, -89, 102, -37, -92, -29, -71, -68, -7, -106, -88, 118, Ascii.RS, 116, -127, -111, -70, Ascii.SUB, Ascii.EM, -6, -67, 117, -55, -108, -119, -5, Ascii.SYN, 2, -57, -12, -1, -72, -24, -42, -81, 67, 8, 94, -35, -10, -21, -24, 99, 119, -19, 4, 100, 68, -24, 2, 124, -31, -38, -103, 62, 113, -85, -115, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, -32, 59, -33, -108, -23, 68, 43, -105, -102, TarConstants.LF_PAX_EXTENDED_HEADER_LC, TarConstants.LF_DIR, -60, -86, TarConstants.LF_SYMLINK, -74, -68, 118, -43, -52, -36, -79, 87, 126, -112, 59, -55, -101, 36, 87, -109, -52, TarConstants.LF_FIFO, 122, 65, 69, 2, 3, 1, 0, 1}));
        } catch (InvalidKeySpecException e11) {
            bo.b(f41238a, "problem generating requested local public key", e11);
        } catch (NoSuchAlgorithmException e12) {
            bo.b(f41238a, "problem generating requested local public key", e12);
        }
    }
}
