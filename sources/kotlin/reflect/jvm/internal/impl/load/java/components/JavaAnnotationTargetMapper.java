package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.tekartik.sqflite.Constant;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaAnnotationTargetMapper {
    @NotNull
    public static final JavaAnnotationTargetMapper INSTANCE = new JavaAnnotationTargetMapper();
    @NotNull
    private static final Map<String, KotlinRetention> retentionNameList = MapsKt__MapsKt.mapOf(TuplesKt.to("RUNTIME", KotlinRetention.RUNTIME), TuplesKt.to("CLASS", KotlinRetention.BINARY), TuplesKt.to("SOURCE", KotlinRetention.SOURCE));
    @NotNull
    private static final Map<String, EnumSet<KotlinTarget>> targetNameLists = MapsKt__MapsKt.mapOf(TuplesKt.to("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), TuplesKt.to("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), TuplesKt.to("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), TuplesKt.to("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), TuplesKt.to("FIELD", EnumSet.of(KotlinTarget.FIELD)), TuplesKt.to("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), TuplesKt.to("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), TuplesKt.to("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), TuplesKt.to("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), TuplesKt.to("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));

    private JavaAnnotationTargetMapper() {
    }

    @Nullable
    public final ConstantValue<?> mapJavaRetentionArgument$descriptors_jvm(@Nullable JavaAnnotationArgument javaAnnotationArgument) {
        JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument;
        String str;
        if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
            javaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument) javaAnnotationArgument;
        } else {
            javaEnumValueAnnotationArgument = null;
        }
        if (javaEnumValueAnnotationArgument == null) {
            return null;
        }
        Map<String, KotlinRetention> map = retentionNameList;
        Name entryName = javaEnumValueAnnotationArgument.getEntryName();
        if (entryName != null) {
            str = entryName.asString();
        } else {
            str = null;
        }
        KotlinRetention kotlinRetention = map.get(str);
        if (kotlinRetention == null) {
            return null;
        }
        ClassId classId = ClassId.topLevel(StandardNames.FqNames.annotationRetention);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(StandardNames.F…ames.annotationRetention)");
        Name identifier = Name.identifier(kotlinRetention.name());
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(retention.name)");
        return new EnumValue(classId, identifier);
    }

    @NotNull
    public final Set<KotlinTarget> mapJavaTargetArgumentByName(@Nullable String str) {
        EnumSet enumSet = targetNameLists.get(str);
        return enumSet != null ? enumSet : SetsKt__SetsKt.emptySet();
    }

    @NotNull
    public final ConstantValue<?> mapJavaTargetArguments$descriptors_jvm(@NotNull List<? extends JavaAnnotationArgument> list) {
        String str;
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        ArrayList<JavaEnumValueAnnotationArgument> arrayList = new ArrayList<>();
        for (Object next : list) {
            if (next instanceof JavaEnumValueAnnotationArgument) {
                arrayList.add(next);
            }
        }
        ArrayList<KotlinTarget> arrayList2 = new ArrayList<>();
        for (JavaEnumValueAnnotationArgument entryName : arrayList) {
            JavaAnnotationTargetMapper javaAnnotationTargetMapper = INSTANCE;
            Name entryName2 = entryName.getEntryName();
            if (entryName2 != null) {
                str = entryName2.asString();
            } else {
                str = null;
            }
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList2, javaAnnotationTargetMapper.mapJavaTargetArgumentByName(str));
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
        for (KotlinTarget name2 : arrayList2) {
            ClassId classId = ClassId.topLevel(StandardNames.FqNames.annotationTarget);
            Intrinsics.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.annotationTarget)");
            Name identifier = Name.identifier(name2.name());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(kotlinTarget.name)");
            arrayList3.add(new EnumValue(classId, identifier));
        }
        return new ArrayValue(arrayList3, JavaAnnotationTargetMapper$mapJavaTargetArguments$1.INSTANCE);
    }
}
