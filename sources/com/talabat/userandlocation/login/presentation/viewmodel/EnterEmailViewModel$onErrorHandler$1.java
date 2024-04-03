package com.talabat.userandlocation.login.presentation.viewmodel;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnterEmailViewModel$onErrorHandler$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ EnterEmailViewModel f12383g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterEmailViewModel$onErrorHandler$1(EnterEmailViewModel enterEmailViewModel) {
        super(1);
        this.f12383g = enterEmailViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        IObservabilityManager access$getObservabilityManager$p = this.f12383g.observabilityManager;
        Pair[] pairArr = new Pair[1];
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        pairArr[0] = TuplesKt.to("errorMessage", message);
        access$getObservabilityManager$p.trackUnExpectedScenario("EnterEmailViewModelErrors", MapsKt__MapsKt.mutableMapOf(pairArr));
        LogManager.logException(th2);
        this.f12383g._showProgressDialog.postValue(Boolean.FALSE);
    }
}
