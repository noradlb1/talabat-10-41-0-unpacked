package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidSelectionHandles_androidKt$SelectionHandle$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3634g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3635h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f3636i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f3637j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f3638k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ResolvedTextDirection f3639l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f3640m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidSelectionHandles_androidKt$SelectionHandle$1(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z11, long j11, int i11, ResolvedTextDirection resolvedTextDirection, boolean z12) {
        super(2);
        this.f3634g = function2;
        this.f3635h = modifier;
        this.f3636i = z11;
        this.f3637j = j11;
        this.f3638k = i11;
        this.f3639l = resolvedTextDirection;
        this.f3640m = z12;
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
                ComposerKt.traceEventStart(732099485, i11, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:69)");
            }
            if (this.f3634g == null) {
                composer.startReplaceableGroup(386443790);
                Modifier modifier = this.f3635h;
                Boolean valueOf = Boolean.valueOf(this.f3636i);
                Offset r12 = Offset.m2665boximpl(this.f3637j);
                boolean z11 = this.f3636i;
                long j11 = this.f3637j;
                composer.startReplaceableGroup(511388516);
                boolean changed = composer.changed((Object) valueOf) | composer.changed((Object) r12);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1(z11, j11);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, (Object) null);
                boolean z12 = this.f3636i;
                ResolvedTextDirection resolvedTextDirection = this.f3639l;
                boolean z13 = this.f3640m;
                int i12 = this.f3638k;
                AndroidSelectionHandles_androidKt.DefaultSelectionHandle(semantics$default, z12, resolvedTextDirection, z13, composer, (i12 & 112) | (i12 & 896) | (i12 & 7168));
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(386444465);
                this.f3634g.invoke(composer, Integer.valueOf((this.f3638k >> 15) & 14));
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
