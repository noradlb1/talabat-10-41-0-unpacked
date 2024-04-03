package kotlinx.serialization.modules;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0002B'\b\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0001J5\u0010\u0015\u001a\u00020\u00122-\u0010\f\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u000b0\tJ7\u0010\u0019\u001a\u00020\u00122-\u0010\b\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u000b0\tH\u0007J,\u0010\u001a\u001a\u00020\u0012\"\b\b\u0001\u0010\u001b*\u00028\u00002\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0006R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u000b\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R0\u0010\u000e\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060\u00100\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "Base", "", "baseClass", "Lkotlin/reflect/KClass;", "baseSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "defaultDeserializerProvider", "Lkotlin/Function1;", "", "Lkotlinx/serialization/DeserializationStrategy;", "defaultSerializerProvider", "Lkotlinx/serialization/SerializationStrategy;", "subclasses", "", "Lkotlin/Pair;", "buildTo", "", "builder", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "default", "Lkotlin/ParameterName;", "name", "className", "defaultDeserializer", "subclass", "T", "serializer", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolymorphicModuleBuilder<Base> {
    @NotNull
    private final KClass<Base> baseClass;
    @Nullable
    private final KSerializer<Base> baseSerializer;
    @Nullable
    private Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider;
    @Nullable
    private Function1<? super Base, ? extends SerializationStrategy<? super Base>> defaultSerializerProvider;
    @NotNull
    private final List<Pair<KClass<? extends Base>, KSerializer<? extends Base>>> subclasses;

    @PublishedApi
    public PolymorphicModuleBuilder(@NotNull KClass<Base> kClass, @Nullable KSerializer<Base> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        this.baseClass = kClass;
        this.baseSerializer = kSerializer;
        this.subclasses = new ArrayList();
    }

    @PublishedApi
    public final void buildTo(@NotNull SerializersModuleBuilder serializersModuleBuilder) {
        Intrinsics.checkNotNullParameter(serializersModuleBuilder, "builder");
        KSerializer<Base> kSerializer = this.baseSerializer;
        if (kSerializer != null) {
            KClass<Base> kClass = this.baseClass;
            SerializersModuleBuilder.registerPolymorphicSerializer$default(serializersModuleBuilder, kClass, kClass, kSerializer, false, 8, (Object) null);
        }
        for (Pair pair : this.subclasses) {
            SerializersModuleBuilder serializersModuleBuilder2 = serializersModuleBuilder;
            SerializersModuleBuilder.registerPolymorphicSerializer$default(serializersModuleBuilder2, this.baseClass, (KClass) pair.component1(), (KSerializer) pair.component2(), false, 8, (Object) null);
        }
        Function1<? super Base, ? extends SerializationStrategy<? super Base>> function1 = this.defaultSerializerProvider;
        if (function1 != null) {
            serializersModuleBuilder.registerDefaultPolymorphicSerializer(this.baseClass, function1, false);
        }
        Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function12 = this.defaultDeserializerProvider;
        if (function12 != null) {
            serializersModuleBuilder.registerDefaultPolymorphicDeserializer(this.baseClass, function12, false);
        }
    }

    /* renamed from: default  reason: not valid java name */
    public final void m7874default(@NotNull Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        Intrinsics.checkNotNullParameter(function1, "defaultSerializerProvider");
        defaultDeserializer(function1);
    }

    @ExperimentalSerializationApi
    public final void defaultDeserializer(@NotNull Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        boolean z11;
        Intrinsics.checkNotNullParameter(function1, "defaultDeserializerProvider");
        if (this.defaultDeserializerProvider == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.defaultDeserializerProvider = function1;
            return;
        }
        throw new IllegalArgumentException(("Default deserializer provider is already registered for class " + this.baseClass + ": " + this.defaultDeserializerProvider).toString());
    }

    public final <T extends Base> void subclass(@NotNull KClass<T> kClass, @NotNull KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "subclass");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        this.subclasses.add(TuplesKt.to(kClass, kSerializer));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PolymorphicModuleBuilder(KClass kClass, KSerializer kSerializer, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, (i11 & 2) != 0 ? null : kSerializer);
    }
}
