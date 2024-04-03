package j$.time.format;

import j$.time.temporal.a;
import j$.time.temporal.q;
import j$.time.temporal.u;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

final class h extends k {

    /* renamed from: g  reason: collision with root package name */
    private final boolean f28349g;

    h(a aVar, int i11, int i12, boolean z11) {
        this(aVar, i11, i12, z11, 0);
        Objects.requireNonNull(aVar, "field");
        if (!aVar.range().g()) {
            throw new IllegalArgumentException("Field must have a fixed set of values: " + aVar);
        } else if (i11 < 0 || i11 > 9) {
            throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i11);
        } else if (i12 < 1 || i12 > 9) {
            throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i12);
        } else if (i12 < i11) {
            throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i12 + " < " + i11);
        }
    }

    h(q qVar, int i11, int i12, boolean z11, int i13) {
        super(qVar, i11, i12, A.NOT_NEGATIVE, i13);
        this.f28349g = z11;
    }

    /* access modifiers changed from: package-private */
    public final k c() {
        return this.f28357e == -1 ? this : new h(this.f28353a, this.f28354b, this.f28355c, this.f28349g, -1);
    }

    /* access modifiers changed from: package-private */
    public final k d(int i11) {
        return new h(this.f28353a, this.f28354b, this.f28355c, this.f28349g, this.f28357e + i11);
    }

    public final boolean f(v vVar, StringBuilder sb2) {
        q qVar = this.f28353a;
        Long e11 = vVar.e(qVar);
        if (e11 == null) {
            return false;
        }
        y b11 = vVar.b();
        long longValue = e11.longValue();
        u range = qVar.range();
        range.b(longValue, qVar);
        BigDecimal valueOf = BigDecimal.valueOf(range.e());
        BigDecimal divide = BigDecimal.valueOf(longValue).subtract(valueOf).divide(BigDecimal.valueOf(range.d()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
        BigDecimal stripTrailingZeros = divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
        int scale = stripTrailingZeros.scale();
        boolean z11 = this.f28349g;
        int i11 = this.f28354b;
        if (scale != 0) {
            String substring = stripTrailingZeros.setScale(Math.min(Math.max(stripTrailingZeros.scale(), i11), this.f28355c), RoundingMode.FLOOR).toPlainString().substring(2);
            b11.getClass();
            if (z11) {
                sb2.append('.');
            }
            sb2.append(substring);
            return true;
        } else if (i11 <= 0) {
            return true;
        } else {
            if (z11) {
                b11.getClass();
                sb2.append('.');
            }
            for (int i12 = 0; i12 < i11; i12++) {
                b11.getClass();
                sb2.append('0');
            }
            return true;
        }
    }

    public final String toString() {
        String str = this.f28349g ? ",DecimalPoint" : "";
        return "Fraction(" + this.f28353a + "," + this.f28354b + "," + this.f28355c + str + ")";
    }
}
