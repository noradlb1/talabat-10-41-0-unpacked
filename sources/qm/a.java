package qm;

import com.talabat.feature.darkstorestooltip.DarkstoresTooltipRepositoryImpl;
import com.talabat.feature.darkstorestooltip.domain.model.TooltipKey;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresTooltipRepositoryImpl f62825b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TooltipKey f62826c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f62827d;

    public /* synthetic */ a(DarkstoresTooltipRepositoryImpl darkstoresTooltipRepositoryImpl, TooltipKey tooltipKey, boolean z11) {
        this.f62825b = darkstoresTooltipRepositoryImpl;
        this.f62826c = tooltipKey;
        this.f62827d = z11;
    }

    public final Object call() {
        return DarkstoresTooltipRepositoryImpl.m10210setTooltipShown$lambda1(this.f62825b, this.f62826c, this.f62827d);
    }
}
