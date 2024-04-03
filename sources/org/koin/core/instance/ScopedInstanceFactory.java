package org.koin.core.instance;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0015\u0010\u0014\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0017\u001a\u00020\u00102\n\u0010\u0018\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0019\u001a\u00020\u001aR2\u0010\u0006\u001a&\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00028\u00000\u0007j\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00028\u0000`\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lorg/koin/core/instance/ScopedInstanceFactory;", "T", "Lorg/koin/core/instance/InstanceFactory;", "beanDefinition", "Lorg/koin/core/definition/BeanDefinition;", "(Lorg/koin/core/definition/BeanDefinition;)V", "values", "Ljava/util/HashMap;", "", "Lorg/koin/core/scope/ScopeID;", "Lkotlin/collections/HashMap;", "create", "context", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "drop", "", "scope", "Lorg/koin/core/scope/Scope;", "dropAll", "get", "isCreated", "", "refreshInstance", "scopeID", "instance", "", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ScopedInstanceFactory<T> extends InstanceFactory<T> {
    /* access modifiers changed from: private */
    @NotNull
    public HashMap<String, T> values = new HashMap<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScopedInstanceFactory(@NotNull BeanDefinition<T> beanDefinition) {
        super(beanDefinition);
        Intrinsics.checkNotNullParameter(beanDefinition, "beanDefinition");
    }

    public T create(@NotNull InstanceContext instanceContext) {
        Intrinsics.checkNotNullParameter(instanceContext, "context");
        if (this.values.get(instanceContext.getScope().getId()) == null) {
            return super.create(instanceContext);
        }
        T t11 = this.values.get(instanceContext.getScope().getId());
        if (t11 != null) {
            return t11;
        }
        throw new IllegalStateException(("Scoped instance not found for " + instanceContext.getScope().getId() + " in " + getBeanDefinition()).toString());
    }

    public void drop(@Nullable Scope scope) {
        if (scope != null) {
            Function1 onClose = getBeanDefinition().getCallbacks().getOnClose();
            if (onClose != null) {
                onClose.invoke(this.values.get(scope.getId()));
            }
            this.values.remove(scope.getId());
        }
    }

    public void dropAll() {
        this.values.clear();
    }

    public T get(@NotNull InstanceContext instanceContext) {
        Intrinsics.checkNotNullParameter(instanceContext, "context");
        if (Intrinsics.areEqual((Object) instanceContext.getScope().getScopeQualifier(), (Object) getBeanDefinition().getScopeQualifier())) {
            KoinPlatformTools.INSTANCE.m10944synchronized(this, new ScopedInstanceFactory$get$1(this, instanceContext));
            T t11 = this.values.get(instanceContext.getScope().getId());
            if (t11 != null) {
                return t11;
            }
            throw new IllegalStateException(("Scoped instance not found for " + instanceContext.getScope().getId() + " in " + getBeanDefinition()).toString());
        }
        throw new IllegalStateException(("Wrong Scope: trying to open instance for " + instanceContext.getScope().getId() + " in " + getBeanDefinition()).toString());
    }

    public boolean isCreated(@Nullable InstanceContext instanceContext) {
        Scope scope;
        HashMap<String, T> hashMap = this.values;
        String str = null;
        if (!(instanceContext == null || (scope = instanceContext.getScope()) == null)) {
            str = scope.getId();
        }
        return hashMap.get(str) != null;
    }

    public final void refreshInstance(@NotNull String str, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(str, "scopeID");
        Intrinsics.checkNotNullParameter(obj, "instance");
        this.values.put(str, obj);
    }
}
