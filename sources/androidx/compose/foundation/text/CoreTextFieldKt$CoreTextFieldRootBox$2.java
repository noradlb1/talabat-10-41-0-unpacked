package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$CoreTextFieldRootBox$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f3486g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3487h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3488i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3489j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextFieldRootBox$2(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f3486g = modifier;
        this.f3487h = textFieldSelectionManager;
        this.f3488i = function2;
        this.f3489j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CoreTextFieldKt.CoreTextFieldRootBox(this.f3486g, this.f3487h, this.f3488i, composer, this.f3489j | 1);
    }
}
