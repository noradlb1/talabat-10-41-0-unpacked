package org.koin.dsl;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Callbacks;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.module.Module;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a5\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001\"\u0006\b\u0000\u0010\u0004\u0018\u0001*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001H\b\u001a9\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0004\u001aD\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00012\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\tH\u0004¢\u0006\u0002\u0010\n\u001aW\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\u0004\b\u0000\u0010\u0004*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u00012\u001e\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u0002H\u0004`\u000eH\u0004¨\u0006\u000f"}, d2 = {"bind", "Lkotlin/Pair;", "Lorg/koin/core/module/Module;", "Lorg/koin/core/instance/InstanceFactory;", "T", "clazz", "Lkotlin/reflect/KClass;", "binds", "classes", "", "(Lkotlin/Pair;[Lkotlin/reflect/KClass;)Lkotlin/Pair;", "onClose", "Lkotlin/Function1;", "", "Lorg/koin/core/definition/OnCloseCallback;", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DefinitionBindingKt {
    @NotNull
    public static final Pair<Module, InstanceFactory<?>> bind(@NotNull Pair<Module, ? extends InstanceFactory<?>> pair, @NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        ((InstanceFactory) pair.getSecond()).getBeanDefinition().setSecondaryTypes(CollectionsKt___CollectionsKt.plus(((InstanceFactory) pair.getSecond()).getBeanDefinition().getSecondaryTypes(), kClass));
        pair.getFirst().saveMapping(BeanDefinitionKt.indexKey(kClass, ((InstanceFactory) pair.getSecond()).getBeanDefinition().getQualifier(), ((InstanceFactory) pair.getSecond()).getBeanDefinition().getScopeQualifier()), (InstanceFactory) pair.getSecond(), true);
        return pair;
    }

    @NotNull
    public static final Pair<Module, InstanceFactory<?>> binds(@NotNull Pair<Module, ? extends InstanceFactory<?>> pair, @NotNull KClass<?>[] kClassArr) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.checkNotNullParameter(kClassArr, "classes");
        ((InstanceFactory) pair.getSecond()).getBeanDefinition().setSecondaryTypes(CollectionsKt___CollectionsKt.plus(((InstanceFactory) pair.getSecond()).getBeanDefinition().getSecondaryTypes(), (T[]) kClassArr));
        for (KClass<?> indexKey : kClassArr) {
            pair.getFirst().saveMapping(BeanDefinitionKt.indexKey(indexKey, ((InstanceFactory) pair.getSecond()).getBeanDefinition().getQualifier(), ((InstanceFactory) pair.getSecond()).getBeanDefinition().getScopeQualifier()), (InstanceFactory) pair.getSecond(), true);
        }
        return pair;
    }

    @NotNull
    public static final <T> Pair<Module, InstanceFactory<T>> onClose(@NotNull Pair<Module, ? extends InstanceFactory<T>> pair, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onClose");
        ((InstanceFactory) pair.getSecond()).getBeanDefinition().setCallbacks(new Callbacks(function1));
        return pair;
    }

    public static final /* synthetic */ <T> Pair<Module, InstanceFactory<?>> bind(Pair<Module, ? extends InstanceFactory<?>> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return bind(pair, Reflection.getOrCreateKotlinClass(Object.class));
    }
}
