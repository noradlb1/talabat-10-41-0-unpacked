package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposeView$Content$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposeView f10024g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10025h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeView$Content$1(ComposeView composeView, int i11) {
        super(2);
        this.f10024g = composeView;
        this.f10025h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f10024g.Content(composer, this.f10025h | 1);
    }
}
