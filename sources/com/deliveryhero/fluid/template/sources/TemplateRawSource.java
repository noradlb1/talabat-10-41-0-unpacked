package com.deliveryhero.fluid.template.sources;

import androidx.annotation.RawRes;
import com.deliveryhero.fluid.ParseConfig;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/fluid/template/sources/TemplateRawSource;", "Lcom/deliveryhero/fluid/template/sources/TemplateInputStreamSource;", "parseConfig", "Lcom/deliveryhero/fluid/ParseConfig;", "id", "", "(Lcom/deliveryhero/fluid/ParseConfig;I)V", "name", "", "getName", "()Ljava/lang/String;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateRawSource extends TemplateInputStreamSource {
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f30230name = "raw";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TemplateRawSource(@NotNull final ParseConfig parseConfig, @RawRes final int i11) {
        super(new Function0<InputStream>() {
            @NotNull
            public final InputStream invoke() {
                InputStream openRawResource = parseConfig.getContext().getResources().openRawResource(i11);
                Intrinsics.checkNotNullExpressionValue(openRawResource, "parseConfig.context.resources.openRawResource(id)");
                return openRawResource;
            }
        }, parseConfig);
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
    }

    @NotNull
    public String getName() {
        return this.f30230name;
    }
}
