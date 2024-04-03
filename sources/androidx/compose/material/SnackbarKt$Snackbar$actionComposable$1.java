package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.google.android.exoplayer2.audio.WavUtil;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SnackbarKt$Snackbar$actionComposable$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f5445g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5446h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SnackbarData f5447i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f5448j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$Snackbar$actionComposable$1(long j11, int i11, SnackbarData snackbarData, String str) {
        super(2);
        this.f5445g = j11;
        this.f5446h = i11;
        this.f5447i = snackbarData;
        this.f5448j = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            ButtonColors r19 = ButtonDefaults.INSTANCE.m1138textButtonColorsRGew2ao(0, this.f5445g, 0, composer, ((this.f5446h >> 15) & 112) | KfsConstant.KFS_RSA_KEY_LEN_3072, 5);
            final SnackbarData snackbarData = this.f5447i;
            AnonymousClass1 r12 = new Function0<Unit>() {
                public final void invoke() {
                    snackbarData.performAction();
                }
            };
            final String str = this.f5448j;
            ButtonKt.TextButton(r12, (Modifier) null, false, (MutableInteractionSource) null, (ButtonElevation) null, (Shape) null, (BorderStroke) null, r19, (PaddingValues) null, ComposableLambdaKt.composableLambda(composer, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i11) {
                    Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
                    if ((i11 & 81) != 16 || !composer.getSkipping()) {
                        TextKt.m1461TextfLXpl1I(str, (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 805306368, 382);
            return;
        }
        composer.skipToGroupEnd();
    }
}
