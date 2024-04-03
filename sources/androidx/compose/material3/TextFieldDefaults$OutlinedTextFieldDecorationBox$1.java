package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldDefaults$OutlinedTextFieldDecorationBox$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f8676g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f8677h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f8678i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f8679j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8680k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f8681l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$OutlinedTextFieldDecorationBox$1(boolean z11, boolean z12, InteractionSource interactionSource, TextFieldColors textFieldColors, int i11, int i12) {
        super(2);
        this.f8676g = z11;
        this.f8677h = z12;
        this.f8678i = interactionSource;
        this.f8679j = textFieldColors;
        this.f8680k = i11;
        this.f8681l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        int i12 = i11;
        if ((i12 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(144282315, i12, -1, "androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:644)");
            }
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            boolean z11 = this.f8676g;
            boolean z12 = this.f8677h;
            InteractionSource interactionSource = this.f8678i;
            TextFieldColors textFieldColors = this.f8679j;
            int i13 = this.f8680k;
            Composer composer2 = composer;
            textFieldDefaults.m1908OutlinedBorderContainerBoxnbWgWpA(z11, z12, interactionSource, textFieldColors, (Shape) null, 0.0f, 0.0f, composer2, ((i13 >> 9) & 896) | ((i13 >> 6) & 14) | 12582912 | ((i13 >> 15) & 112) | ((this.f8681l << 3) & 7168), 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
