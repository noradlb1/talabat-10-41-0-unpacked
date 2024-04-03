package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.DeserializationStrategy;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "", "Tag", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TaggedDecoder$decodeNullableSerializableElement$1 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TaggedDecoder<Tag> f26428g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DeserializationStrategy<T> f26429h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ T f26430i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaggedDecoder$decodeNullableSerializableElement$1(TaggedDecoder<Tag> taggedDecoder, DeserializationStrategy<T> deserializationStrategy, T t11) {
        super(0);
        this.f26428g = taggedDecoder;
        this.f26429h = deserializationStrategy;
        this.f26430i = t11;
    }

    @Nullable
    public final T invoke() {
        if (this.f26428g.decodeNotNullMark()) {
            return this.f26428g.a(this.f26429h, this.f26430i);
        }
        return this.f26428g.decodeNull();
    }
}
