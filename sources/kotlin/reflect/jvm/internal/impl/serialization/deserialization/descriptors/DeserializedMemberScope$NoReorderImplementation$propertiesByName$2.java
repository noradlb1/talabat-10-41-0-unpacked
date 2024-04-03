package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;

public final class DeserializedMemberScope$NoReorderImplementation$propertiesByName$2 extends Lambda implements Function0<Map<Name, ? extends List<? extends PropertyDescriptor>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedMemberScope.NoReorderImplementation f24897g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$NoReorderImplementation$propertiesByName$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.f24897g = noReorderImplementation;
    }

    @NotNull
    public final Map<Name, List<PropertyDescriptor>> invoke() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : this.f24897g.getAllProperties()) {
            Name name2 = ((PropertyDescriptor) next).getName();
            Intrinsics.checkNotNullExpressionValue(name2, "it.name");
            Object obj = linkedHashMap.get(name2);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name2, obj);
            }
            ((List) obj).add(next);
        }
        return linkedHashMap;
    }
}
