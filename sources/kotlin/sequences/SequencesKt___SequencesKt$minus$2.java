package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.BrittleContainsOptimizationKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$minus$2", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SequencesKt___SequencesKt$minus$2 implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ T[] f25021a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Sequence<T> f25022b;

    public SequencesKt___SequencesKt$minus$2(T[] tArr, Sequence<? extends T> sequence) {
        this.f25021a = tArr;
        this.f25022b = sequence;
    }

    @NotNull
    public Iterator<T> iterator() {
        return SequencesKt___SequencesKt.filterNot(this.f25022b, new SequencesKt___SequencesKt$minus$2$iterator$1(BrittleContainsOptimizationKt.convertToSetForSetOperation(this.f25021a))).iterator();
    }
}
