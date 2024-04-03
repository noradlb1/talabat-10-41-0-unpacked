package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ComposeViewAdapter$WrapPreview$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposeViewAdapter f10231g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f10232h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f10233i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter$WrapPreview$2(ComposeViewAdapter composeViewAdapter, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f10231g = composeViewAdapter;
        this.f10232h = function2;
        this.f10233i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f10231g.WrapPreview(this.f10232h, composer, this.f10233i | 1);
    }
}
