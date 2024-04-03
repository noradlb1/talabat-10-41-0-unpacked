package net.bytebuddy.dynamic.scaffold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.LatentMatcher;

public interface FieldRegistry {

    public interface Compiled extends TypeWriter.FieldPool {

        public enum NoOp implements Compiled {
            INSTANCE;

            public TypeWriter.FieldPool.Record target(FieldDescription fieldDescription) {
                return new TypeWriter.FieldPool.Record.ForImplicitField(fieldDescription);
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements FieldRegistry {
        private final List<Entry> entries;

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compiled implements Compiled {
            private final List<Entry> entries;
            private final TypeDescription instrumentedType;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Entry implements ElementMatcher<FieldDescription> {
                private final Object defaultValue;
                private final FieldAttributeAppender fieldAttributeAppender;
                private final ElementMatcher<? super FieldDescription> matcher;
                private final Transformer<FieldDescription> transformer;

                public Entry(ElementMatcher<? super FieldDescription> elementMatcher, FieldAttributeAppender fieldAttributeAppender2, Object obj, Transformer<FieldDescription> transformer2) {
                    this.matcher = elementMatcher;
                    this.fieldAttributeAppender = fieldAttributeAppender2;
                    this.defaultValue = obj;
                    this.transformer = transformer2;
                }

                public TypeWriter.FieldPool.Record a(TypeDescription typeDescription, FieldDescription fieldDescription) {
                    return new TypeWriter.FieldPool.Record.ForExplicitField(this.fieldAttributeAppender, this.defaultValue, this.transformer.transform(typeDescription, fieldDescription));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Entry entry = (Entry) obj;
                    return this.matcher.equals(entry.matcher) && this.fieldAttributeAppender.equals(entry.fieldAttributeAppender) && this.defaultValue.equals(entry.defaultValue) && this.transformer.equals(entry.transformer);
                }

                public int hashCode() {
                    return (((((((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.fieldAttributeAppender.hashCode()) * 31) + this.defaultValue.hashCode()) * 31) + this.transformer.hashCode();
                }

                public boolean matches(FieldDescription fieldDescription) {
                    return this.matcher.matches(fieldDescription);
                }
            }

            public Compiled(TypeDescription typeDescription, List<Entry> list) {
                this.instrumentedType = typeDescription;
                this.entries = list;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Compiled compiled = (Compiled) obj;
                return this.instrumentedType.equals(compiled.instrumentedType) && this.entries.equals(compiled.entries);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.entries.hashCode();
            }

            public TypeWriter.FieldPool.Record target(FieldDescription fieldDescription) {
                for (Entry next : this.entries) {
                    if (next.matches(fieldDescription)) {
                        return next.a(this.instrumentedType, fieldDescription);
                    }
                }
                return new TypeWriter.FieldPool.Record.ForImplicitField(fieldDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Entry implements LatentMatcher<FieldDescription> {
            private final Object defaultValue;
            private final FieldAttributeAppender.Factory fieldAttributeAppenderFactory;
            private final LatentMatcher<? super FieldDescription> matcher;
            private final Transformer<FieldDescription> transformer;

            public Entry(LatentMatcher<? super FieldDescription> latentMatcher, FieldAttributeAppender.Factory factory, Object obj, Transformer<FieldDescription> transformer2) {
                this.matcher = latentMatcher;
                this.fieldAttributeAppenderFactory = factory;
                this.defaultValue = obj;
                this.transformer = transformer2;
            }

            public Object a() {
                return this.defaultValue;
            }

            public FieldAttributeAppender.Factory b() {
                return this.fieldAttributeAppenderFactory;
            }

            public Transformer<FieldDescription> c() {
                return this.transformer;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Entry entry = (Entry) obj;
                return this.matcher.equals(entry.matcher) && this.fieldAttributeAppenderFactory.equals(entry.fieldAttributeAppenderFactory) && this.defaultValue.equals(entry.defaultValue) && this.transformer.equals(entry.transformer);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.fieldAttributeAppenderFactory.hashCode()) * 31) + this.defaultValue.hashCode()) * 31) + this.transformer.hashCode();
            }

            public ElementMatcher<? super FieldDescription> resolve(TypeDescription typeDescription) {
                return this.matcher.resolve(typeDescription);
            }
        }

        public Default() {
            this(Collections.emptyList());
        }

        public Compiled compile(TypeDescription typeDescription) {
            ArrayList arrayList = new ArrayList(this.entries.size());
            HashMap hashMap = new HashMap();
            for (Entry next : this.entries) {
                FieldAttributeAppender fieldAttributeAppender = (FieldAttributeAppender) hashMap.get(next.b());
                if (fieldAttributeAppender == null) {
                    fieldAttributeAppender = next.b().make(typeDescription);
                    hashMap.put(next.b(), fieldAttributeAppender);
                }
                arrayList.add(new Compiled.Entry(next.resolve(typeDescription), fieldAttributeAppender, next.a(), next.c()));
            }
            return new Compiled(typeDescription, arrayList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.entries.equals(((Default) obj).entries);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.entries.hashCode();
        }

        public FieldRegistry prepend(LatentMatcher<? super FieldDescription> latentMatcher, FieldAttributeAppender.Factory factory, Object obj, Transformer<FieldDescription> transformer) {
            ArrayList arrayList = new ArrayList(this.entries.size() + 1);
            arrayList.add(new Entry(latentMatcher, factory, obj, transformer));
            arrayList.addAll(this.entries);
            return new Default(arrayList);
        }

        private Default(List<Entry> list) {
            this.entries = list;
        }
    }

    Compiled compile(TypeDescription typeDescription);

    FieldRegistry prepend(LatentMatcher<? super FieldDescription> latentMatcher, FieldAttributeAppender.Factory factory, Object obj, Transformer<FieldDescription> transformer);
}
