package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldDefaults$OutlinedTextFieldDecorationBox$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f5884g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f5885h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f5886i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f5887j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5888k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f5889l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$OutlinedTextFieldDecorationBox$1(boolean z11, boolean z12, InteractionSource interactionSource, TextFieldColors textFieldColors, int i11, int i12) {
        super(2);
        this.f5884g = z11;
        this.f5885h = z12;
        this.f5886i = interactionSource;
        this.f5887j = textFieldColors;
        this.f5888k = i11;
        this.f5889l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            boolean z11 = this.f5884g;
            boolean z12 = this.f5885h;
            InteractionSource interactionSource = this.f5886i;
            TextFieldColors textFieldColors = this.f5887j;
            int i12 = this.f5888k;
            textFieldDefaults.m1432BorderBoxnbWgWpA(z11, z12, interactionSource, textFieldColors, (Shape) null, 0.0f, 0.0f, composer, ((i12 >> 9) & 896) | ((i12 >> 6) & 14) | 12582912 | ((i12 >> 15) & 112) | ((this.f5889l << 6) & 7168), 112);
            return;
        }
        composer.skipToGroupEnd();
    }
}
