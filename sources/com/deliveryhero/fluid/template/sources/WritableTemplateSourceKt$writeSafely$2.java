package com.deliveryhero.fluid.template.sources;

import com.deliveryhero.fluid.template.TemplateBuilder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WritableTemplateSourceKt$writeSafely$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WritableTemplateSource f30233g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Map<String, TemplateBuilder> f30234h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WritableTemplateSourceKt$writeSafely$2(WritableTemplateSource writableTemplateSource, Map<String, TemplateBuilder> map) {
        super(0);
        this.f30233g = writableTemplateSource;
        this.f30234h = map;
    }

    public final void invoke() {
        this.f30233g.write(this.f30234h);
    }
}
