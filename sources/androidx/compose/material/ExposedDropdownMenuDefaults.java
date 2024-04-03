package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalMaterialApi
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007¢\u0006\u0002\u0010\tJñ\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$Jñ\u0001\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010$\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuDefaults;", "", "()V", "TrailingIcon", "", "expanded", "", "onIconClick", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "outlinedTextFieldColors", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "focusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-DlUQjxs", "(JJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-DlUQjxs", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();

    private ExposedDropdownMenuDefaults() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void TrailingIcon(boolean r13, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r14, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r15, int r16, int r17) {
        /*
            r12 = this;
            r2 = r13
            r0 = 876077373(0x3437e13d, float:1.7125144E-7)
            r1 = r15
            androidx.compose.runtime.Composer r0 = r15.startRestartGroup(r0)
            r1 = r17 & 1
            if (r1 == 0) goto L_0x0010
            r1 = r16 | 6
            goto L_0x0022
        L_0x0010:
            r1 = r16 & 14
            if (r1 != 0) goto L_0x0020
            boolean r1 = r0.changed((boolean) r13)
            if (r1 == 0) goto L_0x001c
            r1 = 4
            goto L_0x001d
        L_0x001c:
            r1 = 2
        L_0x001d:
            r1 = r16 | r1
            goto L_0x0022
        L_0x0020:
            r1 = r16
        L_0x0022:
            r3 = r17 & 2
            if (r3 == 0) goto L_0x0029
            r1 = r1 | 48
            goto L_0x003b
        L_0x0029:
            r4 = r16 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x003b
            r4 = r14
            boolean r5 = r0.changed((java.lang.Object) r14)
            if (r5 == 0) goto L_0x0037
            r5 = 32
            goto L_0x0039
        L_0x0037:
            r5 = 16
        L_0x0039:
            r1 = r1 | r5
            goto L_0x003c
        L_0x003b:
            r4 = r14
        L_0x003c:
            r5 = r1 & 91
            r6 = 18
            if (r5 != r6) goto L_0x004e
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x0049
            goto L_0x004e
        L_0x0049:
            r0.skipToGroupEnd()
            r3 = r4
            goto L_0x0079
        L_0x004e:
            if (r3 == 0) goto L_0x0054
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1 r3 = androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1.INSTANCE
            r11 = r3
            goto L_0x0055
        L_0x0054:
            r11 = r4
        L_0x0055:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2 r4 = androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2.INSTANCE
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.semantics.SemanticsModifierKt.clearAndSetSemantics(r3, r4)
            r5 = 0
            r6 = 0
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$3 r3 = new androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$3
            r3.<init>(r13)
            r7 = 726122713(0x2b47c0d9, float:7.096663E-13)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r7, r8, r3)
            int r1 = r1 >> 3
            r1 = r1 & 14
            r9 = r1 | 24576(0x6000, float:3.4438E-41)
            r10 = 12
            r3 = r11
            r8 = r0
            androidx.compose.material.IconButtonKt.IconButton(r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x0079:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x0080
            goto L_0x008f
        L_0x0080:
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$4 r7 = new androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$4
            r0 = r7
            r1 = r12
            r2 = r13
            r4 = r16
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon(boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    @NotNull
    @Composable
    /* renamed from: outlinedTextFieldColors-DlUQjxs  reason: not valid java name */
    public final TextFieldColors m1251outlinedTextFieldColorsDlUQjxs(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, @Nullable Composer composer, int i11, int i12, int i13, int i14) {
        Composer composer2 = composer;
        int i15 = i14;
        composer2.startReplaceableGroup(1162641182);
        long r22 = (i15 & 1) != 0 ? Color.m2918copywmQWz5c$default(((Color) composer2.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl(), ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        long r72 = (i15 & 2) != 0 ? Color.m2918copywmQWz5c$default(r22, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j12;
        long r35 = (i15 & 4) != 0 ? Color.Companion.m2954getTransparent0d7_KjU() : j13;
        long r92 = (i15 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1179getPrimary0d7_KjU() : j14;
        long r13 = (i15 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1173getError0d7_KjU() : j15;
        long r15 = (i15 & 32) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1179getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j16;
        long r17 = (i15 & 64) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j17;
        long r19 = (i15 & 128) != 0 ? Color.m2918copywmQWz5c$default(r17, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j18;
        long r21 = (i15 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1173getError0d7_KjU() : j19;
        long r23 = (i15 & 512) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j21;
        long r25 = (i15 & 1024) != 0 ? Color.m2918copywmQWz5c$default(r23, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j22;
        long j35 = (i15 & 2048) != 0 ? r23 : j23;
        long r29 = (i15 & 4096) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j24;
        long r31 = (i15 & 8192) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1179getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j25;
        long r33 = (i15 & 16384) != 0 ? Color.m2918copywmQWz5c$default(r29, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j26;
        long r37 = (32768 & i15) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1173getError0d7_KjU() : j27;
        long r39 = (65536 & i15) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1179getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j28;
        long r41 = (131072 & i15) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j29;
        long r43 = (262144 & i15) != 0 ? Color.m2918copywmQWz5c$default(r41, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j31;
        long r45 = (524288 & i15) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1173getError0d7_KjU() : j32;
        long r47 = (1048576 & i15) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j33;
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(r22, r72, r92, r13, r15, r17, r21, r19, r23, r25, j35, r29, r31, r33, r37, r35, r39, r41, r43, r45, r47, (i15 & 2097152) != 0 ? Color.m2918copywmQWz5c$default(r47, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j34, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }

    @NotNull
    @Composable
    /* renamed from: textFieldColors-DlUQjxs  reason: not valid java name */
    public final TextFieldColors m1252textFieldColorsDlUQjxs(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, @Nullable Composer composer, int i11, int i12, int i13, int i14) {
        Composer composer2 = composer;
        int i15 = i14;
        composer2.startReplaceableGroup(1208167904);
        long r22 = (i15 & 1) != 0 ? Color.m2918copywmQWz5c$default(((Color) composer2.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl(), ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        long r72 = (i15 & 2) != 0 ? Color.m2918copywmQWz5c$default(r22, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j12;
        long r35 = (i15 & 4) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j13;
        long r92 = (i15 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1179getPrimary0d7_KjU() : j14;
        long r13 = (i15 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1173getError0d7_KjU() : j15;
        long r15 = (i15 & 32) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1179getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j16;
        long r17 = (i15 & 64) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j17;
        long r19 = (i15 & 128) != 0 ? Color.m2918copywmQWz5c$default(r17, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j18;
        long r21 = (i15 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1173getError0d7_KjU() : j19;
        long r23 = (i15 & 512) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j21;
        long r25 = (i15 & 1024) != 0 ? Color.m2918copywmQWz5c$default(r23, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j22;
        long j35 = (i15 & 2048) != 0 ? r23 : j23;
        long r29 = (i15 & 4096) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j24;
        long r31 = (i15 & 8192) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1179getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j25;
        long r33 = (i15 & 16384) != 0 ? Color.m2918copywmQWz5c$default(r29, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j26;
        long r37 = (32768 & i15) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1173getError0d7_KjU() : j27;
        long r39 = (65536 & i15) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1179getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j28;
        long r41 = (131072 & i15) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j29;
        long r43 = (262144 & i15) != 0 ? Color.m2918copywmQWz5c$default(r41, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j31;
        long r45 = (524288 & i15) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1173getError0d7_KjU() : j32;
        long r47 = (1048576 & i15) != 0 ? Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j33;
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(r22, r72, r92, r13, r15, r17, r21, r19, r23, r25, j35, r29, r31, r33, r37, r35, r39, r41, r43, r45, r47, (i15 & 2097152) != 0 ? Color.m2918copywmQWz5c$default(r47, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j34, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }
}
