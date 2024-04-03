package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$InputFieldTrailingIcon$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f31665g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f31666h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31667i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f31668j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f31669k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31670l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f31671m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$InputFieldTrailingIcon$3(int i11, long j11, Function0<Unit> function0, boolean z11, boolean z12, int i12, int i13) {
        super(2);
        this.f31665g = i11;
        this.f31666h = j11;
        this.f31667i = function0;
        this.f31668j = z11;
        this.f31669k = z12;
        this.f31670l = i12;
        this.f31671m = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InputFieldCommonComposablesKt.m8414InputFieldTrailingIcon8V94_ZQ(this.f31665g, this.f31666h, this.f31667i, this.f31668j, this.f31669k, composer, this.f31670l | 1, this.f31671m);
    }
}
