package com.designsystem.ds_chip;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSMultiSelectionChip$Content$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSMultiSelectionChip f30931g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f30932h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSMultiSelectionChip$Content$1(DSMultiSelectionChip dSMultiSelectionChip, int i11) {
        super(2);
        this.f30931g = dSMultiSelectionChip;
        this.f30932h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f30931g.Content(composer, this.f30932h | 1);
    }
}
