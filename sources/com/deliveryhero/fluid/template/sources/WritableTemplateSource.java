package com.deliveryhero.fluid.template.sources;

import com.deliveryhero.fluid.template.TemplateBuilder;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005H&¨\u0006\t"}, d2 = {"Lcom/deliveryhero/fluid/template/sources/WritableTemplateSource;", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;", "write", "", "templates", "", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WritableTemplateSource extends ReadableTemplateSource {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static TemplateBuilder get(@NotNull WritableTemplateSource writableTemplateSource, @NotNull ReadableTemplateSource.Request request) throws Throwable {
            Intrinsics.checkNotNullParameter(request, "request");
            return ReadableTemplateSource.DefaultImpls.get(writableTemplateSource, request);
        }

        @NotNull
        public static String getDebugName(@NotNull WritableTemplateSource writableTemplateSource) {
            return ReadableTemplateSource.DefaultImpls.getDebugName(writableTemplateSource);
        }
    }

    void write(@NotNull Map<String, TemplateBuilder> map) throws Throwable;
}
