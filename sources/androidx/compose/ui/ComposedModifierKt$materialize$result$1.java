package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusRequesterModifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "acc", "element", "Landroidx/compose/ui/Modifier$Element;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposedModifierKt$materialize$result$1 extends Lambda implements Function2<Modifier, Modifier.Element, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Composer f9552g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposedModifierKt$materialize$result$1(Composer composer) {
        super(2);
        this.f9552g = composer;
    }

    @NotNull
    public final Modifier invoke(@NotNull Modifier modifier, @NotNull Modifier.Element element) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(modifier, "acc");
        Intrinsics.checkNotNullParameter(element, "element");
        if (element instanceof ComposedModifier) {
            Function3<Modifier, Composer, Integer, Modifier> factory = ((ComposedModifier) element).getFactory();
            Intrinsics.checkNotNull(factory, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function3<androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
            modifier2 = ComposedModifierKt.materialize(this.f9552g, (Modifier) ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(factory, 3)).invoke(Modifier.Companion, this.f9552g, 0));
        } else {
            if (element instanceof FocusEventModifier) {
                Function3 access$getWrapFocusEventModifier$p = ComposedModifierKt.WrapFocusEventModifier;
                Intrinsics.checkNotNull(access$getWrapFocusEventModifier$p, "null cannot be cast to non-null type kotlin.Function3<androidx.compose.ui.focus.FocusEventModifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
                modifier3 = element.then((Modifier) ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(access$getWrapFocusEventModifier$p, 3)).invoke(element, this.f9552g, 0));
            } else {
                modifier3 = element;
            }
            if (element instanceof FocusRequesterModifier) {
                Function3 access$getWrapFocusRequesterModifier$p = ComposedModifierKt.WrapFocusRequesterModifier;
                Intrinsics.checkNotNull(access$getWrapFocusRequesterModifier$p, "null cannot be cast to non-null type kotlin.Function3<androidx.compose.ui.focus.FocusRequesterModifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
                modifier2 = modifier3.then((Modifier) ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(access$getWrapFocusRequesterModifier$p, 3)).invoke(element, this.f9552g, 0));
            } else {
                modifier2 = modifier3;
            }
        }
        return modifier.then(modifier2);
    }
}
