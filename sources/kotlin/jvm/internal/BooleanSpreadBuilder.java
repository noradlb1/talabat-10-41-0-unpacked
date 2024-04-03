package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/jvm/internal/BooleanSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "", "e", "", "value", "", "add", "toArray", "values", "[Z", "size", "<init>", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
public final class BooleanSpreadBuilder extends PrimitiveSpreadBuilder<boolean[]> {
    @NotNull
    private final boolean[] values;

    public BooleanSpreadBuilder(int i11) {
        super(i11);
        this.values = new boolean[i11];
    }

    public final void add(boolean z11) {
        boolean[] zArr = this.values;
        int a11 = a();
        b(a11 + 1);
        zArr[a11] = z11;
    }

    /* renamed from: e */
    public int getSize(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length;
    }

    @NotNull
    public final boolean[] toArray() {
        return (boolean[]) d(this.values, new boolean[c()]);
    }
}
