package com.designsystem.ds_simple_card;

import android.view.View;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.semantics.Role;
import com.designsystem.ds_theme.DSTheme;
import com.designsystem.extensions.ViewExtensionsKt;
import com.designsystem.modifier.BoxShadowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSimpleCardKt$DSSimpleCard$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32639g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32640h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f32641i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ View f32642j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f32643k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DSSimpleCardImageModel f32644l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f32645m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Integer f32646n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f32647o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ long f32648p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ MutableState<Alignment.Vertical> f32649q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f32650r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ long f32651s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSimpleCardKt$DSSimpleCard$2(Modifier modifier, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource, View view, Function2<? super Composer, ? super Integer, Unit> function2, DSSimpleCardImageModel dSSimpleCardImageModel, String str, Integer num, String str2, long j11, MutableState<Alignment.Vertical> mutableState, int i11, long j12) {
        super(2);
        this.f32639g = modifier;
        this.f32640h = function0;
        this.f32641i = mutableInteractionSource;
        this.f32642j = view;
        this.f32643k = function2;
        this.f32644l = dSSimpleCardImageModel;
        this.f32645m = str;
        this.f32646n = num;
        this.f32647o = str2;
        this.f32648p = j11;
        this.f32649q = mutableState;
        this.f32650r = i11;
        this.f32651s = j12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            RoundedCornerShape access$getCardShape$p = DSSimpleCardKt.CardShape;
            DSTheme dSTheme = DSTheme.INSTANCE;
            long r11 = dSTheme.getColors(composer2, 0).m8774getDsNeutralWhite0d7_KjU();
            Modifier clip = ClipKt.clip(SizeKt.fillMaxWidth$default(BoxShadowKt.boxShadow(this.f32639g, dSTheme.getElevation(composer2, 0).getDsElevationMedium(), DSSimpleCardKt.CardShape), 0.0f, 1, (Object) null), DSSimpleCardKt.CardShape);
            boolean z11 = this.f32640h != null;
            Indication r15 = RippleKt.m1485rememberRipple9IZ8Weo(false, 0.0f, dSTheme.getColors(composer2, 0).m8764getDsNeutral350d7_KjU(), composer, 0, 3);
            MutableInteractionSource mutableInteractionSource = this.f32641i;
            final Function0<Unit> function0 = this.f32640h;
            final View view = this.f32642j;
            Modifier r12 = ClickableKt.m194clickableO2vRcR0$default(clip, mutableInteractionSource, r15, z11, (String) null, (Role) null, new Function0<Unit>() {
                public final void invoke() {
                    Function0<Unit> function0 = function0;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    ViewExtensionsKt.performSelectionFeedback(view);
                }
            }, 24, (Object) null);
            final Function2<Composer, Integer, Unit> function2 = this.f32643k;
            DSSimpleCardImageModel dSSimpleCardImageModel = this.f32644l;
            String str = this.f32645m;
            Integer num = this.f32646n;
            String str2 = this.f32647o;
            long j11 = this.f32648p;
            final Integer num2 = num;
            final DSSimpleCardImageModel dSSimpleCardImageModel2 = dSSimpleCardImageModel;
            final String str3 = str;
            final String str4 = str2;
            final long j12 = j11;
            final MutableState<Alignment.Vertical> mutableState = this.f32649q;
            final int i12 = this.f32650r;
            final long j13 = this.f32651s;
            SurfaceKt.m1384SurfaceFjzlyU(r12, access$getCardShape$p, r11, 0, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -819890892, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: kotlin.jvm.functions.Function1} */
                /* JADX WARNING: Multi-variable type inference failed */
                @androidx.compose.runtime.Composable
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r48, int r49) {
                    /*
                        r47 = this;
                        r0 = r47
                        r14 = r48
                        r1 = r49 & 11
                        r15 = 2
                        r1 = r1 ^ r15
                        if (r1 != 0) goto L_0x0016
                        boolean r1 = r48.getSkipping()
                        if (r1 != 0) goto L_0x0011
                        goto L_0x0016
                    L_0x0011:
                        r48.skipToGroupEnd()
                        goto L_0x0627
                    L_0x0016:
                        androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
                        com.designsystem.ds_theme.DSTheme r12 = com.designsystem.ds_theme.DSTheme.INSTANCE
                        r11 = 0
                        com.designsystem.ds_theme.DSDimens r1 = r12.getDimens(r14, r11)
                        float r1 = r1.m8844getDsXsD9Ej5fM()
                        androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m486padding3ABfNKs(r13, r1)
                        androidx.compose.ui.Alignment$Companion r25 = androidx.compose.ui.Alignment.Companion
                        androidx.compose.ui.Alignment$Vertical r2 = r25.getCenterVertically()
                        kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r10 = r15
                        com.designsystem.ds_simple_card.DSSimpleCardImageModel r8 = r16
                        java.lang.String r9 = r17
                        java.lang.Integer r7 = r18
                        java.lang.String r6 = r19
                        long r4 = r20
                        androidx.compose.runtime.MutableState<androidx.compose.ui.Alignment$Vertical> r3 = r22
                        int r15 = r23
                        r17 = r9
                        r16 = r10
                        long r9 = r24
                        r18 = r12
                        r12 = -1989997546(0xffffffff89630c16, float:-2.7329814E-33)
                        r14.startReplaceableGroup(r12)
                        r19 = r9
                        androidx.compose.foundation.layout.Arrangement r10 = androidx.compose.foundation.layout.Arrangement.INSTANCE
                        androidx.compose.foundation.layout.Arrangement$Horizontal r9 = r10.getStart()
                        androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r9, r2, r14, r11)
                        r9 = 1376089335(0x520574f7, float:1.43298249E11)
                        r14.startReplaceableGroup(r9)
                        androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                        java.lang.Object r9 = r14.consume(r9)
                        androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
                        androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
                        java.lang.Object r12 = r14.consume(r12)
                        androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
                        androidx.compose.ui.node.ComposeUiNode$Companion r26 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function0 r11 = r26.getConstructor()
                        kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
                        androidx.compose.runtime.Applier r0 = r48.getApplier()
                        boolean r0 = r0 instanceof androidx.compose.runtime.Applier
                        if (r0 != 0) goto L_0x0086
                        androidx.compose.runtime.ComposablesKt.invalidApplier()
                    L_0x0086:
                        r48.startReusableNode()
                        boolean r0 = r48.getInserting()
                        if (r0 == 0) goto L_0x0093
                        r14.createNode(r11)
                        goto L_0x0096
                    L_0x0093:
                        r48.useNode()
                    L_0x0096:
                        r48.disableReusing()
                        androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m2536constructorimpl(r48)
                        kotlin.jvm.functions.Function2 r11 = r26.getSetMeasurePolicy()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r2, r11)
                        kotlin.jvm.functions.Function2 r2 = r26.getSetDensity()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r9, r2)
                        kotlin.jvm.functions.Function2 r2 = r26.getSetLayoutDirection()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r12, r2)
                        r48.enableReusing()
                        androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r48)
                        androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r0)
                        r2 = 0
                        java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
                        r1.invoke(r0, r14, r9)
                        r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                        r14.startReplaceableGroup(r0)
                        r12 = -326682743(0xffffffffec873789, float:-1.307738E27)
                        r14.startReplaceableGroup(r12)
                        androidx.compose.foundation.layout.RowScopeInstance r11 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
                        r1 = 1065353216(0x3f800000, float:1.0)
                        r9 = 0
                        r24 = 2
                        r27 = 0
                        r2 = r11
                        r28 = r3
                        r3 = r13
                        r29 = r4
                        r4 = r1
                        r5 = r9
                        r31 = r6
                        r6 = r24
                        r32 = r7
                        r7 = r27
                        androidx.compose.ui.Modifier r1 = p.e.a(r2, r3, r4, r5, r6, r7)
                        r9 = -1989997546(0xffffffff89630c16, float:-2.7329814E-33)
                        r14.startReplaceableGroup(r9)
                        androidx.compose.foundation.layout.Arrangement$Horizontal r2 = r10.getStart()
                        androidx.compose.ui.Alignment$Vertical r3 = r25.getTop()
                        r4 = 0
                        androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r2, r3, r14, r4)
                        r7 = 1376089335(0x520574f7, float:1.43298249E11)
                        r14.startReplaceableGroup(r7)
                        androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                        java.lang.Object r3 = r14.consume(r3)
                        androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
                        androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
                        java.lang.Object r4 = r14.consume(r4)
                        androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
                        kotlin.jvm.functions.Function0 r5 = r26.getConstructor()
                        kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
                        androidx.compose.runtime.Applier r6 = r48.getApplier()
                        boolean r6 = r6 instanceof androidx.compose.runtime.Applier
                        if (r6 != 0) goto L_0x012e
                        androidx.compose.runtime.ComposablesKt.invalidApplier()
                    L_0x012e:
                        r48.startReusableNode()
                        boolean r6 = r48.getInserting()
                        if (r6 == 0) goto L_0x013b
                        r14.createNode(r5)
                        goto L_0x013e
                    L_0x013b:
                        r48.useNode()
                    L_0x013e:
                        r48.disableReusing()
                        androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m2536constructorimpl(r48)
                        kotlin.jvm.functions.Function2 r6 = r26.getSetMeasurePolicy()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r2, r6)
                        kotlin.jvm.functions.Function2 r2 = r26.getSetDensity()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r3, r2)
                        kotlin.jvm.functions.Function2 r2 = r26.getSetLayoutDirection()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r4, r2)
                        r48.enableReusing()
                        androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r48)
                        androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r2)
                        r21 = 0
                        java.lang.Integer r3 = java.lang.Integer.valueOf(r21)
                        r1.invoke(r2, r14, r3)
                        r14.startReplaceableGroup(r0)
                        r14.startReplaceableGroup(r12)
                        if (r8 != 0) goto L_0x0190
                        r1 = -1208913972(0xffffffffb7f16fcc, float:-2.8781498E-5)
                        r14.startReplaceableGroup(r1)
                        r48.endReplaceableGroup()
                        r0 = r10
                        r38 = r11
                        r37 = r16
                        r34 = r17
                        r35 = r19
                        r12 = r21
                        r16 = r15
                        r15 = r13
                        r13 = r18
                        goto L_0x01f3
                    L_0x0190:
                        r1 = 2039212757(0x798bead5, float:9.081153E34)
                        r14.startReplaceableGroup(r1)
                        java.lang.String r1 = r8.getImageUrl()
                        com.designsystem.ds_image.DSImageRatio r2 = com.designsystem.ds_image.DSImageRatio.OneToOne
                        float r22 = r8.m8570getCornerRadiusD9Ej5fM()
                        java.lang.String r4 = r8.getPlaceholderImageUrl()
                        float r5 = com.designsystem.ds_simple_card.DSSimpleCardKt.ImageSize
                        java.lang.String r3 = "ImageTag"
                        androidx.compose.ui.Modifier r3 = androidx.compose.ui.platform.TestTagKt.testTag(r13, r3)
                        r6 = 0
                        r8 = 0
                        r23 = 0
                        r24 = 0
                        r27 = 25008(0x61b0, float:3.5044E-41)
                        r33 = 864(0x360, float:1.211E-42)
                        r34 = r7
                        r7 = r8
                        r8 = r22
                        r35 = r19
                        r0 = r34
                        r34 = r17
                        r17 = r9
                        r9 = r23
                        r0 = r10
                        r37 = r16
                        r10 = r24
                        r38 = r11
                        r11 = r48
                        r40 = r18
                        r12 = r27
                        r16 = r15
                        r15 = r13
                        r13 = r33
                        com.designsystem.ds_image.DSRatioImageKt.m8361DSRatioImageDSyytA(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                        r13 = r40
                        r12 = 0
                        com.designsystem.ds_theme.DSDimens r1 = r13.getDimens(r14, r12)
                        float r1 = r1.m8844getDsXsD9Ej5fM()
                        androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r15, r1)
                        androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r14, r12)
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        r48.endReplaceableGroup()
                    L_0x01f3:
                        com.designsystem.ds_theme.DSDimens r1 = r13.getDimens(r14, r12)
                        float r1 = r1.m8848getDsXxxsD9Ej5fM()
                        androidx.compose.ui.Alignment$Vertical r2 = r25.getCenterVertically()
                        androidx.compose.foundation.layout.Arrangement$Vertical r1 = r0.m396spacedByD5KLDUw((float) r1, (androidx.compose.ui.Alignment.Vertical) r2)
                        r2 = -1113031299(0xffffffffbda87d7d, float:-0.0822706)
                        r14.startReplaceableGroup(r2)
                        androidx.compose.ui.Alignment$Horizontal r2 = r25.getStart()
                        androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r1, r2, r14, r12)
                        r2 = 1376089335(0x520574f7, float:1.43298249E11)
                        r14.startReplaceableGroup(r2)
                        androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                        java.lang.Object r2 = r14.consume(r2)
                        androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
                        androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
                        java.lang.Object r3 = r14.consume(r3)
                        androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
                        kotlin.jvm.functions.Function0 r4 = r26.getConstructor()
                        kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r15)
                        androidx.compose.runtime.Applier r6 = r48.getApplier()
                        boolean r6 = r6 instanceof androidx.compose.runtime.Applier
                        if (r6 != 0) goto L_0x023e
                        androidx.compose.runtime.ComposablesKt.invalidApplier()
                    L_0x023e:
                        r48.startReusableNode()
                        boolean r6 = r48.getInserting()
                        if (r6 == 0) goto L_0x024b
                        r14.createNode(r4)
                        goto L_0x024e
                    L_0x024b:
                        r48.useNode()
                    L_0x024e:
                        r48.disableReusing()
                        androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m2536constructorimpl(r48)
                        kotlin.jvm.functions.Function2 r6 = r26.getSetMeasurePolicy()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r1, r6)
                        kotlin.jvm.functions.Function2 r1 = r26.getSetDensity()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r2, r1)
                        kotlin.jvm.functions.Function2 r1 = r26.getSetLayoutDirection()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r3, r1)
                        r48.enableReusing()
                        androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r48)
                        androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
                        r5.invoke(r1, r14, r2)
                        r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                        r14.startReplaceableGroup(r1)
                        r1 = 276693241(0x107e00f9, float:5.0093417E-29)
                        r14.startReplaceableGroup(r1)
                        androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
                        r10 = -1989997546(0xffffffff89630c16, float:-2.7329814E-33)
                        r14.startReplaceableGroup(r10)
                        androidx.compose.foundation.layout.Arrangement$Horizontal r1 = r0.getStart()
                        androidx.compose.ui.Alignment$Vertical r2 = r25.getTop()
                        androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r1, r2, r14, r12)
                        r2 = 1376089335(0x520574f7, float:1.43298249E11)
                        r14.startReplaceableGroup(r2)
                        androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                        java.lang.Object r2 = r14.consume(r2)
                        androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
                        androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
                        java.lang.Object r3 = r14.consume(r3)
                        androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
                        kotlin.jvm.functions.Function0 r4 = r26.getConstructor()
                        kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r15)
                        androidx.compose.runtime.Applier r6 = r48.getApplier()
                        boolean r6 = r6 instanceof androidx.compose.runtime.Applier
                        if (r6 != 0) goto L_0x02c9
                        androidx.compose.runtime.ComposablesKt.invalidApplier()
                    L_0x02c9:
                        r48.startReusableNode()
                        boolean r6 = r48.getInserting()
                        if (r6 == 0) goto L_0x02d6
                        r14.createNode(r4)
                        goto L_0x02d9
                    L_0x02d6:
                        r48.useNode()
                    L_0x02d9:
                        r48.disableReusing()
                        androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m2536constructorimpl(r48)
                        kotlin.jvm.functions.Function2 r6 = r26.getSetMeasurePolicy()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r1, r6)
                        kotlin.jvm.functions.Function2 r1 = r26.getSetDensity()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r2, r1)
                        kotlin.jvm.functions.Function2 r1 = r26.getSetLayoutDirection()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r3, r1)
                        r48.enableReusing()
                        androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r48)
                        androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
                        r5.invoke(r1, r14, r2)
                        r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                        r14.startReplaceableGroup(r1)
                        r11 = -326682743(0xffffffffec873789, float:-1.307738E27)
                        r14.startReplaceableGroup(r11)
                        if (r32 != 0) goto L_0x0321
                        r1 = -904746844(0xffffffffca12a8a4, float:-2402857.0)
                        r14.startReplaceableGroup(r1)
                        r48.endReplaceableGroup()
                        r9 = r38
                        goto L_0x036a
                    L_0x0321:
                        r1 = -999016707(0xffffffffc47436fd, float:-976.8592)
                        r14.startReplaceableGroup(r1)
                        int r1 = r32.intValue()
                        androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r14, r12)
                        float r2 = com.designsystem.ds_simple_card.DSSimpleCardKt.IconSize
                        androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m558size3ABfNKs(r15, r2)
                        java.lang.String r3 = "IconTag"
                        androidx.compose.ui.Modifier r2 = androidx.compose.ui.platform.TestTagKt.testTag(r2, r3)
                        androidx.compose.ui.Alignment$Vertical r3 = com.designsystem.ds_simple_card.DSSimpleCardKt.m8572DSSimpleCard_baIBcDA$lambda3(r28)
                        r9 = r38
                        androidx.compose.ui.Modifier r3 = r9.align(r2, r3)
                        r2 = 0
                        int r4 = r16 << 3
                        r4 = r4 & 7168(0x1c00, float:1.0045E-41)
                        r7 = r4 | 56
                        r8 = 0
                        r4 = r29
                        r6 = r48
                        androidx.compose.material.IconKt.m1278Iconww6aTOc((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (long) r4, (androidx.compose.runtime.Composer) r6, (int) r7, (int) r8)
                        com.designsystem.ds_theme.DSDimens r1 = r13.getDimens(r14, r12)
                        float r1 = r1.m8848getDsXxxsD9Ej5fM()
                        androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r15, r1)
                        androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r14, r12)
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        r48.endReplaceableGroup()
                    L_0x036a:
                        com.designsystem.ds_theme.DSTypography r1 = r13.getTypography(r14, r12)
                        androidx.compose.ui.text.TextStyle r20 = r1.getDsSubheading2()
                        if (r34 == 0) goto L_0x0378
                        r1 = 1
                        r18 = r1
                        goto L_0x037a
                    L_0x0378:
                        r18 = 2
                    L_0x037a:
                        androidx.compose.ui.text.style.TextOverflow$Companion r27 = androidx.compose.ui.text.style.TextOverflow.Companion
                        int r17 = r27.m5403getEllipsisgIe3tQ8()
                        r2 = 0
                        r5 = 0
                        r7 = 0
                        r8 = 0
                        r21 = 0
                        r38 = 0
                        r33 = 0
                        r40 = 0
                        r41 = 0
                        r43 = 0
                        r1 = -3686930(0xffffffffffc7bdee, float:NaN)
                        r14.startReplaceableGroup(r1)
                        r1 = r28
                        boolean r3 = r14.changed((java.lang.Object) r1)
                        java.lang.Object r4 = r48.rememberedValue()
                        if (r3 != 0) goto L_0x03ab
                        androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r3 = r3.getEmpty()
                        if (r4 != r3) goto L_0x03b3
                    L_0x03ab:
                        com.designsystem.ds_simple_card.DSSimpleCardKt$DSSimpleCard$2$2$1$1$2$1$2$1 r4 = new com.designsystem.ds_simple_card.DSSimpleCardKt$DSSimpleCard$2$2$1$1$2$1$2$1
                        r4.<init>(r1)
                        r14.updateRememberedValue(r4)
                    L_0x03b3:
                        r48.endReplaceableGroup()
                        r19 = r4
                        kotlin.jvm.functions.Function1 r19 = (kotlin.jvm.functions.Function1) r19
                        r1 = r16 & 14
                        r3 = r16
                        r4 = r3 & 896(0x380, float:1.256E-42)
                        r22 = r1 | r4
                        r23 = 64
                        r24 = 6138(0x17fa, float:8.601E-42)
                        r1 = r31
                        r3 = r29
                        r44 = r9
                        r9 = r21
                        r10 = r38
                        r12 = r33
                        r45 = r13
                        r13 = r40
                        r49 = r15
                        r28 = r16
                        r14 = r41
                        r16 = r17
                        r17 = r43
                        r21 = r48
                        androidx.compose.material.TextKt.m1461TextfLXpl1I(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
                        r48.endReplaceableGroup()
                        r48.endReplaceableGroup()
                        r48.endNode()
                        r48.endReplaceableGroup()
                        r48.endReplaceableGroup()
                        if (r34 != 0) goto L_0x0407
                        r0 = -205999669(0xfffffffff3b8b1cb, float:-2.9266012E31)
                        r3 = r48
                        r3.startReplaceableGroup(r0)
                        r48.endReplaceableGroup()
                        r0 = r49
                        r46 = r45
                        goto L_0x051e
                    L_0x0407:
                        r3 = r48
                        r1 = 686091510(0x28e4ecf6, float:2.541585E-14)
                        r3.startReplaceableGroup(r1)
                        r1 = -1989997546(0xffffffff89630c16, float:-2.7329814E-33)
                        r3.startReplaceableGroup(r1)
                        androidx.compose.foundation.layout.Arrangement$Horizontal r0 = r0.getStart()
                        androidx.compose.ui.Alignment$Vertical r1 = r25.getTop()
                        r4 = 0
                        androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r0, r1, r3, r4)
                        r1 = 1376089335(0x520574f7, float:1.43298249E11)
                        r3.startReplaceableGroup(r1)
                        androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                        java.lang.Object r1 = r3.consume(r1)
                        androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
                        androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
                        java.lang.Object r2 = r3.consume(r2)
                        androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
                        kotlin.jvm.functions.Function0 r5 = r26.getConstructor()
                        kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.materializerOf(r49)
                        androidx.compose.runtime.Applier r7 = r48.getApplier()
                        boolean r7 = r7 instanceof androidx.compose.runtime.Applier
                        if (r7 != 0) goto L_0x044f
                        androidx.compose.runtime.ComposablesKt.invalidApplier()
                    L_0x044f:
                        r48.startReusableNode()
                        boolean r7 = r48.getInserting()
                        if (r7 == 0) goto L_0x045c
                        r3.createNode(r5)
                        goto L_0x045f
                    L_0x045c:
                        r48.useNode()
                    L_0x045f:
                        r48.disableReusing()
                        androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m2536constructorimpl(r48)
                        kotlin.jvm.functions.Function2 r7 = r26.getSetMeasurePolicy()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r0, r7)
                        kotlin.jvm.functions.Function2 r0 = r26.getSetDensity()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r1, r0)
                        kotlin.jvm.functions.Function2 r0 = r26.getSetLayoutDirection()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r2, r0)
                        r48.enableReusing()
                        androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r48)
                        androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r0)
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
                        r6.invoke(r0, r3, r1)
                        r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                        r3.startReplaceableGroup(r0)
                        r0 = -326682743(0xffffffffec873789, float:-1.307738E27)
                        r3.startReplaceableGroup(r0)
                        if (r32 != 0) goto L_0x04a9
                        r0 = 748174779(0x2c983dbb, float:4.3269533E-12)
                        r3.startReplaceableGroup(r0)
                        r48.endReplaceableGroup()
                        r14 = r49
                        r1 = r45
                        goto L_0x04d3
                    L_0x04a9:
                        r0 = -252959994(0xfffffffff0ec2306, float:-5.8464642E29)
                        r3.startReplaceableGroup(r0)
                        r32.intValue()
                        float r0 = com.designsystem.ds_simple_card.DSSimpleCardKt.IconSize
                        r1 = r45
                        com.designsystem.ds_theme.DSDimens r2 = r1.getDimens(r3, r4)
                        float r2 = r2.m8848getDsXxxsD9Ej5fM()
                        float r0 = r0 + r2
                        float r0 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
                        r14 = r49
                        androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r14, r0)
                        androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r3, r4)
                        kotlin.Unit r0 = kotlin.Unit.INSTANCE
                        r48.endReplaceableGroup()
                    L_0x04d3:
                        com.designsystem.ds_theme.DSTypography r0 = r1.getTypography(r3, r4)
                        androidx.compose.ui.text.TextStyle r20 = r0.getDsBody1Compact()
                        int r16 = r27.m5403getEllipsisgIe3tQ8()
                        r2 = 0
                        r5 = 0
                        r7 = 0
                        r8 = 0
                        r9 = 0
                        r10 = 0
                        r12 = 0
                        r13 = 0
                        r17 = 0
                        r0 = r14
                        r14 = r17
                        r17 = 0
                        r18 = 1
                        r19 = 0
                        int r4 = r28 >> 6
                        r4 = r4 & 896(0x380, float:1.256E-42)
                        r22 = r4
                        r23 = 3136(0xc40, float:4.394E-42)
                        r24 = 22522(0x57fa, float:3.156E-41)
                        r4 = r1
                        r1 = r34
                        r46 = r4
                        r3 = r35
                        r21 = r48
                        androidx.compose.material.TextKt.m1461TextfLXpl1I(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
                        r48.endReplaceableGroup()
                        r48.endReplaceableGroup()
                        r48.endNode()
                        r48.endReplaceableGroup()
                        r48.endReplaceableGroup()
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        r48.endReplaceableGroup()
                    L_0x051e:
                        r48.endReplaceableGroup()
                        r48.endReplaceableGroup()
                        r48.endNode()
                        r48.endReplaceableGroup()
                        r48.endReplaceableGroup()
                        r48.endReplaceableGroup()
                        r48.endReplaceableGroup()
                        r48.endNode()
                        r48.endReplaceableGroup()
                        r48.endReplaceableGroup()
                        r1 = r37
                        if (r1 != 0) goto L_0x054d
                        r0 = -1031049929(0xffffffffc28b6d37, float:-69.71331)
                        r2 = r48
                        r2.startReplaceableGroup(r0)
                    L_0x0548:
                        r48.endReplaceableGroup()
                        goto L_0x0618
                    L_0x054d:
                        r2 = r48
                        r3 = 1213666314(0x4857140a, float:220240.16)
                        r2.startReplaceableGroup(r3)
                        r3 = r46
                        r4 = 0
                        com.designsystem.ds_theme.DSDimens r3 = r3.getDimens(r2, r4)
                        float r3 = r3.m8844getDsXsD9Ej5fM()
                        androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r0, r3)
                        androidx.compose.foundation.layout.SpacerKt.Spacer(r3, r2, r4)
                        androidx.compose.ui.Alignment$Vertical r3 = r25.getCenterVertically()
                        r5 = r44
                        androidx.compose.ui.Modifier r0 = r5.align(r0, r3)
                        java.lang.String r3 = "TrailingViewTag"
                        androidx.compose.ui.Modifier r0 = androidx.compose.ui.platform.TestTagKt.testTag(r0, r3)
                        r3 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
                        r2.startReplaceableGroup(r3)
                        androidx.compose.ui.Alignment r3 = r25.getTopStart()
                        androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r4, r2, r4)
                        r5 = 1376089335(0x520574f7, float:1.43298249E11)
                        r2.startReplaceableGroup(r5)
                        androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                        java.lang.Object r5 = r2.consume(r5)
                        androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
                        androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
                        java.lang.Object r6 = r2.consume(r6)
                        androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
                        kotlin.jvm.functions.Function0 r7 = r26.getConstructor()
                        kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
                        androidx.compose.runtime.Applier r8 = r48.getApplier()
                        boolean r8 = r8 instanceof androidx.compose.runtime.Applier
                        if (r8 != 0) goto L_0x05b2
                        androidx.compose.runtime.ComposablesKt.invalidApplier()
                    L_0x05b2:
                        r48.startReusableNode()
                        boolean r8 = r48.getInserting()
                        if (r8 == 0) goto L_0x05bf
                        r2.createNode(r7)
                        goto L_0x05c2
                    L_0x05bf:
                        r48.useNode()
                    L_0x05c2:
                        r48.disableReusing()
                        androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m2536constructorimpl(r48)
                        kotlin.jvm.functions.Function2 r8 = r26.getSetMeasurePolicy()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r3, r8)
                        kotlin.jvm.functions.Function2 r3 = r26.getSetDensity()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r5, r3)
                        kotlin.jvm.functions.Function2 r3 = r26.getSetLayoutDirection()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r6, r3)
                        r48.enableReusing()
                        androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r48)
                        androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r3)
                        java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                        r0.invoke(r3, r2, r5)
                        r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                        r2.startReplaceableGroup(r0)
                        r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
                        r2.startReplaceableGroup(r0)
                        androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
                        java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
                        r1.invoke(r2, r0)
                        r48.endReplaceableGroup()
                        r48.endReplaceableGroup()
                        r48.endNode()
                        r48.endReplaceableGroup()
                        r48.endReplaceableGroup()
                        kotlin.Unit r0 = kotlin.Unit.INSTANCE
                        goto L_0x0548
                    L_0x0618:
                        r48.endReplaceableGroup()
                        r48.endReplaceableGroup()
                        r48.endNode()
                        r48.endReplaceableGroup()
                        r48.endReplaceableGroup()
                    L_0x0627:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_simple_card.DSSimpleCardKt$DSSimpleCard$2.AnonymousClass2.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), composer, 1572912, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
