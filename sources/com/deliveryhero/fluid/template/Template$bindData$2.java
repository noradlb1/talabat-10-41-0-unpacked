package com.deliveryhero.fluid.template;

import android.view.View;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.telemetry.log.ErrorTypes;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.log.LoggerKt;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class Template$bindData$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Host f30205g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ View f30206h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TemplateUiData f30207i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Template$bindData$2(Host host, View view, TemplateUiData templateUiData) {
        super(0);
        this.f30205g = host;
        this.f30206h = view;
        this.f30207i = templateUiData;
    }

    public final void invoke() {
        TemplateUiDataHolder templateUiDataHolder = this.f30205g.getTemplateDataHolders().get(this.f30206h);
        if (templateUiDataHolder != null) {
            templateUiDataHolder.setData(this.f30207i);
            return;
        }
        Logger logger = this.f30205g.getLogger();
        LoggerKt.error$default(logger, new NoSuchElementException("No data-holder found for UI: `" + this.f30206h + '`'), ErrorTypes.BINDING, (Map) null, 4, (Object) null);
    }
}
