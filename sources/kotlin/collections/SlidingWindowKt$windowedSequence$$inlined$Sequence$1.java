package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SlidingWindowKt$windowedSequence$$inlined$Sequence$1 implements Sequence<List<? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Sequence f23803a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f23804b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f23805c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f23806d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f23807e;

    public SlidingWindowKt$windowedSequence$$inlined$Sequence$1(Sequence sequence, int i11, int i12, boolean z11, boolean z12) {
        this.f23803a = sequence;
        this.f23804b = i11;
        this.f23805c = i12;
        this.f23806d = z11;
        this.f23807e = z12;
    }

    @NotNull
    public Iterator<List<? extends T>> iterator() {
        return SlidingWindowKt.windowedIterator(this.f23803a.iterator(), this.f23804b, this.f23805c, this.f23806d, this.f23807e);
    }
}
