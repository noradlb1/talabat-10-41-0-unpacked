package com.designsystem.ds_input_field;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.ds_bottom_sheet_v2.DSFragmentManagerExtensionsKt;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_input_field.country.DSCountryModel;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.designsystem.ds_theme.DSTheme;
import com.designsystem.marshmallow.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aÁ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001e\b\u0002\u0010\u0007\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\u001e\b\u0002\u0010\n\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u001b\u001a\"\u0010\u001c\u001a\u0004\u0018\u00010\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0002\u001ab\u0010\u001f\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010#2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010%2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001eH\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"PhoneNumberInputField", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "hint", "onTextChange", "Lkotlin/Function2;", "Lcom/designsystem/ds_input_field/country/DSCountryModel;", "onKeyboardReturnButtonTap", "defaultCountryCode", "isEnabled", "", "outerState", "Lcom/designsystem/ds_input_field/OuterState;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "prefixSearchHint", "prefixSearchEmptyStateTitle", "prefixSearchEmptyStateDetails", "PhoneNumberInputField-4-mkn5s", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Ljava/lang/String;ZLcom/designsystem/ds_input_field/OuterState;Landroidx/compose/ui/text/input/ImeAction;Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;III)V", "PhonePrefix", "prefix", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "getDefaultCountry", "countries", "", "showCountryPicker", "context", "Landroid/content/Context;", "onCountrySelected", "Lkotlin/Function1;", "onCallbackDismiss", "Lkotlin/Function0;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class PhoneFieldComposablesKt {
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0135  */
    @androidx.compose.runtime.Composable
    /* renamed from: PhoneNumberInputField-4-mkn5s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8448PhoneNumberInputField4mkn5s(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r39, @org.jetbrains.annotations.Nullable java.lang.String r40, @org.jetbrains.annotations.Nullable java.lang.String r41, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super com.designsystem.ds_input_field.country.DSCountryModel, ? super java.lang.String, kotlin.Unit> r42, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super com.designsystem.ds_input_field.country.DSCountryModel, ? super java.lang.String, kotlin.Unit> r43, @org.jetbrains.annotations.Nullable java.lang.String r44, boolean r45, @org.jetbrains.annotations.NotNull com.designsystem.ds_input_field.OuterState r46, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.ImeAction r47, @org.jetbrains.annotations.Nullable androidx.fragment.app.FragmentManager r48, @org.jetbrains.annotations.NotNull java.lang.String r49, @org.jetbrains.annotations.NotNull java.lang.String r50, @org.jetbrains.annotations.NotNull java.lang.String r51, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r52, int r53, int r54, int r55) {
        /*
            r15 = r39
            r14 = r46
            r13 = r49
            r12 = r50
            r10 = r51
            r9 = r53
            r8 = r54
            r7 = r55
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "outerState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "prefixSearchHint"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "prefixSearchEmptyStateTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "prefixSearchEmptyStateDetails"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 836548670(0x31dcb83e, float:6.4237886E-9)
            r1 = r52
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            r0 = r7 & 1
            if (r0 == 0) goto L_0x0039
            r0 = r9 | 6
            goto L_0x0049
        L_0x0039:
            r0 = r9 & 14
            if (r0 != 0) goto L_0x0048
            boolean r0 = r6.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0045
            r0 = 4
            goto L_0x0046
        L_0x0045:
            r0 = 2
        L_0x0046:
            r0 = r0 | r9
            goto L_0x0049
        L_0x0048:
            r0 = r9
        L_0x0049:
            r3 = r7 & 2
            if (r3 == 0) goto L_0x0050
            r0 = r0 | 48
            goto L_0x0064
        L_0x0050:
            r11 = r9 & 112(0x70, float:1.57E-43)
            if (r11 != 0) goto L_0x0064
            r11 = r40
            boolean r16 = r6.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x005f
            r16 = 32
            goto L_0x0061
        L_0x005f:
            r16 = 16
        L_0x0061:
            r0 = r0 | r16
            goto L_0x0066
        L_0x0064:
            r11 = r40
        L_0x0066:
            r16 = r7 & 4
            r17 = 256(0x100, float:3.59E-43)
            r18 = 128(0x80, float:1.794E-43)
            if (r16 == 0) goto L_0x0071
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0085
        L_0x0071:
            r1 = r9 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x0085
            r1 = r41
            boolean r19 = r6.changed((java.lang.Object) r1)
            if (r19 == 0) goto L_0x0080
            r19 = r17
            goto L_0x0082
        L_0x0080:
            r19 = r18
        L_0x0082:
            r0 = r0 | r19
            goto L_0x0087
        L_0x0085:
            r1 = r41
        L_0x0087:
            r19 = r7 & 8
            if (r19 == 0) goto L_0x008e
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x00a2
        L_0x008e:
            r4 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x00a2
            r4 = r42
            boolean r21 = r6.changed((java.lang.Object) r4)
            if (r21 == 0) goto L_0x009d
            r21 = 2048(0x800, float:2.87E-42)
            goto L_0x009f
        L_0x009d:
            r21 = 1024(0x400, float:1.435E-42)
        L_0x009f:
            r0 = r0 | r21
            goto L_0x00a4
        L_0x00a2:
            r4 = r42
        L_0x00a4:
            r21 = r7 & 16
            if (r21 == 0) goto L_0x00ad
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r5 = r43
            goto L_0x00c3
        L_0x00ad:
            r22 = 57344(0xe000, float:8.0356E-41)
            r22 = r9 & r22
            r5 = r43
            if (r22 != 0) goto L_0x00c3
            boolean r23 = r6.changed((java.lang.Object) r5)
            if (r23 == 0) goto L_0x00bf
            r23 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00c1
        L_0x00bf:
            r23 = 8192(0x2000, float:1.14794E-41)
        L_0x00c1:
            r0 = r0 | r23
        L_0x00c3:
            r23 = r7 & 32
            if (r23 == 0) goto L_0x00ce
            r24 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r24
            r2 = r44
            goto L_0x00e3
        L_0x00ce:
            r24 = 458752(0x70000, float:6.42848E-40)
            r24 = r9 & r24
            r2 = r44
            if (r24 != 0) goto L_0x00e3
            boolean r25 = r6.changed((java.lang.Object) r2)
            if (r25 == 0) goto L_0x00df
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00e1
        L_0x00df:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00e1:
            r0 = r0 | r25
        L_0x00e3:
            r25 = r7 & 64
            if (r25 == 0) goto L_0x00ee
            r25 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r25
            r15 = r45
            goto L_0x0103
        L_0x00ee:
            r25 = 3670016(0x380000, float:5.142788E-39)
            r25 = r9 & r25
            r15 = r45
            if (r25 != 0) goto L_0x0103
            boolean r25 = r6.changed((boolean) r15)
            if (r25 == 0) goto L_0x00ff
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0101
        L_0x00ff:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x0101:
            r0 = r0 | r25
        L_0x0103:
            r1 = r7 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x010b
            r1 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x0109:
            r0 = r0 | r1
            goto L_0x011c
        L_0x010b:
            r1 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r9
            if (r1 != 0) goto L_0x011c
            boolean r1 = r6.changed((java.lang.Object) r14)
            if (r1 == 0) goto L_0x0119
            r1 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0109
        L_0x0119:
            r1 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x0109
        L_0x011c:
            r1 = r7 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0124
            r25 = 33554432(0x2000000, float:9.403955E-38)
            r0 = r0 | r25
        L_0x0124:
            r2 = r7 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x012c
            r25 = 268435456(0x10000000, float:2.5243549E-29)
            r0 = r0 | r25
        L_0x012c:
            r25 = r0
            r0 = r7 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0135
            r0 = r8 | 6
            goto L_0x0145
        L_0x0135:
            r0 = r8 & 14
            if (r0 != 0) goto L_0x0144
            boolean r0 = r6.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x0141
            r0 = 4
            goto L_0x0142
        L_0x0141:
            r0 = 2
        L_0x0142:
            r0 = r0 | r8
            goto L_0x0145
        L_0x0144:
            r0 = r8
        L_0x0145:
            r4 = r7 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x014c
            r0 = r0 | 48
            goto L_0x015c
        L_0x014c:
            r4 = r8 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x015c
            boolean r4 = r6.changed((java.lang.Object) r12)
            if (r4 == 0) goto L_0x0159
            r4 = 32
            goto L_0x015b
        L_0x0159:
            r4 = 16
        L_0x015b:
            r0 = r0 | r4
        L_0x015c:
            r4 = r7 & 4096(0x1000, float:5.74E-42)
            if (r4 == 0) goto L_0x0163
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0172
        L_0x0163:
            r4 = r8 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0172
            boolean r4 = r6.changed((java.lang.Object) r10)
            if (r4 == 0) goto L_0x016e
            goto L_0x0170
        L_0x016e:
            r17 = r18
        L_0x0170:
            r0 = r0 | r17
        L_0x0172:
            int r4 = ~r7
            r4 = r4 & 768(0x300, float:1.076E-42)
            if (r4 != 0) goto L_0x01a2
            r4 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r4 = r25 & r4
            r17 = 306783378(0x12492492, float:6.3469493E-28)
            r4 = r4 ^ r17
            if (r4 != 0) goto L_0x01a2
            r0 = r0 & 731(0x2db, float:1.024E-42)
            r0 = r0 ^ 146(0x92, float:2.05E-43)
            if (r0 != 0) goto L_0x01a2
            boolean r0 = r6.getSkipping()
            if (r0 != 0) goto L_0x0190
            goto L_0x01a2
        L_0x0190:
            r6.skipToGroupEnd()
            r3 = r41
            r4 = r42
            r9 = r47
            r10 = r48
            r2 = r6
            r20 = r11
            r6 = r44
            goto L_0x02b2
        L_0x01a2:
            r0 = 0
            if (r3 == 0) goto L_0x01a8
            r20 = r0
            goto L_0x01aa
        L_0x01a8:
            r20 = r11
        L_0x01aa:
            if (r16 == 0) goto L_0x01af
            r22 = r0
            goto L_0x01b1
        L_0x01af:
            r22 = r41
        L_0x01b1:
            if (r19 == 0) goto L_0x01b6
            r19 = r0
            goto L_0x01b8
        L_0x01b6:
            r19 = r42
        L_0x01b8:
            if (r21 == 0) goto L_0x01bd
            r21 = r0
            goto L_0x01bf
        L_0x01bd:
            r21 = r5
        L_0x01bf:
            if (r23 == 0) goto L_0x01c4
            r23 = r0
            goto L_0x01c6
        L_0x01c4:
            r23 = r44
        L_0x01c6:
            if (r1 == 0) goto L_0x01cb
            r33 = r0
            goto L_0x01cd
        L_0x01cb:
            r33 = r47
        L_0x01cd:
            if (r2 == 0) goto L_0x01d2
            r34 = r0
            goto L_0x01d4
        L_0x01d2:
            r34 = r48
        L_0x01d4:
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            java.lang.Object r1 = r6.consume(r1)
            r16 = r1
            android.content.Context r16 = (android.content.Context) r16
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r6.startReplaceableGroup(r1)
            java.lang.Object r2 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r3.getEmpty()
            if (r2 != r4) goto L_0x01ff
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r4 = 2
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r0, r4, r0)
            r6.updateRememberedValue(r2)
            goto L_0x0200
        L_0x01ff:
            r4 = 2
        L_0x0200:
            r6.endReplaceableGroup()
            r18 = r2
            androidx.compose.runtime.MutableState r18 = (androidx.compose.runtime.MutableState) r18
            r6.startReplaceableGroup(r1)
            java.lang.Object r2 = r6.rememberedValue()
            java.lang.Object r5 = r3.getEmpty()
            if (r2 != r5) goto L_0x021d
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r0, r4, r0)
            r6.updateRememberedValue(r2)
        L_0x021d:
            r6.endReplaceableGroup()
            r17 = r2
            androidx.compose.runtime.MutableState r17 = (androidx.compose.runtime.MutableState) r17
            r6.startReplaceableGroup(r1)
            java.lang.Object r2 = r6.rememberedValue()
            java.lang.Object r5 = r3.getEmpty()
            if (r2 != r5) goto L_0x0238
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r0, r4, r0)
            r6.updateRememberedValue(r2)
        L_0x0238:
            r6.endReplaceableGroup()
            r5 = r2
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            r6.startReplaceableGroup(r1)
            java.lang.Object r1 = r6.rememberedValue()
            java.lang.Object r2 = r3.getEmpty()
            if (r1 != r2) goto L_0x0252
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r0, r4, r0)
            r6.updateRememberedValue(r1)
        L_0x0252:
            r6.endReplaceableGroup()
            r30 = r1
            androidx.compose.runtime.MutableState r30 = (androidx.compose.runtime.MutableState) r30
            r11 = r30
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$1 r1 = new com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$1
            r32 = 0
            r26 = r1
            r27 = r16
            r28 = r23
            r29 = r18
            r31 = r5
            r26.<init>(r27, r28, r29, r30, r31, r32)
            r2 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r6, (int) r2)
            com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2 r4 = new com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2
            r0 = r4
            r1 = r39
            r2 = r20
            r3 = r22
            r35 = r4
            r4 = r19
            r36 = r6
            r6 = r25
            r7 = r21
            r8 = r45
            r9 = r46
            r10 = r33
            r12 = r34
            r13 = r16
            r14 = r49
            r15 = r50
            r16 = r51
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = -819892465(0xffffffffcf216f0f, float:-2.70841011E9)
            r1 = 1
            r3 = r35
            r2 = r36
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r0, r1, r3)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r2, r1)
            r5 = r21
            r3 = r22
            r6 = r23
            r9 = r33
            r10 = r34
        L_0x02b2:
            androidx.compose.runtime.ScopeUpdateScope r15 = r2.endRestartGroup()
            if (r15 != 0) goto L_0x02b9
            goto L_0x02de
        L_0x02b9:
            com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$3 r14 = new com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$3
            r0 = r14
            r1 = r39
            r2 = r20
            r7 = r45
            r8 = r46
            r11 = r49
            r12 = r50
            r13 = r51
            r37 = r14
            r14 = r53
            r38 = r15
            r15 = r54
            r16 = r55
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r1 = r37
            r0 = r38
            r0.updateScope(r1)
        L_0x02de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.PhoneFieldComposablesKt.m8448PhoneNumberInputField4mkn5s(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, java.lang.String, boolean, com.designsystem.ds_input_field.OuterState, androidx.compose.ui.text.input.ImeAction, androidx.fragment.app.FragmentManager, java.lang.String, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: PhoneNumberInputField_4_mkn5s$lambda-1  reason: not valid java name */
    public static final List<DSCountryModel> m8449PhoneNumberInputField_4_mkn5s$lambda1(MutableState<List<DSCountryModel>> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: PhoneNumberInputField_4_mkn5s$lambda-10  reason: not valid java name */
    public static final VisualTransformation m8450PhoneNumberInputField_4_mkn5s$lambda10(MutableState<VisualTransformation> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: PhoneNumberInputField_4_mkn5s$lambda-11  reason: not valid java name */
    public static final void m8451PhoneNumberInputField_4_mkn5s$lambda11(MutableState<VisualTransformation> mutableState, VisualTransformation visualTransformation) {
        mutableState.setValue(visualTransformation);
    }

    /* access modifiers changed from: private */
    /* renamed from: PhoneNumberInputField_4_mkn5s$lambda-2  reason: not valid java name */
    public static final void m8452PhoneNumberInputField_4_mkn5s$lambda2(MutableState<List<DSCountryModel>> mutableState, List<DSCountryModel> list) {
        mutableState.setValue(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: PhoneNumberInputField_4_mkn5s$lambda-4  reason: not valid java name */
    public static final boolean m8453PhoneNumberInputField_4_mkn5s$lambda4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: PhoneNumberInputField_4_mkn5s$lambda-5  reason: not valid java name */
    public static final void m8454PhoneNumberInputField_4_mkn5s$lambda5(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    /* renamed from: PhoneNumberInputField_4_mkn5s$lambda-7  reason: not valid java name */
    public static final DSCountryModel m8455PhoneNumberInputField_4_mkn5s$lambda7(MutableState<DSCountryModel> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: PhoneNumberInputField_4_mkn5s$lambda-8  reason: not valid java name */
    public static final void m8456PhoneNumberInputField_4_mkn5s$lambda8(MutableState<DSCountryModel> mutableState, DSCountryModel dSCountryModel) {
        mutableState.setValue(dSCountryModel);
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void PhonePrefix(String str, Composer composer, int i11) {
        int i12;
        Composer composer2;
        int i13;
        String str2 = str;
        int i14 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-1638705947);
        if ((i14 & 14) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i14;
        } else {
            i12 = i14;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            Composer composer3 = startRestartGroup;
            TextKt.m1461TextfLXpl1I(str, (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, InputFieldTextStyleComposablesKt.prefixTextStyle(startRestartGroup, 0), composer3, i12 & 14, 64, 32766);
            composer2 = composer3;
            SpacerKt.Spacer(SizeKt.m563width3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(composer2, 0).m8846getDsXxsD9Ej5fM()), composer2, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PhoneFieldComposablesKt$PhonePrefix$1(str, i11));
        }
    }

    /* access modifiers changed from: private */
    public static final DSCountryModel getDefaultCountry(List<DSCountryModel> list, String str) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt__StringsJVMKt.equals(((DSCountryModel) obj).getCode(), str, true)) {
                break;
            }
        }
        return (DSCountryModel) obj;
    }

    /* access modifiers changed from: private */
    public static final void showCountryPicker(FragmentManager fragmentManager, Context context, Function1<? super DSCountryModel, Unit> function1, String str, String str2, String str3, Function0<Unit> function0, List<DSCountryModel> list) {
        DSBottomSheet dSBottomSheet = null;
        if (fragmentManager != null) {
            dSBottomSheet = DSFragmentManagerExtensionsKt.findDSBottomSheet$default(fragmentManager, (String) null, 1, (Object) null);
        }
        if (dSBottomSheet == null) {
            dSBottomSheet = new DSBottomSheet();
        }
        dSBottomSheet.setOnDismiss(new PhoneFieldComposablesKt$showCountryPicker$1$1(function0));
        DSNavigationBar dSNavigationBar = new DSNavigationBar(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        dSNavigationBar.setLeadingIconButton(new DSIconButtonModel(R.drawable.ds_close, new PhoneFieldComposablesKt$showCountryPicker$1$2$1(dSBottomSheet)));
        dSNavigationBar.setTitle(dSNavigationBar.getTitle());
        Unit unit = Unit.INSTANCE;
        dSBottomSheet.setNavigationBar(dSNavigationBar);
        dSBottomSheet.setBody(PhoneInputCountriesFragment.Companion.newInstance(list, new PhoneFieldComposablesKt$showCountryPicker$1$3(function1), str, str2, str3));
        if (fragmentManager != null) {
            dSBottomSheet.show(fragmentManager);
        }
    }
}
