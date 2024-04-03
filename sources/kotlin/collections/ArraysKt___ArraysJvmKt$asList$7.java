package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$7", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "element", "get", "index", "(I)Ljava/lang/Boolean;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ArraysKt___ArraysJvmKt$asList$7 extends AbstractList<Boolean> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean[] f23762b;

    public ArraysKt___ArraysJvmKt$asList$7(boolean[] zArr) {
        this.f23762b = zArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Boolean)) {
            return false;
        }
        return contains(((Boolean) obj).booleanValue());
    }

    public int getSize() {
        return this.f23762b.length;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        return indexOf(((Boolean) obj).booleanValue());
    }

    public boolean isEmpty() {
        return this.f23762b.length == 0;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        return lastIndexOf(((Boolean) obj).booleanValue());
    }

    public boolean contains(boolean z11) {
        return ArraysKt___ArraysKt.contains(this.f23762b, z11);
    }

    @NotNull
    public Boolean get(int i11) {
        return Boolean.valueOf(this.f23762b[i11]);
    }

    public int indexOf(boolean z11) {
        return ArraysKt___ArraysKt.indexOf(this.f23762b, z11);
    }

    public int lastIndexOf(boolean z11) {
        return ArraysKt___ArraysKt.lastIndexOf(this.f23762b, z11);
    }
}
