package net.bytebuddy.dynamic.loading;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

public interface PackageDefinitionStrategy {

    public interface Definition {

        public static class Simple implements Definition {

            /* renamed from: b  reason: collision with root package name */
            public final URL f27198b;
            private final String implementationTitle;
            private final String implementationVendor;
            private final String implementationVersion;
            private final String specificationTitle;
            private final String specificationVendor;
            private final String specificationVersion;

            public Simple(String str, String str2, String str3, String str4, String str5, String str6, URL url) {
                this.specificationTitle = str;
                this.specificationVersion = str2;
                this.specificationVendor = str3;
                this.implementationTitle = str4;
                this.implementationVersion = str5;
                this.implementationVendor = str6;
                this.f27198b = url;
            }

            @SuppressFBWarnings(justification = "Package sealing relies on URL equality", value = {"DMI_BLOCKING_METHODS_ON_URL"})
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Simple simple = (Simple) obj;
                String str = this.specificationTitle;
                if (str == null ? simple.specificationTitle == null : str.equals(simple.specificationTitle)) {
                    String str2 = this.specificationVersion;
                    if (str2 == null ? simple.specificationVersion == null : str2.equals(simple.specificationVersion)) {
                        String str3 = this.specificationVendor;
                        if (str3 == null ? simple.specificationVendor == null : str3.equals(simple.specificationVendor)) {
                            String str4 = this.implementationTitle;
                            if (str4 == null ? simple.implementationTitle == null : str4.equals(simple.implementationTitle)) {
                                String str5 = this.implementationVersion;
                                if (str5 == null ? simple.implementationVersion == null : str5.equals(simple.implementationVersion)) {
                                    String str6 = this.implementationVendor;
                                    if (str6 == null ? simple.implementationVendor == null : str6.equals(simple.implementationVendor)) {
                                        URL url = this.f27198b;
                                        if (url != null) {
                                            if (url.equals(simple.f27198b)) {
                                                return true;
                                            }
                                        } else if (simple.f27198b == null) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }

            public String getImplementationTitle() {
                return this.implementationTitle;
            }

            public String getImplementationVendor() {
                return this.implementationVendor;
            }

            public String getImplementationVersion() {
                return this.implementationVersion;
            }

            public URL getSealBase() {
                return this.f27198b;
            }

            public String getSpecificationTitle() {
                return this.specificationTitle;
            }

            public String getSpecificationVendor() {
                return this.specificationVendor;
            }

            public String getSpecificationVersion() {
                return this.specificationVersion;
            }

            @SuppressFBWarnings(justification = "Package sealing relies on URL equality", value = {"DMI_BLOCKING_METHODS_ON_URL"})
            public int hashCode() {
                int i11;
                int i12;
                int i13;
                int i14;
                int i15;
                int i16;
                String str = this.specificationTitle;
                int i17 = 0;
                if (str != null) {
                    i11 = str.hashCode();
                } else {
                    i11 = 0;
                }
                int i18 = i11 * 31;
                String str2 = this.specificationVersion;
                if (str2 != null) {
                    i12 = str2.hashCode();
                } else {
                    i12 = 0;
                }
                int i19 = (i18 + i12) * 31;
                String str3 = this.specificationVendor;
                if (str3 != null) {
                    i13 = str3.hashCode();
                } else {
                    i13 = 0;
                }
                int i21 = (i19 + i13) * 31;
                String str4 = this.implementationTitle;
                if (str4 != null) {
                    i14 = str4.hashCode();
                } else {
                    i14 = 0;
                }
                int i22 = (i21 + i14) * 31;
                String str5 = this.implementationVersion;
                if (str5 != null) {
                    i15 = str5.hashCode();
                } else {
                    i15 = 0;
                }
                int i23 = (i22 + i15) * 31;
                String str6 = this.implementationVendor;
                if (str6 != null) {
                    i16 = str6.hashCode();
                } else {
                    i16 = 0;
                }
                int i24 = (i23 + i16) * 31;
                URL url = this.f27198b;
                if (url != null) {
                    i17 = url.hashCode();
                }
                return i24 + i17;
            }

            public boolean isCompatibleTo(Package packageR) {
                URL url = this.f27198b;
                if (url == null) {
                    return !packageR.isSealed();
                }
                return packageR.isSealed(url);
            }

            public boolean isDefined() {
                return true;
            }
        }

        public enum Trivial implements Definition {
            INSTANCE;
            
            private static final URL NOT_SEALED = null;
            private static final String NO_VALUE = null;

            /* access modifiers changed from: public */
            static {
                NO_VALUE = null;
                NOT_SEALED = null;
            }

            public String getImplementationTitle() {
                return NO_VALUE;
            }

            public String getImplementationVendor() {
                return NO_VALUE;
            }

            public String getImplementationVersion() {
                return NO_VALUE;
            }

            public URL getSealBase() {
                return NOT_SEALED;
            }

            public String getSpecificationTitle() {
                return NO_VALUE;
            }

            public String getSpecificationVendor() {
                return NO_VALUE;
            }

            public String getSpecificationVersion() {
                return NO_VALUE;
            }

            public boolean isCompatibleTo(Package packageR) {
                return true;
            }

            public boolean isDefined() {
                return true;
            }
        }

        public enum Undefined implements Definition {
            INSTANCE;

            public String getImplementationTitle() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public String getImplementationVendor() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public String getImplementationVersion() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public URL getSealBase() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public String getSpecificationTitle() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public String getSpecificationVendor() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public String getSpecificationVersion() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public boolean isCompatibleTo(Package packageR) {
                throw new IllegalStateException("Cannot check compatibility to undefined package");
            }

            public boolean isDefined() {
                return false;
            }
        }

        String getImplementationTitle();

        String getImplementationVendor();

        String getImplementationVersion();

        URL getSealBase();

        String getSpecificationTitle();

        String getSpecificationVendor();

        String getSpecificationVersion();

        boolean isCompatibleTo(Package packageR);

        boolean isDefined();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ManifestReading implements PackageDefinitionStrategy {
        private static final Attributes.Name[] ATTRIBUTE_NAMES = {Attributes.Name.SPECIFICATION_TITLE, Attributes.Name.SPECIFICATION_VERSION, Attributes.Name.SPECIFICATION_VENDOR, Attributes.Name.IMPLEMENTATION_TITLE, Attributes.Name.IMPLEMENTATION_VERSION, Attributes.Name.IMPLEMENTATION_VENDOR, Attributes.Name.SEALED};
        /* access modifiers changed from: private */
        public static final URL NOT_SEALED = null;
        private final SealBaseLocator sealBaseLocator;

        public interface SealBaseLocator {

            public static class ForFixedValue implements SealBaseLocator {
                private final URL sealBase;

                public ForFixedValue(URL url) {
                    this.sealBase = url;
                }

                @SuppressFBWarnings(justification = "Package sealing relies on URL equality", value = {"DMI_BLOCKING_METHODS_ON_URL"})
                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    return this.sealBase.equals(((ForFixedValue) obj).sealBase);
                }

                public URL findSealBase(ClassLoader classLoader, String str) {
                    return this.sealBase;
                }

                @SuppressFBWarnings(justification = "Package sealing relies on URL equality", value = {"DMI_BLOCKING_METHODS_ON_URL"})
                public int hashCode() {
                    return this.sealBase.hashCode();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForTypeResourceUrl implements SealBaseLocator {
                private static final String CLASS_FILE_EXTENSION = ".class";
                private static final int EXCLUDE_INITIAL_SLASH = 1;
                private static final String FILE_SYSTEM = "file";
                private static final String JAR_FILE = "jar";
                private static final String RUNTIME_IMAGE = "jrt";
                private final SealBaseLocator fallback;

                public ForTypeResourceUrl() {
                    this(NonSealing.INSTANCE);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fallback.equals(((ForTypeResourceUrl) obj).fallback);
                }

                public URL findSealBase(ClassLoader classLoader, String str) {
                    URL resource = classLoader.getResource(str.replace('.', '/') + ".class");
                    if (resource != null) {
                        try {
                            if (resource.getProtocol().equals("jar")) {
                                return new URL(resource.getPath().substring(0, resource.getPath().indexOf(33)));
                            }
                            if (resource.getProtocol().equals("file")) {
                                return resource;
                            }
                            if (resource.getProtocol().equals(RUNTIME_IMAGE)) {
                                String path = resource.getPath();
                                int indexOf = path.indexOf(47, 1);
                                if (indexOf == -1) {
                                    return resource;
                                }
                                return new URL("jrt:" + path.substring(0, indexOf));
                            }
                        } catch (MalformedURLException e11) {
                            throw new IllegalStateException("Unexpected URL: " + resource, e11);
                        }
                    }
                    return this.fallback.findSealBase(classLoader, str);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.fallback.hashCode();
                }

                public ForTypeResourceUrl(SealBaseLocator sealBaseLocator) {
                    this.fallback = sealBaseLocator;
                }
            }

            public enum NonSealing implements SealBaseLocator {
                INSTANCE;

                public URL findSealBase(ClassLoader classLoader, String str) {
                    return ManifestReading.NOT_SEALED;
                }
            }

            URL findSealBase(ClassLoader classLoader, String str);
        }

        public ManifestReading() {
            this(new SealBaseLocator.ForTypeResourceUrl());
        }

        public Definition define(ClassLoader classLoader, String str, String str2) {
            URL url;
            InputStream resourceAsStream = classLoader.getResourceAsStream("META-INF/MANIFEST.MF");
            if (resourceAsStream == null) {
                return Definition.Trivial.INSTANCE;
            }
            try {
                Manifest manifest = new Manifest(resourceAsStream);
                HashMap hashMap = new HashMap();
                Attributes mainAttributes = manifest.getMainAttributes();
                if (mainAttributes != null) {
                    for (Attributes.Name name2 : ATTRIBUTE_NAMES) {
                        hashMap.put(name2, mainAttributes.getValue(name2));
                    }
                }
                Attributes attributes = manifest.getAttributes(str.replace('.', '/').concat("/"));
                if (attributes != null) {
                    for (Attributes.Name name3 : ATTRIBUTE_NAMES) {
                        String value = attributes.getValue(name3);
                        if (value != null) {
                            hashMap.put(name3, value);
                        }
                    }
                }
                String str3 = (String) hashMap.get(Attributes.Name.SPECIFICATION_TITLE);
                String str4 = (String) hashMap.get(Attributes.Name.SPECIFICATION_VERSION);
                String str5 = (String) hashMap.get(Attributes.Name.SPECIFICATION_VENDOR);
                String str6 = (String) hashMap.get(Attributes.Name.IMPLEMENTATION_TITLE);
                String str7 = (String) hashMap.get(Attributes.Name.IMPLEMENTATION_VERSION);
                String str8 = (String) hashMap.get(Attributes.Name.IMPLEMENTATION_VENDOR);
                if (Boolean.parseBoolean((String) hashMap.get(Attributes.Name.SEALED))) {
                    url = this.sealBaseLocator.findSealBase(classLoader, str2);
                } else {
                    url = NOT_SEALED;
                }
                Definition.Simple simple = new Definition.Simple(str3, str4, str5, str6, str7, str8, url);
                resourceAsStream.close();
                return simple;
            } catch (IOException e11) {
                throw new IllegalStateException("Error while reading manifest file", e11);
            } catch (Throwable th2) {
                resourceAsStream.close();
                throw th2;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.sealBaseLocator.equals(((ManifestReading) obj).sealBaseLocator);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.sealBaseLocator.hashCode();
        }

        public ManifestReading(SealBaseLocator sealBaseLocator2) {
            this.sealBaseLocator = sealBaseLocator2;
        }
    }

    public enum NoOp implements PackageDefinitionStrategy {
        INSTANCE;

        public Definition define(ClassLoader classLoader, String str, String str2) {
            return Definition.Undefined.INSTANCE;
        }
    }

    public enum Trivial implements PackageDefinitionStrategy {
        INSTANCE;

        public Definition define(ClassLoader classLoader, String str, String str2) {
            return Definition.Trivial.INSTANCE;
        }
    }

    Definition define(ClassLoader classLoader, String str, String str2);
}
