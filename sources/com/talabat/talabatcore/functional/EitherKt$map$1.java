package com.talabat.talabatcore.functional;

import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class EitherKt$map$1 extends FunctionReferenceImpl implements Function1<T, Either.Right<? extends T>> {
    public EitherKt$map$1(Object obj) {
        super(1, obj, Either.class, TtmlNode.RIGHT, "right(Ljava/lang/Object;)Lcom/talabat/talabatcore/functional/Either$Right;", 0);
    }

    @NotNull
    public final Either.Right<T> invoke(T t11) {
        return ((Either) this.receiver).right(t11);
    }
}
