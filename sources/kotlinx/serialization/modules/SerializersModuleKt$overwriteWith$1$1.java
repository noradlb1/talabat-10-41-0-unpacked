package kotlinx.serialization.modules;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.modules.ContextualProvider;
import kotlinx.serialization.modules.SerializersModuleCollector;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JQ\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072/\u0010\b\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\tH\u0016J.\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000bH\u0016JF\u0010\u0010\u001a\u00020\u0003\"\b\b\u0000\u0010\u0011*\u00020\u0005\"\b\b\u0001\u0010\u0012*\u0002H\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u000bH\u0016JO\u0010\u0016\u001a\u00020\u0003\"\b\b\u0000\u0010\u0011*\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00072-\u0010\u0017\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0019\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u0002H\u0011\u0018\u00010\u001a0\tH\u0016JK\u0010\u001b\u001a\u00020\u0003\"\b\b\u0000\u0010\u0011*\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00072)\u0010\u001c\u001a%\u0012\u0013\u0012\u0011H\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001d\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u001e0\tH\u0016¨\u0006\u001f"}, d2 = {"kotlinx/serialization/modules/SerializersModuleKt$overwriteWith$1$1", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "contextual", "", "T", "", "kClass", "Lkotlin/reflect/KClass;", "provider", "Lkotlin/Function1;", "", "Lkotlinx/serialization/KSerializer;", "Lkotlin/ParameterName;", "name", "serializers", "serializer", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphicDefaultDeserializer", "defaultDeserializerProvider", "", "className", "Lkotlinx/serialization/DeserializationStrategy;", "polymorphicDefaultSerializer", "defaultSerializerProvider", "value", "Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SerializersModuleKt$overwriteWith$1$1 implements SerializersModuleCollector {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SerializersModuleBuilder f26455a;

    public SerializersModuleKt$overwriteWith$1$1(SerializersModuleBuilder serializersModuleBuilder) {
        this.f26455a = serializersModuleBuilder;
    }

    public <T> void contextual(@NotNull KClass<T> kClass, @NotNull KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        this.f26455a.registerSerializer(kClass, new ContextualProvider.Argless(kSerializer), true);
    }

    public <Base, Sub extends Base> void polymorphic(@NotNull KClass<Base> kClass, @NotNull KClass<Sub> kClass2, @NotNull KSerializer<Sub> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(kClass2, "actualClass");
        Intrinsics.checkNotNullParameter(kSerializer, "actualSerializer");
        this.f26455a.registerPolymorphicSerializer(kClass, kClass2, kSerializer, true);
    }

    public <Base> void polymorphicDefault(@NotNull KClass<Base> kClass, @NotNull Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        SerializersModuleCollector.DefaultImpls.polymorphicDefault(this, kClass, function1);
    }

    public <Base> void polymorphicDefaultDeserializer(@NotNull KClass<Base> kClass, @NotNull Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "defaultDeserializerProvider");
        this.f26455a.registerDefaultPolymorphicDeserializer(kClass, function1, true);
    }

    public <Base> void polymorphicDefaultSerializer(@NotNull KClass<Base> kClass, @NotNull Function1<? super Base, ? extends SerializationStrategy<? super Base>> function1) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "defaultSerializerProvider");
        this.f26455a.registerDefaultPolymorphicSerializer(kClass, function1, true);
    }

    public <T> void contextual(@NotNull KClass<T> kClass, @NotNull Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> function1) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(function1, "provider");
        this.f26455a.registerSerializer(kClass, new ContextualProvider.WithTypeArguments(function1), true);
    }
}
