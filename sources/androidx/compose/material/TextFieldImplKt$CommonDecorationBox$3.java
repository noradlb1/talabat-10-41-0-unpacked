package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldImplKt$CommonDecorationBox$3 extends Lambda implements Function6<Float, Color, Color, Float, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5931g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5932h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f5933i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5934j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5935k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f5936l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f5937m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f5938n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f5939o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5940p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5941q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ TextFieldType f5942r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5943s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ boolean f5944t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f5945u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ boolean f5946v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5947w;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextFieldType.values().length];
            iArr[TextFieldType.Filled.ordinal()] = 1;
            iArr[TextFieldType.Outlined.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$CommonDecorationBox$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, String str, boolean z11, int i11, TextFieldColors textFieldColors, boolean z12, InteractionSource interactionSource, int i12, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, TextFieldType textFieldType, Function2<? super Composer, ? super Integer, Unit> function25, boolean z13, PaddingValues paddingValues, boolean z14, Function2<? super Composer, ? super Integer, Unit> function26) {
        super(6);
        this.f5931g = function2;
        this.f5932h = function22;
        this.f5933i = str;
        this.f5934j = z11;
        this.f5935k = i11;
        this.f5936l = textFieldColors;
        this.f5937m = z12;
        this.f5938n = interactionSource;
        this.f5939o = i12;
        this.f5940p = function23;
        this.f5941q = function24;
        this.f5942r = textFieldType;
        this.f5943s = function25;
        this.f5944t = z13;
        this.f5945u = paddingValues;
        this.f5946v = z14;
        this.f5947w = function26;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        m1447invokeRIQooxk(((Number) obj).floatValue(), ((Color) obj2).m2929unboximpl(), ((Color) obj3).m2929unboximpl(), ((Number) obj4).floatValue(), (Composer) obj5, ((Number) obj6).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02be  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: invoke-RIQooxk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1447invokeRIQooxk(float r21, long r22, long r24, float r26, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28) {
        /*
            r20 = this;
            r0 = r20
            r10 = r21
            r15 = r27
            r1 = r28
            r2 = r1 & 14
            if (r2 != 0) goto L_0x0017
            boolean r2 = r15.changed((float) r10)
            if (r2 == 0) goto L_0x0014
            r2 = 4
            goto L_0x0015
        L_0x0014:
            r2 = 2
        L_0x0015:
            r2 = r2 | r1
            goto L_0x0018
        L_0x0017:
            r2 = r1
        L_0x0018:
            r3 = r1 & 112(0x70, float:1.57E-43)
            r8 = r22
            if (r3 != 0) goto L_0x002a
            boolean r3 = r15.changed((long) r8)
            if (r3 == 0) goto L_0x0027
            r3 = 32
            goto L_0x0029
        L_0x0027:
            r3 = 16
        L_0x0029:
            r2 = r2 | r3
        L_0x002a:
            r3 = r1 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x003d
            r3 = r24
            boolean r5 = r15.changed((long) r3)
            if (r5 == 0) goto L_0x0039
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x003b
        L_0x0039:
            r5 = 128(0x80, float:1.794E-43)
        L_0x003b:
            r2 = r2 | r5
            goto L_0x003f
        L_0x003d:
            r3 = r24
        L_0x003f:
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r12 = r26
            if (r1 != 0) goto L_0x0051
            boolean r1 = r15.changed((float) r12)
            if (r1 == 0) goto L_0x004e
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x0050
        L_0x004e:
            r1 = 1024(0x400, float:1.435E-42)
        L_0x0050:
            r2 = r2 | r1
        L_0x0051:
            r13 = r2
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r1 & r13
            r2 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r2) goto L_0x0066
            boolean r1 = r27.getSkipping()
            if (r1 != 0) goto L_0x0061
            goto L_0x0066
        L_0x0061:
            r27.skipToGroupEnd()
            goto L_0x02f8
        L_0x0066:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.f5931g
            r7 = 1
            if (r5 == 0) goto L_0x0089
            boolean r6 = r0.f5946v
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1 r2 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
            r1 = r2
            r11 = r2
            r2 = r21
            r3 = r24
            r17 = r6
            r6 = r13
            r14 = r7
            r7 = r17
            r8 = r22
            r1.<init>(r2, r3, r5, r6, r7, r8)
            r1 = 362863774(0x15a0dc9e, float:6.497156E-26)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r1, r14, r11)
            r11 = r1
            goto L_0x008b
        L_0x0089:
            r14 = r7
            r11 = 0
        L_0x008b:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.f5932h
            r2 = 0
            if (r1 == 0) goto L_0x00b8
            java.lang.String r1 = r0.f5933i
            int r1 = r1.length()
            if (r1 != 0) goto L_0x009a
            r7 = r14
            goto L_0x009b
        L_0x009a:
            r7 = r2
        L_0x009b:
            if (r7 == 0) goto L_0x00b8
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1 r1 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
            androidx.compose.material.TextFieldColors r5 = r0.f5936l
            boolean r6 = r0.f5937m
            int r7 = r0.f5939o
            int r8 = r0.f5935k
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r9 = r0.f5932h
            r3 = r1
            r4 = r26
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r3 = 1120552650(0x42ca46ca, float:101.13826)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r3, r14, r1)
            r7 = r1
            goto L_0x00b9
        L_0x00b8:
            r7 = 0
        L_0x00b9:
            androidx.compose.material.Strings$Companion r1 = androidx.compose.material.Strings.Companion
            int r1 = r1.m1377getDefaultErrorMessageUdPEhr4()
            r8 = 6
            java.lang.String r1 = androidx.compose.material.Strings_androidKt.m1382getString4foXLRw(r1, r15, r8)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            boolean r4 = r0.f5934j
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            boolean r5 = r0.f5934j
            r9 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r15.startReplaceableGroup(r9)
            boolean r4 = r15.changed((java.lang.Object) r4)
            boolean r6 = r15.changed((java.lang.Object) r1)
            r4 = r4 | r6
            java.lang.Object r6 = r27.rememberedValue()
            if (r4 != 0) goto L_0x00eb
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r6 != r4) goto L_0x00f3
        L_0x00eb:
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1 r6 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1
            r6.<init>(r5, r1)
            r15.updateRememberedValue(r6)
        L_0x00f3:
            r27.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r1 = 0
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r3, r2, r6, r14, r1)
            androidx.compose.material.TextFieldColors r1 = r0.f5936l
            boolean r1 = r1 instanceof androidx.compose.material.TextFieldColorsWithIcons
            if (r1 == 0) goto L_0x013a
            r1 = -1083197894(0xffffffffbf6fb63a, float:-0.9363743)
            r15.startReplaceableGroup(r1)
            androidx.compose.material.TextFieldColors r1 = r0.f5936l
            androidx.compose.material.TextFieldColorsWithIcons r1 = (androidx.compose.material.TextFieldColorsWithIcons) r1
            boolean r2 = r0.f5937m
            boolean r3 = r0.f5934j
            androidx.compose.foundation.interaction.InteractionSource r4 = r0.f5938n
            int r5 = r0.f5939o
            int r5 = r5 >> 27
            r5 = r5 & 14
            int r6 = r0.f5935k
            int r17 = r6 << 3
            r17 = r17 & 112(0x70, float:1.57E-43)
            r5 = r5 | r17
            int r6 = r6 << 3
            r6 = r6 & 896(0x380, float:1.256E-42)
            r6 = r6 | r5
            r5 = r27
            androidx.compose.runtime.State r1 = r1.leadingIconColor(r2, r3, r4, r5, r6)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m2929unboximpl()
            r27.endReplaceableGroup()
            goto L_0x0169
        L_0x013a:
            r1 = -1083197798(0xffffffffbf6fb69a, float:-0.93638)
            r15.startReplaceableGroup(r1)
            androidx.compose.material.TextFieldColors r1 = r0.f5936l
            boolean r2 = r0.f5937m
            boolean r3 = r0.f5934j
            int r4 = r0.f5939o
            int r4 = r4 >> 27
            r4 = r4 & 14
            int r5 = r0.f5935k
            int r6 = r5 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r4 = r4 | r6
            int r5 = r5 >> 3
            r5 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            androidx.compose.runtime.State r1 = r1.leadingIconColor(r2, r3, r15, r4)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m2929unboximpl()
            r27.endReplaceableGroup()
        L_0x0169:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.f5940p
            if (r3 == 0) goto L_0x017c
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1 r4 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
            r4.<init>(r1, r3)
            r1 = 1505327088(0x59b977f0, float:6.5255929E15)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r1, r14, r4)
            r17 = r1
            goto L_0x017e
        L_0x017c:
            r17 = 0
        L_0x017e:
            androidx.compose.material.TextFieldColors r1 = r0.f5936l
            boolean r1 = r1 instanceof androidx.compose.material.TextFieldColorsWithIcons
            if (r1 == 0) goto L_0x01bb
            r1 = -1083197452(0xffffffffbf6fb7f4, float:-0.93640065)
            r15.startReplaceableGroup(r1)
            androidx.compose.material.TextFieldColors r1 = r0.f5936l
            androidx.compose.material.TextFieldColorsWithIcons r1 = (androidx.compose.material.TextFieldColorsWithIcons) r1
            boolean r2 = r0.f5937m
            boolean r3 = r0.f5934j
            androidx.compose.foundation.interaction.InteractionSource r4 = r0.f5938n
            int r5 = r0.f5939o
            int r5 = r5 >> 27
            r5 = r5 & 14
            int r6 = r0.f5935k
            int r18 = r6 << 3
            r18 = r18 & 112(0x70, float:1.57E-43)
            r5 = r5 | r18
            int r6 = r6 << 3
            r6 = r6 & 896(0x380, float:1.256E-42)
            r6 = r6 | r5
            r5 = r27
            androidx.compose.runtime.State r1 = r1.trailingIconColor(r2, r3, r4, r5, r6)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m2929unboximpl()
            r27.endReplaceableGroup()
            goto L_0x01ea
        L_0x01bb:
            r1 = -1083197355(0xffffffffbf6fb855, float:-0.93640643)
            r15.startReplaceableGroup(r1)
            androidx.compose.material.TextFieldColors r1 = r0.f5936l
            boolean r2 = r0.f5937m
            boolean r3 = r0.f5934j
            int r4 = r0.f5939o
            int r4 = r4 >> 27
            r4 = r4 & 14
            int r5 = r0.f5935k
            int r6 = r5 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r4 = r4 | r6
            int r5 = r5 >> 3
            r5 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            androidx.compose.runtime.State r1 = r1.trailingIconColor(r2, r3, r15, r4)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m2929unboximpl()
            r27.endReplaceableGroup()
        L_0x01ea:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.f5941q
            if (r3 == 0) goto L_0x01fc
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1 r4 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
            r4.<init>(r1, r3)
            r1 = -1894727196(0xffffffff8f10c1e4, float:-7.13709E-30)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r1, r14, r4)
            r6 = r1
            goto L_0x01fd
        L_0x01fc:
            r6 = 0
        L_0x01fd:
            androidx.compose.material.TextFieldType r1 = r0.f5942r
            int[] r2 = androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            if (r1 == r14) goto L_0x02be
            r4 = 2
            if (r1 == r4) goto L_0x0219
            r1 = -1083194976(0xffffffffbf6fc1a0, float:-0.93654823)
            r15.startReplaceableGroup(r1)
            r27.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x02f8
        L_0x0219:
            r1 = -1083196463(0xffffffffbf6fbbd1, float:-0.9364596)
            r15.startReplaceableGroup(r1)
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r1)
            java.lang.Object r1 = r27.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r4.getEmpty()
            if (r1 != r5) goto L_0x0244
            androidx.compose.ui.geometry.Size$Companion r1 = androidx.compose.ui.geometry.Size.Companion
            long r18 = r1.m2754getZeroNHjbRc()
            androidx.compose.ui.geometry.Size r1 = androidx.compose.ui.geometry.Size.m2733boximpl(r18)
            r2 = 0
            r5 = 2
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r2, r5, r2)
            r15.updateRememberedValue(r1)
        L_0x0244:
            r27.endReplaceableGroup()
            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1 r2 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
            androidx.compose.foundation.layout.PaddingValues r5 = r0.f5945u
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.f5947w
            int r8 = r0.f5935k
            r2.<init>(r1, r5, r3, r8)
            r3 = 139886979(0x8568183, float:6.4550523E-34)
            androidx.compose.runtime.internal.ComposableLambda r14 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r3, r14, r2)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r2 = r0.f5943s
            boolean r8 = r0.f5944t
            java.lang.Float r3 = java.lang.Float.valueOf(r21)
            r15.startReplaceableGroup(r9)
            boolean r3 = r15.changed((java.lang.Object) r3)
            boolean r5 = r15.changed((java.lang.Object) r1)
            r3 = r3 | r5
            java.lang.Object r5 = r27.rememberedValue()
            if (r3 != 0) goto L_0x027b
            java.lang.Object r3 = r4.getEmpty()
            if (r5 != r3) goto L_0x0283
        L_0x027b:
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1 r5 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
            r5.<init>(r10, r1)
            r15.updateRememberedValue(r5)
        L_0x0283:
            r27.endReplaceableGroup()
            r9 = r5
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.foundation.layout.PaddingValues r5 = r0.f5945u
            int r1 = r0.f5939o
            int r3 = r1 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r4 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r4
            r4 = 6
            int r1 = r1 >> r4
            r16 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r16
            r1 = r1 | r3
            int r3 = r13 << 21
            r13 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r13
            r13 = r1 | r3
            int r1 = r0.f5935k
            int r1 = r1 >> r4
            r16 = r1 & 14
            r1 = r12
            r3 = r7
            r4 = r11
            r11 = r5
            r5 = r17
            r7 = r8
            r8 = r21
            r10 = r14
            r12 = r27
            r14 = r16
            androidx.compose.material.OutlinedTextFieldKt.OutlinedTextFieldLayout(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r27.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x02f8
        L_0x02be:
            r1 = -1083197019(0xffffffffbf6fb9a5, float:-0.93642646)
            r15.startReplaceableGroup(r1)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r2 = r0.f5943s
            boolean r8 = r0.f5944t
            androidx.compose.foundation.layout.PaddingValues r9 = r0.f5945u
            int r1 = r0.f5939o
            int r3 = r1 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r4 = 6
            int r1 = r1 >> r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r4
            r1 = r1 | r3
            int r3 = r13 << 21
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r4
            r1 = r1 | r3
            int r3 = r0.f5935k
            int r3 = r3 << 18
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r4
            r13 = r1 | r3
            r1 = r12
            r3 = r11
            r4 = r7
            r5 = r17
            r7 = r8
            r8 = r21
            r10 = r27
            r11 = r13
            androidx.compose.material.TextFieldKt.TextFieldLayout(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r27.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x02f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3.m1447invokeRIQooxk(float, long, long, float, androidx.compose.runtime.Composer, int):void");
    }
}
