package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldImplKt$CommonDecorationBox$labelColor$1 extends Lambda implements Function3<InputPhase, Composer, Integer, Color> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f8801g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f8802h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8803i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f8804j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8805k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$CommonDecorationBox$labelColor$1(TextFieldColors textFieldColors, boolean z11, boolean z12, InteractionSource interactionSource, int i11) {
        super(3);
        this.f8801g = textFieldColors;
        this.f8802h = z11;
        this.f8803i = z12;
        this.f8804j = interactionSource;
        this.f8805k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return Color.m2909boximpl(m1926invokeXeAY9LY((InputPhase) obj, (Composer) obj2, ((Number) obj3).intValue()));
    }

    @Composable
    /* renamed from: invoke-XeAY9LY  reason: not valid java name */
    public final long m1926invokeXeAY9LY(@NotNull InputPhase inputPhase, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(inputPhase, "it");
        composer.startReplaceableGroup(-379813807);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-379813807, i11, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
        }
        TextFieldColors textFieldColors = this.f8801g;
        boolean z11 = this.f8802h;
        boolean z12 = this.f8803i;
        InteractionSource interactionSource = this.f8804j;
        int i12 = this.f8805k;
        long r02 = textFieldColors.labelColor$material3_release(z11, z12, interactionSource, composer, (i12 & 14) | (i12 & 112) | (i12 & 896) | ((i12 >> 3) & 7168)).getValue().m2929unboximpl();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r02;
    }
}
