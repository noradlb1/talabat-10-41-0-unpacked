package com.deliveryhero.fluid.widgets.collections.grid.horizontal;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.telemetry.log.ErrorTypes;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.log.LoggerKt;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.widgets.collections.grid.GridWidget;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HorizontalGridFactory$create$1$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TemplateUiData f30240g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GridWidget f30241h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Host f30242i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalGridFactory$create$1$1$1(TemplateUiData templateUiData, GridWidget gridWidget, Host host) {
        super(0);
        this.f30240g = templateUiData;
        this.f30241h = gridWidget;
        this.f30242i = host;
    }

    public final void invoke() {
        if (this.f30240g == null || this.f30241h.getLastVisiblePosition() < 0) {
            Logger logger = this.f30242i.getLogger();
            ErrorTypes errorTypes = ErrorTypes.COLLECTION_SCROLL;
            LoggerKt.error(logger, new IllegalStateException(errorTypes.getMessage()), errorTypes, MapsKt__MapsKt.mapOf(TuplesKt.to("data", this.f30240g), TuplesKt.to("last_visible_position", Integer.valueOf(this.f30241h.getLastVisiblePosition()))));
            return;
        }
        this.f30242i.getInteractionListeners().getCollectionScroll().onScrollTo(this.f30241h.getLastVisiblePosition(), this.f30241h.getCells(), this.f30240g);
    }
}
