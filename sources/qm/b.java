package qm;

import com.talabat.feature.darkstorestooltip.DarkstoresTooltipRepositoryImpl;
import com.talabat.feature.darkstorestooltip.domain.model.TooltipKey;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresTooltipRepositoryImpl f62828b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TooltipKey f62829c;

    public /* synthetic */ b(DarkstoresTooltipRepositoryImpl darkstoresTooltipRepositoryImpl, TooltipKey tooltipKey) {
        this.f62828b = darkstoresTooltipRepositoryImpl;
        this.f62829c = tooltipKey;
    }

    public final Object call() {
        return DarkstoresTooltipRepositoryImpl.m10211wasTooltipAlreadyShown$lambda0(this.f62828b, this.f62829c);
    }
}
