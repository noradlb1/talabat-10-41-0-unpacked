package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.DeserializationStrategy;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "Tag", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TaggedDecoder$decodeSerializableElement$1 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TaggedDecoder<Tag> f26431g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DeserializationStrategy<T> f26432h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ T f26433i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaggedDecoder$decodeSerializableElement$1(TaggedDecoder<Tag> taggedDecoder, DeserializationStrategy<T> deserializationStrategy, T t11) {
        super(0);
        this.f26431g = taggedDecoder;
        this.f26432h = deserializationStrategy;
        this.f26433i = t11;
    }

    public final T invoke() {
        return this.f26431g.a(this.f26432h, this.f26433i);
    }
}
