package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/focus/FocusOrderModifierToProperties;", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusProperties;", "", "modifier", "Landroidx/compose/ui/focus/FocusOrderModifier;", "(Landroidx/compose/ui/focus/FocusOrderModifier;)V", "getModifier", "()Landroidx/compose/ui/focus/FocusOrderModifier;", "invoke", "focusProperties", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FocusOrderModifierToProperties implements Function1<FocusProperties, Unit> {
    @NotNull
    private final FocusOrderModifier modifier;

    public FocusOrderModifierToProperties(@NotNull FocusOrderModifier focusOrderModifier) {
        Intrinsics.checkNotNullParameter(focusOrderModifier, "modifier");
        this.modifier = focusOrderModifier;
    }

    @NotNull
    public final FocusOrderModifier getModifier() {
        return this.modifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusProperties) obj);
        return Unit.INSTANCE;
    }

    public void invoke(@NotNull FocusProperties focusProperties) {
        Intrinsics.checkNotNullParameter(focusProperties, "focusProperties");
        this.modifier.populateFocusOrder(new FocusOrder(focusProperties));
    }
}
