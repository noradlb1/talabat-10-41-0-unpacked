package j$.time.format;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import j$.time.temporal.a;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

final class j implements g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28350a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f28351b;

    public /* synthetic */ j(int i11, Object obj) {
        this.f28350a = i11;
        this.f28351b = obj;
    }

    private static void a(StringBuilder sb2, int i11) {
        sb2.append((char) ((i11 / 10) + 48));
        sb2.append((char) ((i11 % 10) + 48));
    }

    public final boolean f(v vVar, StringBuilder sb2) {
        int i11 = this.f28350a;
        Object obj = this.f28351b;
        switch (i11) {
            case 0:
                Long e11 = vVar.e(a.OFFSET_SECONDS);
                if (e11 == null) {
                    return false;
                }
                sb2.append("GMT");
                long longValue = e11.longValue();
                int i12 = (int) longValue;
                if (longValue != ((long) i12)) {
                    throw new ArithmeticException();
                } else if (i12 == 0) {
                    return true;
                } else {
                    int abs = Math.abs((i12 / 3600) % 100);
                    int abs2 = Math.abs((i12 / 60) % 60);
                    int abs3 = Math.abs(i12 % 60);
                    sb2.append(i12 < 0 ? SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE : "+");
                    if (((B) obj) == B.FULL) {
                        a(sb2, abs);
                        sb2.append(AbstractJsonLexerKt.COLON);
                        a(sb2, abs2);
                        if (abs3 == 0) {
                            return true;
                        }
                    } else {
                        if (abs >= 10) {
                            sb2.append((char) ((abs / 10) + 48));
                        }
                        sb2.append((char) ((abs % 10) + 48));
                        if (abs2 == 0 && abs3 == 0) {
                            return true;
                        }
                        sb2.append(AbstractJsonLexerKt.COLON);
                        a(sb2, abs2);
                        if (abs3 == 0) {
                            return true;
                        }
                    }
                    sb2.append(AbstractJsonLexerKt.COLON);
                    a(sb2, abs3);
                    return true;
                }
            default:
                sb2.append((String) obj);
                return true;
        }
    }

    public final String toString() {
        int i11 = this.f28350a;
        Object obj = this.f28351b;
        switch (i11) {
            case 0:
                return "LocalizedOffset(" + ((B) obj) + ")";
            default:
                String replace = ((String) obj).replace("'", "''");
                return "'" + replace + "'";
        }
    }
}
