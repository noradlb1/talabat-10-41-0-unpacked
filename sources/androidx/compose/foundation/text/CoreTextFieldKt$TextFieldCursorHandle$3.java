package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$TextFieldCursorHandle$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3496g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3497h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$TextFieldCursorHandle$3(TextFieldSelectionManager textFieldSelectionManager, int i11) {
        super(2);
        this.f3496g = textFieldSelectionManager;
        this.f3497h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CoreTextFieldKt.TextFieldCursorHandle(this.f3496g, composer, this.f3497h | 1);
    }
}
