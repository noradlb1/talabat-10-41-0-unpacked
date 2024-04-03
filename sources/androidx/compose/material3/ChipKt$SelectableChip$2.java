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
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ChipKt$SelectableChip$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SelectableChipColors f6908g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f6909h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f6910i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6911j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f6912k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6913l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6914m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6915n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6916o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6917p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ float f6918q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6919r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$SelectableChip$2(SelectableChipColors selectableChipColors, boolean z11, boolean z12, int i11, int i12, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, float f11, PaddingValues paddingValues) {
        super(2);
        this.f6908g = selectableChipColors;
        this.f6909h = z11;
        this.f6910i = z12;
        this.f6911j = i11;
        this.f6912k = i12;
        this.f6913l = function2;
        this.f6914m = textStyle;
        this.f6915n = function22;
        this.f6916o = function23;
        this.f6917p = function24;
        this.f6918q = f11;
        this.f6919r = paddingValues;
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
                ComposerKt.traceEventStart(-577614814, i12, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:1385)");
            }
            SelectableChipColors selectableChipColors = this.f6908g;
            boolean z11 = this.f6909h;
            boolean z12 = this.f6910i;
            int i13 = this.f6911j;
            long r32 = selectableChipColors.labelColor$material3_release(z11, z12, composer2, ((i13 << 3) & 112) | ((i13 >> 9) & 14) | ((this.f6912k << 6) & 896)).getValue().m2929unboximpl();
            SelectableChipColors selectableChipColors2 = this.f6908g;
            boolean z13 = this.f6909h;
            boolean z14 = this.f6910i;
            int i14 = this.f6911j;
            long r82 = selectableChipColors2.leadingIconContentColor$material3_release(z13, z14, composer2, ((i14 << 3) & 112) | ((i14 >> 9) & 14) | ((this.f6912k << 6) & 896)).getValue().m2929unboximpl();
            SelectableChipColors selectableChipColors3 = this.f6908g;
            boolean z15 = this.f6909h;
            boolean z16 = this.f6910i;
            int i15 = this.f6911j;
            long r102 = selectableChipColors3.trailingIconContentColor$material3_release(z15, z16, composer2, ((i15 << 3) & 112) | ((i15 >> 9) & 14) | ((this.f6912k << 6) & 896)).getValue().m2929unboximpl();
            Function2<Composer, Integer, Unit> function2 = this.f6913l;
            TextStyle textStyle = this.f6914m;
            Function2<Composer, Integer, Unit> function22 = this.f6915n;
            Function2<Composer, Integer, Unit> function23 = this.f6916o;
            Function2<Composer, Integer, Unit> function24 = this.f6917p;
            float f11 = this.f6918q;
            PaddingValues paddingValues = this.f6919r;
            int i16 = this.f6911j;
            int i17 = ((i16 >> 12) & 14) | ((i16 >> 12) & 112) | ((i16 >> 9) & 7168) | ((i16 >> 9) & 57344) | ((i16 >> 9) & Opcodes.ASM7);
            int i18 = this.f6912k;
            ChipKt.m1541ChipContentfe0OD_I(function2, textStyle, r32, function22, function23, function24, r82, r102, f11, paddingValues, composer, ((i18 << 15) & 1879048192) | i17 | ((i18 << 15) & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
