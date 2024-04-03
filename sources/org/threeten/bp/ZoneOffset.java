package org.threeten.bp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.security.CertificateUtil;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneRules;

public final class ZoneOffset extends ZoneId implements TemporalAccessor, TemporalAdjuster, Comparable<ZoneOffset> {
    public static final TemporalQuery<ZoneOffset> FROM = new TemporalQuery<ZoneOffset>() {
        public ZoneOffset queryFrom(TemporalAccessor temporalAccessor) {
            return ZoneOffset.from(temporalAccessor);
        }
    };
    private static final ConcurrentMap<String, ZoneOffset> ID_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset MAX = ofTotalSeconds(MAX_SECONDS);
    private static final int MAX_SECONDS = 64800;
    public static final ZoneOffset MIN = ofTotalSeconds(-64800);
    private static final int MINUTES_PER_HOUR = 60;
    private static final ConcurrentMap<Integer, ZoneOffset> SECONDS_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    public static final ZoneOffset UTC = ofTotalSeconds(0);
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: id  reason: collision with root package name */
    private final transient String f63328id;
    private final int totalSeconds;

    private ZoneOffset(int i11) {
        this.totalSeconds = i11;
        this.f63328id = buildId(i11);
    }

    public static ZoneOffset b(DataInput dataInput) throws IOException {
        byte readByte = dataInput.readByte();
        if (readByte == Byte.MAX_VALUE) {
            return ofTotalSeconds(dataInput.readInt());
        }
        return ofTotalSeconds(readByte * 900);
    }

    private static String buildId(int i11) {
        String str;
        String str2;
        if (i11 == 0) {
            return "Z";
        }
        int abs = Math.abs(i11);
        StringBuilder sb2 = new StringBuilder();
        int i12 = abs / SECONDS_PER_HOUR;
        int i13 = (abs / 60) % 60;
        if (i11 < 0) {
            str = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
        } else {
            str = "+";
        }
        sb2.append(str);
        if (i12 < 10) {
            str2 = "0";
        } else {
            str2 = "";
        }
        sb2.append(str2);
        sb2.append(i12);
        String str3 = ":0";
        sb2.append(i13 < 10 ? str3 : CertificateUtil.DELIMITER);
        sb2.append(i13);
        int i14 = abs % 60;
        if (i14 != 0) {
            if (i14 >= 10) {
                str3 = CertificateUtil.DELIMITER;
            }
            sb2.append(str3);
            sb2.append(i14);
        }
        return sb2.toString();
    }

    public static ZoneOffset from(TemporalAccessor temporalAccessor) {
        ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.query(TemporalQueries.offset());
        if (zoneOffset != null) {
            return zoneOffset;
        }
        throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x009a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.threeten.bp.ZoneOffset of(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            org.threeten.bp.jdk8.Jdk8Methods.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, org.threeten.bp.ZoneOffset> r0 = ID_CACHE
            java.lang.Object r0 = r0.get(r7)
            org.threeten.bp.ZoneOffset r0 = (org.threeten.bp.ZoneOffset) r0
            if (r0 == 0) goto L_0x0010
            return r0
        L_0x0010:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x006e
            r1 = 3
            if (r0 == r1) goto L_0x008a
            r4 = 5
            if (r0 == r4) goto L_0x0064
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L_0x005b
            r5 = 7
            if (r0 == r5) goto L_0x004e
            r1 = 9
            if (r0 != r1) goto L_0x0037
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r6, r2)
            int r2 = parseNumber(r7, r5, r2)
            goto L_0x0090
        L_0x0037:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, invalid format: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x004e:
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r1, r3)
            int r2 = parseNumber(r7, r4, r3)
            goto L_0x0090
        L_0x005b:
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r6, r2)
            goto L_0x006c
        L_0x0064:
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r1, r3)
        L_0x006c:
            r2 = r3
            goto L_0x0090
        L_0x006e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r1 = r7.charAt(r3)
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            char r7 = r7.charAt(r2)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L_0x008a:
            int r0 = parseNumber(r7, r2, r3)
            r1 = r3
            r2 = r1
        L_0x0090:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto L_0x00b4
            if (r3 != r5) goto L_0x009d
            goto L_0x00b4
        L_0x009d:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x00b4:
            if (r3 != r5) goto L_0x00be
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            org.threeten.bp.ZoneOffset r7 = ofHoursMinutesSeconds(r7, r0, r1)
            return r7
        L_0x00be:
            org.threeten.bp.ZoneOffset r7 = ofHoursMinutesSeconds(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZoneOffset.of(java.lang.String):org.threeten.bp.ZoneOffset");
    }

    public static ZoneOffset ofHours(int i11) {
        return ofHoursMinutesSeconds(i11, 0, 0);
    }

    public static ZoneOffset ofHoursMinutes(int i11, int i12) {
        return ofHoursMinutesSeconds(i11, i12, 0);
    }

    public static ZoneOffset ofHoursMinutesSeconds(int i11, int i12, int i13) {
        validate(i11, i12, i13);
        return ofTotalSeconds(totalSeconds(i11, i12, i13));
    }

    public static ZoneOffset ofTotalSeconds(int i11) {
        if (Math.abs(i11) > MAX_SECONDS) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i11 % TypedValues.Custom.TYPE_INT != 0) {
            return new ZoneOffset(i11);
        } else {
            Integer valueOf = Integer.valueOf(i11);
            ConcurrentMap<Integer, ZoneOffset> concurrentMap = SECONDS_CACHE;
            ZoneOffset zoneOffset = concurrentMap.get(valueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentMap.putIfAbsent(valueOf, new ZoneOffset(i11));
            ZoneOffset zoneOffset2 = concurrentMap.get(valueOf);
            ID_CACHE.putIfAbsent(zoneOffset2.getId(), zoneOffset2);
            return zoneOffset2;
        }
    }

    private static int parseNumber(CharSequence charSequence, int i11, boolean z11) {
        if (!z11 || charSequence.charAt(i11 - 1) == ':') {
            char charAt = charSequence.charAt(i11);
            char charAt2 = charSequence.charAt(i11 + 1);
            if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
                return ((charAt - '0') * 10) + (charAt2 - '0');
            }
            throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + charSequence);
        }
        throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + charSequence);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static int totalSeconds(int i11, int i12, int i13) {
        return (i11 * SECONDS_PER_HOUR) + (i12 * 60) + i13;
    }

    private static void validate(int i11, int i12, int i13) {
        if (i11 < -18 || i11 > 18) {
            throw new DateTimeException("Zone offset hours not in valid range: value " + i11 + " is not in the range -18 to 18");
        }
        if (i11 > 0) {
            if (i12 < 0 || i13 < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i11 < 0) {
            if (i12 > 0 || i13 > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i12 > 0 && i13 < 0) || (i12 < 0 && i13 > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (Math.abs(i12) > 59) {
            throw new DateTimeException("Zone offset minutes not in valid range: abs(value) " + Math.abs(i12) + " is not in the range 0 to 59");
        } else if (Math.abs(i13) > 59) {
            throw new DateTimeException("Zone offset seconds not in valid range: abs(value) " + Math.abs(i13) + " is not in the range 0 to 59");
        } else if (Math.abs(i11) != 18) {
        } else {
            if (Math.abs(i12) > 0 || Math.abs(i13) > 0) {
                throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
            }
        }
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    public void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(8);
        c(dataOutput);
    }

    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.OFFSET_SECONDS, (long) this.totalSeconds);
    }

    public void c(DataOutput dataOutput) throws IOException {
        int i11;
        int i12 = this.totalSeconds;
        if (i12 % TypedValues.Custom.TYPE_INT == 0) {
            i11 = i12 / TypedValues.Custom.TYPE_INT;
        } else {
            i11 = 127;
        }
        dataOutput.writeByte(i11);
        if (i11 == 127) {
            dataOutput.writeInt(i12);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZoneOffset)) {
            return false;
        }
        if (this.totalSeconds == ((ZoneOffset) obj).totalSeconds) {
            return true;
        }
        return false;
    }

    public int get(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (!(temporalField instanceof ChronoField)) {
            return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public String getId() {
        return this.f63328id;
    }

    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return (long) this.totalSeconds;
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        throw new DateTimeException("Unsupported field: " + temporalField);
    }

    public ZoneRules getRules() {
        return ZoneRules.of(this);
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    public int hashCode() {
        return this.totalSeconds;
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField == ChronoField.OFFSET_SECONDS) {
                return true;
            }
            return false;
        } else if (temporalField == null || !temporalField.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.zone()) {
            return this;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.precision() || temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zoneId()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return temporalField.range();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public String toString() {
        return this.f63328id;
    }

    public int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.totalSeconds - this.totalSeconds;
    }
}
