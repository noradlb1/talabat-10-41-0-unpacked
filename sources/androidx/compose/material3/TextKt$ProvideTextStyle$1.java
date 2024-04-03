package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextKt$ProvideTextStyle$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextStyle f8962g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8963h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f8964i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextKt$ProvideTextStyle$1(TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f8962g = textStyle;
        this.f8963h = function2;
        this.f8964i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TextKt.ProvideTextStyle(this.f8962g, this.f8963h, composer, this.f8964i | 1);
    }
}
