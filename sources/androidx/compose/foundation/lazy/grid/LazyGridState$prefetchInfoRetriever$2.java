package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "Landroidx/compose/ui/unit/Constraints;", "it", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "invoke-bKFJvoY", "(I)Ljava/util/List;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridState$prefetchInfoRetriever$2 extends Lambda implements Function1<LineIndex, List<? extends Pair<? extends Integer, ? extends Constraints>>> {
    public static final LazyGridState$prefetchInfoRetriever$2 INSTANCE = new LazyGridState$prefetchInfoRetriever$2();

    public LazyGridState$prefetchInfoRetriever$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m713invokebKFJvoY(((LineIndex) obj).m732unboximpl());
    }

    @NotNull
    /* renamed from: invoke-bKFJvoY  reason: not valid java name */
    public final List<Pair<Integer, Constraints>> m713invokebKFJvoY(int i11) {
        return CollectionsKt__CollectionsKt.emptyList();
    }
}
