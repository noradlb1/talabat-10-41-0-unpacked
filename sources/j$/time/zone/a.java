package j$.time.zone;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import j$.time.ZoneOffset;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.TimeZone;

final class a implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;

    /* renamed from: a  reason: collision with root package name */
    private byte f28507a;

    /* renamed from: b  reason: collision with root package name */
    private Object f28508b;

    public a() {
    }

    a(byte b11, Object obj) {
        this.f28507a = b11;
        this.f28508b = obj;
    }

    static long a(DataInput dataInput) {
        byte readByte = dataInput.readByte() & 255;
        if (readByte == 255) {
            return dataInput.readLong();
        }
        return (((long) (((readByte << Ascii.DLE) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255))) * 900) - 4575744000L;
    }

    static ZoneOffset b(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ZoneOffset.L(dataInput.readInt()) : ZoneOffset.L(readByte * 900);
    }

    static void c(long j11, DataOutput dataOutput) {
        if (j11 < -4575744000L || j11 >= 10413792000L || j11 % 900 != 0) {
            dataOutput.writeByte(255);
            dataOutput.writeLong(j11);
            return;
        }
        int i11 = (int) ((j11 + 4575744000L) / 900);
        dataOutput.writeByte((i11 >>> 16) & 255);
        dataOutput.writeByte((i11 >>> 8) & 255);
        dataOutput.writeByte(i11 & 255);
    }

    static void d(ZoneOffset zoneOffset, DataOutput dataOutput) {
        int I = zoneOffset.I();
        int i11 = I % TypedValues.Custom.TYPE_INT == 0 ? I / TypedValues.Custom.TYPE_INT : 127;
        dataOutput.writeByte(i11);
        if (i11 == 127) {
            dataOutput.writeInt(I);
        }
    }

    private Object readResolve() {
        return this.f28508b;
    }

    public final void readExternal(ObjectInput objectInput) {
        Object obj;
        byte readByte = objectInput.readByte();
        this.f28507a = readByte;
        if (readByte == 1) {
            obj = f.l(objectInput);
        } else if (readByte == 2) {
            long a11 = a(objectInput);
            ZoneOffset b11 = b(objectInput);
            ZoneOffset b12 = b(objectInput);
            if (!b11.equals(b12)) {
                obj = new b(a11, b11, b12);
            } else {
                throw new IllegalArgumentException("Offsets must not be equal");
            }
        } else if (readByte == 3) {
            obj = e.b(objectInput);
        } else if (readByte == 100) {
            obj = new f(TimeZone.getTimeZone(objectInput.readUTF()));
        } else {
            throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f28508b = obj;
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        byte b11 = this.f28507a;
        Object obj = this.f28508b;
        objectOutput.writeByte(b11);
        if (b11 == 1) {
            ((f) obj).m(objectOutput);
        } else if (b11 == 2) {
            ((b) obj).C(objectOutput);
        } else if (b11 == 3) {
            ((e) obj).c(objectOutput);
        } else if (b11 == 100) {
            ((f) obj).n(objectOutput);
        } else {
            throw new InvalidClassException("Unknown serialized type");
        }
    }
}
