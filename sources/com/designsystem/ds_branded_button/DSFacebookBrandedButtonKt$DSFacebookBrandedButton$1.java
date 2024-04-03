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
public final class DSFacebookBrandedButtonKt$DSFacebookBrandedButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30659g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f30660h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f30661i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f30662j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30663k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30664l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f30665m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f30666n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSFacebookBrandedButtonKt$DSFacebookBrandedButton$1(String str, Modifier modifier, boolean z11, boolean z12, boolean z13, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f30659g = str;
        this.f30660h = modifier;
        this.f30661i = z11;
        this.f30662j = z12;
        this.f30663k = z13;
        this.f30664l = function0;
        this.f30665m = i11;
        this.f30666n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSFacebookBrandedButtonKt.DSFacebookBrandedButton(this.f30659g, this.f30660h, this.f30661i, this.f30662j, this.f30663k, this.f30664l, composer, this.f30665m | 1, this.f30666n);
    }
}
