package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldDefaults$indicatorLine$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f5925g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f5926h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f5927i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f5928j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f5929k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f5930l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$indicatorLine$2(boolean z11, boolean z12, InteractionSource interactionSource, TextFieldColors textFieldColors, float f11, float f12) {
        super(3);
        this.f5925g = z11;
        this.f5926h = z12;
        this.f5927i = interactionSource;
        this.f5928j = textFieldColors;
        this.f5929k = f11;
        this.f5930l = f12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(1398930845);
        Modifier drawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.Companion, (BorderStroke) TextFieldDefaultsKt.m1444animateBorderStrokeAsStateNuRrP5Q(this.f5925g, this.f5926h, this.f5927i, this.f5928j, this.f5929k, this.f5930l, composer, 0).getValue());
        composer.endReplaceableGroup();
        return drawIndicatorLine;
    }
}
