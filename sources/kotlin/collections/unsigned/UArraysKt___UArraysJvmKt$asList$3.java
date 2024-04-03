package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.collections.AbstractList;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0018"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "Lkotlin/UByte;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-7apg3OU", "(B)Z", "get", "index", "get-w2LRezQ", "(I)B", "indexOf", "indexOf-7apg3OU", "(B)I", "isEmpty", "lastIndexOf", "lastIndexOf-7apg3OU", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UArraysKt___UArraysJvmKt$asList$3 extends AbstractList<UByte> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ byte[] f23819b;

    public UArraysKt___UArraysJvmKt$asList$3(byte[] bArr) {
        this.f23819b = bArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UByte)) {
            return false;
        }
        return m6844contains7apg3OU(((UByte) obj).m6396unboximpl());
    }

    /* renamed from: contains-7apg3OU  reason: not valid java name */
    public boolean m6844contains7apg3OU(byte b11) {
        return UByteArray.m6400contains7apg3OU(this.f23819b, b11);
    }

    public /* bridge */ /* synthetic */ Object get(int i11) {
        return UByte.m6341boximpl(m6845getw2LRezQ(i11));
    }

    /* renamed from: get-w2LRezQ  reason: not valid java name */
    public byte m6845getw2LRezQ(int i11) {
        return UByteArray.m6404getw2LRezQ(this.f23819b, i11);
    }

    public int getSize() {
        return UByteArray.m6405getSizeimpl(this.f23819b);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof UByte)) {
            return -1;
        }
        return m6846indexOf7apg3OU(((UByte) obj).m6396unboximpl());
    }

    /* renamed from: indexOf-7apg3OU  reason: not valid java name */
    public int m6846indexOf7apg3OU(byte b11) {
        return ArraysKt___ArraysKt.indexOf(this.f23819b, b11);
    }

    public boolean isEmpty() {
        return UByteArray.m6407isEmptyimpl(this.f23819b);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof UByte)) {
            return -1;
        }
        return m6847lastIndexOf7apg3OU(((UByte) obj).m6396unboximpl());
    }

    /* renamed from: lastIndexOf-7apg3OU  reason: not valid java name */
    public int m6847lastIndexOf7apg3OU(byte b11) {
        return ArraysKt___ArraysKt.lastIndexOf(this.f23819b, b11);
    }
}
