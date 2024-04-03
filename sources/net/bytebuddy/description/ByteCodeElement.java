package net.bytebuddy.description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.FilterableList;

public interface ByteCodeElement extends NamedElement.WithRuntimeName, NamedElement.WithDescriptor, ModifierReviewable, DeclaredByType, AnnotationSource {

    public interface Token<T extends Token<T>> {

        public static class TokenList<S extends Token<S>> extends FilterableList.AbstractBase<S, TokenList<S>> {
            private final List<? extends S> tokens;

            public TokenList(S... sArr) {
                this(Arrays.asList(sArr));
            }

            public TokenList<S> accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
                ArrayList arrayList = new ArrayList(this.tokens.size());
                Iterator<? extends S> it = this.tokens.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Token) it.next()).accept(visitor));
                }
                return new TokenList<>(arrayList);
            }

            /* renamed from: b */
            public TokenList<S> a(List<S> list) {
                return new TokenList<>(list);
            }

            public int size() {
                return this.tokens.size();
            }

            public TokenList(List<? extends S> list) {
                this.tokens = list;
            }

            public S get(int i11) {
                return (Token) this.tokens.get(i11);
            }
        }

        T accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor);
    }

    public interface TypeDependant<T extends TypeDependant<?, S>, S extends Token<S>> {
        T asDefined();

        S asToken(ElementMatcher<? super TypeDescription> elementMatcher);
    }

    boolean isAccessibleTo(TypeDescription typeDescription);

    boolean isVisibleTo(TypeDescription typeDescription);
}
