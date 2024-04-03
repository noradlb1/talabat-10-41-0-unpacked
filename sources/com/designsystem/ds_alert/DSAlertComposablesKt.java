package com.designsystem.ds_alert;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.designsystem.ds_icon_button.DSIconButtonKt;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_icon_button.DSIconButtonSize;
import com.designsystem.ds_theme.DSTheme;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0003¢\u0006\u0002\u0010\u000b\u001a7\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0014\u001a\u0019\u0010\u0015\u001a\u00020\u00012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001aU\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0002\u0010\u001c\u001a\u0011\u0010\u001d\u001a\u00020\u0005*\u00020\u001bH\u0003¢\u0006\u0002\u0010\u001e¨\u0006\u001f"}, d2 = {"AlertBackground", "", "modifier", "Landroidx/compose/ui/Modifier;", "alertTypeModel", "Lcom/designsystem/ds_alert/AlertTypeModel;", "withLeadingIcon", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lcom/designsystem/ds_alert/AlertTypeModel;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "AlertContent", "descriptor", "", "title", "actionButton", "Lcom/designsystem/ds_alert/DSAlertActionButtonModel;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lcom/designsystem/ds_alert/DSAlertActionButtonModel;Landroidx/compose/runtime/Composer;II)V", "AlertIcon", "(Lcom/designsystem/ds_alert/AlertTypeModel;Landroidx/compose/runtime/Composer;I)V", "AlertIconButton", "iconButton", "Lcom/designsystem/ds_icon_button/DSIconButtonModel;", "(Lcom/designsystem/ds_icon_button/DSIconButtonModel;Landroidx/compose/runtime/Composer;II)V", "AlertSurface", "alertType", "Lcom/designsystem/ds_alert/DSAlertType;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lcom/designsystem/ds_alert/DSAlertType;Ljava/lang/String;Lcom/designsystem/ds_alert/DSAlertActionButtonModel;Lcom/designsystem/ds_icon_button/DSIconButtonModel;Ljava/lang/Boolean;Landroidx/compose/runtime/Composer;II)V", "toModel", "(Lcom/designsystem/ds_alert/DSAlertType;Landroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_alert/AlertTypeModel;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSAlertComposablesKt {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DSAlertType.values().length];
            iArr[DSAlertType.ERROR.ordinal()] = 1;
            iArr[DSAlertType.WARNING.ordinal()] = 2;
            iArr[DSAlertType.INFO.ordinal()] = 3;
            iArr[DSAlertType.SUCCESS.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AlertBackground(androidx.compose.ui.Modifier r18, com.designsystem.ds_alert.AlertTypeModel r19, java.lang.Boolean r20, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r4 = r21
            r5 = r23
            r0 = -1382359137(0xffffffffad9adf9f, float:-1.760708E-11)
            r1 = r22
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r24 & 1
            if (r1 == 0) goto L_0x0017
            r1 = r5 | 6
            r2 = r1
            r1 = r18
            goto L_0x002b
        L_0x0017:
            r1 = r5 & 14
            if (r1 != 0) goto L_0x0028
            r1 = r18
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0025
            r2 = 4
            goto L_0x0026
        L_0x0025:
            r2 = 2
        L_0x0026:
            r2 = r2 | r5
            goto L_0x002b
        L_0x0028:
            r1 = r18
            r2 = r5
        L_0x002b:
            r3 = r24 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r3 = r5 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0045
            r3 = r19
            boolean r6 = r0.changed((java.lang.Object) r3)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r2 = r2 | r6
            goto L_0x0047
        L_0x0045:
            r3 = r19
        L_0x0047:
            r6 = r24 & 4
            if (r6 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r5 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0061
            r7 = r20
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r8
            goto L_0x0063
        L_0x0061:
            r7 = r20
        L_0x0063:
            r8 = r24 & 8
            if (r8 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x006a:
            r8 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007a
            boolean r8 = r0.changed((java.lang.Object) r4)
            if (r8 == 0) goto L_0x0077
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r2 = r2 | r8
        L_0x007a:
            r8 = r2 & 5851(0x16db, float:8.199E-42)
            r8 = r8 ^ 1170(0x492, float:1.64E-42)
            if (r8 != 0) goto L_0x008c
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x0087
            goto L_0x008c
        L_0x0087:
            r0.skipToGroupEnd()
            goto L_0x00f7
        L_0x008c:
            if (r6 == 0) goto L_0x0092
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r15 = r6
            goto L_0x0093
        L_0x0092:
            r15 = r7
        L_0x0093:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r6)
            r7 = 0
            if (r6 == 0) goto L_0x00b0
            r6 = -1382358928(0xffffffffad9ae070, float:-1.7607443E-11)
            r0.startReplaceableGroup(r6)
            com.designsystem.ds_theme.DSTheme r6 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r6 = r6.getDimens(r0, r7)
            float r6 = r6.m8849getDsZeroD9Ej5fM()
            r0.endReplaceableGroup()
            goto L_0x00c3
        L_0x00b0:
            r6 = -1382358885(0xffffffffad9ae09b, float:-1.7607518E-11)
            r0.startReplaceableGroup(r6)
            com.designsystem.ds_theme.DSTheme r6 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r6 = r6.getDimens(r0, r7)
            float r6 = r6.m8844getDsXsD9Ej5fM()
            r0.endReplaceableGroup()
        L_0x00c3:
            long r8 = r19.m8246getBackgroundColor0d7_KjU()
            com.designsystem.ds_theme.DSTheme r10 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r7 = r10.getDimens(r0, r7)
            float r7 = r7.m8846getDsXxsD9Ej5fM()
            androidx.compose.foundation.shape.RoundedCornerShape r7 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(r7)
            r10 = 0
            r12 = 0
            com.designsystem.ds_alert.DSAlertComposablesKt$AlertBackground$1 r14 = new com.designsystem.ds_alert.DSAlertComposablesKt$AlertBackground$1
            r14.<init>(r6, r4, r2)
            r6 = -819890853(0xffffffffcf21755b, float:-2.70882278E9)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r14 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r6, r13, r14)
            r6 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 & 14
            r16 = r2 | r6
            r17 = 56
            r6 = r18
            r2 = 0
            r13 = r2
            r2 = r15
            r15 = r0
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r6, r7, r8, r10, r12, r13, r14, r15, r16, r17)
            r7 = r2
        L_0x00f7:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x00fe
            goto L_0x0112
        L_0x00fe:
            com.designsystem.ds_alert.DSAlertComposablesKt$AlertBackground$2 r9 = new com.designsystem.ds_alert.DSAlertComposablesKt$AlertBackground$2
            r0 = r9
            r1 = r18
            r2 = r19
            r3 = r7
            r4 = r21
            r5 = r23
            r6 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r8.updateScope(r9)
        L_0x0112:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_alert.DSAlertComposablesKt.AlertBackground(androidx.compose.ui.Modifier, com.designsystem.ds_alert.AlertTypeModel, java.lang.Boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AlertContent(androidx.compose.ui.Modifier r31, java.lang.String r32, java.lang.String r33, com.designsystem.ds_alert.DSAlertActionButtonModel r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r5 = r36
            r0 = 1351048770(0x50875e42, float:1.81688115E10)
            r1 = r35
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r37 & 1
            r2 = 2
            if (r1 == 0) goto L_0x0016
            r3 = r5 | 6
            r4 = r3
            r3 = r31
            goto L_0x002a
        L_0x0016:
            r3 = r5 & 14
            if (r3 != 0) goto L_0x0027
            r3 = r31
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0024
            r4 = 4
            goto L_0x0025
        L_0x0024:
            r4 = r2
        L_0x0025:
            r4 = r4 | r5
            goto L_0x002a
        L_0x0027:
            r3 = r31
            r4 = r5
        L_0x002a:
            r6 = r37 & 2
            if (r6 == 0) goto L_0x0031
            r4 = r4 | 48
            goto L_0x0044
        L_0x0031:
            r6 = r5 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0044
            r6 = r32
            boolean r8 = r0.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x0040
            r8 = 32
            goto L_0x0042
        L_0x0040:
            r8 = 16
        L_0x0042:
            r4 = r4 | r8
            goto L_0x0046
        L_0x0044:
            r6 = r32
        L_0x0046:
            r8 = r37 & 4
            if (r8 == 0) goto L_0x004d
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r9 = r5 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0060
            r9 = r33
            boolean r10 = r0.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x005c
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r4 = r4 | r10
            goto L_0x0062
        L_0x0060:
            r9 = r33
        L_0x0062:
            r10 = r37 & 8
            if (r10 == 0) goto L_0x0069
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r11 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x007c
            r11 = r34
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0078
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r4 = r4 | r12
            goto L_0x007e
        L_0x007c:
            r11 = r34
        L_0x007e:
            r12 = r4 & 5851(0x16db, float:8.199E-42)
            r12 = r12 ^ 1170(0x492, float:1.64E-42)
            if (r12 != 0) goto L_0x0093
            boolean r12 = r0.getSkipping()
            if (r12 != 0) goto L_0x008b
            goto L_0x0093
        L_0x008b:
            r0.skipToGroupEnd()
            r1 = r3
            r3 = r9
            r4 = r11
            goto L_0x02c4
        L_0x0093:
            if (r1 == 0) goto L_0x0098
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0099
        L_0x0098:
            r1 = r3
        L_0x0099:
            r3 = 0
            if (r8 == 0) goto L_0x009f
            r30 = r3
            goto L_0x00a1
        L_0x009f:
            r30 = r9
        L_0x00a1:
            if (r10 == 0) goto L_0x00a4
            goto L_0x00a5
        L_0x00a4:
            r3 = r11
        L_0x00a5:
            r8 = r4 & 14
            r9 = -1113031299(0xffffffffbda87d7d, float:-0.0822706)
            r0.startReplaceableGroup(r9)
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r9 = r9.getTop()
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r10 = r10.getStart()
            int r11 = r8 >> 3
            r12 = r11 & 14
            r11 = r11 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r9, r10, r0, r11)
            int r10 = r8 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r11 = 1376089335(0x520574f7, float:1.43298249E11)
            r0.startReplaceableGroup(r11)
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.ui.unit.Density r11 = (androidx.compose.ui.unit.Density) r11
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r15 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            int r10 = r10 << 9
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            androidx.compose.runtime.Applier r7 = r0.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x00fb
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00fb:
            r0.startReusableNode()
            boolean r7 = r0.getInserting()
            if (r7 == 0) goto L_0x0108
            r0.createNode(r14)
            goto L_0x010b
        L_0x0108:
            r0.useNode()
        L_0x010b:
            r0.disableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r14 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r9, r14)
            kotlin.jvm.functions.Function2 r9 = r13.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r11, r9)
            kotlin.jvm.functions.Function2 r9 = r13.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r12, r9)
            r0.enableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r7)
            int r9 = r10 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r15.invoke(r7, r0, r9)
            r7 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r7)
            int r7 = r10 >> 9
            r7 = r7 & 14
            r9 = 276693241(0x107e00f9, float:5.0093417E-29)
            r0.startReplaceableGroup(r9)
            r7 = r7 & 11
            r2 = r2 ^ r7
            if (r2 != 0) goto L_0x015e
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x0159
            goto L_0x015e
        L_0x0159:
            r0.skipToGroupEnd()
            goto L_0x02b2
        L_0x015e:
            androidx.compose.foundation.layout.ColumnScopeInstance r2 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            int r2 = r8 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 6
            r2 = r2 & 81
            r7 = 16
            r2 = r2 ^ r7
            if (r2 != 0) goto L_0x0179
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x0174
            goto L_0x0179
        L_0x0174:
            r0.skipToGroupEnd()
            goto L_0x02b2
        L_0x0179:
            r2 = 0
            if (r30 != 0) goto L_0x0183
            r7 = -1667588481(0xffffffff9c9a9e7f, float:-1.0231835E-21)
            r0.startReplaceableGroup(r7)
            goto L_0x01d7
        L_0x0183:
            r7 = -1300719166(0xffffffffb27899c2, float:-1.447046E-8)
            r0.startReplaceableGroup(r7)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            r9 = 0
            r10 = 0
            r11 = 0
            com.designsystem.ds_theme.DSTheme r15 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r7 = r15.getDimens(r0, r2)
            float r12 = r7.m8848getDsXxxsD9Ej5fM()
            r13 = 7
            r14 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r8, r9, r10, r11, r12, r13, r14)
            com.designsystem.ds_theme.DSTypography r8 = r15.getTypography(r0, r2)
            androidx.compose.ui.text.TextStyle r25 = r8.getDsSubheading1()
            com.designsystem.ds_theme.DSColors r8 = r15.getColors(r0, r2)
            long r8 = r8.m8760getDsNeutral1000d7_KjU()
            androidx.compose.ui.text.style.TextOverflow$Companion r10 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r21 = r10.m5403getEllipsisgIe3tQ8()
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r22 = 0
            r23 = 2
            r24 = 0
            int r26 = r4 >> 6
            r27 = r26 & 14
            r28 = 3136(0xc40, float:4.394E-42)
            r29 = 22520(0x57f8, float:3.1557E-41)
            r6 = r30
            r26 = r0
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r6, r7, r8, r10, r12, r13, r14, r15, r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L_0x01d7:
            r0.endReplaceableGroup()
            com.designsystem.ds_theme.DSTheme r6 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSTypography r7 = r6.getTypography(r0, r2)
            androidx.compose.ui.text.TextStyle r25 = r7.getDsBody1Compact()
            com.designsystem.ds_theme.DSColors r7 = r6.getColors(r0, r2)
            long r8 = r7.m8760getDsNeutral1000d7_KjU()
            r7 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            int r4 = r4 >> 3
            r27 = r4 & 14
            r28 = 64
            r29 = 32762(0x7ffa, float:4.591E-41)
            r4 = r6
            r6 = r32
            r26 = r0
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r6, r7, r8, r10, r12, r13, r14, r15, r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            if (r3 != 0) goto L_0x021f
            r2 = -1667572082(0xffffffff9c9ade8e, float:-1.0248394E-21)
            r0.startReplaceableGroup(r2)
        L_0x021a:
            r0.endReplaceableGroup()
            goto L_0x02b2
        L_0x021f:
            r6 = -1300718637(0xffffffffb2789bd3, float:-1.447093E-8)
            r0.startReplaceableGroup(r6)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            r8 = 0
            com.designsystem.ds_theme.DSDimens r6 = r4.getDimens(r0, r2)
            float r9 = r6.m8846getDsXxsD9Ej5fM()
            r10 = 0
            r11 = 0
            r12 = 13
            r13 = 0
            androidx.compose.ui.Modifier r14 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r7, r8, r9, r10, r11, r12, r13)
            androidx.compose.foundation.interaction.MutableInteractionSource r15 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r6 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r6)
            boolean r6 = r0.changed((java.lang.Object) r3)
            java.lang.Object r7 = r0.rememberedValue()
            if (r6 != 0) goto L_0x025d
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x0265
        L_0x025d:
            com.designsystem.ds_alert.DSAlertComposablesKt$AlertContent$1$2$1$1 r7 = new com.designsystem.ds_alert.DSAlertComposablesKt$AlertContent$1$2$1$1
            r7.<init>(r3)
            r0.updateRememberedValue(r7)
        L_0x0265:
            r0.endReplaceableGroup()
            r20 = r7
            kotlin.jvm.functions.Function0 r20 = (kotlin.jvm.functions.Function0) r20
            r21 = 28
            r22 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r14, r15, r16, r17, r18, r19, r20, r21, r22)
            java.lang.String r7 = "AlertActionButtonTestTag"
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.platform.TestTagKt.testTag(r6, r7)
            java.lang.String r6 = r3.getText()
            com.designsystem.ds_theme.DSTypography r8 = r4.getTypography(r0, r2)
            androidx.compose.ui.text.TextStyle r25 = r8.getDsLink()
            com.designsystem.ds_theme.DSColors r2 = r4.getColors(r0, r2)
            long r8 = r2.m8771getDsNeutral700d7_KjU()
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r27 = 0
            r28 = 64
            r29 = 32760(0x7ff8, float:4.5907E-41)
            r26 = r0
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r6, r7, r8, r10, r12, r13, r14, r15, r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x021a
        L_0x02b2:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r4 = r3
            r3 = r30
        L_0x02c4:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x02cb
            goto L_0x02da
        L_0x02cb:
            com.designsystem.ds_alert.DSAlertComposablesKt$AlertContent$2 r8 = new com.designsystem.ds_alert.DSAlertComposablesKt$AlertContent$2
            r0 = r8
            r2 = r32
            r5 = r36
            r6 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.updateScope(r8)
        L_0x02da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_alert.DSAlertComposablesKt.AlertContent(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, com.designsystem.ds_alert.DSAlertActionButtonModel, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void AlertIcon(AlertTypeModel alertTypeModel, Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(78903019);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) alertTypeModel)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            Painter painterResource = PainterResources_androidKt.painterResource(alertTypeModel.getIcon(), startRestartGroup, 0);
            long r42 = alertTypeModel.m8247getIconColor0d7_KjU();
            Modifier.Companion companion = Modifier.Companion;
            DSTheme dSTheme = DSTheme.INSTANCE;
            IconKt.m1278Iconww6aTOc(painterResource, (String) null, TestTagKt.testTag(SizeKt.m558size3ABfNKs(PaddingKt.m490paddingqDBjuR0$default(companion, 0.0f, 0.0f, dSTheme.getDimens(startRestartGroup, 0).m8844getDsXsD9Ej5fM(), 0.0f, 11, (Object) null), dSTheme.getDimens(startRestartGroup, 0).m8840getDsLD9Ej5fM()), Alert.AlertIconTestTag), r42, startRestartGroup, 56, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSAlertComposablesKt$AlertIcon$1(alertTypeModel, i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void AlertIconButton(DSIconButtonModel dSIconButtonModel, Composer composer, int i11, int i12) {
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(862281251);
        int i15 = i12 & 1;
        if (i15 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) dSIconButtonModel)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i13 = i14 | i11;
        } else {
            i13 = i11;
        }
        if ((2 ^ (i13 & 11)) != 0 || !startRestartGroup.getSkipping()) {
            if (i15 != 0) {
                dSIconButtonModel = null;
            }
            if (dSIconButtonModel == null) {
                startRestartGroup.startReplaceableGroup(960917579);
            } else {
                startRestartGroup.startReplaceableGroup(862281334);
                int icon = dSIconButtonModel.getIcon();
                startRestartGroup.startReplaceableGroup(-3686930);
                boolean changed = startRestartGroup.changed((Object) dSIconButtonModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DSAlertComposablesKt$AlertIconButton$1$1$1(dSIconButtonModel);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                DSIconButtonKt.m8355DSIconButton_trzpw((Modifier) null, icon, (Function0) rememberedValue, (Color) null, false, DSIconButtonSize.SMALL, startRestartGroup, 196608, 25);
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSAlertComposablesKt$AlertIconButton$2(dSIconButtonModel, i11, i12));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AlertSurface(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull com.designsystem.ds_alert.DSAlertType r21, @org.jetbrains.annotations.Nullable java.lang.String r22, @org.jetbrains.annotations.Nullable com.designsystem.ds_alert.DSAlertActionButtonModel r23, @org.jetbrains.annotations.Nullable com.designsystem.ds_icon_button.DSIconButtonModel r24, @org.jetbrains.annotations.Nullable java.lang.Boolean r25, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r9 = r19
            r10 = r20
            r11 = r21
            r12 = r27
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "alertType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 302753451(0x120ba6ab, float:4.40661E-28)
            r1 = r26
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            r0 = r28 & 1
            if (r0 == 0) goto L_0x0027
            r0 = r12 | 6
            goto L_0x0037
        L_0x0027:
            r0 = r12 & 14
            if (r0 != 0) goto L_0x0036
            boolean r0 = r13.changed((java.lang.Object) r9)
            if (r0 == 0) goto L_0x0033
            r0 = 4
            goto L_0x0034
        L_0x0033:
            r0 = 2
        L_0x0034:
            r0 = r0 | r12
            goto L_0x0037
        L_0x0036:
            r0 = r12
        L_0x0037:
            r1 = r28 & 2
            if (r1 == 0) goto L_0x003e
            r0 = r0 | 48
            goto L_0x004e
        L_0x003e:
            r1 = r12 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x004e
            boolean r1 = r13.changed((java.lang.Object) r10)
            if (r1 == 0) goto L_0x004b
            r1 = 32
            goto L_0x004d
        L_0x004b:
            r1 = 16
        L_0x004d:
            r0 = r0 | r1
        L_0x004e:
            r1 = r28 & 4
            if (r1 == 0) goto L_0x0055
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0055:
            r1 = r12 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x0065
            boolean r1 = r13.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x0062
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r1 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r0 = r0 | r1
        L_0x0065:
            r1 = r28 & 8
            if (r1 == 0) goto L_0x006c
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r2 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x007f
            r2 = r22
            boolean r3 = r13.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x007b
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r0 = r0 | r3
            goto L_0x0081
        L_0x007f:
            r2 = r22
        L_0x0081:
            r3 = r28 & 16
            if (r3 == 0) goto L_0x0088
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x0088:
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r12
            if (r4 != 0) goto L_0x009d
            r4 = r23
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0099
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r5 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r0 = r0 | r5
            goto L_0x009f
        L_0x009d:
            r4 = r23
        L_0x009f:
            r5 = r28 & 32
            if (r5 == 0) goto L_0x00a7
            r6 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r6
            goto L_0x00bb
        L_0x00a7:
            r6 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r12
            if (r6 != 0) goto L_0x00bb
            r6 = r24
            boolean r7 = r13.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x00b7
            r7 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r7 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r0 = r0 | r7
            goto L_0x00bd
        L_0x00bb:
            r6 = r24
        L_0x00bd:
            r7 = r28 & 64
            if (r7 == 0) goto L_0x00c5
            r8 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r8
            goto L_0x00d9
        L_0x00c5:
            r8 = 3670016(0x380000, float:5.142788E-39)
            r8 = r8 & r12
            if (r8 != 0) goto L_0x00d9
            r8 = r25
            boolean r14 = r13.changed((java.lang.Object) r8)
            if (r14 == 0) goto L_0x00d5
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r0 = r0 | r14
            goto L_0x00db
        L_0x00d9:
            r8 = r25
        L_0x00db:
            r14 = r0
            r0 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r0 & r14
            r15 = 599186(0x92492, float:8.39638E-40)
            r0 = r0 ^ r15
            if (r0 != 0) goto L_0x00f4
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x00ed
            goto L_0x00f4
        L_0x00ed:
            r13.skipToGroupEnd()
            r5 = r4
            r7 = r8
            r4 = r2
            goto L_0x013f
        L_0x00f4:
            r0 = 0
            if (r1 == 0) goto L_0x00f9
            r15 = r0
            goto L_0x00fa
        L_0x00f9:
            r15 = r2
        L_0x00fa:
            if (r3 == 0) goto L_0x00ff
            r16 = r0
            goto L_0x0101
        L_0x00ff:
            r16 = r4
        L_0x0101:
            if (r5 == 0) goto L_0x0106
            r17 = r0
            goto L_0x0108
        L_0x0106:
            r17 = r6
        L_0x0108:
            if (r7 == 0) goto L_0x010f
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r18 = r0
            goto L_0x0111
        L_0x010f:
            r18 = r8
        L_0x0111:
            int r0 = r14 >> 6
            r0 = r0 & 14
            com.designsystem.ds_alert.AlertTypeModel r2 = toModel(r11, r13, r0)
            com.designsystem.ds_alert.DSAlertComposablesKt$AlertSurface$1 r8 = new com.designsystem.ds_alert.DSAlertComposablesKt$AlertSurface$1
            r0 = r8
            r1 = r19
            r3 = r18
            r4 = r14
            r5 = r20
            r6 = r15
            r7 = r16
            r14 = r8
            r8 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = -819896277(0xffffffffcf21602b, float:-2.70743424E9)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r1, r14)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r13, r1)
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
        L_0x013f:
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x0146
            goto L_0x0159
        L_0x0146:
            com.designsystem.ds_alert.DSAlertComposablesKt$AlertSurface$2 r14 = new com.designsystem.ds_alert.DSAlertComposablesKt$AlertSurface$2
            r0 = r14
            r1 = r19
            r2 = r20
            r3 = r21
            r8 = r27
            r9 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r13.updateScope(r14)
        L_0x0159:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_alert.DSAlertComposablesKt.AlertSurface(androidx.compose.ui.Modifier, java.lang.String, com.designsystem.ds_alert.DSAlertType, java.lang.String, com.designsystem.ds_alert.DSAlertActionButtonModel, com.designsystem.ds_icon_button.DSIconButtonModel, java.lang.Boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    @Stable
    @Composable
    private static final AlertTypeModel toModel(DSAlertType dSAlertType, Composer composer, int i11) {
        AlertTypeModel alertTypeModel;
        composer.startReplaceableGroup(156265336);
        int i12 = WhenMappings.$EnumSwitchMapping$0[dSAlertType.ordinal()];
        if (i12 == 1) {
            composer.startReplaceableGroup(156265434);
            int i13 = R.drawable.ds_error;
            DSTheme dSTheme = DSTheme.INSTANCE;
            alertTypeModel = new AlertTypeModel(i13, dSTheme.getColors(composer, 0).m8748getDsDanger1000d7_KjU(), dSTheme.getColors(composer, 0).m8747getDsDanger100d7_KjU(), (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else if (i12 == 2) {
            composer.startReplaceableGroup(156265602);
            int i14 = R.drawable.ds_alert;
            DSTheme dSTheme2 = DSTheme.INSTANCE;
            alertTypeModel = new AlertTypeModel(i14, dSTheme2.getColors(composer, 0).m8736getDsAlert1000d7_KjU(), dSTheme2.getColors(composer, 0).m8735getDsAlert100d7_KjU(), (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else if (i12 == 3) {
            composer.startReplaceableGroup(156265765);
            int i15 = R.drawable.ds_tooltip;
            DSTheme dSTheme3 = DSTheme.INSTANCE;
            alertTypeModel = new AlertTypeModel(i15, dSTheme3.getColors(composer, 0).m8810getDsSecondary1000d7_KjU(), dSTheme3.getColors(composer, 0).m8809getDsSecondary100d7_KjU(), (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else if (i12 == 4) {
            composer.startReplaceableGroup(156265941);
            int i16 = R.drawable.ds_check_circle;
            DSTheme dSTheme4 = DSTheme.INSTANCE;
            alertTypeModel = new AlertTypeModel(i16, dSTheme4.getColors(composer, 0).m8814getDsSuccess1000d7_KjU(), dSTheme4.getColors(composer, 0).m8813getDsSuccess100d7_KjU(), (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(156259871);
            composer.endReplaceableGroup();
            throw new NoWhenBranchMatchedException();
        }
        composer.endReplaceableGroup();
        return alertTypeModel;
    }
}
