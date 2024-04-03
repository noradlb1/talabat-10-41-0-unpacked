package androidx.compose.runtime.internal;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/internal/ThreadMap;", "", "size", "", "keys", "", "values", "", "(I[J[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "find", "key", "", "get", "newWith", "value", "trySet", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ThreadMap {
    @NotNull
    private final long[] keys;
    private final int size;
    @NotNull
    private final Object[] values;

    public ThreadMap(int i11, @NotNull long[] jArr, @NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(jArr, UserMetadata.KEYDATA_FILENAME);
        Intrinsics.checkNotNullParameter(objArr, "values");
        this.size = i11;
        this.keys = jArr;
        this.values = objArr;
    }

    private final int find(long j11) {
        int i11 = this.size - 1;
        if (i11 == -1) {
            return -1;
        }
        int i12 = 0;
        if (i11 != 0) {
            while (i12 <= i11) {
                int i13 = (i12 + i11) >>> 1;
                int i14 = ((this.keys[i13] - j11) > 0 ? 1 : ((this.keys[i13] - j11) == 0 ? 0 : -1));
                if (i14 < 0) {
                    i12 = i13 + 1;
                } else if (i14 <= 0) {
                    return i13;
                } else {
                    i11 = i13 - 1;
                }
            }
            return -(i12 + 1);
        }
        long j12 = this.keys[0];
        if (j12 == j11) {
            return 0;
        }
        if (j12 > j11) {
            return -2;
        }
        return -1;
    }

    @Nullable
    public final Object get(long j11) {
        int find = find(j11);
        if (find >= 0) {
            return this.values[find];
        }
        return null;
    }

    @NotNull
    public final ThreadMap newWith(long j11, @Nullable Object obj) {
        int i11 = this.size;
        Object[] objArr = this.values;
        int length = objArr.length;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            boolean z11 = true;
            if (i13 >= length) {
                break;
            }
            if (objArr[i13] == null) {
                z11 = false;
            }
            if (z11) {
                i14++;
            }
            i13++;
        }
        int i15 = i14 + 1;
        long[] jArr = new long[i15];
        Object[] objArr2 = new Object[i15];
        if (i15 > 1) {
            int i16 = 0;
            while (true) {
                if (i12 >= i15 || i16 >= i11) {
                    break;
                }
                long j12 = this.keys[i16];
                Object obj2 = this.values[i16];
                if (j12 > j11) {
                    jArr[i12] = j11;
                    objArr2[i12] = obj;
                    i12++;
                    break;
                }
                if (obj2 != null) {
                    jArr[i12] = j12;
                    objArr2[i12] = obj2;
                    i12++;
                }
                i16++;
            }
            if (i16 == i11) {
                int i17 = i15 - 1;
                jArr[i17] = j11;
                objArr2[i17] = obj;
            } else {
                while (i12 < i15) {
                    long j13 = this.keys[i16];
                    Object obj3 = this.values[i16];
                    if (obj3 != null) {
                        jArr[i12] = j13;
                        objArr2[i12] = obj3;
                        i12++;
                    }
                    i16++;
                }
            }
        } else {
            jArr[0] = j11;
            objArr2[0] = obj;
        }
        return new ThreadMap(i15, jArr, objArr2);
    }

    public final boolean trySet(long j11, @Nullable Object obj) {
        int find = find(j11);
        if (find < 0) {
            return false;
        }
        this.values[find] = obj;
        return true;
    }
}
