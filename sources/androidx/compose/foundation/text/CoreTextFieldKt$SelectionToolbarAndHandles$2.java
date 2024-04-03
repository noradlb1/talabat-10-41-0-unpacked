package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$SelectionToolbarAndHandles$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3490g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f3491h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f3492i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$SelectionToolbarAndHandles$2(TextFieldSelectionManager textFieldSelectionManager, boolean z11, int i11) {
        super(2);
        this.f3490g = textFieldSelectionManager;
        this.f3491h = z11;
        this.f3492i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CoreTextFieldKt.SelectionToolbarAndHandles(this.f3490g, this.f3491h, composer, this.f3492i | 1);
    }
}
