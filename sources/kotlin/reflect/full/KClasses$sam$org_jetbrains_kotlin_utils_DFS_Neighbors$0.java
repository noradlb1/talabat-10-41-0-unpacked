package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class KClasses$sam$org_jetbrains_kotlin_utils_DFS_Neighbors$0 implements DFS.Neighbors {
    private final /* synthetic */ Function1 function;

    public KClasses$sam$org_jetbrains_kotlin_utils_DFS_Neighbors$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ Iterable getNeighbors(Object obj) {
        return (Iterable) this.function.invoke(obj);
    }
}
