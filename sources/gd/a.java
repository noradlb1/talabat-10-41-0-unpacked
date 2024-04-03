package gd;

import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.request.Request;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NetworkManager f56830b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Request f56831c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ com.instabug.library.networkv2.connection.a f56832d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f56833e;

    public /* synthetic */ a(NetworkManager networkManager, Request request, com.instabug.library.networkv2.connection.a aVar, Request.Callbacks callbacks) {
        this.f56830b = networkManager;
        this.f56831c = request;
        this.f56832d = aVar;
        this.f56833e = callbacks;
    }

    public final void run() {
        this.f56830b.lambda$doRequest$0(this.f56831c, this.f56832d, this.f56833e);
    }
}
