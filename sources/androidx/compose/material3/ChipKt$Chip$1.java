package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ChipKt$Chip$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6782g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6783h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f6784i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6785j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6786k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ChipColors f6787l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f6788m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6789n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f6790o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6791p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6792q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$Chip$1(Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, long j11, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, ChipColors chipColors, boolean z11, int i11, float f11, PaddingValues paddingValues, int i12) {
        super(2);
        this.f6782g = function2;
        this.f6783h = textStyle;
        this.f6784i = j11;
        this.f6785j = function22;
        this.f6786k = function23;
        this.f6787l = chipColors;
        this.f6788m = z11;
        this.f6789n = i11;
        this.f6790o = f11;
        this.f6791p = paddingValues;
        this.f6792q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        int i12 = i11;
        if ((i12 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1985962652, i12, -1, "androidx.compose.material3.Chip.<anonymous> (Chip.kt:1335)");
            }
            Function2<Composer, Integer, Unit> function2 = this.f6782g;
            TextStyle textStyle = this.f6783h;
            long j11 = this.f6784i;
            Function2<Composer, Integer, Unit> function22 = this.f6785j;
            Function2<Composer, Integer, Unit> function23 = this.f6786k;
            ChipColors chipColors = this.f6787l;
            boolean z11 = this.f6788m;
            int i13 = this.f6789n;
            long r82 = chipColors.leadingIconContentColor$material3_release(z11, composer2, ((i13 >> 24) & 112) | ((i13 >> 6) & 14)).getValue().m2929unboximpl();
            ChipColors chipColors2 = this.f6787l;
            boolean z12 = this.f6788m;
            int i14 = this.f6789n;
            long r102 = chipColors2.trailingIconContentColor$material3_release(z12, composer2, ((i14 >> 24) & 112) | ((i14 >> 6) & 14)).getValue().m2929unboximpl();
            float f11 = this.f6790o;
            PaddingValues paddingValues = this.f6791p;
            int i15 = this.f6789n;
            int i16 = ((i15 >> 9) & 14) | CpioConstants.C_ISBLK | ((i15 >> 9) & 112) | ((i15 >> 9) & 896) | ((i15 >> 9) & 7168) | (458752 & (i15 >> 6));
            int i17 = this.f6792q;
            ChipKt.m1541ChipContentfe0OD_I(function2, textStyle, j11, function22, (Function2<? super Composer, ? super Integer, Unit>) null, function23, r82, r102, f11, paddingValues, composer, i16 | ((i17 << 18) & 234881024) | ((i17 << 18) & 1879048192));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
