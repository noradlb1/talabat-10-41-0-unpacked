package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KClassImpl$Data$supertypes$2 extends Lambda implements Function0<List<? extends KTypeImpl>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KClassImpl<T>.Data f24385g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ KClassImpl<T> f24386h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$supertypes$2(KClassImpl<T>.Data data, KClassImpl<T> kClassImpl) {
        super(0);
        this.f24385g = data;
        this.f24386h = kClassImpl;
    }

    public final List<KTypeImpl> invoke() {
        boolean z11;
        Collection<KotlinType> supertypes = this.f24385g.getDescriptor().getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "descriptor.typeConstructor.supertypes");
        ArrayList arrayList = new ArrayList(supertypes.size());
        KClassImpl<T>.Data data = this.f24385g;
        KClassImpl<T> kClassImpl = this.f24386h;
        for (KotlinType kotlinType : supertypes) {
            Intrinsics.checkNotNullExpressionValue(kotlinType, "kotlinType");
            arrayList.add(new KTypeImpl(kotlinType, new KClassImpl$Data$supertypes$2$1$1(kotlinType, data, kClassImpl)));
        }
        if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(this.f24385g.getDescriptor())) {
            boolean z12 = true;
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ClassKind kind = DescriptorUtils.getClassDescriptorForType(((KTypeImpl) it.next()).getType()).getKind();
                    Intrinsics.checkNotNullExpressionValue(kind, "getClassDescriptorForType(it.type).kind");
                    if (kind == ClassKind.INTERFACE || kind == ClassKind.ANNOTATION_CLASS) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (!z11) {
                        z12 = false;
                        break;
                    }
                }
            }
            if (z12) {
                SimpleType anyType = DescriptorUtilsKt.getBuiltIns(this.f24385g.getDescriptor()).getAnyType();
                Intrinsics.checkNotNullExpressionValue(anyType, "descriptor.builtIns.anyType");
                arrayList.add(new KTypeImpl(anyType, AnonymousClass3.INSTANCE));
            }
        }
        return CollectionsKt.compact(arrayList);
    }
}
