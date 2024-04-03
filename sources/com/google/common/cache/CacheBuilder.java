package com.google.common.cache;

import a9.a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.LocalCache;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class CacheBuilder<K, V> {
    static final Supplier<AbstractCache.StatsCounter> CACHE_STATS_COUNTER = new a();
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_REFRESH_NANOS = 0;
    static final CacheStats EMPTY_STATS = new CacheStats(0, 0, 0, 0, 0, 0);
    static final Supplier<? extends AbstractCache.StatsCounter> NULL_STATS_COUNTER = Suppliers.ofInstance(new AbstractCache.StatsCounter() {
        public void recordEviction() {
        }

        public void recordHits(int i11) {
        }

        public void recordLoadException(long j11) {
        }

        public void recordLoadSuccess(long j11) {
        }

        public void recordMisses(int i11) {
        }

        public CacheStats snapshot() {
            return CacheBuilder.EMPTY_STATS;
        }
    });
    static final Ticker NULL_TICKER = new Ticker() {
        public long read() {
            return 0;
        }
    };
    static final int UNSET_INT = -1;
    private static final Logger logger = Logger.getLogger(CacheBuilder.class.getName());
    int concurrencyLevel = -1;
    long expireAfterAccessNanos = -1;
    long expireAfterWriteNanos = -1;
    int initialCapacity = -1;
    @CheckForNull
    Equivalence<Object> keyEquivalence;
    @CheckForNull
    LocalCache.Strength keyStrength;
    long maximumSize = -1;
    long maximumWeight = -1;
    long refreshNanos = -1;
    @CheckForNull
    RemovalListener<? super K, ? super V> removalListener;
    Supplier<? extends AbstractCache.StatsCounter> statsCounterSupplier = NULL_STATS_COUNTER;
    boolean strictParsing = true;
    @CheckForNull
    Ticker ticker;
    @CheckForNull
    Equivalence<Object> valueEquivalence;
    @CheckForNull
    LocalCache.Strength valueStrength;
    @CheckForNull
    Weigher<? super K, ? super V> weigher;

    public enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    public enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    private CacheBuilder() {
    }

    private void checkNonLoadingCache() {
        Preconditions.checkState(this.refreshNanos == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void checkWeightWithWeigher() {
        boolean z11 = true;
        if (this.weigher == null) {
            if (this.maximumWeight != -1) {
                z11 = false;
            }
            Preconditions.checkState(z11, "maximumWeight requires weigher");
        } else if (this.strictParsing) {
            if (this.maximumWeight == -1) {
                z11 = false;
            }
            Preconditions.checkState(z11, "weigher requires maximumWeight");
        } else if (this.maximumWeight == -1) {
            logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.toCacheBuilder().lenientParsing();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ AbstractCache.StatsCounter lambda$static$0() {
        return new AbstractCache.SimpleStatsCounter();
    }

    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder<>();
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> cacheLoader) {
        checkWeightWithWeigher();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> concurrencyLevel(int i11) {
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

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> expireAfterAccess(long j11, TimeUnit timeUnit) {
        boolean z11;
        long j12 = this.expireAfterAccessNanos;
        boolean z12 = true;
        if (j12 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "expireAfterAccess was already set to %s ns", j12);
        if (j11 < 0) {
            z12 = false;
        }
        Preconditions.checkArgument(z12, "duration cannot be negative: %s %s", j11, (Object) timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(j11);
        return this;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> expireAfterWrite(long j11, TimeUnit timeUnit) {
        boolean z11;
        long j12 = this.expireAfterWriteNanos;
        boolean z12 = true;
        if (j12 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "expireAfterWrite was already set to %s ns", j12);
        if (j11 < 0) {
            z12 = false;
        }
        Preconditions.checkArgument(z12, "duration cannot be negative: %s %s", j11, (Object) timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(j11);
        return this;
    }

    public int getConcurrencyLevel() {
        int i11 = this.concurrencyLevel;
        if (i11 == -1) {
            return 4;
        }
        return i11;
    }

    public long getExpireAfterAccessNanos() {
        long j11 = this.expireAfterAccessNanos;
        if (j11 == -1) {
            return 0;
        }
        return j11;
    }

    public long getExpireAfterWriteNanos() {
        long j11 = this.expireAfterWriteNanos;
        if (j11 == -1) {
            return 0;
        }
        return j11;
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

    public LocalCache.Strength getKeyStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.keyStrength, LocalCache.Strength.STRONG);
    }

    public long getMaximumWeight() {
        if (this.expireAfterWriteNanos == 0 || this.expireAfterAccessNanos == 0) {
            return 0;
        }
        if (this.weigher == null) {
            return this.maximumSize;
        }
        return this.maximumWeight;
    }

    public long getRefreshNanos() {
        long j11 = this.refreshNanos;
        if (j11 == -1) {
            return 0;
        }
        return j11;
    }

    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> getRemovalListener() {
        return (RemovalListener) MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
    }

    public Supplier<? extends AbstractCache.StatsCounter> getStatsCounterSupplier() {
        return this.statsCounterSupplier;
    }

    public Ticker getTicker(boolean z11) {
        Ticker ticker2 = this.ticker;
        if (ticker2 != null) {
            return ticker2;
        }
        if (z11) {
            return Ticker.systemTicker();
        }
        return NULL_TICKER;
    }

    public Equivalence<Object> getValueEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.valueEquivalence, getValueStrength().defaultEquivalence());
    }

    public LocalCache.Strength getValueStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.valueStrength, LocalCache.Strength.STRONG);
    }

    public <K1 extends K, V1 extends V> Weigher<K1, V1> getWeigher() {
        return (Weigher) MoreObjects.firstNonNull(this.weigher, OneWeigher.INSTANCE);
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> initialCapacity(int i11) {
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

    public boolean isRecordingStats() {
        return this.statsCounterSupplier == CACHE_STATS_COUNTER;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> keyEquivalence(Equivalence<Object> equivalence) {
        boolean z11;
        Equivalence<Object> equivalence2 = this.keyEquivalence;
        if (equivalence2 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "key equivalence was already set to %s", (Object) equivalence2);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> lenientParsing() {
        this.strictParsing = false;
        return this;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> maximumSize(long j11) {
        boolean z11;
        boolean z12;
        boolean z13;
        long j12 = this.maximumSize;
        boolean z14 = true;
        if (j12 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "maximum size was already set to %s", j12);
        long j13 = this.maximumWeight;
        if (j13 == -1) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkState(z12, "maximum weight was already set to %s", j13);
        if (this.weigher == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        Preconditions.checkState(z13, "maximum size can not be combined with weigher");
        if (j11 < 0) {
            z14 = false;
        }
        Preconditions.checkArgument(z14, "maximum size must not be negative");
        this.maximumSize = j11;
        return this;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> maximumWeight(long j11) {
        boolean z11;
        boolean z12;
        long j12 = this.maximumWeight;
        boolean z13 = true;
        if (j12 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "maximum weight was already set to %s", j12);
        long j13 = this.maximumSize;
        if (j13 == -1) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkState(z12, "maximum size was already set to %s", j13);
        if (j11 < 0) {
            z13 = false;
        }
        Preconditions.checkArgument(z13, "maximum weight must not be negative");
        this.maximumWeight = j11;
        return this;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> recordStats() {
        this.statsCounterSupplier = CACHE_STATS_COUNTER;
        return this;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> refreshAfterWrite(long j11, TimeUnit timeUnit) {
        boolean z11;
        Preconditions.checkNotNull(timeUnit);
        long j12 = this.refreshNanos;
        boolean z12 = true;
        if (j12 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "refresh was already set to %s ns", j12);
        if (j11 <= 0) {
            z12 = false;
        }
        Preconditions.checkArgument(z12, "duration must be positive: %s %s", j11, (Object) timeUnit);
        this.refreshNanos = timeUnit.toNanos(j11);
        return this;
    }

    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> removalListener2) {
        boolean z11;
        if (this.removalListener == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        this.removalListener = (RemovalListener) Preconditions.checkNotNull(removalListener2);
        return this;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> setKeyStrength(LocalCache.Strength strength) {
        boolean z11;
        LocalCache.Strength strength2 = this.keyStrength;
        if (strength2 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "Key strength was already set to %s", (Object) strength2);
        this.keyStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> setValueStrength(LocalCache.Strength strength) {
        boolean z11;
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "Value strength was already set to %s", (Object) strength2);
        this.valueStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> softValues() {
        return setValueStrength(LocalCache.Strength.SOFT);
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> ticker(Ticker ticker2) {
        boolean z11;
        if (this.ticker == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        this.ticker = (Ticker) Preconditions.checkNotNull(ticker2);
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
        long j11 = this.maximumSize;
        if (j11 != -1) {
            stringHelper.add("maximumSize", j11);
        }
        long j12 = this.maximumWeight;
        if (j12 != -1) {
            stringHelper.add("maximumWeight", j12);
        }
        if (this.expireAfterWriteNanos != -1) {
            stringHelper.add("expireAfterWrite", (Object) this.expireAfterWriteNanos + "ns");
        }
        if (this.expireAfterAccessNanos != -1) {
            stringHelper.add("expireAfterAccess", (Object) this.expireAfterAccessNanos + "ns");
        }
        LocalCache.Strength strength = this.keyStrength;
        if (strength != null) {
            stringHelper.add("keyStrength", (Object) Ascii.toLowerCase(strength.toString()));
        }
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            stringHelper.add("valueStrength", (Object) Ascii.toLowerCase(strength2.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue((Object) "keyEquivalence");
        }
        if (this.valueEquivalence != null) {
            stringHelper.addValue((Object) "valueEquivalence");
        }
        if (this.removalListener != null) {
            stringHelper.addValue((Object) "removalListener");
        }
        return stringHelper.toString();
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> valueEquivalence(Equivalence<Object> equivalence) {
        boolean z11;
        Equivalence<Object> equivalence2 = this.valueEquivalence;
        if (equivalence2 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "value equivalence was already set to %s", (Object) equivalence2);
        this.valueEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> weakKeys() {
        return setKeyStrength(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> weakValues() {
        return setValueStrength(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> weigher2) {
        boolean z11;
        boolean z12 = true;
        if (this.weigher == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        if (this.strictParsing) {
            long j11 = this.maximumSize;
            if (j11 != -1) {
                z12 = false;
            }
            Preconditions.checkState(z12, "weigher can not be combined with maximum size (%s provided)", j11);
        }
        this.weigher = (Weigher) Preconditions.checkNotNull(weigher2);
        return this;
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(String str) {
        return from(CacheBuilderSpec.parse(str));
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        checkWeightWithWeigher();
        checkNonLoadingCache();
        return new LocalCache.LocalManualCache(this);
    }
}
