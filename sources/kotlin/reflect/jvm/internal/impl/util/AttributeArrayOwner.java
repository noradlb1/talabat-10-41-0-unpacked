package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

public abstract class AttributeArrayOwner<K, T> extends AbstractArrayMapOwner<K, T> {
    @NotNull
    private ArrayMap<T> arrayMap;

    public AttributeArrayOwner(@NotNull ArrayMap<T> arrayMap2) {
        Intrinsics.checkNotNullParameter(arrayMap2, "arrayMap");
        this.arrayMap = arrayMap2;
    }

    @NotNull
    public final ArrayMap<T> a() {
        return this.arrayMap;
    }

    public final void c(@NotNull KClass<? extends K> kClass, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(kClass, "tClass");
        Intrinsics.checkNotNullParameter(t11, "value");
        int id2 = b().getId(kClass);
        int size = this.arrayMap.getSize();
        if (size != 0) {
            if (size == 1) {
                ArrayMap<T> arrayMap2 = this.arrayMap;
                Intrinsics.checkNotNull(arrayMap2, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                OneElementArrayMap oneElementArrayMap = (OneElementArrayMap) arrayMap2;
                if (oneElementArrayMap.getIndex() == id2) {
                    this.arrayMap = new OneElementArrayMap(t11, id2);
                    return;
                }
                ArrayMapImpl arrayMapImpl = new ArrayMapImpl();
                this.arrayMap = arrayMapImpl;
                arrayMapImpl.set(oneElementArrayMap.getIndex(), oneElementArrayMap.getValue());
            }
            this.arrayMap.set(id2, t11);
            return;
        }
        this.arrayMap = new OneElementArrayMap(t11, id2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AttributeArrayOwner() {
        /*
            r2 = this;
            kotlin.reflect.jvm.internal.impl.util.EmptyArrayMap r0 = kotlin.reflect.jvm.internal.impl.util.EmptyArrayMap.INSTANCE
            java.lang.String r1 = "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            r2.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.AttributeArrayOwner.<init>():void");
    }
}
