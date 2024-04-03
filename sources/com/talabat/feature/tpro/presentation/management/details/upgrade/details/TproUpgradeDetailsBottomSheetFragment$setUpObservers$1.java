package com.talabat.feature.tpro.presentation.management.details.upgrade.details;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "upgradeResult", "Lorg/threeten/bp/LocalDateTime;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TproUpgradeDetailsBottomSheetFragment$setUpObservers$1 extends Lambda implements Function1<LocalDateTime, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TproUpgradeDetailsBottomSheetFragment f59324g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproUpgradeDetailsBottomSheetFragment$setUpObservers$1(TproUpgradeDetailsBottomSheetFragment tproUpgradeDetailsBottomSheetFragment) {
        super(1);
        this.f59324g = tproUpgradeDetailsBottomSheetFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LocalDateTime) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable LocalDateTime localDateTime) {
        Unit unit;
        this.f59324g.showProgresses(false);
        if (localDateTime != null) {
            this.f59324g.handleUpgradeSuccess(localDateTime);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.f59324g.handleUpgradeFailure();
        }
    }
}
