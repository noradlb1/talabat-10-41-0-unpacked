package com.deliveryhero.fluid.template.sources;

import com.deliveryhero.fluid.ParseConfig;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/deliveryhero/fluid/template/sources/TemplateAssetsSource;", "Lcom/deliveryhero/fluid/template/sources/TemplateInputStreamSource;", "parseConfig", "Lcom/deliveryhero/fluid/ParseConfig;", "fileName", "", "(Lcom/deliveryhero/fluid/ParseConfig;Ljava/lang/String;)V", "name", "getName", "()Ljava/lang/String;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateAssetsSource extends TemplateInputStreamSource {
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f30217name = "assets";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TemplateAssetsSource(@NotNull final ParseConfig parseConfig, @NotNull final String str) {
        super(new Function0<InputStream>() {
            @NotNull
            public final InputStream invoke() {
                InputStream open = parseConfig.getContext().getAssets().open(str);
                Intrinsics.checkNotNullExpressionValue(open, "parseConfig.context.assets.open(fileName)");
                return open;
            }
        }, parseConfig);
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        Intrinsics.checkNotNullParameter(str, "fileName");
    }

    @NotNull
    public String getName() {
        return this.f30217name;
    }
}
