package androidx.compose.ui.tooling.preview.datasource;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import com.talabat.gem.integration.GemAccessor;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import t0.a;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/tooling/preview/datasource/CollectionPreviewParameterProvider;", "T", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "collection", "", "(Ljava/util/Collection;)V", "values", "Lkotlin/sequences/Sequence;", "getValues", "()Lkotlin/sequences/Sequence;", "ui-tooling-preview_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CollectionPreviewParameterProvider<T> implements PreviewParameterProvider<T> {
    @NotNull
    private final Collection<T> collection;

    public CollectionPreviewParameterProvider(@NotNull Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection2, GemAccessor.COMPONENT_COLLECTION);
        this.collection = collection2;
    }

    public /* synthetic */ int getCount() {
        return a.a(this);
    }

    @NotNull
    public Sequence<T> getValues() {
        return CollectionsKt___CollectionsKt.asSequence(this.collection);
    }
}
