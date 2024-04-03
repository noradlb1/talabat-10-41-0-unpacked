package androidx.sqlite.db;

import androidx.annotation.Nullable;

public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    @Nullable
    private final Object[] mBindArgs;
    private final String mQuery;

    public SimpleSQLiteQuery(String str, @Nullable Object[] objArr) {
        this.mQuery = str;
        this.mBindArgs = objArr;
    }

    public static void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
        if (objArr != null) {
            int length = objArr.length;
            int i11 = 0;
            while (i11 < length) {
                Object obj = objArr[i11];
                i11++;
                bind(supportSQLiteProgram, i11, obj);
            }
        }
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        bind(supportSQLiteProgram, this.mBindArgs);
    }

    public int getArgCount() {
        Object[] objArr = this.mBindArgs;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public String getSql() {
        return this.mQuery;
    }

    public SimpleSQLiteQuery(String str) {
        this(str, (Object[]) null);
    }

    private static void bind(SupportSQLiteProgram supportSQLiteProgram, int i11, Object obj) {
        if (obj == null) {
            supportSQLiteProgram.bindNull(i11);
        } else if (obj instanceof byte[]) {
            supportSQLiteProgram.bindBlob(i11, (byte[]) obj);
        } else if (obj instanceof Float) {
            supportSQLiteProgram.bindDouble(i11, (double) ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            supportSQLiteProgram.bindDouble(i11, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            supportSQLiteProgram.bindLong(i11, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            supportSQLiteProgram.bindLong(i11, (long) ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            supportSQLiteProgram.bindLong(i11, (long) ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            supportSQLiteProgram.bindLong(i11, (long) ((Byte) obj).byteValue());
        } else if (obj instanceof String) {
            supportSQLiteProgram.bindString(i11, (String) obj);
        } else if (obj instanceof Boolean) {
            supportSQLiteProgram.bindLong(i11, ((Boolean) obj).booleanValue() ? 1 : 0);
        } else {
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i11 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
        }
    }
}
