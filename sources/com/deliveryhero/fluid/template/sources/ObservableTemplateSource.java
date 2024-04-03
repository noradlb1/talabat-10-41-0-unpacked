package com.deliveryhero.fluid.template.sources;

import com.deliveryhero.fluid.template.TemplateBuilder;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JS\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000721\u0010\t\u001a-\u0012#\u0012!\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00040\nH&¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/fluid/template/sources/ObservableTemplateSource;", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;", "observe", "Lkotlin/Function0;", "", "Lcom/deliveryhero/fluid/utils/Cancellable;", "requests", "", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource$Request;", "observer", "Lkotlin/Function1;", "", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "Lkotlin/ParameterName;", "name", "templates", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ObservableTemplateSource extends ReadableTemplateSource {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static TemplateBuilder get(@NotNull ObservableTemplateSource observableTemplateSource, @NotNull ReadableTemplateSource.Request request) throws Throwable {
            Intrinsics.checkNotNullParameter(request, "request");
            return ReadableTemplateSource.DefaultImpls.get(observableTemplateSource, request);
        }

        @NotNull
        public static String getDebugName(@NotNull ObservableTemplateSource observableTemplateSource) {
            return ReadableTemplateSource.DefaultImpls.getDebugName(observableTemplateSource);
        }
    }

    @NotNull
    Function0<Unit> observe(@NotNull Set<ReadableTemplateSource.Request> set, @NotNull Function1<? super Map<String, TemplateBuilder>, Unit> function1);
}
