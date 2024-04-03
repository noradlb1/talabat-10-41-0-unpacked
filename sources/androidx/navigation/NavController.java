package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NavigationRes;
import androidx.annotation.RestrictTo;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import f2.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 Å\u00012\u00020\u0001:\u0006Å\u0001Æ\u0001Ç\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010p\u001a\u00020\u00162\u0006\u0010q\u001a\u0002022\b\u0010r\u001a\u0004\u0018\u00010\\2\u0006\u0010\u0015\u001a\u00020\u00072\u000e\b\u0002\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002J\u0010\u0010t\u001a\u00020\u00162\u0006\u0010u\u001a\u00020cH\u0016J\u0012\u0010v\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001fH\u0007J\u0010\u0010v\u001a\u0002062\u0006\u0010x\u001a\u00020 H\u0007J\u0012\u0010y\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001fH\u0003J\b\u0010z\u001a\u00020{H\u0016J\b\u0010|\u001a\u000206H\u0002J\u0010\u0010}\u001a\u00020\u00162\u0006\u0010~\u001a\u000206H\u0017J\u0014\u0010\u001a\u0004\u0018\u0001022\b\b\u0001\u0010w\u001a\u00020\u001fH\u0007J\u0013\u0010\u001a\u0004\u0018\u0001022\u0007\u0010\u0001\u001a\u00020 H\u0007J\u0015\u0010\u0001\u001a\u0004\u0018\u00010 2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020\u00072\b\b\u0001\u0010w\u001a\u00020\u001fH\u0016J\u000f\u0010\u0001\u001a\u00020\u00072\u0006\u0010x\u001a\u00020 J\u0015\u0010\u0001\u001a\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u001fH\u0016J\u0015\u0010\u0001\u001a\u0002062\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J \u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000f\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0018H\u0002J\u001b\u0010\u0001\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u001f\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J+\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J\u0013\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u001f\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J+\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J4\u0010\u0001\u001a\u00020\u00162\u0006\u0010q\u001a\u0002022\t\u0010\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0003J\u0013\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u001f\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J\u001d\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u0014\u0010\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u0001\u001a\u00020\u001fH\u0017J\u001f\u0010\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u0001\u001a\u00020\u001f2\t\u0010\u0001\u001a\u0004\u0018\u00010\\H\u0017J+\u0010\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u0001\u001a\u00020\u001f2\t\u0010\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J7\u0010\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u0001\u001a\u00020\u001f2\t\u0010\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J-\u0010\u0001\u001a\u00020\u00162\u0006\u0010x\u001a\u00020 2\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u00012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J+\u0010\u0001\u001a\u00020\u00162\u0006\u0010x\u001a\u00020 2\u001a\u0010\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\u0003\b\u0001J\t\u0010\u0001\u001a\u000206H\u0017J\u0014\u0010 \u0001\u001a\u00020\u00162\t\u0010¡\u0001\u001a\u0004\u0018\u00010\\H\u0003J\t\u0010¢\u0001\u001a\u000206H\u0017J\u001c\u0010¢\u0001\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001f2\u0007\u0010£\u0001\u001a\u000206H\u0017J%\u0010¢\u0001\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001f2\u0007\u0010£\u0001\u001a\u0002062\u0007\u0010¤\u0001\u001a\u000206H\u0017J%\u0010¢\u0001\u001a\u0002062\u0006\u0010x\u001a\u00020 2\u0007\u0010£\u0001\u001a\u0002062\t\b\u0002\u0010¤\u0001\u001a\u000206H\u0007J'\u0010¥\u0001\u001a\u00020\u00162\u0006\u0010g\u001a\u00020\u00072\u000e\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020\u00160§\u0001H\u0000¢\u0006\u0003\b¨\u0001J'\u0010©\u0001\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001f2\u0007\u0010£\u0001\u001a\u0002062\t\b\u0002\u0010¤\u0001\u001a\u000206H\u0003J-\u0010ª\u0001\u001a\u00020\u00162\u0006\u0010g\u001a\u00020\u00072\t\b\u0002\u0010¤\u0001\u001a\u0002062\u000f\b\u0002\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\u0018H\u0002J\u0015\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0000¢\u0006\u0003\b­\u0001J\u0011\u0010®\u0001\u001a\u00020\u00162\u0006\u0010u\u001a\u00020cH\u0016J\u0014\u0010¯\u0001\u001a\u00020\u00162\t\u0010°\u0001\u001a\u0004\u0018\u00010\\H\u0017J5\u0010±\u0001\u001a\u0002062\u0007\u0010²\u0001\u001a\u00020\u001f2\t\u0010\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u000b\u0010¤\u0001\u001a\u0004\u0018\u00010\\H\u0017J\u001b\u0010@\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\t2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\\H\u0017J\u0013\u0010@\u001a\u00020\u00162\t\b\u0001\u0010³\u0001\u001a\u00020\u001fH\u0017J\u001e\u0010@\u001a\u00020\u00162\t\b\u0001\u0010³\u0001\u001a\u00020\u001f2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\\H\u0017J\u0012\u0010´\u0001\u001a\u00020\u00162\u0007\u0010µ\u0001\u001a\u00020MH\u0017J\u0012\u0010¶\u0001\u001a\u00020\u00162\u0007\u0010·\u0001\u001a\u00020`H\u0017J\u0013\u0010¸\u0001\u001a\u00020\u00162\b\u0010¹\u0001\u001a\u00030º\u0001H\u0017J\t\u0010»\u0001\u001a\u000206H\u0002J\t\u0010¼\u0001\u001a\u000206H\u0002J\u001a\u0010½\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\b¾\u0001J\u000f\u0010¿\u0001\u001a\u00020\u0016H\u0000¢\u0006\u0003\bÀ\u0001J\t\u0010Á\u0001\u001a\u00020\u0016H\u0002J\u0018\u0010\u001a\u0004\u0018\u000102*\u0002022\b\b\u0001\u0010w\u001a\u00020\u001fH\u0002Jb\u0010Â\u0001\u001a\u00020\u0016*\n\u0012\u0006\b\u0001\u0012\u0002020Y2\r\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012$\b\u0002\u0010Ä\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0012H\u0002JL\u0010©\u0001\u001a\u00020\u0016*\n\u0012\u0006\b\u0001\u0012\u0002020Y2\u0006\u0010g\u001a\u00020\u00072\u0007\u0010¤\u0001\u001a\u0002062$\b\u0002\u0010Ä\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u00160\u0012H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188WX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001eX\u0004¢\u0006\u0002\n\u0000R \u0010!\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00180\u001eX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u000e¢\u0006\u0004\n\u0002\u0010&R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001eX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0016\u00101\u001a\u0004\u0018\u0001028VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u000e\u0010:\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002060\u001eX\u0004¢\u0006\u0002\n\u0000R$\u0010=\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t8W@WX\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u00020C8@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010N\u001a\u00020I8VX\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bO\u0010PR$\u0010S\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b8V@WX\u000e¢\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR&\u0010X\u001a\u001a\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002020Y\u0012\b\u0012\u00060ZR\u00020\u00000\u001eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020c0bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020e0\u001eX\u0004¢\u0006\u0002\n\u0000R+\u0010f\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010h\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\bi\u0010,R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0m¢\u0006\b\n\u0000\u001a\u0004\bn\u0010o¨\u0006È\u0001"}, d2 = {"Landroidx/navigation/NavController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/navigation/NavBackStackEntry;", "_graph", "Landroidx/navigation/NavGraph;", "_navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "_visibleEntries", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "activity", "Landroid/app/Activity;", "addToBackStackHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "backStackEntry", "", "backQueue", "Lkotlin/collections/ArrayDeque;", "getBackQueue", "()Lkotlin/collections/ArrayDeque;", "backStackEntriesToDispatch", "", "backStackMap", "", "", "", "backStackStates", "Landroidx/navigation/NavBackStackEntryState;", "backStackToRestore", "", "Landroid/os/Parcelable;", "[Landroid/os/Parcelable;", "childToParentEntries", "getContext", "()Landroid/content/Context;", "currentBackStackEntry", "getCurrentBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/Flow;", "getCurrentBackStackEntryFlow", "()Lkotlinx/coroutines/flow/Flow;", "currentDestination", "Landroidx/navigation/NavDestination;", "getCurrentDestination", "()Landroidx/navigation/NavDestination;", "deepLinkHandled", "", "destinationCountOnBackStack", "getDestinationCountOnBackStack", "()I", "dispatchReentrantCount", "enableOnBackPressedCallback", "entrySavedState", "graph", "getGraph", "()Landroidx/navigation/NavGraph;", "setGraph", "(Landroidx/navigation/NavGraph;)V", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "getHostLifecycleState$navigation_runtime_release", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "inflater", "Landroidx/navigation/NavInflater;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "navInflater", "getNavInflater", "()Landroidx/navigation/NavInflater;", "navInflater$delegate", "Lkotlin/Lazy;", "navigatorProvider", "getNavigatorProvider", "()Landroidx/navigation/NavigatorProvider;", "setNavigatorProvider", "(Landroidx/navigation/NavigatorProvider;)V", "navigatorState", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "navigatorStateToRestore", "Landroid/os/Bundle;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "onDestinationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "parentToChildCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "popFromBackStackHandler", "popUpTo", "previousBackStackEntry", "getPreviousBackStackEntry", "viewModel", "Landroidx/navigation/NavControllerViewModel;", "visibleEntries", "Lkotlinx/coroutines/flow/StateFlow;", "getVisibleEntries", "()Lkotlinx/coroutines/flow/StateFlow;", "addEntryToBackStack", "node", "finalArgs", "restoredEntries", "addOnDestinationChangedListener", "listener", "clearBackStack", "destinationId", "route", "clearBackStackInternal", "createDeepLink", "Landroidx/navigation/NavDeepLinkBuilder;", "dispatchOnDestinationChanged", "enableOnBackPressed", "enabled", "findDestination", "destinationRoute", "findInvalidDestinationDisplayNameInDeepLink", "deepLink", "", "getBackStackEntry", "getViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "navGraphId", "handleDeepLink", "intent", "Landroid/content/Intent;", "instantiateBackStack", "backStackState", "linkChildToParent", "child", "parent", "navigate", "Landroid/net/Uri;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "request", "Landroidx/navigation/NavDeepLinkRequest;", "args", "directions", "Landroidx/navigation/NavDirections;", "resId", "builder", "Landroidx/navigation/NavOptionsBuilder;", "Lkotlin/ExtensionFunctionType;", "navigateUp", "onGraphCreated", "startDestinationArgs", "popBackStack", "inclusive", "saveState", "popBackStackFromNavigator", "onComplete", "Lkotlin/Function0;", "popBackStackFromNavigator$navigation_runtime_release", "popBackStackInternal", "popEntryFromBackStack", "savedState", "populateVisibleEntries", "populateVisibleEntries$navigation_runtime_release", "removeOnDestinationChangedListener", "restoreState", "navState", "restoreStateInternal", "id", "graphResId", "setLifecycleOwner", "owner", "setOnBackPressedDispatcher", "dispatcher", "setViewModelStore", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "tryRelaunchUpToExplicitStack", "tryRelaunchUpToGeneratedStack", "unlinkChildFromParent", "unlinkChildFromParent$navigation_runtime_release", "updateBackStackLifecycle", "updateBackStackLifecycle$navigation_runtime_release", "updateOnBackPressedCallbackEnabled", "navigateInternal", "entries", "handler", "Companion", "NavControllerNavigatorState", "OnDestinationChangedListener", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavController {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    @NotNull
    private static final String KEY_BACK_STACK_DEST_IDS = "android-support-nav:controller:backStackDestIds";
    @NotNull
    private static final String KEY_BACK_STACK_IDS = "android-support-nav:controller:backStackIds";
    @NotNull
    private static final String KEY_BACK_STACK_STATES_IDS = "android-support-nav:controller:backStackStates";
    @NotNull
    private static final String KEY_BACK_STACK_STATES_PREFIX = "android-support-nav:controller:backStackStates:";
    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_ARGS = "android-support-nav:controller:deepLinkArgs";
    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";
    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
    @NotNull
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    @NotNull
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    @NotNull
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    @NotNull
    private static final String TAG = "NavController";
    /* access modifiers changed from: private */
    public static boolean deepLinkSaveState = true;
    @NotNull
    private final MutableSharedFlow<NavBackStackEntry> _currentBackStackEntryFlow;
    @Nullable
    private NavGraph _graph;
    /* access modifiers changed from: private */
    @NotNull
    public NavigatorProvider _navigatorProvider;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableStateFlow<List<NavBackStackEntry>> _visibleEntries;
    @Nullable
    private Activity activity;
    /* access modifiers changed from: private */
    @Nullable
    public Function1<? super NavBackStackEntry, Unit> addToBackStackHandler;
    @NotNull
    private final ArrayDeque<NavBackStackEntry> backQueue;
    @NotNull
    private final List<NavBackStackEntry> backStackEntriesToDispatch;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<Integer, String> backStackMap;
    @NotNull
    private final Map<String, ArrayDeque<NavBackStackEntryState>> backStackStates;
    @Nullable
    private Parcelable[] backStackToRestore;
    @NotNull
    private final Map<NavBackStackEntry, NavBackStackEntry> childToParentEntries;
    @NotNull
    private final Context context;
    @NotNull
    private final Flow<NavBackStackEntry> currentBackStackEntryFlow;
    private boolean deepLinkHandled;
    private int dispatchReentrantCount;
    private boolean enableOnBackPressedCallback;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<NavBackStackEntry, Boolean> entrySavedState;
    @NotNull
    private Lifecycle.State hostLifecycleState;
    /* access modifiers changed from: private */
    @Nullable
    public NavInflater inflater;
    @NotNull
    private final LifecycleObserver lifecycleObserver;
    @Nullable
    private LifecycleOwner lifecycleOwner;
    @NotNull
    private final Lazy navInflater$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> navigatorState;
    @Nullable
    private Bundle navigatorStateToRestore;
    @NotNull
    private final OnBackPressedCallback onBackPressedCallback;
    @Nullable
    private OnBackPressedDispatcher onBackPressedDispatcher;
    @NotNull
    private final CopyOnWriteArrayList<OnDestinationChangedListener> onDestinationChangedListeners;
    @NotNull
    private final Map<NavBackStackEntry, AtomicInteger> parentToChildCount;
    /* access modifiers changed from: private */
    @Nullable
    public Function1<? super NavBackStackEntry, Unit> popFromBackStackHandler;
    /* access modifiers changed from: private */
    @Nullable
    public NavControllerViewModel viewModel;
    @NotNull
    private final StateFlow<List<NavBackStackEntry>> visibleEntries;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u0010\u0010\f\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/navigation/NavController$Companion;", "", "()V", "KEY_BACK_STACK", "", "KEY_BACK_STACK_DEST_IDS", "KEY_BACK_STACK_IDS", "KEY_BACK_STACK_STATES_IDS", "KEY_BACK_STACK_STATES_PREFIX", "KEY_DEEP_LINK_ARGS", "KEY_DEEP_LINK_EXTRAS", "getKEY_DEEP_LINK_EXTRAS$annotations", "KEY_DEEP_LINK_HANDLED", "KEY_DEEP_LINK_IDS", "KEY_DEEP_LINK_INTENT", "KEY_NAVIGATOR_STATE", "KEY_NAVIGATOR_STATE_NAMES", "TAG", "deepLinkSaveState", "", "enableDeepLinkSaveState", "", "saveState", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getKEY_DEEP_LINK_EXTRAS$annotations() {
        }

        @JvmStatic
        @NavDeepLinkSaveStateControl
        public final void enableDeepLinkSaveState(boolean z11) {
            NavController.deepLinkSaveState = z11;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Landroidx/navigation/NavController$NavControllerNavigatorState;", "Landroidx/navigation/NavigatorState;", "navigator", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "(Landroidx/navigation/NavController;Landroidx/navigation/Navigator;)V", "getNavigator", "()Landroidx/navigation/Navigator;", "addInternal", "", "backStackEntry", "Landroidx/navigation/NavBackStackEntry;", "createBackStackEntry", "destination", "arguments", "Landroid/os/Bundle;", "markTransitionComplete", "entry", "pop", "popUpTo", "saveState", "", "popWithTransition", "push", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class NavControllerNavigatorState extends NavigatorState {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NavController f36304a;
        @NotNull
        private final Navigator<? extends NavDestination> navigator;

        public NavControllerNavigatorState(@NotNull NavController navController, Navigator<? extends NavDestination> navigator2) {
            Intrinsics.checkNotNullParameter(navigator2, "navigator");
            this.f36304a = navController;
            this.navigator = navigator2;
        }

        public final void addInternal(@NotNull NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
            super.push(navBackStackEntry);
        }

        @NotNull
        public NavBackStackEntry createBackStackEntry(@NotNull NavDestination navDestination, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(navDestination, "destination");
            return NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.f36304a.getContext(), navDestination, bundle, this.f36304a.getHostLifecycleState$navigation_runtime_release(), this.f36304a.viewModel, (String) null, (Bundle) null, 96, (Object) null);
        }

        @NotNull
        public final Navigator<? extends NavDestination> getNavigator() {
            return this.navigator;
        }

        public void markTransitionComplete(@NotNull NavBackStackEntry navBackStackEntry) {
            NavControllerViewModel access$getViewModel$p;
            Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
            boolean areEqual = Intrinsics.areEqual(this.f36304a.entrySavedState.get(navBackStackEntry), (Object) Boolean.TRUE);
            super.markTransitionComplete(navBackStackEntry);
            this.f36304a.entrySavedState.remove(navBackStackEntry);
            if (!this.f36304a.getBackQueue().contains(navBackStackEntry)) {
                this.f36304a.unlinkChildFromParent$navigation_runtime_release(navBackStackEntry);
                if (navBackStackEntry.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                    navBackStackEntry.setMaxLifecycle(Lifecycle.State.DESTROYED);
                }
                ArrayDeque<NavBackStackEntry> backQueue = this.f36304a.getBackQueue();
                boolean z11 = true;
                if (!(backQueue instanceof Collection) || !backQueue.isEmpty()) {
                    Iterator<T> it = backQueue.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual((Object) ((NavBackStackEntry) it.next()).getId(), (Object) navBackStackEntry.getId())) {
                                z11 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (z11 && !areEqual && (access$getViewModel$p = this.f36304a.viewModel) != null) {
                    access$getViewModel$p.clear(navBackStackEntry.getId());
                }
                this.f36304a.updateBackStackLifecycle$navigation_runtime_release();
                this.f36304a._visibleEntries.tryEmit(this.f36304a.populateVisibleEntries$navigation_runtime_release());
            } else if (!isNavigating()) {
                this.f36304a.updateBackStackLifecycle$navigation_runtime_release();
                this.f36304a._visibleEntries.tryEmit(this.f36304a.populateVisibleEntries$navigation_runtime_release());
            }
        }

        public void pop(@NotNull NavBackStackEntry navBackStackEntry, boolean z11) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
            Navigator navigator2 = this.f36304a._navigatorProvider.getNavigator(navBackStackEntry.getDestination().getNavigatorName());
            if (Intrinsics.areEqual((Object) navigator2, (Object) this.navigator)) {
                Function1 access$getPopFromBackStackHandler$p = this.f36304a.popFromBackStackHandler;
                if (access$getPopFromBackStackHandler$p != null) {
                    access$getPopFromBackStackHandler$p.invoke(navBackStackEntry);
                    super.pop(navBackStackEntry, z11);
                    return;
                }
                this.f36304a.popBackStackFromNavigator$navigation_runtime_release(navBackStackEntry, new NavController$NavControllerNavigatorState$pop$1(this, navBackStackEntry, z11));
                return;
            }
            Object obj = this.f36304a.navigatorState.get(navigator2);
            Intrinsics.checkNotNull(obj);
            ((NavControllerNavigatorState) obj).pop(navBackStackEntry, z11);
        }

        public void popWithTransition(@NotNull NavBackStackEntry navBackStackEntry, boolean z11) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
            super.popWithTransition(navBackStackEntry, z11);
            this.f36304a.entrySavedState.put(navBackStackEntry, Boolean.valueOf(z11));
        }

        public void push(@NotNull NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
            Navigator navigator2 = this.f36304a._navigatorProvider.getNavigator(navBackStackEntry.getDestination().getNavigatorName());
            if (Intrinsics.areEqual((Object) navigator2, (Object) this.navigator)) {
                Function1 access$getAddToBackStackHandler$p = this.f36304a.addToBackStackHandler;
                if (access$getAddToBackStackHandler$p != null) {
                    access$getAddToBackStackHandler$p.invoke(navBackStackEntry);
                    addInternal(navBackStackEntry);
                    return;
                }
                Log.i(NavController.TAG, "Ignoring add of destination " + navBackStackEntry.getDestination() + " outside of the call to navigate(). ");
                return;
            }
            Object obj = this.f36304a.navigatorState.get(navigator2);
            if (obj != null) {
                ((NavControllerNavigatorState) obj).push(navBackStackEntry);
                return;
            }
            throw new IllegalStateException(("NavigatorBackStack for " + navBackStackEntry.getDestination().getNavigatorName() + " should already be created").toString());
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDestinationChangedListener {
        void onDestinationChanged(@NotNull NavController navController, @NotNull NavDestination navDestination, @Nullable Bundle bundle);
    }

    public NavController(@NotNull Context context2) {
        Object obj;
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        Iterator it = SequencesKt__SequencesKt.generateSequence(context2, NavController$activity$1.INSTANCE).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Context) obj) instanceof Activity) {
                break;
            }
        }
        this.activity = (Activity) obj;
        this.backQueue = new ArrayDeque<>();
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt__CollectionsKt.emptyList());
        this._visibleEntries = MutableStateFlow;
        this.visibleEntries = FlowKt.asStateFlow(MutableStateFlow);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new CopyOnWriteArrayList<>();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new a(this);
        this.onBackPressedCallback = new NavController$onBackPressedCallback$1(this);
        this.enableOnBackPressedCallback = true;
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        NavigatorProvider navigatorProvider = this._navigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
        this.backStackEntriesToDispatch = new ArrayList();
        this.navInflater$delegate = LazyKt__LazyJVMKt.lazy(new NavController$navInflater$2(this));
        MutableSharedFlow<NavBackStackEntry> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
        this._currentBackStackEntryFlow = MutableSharedFlow$default;
        this.currentBackStackEntryFlow = FlowKt.asSharedFlow(MutableSharedFlow$default);
    }

    /* access modifiers changed from: private */
    public final void addEntryToBackStack(NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List<NavBackStackEntry> list) {
        NavDestination navDestination2;
        Bundle bundle2;
        List<NavBackStackEntry> list2;
        ArrayDeque<NavBackStackEntry> arrayDeque;
        NavBackStackEntry navBackStackEntry2;
        NavDestination navDestination3;
        NavDestination navDestination4;
        NavBackStackEntry navBackStackEntry3;
        NavGraph navGraph;
        NavBackStackEntry navBackStackEntry4;
        Bundle bundle3;
        List<NavBackStackEntry> list3;
        NavDestination navDestination5 = navDestination;
        Bundle bundle4 = bundle;
        NavBackStackEntry navBackStackEntry5 = navBackStackEntry;
        List<NavBackStackEntry> list4 = list;
        NavDestination destination = navBackStackEntry.getDestination();
        if (!(destination instanceof FloatingWindow)) {
            while (!getBackQueue().isEmpty() && (getBackQueue().last().getDestination() instanceof FloatingWindow)) {
                if (!c(this, getBackQueue().last().getDestination().getId(), true, false, 4, (Object) null)) {
                    break;
                }
            }
        }
        ArrayDeque arrayDeque2 = new ArrayDeque();
        NavBackStackEntry navBackStackEntry6 = null;
        if (navDestination5 instanceof NavGraph) {
            NavGraph navGraph2 = destination;
            while (true) {
                Intrinsics.checkNotNull(navGraph2);
                NavGraph parent = navGraph2.getParent();
                if (parent != null) {
                    ListIterator<NavBackStackEntry> listIterator = list4.listIterator(list.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            navBackStackEntry4 = null;
                            break;
                        }
                        navBackStackEntry4 = listIterator.previous();
                        if (Intrinsics.areEqual((Object) navBackStackEntry4.getDestination(), (Object) parent)) {
                            break;
                        }
                    }
                    NavBackStackEntry navBackStackEntry7 = navBackStackEntry4;
                    if (navBackStackEntry7 == null) {
                        navDestination2 = destination;
                        list3 = list4;
                        bundle3 = bundle4;
                        NavBackStackEntry create$default = NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.context, parent, bundle, getHostLifecycleState$navigation_runtime_release(), this.viewModel, (String) null, (Bundle) null, 96, (Object) null);
                        navBackStackEntry2 = navBackStackEntry5;
                        navBackStackEntry7 = create$default;
                    } else {
                        navDestination2 = destination;
                        list3 = list4;
                        navBackStackEntry2 = navBackStackEntry5;
                        bundle3 = bundle4;
                    }
                    arrayDeque2.addFirst(navBackStackEntry7);
                    if (!(!getBackQueue().isEmpty()) || getBackQueue().last().getDestination() != parent) {
                        list2 = list3;
                        bundle2 = bundle3;
                        navGraph = parent;
                        arrayDeque = arrayDeque2;
                    } else {
                        list2 = list3;
                        bundle2 = bundle3;
                        navGraph = parent;
                        arrayDeque = arrayDeque2;
                        d(this, getBackQueue().last(), false, (ArrayDeque) null, 6, (Object) null);
                    }
                } else {
                    navGraph = parent;
                    arrayDeque = arrayDeque2;
                    navDestination2 = destination;
                    list2 = list4;
                    navBackStackEntry2 = navBackStackEntry5;
                    bundle2 = bundle4;
                }
                if (navGraph == null || navGraph == navDestination5) {
                    break;
                }
                navBackStackEntry5 = navBackStackEntry2;
                navGraph2 = navGraph;
                arrayDeque2 = arrayDeque;
                bundle4 = bundle2;
                list4 = list2;
                destination = navDestination2;
            }
        } else {
            arrayDeque = arrayDeque2;
            navDestination2 = destination;
            list2 = list4;
            navBackStackEntry2 = navBackStackEntry5;
            bundle2 = bundle4;
        }
        if (arrayDeque.isEmpty()) {
            navDestination3 = navDestination2;
        } else {
            navDestination3 = ((NavBackStackEntry) arrayDeque.first()).getDestination();
        }
        while (navDestination3 != null && findDestination(navDestination3.getId()) == null) {
            navDestination3 = navDestination3.getParent();
            if (navDestination3 != null) {
                ListIterator<NavBackStackEntry> listIterator2 = list2.listIterator(list.size());
                while (true) {
                    if (!listIterator2.hasPrevious()) {
                        navBackStackEntry3 = null;
                        break;
                    }
                    navBackStackEntry3 = listIterator2.previous();
                    if (Intrinsics.areEqual((Object) navBackStackEntry3.getDestination(), (Object) navDestination3)) {
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntry8 = navBackStackEntry3;
                if (navBackStackEntry8 == null) {
                    navBackStackEntry8 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.context, navDestination3, navDestination3.addInDefaultArgs(bundle2), getHostLifecycleState$navigation_runtime_release(), this.viewModel, (String) null, (Bundle) null, 96, (Object) null);
                }
                arrayDeque.addFirst(navBackStackEntry8);
            }
        }
        if (!arrayDeque.isEmpty()) {
            navDestination2 = ((NavBackStackEntry) arrayDeque.last()).getDestination();
        }
        while (!getBackQueue().isEmpty() && (getBackQueue().last().getDestination() instanceof NavGraph) && ((NavGraph) getBackQueue().last().getDestination()).findNode(navDestination2.getId(), false) == null) {
            d(this, getBackQueue().last(), false, (ArrayDeque) null, 6, (Object) null);
        }
        NavBackStackEntry firstOrNull = getBackQueue().firstOrNull();
        if (firstOrNull == null) {
            firstOrNull = (NavBackStackEntry) arrayDeque.firstOrNull();
        }
        if (firstOrNull != null) {
            navDestination4 = firstOrNull.getDestination();
        } else {
            navDestination4 = null;
        }
        if (!Intrinsics.areEqual((Object) navDestination4, (Object) this._graph)) {
            ListIterator<NavBackStackEntry> listIterator3 = list2.listIterator(list.size());
            while (true) {
                if (!listIterator3.hasPrevious()) {
                    break;
                }
                NavBackStackEntry previous = listIterator3.previous();
                NavDestination destination2 = previous.getDestination();
                NavGraph navGraph3 = this._graph;
                Intrinsics.checkNotNull(navGraph3);
                if (Intrinsics.areEqual((Object) destination2, (Object) navGraph3)) {
                    navBackStackEntry6 = previous;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntry9 = navBackStackEntry6;
            if (navBackStackEntry9 == null) {
                NavBackStackEntry.Companion companion = NavBackStackEntry.Companion;
                Context context2 = this.context;
                NavGraph navGraph4 = this._graph;
                Intrinsics.checkNotNull(navGraph4);
                NavGraph navGraph5 = this._graph;
                Intrinsics.checkNotNull(navGraph5);
                navBackStackEntry9 = NavBackStackEntry.Companion.create$default(companion, context2, navGraph4, navGraph5.addInDefaultArgs(bundle2), getHostLifecycleState$navigation_runtime_release(), this.viewModel, (String) null, (Bundle) null, 96, (Object) null);
            }
            arrayDeque.addFirst(navBackStackEntry9);
        }
        for (NavBackStackEntry navBackStackEntry10 : arrayDeque) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry10.getDestination().getNavigatorName()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.addInternal(navBackStackEntry10);
            } else {
                throw new IllegalStateException(("NavigatorBackStack for " + navDestination.getNavigatorName() + " should already be created").toString());
            }
        }
        getBackQueue().addAll(arrayDeque);
        getBackQueue().add(navBackStackEntry2);
        for (NavBackStackEntry navBackStackEntry11 : CollectionsKt___CollectionsKt.plus(arrayDeque, navBackStackEntry2)) {
            NavGraph parent2 = navBackStackEntry11.getDestination().getParent();
            if (parent2 != null) {
                linkChildToParent(navBackStackEntry11, getBackStackEntry(parent2.getId()));
            }
        }
    }

    public static /* synthetic */ void b(NavController navController, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 8) != 0) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            navController.addEntryToBackStack(navDestination, bundle, navBackStackEntry, list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
    }

    public static /* synthetic */ boolean c(NavController navController, int i11, boolean z11, boolean z12, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 4) != 0) {
                z12 = false;
            }
            return navController.popBackStackInternal(i11, z11, z12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    @MainThread
    private final boolean clearBackStackInternal(@IdRes int i11) {
        for (NavControllerNavigatorState navigating : this.navigatorState.values()) {
            navigating.setNavigating(true);
        }
        boolean restoreStateInternal = restoreStateInternal(i11, (Bundle) null, (NavOptions) null, (Navigator.Extras) null);
        for (NavControllerNavigatorState navigating2 : this.navigatorState.values()) {
            navigating2.setNavigating(false);
        }
        if (!restoreStateInternal || !popBackStackInternal(i11, true, false)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void d(NavController navController, NavBackStackEntry navBackStackEntry, boolean z11, ArrayDeque arrayDeque, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            if ((i11 & 4) != 0) {
                arrayDeque = new ArrayDeque();
            }
            navController.popEntryFromBackStack(navBackStackEntry, z11, arrayDeque);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
    }

    private final boolean dispatchOnDestinationChanged() {
        while (!getBackQueue().isEmpty() && (getBackQueue().last().getDestination() instanceof NavGraph)) {
            d(this, getBackQueue().last(), false, (ArrayDeque) null, 6, (Object) null);
        }
        NavBackStackEntry lastOrNull = getBackQueue().lastOrNull();
        if (lastOrNull != null) {
            this.backStackEntriesToDispatch.add(lastOrNull);
        }
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int i11 = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = i11;
        if (i11 == 0) {
            List<NavBackStackEntry> mutableList = CollectionsKt___CollectionsKt.toMutableList(this.backStackEntriesToDispatch);
            this.backStackEntriesToDispatch.clear();
            for (NavBackStackEntry navBackStackEntry : mutableList) {
                Iterator<OnDestinationChangedListener> it = this.onDestinationChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDestinationChanged(this, navBackStackEntry.getDestination(), navBackStackEntry.getArguments());
                }
                this._currentBackStackEntryFlow.tryEmit(navBackStackEntry);
            }
            this._visibleEntries.tryEmit(populateVisibleEntries$navigation_runtime_release());
        }
        if (lastOrNull != null) {
            return true;
        }
        return false;
    }

    @JvmStatic
    @NavDeepLinkSaveStateControl
    public static final void enableDeepLinkSaveState(boolean z11) {
        Companion.enableDeepLinkSaveState(z11);
    }

    private final String findInvalidDestinationDisplayNameInDeepLink(int[] iArr) {
        NavGraph navGraph;
        NavGraph navGraph2 = this._graph;
        int length = iArr.length;
        int i11 = 0;
        while (true) {
            NavDestination navDestination = null;
            if (i11 >= length) {
                return null;
            }
            int i12 = iArr[i11];
            if (i11 == 0) {
                NavGraph navGraph3 = this._graph;
                Intrinsics.checkNotNull(navGraph3);
                if (navGraph3.getId() == i12) {
                    navDestination = this._graph;
                }
            } else {
                Intrinsics.checkNotNull(navGraph2);
                navDestination = navGraph2.findNode(i12);
            }
            if (navDestination == null) {
                return NavDestination.Companion.getDisplayName(this.context, i12);
            }
            if (i11 != iArr.length - 1 && (navDestination instanceof NavGraph)) {
                while (true) {
                    navGraph = (NavGraph) navDestination;
                    Intrinsics.checkNotNull(navGraph);
                    if (!(navGraph.findNode(navGraph.getStartDestinationId()) instanceof NavGraph)) {
                        break;
                    }
                    navDestination = navGraph.findNode(navGraph.getStartDestinationId());
                }
                navGraph2 = navGraph;
            }
            i11++;
        }
    }

    private final int getDestinationCountOnBackStack() {
        ArrayDeque<NavBackStackEntry> backQueue2 = getBackQueue();
        int i11 = 0;
        if (!(backQueue2 instanceof Collection) || !backQueue2.isEmpty()) {
            for (NavBackStackEntry destination : backQueue2) {
                if ((!(destination.getDestination() instanceof NavGraph)) && (i11 = i11 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i11;
    }

    private final List<NavBackStackEntry> instantiateBackStack(ArrayDeque<NavBackStackEntryState> arrayDeque) {
        NavDestination navDestination;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry lastOrNull = getBackQueue().lastOrNull();
        if (lastOrNull == null || (navDestination = lastOrNull.getDestination()) == null) {
            navDestination = getGraph();
        }
        if (arrayDeque != null) {
            for (NavBackStackEntryState navBackStackEntryState : arrayDeque) {
                NavDestination findDestination = findDestination(navDestination, navBackStackEntryState.getDestinationId());
                if (findDestination != null) {
                    arrayList.add(navBackStackEntryState.instantiate(this.context, findDestination, getHostLifecycleState$navigation_runtime_release(), this.viewModel));
                    navDestination = findDestination;
                } else {
                    String displayName = NavDestination.Companion.getDisplayName(this.context, navBackStackEntryState.getDestinationId());
                    throw new IllegalStateException(("Restore State failed: destination " + displayName + " cannot be found from the current destination " + navDestination).toString());
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: lifecycleObserver$lambda-2  reason: not valid java name */
    public static final void m9093lifecycleObserver$lambda2(NavController navController, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(navController, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        Lifecycle.State targetState = event.getTargetState();
        Intrinsics.checkNotNullExpressionValue(targetState, "event.targetState");
        navController.hostLifecycleState = targetState;
        if (navController._graph != null) {
            Iterator<NavBackStackEntry> it = navController.getBackQueue().iterator();
            while (it.hasNext()) {
                it.next().handleLifecycleEvent(event);
            }
        }
    }

    private final void linkChildToParent(NavBackStackEntry navBackStackEntry, NavBackStackEntry navBackStackEntry2) {
        this.childToParentEntries.put(navBackStackEntry, navBackStackEntry2);
        if (this.parentToChildCount.get(navBackStackEntry2) == null) {
            this.parentToChildCount.put(navBackStackEntry2, new AtomicInteger(0));
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(navBackStackEntry2);
        Intrinsics.checkNotNull(atomicInteger);
        atomicInteger.incrementAndGet();
    }

    public static /* synthetic */ void navigate$default(NavController navController, String str, NavOptions navOptions, Navigator.Extras extras, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                navOptions = null;
            }
            if ((i11 & 4) != 0) {
                extras = null;
            }
            navController.navigate(str, navOptions, extras);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
    }

    private final void navigateInternal(Navigator<? extends NavDestination> navigator, List<NavBackStackEntry> list, NavOptions navOptions, Navigator.Extras extras, Function1<? super NavBackStackEntry, Unit> function1) {
        this.addToBackStackHandler = function1;
        navigator.navigate(list, navOptions, extras);
        this.addToBackStackHandler = null;
    }

    @MainThread
    private final void onGraphCreated(Bundle bundle) {
        Activity activity2;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.navigatorStateToRestore;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES)) == null)) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                NavigatorProvider navigatorProvider = this._navigatorProvider;
                Intrinsics.checkNotNullExpressionValue(next, "name");
                Navigator navigator = navigatorProvider.getNavigator(next);
                Bundle bundle3 = bundle2.getBundle(next);
                if (bundle3 != null) {
                    navigator.onRestoreState(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.backStackToRestore;
        boolean z11 = false;
        if (parcelableArr != null) {
            int length = parcelableArr.length;
            int i11 = 0;
            while (i11 < length) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelableArr[i11];
                NavDestination findDestination = findDestination(navBackStackEntryState.getDestinationId());
                if (findDestination != null) {
                    NavBackStackEntry instantiate = navBackStackEntryState.instantiate(this.context, findDestination, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                    Navigator navigator2 = this._navigatorProvider.getNavigator(findDestination.getNavigatorName());
                    Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map = this.navigatorState;
                    NavControllerNavigatorState navControllerNavigatorState = map.get(navigator2);
                    if (navControllerNavigatorState == null) {
                        navControllerNavigatorState = new NavControllerNavigatorState(this, navigator2);
                        map.put(navigator2, navControllerNavigatorState);
                    }
                    getBackQueue().add(instantiate);
                    navControllerNavigatorState.addInternal(instantiate);
                    NavGraph parent = instantiate.getDestination().getParent();
                    if (parent != null) {
                        linkChildToParent(instantiate, getBackStackEntry(parent.getId()));
                    }
                    i11++;
                } else {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.Companion.getDisplayName(this.context, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + getCurrentDestination());
                }
            }
            updateOnBackPressedCallbackEnabled();
            this.backStackToRestore = null;
        }
        ArrayList<Navigator> arrayList = new ArrayList<>();
        for (Object next2 : this._navigatorProvider.getNavigators().values()) {
            if (!((Navigator) next2).isAttached()) {
                arrayList.add(next2);
            }
        }
        for (Navigator navigator3 : arrayList) {
            Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map2 = this.navigatorState;
            NavControllerNavigatorState navControllerNavigatorState2 = map2.get(navigator3);
            if (navControllerNavigatorState2 == null) {
                navControllerNavigatorState2 = new NavControllerNavigatorState(this, navigator3);
                map2.put(navigator3, navControllerNavigatorState2);
            }
            navigator3.onAttach(navControllerNavigatorState2);
        }
        if (this._graph == null || !getBackQueue().isEmpty()) {
            dispatchOnDestinationChanged();
            return;
        }
        if (!this.deepLinkHandled && (activity2 = this.activity) != null) {
            Intrinsics.checkNotNull(activity2);
            if (handleDeepLink(activity2.getIntent())) {
                z11 = true;
            }
        }
        if (!z11) {
            NavGraph navGraph = this._graph;
            Intrinsics.checkNotNull(navGraph);
            navigate((NavDestination) navGraph, bundle, (NavOptions) null, (Navigator.Extras) null);
        }
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, String str, boolean z11, boolean z12, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                z12 = false;
            }
            return navController.popBackStack(str, z11, z12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
    }

    private final void popBackStackInternal(Navigator<? extends NavDestination> navigator, NavBackStackEntry navBackStackEntry, boolean z11, Function1<? super NavBackStackEntry, Unit> function1) {
        this.popFromBackStackHandler = function1;
        navigator.popBackStack(navBackStackEntry, z11);
        this.popFromBackStackHandler = null;
    }

    /* access modifiers changed from: private */
    public final void popEntryFromBackStack(NavBackStackEntry navBackStackEntry, boolean z11, ArrayDeque<NavBackStackEntryState> arrayDeque) {
        boolean z12;
        NavControllerViewModel navControllerViewModel;
        StateFlow<Set<NavBackStackEntry>> transitionsInProgress;
        Set value;
        NavBackStackEntry last = getBackQueue().last();
        if (Intrinsics.areEqual((Object) last, (Object) navBackStackEntry)) {
            getBackQueue().removeLast();
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(getNavigatorProvider().getNavigator(last.getDestination().getNavigatorName()));
            boolean z13 = true;
            if (navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null || !value.contains(last)) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (!z12 && !this.parentToChildCount.containsKey(last)) {
                z13 = false;
            }
            Lifecycle.State currentState = last.getLifecycle().getCurrentState();
            Lifecycle.State state = Lifecycle.State.CREATED;
            if (currentState.isAtLeast(state)) {
                if (z11) {
                    last.setMaxLifecycle(state);
                    arrayDeque.addFirst(new NavBackStackEntryState(last));
                }
                if (!z13) {
                    last.setMaxLifecycle(Lifecycle.State.DESTROYED);
                    unlinkChildFromParent$navigation_runtime_release(last);
                } else {
                    last.setMaxLifecycle(state);
                }
            }
            if (!z11 && !z13 && (navControllerViewModel = this.viewModel) != null) {
                navControllerViewModel.clear(last.getId());
                return;
            }
            return;
        }
        throw new IllegalStateException(("Attempted to pop " + navBackStackEntry.getDestination() + ", which is not the top of the back stack (" + last.getDestination() + ')').toString());
    }

    private final boolean restoreStateInternal(int i11, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        String str;
        NavBackStackEntry navBackStackEntry;
        NavDestination destination;
        if (!this.backStackMap.containsKey(Integer.valueOf(i11))) {
            return false;
        }
        String str2 = this.backStackMap.get(Integer.valueOf(i11));
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(this.backStackMap.values(), new NavController$restoreStateInternal$1(str2));
        List<NavBackStackEntry> instantiateBackStack = instantiateBackStack((ArrayDeque) TypeIntrinsics.asMutableMap(this.backStackStates).remove(str2));
        ArrayList<List> arrayList = new ArrayList<>();
        ArrayList<NavBackStackEntry> arrayList2 = new ArrayList<>();
        for (Object next : instantiateBackStack) {
            if (!(((NavBackStackEntry) next).getDestination() instanceof NavGraph)) {
                arrayList2.add(next);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayList2) {
            List list = (List) CollectionsKt___CollectionsKt.lastOrNull(arrayList);
            if (list == null || (navBackStackEntry = (NavBackStackEntry) CollectionsKt___CollectionsKt.last(list)) == null || (destination = navBackStackEntry.getDestination()) == null) {
                str = null;
            } else {
                str = destination.getNavigatorName();
            }
            if (Intrinsics.areEqual((Object) str, (Object) navBackStackEntry2.getDestination().getNavigatorName())) {
                list.add(navBackStackEntry2);
            } else {
                arrayList.add(CollectionsKt__CollectionsKt.mutableListOf(navBackStackEntry2));
            }
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        for (List list2 : arrayList) {
            navigateInternal(this._navigatorProvider.getNavigator(((NavBackStackEntry) CollectionsKt___CollectionsKt.first(list2)).getDestination().getNavigatorName()), list2, navOptions, extras, new NavController$restoreStateInternal$4(booleanRef, instantiateBackStack, new Ref.IntRef(), this, bundle));
        }
        return booleanRef.element;
    }

    private final boolean tryRelaunchUpToExplicitStack() {
        boolean z11;
        Bundle bundle;
        int i11 = 0;
        if (!this.deepLinkHandled) {
            return false;
        }
        Activity activity2 = this.activity;
        Intrinsics.checkNotNull(activity2);
        Intent intent = activity2.getIntent();
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        int[] intArray = extras.getIntArray(KEY_DEEP_LINK_IDS);
        Intrinsics.checkNotNull(intArray);
        List mutableList = ArraysKt___ArraysKt.toMutableList(intArray);
        ArrayList parcelableArrayList = extras.getParcelableArrayList(KEY_DEEP_LINK_ARGS);
        int intValue = ((Number) CollectionsKt__MutableCollectionsKt.removeLast(mutableList)).intValue();
        if (parcelableArrayList != null) {
            Bundle bundle2 = (Bundle) CollectionsKt__MutableCollectionsKt.removeLast(parcelableArrayList);
        }
        if (mutableList.isEmpty()) {
            return false;
        }
        NavDestination findDestination = findDestination(getGraph(), intValue);
        if (findDestination instanceof NavGraph) {
            intValue = NavGraph.Companion.findStartDestination((NavGraph) findDestination).getId();
        }
        NavDestination currentDestination = getCurrentDestination();
        if (currentDestination == null || intValue != currentDestination.getId()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            return false;
        }
        NavDeepLinkBuilder createDeepLink = createDeepLink();
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to(KEY_DEEP_LINK_INTENT, intent));
        Bundle bundle3 = extras.getBundle(KEY_DEEP_LINK_EXTRAS);
        if (bundle3 != null) {
            bundleOf.putAll(bundle3);
        }
        createDeepLink.setArguments(bundleOf);
        for (Object next : mutableList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            int intValue2 = ((Number) next).intValue();
            if (parcelableArrayList != null) {
                bundle = (Bundle) parcelableArrayList.get(i11);
            } else {
                bundle = null;
            }
            createDeepLink.addDestination(intValue2, bundle);
            i11 = i12;
        }
        createDeepLink.createTaskStackBuilder().startActivities();
        Activity activity3 = this.activity;
        if (activity3 != null) {
            activity3.finish();
        }
        return true;
    }

    private final boolean tryRelaunchUpToGeneratedStack() {
        NavDestination currentDestination = getCurrentDestination();
        Intrinsics.checkNotNull(currentDestination);
        int id2 = currentDestination.getId();
        for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getStartDestinationId() != id2) {
                Bundle bundle = new Bundle();
                Activity activity2 = this.activity;
                if (activity2 != null) {
                    Intrinsics.checkNotNull(activity2);
                    if (activity2.getIntent() != null) {
                        Activity activity3 = this.activity;
                        Intrinsics.checkNotNull(activity3);
                        if (activity3.getIntent().getData() != null) {
                            Activity activity4 = this.activity;
                            Intrinsics.checkNotNull(activity4);
                            bundle.putParcelable(KEY_DEEP_LINK_INTENT, activity4.getIntent());
                            NavGraph navGraph = this._graph;
                            Intrinsics.checkNotNull(navGraph);
                            Activity activity5 = this.activity;
                            Intrinsics.checkNotNull(activity5);
                            Intent intent = activity5.getIntent();
                            Intrinsics.checkNotNullExpressionValue(intent, "activity!!.intent");
                            NavDestination.DeepLinkMatch matchDeepLink = navGraph.matchDeepLink(new NavDeepLinkRequest(intent));
                            if (matchDeepLink != null) {
                                bundle.putAll(matchDeepLink.getDestination().addInDefaultArgs(matchDeepLink.getMatchingArgs()));
                            }
                        }
                    }
                }
                NavDeepLinkBuilder.setDestination$default(new NavDeepLinkBuilder(this), parent.getId(), (Bundle) null, 2, (Object) null).setArguments(bundle).createTaskStackBuilder().startActivities();
                Activity activity6 = this.activity;
                if (activity6 == null) {
                    return true;
                }
                activity6.finish();
                return true;
            }
            id2 = parent.getId();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        if (getDestinationCountOnBackStack() > 1) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateOnBackPressedCallbackEnabled() {
        /*
            r3 = this;
            androidx.activity.OnBackPressedCallback r0 = r3.onBackPressedCallback
            boolean r1 = r3.enableOnBackPressedCallback
            if (r1 == 0) goto L_0x000e
            int r1 = r3.getDestinationCountOnBackStack()
            r2 = 1
            if (r1 <= r2) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r2 = 0
        L_0x000f:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.updateOnBackPressedCallbackEnabled():void");
    }

    public void addOnDestinationChangedListener(@NotNull OnDestinationChangedListener onDestinationChangedListener) {
        Intrinsics.checkNotNullParameter(onDestinationChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onDestinationChangedListeners.add(onDestinationChangedListener);
        if (!getBackQueue().isEmpty()) {
            NavBackStackEntry last = getBackQueue().last();
            onDestinationChangedListener.onDestinationChanged(this, last.getDestination(), last.getArguments());
        }
    }

    @MainThread
    public final boolean clearBackStack(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        return clearBackStack(NavDestination.Companion.createRoute(str).hashCode());
    }

    @NotNull
    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void enableOnBackPressed(boolean z11) {
        this.enableOnBackPressedCallback = z11;
        updateOnBackPressedCallbackEnabled();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findDestination(@IdRes int i11) {
        NavDestination navDestination;
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph);
        if (navGraph.getId() == i11) {
            return this._graph;
        }
        NavBackStackEntry lastOrNull = getBackQueue().lastOrNull();
        if (lastOrNull == null || (navDestination = lastOrNull.getDestination()) == null) {
            navDestination = this._graph;
            Intrinsics.checkNotNull(navDestination);
        }
        return findDestination(navDestination, i11);
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ArrayDeque<NavBackStackEntry> getBackQueue() {
        return this.backQueue;
    }

    @NotNull
    public NavBackStackEntry getBackStackEntry(@IdRes int i11) {
        NavBackStackEntry navBackStackEntry;
        boolean z11;
        ArrayDeque<NavBackStackEntry> backQueue2 = getBackQueue();
        ListIterator<NavBackStackEntry> listIterator = backQueue2.listIterator(backQueue2.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            if (navBackStackEntry.getDestination().getId() == i11) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        throw new IllegalArgumentException(("No destination with ID " + i11 + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public NavBackStackEntry getCurrentBackStackEntry() {
        return getBackQueue().lastOrNull();
    }

    @NotNull
    public final Flow<NavBackStackEntry> getCurrentBackStackEntryFlow() {
        return this.currentBackStackEntryFlow;
    }

    @Nullable
    public NavDestination getCurrentDestination() {
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            return currentBackStackEntry.getDestination();
        }
        return null;
    }

    @NotNull
    @MainThread
    public NavGraph getGraph() {
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
        } else if (navGraph != null) {
            return navGraph;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavGraph");
        }
    }

    @NotNull
    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        if (this.lifecycleOwner == null) {
            return Lifecycle.State.CREATED;
        }
        return this.hostLifecycleState;
    }

    @NotNull
    public NavInflater getNavInflater() {
        return (NavInflater) this.navInflater$delegate.getValue();
    }

    @NotNull
    public NavigatorProvider getNavigatorProvider() {
        return this._navigatorProvider;
    }

    @Nullable
    public NavBackStackEntry getPreviousBackStackEntry() {
        Object obj;
        Iterator it = CollectionsKt___CollectionsKt.reversed(getBackQueue()).iterator();
        if (it.hasNext()) {
            it.next();
        }
        Iterator it2 = SequencesKt__SequencesKt.asSequence(it).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                break;
            }
        }
        return (NavBackStackEntry) obj;
    }

    @NotNull
    public ViewModelStoreOwner getViewModelStoreOwner(@IdRes int i11) {
        if (this.viewModel != null) {
            NavBackStackEntry backStackEntry = getBackStackEntry(i11);
            if (backStackEntry.getDestination() instanceof NavGraph) {
                return backStackEntry;
            }
            throw new IllegalArgumentException(("No NavGraph with ID " + i11 + " is on the NavController's back stack").toString());
        }
        throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().".toString());
    }

    @NotNull
    public final StateFlow<List<NavBackStackEntry>> getVisibleEntries() {
        return this.visibleEntries;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
        if (r1 != false) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleDeepLink(@org.jetbrains.annotations.Nullable android.content.Intent r20) {
        /*
            r19 = this;
            r6 = r19
            r0 = r20
            r7 = 0
            if (r0 != 0) goto L_0x0008
            return r7
        L_0x0008:
            android.os.Bundle r1 = r20.getExtras()
            r8 = 0
            if (r1 == 0) goto L_0x0016
            java.lang.String r2 = "android-support-nav:controller:deepLinkIds"
            int[] r2 = r1.getIntArray(r2)
            goto L_0x0017
        L_0x0016:
            r2 = r8
        L_0x0017:
            if (r1 == 0) goto L_0x0020
            java.lang.String r3 = "android-support-nav:controller:deepLinkArgs"
            java.util.ArrayList r3 = r1.getParcelableArrayList(r3)
            goto L_0x0021
        L_0x0020:
            r3 = r8
        L_0x0021:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            if (r1 == 0) goto L_0x002f
            java.lang.String r5 = "android-support-nav:controller:deepLinkExtras"
            android.os.Bundle r1 = r1.getBundle(r5)
            goto L_0x0030
        L_0x002f:
            r1 = r8
        L_0x0030:
            if (r1 == 0) goto L_0x0035
            r4.putAll(r1)
        L_0x0035:
            r9 = 1
            if (r2 == 0) goto L_0x0040
            int r1 = r2.length
            if (r1 != 0) goto L_0x003d
            r1 = r9
            goto L_0x003e
        L_0x003d:
            r1 = r7
        L_0x003e:
            if (r1 == 0) goto L_0x0068
        L_0x0040:
            androidx.navigation.NavGraph r1 = r6._graph
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.navigation.NavDeepLinkRequest r5 = new androidx.navigation.NavDeepLinkRequest
            r5.<init>(r0)
            androidx.navigation.NavDestination$DeepLinkMatch r1 = r1.matchDeepLink(r5)
            if (r1 == 0) goto L_0x0068
            androidx.navigation.NavDestination r2 = r1.getDestination()
            int[] r3 = androidx.navigation.NavDestination.buildDeepLinkIds$default(r2, r8, r9, r8)
            android.os.Bundle r1 = r1.getMatchingArgs()
            android.os.Bundle r1 = r2.addInDefaultArgs(r1)
            if (r1 == 0) goto L_0x0065
            r4.putAll(r1)
        L_0x0065:
            r10 = r3
            r3 = r8
            goto L_0x0069
        L_0x0068:
            r10 = r2
        L_0x0069:
            if (r10 == 0) goto L_0x01e7
            int r1 = r10.length
            if (r1 != 0) goto L_0x0070
            r1 = r9
            goto L_0x0071
        L_0x0070:
            r1 = r7
        L_0x0071:
            if (r1 == 0) goto L_0x0075
            goto L_0x01e7
        L_0x0075:
            java.lang.String r1 = r6.findInvalidDestinationDisplayNameInDeepLink(r10)
            if (r1 == 0) goto L_0x009a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Could not find destination "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " in the navigation graph, ignoring the deep link from "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "NavController"
            android.util.Log.i(r1, r0)
            return r7
        L_0x009a:
            java.lang.String r1 = "android-support-nav:controller:deepLinkIntent"
            r4.putParcelable(r1, r0)
            int r1 = r10.length
            android.os.Bundle[] r11 = new android.os.Bundle[r1]
            r2 = r7
        L_0x00a3:
            if (r2 >= r1) goto L_0x00bf
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r5.putAll(r4)
            if (r3 == 0) goto L_0x00ba
            java.lang.Object r12 = r3.get(r2)
            android.os.Bundle r12 = (android.os.Bundle) r12
            if (r12 == 0) goto L_0x00ba
            r5.putAll(r12)
        L_0x00ba:
            r11[r2] = r5
            int r2 = r2 + 1
            goto L_0x00a3
        L_0x00bf:
            int r1 = r20.getFlags()
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r2 = r2 & r1
            if (r2 == 0) goto L_0x00ee
            r3 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r3
            if (r1 != 0) goto L_0x00ee
            r0.addFlags(r3)
            android.content.Context r1 = r6.context
            androidx.core.app.TaskStackBuilder r1 = androidx.core.app.TaskStackBuilder.create(r1)
            androidx.core.app.TaskStackBuilder r0 = r1.addNextIntentWithParentStack(r0)
            java.lang.String r1 = "create(context)\n        …ntWithParentStack(intent)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0.startActivities()
            android.app.Activity r0 = r6.activity
            if (r0 == 0) goto L_0x00ed
            r0.finish()
            r0.overridePendingTransition(r7, r7)
        L_0x00ed:
            return r9
        L_0x00ee:
            java.lang.String r12 = "Deep Linking failed: destination "
            if (r2 == 0) goto L_0x0155
            kotlin.collections.ArrayDeque r0 = r19.getBackQueue()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x010e
            androidx.navigation.NavGraph r0 = r6._graph
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r1 = r0.getId()
            r2 = 1
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r19
            c(r0, r1, r2, r3, r4, r5)
        L_0x010e:
            int r0 = r10.length
            if (r7 >= r0) goto L_0x0154
            r0 = r10[r7]
            int r1 = r7 + 1
            r2 = r11[r7]
            androidx.navigation.NavDestination r3 = r6.findDestination((int) r0)
            if (r3 == 0) goto L_0x012b
            androidx.navigation.NavController$handleDeepLink$2 r0 = new androidx.navigation.NavController$handleDeepLink$2
            r0.<init>(r3, r6)
            androidx.navigation.NavOptions r0 = androidx.navigation.NavOptionsBuilderKt.navOptions(r0)
            r6.navigate((androidx.navigation.NavDestination) r3, (android.os.Bundle) r2, (androidx.navigation.NavOptions) r0, (androidx.navigation.Navigator.Extras) r8)
            r7 = r1
            goto L_0x010e
        L_0x012b:
            androidx.navigation.NavDestination$Companion r1 = androidx.navigation.NavDestination.Companion
            android.content.Context r2 = r6.context
            java.lang.String r0 = r1.getDisplayName(r2, r0)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r0)
            java.lang.String r0 = " cannot be found from the current destination "
            r2.append(r0)
            androidx.navigation.NavDestination r0 = r19.getCurrentDestination()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0154:
            return r9
        L_0x0155:
            androidx.navigation.NavGraph r0 = r6._graph
            int r1 = r10.length
            r2 = r7
        L_0x0159:
            if (r2 >= r1) goto L_0x01e4
            r3 = r10[r2]
            r4 = r11[r2]
            if (r2 != 0) goto L_0x0164
            androidx.navigation.NavGraph r5 = r6._graph
            goto L_0x016b
        L_0x0164:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.navigation.NavDestination r5 = r0.findNode((int) r3)
        L_0x016b:
            if (r5 == 0) goto L_0x01bf
            int r3 = r10.length
            int r3 = r3 - r9
            if (r2 == r3) goto L_0x0194
            boolean r3 = r5 instanceof androidx.navigation.NavGraph
            if (r3 == 0) goto L_0x01bc
            androidx.navigation.NavGraph r5 = (androidx.navigation.NavGraph) r5
        L_0x0177:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r0 = r5.getStartDestinationId()
            androidx.navigation.NavDestination r0 = r5.findNode((int) r0)
            boolean r0 = r0 instanceof androidx.navigation.NavGraph
            if (r0 == 0) goto L_0x0192
            int r0 = r5.getStartDestinationId()
            androidx.navigation.NavDestination r0 = r5.findNode((int) r0)
            r5 = r0
            androidx.navigation.NavGraph r5 = (androidx.navigation.NavGraph) r5
            goto L_0x0177
        L_0x0192:
            r0 = r5
            goto L_0x01bc
        L_0x0194:
            androidx.navigation.NavOptions$Builder r13 = new androidx.navigation.NavOptions$Builder
            r13.<init>()
            androidx.navigation.NavGraph r3 = r6._graph
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r14 = r3.getId()
            r15 = 1
            r16 = 0
            r17 = 4
            r18 = 0
            androidx.navigation.NavOptions$Builder r3 = androidx.navigation.NavOptions.Builder.setPopUpTo$default((androidx.navigation.NavOptions.Builder) r13, (int) r14, (boolean) r15, (boolean) r16, (int) r17, (java.lang.Object) r18)
            androidx.navigation.NavOptions$Builder r3 = r3.setEnterAnim(r7)
            androidx.navigation.NavOptions$Builder r3 = r3.setExitAnim(r7)
            androidx.navigation.NavOptions r3 = r3.build()
            r6.navigate((androidx.navigation.NavDestination) r5, (android.os.Bundle) r4, (androidx.navigation.NavOptions) r3, (androidx.navigation.Navigator.Extras) r8)
        L_0x01bc:
            int r2 = r2 + 1
            goto L_0x0159
        L_0x01bf:
            androidx.navigation.NavDestination$Companion r1 = androidx.navigation.NavDestination.Companion
            android.content.Context r2 = r6.context
            java.lang.String r1 = r1.getDisplayName(r2, r3)
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            r3.append(r1)
            java.lang.String r1 = " cannot be found in graph "
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x01e4:
            r6.deepLinkHandled = r9
            return r9
        L_0x01e7:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.handleDeepLink(android.content.Intent):boolean");
    }

    @MainThread
    public void navigate(@IdRes int i11) {
        navigate(i11, (Bundle) null);
    }

    @JvmOverloads
    public final void navigate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        navigate$default(this, str, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    @JvmOverloads
    public final void navigate(@NotNull String str, @Nullable NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        navigate$default(this, str, navOptions, (Navigator.Extras) null, 4, (Object) null);
    }

    @MainThread
    public boolean navigateUp() {
        Bundle bundle;
        Intent intent;
        if (getDestinationCountOnBackStack() != 1) {
            return popBackStack();
        }
        Activity activity2 = this.activity;
        int[] iArr = null;
        if (activity2 == null || (intent = activity2.getIntent()) == null) {
            bundle = null;
        } else {
            bundle = intent.getExtras();
        }
        if (bundle != null) {
            iArr = bundle.getIntArray(KEY_DEEP_LINK_IDS);
        }
        if (iArr != null) {
            return tryRelaunchUpToExplicitStack();
        }
        return tryRelaunchUpToGeneratedStack();
    }

    @MainThread
    public boolean popBackStack() {
        if (getBackQueue().isEmpty()) {
            return false;
        }
        NavDestination currentDestination = getCurrentDestination();
        Intrinsics.checkNotNull(currentDestination);
        return popBackStack(currentDestination.getId(), true);
    }

    @MainThread
    @JvmOverloads
    public final boolean popBackStack(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        return popBackStack$default(this, str, z11, false, 4, (Object) null);
    }

    public final void popBackStackFromNavigator$navigation_runtime_release(@NotNull NavBackStackEntry navBackStackEntry, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        int indexOf = getBackQueue().indexOf(navBackStackEntry);
        if (indexOf < 0) {
            Log.i(TAG, "Ignoring pop of " + navBackStackEntry + " as it was not found on the current back stack");
            return;
        }
        int i11 = indexOf + 1;
        if (i11 != getBackQueue().size()) {
            popBackStackInternal(getBackQueue().get(i11).getDestination().getId(), true, false);
        }
        d(this, navBackStackEntry, false, (ArrayDeque) null, 6, (Object) null);
        function0.invoke();
        updateOnBackPressedCallbackEnabled();
        dispatchOnDestinationChanged();
    }

    @NotNull
    public final List<NavBackStackEntry> populateVisibleEntries$navigation_runtime_release() {
        boolean z11;
        boolean z12;
        ArrayList arrayList = new ArrayList();
        for (NavControllerNavigatorState transitionsInProgress : this.navigatorState.values()) {
            ArrayList arrayList2 = new ArrayList();
            for (Object next : transitionsInProgress.getTransitionsInProgress().getValue()) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) next;
                if (arrayList.contains(navBackStackEntry) || navBackStackEntry.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12) {
                    arrayList2.add(next);
                }
            }
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList2);
        }
        ArrayDeque<NavBackStackEntry> backQueue2 = getBackQueue();
        ArrayList arrayList3 = new ArrayList();
        for (T next2 : backQueue2) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) next2;
            if (arrayList.contains(navBackStackEntry2) || !navBackStackEntry2.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList3.add(next2);
            }
        }
        boolean unused2 = CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object next3 : arrayList) {
            if (!(((NavBackStackEntry) next3).getDestination() instanceof NavGraph)) {
                arrayList4.add(next3);
            }
        }
        return arrayList4;
    }

    public void removeOnDestinationChangedListener(@NotNull OnDestinationChangedListener onDestinationChangedListener) {
        Intrinsics.checkNotNullParameter(onDestinationChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onDestinationChangedListeners.remove(onDestinationChangedListener);
    }

    @CallSuper
    public void restoreState(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(this.context.getClassLoader());
            this.navigatorStateToRestore = bundle.getBundle(KEY_NAVIGATOR_STATE);
            this.backStackToRestore = bundle.getParcelableArray(KEY_BACK_STACK);
            this.backStackStates.clear();
            int[] intArray = bundle.getIntArray(KEY_BACK_STACK_DEST_IDS);
            ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_BACK_STACK_IDS);
            if (!(intArray == null || stringArrayList == null)) {
                int length = intArray.length;
                int i11 = 0;
                int i12 = 0;
                while (i11 < length) {
                    this.backStackMap.put(Integer.valueOf(intArray[i11]), stringArrayList.get(i12));
                    i11++;
                    i12++;
                }
            }
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList(KEY_BACK_STACK_STATES_IDS);
            if (stringArrayList2 != null) {
                for (String str : stringArrayList2) {
                    Parcelable[] parcelableArray = bundle.getParcelableArray(KEY_BACK_STACK_STATES_PREFIX + str);
                    if (parcelableArray != null) {
                        Map<String, ArrayDeque<NavBackStackEntryState>> map = this.backStackStates;
                        Intrinsics.checkNotNullExpressionValue(str, "id");
                        ArrayDeque arrayDeque = new ArrayDeque(parcelableArray.length);
                        Iterator it = ArrayIteratorKt.iterator(parcelableArray);
                        while (it.hasNext()) {
                            Parcelable parcelable = (Parcelable) it.next();
                            if (parcelable != null) {
                                arrayDeque.add((NavBackStackEntryState) parcelable);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                            }
                        }
                        map.put(str, arrayDeque);
                    }
                }
            }
            this.deepLinkHandled = bundle.getBoolean(KEY_DEEP_LINK_HANDLED);
        }
    }

    @CallSuper
    @Nullable
    public Bundle saveState() {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = new Bundle();
        for (Map.Entry next : this._navigatorProvider.getNavigators().entrySet()) {
            String str = (String) next.getKey();
            Bundle onSaveState = ((Navigator) next.getValue()).onSaveState();
            if (onSaveState != null) {
                arrayList.add(str);
                bundle2.putBundle(str, onSaveState);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList(KEY_NAVIGATOR_STATE_NAMES, arrayList);
            bundle.putBundle(KEY_NAVIGATOR_STATE, bundle2);
        } else {
            bundle = null;
        }
        if (!getBackQueue().isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[getBackQueue().size()];
            Iterator<NavBackStackEntry> it = getBackQueue().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                parcelableArr[i11] = new NavBackStackEntryState(it.next());
                i11++;
            }
            bundle.putParcelableArray(KEY_BACK_STACK, parcelableArr);
        }
        if (!this.backStackMap.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.backStackMap.size()];
            ArrayList arrayList2 = new ArrayList();
            int i12 = 0;
            for (Map.Entry next2 : this.backStackMap.entrySet()) {
                iArr[i12] = ((Number) next2.getKey()).intValue();
                arrayList2.add((String) next2.getValue());
                i12++;
            }
            bundle.putIntArray(KEY_BACK_STACK_DEST_IDS, iArr);
            bundle.putStringArrayList(KEY_BACK_STACK_IDS, arrayList2);
        }
        if (!this.backStackStates.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList arrayList3 = new ArrayList();
            for (Map.Entry next3 : this.backStackStates.entrySet()) {
                String str2 = (String) next3.getKey();
                ArrayDeque arrayDeque = (ArrayDeque) next3.getValue();
                arrayList3.add(str2);
                Parcelable[] parcelableArr2 = new Parcelable[arrayDeque.size()];
                int i13 = 0;
                for (Object next4 : arrayDeque) {
                    int i14 = i13 + 1;
                    if (i13 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    parcelableArr2[i13] = (NavBackStackEntryState) next4;
                    i13 = i14;
                }
                bundle.putParcelableArray(KEY_BACK_STACK_STATES_PREFIX + str2, parcelableArr2);
            }
            bundle.putStringArrayList(KEY_BACK_STACK_STATES_IDS, arrayList3);
        }
        if (this.deepLinkHandled) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(KEY_DEEP_LINK_HANDLED, this.deepLinkHandled);
        }
        return bundle;
    }

    @CallSuper
    @MainThread
    public void setGraph(@NotNull NavGraph navGraph) {
        Intrinsics.checkNotNullParameter(navGraph, "graph");
        setGraph(navGraph, (Bundle) null);
    }

    public final void setHostLifecycleState$navigation_runtime_release(@NotNull Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.hostLifecycleState = state;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner2) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "owner");
        if (!Intrinsics.areEqual((Object) lifecycleOwner2, (Object) this.lifecycleOwner)) {
            LifecycleOwner lifecycleOwner3 = this.lifecycleOwner;
            if (!(lifecycleOwner3 == null || (lifecycle = lifecycleOwner3.getLifecycle()) == null)) {
                lifecycle.removeObserver(this.lifecycleObserver);
            }
            this.lifecycleOwner = lifecycleOwner2;
            lifecycleOwner2.getLifecycle().addObserver(this.lifecycleObserver);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setNavigatorProvider(@NotNull NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        if (getBackQueue().isEmpty()) {
            this._navigatorProvider = navigatorProvider;
            return;
        }
        throw new IllegalStateException("NavigatorProvider must be set before setGraph call".toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setOnBackPressedDispatcher(@NotNull OnBackPressedDispatcher onBackPressedDispatcher2) {
        Intrinsics.checkNotNullParameter(onBackPressedDispatcher2, "dispatcher");
        if (!Intrinsics.areEqual((Object) onBackPressedDispatcher2, (Object) this.onBackPressedDispatcher)) {
            LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
            if (lifecycleOwner2 != null) {
                this.onBackPressedCallback.remove();
                this.onBackPressedDispatcher = onBackPressedDispatcher2;
                onBackPressedDispatcher2.addCallback(lifecycleOwner2, this.onBackPressedCallback);
                Lifecycle lifecycle = lifecycleOwner2.getLifecycle();
                lifecycle.removeObserver(this.lifecycleObserver);
                lifecycle.addObserver(this.lifecycleObserver);
                return;
            }
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()".toString());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setViewModelStore(@NotNull ViewModelStore viewModelStore) {
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        NavControllerViewModel navControllerViewModel = this.viewModel;
        NavControllerViewModel.Companion companion = NavControllerViewModel.Companion;
        if (!Intrinsics.areEqual((Object) navControllerViewModel, (Object) companion.getInstance(viewModelStore))) {
            if (getBackQueue().isEmpty()) {
                this.viewModel = companion.getInstance(viewModelStore);
                return;
            }
            throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
        }
    }

    @Nullable
    public final NavBackStackEntry unlinkChildFromParent$navigation_runtime_release(@NotNull NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "child");
        NavBackStackEntry remove = this.childToParentEntries.remove(navBackStackEntry);
        Integer num = null;
        if (remove == null) {
            return null;
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(remove);
        if (atomicInteger != null) {
            num = Integer.valueOf(atomicInteger.decrementAndGet());
        }
        if (num != null && num.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(remove.getDestination().getNavigatorName()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.markTransitionComplete(remove);
            }
            this.parentToChildCount.remove(remove);
        }
        return remove;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateBackStackLifecycle$navigation_runtime_release() {
        /*
            r11 = this;
            kotlin.collections.ArrayDeque r0 = r11.getBackQueue()
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r0)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.last(r0)
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r1 = r1.getDestination()
            boolean r2 = r1 instanceof androidx.navigation.FloatingWindow
            r3 = 0
            if (r2 == 0) goto L_0x0042
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.reversed(r2)
            java.util.Iterator r2 = r2.iterator()
        L_0x0029:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0042
            java.lang.Object r4 = r2.next()
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            androidx.navigation.NavDestination r4 = r4.getDestination()
            boolean r5 = r4 instanceof androidx.navigation.NavGraph
            if (r5 != 0) goto L_0x0029
            boolean r5 = r4 instanceof androidx.navigation.FloatingWindow
            if (r5 != 0) goto L_0x0029
            goto L_0x0043
        L_0x0042:
            r4 = r3
        L_0x0043:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r5 = r0
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.reversed(r5)
            java.util.Iterator r5 = r5.iterator()
        L_0x0053:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00fd
            java.lang.Object r6 = r5.next()
            androidx.navigation.NavBackStackEntry r6 = (androidx.navigation.NavBackStackEntry) r6
            androidx.lifecycle.Lifecycle$State r7 = r6.getMaxLifecycle()
            androidx.navigation.NavDestination r8 = r6.getDestination()
            if (r1 == 0) goto L_0x00d3
            int r9 = r8.getId()
            int r10 = r1.getId()
            if (r9 != r10) goto L_0x00d3
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.RESUMED
            if (r7 == r8) goto L_0x00ce
            androidx.navigation.NavigatorProvider r7 = r11.getNavigatorProvider()
            androidx.navigation.NavDestination r9 = r6.getDestination()
            java.lang.String r9 = r9.getNavigatorName()
            androidx.navigation.Navigator r7 = r7.getNavigator((java.lang.String) r9)
            java.util.Map<androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>, androidx.navigation.NavController$NavControllerNavigatorState> r9 = r11.navigatorState
            java.lang.Object r7 = r9.get(r7)
            androidx.navigation.NavController$NavControllerNavigatorState r7 = (androidx.navigation.NavController.NavControllerNavigatorState) r7
            if (r7 == 0) goto L_0x00a8
            kotlinx.coroutines.flow.StateFlow r7 = r7.getTransitionsInProgress()
            if (r7 == 0) goto L_0x00a8
            java.lang.Object r7 = r7.getValue()
            java.util.Set r7 = (java.util.Set) r7
            if (r7 == 0) goto L_0x00a8
            boolean r7 = r7.contains(r6)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            goto L_0x00a9
        L_0x00a8:
            r7 = r3
        L_0x00a9:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r9)
            if (r7 != 0) goto L_0x00c9
            java.util.Map<androidx.navigation.NavBackStackEntry, java.util.concurrent.atomic.AtomicInteger> r7 = r11.parentToChildCount
            java.lang.Object r7 = r7.get(r6)
            java.util.concurrent.atomic.AtomicInteger r7 = (java.util.concurrent.atomic.AtomicInteger) r7
            r9 = 0
            if (r7 == 0) goto L_0x00c3
            int r7 = r7.get()
            if (r7 != 0) goto L_0x00c3
            r9 = 1
        L_0x00c3:
            if (r9 != 0) goto L_0x00c9
            r2.put(r6, r8)
            goto L_0x00ce
        L_0x00c9:
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.STARTED
            r2.put(r6, r7)
        L_0x00ce:
            androidx.navigation.NavGraph r1 = r1.getParent()
            goto L_0x0053
        L_0x00d3:
            if (r4 == 0) goto L_0x00f6
            int r8 = r8.getId()
            int r9 = r4.getId()
            if (r8 != r9) goto L_0x00f6
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.RESUMED
            if (r7 != r8) goto L_0x00e9
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.STARTED
            r6.setMaxLifecycle(r7)
            goto L_0x00f0
        L_0x00e9:
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.STARTED
            if (r7 == r8) goto L_0x00f0
            r2.put(r6, r8)
        L_0x00f0:
            androidx.navigation.NavGraph r4 = r4.getParent()
            goto L_0x0053
        L_0x00f6:
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.CREATED
            r6.setMaxLifecycle(r7)
            goto L_0x0053
        L_0x00fd:
            java.util.Iterator r0 = r0.iterator()
        L_0x0101:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x011d
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            java.lang.Object r3 = r2.get(r1)
            androidx.lifecycle.Lifecycle$State r3 = (androidx.lifecycle.Lifecycle.State) r3
            if (r3 == 0) goto L_0x0119
            r1.setMaxLifecycle(r3)
            goto L_0x0101
        L_0x0119:
            r1.updateState()
            goto L_0x0101
        L_0x011d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.updateBackStackLifecycle$navigation_runtime_release():void");
    }

    @MainThread
    public final boolean clearBackStack(@IdRes int i11) {
        return clearBackStackInternal(i11) && dispatchOnDestinationChanged();
    }

    @MainThread
    public void navigate(@IdRes int i11, @Nullable Bundle bundle) {
        navigate(i11, bundle, (NavOptions) null);
    }

    @CallSuper
    @MainThread
    public void setGraph(@NavigationRes int i11) {
        setGraph(getNavInflater().inflate(i11), (Bundle) null);
    }

    @MainThread
    public void navigate(@IdRes int i11, @Nullable Bundle bundle, @Nullable NavOptions navOptions) {
        navigate(i11, bundle, navOptions, (Navigator.Extras) null);
    }

    @MainThread
    public boolean popBackStack(@IdRes int i11, boolean z11) {
        return popBackStack(i11, z11, false);
    }

    @CallSuper
    @MainThread
    public void setGraph(@NavigationRes int i11, @Nullable Bundle bundle) {
        setGraph(getNavInflater().inflate(i11), bundle);
    }

    @MainThread
    private final boolean popBackStackInternal(@IdRes int i11, boolean z11, boolean z12) {
        NavDestination navDestination;
        int i12 = i11;
        boolean z13 = z12;
        if (getBackQueue().isEmpty()) {
            return false;
        }
        ArrayList<Navigator> arrayList = new ArrayList<>();
        Iterator it = CollectionsKt___CollectionsKt.reversed(getBackQueue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            NavDestination destination = ((NavBackStackEntry) it.next()).getDestination();
            Navigator navigator = this._navigatorProvider.getNavigator(destination.getNavigatorName());
            if (z11 || destination.getId() != i12) {
                arrayList.add(navigator);
            }
            if (destination.getId() == i12) {
                navDestination = destination;
                break;
            }
        }
        if (navDestination == null) {
            String displayName = NavDestination.Companion.getDisplayName(this.context, i12);
            Log.i(TAG, "Ignoring popBackStack to destination " + displayName + " as it was not found on the current back stack");
            return false;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Navigator popBackStackInternal : arrayList) {
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            NavController$popBackStackInternal$2 navController$popBackStackInternal$2 = r0;
            NavController$popBackStackInternal$2 navController$popBackStackInternal$22 = new NavController$popBackStackInternal$2(booleanRef2, booleanRef, this, z12, arrayDeque);
            popBackStackInternal(popBackStackInternal, getBackQueue().last(), z13, navController$popBackStackInternal$2);
            if (!booleanRef2.element) {
                break;
            }
        }
        if (z13) {
            if (!z11) {
                for (NavDestination id2 : SequencesKt___SequencesKt.takeWhile(SequencesKt__SequencesKt.generateSequence(navDestination, NavController$popBackStackInternal$3.INSTANCE), new NavController$popBackStackInternal$4(this))) {
                    Map<Integer, String> map = this.backStackMap;
                    Integer valueOf = Integer.valueOf(id2.getId());
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) arrayDeque.firstOrNull();
                    map.put(valueOf, navBackStackEntryState != null ? navBackStackEntryState.getId() : null);
                }
            }
            if (!arrayDeque.isEmpty()) {
                NavBackStackEntryState navBackStackEntryState2 = (NavBackStackEntryState) arrayDeque.first();
                for (NavDestination id3 : SequencesKt___SequencesKt.takeWhile(SequencesKt__SequencesKt.generateSequence(findDestination(navBackStackEntryState2.getDestinationId()), NavController$popBackStackInternal$6.INSTANCE), new NavController$popBackStackInternal$7(this))) {
                    this.backStackMap.put(Integer.valueOf(id3.getId()), navBackStackEntryState2.getId());
                }
                this.backStackStates.put(navBackStackEntryState2.getId(), arrayDeque);
            }
        }
        updateOnBackPressedCallbackEnabled();
        return booleanRef.element;
    }

    @MainThread
    public void navigate(@IdRes int i11, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        NavDestination navDestination;
        int i12;
        if (getBackQueue().isEmpty()) {
            navDestination = this._graph;
        } else {
            navDestination = getBackQueue().last().getDestination();
        }
        if (navDestination != null) {
            NavAction action = navDestination.getAction(i11);
            Bundle bundle2 = null;
            if (action != null) {
                if (navOptions == null) {
                    navOptions = action.getNavOptions();
                }
                i12 = action.getDestinationId();
                Bundle defaultArguments = action.getDefaultArguments();
                if (defaultArguments != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(defaultArguments);
                }
            } else {
                i12 = i11;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i12 != 0 || navOptions == null || navOptions.getPopUpToId() == -1) {
                boolean z11 = true;
                if (i12 != 0) {
                    NavDestination findDestination = findDestination(i12);
                    if (findDestination == null) {
                        NavDestination.Companion companion = NavDestination.Companion;
                        String displayName = companion.getDisplayName(this.context, i12);
                        if (action != null) {
                            z11 = false;
                        }
                        if (!z11) {
                            throw new IllegalArgumentException(("Navigation destination " + displayName + " referenced from action " + companion.getDisplayName(this.context, i11) + " cannot be found from the current destination " + navDestination).toString());
                        }
                        throw new IllegalArgumentException("Navigation action/destination " + displayName + " cannot be found from the current destination " + navDestination);
                    }
                    navigate(findDestination, bundle2, navOptions, extras);
                    return;
                }
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo".toString());
            }
            popBackStack(navOptions.getPopUpToId(), navOptions.isPopUpToInclusive());
            return;
        }
        throw new IllegalStateException("no current navigation node");
    }

    @MainThread
    public boolean popBackStack(@IdRes int i11, boolean z11, boolean z12) {
        return popBackStackInternal(i11, z11, z12) && dispatchOnDestinationChanged();
    }

    @CallSuper
    @MainThread
    public void setGraph(@NotNull NavGraph navGraph, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(navGraph, "graph");
        if (!Intrinsics.areEqual((Object) this._graph, (Object) navGraph)) {
            NavGraph navGraph2 = this._graph;
            if (navGraph2 != null) {
                for (Integer num : new ArrayList(this.backStackMap.keySet())) {
                    Intrinsics.checkNotNullExpressionValue(num, "id");
                    clearBackStackInternal(num.intValue());
                }
                c(this, navGraph2.getId(), true, false, 4, (Object) null);
            }
            this._graph = navGraph;
            onGraphCreated(bundle);
            return;
        }
        int size = navGraph.getNodes().size();
        for (int i11 = 0; i11 < size; i11++) {
            NavDestination valueAt = navGraph.getNodes().valueAt(i11);
            NavGraph navGraph3 = this._graph;
            Intrinsics.checkNotNull(navGraph3);
            navGraph3.getNodes().replace(i11, valueAt);
            ArrayDeque<NavBackStackEntry> backQueue2 = getBackQueue();
            ArrayList<NavBackStackEntry> arrayList = new ArrayList<>();
            for (T next : backQueue2) {
                if (valueAt != null && ((NavBackStackEntry) next).getDestination().getId() == valueAt.getId()) {
                    arrayList.add(next);
                }
            }
            for (NavBackStackEntry destination : arrayList) {
                Intrinsics.checkNotNullExpressionValue(valueAt, "newDestination");
                destination.setDestination(valueAt);
            }
        }
    }

    private final NavDestination findDestination(NavDestination navDestination, @IdRes int i11) {
        NavGraph navGraph;
        if (navDestination.getId() == i11) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            navGraph = navDestination.getParent();
            Intrinsics.checkNotNull(navGraph);
        }
        return navGraph.findNode(i11);
    }

    @MainThread
    @JvmOverloads
    public final boolean popBackStack(@NotNull String str, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        return popBackStack(NavDestination.Companion.createRoute(str).hashCode(), z11, z12);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findDestination(@NotNull String str) {
        NavDestination navDestination;
        NavGraph navGraph;
        Intrinsics.checkNotNullParameter(str, "destinationRoute");
        NavGraph navGraph2 = this._graph;
        if (navGraph2 == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph2);
        if (Intrinsics.areEqual((Object) navGraph2.getRoute(), (Object) str)) {
            return this._graph;
        }
        NavBackStackEntry lastOrNull = getBackQueue().lastOrNull();
        if (lastOrNull == null || (navDestination = lastOrNull.getDestination()) == null) {
            navDestination = this._graph;
            Intrinsics.checkNotNull(navDestination);
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            navGraph = navDestination.getParent();
            Intrinsics.checkNotNull(navGraph);
        }
        return navGraph.findNode(str);
    }

    @NotNull
    public final NavBackStackEntry getBackStackEntry(@NotNull String str) {
        NavBackStackEntry navBackStackEntry;
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        ArrayDeque<NavBackStackEntry> backQueue2 = getBackQueue();
        ListIterator<NavBackStackEntry> listIterator = backQueue2.listIterator(backQueue2.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            if (Intrinsics.areEqual((Object) navBackStackEntry.getDestination().getRoute(), (Object) str)) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        throw new IllegalArgumentException(("No destination with route " + str + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    @MainThread
    public void navigate(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "deepLink");
        navigate(new NavDeepLinkRequest(uri, (String) null, (String) null));
    }

    @MainThread
    public void navigate(@NotNull Uri uri, @Nullable NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(uri, "deepLink");
        navigate(new NavDeepLinkRequest(uri, (String) null, (String) null), navOptions, (Navigator.Extras) null);
    }

    @MainThread
    public void navigate(@NotNull Uri uri, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(uri, "deepLink");
        navigate(new NavDeepLinkRequest(uri, (String) null, (String) null), navOptions, extras);
    }

    @MainThread
    public void navigate(@NotNull NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "request");
        navigate(navDeepLinkRequest, (NavOptions) null);
    }

    @MainThread
    public void navigate(@NotNull NavDeepLinkRequest navDeepLinkRequest, @Nullable NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "request");
        navigate(navDeepLinkRequest, navOptions, (Navigator.Extras) null);
    }

    @MainThread
    public void navigate(@NotNull NavDeepLinkRequest navDeepLinkRequest, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "request");
        NavGraph navGraph = this._graph;
        Intrinsics.checkNotNull(navGraph);
        NavDestination.DeepLinkMatch matchDeepLink = navGraph.matchDeepLink(navDeepLinkRequest);
        if (matchDeepLink != null) {
            Bundle addInDefaultArgs = matchDeepLink.getDestination().addInDefaultArgs(matchDeepLink.getMatchingArgs());
            if (addInDefaultArgs == null) {
                addInDefaultArgs = new Bundle();
            }
            NavDestination destination = matchDeepLink.getDestination();
            Intent intent = new Intent();
            intent.setDataAndType(navDeepLinkRequest.getUri(), navDeepLinkRequest.getMimeType());
            intent.setAction(navDeepLinkRequest.getAction());
            addInDefaultArgs.putParcelable(KEY_DEEP_LINK_INTENT, intent);
            navigate(destination, addInDefaultArgs, navOptions, extras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches request " + navDeepLinkRequest + " cannot be found in the navigation graph " + this._graph);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x011d A[LOOP:1: B:42:0x0117->B:44:0x011d, LOOP_END] */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void navigate(androidx.navigation.NavDestination r21, android.os.Bundle r22, androidx.navigation.NavOptions r23, androidx.navigation.Navigator.Extras r24) {
        /*
            r20 = this;
            r6 = r20
            r3 = r23
            java.util.Map<androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>, androidx.navigation.NavController$NavControllerNavigatorState> r0 = r6.navigatorState
            java.util.Collection r0 = r0.values()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0010:
            boolean r1 = r0.hasNext()
            r2 = 1
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavController$NavControllerNavigatorState r1 = (androidx.navigation.NavController.NavControllerNavigatorState) r1
            r1.setNavigating(r2)
            goto L_0x0010
        L_0x0021:
            kotlin.jvm.internal.Ref$BooleanRef r7 = new kotlin.jvm.internal.Ref$BooleanRef
            r7.<init>()
            r8 = 0
            if (r3 == 0) goto L_0x0042
            int r0 = r23.getPopUpToId()
            r1 = -1
            if (r0 == r1) goto L_0x0042
            int r0 = r23.getPopUpToId()
            boolean r1 = r23.isPopUpToInclusive()
            boolean r4 = r23.shouldPopUpToSaveState()
            boolean r0 = r6.popBackStackInternal(r0, r1, r4)
            r9 = r0
            goto L_0x0043
        L_0x0042:
            r9 = r8
        L_0x0043:
            android.os.Bundle r0 = r21.addInDefaultArgs(r22)
            if (r3 == 0) goto L_0x0051
            boolean r1 = r23.shouldRestoreState()
            if (r1 != r2) goto L_0x0051
            r1 = r2
            goto L_0x0052
        L_0x0051:
            r1 = r8
        L_0x0052:
            if (r1 == 0) goto L_0x0072
            java.util.Map<java.lang.Integer, java.lang.String> r1 = r6.backStackMap
            int r4 = r21.getId()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x0072
            int r1 = r21.getId()
            r4 = r24
            boolean r0 = r6.restoreStateInternal(r1, r0, r3, r4)
            r7.element = r0
            goto L_0x0107
        L_0x0072:
            r4 = r24
            androidx.navigation.NavBackStackEntry r1 = r20.getCurrentBackStackEntry()
            androidx.navigation.NavigatorProvider r5 = r6._navigatorProvider
            java.lang.String r10 = r21.getNavigatorName()
            androidx.navigation.Navigator r5 = r5.getNavigator((java.lang.String) r10)
            if (r3 == 0) goto L_0x008c
            boolean r10 = r23.shouldLaunchSingleTop()
            if (r10 != r2) goto L_0x008c
            r10 = r2
            goto L_0x008d
        L_0x008c:
            r10 = r8
        L_0x008d:
            if (r10 == 0) goto L_0x00d8
            if (r1 == 0) goto L_0x00a3
            androidx.navigation.NavDestination r10 = r1.getDestination()
            if (r10 == 0) goto L_0x00a3
            int r11 = r21.getId()
            int r10 = r10.getId()
            if (r11 != r10) goto L_0x00a3
            r10 = r2
            goto L_0x00a4
        L_0x00a3:
            r10 = r8
        L_0x00a4:
            if (r10 == 0) goto L_0x00d8
            kotlin.collections.ArrayDeque r3 = r20.getBackQueue()
            java.lang.Object r3 = r3.removeLast()
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            r6.unlinkChildFromParent$navigation_runtime_release(r3)
            androidx.navigation.NavBackStackEntry r3 = new androidx.navigation.NavBackStackEntry
            r3.<init>(r1, r0)
            kotlin.collections.ArrayDeque r0 = r20.getBackQueue()
            r0.addLast(r3)
            androidx.navigation.NavDestination r0 = r3.getDestination()
            androidx.navigation.NavGraph r0 = r0.getParent()
            if (r0 == 0) goto L_0x00d4
            int r0 = r0.getId()
            androidx.navigation.NavBackStackEntry r0 = r6.getBackStackEntry((int) r0)
            r6.linkChildToParent(r3, r0)
        L_0x00d4:
            r5.onLaunchSingleTop(r3)
            goto L_0x0108
        L_0x00d8:
            androidx.navigation.NavBackStackEntry$Companion r10 = androidx.navigation.NavBackStackEntry.Companion
            android.content.Context r11 = r6.context
            androidx.lifecycle.Lifecycle$State r14 = r20.getHostLifecycleState$navigation_runtime_release()
            androidx.navigation.NavControllerViewModel r15 = r6.viewModel
            r16 = 0
            r17 = 0
            r18 = 96
            r19 = 0
            r12 = r21
            r13 = r0
            androidx.navigation.NavBackStackEntry r1 = androidx.navigation.NavBackStackEntry.Companion.create$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r1)
            androidx.navigation.NavController$navigate$4 r10 = new androidx.navigation.NavController$navigate$4
            r1 = r21
            r10.<init>(r7, r6, r1, r0)
            r0 = r20
            r1 = r5
            r3 = r23
            r4 = r24
            r5 = r10
            r0.navigateInternal(r1, r2, r3, r4, r5)
        L_0x0107:
            r2 = r8
        L_0x0108:
            r20.updateOnBackPressedCallbackEnabled()
            java.util.Map<androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>, androidx.navigation.NavController$NavControllerNavigatorState> r0 = r6.navigatorState
            java.util.Collection r0 = r0.values()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0117:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0127
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavController$NavControllerNavigatorState r1 = (androidx.navigation.NavController.NavControllerNavigatorState) r1
            r1.setNavigating(r8)
            goto L_0x0117
        L_0x0127:
            if (r9 != 0) goto L_0x0134
            boolean r0 = r7.element
            if (r0 != 0) goto L_0x0134
            if (r2 == 0) goto L_0x0130
            goto L_0x0134
        L_0x0130:
            r20.updateBackStackLifecycle$navigation_runtime_release()
            goto L_0x0137
        L_0x0134:
            r20.dispatchOnDestinationChanged()
        L_0x0137:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.navigate(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):void");
    }

    @MainThread
    public void navigate(@NotNull NavDirections navDirections) {
        Intrinsics.checkNotNullParameter(navDirections, "directions");
        navigate(navDirections.getActionId(), navDirections.getArguments(), (NavOptions) null);
    }

    @MainThread
    public void navigate(@NotNull NavDirections navDirections, @Nullable NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(navDirections, "directions");
        navigate(navDirections.getActionId(), navDirections.getArguments(), navOptions);
    }

    @MainThread
    public void navigate(@NotNull NavDirections navDirections, @NotNull Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(navDirections, "directions");
        Intrinsics.checkNotNullParameter(extras, "navigatorExtras");
        navigate(navDirections.getActionId(), navDirections.getArguments(), (NavOptions) null, extras);
    }

    public final void navigate(@NotNull String str, @NotNull Function1<? super NavOptionsBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        Intrinsics.checkNotNullParameter(function1, "builder");
        navigate$default(this, str, NavOptionsBuilderKt.navOptions(function1), (Navigator.Extras) null, 4, (Object) null);
    }

    @JvmOverloads
    public final void navigate(@NotNull String str, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        NavDeepLinkRequest.Builder.Companion companion = NavDeepLinkRequest.Builder.Companion;
        Uri parse = Uri.parse(NavDestination.Companion.createRoute(str));
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        navigate(companion.fromUri(parse).build(), navOptions, extras);
    }
}
