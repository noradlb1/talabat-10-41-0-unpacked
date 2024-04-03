package net.bytebuddy.dynamic;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.MethodManifestation;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.description.type.TypeVariableToken;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import net.bytebuddy.dynamic.scaffold.ClassWriterStrategy;
import net.bytebuddy.dynamic.scaffold.FieldRegistry;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.dynamic.scaffold.RecordComponentRegistry;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.implementation.EqualsMethod;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.HashCodeMethod;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.ToStringMethod;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.implementation.attribute.RecordComponentAttributeAppender;
import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.FileSystem;

public interface DynamicType {

    public interface Builder<T> {

        public static abstract class AbstractBase<S> implements Builder<S> {

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Adapter<U> extends AbstractBase<U> {

                /* renamed from: a  reason: collision with root package name */
                public final InstrumentedType.WithFlexibleName f27132a;

                /* renamed from: b  reason: collision with root package name */
                public final FieldRegistry f27133b;

                /* renamed from: c  reason: collision with root package name */
                public final MethodRegistry f27134c;

                /* renamed from: d  reason: collision with root package name */
                public final RecordComponentRegistry f27135d;

                /* renamed from: e  reason: collision with root package name */
                public final TypeAttributeAppender f27136e;

                /* renamed from: f  reason: collision with root package name */
                public final AsmVisitorWrapper f27137f;

                /* renamed from: g  reason: collision with root package name */
                public final ClassFileVersion f27138g;

                /* renamed from: h  reason: collision with root package name */
                public final AuxiliaryType.NamingStrategy f27139h;

                /* renamed from: i  reason: collision with root package name */
                public final AnnotationValueFilter.Factory f27140i;

                /* renamed from: j  reason: collision with root package name */
                public final AnnotationRetention f27141j;

                /* renamed from: k  reason: collision with root package name */
                public final Implementation.Context.Factory f27142k;

                /* renamed from: l  reason: collision with root package name */
                public final MethodGraph.Compiler f27143l;

                /* renamed from: m  reason: collision with root package name */
                public final TypeValidation f27144m;

                /* renamed from: n  reason: collision with root package name */
                public final VisibilityBridgeStrategy f27145n;

                /* renamed from: o  reason: collision with root package name */
                public final ClassWriterStrategy f27146o;

                /* renamed from: p  reason: collision with root package name */
                public final LatentMatcher<? super MethodDescription> f27147p;

                /* renamed from: q  reason: collision with root package name */
                public final List<? extends DynamicType> f27148q;

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class InnerTypeDefinitionForMethodAdapter extends Delegator<U> implements InnerTypeDefinition<U> {
                    private final MethodDescription.InDefinedShape methodDescription;

                    public InnerTypeDefinitionForMethodAdapter(MethodDescription.InDefinedShape inDefinedShape) {
                        this.methodDescription = inDefinedShape;
                    }

                    public Builder<U> a() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withLocalClass = adapter.f27132a.withDeclaringType(TypeDescription.UNDEFINED).withEnclosingMethod(this.methodDescription).withLocalClass(true);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.a(withLocalClass, adapter3.f27133b, adapter3.f27134c, adapter3.f27135d, adapter3.f27136e, adapter3.f27137f, adapter3.f27138g, adapter3.f27139h, adapter3.f27140i, adapter3.f27141j, adapter3.f27142k, adapter3.f27143l, adapter3.f27144m, adapter3.f27145n, adapter5.f27146o, adapter5.f27147p, adapter5.f27148q);
                    }

                    public Builder<U> asAnonymousType() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withAnonymousClass = adapter.f27132a.withDeclaringType(TypeDescription.UNDEFINED).withEnclosingMethod(this.methodDescription).withAnonymousClass(true);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.a(withAnonymousClass, adapter3.f27133b, adapter3.f27134c, adapter3.f27135d, adapter3.f27136e, adapter3.f27137f, adapter3.f27138g, adapter3.f27139h, adapter3.f27140i, adapter3.f27141j, adapter3.f27142k, adapter3.f27143l, adapter3.f27144m, adapter3.f27145n, adapter5.f27146o, adapter5.f27147p, adapter5.f27148q);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        InnerTypeDefinitionForMethodAdapter innerTypeDefinitionForMethodAdapter = (InnerTypeDefinitionForMethodAdapter) obj;
                        return this.methodDescription.equals(innerTypeDefinitionForMethodAdapter.methodDescription) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + Adapter.this.hashCode();
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class InnerTypeDefinitionForTypeAdapter extends Delegator<U> implements InnerTypeDefinition.ForType<U> {
                    private final TypeDescription typeDescription;

                    public InnerTypeDefinitionForTypeAdapter(TypeDescription typeDescription2) {
                        this.typeDescription = typeDescription2;
                    }

                    public Builder<U> a() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withLocalClass = adapter.f27132a.withDeclaringType(TypeDescription.UNDEFINED).withEnclosingType(this.typeDescription).withLocalClass(true);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.a(withLocalClass, adapter3.f27133b, adapter3.f27134c, adapter3.f27135d, adapter3.f27136e, adapter3.f27137f, adapter3.f27138g, adapter3.f27139h, adapter3.f27140i, adapter3.f27141j, adapter3.f27142k, adapter3.f27143l, adapter3.f27144m, adapter3.f27145n, adapter5.f27146o, adapter5.f27147p, adapter5.f27148q);
                    }

                    public Builder<U> asAnonymousType() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withAnonymousClass = adapter.f27132a.withDeclaringType(TypeDescription.UNDEFINED).withEnclosingType(this.typeDescription).withAnonymousClass(true);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.a(withAnonymousClass, adapter3.f27133b, adapter3.f27134c, adapter3.f27135d, adapter3.f27136e, adapter3.f27137f, adapter3.f27138g, adapter3.f27139h, adapter3.f27140i, adapter3.f27141j, adapter3.f27142k, adapter3.f27143l, adapter3.f27144m, adapter3.f27145n, adapter5.f27146o, adapter5.f27147p, adapter5.f27148q);
                    }

                    public Builder<U> asMemberType() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withLocalClass = adapter.f27132a.withDeclaringType(this.typeDescription).withEnclosingType(this.typeDescription).withAnonymousClass(false).withLocalClass(false);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.a(withLocalClass, adapter3.f27133b, adapter3.f27134c, adapter3.f27135d, adapter3.f27136e, adapter3.f27137f, adapter3.f27138g, adapter3.f27139h, adapter3.f27140i, adapter3.f27141j, adapter3.f27142k, adapter3.f27143l, adapter3.f27144m, adapter3.f27145n, adapter5.f27146o, adapter5.f27147p, adapter5.f27148q);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        InnerTypeDefinitionForTypeAdapter innerTypeDefinitionForTypeAdapter = (InnerTypeDefinitionForTypeAdapter) obj;
                        return this.typeDescription.equals(innerTypeDefinitionForTypeAdapter.typeDescription) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.typeDescription.hashCode()) * 31) + Adapter.this.hashCode();
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class MethodDefinitionAdapter extends MethodDefinition.ParameterDefinition.Initial.AbstractBase<U> {
                    /* access modifiers changed from: private */
                    public final MethodDescription.Token token;

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class ParameterAnnotationAdapter extends MethodDefinition.ParameterDefinition.Annotatable.AbstractBase.Adapter<U> {
                        private final ParameterDescription.Token token;

                        public ParameterAnnotationAdapter(ParameterDescription.Token token2) {
                            this.token = token2;
                        }

                        public MethodDefinition.ParameterDefinition<U> a() {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new MethodDefinitionAdapter(new MethodDescription.Token(methodDefinitionAdapter.token.getName(), MethodDefinitionAdapter.this.token.getModifiers(), MethodDefinitionAdapter.this.token.getTypeVariableTokens(), MethodDefinitionAdapter.this.token.getReturnType(), CompoundList.of(MethodDefinitionAdapter.this.token.getParameterTokens(), this.token), MethodDefinitionAdapter.this.token.getExceptionTypes(), MethodDefinitionAdapter.this.token.getAnnotations(), MethodDefinitionAdapter.this.token.getDefaultValue(), MethodDefinitionAdapter.this.token.getReceiverType()));
                        }

                        public MethodDefinition.ParameterDefinition.Annotatable<U> annotateParameter(Collection<? extends AnnotationDescription> collection) {
                            return new ParameterAnnotationAdapter(new ParameterDescription.Token(this.token.getType(), CompoundList.of(this.token.getAnnotations(), (AnnotationList) new ArrayList(collection)), this.token.getName(), this.token.getModifiers()));
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            ParameterAnnotationAdapter parameterAnnotationAdapter = (ParameterAnnotationAdapter) obj;
                            return this.token.equals(parameterAnnotationAdapter.token) && MethodDefinitionAdapter.this.equals(MethodDefinitionAdapter.this);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.token.hashCode()) * 31) + MethodDefinitionAdapter.this.hashCode();
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class SimpleParameterAnnotationAdapter extends MethodDefinition.ParameterDefinition.Simple.Annotatable.AbstractBase.Adapter<U> {
                        private final ParameterDescription.Token token;

                        public SimpleParameterAnnotationAdapter(ParameterDescription.Token token2) {
                            this.token = token2;
                        }

                        public MethodDefinition.ParameterDefinition.Simple<U> a() {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new MethodDefinitionAdapter(new MethodDescription.Token(methodDefinitionAdapter.token.getName(), MethodDefinitionAdapter.this.token.getModifiers(), MethodDefinitionAdapter.this.token.getTypeVariableTokens(), MethodDefinitionAdapter.this.token.getReturnType(), CompoundList.of(MethodDefinitionAdapter.this.token.getParameterTokens(), this.token), MethodDefinitionAdapter.this.token.getExceptionTypes(), MethodDefinitionAdapter.this.token.getAnnotations(), MethodDefinitionAdapter.this.token.getDefaultValue(), MethodDefinitionAdapter.this.token.getReceiverType()));
                        }

                        public MethodDefinition.ParameterDefinition.Simple.Annotatable<U> annotateParameter(Collection<? extends AnnotationDescription> collection) {
                            return new SimpleParameterAnnotationAdapter(new ParameterDescription.Token(this.token.getType(), CompoundList.of(this.token.getAnnotations(), (AnnotationList) new ArrayList(collection)), this.token.getName(), this.token.getModifiers()));
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            SimpleParameterAnnotationAdapter simpleParameterAnnotationAdapter = (SimpleParameterAnnotationAdapter) obj;
                            return this.token.equals(simpleParameterAnnotationAdapter.token) && MethodDefinitionAdapter.this.equals(MethodDefinitionAdapter.this);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.token.hashCode()) * 31) + MethodDefinitionAdapter.this.hashCode();
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class TypeVariableAnnotationAdapter extends MethodDefinition.TypeVariableDefinition.Annotatable.AbstractBase.Adapter<U> {
                        private final TypeVariableToken token;

                        public TypeVariableAnnotationAdapter(TypeVariableToken typeVariableToken) {
                            this.token = typeVariableToken;
                        }

                        public MethodDefinition.ParameterDefinition<U> a() {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new MethodDefinitionAdapter(new MethodDescription.Token(methodDefinitionAdapter.token.getName(), MethodDefinitionAdapter.this.token.getModifiers(), CompoundList.of(MethodDefinitionAdapter.this.token.getTypeVariableTokens(), this.token), MethodDefinitionAdapter.this.token.getReturnType(), MethodDefinitionAdapter.this.token.getParameterTokens(), MethodDefinitionAdapter.this.token.getExceptionTypes(), MethodDefinitionAdapter.this.token.getAnnotations(), MethodDefinitionAdapter.this.token.getDefaultValue(), MethodDefinitionAdapter.this.token.getReceiverType()));
                        }

                        public MethodDefinition.TypeVariableDefinition.Annotatable<U> annotateTypeVariable(Collection<? extends AnnotationDescription> collection) {
                            return new TypeVariableAnnotationAdapter(new TypeVariableToken(this.token.getSymbol(), this.token.getBounds(), CompoundList.of(this.token.getAnnotations(), (AnnotationList) new ArrayList(collection))));
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            TypeVariableAnnotationAdapter typeVariableAnnotationAdapter = (TypeVariableAnnotationAdapter) obj;
                            return this.token.equals(typeVariableAnnotationAdapter.token) && MethodDefinitionAdapter.this.equals(MethodDefinitionAdapter.this);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.token.hashCode()) * 31) + MethodDefinitionAdapter.this.hashCode();
                        }
                    }

                    public MethodDefinitionAdapter(MethodDescription.Token token2) {
                        this.token = token2;
                    }

                    private MethodDefinition.ReceiverTypeDefinition<U> materialize(MethodRegistry.Handler handler) {
                        return new AnnotationAdapter(this, handler);
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> annotationValue) {
                        return new MethodDefinitionAdapter(new MethodDescription.Token(this.token.getName(), ModifierContributor.Resolver.of(MethodManifestation.ABSTRACT).resolve(this.token.getModifiers()), this.token.getTypeVariableTokens(), this.token.getReturnType(), this.token.getParameterTokens(), this.token.getExceptionTypes(), this.token.getAnnotations(), annotationValue, this.token.getReceiverType())).materialize(new MethodRegistry.Handler.ForAnnotationValue(annotationValue));
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        MethodDefinitionAdapter methodDefinitionAdapter = (MethodDefinitionAdapter) obj;
                        return this.token.equals(methodDefinitionAdapter.token) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.token.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation implementation) {
                        return materialize(new MethodRegistry.Handler.ForImplementation(implementation));
                    }

                    public MethodDefinition.ExceptionDefinition<U> throwing(Collection<? extends TypeDefinition> collection) {
                        return new MethodDefinitionAdapter(new MethodDescription.Token(this.token.getName(), this.token.getModifiers(), this.token.getTypeVariableTokens(), this.token.getReturnType(), this.token.getParameterTokens(), CompoundList.of(this.token.getExceptionTypes(), (TypeList.Generic) new TypeList.Generic.Explicit((List<? extends TypeDefinition>) new ArrayList(collection))), this.token.getAnnotations(), this.token.getDefaultValue(), this.token.getReceiverType()));
                    }

                    public MethodDefinition.TypeVariableDefinition.Annotatable<U> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                        return new TypeVariableAnnotationAdapter(new TypeVariableToken(str, new TypeList.Generic.Explicit((List<? extends TypeDefinition>) new ArrayList(collection))));
                    }

                    public MethodDefinition.ParameterDefinition.Annotatable<U> withParameter(TypeDefinition typeDefinition, String str, int i11) {
                        return new ParameterAnnotationAdapter(new ParameterDescription.Token(typeDefinition.asGenericType(), str, Integer.valueOf(i11)));
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> withoutCode() {
                        int i11;
                        Adapter adapter = Adapter.this;
                        String name2 = this.token.getName();
                        if ((this.token.getModifiers() & 256) == 0) {
                            i11 = ModifierContributor.Resolver.of(MethodManifestation.ABSTRACT).resolve(this.token.getModifiers());
                        } else {
                            i11 = this.token.getModifiers();
                        }
                        return new MethodDefinitionAdapter(new MethodDescription.Token(name2, i11, this.token.getTypeVariableTokens(), this.token.getReturnType(), this.token.getParameterTokens(), this.token.getExceptionTypes(), this.token.getAnnotations(), this.token.getDefaultValue(), this.token.getReceiverType())).materialize(MethodRegistry.Handler.ForAbstractMethod.INSTANCE);
                    }

                    public MethodDefinition.ParameterDefinition.Simple.Annotatable<U> withParameter(TypeDefinition typeDefinition) {
                        return new SimpleParameterAnnotationAdapter(new ParameterDescription.Token(typeDefinition.asGenericType()));
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class AnnotationAdapter extends MethodDefinition.AbstractBase.Adapter<U> {
                        public AnnotationAdapter(MethodDefinitionAdapter methodDefinitionAdapter, MethodRegistry.Handler handler) {
                            this(handler, MethodAttributeAppender.ForInstrumentedMethod.INCLUDING_RECEIVER, Transformer.NoOp.make());
                        }

                        public Builder<U> a() {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            Adapter adapter = Adapter.this;
                            Adapter adapter2 = adapter;
                            InstrumentedType.WithFlexibleName withMethod = adapter.f27132a.withMethod(methodDefinitionAdapter.token);
                            MethodDefinitionAdapter methodDefinitionAdapter2 = MethodDefinitionAdapter.this;
                            Adapter adapter3 = Adapter.this;
                            FieldRegistry fieldRegistry = adapter3.f27133b;
                            MethodRegistry prepend = adapter3.f27134c.prepend(new LatentMatcher.ForMethodToken(methodDefinitionAdapter2.token), this.f27167a, this.f27168b, this.f27169c);
                            Adapter adapter4 = Adapter.this;
                            return adapter2.a(withMethod, fieldRegistry, prepend, adapter4.f27135d, adapter4.f27136e, adapter4.f27137f, adapter4.f27138g, adapter4.f27139h, adapter4.f27140i, adapter4.f27141j, adapter4.f27142k, adapter4.f27143l, adapter4.f27144m, adapter4.f27145n, adapter4.f27146o, adapter4.f27147p, adapter4.f27148q);
                        }

                        public MethodDefinition<U> annotateMethod(Collection<? extends AnnotationDescription> collection) {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new AnnotationAdapter(this.f27167a, this.f27168b, this.f27169c);
                        }

                        public MethodDefinition<U> annotateParameter(int i11, Collection<? extends AnnotationDescription> collection) {
                            ArrayList arrayList = new ArrayList(MethodDefinitionAdapter.this.token.getParameterTokens());
                            arrayList.set(i11, new ParameterDescription.Token(((ParameterDescription.Token) MethodDefinitionAdapter.this.token.getParameterTokens().get(i11)).getType(), CompoundList.of(((ParameterDescription.Token) MethodDefinitionAdapter.this.token.getParameterTokens().get(i11)).getAnnotations(), (AnnotationList) new ArrayList(collection)), ((ParameterDescription.Token) MethodDefinitionAdapter.this.token.getParameterTokens().get(i11)).getName(), ((ParameterDescription.Token) MethodDefinitionAdapter.this.token.getParameterTokens().get(i11)).getModifiers()));
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new AnnotationAdapter(this.f27167a, this.f27168b, this.f27169c);
                        }

                        public MethodDefinition<U> b(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                            return new AnnotationAdapter(handler, factory, transformer);
                        }

                        public boolean equals(Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && MethodDefinitionAdapter.this.equals(MethodDefinitionAdapter.this);
                        }

                        public int hashCode() {
                            return (super.hashCode() * 31) + MethodDefinitionAdapter.this.hashCode();
                        }

                        public MethodDefinition<U> receiverType(TypeDescription.Generic generic) {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new AnnotationAdapter(this.f27167a, this.f27168b, this.f27169c);
                        }

                        public AnnotationAdapter(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                            super(handler, factory, transformer);
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class MethodMatchAdapter extends MethodDefinition.ImplementationDefinition.AbstractBase<U> {
                    /* access modifiers changed from: private */
                    public final LatentMatcher<? super MethodDescription> matcher;

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class AnnotationAdapter extends MethodDefinition.AbstractBase.Adapter<U> {
                        public AnnotationAdapter(MethodMatchAdapter methodMatchAdapter, MethodRegistry.Handler handler) {
                            this(handler, MethodAttributeAppender.NoOp.INSTANCE, Transformer.NoOp.make());
                        }

                        public Builder<U> a() {
                            MethodMatchAdapter methodMatchAdapter = MethodMatchAdapter.this;
                            Adapter adapter = Adapter.this;
                            Adapter adapter2 = adapter;
                            InstrumentedType.WithFlexibleName withFlexibleName = adapter.f27132a;
                            FieldRegistry fieldRegistry = adapter.f27133b;
                            MethodRegistry prepend = adapter.f27134c.prepend(methodMatchAdapter.matcher, this.f27167a, this.f27168b, this.f27169c);
                            Adapter adapter3 = Adapter.this;
                            return adapter2.a(withFlexibleName, fieldRegistry, prepend, adapter3.f27135d, adapter3.f27136e, adapter3.f27137f, adapter3.f27138g, adapter3.f27139h, adapter3.f27140i, adapter3.f27141j, adapter3.f27142k, adapter3.f27143l, adapter3.f27144m, adapter3.f27145n, adapter3.f27146o, adapter3.f27147p, adapter3.f27148q);
                        }

                        public MethodDefinition<U> annotateMethod(Collection<? extends AnnotationDescription> collection) {
                            return new AnnotationAdapter(this.f27167a, new MethodAttributeAppender.Factory.Compound(this.f27168b, new MethodAttributeAppender.Explicit(new ArrayList(collection))), this.f27169c);
                        }

                        public MethodDefinition<U> annotateParameter(int i11, Collection<? extends AnnotationDescription> collection) {
                            return new AnnotationAdapter(this.f27167a, new MethodAttributeAppender.Factory.Compound(this.f27168b, new MethodAttributeAppender.Explicit(i11, (List<? extends AnnotationDescription>) new ArrayList(collection))), this.f27169c);
                        }

                        public MethodDefinition<U> b(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                            return new AnnotationAdapter(handler, factory, transformer);
                        }

                        public boolean equals(Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && MethodMatchAdapter.this.equals(MethodMatchAdapter.this);
                        }

                        public int hashCode() {
                            return (super.hashCode() * 31) + MethodMatchAdapter.this.hashCode();
                        }

                        public MethodDefinition<U> receiverType(TypeDescription.Generic generic) {
                            return new AnnotationAdapter(this.f27167a, new MethodAttributeAppender.Factory.Compound(this.f27168b, new MethodAttributeAppender.ForReceiverType(generic)), this.f27169c);
                        }

                        public AnnotationAdapter(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                            super(handler, factory, transformer);
                        }
                    }

                    public MethodMatchAdapter(LatentMatcher<? super MethodDescription> latentMatcher) {
                        this.matcher = latentMatcher;
                    }

                    private MethodDefinition.ReceiverTypeDefinition<U> materialize(MethodRegistry.Handler handler) {
                        return new AnnotationAdapter(this, handler);
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> annotationValue) {
                        return materialize(new MethodRegistry.Handler.ForAnnotationValue(annotationValue));
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        MethodMatchAdapter methodMatchAdapter = (MethodMatchAdapter) obj;
                        return this.matcher.equals(methodMatchAdapter.matcher) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation implementation) {
                        return materialize(new MethodRegistry.Handler.ForImplementation(implementation));
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> withoutCode() {
                        return materialize(MethodRegistry.Handler.ForAbstractMethod.INSTANCE);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class OptionalMethodMatchAdapter extends Delegator<U> implements MethodDefinition.ImplementationDefinition.Optional<U> {
                    private final TypeList.Generic interfaces;

                    public OptionalMethodMatchAdapter(TypeList.Generic generic) {
                        this.interfaces = generic;
                    }

                    private MethodDefinition.ImplementationDefinition<U> interfaceType() {
                        ElementMatcher.Junction none = ElementMatchers.none();
                        for (TypeDescription isSuperTypeOf : this.interfaces.asErasures()) {
                            none = none.or(ElementMatchers.isSuperTypeOf(isSuperTypeOf));
                        }
                        return a().invokable((ElementMatcher<? super MethodDescription>) ElementMatchers.isDeclaredBy((ElementMatcher<? super TypeDescription>) ElementMatchers.isInterface().and(none)));
                    }

                    public Builder<U> a() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withInterfaces = adapter.f27132a.withInterfaces(this.interfaces);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.a(withInterfaces, adapter3.f27133b, adapter3.f27134c, adapter3.f27135d, adapter3.f27136e, adapter3.f27137f, adapter3.f27138g, adapter3.f27139h, adapter3.f27140i, adapter3.f27141j, adapter3.f27142k, adapter3.f27143l, adapter3.f27144m, adapter3.f27145n, adapter5.f27146o, adapter5.f27147p, adapter5.f27148q);
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> annotationValue) {
                        return interfaceType().defaultValue(annotationValue);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        OptionalMethodMatchAdapter optionalMethodMatchAdapter = (OptionalMethodMatchAdapter) obj;
                        return this.interfaces.equals(optionalMethodMatchAdapter.interfaces) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.interfaces.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation implementation) {
                        return interfaceType().intercept(implementation);
                    }

                    public MethodDefinition.ReceiverTypeDefinition<U> withoutCode() {
                        return interfaceType().withoutCode();
                    }

                    public <V> MethodDefinition.ReceiverTypeDefinition<U> defaultValue(V v11, Class<? extends V> cls) {
                        return interfaceType().defaultValue(v11, cls);
                    }
                }

                public class RecordComponentMatchAdapter extends RecordComponentDefinition.Optional.AbstractBase<U> {
                    private final LatentMatcher<? super RecordComponentDescription> matcher;
                    private final RecordComponentAttributeAppender.Factory recordComponentAttributeAppenderFactory;
                    private final Transformer<RecordComponentDescription> transformer;

                    public RecordComponentMatchAdapter(Adapter adapter, LatentMatcher<? super RecordComponentDescription> latentMatcher) {
                        this(latentMatcher, RecordComponentAttributeAppender.NoOp.INSTANCE, Transformer.NoOp.make());
                    }

                    public Builder<U> a() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withFlexibleName = adapter.f27132a;
                        FieldRegistry fieldRegistry = adapter.f27133b;
                        MethodRegistry methodRegistry = adapter.f27134c;
                        RecordComponentRegistry prepend = adapter.f27135d.prepend(this.matcher, this.recordComponentAttributeAppenderFactory, this.transformer);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.a(withFlexibleName, fieldRegistry, methodRegistry, prepend, adapter3.f27136e, adapter3.f27137f, adapter3.f27138g, adapter3.f27139h, adapter3.f27140i, adapter3.f27141j, adapter3.f27142k, adapter3.f27143l, adapter3.f27144m, adapter3.f27145n, adapter5.f27146o, adapter5.f27147p, adapter5.f27148q);
                    }

                    public RecordComponentDefinition.Optional<U> annotateRecordComponent(Collection<? extends AnnotationDescription> collection) {
                        return attribute(new RecordComponentAttributeAppender.Explicit(new ArrayList(collection)));
                    }

                    public RecordComponentDefinition.Optional<U> attribute(RecordComponentAttributeAppender.Factory factory) {
                        return new RecordComponentMatchAdapter(this.matcher, new RecordComponentAttributeAppender.Factory.Compound(this.recordComponentAttributeAppenderFactory, factory), this.transformer);
                    }

                    public RecordComponentDefinition.Optional<U> transform(Transformer<RecordComponentDescription> transformer2) {
                        return new RecordComponentMatchAdapter(this.matcher, this.recordComponentAttributeAppenderFactory, new Transformer.Compound((Transformer<S>[]) new Transformer[]{this.transformer, transformer2}));
                    }

                    public RecordComponentMatchAdapter(LatentMatcher<? super RecordComponentDescription> latentMatcher, RecordComponentAttributeAppender.Factory factory, Transformer<RecordComponentDescription> transformer2) {
                        this.matcher = latentMatcher;
                        this.recordComponentAttributeAppenderFactory = factory;
                        this.transformer = transformer2;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class TypeVariableDefinitionAdapter extends TypeVariableDefinition.AbstractBase<U> {
                    private final TypeVariableToken token;

                    public TypeVariableDefinitionAdapter(TypeVariableToken typeVariableToken) {
                        this.token = typeVariableToken;
                    }

                    public Builder<U> a() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withTypeVariable = adapter.f27132a.withTypeVariable(this.token);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.a(withTypeVariable, adapter3.f27133b, adapter3.f27134c, adapter3.f27135d, adapter3.f27136e, adapter3.f27137f, adapter3.f27138g, adapter3.f27139h, adapter3.f27140i, adapter3.f27141j, adapter3.f27142k, adapter3.f27143l, adapter3.f27144m, adapter3.f27145n, adapter5.f27146o, adapter5.f27147p, adapter5.f27148q);
                    }

                    public TypeVariableDefinition<U> annotateTypeVariable(Collection<? extends AnnotationDescription> collection) {
                        return new TypeVariableDefinitionAdapter(new TypeVariableToken(this.token.getSymbol(), this.token.getBounds(), CompoundList.of(this.token.getAnnotations(), (AnnotationList) new ArrayList(collection))));
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        TypeVariableDefinitionAdapter typeVariableDefinitionAdapter = (TypeVariableDefinitionAdapter) obj;
                        return this.token.equals(typeVariableDefinitionAdapter.token) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.token.hashCode()) * 31) + Adapter.this.hashCode();
                    }
                }

                public Adapter(InstrumentedType.WithFlexibleName withFlexibleName, FieldRegistry fieldRegistry, MethodRegistry methodRegistry, RecordComponentRegistry recordComponentRegistry, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, ClassWriterStrategy classWriterStrategy, LatentMatcher<? super MethodDescription> latentMatcher, List<? extends DynamicType> list) {
                    this.f27132a = withFlexibleName;
                    this.f27133b = fieldRegistry;
                    this.f27134c = methodRegistry;
                    this.f27135d = recordComponentRegistry;
                    this.f27136e = typeAttributeAppender;
                    this.f27137f = asmVisitorWrapper;
                    this.f27138g = classFileVersion;
                    this.f27139h = namingStrategy;
                    this.f27140i = factory;
                    this.f27141j = annotationRetention;
                    this.f27142k = factory2;
                    this.f27143l = compiler;
                    this.f27144m = typeValidation;
                    this.f27145n = visibilityBridgeStrategy;
                    this.f27146o = classWriterStrategy;
                    this.f27147p = latentMatcher;
                    this.f27148q = list;
                }

                public abstract Builder<U> a(InstrumentedType.WithFlexibleName withFlexibleName, FieldRegistry fieldRegistry, MethodRegistry methodRegistry, RecordComponentRegistry recordComponentRegistry, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, ClassWriterStrategy classWriterStrategy, LatentMatcher<? super MethodDescription> latentMatcher, List<? extends DynamicType> list);

                public Builder<U> annotateType(Collection<? extends AnnotationDescription> collection) {
                    InstrumentedType.WithFlexibleName withAnnotations = this.f27132a.withAnnotations(new ArrayList(collection));
                    InstrumentedType.WithFlexibleName withFlexibleName = withAnnotations;
                    return a(withFlexibleName, this.f27133b, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public Builder<U> attribute(TypeAttributeAppender typeAttributeAppender) {
                    InstrumentedType.WithFlexibleName withFlexibleName = this.f27132a;
                    FieldRegistry fieldRegistry = this.f27133b;
                    MethodRegistry methodRegistry = this.f27134c;
                    RecordComponentRegistry recordComponentRegistry = this.f27135d;
                    TypeAttributeAppender.Compound compound = r6;
                    TypeAttributeAppender.Compound compound2 = new TypeAttributeAppender.Compound(this.f27136e, typeAttributeAppender);
                    InstrumentedType.WithFlexibleName withFlexibleName2 = withFlexibleName;
                    return a(withFlexibleName2, fieldRegistry, methodRegistry, recordComponentRegistry, compound, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public Builder<U> declaredTypes(Collection<? extends TypeDescription> collection) {
                    InstrumentedType.WithFlexibleName withDeclaredTypes = this.f27132a.withDeclaredTypes(new TypeList.Explicit((List<? extends TypeDescription>) new ArrayList(collection)));
                    InstrumentedType.WithFlexibleName withFlexibleName = withDeclaredTypes;
                    return a(withFlexibleName, this.f27133b, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public MethodDefinition.ParameterDefinition.Initial<U> defineConstructor(int i11) {
                    return new MethodDefinitionAdapter(new MethodDescription.Token(i11));
                }

                public FieldDefinition.Optional.Valuable<U> defineField(String str, TypeDefinition typeDefinition, int i11) {
                    return new FieldDefinitionAdapter(this, new FieldDescription.Token(str, i11, typeDefinition.asGenericType()));
                }

                public MethodDefinition.ParameterDefinition.Initial<U> defineMethod(String str, TypeDefinition typeDefinition, int i11) {
                    return new MethodDefinitionAdapter(new MethodDescription.Token(str, i11, typeDefinition.asGenericType()));
                }

                public RecordComponentDefinition.Optional<U> defineRecordComponent(String str, TypeDefinition typeDefinition) {
                    return new RecordComponentDefinitionAdapter(this, new RecordComponentDescription.Token(str, typeDefinition.asGenericType()));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Adapter adapter = (Adapter) obj;
                    return this.f27141j.equals(adapter.f27141j) && this.f27144m.equals(adapter.f27144m) && this.f27132a.equals(adapter.f27132a) && this.f27133b.equals(adapter.f27133b) && this.f27134c.equals(adapter.f27134c) && this.f27135d.equals(adapter.f27135d) && this.f27136e.equals(adapter.f27136e) && this.f27137f.equals(adapter.f27137f) && this.f27138g.equals(adapter.f27138g) && this.f27139h.equals(adapter.f27139h) && this.f27140i.equals(adapter.f27140i) && this.f27142k.equals(adapter.f27142k) && this.f27143l.equals(adapter.f27143l) && this.f27145n.equals(adapter.f27145n) && this.f27146o.equals(adapter.f27146o) && this.f27147p.equals(adapter.f27147p) && this.f27148q.equals(adapter.f27148q);
                }

                public FieldDefinition.Valuable<U> field(LatentMatcher<? super FieldDescription> latentMatcher) {
                    return new FieldMatchAdapter(this, latentMatcher);
                }

                public int hashCode() {
                    return (((((((((((((((((((((((((((((((((getClass().hashCode() * 31) + this.f27132a.hashCode()) * 31) + this.f27133b.hashCode()) * 31) + this.f27134c.hashCode()) * 31) + this.f27135d.hashCode()) * 31) + this.f27136e.hashCode()) * 31) + this.f27137f.hashCode()) * 31) + this.f27138g.hashCode()) * 31) + this.f27139h.hashCode()) * 31) + this.f27140i.hashCode()) * 31) + this.f27141j.hashCode()) * 31) + this.f27142k.hashCode()) * 31) + this.f27143l.hashCode()) * 31) + this.f27144m.hashCode()) * 31) + this.f27145n.hashCode()) * 31) + this.f27146o.hashCode()) * 31) + this.f27147p.hashCode()) * 31) + this.f27148q.hashCode();
                }

                public Builder<U> ignoreAlso(LatentMatcher<? super MethodDescription> latentMatcher) {
                    InstrumentedType.WithFlexibleName withFlexibleName = this.f27132a;
                    FieldRegistry fieldRegistry = this.f27133b;
                    MethodRegistry methodRegistry = this.f27134c;
                    RecordComponentRegistry recordComponentRegistry = this.f27135d;
                    TypeAttributeAppender typeAttributeAppender = this.f27136e;
                    AsmVisitorWrapper asmVisitorWrapper = this.f27137f;
                    ClassFileVersion classFileVersion = this.f27138g;
                    AuxiliaryType.NamingStrategy namingStrategy = this.f27139h;
                    AnnotationValueFilter.Factory factory = this.f27140i;
                    AnnotationRetention annotationRetention = this.f27141j;
                    Implementation.Context.Factory factory2 = this.f27142k;
                    MethodGraph.Compiler compiler = this.f27143l;
                    TypeValidation typeValidation = this.f27144m;
                    VisibilityBridgeStrategy visibilityBridgeStrategy = this.f27145n;
                    InstrumentedType.WithFlexibleName withFlexibleName2 = withFlexibleName;
                    ClassWriterStrategy classWriterStrategy = this.f27146o;
                    LatentMatcher.Disjunction disjunction = r0;
                    FieldRegistry fieldRegistry2 = fieldRegistry;
                    MethodRegistry methodRegistry2 = methodRegistry;
                    LatentMatcher.Disjunction disjunction2 = new LatentMatcher.Disjunction((LatentMatcher<? super S>[]) new LatentMatcher[]{this.f27147p, latentMatcher});
                    return a(withFlexibleName2, fieldRegistry2, methodRegistry2, recordComponentRegistry, typeAttributeAppender, asmVisitorWrapper, classFileVersion, namingStrategy, factory, annotationRetention, factory2, compiler, typeValidation, visibilityBridgeStrategy, classWriterStrategy, disjunction, this.f27148q);
                }

                public MethodDefinition.ImplementationDefinition.Optional<U> implement(Collection<? extends TypeDefinition> collection) {
                    return new OptionalMethodMatchAdapter(new TypeList.Generic.Explicit((List<? extends TypeDefinition>) new ArrayList(collection)));
                }

                public Builder<U> initializer(ByteCodeAppender byteCodeAppender) {
                    InstrumentedType.WithFlexibleName withInitializer = this.f27132a.withInitializer(byteCodeAppender);
                    InstrumentedType.WithFlexibleName withFlexibleName = withInitializer;
                    return a(withFlexibleName, this.f27133b, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public InnerTypeDefinition.ForType<U> innerTypeOf(TypeDescription typeDescription) {
                    return new InnerTypeDefinitionForTypeAdapter(typeDescription);
                }

                public MethodDefinition.ImplementationDefinition<U> invokable(LatentMatcher<? super MethodDescription> latentMatcher) {
                    return new MethodMatchAdapter(latentMatcher);
                }

                public Builder<U> merge(Collection<? extends ModifierContributor.ForType> collection) {
                    InstrumentedType.WithFlexibleName withModifiers = this.f27132a.withModifiers(ModifierContributor.Resolver.of(collection).resolve(this.f27132a.getModifiers()));
                    InstrumentedType.WithFlexibleName withFlexibleName = withModifiers;
                    return a(withFlexibleName, this.f27133b, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public Builder<U> modifiers(int i11) {
                    InstrumentedType.WithFlexibleName withModifiers = this.f27132a.withModifiers(i11);
                    InstrumentedType.WithFlexibleName withFlexibleName = withModifiers;
                    return a(withFlexibleName, this.f27133b, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public Builder<U> name(String str) {
                    InstrumentedType.WithFlexibleName withName = this.f27132a.withName(str);
                    InstrumentedType.WithFlexibleName withFlexibleName = withName;
                    return a(withFlexibleName, this.f27133b, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public Builder<U> nestHost(TypeDescription typeDescription) {
                    InstrumentedType.WithFlexibleName withNestHost = this.f27132a.withNestHost(typeDescription);
                    InstrumentedType.WithFlexibleName withFlexibleName = withNestHost;
                    return a(withFlexibleName, this.f27133b, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public Builder<U> nestMembers(Collection<? extends TypeDescription> collection) {
                    InstrumentedType.WithFlexibleName withNestMembers = this.f27132a.withNestMembers(new TypeList.Explicit((List<? extends TypeDescription>) new ArrayList(collection)));
                    InstrumentedType.WithFlexibleName withFlexibleName = withNestMembers;
                    return a(withFlexibleName, this.f27133b, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public Builder<U> permittedSubclass(Collection<? extends TypeDescription> collection) {
                    InstrumentedType.WithFlexibleName withPermittedSubclasses = this.f27132a.withPermittedSubclasses(new TypeList.Explicit((List<? extends TypeDescription>) new ArrayList(collection)));
                    InstrumentedType.WithFlexibleName withFlexibleName = withPermittedSubclasses;
                    return a(withFlexibleName, this.f27133b, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public RecordComponentDefinition<U> recordComponent(LatentMatcher<? super RecordComponentDescription> latentMatcher) {
                    return new RecordComponentMatchAdapter(this, latentMatcher);
                }

                public Builder<U> require(Collection<DynamicType> collection) {
                    InstrumentedType.WithFlexibleName withFlexibleName = this.f27132a;
                    FieldRegistry fieldRegistry = this.f27133b;
                    InstrumentedType.WithFlexibleName withFlexibleName2 = withFlexibleName;
                    return a(withFlexibleName2, fieldRegistry, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, CompoundList.of(this.f27148q, (List<? extends DynamicType>) new ArrayList(collection)));
                }

                public Builder<U> suffix(String str) {
                    return name(this.f27132a.getName() + "$" + str);
                }

                public TypeDescription toTypeDescription() {
                    return this.f27132a;
                }

                public Builder<U> topLevelType() {
                    InstrumentedType.WithFlexibleName withFlexibleName = this.f27132a;
                    TypeDescription typeDescription = TypeDescription.UNDEFINED;
                    InstrumentedType.WithFlexibleName withLocalClass = withFlexibleName.withDeclaringType(typeDescription).withEnclosingType(typeDescription).withLocalClass(false);
                    InstrumentedType.WithFlexibleName withFlexibleName2 = withLocalClass;
                    return a(withFlexibleName2, this.f27133b, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public Builder<U> transform(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer) {
                    InstrumentedType.WithFlexibleName withTypeVariables = this.f27132a.withTypeVariables(elementMatcher, transformer);
                    InstrumentedType.WithFlexibleName withFlexibleName = withTypeVariables;
                    return a(withFlexibleName, this.f27133b, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public TypeVariableDefinition<U> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                    return new TypeVariableDefinitionAdapter(new TypeVariableToken(str, new TypeList.Generic.Explicit((List<? extends TypeDefinition>) new ArrayList(collection))));
                }

                public Builder<U> unsealed() {
                    InstrumentedType.WithFlexibleName withPermittedSubclasses = this.f27132a.withPermittedSubclasses(TypeList.UNDEFINED);
                    InstrumentedType.WithFlexibleName withFlexibleName = withPermittedSubclasses;
                    return a(withFlexibleName, this.f27133b, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public Builder<U> visit(AsmVisitorWrapper asmVisitorWrapper) {
                    InstrumentedType.WithFlexibleName withFlexibleName = this.f27132a;
                    FieldRegistry fieldRegistry = this.f27133b;
                    MethodRegistry methodRegistry = this.f27134c;
                    RecordComponentRegistry recordComponentRegistry = this.f27135d;
                    TypeAttributeAppender typeAttributeAppender = this.f27136e;
                    AsmVisitorWrapper.Compound compound = r7;
                    AsmVisitorWrapper.Compound compound2 = new AsmVisitorWrapper.Compound(this.f27137f, asmVisitorWrapper);
                    InstrumentedType.WithFlexibleName withFlexibleName2 = withFlexibleName;
                    return a(withFlexibleName2, fieldRegistry, methodRegistry, recordComponentRegistry, typeAttributeAppender, compound, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public Builder<U> initializer(LoadedTypeInitializer loadedTypeInitializer) {
                    InstrumentedType.WithFlexibleName withInitializer = this.f27132a.withInitializer(loadedTypeInitializer);
                    InstrumentedType.WithFlexibleName withFlexibleName = withInitializer;
                    return a(withFlexibleName, this.f27133b, this.f27134c, this.f27135d, this.f27136e, this.f27137f, this.f27138g, this.f27139h, this.f27140i, this.f27141j, this.f27142k, this.f27143l, this.f27144m, this.f27145n, this.f27146o, this.f27147p, this.f27148q);
                }

                public InnerTypeDefinition<U> innerTypeOf(MethodDescription.InDefinedShape inDefinedShape) {
                    return inDefinedShape.isTypeInitializer() ? new InnerTypeDefinitionForTypeAdapter(inDefinedShape.getDeclaringType()) : new InnerTypeDefinitionForMethodAdapter(inDefinedShape);
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class FieldDefinitionAdapter extends FieldDefinition.Optional.Valuable.AbstractBase.Adapter<U> {
                    private final FieldDescription.Token token;

                    public FieldDefinitionAdapter(Adapter adapter, FieldDescription.Token token2) {
                        this(FieldAttributeAppender.ForInstrumentedField.INSTANCE, Transformer.NoOp.make(), FieldDescription.NO_DEFAULT_VALUE, token2);
                    }

                    public Builder<U> a() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withField = adapter.f27132a.withField(this.token);
                        FieldRegistry prepend = Adapter.this.f27133b.prepend(new LatentMatcher.ForFieldToken(this.token), this.f27164a, this.f27166c, this.f27165b);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.a(withField, prepend, adapter3.f27134c, adapter3.f27135d, adapter3.f27136e, adapter3.f27137f, adapter3.f27138g, adapter3.f27139h, adapter3.f27140i, adapter3.f27141j, adapter3.f27142k, adapter3.f27143l, adapter3.f27144m, adapter3.f27145n, adapter5.f27146o, adapter5.f27147p, adapter5.f27148q);
                    }

                    public FieldDefinition.Optional<U> annotateField(Collection<? extends AnnotationDescription> collection) {
                        return new FieldDefinitionAdapter(this.f27164a, this.f27165b, this.f27166c, new FieldDescription.Token(this.token.getName(), this.token.getModifiers(), this.token.getType(), CompoundList.of(this.token.getAnnotations(), (AnnotationList) new ArrayList(collection))));
                    }

                    public FieldDefinition.Optional<U> c(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, Object obj) {
                        return new FieldDefinitionAdapter(factory, transformer, obj, this.token);
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        FieldDefinitionAdapter fieldDefinitionAdapter = (FieldDefinitionAdapter) obj;
                        return this.token.equals(fieldDefinitionAdapter.token) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((super.hashCode() * 31) + this.token.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    public FieldDefinitionAdapter(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, Object obj, FieldDescription.Token token2) {
                        super(factory, transformer, obj);
                        this.token = token2;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class FieldMatchAdapter extends FieldDefinition.Optional.Valuable.AbstractBase.Adapter<U> {
                    private final LatentMatcher<? super FieldDescription> matcher;

                    public FieldMatchAdapter(Adapter adapter, LatentMatcher<? super FieldDescription> latentMatcher) {
                        this(FieldAttributeAppender.NoOp.INSTANCE, Transformer.NoOp.make(), FieldDescription.NO_DEFAULT_VALUE, latentMatcher);
                    }

                    public Builder<U> a() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withFlexibleName = adapter.f27132a;
                        FieldRegistry prepend = adapter.f27133b.prepend(this.matcher, this.f27164a, this.f27166c, this.f27165b);
                        Adapter adapter3 = Adapter.this;
                        Adapter adapter4 = adapter2;
                        Adapter adapter5 = adapter3;
                        return adapter4.a(withFlexibleName, prepend, adapter3.f27134c, adapter3.f27135d, adapter3.f27136e, adapter3.f27137f, adapter3.f27138g, adapter3.f27139h, adapter3.f27140i, adapter3.f27141j, adapter3.f27142k, adapter3.f27143l, adapter3.f27144m, adapter3.f27145n, adapter5.f27146o, adapter5.f27147p, adapter5.f27148q);
                    }

                    public FieldDefinition.Optional<U> annotateField(Collection<? extends AnnotationDescription> collection) {
                        return attribute(new FieldAttributeAppender.Explicit(new ArrayList(collection)));
                    }

                    public FieldDefinition.Optional<U> c(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, Object obj) {
                        return new FieldMatchAdapter(factory, transformer, obj, this.matcher);
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        FieldMatchAdapter fieldMatchAdapter = (FieldMatchAdapter) obj;
                        return this.matcher.equals(fieldMatchAdapter.matcher) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((super.hashCode() * 31) + this.matcher.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    public FieldMatchAdapter(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, Object obj, LatentMatcher<? super FieldDescription> latentMatcher) {
                        super(factory, transformer, obj);
                        this.matcher = latentMatcher;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class RecordComponentDefinitionAdapter extends RecordComponentDefinition.Optional.AbstractBase<U> {
                    private final RecordComponentAttributeAppender.Factory recordComponentAttributeAppenderFactory;
                    private final RecordComponentDescription.Token token;
                    private final Transformer<RecordComponentDescription> transformer;

                    public RecordComponentDefinitionAdapter(Adapter adapter, RecordComponentDescription.Token token2) {
                        this(RecordComponentAttributeAppender.ForInstrumentedRecordComponent.INSTANCE, Transformer.NoOp.make(), token2);
                    }

                    public Builder<U> a() {
                        Adapter adapter = Adapter.this;
                        Adapter adapter2 = adapter;
                        InstrumentedType.WithFlexibleName withRecordComponent = adapter.f27132a.withRecordComponent(this.token);
                        Adapter adapter3 = Adapter.this;
                        FieldRegistry fieldRegistry = adapter3.f27133b;
                        MethodRegistry methodRegistry = adapter3.f27134c;
                        RecordComponentRegistry prepend = adapter3.f27135d.prepend(new LatentMatcher.ForRecordComponentToken(this.token), this.recordComponentAttributeAppenderFactory, this.transformer);
                        Adapter adapter4 = Adapter.this;
                        Adapter adapter5 = adapter2;
                        Adapter adapter6 = adapter4;
                        return adapter5.a(withRecordComponent, fieldRegistry, methodRegistry, prepend, adapter4.f27136e, adapter4.f27137f, adapter4.f27138g, adapter4.f27139h, adapter4.f27140i, adapter4.f27141j, adapter4.f27142k, adapter4.f27143l, adapter4.f27144m, adapter4.f27145n, adapter6.f27146o, adapter6.f27147p, adapter6.f27148q);
                    }

                    public RecordComponentDefinition.Optional<U> annotateRecordComponent(Collection<? extends AnnotationDescription> collection) {
                        return new RecordComponentDefinitionAdapter(this.recordComponentAttributeAppenderFactory, this.transformer, new RecordComponentDescription.Token(this.token.getName(), this.token.getType(), CompoundList.of(this.token.getAnnotations(), (AnnotationList) new ArrayList(collection))));
                    }

                    public RecordComponentDefinition.Optional<U> attribute(RecordComponentAttributeAppender.Factory factory) {
                        return new RecordComponentDefinitionAdapter(new RecordComponentAttributeAppender.Factory.Compound(this.recordComponentAttributeAppenderFactory, factory), this.transformer, this.token);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        RecordComponentDefinitionAdapter recordComponentDefinitionAdapter = (RecordComponentDefinitionAdapter) obj;
                        return this.recordComponentAttributeAppenderFactory.equals(recordComponentDefinitionAdapter.recordComponentAttributeAppenderFactory) && this.token.equals(recordComponentDefinitionAdapter.token) && this.transformer.equals(recordComponentDefinitionAdapter.transformer) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.recordComponentAttributeAppenderFactory.hashCode()) * 31) + this.token.hashCode()) * 31) + this.transformer.hashCode()) * 31) + Adapter.this.hashCode();
                    }

                    public RecordComponentDefinition.Optional<U> transform(Transformer<RecordComponentDescription> transformer2) {
                        return new RecordComponentDefinitionAdapter(this.recordComponentAttributeAppenderFactory, new Transformer.Compound((Transformer<S>[]) new Transformer[]{this.transformer, transformer2}), this.token);
                    }

                    public RecordComponentDefinitionAdapter(RecordComponentAttributeAppender.Factory factory, Transformer<RecordComponentDescription> transformer2, RecordComponentDescription.Token token2) {
                        this.recordComponentAttributeAppenderFactory = factory;
                        this.transformer = transformer2;
                        this.token = token2;
                    }
                }
            }

            public static abstract class Delegator<U> extends AbstractBase<U> {
                public abstract Builder<U> a();

                public Builder<U> annotateType(Collection<? extends AnnotationDescription> collection) {
                    return a().annotateType(collection);
                }

                public Builder<U> attribute(TypeAttributeAppender typeAttributeAppender) {
                    return a().attribute(typeAttributeAppender);
                }

                public Builder<U> declaredTypes(Collection<? extends TypeDescription> collection) {
                    return a().declaredTypes(collection);
                }

                public RecordComponentDefinition.Optional<U> define(RecordComponentDescription recordComponentDescription) {
                    return a().define(recordComponentDescription);
                }

                public MethodDefinition.ParameterDefinition.Initial<U> defineConstructor(int i11) {
                    return a().defineConstructor(i11);
                }

                public FieldDefinition.Optional.Valuable<U> defineField(String str, TypeDefinition typeDefinition, int i11) {
                    return a().defineField(str, typeDefinition, i11);
                }

                public MethodDefinition.ParameterDefinition.Initial<U> defineMethod(String str, TypeDefinition typeDefinition, int i11) {
                    return a().defineMethod(str, typeDefinition, i11);
                }

                public RecordComponentDefinition.Optional<U> defineRecordComponent(String str, TypeDefinition typeDefinition) {
                    return a().defineRecordComponent(str, typeDefinition);
                }

                public FieldDefinition.Valuable<U> field(LatentMatcher<? super FieldDescription> latentMatcher) {
                    return a().field(latentMatcher);
                }

                public Builder<U> ignoreAlso(ElementMatcher<? super MethodDescription> elementMatcher) {
                    return a().ignoreAlso(elementMatcher);
                }

                public MethodDefinition.ImplementationDefinition.Optional<U> implement(Collection<? extends TypeDefinition> collection) {
                    return a().implement(collection);
                }

                public Builder<U> initializer(LoadedTypeInitializer loadedTypeInitializer) {
                    return a().initializer(loadedTypeInitializer);
                }

                public InnerTypeDefinition.ForType<U> innerTypeOf(TypeDescription typeDescription) {
                    return a().innerTypeOf(typeDescription);
                }

                public MethodDefinition.ImplementationDefinition<U> invokable(LatentMatcher<? super MethodDescription> latentMatcher) {
                    return a().invokable(latentMatcher);
                }

                public Unloaded<U> make() {
                    return a().make();
                }

                public Builder<U> merge(Collection<? extends ModifierContributor.ForType> collection) {
                    return a().merge(collection);
                }

                public Builder<U> modifiers(int i11) {
                    return a().modifiers(i11);
                }

                public Builder<U> name(String str) {
                    return a().name(str);
                }

                public Builder<U> nestHost(TypeDescription typeDescription) {
                    return a().nestHost(typeDescription);
                }

                public Builder<U> nestMembers(Collection<? extends TypeDescription> collection) {
                    return a().nestMembers(collection);
                }

                public Builder<U> permittedSubclass(Collection<? extends TypeDescription> collection) {
                    return a().permittedSubclass(collection);
                }

                public RecordComponentDefinition<U> recordComponent(ElementMatcher<? super RecordComponentDescription> elementMatcher) {
                    return a().recordComponent(elementMatcher);
                }

                public Builder<U> require(Collection<DynamicType> collection) {
                    return a().require(collection);
                }

                public Builder<U> suffix(String str) {
                    return a().suffix(str);
                }

                public TypeDescription toTypeDescription() {
                    return a().toTypeDescription();
                }

                public Builder<U> topLevelType() {
                    return a().topLevelType();
                }

                public Builder<U> transform(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer) {
                    return a().transform(elementMatcher, transformer);
                }

                public TypeVariableDefinition<U> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                    return a().typeVariable(str, collection);
                }

                public Builder<U> unsealed() {
                    return a().unsealed();
                }

                public Builder<U> visit(AsmVisitorWrapper asmVisitorWrapper) {
                    return a().visit(asmVisitorWrapper);
                }

                public Builder<U> ignoreAlso(LatentMatcher<? super MethodDescription> latentMatcher) {
                    return a().ignoreAlso(latentMatcher);
                }

                public Builder<U> initializer(ByteCodeAppender byteCodeAppender) {
                    return a().initializer(byteCodeAppender);
                }

                public InnerTypeDefinition<U> innerTypeOf(MethodDescription.InDefinedShape inDefinedShape) {
                    return a().innerTypeOf(inDefinedShape);
                }

                public Unloaded<U> make(TypeResolutionStrategy typeResolutionStrategy) {
                    return a().make(typeResolutionStrategy);
                }

                public RecordComponentDefinition<U> recordComponent(LatentMatcher<? super RecordComponentDescription> latentMatcher) {
                    return a().recordComponent(latentMatcher);
                }

                public Unloaded<U> make(TypePool typePool) {
                    return a().make(typePool);
                }

                public Unloaded<U> make(TypeResolutionStrategy typeResolutionStrategy, TypePool typePool) {
                    return a().make(typeResolutionStrategy, typePool);
                }
            }

            public Builder<S> annotateType(Annotation... annotationArr) {
                return annotateType((List<? extends Annotation>) Arrays.asList(annotationArr));
            }

            public MethodDefinition.ImplementationDefinition<S> constructor(ElementMatcher<? super MethodDescription> elementMatcher) {
                return invokable(ElementMatchers.isConstructor().and(elementMatcher));
            }

            public Builder<S> declaredTypes(Class<?>... clsArr) {
                return declaredTypes((List<? extends Class<?>>) Arrays.asList(clsArr));
            }

            public RecordComponentDefinition.Optional<S> define(RecordComponentDescription recordComponentDescription) {
                return defineRecordComponent(recordComponentDescription.getActualName(), (TypeDefinition) recordComponentDescription.getType());
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineConstructor(ModifierContributor.ForMethod... forMethodArr) {
                return defineConstructor((Collection<? extends ModifierContributor.ForMethod>) Arrays.asList(forMethodArr));
            }

            public FieldDefinition.Optional.Valuable<S> defineField(String str, Type type, ModifierContributor.ForField... forFieldArr) {
                return defineField(str, type, (Collection<? extends ModifierContributor.ForField>) Arrays.asList(forFieldArr));
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, Type type, ModifierContributor.ForMethod... forMethodArr) {
                return defineMethod(str, type, (Collection<? extends ModifierContributor.ForMethod>) Arrays.asList(forMethodArr));
            }

            public FieldDefinition.Optional<S> defineProperty(String str, Type type) {
                return defineProperty(str, (TypeDefinition) TypeDefinition.Sort.describe(type));
            }

            public RecordComponentDefinition.Optional<S> defineRecordComponent(String str, Type type) {
                return defineRecordComponent(str, (TypeDefinition) TypeDefinition.Sort.describe(type));
            }

            public FieldDefinition.Valuable<S> field(ElementMatcher<? super FieldDescription> elementMatcher) {
                return field((LatentMatcher<? super FieldDescription>) new LatentMatcher.Resolved(elementMatcher));
            }

            public Builder<S> ignoreAlso(ElementMatcher<? super MethodDescription> elementMatcher) {
                return ignoreAlso((LatentMatcher<? super MethodDescription>) new LatentMatcher.Resolved(elementMatcher));
            }

            public MethodDefinition.ImplementationDefinition.Optional<S> implement(Type... typeArr) {
                return implement((List<? extends Type>) Arrays.asList(typeArr));
            }

            public InnerTypeDefinition.ForType<S> innerTypeOf(Class<?> cls) {
                return innerTypeOf(TypeDescription.ForLoadedType.of(cls));
            }

            public MethodDefinition.ImplementationDefinition<S> invokable(ElementMatcher<? super MethodDescription> elementMatcher) {
                return invokable((LatentMatcher<? super MethodDescription>) new LatentMatcher.Resolved(elementMatcher));
            }

            public Unloaded<S> make(TypePool typePool) {
                return make(TypeResolutionStrategy.Passive.INSTANCE, typePool);
            }

            public Builder<S> merge(ModifierContributor.ForType... forTypeArr) {
                return merge((Collection<? extends ModifierContributor.ForType>) Arrays.asList(forTypeArr));
            }

            public MethodDefinition.ImplementationDefinition<S> method(ElementMatcher<? super MethodDescription> elementMatcher) {
                return invokable(ElementMatchers.isMethod().and(elementMatcher));
            }

            public Builder<S> modifiers(ModifierContributor.ForType... forTypeArr) {
                return modifiers((Collection<? extends ModifierContributor.ForType>) Arrays.asList(forTypeArr));
            }

            public Builder<S> nestHost(Class<?> cls) {
                return nestHost(TypeDescription.ForLoadedType.of(cls));
            }

            public Builder<S> nestMembers(Class<?>... clsArr) {
                return nestMembers((List<? extends Class<?>>) Arrays.asList(clsArr));
            }

            public Builder<S> noNestMate() {
                return nestHost(TargetType.DESCRIPTION);
            }

            public Builder<S> permittedSubclass(Class<?>... clsArr) {
                return permittedSubclass((List<? extends Class<?>>) Arrays.asList(clsArr));
            }

            public RecordComponentDefinition<S> recordComponent(ElementMatcher<? super RecordComponentDescription> elementMatcher) {
                return recordComponent((LatentMatcher<? super RecordComponentDescription>) new LatentMatcher.Resolved(elementMatcher));
            }

            public Builder<S> require(TypeDescription typeDescription, byte[] bArr) {
                return require(typeDescription, bArr, LoadedTypeInitializer.NoOp.INSTANCE);
            }

            public FieldDefinition.Optional<S> serialVersionUid(long j11) {
                return defineField("serialVersionUID", (Type) Long.TYPE, Visibility.PRIVATE, FieldManifestation.FINAL, Ownership.STATIC).value(j11);
            }

            public TypeVariableDefinition<S> typeVariable(String str) {
                return typeVariable(str, TypeDescription.Generic.OBJECT);
            }

            public Builder<S> withHashCodeEquals() {
                return method(ElementMatchers.isHashCode()).intercept(HashCodeMethod.usingDefaultOffset().withIgnoredFields(ElementMatchers.isSynthetic())).method(ElementMatchers.isEquals()).intercept(EqualsMethod.isolated().withIgnoredFields(ElementMatchers.isSynthetic()));
            }

            public Builder<S> withToString() {
                return method(ElementMatchers.isToString()).intercept(ToStringMethod.prefixedBySimpleClassName());
            }

            public Builder<S> annotateType(List<? extends Annotation> list) {
                return annotateType((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
            }

            public Builder<S> declaredTypes(TypeDescription... typeDescriptionArr) {
                return declaredTypes((Collection<? extends TypeDescription>) Arrays.asList(typeDescriptionArr));
            }

            public FieldDefinition.Optional.Valuable<S> define(Field field) {
                return define((FieldDescription) new FieldDescription.ForLoadedField(field));
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineConstructor(Collection<? extends ModifierContributor.ForMethod> collection) {
                return defineConstructor(ModifierContributor.Resolver.of(collection).resolve());
            }

            public FieldDefinition.Optional.Valuable<S> defineField(String str, Type type, Collection<? extends ModifierContributor.ForField> collection) {
                return defineField(str, type, ModifierContributor.Resolver.of(collection).resolve());
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, Type type, Collection<? extends ModifierContributor.ForMethod> collection) {
                return defineMethod(str, type, ModifierContributor.Resolver.of(collection).resolve());
            }

            public FieldDefinition.Optional<S> defineProperty(String str, Type type, boolean z11) {
                return defineProperty(str, (TypeDefinition) TypeDefinition.Sort.describe(type), z11);
            }

            public MethodDefinition.ImplementationDefinition.Optional<S> implement(List<? extends Type> list) {
                return implement((Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
            }

            public InnerTypeDefinition<S> innerTypeOf(Method method) {
                return innerTypeOf((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method));
            }

            public Unloaded<S> make() {
                return make((TypeResolutionStrategy) TypeResolutionStrategy.Passive.INSTANCE);
            }

            public Builder<S> modifiers(Collection<? extends ModifierContributor.ForType> collection) {
                return modifiers(ModifierContributor.Resolver.of(collection).resolve());
            }

            public Builder<S> nestMembers(TypeDescription... typeDescriptionArr) {
                return nestMembers((Collection<? extends TypeDescription>) Arrays.asList(typeDescriptionArr));
            }

            public Builder<S> permittedSubclass(TypeDescription... typeDescriptionArr) {
                return permittedSubclass((Collection<? extends TypeDescription>) Arrays.asList(typeDescriptionArr));
            }

            public Builder<S> require(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer) {
                return require(new Default(typeDescription, bArr, loadedTypeInitializer, Collections.emptyList()));
            }

            public TypeVariableDefinition<S> typeVariable(String str, Type... typeArr) {
                return typeVariable(str, (List<? extends Type>) Arrays.asList(typeArr));
            }

            public Builder<S> annotateType(AnnotationDescription... annotationDescriptionArr) {
                return annotateType((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
            }

            public Builder<S> declaredTypes(List<? extends Class<?>> list) {
                return declaredTypes((Collection<? extends TypeDescription>) new TypeList.ForLoadedTypes(list));
            }

            public FieldDefinition.Optional.Valuable<S> define(FieldDescription fieldDescription) {
                return defineField(fieldDescription.getName(), (TypeDefinition) fieldDescription.getType(), fieldDescription.getModifiers());
            }

            public FieldDefinition.Optional.Valuable<S> defineField(String str, Type type, int i11) {
                return defineField(str, (TypeDefinition) TypeDefinition.Sort.describe(type), i11);
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, Type type, int i11) {
                return defineMethod(str, (TypeDefinition) TypeDefinition.Sort.describe(type), i11);
            }

            public FieldDefinition.Optional<S> defineProperty(String str, TypeDefinition typeDefinition) {
                return defineProperty(str, typeDefinition, false);
            }

            public MethodDefinition.ImplementationDefinition.Optional<S> implement(TypeDefinition... typeDefinitionArr) {
                return implement((Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
            }

            public InnerTypeDefinition<S> innerTypeOf(Constructor<?> constructor) {
                return innerTypeOf((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor));
            }

            public Builder<S> nestMembers(List<? extends Class<?>> list) {
                return nestMembers((Collection<? extends TypeDescription>) new TypeList.ForLoadedTypes(list));
            }

            public Builder<S> permittedSubclass(List<? extends Class<?>> list) {
                return permittedSubclass((Collection<? extends TypeDescription>) new TypeList.ForLoadedTypes(list));
            }

            public Builder<S> require(DynamicType... dynamicTypeArr) {
                return require((Collection<DynamicType>) Arrays.asList(dynamicTypeArr));
            }

            public TypeVariableDefinition<S> typeVariable(String str, List<? extends Type> list) {
                return typeVariable(str, (Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
            }

            public MethodDefinition.ImplementationDefinition<S> define(Method method) {
                return define((MethodDescription) new MethodDescription.ForLoadedMethod(method));
            }

            public FieldDefinition.Optional.Valuable<S> defineField(String str, TypeDefinition typeDefinition, ModifierContributor.ForField... forFieldArr) {
                return defineField(str, typeDefinition, (Collection<? extends ModifierContributor.ForField>) Arrays.asList(forFieldArr));
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, TypeDefinition typeDefinition, ModifierContributor.ForMethod... forMethodArr) {
                return defineMethod(str, typeDefinition, (Collection<? extends ModifierContributor.ForMethod>) Arrays.asList(forMethodArr));
            }

            public FieldDefinition.Optional<S> defineProperty(String str, TypeDefinition typeDefinition, boolean z11) {
                Builder builder;
                FieldManifestation fieldManifestation;
                if (str.length() == 0) {
                    throw new IllegalArgumentException("A bean property cannot have an empty name");
                } else if (!typeDefinition.represents(Void.TYPE)) {
                    if (!z11) {
                        builder = defineMethod("set" + Character.toUpperCase(str.charAt(0)) + str.substring(1), (Type) Void.TYPE, Visibility.PUBLIC).withParameters(typeDefinition).intercept(FieldAccessor.ofField(str));
                        fieldManifestation = FieldManifestation.PLAIN;
                    } else {
                        fieldManifestation = FieldManifestation.FINAL;
                        builder = this;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(typeDefinition.represents(Boolean.TYPE) ? "is" : "get");
                    sb2.append(Character.toUpperCase(str.charAt(0)));
                    sb2.append(str.substring(1));
                    return builder.defineMethod(sb2.toString(), typeDefinition, Visibility.PUBLIC).intercept(FieldAccessor.ofField(str)).defineField(str, typeDefinition, Visibility.PRIVATE, fieldManifestation);
                } else {
                    throw new IllegalArgumentException("A bean property cannot have a void type");
                }
            }

            public TypeVariableDefinition<S> typeVariable(String str, TypeDefinition... typeDefinitionArr) {
                return typeVariable(str, (Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
            }

            public MethodDefinition.ImplementationDefinition<S> define(Constructor<?> constructor) {
                return define((MethodDescription) new MethodDescription.ForLoadedConstructor(constructor));
            }

            public FieldDefinition.Optional.Valuable<S> defineField(String str, TypeDefinition typeDefinition, Collection<? extends ModifierContributor.ForField> collection) {
                return defineField(str, typeDefinition, ModifierContributor.Resolver.of(collection).resolve());
            }

            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, TypeDefinition typeDefinition, Collection<? extends ModifierContributor.ForMethod> collection) {
                return defineMethod(str, typeDefinition, ModifierContributor.Resolver.of(collection).resolve());
            }

            public MethodDefinition.ImplementationDefinition<S> define(MethodDescription methodDescription) {
                MethodDefinition.ParameterDefinition.Initial initial;
                MethodDefinition.ParameterDefinition parameterDefinition;
                if (methodDescription.isConstructor()) {
                    initial = defineConstructor(methodDescription.getModifiers());
                } else {
                    initial = defineMethod(methodDescription.getInternalName(), (TypeDefinition) methodDescription.getReturnType(), methodDescription.getModifiers());
                }
                ParameterList<?> parameters = methodDescription.getParameters();
                if (parameters.hasExplicitMetaData()) {
                    Iterator<E> it = parameters.iterator();
                    MethodDefinition.ParameterDefinition parameterDefinition2 = initial;
                    while (it.hasNext()) {
                        ParameterDescription parameterDescription = (ParameterDescription) it.next();
                        parameterDefinition2 = parameterDefinition2.withParameter((TypeDefinition) parameterDescription.getType(), parameterDescription.getName(), parameterDescription.getModifiers());
                    }
                    parameterDefinition = parameterDefinition2;
                } else {
                    parameterDefinition = initial.withParameters((Collection<? extends TypeDefinition>) parameters.asTypeList());
                }
                MethodDefinition.TypeVariableDefinition throwing = parameterDefinition.throwing((Collection<? extends TypeDefinition>) methodDescription.getExceptionTypes());
                for (TypeDescription.Generic generic : methodDescription.getTypeVariables()) {
                    throwing = throwing.typeVariable(generic.getSymbol(), (Collection<? extends TypeDefinition>) generic.getUpperBounds());
                }
                return throwing;
            }
        }

        public interface FieldDefinition<S> {

            public interface Optional<U> extends FieldDefinition<U>, Builder<U> {

                public static abstract class AbstractBase<U> extends AbstractBase.Delegator<U> implements Optional<U> {
                    public Optional<U> annotateField(Annotation... annotationArr) {
                        return annotateField((List<? extends Annotation>) Arrays.asList(annotationArr));
                    }

                    public Optional<U> annotateField(List<? extends Annotation> list) {
                        return annotateField((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                    }

                    public Optional<U> annotateField(AnnotationDescription... annotationDescriptionArr) {
                        return annotateField((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                    }
                }

                public interface Valuable<V> extends Valuable<V>, Optional<V> {

                    public static abstract class AbstractBase<U> extends AbstractBase<U> implements Valuable<U> {

                        @HashCodeAndEqualsPlugin.Enhance
                        public static abstract class Adapter<V> extends AbstractBase<V> {

                            /* renamed from: a  reason: collision with root package name */
                            public final FieldAttributeAppender.Factory f27164a;

                            /* renamed from: b  reason: collision with root package name */
                            public final Transformer<FieldDescription> f27165b;
                            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)

                            /* renamed from: c  reason: collision with root package name */
                            public final Object f27166c;

                            public Adapter(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, Object obj) {
                                this.f27164a = factory;
                                this.f27165b = transformer;
                                this.f27166c = obj;
                            }

                            public Optional<V> attribute(FieldAttributeAppender.Factory factory) {
                                return c(new FieldAttributeAppender.Factory.Compound(this.f27164a, factory), this.f27165b, this.f27166c);
                            }

                            public Optional<V> b(Object obj) {
                                return c(this.f27164a, this.f27165b, obj);
                            }

                            public abstract Optional<V> c(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, Object obj);

                            /* JADX WARNING: Removed duplicated region for block: B:23:0x003d A[RETURN] */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public boolean equals(java.lang.Object r5) {
                                /*
                                    r4 = this;
                                    r0 = 1
                                    if (r4 != r5) goto L_0x0004
                                    return r0
                                L_0x0004:
                                    r1 = 0
                                    if (r5 != 0) goto L_0x0008
                                    return r1
                                L_0x0008:
                                    java.lang.Class r2 = r4.getClass()
                                    java.lang.Class r3 = r5.getClass()
                                    if (r2 == r3) goto L_0x0013
                                    return r1
                                L_0x0013:
                                    net.bytebuddy.implementation.attribute.FieldAttributeAppender$Factory r2 = r4.f27164a
                                    net.bytebuddy.dynamic.DynamicType$Builder$FieldDefinition$Optional$Valuable$AbstractBase$Adapter r5 = (net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional.Valuable.AbstractBase.Adapter) r5
                                    net.bytebuddy.implementation.attribute.FieldAttributeAppender$Factory r3 = r5.f27164a
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L_0x0020
                                    return r1
                                L_0x0020:
                                    net.bytebuddy.dynamic.Transformer<net.bytebuddy.description.field.FieldDescription> r2 = r4.f27165b
                                    net.bytebuddy.dynamic.Transformer<net.bytebuddy.description.field.FieldDescription> r3 = r5.f27165b
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L_0x002b
                                    return r1
                                L_0x002b:
                                    java.lang.Object r2 = r4.f27166c
                                    java.lang.Object r5 = r5.f27166c
                                    if (r5 == 0) goto L_0x003a
                                    if (r2 == 0) goto L_0x003c
                                    boolean r5 = r2.equals(r5)
                                    if (r5 != 0) goto L_0x003d
                                    return r1
                                L_0x003a:
                                    if (r2 == 0) goto L_0x003d
                                L_0x003c:
                                    return r1
                                L_0x003d:
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional.Valuable.AbstractBase.Adapter.equals(java.lang.Object):boolean");
                            }

                            public int hashCode() {
                                int hashCode = ((((getClass().hashCode() * 31) + this.f27164a.hashCode()) * 31) + this.f27165b.hashCode()) * 31;
                                Object obj = this.f27166c;
                                return obj != null ? hashCode + obj.hashCode() : hashCode;
                            }

                            public Optional<V> transform(Transformer<FieldDescription> transformer) {
                                return c(this.f27164a, new Transformer.Compound((Transformer<S>[]) new Transformer[]{this.f27165b, transformer}), this.f27166c);
                            }
                        }

                        public abstract Optional<U> b(Object obj);

                        public Optional<U> value(boolean z11) {
                            return b(Integer.valueOf(z11 ? 1 : 0));
                        }

                        public Optional<U> value(int i11) {
                            return b(Integer.valueOf(i11));
                        }

                        public Optional<U> value(long j11) {
                            return b(Long.valueOf(j11));
                        }

                        public Optional<U> value(float f11) {
                            return b(Float.valueOf(f11));
                        }

                        public Optional<U> value(double d11) {
                            return b(Double.valueOf(d11));
                        }

                        public Optional<U> value(String str) {
                            if (str != null) {
                                return b(str);
                            }
                            throw new IllegalArgumentException("Cannot set null as a default value");
                        }
                    }
                }
            }

            public interface Valuable<U> extends FieldDefinition<U> {
                Optional<U> value(double d11);

                Optional<U> value(float f11);

                Optional<U> value(int i11);

                Optional<U> value(long j11);

                Optional<U> value(String str);

                Optional<U> value(boolean z11);
            }

            Optional<S> annotateField(Collection<? extends AnnotationDescription> collection);

            Optional<S> annotateField(List<? extends Annotation> list);

            Optional<S> annotateField(Annotation... annotationArr);

            Optional<S> annotateField(AnnotationDescription... annotationDescriptionArr);

            Optional<S> attribute(FieldAttributeAppender.Factory factory);

            Optional<S> transform(Transformer<FieldDescription> transformer);
        }

        public interface InnerTypeDefinition<S> extends Builder<S> {

            public interface ForType<U> extends InnerTypeDefinition<U> {
                Builder<U> asMemberType();
            }

            Builder<S> asAnonymousType();
        }

        public interface MethodDefinition<S> extends Builder<S> {

            public static abstract class AbstractBase<U> extends AbstractBase.Delegator<U> implements MethodDefinition<U> {

                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class Adapter<V> extends ReceiverTypeDefinition.AbstractBase<V> {

                    /* renamed from: a  reason: collision with root package name */
                    public final MethodRegistry.Handler f27167a;

                    /* renamed from: b  reason: collision with root package name */
                    public final MethodAttributeAppender.Factory f27168b;

                    /* renamed from: c  reason: collision with root package name */
                    public final Transformer<MethodDescription> f27169c;

                    public Adapter(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                        this.f27167a = handler;
                        this.f27168b = factory;
                        this.f27169c = transformer;
                    }

                    public MethodDefinition<V> attribute(MethodAttributeAppender.Factory factory) {
                        return b(this.f27167a, new MethodAttributeAppender.Factory.Compound(this.f27168b, factory), this.f27169c);
                    }

                    public abstract MethodDefinition<V> b(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer);

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Adapter adapter = (Adapter) obj;
                        return this.f27167a.equals(adapter.f27167a) && this.f27168b.equals(adapter.f27168b) && this.f27169c.equals(adapter.f27169c);
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.f27167a.hashCode()) * 31) + this.f27168b.hashCode()) * 31) + this.f27169c.hashCode();
                    }

                    public MethodDefinition<V> transform(Transformer<MethodDescription> transformer) {
                        return b(this.f27167a, this.f27168b, new Transformer.Compound((Transformer<S>[]) new Transformer[]{this.f27169c, transformer}));
                    }
                }

                public MethodDefinition<U> annotateMethod(Annotation... annotationArr) {
                    return annotateMethod((List<? extends Annotation>) Arrays.asList(annotationArr));
                }

                public MethodDefinition<U> annotateParameter(int i11, Annotation... annotationArr) {
                    return annotateParameter(i11, (List<? extends Annotation>) Arrays.asList(annotationArr));
                }

                public MethodDefinition<U> annotateMethod(List<? extends Annotation> list) {
                    return annotateMethod((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                }

                public MethodDefinition<U> annotateParameter(int i11, List<? extends Annotation> list) {
                    return annotateParameter(i11, (Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                }

                public MethodDefinition<U> annotateMethod(AnnotationDescription... annotationDescriptionArr) {
                    return annotateMethod((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                }

                public MethodDefinition<U> annotateParameter(int i11, AnnotationDescription... annotationDescriptionArr) {
                    return annotateParameter(i11, (Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                }
            }

            public interface ExceptionDefinition<U> extends TypeVariableDefinition<U> {

                public static abstract class AbstractBase<V> extends TypeVariableDefinition.AbstractBase<V> implements ExceptionDefinition<V> {
                    public ExceptionDefinition<V> throwing(Type... typeArr) {
                        return throwing((List<? extends Type>) Arrays.asList(typeArr));
                    }

                    public ExceptionDefinition<V> throwing(List<? extends Type> list) {
                        return throwing((Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
                    }

                    public ExceptionDefinition<V> throwing(TypeDefinition... typeDefinitionArr) {
                        return throwing((Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
                    }
                }

                ExceptionDefinition<U> throwing(Collection<? extends TypeDefinition> collection);

                ExceptionDefinition<U> throwing(List<? extends Type> list);

                ExceptionDefinition<U> throwing(Type... typeArr);

                ExceptionDefinition<U> throwing(TypeDefinition... typeDefinitionArr);
            }

            public interface ImplementationDefinition<U> {

                public static abstract class AbstractBase<V> implements ImplementationDefinition<V> {
                    public <W> ReceiverTypeDefinition<V> defaultValue(W w11, Class<? extends W> cls) {
                        return defaultValue(AnnotationDescription.ForLoadedAnnotation.asValue(w11, cls));
                    }
                }

                public interface Optional<V> extends ImplementationDefinition<V>, Builder<V> {
                }

                <W> ReceiverTypeDefinition<U> defaultValue(W w11, Class<? extends W> cls);

                ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> annotationValue);

                ReceiverTypeDefinition<U> intercept(Implementation implementation);

                ReceiverTypeDefinition<U> withoutCode();
            }

            public interface ParameterDefinition<U> extends ExceptionDefinition<U> {

                public static abstract class AbstractBase<V> extends ExceptionDefinition.AbstractBase<V> implements ParameterDefinition<V> {
                    public Annotatable<V> withParameter(Type type, String str, ModifierContributor.ForParameter... forParameterArr) {
                        return withParameter(type, str, (Collection<? extends ModifierContributor.ForParameter>) Arrays.asList(forParameterArr));
                    }

                    public Annotatable<V> withParameter(Type type, String str, Collection<? extends ModifierContributor.ForParameter> collection) {
                        return withParameter(type, str, ModifierContributor.Resolver.of(collection).resolve());
                    }

                    public Annotatable<V> withParameter(Type type, String str, int i11) {
                        return withParameter((TypeDefinition) TypeDefinition.Sort.describe(type), str, i11);
                    }

                    public Annotatable<V> withParameter(TypeDefinition typeDefinition, String str, ModifierContributor.ForParameter... forParameterArr) {
                        return withParameter(typeDefinition, str, (Collection<? extends ModifierContributor.ForParameter>) Arrays.asList(forParameterArr));
                    }

                    public Annotatable<V> withParameter(TypeDefinition typeDefinition, String str, Collection<? extends ModifierContributor.ForParameter> collection) {
                        return withParameter(typeDefinition, str, ModifierContributor.Resolver.of(collection).resolve());
                    }
                }

                public interface Annotatable<V> extends ParameterDefinition<V> {

                    public static abstract class AbstractBase<W> extends AbstractBase<W> implements Annotatable<W> {

                        public static abstract class Adapter<X> extends AbstractBase<X> {
                            public abstract ParameterDefinition<X> a();

                            public ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> annotationValue) {
                                return a().defaultValue(annotationValue);
                            }

                            public ReceiverTypeDefinition<X> intercept(Implementation implementation) {
                                return a().intercept(implementation);
                            }

                            public ExceptionDefinition<X> throwing(Collection<? extends TypeDefinition> collection) {
                                return a().throwing(collection);
                            }

                            public TypeVariableDefinition.Annotatable<X> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                                return a().typeVariable(str, collection);
                            }

                            public Annotatable<X> withParameter(TypeDefinition typeDefinition, String str, int i11) {
                                return a().withParameter(typeDefinition, str, i11);
                            }

                            public ReceiverTypeDefinition<X> withoutCode() {
                                return a().withoutCode();
                            }

                            public <V> ReceiverTypeDefinition<X> defaultValue(V v11, Class<? extends V> cls) {
                                return a().defaultValue(v11, cls);
                            }
                        }

                        public Annotatable<W> annotateParameter(Annotation... annotationArr) {
                            return annotateParameter((List<? extends Annotation>) Arrays.asList(annotationArr));
                        }

                        public Annotatable<W> annotateParameter(List<? extends Annotation> list) {
                            return annotateParameter((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                        }

                        public Annotatable<W> annotateParameter(AnnotationDescription... annotationDescriptionArr) {
                            return annotateParameter((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                        }
                    }

                    Annotatable<V> annotateParameter(Collection<? extends AnnotationDescription> collection);

                    Annotatable<V> annotateParameter(List<? extends Annotation> list);

                    Annotatable<V> annotateParameter(Annotation... annotationArr);

                    Annotatable<V> annotateParameter(AnnotationDescription... annotationDescriptionArr);
                }

                public interface Initial<V> extends ParameterDefinition<V>, Simple<V> {

                    public static abstract class AbstractBase<W> extends AbstractBase<W> implements Initial<W> {
                        public Simple.Annotatable<W> withParameter(Type type) {
                            return withParameter((TypeDefinition) TypeDefinition.Sort.describe(type));
                        }

                        public ExceptionDefinition<W> withParameters(Type... typeArr) {
                            return withParameters((List<? extends Type>) Arrays.asList(typeArr));
                        }

                        public ExceptionDefinition<W> withParameters(List<? extends Type> list) {
                            return withParameters((Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
                        }

                        public ExceptionDefinition<W> withParameters(TypeDefinition... typeDefinitionArr) {
                            return withParameters((Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
                        }

                        public ExceptionDefinition<W> withParameters(Collection<? extends TypeDefinition> collection) {
                            Simple simple = this;
                            for (TypeDefinition withParameter : collection) {
                                simple = simple.withParameter(withParameter);
                            }
                            return simple;
                        }
                    }

                    ExceptionDefinition<V> withParameters(Collection<? extends TypeDefinition> collection);

                    ExceptionDefinition<V> withParameters(List<? extends Type> list);

                    ExceptionDefinition<V> withParameters(Type... typeArr);

                    ExceptionDefinition<V> withParameters(TypeDefinition... typeDefinitionArr);
                }

                public interface Simple<V> extends ExceptionDefinition<V> {

                    public static abstract class AbstractBase<W> extends ExceptionDefinition.AbstractBase<W> implements Simple<W> {
                        public Annotatable<W> withParameter(Type type) {
                            return withParameter((TypeDefinition) TypeDefinition.Sort.describe(type));
                        }
                    }

                    public interface Annotatable<V> extends Simple<V> {

                        public static abstract class AbstractBase<W> extends AbstractBase<W> implements Annotatable<W> {

                            public static abstract class Adapter<X> extends AbstractBase<X> {
                                public abstract Simple<X> a();

                                public ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> annotationValue) {
                                    return a().defaultValue(annotationValue);
                                }

                                public ReceiverTypeDefinition<X> intercept(Implementation implementation) {
                                    return a().intercept(implementation);
                                }

                                public ExceptionDefinition<X> throwing(Collection<? extends TypeDefinition> collection) {
                                    return a().throwing(collection);
                                }

                                public TypeVariableDefinition.Annotatable<X> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                                    return a().typeVariable(str, collection);
                                }

                                public Annotatable<X> withParameter(TypeDefinition typeDefinition) {
                                    return a().withParameter(typeDefinition);
                                }

                                public ReceiverTypeDefinition<X> withoutCode() {
                                    return a().withoutCode();
                                }

                                public <V> ReceiverTypeDefinition<X> defaultValue(V v11, Class<? extends V> cls) {
                                    return a().defaultValue(v11, cls);
                                }
                            }

                            public Annotatable<W> annotateParameter(Annotation... annotationArr) {
                                return annotateParameter((List<? extends Annotation>) Arrays.asList(annotationArr));
                            }

                            public Annotatable<W> annotateParameter(List<? extends Annotation> list) {
                                return annotateParameter((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                            }

                            public Annotatable<W> annotateParameter(AnnotationDescription... annotationDescriptionArr) {
                                return annotateParameter((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                            }
                        }

                        Annotatable<V> annotateParameter(Collection<? extends AnnotationDescription> collection);

                        Annotatable<V> annotateParameter(List<? extends Annotation> list);

                        Annotatable<V> annotateParameter(Annotation... annotationArr);

                        Annotatable<V> annotateParameter(AnnotationDescription... annotationDescriptionArr);
                    }

                    Annotatable<V> withParameter(Type type);

                    Annotatable<V> withParameter(TypeDefinition typeDefinition);
                }

                Annotatable<U> withParameter(Type type, String str, int i11);

                Annotatable<U> withParameter(Type type, String str, Collection<? extends ModifierContributor.ForParameter> collection);

                Annotatable<U> withParameter(Type type, String str, ModifierContributor.ForParameter... forParameterArr);

                Annotatable<U> withParameter(TypeDefinition typeDefinition, String str, int i11);

                Annotatable<U> withParameter(TypeDefinition typeDefinition, String str, Collection<? extends ModifierContributor.ForParameter> collection);

                Annotatable<U> withParameter(TypeDefinition typeDefinition, String str, ModifierContributor.ForParameter... forParameterArr);
            }

            public interface ReceiverTypeDefinition<U> extends MethodDefinition<U> {

                public static abstract class AbstractBase<V> extends AbstractBase<V> implements ReceiverTypeDefinition<V> {
                    public MethodDefinition<V> receiverType(AnnotatedElement annotatedElement) {
                        return receiverType(TypeDefinition.Sort.describeAnnotated(annotatedElement));
                    }
                }

                MethodDefinition<U> receiverType(AnnotatedElement annotatedElement);

                MethodDefinition<U> receiverType(TypeDescription.Generic generic);
            }

            public interface TypeVariableDefinition<U> extends ImplementationDefinition<U> {

                public static abstract class AbstractBase<V> extends ImplementationDefinition.AbstractBase<V> implements TypeVariableDefinition<V> {
                    public Annotatable<V> typeVariable(String str) {
                        return typeVariable(str, (List<? extends Type>) Collections.singletonList(Object.class));
                    }

                    public Annotatable<V> typeVariable(String str, Type... typeArr) {
                        return typeVariable(str, (List<? extends Type>) Arrays.asList(typeArr));
                    }

                    public Annotatable<V> typeVariable(String str, List<? extends Type> list) {
                        return typeVariable(str, (Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
                    }

                    public Annotatable<V> typeVariable(String str, TypeDefinition... typeDefinitionArr) {
                        return typeVariable(str, (Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
                    }
                }

                public interface Annotatable<V> extends TypeVariableDefinition<V> {

                    public static abstract class AbstractBase<W> extends AbstractBase<W> implements Annotatable<W> {

                        public static abstract class Adapter<X> extends AbstractBase<X> {
                            public abstract ParameterDefinition<X> a();

                            public ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> annotationValue) {
                                return a().defaultValue(annotationValue);
                            }

                            public ReceiverTypeDefinition<X> intercept(Implementation implementation) {
                                return a().intercept(implementation);
                            }

                            public Annotatable<X> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                                return a().typeVariable(str, collection);
                            }

                            public ReceiverTypeDefinition<X> withoutCode() {
                                return a().withoutCode();
                            }

                            public <V> ReceiverTypeDefinition<X> defaultValue(V v11, Class<? extends V> cls) {
                                return a().defaultValue(v11, cls);
                            }
                        }

                        public Annotatable<W> annotateTypeVariable(Annotation... annotationArr) {
                            return annotateTypeVariable((List<? extends Annotation>) Arrays.asList(annotationArr));
                        }

                        public Annotatable<W> annotateTypeVariable(List<? extends Annotation> list) {
                            return annotateTypeVariable((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                        }

                        public Annotatable<W> annotateTypeVariable(AnnotationDescription... annotationDescriptionArr) {
                            return annotateTypeVariable((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                        }
                    }

                    Annotatable<V> annotateTypeVariable(Collection<? extends AnnotationDescription> collection);

                    Annotatable<V> annotateTypeVariable(List<? extends Annotation> list);

                    Annotatable<V> annotateTypeVariable(Annotation... annotationArr);

                    Annotatable<V> annotateTypeVariable(AnnotationDescription... annotationDescriptionArr);
                }

                Annotatable<U> typeVariable(String str);

                Annotatable<U> typeVariable(String str, Collection<? extends TypeDefinition> collection);

                Annotatable<U> typeVariable(String str, List<? extends Type> list);

                Annotatable<U> typeVariable(String str, Type... typeArr);

                Annotatable<U> typeVariable(String str, TypeDefinition... typeDefinitionArr);
            }

            MethodDefinition<S> annotateMethod(Collection<? extends AnnotationDescription> collection);

            MethodDefinition<S> annotateMethod(List<? extends Annotation> list);

            MethodDefinition<S> annotateMethod(Annotation... annotationArr);

            MethodDefinition<S> annotateMethod(AnnotationDescription... annotationDescriptionArr);

            MethodDefinition<S> annotateParameter(int i11, Collection<? extends AnnotationDescription> collection);

            MethodDefinition<S> annotateParameter(int i11, List<? extends Annotation> list);

            MethodDefinition<S> annotateParameter(int i11, Annotation... annotationArr);

            MethodDefinition<S> annotateParameter(int i11, AnnotationDescription... annotationDescriptionArr);

            MethodDefinition<S> attribute(MethodAttributeAppender.Factory factory);

            MethodDefinition<S> transform(Transformer<MethodDescription> transformer);
        }

        public interface RecordComponentDefinition<S> {

            public interface Optional<U> extends RecordComponentDefinition<U>, Builder<U> {

                public static abstract class AbstractBase<U> extends AbstractBase.Delegator<U> implements Optional<U> {
                    public Optional<U> annotateRecordComponent(Annotation... annotationArr) {
                        return annotateRecordComponent((List<? extends Annotation>) Arrays.asList(annotationArr));
                    }

                    public Optional<U> annotateRecordComponent(List<? extends Annotation> list) {
                        return annotateRecordComponent((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                    }

                    public Optional<U> annotateRecordComponent(AnnotationDescription... annotationDescriptionArr) {
                        return annotateRecordComponent((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                    }
                }
            }

            Optional<S> annotateRecordComponent(Collection<? extends AnnotationDescription> collection);

            Optional<S> annotateRecordComponent(List<? extends Annotation> list);

            Optional<S> annotateRecordComponent(Annotation... annotationArr);

            Optional<S> annotateRecordComponent(AnnotationDescription... annotationDescriptionArr);

            Optional<S> attribute(RecordComponentAttributeAppender.Factory factory);

            Optional<S> transform(Transformer<RecordComponentDescription> transformer);
        }

        public interface TypeVariableDefinition<S> extends Builder<S> {

            public static abstract class AbstractBase<U> extends AbstractBase.Delegator<U> implements TypeVariableDefinition<U> {
                public TypeVariableDefinition<U> annotateTypeVariable(Annotation... annotationArr) {
                    return annotateTypeVariable((List<? extends Annotation>) Arrays.asList(annotationArr));
                }

                public TypeVariableDefinition<U> annotateTypeVariable(List<? extends Annotation> list) {
                    return annotateTypeVariable((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                }

                public TypeVariableDefinition<U> annotateTypeVariable(AnnotationDescription... annotationDescriptionArr) {
                    return annotateTypeVariable((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                }
            }

            TypeVariableDefinition<S> annotateTypeVariable(Collection<? extends AnnotationDescription> collection);

            TypeVariableDefinition<S> annotateTypeVariable(List<? extends Annotation> list);

            TypeVariableDefinition<S> annotateTypeVariable(Annotation... annotationArr);

            TypeVariableDefinition<S> annotateTypeVariable(AnnotationDescription... annotationDescriptionArr);
        }

        Builder<T> annotateType(Collection<? extends AnnotationDescription> collection);

        Builder<T> annotateType(List<? extends Annotation> list);

        Builder<T> annotateType(Annotation... annotationArr);

        Builder<T> annotateType(AnnotationDescription... annotationDescriptionArr);

        Builder<T> attribute(TypeAttributeAppender typeAttributeAppender);

        MethodDefinition.ImplementationDefinition<T> constructor(ElementMatcher<? super MethodDescription> elementMatcher);

        Builder<T> declaredTypes(Collection<? extends TypeDescription> collection);

        Builder<T> declaredTypes(List<? extends Class<?>> list);

        Builder<T> declaredTypes(Class<?>... clsArr);

        Builder<T> declaredTypes(TypeDescription... typeDescriptionArr);

        FieldDefinition.Optional.Valuable<T> define(Field field);

        FieldDefinition.Optional.Valuable<T> define(FieldDescription fieldDescription);

        MethodDefinition.ImplementationDefinition<T> define(Constructor<?> constructor);

        MethodDefinition.ImplementationDefinition<T> define(Method method);

        MethodDefinition.ImplementationDefinition<T> define(MethodDescription methodDescription);

        RecordComponentDefinition.Optional<T> define(RecordComponentDescription recordComponentDescription);

        MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(int i11);

        MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(Collection<? extends ModifierContributor.ForMethod> collection);

        MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(ModifierContributor.ForMethod... forMethodArr);

        FieldDefinition.Optional.Valuable<T> defineField(String str, Type type, int i11);

        FieldDefinition.Optional.Valuable<T> defineField(String str, Type type, Collection<? extends ModifierContributor.ForField> collection);

        FieldDefinition.Optional.Valuable<T> defineField(String str, Type type, ModifierContributor.ForField... forFieldArr);

        FieldDefinition.Optional.Valuable<T> defineField(String str, TypeDefinition typeDefinition, int i11);

        FieldDefinition.Optional.Valuable<T> defineField(String str, TypeDefinition typeDefinition, Collection<? extends ModifierContributor.ForField> collection);

        FieldDefinition.Optional.Valuable<T> defineField(String str, TypeDefinition typeDefinition, ModifierContributor.ForField... forFieldArr);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, Type type, int i11);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, Type type, Collection<? extends ModifierContributor.ForMethod> collection);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, Type type, ModifierContributor.ForMethod... forMethodArr);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, TypeDefinition typeDefinition, int i11);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, TypeDefinition typeDefinition, Collection<? extends ModifierContributor.ForMethod> collection);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, TypeDefinition typeDefinition, ModifierContributor.ForMethod... forMethodArr);

        FieldDefinition.Optional<T> defineProperty(String str, Type type);

        FieldDefinition.Optional<T> defineProperty(String str, Type type, boolean z11);

        FieldDefinition.Optional<T> defineProperty(String str, TypeDefinition typeDefinition);

        FieldDefinition.Optional<T> defineProperty(String str, TypeDefinition typeDefinition, boolean z11);

        RecordComponentDefinition.Optional<T> defineRecordComponent(String str, Type type);

        RecordComponentDefinition.Optional<T> defineRecordComponent(String str, TypeDefinition typeDefinition);

        FieldDefinition.Valuable<T> field(ElementMatcher<? super FieldDescription> elementMatcher);

        FieldDefinition.Valuable<T> field(LatentMatcher<? super FieldDescription> latentMatcher);

        Builder<T> ignoreAlso(ElementMatcher<? super MethodDescription> elementMatcher);

        Builder<T> ignoreAlso(LatentMatcher<? super MethodDescription> latentMatcher);

        MethodDefinition.ImplementationDefinition.Optional<T> implement(Collection<? extends TypeDefinition> collection);

        MethodDefinition.ImplementationDefinition.Optional<T> implement(List<? extends Type> list);

        MethodDefinition.ImplementationDefinition.Optional<T> implement(Type... typeArr);

        MethodDefinition.ImplementationDefinition.Optional<T> implement(TypeDefinition... typeDefinitionArr);

        Builder<T> initializer(LoadedTypeInitializer loadedTypeInitializer);

        Builder<T> initializer(ByteCodeAppender byteCodeAppender);

        InnerTypeDefinition.ForType<T> innerTypeOf(Class<?> cls);

        InnerTypeDefinition.ForType<T> innerTypeOf(TypeDescription typeDescription);

        InnerTypeDefinition<T> innerTypeOf(Constructor<?> constructor);

        InnerTypeDefinition<T> innerTypeOf(Method method);

        InnerTypeDefinition<T> innerTypeOf(MethodDescription.InDefinedShape inDefinedShape);

        MethodDefinition.ImplementationDefinition<T> invokable(ElementMatcher<? super MethodDescription> elementMatcher);

        MethodDefinition.ImplementationDefinition<T> invokable(LatentMatcher<? super MethodDescription> latentMatcher);

        Unloaded<T> make();

        Unloaded<T> make(TypeResolutionStrategy typeResolutionStrategy);

        Unloaded<T> make(TypeResolutionStrategy typeResolutionStrategy, TypePool typePool);

        Unloaded<T> make(TypePool typePool);

        Builder<T> merge(Collection<? extends ModifierContributor.ForType> collection);

        Builder<T> merge(ModifierContributor.ForType... forTypeArr);

        MethodDefinition.ImplementationDefinition<T> method(ElementMatcher<? super MethodDescription> elementMatcher);

        Builder<T> modifiers(int i11);

        Builder<T> modifiers(Collection<? extends ModifierContributor.ForType> collection);

        Builder<T> modifiers(ModifierContributor.ForType... forTypeArr);

        Builder<T> name(String str);

        Builder<T> nestHost(Class<?> cls);

        Builder<T> nestHost(TypeDescription typeDescription);

        Builder<T> nestMembers(Collection<? extends TypeDescription> collection);

        Builder<T> nestMembers(List<? extends Class<?>> list);

        Builder<T> nestMembers(Class<?>... clsArr);

        Builder<T> nestMembers(TypeDescription... typeDescriptionArr);

        Builder<T> noNestMate();

        Builder<T> permittedSubclass(Collection<? extends TypeDescription> collection);

        Builder<T> permittedSubclass(List<? extends Class<?>> list);

        Builder<T> permittedSubclass(Class<?>... clsArr);

        Builder<T> permittedSubclass(TypeDescription... typeDescriptionArr);

        RecordComponentDefinition<T> recordComponent(ElementMatcher<? super RecordComponentDescription> elementMatcher);

        RecordComponentDefinition<T> recordComponent(LatentMatcher<? super RecordComponentDescription> latentMatcher);

        Builder<T> require(Collection<DynamicType> collection);

        Builder<T> require(TypeDescription typeDescription, byte[] bArr);

        Builder<T> require(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer);

        Builder<T> require(DynamicType... dynamicTypeArr);

        FieldDefinition.Optional<T> serialVersionUid(long j11);

        Builder<T> suffix(String str);

        TypeDescription toTypeDescription();

        Builder<T> topLevelType();

        Builder<T> transform(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer);

        TypeVariableDefinition<T> typeVariable(String str);

        TypeVariableDefinition<T> typeVariable(String str, Collection<? extends TypeDefinition> collection);

        TypeVariableDefinition<T> typeVariable(String str, List<? extends Type> list);

        TypeVariableDefinition<T> typeVariable(String str, Type... typeArr);

        TypeVariableDefinition<T> typeVariable(String str, TypeDefinition... typeDefinitionArr);

        Builder<T> unsealed();

        Builder<T> visit(AsmVisitorWrapper asmVisitorWrapper);

        Builder<T> withHashCodeEquals();

        Builder<T> withToString();
    }

    public interface Loaded<T> extends DynamicType {
        Map<TypeDescription, Class<?>> getAllLoaded();

        Class<? extends T> getLoaded();

        Map<TypeDescription, Class<?>> getLoadedAuxiliaryTypes();
    }

    public interface Unloaded<T> extends DynamicType {
        Unloaded<T> include(List<? extends DynamicType> list);

        Unloaded<T> include(DynamicType... dynamicTypeArr);

        Loaded<T> load(ClassLoader classLoader);

        <S extends ClassLoader> Loaded<T> load(S s11, ClassLoadingStrategy<? super S> classLoadingStrategy);
    }

    Map<TypeDescription, byte[]> getAllTypes();

    Map<TypeDescription, byte[]> getAuxiliaryTypes();

    byte[] getBytes();

    Map<TypeDescription, LoadedTypeInitializer> getLoadedTypeInitializers();

    TypeDescription getTypeDescription();

    boolean hasAliveLoadedTypeInitializers();

    File inject(File file) throws IOException;

    File inject(File file, File file2) throws IOException;

    Map<TypeDescription, File> saveIn(File file) throws IOException;

    File toJar(File file) throws IOException;

    File toJar(File file, Manifest manifest) throws IOException;

    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements DynamicType {
        private static final int BUFFER_SIZE = 1024;
        private static final String CLASS_FILE_EXTENSION = ".class";
        private static final int END_OF_FILE = -1;
        private static final int FROM_BEGINNING = 0;
        private static final String MANIFEST_VERSION = "1.0";
        private static final String TEMP_SUFFIX = "tmp";

        /* renamed from: a  reason: collision with root package name */
        public final TypeDescription f27170a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f27171b;

        /* renamed from: c  reason: collision with root package name */
        public final LoadedTypeInitializer f27172c;

        /* renamed from: d  reason: collision with root package name */
        public final List<? extends DynamicType> f27173d;

        @HashCodeAndEqualsPlugin.Enhance
        public static class Loaded<T> extends Default implements Loaded<T> {
            private final Map<TypeDescription, Class<?>> loadedTypes;

            public Loaded(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer, List<? extends DynamicType> list, Map<TypeDescription, Class<?>> map) {
                super(typeDescription, bArr, loadedTypeInitializer, list);
                this.loadedTypes = map;
            }

            public boolean equals(Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.loadedTypes.equals(((Loaded) obj).loadedTypes);
            }

            public Map<TypeDescription, Class<?>> getAllLoaded() {
                return new HashMap(this.loadedTypes);
            }

            public Class<? extends T> getLoaded() {
                return this.loadedTypes.get(this.f27170a);
            }

            public Map<TypeDescription, Class<?>> getLoadedAuxiliaryTypes() {
                HashMap hashMap = new HashMap(this.loadedTypes);
                hashMap.remove(this.f27170a);
                return hashMap;
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.loadedTypes.hashCode();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Unloaded<T> extends Default implements Unloaded<T> {
            private final TypeResolutionStrategy.Resolved typeResolutionStrategy;

            public Unloaded(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer, List<? extends DynamicType> list, TypeResolutionStrategy.Resolved resolved) {
                super(typeDescription, bArr, loadedTypeInitializer, list);
                this.typeResolutionStrategy = resolved;
            }

            public boolean equals(Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typeResolutionStrategy.equals(((Unloaded) obj).typeResolutionStrategy);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.typeResolutionStrategy.hashCode();
            }

            public Unloaded<T> include(DynamicType... dynamicTypeArr) {
                return include((List<? extends DynamicType>) Arrays.asList(dynamicTypeArr));
            }

            public Loaded<T> load(ClassLoader classLoader) {
                if (classLoader instanceof InjectionClassLoader) {
                    InjectionClassLoader injectionClassLoader = (InjectionClassLoader) classLoader;
                    if (!injectionClassLoader.isSealed()) {
                        return load(injectionClassLoader, InjectionClassLoader.Strategy.INSTANCE);
                    }
                }
                return load(classLoader, ClassLoadingStrategy.Default.WRAPPER);
            }

            public Unloaded<T> include(List<? extends DynamicType> list) {
                return new Unloaded(this.f27170a, this.f27171b, this.f27172c, CompoundList.of(this.f27173d, list), this.typeResolutionStrategy);
            }

            public <S extends ClassLoader> Loaded<T> load(S s11, ClassLoadingStrategy<? super S> classLoadingStrategy) {
                return new Loaded(this.f27170a, this.f27171b, this.f27172c, this.f27173d, this.typeResolutionStrategy.initialize(this, s11, classLoadingStrategy));
            }
        }

        @SuppressFBWarnings(justification = "The array is not to be modified by contract", value = {"EI_EXPOSE_REP2"})
        public Default(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer, List<? extends DynamicType> list) {
            this.f27170a = typeDescription;
            this.f27171b = bArr;
            this.f27172c = loadedTypeInitializer;
            this.f27173d = list;
        }

        private File doInject(File file, File file2) throws IOException {
            JarOutputStream jarOutputStream;
            JarInputStream jarInputStream = new JarInputStream(new FileInputStream(file));
            try {
                if (!file2.isFile()) {
                    if (!file2.createNewFile()) {
                        throw new IllegalArgumentException("Could not create file: " + file2);
                    }
                }
                Manifest manifest = jarInputStream.getManifest();
                if (manifest == null) {
                    jarOutputStream = new JarOutputStream(new FileOutputStream(file2));
                } else {
                    jarOutputStream = new JarOutputStream(new FileOutputStream(file2), manifest);
                }
                Map<TypeDescription, byte[]> auxiliaryTypes = getAuxiliaryTypes();
                HashMap hashMap = new HashMap();
                for (Map.Entry next : auxiliaryTypes.entrySet()) {
                    hashMap.put(((TypeDescription) next.getKey()).getInternalName() + ".class", next.getValue());
                }
                hashMap.put(this.f27170a.getInternalName() + ".class", this.f27171b);
                while (true) {
                    JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
                    if (nextJarEntry == null) {
                        break;
                    }
                    byte[] bArr = (byte[]) hashMap.remove(nextJarEntry.getName());
                    if (bArr == null) {
                        jarOutputStream.putNextEntry(nextJarEntry);
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = jarInputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            jarOutputStream.write(bArr2, 0, read);
                        }
                    } else {
                        jarOutputStream.putNextEntry(new JarEntry(nextJarEntry.getName()));
                        jarOutputStream.write(bArr);
                    }
                    jarInputStream.closeEntry();
                    jarOutputStream.closeEntry();
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    jarOutputStream.putNextEntry(new JarEntry((String) entry.getKey()));
                    jarOutputStream.write((byte[]) entry.getValue());
                    jarOutputStream.closeEntry();
                }
                jarOutputStream.close();
                jarInputStream.close();
                return file2;
            } catch (Throwable th2) {
                jarInputStream.close();
                throw th2;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Default defaultR = (Default) obj;
            return this.f27170a.equals(defaultR.f27170a) && Arrays.equals(this.f27171b, defaultR.f27171b) && this.f27172c.equals(defaultR.f27172c) && this.f27173d.equals(defaultR.f27173d);
        }

        public Map<TypeDescription, byte[]> getAllTypes() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(this.f27170a, this.f27171b);
            for (DynamicType allTypes : this.f27173d) {
                linkedHashMap.putAll(allTypes.getAllTypes());
            }
            return linkedHashMap;
        }

        public Map<TypeDescription, byte[]> getAuxiliaryTypes() {
            HashMap hashMap = new HashMap();
            for (DynamicType dynamicType : this.f27173d) {
                hashMap.put(dynamicType.getTypeDescription(), dynamicType.getBytes());
                hashMap.putAll(dynamicType.getAuxiliaryTypes());
            }
            return hashMap;
        }

        @SuppressFBWarnings(justification = "The array is not to be modified by contract", value = {"EI_EXPOSE_REP"})
        public byte[] getBytes() {
            return this.f27171b;
        }

        public Map<TypeDescription, LoadedTypeInitializer> getLoadedTypeInitializers() {
            HashMap hashMap = new HashMap();
            for (DynamicType loadedTypeInitializers : this.f27173d) {
                hashMap.putAll(loadedTypeInitializers.getLoadedTypeInitializers());
            }
            hashMap.put(this.f27170a, this.f27172c);
            return hashMap;
        }

        public TypeDescription getTypeDescription() {
            return this.f27170a;
        }

        public boolean hasAliveLoadedTypeInitializers() {
            for (LoadedTypeInitializer isAlive : getLoadedTypeInitializers().values()) {
                if (isAlive.isAlive()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.f27170a.hashCode()) * 31) + Arrays.hashCode(this.f27171b)) * 31) + this.f27172c.hashCode()) * 31) + this.f27173d.hashCode();
        }

        public File inject(File file, File file2) throws IOException {
            if (file.equals(file2)) {
                return inject(file);
            }
            return doInject(file, file2);
        }

        /* JADX INFO: finally extract failed */
        public Map<TypeDescription, File> saveIn(File file) throws IOException {
            HashMap hashMap = new HashMap();
            File file2 = new File(file, this.f27170a.getName().replace('.', File.separatorChar) + ".class");
            if (file2.getParentFile() == null || file2.getParentFile().isDirectory() || file2.getParentFile().mkdirs()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(this.f27171b);
                    fileOutputStream.close();
                    hashMap.put(this.f27170a, file2);
                    for (DynamicType saveIn : this.f27173d) {
                        hashMap.putAll(saveIn.saveIn(file));
                    }
                    return hashMap;
                } catch (Throwable th2) {
                    fileOutputStream.close();
                    throw th2;
                }
            } else {
                throw new IllegalArgumentException("Could not create directory: " + file2.getParentFile());
            }
        }

        public File toJar(File file) throws IOException {
            Manifest manifest = new Manifest();
            manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
            return toJar(file, manifest);
        }

        public File inject(File file) throws IOException {
            FileSystem.getInstance().move(doInject(file, File.createTempFile(file.getName(), TEMP_SUFFIX)), file);
            return file;
        }

        public File toJar(File file, Manifest manifest) throws IOException {
            if (file.isFile() || file.createNewFile()) {
                JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(file), manifest);
                try {
                    for (Map.Entry next : getAuxiliaryTypes().entrySet()) {
                        jarOutputStream.putNextEntry(new JarEntry(((TypeDescription) next.getKey()).getInternalName() + ".class"));
                        jarOutputStream.write((byte[]) next.getValue());
                        jarOutputStream.closeEntry();
                    }
                    jarOutputStream.putNextEntry(new JarEntry(this.f27170a.getInternalName() + ".class"));
                    jarOutputStream.write(this.f27171b);
                    jarOutputStream.closeEntry();
                    return file;
                } finally {
                    jarOutputStream.close();
                }
            } else {
                throw new IllegalArgumentException("Could not create file: " + file);
            }
        }
    }
}
