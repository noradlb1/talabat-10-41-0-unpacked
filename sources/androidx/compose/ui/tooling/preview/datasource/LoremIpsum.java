package androidx.compose.ui.tooling.preview.datasource;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import t0.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/compose/ui/tooling/preview/datasource/LoremIpsum;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "", "()V", "words", "", "(I)V", "values", "Lkotlin/sequences/Sequence;", "getValues", "()Lkotlin/sequences/Sequence;", "generateLoremIpsum", "ui-tooling-preview_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoremIpsum implements PreviewParameterProvider<String> {
    private final int words;

    public LoremIpsum(int i11) {
        this.words = i11;
    }

    private final String generateLoremIpsum(int i11) {
        return SequencesKt___SequencesKt.joinToString$default(SequencesKt___SequencesKt.take(SequencesKt__SequencesKt.generateSequence(new LoremIpsum$generateLoremIpsum$1(new Ref.IntRef(), LoremIpsumKt.LOREM_IPSUM_SOURCE.size())), i11), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public /* synthetic */ int getCount() {
        return a.a(this);
    }

    @NotNull
    public Sequence<String> getValues() {
        return SequencesKt__SequencesKt.sequenceOf(generateLoremIpsum(this.words));
    }

    public LoremIpsum() {
        this(500);
    }
}
