package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldImplKt$Decoration$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f8806g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextStyle f8807h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8808i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8809j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8810k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$Decoration$1(long j11, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f8806g = j11;
        this.f8807h = textStyle;
        this.f8808i = function2;
        this.f8809j = i11;
        this.f8810k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TextFieldImplKt.m1923DecorationKTwxG1Y(this.f8806g, this.f8807h, this.f8808i, composer, this.f8809j | 1, this.f8810k);
    }
}
