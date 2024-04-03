package com.deliveryhero.fluid.content;

import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/deliveryhero/fluid/content/Content;", "TrackingModelT", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DefaultContentBuilder$build$1 extends Lambda implements Function0<Content> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DefaultContentBuilder<TrackingModelT> f30194g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ReadableTemplateSource f30195h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Map<String, Template> f30196i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultContentBuilder$build$1(DefaultContentBuilder<TrackingModelT> defaultContentBuilder, ReadableTemplateSource readableTemplateSource, Map<String, Template> map) {
        super(0);
        this.f30194g = defaultContentBuilder;
        this.f30195h = readableTemplateSource;
        this.f30196i = map;
    }

    @NotNull
    public final Content invoke() {
        return ContentBuilderUtilsKt.buildInternal(this.f30194g, this.f30195h.getParseConfig(), this.f30196i);
    }
}
