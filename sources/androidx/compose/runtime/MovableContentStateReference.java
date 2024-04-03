package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.StabilityInferred;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@InternalComposeApi
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0001\b\u0000\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012 \u0010\u000b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f0\r0\f\u0012&\u0010\u0010\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00130\u0011j\u0002`\u0014¢\u0006\u0002\u0010\u0015R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR.\u0010\u000b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f0\r0\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR4\u0010\u0010\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00130\u0011j\u0002`\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroidx/compose/runtime/MovableContentStateReference;", "", "content", "Landroidx/compose/runtime/MovableContent;", "parameter", "composition", "Landroidx/compose/runtime/ControlledComposition;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidations", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "locals", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "(Landroidx/compose/runtime/MovableContent;Ljava/lang/Object;Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/SlotTable;Landroidx/compose/runtime/Anchor;Ljava/util/List;Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "getAnchor$runtime_release", "()Landroidx/compose/runtime/Anchor;", "getComposition$runtime_release", "()Landroidx/compose/runtime/ControlledComposition;", "getContent$runtime_release", "()Landroidx/compose/runtime/MovableContent;", "getInvalidations$runtime_release", "()Ljava/util/List;", "getLocals$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "getParameter$runtime_release", "()Ljava/lang/Object;", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MovableContentStateReference {
    public static final int $stable = 8;
    @NotNull
    private final Anchor anchor;
    @NotNull
    private final ControlledComposition composition;
    @NotNull
    private final MovableContent<Object> content;
    @NotNull
    private final List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> invalidations;
    @NotNull
    private final PersistentMap<CompositionLocal<Object>, State<Object>> locals;
    @Nullable
    private final Object parameter;
    @NotNull
    private final SlotTable slotTable;

    public MovableContentStateReference(@NotNull MovableContent<Object> movableContent, @Nullable Object obj, @NotNull ControlledComposition controlledComposition, @NotNull SlotTable slotTable2, @NotNull Anchor anchor2, @NotNull List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> list, @NotNull PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
        Intrinsics.checkNotNullParameter(movableContent, "content");
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        Intrinsics.checkNotNullParameter(slotTable2, "slotTable");
        Intrinsics.checkNotNullParameter(anchor2, Param.ANCHOR);
        Intrinsics.checkNotNullParameter(list, "invalidations");
        Intrinsics.checkNotNullParameter(persistentMap, "locals");
        this.content = movableContent;
        this.parameter = obj;
        this.composition = controlledComposition;
        this.slotTable = slotTable2;
        this.anchor = anchor2;
        this.invalidations = list;
        this.locals = persistentMap;
    }

    @NotNull
    public final Anchor getAnchor$runtime_release() {
        return this.anchor;
    }

    @NotNull
    public final ControlledComposition getComposition$runtime_release() {
        return this.composition;
    }

    @NotNull
    public final MovableContent<Object> getContent$runtime_release() {
        return this.content;
    }

    @NotNull
    public final List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> getInvalidations$runtime_release() {
        return this.invalidations;
    }

    @NotNull
    public final PersistentMap<CompositionLocal<Object>, State<Object>> getLocals$runtime_release() {
        return this.locals;
    }

    @Nullable
    public final Object getParameter$runtime_release() {
        return this.parameter;
    }

    @NotNull
    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }
}
