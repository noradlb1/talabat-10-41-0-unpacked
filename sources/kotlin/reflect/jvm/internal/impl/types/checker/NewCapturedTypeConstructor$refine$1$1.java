package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

public final class NewCapturedTypeConstructor$refine$1$1 extends Lambda implements Function0<List<? extends UnwrappedType>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NewCapturedTypeConstructor f24968g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ KotlinTypeRefiner f24969h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewCapturedTypeConstructor$refine$1$1(NewCapturedTypeConstructor newCapturedTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
        super(0);
        this.f24968g = newCapturedTypeConstructor;
        this.f24969h = kotlinTypeRefiner;
    }

    @NotNull
    public final List<UnwrappedType> invoke() {
        Iterable<UnwrappedType> supertypes = this.f24968g.getSupertypes();
        KotlinTypeRefiner kotlinTypeRefiner = this.f24969h;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(supertypes, 10));
        for (UnwrappedType refine : supertypes) {
            arrayList.add(refine.refine(kotlinTypeRefiner));
        }
        return arrayList;
    }
}
