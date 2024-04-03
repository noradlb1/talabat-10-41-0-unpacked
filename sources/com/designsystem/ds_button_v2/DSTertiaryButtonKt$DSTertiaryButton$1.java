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
public final class DSTertiaryButtonKt$DSTertiaryButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30792g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f30793h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f30794i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f30795j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30796k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f30797l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30798m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f30799n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f30800o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTertiaryButtonKt$DSTertiaryButton$1(String str, Modifier modifier, String str2, Integer num, boolean z11, boolean z12, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f30792g = str;
        this.f30793h = modifier;
        this.f30794i = str2;
        this.f30795j = num;
        this.f30796k = z11;
        this.f30797l = z12;
        this.f30798m = function0;
        this.f30799n = i11;
        this.f30800o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSTertiaryButtonKt.DSTertiaryButton(this.f30792g, this.f30793h, this.f30794i, this.f30795j, this.f30796k, this.f30797l, this.f30798m, composer, this.f30799n | 1, this.f30800o);
    }
}
