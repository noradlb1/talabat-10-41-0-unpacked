package androidx.compose.ui.node;

import a0.a;
import a0.b;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ActualKt;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B*\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\r\u0010\u000f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0015\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0018R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/node/ModifierNodeElement;", "N", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "params", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "getParams$ui_release", "()Ljava/lang/Object;", "create", "()Landroidx/compose/ui/Modifier$Node;", "equals", "", "other", "hashCode", "", "update", "node", "(Landroidx/compose/ui/Modifier$Node;)Landroidx/compose/ui/Modifier$Node;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ModifierNodeElement<N extends Modifier.Node> extends InspectorValueInfo implements Modifier.Element {
    public static final int $stable = 0;
    @Nullable
    private final Object params;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ModifierNodeElement(Object obj, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : obj, function1);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    @NotNull
    public abstract N create();

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ModifierNodeElement) && ActualKt.areObjectsOfSameType(this, obj)) {
            return Intrinsics.areEqual(this.params, ((ModifierNodeElement) obj).params);
        }
        return false;
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @Nullable
    public final Object getParams$ui_release() {
        return this.params;
    }

    public int hashCode() {
        Object obj = this.params;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    @NotNull
    public abstract N update(@NotNull N n11);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModifierNodeElement(@Nullable Object obj, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.params = obj;
    }
}
