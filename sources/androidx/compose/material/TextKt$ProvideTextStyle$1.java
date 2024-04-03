package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextKt$ProvideTextStyle$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6109g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6110h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f6111i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextKt$ProvideTextStyle$1(TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f6109g = textStyle;
        this.f6110h = function2;
        this.f6111i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TextKt.ProvideTextStyle(this.f6109g, this.f6110h, composer, this.f6111i | 1);
    }
}
