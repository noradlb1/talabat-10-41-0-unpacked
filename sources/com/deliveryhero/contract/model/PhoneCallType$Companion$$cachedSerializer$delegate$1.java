package com.deliveryhero.contract.model;

import com.deliveryhero.contract.model.PhoneCallType;
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
public final class PhoneCallType$Companion$$cachedSerializer$delegate$1 extends Lambda implements Function0<KSerializer<Object>> {
    public static final PhoneCallType$Companion$$cachedSerializer$delegate$1 INSTANCE = new PhoneCallType$Companion$$cachedSerializer$delegate$1();

    public PhoneCallType$Companion$$cachedSerializer$delegate$1() {
        super(0);
    }

    @NotNull
    public final KSerializer<Object> invoke() {
        return new SealedClassSerializer("com.deliveryhero.contract.model.PhoneCallType", Reflection.getOrCreateKotlinClass(PhoneCallType.class), new KClass[]{Reflection.getOrCreateKotlinClass(PhoneCallType.Normal.class), Reflection.getOrCreateKotlinClass(PhoneCallType.Masked.class), Reflection.getOrCreateKotlinClass(PhoneCallType.Toku.class), Reflection.getOrCreateKotlinClass(PhoneCallType.None.class)}, new KSerializer[]{new ObjectSerializer("com.deliveryhero.contract.model.PhoneCallType.Normal", PhoneCallType.Normal.INSTANCE, new Annotation[0]), new ObjectSerializer("com.deliveryhero.contract.model.PhoneCallType.Masked", PhoneCallType.Masked.INSTANCE, new Annotation[0]), PhoneCallType$Toku$$serializer.INSTANCE, new ObjectSerializer("com.deliveryhero.contract.model.PhoneCallType.None", PhoneCallType.None.INSTANCE, new Annotation[0])}, new Annotation[0]);
    }
}
