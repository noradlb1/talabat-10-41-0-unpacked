package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010)\n\u0000\n\u0002\u0010*\n\u0000\n\u0002\u0010+\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0018\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u001d\u0010\u001c\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0016\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u001d\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J=\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010+\u001a\u00020\u000b2\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0-H\u0002¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u00100J\r\u00101\u001a\u00020\u000bH\u0000¢\u0006\u0002\b2JG\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0002\u00107J[\u00103\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010!\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010<J/\u0010=\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010>J\u001d\u0010?\u001a\u00020\u001d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010@J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000BH\u0002J\u001e\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070D2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000FH\u0016J\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000F2\u0006\u0010!\u001a\u00020\u000bH\u0016J'\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010HJ-\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010J\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010KJ\u0015\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010\u0012J\u001f\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010NJ5\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010PJ?\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u000206H\u0002¢\u0006\u0002\u0010TJ/\u0010U\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010VJM\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0014\u0010X\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070-H\u0002¢\u0006\u0002\u0010YJE\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0014\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0007H\u0002¢\u0006\u0002\u0010[J?\u0010\\\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010_J?\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010aJu\u0010b\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u0002062\u0014\u0010h\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070i2\u0014\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070iH\u0002¢\u0006\u0002\u0010jJ\u001c\u0010k\u001a\u00020\u001d2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0dH\u0002JA\u0010k\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010g\u001a\u000206H\u0002¢\u0006\u0002\u0010lJ\u0016\u0010k\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J,\u0010m\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u0006\u0010n\u001a\u00020\u000b2\u0006\u0010g\u001a\u000206H\u0002J\u001a\u0010o\u001a\u00020\u001d2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0dJ\u0015\u0010p\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0002\u00100J=\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010S\u001a\u000206H\u0002¢\u0006\u0002\u0010TJ9\u0010r\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010sJ/\u0010t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0018\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010KJ\b\u0010R\u001a\u00020\u000bH\u0002J\u001e\u0010u\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010vJE\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010x\u001a\u00028\u00002\u0006\u0010y\u001a\u000206H\u0002¢\u0006\u0002\u00107JU\u0010z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010{\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010|Jl\u0010}\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010!\u001a\u00020\u000b2\u000e\u0010~\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0003\u0010\u0001J\b\u0010n\u001a\u00020\u000bH\u0002J\u0010\u0010n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R4\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007@BX\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R0\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007@BX\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "E", "Lkotlin/collections/AbstractMutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "vector", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "vectorRoot", "", "", "vectorTail", "rootShift", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;[Ljava/lang/Object;I)V", "ownership", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "<set-?>", "root", "getRoot$runtime_release", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getRootShift$runtime_release", "()I", "setRootShift$runtime_release", "(I)V", "size", "getSize", "tail", "getTail$runtime_release", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "bufferFor", "(I)[Ljava/lang/Object;", "build", "copyToBuffer", "buffer", "bufferIndex", "sourceIterator", "", "([Ljava/lang/Object;ILjava/util/Iterator;)[Ljava/lang/Object;", "get", "(I)Ljava/lang/Object;", "getModCount", "getModCount$runtime_release", "insertIntoRoot", "shift", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "rightShift", "buffers", "nullBuffers", "nextBuffer", "(Ljava/util/Collection;II[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "insertIntoTail", "([Ljava/lang/Object;ILjava/lang/Object;)V", "isMutable", "([Ljava/lang/Object;)Z", "iterator", "", "leafBufferIterator", "", "listIterator", "", "makeMutable", "([Ljava/lang/Object;)[Ljava/lang/Object;", "makeMutableShiftingRight", "distance", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "mutableBuffer", "mutableBufferWith", "(Ljava/lang/Object;)[Ljava/lang/Object;", "nullifyAfter", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "pullLastBuffer", "rootSize", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "([Ljava/lang/Object;II)V", "pushBuffers", "buffersIterator", "([Ljava/lang/Object;IILjava/util/Iterator;)[Ljava/lang/Object;", "pushBuffersIncreasingHeightIfNeeded", "([Ljava/lang/Object;I[[Ljava/lang/Object;)[Ljava/lang/Object;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)V", "pushTail", "([Ljava/lang/Object;[Ljava/lang/Object;I)[Ljava/lang/Object;", "recyclableRemoveAll", "predicate", "Lkotlin/Function1;", "bufferSize", "toBufferSize", "bufferRef", "recyclableBuffers", "", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;Ljava/util/List;Ljava/util/List;)I", "removeAll", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)I", "removeAllFromTail", "tailSize", "removeAllWithPredicate", "removeAt", "removeFromRootAt", "removeFromTailAt", "([Ljava/lang/Object;III)Ljava/lang/Object;", "retainFirst", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "setInRoot", "e", "oldElementCarry", "shiftLeafBuffers", "startLeafIndex", "(II[[Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "splitToBuffers", "startBuffer", "startBufferSize", "(Ljava/util/Collection;I[Ljava/lang/Object;I[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PersistentVectorBuilder<E> extends AbstractMutableList<E> implements PersistentList.Builder<E> {
    @NotNull
    private MutabilityOwnership ownership = new MutabilityOwnership();
    @Nullable
    private Object[] root = this.vectorRoot;
    private int rootShift;
    private int size = this.vector.size();
    @NotNull
    private Object[] tail = this.vectorTail;
    @NotNull
    private PersistentList<? extends E> vector;
    @Nullable
    private Object[] vectorRoot;
    @NotNull
    private Object[] vectorTail;

    public PersistentVectorBuilder(@NotNull PersistentList<? extends E> persistentList, @Nullable Object[] objArr, @NotNull Object[] objArr2, int i11) {
        Intrinsics.checkNotNullParameter(persistentList, "vector");
        Intrinsics.checkNotNullParameter(objArr2, "vectorTail");
        this.vector = persistentList;
        this.vectorRoot = objArr;
        this.vectorTail = objArr2;
        this.rootShift = i11;
    }

    private final Object[] bufferFor(int i11) {
        if (rootSize() <= i11) {
            return this.tail;
        }
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        for (int i12 = this.rootShift; i12 > 0; i12 -= 5) {
            Object[] objArr2 = objArr[UtilsKt.indexSegment(i11, i12)];
            Intrinsics.checkNotNull(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    private final Object[] copyToBuffer(Object[] objArr, int i11, Iterator<? extends Object> it) {
        while (i11 < 32 && it.hasNext()) {
            objArr[i11] = it.next();
            i11++;
        }
        return objArr;
    }

    private final Object[] insertIntoRoot(Object[] objArr, int i11, int i12, Object obj, ObjectRef objectRef) {
        Object obj2;
        int indexSegment = UtilsKt.indexSegment(i12, i11);
        if (i11 == 0) {
            objectRef.setValue(objArr[31]);
            Object[] copyInto = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) makeMutable(objArr), indexSegment + 1, indexSegment, 31);
            copyInto[indexSegment] = obj;
            return copyInto;
        }
        Object[] makeMutable = makeMutable(objArr);
        int i13 = i11 - 5;
        Object obj3 = makeMutable[indexSegment];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        makeMutable[indexSegment] = insertIntoRoot((Object[]) obj3, i13, i12, obj, objectRef);
        while (true) {
            indexSegment++;
            if (indexSegment >= 32 || (obj2 = makeMutable[indexSegment]) == null) {
                return makeMutable;
            }
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            makeMutable[indexSegment] = insertIntoRoot((Object[]) obj2, i13, 0, objectRef.getValue(), objectRef);
        }
        return makeMutable;
    }

    private final void insertIntoTail(Object[] objArr, int i11, E e11) {
        int tailSize = tailSize();
        Object[] makeMutable = makeMutable(this.tail);
        if (tailSize < 32) {
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) this.tail, (T[]) makeMutable, i11 + 1, i11, tailSize);
            makeMutable[i11] = e11;
            this.root = objArr;
            this.tail = makeMutable;
            this.size = size() + 1;
            return;
        }
        Object[] objArr2 = this.tail;
        Object obj = objArr2[31];
        Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr2, (T[]) makeMutable, i11 + 1, i11, 31);
        makeMutable[i11] = e11;
        pushFilledTail(objArr, makeMutable, mutableBufferWith(obj));
    }

    private final boolean isMutable(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.ownership;
    }

    private final ListIterator<Object[]> leafBufferIterator(int i11) {
        if (this.root != null) {
            int rootSize = rootSize() >> 5;
            ListImplementation.checkPositionIndex$runtime_release(i11, rootSize);
            int i12 = this.rootShift;
            if (i12 == 0) {
                Object[] objArr = this.root;
                Intrinsics.checkNotNull(objArr);
                return new SingleElementListIterator(objArr, i11);
            }
            Object[] objArr2 = this.root;
            Intrinsics.checkNotNull(objArr2);
            return new TrieIterator(objArr2, i11, rootSize, i12 / 5);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final Object[] makeMutable(Object[] objArr) {
        if (objArr == null) {
            return mutableBuffer();
        }
        if (isMutable(objArr)) {
            return objArr;
        }
        return ArraysKt___ArraysJvmKt.copyInto$default(objArr, mutableBuffer(), 0, 0, RangesKt___RangesKt.coerceAtMost(objArr.length, 32), 6, (Object) null);
    }

    private final Object[] makeMutableShiftingRight(Object[] objArr, int i11) {
        if (isMutable(objArr)) {
            return ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr, i11, 0, 32 - i11);
        }
        return ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) mutableBuffer(), i11, 0, 32 - i11);
    }

    private final Object[] mutableBuffer() {
        Object[] objArr = new Object[33];
        objArr[32] = this.ownership;
        return objArr;
    }

    private final Object[] mutableBufferWith(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.ownership;
        return objArr;
    }

    private final Object[] nullifyAfter(Object[] objArr, int i11, int i12) {
        boolean z11;
        if (i12 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (i12 == 0) {
            return objArr;
        } else {
            int indexSegment = UtilsKt.indexSegment(i11, i12);
            Object[] objArr2 = objArr[indexSegment];
            Intrinsics.checkNotNull(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            Object nullifyAfter = nullifyAfter(objArr2, i11, i12 - 5);
            if (indexSegment < 31) {
                int i13 = indexSegment + 1;
                if (objArr[i13] != null) {
                    if (isMutable(objArr)) {
                        ArraysKt___ArraysJvmKt.fill((T[]) objArr, null, i13, 32);
                    }
                    objArr = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) mutableBuffer(), 0, 0, i13);
                }
            }
            if (nullifyAfter == objArr[indexSegment]) {
                return objArr;
            }
            Object[] makeMutable = makeMutable(objArr);
            makeMutable[indexSegment] = nullifyAfter;
            return makeMutable;
        }
    }

    private final Object[] pullLastBuffer(Object[] objArr, int i11, int i12, ObjectRef objectRef) {
        Object[] objArr2;
        int indexSegment = UtilsKt.indexSegment(i12 - 1, i11);
        if (i11 == 5) {
            objectRef.setValue(objArr[indexSegment]);
            objArr2 = null;
        } else {
            Object[] objArr3 = objArr[indexSegment];
            Intrinsics.checkNotNull(objArr3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr2 = pullLastBuffer(objArr3, i11 - 5, i12, objectRef);
        }
        if (objArr2 == null && indexSegment == 0) {
            return null;
        }
        Object[] makeMutable = makeMutable(objArr);
        makeMutable[indexSegment] = objArr2;
        return makeMutable;
    }

    private final void pullLastBufferFromRoot(Object[] objArr, int i11, int i12) {
        if (i12 == 0) {
            this.root = null;
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.tail = objArr;
            this.size = i11;
            this.rootShift = i12;
            return;
        }
        ObjectRef objectRef = new ObjectRef((Object) null);
        Intrinsics.checkNotNull(objArr);
        Object[] pullLastBuffer = pullLastBuffer(objArr, i12, i11, objectRef);
        Intrinsics.checkNotNull(pullLastBuffer);
        Object value = objectRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.tail = (Object[]) value;
        this.size = i11;
        if (pullLastBuffer[1] == null) {
            this.root = (Object[]) pullLastBuffer[0];
            this.rootShift = i12 - 5;
            return;
        }
        this.root = pullLastBuffer;
        this.rootShift = i12;
    }

    private final Object[] pushBuffers(Object[] objArr, int i11, int i12, Iterator<Object[]> it) {
        boolean z11;
        if (it.hasNext()) {
            if (i12 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (i12 == 0) {
                return it.next();
            } else {
                Object[] makeMutable = makeMutable(objArr);
                int indexSegment = UtilsKt.indexSegment(i11, i12);
                int i13 = i12 - 5;
                makeMutable[indexSegment] = pushBuffers((Object[]) makeMutable[indexSegment], i11, i13, it);
                while (true) {
                    indexSegment++;
                    if (indexSegment >= 32 || !it.hasNext()) {
                        return makeMutable;
                    }
                    makeMutable[indexSegment] = pushBuffers((Object[]) makeMutable[indexSegment], 0, i13, it);
                }
                return makeMutable;
            }
        } else {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    private final Object[] pushBuffersIncreasingHeightIfNeeded(Object[] objArr, int i11, Object[][] objArr2) {
        Object[] objArr3;
        Iterator it = ArrayIteratorKt.iterator(objArr2);
        int i12 = i11 >> 5;
        int i13 = this.rootShift;
        if (i12 < (1 << i13)) {
            objArr3 = pushBuffers(objArr, i11, i13, it);
        } else {
            objArr3 = makeMutable(objArr);
        }
        while (it.hasNext()) {
            this.rootShift += 5;
            objArr3 = mutableBufferWith(objArr3);
            int i14 = this.rootShift;
            pushBuffers(objArr3, 1 << i14, i14, it);
        }
        return objArr3;
    }

    private final void pushFilledTail(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size2 = size() >> 5;
        int i11 = this.rootShift;
        if (size2 > (1 << i11)) {
            this.root = pushTail(mutableBufferWith(objArr), objArr2, this.rootShift + 5);
            this.tail = objArr3;
            this.rootShift += 5;
            this.size = size() + 1;
        } else if (objArr == null) {
            this.root = objArr2;
            this.tail = objArr3;
            this.size = size() + 1;
        } else {
            this.root = pushTail(objArr, objArr2, i11);
            this.tail = objArr3;
            this.size = size() + 1;
        }
    }

    private final Object[] pushTail(Object[] objArr, Object[] objArr2, int i11) {
        int indexSegment = UtilsKt.indexSegment(size() - 1, i11);
        Object[] makeMutable = makeMutable(objArr);
        if (i11 == 5) {
            makeMutable[indexSegment] = objArr2;
        } else {
            makeMutable[indexSegment] = pushTail((Object[]) makeMutable[indexSegment], objArr2, i11 - 5);
        }
        return makeMutable;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.Object} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int recyclableRemoveAll(kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r7, java.lang.Object[] r8, int r9, int r10, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef r11, java.util.List<java.lang.Object[]> r12, java.util.List<java.lang.Object[]> r13) {
        /*
            r6 = this;
            boolean r0 = r6.isMutable(r8)
            if (r0 == 0) goto L_0x0009
            r12.add(r8)
        L_0x0009:
            java.lang.Object r0 = r11.getValue()
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r1 = 0
            r3 = r0
            r2 = r1
        L_0x0017:
            if (r2 >= r9) goto L_0x0051
            r4 = r8[r2]
            java.lang.Object r5 = r7.invoke(r4)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x004e
            r5 = 32
            if (r10 != r5) goto L_0x0049
            r10 = r12
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            r10 = r10 ^ 1
            if (r10 == 0) goto L_0x0043
            int r10 = r12.size()
            int r10 = r10 + -1
            java.lang.Object r10 = r12.remove(r10)
            java.lang.Object[] r10 = (java.lang.Object[]) r10
            goto L_0x0047
        L_0x0043:
            java.lang.Object[] r10 = r6.mutableBuffer()
        L_0x0047:
            r3 = r10
            r10 = r1
        L_0x0049:
            int r5 = r10 + 1
            r3[r10] = r4
            r10 = r5
        L_0x004e:
            int r2 = r2 + 1
            goto L_0x0017
        L_0x0051:
            r11.setValue(r3)
            java.lang.Object r7 = r11.getValue()
            if (r0 == r7) goto L_0x005d
            r13.add(r0)
        L_0x005d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder.recyclableRemoveAll(kotlin.jvm.functions.Function1, java.lang.Object[], int, int, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef, java.util.List, java.util.List):int");
    }

    private final int removeAllFromTail(Function1<? super E, Boolean> function1, int i11, ObjectRef objectRef) {
        boolean z11;
        int removeAll = removeAll(function1, this.tail, i11, objectRef);
        if (removeAll == i11) {
            if (objectRef.getValue() == this.tail) {
                z11 = true;
            } else {
                z11 = false;
            }
            CommonFunctionsKt.m2551assert(z11);
            return i11;
        }
        Object value = objectRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) value;
        ArraysKt___ArraysJvmKt.fill((T[]) objArr, null, removeAll, i11);
        this.tail = objArr;
        this.size = size() - (i11 - removeAll);
        return removeAll;
    }

    private final Object[] removeFromRootAt(Object[] objArr, int i11, int i12, ObjectRef objectRef) {
        int indexSegment = UtilsKt.indexSegment(i12, i11);
        int i13 = 31;
        if (i11 == 0) {
            Object obj = objArr[indexSegment];
            Object[] copyInto = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) makeMutable(objArr), indexSegment, indexSegment + 1, 32);
            copyInto[31] = objectRef.getValue();
            objectRef.setValue(obj);
            return copyInto;
        }
        if (objArr[31] == null) {
            i13 = UtilsKt.indexSegment(rootSize() - 1, i11);
        }
        Object[] makeMutable = makeMutable(objArr);
        int i14 = i11 - 5;
        int i15 = indexSegment + 1;
        if (i15 <= i13) {
            while (true) {
                Object obj2 = makeMutable[i13];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                makeMutable[i13] = removeFromRootAt((Object[]) obj2, i14, 0, objectRef);
                if (i13 == i15) {
                    break;
                }
                i13--;
            }
        }
        Object obj3 = makeMutable[indexSegment];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        makeMutable[indexSegment] = removeFromRootAt((Object[]) obj3, i14, i12, objectRef);
        return makeMutable;
    }

    private final Object removeFromTailAt(Object[] objArr, int i11, int i12, int i13) {
        boolean z11;
        int size2 = size() - i11;
        if (i13 < size2) {
            z11 = true;
        } else {
            z11 = false;
        }
        CommonFunctionsKt.m2551assert(z11);
        if (size2 == 1) {
            Object obj = this.tail[0];
            pullLastBufferFromRoot(objArr, i11, i12);
            return obj;
        }
        Object[] objArr2 = this.tail;
        Object obj2 = objArr2[i13];
        Object[] copyInto = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr2, (T[]) makeMutable(objArr2), i13, i13 + 1, size2);
        copyInto[size2 - 1] = null;
        this.root = objArr;
        this.tail = copyInto;
        this.size = (i11 + size2) - 1;
        this.rootShift = i12;
        return obj2;
    }

    private final Object[] retainFirst(Object[] objArr, int i11) {
        boolean z11;
        if ((i11 & 31) == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (i11 == 0) {
            this.rootShift = 0;
            return null;
        } else {
            int i12 = i11 - 1;
            while (true) {
                int i13 = this.rootShift;
                if ((i12 >> i13) != 0) {
                    return nullifyAfter(objArr, i12, i13);
                }
                this.rootShift = i13 - 5;
                Object[] objArr2 = objArr[0];
                Intrinsics.checkNotNull(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArr = objArr2;
            }
        }
    }

    private final int rootSize() {
        if (size() <= 32) {
            return 0;
        }
        return UtilsKt.rootSize(size());
    }

    private final Object[] setInRoot(Object[] objArr, int i11, int i12, E e11, ObjectRef objectRef) {
        int indexSegment = UtilsKt.indexSegment(i12, i11);
        Object[] makeMutable = makeMutable(objArr);
        if (i11 == 0) {
            if (makeMutable != objArr) {
                this.modCount++;
            }
            objectRef.setValue(makeMutable[indexSegment]);
            makeMutable[indexSegment] = e11;
            return makeMutable;
        }
        Object obj = makeMutable[indexSegment];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        makeMutable[indexSegment] = setInRoot((Object[]) obj, i11 - 5, i12, e11, objectRef);
        return makeMutable;
    }

    private final Object[] shiftLeafBuffers(int i11, int i12, Object[][] objArr, int i13, Object[] objArr2) {
        if (this.root != null) {
            ListIterator<Object[]> leafBufferIterator = leafBufferIterator(rootSize() >> 5);
            while (leafBufferIterator.previousIndex() != i11) {
                Object[] previous = leafBufferIterator.previous();
                Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) previous, (T[]) objArr2, 0, 32 - i12, 32);
                objArr2 = makeMutableShiftingRight(previous, i12);
                i13--;
                objArr[i13] = objArr2;
            }
            return leafBufferIterator.previous();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void splitToBuffers(Collection<? extends E> collection, int i11, Object[] objArr, int i12, Object[][] objArr2, int i13, Object[] objArr3) {
        boolean z11;
        Object[] objArr4;
        if (i13 >= 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            Object[] makeMutable = makeMutable(objArr);
            objArr2[0] = makeMutable;
            int i14 = i11 & 31;
            int size2 = ((i11 + collection.size()) - 1) & 31;
            int i15 = (i12 - i14) + size2;
            if (i15 < 32) {
                Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) makeMutable, (T[]) objArr3, size2 + 1, i14, i12);
            } else {
                int i16 = (i15 - 32) + 1;
                if (i13 == 1) {
                    objArr4 = makeMutable;
                } else {
                    objArr4 = mutableBuffer();
                    i13--;
                    objArr2[i13] = objArr4;
                }
                int i17 = i12 - i16;
                Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) makeMutable, (T[]) objArr3, 0, i17, i12);
                Object[] unused3 = ArraysKt___ArraysJvmKt.copyInto((T[]) makeMutable, (T[]) objArr4, size2 + 1, i14, i17);
                objArr3 = objArr4;
            }
            Iterator<? extends E> it = collection.iterator();
            copyToBuffer(makeMutable, i14, it);
            for (int i18 = 1; i18 < i13; i18++) {
                objArr2[i18] = copyToBuffer(mutableBuffer(), 0, it);
            }
            copyToBuffer(objArr3, 0, it);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final int tailSize(int i11) {
        return i11 <= 32 ? i11 : i11 - UtilsKt.rootSize(i11);
    }

    public boolean add(E e11) {
        this.modCount++;
        int tailSize = tailSize();
        if (tailSize < 32) {
            Object[] makeMutable = makeMutable(this.tail);
            makeMutable[tailSize] = e11;
            this.tail = makeMutable;
            this.size = size() + 1;
        } else {
            pushFilledTail(this.root, this.tail, mutableBufferWith(e11));
        }
        return true;
    }

    public boolean addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        this.modCount++;
        int tailSize = tailSize();
        Iterator<? extends E> it = collection.iterator();
        if (32 - tailSize >= collection.size()) {
            this.tail = copyToBuffer(makeMutable(this.tail), tailSize, it);
            this.size = size() + collection.size();
        } else {
            int size2 = ((collection.size() + tailSize) - 1) / 32;
            Object[][] objArr = new Object[size2][];
            objArr[0] = copyToBuffer(makeMutable(this.tail), tailSize, it);
            for (int i11 = 1; i11 < size2; i11++) {
                objArr[i11] = copyToBuffer(mutableBuffer(), 0, it);
            }
            this.root = pushBuffersIncreasingHeightIfNeeded(this.root, rootSize(), objArr);
            this.tail = copyToBuffer(mutableBuffer(), 0, it);
            this.size = size() + collection.size();
        }
        return true;
    }

    public E get(int i11) {
        ListImplementation.checkElementIndex$runtime_release(i11, size());
        return bufferFor(i11)[i11 & 31];
    }

    public final int getModCount$runtime_release() {
        return this.modCount;
    }

    @Nullable
    public final Object[] getRoot$runtime_release() {
        return this.root;
    }

    public final int getRootShift$runtime_release() {
        return this.rootShift;
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public final Object[] getTail$runtime_release() {
        return this.tail;
    }

    @NotNull
    public Iterator<E> iterator() {
        return listIterator();
    }

    @NotNull
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return removeAllWithPredicate(new PersistentVectorBuilder$removeAll$1(collection));
    }

    public final boolean removeAllWithPredicate(@NotNull Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        boolean removeAll = removeAll(function1);
        if (removeAll) {
            this.modCount++;
        }
        return removeAll;
    }

    public E removeAt(int i11) {
        ListImplementation.checkElementIndex$runtime_release(i11, size());
        this.modCount++;
        int rootSize = rootSize();
        if (i11 >= rootSize) {
            return removeFromTailAt(this.root, rootSize, this.rootShift, i11 - rootSize);
        }
        ObjectRef objectRef = new ObjectRef(this.tail[0]);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        removeFromTailAt(removeFromRootAt(objArr, this.rootShift, i11, objectRef), rootSize, this.rootShift, 0);
        return objectRef.getValue();
    }

    public E set(int i11, E e11) {
        ListImplementation.checkElementIndex$runtime_release(i11, size());
        if (rootSize() <= i11) {
            E[] makeMutable = makeMutable(this.tail);
            if (makeMutable != this.tail) {
                this.modCount++;
            }
            int i12 = i11 & 31;
            E e12 = makeMutable[i12];
            makeMutable[i12] = e11;
            this.tail = makeMutable;
            return e12;
        }
        ObjectRef objectRef = new ObjectRef((Object) null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        this.root = setInRoot(objArr, this.rootShift, i11, e11, objectRef);
        return objectRef.getValue();
    }

    public final void setRootShift$runtime_release(int i11) {
        this.rootShift = i11;
    }

    private final boolean removeAll(Function1<? super E, Boolean> function1) {
        Object[] objArr;
        Function1<? super E, Boolean> function12 = function1;
        int tailSize = tailSize();
        ObjectRef objectRef = new ObjectRef((Object) null);
        if (this.root != null) {
            ListIterator<Object[]> leafBufferIterator = leafBufferIterator(0);
            int i11 = 32;
            while (i11 == 32 && leafBufferIterator.hasNext()) {
                i11 = removeAll(function12, leafBufferIterator.next(), 32, objectRef);
            }
            if (i11 == 32) {
                CommonFunctionsKt.m2551assert(!leafBufferIterator.hasNext());
                int removeAllFromTail = removeAllFromTail(function12, tailSize, objectRef);
                if (removeAllFromTail == 0) {
                    pullLastBufferFromRoot(this.root, size(), this.rootShift);
                }
                if (removeAllFromTail != tailSize) {
                    return true;
                }
                return false;
            }
            int previousIndex = leafBufferIterator.previousIndex() << 5;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i12 = i11;
            while (leafBufferIterator.hasNext()) {
                i12 = recyclableRemoveAll(function1, leafBufferIterator.next(), 32, i12, objectRef, arrayList2, arrayList);
                previousIndex = previousIndex;
            }
            int i13 = previousIndex;
            int recyclableRemoveAll = recyclableRemoveAll(function1, this.tail, tailSize, i12, objectRef, arrayList2, arrayList);
            Object value = objectRef.getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            Object[] objArr2 = (Object[]) value;
            ArraysKt___ArraysJvmKt.fill((T[]) objArr2, null, recyclableRemoveAll, 32);
            if (arrayList.isEmpty()) {
                objArr = this.root;
                Intrinsics.checkNotNull(objArr);
            } else {
                objArr = pushBuffers(this.root, i13, this.rootShift, arrayList.iterator());
            }
            int size2 = i13 + (arrayList.size() << 5);
            this.root = retainFirst(objArr, size2);
            this.tail = objArr2;
            this.size = size2 + recyclableRemoveAll;
            return true;
        } else if (removeAllFromTail(function12, tailSize, objectRef) != tailSize) {
            return true;
        } else {
            return false;
        }
    }

    private final int tailSize() {
        return tailSize(size());
    }

    @NotNull
    public PersistentList<E> build() {
        PersistentList<? extends E> persistentList;
        if (this.root == this.vectorRoot && this.tail == this.vectorTail) {
            persistentList = this.vector;
        } else {
            this.ownership = new MutabilityOwnership();
            Object[] objArr = this.root;
            this.vectorRoot = objArr;
            Object[] objArr2 = this.tail;
            this.vectorTail = objArr2;
            if (objArr == null) {
                if (objArr2.length == 0) {
                    persistentList = UtilsKt.persistentVectorOf();
                } else {
                    Object[] copyOf = Arrays.copyOf(this.tail, size());
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    persistentList = new SmallPersistentVector<>(copyOf);
                }
            } else {
                Object[] objArr3 = this.root;
                Intrinsics.checkNotNull(objArr3);
                persistentList = new PersistentVector<>(objArr3, this.tail, size(), this.rootShift);
            }
        }
        this.vector = persistentList;
        return persistentList;
    }

    @NotNull
    public ListIterator<E> listIterator(int i11) {
        ListImplementation.checkPositionIndex$runtime_release(i11, size());
        return new PersistentVectorMutableIterator(this, i11);
    }

    private final void insertIntoRoot(Collection<? extends E> collection, int i11, int i12, Object[][] objArr, int i13, Object[] objArr2) {
        if (this.root != null) {
            int i14 = i11 >> 5;
            Object[] shiftLeafBuffers = shiftLeafBuffers(i14, i12, objArr, i13, objArr2);
            int rootSize = i13 - (((rootSize() >> 5) - 1) - i14);
            if (rootSize < i13) {
                objArr2 = objArr[rootSize];
                Intrinsics.checkNotNull(objArr2);
            }
            splitToBuffers(collection, i11, shiftLeafBuffers, 32, objArr, rootSize, objArr2);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void add(int i11, E e11) {
        ListImplementation.checkPositionIndex$runtime_release(i11, size());
        if (i11 == size()) {
            add(e11);
            return;
        }
        this.modCount++;
        int rootSize = rootSize();
        if (i11 >= rootSize) {
            insertIntoTail(this.root, i11 - rootSize, e11);
            return;
        }
        ObjectRef objectRef = new ObjectRef((Object) null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        insertIntoTail(insertIntoRoot(objArr, this.rootShift, i11, e11, objectRef), 0, objectRef.getValue());
    }

    public boolean addAll(int i11, @NotNull Collection<? extends E> collection) {
        Object[] objArr;
        Intrinsics.checkNotNullParameter(collection, "elements");
        ListImplementation.checkPositionIndex$runtime_release(i11, size());
        if (i11 == size()) {
            return addAll(collection);
        }
        boolean z11 = false;
        if (collection.isEmpty()) {
            return false;
        }
        this.modCount++;
        int i12 = (i11 >> 5) << 5;
        int size2 = (((size() - i12) + collection.size()) - 1) / 32;
        if (size2 == 0) {
            if (i11 >= rootSize()) {
                z11 = true;
            }
            CommonFunctionsKt.m2551assert(z11);
            int i13 = i11 & 31;
            Object[] objArr2 = this.tail;
            Object[] copyInto = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr2, (T[]) makeMutable(objArr2), (((i11 + collection.size()) - 1) & 31) + 1, i13, tailSize());
            copyToBuffer(copyInto, i13, collection.iterator());
            this.tail = copyInto;
            this.size = size() + collection.size();
            return true;
        }
        Object[][] objArr3 = new Object[size2][];
        int tailSize = tailSize();
        int tailSize2 = tailSize(size() + collection.size());
        if (i11 >= rootSize()) {
            objArr = mutableBuffer();
            splitToBuffers(collection, i11, this.tail, tailSize, objArr3, size2, objArr);
        } else if (tailSize2 > tailSize) {
            int i14 = tailSize2 - tailSize;
            objArr = makeMutableShiftingRight(this.tail, i14);
            insertIntoRoot(collection, i11, i14, objArr3, size2, objArr);
        } else {
            int i15 = tailSize - tailSize2;
            objArr = ArraysKt___ArraysJvmKt.copyInto((T[]) this.tail, (T[]) mutableBuffer(), 0, i15, tailSize);
            int i16 = 32 - i15;
            Object[] makeMutableShiftingRight = makeMutableShiftingRight(this.tail, i16);
            int i17 = size2 - 1;
            objArr3[i17] = makeMutableShiftingRight;
            insertIntoRoot(collection, i11, i16, objArr3, i17, makeMutableShiftingRight);
        }
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, i12, objArr3);
        this.tail = objArr;
        this.size = size() + collection.size();
        return true;
    }

    private final int removeAll(Function1<? super E, Boolean> function1, Object[] objArr, int i11, ObjectRef objectRef) {
        Object[] objArr2 = objArr;
        int i12 = i11;
        boolean z11 = false;
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = objArr[i13];
            if (function1.invoke(obj).booleanValue()) {
                if (!z11) {
                    objArr2 = makeMutable(objArr);
                    z11 = true;
                    i12 = i13;
                }
            } else if (z11) {
                objArr2[i12] = obj;
                i12++;
            }
        }
        objectRef.setValue(objArr2);
        return i12;
    }
}
