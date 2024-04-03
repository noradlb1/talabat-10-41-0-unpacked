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
public final class DSSingleSelectionChipKt$DSSingleSelectionChip$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30967g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f30968h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Integer f30969i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f30970j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30971k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30972l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f30973m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f30974n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSingleSelectionChipKt$DSSingleSelectionChip$3(String str, Modifier modifier, Integer num, Integer num2, boolean z11, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f30967g = str;
        this.f30968h = modifier;
        this.f30969i = num;
        this.f30970j = num2;
        this.f30971k = z11;
        this.f30972l = function0;
        this.f30973m = i11;
        this.f30974n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSSingleSelectionChipKt.DSSingleSelectionChip(this.f30967g, this.f30968h, this.f30969i, this.f30970j, this.f30971k, this.f30972l, composer, this.f30973m | 1, this.f30974n);
    }
}
