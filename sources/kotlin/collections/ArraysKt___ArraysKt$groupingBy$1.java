package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\u0002\u001a\u00028\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¨\u0006\u0007"}, d2 = {"kotlin/collections/ArraysKt___ArraysKt$groupingBy$1", "Lkotlin/collections/Grouping;", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 176)
public final class ArraysKt___ArraysKt$groupingBy$1 implements Grouping<T, K> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ T[] f23782a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<T, K> f23783b;

    public ArraysKt___ArraysKt$groupingBy$1(T[] tArr, Function1<? super T, ? extends K> function1) {
        this.f23782a = tArr;
        this.f23783b = function1;
    }

    public K keyOf(T t11) {
        return this.f23783b.invoke(t11);
    }

    @NotNull
    public Iterator<T> sourceIterator() {
        return ArrayIteratorKt.iterator(this.f23782a);
    }
}
