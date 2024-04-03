package androidx.compose.foundation.text;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BasicTextKt$BasicText$6 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnnotatedString f3324g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> f3325h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f3326i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasicTextKt$BasicText$6(AnnotatedString annotatedString, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> list, int i11) {
        super(2);
        this.f3324g = annotatedString;
        this.f3325h = list;
        this.f3326i = i11;
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
                ComposerKt.traceEventStart(1892283635, i11, -1, "androidx.compose.foundation.text.BasicText.<anonymous> (BasicText.kt:239)");
            }
            CoreTextKt.InlineChildren(this.f3324g, this.f3325h, composer, (this.f3326i & 14) | 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
