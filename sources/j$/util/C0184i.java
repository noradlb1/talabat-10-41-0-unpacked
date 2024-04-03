package j$.util;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* renamed from: j$.util.i  reason: case insensitive filesystem */
public abstract class C0184i {
    public static Optional a(Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? Optional.of(optional.get()) : Optional.empty();
    }

    public static C0185j b(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        return optionalDouble.isPresent() ? C0185j.d(optionalDouble.getAsDouble()) : C0185j.a();
    }

    public static C0186k c(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        return optionalInt.isPresent() ? C0186k.d(optionalInt.getAsInt()) : C0186k.a();
    }

    public static C0187l d(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        return optionalLong.isPresent() ? C0187l.d(optionalLong.getAsLong()) : C0187l.a();
    }

    public static Optional e(Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? Optional.of(optional.get()) : Optional.empty();
    }

    public static OptionalDouble f(C0185j jVar) {
        if (jVar == null) {
            return null;
        }
        return jVar.c() ? OptionalDouble.of(jVar.b()) : OptionalDouble.empty();
    }

    public static OptionalInt g(C0186k kVar) {
        if (kVar == null) {
            return null;
        }
        return kVar.c() ? OptionalInt.of(kVar.b()) : OptionalInt.empty();
    }

    public static OptionalLong h(C0187l lVar) {
        if (lVar == null) {
            return null;
        }
        return lVar.c() ? OptionalLong.of(lVar.b()) : OptionalLong.empty();
    }
}
