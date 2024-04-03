package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class SimpleType extends UnwrappedType implements SimpleTypeMarker, TypeArgumentListMarker {
    public SimpleType() {
        super((DefaultConstructorMarker) null);
    }

    @NotNull
    public abstract SimpleType makeNullableAsSpecified(boolean z11);

    @NotNull
    public abstract SimpleType replaceAttributes(@NotNull TypeAttributes typeAttributes);

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (AnnotationDescriptor renderAnnotation$default : getAnnotations()) {
            StringBuilder unused = StringsKt__StringBuilderKt.append(sb2, "[", DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.DEBUG_TEXT, renderAnnotation$default, (AnnotationUseSiteTarget) null, 2, (Object) null), "] ");
        }
        sb2.append(getConstructor());
        if (!getArguments().isEmpty()) {
            Appendable unused2 = CollectionsKt___CollectionsKt.joinTo$default(getArguments(), sb2, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, "<", ">", 0, (CharSequence) null, (Function1) null, 112, (Object) null);
        }
        if (isMarkedNullable()) {
            sb2.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
