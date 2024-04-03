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
public final class DSDestructiveSmallButtonKt$DSDestructiveSmallButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32711g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f32712h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Integer f32713i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f32714j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f32715k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f32716l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32717m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32718n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f32719o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSDestructiveSmallButtonKt$DSDestructiveSmallButton$1(String str, Modifier modifier, Integer num, boolean z11, boolean z12, boolean z13, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f32711g = str;
        this.f32712h = modifier;
        this.f32713i = num;
        this.f32714j = z11;
        this.f32715k = z12;
        this.f32716l = z13;
        this.f32717m = function0;
        this.f32718n = i11;
        this.f32719o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSDestructiveSmallButtonKt.DSDestructiveSmallButton(this.f32711g, this.f32712h, this.f32713i, this.f32714j, this.f32715k, this.f32716l, this.f32717m, composer, this.f32718n | 1, this.f32719o);
    }
}
