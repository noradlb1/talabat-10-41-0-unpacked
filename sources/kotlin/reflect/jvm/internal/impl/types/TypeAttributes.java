package kotlin.reflect.jvm.internal.impl.types;

import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.util.ArrayMap;
import kotlin.reflect.jvm.internal.impl.util.AttributeArrayOwner;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;

public final class TypeAttributes extends AttributeArrayOwner<TypeAttribute<?>, TypeAttribute<?>> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final TypeAttributes Empty = new TypeAttributes((List<? extends TypeAttribute<?>>) CollectionsKt__CollectionsKt.emptyList());

    public static final class Companion extends TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TypeAttributes create(@NotNull List<? extends TypeAttribute<?>> list) {
            Intrinsics.checkNotNullParameter(list, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
            if (list.isEmpty()) {
                return getEmpty();
            }
            return new TypeAttributes(list, (DefaultConstructorMarker) null);
        }

        public <T extends TypeAttribute<?>> int customComputeIfAbsent(@NotNull ConcurrentHashMap<KClass<? extends TypeAttribute<?>>, Integer> concurrentHashMap, @NotNull KClass<T> kClass, @NotNull Function1<? super KClass<? extends TypeAttribute<?>>, Integer> function1) {
            int intValue;
            Intrinsics.checkNotNullParameter(concurrentHashMap, "<this>");
            Intrinsics.checkNotNullParameter(kClass, "kClass");
            Intrinsics.checkNotNullParameter(function1, "compute");
            Integer num = concurrentHashMap.get(kClass);
            if (num != null) {
                return num.intValue();
            }
            synchronized (concurrentHashMap) {
                Integer num2 = concurrentHashMap.get(kClass);
                if (num2 == null) {
                    Integer invoke = function1.invoke(kClass);
                    concurrentHashMap.putIfAbsent(kClass, Integer.valueOf(invoke.intValue()));
                    num2 = invoke;
                }
                Intrinsics.checkNotNullExpressionValue(num2, "this[kClass] ?: compute(…putIfAbsent(kClass, it) }");
                intValue = num2.intValue();
            }
            return intValue;
        }

        @NotNull
        public final TypeAttributes getEmpty() {
            return TypeAttributes.Empty;
        }
    }

    private TypeAttributes(List<? extends TypeAttribute<?>> list) {
        for (TypeAttribute typeAttribute : list) {
            c(typeAttribute.getKey(), typeAttribute);
        }
    }

    public /* synthetic */ TypeAttributes(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this((List<? extends TypeAttribute<?>>) list);
    }

    @NotNull
    public final TypeAttributes add(@NotNull TypeAttributes typeAttributes) {
        TypeAttribute typeAttribute;
        Intrinsics.checkNotNullParameter(typeAttributes, "other");
        if (isEmpty() && typeAttributes.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        for (Number intValue : Companion.a()) {
            int intValue2 = intValue.intValue();
            TypeAttribute typeAttribute2 = (TypeAttribute) a().get(intValue2);
            TypeAttribute typeAttribute3 = (TypeAttribute) typeAttributes.a().get(intValue2);
            if (typeAttribute2 != null) {
                typeAttribute = typeAttribute2.add(typeAttribute3);
            } else if (typeAttribute3 != null) {
                typeAttribute = typeAttribute3.add(typeAttribute2);
            } else {
                typeAttribute = null;
            }
            CollectionsKt.addIfNotNull(arrayList, typeAttribute);
        }
        return Companion.create(arrayList);
    }

    @NotNull
    public TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> b() {
        return Companion;
    }

    public final boolean contains(@NotNull TypeAttribute<?> typeAttribute) {
        Intrinsics.checkNotNullParameter(typeAttribute, "attribute");
        if (a().get(Companion.getId(typeAttribute.getKey())) != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final TypeAttributes intersect(@NotNull TypeAttributes typeAttributes) {
        TypeAttribute typeAttribute;
        Intrinsics.checkNotNullParameter(typeAttributes, "other");
        if (isEmpty() && typeAttributes.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        for (Number intValue : Companion.a()) {
            int intValue2 = intValue.intValue();
            TypeAttribute typeAttribute2 = (TypeAttribute) a().get(intValue2);
            TypeAttribute typeAttribute3 = (TypeAttribute) typeAttributes.a().get(intValue2);
            if (typeAttribute2 != null) {
                typeAttribute = typeAttribute2.intersect(typeAttribute3);
            } else if (typeAttribute3 != null) {
                typeAttribute = typeAttribute3.intersect(typeAttribute2);
            } else {
                typeAttribute = null;
            }
            CollectionsKt.addIfNotNull(arrayList, typeAttribute);
        }
        return Companion.create(arrayList);
    }

    @NotNull
    public final TypeAttributes plus(@NotNull TypeAttribute<?> typeAttribute) {
        Intrinsics.checkNotNullParameter(typeAttribute, "attribute");
        if (contains(typeAttribute)) {
            return this;
        }
        if (isEmpty()) {
            return new TypeAttributes(typeAttribute);
        }
        return Companion.create(CollectionsKt___CollectionsKt.plus(CollectionsKt___CollectionsKt.toList(this), typeAttribute));
    }

    @NotNull
    public final TypeAttributes remove(@NotNull TypeAttribute<?> typeAttribute) {
        Intrinsics.checkNotNullParameter(typeAttribute, "attribute");
        if (isEmpty()) {
            return this;
        }
        ArrayMap a11 = a();
        ArrayList arrayList = new ArrayList();
        for (Object next : a11) {
            if (!Intrinsics.areEqual((Object) (TypeAttribute) next, (Object) typeAttribute)) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() == a().getSize()) {
            return this;
        }
        return Companion.create(arrayList);
    }

    private TypeAttributes(TypeAttribute<?> typeAttribute) {
        this((List<? extends TypeAttribute<?>>) CollectionsKt__CollectionsJVMKt.listOf(typeAttribute));
    }
}
