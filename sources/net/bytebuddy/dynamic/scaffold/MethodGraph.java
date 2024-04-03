package net.bytebuddy.dynamic.scaffold;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.FilterableList;

public interface MethodGraph {

    @SuppressFBWarnings(justification = "Safe initialization is implied", value = {"IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION"})
    public interface Compiler {
        public static final Compiler DEFAULT = Default.forJavaHierarchy();

        public static abstract class AbstractBase implements Compiler {
            public Linked compile(TypeDefinition typeDefinition) {
                return compile(typeDefinition, typeDefinition.asErasure());
            }

            @Deprecated
            public Linked compile(TypeDescription typeDescription) {
                return compile((TypeDefinition) typeDescription, typeDescription);
            }

            @Deprecated
            public Linked compile(TypeDescription typeDescription, TypeDescription typeDescription2) {
                return compile((TypeDefinition) typeDescription, typeDescription2);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Default<T> extends AbstractBase {
            private final Harmonizer<T> harmonizer;
            private final Merger merger;
            private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

            public interface Harmonizer<S> {

                public enum ForJVMMethod implements Harmonizer<Token> {
                    INSTANCE;

                    public static class Token {
                        private final int hashCode;
                        private final MethodDescription.TypeToken typeToken;

                        public Token(MethodDescription.TypeToken typeToken2) {
                            this.typeToken = typeToken2;
                            this.hashCode = typeToken2.getReturnType().hashCode() + (typeToken2.getParameterTypes().hashCode() * 31);
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (!(obj instanceof Token)) {
                                return false;
                            }
                            Token token = (Token) obj;
                            if (!this.typeToken.getReturnType().equals(token.typeToken.getReturnType()) || !this.typeToken.getParameterTypes().equals(token.typeToken.getParameterTypes())) {
                                return false;
                            }
                            return true;
                        }

                        public int hashCode() {
                            return this.hashCode;
                        }

                        public String toString() {
                            return this.typeToken.toString();
                        }
                    }

                    public Token harmonize(MethodDescription.TypeToken typeToken) {
                        return new Token(typeToken);
                    }
                }

                public enum ForJavaMethod implements Harmonizer<Token> {
                    INSTANCE;

                    public static class Token {
                        private final int hashCode;
                        private final MethodDescription.TypeToken typeToken;

                        public Token(MethodDescription.TypeToken typeToken2) {
                            this.typeToken = typeToken2;
                            this.hashCode = typeToken2.getParameterTypes().hashCode();
                        }

                        public boolean equals(Object obj) {
                            return this == obj || ((obj instanceof Token) && this.typeToken.getParameterTypes().equals(((Token) obj).typeToken.getParameterTypes()));
                        }

                        public int hashCode() {
                            return this.hashCode;
                        }

                        public String toString() {
                            return this.typeToken.getParameterTypes().toString();
                        }
                    }

                    public Token harmonize(MethodDescription.TypeToken typeToken) {
                        return new Token(typeToken);
                    }
                }

                S harmonize(MethodDescription.TypeToken typeToken);
            }

            public static abstract class Key<S> {

                /* renamed from: a  reason: collision with root package name */
                public final String f27201a;

                /* renamed from: b  reason: collision with root package name */
                public final int f27202b;

                public static class Detached extends Key<MethodDescription.TypeToken> {
                    private final Set<MethodDescription.TypeToken> identifiers;

                    public Detached(String str, int i11, Set<MethodDescription.TypeToken> set) {
                        super(str, i11);
                        this.identifiers = set;
                    }

                    public static Detached b(MethodDescription.SignatureToken signatureToken) {
                        return new Detached(signatureToken.getName(), signatureToken.getParameterTypes().size(), Collections.singleton(signatureToken.asTypeToken()));
                    }

                    public Set<MethodDescription.TypeToken> a() {
                        return this.identifiers;
                    }
                }

                public static class Harmonized<V> extends Key<V> {
                    private final Map<V, Set<MethodDescription.TypeToken>> identifiers;

                    public Harmonized(String str, int i11, Map<V, Set<MethodDescription.TypeToken>> map) {
                        super(str, i11);
                        this.identifiers = map;
                    }

                    public static <Q> Harmonized<Q> e(MethodDescription methodDescription, Harmonizer<Q> harmonizer) {
                        return new Harmonized<>(methodDescription.getInternalName(), methodDescription.getParameters().size(), Collections.singletonMap(harmonizer.harmonize(methodDescription.asTypeToken()), Collections.emptySet()));
                    }

                    public Set<V> a() {
                        return this.identifiers.keySet();
                    }

                    public Harmonized<V> b(Harmonized<V> harmonized) {
                        HashMap hashMap = new HashMap(this.identifiers);
                        for (Map.Entry next : harmonized.identifiers.entrySet()) {
                            Set set = (Set) hashMap.get(next.getKey());
                            if (set == null) {
                                hashMap.put(next.getKey(), next.getValue());
                            } else {
                                HashSet hashSet = new HashSet(set);
                                hashSet.addAll((Collection) next.getValue());
                                hashMap.put(next.getKey(), hashSet);
                            }
                        }
                        return new Harmonized<>(this.f27201a, this.f27202b, hashMap);
                    }

                    public Detached c(MethodDescription.TypeToken typeToken) {
                        HashSet hashSet = new HashSet();
                        for (Set<MethodDescription.TypeToken> addAll : this.identifiers.values()) {
                            hashSet.addAll(addAll);
                        }
                        hashSet.add(typeToken);
                        return new Detached(this.f27201a, this.f27202b, hashSet);
                    }

                    public Harmonized<V> d(MethodDescription.InDefinedShape inDefinedShape, Harmonizer<V> harmonizer) {
                        HashMap hashMap = new HashMap(this.identifiers);
                        MethodDescription.TypeToken asTypeToken = inDefinedShape.asTypeToken();
                        V harmonize = harmonizer.harmonize(asTypeToken);
                        Set set = (Set) hashMap.get(harmonize);
                        if (set == null) {
                            hashMap.put(harmonize, Collections.singleton(asTypeToken));
                        } else {
                            HashSet hashSet = new HashSet(set);
                            hashSet.add(asTypeToken);
                            hashMap.put(harmonize, hashSet);
                        }
                        return new Harmonized<>(this.f27201a, this.f27202b, hashMap);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Store<V> {
                    private final LinkedHashMap<Harmonized<V>, Entry<V>> entries;

                    public interface Entry<W> {

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Ambiguous<U> implements Entry<U> {
                            private final Harmonized<U> key;
                            private final LinkedHashSet<MethodDescription> methodDescriptions;
                            private final Visibility visibility;

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Node implements Node {
                                private final Detached key;
                                private final MethodDescription methodDescription;
                                private final Visibility visibility;

                                public Node(Detached detached, MethodDescription methodDescription2, Visibility visibility2) {
                                    this.key = detached;
                                    this.methodDescription = methodDescription2;
                                    this.visibility = visibility2;
                                }

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Node node = (Node) obj;
                                    return this.visibility.equals(node.visibility) && this.key.equals(node.key) && this.methodDescription.equals(node.methodDescription);
                                }

                                public Set<MethodDescription.TypeToken> getMethodTypes() {
                                    return this.key.a();
                                }

                                public MethodDescription getRepresentative() {
                                    return this.methodDescription;
                                }

                                public Node.Sort getSort() {
                                    return Node.Sort.AMBIGUOUS;
                                }

                                public Visibility getVisibility() {
                                    return this.visibility;
                                }

                                public int hashCode() {
                                    return (((((getClass().hashCode() * 31) + this.key.hashCode()) * 31) + this.methodDescription.hashCode()) * 31) + this.visibility.hashCode();
                                }
                            }

                            public Ambiguous(Harmonized<U> harmonized, LinkedHashSet<MethodDescription> linkedHashSet, Visibility visibility2) {
                                this.key = harmonized;
                                this.methodDescriptions = linkedHashSet;
                                this.visibility = visibility2;
                            }

                            public static <Q> Entry<Q> a(Harmonized<Q> harmonized, MethodDescription methodDescription, MethodDescription methodDescription2, Visibility visibility2) {
                                Visibility expandTo = visibility2.expandTo(methodDescription.getVisibility()).expandTo(methodDescription2.getVisibility());
                                if (methodDescription.isBridge() ^ methodDescription2.isBridge()) {
                                    if (methodDescription.isBridge()) {
                                        methodDescription = methodDescription2;
                                    }
                                    return new Resolved(harmonized, methodDescription, expandTo, false);
                                }
                                return new Ambiguous(harmonized, new LinkedHashSet(Arrays.asList(new MethodDescription[]{methodDescription, methodDescription2})), expandTo);
                            }

                            public Node asNode(Merger merger) {
                                Iterator<MethodDescription> it = this.methodDescriptions.iterator();
                                MethodDescription next = it.next();
                                while (it.hasNext()) {
                                    next = merger.merge(next, it.next());
                                }
                                return new Node(this.key.c(next.asTypeToken()), next, this.visibility);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                Ambiguous ambiguous = (Ambiguous) obj;
                                return this.visibility.equals(ambiguous.visibility) && this.key.equals(ambiguous.key) && this.methodDescriptions.equals(ambiguous.methodDescriptions);
                            }

                            public Entry<U> extendBy(MethodDescription methodDescription, Harmonizer<U> harmonizer) {
                                MethodDescription methodDescription2;
                                Harmonized<U> d11 = this.key.d((MethodDescription.InDefinedShape) methodDescription.asDefined(), harmonizer);
                                LinkedHashSet linkedHashSet = new LinkedHashSet();
                                TypeDescription asErasure = methodDescription.getDeclaringType().asErasure();
                                boolean isBridge = methodDescription.isBridge();
                                Visibility visibility2 = this.visibility;
                                Iterator<MethodDescription> it = this.methodDescriptions.iterator();
                                while (it.hasNext()) {
                                    MethodDescription next = it.next();
                                    if (next.getDeclaringType().asErasure().equals(asErasure)) {
                                        if (next.isBridge() ^ isBridge) {
                                            if (isBridge) {
                                                methodDescription2 = next;
                                            } else {
                                                methodDescription2 = methodDescription;
                                            }
                                            linkedHashSet.add(methodDescription2);
                                        } else {
                                            linkedHashSet.add(methodDescription);
                                            linkedHashSet.add(next);
                                        }
                                    }
                                    visibility2 = visibility2.expandTo(next.getVisibility());
                                }
                                if (linkedHashSet.isEmpty()) {
                                    return new Resolved(d11, methodDescription, visibility2, isBridge);
                                }
                                if (linkedHashSet.size() == 1) {
                                    return new Resolved(d11, (MethodDescription) linkedHashSet.iterator().next(), visibility2, false);
                                }
                                return new Ambiguous(d11, linkedHashSet, visibility2);
                            }

                            public Set<MethodDescription> getCandidates() {
                                return this.methodDescriptions;
                            }

                            public Harmonized<U> getKey() {
                                return this.key;
                            }

                            public Visibility getVisibility() {
                                return this.visibility;
                            }

                            public int hashCode() {
                                return (((((getClass().hashCode() * 31) + this.key.hashCode()) * 31) + this.methodDescriptions.hashCode()) * 31) + this.visibility.hashCode();
                            }

                            public Entry<U> inject(Harmonized<U> harmonized, Visibility visibility2) {
                                return new Ambiguous(this.key.b(harmonized), this.methodDescriptions, this.visibility.expandTo(visibility2));
                            }
                        }

                        public static class Initial<U> implements Entry<U> {
                            private final Harmonized<U> key;

                            public Initial(Harmonized<U> harmonized) {
                                this.key = harmonized;
                            }

                            public Node asNode(Merger merger) {
                                throw new IllegalStateException("Cannot transform initial entry without a registered method: " + this);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                return this.key.equals(((Initial) obj).key);
                            }

                            public Entry<U> extendBy(MethodDescription methodDescription, Harmonizer<U> harmonizer) {
                                return new Resolved(this.key.d((MethodDescription.InDefinedShape) methodDescription.asDefined(), harmonizer), methodDescription, methodDescription.getVisibility(), false);
                            }

                            public Set<MethodDescription> getCandidates() {
                                throw new IllegalStateException("Cannot extract method from initial entry:" + this);
                            }

                            public Harmonized<U> getKey() {
                                throw new IllegalStateException("Cannot extract key from initial entry:" + this);
                            }

                            public Visibility getVisibility() {
                                throw new IllegalStateException("Cannot extract visibility from initial entry:" + this);
                            }

                            public int hashCode() {
                                return this.key.hashCode();
                            }

                            public Entry<U> inject(Harmonized<U> harmonized, Visibility visibility) {
                                throw new IllegalStateException("Cannot inject into initial entry without a registered method: " + this);
                            }
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Resolved<U> implements Entry<U> {
                            private static final int MADE_VISIBLE = 5;
                            private static final boolean NOT_MADE_VISIBLE = false;
                            private final Harmonized<U> key;
                            private final boolean madeVisible;
                            private final MethodDescription methodDescription;
                            private final Visibility visibility;

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Node implements Node {
                                private final Detached key;
                                private final MethodDescription methodDescription;
                                private final Visibility visibility;
                                private final boolean visible;

                                public Node(Detached detached, MethodDescription methodDescription2, Visibility visibility2, boolean z11) {
                                    this.key = detached;
                                    this.methodDescription = methodDescription2;
                                    this.visibility = visibility2;
                                    this.visible = z11;
                                }

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Node node = (Node) obj;
                                    return this.visible == node.visible && this.visibility.equals(node.visibility) && this.key.equals(node.key) && this.methodDescription.equals(node.methodDescription);
                                }

                                public Set<MethodDescription.TypeToken> getMethodTypes() {
                                    return this.key.a();
                                }

                                public MethodDescription getRepresentative() {
                                    return this.methodDescription;
                                }

                                public Node.Sort getSort() {
                                    return this.visible ? Node.Sort.VISIBLE : Node.Sort.RESOLVED;
                                }

                                public Visibility getVisibility() {
                                    return this.visibility;
                                }

                                public int hashCode() {
                                    return (((((((getClass().hashCode() * 31) + this.key.hashCode()) * 31) + this.methodDescription.hashCode()) * 31) + this.visibility.hashCode()) * 31) + (this.visible ? 1 : 0);
                                }
                            }

                            public Resolved(Harmonized<U> harmonized, MethodDescription methodDescription2, Visibility visibility2, boolean z11) {
                                this.key = harmonized;
                                this.methodDescription = methodDescription2;
                                this.visibility = visibility2;
                                this.madeVisible = z11;
                            }

                            private static <V> Entry<V> of(Harmonized<V> harmonized, MethodDescription methodDescription2, MethodDescription methodDescription3, Visibility visibility2) {
                                Visibility expandTo = visibility2.expandTo(methodDescription3.getVisibility()).expandTo(methodDescription2.getVisibility());
                                boolean z11 = false;
                                if (!methodDescription2.isBridge()) {
                                    return new Resolved(harmonized, methodDescription2, expandTo, false);
                                }
                                if ((methodDescription3.getDeclaringType().getModifiers() & 5) == 0) {
                                    z11 = true;
                                }
                                return new Resolved(harmonized, methodDescription3, expandTo, z11);
                            }

                            public Node asNode(Merger merger) {
                                return new Node(this.key.c(this.methodDescription.asTypeToken()), this.methodDescription, this.visibility, this.madeVisible);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                Resolved resolved = (Resolved) obj;
                                return this.madeVisible == resolved.madeVisible && this.visibility.equals(resolved.visibility) && this.key.equals(resolved.key) && this.methodDescription.equals(resolved.methodDescription);
                            }

                            public Entry<U> extendBy(MethodDescription methodDescription2, Harmonizer<U> harmonizer) {
                                Harmonized<U> d11 = this.key.d((MethodDescription.InDefinedShape) methodDescription2.asDefined(), harmonizer);
                                Visibility expandTo = this.visibility.expandTo(methodDescription2.getVisibility());
                                if (methodDescription2.getDeclaringType().equals(this.methodDescription.getDeclaringType())) {
                                    return Ambiguous.a(d11, methodDescription2, this.methodDescription, expandTo);
                                }
                                return of(d11, methodDescription2, this.methodDescription, expandTo);
                            }

                            public Set<MethodDescription> getCandidates() {
                                return Collections.singleton(this.methodDescription);
                            }

                            public Harmonized<U> getKey() {
                                return this.key;
                            }

                            public Visibility getVisibility() {
                                return this.visibility;
                            }

                            public int hashCode() {
                                return (((((((getClass().hashCode() * 31) + this.key.hashCode()) * 31) + this.methodDescription.hashCode()) * 31) + this.visibility.hashCode()) * 31) + (this.madeVisible ? 1 : 0);
                            }

                            public Entry<U> inject(Harmonized<U> harmonized, Visibility visibility2) {
                                return new Resolved(this.key.b(harmonized), this.methodDescription, this.visibility.expandTo(visibility2), this.madeVisible);
                            }
                        }

                        Node asNode(Merger merger);

                        Entry<W> extendBy(MethodDescription methodDescription, Harmonizer<W> harmonizer);

                        Set<MethodDescription> getCandidates();

                        Harmonized<W> getKey();

                        Visibility getVisibility();

                        Entry<W> inject(Harmonized<W> harmonized, Visibility visibility);
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Graph implements MethodGraph {
                        private final LinkedHashMap<Key<MethodDescription.TypeToken>, Node> entries;

                        public Graph(LinkedHashMap<Key<MethodDescription.TypeToken>, Node> linkedHashMap) {
                            this.entries = linkedHashMap;
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.entries.equals(((Graph) obj).entries);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.entries.hashCode();
                        }

                        public NodeList listNodes() {
                            return new NodeList(new ArrayList(this.entries.values()));
                        }

                        public Node locate(MethodDescription.SignatureToken signatureToken) {
                            Node node = this.entries.get(Detached.b(signatureToken));
                            if (node == null) {
                                return Node.Unresolved.INSTANCE;
                            }
                            return node;
                        }
                    }

                    public Store() {
                        this(new LinkedHashMap());
                    }

                    private static <W> Entry<W> combine(Entry<W> entry, Entry<W> entry2) {
                        Set<MethodDescription> candidates = entry.getCandidates();
                        Set<MethodDescription> candidates2 = entry2.getCandidates();
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        linkedHashSet.addAll(candidates);
                        linkedHashSet.addAll(candidates2);
                        for (MethodDescription next : candidates) {
                            TypeDescription asErasure = next.getDeclaringType().asErasure();
                            Iterator<MethodDescription> it = candidates2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                MethodDescription next2 = it.next();
                                TypeDescription asErasure2 = next2.getDeclaringType().asErasure();
                                if (!asErasure.equals(asErasure2)) {
                                    if (!asErasure.isAssignableTo(asErasure2)) {
                                        if (asErasure.isAssignableFrom(asErasure2)) {
                                            linkedHashSet.remove(next);
                                            break;
                                        }
                                    } else {
                                        linkedHashSet.remove(next2);
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        Harmonized<W> b11 = entry.getKey().b(entry2.getKey());
                        Visibility expandTo = entry.getVisibility().expandTo(entry2.getVisibility());
                        if (linkedHashSet.size() == 1) {
                            return new Entry.Resolved(b11, (MethodDescription) linkedHashSet.iterator().next(), expandTo, false);
                        }
                        return new Entry.Ambiguous(b11, linkedHashSet, expandTo);
                    }

                    public MethodGraph a(Merger merger) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Entry next : this.entries.values()) {
                            Node asNode = next.asNode(merger);
                            linkedHashMap.put(next.getKey().c(asNode.getRepresentative().asTypeToken()), asNode);
                        }
                        return new Graph(linkedHashMap);
                    }

                    public Store<V> b(Store<V> store) {
                        if (this.entries.isEmpty()) {
                            return store;
                        }
                        if (store.entries.isEmpty()) {
                            return this;
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap(this.entries);
                        for (Entry next : store.entries.values()) {
                            Entry entry = (Entry) linkedHashMap.remove(next.getKey());
                            if (entry != null) {
                                next = combine(entry, next);
                            }
                            linkedHashMap.put(next.getKey(), next);
                        }
                        return new Store<>(linkedHashMap);
                    }

                    public Store<V> c(Store<V> store) {
                        if (this.entries.isEmpty()) {
                            return store;
                        }
                        if (store.entries.isEmpty()) {
                            return this;
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap(this.entries);
                        for (Entry next : store.entries.values()) {
                            Entry entry = (Entry) linkedHashMap.remove(next.getKey());
                            if (entry != null) {
                                next = entry.inject(next.getKey(), next.getVisibility());
                            }
                            linkedHashMap.put(next.getKey(), next);
                        }
                        return new Store<>(linkedHashMap);
                    }

                    public Store<V> d(List<? extends MethodDescription> list, Harmonizer<V> harmonizer) {
                        if (list.isEmpty()) {
                            return this;
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap(this.entries);
                        for (MethodDescription methodDescription : list) {
                            Harmonized<Q> e11 = Harmonized.e(methodDescription, harmonizer);
                            Entry entry = (Entry) linkedHashMap.remove(e11);
                            if (entry == null) {
                                entry = new Entry.Initial(e11);
                            }
                            Entry<W> extendBy = entry.extendBy(methodDescription, harmonizer);
                            linkedHashMap.put(extendBy.getKey(), extendBy);
                        }
                        return new Store<>(linkedHashMap);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.entries.equals(((Store) obj).entries);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.entries.hashCode();
                    }

                    private Store(LinkedHashMap<Harmonized<V>, Entry<V>> linkedHashMap) {
                        this.entries = linkedHashMap;
                    }
                }

                public Key(String str, int i11) {
                    this.f27201a = str;
                    this.f27202b = i11;
                }

                public abstract Set<S> a();

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Key)) {
                        return false;
                    }
                    Key key = (Key) obj;
                    if (!this.f27201a.equals(key.f27201a) || this.f27202b != key.f27202b || Collections.disjoint(a(), key.a())) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return this.f27201a.hashCode() + (this.f27202b * 31);
                }
            }

            public interface Merger {

                public enum Directional implements Merger {
                    LEFT(true),
                    RIGHT(false);
                    
                    private final boolean left;

                    private Directional(boolean z11) {
                        this.left = z11;
                    }

                    public MethodDescription merge(MethodDescription methodDescription, MethodDescription methodDescription2) {
                        return this.left ? methodDescription : methodDescription2;
                    }
                }

                MethodDescription merge(MethodDescription methodDescription, MethodDescription methodDescription2);
            }

            public Default(Harmonizer<T> harmonizer2, Merger merger2, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
                this.harmonizer = harmonizer2;
                this.merger = merger2;
                this.visitor = visitor2;
            }

            public static Compiler forJVMHierarchy() {
                return of(Harmonizer.ForJVMMethod.INSTANCE, Merger.Directional.LEFT);
            }

            public static Compiler forJavaHierarchy() {
                return of(Harmonizer.ForJavaMethod.INSTANCE, Merger.Directional.LEFT);
            }

            public static <S> Compiler of(Harmonizer<S> harmonizer2, Merger merger2) {
                return new Default(harmonizer2, merger2, TypeDescription.Generic.Visitor.Reifying.INITIATING);
            }

            public Key.Store<T> a(TypeDefinition typeDefinition, TypeDefinition typeDefinition2, Map<TypeDefinition, Key.Store<T>> map, ElementMatcher<? super MethodDescription> elementMatcher) {
                Key.Store<T> store = map.get(typeDefinition2);
                if (store != null) {
                    return store;
                }
                Key.Store<T> c11 = c(typeDefinition, map, elementMatcher);
                map.put(typeDefinition2, c11);
                return c11;
            }

            public Key.Store<T> b(TypeDescription.Generic generic, Map<TypeDefinition, Key.Store<T>> map, ElementMatcher<? super MethodDescription> elementMatcher) {
                if (generic == null) {
                    return new Key.Store<>();
                }
                return a((TypeDefinition) generic.accept(this.visitor), generic, map, elementMatcher);
            }

            /* JADX WARNING: type inference failed for: r8v0, types: [net.bytebuddy.matcher.ElementMatcher, net.bytebuddy.matcher.ElementMatcher<? super net.bytebuddy.description.method.MethodDescription>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store<T> c(net.bytebuddy.description.type.TypeDefinition r6, java.util.Map<net.bytebuddy.description.type.TypeDefinition, net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store<T>> r7, net.bytebuddy.matcher.ElementMatcher<? super net.bytebuddy.description.method.MethodDescription> r8) {
                /*
                    r5 = this;
                    net.bytebuddy.description.type.TypeDescription$Generic r0 = r6.getSuperClass()
                    net.bytebuddy.dynamic.scaffold.MethodGraph$Compiler$Default$Key$Store r0 = r5.b(r0, r7, r8)
                    net.bytebuddy.dynamic.scaffold.MethodGraph$Compiler$Default$Key$Store r1 = new net.bytebuddy.dynamic.scaffold.MethodGraph$Compiler$Default$Key$Store
                    r1.<init>()
                    net.bytebuddy.description.type.TypeList$Generic r2 = r6.getInterfaces()
                    java.util.Iterator r2 = r2.iterator()
                L_0x0015:
                    boolean r3 = r2.hasNext()
                    if (r3 == 0) goto L_0x0032
                    java.lang.Object r3 = r2.next()
                    net.bytebuddy.description.type.TypeDescription$Generic r3 = (net.bytebuddy.description.type.TypeDescription.Generic) r3
                    net.bytebuddy.description.type.TypeDescription$Generic$Visitor<? extends net.bytebuddy.description.type.TypeDescription$Generic> r4 = r5.visitor
                    java.lang.Object r4 = r3.accept(r4)
                    net.bytebuddy.description.type.TypeDefinition r4 = (net.bytebuddy.description.type.TypeDefinition) r4
                    net.bytebuddy.dynamic.scaffold.MethodGraph$Compiler$Default$Key$Store r3 = r5.a(r4, r3, r7, r8)
                    net.bytebuddy.dynamic.scaffold.MethodGraph$Compiler$Default$Key$Store r1 = r1.b(r3)
                    goto L_0x0015
                L_0x0032:
                    net.bytebuddy.dynamic.scaffold.MethodGraph$Compiler$Default$Key$Store r7 = r0.c(r1)
                    net.bytebuddy.description.method.MethodList r6 = r6.getDeclaredMethods()
                    net.bytebuddy.matcher.FilterableList r6 = r6.filter(r8)
                    net.bytebuddy.dynamic.scaffold.MethodGraph$Compiler$Default$Harmonizer<T> r8 = r5.harmonizer
                    net.bytebuddy.dynamic.scaffold.MethodGraph$Compiler$Default$Key$Store r6 = r7.d(r6, r8)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.c(net.bytebuddy.description.type.TypeDefinition, java.util.Map, net.bytebuddy.matcher.ElementMatcher):net.bytebuddy.dynamic.scaffold.MethodGraph$Compiler$Default$Key$Store");
            }

            public Linked compile(TypeDefinition typeDefinition, TypeDescription typeDescription) {
                Key.Store store;
                MethodGraph methodGraph;
                HashMap hashMap = new HashMap();
                Key.Store c11 = c(typeDefinition, hashMap, ElementMatchers.isVirtual().and(ElementMatchers.isVisibleTo(typeDescription)));
                TypeDescription.Generic superClass = typeDefinition.getSuperClass();
                TypeList.Generic<TypeDescription.Generic> interfaces = typeDefinition.getInterfaces();
                HashMap hashMap2 = new HashMap();
                for (TypeDescription.Generic generic : interfaces) {
                    Key.Store store2 = (Key.Store) hashMap.get(generic);
                    if (store2 != null) {
                        hashMap2.put(generic.asErasure(), store2.a(this.merger));
                    } else {
                        throw new IllegalStateException("Failed to resolve interface type " + generic + " from " + hashMap.keySet());
                    }
                }
                if (superClass == null) {
                    store = null;
                } else {
                    store = (Key.Store) hashMap.get(superClass);
                    if (store == null) {
                        throw new IllegalStateException("Failed to resolve super class " + superClass + " from " + hashMap.keySet());
                    }
                }
                MethodGraph a11 = c11.a(this.merger);
                if (store == null) {
                    methodGraph = Empty.INSTANCE;
                } else {
                    methodGraph = store.a(this.merger);
                }
                return new Linked.Delegation(a11, methodGraph, hashMap2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Default defaultR = (Default) obj;
                return this.harmonizer.equals(defaultR.harmonizer) && this.merger.equals(defaultR.merger) && this.visitor.equals(defaultR.visitor);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.harmonizer.hashCode()) * 31) + this.merger.hashCode()) * 31) + this.visitor.hashCode();
            }

            public static <S> Compiler of(Harmonizer<S> harmonizer2, Merger merger2, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
                return new Default(harmonizer2, merger2, visitor2);
            }
        }

        public enum ForDeclaredMethods implements Compiler {
            INSTANCE;

            public Linked compile(TypeDefinition typeDefinition) {
                return compile(typeDefinition, typeDefinition.asErasure());
            }

            @Deprecated
            public Linked compile(TypeDescription typeDescription) {
                return compile((TypeDefinition) typeDescription, typeDescription);
            }

            public Linked compile(TypeDefinition typeDefinition, TypeDescription typeDescription) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (MethodDescription methodDescription : (MethodList) typeDefinition.getDeclaredMethods().filter(ElementMatchers.isVirtual().and(ElementMatchers.not(ElementMatchers.isBridge())).and(ElementMatchers.isVisibleTo(typeDescription)))) {
                    linkedHashMap.put(methodDescription.asSignatureToken(), new Node.Simple(methodDescription));
                }
                return new Linked.Delegation(new Simple(linkedHashMap), Empty.INSTANCE, Collections.emptyMap());
            }

            @Deprecated
            public Linked compile(TypeDescription typeDescription, TypeDescription typeDescription2) {
                return compile((TypeDefinition) typeDescription, typeDescription2);
            }
        }

        Linked compile(TypeDefinition typeDefinition);

        Linked compile(TypeDefinition typeDefinition, TypeDescription typeDescription);

        @Deprecated
        Linked compile(TypeDescription typeDescription);

        @Deprecated
        Linked compile(TypeDescription typeDescription, TypeDescription typeDescription2);
    }

    public enum Empty implements Linked, Compiler {
        INSTANCE;

        public Linked compile(TypeDefinition typeDefinition) {
            return this;
        }

        public Linked compile(TypeDefinition typeDefinition, TypeDescription typeDescription) {
            return this;
        }

        @Deprecated
        public Linked compile(TypeDescription typeDescription) {
            return this;
        }

        @Deprecated
        public Linked compile(TypeDescription typeDescription, TypeDescription typeDescription2) {
            return this;
        }

        public MethodGraph getInterfaceGraph(TypeDescription typeDescription) {
            return this;
        }

        public MethodGraph getSuperClassGraph() {
            return this;
        }

        public NodeList listNodes() {
            return new NodeList(Collections.emptyList());
        }

        public Node locate(MethodDescription.SignatureToken signatureToken) {
            return Node.Unresolved.INSTANCE;
        }
    }

    public interface Linked extends MethodGraph {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Delegation implements Linked {
            private final Map<TypeDescription, MethodGraph> interfaceGraphs;
            private final MethodGraph methodGraph;
            private final MethodGraph superClassGraph;

            public Delegation(MethodGraph methodGraph2, MethodGraph methodGraph3, Map<TypeDescription, MethodGraph> map) {
                this.methodGraph = methodGraph2;
                this.superClassGraph = methodGraph3;
                this.interfaceGraphs = map;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Delegation delegation = (Delegation) obj;
                return this.methodGraph.equals(delegation.methodGraph) && this.superClassGraph.equals(delegation.superClassGraph) && this.interfaceGraphs.equals(delegation.interfaceGraphs);
            }

            public MethodGraph getInterfaceGraph(TypeDescription typeDescription) {
                MethodGraph methodGraph2 = this.interfaceGraphs.get(typeDescription);
                if (methodGraph2 == null) {
                    return Empty.INSTANCE;
                }
                return methodGraph2;
            }

            public MethodGraph getSuperClassGraph() {
                return this.superClassGraph;
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.methodGraph.hashCode()) * 31) + this.superClassGraph.hashCode()) * 31) + this.interfaceGraphs.hashCode();
            }

            public NodeList listNodes() {
                return this.methodGraph.listNodes();
            }

            public Node locate(MethodDescription.SignatureToken signatureToken) {
                return this.methodGraph.locate(signatureToken);
            }
        }

        MethodGraph getInterfaceGraph(TypeDescription typeDescription);

        MethodGraph getSuperClassGraph();
    }

    public interface Node {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements Node {
            private final MethodDescription methodDescription;

            public Simple(MethodDescription methodDescription2) {
                this.methodDescription = methodDescription2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((Simple) obj).methodDescription);
            }

            public Set<MethodDescription.TypeToken> getMethodTypes() {
                return Collections.emptySet();
            }

            public MethodDescription getRepresentative() {
                return this.methodDescription;
            }

            public Sort getSort() {
                return Sort.RESOLVED;
            }

            public Visibility getVisibility() {
                return this.methodDescription.getVisibility();
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.methodDescription.hashCode();
            }
        }

        public enum Sort {
            VISIBLE(true, true, true),
            RESOLVED(true, true, false),
            AMBIGUOUS(true, false, false),
            UNRESOLVED(false, false, false);
            
            private final boolean madeVisible;
            private final boolean resolved;
            private final boolean unique;

            private Sort(boolean z11, boolean z12, boolean z13) {
                this.resolved = z11;
                this.unique = z12;
                this.madeVisible = z13;
            }

            public boolean isMadeVisible() {
                return this.madeVisible;
            }

            public boolean isResolved() {
                return this.resolved;
            }

            public boolean isUnique() {
                return this.unique;
            }
        }

        public enum Unresolved implements Node {
            INSTANCE;

            public Set<MethodDescription.TypeToken> getMethodTypes() {
                throw new IllegalStateException("Cannot resolve bridge method of an illegal node");
            }

            public MethodDescription getRepresentative() {
                throw new IllegalStateException("Cannot resolve the method of an illegal node");
            }

            public Sort getSort() {
                return Sort.UNRESOLVED;
            }

            public Visibility getVisibility() {
                throw new IllegalStateException("Cannot resolve visibility of an illegal node");
            }
        }

        Set<MethodDescription.TypeToken> getMethodTypes();

        MethodDescription getRepresentative();

        Sort getSort();

        Visibility getVisibility();
    }

    public static class NodeList extends FilterableList.AbstractBase<Node, NodeList> {
        private final List<? extends Node> nodes;

        public NodeList(List<? extends Node> list) {
            this.nodes = list;
        }

        public MethodList<?> asMethodList() {
            ArrayList arrayList = new ArrayList(size());
            for (Node representative : this.nodes) {
                arrayList.add(representative.getRepresentative());
            }
            return new MethodList.Explicit(arrayList);
        }

        /* renamed from: b */
        public NodeList a(List<Node> list) {
            return new NodeList(list);
        }

        public int size() {
            return this.nodes.size();
        }

        public Node get(int i11) {
            return (Node) this.nodes.get(i11);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Simple implements MethodGraph {
        private final LinkedHashMap<MethodDescription.SignatureToken, Node> nodes;

        public Simple(LinkedHashMap<MethodDescription.SignatureToken, Node> linkedHashMap) {
            this.nodes = linkedHashMap;
        }

        public static MethodGraph of(List<? extends MethodDescription> list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (MethodDescription methodDescription : list) {
                linkedHashMap.put(methodDescription.asSignatureToken(), new Node.Simple(methodDescription));
            }
            return new Simple(linkedHashMap);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.nodes.equals(((Simple) obj).nodes);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.nodes.hashCode();
        }

        public NodeList listNodes() {
            return new NodeList(new ArrayList(this.nodes.values()));
        }

        public Node locate(MethodDescription.SignatureToken signatureToken) {
            Node node = this.nodes.get(signatureToken);
            if (node == null) {
                return Node.Unresolved.INSTANCE;
            }
            return node;
        }
    }

    NodeList listNodes();

    Node locate(MethodDescription.SignatureToken signatureToken);
}
