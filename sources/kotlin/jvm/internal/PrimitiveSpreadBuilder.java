package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u0015J\u0013\u0010\u0004\u001a\u00020\u0003*\u00028\u0000H$¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0003H\u0004J\u001f\u0010\r\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00038\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00168\u0002X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "T", "", "getSize", "(Ljava/lang/Object;)I", "spreadArgument", "", "addSpread", "(Ljava/lang/Object;)V", "c", "values", "result", "d", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "size", "I", "position", "a", "()I", "b", "(I)V", "", "spreads", "[Ljava/lang/Object;", "getSpreads$annotations", "()V", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
public abstract class PrimitiveSpreadBuilder<T> {
    private int position;
    private final int size;
    @NotNull
    private final T[] spreads;

    public PrimitiveSpreadBuilder(int i11) {
        this.size = i11;
        this.spreads = new Object[i11];
    }

    private static /* synthetic */ void getSpreads$annotations() {
    }

    public final int a() {
        return this.position;
    }

    public final void addSpread(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "spreadArgument");
        T[] tArr = this.spreads;
        int i11 = this.position;
        this.position = i11 + 1;
        tArr[i11] = t11;
    }

    public final void b(int i11) {
        this.position = i11;
    }

    public final int c() {
        int i11;
        int i12 = 0;
        IntIterator it = new IntRange(0, this.size - 1).iterator();
        while (it.hasNext()) {
            T t11 = this.spreads[it.nextInt()];
            if (t11 != null) {
                i11 = getSize(t11);
            } else {
                i11 = 1;
            }
            i12 += i11;
        }
        return i12;
    }

    @NotNull
    public final T d(@NotNull T t11, @NotNull T t12) {
        Intrinsics.checkNotNullParameter(t11, "values");
        Intrinsics.checkNotNullParameter(t12, "result");
        IntIterator it = new IntRange(0, this.size - 1).iterator();
        int i11 = 0;
        int i12 = 0;
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            T t13 = this.spreads[nextInt];
            if (t13 != null) {
                if (i11 < nextInt) {
                    int i13 = nextInt - i11;
                    System.arraycopy(t11, i11, t12, i12, i13);
                    i12 += i13;
                }
                int size2 = getSize(t13);
                System.arraycopy(t13, 0, t12, i12, size2);
                i12 += size2;
                i11 = nextInt + 1;
            }
        }
        int i14 = this.size;
        if (i11 < i14) {
            System.arraycopy(t11, i11, t12, i12, i14 - i11);
        }
        return t12;
    }

    public abstract int getSize(@NotNull T t11);
}
