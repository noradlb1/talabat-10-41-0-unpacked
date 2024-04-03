package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CanvasKt$Canvas$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f1483g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f1484h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<DrawScope, Unit> f1485i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f1486j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CanvasKt$Canvas$3(Modifier modifier, String str, Function1<? super DrawScope, Unit> function1, int i11) {
        super(2);
        this.f1483g = modifier;
        this.f1484h = str;
        this.f1485i = function1;
        this.f1486j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CanvasKt.Canvas(this.f1483g, this.f1484h, this.f1485i, composer, this.f1486j | 1);
    }
}
