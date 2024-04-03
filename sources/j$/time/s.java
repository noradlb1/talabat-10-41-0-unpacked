package j$.time;

import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;

final class s implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* renamed from: a  reason: collision with root package name */
    private byte f28436a;

    /* renamed from: b  reason: collision with root package name */
    private Object f28437b;

    public s() {
    }

    s(byte b11, Object obj) {
        this.f28436a = b11;
        this.f28437b = obj;
    }

    static Serializable a(ObjectInput objectInput) {
        return b(objectInput.readByte(), objectInput);
    }

    private static Serializable b(byte b11, ObjectInput objectInput) {
        switch (b11) {
            case 1:
                Duration duration = Duration.ZERO;
                return Duration.ofSeconds(objectInput.readLong(), (long) objectInput.readInt());
            case 2:
                Instant instant = Instant.f28248c;
                return Instant.E(objectInput.readLong(), (long) objectInput.readInt());
            case 3:
                h hVar = h.f28407d;
                return h.M(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return k.Q(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.f28251c;
                h hVar2 = h.f28407d;
                return LocalDateTime.J(h.M(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.Q(objectInput));
            case 6:
                return ZonedDateTime.F(objectInput);
            case 7:
                int i11 = y.f28503d;
                return x.D(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.N(objectInput);
            case 9:
                return q.D(objectInput);
            case 10:
                return OffsetDateTime.E(objectInput);
            case 11:
                int i12 = u.f28496b;
                return u.B(objectInput.readInt());
            case 12:
                return w.E(objectInput);
            case 13:
                return o.B(objectInput);
            case 14:
                return r.a(objectInput);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f28437b;
    }

    public final void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.f28436a = readByte;
        this.f28437b = b(readByte, objectInput);
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        byte b11 = this.f28436a;
        Object obj = this.f28437b;
        objectOutput.writeByte(b11);
        switch (b11) {
            case 1:
                ((Duration) obj).C(objectOutput);
                return;
            case 2:
                ((Instant) obj).H(objectOutput);
                return;
            case 3:
                ((h) obj).Y(objectOutput);
                return;
            case 4:
                ((k) obj).V(objectOutput);
                return;
            case 5:
                ((LocalDateTime) obj).S(objectOutput);
                return;
            case 6:
                ((ZonedDateTime) obj).J(objectOutput);
                return;
            case 7:
                ((y) obj).I(objectOutput);
                return;
            case 8:
                ((ZoneOffset) obj).O(objectOutput);
                return;
            case 9:
                ((q) obj).writeExternal(objectOutput);
                return;
            case 10:
                ((OffsetDateTime) obj).writeExternal(objectOutput);
                return;
            case 11:
                ((u) obj).F(objectOutput);
                return;
            case 12:
                ((w) obj).H(objectOutput);
                return;
            case 13:
                ((o) obj).C(objectOutput);
                return;
            case 14:
                ((r) obj).c(objectOutput);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }
}
