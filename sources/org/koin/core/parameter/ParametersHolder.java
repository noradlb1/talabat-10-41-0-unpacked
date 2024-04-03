package org.koin.core.parameter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.error.DefinitionParameterException;
import org.koin.core.error.NoParameterFoundException;
import org.koin.ext.KClassExtKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0001J\u0016\u0010\u000e\u001a\u0002H\u000f\"\u0006\b\u0000\u0010\u000f\u0018\u0001H\n¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u0002H\u000f\"\u0006\b\u0000\u0010\u000f\u0018\u0001H\n¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0012\u001a\u0002H\u000f\"\u0006\b\u0000\u0010\u000f\u0018\u0001H\n¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0013\u001a\u0002H\u000f\"\u0006\b\u0000\u0010\u000f\u0018\u0001H\n¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0014\u001a\u0002H\u000f\"\u0006\b\u0000\u0010\u000f\u0018\u0001H\n¢\u0006\u0002\u0010\u0010J'\u0010\u0015\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u0002H\u000f\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\u0001H\b¢\u0006\u0002\u0010\u0010J\u001c\u0010\u001b\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u0004\u0018\u0001H\u000f\"\u0006\b\u0000\u0010\u000f\u0018\u0001H\b¢\u0006\u0002\u0010\u0010J!\u0010\u001d\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0016¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u0001J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J!\u0010$\u001a\u00020%\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u0002H\u000f¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\u0017J\b\u0010)\u001a\u00020*H\u0016R$\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00038\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006,"}, d2 = {"Lorg/koin/core/parameter/ParametersHolder;", "", "_values", "", "(Ljava/util/List;)V", "get_values$annotations", "()V", "get_values", "()Ljava/util/List;", "values", "", "getValues", "add", "value", "component1", "T", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "elementAt", "i", "", "clazz", "Lkotlin/reflect/KClass;", "(ILkotlin/reflect/KClass;)Ljava/lang/Object;", "get", "(I)Ljava/lang/Object;", "getOrNull", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "insert", "index", "isEmpty", "", "isNotEmpty", "set", "", "t", "(ILjava/lang/Object;)V", "size", "toString", "", "Companion", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class ParametersHolder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_PARAMS = 5;
    @NotNull
    private final List<Object> _values;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lorg/koin/core/parameter/ParametersHolder$Companion;", "", "()V", "MAX_PARAMS", "", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ParametersHolder() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public ParametersHolder(@NotNull List<Object> list) {
        Intrinsics.checkNotNullParameter(list, "_values");
        this._values = list;
    }

    @PublishedApi
    public static /* synthetic */ void get_values$annotations() {
    }

    @NotNull
    public final ParametersHolder add(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        this._values.add(obj);
        return this;
    }

    public final /* synthetic */ <T> T component1() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return elementAt(0, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final /* synthetic */ <T> T component2() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return elementAt(1, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final /* synthetic */ <T> T component3() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return elementAt(2, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final /* synthetic */ <T> T component4() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return elementAt(3, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final /* synthetic */ <T> T component5() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return elementAt(4, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public <T> T elementAt(int i11, @NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        if (this._values.size() > i11) {
            return this._values.get(i11);
        }
        throw new NoParameterFoundException("Can't get injected parameter #" + i11 + " from " + this + " for type '" + KClassExtKt.getFullName(kClass) + '\'');
    }

    public final <T> T get(int i11) {
        return this._values.get(i11);
    }

    @Nullable
    public <T> T getOrNull(@NotNull KClass<?> kClass) {
        T t11;
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Iterator it = this._values.iterator();
        do {
            t11 = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (kClass.isInstance(next)) {
                t11 = next;
                continue;
            }
        } while (t11 == null);
        return t11;
    }

    @NotNull
    public final List<Object> getValues() {
        return this._values;
    }

    @NotNull
    public final List<Object> get_values() {
        return this._values;
    }

    @NotNull
    public final ParametersHolder insert(int i11, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        this._values.add(i11, obj);
        return this;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public final <T> void set(int i11, T t11) {
        List<Object> list = this._values;
        if (t11 != null) {
            list.set(i11, t11);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    public final int size() {
        return this._values.size();
    }

    @NotNull
    public String toString() {
        return Intrinsics.stringPlus("DefinitionParameters", CollectionsKt___CollectionsKt.toList(this._values));
    }

    public final /* synthetic */ <T> T get() {
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        T orNull = getOrNull(Reflection.getOrCreateKotlinClass(cls));
        if (orNull != null) {
            return orNull;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No value found for type '");
        Intrinsics.reifiedOperationMarker(4, "T");
        sb2.append(KClassExtKt.getFullName(Reflection.getOrCreateKotlinClass(cls)));
        sb2.append('\'');
        throw new DefinitionParameterException(sb2.toString());
    }

    public final /* synthetic */ <T> T getOrNull() {
        T t11;
        Iterator it = get_values().iterator();
        do {
            t11 = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            Intrinsics.reifiedOperationMarker(3, "T");
            if (next instanceof Object) {
                t11 = next;
                continue;
            }
        } while (t11 == null);
        return t11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParametersHolder(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new ArrayList() : list);
    }
}
