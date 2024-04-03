package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import com.talabat.helpers.GlobalConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ú\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\b7\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b)\b\u0000\u0018\u00002\u00020\u0001:\u0004ä\u0002å\u0002Bí\u0001\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012Y\u0010\u000b\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f\u0012Y\u0010\u0016\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\t\u0010\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u0001\u001a\u00020\u0014H\u0002JK\u0010\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010\u0001\"\u0005\b\u0001\u0010\u00012\b\u0010\u0001\u001a\u0003H\u00012\"\u0010\u0001\u001a\u001d\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u0003H\u0001\u0012\u0004\u0012\u00020\u00140\u0001¢\u0006\u0003\b\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0005H\u0016J5\u0010\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u0007\u0010\u0001\u001a\u00020!2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010 \u0001H\bø\u0001\u0000¢\u0006\u0003\u0010¡\u0001J\u0014\u0010¢\u0001\u001a\u00020!2\t\u0010\u0001\u001a\u0004\u0018\u00010CH\u0017J\u0012\u0010¢\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020!H\u0017J\u0013\u0010¢\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030£\u0001H\u0017J\u0013\u0010¢\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030¤\u0001H\u0017J\u0013\u0010¢\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030¥\u0001H\u0017J\u0013\u0010¢\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030¦\u0001H\u0017J\u0012\u0010¢\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020%H\u0017J\u0013\u0010¢\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030§\u0001H\u0017J\u0013\u0010¢\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030¨\u0001H\u0017J\u000f\u0010©\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\bª\u0001J\t\u0010«\u0001\u001a\u00020\u0014H\u0002J\t\u0010¬\u0001\u001a\u00020\u0014H\u0002J\t\u0010­\u0001\u001a\u00020\u0014H\u0016JG\u0010®\u0001\u001a\u00020\u00142\u001d\u0010¯\u0001\u001a\u0018\u0012\u0004\u0012\u000206\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020C\u0018\u00010±\u00010°\u00012\u0014\u0010²\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u00140 \u0001¢\u0006\u0003\b³\u0001H\u0000¢\u0006\u0006\b´\u0001\u0010µ\u0001J$\u0010¶\u0001\u001a\u00020%2\u0007\u0010·\u0001\u001a\u00020%2\u0007\u0010¸\u0001\u001a\u00020%2\u0007\u0010¹\u0001\u001a\u00020%H\u0002J'\u0010º\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u000e\u0010»\u0001\u001a\t\u0012\u0005\u0012\u0003H\u00010lH\u0017¢\u0006\u0003\u0010¼\u0001J\t\u0010½\u0001\u001a\u00020\u0014H\u0002J!\u0010¾\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010\u00012\u000f\u0010¿\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010 \u0001H\u0016J<\u0010À\u0001\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`n2\u000b\b\u0002\u0010·\u0001\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0003\u0010Á\u0001J\u0012\u0010Â\u0001\u001a\u00020\u00142\u0007\u0010¢\u0001\u001a\u00020!H\u0017J\t\u0010Ã\u0001\u001a\u00020\u0014H\u0016J\u000f\u0010Ä\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\bÅ\u0001JF\u0010Æ\u0001\u001a\u00020\u00142\u001d\u0010¯\u0001\u001a\u0018\u0012\u0004\u0012\u000206\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020C\u0018\u00010±\u00010°\u00012\u0016\u0010²\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0018\u00010 \u0001¢\u0006\u0003\b³\u0001H\u0002¢\u0006\u0003\u0010µ\u0001J\u001b\u0010Ç\u0001\u001a\u00020\u00142\u0007\u0010·\u0001\u001a\u00020%2\u0007\u0010È\u0001\u001a\u00020%H\u0002J\t\u0010É\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010Ê\u0001\u001a\u00020\u00142\u0007\u0010Ë\u0001\u001a\u00020!H\u0002J\t\u0010Ì\u0001\u001a\u00020\u0014H\u0017J\t\u0010Í\u0001\u001a\u00020\u0014H\u0002J\t\u0010Î\u0001\u001a\u00020\u0014H\u0017J\t\u0010Ï\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ð\u0001\u001a\u00020\u0014H\u0017J\t\u0010Ñ\u0001\u001a\u00020\u0014H\u0017J\f\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001H\u0017J\t\u0010Ô\u0001\u001a\u00020\u0014H\u0016J\t\u0010Õ\u0001\u001a\u00020\u0014H\u0002J\t\u0010Ö\u0001\u001a\u00020\u0014H\u0002J\u001d\u0010×\u0001\u001a\u00020\u00142\u0007\u0010Ë\u0001\u001a\u00020!2\t\u0010Ø\u0001\u001a\u0004\u0018\u00010pH\u0002J\u001a\u0010Ù\u0001\u001a\u00020\u00142\u0007\u0010Ú\u0001\u001a\u00020%2\u0006\u0010X\u001a\u00020!H\u0002J\t\u0010Û\u0001\u001a\u00020\u0014H\u0002J\u000e\u0010F\u001a\u00020!H\u0000¢\u0006\u0003\bÜ\u0001J\"\u0010Ý\u0001\u001a\u00020\u00142\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030Þ\u00012\t\u0010ß\u0001\u001a\u0004\u0018\u00010CH\u0017J*\u0010à\u0001\u001a\u00020\u00142\u001f\u0010á\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030ä\u0001\u0012\u0007\u0012\u0005\u0018\u00010ä\u00010ã\u00010â\u0001H\u0002J*\u0010å\u0001\u001a\u00020\u00142\u001f\u0010á\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030ä\u0001\u0012\u0007\u0012\u0005\u0018\u00010ä\u00010ã\u00010â\u0001H\u0017J\u0012\u0010æ\u0001\u001a\u00020%2\u0007\u0010ç\u0001\u001a\u00020%H\u0002JX\u0010è\u0001\u001a\u00020\u00142\u0010\u0010²\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010C0Þ\u00012'\u0010é\u0001\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`n2\t\u0010ß\u0001\u001a\u0004\u0018\u00010C2\u0007\u0010ê\u0001\u001a\u00020!H\u0002J\u001f\u0010ë\u0001\u001a\u00020C2\t\u0010ì\u0001\u001a\u0004\u0018\u00010C2\t\u0010í\u0001\u001a\u0004\u0018\u00010CH\u0017J\u000b\u0010î\u0001\u001a\u0004\u0018\u00010CH\u0001J-\u0010ï\u0001\u001a\u00020%2\u0007\u0010ð\u0001\u001a\u00020%2\u0007\u0010·\u0001\u001a\u00020%2\u0007\u0010¸\u0001\u001a\u00020%2\u0007\u0010ñ\u0001\u001a\u00020%H\u0002J\u000f\u0010ò\u0001\u001a\u00020%H\u0000¢\u0006\u0003\bó\u0001J\u001f\u0010ô\u0001\u001a\u00020\u00142\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140 \u0001H\u0000¢\u0006\u0003\bõ\u0001J\t\u0010ö\u0001\u001a\u00020\u0014H\u0002J!\u0010ö\u0001\u001a\u00020\u00142\u0010\u0010÷\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010C0ø\u0001H\u0002¢\u0006\u0003\u0010ù\u0001J\t\u0010ú\u0001\u001a\u00020\u0014H\u0002J\u0014\u0010û\u0001\u001a\u00020\u00142\t\b\u0002\u0010ü\u0001\u001a\u00020!H\u0002J\t\u0010ý\u0001\u001a\u00020\u0014H\u0002J.\u0010þ\u0001\u001a\u00020!2\u001d\u0010¯\u0001\u001a\u0018\u0012\u0004\u0012\u000206\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020C\u0018\u00010±\u00010°\u0001H\u0000¢\u0006\u0003\bÿ\u0001Jv\u0010\u0002\u001a\u0003H\u0002\"\u0005\b\u0000\u0010\u00022\u000b\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010ç\u0001\u001a\u0004\u0018\u00010%2%\b\u0002\u0010\\\u001a\u001f\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u000206\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020C\u0018\u00010±\u00010ã\u00010â\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00020 \u0001H\u0002¢\u0006\u0003\u0010\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J\u0014\u0010\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010CH\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\u0012\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020PH\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J$\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%H\u0002J\u0012\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020%H\u0002J\u001a\u0010\u0002\u001a\u00020\u00142\u0006\u0010h\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%H\u0002J\u0019\u0010\u0002\u001a\u00020\u00142\u000e\u0010\u0002\u001a\t\u0012\u0004\u0012\u00020\u00140 \u0001H\u0016J\t\u0010\u0002\u001a\u00020\u0014H\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002Jj\u0010\u0002\u001a\u00020\u00142\t\b\u0002\u0010ü\u0001\u001a\u00020!2T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J$\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%H\u0002J\u0012\u0010 \u0002\u001a\u00020\u00142\u0007\u0010¡\u0002\u001a\u00020~H\u0016J\t\u0010¢\u0002\u001a\u00020\u0014H\u0002J\u001b\u0010£\u0002\u001a\u00020\u00142\b\u0010¤\u0002\u001a\u00030ä\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000b\u0010¥\u0002\u001a\u0004\u0018\u00010CH\u0016J\t\u0010¦\u0002\u001a\u00020\u0014H\u0002J\u0012\u0010§\u0002\u001a\u00020\u00142\u0007\u0010¨\u0002\u001a\u00020%H\u0002JP\u0010©\u0002\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u000e\u0010»\u0001\u001a\t\u0012\u0005\u0012\u0003H\u00010l2'\u0010¡\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`nH\u0002¢\u0006\u0003\u0010ª\u0002J\t\u0010«\u0002\u001a\u00020\u0014H\u0017J\t\u0010¬\u0002\u001a\u00020\u0014H\u0002J\t\u0010­\u0002\u001a\u00020\u0014H\u0002J\t\u0010®\u0002\u001a\u00020\u0014H\u0017J\u0013\u0010¯\u0002\u001a\u00020\u00142\b\u0010¯\u0002\u001a\u00030°\u0002H\u0017J\t\u0010±\u0002\u001a\u00020\u0014H\u0017J\u001c\u0010²\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%2\b\u0010¯\u0002\u001a\u00030°\u0002H\u0017J1\u0010³\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%2\t\u0010´\u0002\u001a\u0004\u0018\u00010C2\u0007\u0010Ë\u0001\u001a\u00020!2\t\u0010µ\u0002\u001a\u0004\u0018\u00010CH\u0002J\t\u0010¶\u0002\u001a\u00020\u0014H\u0017J\u0012\u0010·\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%H\u0002J\u001d\u0010·\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%2\t\u0010¸\u0002\u001a\u0004\u0018\u00010CH\u0002J\u001d\u0010¹\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%2\t\u0010¸\u0002\u001a\u0004\u0018\u00010CH\u0017J\t\u0010º\u0002\u001a\u00020\u0014H\u0016J&\u0010»\u0002\u001a\u00020\u00142\u0015\u0010¼\u0002\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030½\u00020ø\u0001H\u0017¢\u0006\u0003\u0010¾\u0002J\u001d\u0010¿\u0002\u001a\u00020\u00142\u0007\u0010Ë\u0001\u001a\u00020!2\t\u0010µ\u0002\u001a\u0004\u0018\u00010CH\u0002J\u0012\u0010À\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%H\u0017J\u0012\u0010Á\u0002\u001a\u00020\u00012\u0007\u0010»\u0001\u001a\u00020%H\u0017J\u001d\u0010Â\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%2\t\u0010¸\u0002\u001a\u0004\u0018\u00010CH\u0016J\t\u0010Ã\u0002\u001a\u00020\u0014H\u0016J\t\u0010Ä\u0002\u001a\u00020\u0014H\u0002J#\u0010Å\u0002\u001a\u00020!2\u0007\u0010¡\u0002\u001a\u0002062\t\u0010Æ\u0002\u001a\u0004\u0018\u00010CH\u0000¢\u0006\u0003\bÇ\u0002J\u0014\u0010È\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010CH\u0001J(\u0010É\u0002\u001a\u00020\u00142\u0007\u0010Ê\u0002\u001a\u00020%2\t\u0010¸\u0002\u001a\u0004\u0018\u00010C2\t\u0010µ\u0002\u001a\u0004\u0018\u00010CH\u0002J\u0012\u0010Ë\u0002\u001a\u00020\u00142\u0007\u0010Ì\u0002\u001a\u00020%H\u0002J(\u0010Í\u0002\u001a\u00020\u00142\u0007\u0010Ê\u0002\u001a\u00020%2\t\u0010¸\u0002\u001a\u0004\u0018\u00010C2\t\u0010µ\u0002\u001a\u0004\u0018\u00010CH\u0002J\u0012\u0010Î\u0002\u001a\u00020\u00142\u0007\u0010Ê\u0002\u001a\u00020%H\u0002J\u001b\u0010Ï\u0002\u001a\u00020\u00142\u0007\u0010·\u0001\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%H\u0002J\u001b\u0010Ð\u0002\u001a\u00020\u00142\u0007\u0010·\u0001\u001a\u00020%2\u0007\u0010Ñ\u0002\u001a\u00020%H\u0002J{\u0010Ò\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`n2'\u0010Ó\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`n2'\u0010Ô\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`nH\u0002J\u0014\u0010Õ\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010CH\u0016J\u0014\u0010Ö\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010CH\u0001J\u0012\u0010×\u0002\u001a\u00020%2\u0007\u0010·\u0001\u001a\u00020%H\u0002J\t\u0010Ø\u0002\u001a\u00020\u0014H\u0016J\t\u0010Ù\u0002\u001a\u00020\u0014H\u0002J\t\u0010Ú\u0002\u001a\u00020\u0014H\u0002J\u000f\u0010Û\u0002\u001a\u00020\u0014H\u0000¢\u0006\u0003\bÜ\u0002J\u0001\u0010Ý\u0002\u001a\u0003H\u0002\"\u0005\b\u0000\u0010\u00022Z\u0010Þ\u0002\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00020 \u0001H\b¢\u0006\u0003\u0010ß\u0002J1\u0010à\u0002\u001a\u0003H\u0002\"\u0005\b\u0000\u0010\u00022\u0006\u0010{\u001a\u00020|2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00020 \u0001H\b¢\u0006\u0003\u0010á\u0002J\u0016\u0010â\u0002\u001a\u00020%*\u00020|2\u0007\u0010·\u0001\u001a\u00020%H\u0002J\u0018\u0010ã\u0002\u001a\u0004\u0018\u00010C*\u00020|2\u0007\u0010ç\u0001\u001a\u00020%H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8@X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8@X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'Ra\u0010\u000b\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R&\u00101\u001a\u00020%2\u0006\u00100\u001a\u00020%8\u0016@RX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b2\u00103\u001a\u0004\b4\u0010'R\u0016\u00105\u001a\u0004\u0018\u0001068@X\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u00020!8VX\u0004¢\u0006\f\u0012\u0004\b:\u00103\u001a\u0004\b;\u0010#Ro\u0010<\u001aW\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010J\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\bK\u0010#R\u0014\u0010L\u001a\u00020!8@X\u0004¢\u0006\u0006\u001a\u0004\bM\u0010#R\u000e\u0010N\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u000e¢\u0006\u0002\n\u0000Ra\u0010Q\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VRa\u0010W\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150BX\u0004¢\u0006\u0002\n\u0000R&\u0010X\u001a\u00020!2\u0006\u00100\u001a\u00020!8\u0016@RX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\bY\u00103\u001a\u0004\bZ\u0010#R\u0014\u0010[\u001a\b\u0012\u0004\u0012\u0002060BX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010^\u001a\u00020!2\u0006\u00100\u001a\u00020!@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b_\u0010#R\u001e\u0010`\u001a\u00020!2\u0006\u00100\u001a\u00020!@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\ba\u0010#Ra\u0010\u0016\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u0002\n\u0000R.\u0010d\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010ej\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u0001`fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R.\u0010j\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u0004\u0018\u00010pX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010p0BX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R2\u0010w\u001a&\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m\u0018\u00010kj\u0004\u0018\u0001`nX\u000e¢\u0006\u0002\n\u0000Rj\u0010x\u001a^\u0012\u0004\u0012\u00020%\u0012$\u0012\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`n0ej.\u0012\u0004\u0012\u00020%\u0012$\u0012\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`n`fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020EX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020|X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010}\u001a\u0004\u0018\u00010~8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0010\u0001R\u0019\u0010\u0001\u001a\u0004\u0018\u00010C8VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u000f\u0010\u0001\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u00020!8VX\u0004¢\u0006\u000e\u0012\u0005\b\u0001\u00103\u001a\u0005\b\u0001\u0010#R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020EX\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u0004\u0018\u00010C*\u00020|8BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006æ\u0002"}, d2 = {"Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/Composer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "lateChanges", "composition", "Landroidx/compose/runtime/ControlledComposition;", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/SlotTable;Ljava/util/Set;Ljava/util/List;Ljava/util/List;Landroidx/compose/runtime/ControlledComposition;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "areChildrenComposing", "", "getAreChildrenComposing$runtime_release", "()Z", "changeCount", "", "getChangeCount$runtime_release", "()I", "childrenComposing", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compositionToken", "<set-?>", "compoundKeyHash", "getCompoundKeyHash$annotations", "()V", "getCompoundKeyHash", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getCurrentRecomposeScope$runtime_release", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "defaultsInvalid", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "deferredChanges", "getDeferredChanges$runtime_release", "()Ljava/util/List;", "setDeferredChanges$runtime_release", "(Ljava/util/List;)V", "downNodes", "Landroidx/compose/runtime/Stack;", "", "entersStack", "Landroidx/compose/runtime/IntStack;", "forceRecomposeScopes", "forciblyRecompose", "groupNodeCount", "groupNodeCountStack", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges$runtime_release", "implicitRootStart", "insertAnchor", "Landroidx/compose/runtime/Anchor;", "insertFixups", "insertTable", "getInsertTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "setInsertTable$runtime_release", "(Landroidx/compose/runtime/SlotTable;)V", "insertUpFixups", "inserting", "getInserting$annotations", "getInserting", "invalidateStack", "invalidations", "Landroidx/compose/runtime/Invalidation;", "isComposing", "isComposing$runtime_release", "isDisposed", "isDisposed$runtime_release", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "nodeExpected", "nodeIndex", "nodeIndexStack", "parentProvider", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "pending", "Landroidx/compose/runtime/Pending;", "pendingStack", "pendingUps", "previousCount", "previousMoveFrom", "previousMoveTo", "previousRemove", "providerCache", "providerUpdates", "providersInvalid", "providersInvalidStack", "reader", "Landroidx/compose/runtime/SlotReader;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "reusing", "reusingGroup", "skipping", "getSkipping$annotations", "getSkipping", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "startedGroup", "startedGroups", "writer", "writerHasAProvider", "writersReaderDelta", "node", "getNode", "(Landroidx/compose/runtime/SlotReader;)Ljava/lang/Object;", "abortRoot", "addRecomposeScope", "apply", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "cache", "invalid", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "changed", "", "", "", "", "", "", "changesApplied", "changesApplied$runtime_release", "cleanUpCompose", "clearUpdatedNodeCounts", "collectParameterInformation", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "content", "Landroidx/compose/runtime/Composable;", "composeContent$runtime_release", "(Landroidx/compose/runtime/collection/IdentityArrayMap;Lkotlin/jvm/functions/Function2;)V", "compoundKeyOf", "group", "recomposeGroup", "recomposeKey", "consume", "key", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createFreshInsertTable", "createNode", "factory", "currentCompositionLocalScope", "(Ljava/lang/Integer;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "deactivateToEndGroup", "disableReusing", "dispose", "dispose$runtime_release", "doCompose", "doRecordDownsFor", "nearestCommonRoot", "enableReusing", "end", "isNode", "endDefaults", "endGroup", "endMovableGroup", "endNode", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "endRoot", "ensureWriter", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", "finalizeCompose", "forceRecomposeScopes$runtime_release", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentGuarded", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContentReferences", "insertedGroupVirtualIndex", "index", "invokeMovableContentLambda", "locals", "force", "joinKey", "left", "right", "nextSlot", "nodeIndexOf", "groupLocation", "recomposeIndex", "parentKey", "parentKey$runtime_release", "prepareCompose", "prepareCompose$runtime_release", "realizeDowns", "nodes", "", "([Ljava/lang/Object;)V", "realizeMovement", "realizeOperationLocation", "forParent", "realizeUps", "recompose", "recompose$runtime_release", "recomposeMovableContent", "R", "from", "to", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recomposeToGroupEnd", "record", "change", "recordApplierOperation", "recordDelete", "recordDown", "recordEndGroup", "recordEndRoot", "recordFixup", "recordInsert", "anchor", "recordInsertUpFixup", "recordMoveNode", "count", "recordReaderMoving", "location", "recordRemoveNode", "recordSideEffect", "effect", "recordSlotEditing", "recordSlotEditingOperation", "recordSlotTableOperation", "recordUp", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "recordUsed", "scope", "registerInsertUpFixup", "releaseMovableGroupAtCurrent", "reference", "rememberedValue", "reportAllMovableContent", "reportFreeMovableContent", "groupBeingRemoved", "resolveCompositionLocal", "(Landroidx/compose/runtime/CompositionLocal;Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)Ljava/lang/Object;", "skipCurrentGroup", "skipGroup", "skipReaderToGroupEnd", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "start", "objectKey", "data", "startDefaults", "startGroup", "dataKey", "startMovableGroup", "startNode", "startProviders", "values", "Landroidx/compose/runtime/ProvidedValue;", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReaderGroup", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "startRoot", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime_release", "updateCachedValue", "updateCompoundKeyWhenWeEnterGroup", "groupKey", "updateCompoundKeyWhenWeEnterGroupKeyHash", "keyHash", "updateCompoundKeyWhenWeExitGroup", "updateCompoundKeyWhenWeExitGroupKeyHash", "updateNodeCount", "updateNodeCountOverrides", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateRememberedValue", "updateValue", "updatedNodeCount", "useNode", "validateNodeExpected", "validateNodeNotExpected", "verifyConsistent", "verifyConsistent$runtime_release", "withChanges", "newChanges", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withReader", "(Landroidx/compose/runtime/SlotReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "groupCompoundKeyPart", "nodeAt", "CompositionContextHolder", "CompositionContextImpl", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ComposerImpl implements Composer {
    @NotNull
    private final Set<RememberObserver> abandonSet;
    @NotNull
    private final Applier<?> applier;
    /* access modifiers changed from: private */
    @NotNull
    public List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    /* access modifiers changed from: private */
    public int childrenComposing;
    @NotNull
    private final ControlledComposition composition;
    private int compositionToken;
    private int compoundKeyHash;
    @Nullable
    private List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> deferredChanges;
    @NotNull
    private Stack<Object> downNodes;
    @NotNull
    private final IntStack entersStack = new IntStack();
    private boolean forceRecomposeScopes;
    /* access modifiers changed from: private */
    public boolean forciblyRecompose;
    private int groupNodeCount;
    @NotNull
    private IntStack groupNodeCountStack = new IntStack();
    private boolean implicitRootStart;
    @NotNull
    private Anchor insertAnchor;
    @NotNull
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> insertFixups;
    @NotNull
    private SlotTable insertTable;
    @NotNull
    private final Stack<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> insertUpFixups;
    private boolean inserting;
    @NotNull
    private final Stack<RecomposeScopeImpl> invalidateStack = new Stack<>();
    @NotNull
    private final List<Invalidation> invalidations = new ArrayList();
    private boolean isComposing;
    private boolean isDisposed;
    @NotNull
    private List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges;
    /* access modifiers changed from: private */
    @Nullable
    public int[] nodeCountOverrides;
    @Nullable
    private HashMap<Integer, Integer> nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    @NotNull
    private IntStack nodeIndexStack = new IntStack();
    /* access modifiers changed from: private */
    @NotNull
    public final CompositionContext parentContext;
    @NotNull
    private PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> parentProvider = ExtensionsKt.persistentHashMapOf();
    @Nullable
    private Pending pending;
    @NotNull
    private final Stack<Pending> pendingStack = new Stack<>();
    private int pendingUps;
    private int previousCount;
    private int previousMoveFrom;
    private int previousMoveTo;
    private int previousRemove;
    @Nullable
    private PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> providerCache;
    @NotNull
    private final HashMap<Integer, PersistentMap<CompositionLocal<Object>, State<Object>>> providerUpdates = new HashMap<>();
    private boolean providersInvalid;
    @NotNull
    private final IntStack providersInvalidStack = new IntStack();
    /* access modifiers changed from: private */
    @NotNull
    public SlotReader reader;
    private boolean reusing;
    private int reusingGroup = -1;
    /* access modifiers changed from: private */
    @NotNull
    public final SlotTable slotTable;
    @NotNull
    private Snapshot snapshot = SnapshotKt.currentSnapshot();
    private boolean startedGroup;
    @NotNull
    private final IntStack startedGroups;
    @NotNull
    private SlotWriter writer;
    private boolean writerHasAProvider;
    private int writersReaderDelta;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextHolder;", "Landroidx/compose/runtime/RememberObserver;", "ref", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/ComposerImpl;", "(Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CompositionContextHolder implements RememberObserver {
        @NotNull
        private final CompositionContextImpl ref;

        public CompositionContextHolder(@NotNull CompositionContextImpl compositionContextImpl) {
            Intrinsics.checkNotNullParameter(compositionContextImpl, GlobalConstants.ExtraNames.REF);
            this.ref = compositionContextImpl;
        }

        @NotNull
        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        public void onAbandoned() {
            this.ref.dispose();
        }

        public void onForgotten() {
            this.ref.dispose();
        }

        public void onRemembered() {
        }
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020+0/¢\u0006\u0002\b0H\u0010¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0010¢\u0006\u0002\b6J\u0006\u00107\u001a\u00020+J\r\u00108\u001a\u00020+H\u0010¢\u0006\u0002\b9J-\u0010\u0015\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u0013H\u0010¢\u0006\u0002\b:J\u0015\u0010;\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0010¢\u0006\u0002\b<J\u0015\u0010=\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0010¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020AH\u0010¢\u0006\u0002\bBJ\u001d\u0010C\u001a\u00020+2\u0006\u00104\u001a\u0002052\u0006\u0010D\u001a\u00020EH\u0010¢\u0006\u0002\bFJ\u0017\u0010G\u001a\u0004\u0018\u00010E2\u0006\u00104\u001a\u000205H\u0010¢\u0006\u0002\bHJ\u001b\u0010I\u001a\u00020+2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\"0\nH\u0010¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u00020NH\u0010¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0010¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020+H\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020+2\u0006\u0010M\u001a\u00020NH\u0010¢\u0006\u0002\bUJ\u0015\u0010V\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0010¢\u0006\u0002\bWJ.\u0010X\u001a\u00020+2&\u0010@\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rRk\u0010\u0014\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u00132&\u0010\u000e\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u00138B@BX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8PX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R(\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\n\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u001e8PX\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010 ¨\u0006Y"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compoundHashKey", "", "collectingParameterInformation", "", "(Landroidx/compose/runtime/ComposerImpl;IZ)V", "getCollectingParameterInformation$runtime_release", "()Z", "composers", "", "Landroidx/compose/runtime/ComposerImpl;", "getComposers", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompoundHashKey$runtime_release", "()I", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext$runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "inspectionTables", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "setInspectionTables", "(Ljava/util/Set;)V", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release$annotations", "()V", "getRecomposeCoroutineContext$runtime_release", "composeInitial", "", "composition", "Landroidx/compose/runtime/ControlledComposition;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "deletedMovableContent", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "deletedMovableContent$runtime_release", "dispose", "doneComposing", "doneComposing$runtime_release", "getCompositionLocalScope$runtime_release", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "movableContentStateReleased", "data", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "recordInspectionTable", "table", "recordInspectionTable$runtime_release", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime_release", "registerComposition", "registerComposition$runtime_release", "startComposing", "startComposing$runtime_release", "unregisterComposer", "unregisterComposer$runtime_release", "unregisterComposition", "unregisterComposition$runtime_release", "updateCompositionLocalScope", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        @NotNull
        private final Set<ComposerImpl> composers = new LinkedHashSet();
        @NotNull
        private final MutableState compositionLocalScope$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ExtensionsKt.persistentHashMapOf(), (SnapshotMutationPolicy) null, 2, (Object) null);
        private final int compoundHashKey;
        @Nullable
        private Set<Set<CompositionData>> inspectionTables;

        public CompositionContextImpl(int i11, boolean z11) {
            this.compoundHashKey = i11;
            this.collectingParameterInformation = z11;
        }

        private final PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope() {
            return (PersistentMap) this.compositionLocalScope$delegate.getValue();
        }

        public static /* synthetic */ void getRecomposeCoroutineContext$runtime_release$annotations() {
        }

        private final void setCompositionLocalScope(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
            this.compositionLocalScope$delegate.setValue(persistentMap);
        }

        @ComposableInferredTarget(scheme = "[0[0]]")
        public void composeInitial$runtime_release(@NotNull ControlledComposition controlledComposition, @NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(controlledComposition, "composition");
            Intrinsics.checkNotNullParameter(function2, "content");
            ComposerImpl.this.parentContext.composeInitial$runtime_release(controlledComposition, function2);
        }

        public void deletedMovableContent$runtime_release(@NotNull MovableContentStateReference movableContentStateReference) {
            Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
            ComposerImpl.this.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
        }

        public final void dispose() {
            if (!this.composers.isEmpty()) {
                Set<Set<CompositionData>> set = this.inspectionTables;
                if (set != null) {
                    for (ComposerImpl next : this.composers) {
                        for (Set<CompositionData> remove : set) {
                            remove.remove(next.slotTable);
                        }
                    }
                }
                this.composers.clear();
            }
        }

        public void doneComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing = composerImpl.childrenComposing - 1;
        }

        public boolean getCollectingParameterInformation$runtime_release() {
            return this.collectingParameterInformation;
        }

        @NotNull
        public final Set<ComposerImpl> getComposers() {
            return this.composers;
        }

        @NotNull
        public PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope$runtime_release() {
            return getCompositionLocalScope();
        }

        public int getCompoundHashKey$runtime_release() {
            return this.compoundHashKey;
        }

        @NotNull
        public CoroutineContext getEffectCoroutineContext$runtime_release() {
            return ComposerImpl.this.parentContext.getEffectCoroutineContext$runtime_release();
        }

        @Nullable
        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        @NotNull
        public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
            return CompositionKt.getRecomposeCoroutineContext(ComposerImpl.this.getComposition());
        }

        public void insertMovableContent$runtime_release(@NotNull MovableContentStateReference movableContentStateReference) {
            Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
            ComposerImpl.this.parentContext.insertMovableContent$runtime_release(movableContentStateReference);
        }

        public void invalidate$runtime_release(@NotNull ControlledComposition controlledComposition) {
            Intrinsics.checkNotNullParameter(controlledComposition, "composition");
            ComposerImpl.this.parentContext.invalidate$runtime_release(ComposerImpl.this.getComposition());
            ComposerImpl.this.parentContext.invalidate$runtime_release(controlledComposition);
        }

        public void invalidateScope$runtime_release(@NotNull RecomposeScopeImpl recomposeScopeImpl) {
            Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
            ComposerImpl.this.parentContext.invalidateScope$runtime_release(recomposeScopeImpl);
        }

        public void movableContentStateReleased$runtime_release(@NotNull MovableContentStateReference movableContentStateReference, @NotNull MovableContentState movableContentState) {
            Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
            Intrinsics.checkNotNullParameter(movableContentState, "data");
            ComposerImpl.this.parentContext.movableContentStateReleased$runtime_release(movableContentStateReference, movableContentState);
        }

        @Nullable
        public MovableContentState movableContentStateResolve$runtime_release(@NotNull MovableContentStateReference movableContentStateReference) {
            Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
            return ComposerImpl.this.parentContext.movableContentStateResolve$runtime_release(movableContentStateReference);
        }

        public void recordInspectionTable$runtime_release(@NotNull Set<CompositionData> set) {
            Intrinsics.checkNotNullParameter(set, "table");
            Set set2 = this.inspectionTables;
            if (set2 == null) {
                set2 = new HashSet();
                this.inspectionTables = set2;
            }
            set2.add(set);
        }

        public void registerComposer$runtime_release(@NotNull Composer composer) {
            Intrinsics.checkNotNullParameter(composer, "composer");
            super.registerComposer$runtime_release((ComposerImpl) composer);
            this.composers.add(composer);
        }

        public void registerComposition$runtime_release(@NotNull ControlledComposition controlledComposition) {
            Intrinsics.checkNotNullParameter(controlledComposition, "composition");
            ComposerImpl.this.parentContext.registerComposition$runtime_release(controlledComposition);
        }

        public final void setInspectionTables(@Nullable Set<Set<CompositionData>> set) {
            this.inspectionTables = set;
        }

        public void startComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing = composerImpl.childrenComposing + 1;
        }

        public void unregisterComposer$runtime_release(@NotNull Composer composer) {
            Intrinsics.checkNotNullParameter(composer, "composer");
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                for (Set remove : set) {
                    remove.remove(((ComposerImpl) composer).slotTable);
                }
            }
            TypeIntrinsics.asMutableCollection(this.composers).remove(composer);
        }

        public void unregisterComposition$runtime_release(@NotNull ControlledComposition controlledComposition) {
            Intrinsics.checkNotNullParameter(controlledComposition, "composition");
            ComposerImpl.this.parentContext.unregisterComposition$runtime_release(controlledComposition);
        }

        public final void updateCompositionLocalScope(@NotNull PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
            Intrinsics.checkNotNullParameter(persistentMap, "scope");
            setCompositionLocalScope(persistentMap);
        }
    }

    /* JADX INFO: finally extract failed */
    public ComposerImpl(@NotNull Applier<?> applier2, @NotNull CompositionContext compositionContext, @NotNull SlotTable slotTable2, @NotNull Set<RememberObserver> set, @NotNull List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list, @NotNull List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list2, @NotNull ControlledComposition controlledComposition) {
        Intrinsics.checkNotNullParameter(applier2, "applier");
        Intrinsics.checkNotNullParameter(compositionContext, "parentContext");
        Intrinsics.checkNotNullParameter(slotTable2, "slotTable");
        Intrinsics.checkNotNullParameter(set, "abandonSet");
        Intrinsics.checkNotNullParameter(list, "changes");
        Intrinsics.checkNotNullParameter(list2, "lateChanges");
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        this.applier = applier2;
        this.parentContext = compositionContext;
        this.slotTable = slotTable2;
        this.abandonSet = set;
        this.changes = list;
        this.lateChanges = list2;
        this.composition = controlledComposition;
        SlotReader openReader = slotTable2.openReader();
        openReader.close();
        this.reader = openReader;
        SlotTable slotTable3 = new SlotTable();
        this.insertTable = slotTable3;
        SlotWriter openWriter = slotTable3.openWriter();
        openWriter.close();
        this.writer = openWriter;
        SlotReader openReader2 = this.insertTable.openReader();
        try {
            Anchor anchor = openReader2.anchor(0);
            openReader2.close();
            this.insertAnchor = anchor;
            this.insertFixups = new ArrayList();
            this.downNodes = new Stack<>();
            this.implicitRootStart = true;
            this.startedGroups = new IntStack();
            this.insertUpFixups = new Stack<>();
            this.previousRemove = -1;
            this.previousMoveFrom = -1;
            this.previousMoveTo = -1;
        } catch (Throwable th2) {
            openReader2.close();
            throw th2;
        }
    }

    public static /* synthetic */ PersistentMap a(ComposerImpl composerImpl, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        return composerImpl.currentCompositionLocalScope(num);
    }

    private final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.clear();
        this.nodeIndexStack.clear();
        this.groupNodeCountStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates.clear();
        if (!this.reader.getClosed()) {
            this.reader.close();
        }
        if (!this.writer.getClosed()) {
            this.writer.close();
        }
        createFreshInsertTable();
        this.compoundKeyHash = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
    }

    private final void addRecomposeScope() {
        RecomposeScopeImpl recomposeScopeImpl;
        boolean z11;
        if (getInserting()) {
            ControlledComposition composition2 = getComposition();
            Intrinsics.checkNotNull(composition2, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            RecomposeScopeImpl recomposeScopeImpl2 = new RecomposeScopeImpl((CompositionImpl) composition2);
            this.invalidateStack.push(recomposeScopeImpl2);
            updateValue(recomposeScopeImpl2);
            recomposeScopeImpl2.start(this.compositionToken);
            return;
        }
        Invalidation access$removeLocation = ComposerKt.removeLocation(this.invalidations, this.reader.getParent());
        Object next = this.reader.next();
        if (Intrinsics.areEqual(next, Composer.Companion.getEmpty())) {
            ControlledComposition composition3 = getComposition();
            Intrinsics.checkNotNull(composition3, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            recomposeScopeImpl = new RecomposeScopeImpl((CompositionImpl) composition3);
            updateValue(recomposeScopeImpl);
        } else {
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
            recomposeScopeImpl = (RecomposeScopeImpl) next;
        }
        if (access$removeLocation != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        recomposeScopeImpl.setRequiresRecompose(z11);
        this.invalidateStack.push(recomposeScopeImpl);
        recomposeScopeImpl.start(this.compositionToken);
    }

    public static /* synthetic */ void b(ComposerImpl composerImpl, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        composerImpl.realizeOperationLocation(z11);
    }

    public static /* synthetic */ Object c(ComposerImpl composerImpl, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, Function0 function0, int i11, Object obj) {
        ControlledComposition controlledComposition3;
        ControlledComposition controlledComposition4;
        Integer num2;
        if ((i11 & 1) != 0) {
            controlledComposition3 = null;
        } else {
            controlledComposition3 = controlledComposition;
        }
        if ((i11 & 2) != 0) {
            controlledComposition4 = null;
        } else {
            controlledComposition4 = controlledComposition2;
        }
        if ((i11 & 4) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
        if ((i11 & 8) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return composerImpl.recomposeMovableContent(controlledComposition3, controlledComposition4, num2, list, function0);
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.writersReaderDelta = 0;
        this.compoundKeyHash = 0;
        this.nodeExpected = false;
        this.startedGroup = false;
        this.startedGroups.clear();
        this.invalidateStack.clear();
        clearUpdatedNodeCounts();
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final int compoundKeyOf(int i11, int i12, int i13) {
        if (i11 == i12) {
            return i13;
        }
        int groupCompoundKeyPart = groupCompoundKeyPart(this.reader, i11);
        if (groupCompoundKeyPart == 126665345) {
            return groupCompoundKeyPart;
        }
        return Integer.rotateLeft(compoundKeyOf(this.reader.parent(i11), i12, i13), 3) ^ groupCompoundKeyPart;
    }

    private final void createFreshInsertTable() {
        ComposerKt.runtimeCheck(this.writer.getClosed());
        SlotTable slotTable2 = new SlotTable();
        this.insertTable = slotTable2;
        SlotWriter openWriter = slotTable2.openWriter();
        openWriter.close();
        this.writer = openWriter;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<java.lang.Object>, ? extends androidx.compose.runtime.State<? extends java.lang.Object>>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<java.lang.Object>, androidx.compose.runtime.State<java.lang.Object>> currentCompositionLocalScope(java.lang.Integer r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0007
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<java.lang.Object>, ? extends androidx.compose.runtime.State<? extends java.lang.Object>> r0 = r5.providerCache
            if (r0 == 0) goto L_0x0007
            return r0
        L_0x0007:
            boolean r0 = r5.getInserting()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }"
            r2 = 202(0xca, float:2.83E-43)
            if (r0 == 0) goto L_0x004a
            boolean r0 = r5.writerHasAProvider
            if (r0 == 0) goto L_0x004a
            androidx.compose.runtime.SlotWriter r0 = r5.writer
            int r0 = r0.getParent()
        L_0x001b:
            if (r0 <= 0) goto L_0x004a
            androidx.compose.runtime.SlotWriter r3 = r5.writer
            int r3 = r3.groupKey(r0)
            if (r3 != r2) goto L_0x0043
            androidx.compose.runtime.SlotWriter r3 = r5.writer
            java.lang.Object r3 = r3.groupObjectKey(r0)
            java.lang.Object r4 = androidx.compose.runtime.ComposerKt.getCompositionLocalMap()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0043
            androidx.compose.runtime.SlotWriter r6 = r5.writer
            java.lang.Object r6 = r6.groupAux(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r6 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap) r6
            r5.providerCache = r6
            return r6
        L_0x0043:
            androidx.compose.runtime.SlotWriter r3 = r5.writer
            int r0 = r3.parent((int) r0)
            goto L_0x001b
        L_0x004a:
            androidx.compose.runtime.SlotReader r0 = r5.reader
            int r0 = r0.getSize()
            if (r0 <= 0) goto L_0x009d
            if (r6 == 0) goto L_0x0059
            int r6 = r6.intValue()
            goto L_0x005f
        L_0x0059:
            androidx.compose.runtime.SlotReader r6 = r5.reader
            int r6 = r6.getParent()
        L_0x005f:
            if (r6 <= 0) goto L_0x009d
            androidx.compose.runtime.SlotReader r0 = r5.reader
            int r0 = r0.groupKey((int) r6)
            if (r0 != r2) goto L_0x0096
            androidx.compose.runtime.SlotReader r0 = r5.reader
            java.lang.Object r0 = r0.groupObjectKey(r6)
            java.lang.Object r3 = androidx.compose.runtime.ComposerKt.getCompositionLocalMap()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0096
            java.util.HashMap<java.lang.Integer, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<java.lang.Object>, androidx.compose.runtime.State<java.lang.Object>>> r0 = r5.providerUpdates
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            java.lang.Object r0 = r0.get(r2)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap) r0
            if (r0 != 0) goto L_0x0093
            androidx.compose.runtime.SlotReader r0 = r5.reader
            java.lang.Object r6 = r0.groupAux(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)
            r0 = r6
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap) r0
        L_0x0093:
            r5.providerCache = r0
            return r0
        L_0x0096:
            androidx.compose.runtime.SlotReader r0 = r5.reader
            int r6 = r0.parent(r6)
            goto L_0x005f
        L_0x009d:
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<java.lang.Object>, ? extends androidx.compose.runtime.State<? extends java.lang.Object>> r6 = r5.parentProvider
            r5.providerCache = r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.currentCompositionLocalScope(java.lang.Integer):androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap");
    }

    public static /* synthetic */ void d(ComposerImpl composerImpl, boolean z11, Function3 function3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        composerImpl.recordSlotTableOperation(z11, function3);
    }

    private final void doCompose(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (!this.isComposing) {
            Object beginSection = Trace.INSTANCE.beginSection("Compose:recompose");
            try {
                Snapshot currentSnapshot = SnapshotKt.currentSnapshot();
                this.snapshot = currentSnapshot;
                this.compositionToken = currentSnapshot.getId();
                this.providerUpdates.clear();
                int size$runtime_release = identityArrayMap.getSize$runtime_release();
                int i11 = 0;
                while (i11 < size$runtime_release) {
                    Object obj = identityArrayMap.getKeys$runtime_release()[i11];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                    IdentityArraySet identityArraySet = (IdentityArraySet) identityArrayMap.getValues$runtime_release()[i11];
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                    Anchor anchor = recomposeScopeImpl.getAnchor();
                    if (anchor != null) {
                        this.invalidations.add(new Invalidation(recomposeScopeImpl, anchor.getLocation$runtime_release(), identityArraySet));
                        i11++;
                    } else {
                        Trace.INSTANCE.endSection(beginSection);
                        return;
                    }
                }
                List<Invalidation> list = this.invalidations;
                if (list.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(list, new ComposerImpl$doCompose$lambda37$$inlined$sortBy$1());
                }
                this.nodeIndex = 0;
                this.isComposing = true;
                startRoot();
                Object nextSlot = nextSlot();
                if (!(nextSlot == function2 || function2 == null)) {
                    updateValue(function2);
                }
                SnapshotStateKt.observeDerivedStateRecalculations(new ComposerImpl$doCompose$2$3(this), new ComposerImpl$doCompose$2$4(this), new ComposerImpl$doCompose$2$5(function2, this, nextSlot));
                endRoot();
                this.isComposing = false;
                this.invalidations.clear();
                Unit unit = Unit.INSTANCE;
                Trace.INSTANCE.endSection(beginSection);
            } catch (Throwable th2) {
                Trace.INSTANCE.endSection(beginSection);
                throw th2;
            }
        } else {
            ComposerKt.composeRuntimeError("Reentrant composition is not supported".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void doRecordDownsFor(int i11, int i12) {
        if (i11 > 0 && i11 != i12) {
            doRecordDownsFor(this.reader.parent(i11), i12);
            if (this.reader.isNode(i11)) {
                recordDown(nodeAt(this.reader, i11));
            }
        }
    }

    private final void end(boolean z11) {
        List<KeyInfo> list;
        if (getInserting()) {
            int parent = this.writer.getParent();
            updateCompoundKeyWhenWeExitGroup(this.writer.groupKey(parent), this.writer.groupObjectKey(parent), this.writer.groupAux(parent));
        } else {
            int parent2 = this.reader.getParent();
            updateCompoundKeyWhenWeExitGroup(this.reader.groupKey(parent2), this.reader.groupObjectKey(parent2), this.reader.groupAux(parent2));
        }
        int i11 = this.groupNodeCount;
        Pending pending2 = this.pending;
        int i12 = 0;
        if (pending2 != null && pending2.getKeyInfos().size() > 0) {
            List<KeyInfo> keyInfos = pending2.getKeyInfos();
            List<KeyInfo> used = pending2.getUsed();
            Set<T> fastToSet = ListUtilsKt.fastToSet(used);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = used.size();
            int size2 = keyInfos.size();
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i13 < size2) {
                KeyInfo keyInfo = keyInfos.get(i13);
                if (!fastToSet.contains(keyInfo)) {
                    recordRemoveNode(pending2.nodePositionOf(keyInfo) + pending2.getStartIndex(), keyInfo.getNodes());
                    pending2.updateNodeCount(keyInfo.getLocation(), i12);
                    recordReaderMoving(keyInfo.getLocation());
                    this.reader.reposition(keyInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    ComposerKt.removeRange(this.invalidations, keyInfo.getLocation(), keyInfo.getLocation() + this.reader.groupSize(keyInfo.getLocation()));
                } else if (!linkedHashSet.contains(keyInfo)) {
                    if (i14 < size) {
                        KeyInfo keyInfo2 = used.get(i14);
                        if (keyInfo2 != keyInfo) {
                            int nodePositionOf = pending2.nodePositionOf(keyInfo2);
                            linkedHashSet.add(keyInfo2);
                            if (nodePositionOf != i15) {
                                int updatedNodeCountOf = pending2.updatedNodeCountOf(keyInfo2);
                                list = used;
                                recordMoveNode(pending2.getStartIndex() + nodePositionOf, i15 + pending2.getStartIndex(), updatedNodeCountOf);
                                pending2.registerMoveNode(nodePositionOf, i15, updatedNodeCountOf);
                            } else {
                                list = used;
                            }
                        } else {
                            list = used;
                            i13++;
                        }
                        i14++;
                        i15 += pending2.updatedNodeCountOf(keyInfo2);
                        used = list;
                    }
                    i12 = 0;
                }
                i13++;
                i12 = 0;
            }
            realizeMovement();
            if (keyInfos.size() > 0) {
                recordReaderMoving(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        int i16 = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int currentGroup = this.reader.getCurrentGroup();
            recordDelete();
            recordRemoveNode(i16, this.reader.skipGroup());
            ComposerKt.removeRange(this.invalidations, currentGroup, this.reader.getCurrentGroup());
        }
        boolean inserting2 = getInserting();
        if (inserting2) {
            if (z11) {
                registerInsertUpFixup();
                i11 = 1;
            }
            this.reader.endEmpty();
            int parent3 = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int insertedGroupVirtualIndex = insertedGroupVirtualIndex(parent3);
                this.writer.endInsert();
                this.writer.close();
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(insertedGroupVirtualIndex, 0);
                    updateNodeCountOverrides(insertedGroupVirtualIndex, i11);
                }
            }
        } else {
            if (z11) {
                recordUp();
            }
            recordEndGroup();
            int parent4 = this.reader.getParent();
            if (i11 != updatedNodeCount(parent4)) {
                updateNodeCountOverrides(parent4, i11);
            }
            if (z11) {
                i11 = 1;
            }
            this.reader.endGroup();
            realizeMovement();
        }
        exitGroup(i11, inserting2);
    }

    /* access modifiers changed from: private */
    public final void endGroup() {
        end(false);
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime_release();
        endGroup();
        recordEndRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            SlotWriter openWriter = this.insertTable.openWriter();
            this.writer = openWriter;
            openWriter.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void enterGroup(boolean z11, Pending pending2) {
        this.pendingStack.push(this.pending);
        this.pending = pending2;
        this.nodeIndexStack.push(this.nodeIndex);
        if (z11) {
            this.nodeIndex = 0;
        }
        this.groupNodeCountStack.push(this.groupNodeCount);
        this.groupNodeCount = 0;
    }

    private final void exitGroup(int i11, boolean z11) {
        Pending pop = this.pendingStack.pop();
        if (pop != null && !z11) {
            pop.setGroupIndex(pop.getGroupIndex() + 1);
        }
        this.pending = pop;
        this.nodeIndex = this.nodeIndexStack.pop() + i11;
        this.groupNodeCount = this.groupNodeCountStack.pop() + i11;
    }

    private final void finalizeCompose() {
        realizeUps();
        if (!this.pendingStack.isEmpty()) {
            ComposerKt.composeRuntimeError("Start/end imbalance".toString());
            throw new KotlinNothingValueException();
        } else if (this.startedGroups.isEmpty()) {
            cleanUpCompose();
        } else {
            ComposerKt.composeRuntimeError("Missed recording an endGroup()".toString());
            throw new KotlinNothingValueException();
        }
    }

    @InternalComposeApi
    public static /* synthetic */ void getCompoundKeyHash$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    private final Object getNode(SlotReader slotReader) {
        return slotReader.node(slotReader.getParent());
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    private final int groupCompoundKeyPart(SlotReader slotReader, int i11) {
        Object groupAux;
        if (slotReader.hasObjectKey(i11)) {
            Object groupObjectKey = slotReader.groupObjectKey(i11);
            if (groupObjectKey == null) {
                return 0;
            }
            if (groupObjectKey instanceof Enum) {
                return ((Enum) groupObjectKey).ordinal();
            }
            if (groupObjectKey instanceof MovableContent) {
                return MovableContentKt.movableContentKey;
            }
            return groupObjectKey.hashCode();
        }
        int groupKey = slotReader.groupKey(i11);
        if (groupKey == 207 && (groupAux = slotReader.groupAux(i11)) != null && !Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
            groupKey = groupAux.hashCode();
        }
        return groupKey;
    }

    private final void insertMovableContentGuarded(List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        SlotTable slotTable2;
        Anchor anchor;
        SlotReader access$getReader$p;
        int[] access$getNodeCountOverrides$p;
        List list2;
        SlotTable slotTable$runtime_release;
        SlotReader openReader;
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list3 = this.lateChanges;
        List access$getChanges$p = this.changes;
        try {
            this.changes = list3;
            record(ComposerKt.resetSlotsInstance);
            int size = list.size();
            int i11 = 0;
            int i12 = 0;
            while (i12 < size) {
                Pair pair = list.get(i12);
                MovableContentStateReference movableContentStateReference = (MovableContentStateReference) pair.component1();
                MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.component2();
                Anchor anchor$runtime_release = movableContentStateReference.getAnchor$runtime_release();
                int anchorIndex = movableContentStateReference.getSlotTable$runtime_release().anchorIndex(anchor$runtime_release);
                Ref.IntRef intRef = new Ref.IntRef();
                realizeUps();
                record(new ComposerImpl$insertMovableContentGuarded$1$1$1(intRef, anchor$runtime_release));
                if (movableContentStateReference2 == null) {
                    if (Intrinsics.areEqual((Object) movableContentStateReference.getSlotTable$runtime_release(), (Object) this.insertTable)) {
                        createFreshInsertTable();
                    }
                    openReader = movableContentStateReference.getSlotTable$runtime_release().openReader();
                    openReader.reposition(anchorIndex);
                    this.writersReaderDelta = anchorIndex;
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = arrayList;
                    c(this, (ControlledComposition) null, (ControlledComposition) null, (Integer) null, (List) null, new ComposerImpl$insertMovableContentGuarded$1$1$2$1(this, arrayList, openReader, movableContentStateReference), 15, (Object) null);
                    if (!arrayList2.isEmpty()) {
                        record(new ComposerImpl$insertMovableContentGuarded$1$1$2$2(intRef, arrayList2));
                    }
                    Unit unit = Unit.INSTANCE;
                    openReader.close();
                } else {
                    MovableContentState movableContentStateResolve$runtime_release = this.parentContext.movableContentStateResolve$runtime_release(movableContentStateReference2);
                    if (movableContentStateResolve$runtime_release == null || (slotTable2 = movableContentStateResolve$runtime_release.getSlotTable$runtime_release()) == null) {
                        slotTable2 = movableContentStateReference2.getSlotTable$runtime_release();
                    }
                    if (movableContentStateResolve$runtime_release == null || (slotTable$runtime_release = movableContentStateResolve$runtime_release.getSlotTable$runtime_release()) == null || (anchor = slotTable$runtime_release.anchor(i11)) == null) {
                        anchor = movableContentStateReference2.getAnchor$runtime_release();
                    }
                    List access$collectNodesFrom = ComposerKt.collectNodesFrom(slotTable2, anchor);
                    if (!access$collectNodesFrom.isEmpty()) {
                        record(new ComposerImpl$insertMovableContentGuarded$1$1$3(intRef, access$collectNodesFrom));
                        if (Intrinsics.areEqual((Object) movableContentStateReference.getSlotTable$runtime_release(), (Object) this.slotTable)) {
                            int anchorIndex2 = this.slotTable.anchorIndex(anchor$runtime_release);
                            updateNodeCount(anchorIndex2, updatedNodeCount(anchorIndex2) + access$collectNodesFrom.size());
                        }
                    }
                    record(new ComposerImpl$insertMovableContentGuarded$1$1$4(movableContentStateResolve$runtime_release, this, movableContentStateReference2, movableContentStateReference));
                    SlotReader openReader2 = slotTable2.openReader();
                    try {
                        access$getReader$p = this.reader;
                        access$getNodeCountOverrides$p = this.nodeCountOverrides;
                        this.nodeCountOverrides = null;
                        this.reader = openReader2;
                        int anchorIndex3 = slotTable2.anchorIndex(anchor);
                        openReader2.reposition(anchorIndex3);
                        this.writersReaderDelta = anchorIndex3;
                        ArrayList arrayList3 = new ArrayList();
                        List access$getChanges$p2 = this.changes;
                        try {
                            this.changes = arrayList3;
                            list2 = access$getChanges$p2;
                            ArrayList arrayList4 = arrayList3;
                            try {
                                recomposeMovableContent(movableContentStateReference2.getComposition$runtime_release(), movableContentStateReference.getComposition$runtime_release(), Integer.valueOf(openReader2.getCurrentGroup()), movableContentStateReference2.getInvalidations$runtime_release(), new ComposerImpl$insertMovableContentGuarded$1$1$5$1$1$1(this, movableContentStateReference));
                                Unit unit2 = Unit.INSTANCE;
                                this.changes = list2;
                                if (!arrayList4.isEmpty()) {
                                    record(new ComposerImpl$insertMovableContentGuarded$1$1$5$1$2(intRef, arrayList4));
                                }
                                this.reader = access$getReader$p;
                                this.nodeCountOverrides = access$getNodeCountOverrides$p;
                                openReader2.close();
                            } catch (Throwable th2) {
                                th = th2;
                                this.changes = list2;
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            list2 = access$getChanges$p2;
                            this.changes = list2;
                            throw th;
                        }
                    } catch (Throwable th4) {
                        openReader2.close();
                        throw th4;
                    }
                }
                record(ComposerKt.skipToGroupEndInstance);
                i12++;
                i11 = 0;
            }
            record(ComposerImpl$insertMovableContentGuarded$1$2.INSTANCE);
            this.writersReaderDelta = 0;
            Unit unit3 = Unit.INSTANCE;
            this.changes = access$getChanges$p;
        } catch (Throwable th5) {
            this.changes = access$getChanges$p;
            throw th5;
        }
    }

    private static final int insertMovableContentGuarded$currentNodeIndex(SlotWriter slotWriter) {
        int i11;
        int currentGroup = slotWriter.getCurrentGroup();
        int parent = slotWriter.getParent();
        while (parent >= 0 && !slotWriter.isNode(parent)) {
            parent = slotWriter.parent(parent);
        }
        int i12 = parent + 1;
        int i13 = 0;
        while (i12 < currentGroup) {
            if (slotWriter.indexInGroup(currentGroup, i12)) {
                if (slotWriter.isNode(i12)) {
                    i13 = 0;
                }
                i12++;
            } else {
                if (slotWriter.isNode(i12)) {
                    i11 = 1;
                } else {
                    i11 = slotWriter.nodeCount(i12);
                }
                i13 += i11;
                i12 += slotWriter.groupSize(i12);
            }
        }
        return i13;
    }

    /* access modifiers changed from: private */
    public static final int insertMovableContentGuarded$positionToInsert(SlotWriter slotWriter, Anchor anchor, Applier<Object> applier2) {
        boolean z11;
        int anchorIndex = slotWriter.anchorIndex(anchor);
        boolean z12 = true;
        if (slotWriter.getCurrentGroup() < anchorIndex) {
            z11 = true;
        } else {
            z11 = false;
        }
        ComposerKt.runtimeCheck(z11);
        insertMovableContentGuarded$positionToParentOf(slotWriter, applier2, anchorIndex);
        int insertMovableContentGuarded$currentNodeIndex = insertMovableContentGuarded$currentNodeIndex(slotWriter);
        while (slotWriter.getCurrentGroup() < anchorIndex) {
            if (slotWriter.indexInCurrentGroup(anchorIndex)) {
                if (slotWriter.isNode()) {
                    applier2.down(slotWriter.node(slotWriter.getCurrentGroup()));
                    insertMovableContentGuarded$currentNodeIndex = 0;
                }
                slotWriter.startGroup();
            } else {
                insertMovableContentGuarded$currentNodeIndex += slotWriter.skipGroup();
            }
        }
        if (slotWriter.getCurrentGroup() != anchorIndex) {
            z12 = false;
        }
        ComposerKt.runtimeCheck(z12);
        return insertMovableContentGuarded$currentNodeIndex;
    }

    /* access modifiers changed from: private */
    public static final void insertMovableContentGuarded$positionToParentOf(SlotWriter slotWriter, Applier<Object> applier2, int i11) {
        while (!slotWriter.indexInParent(i11)) {
            slotWriter.skipToGroupEnd();
            if (slotWriter.isNode(slotWriter.getParent())) {
                applier2.up();
            }
            slotWriter.endGroup();
        }
    }

    private final int insertedGroupVirtualIndex(int i11) {
        return -2 - i11;
    }

    /* access modifiers changed from: private */
    public final void invokeMovableContentLambda(MovableContent<Object> movableContent, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, Object obj, boolean z11) {
        boolean z12;
        MovableContent<Object> movableContent2 = movableContent;
        PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap2 = persistentMap;
        Object obj2 = obj;
        startMovableGroup(MovableContentKt.movableContentKey, movableContent);
        changed(obj2);
        int compoundKeyHash2 = getCompoundKeyHash();
        try {
            this.compoundKeyHash = MovableContentKt.movableContentKey;
            if (getInserting()) {
                SlotWriter.markGroup$default(this.writer, 0, 1, (Object) null);
            }
            if (!getInserting() && !Intrinsics.areEqual(this.reader.getGroupAux(), (Object) persistentMap2)) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                this.providerUpdates.put(Integer.valueOf(this.reader.getCurrentGroup()), persistentMap2);
            }
            start(202, ComposerKt.getCompositionLocalMap(), false, persistentMap2);
            if (!getInserting() || z11) {
                boolean z13 = this.providersInvalid;
                this.providersInvalid = z12;
                ActualJvm_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(694380496, true, new ComposerImpl$invokeMovableContentLambda$1(movableContent, obj2)));
                this.providersInvalid = z13;
            } else {
                this.writerHasAProvider = true;
                this.providerCache = null;
                SlotWriter slotWriter = this.writer;
                this.parentContext.insertMovableContent$runtime_release(new MovableContentStateReference(movableContent, obj, getComposition(), this.insertTable, slotWriter.anchor(slotWriter.parent(slotWriter.getParent())), CollectionsKt__CollectionsKt.emptyList(), a(this, (Integer) null, 1, (Object) null)));
            }
        } finally {
            endGroup();
            this.compoundKeyHash = compoundKeyHash2;
            endMovableGroup();
        }
    }

    private final Object nodeAt(SlotReader slotReader, int i11) {
        return slotReader.node(i11);
    }

    private final int nodeIndexOf(int i11, int i12, int i13, int i14) {
        int i15;
        int parent = this.reader.parent(i12);
        while (i15 != i13 && !this.reader.isNode(i15)) {
            parent = this.reader.parent(i15);
        }
        if (this.reader.isNode(i15)) {
            i14 = 0;
        }
        if (i15 == i12) {
            return i14;
        }
        int updatedNodeCount = (updatedNodeCount(i15) - this.reader.nodeCount(i12)) + i14;
        loop1:
        while (i14 < updatedNodeCount && i15 != i11) {
            i15++;
            while (true) {
                if (i15 >= i11) {
                    break loop1;
                }
                int groupSize = this.reader.groupSize(i15) + i15;
                if (i11 >= groupSize) {
                    i14 += updatedNodeCount(i15);
                    i15 = groupSize;
                }
            }
        }
        return i14;
    }

    private final void realizeDowns(Object[] objArr) {
        record(new ComposerImpl$realizeDowns$1(objArr));
    }

    private final void realizeMovement() {
        int i11 = this.previousCount;
        this.previousCount = 0;
        if (i11 > 0) {
            int i12 = this.previousRemove;
            if (i12 >= 0) {
                this.previousRemove = -1;
                recordApplierOperation(new ComposerImpl$realizeMovement$1(i12, i11));
                return;
            }
            int i13 = this.previousMoveFrom;
            this.previousMoveFrom = -1;
            int i14 = this.previousMoveTo;
            this.previousMoveTo = -1;
            recordApplierOperation(new ComposerImpl$realizeMovement$2(i13, i14, i11));
        }
    }

    private final void realizeOperationLocation(boolean z11) {
        int i11;
        boolean z12;
        if (z11) {
            i11 = this.reader.getParent();
        } else {
            i11 = this.reader.getCurrentGroup();
        }
        int i12 = i11 - this.writersReaderDelta;
        if (i12 >= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            ComposerKt.composeRuntimeError("Tried to seek backward".toString());
            throw new KotlinNothingValueException();
        } else if (i12 > 0) {
            record(new ComposerImpl$realizeOperationLocation$2(i12));
            this.writersReaderDelta = i11;
        }
    }

    private final void realizeUps() {
        int i11 = this.pendingUps;
        if (i11 > 0) {
            this.pendingUps = 0;
            record(new ComposerImpl$realizeUps$1(i11));
        }
    }

    private final <R> R recomposeMovableContent(ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> list, Function0<? extends R> function0) {
        R r11;
        int i11;
        ControlledComposition controlledComposition3 = controlledComposition;
        boolean z11 = this.implicitRootStart;
        boolean z12 = this.isComposing;
        int i12 = this.nodeIndex;
        try {
            this.implicitRootStart = false;
            this.isComposing = true;
            this.nodeIndex = 0;
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                Pair pair = list.get(i13);
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) pair.component1();
                IdentityArraySet identityArraySet = (IdentityArraySet) pair.component2();
                if (identityArraySet != null) {
                    int size2 = identityArraySet.size();
                    for (int i14 = 0; i14 < size2; i14++) {
                        tryImminentInvalidation$runtime_release(recomposeScopeImpl, identityArraySet.get(i14));
                    }
                } else {
                    tryImminentInvalidation$runtime_release(recomposeScopeImpl, (Object) null);
                }
            }
            if (controlledComposition3 != null) {
                if (num != null) {
                    i11 = num.intValue();
                } else {
                    i11 = -1;
                }
                r11 = controlledComposition.delegateInvalidations(controlledComposition2, i11, function0);
                if (r11 == null) {
                }
                return r11;
            }
            Function0<? extends R> function02 = function0;
            r11 = function0.invoke();
            return r11;
        } finally {
            this.implicitRootStart = z11;
            this.isComposing = z12;
            this.nodeIndex = i12;
        }
    }

    private final void recomposeToGroupEnd() {
        boolean z11 = this.isComposing;
        this.isComposing = true;
        int parent = this.reader.getParent();
        int groupSize = this.reader.groupSize(parent) + parent;
        int i11 = this.nodeIndex;
        int compoundKeyHash2 = getCompoundKeyHash();
        int i12 = this.groupNodeCount;
        Invalidation access$firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), groupSize);
        boolean z12 = false;
        int i13 = parent;
        while (access$firstInRange != null) {
            int location = access$firstInRange.getLocation();
            Invalidation unused = ComposerKt.removeLocation(this.invalidations, location);
            if (access$firstInRange.isInvalid()) {
                this.reader.reposition(location);
                int currentGroup = this.reader.getCurrentGroup();
                recordUpsAndDowns(i13, currentGroup, parent);
                this.nodeIndex = nodeIndexOf(location, currentGroup, parent, i11);
                this.compoundKeyHash = compoundKeyOf(this.reader.parent(currentGroup), parent, compoundKeyHash2);
                this.providerCache = null;
                access$firstInRange.getScope().compose(this);
                this.providerCache = null;
                this.reader.restoreParent(parent);
                i13 = currentGroup;
                z12 = true;
            } else {
                this.invalidateStack.push(access$firstInRange.getScope());
                access$firstInRange.getScope().rereadTrackedInstances();
                this.invalidateStack.pop();
            }
            access$firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), groupSize);
        }
        if (z12) {
            recordUpsAndDowns(i13, parent, parent);
            this.reader.skipToGroupEnd();
            int updatedNodeCount = updatedNodeCount(parent);
            this.nodeIndex = i11 + updatedNodeCount;
            this.groupNodeCount = i12 + updatedNodeCount;
        } else {
            skipReaderToGroupEnd();
        }
        this.compoundKeyHash = compoundKeyHash2;
        this.isComposing = z11;
    }

    private final void record(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        this.changes.add(function3);
    }

    private final void recordApplierOperation(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        realizeUps();
        realizeDowns();
        record(function3);
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrentGroup());
        recordSlotEditingOperation(ComposerKt.removeCurrentGroupInstance);
        this.writersReaderDelta += this.reader.getGroupSize();
    }

    private final void recordDown(Object obj) {
        this.downNodes.push(obj);
    }

    private final void recordEndGroup() {
        boolean z11;
        int parent = this.reader.getParent();
        if (this.startedGroups.peekOr(-1) <= parent) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            ComposerKt.composeRuntimeError("Missed recording an endGroup".toString());
            throw new KotlinNothingValueException();
        } else if (this.startedGroups.peekOr(-1) == parent) {
            this.startedGroups.pop();
            d(this, false, ComposerKt.endGroupInstance, 1, (Object) null);
        }
    }

    private final void recordEndRoot() {
        if (this.startedGroup) {
            d(this, false, ComposerKt.endGroupInstance, 1, (Object) null);
            this.startedGroup = false;
        }
    }

    private final void recordFixup(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        this.insertFixups.add(function3);
    }

    private final void recordInsert(Anchor anchor) {
        if (this.insertFixups.isEmpty()) {
            recordSlotEditingOperation(new ComposerImpl$recordInsert$1(this.insertTable, anchor));
            return;
        }
        List mutableList = CollectionsKt___CollectionsKt.toMutableList(this.insertFixups);
        this.insertFixups.clear();
        realizeUps();
        realizeDowns();
        recordSlotEditingOperation(new ComposerImpl$recordInsert$2(this.insertTable, anchor, mutableList));
    }

    private final void recordInsertUpFixup(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        this.insertUpFixups.push(function3);
    }

    private final void recordMoveNode(int i11, int i12, int i13) {
        if (i13 > 0) {
            int i14 = this.previousCount;
            if (i14 > 0 && this.previousMoveFrom == i11 - i14 && this.previousMoveTo == i12 - i14) {
                this.previousCount = i14 + i13;
                return;
            }
            realizeMovement();
            this.previousMoveFrom = i11;
            this.previousMoveTo = i12;
            this.previousCount = i13;
        }
    }

    private final void recordReaderMoving(int i11) {
        this.writersReaderDelta = i11 - (this.reader.getCurrentGroup() - this.writersReaderDelta);
    }

    private final void recordRemoveNode(int i11, int i12) {
        boolean z11;
        if (i12 > 0) {
            if (i11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                ComposerKt.composeRuntimeError(("Invalid remove index " + i11).toString());
                throw new KotlinNothingValueException();
            } else if (this.previousRemove == i11) {
                this.previousCount += i12;
            } else {
                realizeMovement();
                this.previousRemove = i11;
                this.previousCount = i12;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r6.reader;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void recordSlotEditing() {
        /*
            r6 = this;
            androidx.compose.runtime.SlotReader r0 = r6.reader
            int r0 = r0.getSize()
            if (r0 <= 0) goto L_0x003e
            androidx.compose.runtime.SlotReader r0 = r6.reader
            int r1 = r0.getParent()
            androidx.compose.runtime.IntStack r2 = r6.startedGroups
            r3 = -2
            int r2 = r2.peekOr(r3)
            if (r2 == r1) goto L_0x003e
            boolean r2 = r6.startedGroup
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L_0x002b
            boolean r2 = r6.implicitRootStart
            if (r2 == 0) goto L_0x002b
            kotlin.jvm.functions.Function3 r2 = androidx.compose.runtime.ComposerKt.startRootGroup
            d(r6, r4, r2, r5, r3)
            r6.startedGroup = r5
        L_0x002b:
            if (r1 <= 0) goto L_0x003e
            androidx.compose.runtime.Anchor r0 = r0.anchor(r1)
            androidx.compose.runtime.IntStack r2 = r6.startedGroups
            r2.push(r1)
            androidx.compose.runtime.ComposerImpl$recordSlotEditing$1 r1 = new androidx.compose.runtime.ComposerImpl$recordSlotEditing$1
            r1.<init>(r0)
            d(r6, r4, r1, r5, r3)
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.recordSlotEditing():void");
    }

    private final void recordSlotEditingOperation(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        b(this, false, 1, (Object) null);
        recordSlotEditing();
        record(function3);
    }

    private final void recordSlotTableOperation(boolean z11, Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        realizeOperationLocation(z11);
        record(function3);
    }

    private final void recordUp() {
        if (this.downNodes.isNotEmpty()) {
            this.downNodes.pop();
        } else {
            this.pendingUps++;
        }
    }

    private final void recordUpsAndDowns(int i11, int i12, int i13) {
        SlotReader slotReader = this.reader;
        int access$nearestCommonRootOf = ComposerKt.nearestCommonRootOf(slotReader, i11, i12, i13);
        while (i11 > 0 && i11 != access$nearestCommonRootOf) {
            if (slotReader.isNode(i11)) {
                recordUp();
            }
            i11 = slotReader.parent(i11);
        }
        doRecordDownsFor(i12, access$nearestCommonRootOf);
    }

    private final void registerInsertUpFixup() {
        this.insertFixups.add(this.insertUpFixups.pop());
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public final void releaseMovableGroupAtCurrent(MovableContentStateReference movableContentStateReference, SlotWriter slotWriter) {
        SlotTable slotTable2 = new SlotTable();
        SlotWriter openWriter = slotTable2.openWriter();
        try {
            openWriter.beginInsert();
            openWriter.startGroup(MovableContentKt.movableContentKey, movableContentStateReference.getContent$runtime_release());
            SlotWriter.markGroup$default(openWriter, 0, 1, (Object) null);
            openWriter.update(movableContentStateReference.getParameter$runtime_release());
            slotWriter.moveTo(movableContentStateReference.getAnchor$runtime_release(), 1, openWriter);
            openWriter.skipGroup();
            openWriter.endGroup();
            openWriter.endInsert();
            Unit unit = Unit.INSTANCE;
            openWriter.close();
            this.parentContext.movableContentStateReleased$runtime_release(movableContentStateReference, new MovableContentState(slotTable2));
        } catch (Throwable th2) {
            openWriter.close();
            throw th2;
        }
    }

    private final void reportAllMovableContent() {
        List access$getChanges$p;
        if (this.slotTable.containsMark()) {
            ArrayList arrayList = new ArrayList();
            this.deferredChanges = arrayList;
            SlotReader openReader = this.slotTable.openReader();
            try {
                this.reader = openReader;
                access$getChanges$p = this.changes;
                this.changes = arrayList;
                reportFreeMovableContent(0);
                realizeUps();
                if (this.startedGroup) {
                    record(ComposerKt.skipToGroupEndInstance);
                    recordEndRoot();
                }
                Unit unit = Unit.INSTANCE;
                this.changes = access$getChanges$p;
                openReader.close();
            } catch (Throwable th2) {
                openReader.close();
                throw th2;
            }
        }
    }

    private final void reportFreeMovableContent(int i11) {
        reportFreeMovableContent$reportGroup(this, i11, false, 0);
        realizeMovement();
    }

    private static final int reportFreeMovableContent$reportGroup(ComposerImpl composerImpl, int i11, boolean z11, int i12) {
        boolean z12;
        int i13;
        CompositionContextHolder compositionContextHolder;
        ComposerImpl composerImpl2 = composerImpl;
        int i14 = i11;
        int i15 = i12;
        int i16 = 1;
        if (composerImpl2.reader.hasMark(i14)) {
            int groupKey = composerImpl2.reader.groupKey(i14);
            Object groupObjectKey = composerImpl2.reader.groupObjectKey(i14);
            if (groupKey == 126665345 && (groupObjectKey instanceof MovableContent)) {
                MovableContent movableContent = (MovableContent) groupObjectKey;
                Object groupGet = composerImpl2.reader.groupGet(i14, 0);
                Anchor anchor = composerImpl2.reader.anchor(i14);
                List access$filterToRange = ComposerKt.filterToRange(composerImpl2.invalidations, i14, composerImpl2.reader.groupSize(i14) + i14);
                ArrayList arrayList = new ArrayList(access$filterToRange.size());
                int size = access$filterToRange.size();
                for (int i17 = 0; i17 < size; i17++) {
                    Invalidation invalidation = (Invalidation) access$filterToRange.get(i17);
                    arrayList.add(TuplesKt.to(invalidation.getScope(), invalidation.getInstances()));
                }
                MovableContentStateReference movableContentStateReference = new MovableContentStateReference(movableContent, groupGet, composerImpl.getComposition(), composerImpl2.slotTable, anchor, arrayList, composerImpl2.currentCompositionLocalScope(Integer.valueOf(i11)));
                composerImpl2.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
                composerImpl.recordSlotEditing();
                composerImpl2.record(new ComposerImpl$reportFreeMovableContent$reportGroup$1(composerImpl2, movableContentStateReference));
                if (!z11) {
                    return composerImpl2.reader.nodeCount(i14);
                }
                composerImpl.realizeMovement();
                composerImpl.realizeUps();
                composerImpl.realizeDowns();
                if (!composerImpl2.reader.isNode(i14)) {
                    i16 = composerImpl2.reader.nodeCount(i14);
                }
                if (i16 <= 0) {
                    return 0;
                }
                composerImpl2.recordRemoveNode(i15, i16);
                return 0;
            } else if (groupKey != 206 || !Intrinsics.areEqual(groupObjectKey, ComposerKt.getReference())) {
                return composerImpl2.reader.nodeCount(i14);
            } else {
                Object groupGet2 = composerImpl2.reader.groupGet(i14, 0);
                if (groupGet2 instanceof CompositionContextHolder) {
                    compositionContextHolder = (CompositionContextHolder) groupGet2;
                } else {
                    compositionContextHolder = null;
                }
                if (compositionContextHolder != null) {
                    for (ComposerImpl reportAllMovableContent : compositionContextHolder.getRef().getComposers()) {
                        reportAllMovableContent.reportAllMovableContent();
                    }
                }
                return composerImpl2.reader.nodeCount(i14);
            }
        } else if (!composerImpl2.reader.containsMark(i14)) {
            return composerImpl2.reader.nodeCount(i14);
        } else {
            int groupSize = composerImpl2.reader.groupSize(i14) + i14;
            int i18 = 0;
            for (int i19 = i14 + 1; i19 < groupSize; i19 += composerImpl2.reader.groupSize(i19)) {
                boolean isNode = composerImpl2.reader.isNode(i19);
                if (isNode) {
                    composerImpl.realizeMovement();
                    composerImpl2.recordDown(composerImpl2.reader.node(i19));
                }
                if (isNode || z11) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (isNode) {
                    i13 = 0;
                } else {
                    i13 = i15 + i18;
                }
                i18 += reportFreeMovableContent$reportGroup(composerImpl2, i19, z12, i13);
                if (isNode) {
                    composerImpl.realizeMovement();
                    composerImpl.recordUp();
                }
            }
            return i18;
        }
    }

    private final <T> T resolveCompositionLocal(CompositionLocal<T> compositionLocal, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
        if (ComposerKt.contains(persistentMap, compositionLocal)) {
            return ComposerKt.getValueOf(persistentMap, compositionLocal);
        }
        return compositionLocal.getDefaultValueHolder$runtime_release().getValue();
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    private final void start(int i11, Object obj, boolean z11, Object obj2) {
        int i12;
        validateNodeNotExpected();
        updateCompoundKeyWhenWeEnterGroup(i11, obj, obj2);
        Pending pending2 = null;
        if (getInserting()) {
            this.reader.beginEmpty();
            int currentGroup = this.writer.getCurrentGroup();
            if (z11) {
                this.writer.startNode(Composer.Companion.getEmpty());
            } else if (obj2 != null) {
                SlotWriter slotWriter = this.writer;
                if (obj == null) {
                    obj = Composer.Companion.getEmpty();
                }
                slotWriter.startData(i11, obj, obj2);
            } else {
                SlotWriter slotWriter2 = this.writer;
                if (obj == null) {
                    obj = Composer.Companion.getEmpty();
                }
                slotWriter2.startGroup(i11, obj);
            }
            Pending pending3 = this.pending;
            if (pending3 != null) {
                KeyInfo keyInfo = new KeyInfo(i11, -1, insertedGroupVirtualIndex(currentGroup), -1, 0);
                pending3.registerInsert(keyInfo, this.nodeIndex - pending3.getStartIndex());
                pending3.recordUsed(keyInfo);
            }
            enterGroup(z11, (Pending) null);
            return;
        }
        if (this.pending == null) {
            if (this.reader.getGroupKey() != i11 || !Intrinsics.areEqual(obj, this.reader.getGroupObjectKey())) {
                this.pending = new Pending(this.reader.extractKeys(), this.nodeIndex);
            } else {
                startReaderGroup(z11, obj2);
            }
        }
        Pending pending4 = this.pending;
        if (pending4 != null) {
            KeyInfo next = pending4.getNext(i11, obj);
            if (next != null) {
                pending4.recordUsed(next);
                int location = next.getLocation();
                this.nodeIndex = pending4.nodePositionOf(next) + pending4.getStartIndex();
                int slotPositionOf = pending4.slotPositionOf(next);
                int groupIndex = slotPositionOf - pending4.getGroupIndex();
                pending4.registerMoveSlot(slotPositionOf, pending4.getGroupIndex());
                recordReaderMoving(location);
                this.reader.reposition(location);
                if (groupIndex > 0) {
                    recordSlotEditingOperation(new ComposerImpl$start$2(groupIndex));
                }
                startReaderGroup(z11, obj2);
            } else {
                this.reader.beginEmpty();
                this.inserting = true;
                this.providerCache = null;
                ensureWriter();
                this.writer.beginInsert();
                int currentGroup2 = this.writer.getCurrentGroup();
                if (z11) {
                    this.writer.startNode(Composer.Companion.getEmpty());
                } else if (obj2 != null) {
                    SlotWriter slotWriter3 = this.writer;
                    if (obj == null) {
                        obj = Composer.Companion.getEmpty();
                    }
                    slotWriter3.startData(i11, obj, obj2);
                } else {
                    SlotWriter slotWriter4 = this.writer;
                    if (obj == null) {
                        obj = Composer.Companion.getEmpty();
                    }
                    slotWriter4.startGroup(i11, obj);
                }
                this.insertAnchor = this.writer.anchor(currentGroup2);
                KeyInfo keyInfo2 = new KeyInfo(i11, -1, insertedGroupVirtualIndex(currentGroup2), -1, 0);
                pending4.registerInsert(keyInfo2, this.nodeIndex - pending4.getStartIndex());
                pending4.recordUsed(keyInfo2);
                ArrayList arrayList = new ArrayList();
                if (z11) {
                    i12 = 0;
                } else {
                    i12 = this.nodeIndex;
                }
                pending2 = new Pending(arrayList, i12);
            }
        }
        enterGroup(z11, pending2);
    }

    private final void startGroup(int i11) {
        start(i11, (Object) null, false, (Object) null);
    }

    private final void startReaderGroup(boolean z11, Object obj) {
        if (z11) {
            this.reader.startNode();
            return;
        }
        if (!(obj == null || this.reader.getGroupAux() == obj)) {
            d(this, false, new ComposerImpl$startReaderGroup$1(obj), 1, (Object) null);
        }
        this.reader.startGroup();
    }

    private final void startRoot() {
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime_release();
        this.parentProvider = this.parentContext.getCompositionLocalScope$runtime_release();
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = changed((Object) this.parentProvider);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation$runtime_release();
        }
        Set set = (Set) resolveCompositionLocal(InspectionTablesKt.getLocalInspectionTables(), this.parentProvider);
        if (set != null) {
            set.add(this.slotTable);
            this.parentContext.recordInspectionTable$runtime_release(set);
        }
        startGroup(this.parentContext.getCompoundHashKey$runtime_release());
    }

    private final void updateCompoundKeyWhenWeEnterGroup(int i11, Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null || i11 != 207 || Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                updateCompoundKeyWhenWeEnterGroupKeyHash(i11);
            } else {
                updateCompoundKeyWhenWeEnterGroupKeyHash(obj2.hashCode());
            }
        } else if (obj instanceof Enum) {
            updateCompoundKeyWhenWeEnterGroupKeyHash(((Enum) obj).ordinal());
        } else {
            updateCompoundKeyWhenWeEnterGroupKeyHash(obj.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroupKeyHash(int i11) {
        this.compoundKeyHash = i11 ^ Integer.rotateLeft(getCompoundKeyHash(), 3);
    }

    private final void updateCompoundKeyWhenWeExitGroup(int i11, Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null || i11 != 207 || Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                updateCompoundKeyWhenWeExitGroupKeyHash(i11);
            } else {
                updateCompoundKeyWhenWeExitGroupKeyHash(obj2.hashCode());
            }
        } else if (obj instanceof Enum) {
            updateCompoundKeyWhenWeExitGroupKeyHash(((Enum) obj).ordinal());
        } else {
            updateCompoundKeyWhenWeExitGroupKeyHash(obj.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeExitGroupKeyHash(int i11) {
        this.compoundKeyHash = Integer.rotateRight(i11 ^ getCompoundKeyHash(), 3);
    }

    private final void updateNodeCount(int i11, int i12) {
        if (updatedNodeCount(i11) == i12) {
            return;
        }
        if (i11 < 0) {
            HashMap<Integer, Integer> hashMap = this.nodeCountVirtualOverrides;
            if (hashMap == null) {
                hashMap = new HashMap<>();
                this.nodeCountVirtualOverrides = hashMap;
            }
            hashMap.put(Integer.valueOf(i11), Integer.valueOf(i12));
            return;
        }
        int[] iArr = this.nodeCountOverrides;
        if (iArr == null) {
            iArr = new int[this.reader.getSize()];
            ArraysKt___ArraysJvmKt.fill$default(iArr, -1, 0, 0, 6, (Object) null);
            this.nodeCountOverrides = iArr;
        }
        iArr[i11] = i12;
    }

    private final void updateNodeCountOverrides(int i11, int i12) {
        int updatedNodeCount = updatedNodeCount(i11);
        if (updatedNodeCount != i12) {
            int i13 = i12 - updatedNodeCount;
            int size = this.pendingStack.getSize() - 1;
            while (i11 != -1) {
                int updatedNodeCount2 = updatedNodeCount(i11) + i13;
                updateNodeCount(i11, updatedNodeCount2);
                int i14 = size;
                while (true) {
                    if (-1 < i14) {
                        Pending peek = this.pendingStack.peek(i14);
                        if (peek != null && peek.updateNodeCount(i11, updatedNodeCount2)) {
                            size = i14 - 1;
                            break;
                        }
                        i14--;
                    } else {
                        break;
                    }
                }
                if (i11 < 0) {
                    i11 = this.reader.getParent();
                } else if (!this.reader.isNode(i11)) {
                    i11 = this.reader.parent(i11);
                } else {
                    return;
                }
            }
        }
    }

    private final PersistentMap<CompositionLocal<Object>, State<Object>> updateProviderMapGroup(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap2) {
        PersistentMap.Builder<CompositionLocal<Object>, ? extends State<? extends Object>> builder = persistentMap.builder();
        builder.putAll(persistentMap2);
        PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> build = builder.build();
        startGroup(204, ComposerKt.getProviderMaps());
        changed((Object) build);
        changed((Object) persistentMap2);
        endGroup();
        return build;
    }

    private final int updatedNodeCount(int i11) {
        int i12;
        Integer num;
        if (i11 < 0) {
            HashMap<Integer, Integer> hashMap = this.nodeCountVirtualOverrides;
            if (hashMap == null || (num = hashMap.get(Integer.valueOf(i11))) == null) {
                return 0;
            }
            return num.intValue();
        }
        int[] iArr = this.nodeCountOverrides;
        if (iArr == null || (i12 = iArr[i11]) < 0) {
            return this.reader.nodeCount(i11);
        }
        return i12;
    }

    private final void validateNodeExpected() {
        if (this.nodeExpected) {
            this.nodeExpected = false;
        } else {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void validateNodeNotExpected() {
        if (!(!this.nodeExpected)) {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final <R> R withChanges(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list, Function0<? extends R> function0) {
        List access$getChanges$p = this.changes;
        try {
            this.changes = list;
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            this.changes = access$getChanges$p;
            InlineMarker.finallyEnd(1);
        }
    }

    private final <R> R withReader(SlotReader slotReader, Function0<? extends R> function0) {
        SlotReader access$getReader$p = this.reader;
        int[] access$getNodeCountOverrides$p = this.nodeCountOverrides;
        this.nodeCountOverrides = null;
        try {
            this.reader = slotReader;
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            this.reader = access$getReader$p;
            this.nodeCountOverrides = access$getNodeCountOverrides$p;
            InlineMarker.finallyEnd(1);
        }
    }

    public <V, T> void apply(V v11, @NotNull Function2<? super T, ? super V, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        ComposerImpl$apply$operation$1 composerImpl$apply$operation$1 = new ComposerImpl$apply$operation$1(function2, v11);
        if (getInserting()) {
            recordFixup(composerImpl$apply$operation$1);
        } else {
            recordApplierOperation(composerImpl$apply$operation$1);
        }
    }

    @NotNull
    public CompositionContext buildContext() {
        CompositionContextHolder compositionContextHolder;
        startGroup(206, ComposerKt.getReference());
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, (Object) null);
        }
        Object nextSlot = nextSlot();
        if (nextSlot instanceof CompositionContextHolder) {
            compositionContextHolder = (CompositionContextHolder) nextSlot;
        } else {
            compositionContextHolder = null;
        }
        if (compositionContextHolder == null) {
            compositionContextHolder = new CompositionContextHolder(new CompositionContextImpl(getCompoundKeyHash(), this.forceRecomposeScopes));
            updateValue(compositionContextHolder);
        }
        compositionContextHolder.getRef().updateCompositionLocalScope(a(this, (Integer) null, 1, (Object) null));
        endGroup();
        return compositionContextHolder.getRef();
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean z11, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        T nextSlot = nextSlot();
        if (nextSlot != Composer.Companion.getEmpty() && !z11) {
            return nextSlot;
        }
        T invoke = function0.invoke();
        updateValue(invoke);
        return invoke;
    }

    @ComposeCompilerApi
    public boolean changed(@Nullable Object obj) {
        if (Intrinsics.areEqual(nextSlot(), obj)) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    public final void changesApplied$runtime_release() {
        this.providerUpdates.clear();
    }

    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
    }

    public final void composeContent$runtime_release(@NotNull IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap, @NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(identityArrayMap, "invalidationsRequested");
        Intrinsics.checkNotNullParameter(function2, "content");
        if (this.changes.isEmpty()) {
            doCompose(identityArrayMap, function2);
        } else {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw new KotlinNothingValueException();
        }
    }

    @InternalComposeApi
    public <T> T consume(@NotNull CompositionLocal<T> compositionLocal) {
        Intrinsics.checkNotNullParameter(compositionLocal, "key");
        return resolveCompositionLocal(compositionLocal, a(this, (Integer) null, 1, (Object) null));
    }

    public <T> void createNode(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        validateNodeExpected();
        if (getInserting()) {
            int peek = this.nodeIndexStack.peek();
            SlotWriter slotWriter = this.writer;
            Anchor anchor = slotWriter.anchor(slotWriter.getParent());
            this.groupNodeCount++;
            recordFixup(new ComposerImpl$createNode$2(function0, anchor, peek));
            recordInsertUpFixup(new ComposerImpl$createNode$3(anchor, peek));
            return;
        }
        ComposerKt.composeRuntimeError("createNode() can only be called when inserting".toString());
        throw new KotlinNothingValueException();
    }

    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean z11) {
        boolean z12;
        if (this.groupNodeCount == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            ComposerKt.composeRuntimeError("No nodes can be emitted before calling dactivateToEndGroup".toString());
            throw new KotlinNothingValueException();
        } else if (getInserting()) {
        } else {
            if (!z11) {
                skipReaderToGroupEnd();
                return;
            }
            int currentGroup = this.reader.getCurrentGroup();
            int currentEnd = this.reader.getCurrentEnd();
            for (int i11 = currentGroup; i11 < currentEnd; i11++) {
                this.reader.forEachData$runtime_release(i11, new ComposerImpl$deactivateToEndGroup$2(this, i11));
            }
            ComposerKt.removeRange(this.invalidations, currentGroup, currentEnd);
            this.reader.reposition(currentGroup);
            this.reader.skipToGroupEnd();
        }
    }

    public void disableReusing() {
        this.reusing = false;
    }

    public final void dispose$runtime_release() {
        Trace trace = Trace.INSTANCE;
        Object beginSection = trace.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime_release(this);
            this.invalidateStack.clear();
            this.invalidations.clear();
            this.changes.clear();
            this.providerUpdates.clear();
            getApplier().clear();
            this.isDisposed = true;
            Unit unit = Unit.INSTANCE;
            trace.endSection(beginSection);
        } catch (Throwable th2) {
            Trace.INSTANCE.endSection(beginSection);
            throw th2;
        }
    }

    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getUsed()) {
            currentRecomposeScope$runtime_release.setDefaultsInScope(true);
        }
    }

    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    public void endNode() {
        end(true);
    }

    @InternalComposeApi
    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @Nullable
    @ComposeCompilerApi
    public ScopeUpdateScope endRestartGroup() {
        RecomposeScopeImpl recomposeScopeImpl;
        Anchor anchor;
        Function1<Composition, Unit> end;
        RecomposeScopeImpl recomposeScopeImpl2 = null;
        if (this.invalidateStack.isNotEmpty()) {
            recomposeScopeImpl = this.invalidateStack.pop();
        } else {
            recomposeScopeImpl = null;
        }
        if (recomposeScopeImpl != null) {
            recomposeScopeImpl.setRequiresRecompose(false);
        }
        if (!(recomposeScopeImpl == null || (end = recomposeScopeImpl.end(this.compositionToken)) == null)) {
            record(new ComposerImpl$endRestartGroup$1$1(end, this));
        }
        if (recomposeScopeImpl != null && !recomposeScopeImpl.getSkipped$runtime_release() && (recomposeScopeImpl.getUsed() || this.forceRecomposeScopes)) {
            if (recomposeScopeImpl.getAnchor() == null) {
                if (getInserting()) {
                    SlotWriter slotWriter = this.writer;
                    anchor = slotWriter.anchor(slotWriter.getParent());
                } else {
                    SlotReader slotReader = this.reader;
                    anchor = slotReader.anchor(slotReader.getParent());
                }
                recomposeScopeImpl.setAnchor(anchor);
            }
            recomposeScopeImpl.setDefaultsInvalid(false);
            recomposeScopeImpl2 = recomposeScopeImpl;
        }
        end(false);
        return recomposeScopeImpl2;
    }

    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    public final boolean forceRecomposeScopes$runtime_release() {
        if (this.forceRecomposeScopes) {
            return false;
        }
        this.forceRecomposeScopes = true;
        this.forciblyRecompose = true;
        return true;
    }

    @NotNull
    public Applier<?> getApplier() {
        return this.applier;
    }

    @NotNull
    public CoroutineContext getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext$runtime_release();
    }

    public final boolean getAreChildrenComposing$runtime_release() {
        return this.childrenComposing > 0;
    }

    public final int getChangeCount$runtime_release() {
        return this.changes.size();
    }

    @NotNull
    public ControlledComposition getComposition() {
        return this.composition;
    }

    @NotNull
    public CompositionData getCompositionData() {
        return this.slotTable;
    }

    public int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    @Nullable
    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        Stack<RecomposeScopeImpl> stack = this.invalidateStack;
        if (this.childrenComposing != 0 || !stack.isNotEmpty()) {
            return null;
        }
        return stack.peek();
    }

    public boolean getDefaultsInvalid() {
        if (this.providersInvalid) {
            return true;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        return currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getDefaultsInvalid();
    }

    @Nullable
    public final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> getDeferredChanges$runtime_release() {
        return this.deferredChanges;
    }

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    public final boolean getHasPendingChanges$runtime_release() {
        return !this.changes.isEmpty();
    }

    @NotNull
    public final SlotTable getInsertTable$runtime_release() {
        return this.insertTable;
    }

    public boolean getInserting() {
        return this.inserting;
    }

    @Nullable
    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime_release();
    }

    @Nullable
    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            return currentRecomposeScope$runtime_release.getAnchor();
        }
        return null;
    }

    public boolean getSkipping() {
        boolean z11;
        if (getInserting() || this.reusing || this.providersInvalid) {
            return false;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release == null || currentRecomposeScope$runtime_release.getRequiresRecompose()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 || this.forciblyRecompose) {
            return false;
        }
        return true;
    }

    @InternalComposeApi
    public void insertMovableContent(@NotNull MovableContent<?> movableContent, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(movableContent, "value");
        invokeMovableContentLambda(movableContent, a(this, (Integer) null, 1, (Object) null), obj, false);
    }

    @InternalComposeApi
    public void insertMovableContentReferences(@NotNull List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        Intrinsics.checkNotNullParameter(list, "references");
        try {
            insertMovableContentGuarded(list);
            cleanUpCompose();
        } catch (Throwable th2) {
            abortRoot();
            throw th2;
        }
    }

    public final boolean isComposing$runtime_release() {
        return this.isComposing;
    }

    public final boolean isDisposed$runtime_release() {
        return this.isDisposed;
    }

    @NotNull
    @ComposeCompilerApi
    public Object joinKey(@Nullable Object obj, @Nullable Object obj2) {
        Object access$getKey = ComposerKt.getKey(this.reader.getGroupObjectKey(), obj, obj2);
        return access$getKey == null ? new JoinedKey(obj, obj2) : access$getKey;
    }

    @Nullable
    @PublishedApi
    public final Object nextSlot() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }
        Object next = this.reader.next();
        if (this.reusing) {
            return Composer.Companion.getEmpty();
        }
        return next;
    }

    public final int parentKey$runtime_release() {
        if (getInserting()) {
            SlotWriter slotWriter = this.writer;
            return slotWriter.groupKey(slotWriter.getParent());
        }
        SlotReader slotReader = this.reader;
        return slotReader.groupKey(slotReader.getParent());
    }

    public final void prepareCompose$runtime_release(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (!this.isComposing) {
            this.isComposing = true;
            try {
                function0.invoke();
            } finally {
                this.isComposing = false;
            }
        } else {
            ComposerKt.composeRuntimeError("Preparing a composition while composing is not supported".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final boolean recompose$runtime_release(@NotNull IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap) {
        Intrinsics.checkNotNullParameter(identityArrayMap, "invalidationsRequested");
        if (!this.changes.isEmpty()) {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw new KotlinNothingValueException();
        } else if (!identityArrayMap.isNotEmpty() && !(!this.invalidations.isEmpty()) && !this.forciblyRecompose) {
            return false;
        } else {
            doCompose(identityArrayMap, (Function2<? super Composer, ? super Integer, Unit>) null);
            return !this.changes.isEmpty();
        }
    }

    public void recordSideEffect(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "effect");
        record(new ComposerImpl$recordSideEffect$1(function0));
    }

    public void recordUsed(@NotNull RecomposeScope recomposeScope) {
        RecomposeScopeImpl recomposeScopeImpl;
        Intrinsics.checkNotNullParameter(recomposeScope, "scope");
        if (recomposeScope instanceof RecomposeScopeImpl) {
            recomposeScopeImpl = (RecomposeScopeImpl) recomposeScope;
        } else {
            recomposeScopeImpl = null;
        }
        if (recomposeScopeImpl != null) {
            recomposeScopeImpl.setUsed(true);
        }
    }

    @Nullable
    public Object rememberedValue() {
        return nextSlot();
    }

    public final void setDeferredChanges$runtime_release(@Nullable List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list) {
        this.deferredChanges = list;
    }

    public final void setInsertTable$runtime_release(@NotNull SlotTable slotTable2) {
        Intrinsics.checkNotNullParameter(slotTable2, "<set-?>");
        this.insertTable = slotTable2;
    }

    @ComposeCompilerApi
    public void skipCurrentGroup() {
        if (this.invalidations.isEmpty()) {
            skipGroup();
            return;
        }
        SlotReader slotReader = this.reader;
        int groupKey = slotReader.getGroupKey();
        Object groupObjectKey = slotReader.getGroupObjectKey();
        Object groupAux = slotReader.getGroupAux();
        updateCompoundKeyWhenWeEnterGroup(groupKey, groupObjectKey, groupAux);
        startReaderGroup(slotReader.isNode(), (Object) null);
        recomposeToGroupEnd();
        slotReader.endGroup();
        updateCompoundKeyWhenWeExitGroup(groupKey, groupObjectKey, groupAux);
    }

    @ComposeCompilerApi
    public void skipToGroupEnd() {
        boolean z11;
        if (this.groupNodeCount == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
            if (currentRecomposeScope$runtime_release != null) {
                currentRecomposeScope$runtime_release.scopeSkipped();
            }
            if (this.invalidations.isEmpty()) {
                skipReaderToGroupEnd();
            } else {
                recomposeToGroupEnd();
            }
        } else {
            ComposerKt.composeRuntimeError("No nodes can be emitted before calling skipAndEndGroup".toString());
            throw new KotlinNothingValueException();
        }
    }

    @ComposeCompilerApi
    public void sourceInformation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "sourceInformation");
        if (getInserting()) {
            this.writer.insertAux(str);
        }
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        end(false);
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "sourceInformation");
        start(i11, (Object) null, false, str);
    }

    @ComposeCompilerApi
    public void startDefaults() {
        start(-127, (Object) null, false, (Object) null);
    }

    @ComposeCompilerApi
    public void startMovableGroup(int i11, @Nullable Object obj) {
        start(i11, obj, false, (Object) null);
    }

    public void startNode() {
        int i11 = 125;
        if (!getInserting() && (!this.reusing ? this.reader.getGroupKey() == 126 : this.reader.getGroupKey() == 125)) {
            i11 = 126;
        }
        start(i11, (Object) null, true, (Object) null);
        this.nodeExpected = true;
    }

    @InternalComposeApi
    public void startProviders(@NotNull ProvidedValue<?>[] providedValueArr) {
        PersistentMap<CompositionLocal<Object>, State<Object>> persistentMap;
        boolean z11;
        Intrinsics.checkNotNullParameter(providedValueArr, "values");
        PersistentMap a11 = a(this, (Integer) null, 1, (Object) null);
        startGroup(201, ComposerKt.getProvider());
        startGroup(203, ComposerKt.getProviderValues());
        PersistentMap persistentMap2 = (PersistentMap) ActualJvm_jvmKt.invokeComposableForResult(this, new ComposerImpl$startProviders$currentProviders$1(providedValueArr, a11));
        endGroup();
        if (getInserting()) {
            persistentMap = updateProviderMapGroup(a11, persistentMap2);
            this.writerHasAProvider = true;
        } else {
            Object groupGet = this.reader.groupGet(0);
            Intrinsics.checkNotNull(groupGet, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
            PersistentMap<CompositionLocal<Object>, State<Object>> persistentMap3 = (PersistentMap) groupGet;
            Object groupGet2 = this.reader.groupGet(1);
            Intrinsics.checkNotNull(groupGet2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
            PersistentMap persistentMap4 = (PersistentMap) groupGet2;
            if (!getSkipping() || !Intrinsics.areEqual((Object) persistentMap4, (Object) persistentMap2)) {
                persistentMap = updateProviderMapGroup(a11, persistentMap2);
                z11 = !Intrinsics.areEqual((Object) persistentMap, (Object) persistentMap3);
                if (z11 && !getInserting()) {
                    this.providerUpdates.put(Integer.valueOf(this.reader.getCurrentGroup()), persistentMap);
                }
                this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
                this.providersInvalid = z11;
                this.providerCache = persistentMap;
                start(202, ComposerKt.getCompositionLocalMap(), false, persistentMap);
            }
            skipGroup();
            persistentMap = persistentMap3;
        }
        z11 = false;
        this.providerUpdates.put(Integer.valueOf(this.reader.getCurrentGroup()), persistentMap);
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z11;
        this.providerCache = persistentMap;
        start(202, ComposerKt.getCompositionLocalMap(), false, persistentMap);
    }

    @ComposeCompilerApi
    public void startReplaceableGroup(int i11) {
        start(i11, (Object) null, false, (Object) null);
    }

    @NotNull
    @ComposeCompilerApi
    public Composer startRestartGroup(int i11) {
        start(i11, (Object) null, false, (Object) null);
        addRecomposeScope();
        return this;
    }

    public void startReusableGroup(int i11, @Nullable Object obj) {
        if (this.reader.getGroupKey() == i11 && !Intrinsics.areEqual(this.reader.getGroupAux(), obj) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        start(i11, (Object) null, false, obj);
    }

    public void startReusableNode() {
        start(125, (Object) null, true, (Object) null);
        this.nodeExpected = true;
    }

    public final boolean tryImminentInvalidation$runtime_release(@NotNull RecomposeScopeImpl recomposeScopeImpl, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null) {
            return false;
        }
        int indexFor = anchor.toIndexFor(this.slotTable);
        if (!this.isComposing || indexFor < this.reader.getCurrentGroup()) {
            return false;
        }
        ComposerKt.insertIfMissing(this.invalidations, indexFor, recomposeScopeImpl, obj);
        return true;
    }

    @PublishedApi
    public final void updateCachedValue(@Nullable Object obj) {
        updateValue(obj);
    }

    public void updateRememberedValue(@Nullable Object obj) {
        updateValue(obj);
    }

    @PublishedApi
    public final void updateValue(@Nullable Object obj) {
        if (getInserting()) {
            this.writer.update(obj);
            if (obj instanceof RememberObserver) {
                record(new ComposerImpl$updateValue$1(obj));
                this.abandonSet.add(obj);
                return;
            }
            return;
        }
        int groupSlotIndex = this.reader.getGroupSlotIndex() - 1;
        if (obj instanceof RememberObserver) {
            this.abandonSet.add(obj);
        }
        recordSlotTableOperation(true, new ComposerImpl$updateValue$2(obj, groupSlotIndex));
    }

    public void useNode() {
        validateNodeExpected();
        if (!getInserting()) {
            recordDown(getNode(this.reader));
        } else {
            ComposerKt.composeRuntimeError("useNode() called while inserting".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void verifyConsistent$runtime_release() {
        this.insertTable.verifyWellFormed();
    }

    private final void realizeDowns() {
        if (this.downNodes.isNotEmpty()) {
            realizeDowns(this.downNodes.toArray());
            this.downNodes.clear();
        }
    }

    /* access modifiers changed from: private */
    public final void startGroup(int i11, Object obj) {
        start(i11, obj, false, (Object) null);
    }

    @ComposeCompilerApi
    public boolean changed(char c11) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Character) && c11 == ((Character) nextSlot).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(c11));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(byte b11) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Byte) && b11 == ((Number) nextSlot).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(b11));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(short s11) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Short) && s11 == ((Number) nextSlot).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(s11));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(boolean z11) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Boolean) && z11 == ((Boolean) nextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(z11));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(float f11) {
        Object nextSlot = nextSlot();
        if (nextSlot instanceof Float) {
            if (f11 == ((Number) nextSlot).floatValue()) {
                return false;
            }
        }
        updateValue(Float.valueOf(f11));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(long j11) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Long) && j11 == ((Number) nextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(j11));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(double d11) {
        Object nextSlot = nextSlot();
        if (nextSlot instanceof Double) {
            if (d11 == ((Number) nextSlot).doubleValue()) {
                return false;
            }
        }
        updateValue(Double.valueOf(d11));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(int i11) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Integer) && i11 == ((Number) nextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(i11));
        return true;
    }
}
