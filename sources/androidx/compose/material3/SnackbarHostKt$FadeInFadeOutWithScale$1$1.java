package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarHostKt$FadeInFadeOutWithScale$1$1 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SnackbarData f8216g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SnackbarData f8217h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ List<SnackbarData> f8218i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FadeInFadeOutState<SnackbarData> f8219j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$FadeInFadeOutWithScale$1$1(SnackbarData snackbarData, SnackbarData snackbarData2, List<SnackbarData> list, FadeInFadeOutState<SnackbarData> fadeInFadeOutState) {
        super(3);
        this.f8216g = snackbarData;
        this.f8217h = snackbarData2;
        this.f8218i = list;
        this.f8219j = fadeInFadeOutState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(function22, "children");
        if ((i11 & 14) == 0) {
            i12 = i11 | (composer2.changed((Object) function22) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i12 & 91) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1365430839, i12, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:354)");
            }
            boolean areEqual = Intrinsics.areEqual((Object) this.f8216g, (Object) this.f8217h);
            int i13 = areEqual ? 150 : 75;
            int i14 = (!areEqual || CollectionsKt___CollectionsKt.filterNotNull(this.f8218i).size() == 1) ? 0 : 75;
            State access$animatedOpacity = SnackbarHostKt.animatedOpacity(AnimationSpecKt.tween(i13, i14, EasingKt.getLinearEasing()), areEqual, new SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1(this.f8216g, this.f8219j), composer, 0, 0);
            State access$animatedScale = SnackbarHostKt.animatedScale(AnimationSpecKt.tween(i13, i14, EasingKt.getFastOutSlowInEasing()), areEqual, composer2, 0);
            Modifier r22 = GraphicsLayerModifierKt.m3056graphicsLayerpANQ8Wg$default(Modifier.Companion, ((Number) access$animatedScale.getValue()).floatValue(), ((Number) access$animatedScale.getValue()).floatValue(), ((Number) access$animatedOpacity.getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 65528, (Object) null);
            SnackbarData snackbarData = this.f8216g;
            composer2.startReplaceableGroup(1157296644);
            boolean changed = composer2.changed((Object) snackbarData);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1(snackbarData);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(r22, false, (Function1) rememberedValue, 1, (Object) null);
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(semantics$default);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r102 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r102, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r102, density, companion.getSetDensity());
            Updater.m2543setimpl(r102, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r102, viewConfiguration, companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(-208740163);
            function22.invoke(composer2, Integer.valueOf(i12 & 14));
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
