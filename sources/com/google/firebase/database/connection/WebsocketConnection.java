package com.google.firebase.database.connection;

import com.google.firebase.database.connection.util.StringListReader;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.tubesock.WebSocket;
import com.google.firebase.database.tubesock.WebSocketEventHandler;
import com.google.firebase.database.tubesock.WebSocketException;
import com.google.firebase.database.tubesock.WebSocketMessage;
import com.google.firebase.database.util.JsonMapper;
import java.io.EOFException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class WebsocketConnection {
    private static final long CONNECT_TIMEOUT_MS = 30000;
    private static final long KEEP_ALIVE_TIMEOUT_MS = 45000;
    private static final int MAX_FRAME_SIZE = 16384;
    private static long connectionId;
    /* access modifiers changed from: private */
    public WSClient conn;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> connectTimeout;
    private final ConnectionContext connectionContext;
    private Delegate delegate;
    /* access modifiers changed from: private */
    public boolean everConnected = false;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService executorService;
    private StringListReader frameReader;
    private boolean isClosed = false;
    private ScheduledFuture<?> keepAlive;
    /* access modifiers changed from: private */
    public final LogWrapper logger;
    private long totalFrames = 0;

    public interface Delegate {
        void onDisconnect(boolean z11);

        void onMessage(Map<String, Object> map);
    }

    public interface WSClient {
        void close();

        void connect();

        void send(String str);
    }

    public class WSClientTubesock implements WSClient, WebSocketEventHandler {

        /* renamed from: ws  reason: collision with root package name */
        private WebSocket f47395ws;

        private void shutdown() {
            this.f47395ws.close();
            try {
                this.f47395ws.blockClose();
            } catch (InterruptedException e11) {
                WebsocketConnection.this.logger.error("Interrupted while shutting down websocket threads", e11);
            }
        }

        public void close() {
            this.f47395ws.close();
        }

        public void connect() {
            try {
                this.f47395ws.connect();
            } catch (WebSocketException e11) {
                if (WebsocketConnection.this.logger.logsDebug()) {
                    WebsocketConnection.this.logger.debug("Error connecting", e11, new Object[0]);
                }
                shutdown();
            }
        }

        public void onClose() {
            WebsocketConnection.this.executorService.execute(new Runnable() {
                public void run() {
                    if (WebsocketConnection.this.logger.logsDebug()) {
                        WebsocketConnection.this.logger.debug("closed", new Object[0]);
                    }
                    WebsocketConnection.this.onClosed();
                }
            });
        }

        public void onError(final WebSocketException webSocketException) {
            WebsocketConnection.this.executorService.execute(new Runnable() {
                public void run() {
                    if (webSocketException.getCause() == null || !(webSocketException.getCause() instanceof EOFException)) {
                        WebsocketConnection.this.logger.debug("WebSocket error.", webSocketException, new Object[0]);
                    } else {
                        WebsocketConnection.this.logger.debug("WebSocket reached EOF.", new Object[0]);
                    }
                    WebsocketConnection.this.onClosed();
                }
            });
        }

        public void onLogMessage(String str) {
            if (WebsocketConnection.this.logger.logsDebug()) {
                LogWrapper access$200 = WebsocketConnection.this.logger;
                access$200.debug("Tubesock: " + str, new Object[0]);
            }
        }

        public void onMessage(WebSocketMessage webSocketMessage) {
            final String text = webSocketMessage.getText();
            if (WebsocketConnection.this.logger.logsDebug()) {
                LogWrapper access$200 = WebsocketConnection.this.logger;
                access$200.debug("ws message: " + text, new Object[0]);
            }
            WebsocketConnection.this.executorService.execute(new Runnable() {
                public void run() {
                    WebsocketConnection.this.handleIncomingFrame(text);
                }
            });
        }

        public void onOpen() {
            WebsocketConnection.this.executorService.execute(new Runnable() {
                public void run() {
                    WebsocketConnection.this.connectTimeout.cancel(false);
                    boolean unused = WebsocketConnection.this.everConnected = true;
                    if (WebsocketConnection.this.logger.logsDebug()) {
                        WebsocketConnection.this.logger.debug("websocket opened", new Object[0]);
                    }
                    WebsocketConnection.this.resetKeepAlive();
                }
            });
        }

        public void send(String str) {
            this.f47395ws.send(str);
        }

        private WSClientTubesock(WebSocket webSocket) {
            this.f47395ws = webSocket;
            webSocket.setEventHandler(this);
        }
    }

    public WebsocketConnection(ConnectionContext connectionContext2, HostInfo hostInfo, String str, String str2, Delegate delegate2, String str3) {
        this.connectionContext = connectionContext2;
        this.executorService = connectionContext2.getExecutorService();
        this.delegate = delegate2;
        long j11 = connectionId;
        connectionId = 1 + j11;
        Logger logger2 = connectionContext2.getLogger();
        this.logger = new LogWrapper(logger2, "WebSocket", "ws_" + j11);
        this.conn = createConnection(hostInfo, str, str2, str3);
    }

    private void appendFrame(String str) {
        this.frameReader.addString(str);
        long j11 = this.totalFrames - 1;
        this.totalFrames = j11;
        if (j11 == 0) {
            try {
                this.frameReader.freeze();
                Map<String, Object> parseJson = JsonMapper.parseJson(this.frameReader.toString());
                this.frameReader = null;
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper = this.logger;
                    logWrapper.debug("handleIncomingFrame complete frame: " + parseJson, new Object[0]);
                }
                this.delegate.onMessage(parseJson);
            } catch (IOException e11) {
                LogWrapper logWrapper2 = this.logger;
                logWrapper2.error("Error parsing frame: " + this.frameReader.toString(), e11);
                close();
                shutdown();
            } catch (ClassCastException e12) {
                LogWrapper logWrapper3 = this.logger;
                logWrapper3.error("Error parsing frame (cast error): " + this.frameReader.toString(), e12);
                close();
                shutdown();
            }
        }
    }

    /* access modifiers changed from: private */
    public void closeIfNeverConnected() {
        if (!this.everConnected && !this.isClosed) {
            if (this.logger.logsDebug()) {
                this.logger.debug("timed out on connect", new Object[0]);
            }
            this.conn.close();
        }
    }

    private WSClient createConnection(HostInfo hostInfo, String str, String str2, String str3) {
        if (str == null) {
            str = hostInfo.getHost();
        }
        URI connectionUrl = HostInfo.getConnectionUrl(str, hostInfo.isSecure(), hostInfo.getNamespace(), str3);
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", this.connectionContext.getUserAgent());
        hashMap.put("X-Firebase-GMPID", this.connectionContext.getApplicationId());
        hashMap.put("X-Firebase-AppCheck", str2);
        return new WSClientTubesock(new WebSocket(this.connectionContext, connectionUrl, (String) null, hashMap));
    }

    private String extractFrameCount(String str) {
        if (str.length() <= 6) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt <= 0) {
                    return null;
                }
                handleNewFrameCount(parseInt);
                return null;
            } catch (NumberFormatException unused) {
            }
        }
        handleNewFrameCount(1);
        return str;
    }

    /* access modifiers changed from: private */
    public void handleIncomingFrame(String str) {
        if (!this.isClosed) {
            resetKeepAlive();
            if (isBuffering()) {
                appendFrame(str);
                return;
            }
            String extractFrameCount = extractFrameCount(str);
            if (extractFrameCount != null) {
                appendFrame(extractFrameCount);
            }
        }
    }

    private void handleNewFrameCount(int i11) {
        this.totalFrames = (long) i11;
        this.frameReader = new StringListReader();
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("HandleNewFrameCount: " + this.totalFrames, new Object[0]);
        }
    }

    private boolean isBuffering() {
        return this.frameReader != null;
    }

    private Runnable nop() {
        return new Runnable() {
            public void run() {
                if (WebsocketConnection.this.conn != null) {
                    WebsocketConnection.this.conn.send("0");
                    WebsocketConnection.this.resetKeepAlive();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void onClosed() {
        if (!this.isClosed) {
            if (this.logger.logsDebug()) {
                this.logger.debug("closing itself", new Object[0]);
            }
            shutdown();
        }
        this.conn = null;
        ScheduledFuture<?> scheduledFuture = this.keepAlive;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    /* access modifiers changed from: private */
    public void resetKeepAlive() {
        if (!this.isClosed) {
            ScheduledFuture<?> scheduledFuture = this.keepAlive;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper = this.logger;
                    logWrapper.debug("Reset keepAlive. Remaining: " + this.keepAlive.getDelay(TimeUnit.MILLISECONDS), new Object[0]);
                }
            } else if (this.logger.logsDebug()) {
                this.logger.debug("Reset keepAlive", new Object[0]);
            }
            this.keepAlive = this.executorService.schedule(nop(), KEEP_ALIVE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        }
    }

    private void shutdown() {
        this.isClosed = true;
        this.delegate.onDisconnect(this.everConnected);
    }

    private static String[] splitIntoFrames(String str, int i11) {
        int i12 = 0;
        if (str.length() <= i11) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        while (i12 < str.length()) {
            int i13 = i12 + i11;
            arrayList.add(str.substring(i12, Math.min(i13, str.length())));
            i12 = i13;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void close() {
        if (this.logger.logsDebug()) {
            this.logger.debug("websocket is being closed", new Object[0]);
        }
        this.isClosed = true;
        this.conn.close();
        ScheduledFuture<?> scheduledFuture = this.connectTimeout;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture2 = this.keepAlive;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
    }

    public void open() {
        this.conn.connect();
        this.connectTimeout = this.executorService.schedule(new Runnable() {
            public void run() {
                WebsocketConnection.this.closeIfNeverConnected();
            }
        }, 30000, TimeUnit.MILLISECONDS);
    }

    public void send(Map<String, Object> map) {
        resetKeepAlive();
        try {
            String[] splitIntoFrames = splitIntoFrames(JsonMapper.serializeJson(map), 16384);
            if (splitIntoFrames.length > 1) {
                this.conn.send("" + splitIntoFrames.length);
            }
            for (String send : splitIntoFrames) {
                this.conn.send(send);
            }
        } catch (IOException e11) {
            this.logger.error("Failed to serialize message: " + map.toString(), e11);
            shutdown();
        }
    }

    public void start() {
    }
}
