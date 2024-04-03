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
public final class PagerFactory$create$1$1$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TemplateUiData f30259g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Host f30260h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PagerWidget f30261i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagerFactory$create$1$1$2(TemplateUiData templateUiData, Host host, PagerWidget pagerWidget) {
        super(0);
        this.f30259g = templateUiData;
        this.f30260h = host;
        this.f30261i = pagerWidget;
    }

    public final void invoke() {
        if (this.f30259g != null) {
            this.f30260h.getInteractionListeners().getCollectionScroll().onScrollTo(this.f30261i.getLastVisiblePosition(), this.f30261i.getCells(), this.f30259g);
            return;
        }
        Logger logger = this.f30260h.getLogger();
        LogLevel logLevel = LogLevel.WARNING;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            Logger.log$default(logger, logger.getTag(), logLevel, "Impossible! Collection data was null when scroll occurred.", (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
    }
}
