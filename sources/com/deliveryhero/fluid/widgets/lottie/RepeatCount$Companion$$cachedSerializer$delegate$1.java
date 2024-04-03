package com.deliveryhero.fluid.widgets.lottie;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class RepeatCount$Companion$$cachedSerializer$delegate$1 extends Lambda implements Function0<KSerializer<Object>> {
    public static final RepeatCount$Companion$$cachedSerializer$delegate$1 INSTANCE = new RepeatCount$Companion$$cachedSerializer$delegate$1();

    public RepeatCount$Companion$$cachedSerializer$delegate$1() {
        super(0);
    }

    @NotNull
    public final KSerializer<Object> invoke() {
        return new SealedClassSerializer("com.deliveryhero.fluid.widgets.lottie.RepeatCount", Reflection.getOrCreateKotlinClass(RepeatCount.class), new KClass[0], new KSerializer[0], new Annotation[0]);
    }
}
