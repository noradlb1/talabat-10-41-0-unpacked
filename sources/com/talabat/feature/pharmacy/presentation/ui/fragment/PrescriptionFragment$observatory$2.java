package com.talabat.feature.pharmacy.presentation.ui.fragment;

import com.talabat.feature.pharmacy.model.BannerData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class PrescriptionFragment$observatory$2 extends FunctionReferenceImpl implements Function1<BannerData, Unit> {
    public PrescriptionFragment$observatory$2(Object obj) {
        super(1, obj, PrescriptionFragment.class, "showNonActiveOrderBannerV2", "showNonActiveOrderBannerV2(Lcom/talabat/feature/pharmacy/model/BannerData;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BannerData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable BannerData bannerData) {
        ((PrescriptionFragment) this.receiver).showNonActiveOrderBannerV2(bannerData);
    }
}
