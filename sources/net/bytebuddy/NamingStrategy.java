package net.bytebuddy;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.utility.RandomString;

public interface NamingStrategy {

    public static abstract class AbstractBase implements NamingStrategy {
        public abstract String a(TypeDescription typeDescription);

        public String rebase(TypeDescription typeDescription) {
            return typeDescription.getName();
        }

        public String redefine(TypeDescription typeDescription) {
            return typeDescription.getName();
        }

        public String subclass(TypeDescription.Generic generic) {
            return a(generic.asErasure());
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class PrefixingRandom extends AbstractBase {
        private final String prefix;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
        private final RandomString randomString = new RandomString();

        public PrefixingRandom(String str) {
            this.prefix = str;
        }

        public String a(TypeDescription typeDescription) {
            return this.prefix + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + typeDescription.getName() + "$" + this.randomString.nextString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.prefix.equals(((PrefixingRandom) obj).prefix);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.prefix.hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class SuffixingRandom extends AbstractBase {
        public static final String BYTE_BUDDY_RENAME_PACKAGE = "net.bytebuddy.renamed";
        private static final String JAVA_PACKAGE = "java.";
        public static final String NO_PREFIX = "";
        private final BaseNameResolver baseNameResolver;
        private final String javaLangPackagePrefix;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
        private final RandomString randomString;
        private final String suffix;

        public interface BaseNameResolver {

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForFixedValue implements BaseNameResolver {

                /* renamed from: name  reason: collision with root package name */
                private final String f26920name;

                public ForFixedValue(String str) {
                    this.f26920name = str;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.f26920name.equals(((ForFixedValue) obj).f26920name);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.f26920name.hashCode();
                }

                public String resolve(TypeDescription typeDescription) {
                    return this.f26920name;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForGivenType implements BaseNameResolver {
                private final TypeDescription typeDescription;

                public ForGivenType(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForGivenType) obj).typeDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                }

                public String resolve(TypeDescription typeDescription2) {
                    return this.typeDescription.getName();
                }
            }

            public enum ForUnnamedType implements BaseNameResolver {
                INSTANCE;

                public String resolve(TypeDescription typeDescription) {
                    return typeDescription.getName();
                }
            }

            String resolve(TypeDescription typeDescription);
        }

        public SuffixingRandom(String str) {
            this(str, (BaseNameResolver) BaseNameResolver.ForUnnamedType.INSTANCE);
        }

        public String a(TypeDescription typeDescription) {
            String resolve = this.baseNameResolver.resolve(typeDescription);
            if (resolve.startsWith(JAVA_PACKAGE) && !this.javaLangPackagePrefix.equals("")) {
                resolve = this.javaLangPackagePrefix + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + resolve;
            }
            return resolve + "$" + this.suffix + "$" + this.randomString.nextString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SuffixingRandom suffixingRandom = (SuffixingRandom) obj;
            return this.suffix.equals(suffixingRandom.suffix) && this.javaLangPackagePrefix.equals(suffixingRandom.javaLangPackagePrefix) && this.baseNameResolver.equals(suffixingRandom.baseNameResolver);
        }

        public int hashCode() {
            return (((((getClass().hashCode() * 31) + this.suffix.hashCode()) * 31) + this.javaLangPackagePrefix.hashCode()) * 31) + this.baseNameResolver.hashCode();
        }

        public SuffixingRandom(String str, String str2) {
            this(str, BaseNameResolver.ForUnnamedType.INSTANCE, str2);
        }

        public SuffixingRandom(String str, BaseNameResolver baseNameResolver2) {
            this(str, baseNameResolver2, BYTE_BUDDY_RENAME_PACKAGE);
        }

        public SuffixingRandom(String str, BaseNameResolver baseNameResolver2, String str2) {
            this.suffix = str;
            this.baseNameResolver = baseNameResolver2;
            this.javaLangPackagePrefix = str2;
            this.randomString = new RandomString();
        }
    }

    String rebase(TypeDescription typeDescription);

    String redefine(TypeDescription typeDescription);

    String subclass(TypeDescription.Generic generic);
}
