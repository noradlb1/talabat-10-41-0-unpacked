package androidx.compose.material3.internal;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f9023g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Function2<Composer, Integer, Unit>> f9024h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1(PopupLayout popupLayout, State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        super(2);
        this.f9023g = popupLayout;
        this.f9024h = state;
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
                ComposerKt.traceEventStart(686046343, i11, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.kt:99)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, AnonymousClass1.INSTANCE, 1, (Object) null);
            final PopupLayout popupLayout = this.f9023g;
            Modifier alpha = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(semantics$default, new Function1<IntSize, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m2016invokeozmzZPI(((IntSize) obj).m5642unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-ozmzZPI  reason: not valid java name */
                public final void m2016invokeozmzZPI(long j11) {
                    popupLayout.m2019setPopupContentSizefhxjrPA(IntSize.m5630boximpl(j11));
                    popupLayout.updatePosition();
                }
            }), this.f9023g.getCanCalculatePosition() ? 1.0f : 0.0f);
            final State<Function2<Composer, Integer, Unit>> state = this.f9024h;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 588819933, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(588819933, i11, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.kt:110)");
                        }
                        ExposedDropdownMenuPopupKt.m2013ExposedDropdownMenuPopup$lambda0(state).invoke(composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            composer.startReplaceableGroup(-483170785);
            ExposedDropdownMenuPopupKt$SimpleStack$1 exposedDropdownMenuPopupKt$SimpleStack$1 = ExposedDropdownMenuPopupKt$SimpleStack$1.INSTANCE;
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(alpha);
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
            Composer r72 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r72, exposedDropdownMenuPopupKt$SimpleStack$1, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density, companion.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r72, viewConfiguration, companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composableLambda.invoke(composer, 6);
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
