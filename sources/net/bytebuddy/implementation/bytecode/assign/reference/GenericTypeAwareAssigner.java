package net.bytebuddy.implementation.bytecode.assign.reference;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

public enum GenericTypeAwareAssigner implements Assigner {
    INSTANCE;

    @HashCodeAndEqualsPlugin.Enhance
    public static class IsAssignableToVisitor implements TypeDescription.Generic.Visitor<Boolean> {
        private final boolean polymorphic;
        private final TypeDescription.Generic typeDescription;

        public static class OfGenericArray extends OfManifestType {
            public OfGenericArray(TypeDescription.Generic generic, boolean z11) {
                super(generic, z11);
            }

            public Boolean onGenericArray(TypeDescription.Generic generic) {
                TypeDescription.Generic componentType = this.f27331b.getComponentType();
                TypeDescription.Generic componentType2 = generic.getComponentType();
                while (componentType.getSort().isGenericArray() && componentType2.getSort().isGenericArray()) {
                    componentType = componentType.getComponentType();
                    componentType2 = componentType2.getComponentType();
                }
                return Boolean.valueOf(!componentType.getSort().isGenericArray() && !componentType2.getSort().isGenericArray() && ((Boolean) componentType.accept(new IsAssignableToVisitor(componentType2))).booleanValue());
            }

            public Boolean onNonGenericType(TypeDescription.Generic generic) {
                boolean z11;
                if (this.f27332c) {
                    z11 = this.f27331b.asErasure().isAssignableTo(generic.asErasure());
                } else {
                    z11 = this.f27331b.asErasure().equals(generic.asErasure());
                }
                return Boolean.valueOf(z11);
            }

            public Boolean onParameterizedType(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class OfManifestType implements TypeDescription.Generic.Visitor<Boolean> {

            /* renamed from: b  reason: collision with root package name */
            public final TypeDescription.Generic f27331b;

            /* renamed from: c  reason: collision with root package name */
            public final boolean f27332c;

            public OfManifestType(TypeDescription.Generic generic, boolean z11) {
                this.f27331b = generic;
                this.f27332c = z11;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                OfManifestType ofManifestType = (OfManifestType) obj;
                return this.f27332c == ofManifestType.f27332c && this.f27331b.equals(ofManifestType.f27331b);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.f27331b.hashCode()) * 31) + (this.f27332c ? 1 : 0);
            }

            public Boolean onTypeVariable(TypeDescription.Generic generic) {
                if (!generic.getTypeVariableSource().isInferrable()) {
                    return Boolean.FALSE;
                }
                throw new UnsupportedOperationException("Assignability checks for type variables declared by methods arel not currently supported");
            }

            public Boolean onWildcard(TypeDescription.Generic generic) {
                for (TypeDescription.Generic isAssignableToVisitor : generic.getUpperBounds()) {
                    if (!((Boolean) this.f27331b.accept(new IsAssignableToVisitor(isAssignableToVisitor))).booleanValue()) {
                        return Boolean.FALSE;
                    }
                }
                for (TypeDescription.Generic accept : generic.getLowerBounds()) {
                    if (!((Boolean) accept.accept(new IsAssignableToVisitor(this.f27331b))).booleanValue()) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
        }

        public static class OfNonGenericType extends OfSimpleType {
            public OfNonGenericType(TypeDescription.Generic generic, boolean z11) {
                super(generic, z11);
            }

            public Boolean onGenericArray(TypeDescription.Generic generic) {
                boolean z11;
                if (this.f27332c) {
                    z11 = this.f27331b.asErasure().isAssignableTo(generic.asErasure());
                } else {
                    z11 = this.f27331b.asErasure().equals(generic.asErasure());
                }
                return Boolean.valueOf(z11);
            }
        }

        public static class OfParameterizedType extends OfSimpleType {
            public OfParameterizedType(TypeDescription.Generic generic, boolean z11) {
                super(generic, z11);
            }

            public Boolean onGenericArray(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }
        }

        public static abstract class OfSimpleType extends OfManifestType {
            public OfSimpleType(TypeDescription.Generic generic, boolean z11) {
                super(generic, z11);
            }

            public Boolean onNonGenericType(TypeDescription.Generic generic) {
                boolean z11;
                if (this.f27332c) {
                    z11 = this.f27331b.asErasure().isAssignableTo(generic.asErasure());
                } else {
                    z11 = this.f27331b.asErasure().equals(generic.asErasure());
                }
                return Boolean.valueOf(z11);
            }

            public Boolean onParameterizedType(TypeDescription.Generic generic) {
                LinkedList linkedList = new LinkedList(Collections.singleton(this.f27331b));
                HashSet hashSet = new HashSet(Collections.singleton(this.f27331b.asErasure()));
                do {
                    TypeDescription.Generic generic2 = (TypeDescription.Generic) linkedList.remove();
                    if (generic2.asErasure().equals(generic.asErasure())) {
                        if (generic2.getSort().isNonGeneric()) {
                            return Boolean.TRUE;
                        }
                        TypeList.Generic typeArguments = generic2.getTypeArguments();
                        TypeList.Generic typeArguments2 = generic.getTypeArguments();
                        int size = typeArguments2.size();
                        if (typeArguments.size() != size) {
                            return Boolean.FALSE;
                        }
                        boolean z11 = false;
                        for (int i11 = 0; i11 < size; i11++) {
                            if (!((Boolean) ((TypeDescription.Generic) typeArguments.get(i11)).accept(new IsAssignableToVisitor((TypeDescription.Generic) typeArguments2.get(i11), false))).booleanValue()) {
                                return Boolean.FALSE;
                            }
                        }
                        TypeDescription.Generic ownerType = generic.getOwnerType();
                        if (ownerType == null || ((Boolean) ownerType.accept(new IsAssignableToVisitor(generic.getOwnerType()))).booleanValue()) {
                            z11 = true;
                        }
                        return Boolean.valueOf(z11);
                    } else if (this.f27332c) {
                        TypeDescription.Generic superClass = generic2.getSuperClass();
                        if (superClass != null && hashSet.add(superClass.asErasure())) {
                            linkedList.add(superClass);
                        }
                        for (TypeDescription.Generic generic3 : generic2.getInterfaces()) {
                            if (hashSet.add(generic3.asErasure())) {
                                linkedList.add(generic3);
                            }
                        }
                    }
                } while (!linkedList.isEmpty());
                return Boolean.FALSE;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OfWildcard implements TypeDescription.Generic.Visitor<Boolean> {
            private final TypeDescription.Generic wildcard;

            public OfWildcard(TypeDescription.Generic generic) {
                this.wildcard = generic;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.wildcard.equals(((OfWildcard) obj).wildcard);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.wildcard.hashCode();
            }

            public Boolean onGenericArray(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            public Boolean onNonGenericType(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            public Boolean onParameterizedType(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            public Boolean onTypeVariable(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            public Boolean onWildcard(TypeDescription.Generic generic) {
                Iterator it = generic.getUpperBounds().iterator();
                boolean z11 = false;
                while (true) {
                    boolean z12 = false;
                    while (true) {
                        Class<Object> cls = Object.class;
                        if (it.hasNext()) {
                            TypeDescription.Generic generic2 = (TypeDescription.Generic) it.next();
                            for (TypeDescription.Generic accept : this.wildcard.getUpperBounds()) {
                                if (!((Boolean) accept.accept(new IsAssignableToVisitor(generic2))).booleanValue()) {
                                    return Boolean.FALSE;
                                }
                            }
                            if (z12 || !generic2.represents(cls)) {
                                z12 = true;
                            }
                        } else {
                            boolean z13 = false;
                            for (TypeDescription.Generic generic3 : generic.getLowerBounds()) {
                                for (TypeDescription.Generic isAssignableToVisitor : this.wildcard.getLowerBounds()) {
                                    if (!((Boolean) generic3.accept(new IsAssignableToVisitor(isAssignableToVisitor))).booleanValue()) {
                                        return Boolean.FALSE;
                                    }
                                }
                                z13 = true;
                            }
                            if (z12) {
                                return Boolean.valueOf(this.wildcard.getLowerBounds().isEmpty());
                            }
                            if (!z13) {
                                return Boolean.TRUE;
                            }
                            TypeList.Generic upperBounds = this.wildcard.getUpperBounds();
                            if (upperBounds.size() == 0 || (upperBounds.size() == 1 && ((TypeDescription.Generic) upperBounds.getOnly()).represents(cls))) {
                                z11 = true;
                            }
                            return Boolean.valueOf(z11);
                        }
                    }
                }
            }
        }

        public IsAssignableToVisitor(TypeDescription.Generic generic) {
            this(generic, true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            IsAssignableToVisitor isAssignableToVisitor = (IsAssignableToVisitor) obj;
            return this.polymorphic == isAssignableToVisitor.polymorphic && this.typeDescription.equals(isAssignableToVisitor.typeDescription);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.typeDescription.hashCode()) * 31) + (this.polymorphic ? 1 : 0);
        }

        public IsAssignableToVisitor(TypeDescription.Generic generic, boolean z11) {
            this.typeDescription = generic;
            this.polymorphic = z11;
        }

        public Boolean onGenericArray(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfGenericArray(generic, this.polymorphic));
        }

        public Boolean onNonGenericType(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfNonGenericType(generic, this.polymorphic));
        }

        public Boolean onParameterizedType(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfParameterizedType(generic, this.polymorphic));
        }

        public Boolean onTypeVariable(TypeDescription.Generic generic) {
            if (generic.getTypeVariableSource().isInferrable()) {
                throw new UnsupportedOperationException("Assignability checks for type variables declared by methods are not currently supported");
            } else if (generic.equals(this.typeDescription)) {
                return Boolean.TRUE;
            } else {
                if (!this.polymorphic) {
                    return Boolean.FALSE;
                }
                LinkedList linkedList = new LinkedList(generic.getUpperBounds());
                while (!linkedList.isEmpty()) {
                    TypeDescription.Generic generic2 = (TypeDescription.Generic) linkedList.remove();
                    if (((Boolean) generic2.accept(new IsAssignableToVisitor(this.typeDescription))).booleanValue()) {
                        return Boolean.TRUE;
                    }
                    if (generic2.getSort().isTypeVariable()) {
                        linkedList.addAll(generic2.getUpperBounds());
                    }
                }
                return Boolean.FALSE;
            }
        }

        public Boolean onWildcard(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfWildcard(generic));
        }
    }

    public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Assigner.Typing typing) {
        if (generic.isPrimitive() || generic2.isPrimitive()) {
            if (generic.equals(generic2)) {
                return StackManipulation.Trivial.INSTANCE;
            }
            return StackManipulation.Illegal.INSTANCE;
        } else if (((Boolean) generic.accept(new IsAssignableToVisitor(generic2))).booleanValue()) {
            return StackManipulation.Trivial.INSTANCE;
        } else {
            if (!typing.isDynamic()) {
                return StackManipulation.Illegal.INSTANCE;
            }
            if (generic.asErasure().isAssignableTo(generic2.asErasure())) {
                return StackManipulation.Trivial.INSTANCE;
            }
            return TypeCasting.to(generic2);
        }
    }
}
