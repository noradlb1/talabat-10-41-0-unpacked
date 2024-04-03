package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v0.a;

@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006Ô\u0001Õ\u0001Ö\u0001B\u0012\u0012\u0007\u0010Ñ\u0001\u001a\u00020\u001b¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001J&\u0010\n\u001a\u00020\t2\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\b¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0012H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0012H\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u00020\u0007*\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b'\u0010$J.\u0010*\u001a\u00020\u0007\"\n\b\u0000\u0010)\u0018\u0001*\u00020(2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\b¢\u0006\u0004\b*\u0010$J\u0019\u0010,\u001a\u00020+2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b,\u0010-J@\u00103\u001a\u00020(2'\u00101\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`02\u0006\u00102\u001a\u00020\u001bH\u0002¢\u0006\u0004\b3\u00104J'\u00107\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\u0006\u00106\u001a\u00020(H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u00072\u0006\u0010\r\u001a\u000209H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020(H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u001bH\u0002¢\u0006\u0004\b>\u0010?J\u0013\u0010@\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u001b\u0010B\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bF\u0010CJ\u0019\u0010G\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u0019H\u0002¢\u0006\u0004\bG\u0010HJ\u001f\u0010I\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\bI\u0010JJ%\u0010K\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bK\u0010LJ#\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bM\u0010NJ\u0019\u0010P\u001a\u0004\u0018\u00010O2\u0006\u0010\r\u001a\u00020\u0019H\u0002¢\u0006\u0004\bP\u0010QJ*\u0010S\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010R\u001a\u00020O2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0010¢\u0006\u0004\bS\u0010TJ)\u0010V\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010U\u001a\u00020O2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bV\u0010WJ\u0015\u0010Y\u001a\u0004\u0018\u00010O*\u00020XH\u0002¢\u0006\u0004\bY\u0010ZJ\u0019\u0010\\\u001a\u00020[2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\\\u0010]J\u0015\u0010^\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0004\b^\u0010AJ\u0019\u0010`\u001a\u00020\u00072\b\u0010_\u001a\u0004\u0018\u00010\u0001H\u0004¢\u0006\u0004\b`\u0010aJ\r\u0010b\u001a\u00020\u001b¢\u0006\u0004\bb\u0010?J\u000f\u0010c\u001a\u00020\u0007H\u0014¢\u0006\u0004\bc\u0010dJ\u0011\u0010g\u001a\u00060ej\u0002`f¢\u0006\u0004\bg\u0010hJ#\u0010j\u001a\u00060ej\u0002`f*\u00020\u00122\n\b\u0002\u0010i\u001a\u0004\u0018\u00010[H\u0004¢\u0006\u0004\bj\u0010kJ6\u0010m\u001a\u00020l2'\u00101\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`0¢\u0006\u0004\bm\u0010nJF\u0010m\u001a\u00020l2\u0006\u00102\u001a\u00020\u001b2\u0006\u0010o\u001a\u00020\u001b2'\u00101\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`0¢\u0006\u0004\bm\u0010pJ\u0013\u0010q\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\bq\u0010AJB\u0010v\u001a\u00020\u0007\"\u0004\b\u0000\u0010r2\f\u0010t\u001a\b\u0012\u0004\u0012\u00028\u00000s2\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000u\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005ø\u0001\u0000¢\u0006\u0004\bv\u0010wJ\u0017\u0010y\u001a\u00020\u00072\u0006\u00106\u001a\u00020(H\u0000¢\u0006\u0004\bx\u0010=J\u001f\u0010z\u001a\u00020\u00072\u000e\u0010\"\u001a\n\u0018\u00010ej\u0004\u0018\u0001`fH\u0016¢\u0006\u0004\bz\u0010{J\u000f\u0010|\u001a\u00020[H\u0014¢\u0006\u0004\b|\u0010}J\u0019\u0010z\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0004\bz\u0010&J\u0017\u0010~\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0012H\u0016¢\u0006\u0004\b~\u0010J\u0019\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0012H\u0016¢\u0006\u0005\b\u0001\u0010&J\u0019\u0010\u0001\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0012¢\u0006\u0005\b\u0001\u0010&J\u001c\u0010\u0001\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J,\u0010\u0001\u001a\u00030\u00012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010[2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0012H\b¢\u0006\u0006\b\u0001\u0010\u0001J\u0015\u0010\u0001\u001a\u00060ej\u0002`fH\u0016¢\u0006\u0005\b\u0001\u0010hJ\u001c\u0010\u0001\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0005\b\u0001\u0010CJ\u0019\u0010\u0001\u001a\u00030\u00012\u0006\u0010R\u001a\u00020\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0012H\u0010¢\u0006\u0005\b\u0001\u0010J\u001b\u0010\u0001\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0005\b\u0001\u0010J\u001a\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020\u0012H\u0014¢\u0006\u0005\b\u0001\u0010&J\u001c\u0010\u0001\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020[H\u0016¢\u0006\u0005\b\u0001\u0010}J\u0011\u0010\u0001\u001a\u00020[H\u0007¢\u0006\u0005\b\u0001\u0010}J\u0011\u0010\u0001\u001a\u00020[H\u0010¢\u0006\u0005\b\u0001\u0010}J\u0012\u0010 \u0001\u001a\u0004\u0018\u00010\u0012¢\u0006\u0006\b \u0001\u0010¡\u0001J\u0014\u0010¤\u0001\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u0017\u0010¦\u0001\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0005\b¥\u0001\u0010AJT\u0010ª\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010)\"\u0004\b\u0001\u0010r2\f\u0010t\u001a\b\u0012\u0004\u0012\u00028\u00010s2#\u0010\b\u001a\u001f\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010u\u0012\u0006\u0012\u0004\u0018\u00010\u00060§\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b¨\u0001\u0010©\u0001JT\u0010¬\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010)\"\u0004\b\u0001\u0010r2\f\u0010t\u001a\b\u0012\u0004\u0012\u00028\u00010s2#\u0010\b\u001a\u001f\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010u\u0012\u0006\u0012\u0004\u0018\u00010\u00060§\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b«\u0001\u0010©\u0001R\u001e\u0010®\u0001\u001a\u0004\u0018\u00010\u0012*\u0004\u0018\u00010\u00068BX\u0004¢\u0006\u0007\u001a\u0005\b­\u0001\u0010ER\u001b\u0010¯\u0001\u001a\u00020\u001b*\u00020\u00198BX\u0004¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001R\u0019\u0010´\u0001\u001a\u0007\u0012\u0002\b\u00030±\u00018F¢\u0006\b\u001a\u0006\b²\u0001\u0010³\u0001R0\u0010º\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010µ\u0001\u001a\u0005\u0018\u00010\u00018@@@X\u000e¢\u0006\u0010\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068@X\u0004¢\u0006\b\u001a\u0006\b»\u0001\u0010£\u0001R\u0016\u0010¼\u0001\u001a\u00020\u001b8VX\u0004¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010?R\u0013\u0010½\u0001\u001a\u00020\u001b8F¢\u0006\u0007\u001a\u0005\b½\u0001\u0010?R\u0013\u0010¾\u0001\u001a\u00020\u001b8F¢\u0006\u0007\u001a\u0005\b¾\u0001\u0010?R\u0019\u0010À\u0001\u001a\u0004\u0018\u00010\u00128DX\u0004¢\u0006\b\u001a\u0006\b¿\u0001\u0010¡\u0001R\u0016\u0010Â\u0001\u001a\u00020\u001b8DX\u0004¢\u0006\u0007\u001a\u0005\bÁ\u0001\u0010?R\u0014\u0010Å\u0001\u001a\u00020\u00048F¢\u0006\b\u001a\u0006\bÃ\u0001\u0010Ä\u0001R\u0016\u0010Ç\u0001\u001a\u00020\u001b8PX\u0004¢\u0006\u0007\u001a\u0005\bÆ\u0001\u0010?R\u001b\u0010Ë\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010È\u00018F¢\u0006\b\u001a\u0006\bÉ\u0001\u0010Ê\u0001R\u0016\u0010Í\u0001\u001a\u00020\u001b8TX\u0004¢\u0006\u0007\u001a\u0005\bÌ\u0001\u0010?R\u0016\u0010Ï\u0001\u001a\u00020\u001b8PX\u0004¢\u0006\u0007\u001a\u0005\bÎ\u0001\u0010?R\u0013\u0010Ð\u0001\u001a\u00020\u001b8F¢\u0006\u0007\u001a\u0005\bÐ\u0001\u0010?\u0002\u0004\n\u0002\b\u0019¨\u0006×\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlin/Function1;", "", "", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "Lkotlinx/coroutines/JobSupport$Finishing;", "state", "proposedUpdate", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "", "", "exceptions", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "Lkotlinx/coroutines/Incomplete;", "update", "", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/NodeList;", "list", "cause", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "cancelParent", "(Ljava/lang/Throwable;)Z", "notifyCompletion", "Lkotlinx/coroutines/JobNode;", "T", "notifyHandlers", "", "startInternal", "(Ljava/lang/Object;)I", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "onCancelling", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "expect", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "joinInternal", "()Z", "joinSuspend", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "makeCancelling", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/ChildHandleNode;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "child", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "lastChild", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "awaitSuspend", "parent", "f", "(Lkotlinx/coroutines/Job;)V", "start", "j", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "message", "k", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "invokeImmediately", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "removeNode$kotlinx_coroutines_core", "removeNode", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "b", "()Ljava/lang/String;", "cancelInternal", "(Ljava/lang/Throwable;)V", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "childCancelled", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "getChildJobCancellationCause", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "exception", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "h", "e", "i", "(Ljava/lang/Object;)V", "a", "toString", "toDebugString", "nameString$kotlinx_coroutines_core", "nameString", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "awaitInternal$kotlinx_coroutines_core", "awaitInternal", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "isActive", "isCompleted", "isCancelled", "c", "completionCause", "d", "completionCauseHandled", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "g", "isScopedCoroutine", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isCompletedExceptionally", "active", "<init>", "(Z)V", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
public class JobSupport implements Job, ChildJob, ParentJob, SelectClause0 {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    @NotNull
    private volatile /* synthetic */ Object _parentHandle;
    @NotNull
    private volatile /* synthetic */ Object _state;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/Job;", "parent", "", "getContinuationCancellationCause", "", "a", "Lkotlinx/coroutines/JobSupport;", "job", "Lkotlinx/coroutines/JobSupport;", "Lkotlin/coroutines/Continuation;", "delegate", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        @NotNull
        private final JobSupport job;

        public AwaitContinuation(@NotNull Continuation<? super T> continuation, @NotNull JobSupport jobSupport) {
            super(continuation, 1);
            this.job = jobSupport;
        }

        @NotNull
        public String a() {
            return "AwaitContinuation";
        }

        @NotNull
        public Throwable getContinuationCancellationCause(@NotNull Job job2) {
            Throwable rootCause;
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            if ((state$kotlinx_coroutines_core instanceof Finishing) && (rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause()) != null) {
                return rootCause;
            }
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                return ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            }
            return job2.getCancellationException();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ChildCompletion extends JobNode {
        @NotNull
        private final ChildHandleNode child;
        @NotNull
        private final JobSupport parent;
        @Nullable
        private final Object proposedUpdate;
        @NotNull
        private final Finishing state;

        public ChildCompletion(@NotNull JobSupport jobSupport, @NotNull Finishing finishing, @NotNull ChildHandleNode childHandleNode, @Nullable Object obj) {
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = obj;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.INSTANCE;
        }

        public void invoke(@Nullable Throwable th2) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00060\u0018j\u0002`,2\u00020-B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00188B@BX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010 \"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010 R\u001a\u0010\u0002\u001a\u00020\u00018\u0016X\u0004¢\u0006\f\n\u0004\b\u0002\u0010%\u001a\u0004\b&\u0010'R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\f¨\u0006+"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Finishing implements Incomplete {
        @NotNull
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        @NotNull
        private volatile /* synthetic */ int _isCompleting;
        @NotNull
        private volatile /* synthetic */ Object _rootCause;
        @NotNull
        private final NodeList list;

        public Finishing(@NotNull NodeList nodeList, boolean z11, @Nullable Throwable th2) {
            this.list = nodeList;
            this._isCompleting = z11 ? 1 : 0;
            this._rootCause = th2;
        }

        private final ArrayList<Throwable> allocateList() {
            return new ArrayList<>(4);
        }

        private final Object getExceptionsHolder() {
            return this._exceptionsHolder;
        }

        private final void setExceptionsHolder(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void addExceptionLocked(@NotNull Throwable th2) {
            Throwable rootCause = getRootCause();
            if (rootCause == null) {
                setRootCause(th2);
            } else if (th2 != rootCause) {
                Object exceptionsHolder = getExceptionsHolder();
                if (exceptionsHolder == null) {
                    setExceptionsHolder(th2);
                } else if (exceptionsHolder instanceof Throwable) {
                    if (th2 != exceptionsHolder) {
                        ArrayList<Throwable> allocateList = allocateList();
                        allocateList.add(exceptionsHolder);
                        allocateList.add(th2);
                        setExceptionsHolder(allocateList);
                    }
                } else if (exceptionsHolder instanceof ArrayList) {
                    ((ArrayList) exceptionsHolder).add(th2);
                } else {
                    throw new IllegalStateException(("State is " + exceptionsHolder).toString());
                }
            }
        }

        @NotNull
        public NodeList getList() {
            return this.list;
        }

        @Nullable
        public final Throwable getRootCause() {
            return (Throwable) this._rootCause;
        }

        public boolean isActive() {
            return getRootCause() == null;
        }

        public final boolean isCancelling() {
            return getRootCause() != null;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
        public final boolean isCompleting() {
            return this._isCompleting;
        }

        public final boolean isSealed() {
            return getExceptionsHolder() == JobSupportKt.SEALED;
        }

        @NotNull
        public final List<Throwable> sealLocked(@Nullable Throwable th2) {
            ArrayList<Throwable> arrayList;
            Object exceptionsHolder = getExceptionsHolder();
            if (exceptionsHolder == null) {
                arrayList = allocateList();
            } else if (exceptionsHolder instanceof Throwable) {
                ArrayList<Throwable> allocateList = allocateList();
                allocateList.add(exceptionsHolder);
                arrayList = allocateList;
            } else if (exceptionsHolder instanceof ArrayList) {
                arrayList = (ArrayList) exceptionsHolder;
            } else {
                throw new IllegalStateException(("State is " + exceptionsHolder).toString());
            }
            Throwable rootCause = getRootCause();
            if (rootCause != null) {
                arrayList.add(0, rootCause);
            }
            if (th2 != null && !Intrinsics.areEqual((Object) th2, (Object) rootCause)) {
                arrayList.add(th2);
            }
            setExceptionsHolder(JobSupportKt.SEALED);
            return arrayList;
        }

        public final void setCompleting(boolean z11) {
            this._isCompleting = z11 ? 1 : 0;
        }

        public final void setRootCause(@Nullable Throwable th2) {
            this._rootCause = th2;
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + isCancelling() + ", completing=" + isCompleting() + ", rootCause=" + getRootCause() + ", exceptions=" + getExceptionsHolder() + ", list=" + getList() + AbstractJsonLexerKt.END_LIST;
        }
    }

    public JobSupport(boolean z11) {
        Empty empty;
        if (z11) {
            empty = JobSupportKt.EMPTY_ACTIVE;
        } else {
            empty = JobSupportKt.EMPTY_NEW;
        }
        this._state = empty;
        this._parentHandle = null;
    }

    private final boolean addLastAtomic(Object obj, NodeList nodeList, JobNode jobNode) {
        int tryCondAddNext;
        JobSupport$addLastAtomic$$inlined$addLastIf$1 jobSupport$addLastAtomic$$inlined$addLastIf$1 = new JobSupport$addLastAtomic$$inlined$addLastIf$1(jobNode, this, obj);
        do {
            tryCondAddNext = nodeList.getPrevNode().tryCondAddNext(jobNode, nodeList, jobSupport$addLastAtomic$$inlined$addLastIf$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    private final void addSuppressedExceptions(Throwable th2, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            for (Throwable th3 : list) {
                if (th3 != th2 && th3 != th2 && !(th3 instanceof CancellationException) && newSetFromMap.add(th3)) {
                    ExceptionsKt__ExceptionsKt.addSuppressed(th2, th3);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object awaitSuspend(Continuation<Object> continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), this);
        awaitContinuation.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(awaitContinuation, invokeOnCompletion(new ResumeAwaitOnCompletion(awaitContinuation)));
        Object result = awaitContinuation.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final Object cancelMakeCompleting(Object obj) {
        Object tryMakeCompleting;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).isCompleting())) {
                return JobSupportKt.COMPLETING_ALREADY;
            }
            tryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(createCauseException(obj), false, 2, (DefaultConstructorMarker) null));
        } while (tryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        return tryMakeCompleting;
    }

    private final boolean cancelParent(Throwable th2) {
        if (g()) {
            return true;
        }
        boolean z11 = th2 instanceof CancellationException;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == NonDisposableHandle.INSTANCE) {
            return z11;
        }
        if (parentHandle$kotlinx_coroutines_core.childCancelled(th2) || z11) {
            return true;
        }
        return false;
    }

    private final void completeStateFinalization(Incomplete incomplete, Object obj) {
        CompletedExceptionally completedExceptionally;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
        Throwable th2 = null;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally != null) {
            th2 = completedExceptionally.cause;
        }
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).invoke(th2);
            } catch (Throwable th3) {
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th3));
            }
        } else {
            NodeList list = incomplete.getList();
            if (list != null) {
                notifyCompletion(list, th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void continueCompleting(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        ChildHandleNode nextChild = nextChild(childHandleNode);
        if (nextChild == null || !tryWaitForChild(finishing, nextChild, obj)) {
            a(finalizeFinishingState(finishing, obj));
        }
    }

    private final Throwable createCauseException(Object obj) {
        boolean z11;
        if (obj == null) {
            z11 = true;
        } else {
            z11 = obj instanceof Throwable;
        }
        if (z11) {
            Throwable th2 = (Throwable) obj;
            if (th2 == null) {
                return new JobCancellationException(b(), (Throwable) null, this);
            }
            return th2;
        } else if (obj != null) {
            return ((ParentJob) obj).getChildJobCancellationCause();
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport jobSupport, String str, Throwable th2, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                th2 = null;
            }
            if (str == null) {
                str = jobSupport.b();
            }
            return new JobCancellationException(str, th2, jobSupport);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
    }

    private final Object finalizeFinishingState(Finishing finishing, Object obj) {
        CompletedExceptionally completedExceptionally;
        Throwable th2;
        boolean isCancelling;
        Throwable finalRootCause;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally != null) {
            th2 = completedExceptionally.cause;
        } else {
            th2 = null;
        }
        synchronized (finishing) {
            isCancelling = finishing.isCancelling();
            List<Throwable> sealLocked = finishing.sealLocked(th2);
            finalRootCause = getFinalRootCause(finishing, sealLocked);
            if (finalRootCause != null) {
                addSuppressedExceptions(finalRootCause, sealLocked);
            }
        }
        boolean z11 = false;
        if (!(finalRootCause == null || finalRootCause == th2)) {
            obj = new CompletedExceptionally(finalRootCause, false, 2, (DefaultConstructorMarker) null);
        }
        if (finalRootCause != null) {
            if (cancelParent(finalRootCause) || e(finalRootCause)) {
                z11 = true;
            }
            if (z11) {
                if (obj != null) {
                    ((CompletedExceptionally) obj).makeHandled();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
            }
        }
        if (!isCancelling) {
            h(finalRootCause);
        }
        i(obj);
        a.a(_state$FU, this, finishing, JobSupportKt.boxIncomplete(obj));
        completeStateFinalization(finishing, obj);
        return obj;
    }

    private final ChildHandleNode firstChild(Incomplete incomplete) {
        ChildHandleNode childHandleNode = incomplete instanceof ChildHandleNode ? (ChildHandleNode) incomplete : null;
        if (childHandleNode != null) {
            return childHandleNode;
        }
        NodeList list = incomplete.getList();
        if (list != null) {
            return nextChild(list);
        }
        return null;
    }

    private final Throwable getExceptionOrNull(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Throwable getFinalRootCause(kotlinx.coroutines.JobSupport.Finishing r6, java.util.List<? extends java.lang.Throwable> r7) {
        /*
            r5 = this;
            boolean r0 = r7.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            boolean r6 = r6.isCancelling()
            if (r6 == 0) goto L_0x0017
            kotlinx.coroutines.JobCancellationException r6 = new kotlinx.coroutines.JobCancellationException
            java.lang.String r7 = r5.b()
            r6.<init>(r7, r1, r5)
            return r6
        L_0x0017:
            return r1
        L_0x0018:
            r6 = r7
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r0 = r6.iterator()
        L_0x001f:
            boolean r2 = r0.hasNext()
            r3 = 1
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r0.next()
            r4 = r2
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r4 = r4 instanceof java.util.concurrent.CancellationException
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x001f
            goto L_0x0034
        L_0x0033:
            r2 = r1
        L_0x0034:
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            if (r2 == 0) goto L_0x0039
            return r2
        L_0x0039:
            r0 = 0
            java.lang.Object r7 = r7.get(r0)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            boolean r2 = r7 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r2 == 0) goto L_0x0066
            java.util.Iterator r6 = r6.iterator()
        L_0x0048:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x0061
            java.lang.Object r2 = r6.next()
            r4 = r2
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            if (r4 == r7) goto L_0x005d
            boolean r4 = r4 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r4 == 0) goto L_0x005d
            r4 = r3
            goto L_0x005e
        L_0x005d:
            r4 = r0
        L_0x005e:
            if (r4 == 0) goto L_0x0048
            r1 = r2
        L_0x0061:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            if (r1 == 0) goto L_0x0066
            return r1
        L_0x0066:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.getFinalRootCause(kotlinx.coroutines.JobSupport$Finishing, java.util.List):java.lang.Throwable");
    }

    private final NodeList getOrPromoteCancellingList(Incomplete incomplete) {
        NodeList list = incomplete.getList();
        if (list != null) {
            return list;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            promoteSingleToNodeList((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    private final boolean isCancelling(Incomplete incomplete) {
        return (incomplete instanceof Finishing) && ((Finishing) incomplete).isCancelling();
    }

    private final boolean joinInternal() {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                return false;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return true;
    }

    /* access modifiers changed from: private */
    public final Object joinSuspend(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, invokeOnCompletion(new ResumeOnCompletion(cancellableContinuationImpl)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    private final Void loopOnState(Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(getState$kotlinx_coroutines_core());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        if (r0 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        notifyCancelling(((kotlinx.coroutines.JobSupport.Finishing) r2).getList(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        return kotlinx.coroutines.JobSupportKt.access$getCOMPLETING_ALREADY$p();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object makeCancelling(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r6.getState$kotlinx_coroutines_core()
            boolean r3 = r2 instanceof kotlinx.coroutines.JobSupport.Finishing
            if (r3 == 0) goto L_0x0051
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch:{ all -> 0x004e }
            boolean r3 = r3.isSealed()     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x001a
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.TOO_LATE_TO_CANCEL     // Catch:{ all -> 0x004e }
            monitor-exit(r2)
            return r7
        L_0x001a:
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch:{ all -> 0x004e }
            boolean r3 = r3.isCancelling()     // Catch:{ all -> 0x004e }
            if (r7 != 0) goto L_0x0025
            if (r3 != 0) goto L_0x0031
        L_0x0025:
            if (r1 != 0) goto L_0x002b
            java.lang.Throwable r1 = r6.createCauseException(r7)     // Catch:{ all -> 0x004e }
        L_0x002b:
            r7 = r2
            kotlinx.coroutines.JobSupport$Finishing r7 = (kotlinx.coroutines.JobSupport.Finishing) r7     // Catch:{ all -> 0x004e }
            r7.addExceptionLocked(r1)     // Catch:{ all -> 0x004e }
        L_0x0031:
            r7 = r2
            kotlinx.coroutines.JobSupport$Finishing r7 = (kotlinx.coroutines.JobSupport.Finishing) r7     // Catch:{ all -> 0x004e }
            java.lang.Throwable r7 = r7.getRootCause()     // Catch:{ all -> 0x004e }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003d
            r0 = r7
        L_0x003d:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x0049
            kotlinx.coroutines.JobSupport$Finishing r2 = (kotlinx.coroutines.JobSupport.Finishing) r2
            kotlinx.coroutines.NodeList r7 = r2.getList()
            r6.notifyCancelling(r7, r0)
        L_0x0049:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY
            return r7
        L_0x004e:
            r7 = move-exception
            monitor-exit(r2)
            throw r7
        L_0x0051:
            boolean r3 = r2 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto L_0x00a2
            if (r1 != 0) goto L_0x005b
            java.lang.Throwable r1 = r6.createCauseException(r7)
        L_0x005b:
            r3 = r2
            kotlinx.coroutines.Incomplete r3 = (kotlinx.coroutines.Incomplete) r3
            boolean r4 = r3.isActive()
            if (r4 == 0) goto L_0x006f
            boolean r2 = r6.tryMakeCancelling(r3, r1)
            if (r2 == 0) goto L_0x0002
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY
            return r7
        L_0x006f:
            kotlinx.coroutines.CompletedExceptionally r3 = new kotlinx.coroutines.CompletedExceptionally
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.tryMakeCompleting(r2, r3)
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY
            if (r3 == r4) goto L_0x0087
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.JobSupportKt.COMPLETING_RETRY
            if (r3 == r2) goto L_0x0002
            return r3
        L_0x0087:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot happen in "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00a2:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.TOO_LATE_TO_CANCEL
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.makeCancelling(java.lang.Object):java.lang.Object");
    }

    private final JobNode makeNode(Function1<? super Throwable, Unit> function1, boolean z11) {
        JobNode jobNode = null;
        if (z11) {
            if (function1 instanceof JobCancellingNode) {
                jobNode = (JobCancellingNode) function1;
            }
            if (jobNode == null) {
                jobNode = new InvokeOnCancelling(function1);
            }
        } else {
            if (function1 instanceof JobNode) {
                jobNode = (JobNode) function1;
            }
            if (jobNode == null) {
                jobNode = new InvokeOnCompletion(function1);
            }
        }
        jobNode.setJob(this);
        return jobNode;
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    private final void notifyCancelling(NodeList nodeList, Throwable th2) {
        h(th2);
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.getNext(); !Intrinsics.areEqual((Object) lockFreeLinkedListNode, (Object) nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.invoke(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
        cancelParent(th2);
    }

    private final void notifyCompletion(NodeList nodeList, Throwable th2) {
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.getNext(); !Intrinsics.areEqual((Object) lockFreeLinkedListNode, (Object) nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.invoke(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
    }

    private final /* synthetic */ <T extends JobNode> void notifyHandlers(NodeList nodeList, Throwable th2) {
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.getNext(); !Intrinsics.areEqual((Object) lockFreeLinkedListNode, (Object) nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.invoke(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [kotlinx.coroutines.InactiveNodeList] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void promoteEmptyToNodeList(kotlinx.coroutines.Empty r3) {
        /*
            r2 = this;
            kotlinx.coroutines.NodeList r0 = new kotlinx.coroutines.NodeList
            r0.<init>()
            boolean r1 = r3.isActive()
            if (r1 == 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            kotlinx.coroutines.InactiveNodeList r1 = new kotlinx.coroutines.InactiveNodeList
            r1.<init>(r0)
            r0 = r1
        L_0x0012:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = _state$FU
            v0.a.a(r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.promoteEmptyToNodeList(kotlinx.coroutines.Empty):void");
    }

    private final void promoteSingleToNodeList(JobNode jobNode) {
        jobNode.addOneIfEmpty(new NodeList());
        a.a(_state$FU, this, jobNode, jobNode.getNextNode());
    }

    private final int startInternal(Object obj) {
        if (obj instanceof Empty) {
            if (((Empty) obj).isActive()) {
                return 0;
            }
            if (!a.a(_state$FU, this, obj, JobSupportKt.EMPTY_ACTIVE)) {
                return -1;
            }
            j();
            return 1;
        } else if (!(obj instanceof InactiveNodeList)) {
            return 0;
        } else {
            if (!a.a(_state$FU, this, obj, ((InactiveNodeList) obj).getList())) {
                return -1;
            }
            j();
            return 1;
        }
    }

    private final String stateString(Object obj) {
        if (obj instanceof Finishing) {
            Finishing finishing = (Finishing) obj;
            if (finishing.isCancelling()) {
                return "Cancelling";
            }
            if (finishing.isCompleting()) {
                return "Completing";
            }
            return "Active";
        } else if (obj instanceof Incomplete) {
            if (((Incomplete) obj).isActive()) {
                return "Active";
            }
            return "New";
        } else if (obj instanceof CompletedExceptionally) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
        } else {
            return "Completed";
        }
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th2, String str, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                str = null;
            }
            return jobSupport.k(th2, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean tryFinalizeSimpleState(Incomplete incomplete, Object obj) {
        if (!a.a(_state$FU, this, incomplete, JobSupportKt.boxIncomplete(obj))) {
            return false;
        }
        h((Throwable) null);
        i(obj);
        completeStateFinalization(incomplete, obj);
        return true;
    }

    private final boolean tryMakeCancelling(Incomplete incomplete, Throwable th2) {
        NodeList orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
        if (orPromoteCancellingList == null) {
            return false;
        }
        if (!a.a(_state$FU, this, incomplete, new Finishing(orPromoteCancellingList, false, th2))) {
            return false;
        }
        notifyCancelling(orPromoteCancellingList, th2);
        return true;
    }

    private final Object tryMakeCompleting(Object obj, Object obj2) {
        if (!(obj instanceof Incomplete)) {
            return JobSupportKt.COMPLETING_ALREADY;
        }
        if ((!(obj instanceof Empty) && !(obj instanceof JobNode)) || (obj instanceof ChildHandleNode) || (obj2 instanceof CompletedExceptionally)) {
            return tryMakeCompletingSlowPath((Incomplete) obj, obj2);
        }
        if (tryFinalizeSimpleState((Incomplete) obj, obj2)) {
            return obj2;
        }
        return JobSupportKt.COMPLETING_RETRY;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
        if (r2 == null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0070, code lost:
        notifyCancelling(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0073, code lost:
        r9 = firstChild(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0077, code lost:
        if (r9 == null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007d, code lost:
        if (tryWaitForChild(r1, r9, r10) == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0081, code lost:
        return kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0086, code lost:
        return finalizeFinishingState(r1, r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object tryMakeCompletingSlowPath(kotlinx.coroutines.Incomplete r9, java.lang.Object r10) {
        /*
            r8 = this;
            kotlinx.coroutines.NodeList r0 = r8.getOrPromoteCancellingList(r9)
            if (r0 != 0) goto L_0x000b
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.JobSupportKt.COMPLETING_RETRY
            return r9
        L_0x000b:
            boolean r1 = r9 instanceof kotlinx.coroutines.JobSupport.Finishing
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = r9
            kotlinx.coroutines.JobSupport$Finishing r1 = (kotlinx.coroutines.JobSupport.Finishing) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            r3 = 0
            if (r1 != 0) goto L_0x001d
            kotlinx.coroutines.JobSupport$Finishing r1 = new kotlinx.coroutines.JobSupport$Finishing
            r1.<init>(r0, r3, r2)
        L_0x001d:
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            monitor-enter(r1)
            boolean r5 = r1.isCompleting()     // Catch:{ all -> 0x0087 }
            if (r5 == 0) goto L_0x002f
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY     // Catch:{ all -> 0x0087 }
            monitor-exit(r1)
            return r9
        L_0x002f:
            r5 = 1
            r1.setCompleting(r5)     // Catch:{ all -> 0x0087 }
            if (r1 == r9) goto L_0x0043
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = _state$FU     // Catch:{ all -> 0x0087 }
            boolean r6 = v0.a.a(r6, r8, r9, r1)     // Catch:{ all -> 0x0087 }
            if (r6 != 0) goto L_0x0043
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.JobSupportKt.COMPLETING_RETRY     // Catch:{ all -> 0x0087 }
            monitor-exit(r1)
            return r9
        L_0x0043:
            boolean r6 = r1.isCancelling()     // Catch:{ all -> 0x0087 }
            boolean r7 = r10 instanceof kotlinx.coroutines.CompletedExceptionally     // Catch:{ all -> 0x0087 }
            if (r7 == 0) goto L_0x004f
            r7 = r10
            kotlinx.coroutines.CompletedExceptionally r7 = (kotlinx.coroutines.CompletedExceptionally) r7     // Catch:{ all -> 0x0087 }
            goto L_0x0050
        L_0x004f:
            r7 = r2
        L_0x0050:
            if (r7 == 0) goto L_0x0057
            java.lang.Throwable r7 = r7.cause     // Catch:{ all -> 0x0087 }
            r1.addExceptionLocked(r7)     // Catch:{ all -> 0x0087 }
        L_0x0057:
            java.lang.Throwable r7 = r1.getRootCause()     // Catch:{ all -> 0x0087 }
            if (r6 != 0) goto L_0x005e
            r3 = r5
        L_0x005e:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0087 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0087 }
            if (r3 == 0) goto L_0x0069
            r2 = r7
        L_0x0069:
            r4.element = r2     // Catch:{ all -> 0x0087 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0087 }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x0073
            r8.notifyCancelling(r0, r2)
        L_0x0073:
            kotlinx.coroutines.ChildHandleNode r9 = r8.firstChild(r9)
            if (r9 == 0) goto L_0x0082
            boolean r9 = r8.tryWaitForChild(r1, r9, r10)
            if (r9 == 0) goto L_0x0082
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN
            return r9
        L_0x0082:
            java.lang.Object r9 = r8.finalizeFinishingState(r1, r10)
            return r9
        L_0x0087:
            r9 = move-exception
            monitor-exit(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.tryMakeCompletingSlowPath(kotlinx.coroutines.Incomplete, java.lang.Object):java.lang.Object");
    }

    private final boolean tryWaitForChild(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (Job.DefaultImpls.invokeOnCompletion$default(childHandleNode.childJob, false, false, new ChildCompletion(this, finishing, childHandleNode, obj), 1, (Object) null) == NonDisposableHandle.INSTANCE) {
            childHandleNode = nextChild(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    public void a(@Nullable Object obj) {
    }

    @NotNull
    public final ChildHandle attachChild(@NotNull ChildJob childJob) {
        return (ChildHandle) Job.DefaultImpls.invokeOnCompletion$default(this, true, false, new ChildHandleNode(childJob), 2, (Object) null);
    }

    @Nullable
    public final Object awaitInternal$kotlinx_coroutines_core(@NotNull Continuation<Object> continuation) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                    return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
                }
                throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return awaitSuspend(continuation);
    }

    @NotNull
    public String b() {
        return "Job was cancelled";
    }

    @Nullable
    public final Throwable c() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Throwable rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
            if (rootCause != null) {
                return rootCause;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else {
            return null;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    public final boolean cancelCoroutine(@Nullable Throwable th2) {
        return cancelImpl$kotlinx_coroutines_core(th2);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(@Nullable Object obj) {
        Object access$getCOMPLETING_ALREADY$p = JobSupportKt.COMPLETING_ALREADY;
        if (getOnCancelComplete$kotlinx_coroutines_core() && (access$getCOMPLETING_ALREADY$p = cancelMakeCompleting(obj)) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        if (access$getCOMPLETING_ALREADY$p == JobSupportKt.COMPLETING_ALREADY) {
            access$getCOMPLETING_ALREADY$p = makeCancelling(obj);
        }
        if (access$getCOMPLETING_ALREADY$p == JobSupportKt.COMPLETING_ALREADY || access$getCOMPLETING_ALREADY$p == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        if (access$getCOMPLETING_ALREADY$p == JobSupportKt.TOO_LATE_TO_CANCEL) {
            return false;
        }
        a(access$getCOMPLETING_ALREADY$p);
        return true;
    }

    public void cancelInternal(@NotNull Throwable th2) {
        cancelImpl$kotlinx_coroutines_core(th2);
    }

    public boolean childCancelled(@NotNull Throwable th2) {
        if (th2 instanceof CancellationException) {
            return true;
        }
        if (!cancelImpl$kotlinx_coroutines_core(th2) || !getHandlesException$kotlinx_coroutines_core()) {
            return false;
        }
        return true;
    }

    public final boolean d() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof CompletedExceptionally) && ((CompletedExceptionally) state$kotlinx_coroutines_core).getHandled();
    }

    @NotNull
    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(@Nullable String str, @Nullable Throwable th2) {
        if (str == null) {
            str = b();
        }
        return new JobCancellationException(str, th2, this);
    }

    public boolean e(@NotNull Throwable th2) {
        return false;
    }

    public final void f(@Nullable Job job) {
        if (job == null) {
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }
        job.start();
        ChildHandle attachChild = job.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(attachChild);
        if (isCompleted()) {
            attachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    public <R> R fold(R r11, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return Job.DefaultImpls.fold(this, r11, function2);
    }

    public boolean g() {
        return false;
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return Job.DefaultImpls.get(this, key);
    }

    @NotNull
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Throwable rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
            if (rootCause != null) {
                CancellationException k11 = k(rootCause, DebugStringsKt.getClassSimpleName(this) + " is cancelling");
                if (k11 != null) {
                    return k11;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return toCancellationException$default(this, ((CompletedExceptionally) state$kotlinx_coroutines_core).cause, (String) null, 1, (Object) null);
        } else {
            return new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " has completed normally", (Throwable) null, this);
        }
    }

    @NotNull
    public CancellationException getChildJobCancellationCause() {
        Throwable th2;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        CancellationException cancellationException = null;
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            th2 = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            th2 = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            th2 = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + state$kotlinx_coroutines_core).toString());
        }
        if (th2 instanceof CancellationException) {
            cancellationException = (CancellationException) th2;
        }
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + stateString(state$kotlinx_coroutines_core), th2, this);
    }

    @NotNull
    public final Sequence<Job> getChildren() {
        return SequencesKt__SequenceBuilderKt.sequence(new JobSupport$children$1(this, (Continuation<? super JobSupport$children$1>) null));
    }

    @Nullable
    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(!(state$kotlinx_coroutines_core instanceof Incomplete))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        } else if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
            return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
        } else {
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
    }

    @Nullable
    public final Throwable getCompletionExceptionOrNull() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            return getExceptionOrNull(state$kotlinx_coroutines_core);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @NotNull
    public final CoroutineContext.Key<?> getKey() {
        return Job.Key;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @NotNull
    public final SelectClause0 getOnJoin() {
        return this;
    }

    @Nullable
    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle) this._parentHandle;
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public void h(@Nullable Throwable th2) {
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable th2) {
        throw th2;
    }

    public void i(@Nullable Object obj) {
    }

    @NotNull
    public final DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> function1) {
        return invokeOnCompletion(false, true, function1);
    }

    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Incomplete) || !((Incomplete) state$kotlinx_coroutines_core).isActive()) {
            return false;
        }
        return true;
    }

    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if ((state$kotlinx_coroutines_core instanceof CompletedExceptionally) || ((state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).isCancelling())) {
            return true;
        }
        return false;
    }

    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    public void j() {
    }

    @Nullable
    public final Object join(@NotNull Continuation<? super Unit> continuation) {
        if (!joinInternal()) {
            JobKt.ensureActive(continuation.getContext());
            return Unit.INSTANCE;
        }
        Object joinSuspend = joinSuspend(continuation);
        if (joinSuspend == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return joinSuspend;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final CancellationException k(@NotNull Throwable th2, @Nullable String str) {
        CancellationException cancellationException;
        if (th2 instanceof CancellationException) {
            cancellationException = (CancellationException) th2;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            if (str == null) {
                str = b();
            }
            cancellationException = new JobCancellationException(str, th2, this);
        }
        return cancellationException;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(@Nullable Object obj) {
        Object tryMakeCompleting;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (tryMakeCompleting == JobSupportKt.COMPLETING_ALREADY) {
                return false;
            }
            if (tryMakeCompleting == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        } while (tryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        a(tryMakeCompleting);
        return true;
    }

    @Nullable
    public final Object makeCompletingOnce$kotlinx_coroutines_core(@Nullable Object obj) {
        Object tryMakeCompleting;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (tryMakeCompleting == JobSupportKt.COMPLETING_ALREADY) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, getExceptionOrNull(obj));
            }
        } while (tryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        return tryMakeCompleting;
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.minusKey(this, key);
    }

    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    public final void parentCancelled(@NotNull ParentJob parentJob) {
        cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return Job.DefaultImpls.plus((Job) this, coroutineContext);
    }

    public final <R> void registerSelectClause0(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!selectInstance.isSelected()) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    if (selectInstance.trySelect()) {
                        UndispatchedKt.startCoroutineUnintercepted(function1, selectInstance.getCompletion());
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        selectInstance.disposeOnSelect(invokeOnCompletion(new SelectJoinOnCompletion(selectInstance, function1)));
    }

    public final <T, R> void registerSelectClause1Internal$kotlinx_coroutines_core(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!selectInstance.isSelected()) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    if (!selectInstance.trySelect()) {
                        return;
                    }
                    if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                        selectInstance.resumeSelectWithException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause);
                        return;
                    } else {
                        UndispatchedKt.startCoroutineUnintercepted(function2, JobSupportKt.unboxState(state$kotlinx_coroutines_core), selectInstance.getCompletion());
                        return;
                    }
                }
            } else {
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        selectInstance.disposeOnSelect(invokeOnCompletion(new SelectAwaitOnCompletion(selectInstance, function2)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void removeNode$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull kotlinx.coroutines.JobNode r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.getState$kotlinx_coroutines_core()
            boolean r1 = r0 instanceof kotlinx.coroutines.JobNode
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = _state$FU
            kotlinx.coroutines.Empty r2 = kotlinx.coroutines.JobSupportKt.EMPTY_ACTIVE
            boolean r0 = v0.a.a(r1, r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r1 = r0 instanceof kotlinx.coroutines.Incomplete
            if (r1 == 0) goto L_0x0027
            kotlinx.coroutines.Incomplete r0 = (kotlinx.coroutines.Incomplete) r0
            kotlinx.coroutines.NodeList r0 = r0.getList()
            if (r0 == 0) goto L_0x0027
            r4.remove()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.removeNode$kotlinx_coroutines_core(kotlinx.coroutines.JobNode):void");
    }

    public final <T, R> void selectAwaitCompletion$kotlinx_coroutines_core(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            selectInstance.resumeSelectWithException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause);
            return;
        }
        CancellableKt.startCoroutineCancellable$default(function2, JobSupportKt.unboxState(state$kotlinx_coroutines_core), selectInstance.getCompletion(), (Function1) null, 4, (Object) null);
    }

    public final void setParentHandle$kotlinx_coroutines_core(@Nullable ChildHandle childHandle) {
        this._parentHandle = childHandle;
    }

    public final boolean start() {
        int startInternal;
        do {
            startInternal = startInternal(getState$kotlinx_coroutines_core());
            if (startInternal == 0) {
                return false;
            }
        } while (startInternal != 1);
        return true;
    }

    @NotNull
    @InternalCoroutinesApi
    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + AbstractJsonLexerKt.BEGIN_OBJ + stateString(getState$kotlinx_coroutines_core()) + AbstractJsonLexerKt.END_OBJ;
    }

    @NotNull
    public String toString() {
        return toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable th2) {
        Throwable th3;
        if (th2 == null || (th3 = toCancellationException$default(this, th2, (String) null, 1, (Object) null)) == null) {
            th3 = new JobCancellationException(b(), (Throwable) null, this);
        }
        cancelInternal(th3);
        return true;
    }

    @NotNull
    public final DisposableHandle invokeOnCompletion(boolean z11, boolean z12, @NotNull Function1<? super Throwable, Unit> function1) {
        JobNode makeNode = makeNode(function1, z11);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (!empty.isActive()) {
                    promoteEmptyToNodeList(empty);
                } else if (a.a(_state$FU, this, state$kotlinx_coroutines_core, makeNode)) {
                    return makeNode;
                }
            } else {
                Throwable th2 = null;
                if (state$kotlinx_coroutines_core instanceof Incomplete) {
                    NodeList list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                    if (list != null) {
                        DisposableHandle disposableHandle = NonDisposableHandle.INSTANCE;
                        if (z11 && (state$kotlinx_coroutines_core instanceof Finishing)) {
                            synchronized (state$kotlinx_coroutines_core) {
                                th2 = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
                                if (th2 == null || ((function1 instanceof ChildHandleNode) && !((Finishing) state$kotlinx_coroutines_core).isCompleting())) {
                                    if (addLastAtomic(state$kotlinx_coroutines_core, list, makeNode)) {
                                        if (th2 == null) {
                                            return makeNode;
                                        }
                                        disposableHandle = makeNode;
                                    }
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                        if (th2 != null) {
                            if (z12) {
                                function1.invoke(th2);
                            }
                            return disposableHandle;
                        } else if (addLastAtomic(state$kotlinx_coroutines_core, list, makeNode)) {
                            return makeNode;
                        }
                    } else if (state$kotlinx_coroutines_core != null) {
                        promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                } else {
                    if (z12) {
                        CompletedExceptionally completedExceptionally = state$kotlinx_coroutines_core instanceof CompletedExceptionally ? (CompletedExceptionally) state$kotlinx_coroutines_core : null;
                        if (completedExceptionally != null) {
                            th2 = completedExceptionally.cause;
                        }
                        function1.invoke(th2);
                    }
                    return NonDisposableHandle.INSTANCE;
                }
            }
        }
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job plus(@NotNull Job job) {
        return Job.DefaultImpls.plus((Job) this, job);
    }

    public void cancel(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(b(), (Throwable) null, this);
        }
        cancelInternal(cancellationException);
    }
}
