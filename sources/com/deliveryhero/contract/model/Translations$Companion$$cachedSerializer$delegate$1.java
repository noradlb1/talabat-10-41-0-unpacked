package com.deliveryhero.contract.model;

import com.deliveryhero.contract.model.Translations;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.internal.ObjectSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class Translations$Companion$$cachedSerializer$delegate$1 extends Lambda implements Function0<KSerializer<Object>> {
    public static final Translations$Companion$$cachedSerializer$delegate$1 INSTANCE = new Translations$Companion$$cachedSerializer$delegate$1();

    public Translations$Companion$$cachedSerializer$delegate$1() {
        super(0);
    }

    @NotNull
    public final KSerializer<Object> invoke() {
        return new SealedClassSerializer("com.deliveryhero.contract.model.Translations", Reflection.getOrCreateKotlinClass(Translations.class), new KClass[]{Reflection.getOrCreateKotlinClass(Translations.ENABLED.class), Reflection.getOrCreateKotlinClass(Translations.DISABLED.class)}, new KSerializer[]{Translations$ENABLED$$serializer.INSTANCE, new ObjectSerializer("com.deliveryhero.contract.model.Translations.DISABLED", Translations.DISABLED.INSTANCE, new Annotation[0])}, new Annotation[0]);
    }
}
