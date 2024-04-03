package androidx.compose.ui.tooling;

import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.google.android.exoplayer2.audio.WavUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u000b"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* renamed from: androidx.compose.ui.tooling.ComposableSingletons$PreviewActivityKt$lambda-1$1  reason: invalid class name */
public final class ComposableSingletons$PreviewActivityKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$PreviewActivityKt$lambda1$1 INSTANCE = new ComposableSingletons$PreviewActivityKt$lambda1$1();

    public ComposableSingletons$PreviewActivityKt$lambda1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            TextKt.m1461TextfLXpl1I("Next", (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 64, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
