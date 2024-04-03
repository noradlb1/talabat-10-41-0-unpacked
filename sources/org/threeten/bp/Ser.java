package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

final class Ser implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;
    private Object object;
    private byte type;

    public Ser() {
    }

    public static Object a(DataInput dataInput) throws IOException {
        return readInternal(dataInput.readByte(), dataInput);
    }

    public static void b(byte b11, Object obj, DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(b11);
        if (b11 != 64) {
            switch (b11) {
                case 1:
                    ((Duration) obj).b(dataOutput);
                    return;
                case 2:
                    ((Instant) obj).b(dataOutput);
                    return;
                case 3:
                    ((LocalDate) obj).d(dataOutput);
                    return;
                case 4:
                    ((LocalDateTime) obj).b(dataOutput);
                    return;
                case 5:
                    ((LocalTime) obj).c(dataOutput);
                    return;
                case 6:
                    ((ZonedDateTime) obj).b(dataOutput);
                    return;
                case 7:
                    ((ZoneRegion) obj).d(dataOutput);
                    return;
                case 8:
                    ((ZoneOffset) obj).c(dataOutput);
                    return;
                default:
                    switch (b11) {
                        case 66:
                            ((OffsetTime) obj).b(dataOutput);
                            return;
                        case 67:
                            ((Year) obj).b(dataOutput);
                            return;
                        case 68:
                            ((YearMonth) obj).b(dataOutput);
                            return;
                        case 69:
                            ((OffsetDateTime) obj).b(dataOutput);
                            return;
                        default:
                            throw new InvalidClassException("Unknown serialized type");
                    }
            }
        } else {
            ((MonthDay) obj).b(dataOutput);
        }
    }

    private static Object readInternal(byte b11, DataInput dataInput) throws IOException {
        if (b11 == 64) {
            return MonthDay.a(dataInput);
        }
        switch (b11) {
            case 1:
                return Duration.a(dataInput);
            case 2:
                return Instant.a(dataInput);
            case 3:
                return LocalDate.c(dataInput);
            case 4:
                return LocalDateTime.a(dataInput);
            case 5:
                return LocalTime.b(dataInput);
            case 6:
                return ZonedDateTime.a(dataInput);
            case 7:
                return ZoneRegion.c(dataInput);
            case 8:
                return ZoneOffset.b(dataInput);
            default:
                switch (b11) {
                    case 66:
                        return OffsetTime.a(dataInput);
                    case 67:
                        return Year.a(dataInput);
                    case 68:
                        return YearMonth.a(dataInput);
                    case 69:
                        return OffsetDateTime.a(dataInput);
                    default:
                        throw new StreamCorruptedException("Unknown serialized type");
                }
        }
    }

    private Object readResolve() {
        return this.object;
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        byte readByte = objectInput.readByte();
        this.type = readByte;
        this.object = readInternal(readByte, objectInput);
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        b(this.type, this.object, objectOutput);
    }

    public Ser(byte b11, Object obj) {
        this.type = b11;
        this.object = obj;
    }
}
