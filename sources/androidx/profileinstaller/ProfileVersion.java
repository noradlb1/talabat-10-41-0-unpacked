package androidx.profileinstaller;

import com.facebook.internal.security.CertificateUtil;
import java.util.Arrays;
import org.apache.commons.compress.archivers.tar.TarConstants;

class ProfileVersion {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f37395a = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_DIR, 0};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f37396b = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_NORMAL, 0};

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f37397c = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 57, 0};

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f37398d = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_DIR, 0};

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f37399e = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_LINK, 0};

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f37400f = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_LINK, 0};

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f37401g = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_SYMLINK, 0};

    private ProfileVersion() {
    }

    public static String a(byte[] bArr) {
        if (!Arrays.equals(bArr, f37399e) && !Arrays.equals(bArr, f37398d)) {
            return "!";
        }
        return CertificateUtil.DELIMITER;
    }
}
