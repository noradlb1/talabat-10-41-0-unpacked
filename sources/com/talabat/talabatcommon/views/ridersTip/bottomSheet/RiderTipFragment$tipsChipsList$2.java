package com.talabat.talabatcommon.views.ridersTip.bottomSheet;

import com.designsystem.ds_chip.DSSingleSelectionChip;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/designsystem/ds_chip/DSSingleSelectionChip;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RiderTipFragment$tipsChipsList$2 extends Lambda implements Function0<ArrayList<DSSingleSelectionChip>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RiderTipFragment f11742g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipFragment$tipsChipsList$2(RiderTipFragment riderTipFragment) {
        super(0);
        this.f11742g = riderTipFragment;
    }

    @NotNull
    public final ArrayList<DSSingleSelectionChip> invoke() {
        return this.f11742g.initTipsChipsList();
    }
}
