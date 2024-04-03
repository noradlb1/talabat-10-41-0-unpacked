package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldImplKt$CommonDecorationBox$labelColor$1 extends Lambda implements Function3<InputPhase, Composer, Integer, Color> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f5990g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f5991h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f5992i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f5993j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5994k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f5995l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$CommonDecorationBox$labelColor$1(TextFieldColors textFieldColors, boolean z11, boolean z12, InteractionSource interactionSource, int i11, int i12) {
        super(3);
        this.f5990g = textFieldColors;
        this.f5991h = z11;
        this.f5992i = z12;
        this.f5993j = interactionSource;
        this.f5994k = i11;
        this.f5995l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return Color.m2909boximpl(m1449invokeXeAY9LY((InputPhase) obj, (Composer) obj2, ((Number) obj3).intValue()));
    }

    @Composable
    /* renamed from: invoke-XeAY9LY  reason: not valid java name */
    public final long m1449invokeXeAY9LY(@NotNull InputPhase inputPhase, @Nullable Composer composer, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(inputPhase, "it");
        composer.startReplaceableGroup(697243846);
        TextFieldColors textFieldColors = this.f5990g;
        boolean z12 = this.f5991h;
        if (inputPhase == InputPhase.UnfocusedEmpty) {
            z11 = false;
        } else {
            z11 = this.f5992i;
        }
        InteractionSource interactionSource = this.f5993j;
        int i12 = this.f5995l;
        long r02 = textFieldColors.labelColor(z12, z11, interactionSource, composer, ((this.f5994k >> 27) & 14) | ((i12 << 3) & 896) | (i12 & 7168)).getValue().m2929unboximpl();
        composer.endReplaceableGroup();
        return r02;
    }
}
