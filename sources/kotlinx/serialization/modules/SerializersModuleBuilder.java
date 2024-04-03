package kotlinx.serialization.modules;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.modules.ContextualProvider;
import kotlinx.serialization.modules.SerializersModuleCollector;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0001¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0001JQ\u0010\u0017\u001a\u00020\u0018\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u00052/\u0010\u001c\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u001d¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\bH\u0016J.\u0010\u0017\u001a\u00020\u0018\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0013H\u0016J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0016JF\u0010\"\u001a\u00020\u0018\"\b\b\u0000\u0010#*\u00020\u001a\"\b\b\u0001\u0010$*\u0002H#2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H$0\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H$0\u0013H\u0016JO\u0010(\u001a\u00020\u0018\"\b\b\u0000\u0010#*\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00052-\u0010)\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u0002H#\u0018\u00010\r0\bH\u0017JK\u0010*\u001a\u00020\u0018\"\b\b\u0000\u0010#*\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00052)\u0010+\u001a%\u0012\u0013\u0012\u0011H#¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(,\u0012\f\u0012\n\u0012\u0004\u0012\u0002H#\u0018\u00010\u00100\bH\u0017JW\u0010-\u001a\u00020\u0018\"\b\b\u0000\u0010#*\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00052-\u0010)\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u0002H#\u0018\u00010\r0\b2\u0006\u0010.\u001a\u00020/H\u0001JS\u00100\u001a\u00020\u0018\"\b\b\u0000\u0010#*\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00052)\u0010+\u001a%\u0012\u0013\u0012\u0011H#¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(,\u0012\f\u0012\n\u0012\u0004\u0012\u0002H#\u0018\u00010\u00100\b2\u0006\u0010.\u001a\u00020/H\u0001JP\u00101\u001a\u00020\u0018\"\b\b\u0000\u0010#*\u00020\u001a\"\b\b\u0001\u0010$*\u0002H#2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00052\f\u00102\u001a\b\u0012\u0004\u0012\u0002H$0\u00052\f\u00103\u001a\b\u0012\u0004\u0012\u0002H$0\u00132\b\b\u0002\u0010.\u001a\u00020/H\u0001J2\u00104\u001a\u00020\u0018\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u00105\u001a\b\u0012\u0004\u0012\u0002H\u00190\u00052\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020/H\u0001R\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000RI\u0010\u0007\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r0\bj\u0006\u0012\u0002\b\u0003`\u000e0\u0004X\u0004¢\u0006\u0002\n\u0000R6\u0010\u000f\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00100\bj\u0006\u0012\u0002\b\u0003`\u00110\u0004X\u0004¢\u0006\u0002\n\u0000R.\u0010\u0012\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R2\u0010\u0014\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lkotlinx/serialization/modules/SerializersModuleBuilder;", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "()V", "class2ContextualProvider", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/modules/ContextualProvider;", "polyBase2DefaultDeserializerProvider", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "className", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicDeserializerProvider;", "polyBase2DefaultSerializerProvider", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2NamedSerializers", "Lkotlinx/serialization/KSerializer;", "polyBase2Serializers", "build", "Lkotlinx/serialization/modules/SerializersModule;", "contextual", "", "T", "", "kClass", "provider", "", "typeArgumentsSerializers", "serializer", "include", "module", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphicDefaultDeserializer", "defaultDeserializerProvider", "polymorphicDefaultSerializer", "defaultSerializerProvider", "value", "registerDefaultPolymorphicDeserializer", "allowOverwrite", "", "registerDefaultPolymorphicSerializer", "registerPolymorphicSerializer", "concreteClass", "concreteSerializer", "registerSerializer", "forClass", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SerializersModuleBuilder implements SerializersModuleCollector {
    @NotNull
    private final Map<KClass<?>, ContextualProvider> class2ContextualProvider = new HashMap();
    @NotNull
    private final Map<KClass<?>, Function1<String, DeserializationStrategy<?>>> polyBase2DefaultDeserializerProvider = new HashMap();
    @NotNull
    private final Map<KClass<?>, Function1<?, SerializationStrategy<?>>> polyBase2DefaultSerializerProvider = new HashMap();
    @NotNull
    private final Map<KClass<?>, Map<String, KSerializer<?>>> polyBase2NamedSerializers = new HashMap();
    @NotNull
    private final Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> polyBase2Serializers = new HashMap();

    public static /* synthetic */ void registerPolymorphicSerializer$default(SerializersModuleBuilder serializersModuleBuilder, KClass kClass, KClass kClass2, KSerializer kSerializer, boolean z11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        serializersModuleBuilder.registerPolymorphicSerializer(kClass, kClass2, kSerializer, z11);
    }

    public static /* synthetic */ void registerSerializer$default(SerializersModuleBuilder serializersModuleBuilder, KClass kClass, ContextualProvider contextualProvider, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        serializersModuleBuilder.registerSerializer(kClass, contextualProvider, z11);
    }

    @NotNull
    @PublishedApi
    public final SerializersModule build() {
        return new SerialModuleImpl(this.class2ContextualProvider, this.polyBase2Serializers, this.polyBase2DefaultSerializerProvider, this.polyBase2NamedSerializers, this.polyBase2DefaultDeserializerProvider);
    }

    public <T> void contextual(@NotNull KClass<T> kClass, @NotNull KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        registerSerializer$default(this, kClass, new ContextualProvider.Argless(kSerializer), false, 4, (Object) null);
    }

    public final void include(@NotNull SerializersModule serializersModule) {
        Intrinsics.checkNotNullParameter(serializersModule, "module");
        serializersModule.dumpTo(this);
    }

    public <Base, Sub extends Base> void polymorphic(@NotNull KClass<Base> kClass, @NotNull KClass<Sub> kClass2, @NotNull KSerializer<Sub> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(kClass2, "actualClass");
        Intrinsics.checkNotNullParameter(kSerializer, "actualSerializer");
        registerPolymorphicSerializer$default(this, kClass, kClass2, kSerializer, false, 8, (Object) null);
    }

    public <Base> void polymorphicDefault(@NotNull KClass<Base> kClass, @NotNull Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        SerializersModuleCollector.DefaultImpls.polymorphicDefault(this, kClass, function1);
    }

    @ExperimentalSerializationApi
    public <Base> void polymorphicDefaultDeserializer(@NotNull KClass<Base> kClass, @NotNull Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "defaultDeserializerProvider");
        registerDefaultPolymorphicDeserializer(kClass, function1, false);
    }

    @ExperimentalSerializationApi
    public <Base> void polymorphicDefaultSerializer(@NotNull KClass<Base> kClass, @NotNull Function1<? super Base, ? extends SerializationStrategy<? super Base>> function1) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "defaultSerializerProvider");
        registerDefaultPolymorphicSerializer(kClass, function1, false);
    }

    @JvmName(name = "registerDefaultPolymorphicDeserializer")
    public final <Base> void registerDefaultPolymorphicDeserializer(@NotNull KClass<Base> kClass, @NotNull Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1, boolean z11) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "defaultDeserializerProvider");
        Function1 function12 = this.polyBase2DefaultDeserializerProvider.get(kClass);
        if (function12 == null || Intrinsics.areEqual((Object) function12, (Object) function1) || z11) {
            this.polyBase2DefaultDeserializerProvider.put(kClass, function1);
            return;
        }
        throw new IllegalArgumentException("Default deserializers provider for " + kClass + " is already registered: " + function12);
    }

    @JvmName(name = "registerDefaultPolymorphicSerializer")
    public final <Base> void registerDefaultPolymorphicSerializer(@NotNull KClass<Base> kClass, @NotNull Function1<? super Base, ? extends SerializationStrategy<? super Base>> function1, boolean z11) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "defaultSerializerProvider");
        Function1 function12 = this.polyBase2DefaultSerializerProvider.get(kClass);
        if (function12 == null || Intrinsics.areEqual((Object) function12, (Object) function1) || z11) {
            this.polyBase2DefaultSerializerProvider.put(kClass, function1);
            return;
        }
        throw new IllegalArgumentException("Default serializers provider for " + kClass + " is already registered: " + function12);
    }

    @JvmName(name = "registerPolymorphicSerializer")
    public final <Base, Sub extends Base> void registerPolymorphicSerializer(@NotNull KClass<Base> kClass, @NotNull KClass<Sub> kClass2, @NotNull KSerializer<Sub> kSerializer, boolean z11) {
        Object obj;
        boolean z12;
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(kClass2, "concreteClass");
        Intrinsics.checkNotNullParameter(kSerializer, "concreteSerializer");
        String serialName = kSerializer.getDescriptor().getSerialName();
        Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> map = this.polyBase2Serializers;
        Map<KClass<?>, KSerializer<?>> map2 = map.get(kClass);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(kClass, map2);
        }
        Map map3 = map2;
        KSerializer kSerializer2 = (KSerializer) map3.get(kClass2);
        Map<KClass<?>, Map<String, KSerializer<?>>> map4 = this.polyBase2NamedSerializers;
        Map<String, KSerializer<?>> map5 = map4.get(kClass);
        if (map5 == null) {
            map5 = new HashMap<>();
            map4.put(kClass, map5);
        }
        Map map6 = map5;
        if (z11) {
            if (kSerializer2 != null) {
                map6.remove(kSerializer2.getDescriptor().getSerialName());
            }
            map3.put(kClass2, kSerializer);
            map6.put(serialName, kSerializer);
            return;
        }
        if (kSerializer2 != null) {
            if (Intrinsics.areEqual((Object) kSerializer2, (Object) kSerializer)) {
                map6.remove(kSerializer2.getDescriptor().getSerialName());
            } else {
                throw new SerializerAlreadyRegisteredException(kClass, kClass2);
            }
        }
        KSerializer kSerializer3 = (KSerializer) map6.get(serialName);
        if (kSerializer3 != null) {
            Map<KClass<?>, KSerializer<?>> map7 = this.polyBase2Serializers.get(kClass);
            Intrinsics.checkNotNull(map7);
            Iterator it = MapsKt___MapsKt.asSequence(map7).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Map.Entry) obj).getValue() == kSerializer3) {
                    z12 = true;
                    continue;
                } else {
                    z12 = false;
                    continue;
                }
                if (z12) {
                    break;
                }
            }
            throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + kClass + "' have the same serial name '" + serialName + "': '" + kClass2 + "' and '" + ((Map.Entry) obj) + '\'');
        }
        map3.put(kClass2, kSerializer);
        map6.put(serialName, kSerializer);
    }

    @JvmName(name = "registerSerializer")
    public final <T> void registerSerializer(@NotNull KClass<T> kClass, @NotNull ContextualProvider contextualProvider, boolean z11) {
        ContextualProvider contextualProvider2;
        Intrinsics.checkNotNullParameter(kClass, "forClass");
        Intrinsics.checkNotNullParameter(contextualProvider, "provider");
        if (z11 || (contextualProvider2 = this.class2ContextualProvider.get(kClass)) == null || Intrinsics.areEqual((Object) contextualProvider2, (Object) contextualProvider)) {
            this.class2ContextualProvider.put(kClass, contextualProvider);
            return;
        }
        throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + kClass + " already registered in this module");
    }

    public <T> void contextual(@NotNull KClass<T> kClass, @NotNull Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> function1) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(function1, "provider");
        registerSerializer$default(this, kClass, new ContextualProvider.WithTypeArguments(function1), false, 4, (Object) null);
    }
}
