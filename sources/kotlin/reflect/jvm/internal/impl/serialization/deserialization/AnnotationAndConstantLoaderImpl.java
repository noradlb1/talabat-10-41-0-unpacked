package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AnnotationAndConstantLoaderImpl implements AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    @NotNull
    private final AnnotationDeserializer deserializer;
    @NotNull
    private final SerializerExtensionProtocol protocol;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AnnotationAndConstantLoaderImpl(@NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses, @NotNull SerializerExtensionProtocol serializerExtensionProtocol) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics.checkNotNullParameter(serializerExtensionProtocol, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL);
        this.protocol = serializerExtensionProtocol;
        this.deserializer = new AnnotationDeserializer(moduleDescriptor, notFoundClasses);
    }

    @Nullable
    public ConstantValue<?> loadAnnotationDefaultValue(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.Property property, @NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(property, "proto");
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        return null;
    }

    @NotNull
    public List<AnnotationDescriptor> loadCallableAnnotations(@NotNull ProtoContainer protoContainer, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind) {
        List list;
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, FWFConstants.EXPLANATION_TYPE_KIND);
        if (messageLite instanceof ProtoBuf.Constructor) {
            list = (List) ((ProtoBuf.Constructor) messageLite).getExtension(this.protocol.getConstructorAnnotation());
        } else if (messageLite instanceof ProtoBuf.Function) {
            list = (List) ((ProtoBuf.Function) messageLite).getExtension(this.protocol.getFunctionAnnotation());
        } else if (messageLite instanceof ProtoBuf.Property) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
            if (i11 == 1) {
                list = (List) ((ProtoBuf.Property) messageLite).getExtension(this.protocol.getPropertyAnnotation());
            } else if (i11 == 2) {
                list = (List) ((ProtoBuf.Property) messageLite).getExtension(this.protocol.getPropertyGetterAnnotation());
            } else if (i11 == 3) {
                list = (List) ((ProtoBuf.Property) messageLite).getExtension(this.protocol.getPropertySetterAnnotation());
            } else {
                throw new IllegalStateException("Unsupported callable kind with property proto".toString());
            }
        } else {
            throw new IllegalStateException(("Unknown message: " + messageLite).toString());
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, protoContainer.getNameResolver()));
        }
        return arrayList;
    }

    @NotNull
    public List<AnnotationDescriptor> loadClassAnnotations(@NotNull ProtoContainer.Class classR) {
        Intrinsics.checkNotNullParameter(classR, TtmlNode.RUBY_CONTAINER);
        List list = (List) classR.getClassProto().getExtension(this.protocol.getClassAnnotation());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, classR.getNameResolver()));
        }
        return arrayList;
    }

    @NotNull
    public List<AnnotationDescriptor> loadEnumEntryAnnotations(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.EnumEntry enumEntry) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(enumEntry, "proto");
        List list = (List) enumEntry.getExtension(this.protocol.getEnumEntryAnnotation());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, protoContainer.getNameResolver()));
        }
        return arrayList;
    }

    @NotNull
    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(@NotNull ProtoContainer protoContainer, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, FWFConstants.EXPLANATION_TYPE_KIND);
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public List<AnnotationDescriptor> loadPropertyBackingFieldAnnotations(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(property, "proto");
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public List<AnnotationDescriptor> loadPropertyDelegateFieldAnnotations(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(property, "proto");
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public List<AnnotationDescriptor> loadTypeAnnotations(@NotNull ProtoBuf.Type type, @NotNull NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(type, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        List list = (List) type.getExtension(this.protocol.getTypeAnnotation());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, nameResolver));
        }
        return arrayList;
    }

    @NotNull
    public List<AnnotationDescriptor> loadTypeParameterAnnotations(@NotNull ProtoBuf.TypeParameter typeParameter, @NotNull NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(typeParameter, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        List list = (List) typeParameter.getExtension(this.protocol.getTypeParameterAnnotation());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, nameResolver));
        }
        return arrayList;
    }

    @NotNull
    public List<AnnotationDescriptor> loadValueParameterAnnotations(@NotNull ProtoContainer protoContainer, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind, int i11, @NotNull ProtoBuf.ValueParameter valueParameter) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(messageLite, "callableProto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(valueParameter, "proto");
        List list = (List) valueParameter.getExtension(this.protocol.getParameterAnnotation());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, protoContainer.getNameResolver()));
        }
        return arrayList;
    }

    @Nullable
    public ConstantValue<?> loadPropertyConstant(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.Property property, @NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(property, "proto");
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        ProtoBuf.Annotation.Argument.Value value = (ProtoBuf.Annotation.Argument.Value) ProtoBufUtilKt.getExtensionOrNull(property, this.protocol.getCompileTimeValue());
        if (value == null) {
            return null;
        }
        return this.deserializer.resolveValue(kotlinType, value, protoContainer.getNameResolver());
    }
}
