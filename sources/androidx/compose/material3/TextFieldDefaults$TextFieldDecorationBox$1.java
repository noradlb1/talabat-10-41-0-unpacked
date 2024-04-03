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
public final class TextFieldDefaults$TextFieldDecorationBox$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f8701g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f8702h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f8703i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f8704j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f8705k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f8706l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f8707m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$TextFieldDecorationBox$1(boolean z11, boolean z12, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, int i11, int i12) {
        super(2);
        this.f8701g = z11;
        this.f8702h = z12;
        this.f8703i = interactionSource;
        this.f8704j = textFieldColors;
        this.f8705k = shape;
        this.f8706l = i11;
        this.f8707m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1171460386, i11, -1, "androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:548)");
            }
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            boolean z11 = this.f8701g;
            boolean z12 = this.f8702h;
            InteractionSource interactionSource = this.f8703i;
            TextFieldColors textFieldColors = this.f8704j;
            Shape shape = this.f8705k;
            int i12 = this.f8706l;
            int i13 = this.f8707m;
            Composer composer2 = composer;
            textFieldDefaults.FilledContainerBox(z11, z12, interactionSource, textFieldColors, shape, composer2, ((i12 >> 9) & 896) | ((i12 >> 6) & 14) | 196608 | ((i12 >> 15) & 112) | (i13 & 7168) | ((i13 << 6) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
