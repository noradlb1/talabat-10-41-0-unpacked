package org.threeten.bp.zone;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.zone.ZoneRules;

final class StandardZoneRules extends ZoneRules implements Serializable {
    private static final int LAST_CACHED_YEAR = 2100;
    private static final long serialVersionUID = 3044319355680032515L;
    private final ZoneOffsetTransitionRule[] lastRules;
    private final ConcurrentMap<Integer, ZoneOffsetTransition[]> lastRulesCache = new ConcurrentHashMap();
    private final long[] savingsInstantTransitions;
    private final LocalDateTime[] savingsLocalTransitions;
    private final ZoneOffset[] standardOffsets;
    private final long[] standardTransitions;
    private final ZoneOffset[] wallOffsets;

    public StandardZoneRules(ZoneOffset zoneOffset, ZoneOffset zoneOffset2, List<ZoneOffsetTransition> list, List<ZoneOffsetTransition> list2, List<ZoneOffsetTransitionRule> list3) {
        this.standardTransitions = new long[list.size()];
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[(list.size() + 1)];
        this.standardOffsets = zoneOffsetArr;
        zoneOffsetArr[0] = zoneOffset;
        int i11 = 0;
        while (i11 < list.size()) {
            this.standardTransitions[i11] = list.get(i11).toEpochSecond();
            int i12 = i11 + 1;
            this.standardOffsets[i12] = list.get(i11).getOffsetAfter();
            i11 = i12;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(zoneOffset2);
        for (ZoneOffsetTransition next : list2) {
            if (next.isGap()) {
                arrayList.add(next.getDateTimeBefore());
                arrayList.add(next.getDateTimeAfter());
            } else {
                arrayList.add(next.getDateTimeAfter());
                arrayList.add(next.getDateTimeBefore());
            }
            arrayList2.add(next.getOffsetAfter());
        }
        this.savingsLocalTransitions = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        this.wallOffsets = (ZoneOffset[]) arrayList2.toArray(new ZoneOffset[arrayList2.size()]);
        this.savingsInstantTransitions = new long[list2.size()];
        for (int i13 = 0; i13 < list2.size(); i13++) {
            this.savingsInstantTransitions[i13] = list2.get(i13).getInstant().getEpochSecond();
        }
        if (list3.size() <= 15) {
            this.lastRules = (ZoneOffsetTransitionRule[]) list3.toArray(new ZoneOffsetTransitionRule[list3.size()]);
            return;
        }
        throw new IllegalArgumentException("Too many transition rules");
    }

    public static StandardZoneRules a(DataInput dataInput) throws IOException, ClassNotFoundException {
        int readInt = dataInput.readInt();
        long[] jArr = new long[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            jArr[i11] = Ser.b(dataInput);
        }
        int i12 = readInt + 1;
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            zoneOffsetArr[i13] = Ser.c(dataInput);
        }
        int readInt2 = dataInput.readInt();
        long[] jArr2 = new long[readInt2];
        for (int i14 = 0; i14 < readInt2; i14++) {
            jArr2[i14] = Ser.b(dataInput);
        }
        int i15 = readInt2 + 1;
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i15];
        for (int i16 = 0; i16 < i15; i16++) {
            zoneOffsetArr2[i16] = Ser.c(dataInput);
        }
        int readByte = dataInput.readByte();
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = new ZoneOffsetTransitionRule[readByte];
        for (int i17 = 0; i17 < readByte; i17++) {
            zoneOffsetTransitionRuleArr[i17] = ZoneOffsetTransitionRule.a(dataInput);
        }
        return new StandardZoneRules(jArr, zoneOffsetArr, jArr2, zoneOffsetArr2, zoneOffsetTransitionRuleArr);
    }

    private Object findOffsetInfo(LocalDateTime localDateTime, ZoneOffsetTransition zoneOffsetTransition) {
        LocalDateTime dateTimeBefore = zoneOffsetTransition.getDateTimeBefore();
        if (zoneOffsetTransition.isGap()) {
            if (localDateTime.isBefore(dateTimeBefore)) {
                return zoneOffsetTransition.getOffsetBefore();
            }
            if (localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter())) {
                return zoneOffsetTransition;
            }
            return zoneOffsetTransition.getOffsetAfter();
        } else if (!localDateTime.isBefore(dateTimeBefore)) {
            return zoneOffsetTransition.getOffsetAfter();
        } else {
            if (localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter())) {
                return zoneOffsetTransition.getOffsetBefore();
            }
            return zoneOffsetTransition;
        }
    }

    private ZoneOffsetTransition[] findTransitionArray(int i11) {
        Integer valueOf = Integer.valueOf(i11);
        ZoneOffsetTransition[] zoneOffsetTransitionArr = this.lastRulesCache.get(valueOf);
        if (zoneOffsetTransitionArr != null) {
            return zoneOffsetTransitionArr;
        }
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = this.lastRules;
        ZoneOffsetTransition[] zoneOffsetTransitionArr2 = new ZoneOffsetTransition[zoneOffsetTransitionRuleArr.length];
        for (int i12 = 0; i12 < zoneOffsetTransitionRuleArr.length; i12++) {
            zoneOffsetTransitionArr2[i12] = zoneOffsetTransitionRuleArr[i12].createTransition(i11);
        }
        if (i11 < LAST_CACHED_YEAR) {
            this.lastRulesCache.putIfAbsent(valueOf, zoneOffsetTransitionArr2);
        }
        return zoneOffsetTransitionArr2;
    }

    private int findYear(long j11, ZoneOffset zoneOffset) {
        return LocalDate.ofEpochDay(Jdk8Methods.floorDiv(j11 + ((long) zoneOffset.getTotalSeconds()), 86400)).getYear();
    }

    private Object getOffsetInfo(LocalDateTime localDateTime) {
        int i11 = 0;
        if (this.lastRules.length > 0) {
            LocalDateTime[] localDateTimeArr = this.savingsLocalTransitions;
            if (localDateTimeArr.length == 0 || localDateTime.isAfter(localDateTimeArr[localDateTimeArr.length - 1])) {
                ZoneOffsetTransition[] findTransitionArray = findTransitionArray(localDateTime.getYear());
                int length = findTransitionArray.length;
                Object obj = null;
                while (i11 < length) {
                    ZoneOffsetTransition zoneOffsetTransition = findTransitionArray[i11];
                    Object findOffsetInfo = findOffsetInfo(localDateTime, zoneOffsetTransition);
                    if ((findOffsetInfo instanceof ZoneOffsetTransition) || findOffsetInfo.equals(zoneOffsetTransition.getOffsetBefore())) {
                        return findOffsetInfo;
                    }
                    i11++;
                    obj = findOffsetInfo;
                }
                return obj;
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsLocalTransitions, localDateTime);
        if (binarySearch == -1) {
            return this.wallOffsets[0];
        }
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        } else {
            LocalDateTime[] localDateTimeArr2 = this.savingsLocalTransitions;
            if (binarySearch < localDateTimeArr2.length - 1) {
                int i12 = binarySearch + 1;
                if (localDateTimeArr2[binarySearch].equals(localDateTimeArr2[i12])) {
                    binarySearch = i12;
                }
            }
        }
        if ((binarySearch & 1) != 0) {
            return this.wallOffsets[(binarySearch / 2) + 1];
        }
        LocalDateTime[] localDateTimeArr3 = this.savingsLocalTransitions;
        LocalDateTime localDateTime2 = localDateTimeArr3[binarySearch];
        LocalDateTime localDateTime3 = localDateTimeArr3[binarySearch + 1];
        ZoneOffset[] zoneOffsetArr = this.wallOffsets;
        int i13 = binarySearch / 2;
        ZoneOffset zoneOffset = zoneOffsetArr[i13];
        ZoneOffset zoneOffset2 = zoneOffsetArr[i13 + 1];
        if (zoneOffset2.getTotalSeconds() > zoneOffset.getTotalSeconds()) {
            return new ZoneOffsetTransition(localDateTime2, zoneOffset, zoneOffset2);
        }
        return new ZoneOffsetTransition(localDateTime3, zoneOffset, zoneOffset2);
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public void b(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.standardTransitions.length);
        for (long d11 : this.standardTransitions) {
            Ser.d(d11, dataOutput);
        }
        for (ZoneOffset e11 : this.standardOffsets) {
            Ser.e(e11, dataOutput);
        }
        dataOutput.writeInt(this.savingsInstantTransitions.length);
        for (long d12 : this.savingsInstantTransitions) {
            Ser.d(d12, dataOutput);
        }
        for (ZoneOffset e12 : this.wallOffsets) {
            Ser.e(e12, dataOutput);
        }
        dataOutput.writeByte(this.lastRules.length);
        for (ZoneOffsetTransitionRule b11 : this.lastRules) {
            b11.b(dataOutput);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StandardZoneRules) {
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            if (!Arrays.equals(this.standardTransitions, standardZoneRules.standardTransitions) || !Arrays.equals(this.standardOffsets, standardZoneRules.standardOffsets) || !Arrays.equals(this.savingsInstantTransitions, standardZoneRules.savingsInstantTransitions) || !Arrays.equals(this.wallOffsets, standardZoneRules.wallOffsets) || !Arrays.equals(this.lastRules, standardZoneRules.lastRules)) {
                return false;
            }
            return true;
        } else if (!(obj instanceof ZoneRules.Fixed)) {
            return false;
        } else {
            if (isFixedOffset()) {
                Instant instant = Instant.EPOCH;
                if (getOffset(instant).equals(((ZoneRules.Fixed) obj).getOffset(instant))) {
                    return true;
                }
            }
            return false;
        }
    }

    public Duration getDaylightSavings(Instant instant) {
        return Duration.ofSeconds((long) (getOffset(instant).getTotalSeconds() - getStandardOffset(instant).getTotalSeconds()));
    }

    public ZoneOffset getOffset(Instant instant) {
        long epochSecond = instant.getEpochSecond();
        if (this.lastRules.length > 0) {
            long[] jArr = this.savingsInstantTransitions;
            if (jArr.length == 0 || epochSecond > jArr[jArr.length - 1]) {
                ZoneOffset[] zoneOffsetArr = this.wallOffsets;
                ZoneOffsetTransition[] findTransitionArray = findTransitionArray(findYear(epochSecond, zoneOffsetArr[zoneOffsetArr.length - 1]));
                ZoneOffsetTransition zoneOffsetTransition = null;
                for (int i11 = 0; i11 < findTransitionArray.length; i11++) {
                    zoneOffsetTransition = findTransitionArray[i11];
                    if (epochSecond < zoneOffsetTransition.toEpochSecond()) {
                        return zoneOffsetTransition.getOffsetBefore();
                    }
                }
                return zoneOffsetTransition.getOffsetAfter();
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.wallOffsets[binarySearch + 1];
    }

    public ZoneOffset getStandardOffset(Instant instant) {
        int binarySearch = Arrays.binarySearch(this.standardTransitions, instant.getEpochSecond());
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.standardOffsets[binarySearch + 1];
    }

    public ZoneOffsetTransition getTransition(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return (ZoneOffsetTransition) offsetInfo;
        }
        return null;
    }

    public List<ZoneOffsetTransitionRule> getTransitionRules() {
        return Collections.unmodifiableList(Arrays.asList(this.lastRules));
    }

    public List<ZoneOffsetTransition> getTransitions() {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (true) {
            long[] jArr = this.savingsInstantTransitions;
            if (i11 >= jArr.length) {
                return Collections.unmodifiableList(arrayList);
            }
            long j11 = jArr[i11];
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            ZoneOffset zoneOffset = zoneOffsetArr[i11];
            i11++;
            arrayList.add(new ZoneOffsetTransition(j11, zoneOffset, zoneOffsetArr[i11]));
        }
    }

    public List<ZoneOffset> getValidOffsets(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return ((ZoneOffsetTransition) offsetInfo).a();
        }
        return Collections.singletonList((ZoneOffset) offsetInfo);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.standardTransitions) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets)) ^ Arrays.hashCode(this.lastRules);
    }

    public boolean isDaylightSavings(Instant instant) {
        return !getStandardOffset(instant).equals(getOffset(instant));
    }

    public boolean isFixedOffset() {
        return this.savingsInstantTransitions.length == 0 && this.lastRules.length == 0 && this.wallOffsets[0].equals(this.standardOffsets[0]);
    }

    public boolean isValidOffset(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return getValidOffsets(localDateTime).contains(zoneOffset);
    }

    public ZoneOffsetTransition nextTransition(Instant instant) {
        int i11;
        if (this.savingsInstantTransitions.length == 0) {
            return null;
        }
        long epochSecond = instant.getEpochSecond();
        long[] jArr = this.savingsInstantTransitions;
        if (epochSecond < jArr[jArr.length - 1]) {
            int binarySearch = Arrays.binarySearch(jArr, epochSecond);
            if (binarySearch < 0) {
                i11 = (-binarySearch) - 1;
            } else {
                i11 = binarySearch + 1;
            }
            long j11 = this.savingsInstantTransitions[i11];
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            return new ZoneOffsetTransition(j11, zoneOffsetArr[i11], zoneOffsetArr[i11 + 1]);
        } else if (this.lastRules.length == 0) {
            return null;
        } else {
            ZoneOffset[] zoneOffsetArr2 = this.wallOffsets;
            int findYear = findYear(epochSecond, zoneOffsetArr2[zoneOffsetArr2.length - 1]);
            for (ZoneOffsetTransition zoneOffsetTransition : findTransitionArray(findYear)) {
                if (epochSecond < zoneOffsetTransition.toEpochSecond()) {
                    return zoneOffsetTransition;
                }
            }
            if (findYear < 999999999) {
                return findTransitionArray(findYear + 1)[0];
            }
            return null;
        }
    }

    public ZoneOffsetTransition previousTransition(Instant instant) {
        if (this.savingsInstantTransitions.length == 0) {
            return null;
        }
        long epochSecond = instant.getEpochSecond();
        if (instant.getNano() > 0 && epochSecond < Long.MAX_VALUE) {
            epochSecond++;
        }
        long[] jArr = this.savingsInstantTransitions;
        long j11 = jArr[jArr.length - 1];
        if (this.lastRules.length > 0 && epochSecond > j11) {
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            ZoneOffset zoneOffset = zoneOffsetArr[zoneOffsetArr.length - 1];
            int findYear = findYear(epochSecond, zoneOffset);
            ZoneOffsetTransition[] findTransitionArray = findTransitionArray(findYear);
            for (int length = findTransitionArray.length - 1; length >= 0; length--) {
                if (epochSecond > findTransitionArray[length].toEpochSecond()) {
                    return findTransitionArray[length];
                }
            }
            int i11 = findYear - 1;
            if (i11 > findYear(j11, zoneOffset)) {
                ZoneOffsetTransition[] findTransitionArray2 = findTransitionArray(i11);
                return findTransitionArray2[findTransitionArray2.length - 1];
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        if (binarySearch <= 0) {
            return null;
        }
        int i12 = binarySearch - 1;
        long j12 = this.savingsInstantTransitions[i12];
        ZoneOffset[] zoneOffsetArr2 = this.wallOffsets;
        return new ZoneOffsetTransition(j12, zoneOffsetArr2[i12], zoneOffsetArr2[binarySearch]);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("StandardZoneRules[currentStandardOffset=");
        ZoneOffset[] zoneOffsetArr = this.standardOffsets;
        sb2.append(zoneOffsetArr[zoneOffsetArr.length - 1]);
        sb2.append("]");
        return sb2.toString();
    }

    public ZoneOffset getOffset(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return ((ZoneOffsetTransition) offsetInfo).getOffsetBefore();
        }
        return (ZoneOffset) offsetInfo;
    }

    private StandardZoneRules(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr) {
        this.standardTransitions = jArr;
        this.standardOffsets = zoneOffsetArr;
        this.savingsInstantTransitions = jArr2;
        this.wallOffsets = zoneOffsetArr2;
        this.lastRules = zoneOffsetTransitionRuleArr;
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < jArr2.length) {
            int i12 = i11 + 1;
            ZoneOffsetTransition zoneOffsetTransition = new ZoneOffsetTransition(jArr2[i11], zoneOffsetArr2[i11], zoneOffsetArr2[i12]);
            if (zoneOffsetTransition.isGap()) {
                arrayList.add(zoneOffsetTransition.getDateTimeBefore());
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
            } else {
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
                arrayList.add(zoneOffsetTransition.getDateTimeBefore());
            }
            i11 = i12;
        }
        this.savingsLocalTransitions = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
    }
}
