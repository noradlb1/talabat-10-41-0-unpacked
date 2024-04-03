package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ContextMenu_androidKt$ContextMenuArea$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3357g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3358h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f3359i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextMenu_androidKt$ContextMenuArea$1(TextFieldSelectionManager textFieldSelectionManager, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f3357g = textFieldSelectionManager;
        this.f3358h = function2;
        this.f3359i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ContextMenu_androidKt.ContextMenuArea(this.f3357g, (Function2<? super Composer, ? super Integer, Unit>) this.f3358h, composer, this.f3359i | 1);
    }
}
