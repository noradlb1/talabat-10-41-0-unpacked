package kotlin.collections.builders;

import com.huawei.hms.flutter.map.constants.Param;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.IntRange;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 {*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005:\u0007{|}~\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBE\b\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0002\u0010\u0012J\u0017\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0000¢\u0006\u0004\b4\u00105J\u0013\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0002¢\u0006\u0002\u00107J\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109J\r\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\b<J\b\u0010=\u001a\u00020;H\u0016J\b\u0010>\u001a\u00020;H\u0002J\u0019\u0010?\u001a\u00020!2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030AH\u0000¢\u0006\u0002\bBJ!\u0010C\u001a\u00020!2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010EH\u0000¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u00020!2\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010HJ\u0015\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010HJ\u0018\u0010K\u001a\u00020!2\u000e\u0010L\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000309H\u0002J\u0010\u0010M\u001a\u00020;2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020\bH\u0002J\u0019\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010QH\u0000¢\u0006\u0002\bRJ\u0013\u0010S\u001a\u00020!2\b\u0010L\u001a\u0004\u0018\u00010TH\u0002J\u0015\u0010U\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00105J\u0015\u0010V\u001a\u00020\b2\u0006\u0010J\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00105J\u0018\u0010W\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00105J\b\u0010Z\u001a\u00020\bH\u0016J\b\u0010[\u001a\u00020!H\u0016J\u0019\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010]H\u0000¢\u0006\u0002\b^J\u001f\u0010_\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u00002\u0006\u0010J\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010`J\u001e\u0010a\u001a\u00020;2\u0014\u0010b\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109H\u0016J\"\u0010c\u001a\u00020!2\u0018\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010E0AH\u0002J\u001c\u0010d\u001a\u00020!2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010EH\u0002J\u0010\u0010e\u001a\u00020!2\u0006\u0010f\u001a\u00020\bH\u0002J\u0010\u0010g\u001a\u00020;2\u0006\u0010h\u001a\u00020\bH\u0002J\u0017\u0010i\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010XJ!\u0010j\u001a\u00020!2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010EH\u0000¢\u0006\u0002\bkJ\u0010\u0010l\u001a\u00020;2\u0006\u0010m\u001a\u00020\bH\u0002J\u0017\u0010n\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0000¢\u0006\u0004\bo\u00105J\u0010\u0010p\u001a\u00020;2\u0006\u0010q\u001a\u00020\bH\u0002J\u0017\u0010r\u001a\u00020!2\u0006\u0010s\u001a\u00028\u0001H\u0000¢\u0006\u0004\bt\u0010HJ\b\u0010u\u001a\u00020vH\u0016J\u0019\u0010w\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010xH\u0000¢\u0006\u0002\byJ\b\u0010z\u001a\u00020TH\u0002R\u0014\u0010\u0013\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00180\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u001e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001aR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0015R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010-8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u00100\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u000101X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "length", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "capacity", "getCapacity", "()I", "entries", "", "", "getEntries", "()Ljava/util/Set;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "hashShift", "hashSize", "getHashSize", "<set-?>", "", "isReadOnly", "isReadOnly$kotlin_stdlib", "()Z", "keys", "getKeys", "[Ljava/lang/Object;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "addKey", "key", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "allocateValuesArray", "()[Ljava/lang/Object;", "build", "", "checkIsMutable", "", "checkIsMutable$kotlin_stdlib", "clear", "compact", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "contentEquals", "other", "ensureCapacity", "ensureExtraCapacity", "n", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "equals", "", "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "hashCode", "isEmpty", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "putAllEntries", "putEntry", "putRehash", "i", "rehash", "newHashSize", "remove", "removeEntry", "removeEntry$kotlin_stdlib", "removeHashAt", "removedHash", "removeKey", "removeKey$kotlin_stdlib", "removeKeyAt", "index", "removeValue", "element", "removeValue$kotlin_stdlib", "toString", "", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "writeReplace", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int INITIAL_CAPACITY = 8;
    @Deprecated
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    @Deprecated
    private static final int MAGIC = -1640531527;
    @Deprecated
    private static final int TOMBSTONE = -1;
    @Nullable
    private MapBuilderEntries<K, V> entriesView;
    @NotNull
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    /* access modifiers changed from: private */
    @NotNull
    public K[] keysArray;
    @Nullable
    private MapBuilderKeys<K> keysView;
    /* access modifiers changed from: private */
    public int length;
    private int maxProbeDistance;
    /* access modifiers changed from: private */
    @NotNull
    public int[] presenceArray;
    private int size;
    /* access modifiers changed from: private */
    @Nullable
    public V[] valuesArray;
    @Nullable
    private MapBuilderValues<V> valuesView;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", "", "()V", "INITIAL_CAPACITY", "", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final int computeHashSize(int i11) {
            return Integer.highestOneBit(RangesKt___RangesKt.coerceAtLeast(i11, 1) * 3);
        }

        /* access modifiers changed from: private */
        public final int computeShift(int i11) {
            return Integer.numberOfLeadingZeros(i11) + 1;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator, j$.util.Iterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EntriesItr(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, Param.MAP);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public final void nextAppendString(@NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(sb2, "sb");
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                Object obj = getMap$kotlin_stdlib().keysArray[getLastIndex$kotlin_stdlib()];
                if (Intrinsics.areEqual(obj, (Object) getMap$kotlin_stdlib())) {
                    sb2.append("(this Map)");
                } else {
                    sb2.append(obj);
                }
                sb2.append(SignatureVisitor.INSTANCEOF);
                Object[] access$getValuesArray$p = getMap$kotlin_stdlib().valuesArray;
                Intrinsics.checkNotNull(access$getValuesArray$p);
                Object obj2 = access$getValuesArray$p[getLastIndex$kotlin_stdlib()];
                if (Intrinsics.areEqual(obj2, (Object) getMap$kotlin_stdlib())) {
                    sb2.append("(this Map)");
                } else {
                    sb2.append(obj2);
                }
                initNext$kotlin_stdlib();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int nextHashCode$kotlin_stdlib() {
            int i11;
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                Object obj = getMap$kotlin_stdlib().keysArray[getLastIndex$kotlin_stdlib()];
                int i12 = 0;
                if (obj != null) {
                    i11 = obj.hashCode();
                } else {
                    i11 = 0;
                }
                Object[] access$getValuesArray$p = getMap$kotlin_stdlib().valuesArray;
                Intrinsics.checkNotNull(access$getValuesArray$p);
                Object obj2 = access$getValuesArray$p[getLastIndex$kotlin_stdlib()];
                if (obj2 != null) {
                    i12 = obj2.hashCode();
                }
                int i13 = i11 ^ i12;
                initNext$kotlin_stdlib();
                return i13;
            }
            throw new NoSuchElementException();
        }

        @NotNull
        public EntryRef<K, V> next() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                EntryRef<K, V> entryRef = new EntryRef<>(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
                initNext$kotlin_stdlib();
                return entryRef;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0015\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "(Lkotlin/collections/builders/MapBuilder;I)V", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", "", "other", "", "hashCode", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final int index;
        @NotNull
        private final MapBuilder<K, V> map;

        public EntryRef(@NotNull MapBuilder<K, V> mapBuilder, int i11) {
            Intrinsics.checkNotNullParameter(mapBuilder, Param.MAP);
            this.map = mapBuilder;
            this.index = i11;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (!Intrinsics.areEqual(entry.getKey(), getKey()) || !Intrinsics.areEqual(entry.getValue(), getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public K getKey() {
            return this.map.keysArray[this.index];
        }

        public V getValue() {
            V[] access$getValuesArray$p = this.map.valuesArray;
            Intrinsics.checkNotNull(access$getValuesArray$p);
            return access$getValuesArray$p[this.index];
        }

        public int hashCode() {
            Object key = getKey();
            int i11 = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            if (value != null) {
                i11 = value.hashCode();
            }
            return hashCode ^ i11;
        }

        public V setValue(V v11) {
            this.map.checkIsMutable$kotlin_stdlib();
            V[] access$allocateValuesArray = this.map.allocateValuesArray();
            int i11 = this.index;
            V v12 = access$allocateValuesArray[i11];
            access$allocateValuesArray[i11] = v11;
            return v12;
        }

        @NotNull
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append(SignatureVisitor.INSTANCEOF);
            sb2.append(getValue());
            return sb2.toString();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "index", "", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "hasNext", "", "initNext", "", "initNext$kotlin_stdlib", "remove", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class Itr<K, V> {
        private int index;
        private int lastIndex = -1;
        @NotNull
        private final MapBuilder<K, V> map;

        public Itr(@NotNull MapBuilder<K, V> mapBuilder) {
            Intrinsics.checkNotNullParameter(mapBuilder, Param.MAP);
            this.map = mapBuilder;
            initNext$kotlin_stdlib();
        }

        public final int getIndex$kotlin_stdlib() {
            return this.index;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.lastIndex;
        }

        @NotNull
        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }

        public final boolean hasNext() {
            return this.index < this.map.length;
        }

        public final void initNext$kotlin_stdlib() {
            while (this.index < this.map.length) {
                int[] access$getPresenceArray$p = this.map.presenceArray;
                int i11 = this.index;
                if (access$getPresenceArray$p[i11] < 0) {
                    this.index = i11 + 1;
                } else {
                    return;
                }
            }
        }

        public final void remove() {
            boolean z11;
            if (this.lastIndex != -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.map.checkIsMutable$kotlin_stdlib();
                this.map.removeKeyAt(this.lastIndex);
                this.lastIndex = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }

        public final void setIndex$kotlin_stdlib(int i11) {
            this.index = i11;
        }

        public final void setLastIndex$kotlin_stdlib(int i11) {
            this.lastIndex = i11;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0002H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class KeysItr<K, V> extends Itr<K, V> implements java.util.Iterator<K>, KMutableIterator, j$.util.Iterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public KeysItr(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, Param.MAP);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public K next() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                K k11 = getMap$kotlin_stdlib().keysArray[getLastIndex$kotlin_stdlib()];
                initNext$kotlin_stdlib();
                return k11;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0003H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ValuesItr<K, V> extends Itr<K, V> implements java.util.Iterator<V>, KMutableIterator, j$.util.Iterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ValuesItr(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, Param.MAP);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public V next() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                V[] access$getValuesArray$p = getMap$kotlin_stdlib().valuesArray;
                Intrinsics.checkNotNull(access$getValuesArray$p);
                V v11 = access$getValuesArray$p[getLastIndex$kotlin_stdlib()];
                initNext$kotlin_stdlib();
                return v11;
            }
            throw new NoSuchElementException();
        }
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i11, int i12) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i11;
        this.length = i12;
        this.hashShift = Companion.computeShift(getHashSize());
    }

    /* access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] arrayOfUninitializedElements = ListBuilderKt.arrayOfUninitializedElements(getCapacity());
        this.valuesArray = arrayOfUninitializedElements;
        return arrayOfUninitializedElements;
    }

    private final void compact() {
        int i11;
        V[] vArr = this.valuesArray;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            i11 = this.length;
            if (i12 >= i11) {
                break;
            }
            if (this.presenceArray[i12] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i13] = kArr[i12];
                if (vArr != null) {
                    vArr[i13] = vArr[i12];
                }
                i13++;
            }
            i12++;
        }
        ListBuilderKt.resetRange(this.keysArray, i13, i11);
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, i13, this.length);
        }
        this.length = i13;
    }

    private final boolean contentEquals(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    private final void ensureCapacity(int i11) {
        V[] vArr;
        if (i11 < 0) {
            throw new OutOfMemoryError();
        } else if (i11 > getCapacity()) {
            int capacity = (getCapacity() * 3) / 2;
            if (i11 <= capacity) {
                i11 = capacity;
            }
            this.keysArray = ListBuilderKt.copyOfUninitializedElements(this.keysArray, i11);
            V[] vArr2 = this.valuesArray;
            if (vArr2 != null) {
                vArr = ListBuilderKt.copyOfUninitializedElements(vArr2, i11);
            } else {
                vArr = null;
            }
            this.valuesArray = vArr;
            int[] copyOf = Arrays.copyOf(this.presenceArray, i11);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.presenceArray = copyOf;
            int access$computeHashSize = Companion.computeHashSize(i11);
            if (access$computeHashSize > getHashSize()) {
                rehash(access$computeHashSize);
            }
        } else if ((this.length + i11) - size() > getCapacity()) {
            rehash(getHashSize());
        }
    }

    private final void ensureExtraCapacity(int i11) {
        ensureCapacity(this.length + i11);
    }

    private final int findKey(K k11) {
        int hash = hash(k11);
        int i11 = this.maxProbeDistance;
        while (true) {
            int i12 = this.hashArray[hash];
            if (i12 == 0) {
                return -1;
            }
            if (i12 > 0) {
                int i13 = i12 - 1;
                if (Intrinsics.areEqual((Object) this.keysArray[i13], (Object) k11)) {
                    return i13;
                }
            }
            i11--;
            if (i11 < 0) {
                return -1;
            }
            int i14 = hash - 1;
            if (hash == 0) {
                hash = getHashSize() - 1;
            } else {
                hash = i14;
            }
        }
    }

    private final int findValue(V v11) {
        int i11 = this.length;
        while (true) {
            i11--;
            if (i11 < 0) {
                return -1;
            }
            if (this.presenceArray[i11] >= 0) {
                V[] vArr = this.valuesArray;
                Intrinsics.checkNotNull(vArr);
                if (Intrinsics.areEqual((Object) vArr[i11], (Object) v11)) {
                    return i11;
                }
            }
        }
    }

    private final int getCapacity() {
        return this.keysArray.length;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k11) {
        return ((k11 != null ? k11.hashCode() : 0) * MAGIC) >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z11 = false;
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        for (Map.Entry putEntry : collection) {
            if (putEntry(putEntry)) {
                z11 = true;
            }
        }
        return z11;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        Object[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib >= 0) {
            allocateValuesArray[addKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i11 = (-addKey$kotlin_stdlib) - 1;
        if (Intrinsics.areEqual((Object) entry.getValue(), allocateValuesArray[i11])) {
            return false;
        }
        allocateValuesArray[i11] = entry.getValue();
        return true;
    }

    private final boolean putRehash(int i11) {
        int hash = hash(this.keysArray[i11]);
        int i12 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[hash] == 0) {
                iArr[hash] = i11 + 1;
                this.presenceArray[i11] = hash;
                return true;
            }
            i12--;
            if (i12 < 0) {
                return false;
            }
            int i13 = hash - 1;
            if (hash == 0) {
                hash = getHashSize() - 1;
            } else {
                hash = i13;
            }
        }
    }

    private final void rehash(int i11) {
        if (this.length > size()) {
            compact();
        }
        int i12 = 0;
        if (i11 != getHashSize()) {
            this.hashArray = new int[i11];
            this.hashShift = Companion.computeShift(i11);
        } else {
            ArraysKt___ArraysJvmKt.fill(this.hashArray, 0, 0, getHashSize());
        }
        while (i12 < this.length) {
            int i13 = i12 + 1;
            if (putRehash(i12)) {
                i12 = i13;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    private final void removeHashAt(int i11) {
        int coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
        int i12 = 0;
        int i13 = i11;
        do {
            int i14 = i11 - 1;
            if (i11 == 0) {
                i11 = getHashSize() - 1;
            } else {
                i11 = i14;
            }
            i12++;
            if (i12 > this.maxProbeDistance) {
                this.hashArray[i13] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i15 = iArr[i11];
            if (i15 == 0) {
                iArr[i13] = 0;
                return;
            }
            if (i15 < 0) {
                iArr[i13] = -1;
            } else {
                int i16 = i15 - 1;
                if (((hash(this.keysArray[i16]) - i11) & (getHashSize() - 1)) >= i12) {
                    this.hashArray[i13] = i15;
                    this.presenceArray[i16] = i13;
                }
                coerceAtMost--;
            }
            i13 = i11;
            i12 = 0;
            coerceAtMost--;
        } while (coerceAtMost >= 0);
        this.hashArray[i13] = -1;
    }

    /* access modifiers changed from: private */
    public final void removeKeyAt(int i11) {
        ListBuilderKt.resetAt(this.keysArray, i11);
        removeHashAt(this.presenceArray[i11]);
        this.presenceArray[i11] = -1;
        this.size = size() - 1;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K k11) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(k11);
            int coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
            int i11 = 0;
            while (true) {
                int i12 = this.hashArray[hash];
                if (i12 <= 0) {
                    if (this.length >= getCapacity()) {
                        ensureExtraCapacity(1);
                    } else {
                        int i13 = this.length;
                        int i14 = i13 + 1;
                        this.length = i14;
                        this.keysArray[i13] = k11;
                        this.presenceArray[i13] = hash;
                        this.hashArray[hash] = i14;
                        this.size = size() + 1;
                        if (i11 > this.maxProbeDistance) {
                            this.maxProbeDistance = i11;
                        }
                        return i13;
                    }
                } else if (Intrinsics.areEqual((Object) this.keysArray[i12 - 1], (Object) k11)) {
                    return -i12;
                } else {
                    i11++;
                    if (i11 > coerceAtMost) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    int i15 = hash - 1;
                    if (hash == 0) {
                        hash = getHashSize() - 1;
                    } else {
                        hash = i15;
                    }
                }
            }
        }
    }

    @NotNull
    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        return this;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        checkIsMutable$kotlin_stdlib();
        IntIterator it = new IntRange(0, this.length - 1).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            int[] iArr = this.presenceArray;
            int i11 = iArr[nextInt];
            if (i11 >= 0) {
                this.hashArray[i11] = 0;
                iArr[nextInt] = -1;
            }
        }
        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(@NotNull Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "m");
        for (Object next : collection) {
            if (next != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) next)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return Intrinsics.areEqual((Object) vArr[findKey], (Object) entry.getValue());
    }

    public boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return findValue(obj) >= 0;
    }

    @NotNull
    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr<>(this);
    }

    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this || ((obj instanceof Map) && contentEquals((Map) obj))) {
            return true;
        }
        return false;
    }

    @Nullable
    public V get(Object obj) {
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return vArr[findKey];
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.entriesView;
        if (mapBuilderEntries != null) {
            return mapBuilderEntries;
        }
        MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
        this.entriesView = mapBuilderEntries2;
        return mapBuilderEntries2;
    }

    @NotNull
    public Set<K> getKeys() {
        MapBuilderKeys<K> mapBuilderKeys = this.keysView;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys<K> mapBuilderKeys2 = new MapBuilderKeys<>(this);
        this.keysView = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public Collection<V> getValues() {
        MapBuilderValues<V> mapBuilderValues = this.valuesView;
        if (mapBuilderValues != null) {
            return mapBuilderValues;
        }
        MapBuilderValues<V> mapBuilderValues2 = new MapBuilderValues<>(this);
        this.valuesView = mapBuilderValues2;
        return mapBuilderValues2;
    }

    public int hashCode() {
        EntriesItr entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i11 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i11 += entriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
        }
        return i11;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @NotNull
    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr<>(this);
    }

    @Nullable
    public V put(K k11, V v11) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k11);
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib < 0) {
            int i11 = (-addKey$kotlin_stdlib) - 1;
            V v12 = allocateValuesArray[i11];
            allocateValuesArray[i11] = v11;
            return v12;
        }
        allocateValuesArray[addKey$kotlin_stdlib] = v11;
        return null;
    }

    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(map.entrySet());
    }

    @Nullable
    public V remove(Object obj) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        V v11 = vArr[removeKey$kotlin_stdlib];
        ListBuilderKt.resetAt(vArr, removeKey$kotlin_stdlib);
        return v11;
    }

    public final boolean removeEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        if (!Intrinsics.areEqual((Object) vArr[findKey], (Object) entry.getValue())) {
            return false;
        }
        removeKeyAt(findKey);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k11) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(k11);
        if (findKey < 0) {
            return -1;
        }
        removeKeyAt(findKey);
        return findKey;
    }

    public final boolean removeValue$kotlin_stdlib(V v11) {
        checkIsMutable$kotlin_stdlib();
        int findValue = findValue(v11);
        if (findValue < 0) {
            return false;
        }
        removeKeyAt(findValue);
        return true;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append("{");
        EntriesItr entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i11 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i11 > 0) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            entriesIterator$kotlin_stdlib.nextAppendString(sb2);
            i11++;
        }
        sb2.append("}");
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
        return sb3;
    }

    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @NotNull
    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr<>(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i11) {
        this(ListBuilderKt.arrayOfUninitializedElements(i11), (V[]) null, new int[i11], new int[Companion.computeHashSize(i11)], 2, 0);
    }
}
