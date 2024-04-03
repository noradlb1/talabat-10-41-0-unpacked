package org.koin.core.definition;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.koin.ext.KClassExtKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\n"}, d2 = {"T", "Lkotlin/reflect/KClass;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class BeanDefinition$toString$defOtherTypes$typesAsString$1 extends Lambda implements Function1<KClass<?>, CharSequence> {
    public static final BeanDefinition$toString$defOtherTypes$typesAsString$1 INSTANCE = new BeanDefinition$toString$defOtherTypes$typesAsString$1();

    public BeanDefinition$toString$defOtherTypes$typesAsString$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "it");
        return KClassExtKt.getFullName(kClass);
    }
}
