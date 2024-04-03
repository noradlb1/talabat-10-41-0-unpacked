package com.skydoves.landscapist;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class Shimmer__ShimmerKt$Shimmer$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f52981g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f52982h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f52983i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f52984j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f52985k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f52986l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f52987m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f52988n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f52989o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Shimmer__ShimmerKt$Shimmer$3(Modifier modifier, long j11, long j12, float f11, float f12, float f13, int i11, int i12, int i13) {
        super(2);
        this.f52981g = modifier;
        this.f52982h = j11;
        this.f52983i = j12;
        this.f52984j = f11;
        this.f52985k = f12;
        this.f52986l = f13;
        this.f52987m = i11;
        this.f52988n = i12;
        this.f52989o = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Shimmer.m9399ShimmerK2djEUw(this.f52981g, this.f52982h, this.f52983i, this.f52984j, this.f52985k, this.f52986l, this.f52987m, composer, this.f52988n | 1, this.f52989o);
    }
}
