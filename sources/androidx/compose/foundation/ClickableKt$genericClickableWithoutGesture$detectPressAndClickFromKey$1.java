package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1 extends Lambda implements Function1<KeyEvent, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1603g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Map<Key, PressInteraction.Press> f1604h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<Offset> f1605i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f1606j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1607k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1608l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1", f = "Clickable.kt", i = {}, l = {540}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f1609h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(mutableInteractionSource, press, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f1609h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                MutableInteractionSource mutableInteractionSource = mutableInteractionSource;
                PressInteraction.Press press = press;
                this.f1609h = 1;
                if (mutableInteractionSource.emit(press, this) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1(boolean z11, Map<Key, PressInteraction.Press> map, State<Offset> state, CoroutineScope coroutineScope, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.f1603g = z11;
        this.f1604h = map;
        this.f1605i = state;
        this.f1606j = coroutineScope;
        this.f1607k = function0;
        this.f1608l = mutableInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m210invokeZmokQxo(((KeyEvent) obj).m4172unboximpl());
    }

    @NotNull
    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m210invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        boolean z11 = true;
        if (!this.f1603g || !Clickable_androidKt.m213isPressZmokQxo(keyEvent)) {
            if (this.f1603g && Clickable_androidKt.m211isClickZmokQxo(keyEvent)) {
                PressInteraction.Press remove = this.f1604h.remove(Key.m3585boximpl(KeyEvent_androidKt.m4183getKeyZmokQxo(keyEvent)));
                if (remove != null) {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.f1606j, (CoroutineContext) null, (CoroutineStart) null, new ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1(this.f1608l, remove, (Continuation<? super ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1>) null), 3, (Object) null);
                }
                this.f1607k.invoke();
                return Boolean.valueOf(z11);
            }
        } else if (!this.f1604h.containsKey(Key.m3585boximpl(KeyEvent_androidKt.m4183getKeyZmokQxo(keyEvent)))) {
            final PressInteraction.Press press = new PressInteraction.Press(this.f1605i.getValue().m2686unboximpl(), (DefaultConstructorMarker) null);
            this.f1604h.put(Key.m3585boximpl(KeyEvent_androidKt.m4183getKeyZmokQxo(keyEvent)), press);
            CoroutineScope coroutineScope = this.f1606j;
            final MutableInteractionSource mutableInteractionSource = this.f1608l;
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return Boolean.valueOf(z11);
        }
        z11 = false;
        return Boolean.valueOf(z11);
    }
}
