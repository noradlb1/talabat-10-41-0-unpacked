package com.designsystem.ds_stepper;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.designsystem.DSConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSQuantityStepperKt$DSQuantityStepper$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f32807g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f32808h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32809i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32810j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32811k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f32812l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f32813m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f32814n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f32815o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f32816p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSQuantityStepperKt$DSQuantityStepper$1(boolean z11, Modifier modifier, int i11, int i12, int i13, Function1<? super Integer, Unit> function1, boolean z12, boolean z13, boolean z14, int i14) {
        super(2);
        this.f32807g = z11;
        this.f32808h = modifier;
        this.f32809i = i11;
        this.f32810j = i12;
        this.f32811k = i13;
        this.f32812l = function1;
        this.f32813m = z12;
        this.f32814n = z13;
        this.f32815o = z14;
        this.f32816p = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        boolean z11;
        Composer composer2;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            if (this.f32807g || DSConfiguration.Companion.getInstance().getQuantityStepperM2Enabled()) {
                z11 = true;
                composer2 = composer;
            } else {
                composer2 = composer;
                z11 = false;
            }
            DSStepperStyle stepperStyle = StepperStyleKt.getStepperStyle(z11, composer2, 0);
            Modifier modifier = this.f32808h;
            int i12 = this.f32809i;
            int i13 = this.f32810j;
            int i14 = this.f32811k;
            Function1<Integer, Unit> function1 = this.f32812l;
            boolean z12 = this.f32813m;
            boolean z13 = this.f32814n;
            boolean z14 = this.f32815o;
            int i15 = this.f32816p;
            StepperComposablesKt.Stepper(modifier, i12, i13, i14, function1, z12, (Alignment.Horizontal) null, false, z13, z14, stepperStyle, z11, composer, (i15 & 896) | (i15 & 14) | 12582912 | (i15 & 112) | (i15 & 7168) | (57344 & i15) | (458752 & i15) | ((i15 << 3) & 234881024) | ((i15 << 3) & 1879048192), 0, 64);
            return;
        }
        composer.skipToGroupEnd();
    }
}
