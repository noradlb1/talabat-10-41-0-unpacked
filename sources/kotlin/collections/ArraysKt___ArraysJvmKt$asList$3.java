package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Integer;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ArraysKt___ArraysJvmKt$asList$3 extends AbstractList<Integer> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int[] f23758b;

    public ArraysKt___ArraysJvmKt$asList$3(int[] iArr) {
        this.f23758b = iArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Integer)) {
            return false;
        }
        return contains(((Number) obj).intValue());
    }

    public int getSize() {
        return this.f23758b.length;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        return indexOf(((Number) obj).intValue());
    }

    public boolean isEmpty() {
        return this.f23758b.length == 0;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        return lastIndexOf(((Number) obj).intValue());
    }

    public boolean contains(int i11) {
        return ArraysKt___ArraysKt.contains(this.f23758b, i11);
    }

    @NotNull
    public Integer get(int i11) {
        return Integer.valueOf(this.f23758b[i11]);
    }

    public int indexOf(int i11) {
        return ArraysKt___ArraysKt.indexOf(this.f23758b, i11);
    }

    public int lastIndexOf(int i11) {
        return ArraysKt___ArraysKt.lastIndexOf(this.f23758b, i11);
    }
}
