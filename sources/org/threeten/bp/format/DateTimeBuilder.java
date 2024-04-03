package org.threeten.bp.format;

import com.google.android.exoplayer2.C;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;

final class DateTimeBuilder extends DefaultInterfaceTemporalAccessor implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public final Map<TemporalField, Long> f63346b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Chronology f63347c;

    /* renamed from: d  reason: collision with root package name */
    public ZoneId f63348d;

    /* renamed from: e  reason: collision with root package name */
    public ChronoLocalDate f63349e;

    /* renamed from: f  reason: collision with root package name */
    public LocalTime f63350f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63351g;

    /* renamed from: h  reason: collision with root package name */
    public Period f63352h;

    public DateTimeBuilder() {
    }

    private void checkDate(LocalDate localDate) {
        if (localDate != null) {
            c(localDate);
            for (TemporalField next : this.f63346b.keySet()) {
                if ((next instanceof ChronoField) && next.isDateBased()) {
                    try {
                        long j11 = localDate.getLong(next);
                        Long l11 = this.f63346b.get(next);
                        if (j11 != l11.longValue()) {
                            throw new DateTimeException("Conflict found: Field " + next + " " + j11 + " differs from " + next + " " + l11 + " derived from " + localDate);
                        }
                    } catch (DateTimeException unused) {
                        continue;
                    }
                }
            }
        }
    }

    private void crossCheck() {
        LocalTime localTime;
        if (this.f63346b.size() > 0) {
            ChronoLocalDate chronoLocalDate = this.f63349e;
            if (chronoLocalDate != null && (localTime = this.f63350f) != null) {
                crossCheck(chronoLocalDate.atTime(localTime));
            } else if (chronoLocalDate != null) {
                crossCheck(chronoLocalDate);
            } else {
                LocalTime localTime2 = this.f63350f;
                if (localTime2 != null) {
                    crossCheck(localTime2);
                }
            }
        }
    }

    private Long getFieldValue0(TemporalField temporalField) {
        return this.f63346b.get(temporalField);
    }

    private void mergeDate(ResolverStyle resolverStyle) {
        if (this.f63347c instanceof IsoChronology) {
            checkDate(IsoChronology.INSTANCE.resolveDate(this.f63346b, resolverStyle));
            return;
        }
        Map<TemporalField, Long> map = this.f63346b;
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            checkDate(LocalDate.ofEpochDay(this.f63346b.remove(chronoField).longValue()));
        }
    }

    private void mergeInstantFields() {
        if (this.f63346b.containsKey(ChronoField.INSTANT_SECONDS)) {
            ZoneId zoneId = this.f63348d;
            if (zoneId != null) {
                mergeInstantFields0(zoneId);
                return;
            }
            Long l11 = this.f63346b.get(ChronoField.OFFSET_SECONDS);
            if (l11 != null) {
                mergeInstantFields0(ZoneOffset.ofTotalSeconds(l11.intValue()));
            }
        }
    }

    private void mergeInstantFields0(ZoneId zoneId) {
        Map<TemporalField, Long> map = this.f63346b;
        ChronoField chronoField = ChronoField.INSTANT_SECONDS;
        ChronoZonedDateTime zonedDateTime = this.f63347c.zonedDateTime(Instant.ofEpochSecond(map.remove(chronoField).longValue()), zoneId);
        if (this.f63349e == null) {
            c(zonedDateTime.toLocalDate());
        } else {
            resolveMakeChanges((TemporalField) chronoField, zonedDateTime.toLocalDate());
        }
        a(ChronoField.SECOND_OF_DAY, (long) zonedDateTime.toLocalTime().toSecondOfDay());
    }

    private void mergeTime(ResolverStyle resolverStyle) {
        Map<TemporalField, Long> map = this.f63346b;
        ChronoField chronoField = ChronoField.CLOCK_HOUR_OF_DAY;
        long j11 = 0;
        if (map.containsKey(chronoField)) {
            long longValue = this.f63346b.remove(chronoField).longValue();
            if (!(resolverStyle == ResolverStyle.LENIENT || (resolverStyle == ResolverStyle.SMART && longValue == 0))) {
                chronoField.checkValidValue(longValue);
            }
            ChronoField chronoField2 = ChronoField.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            a(chronoField2, longValue);
        }
        Map<TemporalField, Long> map2 = this.f63346b;
        ChronoField chronoField3 = ChronoField.CLOCK_HOUR_OF_AMPM;
        if (map2.containsKey(chronoField3)) {
            long longValue2 = this.f63346b.remove(chronoField3).longValue();
            if (!(resolverStyle == ResolverStyle.LENIENT || (resolverStyle == ResolverStyle.SMART && longValue2 == 0))) {
                chronoField3.checkValidValue(longValue2);
            }
            ChronoField chronoField4 = ChronoField.HOUR_OF_AMPM;
            if (longValue2 != 12) {
                j11 = longValue2;
            }
            a(chronoField4, j11);
        }
        ResolverStyle resolverStyle2 = ResolverStyle.LENIENT;
        if (resolverStyle != resolverStyle2) {
            Map<TemporalField, Long> map3 = this.f63346b;
            ChronoField chronoField5 = ChronoField.AMPM_OF_DAY;
            if (map3.containsKey(chronoField5)) {
                chronoField5.checkValidValue(this.f63346b.get(chronoField5).longValue());
            }
            Map<TemporalField, Long> map4 = this.f63346b;
            ChronoField chronoField6 = ChronoField.HOUR_OF_AMPM;
            if (map4.containsKey(chronoField6)) {
                chronoField6.checkValidValue(this.f63346b.get(chronoField6).longValue());
            }
        }
        Map<TemporalField, Long> map5 = this.f63346b;
        ChronoField chronoField7 = ChronoField.AMPM_OF_DAY;
        if (map5.containsKey(chronoField7)) {
            Map<TemporalField, Long> map6 = this.f63346b;
            ChronoField chronoField8 = ChronoField.HOUR_OF_AMPM;
            if (map6.containsKey(chronoField8)) {
                a(ChronoField.HOUR_OF_DAY, (this.f63346b.remove(chronoField7).longValue() * 12) + this.f63346b.remove(chronoField8).longValue());
            }
        }
        Map<TemporalField, Long> map7 = this.f63346b;
        ChronoField chronoField9 = ChronoField.NANO_OF_DAY;
        if (map7.containsKey(chronoField9)) {
            long longValue3 = this.f63346b.remove(chronoField9).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField9.checkValidValue(longValue3);
            }
            a(ChronoField.SECOND_OF_DAY, longValue3 / C.NANOS_PER_SECOND);
            a(ChronoField.NANO_OF_SECOND, longValue3 % C.NANOS_PER_SECOND);
        }
        Map<TemporalField, Long> map8 = this.f63346b;
        ChronoField chronoField10 = ChronoField.MICRO_OF_DAY;
        if (map8.containsKey(chronoField10)) {
            long longValue4 = this.f63346b.remove(chronoField10).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField10.checkValidValue(longValue4);
            }
            a(ChronoField.SECOND_OF_DAY, longValue4 / 1000000);
            a(ChronoField.MICRO_OF_SECOND, longValue4 % 1000000);
        }
        Map<TemporalField, Long> map9 = this.f63346b;
        ChronoField chronoField11 = ChronoField.MILLI_OF_DAY;
        if (map9.containsKey(chronoField11)) {
            long longValue5 = this.f63346b.remove(chronoField11).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField11.checkValidValue(longValue5);
            }
            a(ChronoField.SECOND_OF_DAY, longValue5 / 1000);
            a(ChronoField.MILLI_OF_SECOND, longValue5 % 1000);
        }
        Map<TemporalField, Long> map10 = this.f63346b;
        ChronoField chronoField12 = ChronoField.SECOND_OF_DAY;
        if (map10.containsKey(chronoField12)) {
            long longValue6 = this.f63346b.remove(chronoField12).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField12.checkValidValue(longValue6);
            }
            a(ChronoField.HOUR_OF_DAY, longValue6 / 3600);
            a(ChronoField.MINUTE_OF_HOUR, (longValue6 / 60) % 60);
            a(ChronoField.SECOND_OF_MINUTE, longValue6 % 60);
        }
        Map<TemporalField, Long> map11 = this.f63346b;
        ChronoField chronoField13 = ChronoField.MINUTE_OF_DAY;
        if (map11.containsKey(chronoField13)) {
            long longValue7 = this.f63346b.remove(chronoField13).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField13.checkValidValue(longValue7);
            }
            a(ChronoField.HOUR_OF_DAY, longValue7 / 60);
            a(ChronoField.MINUTE_OF_HOUR, longValue7 % 60);
        }
        if (resolverStyle != resolverStyle2) {
            Map<TemporalField, Long> map12 = this.f63346b;
            ChronoField chronoField14 = ChronoField.MILLI_OF_SECOND;
            if (map12.containsKey(chronoField14)) {
                chronoField14.checkValidValue(this.f63346b.get(chronoField14).longValue());
            }
            Map<TemporalField, Long> map13 = this.f63346b;
            ChronoField chronoField15 = ChronoField.MICRO_OF_SECOND;
            if (map13.containsKey(chronoField15)) {
                chronoField15.checkValidValue(this.f63346b.get(chronoField15).longValue());
            }
        }
        Map<TemporalField, Long> map14 = this.f63346b;
        ChronoField chronoField16 = ChronoField.MILLI_OF_SECOND;
        if (map14.containsKey(chronoField16)) {
            Map<TemporalField, Long> map15 = this.f63346b;
            ChronoField chronoField17 = ChronoField.MICRO_OF_SECOND;
            if (map15.containsKey(chronoField17)) {
                a(chronoField17, (this.f63346b.remove(chronoField16).longValue() * 1000) + (this.f63346b.get(chronoField17).longValue() % 1000));
            }
        }
        Map<TemporalField, Long> map16 = this.f63346b;
        ChronoField chronoField18 = ChronoField.MICRO_OF_SECOND;
        if (map16.containsKey(chronoField18)) {
            Map<TemporalField, Long> map17 = this.f63346b;
            ChronoField chronoField19 = ChronoField.NANO_OF_SECOND;
            if (map17.containsKey(chronoField19)) {
                a(chronoField18, this.f63346b.get(chronoField19).longValue() / 1000);
                this.f63346b.remove(chronoField18);
            }
        }
        if (this.f63346b.containsKey(chronoField16)) {
            Map<TemporalField, Long> map18 = this.f63346b;
            ChronoField chronoField20 = ChronoField.NANO_OF_SECOND;
            if (map18.containsKey(chronoField20)) {
                a(chronoField16, this.f63346b.get(chronoField20).longValue() / 1000000);
                this.f63346b.remove(chronoField16);
            }
        }
        if (this.f63346b.containsKey(chronoField18)) {
            a(ChronoField.NANO_OF_SECOND, this.f63346b.remove(chronoField18).longValue() * 1000);
        } else if (this.f63346b.containsKey(chronoField16)) {
            a(ChronoField.NANO_OF_SECOND, this.f63346b.remove(chronoField16).longValue() * 1000000);
        }
    }

    private DateTimeBuilder putFieldValue0(TemporalField temporalField, long j11) {
        this.f63346b.put(temporalField, Long.valueOf(j11));
        return this;
    }

    private boolean resolveFields(ResolverStyle resolverStyle) {
        int i11 = 0;
        loop0:
        while (i11 < 100) {
            for (Map.Entry<TemporalField, Long> key : this.f63346b.entrySet()) {
                TemporalField temporalField = (TemporalField) key.getKey();
                Object resolve = temporalField.resolve(this.f63346b, this, resolverStyle);
                if (resolve != null) {
                    if (resolve instanceof ChronoZonedDateTime) {
                        ChronoZonedDateTime chronoZonedDateTime = (ChronoZonedDateTime) resolve;
                        ZoneId zoneId = this.f63348d;
                        if (zoneId == null) {
                            this.f63348d = chronoZonedDateTime.getZone();
                        } else if (!zoneId.equals(chronoZonedDateTime.getZone())) {
                            throw new DateTimeException("ChronoZonedDateTime must use the effective parsed zone: " + this.f63348d);
                        }
                        resolve = chronoZonedDateTime.toLocalDateTime();
                    }
                    if (resolve instanceof ChronoLocalDate) {
                        resolveMakeChanges(temporalField, (ChronoLocalDate) resolve);
                    } else if (resolve instanceof LocalTime) {
                        resolveMakeChanges(temporalField, (LocalTime) resolve);
                    } else if (resolve instanceof ChronoLocalDateTime) {
                        ChronoLocalDateTime chronoLocalDateTime = (ChronoLocalDateTime) resolve;
                        resolveMakeChanges(temporalField, chronoLocalDateTime.toLocalDate());
                        resolveMakeChanges(temporalField, chronoLocalDateTime.toLocalTime());
                    } else {
                        throw new DateTimeException("Unknown type: " + resolve.getClass().getName());
                    }
                } else if (!this.f63346b.containsKey(temporalField)) {
                }
                i11++;
            }
        }
        if (i11 == 100) {
            throw new DateTimeException("Badly written field");
        } else if (i11 > 0) {
            return true;
        } else {
            return false;
        }
    }

    private void resolveFractional() {
        if (this.f63350f != null) {
            return;
        }
        if (this.f63346b.containsKey(ChronoField.INSTANT_SECONDS) || this.f63346b.containsKey(ChronoField.SECOND_OF_DAY) || this.f63346b.containsKey(ChronoField.SECOND_OF_MINUTE)) {
            Map<TemporalField, Long> map = this.f63346b;
            ChronoField chronoField = ChronoField.NANO_OF_SECOND;
            if (map.containsKey(chronoField)) {
                long longValue = this.f63346b.get(chronoField).longValue();
                this.f63346b.put(ChronoField.MICRO_OF_SECOND, Long.valueOf(longValue / 1000));
                this.f63346b.put(ChronoField.MILLI_OF_SECOND, Long.valueOf(longValue / 1000000));
                return;
            }
            this.f63346b.put(chronoField, 0L);
            this.f63346b.put(ChronoField.MICRO_OF_SECOND, 0L);
            this.f63346b.put(ChronoField.MILLI_OF_SECOND, 0L);
        }
    }

    private void resolveInstant() {
        if (this.f63349e != null && this.f63350f != null) {
            Long l11 = this.f63346b.get(ChronoField.OFFSET_SECONDS);
            if (l11 != null) {
                ChronoZonedDateTime<?> atZone = this.f63349e.atTime(this.f63350f).atZone(ZoneOffset.ofTotalSeconds(l11.intValue()));
                ChronoField chronoField = ChronoField.INSTANT_SECONDS;
                this.f63346b.put(chronoField, Long.valueOf(atZone.getLong(chronoField)));
            } else if (this.f63348d != null) {
                ChronoZonedDateTime<?> atZone2 = this.f63349e.atTime(this.f63350f).atZone(this.f63348d);
                ChronoField chronoField2 = ChronoField.INSTANT_SECONDS;
                this.f63346b.put(chronoField2, Long.valueOf(atZone2.getLong(chronoField2)));
            }
        }
    }

    private void resolveMakeChanges(TemporalField temporalField, ChronoLocalDate chronoLocalDate) {
        if (this.f63347c.equals(chronoLocalDate.getChronology())) {
            long epochDay = chronoLocalDate.toEpochDay();
            Long put = this.f63346b.put(ChronoField.EPOCH_DAY, Long.valueOf(epochDay));
            if (put != null && put.longValue() != epochDay) {
                throw new DateTimeException("Conflict found: " + LocalDate.ofEpochDay(put.longValue()) + " differs from " + LocalDate.ofEpochDay(epochDay) + " while resolving  " + temporalField);
            }
            return;
        }
        throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + this.f63347c);
    }

    private void resolveTimeInferZeroes(ResolverStyle resolverStyle) {
        ResolverStyle resolverStyle2 = resolverStyle;
        Map<TemporalField, Long> map = this.f63346b;
        ChronoField chronoField = ChronoField.HOUR_OF_DAY;
        Long l11 = map.get(chronoField);
        Map<TemporalField, Long> map2 = this.f63346b;
        ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
        Long l12 = map2.get(chronoField2);
        Map<TemporalField, Long> map3 = this.f63346b;
        ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
        Long l13 = map3.get(chronoField3);
        Map<TemporalField, Long> map4 = this.f63346b;
        ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
        Long l14 = map4.get(chronoField4);
        if (l11 != null) {
            if (l12 == null && (l13 != null || l14 != null)) {
                return;
            }
            if (l12 == null || l13 != null || l14 == null) {
                if (resolverStyle2 != ResolverStyle.LENIENT) {
                    if (resolverStyle2 == ResolverStyle.SMART && l11.longValue() == 24 && ((l12 == null || l12.longValue() == 0) && ((l13 == null || l13.longValue() == 0) && (l14 == null || l14.longValue() == 0)))) {
                        l11 = 0L;
                        this.f63352h = Period.ofDays(1);
                    }
                    int checkValidIntValue = chronoField.checkValidIntValue(l11.longValue());
                    if (l12 != null) {
                        int checkValidIntValue2 = chronoField2.checkValidIntValue(l12.longValue());
                        if (l13 != null) {
                            int checkValidIntValue3 = chronoField3.checkValidIntValue(l13.longValue());
                            if (l14 != null) {
                                b(LocalTime.of(checkValidIntValue, checkValidIntValue2, checkValidIntValue3, chronoField4.checkValidIntValue(l14.longValue())));
                            } else {
                                b(LocalTime.of(checkValidIntValue, checkValidIntValue2, checkValidIntValue3));
                            }
                        } else if (l14 == null) {
                            b(LocalTime.of(checkValidIntValue, checkValidIntValue2));
                        }
                    } else if (l13 == null && l14 == null) {
                        b(LocalTime.of(checkValidIntValue, 0));
                    }
                } else {
                    long longValue = l11.longValue();
                    if (l12 == null) {
                        int safeToInt = Jdk8Methods.safeToInt(Jdk8Methods.floorDiv(longValue, 24));
                        b(LocalTime.of((int) ((long) Jdk8Methods.floorMod(longValue, 24)), 0));
                        this.f63352h = Period.ofDays(safeToInt);
                    } else if (l13 != null) {
                        if (l14 == null) {
                            l14 = 0L;
                        }
                        long safeAdd = Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(longValue, 3600000000000L), Jdk8Methods.safeMultiply(l12.longValue(), 60000000000L)), Jdk8Methods.safeMultiply(l13.longValue(), (long) C.NANOS_PER_SECOND)), l14.longValue());
                        b(LocalTime.ofNanoOfDay(Jdk8Methods.floorMod(safeAdd, 86400000000000L)));
                        this.f63352h = Period.ofDays((int) Jdk8Methods.floorDiv(safeAdd, 86400000000000L));
                    } else {
                        long safeAdd2 = Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(longValue, 3600), Jdk8Methods.safeMultiply(l12.longValue(), 60));
                        b(LocalTime.ofSecondOfDay(Jdk8Methods.floorMod(safeAdd2, 86400)));
                        this.f63352h = Period.ofDays((int) Jdk8Methods.floorDiv(safeAdd2, 86400));
                    }
                }
                this.f63346b.remove(chronoField);
                this.f63346b.remove(chronoField2);
                this.f63346b.remove(chronoField3);
                this.f63346b.remove(chronoField4);
            }
        }
    }

    public DateTimeBuilder a(TemporalField temporalField, long j11) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Long fieldValue0 = getFieldValue0(temporalField);
        if (fieldValue0 == null || fieldValue0.longValue() == j11) {
            return putFieldValue0(temporalField, j11);
        }
        throw new DateTimeException("Conflict found: " + temporalField + " " + fieldValue0 + " differs from " + temporalField + " " + j11 + ": " + this);
    }

    public void b(LocalTime localTime) {
        this.f63350f = localTime;
    }

    public <R> R build(TemporalQuery<R> temporalQuery) {
        return temporalQuery.queryFrom(this);
    }

    public void c(ChronoLocalDate chronoLocalDate) {
        this.f63349e = chronoLocalDate;
    }

    public long getLong(TemporalField temporalField) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Long fieldValue0 = getFieldValue0(temporalField);
        if (fieldValue0 != null) {
            return fieldValue0.longValue();
        }
        ChronoLocalDate chronoLocalDate = this.f63349e;
        if (chronoLocalDate != null && chronoLocalDate.isSupported(temporalField)) {
            return this.f63349e.getLong(temporalField);
        }
        LocalTime localTime = this.f63350f;
        if (localTime != null && localTime.isSupported(temporalField)) {
            return this.f63350f.getLong(temporalField);
        }
        throw new DateTimeException("Field not found: " + temporalField);
    }

    public boolean isSupported(TemporalField temporalField) {
        ChronoLocalDate chronoLocalDate;
        LocalTime localTime;
        if (temporalField == null) {
            return false;
        }
        if (this.f63346b.containsKey(temporalField) || (((chronoLocalDate = this.f63349e) != null && chronoLocalDate.isSupported(temporalField)) || ((localTime = this.f63350f) != null && localTime.isSupported(temporalField)))) {
            return true;
        }
        return false;
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.zoneId()) {
            return this.f63348d;
        }
        if (temporalQuery == TemporalQueries.chronology()) {
            return this.f63347c;
        }
        if (temporalQuery == TemporalQueries.localDate()) {
            ChronoLocalDate chronoLocalDate = this.f63349e;
            if (chronoLocalDate != null) {
                return LocalDate.from(chronoLocalDate);
            }
            return null;
        } else if (temporalQuery == TemporalQueries.localTime()) {
            return this.f63350f;
        } else {
            if (temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset()) {
                return temporalQuery.queryFrom(this);
            }
            if (temporalQuery == TemporalQueries.precision()) {
                return null;
            }
            return temporalQuery.queryFrom(this);
        }
    }

    public DateTimeBuilder resolve(ResolverStyle resolverStyle, Set<TemporalField> set) {
        ChronoLocalDate chronoLocalDate;
        if (set != null) {
            this.f63346b.keySet().retainAll(set);
        }
        mergeInstantFields();
        mergeDate(resolverStyle);
        mergeTime(resolverStyle);
        if (resolveFields(resolverStyle)) {
            mergeInstantFields();
            mergeDate(resolverStyle);
            mergeTime(resolverStyle);
        }
        resolveTimeInferZeroes(resolverStyle);
        crossCheck();
        Period period = this.f63352h;
        if (!(period == null || period.isZero() || (chronoLocalDate = this.f63349e) == null || this.f63350f == null)) {
            this.f63349e = chronoLocalDate.plus((TemporalAmount) this.f63352h);
            this.f63352h = Period.ZERO;
        }
        resolveFractional();
        resolveInstant();
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("DateTimeBuilder[");
        if (this.f63346b.size() > 0) {
            sb2.append("fields=");
            sb2.append(this.f63346b);
        }
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(this.f63347c);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(this.f63348d);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(this.f63349e);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(this.f63350f);
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }

    public DateTimeBuilder(TemporalField temporalField, long j11) {
        a(temporalField, j11);
    }

    private void crossCheck(TemporalAccessor temporalAccessor) {
        Iterator<Map.Entry<TemporalField, Long>> it = this.f63346b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            TemporalField temporalField = (TemporalField) next.getKey();
            long longValue = ((Long) next.getValue()).longValue();
            if (temporalAccessor.isSupported(temporalField)) {
                try {
                    long j11 = temporalAccessor.getLong(temporalField);
                    if (j11 == longValue) {
                        it.remove();
                    } else {
                        throw new DateTimeException("Cross check failed: " + temporalField + " " + j11 + " vs " + temporalField + " " + longValue);
                    }
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    private void resolveMakeChanges(TemporalField temporalField, LocalTime localTime) {
        long nanoOfDay = localTime.toNanoOfDay();
        Long put = this.f63346b.put(ChronoField.NANO_OF_DAY, Long.valueOf(nanoOfDay));
        if (put != null && put.longValue() != nanoOfDay) {
            throw new DateTimeException("Conflict found: " + LocalTime.ofNanoOfDay(put.longValue()) + " differs from " + localTime + " while resolving  " + temporalField);
        }
    }
}
