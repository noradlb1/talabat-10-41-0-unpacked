package com.designsystem.ds_chip;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSMultiSelectionChipKt$DSMultiSelectionChip$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30945g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f30946h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Integer f30947i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f30948j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f30949k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30950l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f30951m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f30952n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSMultiSelectionChipKt$DSMultiSelectionChip$3(String str, Modifier modifier, Integer num, Integer num2, int i11, Function0<Unit> function0, int i12, int i13) {
        super(2);
        this.f30945g = str;
        this.f30946h = modifier;
        this.f30947i = num;
        this.f30948j = num2;
        this.f30949k = i11;
        this.f30950l = function0;
        this.f30951m = i12;
        this.f30952n = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSMultiSelectionChipKt.DSMultiSelectionChip(this.f30945g, this.f30946h, this.f30947i, this.f30948j, this.f30949k, this.f30950l, composer, this.f30951m | 1, this.f30952n);
    }
}
