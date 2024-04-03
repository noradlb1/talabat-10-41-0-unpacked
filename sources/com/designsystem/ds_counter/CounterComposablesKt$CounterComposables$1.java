package com.designsystem.ds_counter;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CounterComposablesKt$CounterComposables$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f30997g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f30998h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f30999i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f31000j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f31001k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f31002l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ TextStyle f31003m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Shape f31004n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f31005o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f31006p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CounterComposablesKt$CounterComposables$1(Modifier modifier, int i11, long j11, long j12, float f11, float f12, TextStyle textStyle, Shape shape, int i12, int i13) {
        super(2);
        this.f30997g = modifier;
        this.f30998h = i11;
        this.f30999i = j11;
        this.f31000j = j12;
        this.f31001k = f11;
        this.f31002l = f12;
        this.f31003m = textStyle;
        this.f31004n = shape;
        this.f31005o = i12;
        this.f31006p = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CounterComposablesKt.m8319CounterComposablesT9BRK9s(this.f30997g, this.f30998h, this.f30999i, this.f31000j, this.f31001k, this.f31002l, this.f31003m, this.f31004n, composer, this.f31005o | 1, this.f31006p);
    }
}
