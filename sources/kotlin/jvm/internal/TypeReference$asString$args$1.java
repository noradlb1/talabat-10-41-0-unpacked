package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KTypeProjection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/reflect/KTypeProjection;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TypeReference$asString$args$1 extends Lambda implements Function1<KTypeProjection, CharSequence> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TypeReference f23893g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeReference$asString$args$1(TypeReference typeReference) {
        super(1);
        this.f23893g = typeReference;
    }

    @NotNull
    public final CharSequence invoke(@NotNull KTypeProjection kTypeProjection) {
        Intrinsics.checkNotNullParameter(kTypeProjection, "it");
        return this.f23893g.asString(kTypeProjection);
    }
}
