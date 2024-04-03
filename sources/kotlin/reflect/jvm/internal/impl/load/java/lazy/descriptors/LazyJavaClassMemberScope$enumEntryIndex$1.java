package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaClassMemberScope$enumEntryIndex$1 extends Lambda implements Function0<Map<Name, ? extends JavaField>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaClassMemberScope f24613g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$enumEntryIndex$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(0);
        this.f24613g = lazyJavaClassMemberScope;
    }

    @NotNull
    public final Map<Name, JavaField> invoke() {
        ArrayList arrayList = new ArrayList();
        for (Object next : this.f24613g.jClass.getFields()) {
            if (((JavaField) next).isEnumEntry()) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object next2 : arrayList) {
            linkedHashMap.put(((JavaField) next2).getName(), next2);
        }
        return linkedHashMap;
    }
}
