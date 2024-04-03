package com.designsystem.ds_branded_button;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSGoogleBrandedButtonKt$DSGoogleBrandedButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30669g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f30670h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f30671i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f30672j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30673k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30674l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f30675m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f30676n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSGoogleBrandedButtonKt$DSGoogleBrandedButton$1(String str, Modifier modifier, boolean z11, boolean z12, boolean z13, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f30669g = str;
        this.f30670h = modifier;
        this.f30671i = z11;
        this.f30672j = z12;
        this.f30673k = z13;
        this.f30674l = function0;
        this.f30675m = i11;
        this.f30676n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSGoogleBrandedButtonKt.DSGoogleBrandedButton(this.f30669g, this.f30670h, this.f30671i, this.f30672j, this.f30673k, this.f30674l, composer, this.f30675m | 1, this.f30676n);
    }
}
