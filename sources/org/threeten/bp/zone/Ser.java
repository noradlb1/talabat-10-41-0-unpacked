package org.threeten.bp.zone;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.threeten.bp.ZoneOffset;

final class Ser implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;
    private Object object;
    private byte type;

    public Ser() {
    }

    public static Object a(DataInput dataInput) throws IOException, ClassNotFoundException {
        return readInternal(dataInput.readByte(), dataInput);
    }

    public static long b(DataInput dataInput) throws IOException {
        byte readByte = dataInput.readByte() & 255;
        if (readByte == 255) {
            return dataInput.readLong();
        }
        return (((long) (((readByte << Ascii.DLE) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255))) * 900) - 4575744000L;
    }

    public static ZoneOffset c(DataInput dataInput) throws IOException {
        byte readByte = dataInput.readByte();
        if (readByte == Byte.MAX_VALUE) {
            return ZoneOffset.ofTotalSeconds(dataInput.readInt());
        }
        return ZoneOffset.ofTotalSeconds(readByte * 900);
    }

    public static void d(long j11, DataOutput dataOutput) throws IOException {
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

    public static void e(ZoneOffset zoneOffset, DataOutput dataOutput) throws IOException {
        int i11;
        int totalSeconds = zoneOffset.getTotalSeconds();
        if (totalSeconds % TypedValues.Custom.TYPE_INT == 0) {
            i11 = totalSeconds / TypedValues.Custom.TYPE_INT;
        } else {
            i11 = 127;
        }
        dataOutput.writeByte(i11);
        if (i11 == 127) {
            dataOutput.writeInt(totalSeconds);
        }
    }

    private static Object readInternal(byte b11, DataInput dataInput) throws IOException, ClassNotFoundException {
        if (b11 == 1) {
            return StandardZoneRules.a(dataInput);
        }
        if (b11 == 2) {
            return ZoneOffsetTransition.b(dataInput);
        }
        if (b11 == 3) {
            return ZoneOffsetTransitionRule.a(dataInput);
        }
        throw new StreamCorruptedException("Unknown serialized type");
    }

    private Object readResolve() {
        return this.object;
    }

    private static void writeInternal(byte b11, Object obj, DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(b11);
        if (b11 == 1) {
            ((StandardZoneRules) obj).b(dataOutput);
        } else if (b11 == 2) {
            ((ZoneOffsetTransition) obj).c(dataOutput);
        } else if (b11 == 3) {
            ((ZoneOffsetTransitionRule) obj).b(dataOutput);
        } else {
            throw new InvalidClassException("Unknown serialized type");
        }
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        byte readByte = objectInput.readByte();
        this.type = readByte;
        this.object = readInternal(readByte, objectInput);
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        writeInternal(this.type, this.object, objectOutput);
    }

    public Ser(byte b11, Object obj) {
        this.type = b11;
        this.object = obj;
    }
}
