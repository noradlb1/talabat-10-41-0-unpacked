package com.designsystem.ds_input_field;

import android.content.DialogInterface;
import androidx.compose.runtime.MutableState;
import androidx.fragment.app.FragmentManager;
import com.designsystem.marshmallow.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.CompositeDateValidator;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import d6.a;
import d6.b;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0001¢\u0006\u0002\u0010\u0019\u001aa\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010 \"\u0014\u0010\u0000\u001a\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006!"}, d2 = {"nineteenHundred", "", "getNineteenHundred", "()J", "DateInputField", "", "modifier", "Landroidx/compose/ui/Modifier;", "date", "dateFormat", "", "hint", "helperText", "onDateChange", "Lkotlin/Function1;", "isEnabled", "", "outerState", "Lcom/designsystem/ds_input_field/OuterState;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "locale", "Ljava/util/Locale;", "firstDate", "lastDate", "(Landroidx/compose/ui/Modifier;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;ZLcom/designsystem/ds_input_field/OuterState;Landroidx/fragment/app/FragmentManager;Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Landroidx/compose/runtime/Composer;III)V", "showMaterialDatePicker", "selectedDate", "onDateSelected", "onDismiss", "Lkotlin/Function0;", "onShow", "(Ljava/lang/Long;Landroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JJ)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DateFieldComposablesKt {
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x011b  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DateInputField(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r47, @org.jetbrains.annotations.Nullable java.lang.Long r48, @org.jetbrains.annotations.NotNull java.lang.String r49, @org.jetbrains.annotations.Nullable java.lang.String r50, @org.jetbrains.annotations.Nullable java.lang.String r51, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r52, boolean r53, @org.jetbrains.annotations.NotNull com.designsystem.ds_input_field.OuterState r54, @org.jetbrains.annotations.Nullable androidx.fragment.app.FragmentManager r55, @org.jetbrains.annotations.Nullable java.util.Locale r56, @org.jetbrains.annotations.Nullable java.lang.Long r57, @org.jetbrains.annotations.Nullable java.lang.Long r58, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r59, int r60, int r61, int r62) {
        /*
            r7 = r47
            r6 = r49
            r3 = r53
            r2 = r54
            r0 = r57
            r14 = r58
            r13 = r60
            r12 = r62
            java.lang.String r1 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "dateFormat"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.lang.String r1 = "outerState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            r1 = -848834933(0xffffffffcd67ce8b, float:-2.43067056E8)
            r4 = r59
            androidx.compose.runtime.Composer r11 = r4.startRestartGroup(r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x002f
            r1 = r13 | 6
            goto L_0x003f
        L_0x002f:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x003e
            boolean r1 = r11.changed((java.lang.Object) r7)
            if (r1 == 0) goto L_0x003b
            r1 = 4
            goto L_0x003c
        L_0x003b:
            r1 = 2
        L_0x003c:
            r1 = r1 | r13
            goto L_0x003f
        L_0x003e:
            r1 = r13
        L_0x003f:
            r8 = r12 & 2
            if (r8 == 0) goto L_0x0046
            r1 = r1 | 48
            goto L_0x005a
        L_0x0046:
            r15 = r13 & 112(0x70, float:1.57E-43)
            if (r15 != 0) goto L_0x005a
            r15 = r48
            boolean r16 = r11.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x0055
            r16 = 32
            goto L_0x0057
        L_0x0055:
            r16 = 16
        L_0x0057:
            r1 = r1 | r16
            goto L_0x005c
        L_0x005a:
            r15 = r48
        L_0x005c:
            r16 = r12 & 4
            if (r16 == 0) goto L_0x0063
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0073
        L_0x0063:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0073
            boolean r4 = r11.changed((java.lang.Object) r6)
            if (r4 == 0) goto L_0x0070
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0072
        L_0x0070:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0072:
            r1 = r1 | r4
        L_0x0073:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x007a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x008e
        L_0x007a:
            r9 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x008e
            r9 = r50
            boolean r17 = r11.changed((java.lang.Object) r9)
            if (r17 == 0) goto L_0x0089
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0089:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r1 = r1 | r17
            goto L_0x0090
        L_0x008e:
            r9 = r50
        L_0x0090:
            r17 = r12 & 16
            if (r17 == 0) goto L_0x0099
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r10 = r51
            goto L_0x00af
        L_0x0099:
            r18 = 57344(0xe000, float:8.0356E-41)
            r18 = r13 & r18
            r10 = r51
            if (r18 != 0) goto L_0x00af
            boolean r19 = r11.changed((java.lang.Object) r10)
            if (r19 == 0) goto L_0x00ab
            r19 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ad
        L_0x00ab:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x00ad:
            r1 = r1 | r19
        L_0x00af:
            r19 = r12 & 32
            if (r19 == 0) goto L_0x00ba
            r20 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r20
            r5 = r52
            goto L_0x00cf
        L_0x00ba:
            r20 = 458752(0x70000, float:6.42848E-40)
            r20 = r13 & r20
            r5 = r52
            if (r20 != 0) goto L_0x00cf
            boolean r21 = r11.changed((java.lang.Object) r5)
            if (r21 == 0) goto L_0x00cb
            r21 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cd
        L_0x00cb:
            r21 = 65536(0x10000, float:9.18355E-41)
        L_0x00cd:
            r1 = r1 | r21
        L_0x00cf:
            r21 = r12 & 64
            r22 = 3670016(0x380000, float:5.142788E-39)
            if (r21 == 0) goto L_0x00da
            r21 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d7:
            r1 = r1 | r21
            goto L_0x00ea
        L_0x00da:
            r21 = r13 & r22
            if (r21 != 0) goto L_0x00ea
            boolean r21 = r11.changed((boolean) r3)
            if (r21 == 0) goto L_0x00e7
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00e7:
            r21 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d7
        L_0x00ea:
            r5 = r12 & 128(0x80, float:1.794E-43)
            r23 = 29360128(0x1c00000, float:7.052966E-38)
            if (r5 == 0) goto L_0x00f4
            r5 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00f2:
            r1 = r1 | r5
            goto L_0x0104
        L_0x00f4:
            r5 = r13 & r23
            if (r5 != 0) goto L_0x0104
            boolean r5 = r11.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x0101
            r5 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x0101:
            r5 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00f2
        L_0x0104:
            r5 = r12 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x010c
            r21 = 33554432(0x2000000, float:9.403955E-38)
            r1 = r1 | r21
        L_0x010c:
            r7 = r12 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x0114
            r21 = 268435456(0x10000000, float:2.5243549E-29)
            r1 = r1 | r21
        L_0x0114:
            r9 = r12 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x011b
            r9 = r61 | 6
            goto L_0x012d
        L_0x011b:
            r9 = r61 & 14
            if (r9 != 0) goto L_0x012b
            boolean r9 = r11.changed((java.lang.Object) r0)
            if (r9 == 0) goto L_0x0127
            r9 = 4
            goto L_0x0128
        L_0x0127:
            r9 = 2
        L_0x0128:
            r9 = r61 | r9
            goto L_0x012d
        L_0x012b:
            r9 = r61
        L_0x012d:
            r10 = r12 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L_0x0134
            r9 = r9 | 48
            goto L_0x0145
        L_0x0134:
            r10 = r61 & 112(0x70, float:1.57E-43)
            if (r10 != 0) goto L_0x0145
            boolean r10 = r11.changed((java.lang.Object) r14)
            if (r10 == 0) goto L_0x0141
            r16 = 32
            goto L_0x0143
        L_0x0141:
            r16 = 16
        L_0x0143:
            r9 = r9 | r16
        L_0x0145:
            int r10 = ~r12
            r10 = r10 & 768(0x300, float:1.076E-42)
            if (r10 != 0) goto L_0x0174
            r10 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r10 = r10 & r1
            r16 = 306783378(0x12492492, float:6.3469493E-28)
            r10 = r10 ^ r16
            if (r10 != 0) goto L_0x0174
            r9 = r9 & 91
            r9 = r9 ^ 18
            if (r9 != 0) goto L_0x0174
            boolean r9 = r11.getSkipping()
            if (r9 != 0) goto L_0x0162
            goto L_0x0174
        L_0x0162:
            r11.skipToGroupEnd()
            r4 = r50
            r5 = r51
            r6 = r52
            r9 = r55
            r10 = r56
            r30 = r11
            r2 = r15
            goto L_0x031c
        L_0x0174:
            r9 = 0
            if (r8 == 0) goto L_0x0179
            r10 = r9
            goto L_0x017a
        L_0x0179:
            r10 = r15
        L_0x017a:
            if (r4 == 0) goto L_0x017f
            r27 = r9
            goto L_0x0181
        L_0x017f:
            r27 = r50
        L_0x0181:
            if (r17 == 0) goto L_0x0186
            r28 = r9
            goto L_0x0188
        L_0x0186:
            r28 = r51
        L_0x0188:
            if (r19 == 0) goto L_0x018d
            r40 = r9
            goto L_0x018f
        L_0x018d:
            r40 = r52
        L_0x018f:
            if (r5 == 0) goto L_0x0194
            r41 = r9
            goto L_0x0196
        L_0x0194:
            r41 = r55
        L_0x0196:
            if (r7 == 0) goto L_0x019b
            r42 = r9
            goto L_0x019d
        L_0x019b:
            r42 = r56
        L_0x019d:
            androidx.compose.runtime.ProvidableCompositionLocal r4 = com.designsystem.composition.LocalCurrentTimeKt.getLocalCalendar()
            java.lang.Object r4 = r11.consume(r4)
            java.util.Calendar r4 = (java.util.Calendar) r4
            long r4 = r4.getTimeInMillis()
            if (r0 != 0) goto L_0x01b2
            long r7 = getNineteenHundred()
            goto L_0x01b6
        L_0x01b2:
            long r7 = r57.longValue()
        L_0x01b6:
            if (r14 != 0) goto L_0x01bb
            r43 = r4
            goto L_0x01c1
        L_0x01bb:
            long r15 = r58.longValue()
            r43 = r15
        L_0x01c1:
            r15 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r11.startReplaceableGroup(r15)
            java.lang.Object r15 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r16.getEmpty()
            if (r15 != r0) goto L_0x01db
            r0 = 2
            androidx.compose.runtime.MutableState r15 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r10, r9, r0, r9)
            r11.updateRememberedValue(r15)
        L_0x01db:
            r11.endReplaceableGroup()
            r36 = r15
            androidx.compose.runtime.MutableState r36 = (androidx.compose.runtime.MutableState) r36
            kotlin.ranges.LongRange r0 = new kotlin.ranges.LongRange
            r17 = r10
            r9 = r43
            r0.<init>(r7, r9)
            java.lang.Long r15 = m8390DateInputField$lambda1(r36)
            if (r15 != 0) goto L_0x01f2
            goto L_0x01f6
        L_0x01f2:
            long r4 = r15.longValue()
        L_0x01f6:
            boolean r0 = r0.contains((long) r4)
            if (r0 == 0) goto L_0x0347
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r11.startReplaceableGroup(r0)
            java.lang.Object r4 = r11.rememberedValue()
            java.lang.Object r5 = r16.getEmpty()
            if (r4 != r5) goto L_0x0217
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r5 = 2
            r15 = 0
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r15, r5, r15)
            r11.updateRememberedValue(r4)
        L_0x0217:
            r11.endReplaceableGroup()
            r35 = r4
            androidx.compose.runtime.MutableState r35 = (androidx.compose.runtime.MutableState) r35
            r11.startReplaceableGroup(r0)
            java.lang.Object r0 = r11.rememberedValue()
            java.lang.Object r4 = r16.getEmpty()
            if (r0 != r4) goto L_0x0242
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            if (r42 != 0) goto L_0x0234
            java.util.Locale r4 = java.util.Locale.getDefault()
            goto L_0x0236
        L_0x0234:
            r4 = r42
        L_0x0236:
            r0.<init>(r6, r4)
            r4 = 2
            r5 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r5, r4, r5)
            r11.updateRememberedValue(r0)
        L_0x0242:
            r11.endReplaceableGroup()
            r38 = r0
            androidx.compose.runtime.MutableState r38 = (androidx.compose.runtime.MutableState) r38
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r11.startReplaceableGroup(r0)
            java.lang.Object r0 = r11.rememberedValue()
            java.lang.Object r4 = r16.getEmpty()
            if (r0 != r4) goto L_0x0276
            if (r17 != 0) goto L_0x025f
            r5 = r17
            r0 = 0
            goto L_0x026c
        L_0x025f:
            r17.longValue()
            java.text.SimpleDateFormat r0 = m8397DateInputField$lambda8(r38)
            r5 = r17
            java.lang.String r0 = r0.format(r5)
        L_0x026c:
            r4 = 2
            r15 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r15, r4, r15)
            r11.updateRememberedValue(r0)
            goto L_0x0278
        L_0x0276:
            r5 = r17
        L_0x0278:
            r11.endReplaceableGroup()
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            r4 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r11.startReplaceableGroup(r4)
            java.lang.Object r4 = r11.rememberedValue()
            java.lang.Object r15 = r16.getEmpty()
            if (r4 != r15) goto L_0x02a7
            com.designsystem.ds_input_field.DateFieldComposablesKt$DateInputField$onTap$2$1 r4 = new com.designsystem.ds_input_field.DateFieldComposablesKt$DateInputField$onTap$2$1
            r29 = r4
            r30 = r41
            r31 = r7
            r33 = r9
            r37 = r40
            r39 = r0
            r29.<init>(r30, r31, r33, r35, r36, r37, r38, r39)
            r7 = 2
            r8 = 0
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r8, r7, r8)
            r11.updateRememberedValue(r4)
        L_0x02a7:
            r11.endReplaceableGroup()
            r7 = r4
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            java.lang.String r0 = m8391DateInputField$lambda11(r0)
            r10 = r1
            r1 = r0
            com.designsystem.ds_input_field.InputFieldCommon r0 = com.designsystem.ds_input_field.InputFieldCommon.INSTANCE
            float r15 = r0.m8409getSingleLineContainerMinHeightD9Ej5fM()
            kotlin.jvm.functions.Function0 r18 = m8393DateInputField$lambda14(r7)
            r4 = 0
            r0 = 0
            r16 = r5
            r5 = r0
            r8 = 0
            r9 = 0
            com.designsystem.ds_input_field.DateFieldComposablesKt$DateInputField$2 r0 = new com.designsystem.ds_input_field.DateFieldComposablesKt$DateInputField$2
            r0.<init>(r2, r3, r10, r7)
            r7 = -819893537(0xffffffffcf216adf, float:-2.70813568E9)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r7, r4, r0)
            r4 = r10
            r29 = r16
            r10 = r0
            r0 = 1
            r30 = r11
            r11 = r0
            r0 = 0
            r12 = r0
            r13 = r0
            r14 = r0
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r0 = r4 & 14
            int r7 = r4 >> 3
            r5 = r7 & 896(0x380, float:1.256E-42)
            r0 = r0 | r5
            r5 = r7 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r5
            r5 = r4 & r22
            r0 = r0 | r5
            r4 = r4 & r23
            r23 = r0 | r4
            r24 = 54
            r25 = 0
            r26 = 3896112(0x3b7330, float:5.459616E-39)
            r0 = r47
            r2 = r27
            r3 = r28
            r6 = r53
            r7 = r54
            r22 = r30
            r4 = 0
            r5 = 0
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt.m8413InputFieldmytMHeg(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r4 = r27
            r5 = r28
            r2 = r29
            r6 = r40
            r9 = r41
            r10 = r42
        L_0x031c:
            androidx.compose.runtime.ScopeUpdateScope r15 = r30.endRestartGroup()
            if (r15 != 0) goto L_0x0323
            goto L_0x0346
        L_0x0323:
            com.designsystem.ds_input_field.DateFieldComposablesKt$DateInputField$3 r14 = new com.designsystem.ds_input_field.DateFieldComposablesKt$DateInputField$3
            r0 = r14
            r1 = r47
            r3 = r49
            r7 = r53
            r8 = r54
            r11 = r57
            r12 = r58
            r13 = r60
            r45 = r14
            r14 = r61
            r46 = r15
            r15 = r62
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1 = r45
            r0 = r46
            r0.updateScope(r1)
        L_0x0346:
            return
        L_0x0347:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Date must be between firstDate and lastDate!"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.DateFieldComposablesKt.DateInputField(androidx.compose.ui.Modifier, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, boolean, com.designsystem.ds_input_field.OuterState, androidx.fragment.app.FragmentManager, java.util.Locale, java.lang.Long, java.lang.Long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: DateInputField$lambda-1  reason: not valid java name */
    public static final Long m8390DateInputField$lambda1(MutableState<Long> mutableState) {
        return mutableState.getValue();
    }

    /* renamed from: DateInputField$lambda-11  reason: not valid java name */
    private static final String m8391DateInputField$lambda11(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DateInputField$lambda-12  reason: not valid java name */
    public static final void m8392DateInputField$lambda12(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: DateInputField$lambda-14  reason: not valid java name */
    public static final Function0<Unit> m8393DateInputField$lambda14(MutableState<Function0<Unit>> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DateInputField$lambda-2  reason: not valid java name */
    public static final void m8394DateInputField$lambda2(MutableState<Long> mutableState, Long l11) {
        mutableState.setValue(l11);
    }

    /* access modifiers changed from: private */
    /* renamed from: DateInputField$lambda-5  reason: not valid java name */
    public static final boolean m8395DateInputField$lambda5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DateInputField$lambda-6  reason: not valid java name */
    public static final void m8396DateInputField$lambda6(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    /* renamed from: DateInputField$lambda-8  reason: not valid java name */
    public static final SimpleDateFormat m8397DateInputField$lambda8(MutableState<SimpleDateFormat> mutableState) {
        return mutableState.getValue();
    }

    private static final long getNineteenHundred() {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
        instance.clear();
        instance.set(1900, 0, 1);
        return instance.getTimeInMillis();
    }

    /* access modifiers changed from: private */
    public static final void showMaterialDatePicker(Long l11, FragmentManager fragmentManager, Function1<? super Long, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, long j11, long j12) {
        CalendarConstraints.Builder end = new CalendarConstraints.Builder().setStart(j11).setEnd(j12);
        DateValidatorPointForward from = DateValidatorPointForward.from(j11);
        Intrinsics.checkNotNullExpressionValue(from, "from(firstDate)");
        DateValidatorPointBackward before = DateValidatorPointBackward.before(j12);
        Intrinsics.checkNotNullExpressionValue(before, "before(lastDate)");
        CalendarConstraints.Builder validator = end.setValidator(CompositeDateValidator.allOf(CollectionsKt__CollectionsKt.listOf(from, before)));
        Intrinsics.checkNotNullExpressionValue(validator, "Builder()\n        .setSt…)\n            )\n        )");
        if (l11 != null) {
            validator.setOpenAt(l11.longValue());
        }
        MaterialDatePicker.Builder<Long> calendarConstraints = MaterialDatePicker.Builder.datePicker().setInputMode(0).setTheme(R.style.MaterialDatePickerTheme).setCalendarConstraints(validator.build());
        Intrinsics.checkNotNullExpressionValue(calendarConstraints, "datePicker()\n        .se…endarConstraints.build())");
        if (l11 != null) {
            calendarConstraints.setSelection(Long.valueOf(l11.longValue()));
        }
        MaterialDatePicker build = calendarConstraints.build();
        build.addOnPositiveButtonClickListener(new a(function1));
        build.addOnDismissListener(new b(function0));
        Intrinsics.checkNotNullExpressionValue(build, "builder\n        .build()…)\n            }\n        }");
        if (fragmentManager != null) {
            function02.invoke();
            build.show(fragmentManager, MaterialDatePicker.class.getName());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showMaterialDatePicker$lambda-20$lambda-18  reason: not valid java name */
    public static final void m8405showMaterialDatePicker$lambda20$lambda18(Function1 function1, Long l11) {
        Intrinsics.checkNotNullParameter(function1, "$onDateSelected");
        Intrinsics.checkNotNullExpressionValue(l11, "selection");
        function1.invoke(l11);
    }

    /* access modifiers changed from: private */
    /* renamed from: showMaterialDatePicker$lambda-20$lambda-19  reason: not valid java name */
    public static final void m8406showMaterialDatePicker$lambda20$lambda19(Function0 function0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(function0, "$onDismiss");
        function0.invoke();
    }
}
