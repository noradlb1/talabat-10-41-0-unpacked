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
public final class DSAppleBrandedButtonKt$DSAppleBrandedButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30611g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f30612h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f30613i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f30614j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30615k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30616l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f30617m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f30618n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAppleBrandedButtonKt$DSAppleBrandedButton$1(String str, Modifier modifier, boolean z11, boolean z12, boolean z13, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f30611g = str;
        this.f30612h = modifier;
        this.f30613i = z11;
        this.f30614j = z12;
        this.f30615k = z13;
        this.f30616l = function0;
        this.f30617m = i11;
        this.f30618n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSAppleBrandedButtonKt.DSAppleBrandedButton(this.f30611g, this.f30612h, this.f30613i, this.f30614j, this.f30615k, this.f30616l, composer, this.f30617m | 1, this.f30618n);
    }
}
