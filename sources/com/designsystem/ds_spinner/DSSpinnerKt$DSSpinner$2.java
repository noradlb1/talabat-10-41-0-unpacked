package com.designsystem.ds_spinner;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSpinnerKt$DSSpinner$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32775g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSSpinnerColor f32776h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DSSpinnerSize f32777i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32778j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32779k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSpinnerKt$DSSpinner$2(Modifier modifier, DSSpinnerColor dSSpinnerColor, DSSpinnerSize dSSpinnerSize, int i11, int i12) {
        super(2);
        this.f32775g = modifier;
        this.f32776h = dSSpinnerColor;
        this.f32777i = dSSpinnerSize;
        this.f32778j = i11;
        this.f32779k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSSpinnerKt.DSSpinner(this.f32775g, this.f32776h, this.f32777i, composer, this.f32778j | 1, this.f32779k);
    }
}
