package androidx.compose.foundation.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.exoplayer2.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001aM\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\f2\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00100\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0018\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0000\u001a\u001d\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0001¢\u0006\u0002\u0010 \u001a<\u0010!\u001a\u00020\u0010*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u0015H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u0007\n\u0005\b20\u0001¨\u0006+"}, d2 = {"DefaultBoxMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultBoxMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "EmptyBoxMeasurePolicy", "getEmptyBoxMeasurePolicy", "boxChildData", "Landroidx/compose/foundation/layout/BoxChildData;", "Landroidx/compose/ui/layout/Measurable;", "getBoxChildData", "(Landroidx/compose/ui/layout/Measurable;)Landroidx/compose/foundation/layout/BoxChildData;", "matchesParentSize", "", "getMatchesParentSize", "(Landroidx/compose/ui/layout/Measurable;)Z", "Box", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "boxMeasurePolicy", "alignment", "rememberBoxMeasurePolicy", "(Landroidx/compose/ui/Alignment;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "placeInBox", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "measurable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "boxWidth", "", "boxHeight", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BoxKt {
    @NotNull
    private static final MeasurePolicy DefaultBoxMeasurePolicy = boxMeasurePolicy(Alignment.Companion.getTopStart(), false);
    @NotNull
    private static final MeasurePolicy EmptyBoxMeasurePolicy = BoxKt$EmptyBoxMeasurePolicy$1.INSTANCE;

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void Box(@Nullable Modifier modifier, @Nullable Alignment alignment, boolean z11, @NotNull Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(function3, "content");
        composer.startReplaceableGroup(733328855);
        if ((i12 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i12 & 2) != 0) {
            alignment = Alignment.Companion.getTopStart();
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        int i13 = i11 >> 3;
        MeasurePolicy rememberBoxMeasurePolicy = rememberBoxMeasurePolicy(alignment, z11, composer, (i13 & 112) | (i13 & 14));
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
        int i14 = ((((i11 << 3) & 112) << 9) & 7168) | 6;
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
        Composer r32 = Updater.m2536constructorimpl(composer);
        Updater.m2543setimpl(r32, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r32, density, companion.getSetDensity());
        Updater.m2543setimpl(r32, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r32, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i14 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-2137368960);
        if (((i14 >> 9) & 14 & 11) != 2 || !composer.getSkipping()) {
            function3.invoke(BoxScopeInstance.INSTANCE, composer, Integer.valueOf(((i11 >> 6) & 112) | 6));
        } else {
            composer.skipToGroupEnd();
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @NotNull
    public static final MeasurePolicy boxMeasurePolicy(@NotNull Alignment alignment, boolean z11) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return new BoxKt$boxMeasurePolicy$1(z11, alignment);
    }

    private static final BoxChildData getBoxChildData(Measurable measurable) {
        Object parentData = measurable.getParentData();
        if (parentData instanceof BoxChildData) {
            return (BoxChildData) parentData;
        }
        return null;
    }

    @NotNull
    public static final MeasurePolicy getDefaultBoxMeasurePolicy() {
        return DefaultBoxMeasurePolicy;
    }

    @NotNull
    public static final MeasurePolicy getEmptyBoxMeasurePolicy() {
        return EmptyBoxMeasurePolicy;
    }

    /* access modifiers changed from: private */
    public static final boolean getMatchesParentSize(Measurable measurable) {
        BoxChildData boxChildData = getBoxChildData(measurable);
        if (boxChildData != null) {
            return boxChildData.getMatchParentSize();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final void placeInBox(Placeable.PlacementScope placementScope, Placeable placeable, Measurable measurable, LayoutDirection layoutDirection, int i11, int i12, Alignment alignment) {
        Alignment alignment2;
        Alignment alignment3;
        BoxChildData boxChildData = getBoxChildData(measurable);
        if (boxChildData == null || (alignment3 = boxChildData.getAlignment()) == null) {
            alignment2 = alignment;
        } else {
            alignment2 = alignment3;
        }
        Placeable.PlacementScope.m4529place70tqf50$default(placementScope, placeable, alignment2.m2554alignKFBX0sM(IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight()), IntSizeKt.IntSize(i11, i12), layoutDirection), 0.0f, 2, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: androidx.compose.ui.layout.MeasurePolicy} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @kotlin.PublishedApi
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.layout.MeasurePolicy rememberBoxMeasurePolicy(@org.jetbrains.annotations.NotNull androidx.compose.ui.Alignment r3, boolean r4, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r5, int r6) {
        /*
            java.lang.String r0 = "alignment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 56522820(0x35e7844, float:6.5377995E-37)
            r5.startReplaceableGroup(r0)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0017
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:80)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r1, r2)
        L_0x0017:
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getTopStart()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0028
            if (r4 != 0) goto L_0x0028
            androidx.compose.ui.layout.MeasurePolicy r3 = DefaultBoxMeasurePolicy
            goto L_0x0056
        L_0x0028:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            r0 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r5.startReplaceableGroup(r0)
            boolean r0 = r5.changed((java.lang.Object) r3)
            boolean r6 = r5.changed((java.lang.Object) r6)
            r6 = r6 | r0
            java.lang.Object r0 = r5.rememberedValue()
            if (r6 != 0) goto L_0x0049
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r0 != r6) goto L_0x0050
        L_0x0049:
            androidx.compose.ui.layout.MeasurePolicy r0 = boxMeasurePolicy(r3, r4)
            r5.updateRememberedValue(r0)
        L_0x0050:
            r5.endReplaceableGroup()
            r3 = r0
            androidx.compose.ui.layout.MeasurePolicy r3 = (androidx.compose.ui.layout.MeasurePolicy) r3
        L_0x0056:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x005f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x005f:
            r5.endReplaceableGroup()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(androidx.compose.ui.Alignment, boolean, androidx.compose.runtime.Composer, int):androidx.compose.ui.layout.MeasurePolicy");
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Box(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-211209833);
        if ((i11 & 14) == 0) {
            i12 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-211209833, i12, -1, "androidx.compose.foundation.layout.Box (Box.kt:199)");
            }
            MeasurePolicy measurePolicy = EmptyBoxMeasurePolicy;
            int i13 = ((i12 << 3) & 112) | RendererCapabilities.MODE_SUPPORT_MASK;
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i14 = ((i13 << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r72 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r72, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density, companion.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r72, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i14 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(1021196736);
            if (((i14 >> 9) & 14 & 11) == 2 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BoxKt$Box$3(modifier, i11));
        }
    }
}
