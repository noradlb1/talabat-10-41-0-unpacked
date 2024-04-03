package com.designsystem.ds_stepper;

import android.view.View;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperComposablesKt$TappableArea$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f32989g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32990h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32991i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32992j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32993k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperComposablesKt$TappableArea$3(View view, String str, boolean z11, Function0<Unit> function0, int i11) {
        super(2);
        this.f32989g = view;
        this.f32990h = str;
        this.f32991i = z11;
        this.f32992j = function0;
        this.f32993k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        StepperComposablesKt.TappableArea(this.f32989g, this.f32990h, this.f32991i, this.f32992j, composer, this.f32993k | 1);
    }
}
