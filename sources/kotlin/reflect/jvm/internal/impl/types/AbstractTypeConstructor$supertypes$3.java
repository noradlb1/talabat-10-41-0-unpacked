package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import org.jetbrains.annotations.NotNull;

public final class AbstractTypeConstructor$supertypes$3 extends Lambda implements Function1<AbstractTypeConstructor.Supertypes, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AbstractTypeConstructor f24936g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$supertypes$3(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.f24936g = abstractTypeConstructor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AbstractTypeConstructor.Supertypes) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AbstractTypeConstructor.Supertypes supertypes) {
        Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        Collection<KotlinType> findLoopsInSupertypesAndDisconnect = this.f24936g.g().findLoopsInSupertypesAndDisconnect(this.f24936g, supertypes.getAllSupertypes(), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(this.f24936g), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(this.f24936g));
        List list = null;
        if (findLoopsInSupertypesAndDisconnect.isEmpty()) {
            KotlinType d11 = this.f24936g.d();
            List listOf = d11 != null ? CollectionsKt__CollectionsJVMKt.listOf(d11) : null;
            if (listOf == null) {
                listOf = CollectionsKt__CollectionsKt.emptyList();
            }
            findLoopsInSupertypesAndDisconnect = listOf;
        }
        if (this.f24936g.f()) {
            SupertypeLoopChecker g11 = this.f24936g.g();
            final AbstractTypeConstructor abstractTypeConstructor = this.f24936g;
            AnonymousClass2 r42 = new Function1<TypeConstructor, Iterable<? extends KotlinType>>() {
                @NotNull
                public final Iterable<KotlinType> invoke(@NotNull TypeConstructor typeConstructor) {
                    Intrinsics.checkNotNullParameter(typeConstructor, "it");
                    return abstractTypeConstructor.computeNeighbours(typeConstructor, true);
                }
            };
            final AbstractTypeConstructor abstractTypeConstructor2 = this.f24936g;
            g11.findLoopsInSupertypesAndDisconnect(abstractTypeConstructor, findLoopsInSupertypesAndDisconnect, r42, new Function1<KotlinType, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((KotlinType) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull KotlinType kotlinType) {
                    Intrinsics.checkNotNullParameter(kotlinType, "it");
                    abstractTypeConstructor2.i(kotlinType);
                }
            });
        }
        AbstractTypeConstructor abstractTypeConstructor3 = this.f24936g;
        if (findLoopsInSupertypesAndDisconnect instanceof List) {
            list = (List) findLoopsInSupertypesAndDisconnect;
        }
        if (list == null) {
            list = CollectionsKt___CollectionsKt.toList(findLoopsInSupertypesAndDisconnect);
        }
        supertypes.setSupertypesWithoutCycles(abstractTypeConstructor3.h(list));
    }
}
