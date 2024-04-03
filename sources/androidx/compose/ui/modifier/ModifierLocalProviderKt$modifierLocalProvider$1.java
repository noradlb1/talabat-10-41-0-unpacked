package androidx.compose.ui.modifier;

import a0.a;
import a0.b;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00028\u00008VX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"androidx/compose/ui/modifier/ModifierLocalProviderKt$modifierLocalProvider$1", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Ljava/lang/Object;", "value$delegate", "Landroidx/compose/runtime/State;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ModifierLocalProviderKt$modifierLocalProvider$1 extends InspectorValueInfo implements ModifierLocalProvider<T> {
    @NotNull
    private final ProvidableModifierLocal<T> key;
    @NotNull
    private final State value$delegate;

    public ModifierLocalProviderKt$modifierLocalProvider$1(ProvidableModifierLocal<T> providableModifierLocal, Function0<? extends T> function0, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.key = providableModifierLocal;
        this.value$delegate = SnapshotStateKt.derivedStateOf(function0);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public ProvidableModifierLocal<T> getKey() {
        return this.key;
    }

    public T getValue() {
        return this.value$delegate.getValue();
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
