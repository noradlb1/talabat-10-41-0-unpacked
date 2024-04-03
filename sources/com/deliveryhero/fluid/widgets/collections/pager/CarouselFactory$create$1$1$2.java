package com.deliveryhero.fluid.widgets.collections.pager;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CarouselFactory$create$1$1$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TemplateUiData f30249g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Host f30250h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CarouselWidget f30251i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselFactory$create$1$1$2(TemplateUiData templateUiData, Host host, CarouselWidget carouselWidget) {
        super(0);
        this.f30249g = templateUiData;
        this.f30250h = host;
        this.f30251i = carouselWidget;
    }

    public final void invoke() {
        if (this.f30249g != null) {
            this.f30250h.getInteractionListeners().getCollectionScroll().onScrollTo(this.f30251i.getLastVisiblePosition(), this.f30251i.getCells(), this.f30249g);
            return;
        }
        Logger logger = this.f30250h.getLogger();
        LogLevel logLevel = LogLevel.WARNING;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            Logger.log$default(logger, logger.getTag(), logLevel, "Impossible! Collection data was null when scroll occurred.", (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
    }
}
