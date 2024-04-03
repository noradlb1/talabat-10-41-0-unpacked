package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    @NotNull
    private final Map<Name, JavaRecordComponent> components;
    @NotNull
    private final Map<Name, JavaField> fields;
    @NotNull
    private final JavaClass jClass;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<JavaMember, Boolean> memberFilter;
    @NotNull
    private final Function1<JavaMethod, Boolean> methodFilter;
    @NotNull
    private final Map<Name, List<JavaMethod>> methods;

    public ClassDeclaredMemberIndex(@NotNull JavaClass javaClass, @NotNull Function1<? super JavaMember, Boolean> function1) {
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        Intrinsics.checkNotNullParameter(function1, "memberFilter");
        this.jClass = javaClass;
        this.memberFilter = function1;
        ClassDeclaredMemberIndex$methodFilter$1 classDeclaredMemberIndex$methodFilter$1 = new ClassDeclaredMemberIndex$methodFilter$1(this);
        this.methodFilter = classDeclaredMemberIndex$methodFilter$1;
        Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(javaClass.getMethods()), classDeclaredMemberIndex$methodFilter$1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : filter) {
            Name name2 = ((JavaMethod) next).getName();
            Object obj = linkedHashMap.get(name2);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name2, obj);
            }
            ((List) obj).add(next);
        }
        this.methods = linkedHashMap;
        Sequence filter2 = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object next2 : filter2) {
            linkedHashMap2.put(((JavaField) next2).getName(), next2);
        }
        this.fields = linkedHashMap2;
        Function1<JavaMember, Boolean> function12 = this.memberFilter;
        ArrayList arrayList = new ArrayList();
        for (Object next3 : this.jClass.getRecordComponents()) {
            if (function12.invoke(next3).booleanValue()) {
                arrayList.add(next3);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object next4 : arrayList) {
            linkedHashMap3.put(((JavaRecordComponent) next4).getName(), next4);
        }
        this.components = linkedHashMap3;
    }

    @Nullable
    public JavaField findFieldByName(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        return this.fields.get(name2);
    }

    @NotNull
    public Collection<JavaMethod> findMethodsByName(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        List list = this.methods.get(name2);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    @Nullable
    public JavaRecordComponent findRecordComponentByName(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        return this.components.get(name2);
    }

    @NotNull
    public Set<Name> getFieldNames() {
        Sequence<JavaField> filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaField name2 : filter) {
            linkedHashSet.add(name2.getName());
        }
        return linkedHashSet;
    }

    @NotNull
    public Set<Name> getMethodNames() {
        Sequence<JavaMethod> filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.jClass.getMethods()), this.methodFilter);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaMethod name2 : filter) {
            linkedHashSet.add(name2.getName());
        }
        return linkedHashSet;
    }

    @NotNull
    public Set<Name> getRecordComponentNames() {
        return this.components.keySet();
    }
}
