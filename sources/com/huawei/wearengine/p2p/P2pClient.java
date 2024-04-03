package com.huawei.wearengine.p2p;

import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.p2p.Message;
import com.huawei.wearengine.p2p.P2pCancelFileTransferCallBack;
import com.huawei.wearengine.p2p.P2pSendCallback;
import com.huawei.wearengine.p2p.ReceiverCallback;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class P2pClient {

    /* renamed from: e  reason: collision with root package name */
    private static volatile P2pClient f44769e;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public P2pServiceProxy f44770a = P2pServiceProxy.getInstance();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f44771b = "";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f44772c = "";

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f44773d = Executors.newSingleThreadExecutor();

    public class a implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Device f44786b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Receiver f44787c;

        public a(Device device, Receiver receiver) {
            this.f44786b = device;
            this.f44787c = receiver;
        }

        public Object call() {
            String packageName = com.huawei.wearengine.utils.b.a().getPackageName();
            String a11 = com.huawei.wearengine.utils.b.a(com.huawei.wearengine.utils.b.a(), packageName);
            com.huawei.wearengine.common.a.a(this.f44786b, (Object) "Device can not be null!");
            com.huawei.wearengine.common.a.a(packageName, (Object) "srcPkgName can not be null!");
            com.huawei.wearengine.common.a.a(a11, (Object) "srcFingerPrint can not be null!");
            com.huawei.wearengine.common.a.a(this.f44787c, (Object) "Receiver can not be null!");
            int d11 = P2pClient.this.a(this.f44786b, this.f44787c, new IdentityInfo(packageName, a11), new IdentityInfo(P2pClient.this.f44771b, P2pClient.this.f44772c));
            if (d11 == 0) {
                return null;
            }
            throw new WearEngineException(d11);
        }
    }

    public class b implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Peer f44789b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Receiver f44790c;

        public b(Peer peer, Receiver receiver) {
            this.f44789b = peer;
            this.f44790c = receiver;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f44789b, (Object) "Peer can not be null!");
            Device device = this.f44789b.getDevice();
            String packageName = com.huawei.wearengine.utils.b.a().getPackageName();
            String a11 = com.huawei.wearengine.utils.b.a(com.huawei.wearengine.utils.b.a(), packageName);
            com.huawei.wearengine.common.a.a(device, (Object) "Device can not be null!");
            com.huawei.wearengine.common.a.a(packageName, (Object) "srcPkgName can not be null!");
            com.huawei.wearengine.common.a.a(a11, (Object) "srcFingerPrint can not be null!");
            com.huawei.wearengine.common.a.a(this.f44790c, (Object) "Receiver can not be null!");
            int d11 = P2pClient.this.a(device, this.f44790c, new IdentityInfo(packageName, a11), new IdentityInfo(this.f44789b.getPkgName(), this.f44789b.getFingerPrint()));
            if (d11 == 0) {
                return null;
            }
            throw new WearEngineException(d11);
        }
    }

    public class c implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Receiver f44792b;

        public c(Receiver receiver) {
            this.f44792b = receiver;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f44792b, (Object) "Receiver can not be null!");
            int identityHashCode = System.identityHashCode(this.f44792b);
            int unregisterReceiver = P2pClient.this.f44770a.unregisterReceiver(new P2pClient$13$1(this), identityHashCode);
            if (unregisterReceiver == 0) {
                return null;
            }
            throw new WearEngineException(unregisterReceiver);
        }
    }

    public class d implements Callable<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Device f44794b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44795c;

        public d(Device device, String str) {
            this.f44794b = device;
            this.f44795c = str;
        }

        public Object call() {
            boolean z11;
            com.huawei.wearengine.common.a.a(this.f44794b, (Object) "Device can not be null!");
            if (!TextUtils.isEmpty(this.f44795c)) {
                if (P2pClient.this.f44770a.getDeviceAppVersionCode(this.f44794b, com.huawei.wearengine.utils.b.a().getPackageName(), this.f44795c) != -1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                return Boolean.valueOf(z11);
            }
            throw com.huawei.wearengine.a.a("Preconditions", "targetPkgName can not be null!", 5);
        }
    }

    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MessageParcel f44797b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Message.Builder f44798c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Receiver f44799d;

        public e(P2pClient p2pClient, MessageParcel messageParcel, Message.Builder builder, Receiver receiver) {
            this.f44797b = messageParcel;
            this.f44798c = builder;
            this.f44799d = receiver;
        }

        public void run() {
            this.f44798c.setPayload(com.huawei.wearengine.utils.b.a(this.f44797b.getFileName(), this.f44797b.getParcelFileDescriptor()));
            this.f44799d.onReceiveMessage(this.f44798c.build());
        }
    }

    public class f implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Device f44800b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PingCallback f44801c;

        public f(Device device, PingCallback pingCallback) {
            this.f44800b = device;
            this.f44801c = pingCallback;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f44800b, (Object) "Device can not be null!");
            com.huawei.wearengine.common.a.a(this.f44801c, (Object) "PingCallback can not be null!");
            P2pClient$1$1 p2pClient$1$1 = new P2pClient$1$1(this);
            int ping = P2pClient.this.f44770a.ping(this.f44800b, com.huawei.wearengine.utils.b.a().getPackageName(), P2pClient.this.f44771b, p2pClient$1$1);
            if (ping == 0) {
                return null;
            }
            throw new WearEngineException(ping);
        }
    }

    public class g implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Device f44803b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Message f44804c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SendCallback f44805d;

        public g(Device device, Message message, SendCallback sendCallback) {
            this.f44803b = device;
            this.f44804c = message;
            this.f44805d = sendCallback;
        }

        public Object call() {
            String packageName = com.huawei.wearengine.utils.b.a().getPackageName();
            String a11 = com.huawei.wearengine.utils.b.a(com.huawei.wearengine.utils.b.a(), packageName);
            com.huawei.wearengine.common.a.a(packageName, (Object) "srcPkgName can not be null!");
            com.huawei.wearengine.common.a.a(a11, (Object) "srcFingerPrint can not be null!");
            com.huawei.wearengine.common.a.a(this.f44803b, (Object) "Device can not be null!");
            com.huawei.wearengine.common.a.a(this.f44804c, (Object) "Message can not be null!");
            com.huawei.wearengine.common.a.a(this.f44805d, (Object) "SendCallback can not be null!");
            int c11 = P2pClient.this.a(this.f44803b, new IdentityInfo(packageName, a11), new IdentityInfo(P2pClient.this.f44771b, P2pClient.this.f44772c), this.f44804c, this.f44805d);
            if (c11 == 0) {
                return null;
            }
            throw new WearEngineException(c11);
        }
    }

    public class h implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Peer f44807b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Message f44808c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SendCallback f44809d;

        public h(Peer peer, Message message, SendCallback sendCallback) {
            this.f44807b = peer;
            this.f44808c = message;
            this.f44809d = sendCallback;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f44807b, (Object) "Peer can not be null!");
            Device device = this.f44807b.getDevice();
            String packageName = com.huawei.wearengine.utils.b.a().getPackageName();
            String a11 = com.huawei.wearengine.utils.b.a(com.huawei.wearengine.utils.b.a(), packageName);
            com.huawei.wearengine.common.a.a(device, (Object) "Device can not be null!");
            com.huawei.wearengine.common.a.a(packageName, (Object) "srcPkgName can not be null!");
            com.huawei.wearengine.common.a.a(a11, (Object) "srcFingerPrint can not be null!");
            com.huawei.wearengine.common.a.a(this.f44808c, (Object) "Message can not be null!");
            com.huawei.wearengine.common.a.a(this.f44809d, (Object) "SendCallback can not be null!");
            int c11 = P2pClient.this.a(device, new IdentityInfo(packageName, a11), new IdentityInfo(this.f44807b.getPkgName(), this.f44807b.getFingerPrint()), this.f44808c, this.f44809d);
            if (c11 == 0) {
                return null;
            }
            throw new WearEngineException(c11);
        }
    }

    public class i implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Device f44811b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FileIdentification f44812c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CancelFileTransferCallBack f44813d;

        public i(Device device, FileIdentification fileIdentification, CancelFileTransferCallBack cancelFileTransferCallBack) {
            this.f44811b = device;
            this.f44812c = fileIdentification;
            this.f44813d = cancelFileTransferCallBack;
        }

        public Object call() {
            String packageName = com.huawei.wearengine.utils.b.a().getPackageName();
            String a11 = com.huawei.wearengine.utils.b.a(com.huawei.wearengine.utils.b.a(), packageName);
            com.huawei.wearengine.common.a.a(packageName, (Object) "srcPkgName can not be null!");
            com.huawei.wearengine.common.a.a(a11, (Object) "srcFingerPrint can not be null!");
            com.huawei.wearengine.common.a.a(this.f44811b, (Object) "Device can not be null!");
            com.huawei.wearengine.common.a.a(this.f44812c, (Object) "fileIdentification can not be null!");
            com.huawei.wearengine.common.a.a(this.f44813d, (Object) "CancelFileTransferCallBack can not be null!");
            int b11 = P2pClient.this.a(this.f44811b, new IdentityInfo(packageName, a11), new IdentityInfo(P2pClient.this.f44771b, P2pClient.this.f44772c), this.f44812c, this.f44813d);
            if (b11 == 0) {
                return null;
            }
            throw new WearEngineException(b11);
        }
    }

    public class j implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Peer f44815b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FileIdentification f44816c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CancelFileTransferCallBack f44817d;

        public j(Peer peer, FileIdentification fileIdentification, CancelFileTransferCallBack cancelFileTransferCallBack) {
            this.f44815b = peer;
            this.f44816c = fileIdentification;
            this.f44817d = cancelFileTransferCallBack;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f44815b, (Object) "Peer can not be null!");
            Device device = this.f44815b.getDevice();
            String packageName = com.huawei.wearengine.utils.b.a().getPackageName();
            String a11 = com.huawei.wearengine.utils.b.a(com.huawei.wearengine.utils.b.a(), packageName);
            com.huawei.wearengine.common.a.a(packageName, (Object) "srcPkgName can not be null!");
            com.huawei.wearengine.common.a.a(a11, (Object) "srcFingerPrint can not be null!");
            com.huawei.wearengine.common.a.a(device, (Object) "Device can not be null!");
            com.huawei.wearengine.common.a.a(this.f44816c, (Object) "fileIdentification can not be null!");
            com.huawei.wearengine.common.a.a(this.f44817d, (Object) "CancelFileTransferCallBack can not be null!");
            int b11 = P2pClient.this.a(device, new IdentityInfo(packageName, a11), new IdentityInfo(this.f44815b.getPkgName(), this.f44815b.getFingerPrint()), this.f44816c, this.f44817d);
            if (b11 == 0) {
                return null;
            }
            throw new WearEngineException(b11);
        }
    }

    private P2pClient() {
    }

    /* access modifiers changed from: private */
    public int a(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, FileIdentification fileIdentification, final CancelFileTransferCallBack cancelFileTransferCallBack) {
        FileIdentificationParcel fileIdentificationParcel;
        if (fileIdentification == null) {
            com.huawei.wearengine.common.a.a("ConvertParcelUtil", "convertToFileIdentificationParcel fileIdentification is null");
            fileIdentificationParcel = null;
        } else {
            FileIdentificationParcel fileIdentificationParcel2 = new FileIdentificationParcel();
            File file = fileIdentification.getFile();
            if (file != null) {
                fileIdentificationParcel2.setFileName(file.getName());
            }
            fileIdentificationParcel2.setDescription(fileIdentification.getDescription());
            fileIdentificationParcel = fileIdentificationParcel2;
        }
        return this.f44770a.cancelFileTransfer(device, fileIdentificationParcel, identityInfo, identityInfo2, new P2pCancelFileTransferCallBack.Stub() {
            public void onCancelFileTransferResult(int i11, String str) {
                com.huawei.wearengine.common.a.b("P2pClient", "cancelFileTransfer onCancelFileTransferResult, errCode: " + i11);
                cancelFileTransferCallBack.onCancelFileTransferResult(i11);
            }
        });
    }

    /* access modifiers changed from: private */
    public int a(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, Message message, final SendCallback sendCallback) {
        MessageParcel a11 = com.huawei.wearengine.common.a.a(message);
        MessageParcelExtra b11 = com.huawei.wearengine.common.a.b(message);
        AnonymousClass5 r13 = new P2pSendCallback.Stub() {
            public void onSendProgress(long j11) {
                sendCallback.onSendProgress(j11);
            }

            public void onSendResult(int i11) {
                sendCallback.onSendResult(i11);
            }
        };
        int sendExtra = this.f44770a.sendExtra(device, b11, identityInfo, identityInfo2, r13);
        return sendExtra == 14 ? this.f44770a.send(device, a11, identityInfo, identityInfo2, r13) : sendExtra;
    }

    /* access modifiers changed from: private */
    public int a(Device device, final Receiver receiver, IdentityInfo identityInfo, IdentityInfo identityInfo2) {
        return this.f44770a.registerReceiver(device, identityInfo, identityInfo2, new ReceiverCallback.Stub() {
            public void onReceiveFileMessage(MessageParcel messageParcel) {
                P2pClient.this.a(receiver, messageParcel);
            }

            public void onReceiveMessage(byte[] bArr) {
                Message.Builder builder = new Message.Builder();
                builder.setPayload(bArr);
                receiver.onReceiveMessage(builder.build());
            }
        }, System.identityHashCode(receiver));
    }

    /* access modifiers changed from: private */
    public void a(Receiver receiver, MessageParcel messageParcel) {
        if (messageParcel == null) {
            com.huawei.wearengine.common.a.a("P2pClient", "handleReceiveFile messageParcel is null");
            receiver.onReceiveMessage(new Message.Builder().build());
            return;
        }
        Message.Builder builder = new Message.Builder();
        if (messageParcel.getType() == 2) {
            this.f44773d.execute(new e(this, messageParcel, builder, receiver));
        } else {
            com.huawei.wearengine.common.a.c("P2pClient", "handleReceiveFile type is not file");
        }
    }

    public static P2pClient getInstance() {
        if (f44769e == null) {
            synchronized (P2pClient.class) {
                if (f44769e == null) {
                    f44769e = new P2pClient();
                }
            }
        }
        return f44769e;
    }

    public Task<Void> cancelFileTransfer(Device device, FileIdentification fileIdentification, CancelFileTransferCallBack cancelFileTransferCallBack) {
        return Tasks.callInBackground(new i(device, fileIdentification, cancelFileTransferCallBack));
    }

    public Task<Void> cancelFileTransfer(Peer peer, FileIdentification fileIdentification, CancelFileTransferCallBack cancelFileTransferCallBack) {
        return Tasks.callInBackground(new j(peer, fileIdentification, cancelFileTransferCallBack));
    }

    public Task<Boolean> isAppInstalled(Device device, String str) {
        return Tasks.callInBackground(new d(device, str));
    }

    public Task<Void> ping(Device device, PingCallback pingCallback) {
        return Tasks.callInBackground(new f(device, pingCallback));
    }

    public Task<Void> registerReceiver(Device device, Receiver receiver) {
        return Tasks.callInBackground(new a(device, receiver));
    }

    public Task<Void> registerReceiver(Peer peer, Receiver receiver) {
        return Tasks.callInBackground(new b(peer, receiver));
    }

    public void registerReceiver(Device device, String str, String str2, final Receiver receiver) {
        com.huawei.wearengine.common.a.a(device, (Object) "Device can not be null!");
        com.huawei.wearengine.common.a.a(str, (Object) "srcPkgName can not be null!");
        com.huawei.wearengine.common.a.a(str2, (Object) "srcFingerPrint can not be null!");
        com.huawei.wearengine.common.a.a(receiver, (Object) "Receiver can not be null!");
        AnonymousClass9 r52 = new ReceiverCallback.Stub() {
            public void onReceiveFileMessage(MessageParcel messageParcel) {
                P2pClient.this.a(receiver, messageParcel);
            }

            public void onReceiveMessage(byte[] bArr) {
                Message.Builder builder = new Message.Builder();
                builder.setPayload(bArr);
                receiver.onReceiveMessage(builder.build());
            }
        };
        int registerReceiverInternal = this.f44770a.registerReceiverInternal(device, new IdentityInfo(str, str2), new IdentityInfo(this.f44771b, this.f44772c), r52, System.identityHashCode(receiver));
        if (registerReceiverInternal != 0) {
            throw new WearEngineException(registerReceiverInternal);
        }
    }

    public Task<Void> send(Device device, Message message, SendCallback sendCallback) {
        return Tasks.callInBackground(new g(device, message, sendCallback));
    }

    public Task<Void> send(Peer peer, Message message, SendCallback sendCallback) {
        return Tasks.callInBackground(new h(peer, message, sendCallback));
    }

    public void send(Device device, String str, String str2, Message message, final SendCallback sendCallback) {
        com.huawei.wearengine.common.a.a(device, (Object) "Device can not be null!");
        com.huawei.wearengine.common.a.a(str, (Object) "srcPkgName can not be null!");
        com.huawei.wearengine.common.a.a(str2, (Object) "srcFingerPrint can not be null!");
        com.huawei.wearengine.common.a.a(message, (Object) "Message can not be null!");
        com.huawei.wearengine.common.a.a(sendCallback, (Object) "SendCallback can not be null!");
        IdentityInfo identityInfo = new IdentityInfo(str, str2);
        IdentityInfo identityInfo2 = new IdentityInfo(this.f44771b, this.f44772c);
        int sendInternal = this.f44770a.sendInternal(device, com.huawei.wearengine.common.a.b(message), identityInfo, identityInfo2, new P2pSendCallback.Stub() {
            public void onSendProgress(long j11) {
                sendCallback.onSendProgress(j11);
            }

            public void onSendResult(int i11) {
                sendCallback.onSendResult(i11);
            }
        });
        if (sendInternal != 0) {
            throw new WearEngineException(sendInternal);
        }
    }

    public P2pClient setPeerFingerPrint(String str) {
        this.f44772c = str;
        return this;
    }

    public P2pClient setPeerPkgName(String str) {
        this.f44771b = str;
        return this;
    }

    public Task<Void> unregisterReceiver(Receiver receiver) {
        return Tasks.callInBackground(new c(receiver));
    }
}
