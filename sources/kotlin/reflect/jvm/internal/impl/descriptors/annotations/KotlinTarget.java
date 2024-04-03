package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public enum KotlinTarget {
    CLASS("class", false, 2, (boolean) null),
    ANNOTATION_CLASS("annotation class", false, 2, (boolean) null),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property", false, 2, (boolean) null),
    FIELD("field", false, 2, (boolean) null),
    LOCAL_VARIABLE("local variable", false, 2, (boolean) null),
    VALUE_PARAMETER("value parameter", false, 2, (boolean) null),
    CONSTRUCTOR("constructor", false, 2, (boolean) null),
    FUNCTION("function", false, 2, (boolean) null),
    PROPERTY_GETTER("getter", false, 2, (boolean) null),
    PROPERTY_SETTER("setter", false, 2, (boolean) null),
    TYPE("type usage", false),
    EXPRESSION("expression", false),
    FILE("file", false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY("class", false),
    OBJECT("object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    BACKING_FIELD("backing field", false, 2, (boolean) null),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);
    
    @NotNull
    private static final Set<KotlinTarget> ALL_TARGET_SET = null;
    @NotNull
    private static final List<KotlinTarget> ANNOTATION_CLASS_LIST = null;
    @NotNull
    private static final List<KotlinTarget> CLASS_LIST = null;
    @NotNull
    private static final List<KotlinTarget> COMPANION_OBJECT_LIST = null;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final Set<KotlinTarget> DEFAULT_TARGET_SET = null;
    @NotNull
    private static final List<KotlinTarget> ENUM_ENTRY_LIST = null;
    @NotNull
    private static final List<KotlinTarget> ENUM_LIST = null;
    @NotNull
    private static final List<KotlinTarget> FILE_LIST = null;
    @NotNull
    private static final List<KotlinTarget> FUNCTION_LIST = null;
    @NotNull
    private static final List<KotlinTarget> INTERFACE_LIST = null;
    @NotNull
    private static final List<KotlinTarget> LOCAL_CLASS_LIST = null;
    @NotNull
    private static final List<KotlinTarget> OBJECT_LIST = null;
    @NotNull
    private static final List<KotlinTarget> PROPERTY_GETTER_LIST = null;
    @NotNull
    private static final List<KotlinTarget> PROPERTY_SETTER_LIST = null;
    @NotNull
    private static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING = null;
    @NotNull
    private static final HashMap<String, KotlinTarget> map = null;
    @NotNull
    private final String description;
    private final boolean isDefault;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        map = new HashMap<>();
        for (KotlinTarget kotlinTarget : values()) {
            map.put(kotlinTarget.name(), kotlinTarget);
        }
        KotlinTarget[] values = values();
        ArrayList arrayList = new ArrayList();
        for (KotlinTarget kotlinTarget2 : values) {
            if (kotlinTarget2.isDefault) {
                arrayList.add(kotlinTarget2);
            }
        }
        DEFAULT_TARGET_SET = CollectionsKt___CollectionsKt.toSet(arrayList);
        ALL_TARGET_SET = ArraysKt___ArraysKt.toSet((T[]) values());
        KotlinTarget kotlinTarget3 = CLASS;
        ANNOTATION_CLASS_LIST = CollectionsKt__CollectionsKt.listOf(ANNOTATION_CLASS, kotlinTarget3);
        LOCAL_CLASS_LIST = CollectionsKt__CollectionsKt.listOf(LOCAL_CLASS, kotlinTarget3);
        CLASS_LIST = CollectionsKt__CollectionsKt.listOf(CLASS_ONLY, kotlinTarget3);
        KotlinTarget kotlinTarget4 = OBJECT;
        COMPANION_OBJECT_LIST = CollectionsKt__CollectionsKt.listOf(COMPANION_OBJECT, kotlinTarget4, kotlinTarget3);
        OBJECT_LIST = CollectionsKt__CollectionsKt.listOf(kotlinTarget4, kotlinTarget3);
        INTERFACE_LIST = CollectionsKt__CollectionsKt.listOf(INTERFACE, kotlinTarget3);
        ENUM_LIST = CollectionsKt__CollectionsKt.listOf(ENUM_CLASS, kotlinTarget3);
        KotlinTarget kotlinTarget5 = PROPERTY;
        KotlinTarget kotlinTarget6 = FIELD;
        ENUM_ENTRY_LIST = CollectionsKt__CollectionsKt.listOf(ENUM_ENTRY, kotlinTarget5, kotlinTarget6);
        KotlinTarget kotlinTarget7 = PROPERTY_SETTER;
        PROPERTY_SETTER_LIST = CollectionsKt__CollectionsJVMKt.listOf(kotlinTarget7);
        KotlinTarget kotlinTarget8 = PROPERTY_GETTER;
        PROPERTY_GETTER_LIST = CollectionsKt__CollectionsJVMKt.listOf(kotlinTarget8);
        FUNCTION_LIST = CollectionsKt__CollectionsJVMKt.listOf(FUNCTION);
        KotlinTarget kotlinTarget9 = FILE;
        FILE_LIST = CollectionsKt__CollectionsJVMKt.listOf(kotlinTarget9);
        AnnotationUseSiteTarget annotationUseSiteTarget = AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER;
        KotlinTarget kotlinTarget10 = VALUE_PARAMETER;
        USE_SITE_MAPPING = MapsKt__MapsKt.mapOf(TuplesKt.to(annotationUseSiteTarget, kotlinTarget10), TuplesKt.to(AnnotationUseSiteTarget.FIELD, kotlinTarget6), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY, kotlinTarget5), TuplesKt.to(AnnotationUseSiteTarget.FILE, kotlinTarget9), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_GETTER, kotlinTarget8), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_SETTER, kotlinTarget7), TuplesKt.to(AnnotationUseSiteTarget.RECEIVER, kotlinTarget10), TuplesKt.to(AnnotationUseSiteTarget.SETTER_PARAMETER, kotlinTarget10), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, kotlinTarget6));
    }

    private KotlinTarget(String str, boolean z11) {
        this.description = str;
        this.isDefault = z11;
    }
}
