package com.designsystem.ds_radio_button;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSRadioButtonKt$DSRadioButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32547g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32548h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32549i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32550j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32551k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSRadioButtonKt$DSRadioButton$1(Modifier modifier, boolean z11, boolean z12, Function0<Unit> function0, int i11) {
        super(2);
        this.f32547g = modifier;
        this.f32548h = z11;
        this.f32549i = z12;
        this.f32550j = function0;
        this.f32551k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f32547g;
            boolean z11 = this.f32548h;
            boolean z12 = this.f32549i;
            Function0<Unit> function0 = this.f32550j;
            int i12 = this.f32551k;
            RadioButtonComposablesKt.SelectableRadioButton(modifier, z11, z12, function0, composer, (i12 & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168));
            return;
        }
        composer.skipToGroupEnd();
    }
}
