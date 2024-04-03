package rm;

import androidx.lifecycle.Observer;
import com.talabat.feature.darkstorestooltip.presentation.TooltipView;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TooltipView f62859a;

    public /* synthetic */ a(TooltipView tooltipView) {
        this.f62859a = tooltipView;
    }

    public final void onChanged(Object obj) {
        TooltipView.m10212initialize$lambda0(this.f62859a, (EventWrapper) obj);
    }
}
