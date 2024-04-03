package coil.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0004J(\u0010\n\u001a\u00020\u000b\"\u0004\b\u0002\u0010\u0001\"\u0004\b\u0003\u0010\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007H\u0002J\u001c\u0010\r\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0002J\u001b\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u00020\u000b\"\u0004\b\u0002\u0010\u0001\"\u0004\b\u0003\u0010\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007H\u0002J\r\u0010\u0014\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016RB\u0010\u0005\u001a6\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006j\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcoil/collection/LinkedMultimap;", "K", "V", "", "()V", "entries", "Ljava/util/HashMap;", "Lcoil/collection/LinkedMultimap$LinkedEntry;", "Lkotlin/collections/HashMap;", "head", "insertEntry", "", "entry", "makeHead", "makeTail", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "removeEntry", "removeLast", "()Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "LinkedEntry", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LinkedMultimap<K, V> {
    @NotNull
    private final HashMap<K, LinkedEntry<K, V>> entries = new HashMap<>();
    @NotNull
    private final LinkedEntry<K, V> head = new LinkedEntry<>(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0002¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0003¢\u0006\u0002\u0010\u0005J\r\u0010\u001a\u001a\u0004\u0018\u00018\u0003¢\u0006\u0002\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00018\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcoil/collection/LinkedMultimap$LinkedEntry;", "K", "V", "", "key", "(Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "next", "getNext", "()Lcoil/collection/LinkedMultimap$LinkedEntry;", "setNext", "(Lcoil/collection/LinkedMultimap$LinkedEntry;)V", "prev", "getPrev", "setPrev", "size", "", "getSize", "()I", "values", "", "add", "", "value", "removeLast", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LinkedEntry<K, V> {
        @Nullable
        private final K key;
        @NotNull
        private LinkedEntry<K, V> next = this;
        @NotNull
        private LinkedEntry<K, V> prev = this;
        @Nullable
        private List<V> values;

        public LinkedEntry(@Nullable K k11) {
            this.key = k11;
        }

        public final void add(V v11) {
            List list = this.values;
            if (list == null) {
                list = new ArrayList();
                this.values = list;
            }
            list.add(v11);
        }

        @Nullable
        public final K getKey() {
            return this.key;
        }

        @NotNull
        public final LinkedEntry<K, V> getNext() {
            return this.next;
        }

        @NotNull
        public final LinkedEntry<K, V> getPrev() {
            return this.prev;
        }

        public final int getSize() {
            List<V> list = this.values;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Nullable
        public final V removeLast() {
            List<V> list = this.values;
            if (list == null) {
                return null;
            }
            return CollectionsKt__MutableCollectionsKt.removeLastOrNull(list);
        }

        public final void setNext(@NotNull LinkedEntry<K, V> linkedEntry) {
            Intrinsics.checkNotNullParameter(linkedEntry, "<set-?>");
            this.next = linkedEntry;
        }

        public final void setPrev(@NotNull LinkedEntry<K, V> linkedEntry) {
            Intrinsics.checkNotNullParameter(linkedEntry, "<set-?>");
            this.prev = linkedEntry;
        }
    }

    private final <K, V> void insertEntry(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.getNext().setPrev(linkedEntry);
        linkedEntry.getPrev().setNext(linkedEntry);
    }

    private final void makeHead(LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        linkedEntry.setPrev(this.head);
        linkedEntry.setNext(this.head.getNext());
        insertEntry(linkedEntry);
    }

    private final void makeTail(LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        linkedEntry.setPrev(this.head.getPrev());
        linkedEntry.setNext(this.head);
        insertEntry(linkedEntry);
    }

    private final <K, V> void removeEntry(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.getPrev().setNext(linkedEntry.getNext());
        linkedEntry.getNext().setPrev(linkedEntry.getPrev());
    }

    public final void put(K k11, V v11) {
        HashMap<K, LinkedEntry<K, V>> hashMap = this.entries;
        LinkedEntry<K, V> linkedEntry = hashMap.get(k11);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry<>(k11);
            makeTail(linkedEntry);
            hashMap.put(k11, linkedEntry);
        }
        linkedEntry.add(v11);
    }

    @Nullable
    public final V removeLast(K k11) {
        HashMap<K, LinkedEntry<K, V>> hashMap = this.entries;
        LinkedEntry<K, V> linkedEntry = hashMap.get(k11);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry<>(k11);
            hashMap.put(k11, linkedEntry);
        }
        LinkedEntry linkedEntry2 = linkedEntry;
        makeHead(linkedEntry2);
        return linkedEntry2.removeLast();
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LinkedMultimap( ");
        LinkedEntry<K, V> next = this.head.getNext();
        while (!Intrinsics.areEqual((Object) next, (Object) this.head)) {
            sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
            sb2.append(next.getKey());
            sb2.append(AbstractJsonLexerKt.COLON);
            sb2.append(next.getSize());
            sb2.append(AbstractJsonLexerKt.END_OBJ);
            next = next.getNext();
            if (!Intrinsics.areEqual((Object) next, (Object) this.head)) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
        sb2.append(" )");
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @Nullable
    public final V removeLast() {
        LinkedEntry<K, V> prev = this.head.getPrev();
        while (!Intrinsics.areEqual((Object) prev, (Object) this.head)) {
            V removeLast = prev.removeLast();
            if (removeLast != null) {
                return removeLast;
            }
            removeEntry(prev);
            HashMap<K, LinkedEntry<K, V>> hashMap = this.entries;
            K key = prev.getKey();
            if (hashMap != null) {
                TypeIntrinsics.asMutableMap(hashMap).remove(key);
                prev = prev.getPrev();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            }
        }
        return null;
    }
}
