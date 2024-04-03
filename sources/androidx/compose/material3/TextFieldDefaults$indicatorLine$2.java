package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldDefaults$indicatorLine$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f8728g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f8729h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f8730i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f8731j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f8732k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f8733l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$indicatorLine$2(boolean z11, boolean z12, InteractionSource interactionSource, TextFieldColors textFieldColors, float f11, float f12) {
        super(3);
        this.f8728g = z11;
        this.f8729h = z12;
        this.f8730i = interactionSource;
        this.f8731j = textFieldColors;
        this.f8732k = f11;
        this.f8733l = f12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-891038934);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-891038934, i11, -1, "androidx.compose.material3.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:146)");
        }
        Modifier drawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.Companion, (BorderStroke) TextFieldDefaultsKt.m1921animateBorderStrokeAsStateNuRrP5Q(this.f8728g, this.f8729h, this.f8730i, this.f8731j, this.f8732k, this.f8733l, composer, 0).getValue());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return drawIndicatorLine;
    }
}
