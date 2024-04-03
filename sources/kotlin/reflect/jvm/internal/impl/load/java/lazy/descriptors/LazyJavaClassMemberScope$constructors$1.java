package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaClassMemberScope$constructors$1 extends Lambda implements Function0<List<? extends ClassConstructorDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaClassMemberScope f24611g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyJavaResolverContext f24612h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$constructors$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(0);
        this.f24611g = lazyJavaClassMemberScope;
        this.f24612h = lazyJavaResolverContext;
    }

    @NotNull
    public final List<ClassConstructorDescriptor> invoke() {
        Collection<JavaConstructor> constructors = this.f24611g.jClass.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (JavaConstructor access$resolveConstructor : constructors) {
            arrayList.add(this.f24611g.resolveConstructor(access$resolveConstructor));
        }
        if (this.f24611g.jClass.isRecord()) {
            ClassConstructorDescriptor access$createDefaultRecordConstructor = this.f24611g.createDefaultRecordConstructor();
            boolean z11 = false;
            String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(access$createDefaultRecordConstructor, false, false, 2, (Object) null);
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (Intrinsics.areEqual((Object) MethodSignatureMappingKt.computeJvmDescriptor$default((ClassConstructorDescriptor) it.next(), false, false, 2, (Object) null), (Object) computeJvmDescriptor$default)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z11 = true;
            if (z11) {
                arrayList.add(access$createDefaultRecordConstructor);
                this.f24612h.getComponents().getJavaResolverCache().recordConstructor(this.f24611g.jClass, access$createDefaultRecordConstructor);
            }
        }
        this.f24612h.getComponents().getSyntheticPartsProvider().generateConstructors(this.f24611g.getOwnerDescriptor(), arrayList);
        SignatureEnhancement signatureEnhancement = this.f24612h.getComponents().getSignatureEnhancement();
        LazyJavaResolverContext lazyJavaResolverContext = this.f24612h;
        LazyJavaClassMemberScope lazyJavaClassMemberScope = this.f24611g;
        boolean isEmpty = arrayList.isEmpty();
        Collection collection = arrayList;
        if (isEmpty) {
            collection = CollectionsKt__CollectionsKt.listOfNotNull(lazyJavaClassMemberScope.createDefaultConstructor());
        }
        return CollectionsKt___CollectionsKt.toList(signatureEnhancement.enhanceSignatures(lazyJavaResolverContext, collection));
    }
}
