package org.koin.core.instance;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0015\u0010\u0011\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\r\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0016"}, d2 = {"Lorg/koin/core/instance/SingleInstanceFactory;", "T", "Lorg/koin/core/instance/InstanceFactory;", "beanDefinition", "Lorg/koin/core/definition/BeanDefinition;", "(Lorg/koin/core/definition/BeanDefinition;)V", "value", "Ljava/lang/Object;", "create", "context", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "drop", "", "scope", "Lorg/koin/core/scope/Scope;", "dropAll", "get", "getValue", "()Ljava/lang/Object;", "isCreated", "", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SingleInstanceFactory<T> extends InstanceFactory<T> {
    /* access modifiers changed from: private */
    @Nullable
    public T value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleInstanceFactory(@NotNull BeanDefinition<T> beanDefinition) {
        super(beanDefinition);
        Intrinsics.checkNotNullParameter(beanDefinition, "beanDefinition");
    }

    private final T getValue() {
        T t11 = this.value;
        if (t11 != null) {
            return t11;
        }
        throw new IllegalStateException("Single instance created couldn't return value".toString());
    }

    public T create(@NotNull InstanceContext instanceContext) {
        Intrinsics.checkNotNullParameter(instanceContext, "context");
        if (this.value == null) {
            return super.create(instanceContext);
        }
        return getValue();
    }

    public void drop(@Nullable Scope scope) {
        Function1 onClose = getBeanDefinition().getCallbacks().getOnClose();
        if (onClose != null) {
            onClose.invoke(this.value);
        }
        this.value = null;
    }

    public void dropAll() {
        InstanceFactory.drop$default(this, (Scope) null, 1, (Object) null);
    }

    public T get(@NotNull InstanceContext instanceContext) {
        Intrinsics.checkNotNullParameter(instanceContext, "context");
        KoinPlatformTools.INSTANCE.m10944synchronized(this, new SingleInstanceFactory$get$1(this, instanceContext));
        return getValue();
    }

    public boolean isCreated(@Nullable InstanceContext instanceContext) {
        return this.value != null;
    }
}
