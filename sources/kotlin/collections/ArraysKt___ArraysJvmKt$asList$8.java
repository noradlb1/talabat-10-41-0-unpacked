package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$8", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Character;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ArraysKt___ArraysJvmKt$asList$8 extends AbstractList<Character> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ char[] f23763b;

    public ArraysKt___ArraysJvmKt$asList$8(char[] cArr) {
        this.f23763b = cArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Character)) {
            return false;
        }
        return contains(((Character) obj).charValue());
    }

    public int getSize() {
        return this.f23763b.length;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Character)) {
            return -1;
        }
        return indexOf(((Character) obj).charValue());
    }

    public boolean isEmpty() {
        return this.f23763b.length == 0;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Character)) {
            return -1;
        }
        return lastIndexOf(((Character) obj).charValue());
    }

    public boolean contains(char c11) {
        return ArraysKt___ArraysKt.contains(this.f23763b, c11);
    }

    @NotNull
    public Character get(int i11) {
        return Character.valueOf(this.f23763b[i11]);
    }

    public int indexOf(char c11) {
        return ArraysKt___ArraysKt.indexOf(this.f23763b, c11);
    }

    public int lastIndexOf(char c11) {
        return ArraysKt___ArraysKt.lastIndexOf(this.f23763b, c11);
    }
}
