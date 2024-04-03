package com.designsystem.ds_list_item_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSDividerKt$DSDivider$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31977g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f31978h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f31979i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f31980j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f31981k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSDividerKt$DSDivider$1(Modifier modifier, float f11, float f12, int i11, int i12) {
        super(2);
        this.f31977g = modifier;
        this.f31978h = f11;
        this.f31979i = f12;
        this.f31980j = i11;
        this.f31981k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSDividerKt.m8478DSDividerWMci_g0(this.f31977g, this.f31978h, this.f31979i, composer, this.f31980j | 1, this.f31981k);
    }
}
