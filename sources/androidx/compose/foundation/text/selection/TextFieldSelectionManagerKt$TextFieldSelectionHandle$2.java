package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldSelectionManagerKt$TextFieldSelectionHandle$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f3754g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ResolvedTextDirection f3755h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3756i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3757j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManagerKt$TextFieldSelectionHandle$2(boolean z11, ResolvedTextDirection resolvedTextDirection, TextFieldSelectionManager textFieldSelectionManager, int i11) {
        super(2);
        this.f3754g = z11;
        this.f3755h = resolvedTextDirection;
        this.f3756i = textFieldSelectionManager;
        this.f3757j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TextFieldSelectionManagerKt.TextFieldSelectionHandle(this.f3754g, this.f3755h, this.f3756i, composer, this.f3757j | 1);
    }
}
