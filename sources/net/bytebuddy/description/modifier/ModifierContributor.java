package net.bytebuddy.description.modifier;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

public interface ModifierContributor {
    public static final int EMPTY_MASK = 0;

    public interface ForField extends ModifierContributor {
        public static final int MASK = 151775;
    }

    public interface ForMethod extends ModifierContributor {
        public static final int MASK = 7679;
    }

    public interface ForParameter extends ModifierContributor {
        public static final int MASK = 36880;
    }

    public interface ForType extends ModifierContributor {
        public static final int MASK = 161311;
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Resolver<T extends ModifierContributor> {
        private final Collection<? extends T> modifierContributors;

        public Resolver(Collection<? extends T> collection) {
            this.modifierContributors = collection;
        }

        public static Resolver<ForType> of(ForType... forTypeArr) {
            return of(Arrays.asList(forTypeArr));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.modifierContributors.equals(((Resolver) obj).modifierContributors);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.modifierContributors.hashCode();
        }

        public int resolve() {
            return resolve(0);
        }

        public static Resolver<ForField> of(ForField... forFieldArr) {
            return of(Arrays.asList(forFieldArr));
        }

        public int resolve(int i11) {
            Iterator<? extends T> it = this.modifierContributors.iterator();
            while (it.hasNext()) {
                ModifierContributor modifierContributor = (ModifierContributor) it.next();
                i11 = (i11 & (~modifierContributor.getRange())) | modifierContributor.getMask();
            }
            return i11;
        }

        public static Resolver<ForMethod> of(ForMethod... forMethodArr) {
            return of(Arrays.asList(forMethodArr));
        }

        public static Resolver<ForParameter> of(ForParameter... forParameterArr) {
            return of(Arrays.asList(forParameterArr));
        }

        public static <S extends ModifierContributor> Resolver<S> of(Collection<? extends S> collection) {
            return new Resolver<>(collection);
        }
    }

    int getMask();

    int getRange();

    boolean isDefault();
}
