package kotlinx.serialization.descriptors;

import androidx.exifinterface.media.ExifInterface;
import fwfd.com.fwfsdk.constant.FWFConstants;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.internal.ArrayListClassDesc;
import kotlinx.serialization.internal.HashMapClassDesc;
import kotlinx.serialization.internal.HashSetClassDesc;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.internal.SerialDescriptorForNullable;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u0018\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0001H\u0007\u001aB\u0010\r\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f\"\u00020\u00012\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\u0010\u0015\u001aL\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f\"\u00020\u00012\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0011\u0010\u001a\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u001b\u0018\u0001H\b\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\u0007\u001a\u0019\u0010\u001d\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u001e\u0018\u0001\"\u0006\b\u0001\u0010\u001f\u0018\u0001H\b\u001a\u0018\u0010\u001d\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\"\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u001b\u0018\u0001H\b\u001a\u000e\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$\u001a\u0011\u0010%\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u001b\u0018\u0001H\b\u001a\u0010\u0010%\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\u0007\u001a7\u0010&\u001a\u00020\u0013\"\u0006\b\u0000\u0010\u001b\u0018\u0001*\u00020\u00122\u0006\u0010'\u001a\u00020\b2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\b\b\u0002\u0010+\u001a\u00020,H\b\"\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006-"}, d2 = {"nullable", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getNullable$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getNullable", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "PrimitiveSerialDescriptor", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "SerialDescriptor", "original", "buildClassSerialDescriptor", "typeParameters", "", "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "buildSerialDescriptor", "Lkotlinx/serialization/descriptors/SerialKind;", "builder", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "listSerialDescriptor", "T", "elementDescriptor", "mapSerialDescriptor", "K", "V", "keyDescriptor", "valueDescriptor", "serialDescriptor", "type", "Lkotlin/reflect/KType;", "setSerialDescriptor", "element", "elementName", "annotations", "", "", "isOptional", "", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SerialDescriptorsKt {
    @NotNull
    public static final SerialDescriptor PrimitiveSerialDescriptor(@NotNull String str, @NotNull PrimitiveKind primitiveKind) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(primitiveKind, FWFConstants.EXPLANATION_TYPE_KIND);
        if (!StringsKt__StringsJVMKt.isBlank(str)) {
            return PrimitivesKt.PrimitiveDescriptorSafe(str, primitiveKind);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    @ExperimentalSerializationApi
    @NotNull
    public static final SerialDescriptor SerialDescriptor(@NotNull String str, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(serialDescriptor, "original");
        if (!(!StringsKt__StringsJVMKt.isBlank(str))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        } else if (!(!(serialDescriptor.getKind() instanceof PrimitiveKind))) {
            throw new IllegalArgumentException("For primitive descriptors please use 'PrimitiveSerialDescriptor' instead".toString());
        } else if (!Intrinsics.areEqual((Object) str, (Object) serialDescriptor.getSerialName())) {
            return new WrappedSerialDescriptor(str, serialDescriptor);
        } else {
            throw new IllegalArgumentException(("The name of the wrapped descriptor (" + str + ") cannot be the same as the name of the original descriptor (" + serialDescriptor.getSerialName() + ')').toString());
        }
    }

    @NotNull
    public static final SerialDescriptor buildClassSerialDescriptor(@NotNull String str, @NotNull SerialDescriptor[] serialDescriptorArr, @NotNull Function1<? super ClassSerialDescriptorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(serialDescriptorArr, "typeParameters");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        if (!StringsKt__StringsJVMKt.isBlank(str)) {
            ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(str);
            function1.invoke(classSerialDescriptorBuilder);
            return new SerialDescriptorImpl(str, StructureKind.CLASS.INSTANCE, classSerialDescriptorBuilder.getElementNames$kotlinx_serialization_core().size(), ArraysKt___ArraysKt.toList((T[]) serialDescriptorArr), classSerialDescriptorBuilder);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static /* synthetic */ SerialDescriptor buildClassSerialDescriptor$default(String str, SerialDescriptor[] serialDescriptorArr, Function1 function1, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            function1 = SerialDescriptorsKt$buildClassSerialDescriptor$1.INSTANCE;
        }
        return buildClassSerialDescriptor(str, serialDescriptorArr, function1);
    }

    @NotNull
    @InternalSerializationApi
    public static final SerialDescriptor buildSerialDescriptor(@NotNull String str, @NotNull SerialKind serialKind, @NotNull SerialDescriptor[] serialDescriptorArr, @NotNull Function1<? super ClassSerialDescriptorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(serialKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(serialDescriptorArr, "typeParameters");
        Intrinsics.checkNotNullParameter(function1, "builder");
        if (!(!StringsKt__StringsJVMKt.isBlank(str))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        } else if (!Intrinsics.areEqual((Object) serialKind, (Object) StructureKind.CLASS.INSTANCE)) {
            ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(str);
            function1.invoke(classSerialDescriptorBuilder);
            return new SerialDescriptorImpl(str, serialKind, classSerialDescriptorBuilder.getElementNames$kotlinx_serialization_core().size(), ArraysKt___ArraysKt.toList((T[]) serialDescriptorArr), classSerialDescriptorBuilder);
        } else {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
    }

    public static /* synthetic */ SerialDescriptor buildSerialDescriptor$default(String str, SerialKind serialKind, SerialDescriptor[] serialDescriptorArr, Function1 function1, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            function1 = SerialDescriptorsKt$buildSerialDescriptor$1.INSTANCE;
        }
        return buildSerialDescriptor(str, serialKind, serialDescriptorArr, function1);
    }

    public static final /* synthetic */ <T> void element(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String str, List<? extends Annotation> list, boolean z11) {
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "elementName");
        Intrinsics.checkNotNullParameter(list, "annotations");
        Intrinsics.reifiedOperationMarker(6, "T");
        classSerialDescriptorBuilder.element(str, SerializersKt.serializer((KType) null).getDescriptor(), list, z11);
    }

    public static /* synthetic */ void element$default(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String str, List list, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "elementName");
        Intrinsics.checkNotNullParameter(list, "annotations");
        Intrinsics.reifiedOperationMarker(6, "T");
        classSerialDescriptorBuilder.element(str, SerializersKt.serializer((KType) null).getDescriptor(), list, z11);
    }

    @NotNull
    public static final SerialDescriptor getNullable(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (serialDescriptor.isNullable()) {
            return serialDescriptor;
        }
        return new SerialDescriptorForNullable(serialDescriptor);
    }

    public static /* synthetic */ void getNullable$annotations(SerialDescriptor serialDescriptor) {
    }

    @ExperimentalSerializationApi
    @NotNull
    public static final SerialDescriptor listSerialDescriptor(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "elementDescriptor");
        return new ArrayListClassDesc(serialDescriptor);
    }

    @ExperimentalSerializationApi
    @NotNull
    public static final SerialDescriptor mapSerialDescriptor(@NotNull SerialDescriptor serialDescriptor, @NotNull SerialDescriptor serialDescriptor2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "keyDescriptor");
        Intrinsics.checkNotNullParameter(serialDescriptor2, "valueDescriptor");
        return new HashMapClassDesc(serialDescriptor, serialDescriptor2);
    }

    @ExperimentalSerializationApi
    @NotNull
    public static final SerialDescriptor setSerialDescriptor(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "elementDescriptor");
        return new HashSetClassDesc(serialDescriptor);
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <K, V> SerialDescriptor mapSerialDescriptor() {
        Intrinsics.reifiedOperationMarker(6, "K");
        SerialDescriptor descriptor = SerializersKt.serializer((KType) null).getDescriptor();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        return mapSerialDescriptor(descriptor, SerializersKt.serializer((KType) null).getDescriptor());
    }

    @NotNull
    public static final SerialDescriptor serialDescriptor(@NotNull KType kType) {
        Intrinsics.checkNotNullParameter(kType, "type");
        return SerializersKt.serializer(kType).getDescriptor();
    }
}
