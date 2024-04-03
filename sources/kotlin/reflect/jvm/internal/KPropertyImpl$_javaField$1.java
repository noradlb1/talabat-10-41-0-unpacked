package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.DescriptorsJvmAbiUtil;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Field;", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KPropertyImpl$_javaField$1 extends Lambda implements Function0<Field> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KPropertyImpl<V> f24431g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KPropertyImpl$_javaField$1(KPropertyImpl<? extends V> kPropertyImpl) {
        super(0);
        this.f24431g = kPropertyImpl;
    }

    @Nullable
    public final Field invoke() {
        Class<?> cls;
        JvmPropertySignature mapPropertySignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(this.f24431g.getDescriptor());
        if (mapPropertySignature instanceof JvmPropertySignature.KotlinProperty) {
            JvmPropertySignature.KotlinProperty kotlinProperty = (JvmPropertySignature.KotlinProperty) mapPropertySignature;
            PropertyDescriptor descriptor = kotlinProperty.getDescriptor();
            JvmMemberSignature.Field jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, kotlinProperty.getProto(), kotlinProperty.getNameResolver(), kotlinProperty.getTypeTable(), false, 8, (Object) null);
            if (jvmFieldSignature$default == null) {
                return null;
            }
            KPropertyImpl<V> kPropertyImpl = this.f24431g;
            if (DescriptorsJvmAbiUtil.isPropertyWithBackingFieldInOuterClass(descriptor) || JvmProtoBufUtil.isMovedFromInterfaceCompanion(kotlinProperty.getProto())) {
                cls = kPropertyImpl.getContainer().getJClass().getEnclosingClass();
            } else {
                DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
                if (containingDeclaration instanceof ClassDescriptor) {
                    cls = UtilKt.toJavaClass((ClassDescriptor) containingDeclaration);
                } else {
                    cls = kPropertyImpl.getContainer().getJClass();
                }
            }
            if (cls == null) {
                return null;
            }
            try {
                return cls.getDeclaredField(jvmFieldSignature$default.getName());
            } catch (NoSuchFieldException unused) {
                return null;
            }
        } else if (mapPropertySignature instanceof JvmPropertySignature.JavaField) {
            return ((JvmPropertySignature.JavaField) mapPropertySignature).getField();
        } else {
            if ((mapPropertySignature instanceof JvmPropertySignature.JavaMethodProperty) || (mapPropertySignature instanceof JvmPropertySignature.MappedKotlinProperty)) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
