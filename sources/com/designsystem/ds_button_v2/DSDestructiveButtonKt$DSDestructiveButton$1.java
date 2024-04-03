package com.designsystem.ds_button_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSDestructiveButtonKt$DSDestructiveButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30725g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f30726h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f30727i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f30728j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30729k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f30730l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f30731m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30732n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f30733o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f30734p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSDestructiveButtonKt$DSDestructiveButton$1(String str, Modifier modifier, String str2, Integer num, boolean z11, boolean z12, boolean z13, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f30725g = str;
        this.f30726h = modifier;
        this.f30727i = str2;
        this.f30728j = num;
        this.f30729k = z11;
        this.f30730l = z12;
        this.f30731m = z13;
        this.f30732n = function0;
        this.f30733o = i11;
        this.f30734p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSDestructiveButtonKt.DSDestructiveButton(this.f30725g, this.f30726h, this.f30727i, this.f30728j, this.f30729k, this.f30730l, this.f30731m, this.f30732n, composer, this.f30733o | 1, this.f30734p);
    }
}
