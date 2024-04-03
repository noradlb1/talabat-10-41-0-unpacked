package j$.time.temporal;

import j$.time.d;
import j$.time.h;
import net.bytebuddy.jar.asm.Opcodes;
import org.tukaani.xz.LZMA2Options;

enum g implements q {
    ;
    
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f28449a = null;

    static {
        f28449a = new int[]{0, 90, Opcodes.PUTFIELD, LZMA2Options.NICE_LEN_MAX, 0, 91, Opcodes.INVOKEVIRTUAL, 274};
    }

    static u D(h hVar) {
        return u.j(1, (long) F(E(hVar)));
    }

    /* access modifiers changed from: private */
    public static int E(h hVar) {
        int I = hVar.I();
        int G = hVar.G();
        if (G <= 3) {
            return G - hVar.F().ordinal() < -2 ? I - 1 : I;
        }
        if (G < 363) {
            return I;
        }
        return ((G - 363) - (hVar.m() ? 1 : 0)) - hVar.F().ordinal() >= 0 ? I + 1 : I;
    }

    /* access modifiers changed from: private */
    public static int F(int i11) {
        h M = h.M(i11, 1, 1);
        if (M.F() != d.THURSDAY) {
            return (M.F() != d.WEDNESDAY || !M.m()) ? 52 : 53;
        }
        return 53;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
        if ((r0 == -3 || (r0 == -2 && r5.m())) == false) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int v(j$.time.h r5) {
        /*
            j$.time.d r0 = r5.F()
            int r0 = r0.ordinal()
            int r1 = r5.G()
            r2 = 1
            int r1 = r1 - r2
            int r0 = 3 - r0
            int r0 = r0 + r1
            int r3 = r0 / 7
            int r3 = r3 * 7
            int r0 = r0 - r3
            r3 = -3
            int r0 = r0 + r3
            if (r0 >= r3) goto L_0x001c
            int r0 = r0 + 7
        L_0x001c:
            if (r1 >= r0) goto L_0x003f
            r0 = 180(0xb4, float:2.52E-43)
            j$.time.h r5 = r5.W(r0)
            r0 = -1
            j$.time.h r5 = r5.S(r0)
            int r5 = E(r5)
            int r5 = F(r5)
            long r0 = (long) r5
            r2 = 1
            j$.time.temporal.u r5 = j$.time.temporal.u.j(r2, r0)
            long r0 = r5.d()
            int r5 = (int) r0
            goto L_0x005b
        L_0x003f:
            int r1 = r1 - r0
            int r1 = r1 / 7
            int r1 = r1 + r2
            r4 = 53
            if (r1 != r4) goto L_0x0059
            if (r0 == r3) goto L_0x0055
            r3 = -2
            if (r0 != r3) goto L_0x0053
            boolean r5 = r5.m()
            if (r5 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r5 = 0
            goto L_0x0056
        L_0x0055:
            r5 = r2
        L_0x0056:
            if (r5 != 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r2 = r1
        L_0x005a:
            r5 = r2
        L_0x005b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.temporal.g.v(j$.time.h):int");
    }

    public final boolean isDateBased() {
        return true;
    }

    public final boolean isTimeBased() {
        return false;
    }
}
