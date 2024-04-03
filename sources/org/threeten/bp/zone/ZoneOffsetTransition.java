package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class ZoneOffsetTransition implements Comparable<ZoneOffsetTransition>, Serializable {
    private static final long serialVersionUID = -6946044323557704546L;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final LocalDateTime transition;

    public ZoneOffsetTransition(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.transition = localDateTime;
        this.offsetBefore = zoneOffset;
        this.offsetAfter = zoneOffset2;
    }

    public static ZoneOffsetTransition b(DataInput dataInput) throws IOException {
        long b11 = Ser.b(dataInput);
        ZoneOffset c11 = Ser.c(dataInput);
        ZoneOffset c12 = Ser.c(dataInput);
        if (!c11.equals(c12)) {
            return new ZoneOffsetTransition(b11, c11, c12);
        }
        throw new IllegalArgumentException("Offsets must not be equal");
    }

    private int getDurationSeconds() {
        return getOffsetAfter().getTotalSeconds() - getOffsetBefore().getTotalSeconds();
    }

    public static ZoneOffsetTransition of(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        Jdk8Methods.requireNonNull(localDateTime, "transition");
        Jdk8Methods.requireNonNull(zoneOffset, "offsetBefore");
        Jdk8Methods.requireNonNull(zoneOffset2, "offsetAfter");
        if (zoneOffset.equals(zoneOffset2)) {
            throw new IllegalArgumentException("Offsets must not be equal");
        } else if (localDateTime.getNano() == 0) {
            return new ZoneOffsetTransition(localDateTime, zoneOffset, zoneOffset2);
        } else {
            throw new IllegalArgumentException("Nano-of-second must be zero");
        }
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    public List<ZoneOffset> a() {
        if (isGap()) {
            return Collections.emptyList();
        }
        return Arrays.asList(new ZoneOffset[]{getOffsetBefore(), getOffsetAfter()});
    }

    public void c(DataOutput dataOutput) throws IOException {
        Ser.d(toEpochSecond(), dataOutput);
        Ser.e(this.offsetBefore, dataOutput);
        Ser.e(this.offsetAfter, dataOutput);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransition)) {
            return false;
        }
        ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) obj;
        if (!this.transition.equals(zoneOffsetTransition.transition) || !this.offsetBefore.equals(zoneOffsetTransition.offsetBefore) || !this.offsetAfter.equals(zoneOffsetTransition.offsetAfter)) {
            return false;
        }
        return true;
    }

    public LocalDateTime getDateTimeAfter() {
        return this.transition.plusSeconds((long) getDurationSeconds());
    }

    public LocalDateTime getDateTimeBefore() {
        return this.transition;
    }

    public Duration getDuration() {
        return Duration.ofSeconds((long) getDurationSeconds());
    }

    public Instant getInstant() {
        return this.transition.toInstant(this.offsetBefore);
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    public int hashCode() {
        return (this.transition.hashCode() ^ this.offsetBefore.hashCode()) ^ Integer.rotateLeft(this.offsetAfter.hashCode(), 16);
    }

    public boolean isGap() {
        return getOffsetAfter().getTotalSeconds() > getOffsetBefore().getTotalSeconds();
    }

    public boolean isOverlap() {
        return getOffsetAfter().getTotalSeconds() < getOffsetBefore().getTotalSeconds();
    }

    public boolean isValidOffset(ZoneOffset zoneOffset) {
        if (isGap()) {
            return false;
        }
        return getOffsetBefore().equals(zoneOffset) || getOffsetAfter().equals(zoneOffset);
    }

    public long toEpochSecond() {
        return this.transition.toEpochSecond(this.offsetBefore);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Transition[");
        if (isGap()) {
            str = "Gap";
        } else {
            str = "Overlap";
        }
        sb2.append(str);
        sb2.append(" at ");
        sb2.append(this.transition);
        sb2.append(this.offsetBefore);
        sb2.append(" to ");
        sb2.append(this.offsetAfter);
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }

    public int compareTo(ZoneOffsetTransition zoneOffsetTransition) {
        return getInstant().compareTo(zoneOffsetTransition.getInstant());
    }

    public ZoneOffsetTransition(long j11, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.transition = LocalDateTime.ofEpochSecond(j11, 0, zoneOffset);
        this.offsetBefore = zoneOffset;
        this.offsetAfter = zoneOffset2;
    }
}
