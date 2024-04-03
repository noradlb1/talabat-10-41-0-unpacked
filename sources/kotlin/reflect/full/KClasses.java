package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\u001a+\u0010S\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010U\u001a!\u0010V\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u0002H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001c\u0010W\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010X\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a\u001c\u0010Y\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010Z\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a-\u0010[\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010U\",\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"(\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\"$\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013\",\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\",\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"B\u0010\u001b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\",\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\">\u0010#\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\",\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\"\u0010+\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010.\",\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u001c\u00102\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0004¢\u0006\u0006\u001a\u0004\b2\u00105\"\u001c\u00106\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0004¢\u0006\u0006\u001a\u0004\b6\u00105\",\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"B\u0010:\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006\",\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\">\u0010@\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006\"6\u0010C\u001a\n\u0012\u0004\u0012\u0002H\u001d\u0018\u00010\u0015\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0004¢\u0006\f\u0012\u0004\bD\u0010\u0004\u001a\u0004\bE\u0010F\",\u0010G\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\",\u0010J\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030K0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006\",\u0010N\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020O*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010R¨\u0006\\"}, d2 = {"allSuperclasses", "", "Lkotlin/reflect/KClass;", "getAllSuperclasses$annotations", "(Lkotlin/reflect/KClass;)V", "getAllSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "allSupertypes", "Lkotlin/reflect/KType;", "getAllSupertypes$annotations", "getAllSupertypes", "companionObject", "getCompanionObject$annotations", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "", "getCompanionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "declaredFunctions", "Lkotlin/reflect/KFunction;", "getDeclaredFunctions$annotations", "getDeclaredFunctions", "declaredMemberExtensionFunctions", "getDeclaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "declaredMemberExtensionProperties", "Lkotlin/reflect/KProperty2;", "T", "getDeclaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "declaredMemberFunctions", "getDeclaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberProperties", "Lkotlin/reflect/KProperty1;", "getDeclaredMemberProperties$annotations", "getDeclaredMemberProperties", "declaredMembers", "Lkotlin/reflect/KCallable;", "getDeclaredMembers$annotations", "getDeclaredMembers", "defaultType", "getDefaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "functions", "getFunctions$annotations", "getFunctions", "isExtension", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "memberExtensionFunctions", "getMemberExtensionFunctions$annotations", "getMemberExtensionFunctions", "memberExtensionProperties", "getMemberExtensionProperties$annotations", "getMemberExtensionProperties", "memberFunctions", "getMemberFunctions$annotations", "getMemberFunctions", "memberProperties", "getMemberProperties$annotations", "getMemberProperties", "primaryConstructor", "getPrimaryConstructor$annotations", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "staticFunctions", "getStaticFunctions$annotations", "getStaticFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "getStaticProperties$annotations", "getStaticProperties", "superclasses", "", "getSuperclasses$annotations", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "cast", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "createInstance", "isSubclassOf", "base", "isSuperclassOf", "derived", "safeCast", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "KClasses")
public final class KClasses {
    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T> T cast(@NotNull KClass<T> kClass, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        if (kClass.isInstance(obj)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.cast");
            return obj;
        }
        throw new TypeCastException("Value cannot be cast to " + kClass.getQualifiedName());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: kotlin.reflect.KFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: kotlin.reflect.KFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: kotlin.reflect.KFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.reflect.KFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: kotlin.reflect.KFunction} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @kotlin.SinceKotlin(version = "1.1")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T createInstance(@org.jetbrains.annotations.NotNull kotlin.reflect.KClass<T> r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.util.Collection r0 = r9.getConstructors()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = r2
        L_0x0013:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0055
            java.lang.Object r5 = r0.next()
            r6 = r5
            kotlin.reflect.KFunction r6 = (kotlin.reflect.KFunction) r6
            java.util.List r6 = r6.getParameters()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r7 = r6 instanceof java.util.Collection
            r8 = 1
            if (r7 == 0) goto L_0x0036
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x0036
        L_0x0034:
            r6 = r8
            goto L_0x004d
        L_0x0036:
            java.util.Iterator r6 = r6.iterator()
        L_0x003a:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0034
            java.lang.Object r7 = r6.next()
            kotlin.reflect.KParameter r7 = (kotlin.reflect.KParameter) r7
            boolean r7 = r7.isOptional()
            if (r7 != 0) goto L_0x003a
            r6 = r2
        L_0x004d:
            if (r6 == 0) goto L_0x0013
            if (r3 == 0) goto L_0x0052
            goto L_0x0059
        L_0x0052:
            r4 = r5
            r3 = r8
            goto L_0x0013
        L_0x0055:
            if (r3 != 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r1 = r4
        L_0x0059:
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            if (r1 == 0) goto L_0x0066
            java.util.Map r9 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            java.lang.Object r9 = r1.callBy(r9)
            return r9
        L_0x0066:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Class should have a single no-arg constructor: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.KClasses.createInstance(kotlin.reflect.KClass):java.lang.Object");
    }

    @NotNull
    public static final Collection<KClass<?>> getAllSuperclasses(@NotNull KClass<?> kClass) {
        KClass kClass2;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable<KType> allSupertypes = getAllSupertypes(kClass);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(allSupertypes, 10));
        for (KType kType : allSupertypes) {
            KClassifier classifier = kType.getClassifier();
            if (classifier instanceof KClass) {
                kClass2 = (KClass) classifier;
            } else {
                kClass2 = null;
            }
            if (kClass2 != null) {
                arrayList.add(kClass2);
            } else {
                throw new KotlinReflectionInternalError("Supertype not a class: " + kType);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getAllSuperclasses$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KType> getAllSupertypes(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Object dfs = DFS.dfs(kClass.getSupertypes(), KClasses$allSupertypes$1.INSTANCE, new DFS.VisitedWithSet(), new KClasses$allSupertypes$2());
        Intrinsics.checkNotNullExpressionValue(dfs, "dfs(\n        supertypes,…        }\n        }\n    )");
        return (Collection) dfs;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getAllSupertypes$annotations(KClass kClass) {
    }

    @Nullable
    public static final KClass<?> getCompanionObject(@NotNull KClass<?> kClass) {
        Object obj;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterator it = kClass.getNestedClasses().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            KClass kClass2 = (KClass) obj;
            Intrinsics.checkNotNull(kClass2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            if (((KClassImpl) kClass2).getDescriptor().isCompanionObject()) {
                break;
            }
        }
        return (KClass) obj;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getCompanionObject$annotations(KClass kClass) {
    }

    @Nullable
    public static final Object getCompanionObjectInstance(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KClass<?> companionObject = getCompanionObject(kClass);
        if (companionObject != null) {
            return companionObject.getObjectInstance();
        }
        return null;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getCompanionObjectInstance$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getDeclaredFunctions(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().invoke().getDeclaredMembers()) {
            if (next instanceof KFunction) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(@NotNull KClass<?> kClass) {
        boolean z11;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (!isExtension(kCallableImpl) || !(kCallableImpl instanceof KFunction)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberExtensionFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(@NotNull KClass<T> kClass) {
        boolean z11;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (!isExtension(kCallableImpl) || !(kCallableImpl instanceof KProperty2)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberExtensionProperties$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getDeclaredMemberFunctions(@NotNull KClass<?> kClass) {
        boolean z11;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (!isNotExtension(kCallableImpl) || !(kCallableImpl instanceof KFunction)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(@NotNull KClass<T> kClass) {
        boolean z11;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (!isNotExtension(kCallableImpl) || !(kCallableImpl instanceof KProperty1)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberProperties$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KCallable<?>> getDeclaredMembers(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return ((KClassImpl) kClass).getData().invoke().getDeclaredMembers();
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMembers$annotations(KClass kClass) {
    }

    @NotNull
    public static final KType getDefaultType(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        SimpleType defaultType = ((KClassImpl) kClass).getDescriptor().getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "this as KClassImpl<*>).descriptor.defaultType");
        return new KTypeImpl(defaultType, new KClasses$defaultType$1(kClass));
    }

    @Deprecated(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDefaultType$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getFunctions(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object next : kClass.getMembers()) {
            if (next instanceof KFunction) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getMemberExtensionFunctions(@NotNull KClass<?> kClass) {
        boolean z11;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (!isExtension(kCallableImpl) || !(kCallableImpl instanceof KFunction)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberExtensionFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(@NotNull KClass<T> kClass) {
        boolean z11;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (!isExtension(kCallableImpl) || !(kCallableImpl instanceof KProperty2)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberExtensionProperties$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getMemberFunctions(@NotNull KClass<?> kClass) {
        boolean z11;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (!isNotExtension(kCallableImpl) || !(kCallableImpl instanceof KFunction)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(@NotNull KClass<T> kClass) {
        boolean z11;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (!isNotExtension(kCallableImpl) || !(kCallableImpl instanceof KProperty1)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberProperties$annotations(KClass kClass) {
    }

    @Nullable
    public static final <T> KFunction<T> getPrimaryConstructor(@NotNull KClass<T> kClass) {
        Object obj;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterator it = ((KClassImpl) kClass).getConstructors().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            KFunction kFunction = (KFunction) obj;
            Intrinsics.checkNotNull(kFunction, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
            FunctionDescriptor descriptor = ((KFunctionImpl) kFunction).getDescriptor();
            Intrinsics.checkNotNull(descriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
            if (((ConstructorDescriptor) descriptor).isPrimary()) {
                break;
            }
        }
        return (KFunction) obj;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getPrimaryConstructor$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getStaticFunctions(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().invoke().getAllStaticMembers()) {
            if (next instanceof KFunction) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStaticFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KProperty0<?>> getStaticProperties(@NotNull KClass<?> kClass) {
        boolean z11;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().invoke().getAllStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (!isNotExtension(kCallableImpl) || !(kCallableImpl instanceof KProperty0)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStaticProperties$annotations(KClass kClass) {
    }

    @NotNull
    public static final List<KClass<?>> getSuperclasses(@NotNull KClass<?> kClass) {
        KClass kClass2;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        ArrayList arrayList = new ArrayList();
        for (KType classifier : kClass.getSupertypes()) {
            KClassifier classifier2 = classifier.getClassifier();
            if (classifier2 instanceof KClass) {
                kClass2 = (KClass) classifier2;
            } else {
                kClass2 = null;
            }
            if (kClass2 != null) {
                arrayList.add(kClass2);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getSuperclasses$annotations(KClass kClass) {
    }

    private static final boolean isExtension(KCallableImpl<?> kCallableImpl) {
        return kCallableImpl.getDescriptor().getExtensionReceiverParameter() != null;
    }

    private static final boolean isNotExtension(KCallableImpl<?> kCallableImpl) {
        return !isExtension(kCallableImpl);
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSubclassOf(@NotNull KClass<?> kClass, @NotNull KClass<?> kClass2) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(kClass2, TtmlNode.RUBY_BASE);
        if (!Intrinsics.areEqual((Object) kClass, (Object) kClass2)) {
            Boolean ifAny = DFS.ifAny(CollectionsKt__CollectionsJVMKt.listOf(kClass), new KClasses$sam$org_jetbrains_kotlin_utils_DFS_Neighbors$0(KClasses$isSubclassOf$1.INSTANCE), new KClasses$isSubclassOf$2(kClass2));
            Intrinsics.checkNotNullExpressionValue(ifAny, "base: KClass<*>): Boolea…erclasses) { it == base }");
            if (ifAny.booleanValue()) {
                return true;
            }
            return false;
        }
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSuperclassOf(@NotNull KClass<?> kClass, @NotNull KClass<?> kClass2) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(kClass2, "derived");
        return isSubclassOf(kClass2, kClass);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final <T> T safeCast(@NotNull KClass<T> kClass, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        if (!kClass.isInstance(obj)) {
            return null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.safeCast");
        return obj;
    }
}
