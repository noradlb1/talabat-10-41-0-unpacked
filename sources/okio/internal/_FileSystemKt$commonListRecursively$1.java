package okio.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "okio.internal._FileSystemKt$commonListRecursively$1", f = "-FileSystem.kt", i = {0, 0}, l = {93}, m = "invokeSuspend", n = {"$this$sequence", "stack"}, s = {"L$0", "L$1"})
public final class _FileSystemKt$commonListRecursively$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Path $dir;
    final /* synthetic */ boolean $followSymlinks;
    final /* synthetic */ FileSystem $this_commonListRecursively;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public _FileSystemKt$commonListRecursively$1(Path path, FileSystem fileSystem, boolean z11, Continuation<? super _FileSystemKt$commonListRecursively$1> continuation) {
        super(2, continuation);
        this.$dir = path;
        this.$this_commonListRecursively = fileSystem;
        this.$followSymlinks = z11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        _FileSystemKt$commonListRecursively$1 _filesystemkt_commonlistrecursively_1 = new _FileSystemKt$commonListRecursively$1(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, continuation);
        _filesystemkt_commonlistrecursively_1.L$0 = obj;
        return _filesystemkt_commonlistrecursively_1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super Path> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((_FileSystemKt$commonListRecursively$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ArrayDeque arrayDeque;
        _FileSystemKt$commonListRecursively$1 _filesystemkt_commonlistrecursively_1;
        SequenceScope sequenceScope;
        Iterator<Path> it;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.addLast(this.$dir);
            _filesystemkt_commonlistrecursively_1 = this;
            sequenceScope = (SequenceScope) this.L$0;
            arrayDeque = arrayDeque2;
            it = this.$this_commonListRecursively.list(this.$dir).iterator();
        } else if (i11 == 1) {
            it = (Iterator) this.L$2;
            ResultKt.throwOnFailure(obj);
            _filesystemkt_commonlistrecursively_1 = this;
            arrayDeque = (ArrayDeque) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            FileSystem fileSystem = _filesystemkt_commonlistrecursively_1.$this_commonListRecursively;
            boolean z11 = _filesystemkt_commonlistrecursively_1.$followSymlinks;
            _filesystemkt_commonlistrecursively_1.L$0 = sequenceScope;
            _filesystemkt_commonlistrecursively_1.L$1 = arrayDeque;
            _filesystemkt_commonlistrecursively_1.L$2 = it;
            _filesystemkt_commonlistrecursively_1.label = 1;
            if (_FileSystemKt.collectRecursively(sequenceScope, fileSystem, arrayDeque, it.next(), z11, false, _filesystemkt_commonlistrecursively_1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
