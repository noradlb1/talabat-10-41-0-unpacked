package bo.app;

import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lbo/app/j3;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "value", "", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class j3<T> implements ReadWriteProperty<Object, T> {

    /* renamed from: a  reason: collision with root package name */
    private T f38754a;

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ T f38755b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ KProperty<?> f38756c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(T t11, KProperty<?> kProperty) {
            super(0);
            this.f38755b = t11;
            this.f38756c = kProperty;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot assign " + this.f38755b + " to only-set-once property " + this.f38756c.getName();
        }
    }

    public T getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(obj, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return this.f38754a;
    }

    public void setValue(Object obj, KProperty<?> kProperty, T t11) {
        Intrinsics.checkNotNullParameter(obj, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        T t12 = this.f38754a;
        if (t12 == null) {
            this.f38754a = t11;
        } else if (!Intrinsics.areEqual((Object) t12, (Object) t11)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new a(t11, kProperty), 7, (Object) null);
        }
    }
}
