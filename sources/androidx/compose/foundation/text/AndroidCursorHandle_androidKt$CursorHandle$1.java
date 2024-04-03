package androidx.compose.foundation.text;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidCursorHandle_androidKt$CursorHandle$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3258g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3259h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f3260i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidCursorHandle_androidKt$CursorHandle$1(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, int i11) {
        super(2);
        this.f3258g = function2;
        this.f3259h = modifier;
        this.f3260i = i11;
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
                ComposerKt.traceEventStart(-1458480226, i11, -1, "androidx.compose.foundation.text.CursorHandle.<anonymous> (AndroidCursorHandle.android.kt:46)");
            }
            if (this.f3258g == null) {
                composer.startReplaceableGroup(1275643833);
                AndroidCursorHandle_androidKt.DefaultCursorHandle(this.f3259h, composer, (this.f3260i >> 3) & 14);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1275643903);
                this.f3258g.invoke(composer, Integer.valueOf((this.f3260i >> 6) & 14));
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
