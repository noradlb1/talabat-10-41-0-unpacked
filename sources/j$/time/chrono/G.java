package j$.time.chrono;

import j$.time.ZoneOffset;
import j$.time.h;
import j$.time.k;
import j$.time.temporal.a;
import j$.time.temporal.p;
import j$.time.x;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

final class G implements Externalizable {
    private static final long serialVersionUID = -6103370247208168577L;

    /* renamed from: a  reason: collision with root package name */
    private byte f28278a;

    /* renamed from: b  reason: collision with root package name */
    private Object f28279b;

    public G() {
    }

    G(byte b11, Object obj) {
        this.f28278a = b11;
        this.f28279b = obj;
    }

    private Object readResolve() {
        return this.f28279b;
    }

    public final void readExternal(ObjectInput objectInput) {
        Object obj;
        byte readByte = objectInput.readByte();
        this.f28278a = readByte;
        switch (readByte) {
            case 1:
                int i11 = C0098a.f28287c;
                obj = C0098a.g(objectInput.readUTF());
                break;
            case 2:
                obj = ((C0100c) objectInput.readObject()).u((k) objectInput.readObject());
                break;
            case 3:
                obj = ((C0103f) objectInput.readObject()).i((ZoneOffset) objectInput.readObject()).p((x) objectInput.readObject());
                break;
            case 4:
                h hVar = z.f28326d;
                int readInt = objectInput.readInt();
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                x.f28324d.getClass();
                obj = new z(h.M(readInt, readByte2, readByte3));
                break;
            case 5:
                A a11 = A.f28268d;
                obj = A.o(objectInput.readByte());
                break;
            case 6:
                q qVar = (q) objectInput.readObject();
                int readInt2 = objectInput.readInt();
                byte readByte4 = objectInput.readByte();
                byte readByte5 = objectInput.readByte();
                qVar.getClass();
                obj = s.I(qVar, readInt2, readByte4, readByte5);
                break;
            case 7:
                int readInt3 = objectInput.readInt();
                byte readByte6 = objectInput.readByte();
                byte readByte7 = objectInput.readByte();
                C.f28274d.getClass();
                obj = new E(h.M(readInt3 + 1911, readByte6, readByte7));
                break;
            case 8:
                int readInt4 = objectInput.readInt();
                byte readByte8 = objectInput.readByte();
                byte readByte9 = objectInput.readByte();
                I.f28281d.getClass();
                obj = new K(h.M(readInt4 - 543, readByte8, readByte9));
                break;
            case 9:
                int i12 = C0106i.f28292e;
                obj = new C0106i(C0098a.g(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f28279b = obj;
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        byte b11 = this.f28278a;
        Object obj = this.f28279b;
        objectOutput.writeByte(b11);
        switch (b11) {
            case 1:
                objectOutput.writeUTF(((C0098a) obj).e());
                return;
            case 2:
                ((C0105h) obj).writeExternal(objectOutput);
                return;
            case 3:
                ((m) obj).writeExternal(objectOutput);
                return;
            case 4:
                z zVar = (z) obj;
                zVar.getClass();
                objectOutput.writeInt(p.a(zVar, a.YEAR));
                objectOutput.writeByte(p.a(zVar, a.MONTH_OF_YEAR));
                objectOutput.writeByte(p.a(zVar, a.DAY_OF_MONTH));
                return;
            case 5:
                ((A) obj).x(objectOutput);
                return;
            case 6:
                ((s) obj).writeExternal(objectOutput);
                return;
            case 7:
                E e11 = (E) obj;
                e11.getClass();
                objectOutput.writeInt(p.a(e11, a.YEAR));
                objectOutput.writeByte(p.a(e11, a.MONTH_OF_YEAR));
                objectOutput.writeByte(p.a(e11, a.DAY_OF_MONTH));
                return;
            case 8:
                K k11 = (K) obj;
                k11.getClass();
                objectOutput.writeInt(p.a(k11, a.YEAR));
                objectOutput.writeByte(p.a(k11, a.MONTH_OF_YEAR));
                objectOutput.writeByte(p.a(k11, a.DAY_OF_MONTH));
                return;
            case 9:
                ((C0106i) obj).c(objectOutput);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }
}
