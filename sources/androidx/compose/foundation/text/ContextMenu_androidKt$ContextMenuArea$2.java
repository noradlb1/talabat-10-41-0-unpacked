package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ContextMenu_androidKt$ContextMenuArea$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SelectionManager f3360g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3361h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f3362i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextMenu_androidKt$ContextMenuArea$2(SelectionManager selectionManager, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f3360g = selectionManager;
        this.f3361h = function2;
        this.f3362i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ContextMenu_androidKt.ContextMenuArea(this.f3360g, (Function2<? super Composer, ? super Integer, Unit>) this.f3361h, composer, this.f3362i | 1);
    }
}
