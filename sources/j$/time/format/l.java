package j$.time.format;

import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import j$.time.temporal.a;
import java.util.Objects;

final class l implements g {

    /* renamed from: d  reason: collision with root package name */
    static final String[] f28358d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};

    /* renamed from: e  reason: collision with root package name */
    static final l f28359e = new l("+HH:MM:ss", "Z");

    /* renamed from: a  reason: collision with root package name */
    private final String f28360a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28361b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28362c;

    static {
        new l("+HH:MM:ss", "0");
    }

    l(String str, String str2) {
        Objects.requireNonNull(str, Param.PATTERN);
        int i11 = 0;
        while (true) {
            String[] strArr = f28358d;
            if (i11 >= 22) {
                throw new IllegalArgumentException("Invalid zone offset pattern: ".concat(str));
            } else if (strArr[i11].equals(str)) {
                this.f28361b = i11;
                this.f28362c = i11 % 11;
                this.f28360a = str2;
                return;
            } else {
                i11++;
            }
        }
    }

    private static void a(boolean z11, int i11, StringBuilder sb2) {
        sb2.append(z11 ? CertificateUtil.DELIMITER : "");
        sb2.append((char) ((i11 / 10) + 48));
        sb2.append((char) ((i11 % 10) + 48));
    }

    public final boolean f(v vVar, StringBuilder sb2) {
        Long e11 = vVar.e(a.OFFSET_SECONDS);
        boolean z11 = false;
        if (e11 == null) {
            return false;
        }
        long longValue = e11.longValue();
        int i11 = (int) longValue;
        if (longValue == ((long) i11)) {
            if (i11 != 0) {
                int abs = Math.abs((i11 / 3600) % 100);
                int abs2 = Math.abs((i11 / 60) % 60);
                int abs3 = Math.abs(i11 % 60);
                int length = sb2.length();
                sb2.append(i11 < 0 ? SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE : "+");
                if ((this.f28361b < 11) || abs >= 10) {
                    a(false, abs, sb2);
                } else {
                    sb2.append((char) (abs + 48));
                }
                int i12 = this.f28362c;
                if ((i12 >= 3 && i12 <= 8) || ((i12 >= 9 && abs3 > 0) || (i12 >= 1 && abs2 > 0))) {
                    a(i12 > 0 && i12 % 2 == 0, abs2, sb2);
                    abs += abs2;
                    if (i12 == 7 || i12 == 8 || (i12 >= 5 && abs3 > 0)) {
                        if (i12 > 0 && i12 % 2 == 0) {
                            z11 = true;
                        }
                        a(z11, abs3, sb2);
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    sb2.setLength(length);
                }
                return true;
            }
            sb2.append(this.f28360a);
            return true;
        }
        throw new ArithmeticException();
    }

    public final String toString() {
        String replace = this.f28360a.replace("'", "''");
        String str = f28358d[this.f28361b];
        return "Offset(" + str + ",'" + replace + "')";
    }
}
