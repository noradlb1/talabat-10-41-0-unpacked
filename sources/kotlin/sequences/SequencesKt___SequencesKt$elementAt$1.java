package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "it", "", "invoke", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SequencesKt___SequencesKt$elementAt$1 extends Lambda implements Function1<Integer, T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f25013g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$elementAt$1(int i11) {
        super(1);
        this.f25013g = i11;
    }

    public final T invoke(int i11) {
        throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + this.f25013g + '.');
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
