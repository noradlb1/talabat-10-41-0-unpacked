package com.apptimize;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import androidx.webkit.ProxyConfig;
import com.apptimize.bj;
import com.apptimize.gc;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.Future;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import net.bytebuddy.description.type.TypeDescription;
import org.json.HTTP;

public class go implements bj {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f42671b = "go";

    /* renamed from: k  reason: collision with root package name */
    private static TrustManager[] f42672k;

    /* renamed from: a  reason: collision with root package name */
    protected bj.a f42673a;

    /* renamed from: c  reason: collision with root package name */
    private final URI f42674c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Socket f42675d;

    /* renamed from: e  reason: collision with root package name */
    private Future<?> f42676e;

    /* renamed from: f  reason: collision with root package name */
    private final HandlerThread f42677f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f42678g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Pair<String, String>> f42679h;

    /* renamed from: i  reason: collision with root package name */
    private final gc f42680i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Object f42681j = new Object();

    public go(URI uri, bj.a aVar, List<Pair<String, String>> list) {
        this.f42674c = uri;
        this.f42673a = aVar;
        this.f42679h = list;
        this.f42680i = new gc(this);
        HandlerThread handlerThread = new HandlerThread("websocket-thread");
        this.f42677f = handlerThread;
        handlerThread.start();
        this.f42678g = new Handler(handlerThread.getLooper());
    }

    private String f() {
        byte[] bArr = new byte[16];
        for (int i11 = 0; i11 < 16; i11++) {
            bArr[i11] = (byte) ((int) (Math.random() * 256.0d));
        }
        return ew.a(bArr).trim();
    }

    private SSLSocketFactory g() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, f42672k, (SecureRandom) null);
        return instance.getSocketFactory();
    }

    public void c() {
        if (this.f42675d != null) {
            this.f42678g.post(new fi() {
                public void run() {
                    if (go.this.f42675d != null) {
                        try {
                            go.this.f42675d.close();
                            Socket unused = go.this.f42675d = null;
                        } catch (IOException e11) {
                            bo.h(go.f42671b, "Error while disconnecting", e11);
                            go.this.f42673a.a((Exception) e11);
                        } catch (RuntimeException e12) {
                            bo.h(go.f42671b, "Error while disconnecting", e12);
                            go.this.f42673a.a((Exception) e12);
                        }
                    }
                }
            });
        }
    }

    public void d() throws SocketException, EOFException, SSLException, Exception {
        boolean z11;
        int i11;
        String str;
        SocketFactory socketFactory;
        String str2 = "https";
        if (this.f42674c.getScheme().equals("wss") || this.f42674c.getScheme().equals(str2)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.f42674c.getPort() != -1) {
            i11 = this.f42674c.getPort();
        } else if (z11) {
            i11 = 443;
        } else {
            i11 = 80;
        }
        if (TextUtils.isEmpty(this.f42674c.getPath())) {
            str = "/";
        } else {
            str = this.f42674c.getPath();
        }
        if (!TextUtils.isEmpty(this.f42674c.getQuery())) {
            str = str + TypeDescription.Generic.OfWildcardType.SYMBOL + this.f42674c.getQuery();
        }
        if (!z11) {
            str2 = ProxyConfig.MATCH_HTTP;
        }
        URI uri = new URI(str2, "//" + this.f42674c.getHost(), (String) null);
        c.i();
        if (z11) {
            socketFactory = g();
        } else {
            socketFactory = SocketFactory.getDefault();
        }
        this.f42675d = socketFactory.createSocket(this.f42674c.getHost(), i11);
        if (z11) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            SSLSession session = ((SSLSocket) this.f42675d).getSession();
            if (!defaultHostnameVerifier.verify(this.f42674c.getHost(), session)) {
                throw new SSLHandshakeException("Expected " + this.f42674c.getHost() + ", found " + session.getPeerPrincipal());
            }
        }
        PrintWriter printWriter = new PrintWriter(this.f42675d.getOutputStream());
        printWriter.print("GET " + str + " HTTP/1.1\r\n");
        printWriter.print("Upgrade: websocket\r\n");
        printWriter.print("Connection: Upgrade\r\n");
        printWriter.print("Host: " + this.f42674c.getHost() + HTTP.CRLF);
        printWriter.print("Origin: " + uri.toString() + HTTP.CRLF);
        printWriter.print("Sec-WebSocket-Key: " + f() + HTTP.CRLF);
        printWriter.print("Sec-WebSocket-Version: 13\r\n");
        List<Pair<String, String>> list = this.f42679h;
        if (list != null) {
            for (Pair next : list) {
                printWriter.print(String.format("%s: %s\r\n", new Object[]{next.first, next.second}));
            }
        }
        printWriter.print(HTTP.CRLF);
        printWriter.flush();
        gc.a aVar = new gc.a(this.f42675d.getInputStream());
        fs a11 = fs.a(a(aVar));
        if (a11 == null) {
            throw new IOException("Received no reply from server.");
        } else if (a11.f42469a == 101) {
            do {
            } while (!TextUtils.isEmpty(a(aVar)));
            this.f42673a.a();
            this.f42680i.a(aVar);
        } else {
            throw new IOException(a11.f42469a + " " + a11.f42470b);
        }
    }

    public void b() {
        Future<?> future = this.f42676e;
        if (future == null || future.isDone()) {
            this.f42676e = fg.f42429d.submit(new fi() {
                public void run() {
                    try {
                        go.this.d();
                    } catch (ConnectException unused) {
                        go.this.f42673a.a(0, "Closed");
                    } catch (SocketException e11) {
                        bo.h(go.f42671b, "WebSocket exception: ", e11);
                        go.this.f42673a.a(0, "Closed");
                    } catch (EOFException unused2) {
                        bo.k(go.f42671b, "WebSocket EOF");
                        go.this.f42673a.a(0, "EOF");
                    } catch (SSLException e12) {
                        bo.h(go.f42671b, "Websocket SSL error!", e12);
                        go.this.f42673a.a(0, "SSL");
                    } catch (Exception e13) {
                        try {
                            bo.h(go.f42671b, "Websocket exception: ", e13);
                            go.this.f42673a.a(e13);
                        } catch (RuntimeException e14) {
                            bo.l(go.f42671b, "Apptimize experienced and swallowed an error while handling errors", e14);
                        }
                    }
                }
            });
        }
    }

    public bj.a a() {
        return this.f42673a;
    }

    public void a(byte[] bArr) {
        b(this.f42680i.a(bArr));
    }

    public void b(final byte[] bArr) {
        this.f42678g.post(new fi() {
            public void run() {
                try {
                    synchronized (go.this.f42681j) {
                        if (go.this.f42675d != null) {
                            OutputStream outputStream = go.this.f42675d.getOutputStream();
                            outputStream.write(bArr);
                            outputStream.flush();
                        }
                    }
                } catch (IOException e11) {
                    go.this.f42673a.a((Exception) e11);
                } catch (RuntimeException e12) {
                    go.this.f42673a.a((Exception) e12);
                }
            }
        });
    }

    private String a(gc.a aVar) throws IOException {
        int read = aVar.read();
        if (read == -1) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder("");
        while (read != 10) {
            if (read != 13) {
                sb2.append((char) read);
            }
            read = aVar.read();
            if (read == -1) {
                return null;
            }
        }
        return sb2.toString();
    }
}
