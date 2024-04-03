package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.util.TraceSection;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import uz.a;

class DartMessenger implements BinaryMessenger, PlatformMessageHandler {
    private static final String TAG = "DartMessenger";
    @NonNull
    private Map<String, List<BufferedMessageInfo>> bufferedMessages;
    @NonNull
    private WeakHashMap<BinaryMessenger.TaskQueue, DartMessengerTaskQueue> createdTaskQueues;
    @NonNull
    private final AtomicBoolean enableBufferingIncomingMessages;
    @NonNull
    private final FlutterJNI flutterJNI;
    @NonNull
    private final Object handlersLock;
    @NonNull
    private final Map<String, HandlerInfo> messageHandlers;
    private int nextReplyId;
    @NonNull
    private final Map<Integer, BinaryMessenger.BinaryReply> pendingReplies;
    @NonNull
    private final DartMessengerTaskQueue platformTaskQueue;
    @NonNull
    private TaskQueueFactory taskQueueFactory;

    public static class BufferedMessageInfo {

        /* renamed from: a  reason: collision with root package name */
        public int f14174a;

        /* renamed from: b  reason: collision with root package name */
        public long f14175b;
        @NonNull
        public final ByteBuffer message;

        public BufferedMessageInfo(@NonNull ByteBuffer byteBuffer, int i11, long j11) {
            this.message = byteBuffer;
            this.f14174a = i11;
            this.f14175b = j11;
        }
    }

    public static class ConcurrentTaskQueue implements DartMessengerTaskQueue {
        @NonNull
        private final ExecutorService executor;

        public ConcurrentTaskQueue(ExecutorService executorService) {
            this.executor = executorService;
        }

        public void dispatch(@NonNull Runnable runnable) {
            this.executor.execute(runnable);
        }
    }

    public interface DartMessengerTaskQueue {
        void dispatch(@NonNull Runnable runnable);
    }

    public static class DefaultTaskQueueFactory implements TaskQueueFactory {

        /* renamed from: a  reason: collision with root package name */
        public ExecutorService f14176a = FlutterInjector.instance().executorService();

        public DartMessengerTaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
            if (taskQueueOptions.getIsSerial()) {
                return new SerialTaskQueue(this.f14176a);
            }
            return new ConcurrentTaskQueue(this.f14176a);
        }
    }

    public static class HandlerInfo {
        @NonNull
        public final BinaryMessenger.BinaryMessageHandler handler;
        @Nullable
        public final DartMessengerTaskQueue taskQueue;

        public HandlerInfo(@NonNull BinaryMessenger.BinaryMessageHandler binaryMessageHandler, @Nullable DartMessengerTaskQueue dartMessengerTaskQueue) {
            this.handler = binaryMessageHandler;
            this.taskQueue = dartMessengerTaskQueue;
        }
    }

    public static class Reply implements BinaryMessenger.BinaryReply {
        private final AtomicBoolean done = new AtomicBoolean(false);
        @NonNull
        private final FlutterJNI flutterJNI;
        private final int replyId;

        public Reply(@NonNull FlutterJNI flutterJNI2, int i11) {
            this.flutterJNI = flutterJNI2;
            this.replyId = i11;
        }

        public void reply(@Nullable ByteBuffer byteBuffer) {
            if (this.done.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            } else if (byteBuffer == null) {
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(this.replyId);
            } else {
                this.flutterJNI.invokePlatformMessageResponseCallback(this.replyId, byteBuffer, byteBuffer.position());
            }
        }
    }

    public static class SerialTaskQueue implements DartMessengerTaskQueue {
        @NonNull
        private final ExecutorService executor;
        @NonNull
        private final AtomicBoolean isRunning = new AtomicBoolean(false);
        @NonNull
        private final ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();

        public SerialTaskQueue(ExecutorService executorService) {
            this.executor = executorService;
        }

        /* access modifiers changed from: private */
        /* renamed from: flush */
        public void lambda$flush$1() {
            if (this.isRunning.compareAndSet(false, true)) {
                try {
                    Runnable poll = this.queue.poll();
                    if (poll != null) {
                        poll.run();
                    }
                } finally {
                    this.isRunning.set(false);
                    if (!this.queue.isEmpty()) {
                        this.executor.execute(new b(this));
                    }
                }
            }
        }

        public void dispatch(@NonNull Runnable runnable) {
            this.queue.add(runnable);
            this.executor.execute(new c(this));
        }
    }

    public interface TaskQueueFactory {
        DartMessengerTaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions);
    }

    public static class TaskQueueToken implements BinaryMessenger.TaskQueue {
        private TaskQueueToken() {
        }
    }

    public DartMessenger(@NonNull FlutterJNI flutterJNI2, @NonNull TaskQueueFactory taskQueueFactory2) {
        this.messageHandlers = new HashMap();
        this.bufferedMessages = new HashMap();
        this.handlersLock = new Object();
        this.enableBufferingIncomingMessages = new AtomicBoolean(false);
        this.pendingReplies = new HashMap();
        this.nextReplyId = 1;
        this.platformTaskQueue = new PlatformTaskQueue();
        this.createdTaskQueues = new WeakHashMap<>();
        this.flutterJNI = flutterJNI2;
        this.taskQueueFactory = taskQueueFactory2;
    }

    private void dispatchMessageToQueue(@NonNull String str, @Nullable HandlerInfo handlerInfo, @Nullable ByteBuffer byteBuffer, int i11, long j11) {
        DartMessengerTaskQueue dartMessengerTaskQueue;
        HandlerInfo handlerInfo2 = handlerInfo;
        if (handlerInfo2 != null) {
            dartMessengerTaskQueue = handlerInfo2.taskQueue;
        } else {
            dartMessengerTaskQueue = null;
        }
        DartMessengerTaskQueue dartMessengerTaskQueue2 = dartMessengerTaskQueue;
        TraceSection.beginAsyncSection("PlatformChannel ScheduleHandler on " + str, i11);
        a aVar = new a(this, str, i11, handlerInfo, byteBuffer, j11);
        if (dartMessengerTaskQueue2 == null) {
            dartMessengerTaskQueue2 = this.platformTaskQueue;
        }
        dartMessengerTaskQueue2.dispatch(aVar);
    }

    private static void handleError(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() != null) {
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
            return;
        }
        throw error;
    }

    private void invokeHandler(@Nullable HandlerInfo handlerInfo, @Nullable ByteBuffer byteBuffer, int i11) {
        if (handlerInfo != null) {
            try {
                Log.v(TAG, "Deferring to registered handler to process message.");
                handlerInfo.handler.onMessage(byteBuffer, new Reply(this.flutterJNI, i11));
            } catch (Exception e11) {
                Log.e(TAG, "Uncaught exception in binary message listener", e11);
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i11);
            } catch (Error e12) {
                handleError(e12);
            }
        } else {
            Log.v(TAG, "No registered handler for message. Responding to Dart with empty reply message.");
            this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatchMessageToQueue$0(String str, int i11, HandlerInfo handlerInfo, ByteBuffer byteBuffer, long j11) {
        TraceSection.endAsyncSection("PlatformChannel ScheduleHandler on " + str, i11);
        TraceSection.begin("DartMessenger#handleMessageFromDart on " + str);
        try {
            invokeHandler(handlerInfo, byteBuffer, i11);
            if (byteBuffer != null && byteBuffer.isDirect()) {
                byteBuffer.limit(0);
            }
        } finally {
            this.flutterJNI.cleanupMessageData(j11);
            TraceSection.end();
        }
    }

    public void disableBufferingIncomingMessages() {
        Map<String, List<BufferedMessageInfo>> map;
        synchronized (this.handlersLock) {
            this.enableBufferingIncomingMessages.set(false);
            map = this.bufferedMessages;
            this.bufferedMessages = new HashMap();
        }
        for (Map.Entry next : map.entrySet()) {
            for (BufferedMessageInfo bufferedMessageInfo : (List) next.getValue()) {
                dispatchMessageToQueue((String) next.getKey(), (HandlerInfo) null, bufferedMessageInfo.message, bufferedMessageInfo.f14174a, bufferedMessageInfo.f14175b);
            }
        }
    }

    public void enableBufferingIncomingMessages() {
        this.enableBufferingIncomingMessages.set(true);
    }

    @UiThread
    public int getPendingChannelResponseCount() {
        return this.pendingReplies.size();
    }

    public void handleMessageFromDart(@NonNull String str, @Nullable ByteBuffer byteBuffer, int i11, long j11) {
        HandlerInfo handlerInfo;
        boolean z11;
        Log.v(TAG, "Received message from Dart over channel '" + str + "'");
        synchronized (this.handlersLock) {
            handlerInfo = this.messageHandlers.get(str);
            if (!this.enableBufferingIncomingMessages.get() || handlerInfo != null) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                if (!this.bufferedMessages.containsKey(str)) {
                    this.bufferedMessages.put(str, new LinkedList());
                }
                this.bufferedMessages.get(str).add(new BufferedMessageInfo(byteBuffer, i11, j11));
            }
        }
        if (!z11) {
            dispatchMessageToQueue(str, handlerInfo, byteBuffer, i11, j11);
        }
    }

    public void handlePlatformMessageResponse(int i11, @Nullable ByteBuffer byteBuffer) {
        Log.v(TAG, "Received message reply from Dart.");
        BinaryMessenger.BinaryReply remove = this.pendingReplies.remove(Integer.valueOf(i11));
        if (remove != null) {
            try {
                Log.v(TAG, "Invoking registered callback for reply from Dart.");
                remove.reply(byteBuffer);
                if (byteBuffer != null && byteBuffer.isDirect()) {
                    byteBuffer.limit(0);
                }
            } catch (Exception e11) {
                Log.e(TAG, "Uncaught exception in binary message reply handler", e11);
            } catch (Error e12) {
                handleError(e12);
            }
        }
    }

    public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        return a.c(this);
    }

    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        DartMessengerTaskQueue makeBackgroundTaskQueue = this.taskQueueFactory.makeBackgroundTaskQueue(taskQueueOptions);
        TaskQueueToken taskQueueToken = new TaskQueueToken();
        this.createdTaskQueues.put(taskQueueToken, makeBackgroundTaskQueue);
        return taskQueueToken;
    }

    @UiThread
    public void send(@NonNull String str, @NonNull ByteBuffer byteBuffer) {
        Log.v(TAG, "Sending message over channel '" + str + "'");
        send(str, byteBuffer, (BinaryMessenger.BinaryReply) null);
    }

    public void setMessageHandler(@NonNull String str, @Nullable BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        setMessageHandler(str, binaryMessageHandler, (BinaryMessenger.TaskQueue) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0075, code lost:
        r10 = r10.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        if (r10.hasNext() == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
        r11 = (io.flutter.embedding.engine.dart.DartMessenger.BufferedMessageInfo) r10.next();
        dispatchMessageToQueue(r9, r8.messageHandlers.get(r9), r11.message, r11.f14174a, r11.f14175b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setMessageHandler(@androidx.annotation.NonNull java.lang.String r9, @androidx.annotation.Nullable io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler r10, @androidx.annotation.Nullable io.flutter.plugin.common.BinaryMessenger.TaskQueue r11) {
        /*
            r8 = this;
            if (r10 != 0) goto L_0x002a
            java.lang.String r10 = "DartMessenger"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Removing handler for channel '"
            r11.append(r0)
            r11.append(r9)
            java.lang.String r0 = "'"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            io.flutter.Log.v(r10, r11)
            java.lang.Object r0 = r8.handlersLock
            monitor-enter(r0)
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r10 = r8.messageHandlers     // Catch:{ all -> 0x0027 }
            r10.remove(r9)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r9
        L_0x002a:
            if (r11 == 0) goto L_0x003f
            java.util.WeakHashMap<io.flutter.plugin.common.BinaryMessenger$TaskQueue, io.flutter.embedding.engine.dart.DartMessenger$DartMessengerTaskQueue> r0 = r8.createdTaskQueues
            java.lang.Object r11 = r0.get(r11)
            io.flutter.embedding.engine.dart.DartMessenger$DartMessengerTaskQueue r11 = (io.flutter.embedding.engine.dart.DartMessenger.DartMessengerTaskQueue) r11
            if (r11 == 0) goto L_0x0037
            goto L_0x0040
        L_0x0037:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue)."
            r9.<init>(r10)
            throw r9
        L_0x003f:
            r11 = 0
        L_0x0040:
            java.lang.String r0 = "DartMessenger"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Setting handler for channel '"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = "'"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            io.flutter.Log.v(r0, r1)
            java.lang.Object r0 = r8.handlersLock
            monitor-enter(r0)
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r1 = r8.messageHandlers     // Catch:{ all -> 0x009b }
            io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo r2 = new io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo     // Catch:{ all -> 0x009b }
            r2.<init>(r10, r11)     // Catch:{ all -> 0x009b }
            r1.put(r9, r2)     // Catch:{ all -> 0x009b }
            java.util.Map<java.lang.String, java.util.List<io.flutter.embedding.engine.dart.DartMessenger$BufferedMessageInfo>> r10 = r8.bufferedMessages     // Catch:{ all -> 0x009b }
            java.lang.Object r10 = r10.remove(r9)     // Catch:{ all -> 0x009b }
            java.util.List r10 = (java.util.List) r10     // Catch:{ all -> 0x009b }
            if (r10 != 0) goto L_0x0074
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            return
        L_0x0074:
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            java.util.Iterator r10 = r10.iterator()
        L_0x0079:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x009a
            java.lang.Object r11 = r10.next()
            io.flutter.embedding.engine.dart.DartMessenger$BufferedMessageInfo r11 = (io.flutter.embedding.engine.dart.DartMessenger.BufferedMessageInfo) r11
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r0 = r8.messageHandlers
            java.lang.Object r0 = r0.get(r9)
            r3 = r0
            io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo r3 = (io.flutter.embedding.engine.dart.DartMessenger.HandlerInfo) r3
            java.nio.ByteBuffer r4 = r11.message
            int r5 = r11.f14174a
            long r6 = r11.f14175b
            r1 = r8
            r2 = r9
            r1.dispatchMessageToQueue(r2, r3, r4, r5, r6)
            goto L_0x0079
        L_0x009a:
            return
        L_0x009b:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.dart.DartMessenger.setMessageHandler(java.lang.String, io.flutter.plugin.common.BinaryMessenger$BinaryMessageHandler, io.flutter.plugin.common.BinaryMessenger$TaskQueue):void");
    }

    public void send(@NonNull String str, @Nullable ByteBuffer byteBuffer, @Nullable BinaryMessenger.BinaryReply binaryReply) {
        TraceSection.begin("DartMessenger#send on " + str);
        try {
            Log.v(TAG, "Sending message with callback over channel '" + str + "'");
            int i11 = this.nextReplyId;
            this.nextReplyId = i11 + 1;
            if (binaryReply != null) {
                this.pendingReplies.put(Integer.valueOf(i11), binaryReply);
            }
            if (byteBuffer == null) {
                this.flutterJNI.dispatchEmptyPlatformMessage(str, i11);
            } else {
                this.flutterJNI.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i11);
            }
        } finally {
            TraceSection.end();
        }
    }

    public DartMessenger(@NonNull FlutterJNI flutterJNI2) {
        this(flutterJNI2, new DefaultTaskQueueFactory());
    }
}
