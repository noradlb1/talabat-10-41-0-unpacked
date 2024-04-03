package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    private static final int STRING = 4;
    @VisibleForTesting

    /* renamed from: h  reason: collision with root package name */
    public static final TreeMap<Integer, RoomSQLiteQuery> f37463h = new TreeMap<>();
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    public final long[] f37464b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    public final double[] f37465c;
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    public final String[] f37466d;
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    public final byte[][] f37467e;
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    public final int f37468f;
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    public int f37469g;
    private final int[] mBindingTypes;
    private volatile String mQuery;

    private RoomSQLiteQuery(int i11) {
        this.f37468f = i11;
        int i12 = i11 + 1;
        this.mBindingTypes = new int[i12];
        this.f37464b = new long[i12];
        this.f37465c = new double[i12];
        this.f37466d = new String[i12];
        this.f37467e = new byte[i12][];
    }

    public static RoomSQLiteQuery acquire(String str, int i11) {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = f37463h;
        synchronized (treeMap) {
            Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i11));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                RoomSQLiteQuery value = ceilingEntry.getValue();
                value.a(str, i11);
                return value;
            }
            RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i11);
            roomSQLiteQuery.a(str, i11);
            return roomSQLiteQuery;
        }
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
        supportSQLiteQuery.bindTo(new SupportSQLiteProgram() {
            public void bindBlob(int i11, byte[] bArr) {
                RoomSQLiteQuery.this.bindBlob(i11, bArr);
            }

            public void bindDouble(int i11, double d11) {
                RoomSQLiteQuery.this.bindDouble(i11, d11);
            }

            public void bindLong(int i11, long j11) {
                RoomSQLiteQuery.this.bindLong(i11, j11);
            }

            public void bindNull(int i11) {
                RoomSQLiteQuery.this.bindNull(i11);
            }

            public void bindString(int i11, String str) {
                RoomSQLiteQuery.this.bindString(i11, str);
            }

            public void clearBindings() {
                RoomSQLiteQuery.this.clearBindings();
            }

            public void close() {
            }
        });
        return acquire;
    }

    private static void prunePoolLocked() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = f37463h;
        if (treeMap.size() > 15) {
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            while (true) {
                int i11 = size - 1;
                if (size > 0) {
                    it.next();
                    it.remove();
                    size = i11;
                } else {
                    return;
                }
            }
        }
    }

    public void a(String str, int i11) {
        this.mQuery = str;
        this.f37469g = i11;
    }

    public void bindBlob(int i11, byte[] bArr) {
        this.mBindingTypes[i11] = 5;
        this.f37467e[i11] = bArr;
    }

    public void bindDouble(int i11, double d11) {
        this.mBindingTypes[i11] = 3;
        this.f37465c[i11] = d11;
    }

    public void bindLong(int i11, long j11) {
        this.mBindingTypes[i11] = 2;
        this.f37464b[i11] = j11;
    }

    public void bindNull(int i11) {
        this.mBindingTypes[i11] = 1;
    }

    public void bindString(int i11, String str) {
        this.mBindingTypes[i11] = 4;
        this.f37466d[i11] = str;
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        for (int i11 = 1; i11 <= this.f37469g; i11++) {
            int i12 = this.mBindingTypes[i11];
            if (i12 == 1) {
                supportSQLiteProgram.bindNull(i11);
            } else if (i12 == 2) {
                supportSQLiteProgram.bindLong(i11, this.f37464b[i11]);
            } else if (i12 == 3) {
                supportSQLiteProgram.bindDouble(i11, this.f37465c[i11]);
            } else if (i12 == 4) {
                supportSQLiteProgram.bindString(i11, this.f37466d[i11]);
            } else if (i12 == 5) {
                supportSQLiteProgram.bindBlob(i11, this.f37467e[i11]);
            }
        }
    }

    public void clearBindings() {
        Arrays.fill(this.mBindingTypes, 1);
        Arrays.fill(this.f37466d, (Object) null);
        Arrays.fill(this.f37467e, (Object) null);
        this.mQuery = null;
    }

    public void close() {
    }

    public void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        int argCount = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.mBindingTypes, 0, this.mBindingTypes, 0, argCount);
        System.arraycopy(roomSQLiteQuery.f37464b, 0, this.f37464b, 0, argCount);
        System.arraycopy(roomSQLiteQuery.f37466d, 0, this.f37466d, 0, argCount);
        System.arraycopy(roomSQLiteQuery.f37467e, 0, this.f37467e, 0, argCount);
        System.arraycopy(roomSQLiteQuery.f37465c, 0, this.f37465c, 0, argCount);
    }

    public int getArgCount() {
        return this.f37469g;
    }

    public String getSql() {
        return this.mQuery;
    }

    public void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = f37463h;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f37468f), this);
            prunePoolLocked();
        }
    }
}
