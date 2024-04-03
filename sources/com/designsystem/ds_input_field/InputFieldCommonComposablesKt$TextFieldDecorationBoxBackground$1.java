package com.designsystem.ds_input_field;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$TextFieldDecorationBoxBackground$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OuterState f31714g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ContainerState f31715h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f31716i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f31717j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31718k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f31719l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f31720m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f31721n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$TextFieldDecorationBoxBackground$1(OuterState outerState, ContainerState containerState, boolean z11, float f11, Function0<Unit> function0, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f31714g = outerState;
        this.f31715h = containerState;
        this.f31716i = z11;
        this.f31717j = f11;
        this.f31718k = function0;
        this.f31719l = function3;
        this.f31720m = i11;
        this.f31721n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InputFieldCommonComposablesKt.m8426TextFieldDecorationBoxBackgroundjIwJxvA(this.f31714g, this.f31715h, this.f31716i, this.f31717j, this.f31718k, this.f31719l, composer, this.f31720m | 1, this.f31721n);
    }
}
