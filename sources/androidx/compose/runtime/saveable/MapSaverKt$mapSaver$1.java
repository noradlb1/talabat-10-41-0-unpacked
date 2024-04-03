package androidx.compose.runtime.saveable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "", "T", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "invoke", "(Landroidx/compose/runtime/saveable/SaverScope;Ljava/lang/Object;)Ljava/util/List;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MapSaverKt$mapSaver$1 extends Lambda implements Function2<SaverScope, T, List<? extends Object>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<SaverScope, T, Map<String, Object>> f9487g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapSaverKt$mapSaver$1(Function2<? super SaverScope, ? super T, ? extends Map<String, ? extends Object>> function2) {
        super(2);
        this.f9487g = function2;
    }

    @NotNull
    public final List<Object> invoke(@NotNull SaverScope saverScope, T t11) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$listSaver");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.f9487g.invoke(saverScope, t11).entrySet()) {
            arrayList.add(entry.getKey());
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }
}
