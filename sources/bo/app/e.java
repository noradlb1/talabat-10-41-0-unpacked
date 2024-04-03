package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.coroutine.BrazeCoroutineScope;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004H\u0016J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J,\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0010H\u0016J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0012H\u0016J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0014H\u0016J\u0013\u0010\u0016\u001a\u00020\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¨\u0006\""}, d2 = {"Lbo/app/e;", "Landroid/content/SharedPreferences;", "", "a", "", "", "getAll", "key", "defValue", "getString", "", "defValues", "", "getStringSet", "", "getInt", "", "getLong", "", "getFloat", "", "getBoolean", "contains", "Landroid/content/SharedPreferences$Editor;", "edit", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "listener", "registerOnSharedPreferenceChangeListener", "unregisterOnSharedPreferenceChangeListener", "Landroid/content/Context;", "context", "name", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class e implements SharedPreferences {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f38458a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f38459b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f38460c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Job f38461d = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new a(this, (Continuation<? super a>) null), 3, (Object) null);

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.storage.AsyncPrefs$storageInitJob$1", f = "AsyncPrefs.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        int f38462b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f38463c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f38463c = eVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.f38463c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f38462b == 0) {
                ResultKt.throwOnFailure(obj);
                this.f38463c.f38458a.getSharedPreferences(this.f38463c.f38459b, 0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.storage.AsyncPrefs$waitUntilReady$1", f = "AsyncPrefs.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        int f38464b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f38465c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(e eVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f38465c = eVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.f38465c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f38464b;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Job c11 = this.f38465c.f38461d;
                this.f38464b = 1;
                if (c11.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public e(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        this.f38458a = context;
        this.f38459b = str;
    }

    public boolean contains(String str) {
        a();
        SharedPreferences sharedPreferences = this.f38460c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.contains(str);
    }

    public SharedPreferences.Editor edit() {
        a();
        SharedPreferences sharedPreferences = this.f38460c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "prefs.edit()");
        return edit;
    }

    public Map<String, ?> getAll() {
        a();
        SharedPreferences sharedPreferences = this.f38460c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        Map<String, ?> all = sharedPreferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "prefs.all");
        return all;
    }

    public boolean getBoolean(String str, boolean z11) {
        a();
        SharedPreferences sharedPreferences = this.f38460c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getBoolean(str, z11);
    }

    public float getFloat(String str, float f11) {
        a();
        SharedPreferences sharedPreferences = this.f38460c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getFloat(str, f11);
    }

    public int getInt(String str, int i11) {
        a();
        SharedPreferences sharedPreferences = this.f38460c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getInt(str, i11);
    }

    public long getLong(String str, long j11) {
        a();
        SharedPreferences sharedPreferences = this.f38460c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getLong(str, j11);
    }

    public String getString(String str, String str2) {
        a();
        SharedPreferences sharedPreferences = this.f38460c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getString(str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        a();
        SharedPreferences sharedPreferences = this.f38460c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getStringSet(str, set);
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        a();
        SharedPreferences sharedPreferences = this.f38460c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        a();
        SharedPreferences sharedPreferences = this.f38460c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    private final void a() {
        if (!this.f38461d.isCompleted()) {
            Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new b(this, (Continuation<? super b>) null), 1, (Object) null);
        }
        SharedPreferences sharedPreferences = this.f38458a.getSharedPreferences(this.f38459b, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
        this.f38460c = sharedPreferences;
    }
}
