package androidx.compose.material3.internal;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class PopupLayout$Content$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f9029g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9030h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PopupLayout$Content$4(PopupLayout popupLayout, int i11) {
        super(2);
        this.f9029g = popupLayout;
        this.f9030h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f9029g.Content(composer, this.f9030h | 1);
    }
}
