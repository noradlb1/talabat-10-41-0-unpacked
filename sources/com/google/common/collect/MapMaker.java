package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMakerInternalMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class MapMaker {
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final int UNSET_INT = -1;
    int concurrencyLevel = -1;
    int initialCapacity = -1;
    @CheckForNull
    Equivalence<Object> keyEquivalence;
    @CheckForNull
    MapMakerInternalMap.Strength keyStrength;
    boolean useCustomMap;
    @CheckForNull
    MapMakerInternalMap.Strength valueStrength;

    public enum Dummy {
        VALUE
    }

    @CanIgnoreReturnValue
    public MapMaker concurrencyLevel(int i11) {
        boolean z11;
        int i12 = this.concurrencyLevel;
        boolean z12 = true;
        if (i12 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "concurrency level was already set to %s", i12);
        if (i11 <= 0) {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        this.concurrencyLevel = i11;
        return this;
    }

    public int getConcurrencyLevel() {
        int i11 = this.concurrencyLevel;
        if (i11 == -1) {
            return 4;
        }
        return i11;
    }

    public int getInitialCapacity() {
        int i11 = this.initialCapacity;
        if (i11 == -1) {
            return 16;
        }
        return i11;
    }

    public Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    public MapMakerInternalMap.Strength getKeyStrength() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.keyStrength, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMakerInternalMap.Strength getValueStrength() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.valueStrength, MapMakerInternalMap.Strength.STRONG);
    }

    @CanIgnoreReturnValue
    public MapMaker initialCapacity(int i11) {
        boolean z11;
        int i12 = this.initialCapacity;
        boolean z12 = true;
        if (i12 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "initial capacity was already set to %s", i12);
        if (i11 < 0) {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        this.initialCapacity = i11;
        return this;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public MapMaker keyEquivalence(Equivalence<Object> equivalence) {
        boolean z11;
        Equivalence<Object> equivalence2 = this.keyEquivalence;
        if (equivalence2 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "key equivalence was already set to %s", (Object) equivalence2);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        this.useCustomMap = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> makeMap() {
        if (!this.useCustomMap) {
            return new ConcurrentHashMap(getInitialCapacity(), 0.75f, getConcurrencyLevel());
        }
        return MapMakerInternalMap.create(this);
    }

    public MapMaker setKeyStrength(MapMakerInternalMap.Strength strength) {
        boolean z11;
        MapMakerInternalMap.Strength strength2 = this.keyStrength;
        if (strength2 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "Key strength was already set to %s", (Object) strength2);
        this.keyStrength = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.useCustomMap = true;
        }
        return this;
    }

    public MapMaker setValueStrength(MapMakerInternalMap.Strength strength) {
        boolean z11;
        MapMakerInternalMap.Strength strength2 = this.valueStrength;
        if (strength2 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "Value strength was already set to %s", (Object) strength2);
        this.valueStrength = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.useCustomMap = true;
        }
        return this;
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper((Object) this);
        int i11 = this.initialCapacity;
        if (i11 != -1) {
            stringHelper.add("initialCapacity", i11);
        }
        int i12 = this.concurrencyLevel;
        if (i12 != -1) {
            stringHelper.add("concurrencyLevel", i12);
        }
        MapMakerInternalMap.Strength strength = this.keyStrength;
        if (strength != null) {
            stringHelper.add("keyStrength", (Object) Ascii.toLowerCase(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            stringHelper.add("valueStrength", (Object) Ascii.toLowerCase(strength2.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue((Object) "keyEquivalence");
        }
        return stringHelper.toString();
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public MapMaker weakKeys() {
        return setKeyStrength(MapMakerInternalMap.Strength.WEAK);
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public MapMaker weakValues() {
        return setValueStrength(MapMakerInternalMap.Strength.WEAK);
    }
}
