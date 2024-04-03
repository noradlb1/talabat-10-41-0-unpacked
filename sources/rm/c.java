package rm;

import com.talabat.feature.darkstorestooltip.presentation.TooltipViewController;
import io.reactivex.functions.Action;

public final /* synthetic */ class c implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TooltipViewController f62861b;

    public /* synthetic */ c(TooltipViewController tooltipViewController) {
        this.f62861b = tooltipViewController;
    }

    public final void run() {
        TooltipViewController.m10214setUpDismissOnTimeout$lambda1(this.f62861b);
    }
}
