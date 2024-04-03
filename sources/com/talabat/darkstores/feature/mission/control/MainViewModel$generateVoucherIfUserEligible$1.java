package com.talabat.darkstores.feature.mission.control;

import com.talabat.darkstores.model.ToastModel;
import com.talabat.localization.R;
import com.talabat.wrapper.EventWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MainViewModel$generateVoucherIfUserEligible$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MainViewModel f56460g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainViewModel$generateVoucherIfUserEligible$1(MainViewModel mainViewModel) {
        super(1);
        this.f56460g = mainViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        this.f56460g._showToastMessage.postValue(new EventWrapper(new ToastModel(R.string.error_in_voucher_generation, Integer.valueOf(com.designsystem.marshmallow.R.drawable.ds_error))));
    }
}
