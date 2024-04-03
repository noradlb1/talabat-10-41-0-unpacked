package j$.time;

import j$.time.zone.f;
import j$.time.zone.g;
import j$.time.zone.j;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;

final class y extends x {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f28503d = 0;
    private static final long serialVersionUID = 8386373296231747096L;

    /* renamed from: b  reason: collision with root package name */
    private final String f28504b;

    /* renamed from: c  reason: collision with root package name */
    private final transient f f28505c;

    y(String str, f fVar) {
        this.f28504b = str;
        this.f28505c = fVar;
    }

    static y H(String str, boolean z11) {
        f fVar;
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        if (length >= 2) {
            for (int i11 = 0; i11 < length; i11++) {
                char charAt = str.charAt(i11);
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i11 == 0) && ((charAt < '0' || charAt > '9' || i11 == 0) && ((charAt != '~' || i11 == 0) && ((charAt != '.' || i11 == 0) && ((charAt != '_' || i11 == 0) && ((charAt != '+' || i11 == 0) && (charAt != '-' || i11 == 0))))))))) {
                    throw new b("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
                }
            }
            try {
                fVar = j.a(str, true);
            } catch (g e11) {
                if (!z11) {
                    fVar = null;
                } else {
                    throw e11;
                }
            }
            return new y(str, fVar);
        }
        throw new b("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 7, this);
    }

    public final f B() {
        f fVar = this.f28505c;
        return fVar != null ? fVar : j.a(this.f28504b, false);
    }

    /* access modifiers changed from: package-private */
    public final void G(DataOutput dataOutput) {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.f28504b);
    }

    /* access modifiers changed from: package-private */
    public final void I(DataOutput dataOutput) {
        dataOutput.writeUTF(this.f28504b);
    }

    public final String e() {
        return this.f28504b;
    }
}
