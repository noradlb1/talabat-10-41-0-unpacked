package com.designsystem.ds_stepper;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import com.designsystem.ds_theme.DSTheme;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperComposablesKt$CollapsedStepperBackground$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MM2Properties f32829g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSStepperStyle f32830h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32831i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperComposablesKt$CollapsedStepperBackground$2(MM2Properties mM2Properties, DSStepperStyle dSStepperStyle, int i11) {
        super(2);
        this.f32829g = mM2Properties;
        this.f32830h = dSStepperStyle;
        this.f32831i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            int i12 = R.drawable.ds_plus;
            DSTheme dSTheme = DSTheme.INSTANCE;
            StepperComposablesKt.m8604StepperIconArea1yyLQnY(i12, true, dSTheme.getDimens(composer, 0).m8846getDsXxsD9Ej5fM(), dSTheme.getDimens(composer, 0).m8846getDsXxsD9Ej5fM(), this.f32829g.isClickable(), this.f32829g.isMM2(), this.f32830h, composer, ((this.f32831i << 15) & 3670016) | 48);
            return;
        }
        composer.skipToGroupEnd();
    }
}
