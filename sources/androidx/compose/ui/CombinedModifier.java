package androidx.compose.ui;

import a0.a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u001c\u0010\r\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J5\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u0002H\u00122\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u00120\u0015H\u0016¢\u0006\u0002\u0010\u0016J5\u0010\u0017\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u0002H\u00122\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00120\u0015H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/CombinedModifier;", "Landroidx/compose/ui/Modifier;", "outer", "inner", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;)V", "getInner$ui_release", "()Landroidx/compose/ui/Modifier;", "getOuter$ui_release", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "equals", "other", "", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CombinedModifier implements Modifier {
    public static final int $stable = 0;
    @NotNull
    private final Modifier inner;
    @NotNull
    private final Modifier outer;

    public CombinedModifier(@NotNull Modifier modifier, @NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "outer");
        Intrinsics.checkNotNullParameter(modifier2, "inner");
        this.outer = modifier;
        this.inner = modifier2;
    }

    public boolean all(@NotNull Function1<? super Modifier.Element, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (!this.outer.all(function1) || !this.inner.all(function1)) {
            return false;
        }
        return true;
    }

    public boolean any(@NotNull Function1<? super Modifier.Element, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (this.outer.any(function1) || this.inner.any(function1)) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof CombinedModifier) {
            CombinedModifier combinedModifier = (CombinedModifier) obj;
            return Intrinsics.areEqual((Object) this.outer, (Object) combinedModifier.outer) && Intrinsics.areEqual((Object) this.inner, (Object) combinedModifier.inner);
        }
    }

    public <R> R foldIn(R r11, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return this.inner.foldIn(this.outer.foldIn(r11, function2), function2);
    }

    public <R> R foldOut(R r11, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return this.outer.foldOut(this.inner.foldOut(r11, function2), function2);
    }

    @NotNull
    public final Modifier getInner$ui_release() {
        return this.inner;
    }

    @NotNull
    public final Modifier getOuter$ui_release() {
        return this.outer;
    }

    public int hashCode() {
        return this.outer.hashCode() + (this.inner.hashCode() * 31);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return '[' + ((String) foldIn("", CombinedModifier$toString$1.INSTANCE)) + AbstractJsonLexerKt.END_LIST;
    }
}
