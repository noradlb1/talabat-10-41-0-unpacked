package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClassifier;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KTypeImpl$classifier$2 extends Lambda implements Function0<KClassifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KTypeImpl f24439g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KTypeImpl$classifier$2(KTypeImpl kTypeImpl) {
        super(0);
        this.f24439g = kTypeImpl;
    }

    @Nullable
    public final KClassifier invoke() {
        KTypeImpl kTypeImpl = this.f24439g;
        return kTypeImpl.convert(kTypeImpl.getType());
    }
}
