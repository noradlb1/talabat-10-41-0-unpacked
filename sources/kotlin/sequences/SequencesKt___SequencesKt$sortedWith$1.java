package kotlin.sequences;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$sortedWith$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SequencesKt___SequencesKt$sortedWith$1 implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Sequence<T> f25058a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator<? super T> f25059b;

    public SequencesKt___SequencesKt$sortedWith$1(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        this.f25058a = sequence;
        this.f25059b = comparator;
    }

    @NotNull
    public Iterator<T> iterator() {
        List mutableList = SequencesKt___SequencesKt.toMutableList(this.f25058a);
        CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, this.f25059b);
        return mutableList.iterator();
    }
}
