package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$InputFieldTrailingIconContainer$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f31672g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ OuterState f31673h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f31674i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31675j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f31676k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31677l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f31678m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$InputFieldTrailingIconContainer$2(Integer num, OuterState outerState, boolean z11, Function0<Unit> function0, boolean z12, int i11, int i12) {
        super(2);
        this.f31672g = num;
        this.f31673h = outerState;
        this.f31674i = z11;
        this.f31675j = function0;
        this.f31676k = z12;
        this.f31677l = i11;
        this.f31678m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InputFieldCommonComposablesKt.InputFieldTrailingIconContainer(this.f31672g, this.f31673h, this.f31674i, this.f31675j, this.f31676k, composer, this.f31677l | 1, this.f31678m);
    }
}
