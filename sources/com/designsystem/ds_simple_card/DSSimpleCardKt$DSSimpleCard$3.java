package com.designsystem.ds_simple_card;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSimpleCardKt$DSSimpleCard$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32664g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f32665h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f32666i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f32667j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f32668k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Integer f32669l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ DSSimpleCardImageModel f32670m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32671n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f32672o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f32673p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f32674q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSimpleCardKt$DSSimpleCard$3(String str, Modifier modifier, long j11, String str2, long j12, Integer num, DSSimpleCardImageModel dSSimpleCardImageModel, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f32664g = str;
        this.f32665h = modifier;
        this.f32666i = j11;
        this.f32667j = str2;
        this.f32668k = j12;
        this.f32669l = num;
        this.f32670m = dSSimpleCardImageModel;
        this.f32671n = function0;
        this.f32672o = function2;
        this.f32673p = i11;
        this.f32674q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSSimpleCardKt.m8571DSSimpleCardbaIBcDA(this.f32664g, this.f32665h, this.f32666i, this.f32667j, this.f32668k, this.f32669l, this.f32670m, this.f32671n, this.f32672o, composer, this.f32673p | 1, this.f32674q);
    }
}
