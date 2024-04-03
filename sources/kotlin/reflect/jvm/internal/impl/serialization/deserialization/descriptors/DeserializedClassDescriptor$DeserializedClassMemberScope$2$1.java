package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class DeserializedClassDescriptor$DeserializedClassMemberScope$2$1 extends Lambda implements Function0<List<? extends Name>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<Name> f24867g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$DeserializedClassMemberScope$2$1(List<Name> list) {
        super(0);
        this.f24867g = list;
    }

    @NotNull
    public final List<Name> invoke() {
        return this.f24867g;
    }
}
