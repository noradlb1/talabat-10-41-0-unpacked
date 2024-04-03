package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarKt$Snackbar$actionComposable$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f8321g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8322h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SnackbarData f8323i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f8324j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$Snackbar$actionComposable$1(long j11, int i11, SnackbarData snackbarData, String str) {
        super(2);
        this.f8321g = j11;
        this.f8322h = i11;
        this.f8323i = snackbarData;
        this.f8324j = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r16, int r17) {
        /*
            r15 = this;
            r0 = r15
            r13 = r16
            r1 = r17
            r2 = r1 & 11
            r3 = 2
            if (r2 != r3) goto L_0x0016
            boolean r2 = r16.getSkipping()
            if (r2 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            r16.skipToGroupEnd()
            goto L_0x0090
        L_0x0016:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0025
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:207)"
            r4 = -1378313599(0xffffffffadd89a81, float:-2.462497E-11)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x0025:
            androidx.compose.material3.ButtonDefaults r1 = androidx.compose.material3.ButtonDefaults.INSTANCE
            r2 = 0
            long r4 = r0.f8321g
            r6 = 0
            r8 = 0
            int r10 = r0.f8322h
            int r10 = r10 >> 15
            r10 = r10 & 112(0x70, float:1.57E-43)
            r11 = r10 | 24576(0x6000, float:3.4438E-41)
            r12 = 13
            r10 = r16
            androidx.compose.material3.ButtonColors r5 = r1.m1528textButtonColorsro_MJ88(r2, r4, r6, r8, r10, r11, r12)
            androidx.compose.material3.SnackbarData r1 = r0.f8323i
            r2 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r2)
            boolean r2 = r13.changed((java.lang.Object) r1)
            java.lang.Object r3 = r16.rememberedValue()
            if (r2 != 0) goto L_0x0059
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0061
        L_0x0059:
            androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1 r3 = new androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1
            r3.<init>(r1)
            r13.updateRememberedValue(r3)
        L_0x0061:
            r16.endReplaceableGroup()
            r1 = r3
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$2 r10 = new androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$2
            java.lang.String r11 = r0.f8324j
            r10.<init>(r11)
            r11 = 521110564(0x1f0f8424, float:3.0390732E-20)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r11, r12, r10)
            r12 = 805306368(0x30000000, float:4.656613E-10)
            r14 = 494(0x1ee, float:6.92E-43)
            r11 = r16
            r13 = r14
            androidx.compose.material3.ButtonKt.TextButton(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0090
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
