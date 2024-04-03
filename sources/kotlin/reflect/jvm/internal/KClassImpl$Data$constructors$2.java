package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002 \u0004*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KClassImpl$Data$constructors$2 extends Lambda implements Function0<List<? extends KFunction<? extends T>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KClassImpl<T> f24371g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$constructors$2(KClassImpl<T> kClassImpl) {
        super(0);
        this.f24371g = kClassImpl;
    }

    public final List<KFunction<T>> invoke() {
        Iterable<ConstructorDescriptor> constructorDescriptors = this.f24371g.getConstructorDescriptors();
        KClassImpl<T> kClassImpl = this.f24371g;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(constructorDescriptors, 10));
        for (ConstructorDescriptor kFunctionImpl : constructorDescriptors) {
            arrayList.add(new KFunctionImpl(kClassImpl, kFunctionImpl));
        }
        return arrayList;
    }
}
