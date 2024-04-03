package coil.request;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0003\u001d\u001e\u001fB\u0007\b\u0016¢\u0006\u0002\u0010\u0005B\u001b\b\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0003J\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0006\u0010\u0015\u001a\u00020\u0011J\u001b\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u0003J\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0007R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006 "}, d2 = {"Lcoil/request/Parameters;", "", "Lkotlin/Pair;", "", "Lcoil/request/Parameters$Entry;", "()V", "map", "", "(Ljava/util/Map;)V", "size", "", "()I", "cacheKey", "key", "cacheKeys", "entry", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "", "newBuilder", "Lcoil/request/Parameters$Builder;", "toString", "value", "values", "Builder", "Companion", "Entry", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Parameters implements Iterable<Pair<? extends String, ? extends Entry>>, KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final Parameters EMPTY = new Parameters();
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, Entry> map;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/request/Parameters$Companion;", "", "()V", "EMPTY", "Lcoil/request/Parameters;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcoil/request/Parameters$Entry;", "", "value", "cacheKey", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getCacheKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Entry {
        @Nullable
        private final String cacheKey;
        @Nullable
        private final Object value;

        public Entry(@Nullable Object obj, @Nullable String str) {
            this.value = obj;
            this.cacheKey = str;
        }

        public static /* synthetic */ Entry copy$default(Entry entry, Object obj, String str, int i11, Object obj2) {
            if ((i11 & 1) != 0) {
                obj = entry.value;
            }
            if ((i11 & 2) != 0) {
                str = entry.cacheKey;
            }
            return entry.copy(obj, str);
        }

        @Nullable
        public final Object component1() {
            return this.value;
        }

        @Nullable
        public final String component2() {
            return this.cacheKey;
        }

        @NotNull
        public final Entry copy(@Nullable Object obj, @Nullable String str) {
            return new Entry(obj, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return Intrinsics.areEqual(this.value, entry.value) && Intrinsics.areEqual((Object) this.cacheKey, (Object) entry.cacheKey);
        }

        @Nullable
        public final String getCacheKey() {
            return this.cacheKey;
        }

        @Nullable
        public final Object getValue() {
            return this.value;
        }

        public int hashCode() {
            Object obj = this.value;
            int i11 = 0;
            int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
            String str = this.cacheKey;
            if (str != null) {
                i11 = str.hashCode();
            }
            return hashCode + i11;
        }

        @NotNull
        public String toString() {
            return "Entry(value=" + this.value + ", cacheKey=" + this.cacheKey + ')';
        }
    }

    private Parameters(Map<String, Entry> map2) {
        this.map = map2;
    }

    public /* synthetic */ Parameters(Map map2, DefaultConstructorMarker defaultConstructorMarker) {
        this(map2);
    }

    @Nullable
    public final String cacheKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Entry entry = this.map.get(str);
        if (entry == null) {
            return null;
        }
        return entry.getCacheKey();
    }

    @NotNull
    public final Map<String, String> cacheKeys() {
        if (isEmpty()) {
            return MapsKt__MapsKt.emptyMap();
        }
        Map<String, Entry> map2 = this.map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map2.entrySet()) {
            String cacheKey = ((Entry) next.getValue()).getCacheKey();
            if (cacheKey != null) {
                linkedHashMap.put(next.getKey(), cacheKey);
            }
        }
        return linkedHashMap;
    }

    @Nullable
    public final Entry entry(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.map.get(str);
    }

    public boolean equals(@Nullable Object obj) {
        return this == obj || ((obj instanceof Parameters) && Intrinsics.areEqual((Object) this.map, (Object) ((Parameters) obj).map));
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    @NotNull
    public Iterator<Pair<String, Entry>> iterator() {
        Map<String, Entry> map2 = this.map;
        ArrayList arrayList = new ArrayList(map2.size());
        for (Map.Entry next : map2.entrySet()) {
            arrayList.add(TuplesKt.to((String) next.getKey(), (Entry) next.getValue()));
        }
        return arrayList.iterator();
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @JvmName(name = "size")
    public final int size() {
        return this.map.size();
    }

    @NotNull
    public String toString() {
        return "Parameters(map=" + this.map + ')';
    }

    @Nullable
    public final Object value(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Entry entry = this.map.get(str);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @NotNull
    public final Map<String, Object> values() {
        if (isEmpty()) {
            return MapsKt__MapsKt.emptyMap();
        }
        Map<String, Entry> map2 = this.map;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map2.size()));
        for (Map.Entry entry : map2.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((Entry) entry.getValue()).getValue());
        }
        return linkedHashMap;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ&\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0007R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcoil/request/Parameters$Builder;", "", "()V", "parameters", "Lcoil/request/Parameters;", "(Lcoil/request/Parameters;)V", "map", "", "", "Lcoil/request/Parameters$Entry;", "build", "remove", "key", "set", "value", "cacheKey", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        @NotNull
        private final Map<String, Entry> map;

        public Builder() {
            this.map = new LinkedHashMap();
        }

        public static /* synthetic */ Builder set$default(Builder builder, String str, Object obj, String str2, int i11, Object obj2) {
            if ((i11 & 4) != 0) {
                str2 = obj == null ? null : obj.toString();
            }
            return builder.set(str, obj, str2);
        }

        @NotNull
        public final Parameters build() {
            return new Parameters(MapsKt__MapsKt.toMap(this.map), (DefaultConstructorMarker) null);
        }

        @NotNull
        public final Builder remove(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.map.remove(str);
            return this;
        }

        @NotNull
        @JvmOverloads
        public final Builder set(@NotNull String str, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(str, "key");
            return set$default(this, str, obj, (String) null, 4, (Object) null);
        }

        @NotNull
        @JvmOverloads
        public final Builder set(@NotNull String str, @Nullable Object obj, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.map.put(str, new Entry(obj, str2));
            return this;
        }

        public Builder(@NotNull Parameters parameters) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            this.map = MapsKt__MapsKt.toMutableMap(parameters.map);
        }
    }

    public Parameters() {
        this(MapsKt__MapsKt.emptyMap());
    }
}
