package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldImplKt$Decoration$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f5996g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextStyle f5997h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Float f5998i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5999j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f6000k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f6001l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$Decoration$1(long j11, TextStyle textStyle, Float f11, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f5996g = j11;
        this.f5997h = textStyle;
        this.f5998i = f11;
        this.f5999j = function2;
        this.f6000k = i11;
        this.f6001l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TextFieldImplKt.m1446DecorationeuL9pac(this.f5996g, this.f5997h, this.f5998i, this.f5999j, composer, this.f6000k | 1, this.f6001l);
    }
}
