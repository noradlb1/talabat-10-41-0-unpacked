package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.UtilsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aQ\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0001¢\u0006\u0002\u0010\f\u001a\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\nH\u0001\u001a-\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0001¢\u0006\u0002\u0010\u000f\u001aQ\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\nH\u0001\u001a-\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0001¢\u0006\u0002\u0010\f\u001a \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0000\u001aQ\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\nH\u0000\u001a-\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0000¢\u0006\u0002\u0010\f\u001a\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\nH\u0000\u001a-\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0000¢\u0006\u0002\u0010\u000f\u001a \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0000\u001aQ\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\nH\u0000\u001a-\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0000¢\u0006\u0002\u0010\f\u001a-\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0004\u001a-\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0004\u001a,\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\u0006\u0010\u001b\u001a\u0002H\nH\n¢\u0006\u0002\u0010\u001c\u001a4\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0002¢\u0006\u0002\u0010\u001d\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0002\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0002\u001a,\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\u0006\u0010\u001b\u001a\u0002H\nH\n¢\u0006\u0002\u0010\u001f\u001a4\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0002¢\u0006\u0002\u0010 \u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0002\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0002\u001a@\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010!\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010\"\u001aH\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005H\u0002¢\u0006\u0002\u0010$\u001aA\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0019H\u0002\u001aA\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001eH\u0002\u001a,\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u001b\u001a\u0002H\nH\n¢\u0006\u0002\u0010%\u001a4\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0002¢\u0006\u0002\u0010&\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0002\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0002\u001a<\u0010'\u001a\b\u0012\u0004\u0012\u0002H(0\u000e\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u000e2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H(0+\u0012\u0004\u0012\u00020,0*H\bø\u0001\u0000\u001aV\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030-\u0012\u0004\u0012\u00020,0*H\bø\u0001\u0000\u001a<\u0010'\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\t2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H(0.\u0012\u0004\u0012\u00020,0*H\bø\u0001\u0000\u001a,\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\u0006\u0010\u001b\u001a\u0002H\nH\n¢\u0006\u0002\u0010\u001c\u001a4\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0002¢\u0006\u0002\u0010\u001d\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0002\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0002\u001a,\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\u0006\u0010\u001b\u001a\u0002H\nH\n¢\u0006\u0002\u0010\u001f\u001a4\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0002¢\u0006\u0002\u0010 \u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0002\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0002\u001aT\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005H\n¢\u0006\u0002\u00100\u001aG\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\n\u001aM\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0019H\n\u001aI\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u00102\u001a\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\n\u001aM\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u001eH\n\u001a,\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u001b\u001a\u0002H\nH\n¢\u0006\u0002\u0010%\u001a4\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0002¢\u0006\u0002\u0010&\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0002\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0002\u001aS\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005H\u0000¢\u0006\u0002\u00100\u001aL\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0019H\u0000\u001aH\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u00102\u001a\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001aL\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u001eH\u0000\u001a\u0012\u00105\u001a\b\u0012\u0004\u0012\u00020706*\u000208H\u0000\u001a\u001e\u00105\u001a\b\u0012\u0004\u0012\u0002H(06\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u00105\u001a\b\u0012\u0004\u0012\u0002H(06\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a0\u00109\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030:\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001a\u0012\u0010;\u001a\b\u0012\u0004\u0012\u0002070\t*\u000208H\u0000\u001a\u001e\u0010;\u001a\b\u0012\u0004\u0012\u0002H(0<\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010;\u001a\b\u0012\u0004\u0012\u0002H(0<\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a0\u0010=\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001a\u0012\u0010>\u001a\b\u0012\u0004\u0012\u0002070\t*\u000208H\u0000\u001a\u001e\u0010>\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010>\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a\u0012\u0010?\u001a\b\u0012\u0004\u0012\u0002070\u000e*\u000208H\u0000\u001a\u001e\u0010?\u001a\b\u0012\u0004\u0012\u0002H(0\u000e\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010?\u001a\b\u0012\u0004\u0012\u0002H(0\u000e\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a0\u0010@\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001a\u0012\u0010A\u001a\b\u0012\u0004\u0012\u0002070\t*\u000208H\u0000\u001a\u001e\u0010A\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010A\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006B"}, d2 = {"immutableHashMapOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "K", "V", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "immutableHashSetOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "E", "elements", "([Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "immutableListOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "([Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "immutableMapOf", "immutableSetOf", "persistentHashMapOf", "persistentHashSetOf", "persistentListOf", "persistentMapOf", "persistentSetOf", "intersect", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "", "minus", "element", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "Lkotlin/sequences/Sequence;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "key", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "keys", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "mutate", "T", "mutator", "Lkotlin/Function1;", "", "", "", "", "plus", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;[Lkotlin/Pair;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "pair", "map", "", "putAll", "toImmutableList", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "", "", "toImmutableMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableMap;", "toImmutableSet", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "toPersistentHashMap", "toPersistentHashSet", "toPersistentList", "toPersistentMap", "toPersistentSet", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ExtensionsKt {
    @NotNull
    @Deprecated(message = "Use persistentHashMapOf instead.", replaceWith = @ReplaceWith(expression = "persistentHashMapOf(*pairs)", imports = {}))
    public static final <K, V> PersistentMap<K, V> immutableHashMapOf(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        return persistentHashMapOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    @NotNull
    @Deprecated(message = "Use persistentHashSetOf instead.", replaceWith = @ReplaceWith(expression = "persistentHashSetOf(*elements)", imports = {}))
    public static final <E> PersistentSet<E> immutableHashSetOf(@NotNull E... eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        return persistentHashSetOf(Arrays.copyOf(eArr, eArr.length));
    }

    @NotNull
    @Deprecated(message = "Use persistentListOf instead.", replaceWith = @ReplaceWith(expression = "persistentListOf(*elements)", imports = {}))
    public static final <E> PersistentList<E> immutableListOf(@NotNull E... eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        return persistentListOf(Arrays.copyOf(eArr, eArr.length));
    }

    @NotNull
    @Deprecated(message = "Use persistentMapOf instead.", replaceWith = @ReplaceWith(expression = "persistentMapOf(*pairs)", imports = {}))
    public static final <K, V> PersistentMap<K, V> immutableMapOf(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        return persistentMapOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    @NotNull
    @Deprecated(message = "Use persistentSetOf instead.", replaceWith = @ReplaceWith(expression = "persistentSetOf(*elements)", imports = {}))
    public static final <E> PersistentSet<E> immutableSetOf(@NotNull E... eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        return persistentSetOf(Arrays.copyOf(eArr, eArr.length));
    }

    @NotNull
    public static final <E> PersistentSet<E> intersect(@NotNull PersistentSet<? extends E> persistentSet, @NotNull Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentSet.retainAll((Collection) iterable);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.retainAll(builder, iterable);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentCollection<E> minus(@NotNull PersistentCollection<? extends E> persistentCollection, E e11) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        return persistentCollection.remove(e11);
    }

    @NotNull
    public static final <T> PersistentSet<T> mutate(@NotNull PersistentSet<? extends T> persistentSet, @NotNull Function1<? super Set<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(function1, "mutator");
        PersistentSet.Builder<? extends T> builder = persistentSet.builder();
        function1.invoke(builder);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> persistentHashMapOf(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        PersistentHashMap emptyOf$runtime_release = PersistentHashMap.Companion.emptyOf$runtime_release();
        Intrinsics.checkNotNull(emptyOf$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder builder = emptyOf$runtime_release.builder();
        MapsKt__MapsKt.putAll(builder, pairArr);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> persistentHashSetOf(@NotNull E... eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        return PersistentHashSet.Companion.emptyOf$runtime_release().addAll(ArraysKt___ArraysJvmKt.asList((T[]) eArr));
    }

    @NotNull
    public static final <E> PersistentList<E> persistentListOf(@NotNull E... eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        return UtilsKt.persistentVectorOf().addAll(ArraysKt___ArraysJvmKt.asList((T[]) eArr));
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> persistentMapOf(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        PersistentOrderedMap emptyOf$runtime_release = PersistentOrderedMap.Companion.emptyOf$runtime_release();
        Intrinsics.checkNotNull(emptyOf$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder builder = emptyOf$runtime_release.builder();
        MapsKt__MapsKt.putAll(builder, pairArr);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> persistentSetOf(@NotNull E... eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        return PersistentOrderedSet.Companion.emptyOf$runtime_release().addAll(ArraysKt___ArraysJvmKt.asList((T[]) eArr));
    }

    @NotNull
    public static final <E> PersistentCollection<E> plus(@NotNull PersistentCollection<? extends E> persistentCollection, E e11) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        return persistentCollection.add(e11);
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> putAll(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        return persistentMap.putAll(map);
    }

    @NotNull
    public static final <T> ImmutableList<T> toImmutableList(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ImmutableList<T> immutableList = iterable instanceof ImmutableList ? (ImmutableList) iterable : null;
        return immutableList == null ? toPersistentList(iterable) : immutableList;
    }

    @NotNull
    public static final <K, V> ImmutableMap<K, V> toImmutableMap(@NotNull Map<K, ? extends V> map) {
        ImmutableMap<K, V> immutableMap;
        PersistentMap.Builder builder;
        Intrinsics.checkNotNullParameter(map, "<this>");
        PersistentMap persistentMap = null;
        if (map instanceof ImmutableMap) {
            immutableMap = (ImmutableMap) map;
        } else {
            immutableMap = null;
        }
        if (immutableMap != null) {
            return immutableMap;
        }
        if (map instanceof PersistentMap.Builder) {
            builder = (PersistentMap.Builder) map;
        } else {
            builder = null;
        }
        if (builder != null) {
            persistentMap = builder.build();
        }
        if (persistentMap != null) {
            return persistentMap;
        }
        return persistentMapOf().putAll(map);
    }

    @NotNull
    public static final <T> ImmutableSet<T> toImmutableSet(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        PersistentSet persistentSet = null;
        ImmutableSet<T> immutableSet = iterable instanceof ImmutableSet ? (ImmutableSet) iterable : null;
        if (immutableSet != null) {
            return immutableSet;
        }
        PersistentSet.Builder builder = iterable instanceof PersistentSet.Builder ? (PersistentSet.Builder) iterable : null;
        if (builder != null) {
            persistentSet = builder.build();
        }
        if (persistentSet != null) {
            return persistentSet;
        }
        return plus(persistentSetOf(), iterable);
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> toPersistentHashMap(@NotNull Map<K, ? extends V> map) {
        PersistentHashMap persistentHashMap;
        PersistentHashMapBuilder persistentHashMapBuilder;
        Intrinsics.checkNotNullParameter(map, "<this>");
        PersistentHashMap persistentHashMap2 = null;
        if (map instanceof PersistentHashMap) {
            persistentHashMap = (PersistentHashMap) map;
        } else {
            persistentHashMap = null;
        }
        if (persistentHashMap != null) {
            return persistentHashMap;
        }
        if (map instanceof PersistentHashMapBuilder) {
            persistentHashMapBuilder = (PersistentHashMapBuilder) map;
        } else {
            persistentHashMapBuilder = null;
        }
        if (persistentHashMapBuilder != null) {
            persistentHashMap2 = persistentHashMapBuilder.build();
        }
        if (persistentHashMap2 != null) {
            return persistentHashMap2;
        }
        return PersistentHashMap.Companion.emptyOf$runtime_release().putAll(map);
    }

    @NotNull
    public static final <T> PersistentSet<T> toPersistentHashSet(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        PersistentHashSet persistentHashSet = null;
        PersistentHashSet persistentHashSet2 = iterable instanceof PersistentHashSet ? (PersistentHashSet) iterable : null;
        if (persistentHashSet2 != null) {
            return persistentHashSet2;
        }
        PersistentHashSetBuilder persistentHashSetBuilder = iterable instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) iterable : null;
        if (persistentHashSetBuilder != null) {
            persistentHashSet = persistentHashSetBuilder.build();
        }
        if (persistentHashSet != null) {
            return persistentHashSet;
        }
        return plus(PersistentHashSet.Companion.emptyOf$runtime_release(), iterable);
    }

    @NotNull
    public static final <T> PersistentList<T> toPersistentList(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        PersistentList<T> persistentList = null;
        PersistentList<T> persistentList2 = iterable instanceof PersistentList ? (PersistentList) iterable : null;
        if (persistentList2 != null) {
            return persistentList2;
        }
        PersistentList.Builder builder = iterable instanceof PersistentList.Builder ? (PersistentList.Builder) iterable : null;
        if (builder != null) {
            persistentList = builder.build();
        }
        return persistentList == null ? plus(persistentListOf(), iterable) : persistentList;
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> toPersistentMap(@NotNull Map<K, ? extends V> map) {
        PersistentOrderedMap persistentOrderedMap;
        PersistentOrderedMapBuilder persistentOrderedMapBuilder;
        Intrinsics.checkNotNullParameter(map, "<this>");
        PersistentMap<K, V> persistentMap = null;
        if (map instanceof PersistentOrderedMap) {
            persistentOrderedMap = (PersistentOrderedMap) map;
        } else {
            persistentOrderedMap = null;
        }
        if (persistentOrderedMap != null) {
            return persistentOrderedMap;
        }
        if (map instanceof PersistentOrderedMapBuilder) {
            persistentOrderedMapBuilder = (PersistentOrderedMapBuilder) map;
        } else {
            persistentOrderedMapBuilder = null;
        }
        if (persistentOrderedMapBuilder != null) {
            persistentMap = persistentOrderedMapBuilder.build();
        }
        if (persistentMap == null) {
            return PersistentOrderedMap.Companion.emptyOf$runtime_release().putAll(map);
        }
        return persistentMap;
    }

    @NotNull
    public static final <T> PersistentSet<T> toPersistentSet(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        PersistentSet<T> persistentSet = null;
        PersistentOrderedSet persistentOrderedSet = iterable instanceof PersistentOrderedSet ? (PersistentOrderedSet) iterable : null;
        if (persistentOrderedSet != null) {
            return persistentOrderedSet;
        }
        PersistentOrderedSetBuilder persistentOrderedSetBuilder = iterable instanceof PersistentOrderedSetBuilder ? (PersistentOrderedSetBuilder) iterable : null;
        if (persistentOrderedSetBuilder != null) {
            persistentSet = persistentOrderedSetBuilder.build();
        }
        return persistentSet == null ? plus(PersistentOrderedSet.Companion.emptyOf$runtime_release(), iterable) : persistentSet;
    }

    @NotNull
    @Deprecated(message = "Use persistentListOf instead.", replaceWith = @ReplaceWith(expression = "persistentListOf()", imports = {}))
    public static final <E> PersistentList<E> immutableListOf() {
        return persistentListOf();
    }

    @NotNull
    @Deprecated(message = "Use persistentSetOf instead.", replaceWith = @ReplaceWith(expression = "persistentSetOf()", imports = {}))
    public static final <E> PersistentSet<E> immutableSetOf() {
        return persistentSetOf();
    }

    @NotNull
    public static final <E> PersistentCollection<E> minus(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentCollection.removeAll((Collection<? extends Object>) (Collection) iterable);
        }
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(builder, iterable);
        return builder.build();
    }

    @NotNull
    public static final <T> PersistentList<T> mutate(@NotNull PersistentList<? extends T> persistentList, @NotNull Function1<? super List<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(function1, "mutator");
        PersistentList.Builder<? extends T> builder = persistentList.builder();
        function1.invoke(builder);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> persistentHashSetOf() {
        return PersistentHashSet.Companion.emptyOf$runtime_release();
    }

    @NotNull
    public static final <E> PersistentList<E> persistentListOf() {
        return UtilsKt.persistentVectorOf();
    }

    @NotNull
    public static final <E> PersistentSet<E> persistentSetOf() {
        return PersistentOrderedSet.Companion.emptyOf$runtime_release();
    }

    @NotNull
    public static final <E> PersistentCollection<E> plus(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentCollection.addAll((Collection) iterable);
        }
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(builder, iterable);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> putAll(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        MapsKt__MapsKt.putAll(builder, iterable);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentCollection<E> minus(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull E[] eArr) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(eArr, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(builder, (T[]) eArr);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> mutate(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Function1<? super Map<K, V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(function1, "mutator");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        function1.invoke(builder);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentCollection<E> plus(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull E[] eArr) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(eArr, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(builder, (T[]) eArr);
        return builder.build();
    }

    @NotNull
    public static final <T> ImmutableList<T> toImmutableList(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return toPersistentList(sequence);
    }

    @NotNull
    public static final <E> PersistentCollection<E> minus(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(builder, sequence);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentCollection<E> plus(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(builder, sequence);
        return builder.build();
    }

    @NotNull
    public static final ImmutableList<Character> toImmutableList(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return toPersistentList(charSequence);
    }

    @NotNull
    public static final <T> ImmutableSet<T> toImmutableSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return toPersistentSet(sequence);
    }

    @NotNull
    public static final <T> PersistentSet<T> toPersistentHashSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return plus(persistentHashSetOf(), sequence);
    }

    @NotNull
    public static final <T> PersistentList<T> toPersistentList(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return plus(persistentListOf(), sequence);
    }

    @NotNull
    public static final <T> PersistentSet<T> toPersistentSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return plus(persistentSetOf(), sequence);
    }

    @NotNull
    public static final <E> PersistentSet<E> intersect(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        return intersect(toPersistentSet(persistentCollection), iterable);
    }

    @NotNull
    public static final <E> PersistentList<E> minus(@NotNull PersistentList<? extends E> persistentList, E e11) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        return persistentList.remove(e11);
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> persistentHashMapOf() {
        return PersistentHashMap.Companion.emptyOf$runtime_release();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> persistentMapOf() {
        return PersistentOrderedMap.Companion.emptyOf$runtime_release();
    }

    @NotNull
    public static final <E> PersistentList<E> plus(@NotNull PersistentList<? extends E> persistentList, E e11) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        return persistentList.add(e11);
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> putAll(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        MapsKt__MapsKt.putAll(builder, pairArr);
        return builder.build();
    }

    @NotNull
    public static final PersistentSet<Character> toImmutableSet(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return toPersistentSet(charSequence);
    }

    @NotNull
    public static final PersistentSet<Character> toPersistentHashSet(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        PersistentSet.Builder builder = persistentHashSetOf().builder();
        Collection unused = StringsKt___StringsKt.toCollection(charSequence, builder);
        return builder.build();
    }

    @NotNull
    public static final PersistentList<Character> toPersistentList(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        PersistentList.Builder builder = persistentListOf().builder();
        Collection unused = StringsKt___StringsKt.toCollection(charSequence, builder);
        return builder.build();
    }

    @NotNull
    public static final PersistentSet<Character> toPersistentSet(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        PersistentSet.Builder builder = persistentSetOf().builder();
        Collection unused = StringsKt___StringsKt.toCollection(charSequence, builder);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentList<E> minus(@NotNull PersistentList<? extends E> persistentList, @NotNull Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentList.removeAll((Collection<? extends Object>) (Collection) iterable);
        }
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(builder, iterable);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentList<E> plus(@NotNull PersistentList<? extends E> persistentList, @NotNull Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentList.addAll((Collection) iterable);
        }
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(builder, iterable);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> putAll(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        MapsKt__MapsKt.putAll(builder, sequence);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> minus(@NotNull PersistentSet<? extends E> persistentSet, E e11) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        return persistentSet.remove(e11);
    }

    @NotNull
    public static final <E> PersistentSet<E> plus(@NotNull PersistentSet<? extends E> persistentSet, E e11) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        return persistentSet.add(e11);
    }

    @NotNull
    public static final <E> PersistentSet<E> minus(@NotNull PersistentSet<? extends E> persistentSet, @NotNull Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentSet.removeAll((Collection<? extends Object>) (Collection) iterable);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(builder, iterable);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> plus(@NotNull PersistentSet<? extends E> persistentSet, @NotNull Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentSet.addAll((Collection) iterable);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(builder, iterable);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> minus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, K k11) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        return persistentMap.remove(k11);
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> plus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(pair, "pair");
        return persistentMap.put(pair.getFirst(), pair.getSecond());
    }

    @NotNull
    public static final <E> PersistentList<E> minus(@NotNull PersistentList<? extends E> persistentList, @NotNull E[] eArr) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(eArr, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(builder, (T[]) eArr);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> plus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "pairs");
        return putAll(persistentMap, iterable);
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> plus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        return putAll(persistentMap, pairArr);
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> plus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "pairs");
        return putAll(persistentMap, sequence);
    }

    @NotNull
    public static final <E> PersistentList<E> minus(@NotNull PersistentList<? extends E> persistentList, @NotNull Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(builder, sequence);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> plus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        return putAll(persistentMap, map);
    }

    @NotNull
    public static final <E> PersistentList<E> plus(@NotNull PersistentList<? extends E> persistentList, @NotNull E[] eArr) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(eArr, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(builder, (T[]) eArr);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> minus(@NotNull PersistentSet<? extends E> persistentSet, @NotNull E[] eArr) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(eArr, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(builder, (T[]) eArr);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentList<E> plus(@NotNull PersistentList<? extends E> persistentList, @NotNull Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(builder, sequence);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> minus(@NotNull PersistentSet<? extends E> persistentSet, @NotNull Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(builder, sequence);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> plus(@NotNull PersistentSet<? extends E> persistentSet, @NotNull E[] eArr) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(eArr, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(builder, (T[]) eArr);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> minus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Iterable<? extends K> iterable) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(iterable, UserMetadata.KEYDATA_FILENAME);
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(builder.keySet(), iterable);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> plus(@NotNull PersistentSet<? extends E> persistentSet, @NotNull Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(builder, sequence);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> minus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull K[] kArr) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(kArr, UserMetadata.KEYDATA_FILENAME);
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(builder.keySet(), (T[]) kArr);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> minus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Sequence<? extends K> sequence) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(sequence, UserMetadata.KEYDATA_FILENAME);
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(builder.keySet(), sequence);
        return builder.build();
    }
}
