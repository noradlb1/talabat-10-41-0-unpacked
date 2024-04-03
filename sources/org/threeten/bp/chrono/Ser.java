package org.threeten.bp.chrono;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

final class Ser implements Externalizable {
    private static final long serialVersionUID = 7857518227608961174L;
    private Object object;
    private byte type;

    public Ser() {
    }

    private static Object readInternal(byte b11, ObjectInput objectInput) throws IOException, ClassNotFoundException {
        switch (b11) {
            case 1:
                return JapaneseDate.h(objectInput);
            case 2:
                return JapaneseEra.c(objectInput);
            case 3:
                return HijrahDate.n(objectInput);
            case 4:
                return HijrahEra.b(objectInput);
            case 5:
                return MinguoDate.g(objectInput);
            case 6:
                return MinguoEra.a(objectInput);
            case 7:
                return ThaiBuddhistDate.g(objectInput);
            case 8:
                return ThaiBuddhistEra.a(objectInput);
            case 11:
                return Chronology.d(objectInput);
            case 12:
                return ChronoLocalDateTimeImpl.c(objectInput);
            case 13:
                return ChronoZonedDateTimeImpl.c(objectInput);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.object;
    }

    private static void writeInternal(byte b11, Object obj, ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(b11);
        switch (b11) {
            case 1:
                ((JapaneseDate) obj).i(objectOutput);
                return;
            case 2:
                ((JapaneseEra) obj).e(objectOutput);
                return;
            case 3:
                ((HijrahDate) obj).o(objectOutput);
                return;
            case 4:
                ((HijrahEra) obj).c(objectOutput);
                return;
            case 5:
                ((MinguoDate) obj).h(objectOutput);
                return;
            case 6:
                ((MinguoEra) obj).b(objectOutput);
                return;
            case 7:
                ((ThaiBuddhistDate) obj).h(objectOutput);
                return;
            case 8:
                ((ThaiBuddhistEra) obj).b(objectOutput);
                return;
            case 11:
                ((Chronology) obj).f(objectOutput);
                return;
            case 12:
                ((ChronoLocalDateTimeImpl) obj).writeExternal(objectOutput);
                return;
            case 13:
                ((ChronoZonedDateTimeImpl) obj).writeExternal(objectOutput);
                return;
            default:
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
