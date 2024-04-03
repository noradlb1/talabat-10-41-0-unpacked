package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class DeserializedPackageFragmentImpl$initialize$1 extends Lambda implements Function0<Collection<? extends Name>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedPackageFragmentImpl f24829g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl$initialize$1(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        super(0);
        this.f24829g = deserializedPackageFragmentImpl;
    }

    @NotNull
    public final Collection<Name> invoke() {
        ArrayList<ClassId> arrayList = new ArrayList<>();
        for (Object next : this.f24829g.getClassDataFinder().getAllClassIds()) {
            ClassId classId = (ClassId) next;
            if (!classId.isNestedClass() && !ClassDeserializer.Companion.getBLACK_LIST().contains(classId)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (ClassId shortClassName : arrayList) {
            arrayList2.add(shortClassName.getShortClassName());
        }
        return arrayList2;
    }
}
