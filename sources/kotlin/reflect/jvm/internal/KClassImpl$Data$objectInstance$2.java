package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMappingUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KClassImpl$Data$objectInstance$2 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KClassImpl<T>.Data f24379g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ KClassImpl<T> f24380h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$objectInstance$2(KClassImpl<T>.Data data, KClassImpl<T> kClassImpl) {
        super(0);
        this.f24379g = data;
        this.f24380h = kClassImpl;
    }

    @Nullable
    public final T invoke() {
        Field field;
        ClassDescriptor descriptor = this.f24379g.getDescriptor();
        if (descriptor.getKind() != ClassKind.OBJECT) {
            return null;
        }
        if (!descriptor.isCompanionObject() || CompanionObjectMappingUtilsKt.isMappedIntrinsicCompanionObject(CompanionObjectMapping.INSTANCE, descriptor)) {
            field = this.f24380h.getJClass().getDeclaredField("INSTANCE");
        } else {
            field = this.f24380h.getJClass().getEnclosingClass().getDeclaredField(descriptor.getName().asString());
        }
        T t11 = field.get((Object) null);
        Intrinsics.checkNotNull(t11, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
        return t11;
    }
}
