package kotlinx.serialization.json;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JvmStreamsKt$decodeToSequence$$inlined$Sequence$1 implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Iterator f26435a;

    public JvmStreamsKt$decodeToSequence$$inlined$Sequence$1(Iterator it) {
        this.f26435a = it;
    }

    @NotNull
    public Iterator<T> iterator() {
        return this.f26435a;
    }
}
