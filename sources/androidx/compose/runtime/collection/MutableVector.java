package androidx.compose.runtime.collection;

import androidx.compose.runtime.internal.StabilityInferred;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u0003pqrB\u001f\b\u0001\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001b\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\bJ\u0019\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010$J\u001c\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u001c\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u001c\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&J\u0014\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0017\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&H\bJ+\u0010'\u001a\u00020\u001c2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0006\u0010+\u001a\u00020\u001fJ\u0016\u0010,\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001eJ\u0014\u0010-\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010-\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010-\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&J\u0014\u0010.\u001a\u00020\u001c2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u000e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0007J\u000b\u00102\u001a\u00028\u0000¢\u0006\u0002\u00103J0\u00102\u001a\u00028\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104J\u0010\u00105\u001a\u0004\u0018\u00018\u0000H\b¢\u0006\u0002\u00103J2\u00105\u001a\u0004\u0018\u00018\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104JS\u00106\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u00108\u001a\u0002H72'\u00109\u001a#\u0012\u0013\u0012\u0011H7¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70:H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010>Jh\u0010?\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u00108\u001a\u0002H72<\u00109\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H7¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70@H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010AJS\u0010B\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u00108\u001a\u0002H72'\u00109\u001a#\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H7¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u0002H70:H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010>Jh\u0010C\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u00108\u001a\u0002H72<\u00109\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H7¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u0002H70@H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010AJ+\u0010D\u001a\u00020\u001f2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0)H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J1\u0010F\u001a\u00020\u001f2\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0:H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J+\u0010G\u001a\u00020\u001f2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0)H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J1\u0010H\u001a\u00020\u001f2\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0:H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u0010I\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0007H\n¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010LJ+\u0010M\u001a\u00020\u00072\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J+\u0010N\u001a\u00020\u00072\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010O\u001a\u00020\u001cJ\u0006\u0010P\u001a\u00020\u001cJ\u000b\u0010Q\u001a\u00028\u0000¢\u0006\u0002\u00103J0\u0010Q\u001a\u00028\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104J\u0013\u0010R\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010LJ\u0010\u0010S\u001a\u0004\u0018\u00018\u0000H\b¢\u0006\u0002\u00103J2\u0010S\u001a\u0004\u0018\u00018\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104J>\u0010T\u001a\b\u0012\u0004\u0012\u0002H70\u0005\"\u0006\b\u0001\u00107\u0018\u00012\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70)H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010VJS\u0010W\u001a\b\u0012\u0004\u0012\u0002H70\u0005\"\u0006\b\u0001\u00107\u0018\u00012'\u0010U\u001a#\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70:H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010XJP\u0010Y\u001a\b\u0012\u0004\u0012\u0002H70\u0000\"\u0006\b\u0001\u00107\u0018\u00012)\u0010U\u001a%\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H70:H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J;\u0010Z\u001a\b\u0012\u0004\u0012\u0002H70\u0000\"\u0006\b\u0001\u00107\u0018\u00012\u0014\u0010U\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H70)H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u0010[\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00028\u0000H\n¢\u0006\u0002\u0010\\J\u0016\u0010]\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00028\u0000H\n¢\u0006\u0002\u0010\\J\u0013\u0010^\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\u0014\u0010_\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010_\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010_\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&J\u0013\u0010`\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0007¢\u0006\u0002\u0010JJ\u0016\u0010a\u001a\u00020\u001f2\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0007J\u0014\u0010d\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J+\u0010e\u001a\u00020\u001c2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u001e\u0010f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010gJ\u001e\u0010h\u001a\u00020\u001f2\u0016\u0010i\u001a\u0012\u0012\u0004\u0012\u00028\u00000jj\b\u0012\u0004\u0012\u00028\u0000`kJ+\u0010l\u001a\u00020\u00072\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070)H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010n\u001a\u00020oH\u0001R.\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00058\u0000@\u0000X\u000e¢\u0006\u0016\n\u0002\u0010\u000f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u0010\u001a\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016\u0002\u0007\n\u0005\b20\u0001¨\u0006s"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector;", "T", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "content", "", "size", "", "([Ljava/lang/Object;I)V", "getContent$annotations", "()V", "getContent", "()[Ljava/lang/Object;", "setContent", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "()I", "list", "", "<set-?>", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "([Ljava/lang/Object;)Z", "", "", "any", "predicate", "Lkotlin/Function1;", "asMutableList", "clear", "contains", "containsAll", "contentEquals", "other", "ensureCapacity", "capacity", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastIndexOf", "lastOrNull", "map", "transform", "(Lkotlin/jvm/functions/Function1;)[Ljava/lang/Object;", "mapIndexed", "(Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "mapIndexedNotNull", "mapNotNull", "minusAssign", "(Ljava/lang/Object;)V", "plusAssign", "remove", "removeAll", "removeAt", "removeRange", "start", "end", "retainAll", "reversedAny", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "sortWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sumBy", "selector", "throwNoSuchElementException", "", "MutableVectorList", "SubList", "VectorListIterator", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MutableVector<T> implements RandomAccess {
    public static final int $stable = 8;
    @NotNull
    private T[] content;
    @Nullable
    private List<T> list;
    private int size;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u001d\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\rJ\u0016\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH\u0002J\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0015\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\"\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0015\u0010#\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0018J\u0016\u0010$\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u001e\u0010%\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$MutableVectorList;", "T", "", "vector", "Landroidx/compose/runtime/collection/MutableVector;", "(Landroidx/compose/runtime/collection/MutableVector;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MutableVectorList<T> implements List<T>, KMutableList {
        @NotNull
        private final MutableVector<T> vector;

        public MutableVectorList(@NotNull MutableVector<T> mutableVector) {
            Intrinsics.checkNotNullParameter(mutableVector, "vector");
            this.vector = mutableVector;
        }

        public boolean add(T t11) {
            return this.vector.add(t11);
        }

        public boolean addAll(int i11, @NotNull Collection<? extends T> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            return this.vector.addAll(i11, collection);
        }

        public void clear() {
            this.vector.clear();
        }

        public boolean contains(Object obj) {
            return this.vector.contains(obj);
        }

        public boolean containsAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            return this.vector.containsAll(collection);
        }

        public T get(int i11) {
            MutableVectorKt.checkIndex(this, i11);
            return this.vector.getContent()[i11];
        }

        public int getSize() {
            return this.vector.getSize();
        }

        public int indexOf(Object obj) {
            return this.vector.indexOf(obj);
        }

        public boolean isEmpty() {
            return this.vector.isEmpty();
        }

        @NotNull
        public Iterator<T> iterator() {
            return new VectorListIterator(this, 0);
        }

        public int lastIndexOf(Object obj) {
            return this.vector.lastIndexOf(obj);
        }

        @NotNull
        public ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        public final /* bridge */ T remove(int i11) {
            return removeAt(i11);
        }

        public boolean removeAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            return this.vector.removeAll(collection);
        }

        public T removeAt(int i11) {
            MutableVectorKt.checkIndex(this, i11);
            return this.vector.removeAt(i11);
        }

        public boolean retainAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            return this.vector.retainAll(collection);
        }

        public T set(int i11, T t11) {
            MutableVectorKt.checkIndex(this, i11);
            return this.vector.set(i11, t11);
        }

        public final /* bridge */ int size() {
            return getSize();
        }

        @NotNull
        public List<T> subList(int i11, int i12) {
            MutableVectorKt.checkSubIndex(this, i11, i12);
            return new SubList(this, i11, i12);
        }

        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        public <T> T[] toArray(T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            return CollectionToArray.toArray(this, tArr);
        }

        public void add(int i11, T t11) {
            this.vector.add(i11, t11);
        }

        public boolean addAll(@NotNull Collection<? extends T> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            return this.vector.addAll(collection);
        }

        @NotNull
        public ListIterator<T> listIterator(int i11) {
            return new VectorListIterator(this, i11);
        }

        public boolean remove(Object obj) {
            return this.vector.remove(obj);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0017\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\fH\u0016J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u001eH\u0002J\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010#\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0015\u0010$\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010%\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u001e\u0010&\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$SubList;", "T", "", "list", "start", "", "end", "(Ljava/util/List;II)V", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SubList<T> implements List<T>, KMutableList {
        private int end;
        @NotNull
        private final List<T> list;
        private final int start;

        public SubList(@NotNull List<T> list2, int i11, int i12) {
            Intrinsics.checkNotNullParameter(list2, DefaultCardView.CARD_LIST);
            this.list = list2;
            this.start = i11;
            this.end = i12;
        }

        public boolean add(T t11) {
            List<T> list2 = this.list;
            int i11 = this.end;
            this.end = i11 + 1;
            list2.add(i11, t11);
            return true;
        }

        public boolean addAll(int i11, @NotNull Collection<? extends T> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            this.list.addAll(i11 + this.start, collection);
            this.end += collection.size();
            return collection.size() > 0;
        }

        public void clear() {
            int i11 = this.end - 1;
            int i12 = this.start;
            if (i12 <= i11) {
                while (true) {
                    this.list.remove(i11);
                    if (i11 == i12) {
                        break;
                    }
                    i11--;
                }
            }
            this.end = this.start;
        }

        public boolean contains(Object obj) {
            int i11 = this.end;
            for (int i12 = this.start; i12 < i11; i12++) {
                if (Intrinsics.areEqual((Object) this.list.get(i12), obj)) {
                    return true;
                }
            }
            return false;
        }

        public boolean containsAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public T get(int i11) {
            MutableVectorKt.checkIndex(this, i11);
            return this.list.get(i11 + this.start);
        }

        public int getSize() {
            return this.end - this.start;
        }

        public int indexOf(Object obj) {
            int i11 = this.end;
            for (int i12 = this.start; i12 < i11; i12++) {
                if (Intrinsics.areEqual((Object) this.list.get(i12), obj)) {
                    return i12 - this.start;
                }
            }
            return -1;
        }

        public boolean isEmpty() {
            return this.end == this.start;
        }

        @NotNull
        public Iterator<T> iterator() {
            return new VectorListIterator(this, 0);
        }

        public int lastIndexOf(Object obj) {
            int i11 = this.end - 1;
            int i12 = this.start;
            if (i12 > i11) {
                return -1;
            }
            while (!Intrinsics.areEqual((Object) this.list.get(i11), obj)) {
                if (i11 == i12) {
                    return -1;
                }
                i11--;
            }
            return i11 - this.start;
        }

        @NotNull
        public ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        public final /* bridge */ T remove(int i11) {
            return removeAt(i11);
        }

        public boolean removeAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            int i11 = this.end;
            for (Object remove : collection) {
                remove(remove);
            }
            if (i11 != this.end) {
                return true;
            }
            return false;
        }

        public T removeAt(int i11) {
            MutableVectorKt.checkIndex(this, i11);
            this.end--;
            return this.list.remove(i11 + this.start);
        }

        public boolean retainAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            int i11 = this.end;
            int i12 = i11 - 1;
            int i13 = this.start;
            if (i13 <= i12) {
                while (true) {
                    if (!collection.contains(this.list.get(i12))) {
                        this.list.remove(i12);
                        this.end--;
                    }
                    if (i12 == i13) {
                        break;
                    }
                    i12--;
                }
            }
            if (i11 != this.end) {
                return true;
            }
            return false;
        }

        public T set(int i11, T t11) {
            MutableVectorKt.checkIndex(this, i11);
            return this.list.set(i11 + this.start, t11);
        }

        public final /* bridge */ int size() {
            return getSize();
        }

        @NotNull
        public List<T> subList(int i11, int i12) {
            MutableVectorKt.checkSubIndex(this, i11, i12);
            return new SubList(this, i11, i12);
        }

        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        public <T> T[] toArray(T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            return CollectionToArray.toArray(this, tArr);
        }

        public void add(int i11, T t11) {
            this.list.add(i11 + this.start, t11);
            this.end++;
        }

        @NotNull
        public ListIterator<T> listIterator(int i11) {
            return new VectorListIterator(this, i11);
        }

        public boolean remove(Object obj) {
            int i11 = this.end;
            for (int i12 = this.start; i12 < i11; i12++) {
                if (Intrinsics.areEqual((Object) this.list.get(i12), obj)) {
                    this.list.remove(i12);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        public boolean addAll(@NotNull Collection<? extends T> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            this.list.addAll(this.end, collection);
            this.end += collection.size();
            return collection.size() > 0;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bJ\t\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u000f\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\r\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0015\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$VectorListIterator;", "T", "", "list", "", "index", "", "(Ljava/util/List;I)V", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class VectorListIterator<T> implements ListIterator<T>, KMutableListIterator, j$.util.Iterator {
        private int index;
        @NotNull
        private final List<T> list;

        public VectorListIterator(@NotNull List<T> list2, int i11) {
            Intrinsics.checkNotNullParameter(list2, DefaultCardView.CARD_LIST);
            this.list = list2;
            this.index = i11;
        }

        public void add(T t11) {
            this.list.add(this.index, t11);
            this.index++;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.index < this.list.size();
        }

        public boolean hasPrevious() {
            return this.index > 0;
        }

        public T next() {
            List<T> list2 = this.list;
            int i11 = this.index;
            this.index = i11 + 1;
            return list2.get(i11);
        }

        public int nextIndex() {
            return this.index;
        }

        public T previous() {
            int i11 = this.index - 1;
            this.index = i11;
            return this.list.get(i11);
        }

        public int previousIndex() {
            return this.index - 1;
        }

        public void remove() {
            int i11 = this.index - 1;
            this.index = i11;
            this.list.remove(i11);
        }

        public void set(T t11) {
            this.list.set(this.index, t11);
        }
    }

    @PublishedApi
    public MutableVector(@NotNull T[] tArr, int i11) {
        Intrinsics.checkNotNullParameter(tArr, "content");
        this.content = tArr;
        this.size = i11;
    }

    @PublishedApi
    public static /* synthetic */ void getContent$annotations() {
    }

    public final boolean add(T t11) {
        ensureCapacity(this.size + 1);
        T[] tArr = this.content;
        int i11 = this.size;
        tArr[i11] = t11;
        this.size = i11 + 1;
        return true;
    }

    public final boolean addAll(int i11, @NotNull List<? extends T> list2) {
        Intrinsics.checkNotNullParameter(list2, "elements");
        if (list2.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + list2.size());
        T[] tArr = this.content;
        if (i11 != this.size) {
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto(tArr, tArr, list2.size() + i11, i11, this.size);
        }
        int size2 = list2.size();
        for (int i12 = 0; i12 < size2; i12++) {
            tArr[i11 + i12] = list2.get(i12);
        }
        this.size += list2.size();
        return true;
    }

    public final boolean any(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size2 = getSize();
        if (size2 > 0) {
            Object[] content2 = getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            while (!function1.invoke(content2[i11]).booleanValue()) {
                i11++;
                if (i11 >= size2) {
                }
            }
            return true;
        }
        return false;
    }

    @NotNull
    public final List<T> asMutableList() {
        List<T> list2 = this.list;
        if (list2 != null) {
            return list2;
        }
        MutableVectorList mutableVectorList = new MutableVectorList(this);
        this.list = mutableVectorList;
        return mutableVectorList;
    }

    public final void clear() {
        T[] tArr = this.content;
        int size2 = getSize();
        while (true) {
            size2--;
            if (-1 < size2) {
                tArr[size2] = null;
            } else {
                this.size = 0;
                return;
            }
        }
    }

    public final boolean contains(T t11) {
        int size2 = getSize() - 1;
        if (size2 >= 0) {
            int i11 = 0;
            while (!Intrinsics.areEqual(getContent()[i11], (Object) t11)) {
                if (i11 != size2) {
                    i11++;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean containsAll(@NotNull List<? extends T> list2) {
        Intrinsics.checkNotNullParameter(list2, "elements");
        int size2 = list2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            if (!contains(list2.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public final boolean contentEquals(@NotNull MutableVector<T> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "other");
        if (mutableVector.size != this.size) {
            return false;
        }
        int size2 = getSize() - 1;
        if (size2 >= 0) {
            int i11 = 0;
            while (Intrinsics.areEqual(mutableVector.getContent()[i11], getContent()[i11])) {
                if (i11 != size2) {
                    i11++;
                }
            }
            return false;
        }
        return true;
    }

    public final void ensureCapacity(int i11) {
        T[] tArr = this.content;
        if (tArr.length < i11) {
            T[] copyOf = Arrays.copyOf(tArr, Math.max(i11, tArr.length * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final T first() {
        if (!isEmpty()) {
            return getContent()[0];
        }
        throw new NoSuchElementException("MutableVector is empty.");
    }

    @Nullable
    public final T firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return getContent()[0];
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R fold(R r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r0 = r4.getSize()
            if (r0 <= 0) goto L_0x001f
            java.lang.Object[] r1 = r4.getContent()
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            r2 = 0
        L_0x0015:
            r3 = r1[r2]
            java.lang.Object r5 = r6.invoke(r5, r3)
            int r2 = r2 + 1
            if (r2 < r0) goto L_0x0015
        L_0x001f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.MutableVector.fold(java.lang.Object, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super T, ? extends R>, kotlin.jvm.functions.Function3, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldIndexed(R r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super T, ? extends R> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int r0 = r5.getSize()
            if (r0 <= 0) goto L_0x0023
            java.lang.Object[] r1 = r5.getContent()
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            r2 = 0
        L_0x0015:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r4 = r1[r2]
            java.lang.Object r6 = r7.invoke(r3, r6, r4)
            int r2 = r2 + 1
            if (r2 < r0) goto L_0x0015
        L_0x0023:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.MutableVector.foldIndexed(java.lang.Object, kotlin.jvm.functions.Function3):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Object, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super T, ? super R, ? extends R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldRight(R r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super R, ? extends R> r5) {
        /*
            r3 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = r3.getSize()
            if (r0 <= 0) goto L_0x0020
            int r0 = r0 + -1
            java.lang.Object[] r1 = r3.getContent()
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
        L_0x0016:
            r2 = r1[r0]
            java.lang.Object r4 = r5.invoke(r2, r4)
            int r0 = r0 + -1
            if (r0 >= 0) goto L_0x0016
        L_0x0020:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.MutableVector.foldRight(java.lang.Object, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super T, ? super R, ? extends R>, kotlin.jvm.functions.Function3, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldRightIndexed(R r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super T, ? super R, ? extends R> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r0 = r4.getSize()
            if (r0 <= 0) goto L_0x0024
            int r0 = r0 + -1
            java.lang.Object[] r1 = r4.getContent()
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
        L_0x0016:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r3 = r1[r0]
            java.lang.Object r5 = r6.invoke(r2, r3, r5)
            int r0 = r0 + -1
            if (r0 >= 0) goto L_0x0016
        L_0x0024:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.MutableVector.foldRightIndexed(java.lang.Object, kotlin.jvm.functions.Function3):java.lang.Object");
    }

    public final void forEach(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        int size2 = getSize();
        if (size2 > 0) {
            Object[] content2 = getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                function1.invoke(content2[i11]);
                i11++;
            } while (i11 < size2);
        }
    }

    public final void forEachIndexed(@NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        int size2 = getSize();
        if (size2 > 0) {
            Object[] content2 = getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                function2.invoke(Integer.valueOf(i11), content2[i11]);
                i11++;
            } while (i11 < size2);
        }
    }

    public final void forEachReversed(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        int size2 = getSize();
        if (size2 > 0) {
            int i11 = size2 - 1;
            Object[] content2 = getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                function1.invoke(content2[i11]);
                i11--;
            } while (i11 >= 0);
        }
    }

    public final void forEachReversedIndexed(@NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        if (getSize() > 0) {
            int size2 = getSize() - 1;
            Object[] content2 = getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                function2.invoke(Integer.valueOf(size2), content2[size2]);
                size2--;
            } while (size2 >= 0);
        }
    }

    public final T get(int i11) {
        return getContent()[i11];
    }

    @NotNull
    public final T[] getContent() {
        return this.content;
    }

    @NotNull
    public final IntRange getIndices() {
        return new IntRange(0, getSize() - 1);
    }

    public final int getLastIndex() {
        return getSize() - 1;
    }

    public final int getSize() {
        return this.size;
    }

    public final int indexOf(T t11) {
        int i11 = this.size;
        if (i11 <= 0) {
            return -1;
        }
        T[] tArr = this.content;
        Intrinsics.checkNotNull(tArr, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        int i12 = 0;
        while (!Intrinsics.areEqual((Object) t11, (Object) tArr[i12])) {
            i12++;
            if (i12 >= i11) {
                return -1;
            }
        }
        return i12;
    }

    public final int indexOfFirst(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size2 = getSize();
        if (size2 <= 0) {
            return -1;
        }
        Object[] content2 = getContent();
        Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        int i11 = 0;
        while (!function1.invoke(content2[i11]).booleanValue()) {
            i11++;
            if (i11 >= size2) {
                return -1;
            }
        }
        return i11;
    }

    public final int indexOfLast(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size2 = getSize();
        if (size2 <= 0) {
            return -1;
        }
        int i11 = size2 - 1;
        Object[] content2 = getContent();
        Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        while (!function1.invoke(content2[i11]).booleanValue()) {
            i11--;
            if (i11 < 0) {
                return -1;
            }
        }
        return i11;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size != 0;
    }

    public final T last() {
        if (!isEmpty()) {
            return getContent()[getSize() - 1];
        }
        throw new NoSuchElementException("MutableVector is empty.");
    }

    public final int lastIndexOf(T t11) {
        int i11 = this.size;
        if (i11 <= 0) {
            return -1;
        }
        int i12 = i11 - 1;
        T[] tArr = this.content;
        Intrinsics.checkNotNull(tArr, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        while (!Intrinsics.areEqual((Object) t11, (Object) tArr[i12])) {
            i12--;
            if (i12 < 0) {
                return -1;
            }
        }
        return i12;
    }

    @Nullable
    public final T lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return getContent()[getSize() - 1];
    }

    public final /* synthetic */ <R> R[] map(Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "transform");
        int size2 = getSize();
        Intrinsics.reifiedOperationMarker(0, "R");
        R[] rArr = new Object[size2];
        for (int i11 = 0; i11 < size2; i11++) {
            rArr[i11] = function1.invoke(getContent()[i11]);
        }
        return rArr;
    }

    public final /* synthetic */ <R> R[] mapIndexed(Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "transform");
        int size2 = getSize();
        Intrinsics.reifiedOperationMarker(0, "R");
        R[] rArr = new Object[size2];
        for (int i11 = 0; i11 < size2; i11++) {
            rArr[i11] = function2.invoke(Integer.valueOf(i11), getContent()[i11]);
        }
        return rArr;
    }

    public final /* synthetic */ <R> MutableVector<R> mapIndexedNotNull(Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "transform");
        int size2 = getSize();
        int i11 = 0;
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] objArr = new Object[size2];
        if (size2 > 0) {
            Object[] content2 = getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i12 = 0;
            do {
                Object invoke = function2.invoke(Integer.valueOf(i11), content2[i11]);
                if (invoke != null) {
                    objArr[i12] = invoke;
                    i12++;
                }
                i11++;
            } while (i11 < size2);
            i11 = i12;
        }
        return new MutableVector<>(objArr, i11);
    }

    public final /* synthetic */ <R> MutableVector<R> mapNotNull(Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "transform");
        int size2 = getSize();
        int i11 = 0;
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] objArr = new Object[size2];
        if (size2 > 0) {
            Object[] content2 = getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i12 = 0;
            do {
                Object invoke = function1.invoke(content2[i11]);
                if (invoke != null) {
                    objArr[i12] = invoke;
                    i12++;
                }
                i11++;
            } while (i11 < size2);
            i11 = i12;
        }
        return new MutableVector<>(objArr, i11);
    }

    public final void minusAssign(T t11) {
        remove(t11);
    }

    public final void plusAssign(T t11) {
        add(t11);
    }

    public final boolean remove(T t11) {
        int indexOf = indexOf(t11);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(@NotNull List<? extends T> list2) {
        Intrinsics.checkNotNullParameter(list2, "elements");
        int i11 = this.size;
        int size2 = list2.size();
        for (int i12 = 0; i12 < size2; i12++) {
            remove(list2.get(i12));
        }
        if (i11 != this.size) {
            return true;
        }
        return false;
    }

    public final T removeAt(int i11) {
        T[] tArr = this.content;
        T t11 = tArr[i11];
        if (i11 != getSize() - 1) {
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto(tArr, tArr, i11, i11 + 1, this.size);
        }
        int i12 = this.size - 1;
        this.size = i12;
        tArr[i12] = null;
        return t11;
    }

    public final void removeRange(int i11, int i12) {
        if (i12 > i11) {
            int i13 = this.size;
            if (i12 < i13) {
                T[] tArr = this.content;
                Object[] unused = ArraysKt___ArraysJvmKt.copyInto(tArr, tArr, i11, i12, i13);
            }
            int i14 = this.size - (i12 - i11);
            int size2 = getSize() - 1;
            if (i14 <= size2) {
                int i15 = i14;
                while (true) {
                    this.content[i15] = null;
                    if (i15 == size2) {
                        break;
                    }
                    i15++;
                }
            }
            this.size = i14;
        }
    }

    public final boolean retainAll(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        int i11 = this.size;
        for (int size2 = getSize() - 1; -1 < size2; size2--) {
            if (!collection.contains(getContent()[size2])) {
                removeAt(size2);
            }
        }
        if (i11 != this.size) {
            return true;
        }
        return false;
    }

    public final boolean reversedAny(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size2 = getSize();
        if (size2 <= 0) {
            return false;
        }
        int i11 = size2 - 1;
        Object[] content2 = getContent();
        Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        while (!function1.invoke(content2[i11]).booleanValue()) {
            i11--;
            if (i11 < 0) {
                return false;
            }
        }
        return true;
    }

    public final T set(int i11, T t11) {
        T[] tArr = this.content;
        T t12 = tArr[i11];
        tArr[i11] = t11;
        return t12;
    }

    public final void setContent(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<set-?>");
        this.content = tArr;
    }

    public final void sortWith(@NotNull Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        T[] tArr = this.content;
        Intrinsics.checkNotNull(tArr, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        ArraysKt___ArraysJvmKt.sortWith(tArr, comparator, 0, this.size);
    }

    public final int sumBy(@NotNull Function1<? super T, Integer> function1) {
        Intrinsics.checkNotNullParameter(function1, "selector");
        int size2 = getSize();
        int i11 = 0;
        if (size2 > 0) {
            Object[] content2 = getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i12 = 0;
            do {
                i11 += function1.invoke(content2[i12]).intValue();
                i12++;
            } while (i12 < size2);
        }
        return i11;
    }

    @NotNull
    @PublishedApi
    public final Void throwNoSuchElementException() {
        throw new NoSuchElementException("MutableVector contains no element matching the predicate.");
    }

    public final boolean containsAll(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final T firstOrNull(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size2 = getSize();
        if (size2 <= 0) {
            return null;
        }
        T[] content2 = getContent();
        Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        int i11 = 0;
        do {
            T t11 = content2[i11];
            if (function1.invoke(t11).booleanValue()) {
                return t11;
            }
            i11++;
        } while (i11 < size2);
        return null;
    }

    public final void add(int i11, T t11) {
        ensureCapacity(this.size + 1);
        T[] tArr = this.content;
        int i12 = this.size;
        if (i11 != i12) {
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto(tArr, tArr, i11 + 1, i11, i12);
        }
        tArr[i11] = t11;
        this.size++;
    }

    public final T first(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size2 = getSize();
        if (size2 > 0) {
            T[] content2 = getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                T t11 = content2[i11];
                if (function1.invoke(t11).booleanValue()) {
                    return t11;
                }
                i11++;
            } while (i11 < size2);
        }
        throwNoSuchElementException();
        throw new KotlinNothingValueException();
    }

    @Nullable
    public final T lastOrNull(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size2 = getSize();
        if (size2 <= 0) {
            return null;
        }
        int i11 = size2 - 1;
        T[] content2 = getContent();
        Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            T t11 = content2[i11];
            if (function1.invoke(t11).booleanValue()) {
                return t11;
            }
            i11--;
        } while (i11 >= 0);
        return null;
    }

    public final T last(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size2 = getSize();
        if (size2 > 0) {
            int i11 = size2 - 1;
            T[] content2 = getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                T t11 = content2[i11];
                if (function1.invoke(t11).booleanValue()) {
                    return t11;
                }
                i11--;
            } while (i11 >= 0);
        }
        throwNoSuchElementException();
        throw new KotlinNothingValueException();
    }

    public final boolean removeAll(@NotNull MutableVector<T> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "elements");
        int i11 = this.size;
        int size2 = mutableVector.getSize() - 1;
        if (size2 >= 0) {
            int i12 = 0;
            while (true) {
                remove(mutableVector.getContent()[i12]);
                if (i12 == size2) {
                    break;
                }
                i12++;
            }
        }
        if (i11 != this.size) {
            return true;
        }
        return false;
    }

    public final boolean containsAll(@NotNull MutableVector<T> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "elements");
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (contains(mutableVector.getContent()[first])) {
                if (first != last) {
                    first++;
                }
            }
            return false;
        }
        return true;
    }

    public final boolean removeAll(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        int i11 = this.size;
        for (Object remove : collection) {
            remove(remove);
        }
        if (i11 != this.size) {
            return true;
        }
        return false;
    }

    public final boolean addAll(int i11, @NotNull MutableVector<T> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "elements");
        if (mutableVector.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + mutableVector.size);
        T[] tArr = this.content;
        int i12 = this.size;
        if (i11 != i12) {
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto(tArr, tArr, mutableVector.size + i11, i11, i12);
        }
        Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto(mutableVector.content, tArr, i11, 0, mutableVector.size);
        this.size += mutableVector.size;
        return true;
    }

    public final boolean addAll(@NotNull List<? extends T> list2) {
        Intrinsics.checkNotNullParameter(list2, "elements");
        return addAll(getSize(), list2);
    }

    public final boolean addAll(@NotNull MutableVector<T> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "elements");
        return addAll(getSize(), mutableVector);
    }

    public final boolean addAll(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        if (tArr.length == 0) {
            return false;
        }
        ensureCapacity(this.size + tArr.length);
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto$default((Object[]) tArr, (Object[]) this.content, this.size, 0, 0, 12, (Object) null);
        this.size += tArr.length;
        return true;
    }

    public final boolean addAll(int i11, @NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        int i12 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + collection.size());
        T[] tArr = this.content;
        if (i11 != this.size) {
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto(tArr, tArr, collection.size() + i11, i11, this.size);
        }
        for (T next : collection) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            tArr[i12 + i11] = next;
            i12 = i13;
        }
        this.size += collection.size();
        return true;
    }

    public final boolean addAll(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return addAll(this.size, collection);
    }
}
