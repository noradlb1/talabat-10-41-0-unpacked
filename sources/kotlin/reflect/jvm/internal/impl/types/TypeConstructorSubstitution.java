package kotlin.reflect.jvm.internal.impl.types;

import com.huawei.hms.flutter.map.constants.Param;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class TypeConstructorSubstitution extends TypeSubstitution {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ TypeConstructorSubstitution createByConstructorsMap$default(Companion companion, Map map, boolean z11, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            return companion.createByConstructorsMap(map, z11);
        }

        @JvmStatic
        @NotNull
        public final TypeSubstitution create(@NotNull KotlinType kotlinType) {
            Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
            return create(kotlinType.getConstructor(), kotlinType.getArguments());
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> map) {
            Intrinsics.checkNotNullParameter(map, Param.MAP);
            return createByConstructorsMap$default(this, map, false, 2, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> map, boolean z11) {
            Intrinsics.checkNotNullParameter(map, Param.MAP);
            return new TypeConstructorSubstitution$Companion$createByConstructorsMap$1(map, z11);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0021, code lost:
            if (r2.isCapturedFromOuterDeclaration() == true) goto L_0x0025;
         */
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlin.reflect.jvm.internal.impl.types.TypeSubstitution create(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6, @org.jetbrains.annotations.NotNull java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> r7) {
            /*
                r5 = this;
                java.lang.String r0 = "typeConstructor"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "arguments"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.util.List r0 = r6.getParameters()
                java.lang.String r1 = "typeConstructor.parameters"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r0)
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r2
                r3 = 0
                if (r2 == 0) goto L_0x0024
                boolean r2 = r2.isCapturedFromOuterDeclaration()
                r4 = 1
                if (r2 != r4) goto L_0x0024
                goto L_0x0025
            L_0x0024:
                r4 = r3
            L_0x0025:
                if (r4 == 0) goto L_0x0066
                java.util.List r6 = r6.getParameters()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.ArrayList r0 = new java.util.ArrayList
                r1 = 10
                int r1 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r6, r1)
                r0.<init>(r1)
                java.util.Iterator r6 = r6.iterator()
            L_0x003f:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L_0x0053
                java.lang.Object r1 = r6.next()
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r1
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r1 = r1.getTypeConstructor()
                r0.add(r1)
                goto L_0x003f
            L_0x0053:
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.zip(r0, r7)
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.Map r6 = kotlin.collections.MapsKt__MapsKt.toMap(r6)
                r7 = 2
                r0 = 0
                kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution r6 = createByConstructorsMap$default(r5, r6, r3, r7, r0)
                return r6
            L_0x0066:
                kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution r6 = new kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution
                r6.<init>(r0, r7)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion.create(kotlin.reflect.jvm.internal.impl.types.TypeConstructor, java.util.List):kotlin.reflect.jvm.internal.impl.types.TypeSubstitution");
        }
    }

    @JvmStatic
    @NotNull
    public static final TypeSubstitution create(@NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list) {
        return Companion.create(typeConstructor, list);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> map) {
        return Companion.createByConstructorsMap(map);
    }

    @Nullable
    public TypeProjection get(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "key");
        return get(kotlinType.getConstructor());
    }

    @Nullable
    public abstract TypeProjection get(@NotNull TypeConstructor typeConstructor);
}
