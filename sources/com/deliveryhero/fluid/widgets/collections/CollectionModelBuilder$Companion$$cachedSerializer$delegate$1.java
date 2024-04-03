package com.deliveryhero.fluid.widgets.collections;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class CollectionModelBuilder$Companion$$cachedSerializer$delegate$1 extends Lambda implements Function0<KSerializer<Object>> {
    public static final CollectionModelBuilder$Companion$$cachedSerializer$delegate$1 INSTANCE = new CollectionModelBuilder$Companion$$cachedSerializer$delegate$1();

    public CollectionModelBuilder$Companion$$cachedSerializer$delegate$1() {
        super(0);
    }

    @NotNull
    public final KSerializer<Object> invoke() {
        return new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(CollectionModelBuilder.class), new Annotation[0]);
    }
}
