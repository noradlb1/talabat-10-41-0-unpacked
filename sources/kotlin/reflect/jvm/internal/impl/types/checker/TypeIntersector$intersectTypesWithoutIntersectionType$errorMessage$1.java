package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Set<SimpleType> f24971g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(Set<? extends SimpleType> set) {
        super(0);
        this.f24971g = set;
    }

    @NotNull
    public final String invoke() {
        return "This collections cannot be empty! input types: " + CollectionsKt___CollectionsKt.joinToString$default(this.f24971g, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
    }
}
