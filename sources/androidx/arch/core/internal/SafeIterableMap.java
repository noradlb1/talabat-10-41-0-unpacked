package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    public Entry<K, V> f940b;
    private Entry<K, V> mEnd;
    private WeakHashMap<SupportRemove<K, V>, Boolean> mIterators = new WeakHashMap<>();
    private int mSize = 0;

    public static class AscendingIterator<K, V> extends ListIterator<K, V> {
        public AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        public Entry<K, V> a(Entry<K, V> entry) {
            return entry.f944e;
        }

        public Entry<K, V> b(Entry<K, V> entry) {
            return entry.f943d;
        }
    }

    public static class DescendingIterator<K, V> extends ListIterator<K, V> {
        public DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        public Entry<K, V> a(Entry<K, V> entry) {
            return entry.f943d;
        }

        public Entry<K, V> b(Entry<K, V> entry) {
            return entry.f944e;
        }
    }

    public static class Entry<K, V> implements Map.Entry<K, V> {
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final K f941b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final V f942c;

        /* renamed from: d  reason: collision with root package name */
        public Entry<K, V> f943d;

        /* renamed from: e  reason: collision with root package name */
        public Entry<K, V> f944e;

        public Entry(@NonNull K k11, @NonNull V v11) {
            this.f941b = k11;
            this.f942c = v11;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (!this.f941b.equals(entry.f941b) || !this.f942c.equals(entry.f942c)) {
                return false;
            }
            return true;
        }

        @NonNull
        public K getKey() {
            return this.f941b;
        }

        @NonNull
        public V getValue() {
            return this.f942c;
        }

        public int hashCode() {
            return this.f941b.hashCode() ^ this.f942c.hashCode();
        }

        public V setValue(V v11) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f941b + "=" + this.f942c;
        }
    }

    public class IteratorWithAdditions implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {
        private boolean mBeforeStart = true;
        private Entry<K, V> mCurrent;

        public IteratorWithAdditions() {
        }

        public boolean hasNext() {
            if (!this.mBeforeStart) {
                Entry<K, V> entry = this.mCurrent;
                if (entry == null || entry.f943d == null) {
                    return false;
                }
                return true;
            } else if (SafeIterableMap.this.f940b != null) {
                return true;
            } else {
                return false;
            }
        }

        public void supportRemove(@NonNull Entry<K, V> entry) {
            boolean z11;
            Entry<K, V> entry2 = this.mCurrent;
            if (entry == entry2) {
                Entry<K, V> entry3 = entry2.f944e;
                this.mCurrent = entry3;
                if (entry3 == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                this.mBeforeStart = z11;
            }
        }

        public Map.Entry<K, V> next() {
            if (this.mBeforeStart) {
                this.mBeforeStart = false;
                this.mCurrent = SafeIterableMap.this.f940b;
            } else {
                Entry<K, V> entry = this.mCurrent;
                this.mCurrent = entry != null ? entry.f943d : null;
            }
            return this.mCurrent;
        }
    }

    public static abstract class ListIterator<K, V> implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public Entry<K, V> f946b;

        /* renamed from: c  reason: collision with root package name */
        public Entry<K, V> f947c;

        public ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.f946b = entry2;
            this.f947c = entry;
        }

        private Entry<K, V> nextNode() {
            Entry<K, V> entry = this.f947c;
            Entry<K, V> entry2 = this.f946b;
            if (entry == entry2 || entry2 == null) {
                return null;
            }
            return b(entry);
        }

        public abstract Entry<K, V> a(Entry<K, V> entry);

        public abstract Entry<K, V> b(Entry<K, V> entry);

        public boolean hasNext() {
            return this.f947c != null;
        }

        public void supportRemove(@NonNull Entry<K, V> entry) {
            if (this.f946b == entry && entry == this.f947c) {
                this.f947c = null;
                this.f946b = null;
            }
            Entry<K, V> entry2 = this.f946b;
            if (entry2 == entry) {
                this.f946b = a(entry2);
            }
            if (this.f947c == entry) {
                this.f947c = nextNode();
            }
        }

        public Map.Entry<K, V> next() {
            Entry<K, V> entry = this.f947c;
            this.f947c = nextNode();
            return entry;
        }
    }

    public interface SupportRemove<K, V> {
        void supportRemove(@NonNull Entry<K, V> entry);
    }

    public Entry<K, V> a(K k11) {
        Entry<K, V> entry = this.f940b;
        while (entry != null && !entry.f941b.equals(k11)) {
            entry = entry.f943d;
        }
        return entry;
    }

    public Entry<K, V> b(@NonNull K k11, @NonNull V v11) {
        Entry<K, V> entry = new Entry<>(k11, v11);
        this.mSize++;
        Entry<K, V> entry2 = this.mEnd;
        if (entry2 == null) {
            this.f940b = entry;
            this.mEnd = entry;
            return entry;
        }
        entry2.f943d = entry;
        entry.f944e = entry2;
        this.mEnd = entry;
        return entry;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        DescendingIterator descendingIterator = new DescendingIterator(this.mEnd, this.f940b);
        this.mIterators.put(descendingIterator, Boolean.FALSE);
        return descendingIterator;
    }

    public Map.Entry<K, V> eldest() {
        return this.f940b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i11 += ((Map.Entry) it.next()).hashCode();
        }
        return i11;
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.f940b, this.mEnd);
        this.mIterators.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions() {
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions();
        this.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
        return iteratorWithAdditions;
    }

    public Map.Entry<K, V> newest() {
        return this.mEnd;
    }

    public V putIfAbsent(@NonNull K k11, @NonNull V v11) {
        Entry a11 = a(k11);
        if (a11 != null) {
            return a11.f942c;
        }
        b(k11, v11);
        return null;
    }

    public V remove(@NonNull K k11) {
        Entry a11 = a(k11);
        if (a11 == null) {
            return null;
        }
        this.mSize--;
        if (!this.mIterators.isEmpty()) {
            for (SupportRemove<K, V> supportRemove : this.mIterators.keySet()) {
                supportRemove.supportRemove(a11);
            }
        }
        Entry<K, V> entry = a11.f944e;
        if (entry != null) {
            entry.f943d = a11.f943d;
        } else {
            this.f940b = a11.f943d;
        }
        Entry<K, V> entry2 = a11.f943d;
        if (entry2 != null) {
            entry2.f944e = entry;
        } else {
            this.mEnd = entry;
        }
        a11.f943d = null;
        a11.f944e = null;
        return a11.f942c;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb2.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
