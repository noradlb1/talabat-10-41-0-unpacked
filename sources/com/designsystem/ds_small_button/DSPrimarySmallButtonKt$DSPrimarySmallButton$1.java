package com.designsystem.ds_small_button;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSPrimarySmallButtonKt$DSPrimarySmallButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32722g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f32723h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Integer f32724i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f32725j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f32726k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f32727l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32728m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32729n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f32730o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPrimarySmallButtonKt$DSPrimarySmallButton$1(String str, Modifier modifier, Integer num, boolean z11, boolean z12, boolean z13, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f32722g = str;
        this.f32723h = modifier;
        this.f32724i = num;
        this.f32725j = z11;
        this.f32726k = z12;
        this.f32727l = z13;
        this.f32728m = function0;
        this.f32729n = i11;
        this.f32730o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSPrimarySmallButtonKt.DSPrimarySmallButton(this.f32722g, this.f32723h, this.f32724i, this.f32725j, this.f32726k, this.f32727l, this.f32728m, composer, this.f32729n | 1, this.f32730o);
    }
}
