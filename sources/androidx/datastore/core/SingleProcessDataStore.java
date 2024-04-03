package androidx.datastore.core;

import androidx.annotation.GuardedBy;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 F*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003FGHB\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012?\b\u0002\u0010\b\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n0\t\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001f\u0010+\u001a\u00020\u00102\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H@ø\u0001\u0000¢\u0006\u0002\u0010.J\u001f\u0010/\u001a\u00020\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u000001H@ø\u0001\u0000¢\u0006\u0002\u00102J\u0011\u00103\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00105\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00106\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00107\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00108\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u00104JL\u00109\u001a\u00028\u000021\u0010:\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(;\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n2\u0006\u0010<\u001a\u00020=H@ø\u0001\u0000¢\u0006\u0002\u0010>JD\u0010?\u001a\u00028\u000021\u0010:\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(;\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\nH@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001b\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\f\u0010E\u001a\u00020\u0010*\u00020\u0005H\u0002R\u000e\u0010\u0017\u001a\u00020\u0018XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0!X\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'RJ\u0010*\u001a;\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n\u0018\u00010\tX\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006I"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore;", "T", "Landroidx/datastore/core/DataStore;", "produceFile", "Lkotlin/Function0;", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "initTasksList", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "corruptionHandler", "Landroidx/datastore/core/CorruptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/datastore/core/Serializer;Ljava/util/List;Landroidx/datastore/core/CorruptionHandler;Lkotlinx/coroutines/CoroutineScope;)V", "SCRATCH_SUFFIX", "", "actor", "Landroidx/datastore/core/SimpleActor;", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "data", "Lkotlinx/coroutines/flow/Flow;", "getData", "()Lkotlinx/coroutines/flow/Flow;", "downstreamFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/datastore/core/State;", "getDownstreamFlow$annotations", "()V", "file", "getFile", "()Ljava/io/File;", "file$delegate", "Lkotlin/Lazy;", "initTasks", "handleRead", "read", "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Read;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUpdate", "update", "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAndInit", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAndInitOrPropagateAndThrowFailure", "readAndInitOrPropagateFailure", "readData", "readDataOrHandleCorruption", "transformAndWrite", "transform", "t", "callerContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateData", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeData", "newData", "writeData$datastore_core", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createParentDirectories", "Companion", "Message", "UncloseableOutputStream", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SingleProcessDataStore<T> implements DataStore<T> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    @GuardedBy("activeFilesLock")
    public static final Set<String> activeFiles = new LinkedHashSet();
    /* access modifiers changed from: private */
    @NotNull
    public static final Object activeFilesLock = new Object();
    @NotNull
    private final String SCRATCH_SUFFIX;
    /* access modifiers changed from: private */
    @NotNull
    public final SimpleActor<Message<T>> actor;
    @NotNull
    private final CorruptionHandler<T> corruptionHandler;
    @NotNull
    private final Flow<T> data;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableStateFlow<State<T>> downstreamFlow;
    @NotNull
    private final Lazy file$delegate;
    @Nullable
    private List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasks;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<File> produceFile;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final Serializer<T> serializer;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Companion;", "", "()V", "activeFiles", "", "", "getActiveFiles$datastore_core", "()Ljava/util/Set;", "activeFilesLock", "getActiveFilesLock$datastore_core", "()Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Set<String> getActiveFiles$datastore_core() {
            return SingleProcessDataStore.activeFiles;
        }

        @NotNull
        public final Object getActiveFilesLock$datastore_core() {
            return SingleProcessDataStore.activeFilesLock;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0002\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message;", "T", "", "()V", "lastState", "Landroidx/datastore/core/State;", "getLastState", "()Landroidx/datastore/core/State;", "Read", "Update", "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class Message<T> {

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "lastState", "Landroidx/datastore/core/State;", "(Landroidx/datastore/core/State;)V", "getLastState", "()Landroidx/datastore/core/State;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Read<T> extends Message<T> {
            @Nullable
            private final State<T> lastState;

            public Read(@Nullable State<T> state) {
                super((DefaultConstructorMarker) null);
                this.lastState = state;
            }

            @Nullable
            public State<T> getLastState() {
                return this.lastState;
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002Ba\u00121\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016RA\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "ack", "Lkotlinx/coroutines/CompletableDeferred;", "lastState", "Landroidx/datastore/core/State;", "callerContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CompletableDeferred;Landroidx/datastore/core/State;Lkotlin/coroutines/CoroutineContext;)V", "getAck", "()Lkotlinx/coroutines/CompletableDeferred;", "getCallerContext", "()Lkotlin/coroutines/CoroutineContext;", "getLastState", "()Landroidx/datastore/core/State;", "getTransform", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Update<T> extends Message<T> {
            @NotNull
            private final CompletableDeferred<T> ack;
            @NotNull
            private final CoroutineContext callerContext;
            @Nullable
            private final State<T> lastState;
            @NotNull
            private final Function2<T, Continuation<? super T>, Object> transform;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Update(@NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull CompletableDeferred<T> completableDeferred, @Nullable State<T> state, @NotNull CoroutineContext coroutineContext) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(function2, "transform");
                Intrinsics.checkNotNullParameter(completableDeferred, "ack");
                Intrinsics.checkNotNullParameter(coroutineContext, "callerContext");
                this.transform = function2;
                this.ack = completableDeferred;
                this.lastState = state;
                this.callerContext = coroutineContext;
            }

            @NotNull
            public final CompletableDeferred<T> getAck() {
                return this.ack;
            }

            @NotNull
            public final CoroutineContext getCallerContext() {
                return this.callerContext;
            }

            @Nullable
            public State<T> getLastState() {
                return this.lastState;
            }

            @NotNull
            public final Function2<T, Continuation<? super T>, Object> getTransform() {
                return this.transform;
            }
        }

        private Message() {
        }

        public /* synthetic */ Message(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public abstract State<T> getLastState();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$UncloseableOutputStream;", "Ljava/io/OutputStream;", "fileOutputStream", "Ljava/io/FileOutputStream;", "(Ljava/io/FileOutputStream;)V", "getFileOutputStream", "()Ljava/io/FileOutputStream;", "close", "", "flush", "write", "b", "", "bytes", "off", "", "len", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UncloseableOutputStream extends OutputStream {
        @NotNull
        private final FileOutputStream fileOutputStream;

        public UncloseableOutputStream(@NotNull FileOutputStream fileOutputStream2) {
            Intrinsics.checkNotNullParameter(fileOutputStream2, "fileOutputStream");
            this.fileOutputStream = fileOutputStream2;
        }

        public void close() {
        }

        public void flush() {
            this.fileOutputStream.flush();
        }

        @NotNull
        public final FileOutputStream getFileOutputStream() {
            return this.fileOutputStream;
        }

        public void write(int i11) {
            this.fileOutputStream.write(i11);
        }

        public void write(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "b");
            this.fileOutputStream.write(bArr);
        }

        public void write(@NotNull byte[] bArr, int i11, int i12) {
            Intrinsics.checkNotNullParameter(bArr, "bytes");
            this.fileOutputStream.write(bArr, i11, i12);
        }
    }

    public SingleProcessDataStore(@NotNull Function0<? extends File> function0, @NotNull Serializer<T> serializer2, @NotNull List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> list, @NotNull CorruptionHandler<T> corruptionHandler2, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        Intrinsics.checkNotNullParameter(serializer2, "serializer");
        Intrinsics.checkNotNullParameter(list, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler2, "corruptionHandler");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.produceFile = function0;
        this.serializer = serializer2;
        this.corruptionHandler = corruptionHandler2;
        this.scope = coroutineScope;
        this.data = FlowKt.flow(new SingleProcessDataStore$data$1(this, (Continuation<? super SingleProcessDataStore$data$1>) null));
        this.SCRATCH_SUFFIX = ".tmp";
        this.file$delegate = LazyKt__LazyJVMKt.lazy(new SingleProcessDataStore$file$2(this));
        this.downstreamFlow = StateFlowKt.MutableStateFlow(UnInitialized.INSTANCE);
        this.initTasks = CollectionsKt___CollectionsKt.toList(list);
        this.actor = new SimpleActor<>(coroutineScope, new SingleProcessDataStore$actor$1(this), SingleProcessDataStore$actor$2.INSTANCE, new SingleProcessDataStore$actor$3(this, (Continuation<? super SingleProcessDataStore$actor$3>) null));
    }

    private final void createParentDirectories(File file) {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException(Intrinsics.stringPlus("Unable to create parent directories of ", file));
            }
        }
    }

    private static /* synthetic */ void getDownstreamFlow$annotations() {
    }

    /* access modifiers changed from: private */
    public final File getFile() {
        return (File) this.file$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Object handleRead(Message.Read<T> read, Continuation<? super Unit> continuation) {
        State<T> value = this.downstreamFlow.getValue();
        if (!(value instanceof Data)) {
            if (value instanceof ReadException) {
                if (value == read.getLastState()) {
                    Object readAndInitOrPropagateFailure = readAndInitOrPropagateFailure(continuation);
                    if (readAndInitOrPropagateFailure == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return readAndInitOrPropagateFailure;
                    }
                    return Unit.INSTANCE;
                }
            } else if (Intrinsics.areEqual((Object) value, (Object) UnInitialized.INSTANCE)) {
                Object readAndInitOrPropagateFailure2 = readAndInitOrPropagateFailure(continuation);
                if (readAndInitOrPropagateFailure2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return readAndInitOrPropagateFailure2;
                }
                return Unit.INSTANCE;
            } else if (value instanceof Final) {
                throw new IllegalStateException("Can't read in final state.".toString());
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleUpdate(androidx.datastore.core.SingleProcessDataStore.Message.Update<T> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.SingleProcessDataStore$handleUpdate$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.SingleProcessDataStore$handleUpdate$1 r0 = (androidx.datastore.core.SingleProcessDataStore$handleUpdate$1) r0
            int r1 = r0.f35649m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35649m = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$handleUpdate$1 r0 = new androidx.datastore.core.SingleProcessDataStore$handleUpdate$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f35647k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f35649m
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r5) goto L_0x004a
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r9 = r0.f35644h
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
            goto L_0x004e
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0038:
            java.lang.Object r9 = r0.f35646j
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
            java.lang.Object r2 = r0.f35645i
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            java.lang.Object r4 = r0.f35644h
            androidx.datastore.core.SingleProcessDataStore$Message$Update r4 = (androidx.datastore.core.SingleProcessDataStore.Message.Update) r4
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0052 }
            r10 = r9
            r9 = r4
            goto L_0x00a0
        L_0x004a:
            java.lang.Object r9 = r0.f35644h
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0052 }
            goto L_0x00b8
        L_0x0052:
            r10 = move-exception
            goto L_0x00d9
        L_0x0055:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.CompletableDeferred r10 = r9.getAck()
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x00d5 }
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r2 = r8.downstreamFlow     // Catch:{ all -> 0x00d5 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00d5 }
            androidx.datastore.core.State r2 = (androidx.datastore.core.State) r2     // Catch:{ all -> 0x00d5 }
            boolean r6 = r2 instanceof androidx.datastore.core.Data     // Catch:{ all -> 0x00d5 }
            if (r6 == 0) goto L_0x0081
            kotlin.jvm.functions.Function2 r2 = r9.getTransform()     // Catch:{ all -> 0x00d5 }
            kotlin.coroutines.CoroutineContext r9 = r9.getCallerContext()     // Catch:{ all -> 0x00d5 }
            r0.f35644h = r10     // Catch:{ all -> 0x00d5 }
            r0.f35649m = r5     // Catch:{ all -> 0x00d5 }
            java.lang.Object r9 = r8.transformAndWrite(r2, r9, r0)     // Catch:{ all -> 0x00d5 }
            if (r9 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00b8
        L_0x0081:
            boolean r6 = r2 instanceof androidx.datastore.core.ReadException     // Catch:{ all -> 0x00d5 }
            if (r6 == 0) goto L_0x0086
            goto L_0x0088
        L_0x0086:
            boolean r5 = r2 instanceof androidx.datastore.core.UnInitialized     // Catch:{ all -> 0x00d5 }
        L_0x0088:
            if (r5 == 0) goto L_0x00c4
            androidx.datastore.core.State r5 = r9.getLastState()     // Catch:{ all -> 0x00d5 }
            if (r2 != r5) goto L_0x00bd
            r0.f35644h = r9     // Catch:{ all -> 0x00d5 }
            r0.f35645i = r8     // Catch:{ all -> 0x00d5 }
            r0.f35646j = r10     // Catch:{ all -> 0x00d5 }
            r0.f35649m = r4     // Catch:{ all -> 0x00d5 }
            java.lang.Object r2 = r8.readAndInitOrPropagateAndThrowFailure(r0)     // Catch:{ all -> 0x00d5 }
            if (r2 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r2 = r8
        L_0x00a0:
            kotlin.jvm.functions.Function2 r4 = r9.getTransform()     // Catch:{ all -> 0x00d5 }
            kotlin.coroutines.CoroutineContext r9 = r9.getCallerContext()     // Catch:{ all -> 0x00d5 }
            r0.f35644h = r10     // Catch:{ all -> 0x00d5 }
            r5 = 0
            r0.f35645i = r5     // Catch:{ all -> 0x00d5 }
            r0.f35646j = r5     // Catch:{ all -> 0x00d5 }
            r0.f35649m = r3     // Catch:{ all -> 0x00d5 }
            java.lang.Object r9 = r2.transformAndWrite(r4, r9, r0)     // Catch:{ all -> 0x00d5 }
            if (r9 != r1) goto L_0x007d
            return r1
        L_0x00b8:
            java.lang.Object r10 = kotlin.Result.m6329constructorimpl(r10)     // Catch:{ all -> 0x0052 }
            goto L_0x00e3
        L_0x00bd:
            androidx.datastore.core.ReadException r2 = (androidx.datastore.core.ReadException) r2     // Catch:{ all -> 0x00d5 }
            java.lang.Throwable r9 = r2.getReadException()     // Catch:{ all -> 0x00d5 }
            throw r9     // Catch:{ all -> 0x00d5 }
        L_0x00c4:
            boolean r9 = r2 instanceof androidx.datastore.core.Final     // Catch:{ all -> 0x00d5 }
            if (r9 == 0) goto L_0x00cf
            androidx.datastore.core.Final r2 = (androidx.datastore.core.Final) r2     // Catch:{ all -> 0x00d5 }
            java.lang.Throwable r9 = r2.getFinalException()     // Catch:{ all -> 0x00d5 }
            throw r9     // Catch:{ all -> 0x00d5 }
        L_0x00cf:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x00d5 }
            r9.<init>()     // Catch:{ all -> 0x00d5 }
            throw r9     // Catch:{ all -> 0x00d5 }
        L_0x00d5:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x00d9:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m6329constructorimpl(r10)
        L_0x00e3:
            kotlinx.coroutines.CompletableDeferredKt.completeWith(r9, r10)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.handleUpdate(androidx.datastore.core.SingleProcessDataStore$Message$Update, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0116 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAndInit(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInit$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            androidx.datastore.core.SingleProcessDataStore$readAndInit$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$1) r0
            int r1 = r0.f35658p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35658p = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInit$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$1
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f35656n
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f35658p
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x007b
            if (r2 == r6) goto L_0x0067
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r1 = r0.f35653k
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r2 = r0.f35652j
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r3 = r0.f35651i
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r0 = r0.f35650h
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0119
        L_0x0042:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x004a:
            java.lang.Object r2 = r0.f35655m
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r8 = r0.f35654l
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1 r8 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1) r8
            java.lang.Object r9 = r0.f35653k
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r0.f35652j
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.f35651i
            kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
            java.lang.Object r12 = r0.f35650h
            androidx.datastore.core.SingleProcessDataStore r12 = (androidx.datastore.core.SingleProcessDataStore) r12
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00da
        L_0x0067:
            java.lang.Object r2 = r0.f35653k
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r8 = r0.f35652j
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r0.f35651i
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r0.f35650h
            androidx.datastore.core.SingleProcessDataStore r10 = (androidx.datastore.core.SingleProcessDataStore) r10
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00b8
        L_0x007b:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r14 = r13.downstreamFlow
            java.lang.Object r14 = r14.getValue()
            androidx.datastore.core.UnInitialized r2 = androidx.datastore.core.UnInitialized.INSTANCE
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r2)
            if (r14 != 0) goto L_0x0099
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r14 = r13.downstreamFlow
            java.lang.Object r14 = r14.getValue()
            boolean r14 = r14 instanceof androidx.datastore.core.ReadException
            if (r14 == 0) goto L_0x0097
            goto L_0x0099
        L_0x0097:
            r14 = r5
            goto L_0x009a
        L_0x0099:
            r14 = r6
        L_0x009a:
            if (r14 == 0) goto L_0x013a
            kotlinx.coroutines.sync.Mutex r9 = kotlinx.coroutines.sync.MutexKt.Mutex$default(r5, r6, r7)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            r0.f35650h = r13
            r0.f35651i = r9
            r0.f35652j = r2
            r0.f35653k = r2
            r0.f35658p = r6
            java.lang.Object r14 = r13.readDataOrHandleCorruption(r0)
            if (r14 != r1) goto L_0x00b6
            return r1
        L_0x00b6:
            r10 = r13
            r8 = r2
        L_0x00b8:
            r2.element = r14
            kotlin.jvm.internal.Ref$BooleanRef r14 = new kotlin.jvm.internal.Ref$BooleanRef
            r14.<init>()
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1 r2 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1
            r2.<init>(r9, r14, r8, r10)
            java.util.List<? extends kotlin.jvm.functions.Function2<? super androidx.datastore.core.InitializerApi<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>> r11 = r10.initTasks
            if (r11 != 0) goto L_0x00ce
            r2 = r1
            r1 = r9
            r9 = r14
            r14 = r0
            r0 = r10
            goto L_0x0100
        L_0x00ce:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
            r12 = r10
            r10 = r8
            r8 = r2
            r2 = r11
            r11 = r9
            r9 = r14
        L_0x00da:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x00fb
            java.lang.Object r14 = r2.next()
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r0.f35650h = r12
            r0.f35651i = r11
            r0.f35652j = r10
            r0.f35653k = r9
            r0.f35654l = r8
            r0.f35655m = r2
            r0.f35658p = r4
            java.lang.Object r14 = r14.invoke(r8, r0)
            if (r14 != r1) goto L_0x00da
            return r1
        L_0x00fb:
            r14 = r0
            r2 = r1
            r8 = r10
            r1 = r11
            r0 = r12
        L_0x0100:
            r0.initTasks = r7
            r14.f35650h = r0
            r14.f35651i = r8
            r14.f35652j = r9
            r14.f35653k = r1
            r14.f35654l = r7
            r14.f35655m = r7
            r14.f35658p = r3
            java.lang.Object r14 = r1.lock(r7, r14)
            if (r14 != r2) goto L_0x0117
            return r2
        L_0x0117:
            r3 = r8
            r2 = r9
        L_0x0119:
            r2.element = r6     // Catch:{ all -> 0x0135 }
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0135 }
            r1.unlock(r7)
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r14 = r0.downstreamFlow
            androidx.datastore.core.Data r0 = new androidx.datastore.core.Data
            T r1 = r3.element
            if (r1 == 0) goto L_0x012c
            int r5 = r1.hashCode()
        L_0x012c:
            r0.<init>(r1, r5)
            r14.setValue(r0)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0135:
            r14 = move-exception
            r1.unlock(r7)
            throw r14
        L_0x013a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readAndInit(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAndInitOrPropagateAndThrowFailure(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.f35674k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35674k = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f35672i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f35674k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f35671h
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0045
        L_0x002d:
            r5 = move-exception
            goto L_0x004a
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.f35671h = r4     // Catch:{ all -> 0x0048 }
            r0.f35674k = r3     // Catch:{ all -> 0x0048 }
            java.lang.Object r5 = r4.readAndInit(r0)     // Catch:{ all -> 0x0048 }
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0048:
            r5 = move-exception
            r0 = r4
        L_0x004a:
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r0 = r0.downstreamFlow
            androidx.datastore.core.ReadException r1 = new androidx.datastore.core.ReadException
            r1.<init>(r5)
            r0.setValue(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readAndInitOrPropagateAndThrowFailure(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAndInitOrPropagateFailure(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1) r0
            int r1 = r0.f35678k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35678k = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f35676i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f35678k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f35675h
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0051
        L_0x002d:
            r5 = move-exception
            goto L_0x0047
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.f35675h = r4     // Catch:{ all -> 0x0045 }
            r0.f35678k = r3     // Catch:{ all -> 0x0045 }
            java.lang.Object r5 = r4.readAndInit(r0)     // Catch:{ all -> 0x0045 }
            if (r5 != r1) goto L_0x0051
            return r1
        L_0x0045:
            r5 = move-exception
            r0 = r4
        L_0x0047:
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r0 = r0.downstreamFlow
            androidx.datastore.core.ReadException r1 = new androidx.datastore.core.ReadException
            r1.<init>(r5)
            r0.setValue(r1)
        L_0x0051:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readAndInitOrPropagateFailure(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0068, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006c, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007f, code lost:
        return r0.serializer.getDefaultValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0080, code lost:
        throw r6;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x005f, B:29:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readData(kotlin.coroutines.Continuation<? super T> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$readData$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readData$1) r0
            int r1 = r0.f35684m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35684m = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readData$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f35682k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f35684m
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r1 = r0.f35681j
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.Object r2 = r0.f35680i
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Object r0 = r0.f35679h
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0035 }
            goto L_0x005f
        L_0x0035:
            r6 = move-exception
            goto L_0x0067
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r6)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x006d }
            java.io.File r6 = r5.getFile()     // Catch:{ FileNotFoundException -> 0x006d }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x006d }
            androidx.datastore.core.Serializer<T> r6 = r5.serializer     // Catch:{ all -> 0x0065 }
            r0.f35679h = r5     // Catch:{ all -> 0x0065 }
            r0.f35680i = r2     // Catch:{ all -> 0x0065 }
            r4 = 0
            r0.f35681j = r4     // Catch:{ all -> 0x0065 }
            r0.f35684m = r3     // Catch:{ all -> 0x0065 }
            java.lang.Object r6 = r6.readFrom(r2, r0)     // Catch:{ all -> 0x0065 }
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r0 = r5
            r1 = r4
        L_0x005f:
            kotlin.io.CloseableKt.closeFinally(r2, r1)     // Catch:{ FileNotFoundException -> 0x0063 }
            return r6
        L_0x0063:
            r6 = move-exception
            goto L_0x006f
        L_0x0065:
            r6 = move-exception
            r0 = r5
        L_0x0067:
            throw r6     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r6)     // Catch:{ FileNotFoundException -> 0x0063 }
            throw r1     // Catch:{ FileNotFoundException -> 0x0063 }
        L_0x006d:
            r6 = move-exception
            r0 = r5
        L_0x006f:
            java.io.File r1 = r0.getFile()
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x0080
            androidx.datastore.core.Serializer<T> r6 = r0.serializer
            java.lang.Object r6 = r6.getDefaultValue()
            return r6
        L_0x0080:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0085 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readDataOrHandleCorruption(kotlin.coroutines.Continuation<? super T> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1) r0
            int r1 = r0.f35689l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35689l = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f35687j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f35689l
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r5) goto L_0x004b
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r1 = r0.f35686i
            java.lang.Object r0 = r0.f35685h
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ IOException -> 0x0035 }
            goto L_0x0087
        L_0x0035:
            r8 = move-exception
            goto L_0x008a
        L_0x0037:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003f:
            java.lang.Object r2 = r0.f35686i
            androidx.datastore.core.CorruptionException r2 = (androidx.datastore.core.CorruptionException) r2
            java.lang.Object r4 = r0.f35685h
            androidx.datastore.core.SingleProcessDataStore r4 = (androidx.datastore.core.SingleProcessDataStore) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0079
        L_0x004b:
            java.lang.Object r2 = r0.f35685h
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ CorruptionException -> 0x0053 }
            goto L_0x0063
        L_0x0053:
            r8 = move-exception
            goto L_0x0066
        L_0x0055:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.f35685h = r7     // Catch:{ CorruptionException -> 0x0064 }
            r0.f35689l = r5     // Catch:{ CorruptionException -> 0x0064 }
            java.lang.Object r8 = r7.readData(r0)     // Catch:{ CorruptionException -> 0x0064 }
            if (r8 != r1) goto L_0x0063
            return r1
        L_0x0063:
            return r8
        L_0x0064:
            r8 = move-exception
            r2 = r7
        L_0x0066:
            androidx.datastore.core.CorruptionHandler<T> r5 = r2.corruptionHandler
            r0.f35685h = r2
            r0.f35686i = r8
            r0.f35689l = r4
            java.lang.Object r4 = r5.handleCorruption(r8, r0)
            if (r4 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r6 = r2
            r2 = r8
            r8 = r4
            r4 = r6
        L_0x0079:
            r0.f35685h = r2     // Catch:{ IOException -> 0x0088 }
            r0.f35686i = r8     // Catch:{ IOException -> 0x0088 }
            r0.f35689l = r3     // Catch:{ IOException -> 0x0088 }
            java.lang.Object r0 = r4.writeData$datastore_core(r8, r0)     // Catch:{ IOException -> 0x0088 }
            if (r0 != r1) goto L_0x0086
            return r1
        L_0x0086:
            r1 = r8
        L_0x0087:
            return r1
        L_0x0088:
            r8 = move-exception
            r0 = r2
        L_0x008a:
            kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(r0, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readDataOrHandleCorruption(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object transformAndWrite(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r8, kotlin.coroutines.CoroutineContext r9, kotlin.coroutines.Continuation<? super T> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = (androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1) r0
            int r1 = r0.f35695m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35695m = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            r0.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f35693k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f35695m
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r5) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            java.lang.Object r8 = r0.f35691i
            java.lang.Object r9 = r0.f35690h
            androidx.datastore.core.SingleProcessDataStore r9 = (androidx.datastore.core.SingleProcessDataStore) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x008e
        L_0x0033:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003b:
            java.lang.Object r8 = r0.f35692j
            java.lang.Object r9 = r0.f35691i
            androidx.datastore.core.Data r9 = (androidx.datastore.core.Data) r9
            java.lang.Object r2 = r0.f35690h
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0073
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r10 = r7.downstreamFlow
            java.lang.Object r10 = r10.getValue()
            androidx.datastore.core.Data r10 = (androidx.datastore.core.Data) r10
            r10.checkHashCode()
            java.lang.Object r2 = r10.getValue()
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1 r6 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1
            r6.<init>(r8, r2, r3)
            r0.f35690h = r7
            r0.f35691i = r10
            r0.f35692j = r2
            r0.f35695m = r5
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r9, r6, r0)
            if (r8 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r9 = r10
            r10 = r8
            r8 = r2
            r2 = r7
        L_0x0073:
            r9.checkHashCode()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x007d
            goto L_0x00a0
        L_0x007d:
            r0.f35690h = r2
            r0.f35691i = r10
            r0.f35692j = r3
            r0.f35695m = r4
            java.lang.Object r8 = r2.writeData$datastore_core(r10, r0)
            if (r8 != r1) goto L_0x008c
            return r1
        L_0x008c:
            r8 = r10
            r9 = r2
        L_0x008e:
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r9 = r9.downstreamFlow
            androidx.datastore.core.Data r10 = new androidx.datastore.core.Data
            if (r8 == 0) goto L_0x0099
            int r0 = r8.hashCode()
            goto L_0x009a
        L_0x0099:
            r0 = 0
        L_0x009a:
            r10.<init>(r8, r0)
            r9.setValue(r10)
        L_0x00a0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.transformAndWrite(kotlin.jvm.functions.Function2, kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public Flow<T> getData() {
        return this.data;
    }

    @Nullable
    public Object updateData(@NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        this.actor.offer(new Message.Update(function2, CompletableDeferred$default, this.downstreamFlow.getValue(), continuation.getContext()));
        return CompletableDeferred$default.await(continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c1, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c5, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c6, code lost:
        r8 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c7, code lost:
        r9 = r3;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:25:0x0092, B:35:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a2 A[SYNTHETIC, Splitter:B:30:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeData$datastore_core(T r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.SingleProcessDataStore$writeData$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$writeData$1) r0
            int r1 = r0.f35706o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35706o = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$writeData$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f35704m
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f35706o
            r3 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r8 = r0.f35703l
            java.io.FileOutputStream r8 = (java.io.FileOutputStream) r8
            java.lang.Object r1 = r0.f35702k
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.Object r2 = r0.f35701j
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Object r3 = r0.f35700i
            java.io.File r3 = (java.io.File) r3
            java.lang.Object r0 = r0.f35699h
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x003d }
            goto L_0x0089
        L_0x003d:
            r8 = move-exception
            goto L_0x00c0
        L_0x0040:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r9)
            java.io.File r9 = r7.getFile()
            r7.createParentDirectories(r9)
            java.io.File r9 = new java.io.File
            java.io.File r2 = r7.getFile()
            java.lang.String r2 = r2.getAbsolutePath()
            java.lang.String r4 = r7.SCRATCH_SUFFIX
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r4)
            r9.<init>(r2)
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c9 }
            r2.<init>(r9)     // Catch:{ IOException -> 0x00c9 }
            androidx.datastore.core.Serializer<T> r4 = r7.serializer     // Catch:{ all -> 0x00be }
            androidx.datastore.core.SingleProcessDataStore$UncloseableOutputStream r5 = new androidx.datastore.core.SingleProcessDataStore$UncloseableOutputStream     // Catch:{ all -> 0x00be }
            r5.<init>(r2)     // Catch:{ all -> 0x00be }
            r0.f35699h = r7     // Catch:{ all -> 0x00be }
            r0.f35700i = r9     // Catch:{ all -> 0x00be }
            r0.f35701j = r2     // Catch:{ all -> 0x00be }
            r6 = 0
            r0.f35702k = r6     // Catch:{ all -> 0x00be }
            r0.f35703l = r2     // Catch:{ all -> 0x00be }
            r0.f35706o = r3     // Catch:{ all -> 0x00be }
            java.lang.Object r8 = r4.writeTo(r8, r5, r0)     // Catch:{ all -> 0x00be }
            if (r8 != r1) goto L_0x0085
            return r1
        L_0x0085:
            r0 = r7
            r3 = r9
            r8 = r2
            r1 = r6
        L_0x0089:
            java.io.FileDescriptor r8 = r8.getFD()     // Catch:{ all -> 0x003d }
            r8.sync()     // Catch:{ all -> 0x003d }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003d }
            kotlin.io.CloseableKt.closeFinally(r2, r1)     // Catch:{ IOException -> 0x00c6 }
            java.io.File r8 = r0.getFile()     // Catch:{ IOException -> 0x00c6 }
            boolean r8 = r3.renameTo(r8)     // Catch:{ IOException -> 0x00c6 }
            if (r8 == 0) goto L_0x00a2
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00a2:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ IOException -> 0x00c6 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c6 }
            r9.<init>()     // Catch:{ IOException -> 0x00c6 }
            java.lang.String r0 = "Unable to rename "
            r9.append(r0)     // Catch:{ IOException -> 0x00c6 }
            r9.append(r3)     // Catch:{ IOException -> 0x00c6 }
            java.lang.String r0 = ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            r9.append(r0)     // Catch:{ IOException -> 0x00c6 }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x00c6 }
            r8.<init>(r9)     // Catch:{ IOException -> 0x00c6 }
            throw r8     // Catch:{ IOException -> 0x00c6 }
        L_0x00be:
            r8 = move-exception
            r3 = r9
        L_0x00c0:
            throw r8     // Catch:{ all -> 0x00c1 }
        L_0x00c1:
            r9 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r8)     // Catch:{ IOException -> 0x00c6 }
            throw r9     // Catch:{ IOException -> 0x00c6 }
        L_0x00c6:
            r8 = move-exception
            r9 = r3
            goto L_0x00ca
        L_0x00c9:
            r8 = move-exception
        L_0x00ca:
            boolean r0 = r9.exists()
            if (r0 == 0) goto L_0x00d3
            r9.delete()
        L_0x00d3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.writeData$datastore_core(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SingleProcessDataStore(Function0 function0, Serializer serializer2, List list, CorruptionHandler corruptionHandler2, CoroutineScope coroutineScope, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, serializer2, (i11 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i11 & 8) != 0 ? new NoOpCorruptionHandler() : corruptionHandler2, (i11 & 16) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))) : coroutineScope);
    }
}
