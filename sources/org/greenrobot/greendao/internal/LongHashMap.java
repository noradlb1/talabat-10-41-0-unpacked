package org.greenrobot.greendao.internal;

import java.util.Arrays;
import org.greenrobot.greendao.DaoLog;

public final class LongHashMap<T> {
    private int capacity;
    private int size;
    private Entry<T>[] table;
    private int threshold;

    public static final class Entry<T> {

        /* renamed from: a  reason: collision with root package name */
        public final long f27876a;

        /* renamed from: b  reason: collision with root package name */
        public T f27877b;

        /* renamed from: c  reason: collision with root package name */
        public Entry<T> f27878c;

        public Entry(long j11, T t11, Entry<T> entry) {
            this.f27876a = j11;
            this.f27877b = t11;
            this.f27878c = entry;
        }
    }

    public LongHashMap() {
        this(16);
    }

    public void clear() {
        this.size = 0;
        Arrays.fill(this.table, (Object) null);
    }

    public boolean containsKey(long j11) {
        for (Entry<T> entry = this.table[((((int) (j11 >>> 32)) ^ ((int) j11)) & Integer.MAX_VALUE) % this.capacity]; entry != null; entry = entry.f27878c) {
            if (entry.f27876a == j11) {
                return true;
            }
        }
        return false;
    }

    public T get(long j11) {
        for (Entry<T> entry = this.table[((((int) (j11 >>> 32)) ^ ((int) j11)) & Integer.MAX_VALUE) % this.capacity]; entry != null; entry = entry.f27878c) {
            if (entry.f27876a == j11) {
                return entry.f27877b;
            }
        }
        return null;
    }

    public void logStats() {
        int i11 = 0;
        for (Entry<T> entry : this.table) {
            while (entry != null) {
                entry = entry.f27878c;
                if (entry == null) {
                    break;
                }
                i11++;
            }
        }
        DaoLog.d("load: " + (((float) this.size) / ((float) this.capacity)) + ", size: " + this.size + ", capa: " + this.capacity + ", collisions: " + i11 + ", collision ratio: " + (((float) i11) / ((float) this.size)));
    }

    public T put(long j11, T t11) {
        int i11 = ((((int) (j11 >>> 32)) ^ ((int) j11)) & Integer.MAX_VALUE) % this.capacity;
        Entry<T> entry = this.table[i11];
        for (Entry<T> entry2 = entry; entry2 != null; entry2 = entry2.f27878c) {
            if (entry2.f27876a == j11) {
                T t12 = entry2.f27877b;
                entry2.f27877b = t11;
                return t12;
            }
        }
        this.table[i11] = new Entry<>(j11, t11, entry);
        int i12 = this.size + 1;
        this.size = i12;
        if (i12 <= this.threshold) {
            return null;
        }
        setCapacity(this.capacity * 2);
        return null;
    }

    public T remove(long j11) {
        int i11 = ((((int) (j11 >>> 32)) ^ ((int) j11)) & Integer.MAX_VALUE) % this.capacity;
        Entry<T> entry = this.table[i11];
        Entry<T> entry2 = null;
        while (entry != null) {
            Entry<T> entry3 = entry.f27878c;
            if (entry.f27876a == j11) {
                if (entry2 == null) {
                    this.table[i11] = entry3;
                } else {
                    entry2.f27878c = entry3;
                }
                this.size--;
                return entry.f27877b;
            }
            entry2 = entry;
            entry = entry3;
        }
        return null;
    }

    public void reserveRoom(int i11) {
        setCapacity((i11 * 5) / 3);
    }

    public void setCapacity(int i11) {
        Entry<T>[] entryArr = new Entry[i11];
        for (Entry<T> entry : this.table) {
            while (entry != null) {
                long j11 = entry.f27876a;
                int i12 = ((((int) j11) ^ ((int) (j11 >>> 32))) & Integer.MAX_VALUE) % i11;
                Entry<T> entry2 = entry.f27878c;
                entry.f27878c = entryArr[i12];
                entryArr[i12] = entry;
                entry = entry2;
            }
        }
        this.table = entryArr;
        this.capacity = i11;
        this.threshold = (i11 * 4) / 3;
    }

    public int size() {
        return this.size;
    }

    public LongHashMap(int i11) {
        this.capacity = i11;
        this.threshold = (i11 * 4) / 3;
        this.table = new Entry[i11];
    }
}
