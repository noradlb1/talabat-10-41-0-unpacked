package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class DescriptorKindFilter {
    @NotNull
    @JvmField
    public static final DescriptorKindFilter ALL;
    /* access modifiers changed from: private */
    public static final int ALL_KINDS_MASK;
    @NotNull
    @JvmField
    public static final DescriptorKindFilter CALLABLES;
    private static final int CALLABLES_MASK;
    @NotNull
    @JvmField
    public static final DescriptorKindFilter CLASSIFIERS;
    /* access modifiers changed from: private */
    public static final int CLASSIFIERS_MASK;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final List<Companion.MaskToName> DEBUG_MASK_BIT_NAMES;
    @NotNull
    private static final List<Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES;
    @NotNull
    @JvmField
    public static final DescriptorKindFilter FUNCTIONS;
    /* access modifiers changed from: private */
    public static final int FUNCTIONS_MASK;
    @NotNull
    @JvmField
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS;
    /* access modifiers changed from: private */
    public static final int NON_SINGLETON_CLASSIFIERS_MASK;
    @NotNull
    @JvmField
    public static final DescriptorKindFilter PACKAGES;
    /* access modifiers changed from: private */
    public static final int PACKAGES_MASK;
    @NotNull
    @JvmField
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS;
    /* access modifiers changed from: private */
    public static final int SINGLETON_CLASSIFIERS_MASK;
    @NotNull
    @JvmField
    public static final DescriptorKindFilter TYPE_ALIASES;
    /* access modifiers changed from: private */
    public static final int TYPE_ALIASES_MASK;
    @NotNull
    @JvmField
    public static final DescriptorKindFilter VALUES;
    private static final int VALUES_MASK;
    @NotNull
    @JvmField
    public static final DescriptorKindFilter VARIABLES;
    /* access modifiers changed from: private */
    public static final int VARIABLES_MASK;
    /* access modifiers changed from: private */
    public static int nextMaskValue = 1;
    @NotNull
    private final List<DescriptorKindExclude> excludes;
    private final int kindMask;

    public static final class Companion {

        public static final class MaskToName {
            private final int mask;
            @NotNull

            /* renamed from: name  reason: collision with root package name */
            private final String f24812name;

            public MaskToName(int i11, @NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "name");
                this.mask = i11;
                this.f24812name = str;
            }

            public final int getMask() {
                return this.mask;
            }

            @NotNull
            public final String getName() {
                return this.f24812name;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final int nextMask() {
            int access$getNextMaskValue$cp = DescriptorKindFilter.nextMaskValue;
            DescriptorKindFilter.nextMaskValue = DescriptorKindFilter.nextMaskValue << 1;
            return access$getNextMaskValue$cp;
        }

        public final int getALL_KINDS_MASK() {
            return DescriptorKindFilter.ALL_KINDS_MASK;
        }

        public final int getCLASSIFIERS_MASK() {
            return DescriptorKindFilter.CLASSIFIERS_MASK;
        }

        public final int getFUNCTIONS_MASK() {
            return DescriptorKindFilter.FUNCTIONS_MASK;
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.NON_SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getPACKAGES_MASK() {
            return DescriptorKindFilter.PACKAGES_MASK;
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getTYPE_ALIASES_MASK() {
            return DescriptorKindFilter.TYPE_ALIASES_MASK;
        }

        public final int getVARIABLES_MASK() {
            return DescriptorKindFilter.VARIABLES_MASK;
        }
    }

    static {
        boolean z11;
        Companion.MaskToName maskToName;
        DescriptorKindFilter descriptorKindFilter;
        Companion.MaskToName maskToName2;
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        int access$nextMask = companion.nextMask();
        NON_SINGLETON_CLASSIFIERS_MASK = access$nextMask;
        int access$nextMask2 = companion.nextMask();
        SINGLETON_CLASSIFIERS_MASK = access$nextMask2;
        int access$nextMask3 = companion.nextMask();
        TYPE_ALIASES_MASK = access$nextMask3;
        int access$nextMask4 = companion.nextMask();
        PACKAGES_MASK = access$nextMask4;
        int access$nextMask5 = companion.nextMask();
        FUNCTIONS_MASK = access$nextMask5;
        int access$nextMask6 = companion.nextMask();
        VARIABLES_MASK = access$nextMask6;
        int access$nextMask7 = companion.nextMask() - 1;
        ALL_KINDS_MASK = access$nextMask7;
        int i11 = access$nextMask | access$nextMask2 | access$nextMask3;
        CLASSIFIERS_MASK = i11;
        int i12 = access$nextMask2 | access$nextMask5 | access$nextMask6;
        VALUES_MASK = i12;
        int i13 = access$nextMask5 | access$nextMask6;
        CALLABLES_MASK = i13;
        ALL = new DescriptorKindFilter(access$nextMask7, (List) null, 2, (DefaultConstructorMarker) null);
        CALLABLES = new DescriptorKindFilter(i13, (List) null, 2, (DefaultConstructorMarker) null);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(access$nextMask, (List) null, 2, (DefaultConstructorMarker) null);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(access$nextMask2, (List) null, 2, (DefaultConstructorMarker) null);
        TYPE_ALIASES = new DescriptorKindFilter(access$nextMask3, (List) null, 2, (DefaultConstructorMarker) null);
        CLASSIFIERS = new DescriptorKindFilter(i11, (List) null, 2, (DefaultConstructorMarker) null);
        PACKAGES = new DescriptorKindFilter(access$nextMask4, (List) null, 2, (DefaultConstructorMarker) null);
        FUNCTIONS = new DescriptorKindFilter(access$nextMask5, (List) null, 2, (DefaultConstructorMarker) null);
        VARIABLES = new DescriptorKindFilter(access$nextMask6, (List) null, 2, (DefaultConstructorMarker) null);
        VALUES = new DescriptorKindFilter(i12, (List) null, 2, (DefaultConstructorMarker) null);
        Class<DescriptorKindFilter> cls = DescriptorKindFilter.class;
        Field[] fields = cls.getFields();
        Intrinsics.checkNotNullExpressionValue(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList<>();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get((Object) null);
            if (obj instanceof DescriptorKindFilter) {
                descriptorKindFilter = (DescriptorKindFilter) obj;
            } else {
                descriptorKindFilter = null;
            }
            if (descriptorKindFilter != null) {
                int i14 = descriptorKindFilter.kindMask;
                String name2 = field2.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "field.name");
                maskToName2 = new Companion.MaskToName(i14, name2);
            } else {
                maskToName2 = null;
            }
            if (maskToName2 != null) {
                arrayList2.add(maskToName2);
            }
        }
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = arrayList2;
        Field[] fields2 = cls.getFields();
        Intrinsics.checkNotNullExpressionValue(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList<>();
        for (Object next : arrayList3) {
            if (Intrinsics.areEqual((Object) ((Field) next).getType(), (Object) Integer.TYPE)) {
                arrayList4.add(next);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj2 = field4.get((Object) null);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj2).intValue();
            if (intValue == ((-intValue) & intValue)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                String name3 = field4.getName();
                Intrinsics.checkNotNullExpressionValue(name3, "field.name");
                maskToName = new Companion.MaskToName(intValue, name3);
            } else {
                maskToName = null;
            }
            if (maskToName != null) {
                arrayList5.add(maskToName);
            }
        }
        DEBUG_MASK_BIT_NAMES = arrayList5;
    }

    public DescriptorKindFilter(int i11, @NotNull List<? extends DescriptorKindExclude> list) {
        Intrinsics.checkNotNullParameter(list, "excludes");
        this.excludes = list;
        for (DescriptorKindExclude fullyExcludedDescriptorKinds : list) {
            i11 &= ~fullyExcludedDescriptorKinds.getFullyExcludedDescriptorKinds();
        }
        this.kindMask = i11;
    }

    public final boolean acceptsKinds(int i11) {
        return (i11 & this.kindMask) != 0;
    }

    public boolean equals(@Nullable Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<DescriptorKindFilter> cls2 = DescriptorKindFilter.class;
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual((Object) cls2, (Object) cls)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        DescriptorKindFilter descriptorKindFilter = (DescriptorKindFilter) obj;
        if (Intrinsics.areEqual((Object) this.excludes, (Object) descriptorKindFilter.excludes) && this.kindMask == descriptorKindFilter.kindMask) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<DescriptorKindExclude> getExcludes() {
        return this.excludes;
    }

    public final int getKindMask() {
        return this.kindMask;
    }

    public int hashCode() {
        return (this.excludes.hashCode() * 31) + this.kindMask;
    }

    @Nullable
    public final DescriptorKindFilter restrictedToKindsOrNull(int i11) {
        int i12 = i11 & this.kindMask;
        if (i12 == 0) {
            return null;
        }
        return new DescriptorKindFilter(i12, this.excludes);
    }

    @NotNull
    public String toString() {
        Object obj;
        String str;
        String str2;
        boolean z11;
        Iterator it = DEBUG_PREDEFINED_FILTERS_MASK_NAMES.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Companion.MaskToName) obj).getMask() == this.kindMask) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        Companion.MaskToName maskToName = (Companion.MaskToName) obj;
        if (maskToName != null) {
            str = maskToName.getName();
        } else {
            str = null;
        }
        if (str == null) {
            ArrayList arrayList = new ArrayList();
            for (Companion.MaskToName maskToName2 : DEBUG_MASK_BIT_NAMES) {
                if (acceptsKinds(maskToName2.getMask())) {
                    str2 = maskToName2.getName();
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
            }
            str = CollectionsKt___CollectionsKt.joinToString$default(arrayList, " | ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        return "DescriptorKindFilter(" + str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.excludes + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DescriptorKindFilter(int i11, List list, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
