package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u0001j\u0002`\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "invoke", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposerImpl$startProviders$currentProviders$1 extends Lambda implements Function2<Composer, Integer, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProvidedValue<?>[] f9098g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PersistentMap<CompositionLocal<Object>, State<Object>> f9099h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerImpl$startProviders$currentProviders$1(ProvidedValue<?>[] providedValueArr, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
        super(2);
        this.f9098g = providedValueArr;
        this.f9099h = persistentMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((Composer) obj, ((Number) obj2).intValue());
    }

    @NotNull
    @Composable
    public final PersistentMap<CompositionLocal<Object>, State<Object>> invoke(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(935231726);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(935231726, i11, -1, "androidx.compose.runtime.ComposerImpl.startProviders.<anonymous> (Composer.kt:1893)");
        }
        PersistentMap<CompositionLocal<Object>, State<Object>> access$compositionLocalMapOf = ComposerKt.compositionLocalMapOf(this.f9098g, this.f9099h, composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return access$compositionLocalMapOf;
    }
}
