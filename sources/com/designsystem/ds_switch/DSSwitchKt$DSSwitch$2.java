package com.designsystem.ds_switch;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSwitchKt$DSSwitch$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f33033g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f33034h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f33035i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f33036j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f33037k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f33038l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSwitchKt$DSSwitch$2(Modifier modifier, boolean z11, boolean z12, Function1<? super Boolean, Unit> function1, int i11, int i12) {
        super(2);
        this.f33033g = modifier;
        this.f33034h = z11;
        this.f33035i = z12;
        this.f33036j = function1;
        this.f33037k = i11;
        this.f33038l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSSwitchKt.DSSwitch(this.f33033g, this.f33034h, this.f33035i, this.f33036j, composer, this.f33037k | 1, this.f33038l);
    }
}
