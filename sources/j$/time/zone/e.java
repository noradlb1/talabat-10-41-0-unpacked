package j$.time.zone;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.huawei.hms.push.constant.RemoteMessageConst;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.u;
import j$.time.d;
import j$.time.h;
import j$.time.k;
import j$.time.m;
import j$.time.temporal.o;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;

    /* renamed from: a  reason: collision with root package name */
    private final m f28515a;

    /* renamed from: b  reason: collision with root package name */
    private final byte f28516b;

    /* renamed from: c  reason: collision with root package name */
    private final d f28517c;

    /* renamed from: d  reason: collision with root package name */
    private final k f28518d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f28519e;

    /* renamed from: f  reason: collision with root package name */
    private final d f28520f;

    /* renamed from: g  reason: collision with root package name */
    private final ZoneOffset f28521g;

    /* renamed from: h  reason: collision with root package name */
    private final ZoneOffset f28522h;

    /* renamed from: i  reason: collision with root package name */
    private final ZoneOffset f28523i;

    e(m mVar, int i11, d dVar, k kVar, boolean z11, d dVar2, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.f28515a = mVar;
        this.f28516b = (byte) i11;
        this.f28517c = dVar;
        this.f28518d = kVar;
        this.f28519e = z11;
        this.f28520f = dVar2;
        this.f28521g = zoneOffset;
        this.f28522h = zoneOffset2;
        this.f28523i = zoneOffset3;
    }

    static e b(DataInput dataInput) {
        int readInt = dataInput.readInt();
        m E = m.E(readInt >>> 28);
        int i11 = ((264241152 & readInt) >>> 22) - 32;
        int i12 = (3670016 & readInt) >>> 19;
        d B = i12 == 0 ? null : d.B(i12);
        int i13 = (507904 & readInt) >>> 14;
        d dVar = d.values()[(readInt & 12288) >>> 12];
        int i14 = (readInt & 4080) >>> 4;
        int i15 = (readInt & 12) >>> 2;
        int i16 = readInt & 3;
        k K = i13 == 31 ? k.K((long) dataInput.readInt()) : k.I(i13 % 24);
        ZoneOffset L = ZoneOffset.L(i14 == 255 ? dataInput.readInt() : (i14 - 128) * TypedValues.Custom.TYPE_INT);
        ZoneOffset L2 = i15 == 3 ? ZoneOffset.L(dataInput.readInt()) : ZoneOffset.L((i15 * 1800) + L.I());
        ZoneOffset L3 = i16 == 3 ? ZoneOffset.L(dataInput.readInt()) : ZoneOffset.L((i16 * 1800) + L.I());
        boolean z11 = i13 == 24;
        Objects.requireNonNull(E, "month");
        Objects.requireNonNull(K, "time");
        Objects.requireNonNull(dVar, "timeDefnition");
        if (i11 < -28 || i11 > 31 || i11 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        } else if (z11 && !K.equals(k.f28417g)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        } else if (K.G() == 0) {
            return new e(E, i11, B, K, z11, dVar, L, L2, L3);
        } else {
            throw new IllegalArgumentException("Time's nano-of-second must be zero");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final b a(int i11) {
        h hVar;
        d dVar = this.f28517c;
        m mVar = this.f28515a;
        byte b11 = this.f28516b;
        if (b11 < 0) {
            hVar = h.N(i11, mVar, mVar.C(u.f28321d.A((long) i11)) + 1 + b11);
            if (dVar != null) {
                hVar = hVar.g(new o(dVar.getValue(), 1));
            }
        } else {
            hVar = h.N(i11, mVar, b11);
            if (dVar != null) {
                hVar = hVar.g(new o(dVar.getValue(), 0));
            }
        }
        if (this.f28519e) {
            hVar = hVar.Q(1);
        }
        LocalDateTime J = LocalDateTime.J(hVar, this.f28518d);
        d dVar2 = this.f28520f;
        dVar2.getClass();
        int i12 = c.f28513a[dVar2.ordinal()];
        ZoneOffset zoneOffset = this.f28522h;
        if (i12 == 1) {
            J = J.M((long) (zoneOffset.I() - ZoneOffset.UTC.I()));
        } else if (i12 == 2) {
            J = J.M((long) (zoneOffset.I() - this.f28521g.I()));
        }
        return new b(J, zoneOffset, this.f28523i);
    }

    /* access modifiers changed from: package-private */
    public final void c(DataOutput dataOutput) {
        k kVar = this.f28518d;
        boolean z11 = this.f28519e;
        int S = z11 ? RemoteMessageConst.DEFAULT_TTL : kVar.S();
        int I = this.f28521g.I();
        ZoneOffset zoneOffset = this.f28522h;
        int I2 = zoneOffset.I() - I;
        ZoneOffset zoneOffset2 = this.f28523i;
        int I3 = zoneOffset2.I() - I;
        int F = S % 3600 == 0 ? z11 ? 24 : kVar.F() : 31;
        int i11 = I % TypedValues.Custom.TYPE_INT == 0 ? (I / TypedValues.Custom.TYPE_INT) + 128 : 255;
        int i12 = (I2 == 0 || I2 == 1800 || I2 == 3600) ? I2 / 1800 : 3;
        int i13 = (I3 == 0 || I3 == 1800 || I3 == 3600) ? I3 / 1800 : 3;
        d dVar = this.f28517c;
        dataOutput.writeInt((this.f28515a.getValue() << 28) + ((this.f28516b + 32) << 22) + ((dVar == null ? 0 : dVar.getValue()) << 19) + (F << 14) + (this.f28520f.ordinal() << 12) + (i11 << 4) + (i12 << 2) + i13);
        if (F == 31) {
            dataOutput.writeInt(S);
        }
        if (i11 == 255) {
            dataOutput.writeInt(I);
        }
        if (i12 == 3) {
            dataOutput.writeInt(zoneOffset.I());
        }
        if (i13 == 3) {
            dataOutput.writeInt(zoneOffset2.I());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f28515a == eVar.f28515a && this.f28516b == eVar.f28516b && this.f28517c == eVar.f28517c && this.f28520f == eVar.f28520f && this.f28518d.equals(eVar.f28518d) && this.f28519e == eVar.f28519e && this.f28521g.equals(eVar.f28521g) && this.f28522h.equals(eVar.f28522h) && this.f28523i.equals(eVar.f28523i);
    }

    public final int hashCode() {
        int S = ((this.f28518d.S() + (this.f28519e ? 1 : 0)) << 15) + (this.f28515a.ordinal() << 11) + ((this.f28516b + 32) << 5);
        d dVar = this.f28517c;
        return ((this.f28521g.hashCode() ^ (this.f28520f.ordinal() + (S + ((dVar == null ? 7 : dVar.ordinal()) << 2)))) ^ this.f28522h.hashCode()) ^ this.f28523i.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TransitionRule[");
        ZoneOffset zoneOffset = this.f28522h;
        ZoneOffset zoneOffset2 = this.f28523i;
        sb2.append(zoneOffset.H(zoneOffset2) > 0 ? "Gap " : "Overlap ");
        sb2.append(zoneOffset);
        sb2.append(" to ");
        sb2.append(zoneOffset2);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        byte b11 = this.f28516b;
        m mVar = this.f28515a;
        d dVar = this.f28517c;
        if (dVar == null) {
            sb2.append(mVar.name());
            sb2.append(' ');
            sb2.append(b11);
        } else if (b11 == -1) {
            sb2.append(dVar.name());
            sb2.append(" on or before last day of ");
            sb2.append(mVar.name());
        } else if (b11 < 0) {
            sb2.append(dVar.name());
            sb2.append(" on or before last day minus ");
            sb2.append((-b11) - 1);
            sb2.append(" of ");
            sb2.append(mVar.name());
        } else {
            sb2.append(dVar.name());
            sb2.append(" on or after ");
            sb2.append(mVar.name());
            sb2.append(' ');
            sb2.append(b11);
        }
        sb2.append(" at ");
        sb2.append(this.f28519e ? "24:00" : this.f28518d.toString());
        sb2.append(" ");
        sb2.append(this.f28520f);
        sb2.append(", standard offset ");
        sb2.append(this.f28521g);
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }
}
