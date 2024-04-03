package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class RawTypeImpl extends FlexibleType implements RawType {
    private RawTypeImpl(SimpleType simpleType, SimpleType simpleType2, boolean z11) {
        super(simpleType, simpleType2);
        if (!z11) {
            KotlinTypeChecker.DEFAULT.isSubtypeOf(simpleType, simpleType2);
        }
    }

    private static final boolean render$onlyOutDiffers(String str, String str2) {
        if (Intrinsics.areEqual((Object) str, (Object) StringsKt__StringsKt.removePrefix(str2, (CharSequence) "out ")) || Intrinsics.areEqual((Object) str2, (Object) "*")) {
            return true;
        }
        return false;
    }

    private static final List<String> render$renderArguments(DescriptorRenderer descriptorRenderer, KotlinType kotlinType) {
        Iterable<TypeProjection> arguments = kotlinType.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10));
        for (TypeProjection renderTypeProjection : arguments) {
            arrayList.add(descriptorRenderer.renderTypeProjection(renderTypeProjection));
        }
        return arrayList;
    }

    private static final String render$replaceArgs(String str, String str2) {
        if (!StringsKt__StringsKt.contains$default((CharSequence) str, (char) Typography.less, false, 2, (Object) null)) {
            return str;
        }
        return StringsKt__StringsKt.substringBefore$default(str, (char) Typography.less, (String) null, 2, (Object) null) + Typography.less + str2 + Typography.greater + StringsKt__StringsKt.substringAfterLast$default(str, (char) Typography.greater, (String) null, 2, (Object) null);
    }

    @NotNull
    public SimpleType getDelegate() {
        return getLowerBound();
    }

    @NotNull
    public MemberScope getMemberScope() {
        ClassDescriptor classDescriptor;
        ClassifierDescriptor declarationDescriptor = getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            classDescriptor = (ClassDescriptor) declarationDescriptor;
        } else {
            classDescriptor = null;
        }
        if (classDescriptor != null) {
            MemberScope memberScope = classDescriptor.getMemberScope(new RawSubstitution((TypeParameterUpperBoundEraser) null, 1, (DefaultConstructorMarker) null));
            Intrinsics.checkNotNullExpressionValue(memberScope, "classDescriptor.getMemberScope(RawSubstitution())");
            return memberScope;
        }
        throw new IllegalStateException(("Incorrect classifier: " + getConstructor().getDeclarationDescriptor()).toString());
    }

    @NotNull
    public String render(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
        Intrinsics.checkNotNullParameter(descriptorRendererOptions, "options");
        String renderType = descriptorRenderer.renderType(getLowerBound());
        String renderType2 = descriptorRenderer.renderType(getUpperBound());
        if (descriptorRendererOptions.getDebugMode()) {
            return "raw (" + renderType + ".." + renderType2 + ')';
        } else if (getUpperBound().getArguments().isEmpty()) {
            return descriptorRenderer.renderFlexibleType(renderType, renderType2, TypeUtilsKt.getBuiltIns(this));
        } else {
            List<String> render$renderArguments = render$renderArguments(descriptorRenderer, getLowerBound());
            List<String> render$renderArguments2 = render$renderArguments(descriptorRenderer, getUpperBound());
            Iterable iterable = render$renderArguments;
            String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(iterable, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, RawTypeImpl$render$newArgs$1.INSTANCE, 30, (Object) null);
            Iterable zip = CollectionsKt___CollectionsKt.zip(iterable, render$renderArguments2);
            boolean z11 = true;
            if (!(zip instanceof Collection) || !((Collection) zip).isEmpty()) {
                Iterator it = zip.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair pair = (Pair) it.next();
                    if (!render$onlyOutDiffers((String) pair.getFirst(), (String) pair.getSecond())) {
                        z11 = false;
                        break;
                    }
                }
            }
            if (z11) {
                renderType2 = render$replaceArgs(renderType2, joinToString$default);
            }
            String render$replaceArgs = render$replaceArgs(renderType, joinToString$default);
            if (Intrinsics.areEqual((Object) render$replaceArgs, (Object) renderType2)) {
                return render$replaceArgs;
            }
            return descriptorRenderer.renderFlexibleType(render$replaceArgs, renderType2, TypeUtilsKt.getBuiltIns(this));
        }
    }

    @NotNull
    public RawTypeImpl makeNullableAsSpecified(boolean z11) {
        return new RawTypeImpl(getLowerBound().makeNullableAsSpecified(z11), getUpperBound().makeNullableAsSpecified(z11));
    }

    @NotNull
    public RawTypeImpl replaceAttributes(@NotNull TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return new RawTypeImpl(getLowerBound().replaceAttributes(typeAttributes), getUpperBound().replaceAttributes(typeAttributes));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RawTypeImpl(@NotNull SimpleType simpleType, @NotNull SimpleType simpleType2) {
        this(simpleType, simpleType2, false);
        Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
        Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
    }

    @NotNull
    public FlexibleType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType refineType = kotlinTypeRefiner.refineType(getLowerBound());
        Intrinsics.checkNotNull(refineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType refineType2 = kotlinTypeRefiner.refineType(getUpperBound());
        Intrinsics.checkNotNull(refineType2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new RawTypeImpl((SimpleType) refineType, (SimpleType) refineType2, true);
    }
}
