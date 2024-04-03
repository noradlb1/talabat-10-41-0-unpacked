package com.deliveryhero.fluid.template;

import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0003¨\u0006\b"}, d2 = {"build", "", "Lcom/deliveryhero/fluid/template/Template;", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "config", "Lcom/deliveryhero/fluid/ParseConfig;", "toRequest", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource$Request;", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TemplateBuilderKt {
    @NotNull
    public static final List<Template> build(@NotNull List<TemplateBuilder> list, @NotNull ParseConfig parseConfig) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(parseConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Iterable<TemplateBuilder> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (TemplateBuilder build : iterable) {
            arrayList.add(build.build(parseConfig));
        }
        return arrayList;
    }

    @NotNull
    public static final ReadableTemplateSource.Request toRequest(@NotNull TemplateBuilder templateBuilder) {
        Intrinsics.checkNotNullParameter(templateBuilder, "<this>");
        return new ReadableTemplateSource.Request(templateBuilder.getId(), templateBuilder.getHash());
    }
}
