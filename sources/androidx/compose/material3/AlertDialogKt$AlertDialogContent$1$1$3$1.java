package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AlertDialogKt$AlertDialogContent$1$1$3$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ColumnScope f6270g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6271h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f6272i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogContent$1$1$3$1(ColumnScope columnScope, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f6270g = columnScope;
        this.f6271h = function2;
        this.f6272i = i11;
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
                ComposerKt.traceEventStart(613970333, i11, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:96)");
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), DialogTokens.INSTANCE.getSupportingTextFont());
            final ColumnScope columnScope = this.f6270g;
            final Function2<Composer, Integer, Unit> function2 = this.f6271h;
            final int i12 = this.f6272i;
            TextKt.ProvideTextStyle(fromToken, ComposableLambdaKt.composableLambda(composer, -747827634, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-747827634, i11, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:99)");
                        }
                        ColumnScope columnScope = columnScope;
                        Modifier padding = PaddingKt.padding(columnScope.weight(Modifier.Companion, 1.0f, false), AlertDialogKt.TextPadding);
                        Alignment.Companion companion = Alignment.Companion;
                        Modifier align = columnScope.align(padding, companion.getStart());
                        Function2<Composer, Integer, Unit> function2 = function2;
                        int i12 = i12;
                        composer.startReplaceableGroup(733328855);
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, composer, 0);
                        composer.startReplaceableGroup(-1323940314);
                        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(align);
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(constructor);
                        } else {
                            composer.useNode();
                        }
                        composer.disableReusing();
                        Composer r82 = Updater.m2536constructorimpl(composer);
                        Updater.m2543setimpl(r82, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m2543setimpl(r82, density, companion2.getSetDensity());
                        Updater.m2543setimpl(r82, layoutDirection, companion2.getSetLayoutDirection());
                        Updater.m2543setimpl(r82, viewConfiguration, companion2.getSetViewConfiguration());
                        composer.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
                        composer.startReplaceableGroup(2058660585);
                        composer.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer.startReplaceableGroup(477417300);
                        function2.invoke(composer, Integer.valueOf((i12 >> 12) & 14));
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
            }), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
