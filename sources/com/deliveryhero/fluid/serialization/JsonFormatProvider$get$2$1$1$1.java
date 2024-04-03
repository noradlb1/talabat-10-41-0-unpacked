package com.deliveryhero.fluid.serialization;

import com.deliveryhero.fluid.content.ContentBuilder;
import com.deliveryhero.fluid.content.DefaultContentBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlinx/serialization/DeserializationStrategy;", "Lcom/deliveryhero/fluid/content/ContentBuilder;", "TrackingModelT", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class JsonFormatProvider$get$2$1$1$1 extends Lambda implements Function1<String, DeserializationStrategy<? extends ContentBuilder<?>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KSerializer<TrackingModelT> f30202g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonFormatProvider$get$2$1$1$1(KSerializer<TrackingModelT> kSerializer) {
        super(1);
        this.f30202g = kSerializer;
    }

    @Nullable
    public final DeserializationStrategy<? extends ContentBuilder<?>> invoke(@Nullable String str) {
        return DefaultContentBuilder.Companion.serializer(this.f30202g);
    }
}
