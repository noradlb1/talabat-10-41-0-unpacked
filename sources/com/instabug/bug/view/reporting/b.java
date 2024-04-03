package com.instabug.bug.view.reporting;

import android.net.Uri;
import com.instabug.bug.view.n;
import com.instabug.library.core.eventbus.InstabugStateEventBus;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.model.Attachment;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import net.bytebuddy.jar.asm.Opcodes;

public class b extends BasePresenter {

    /* renamed from: a  reason: collision with root package name */
    private final CompositeDisposable f45875a;

    public b(n nVar) {
        super(nVar);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f45875a = compositeDisposable;
        compositeDisposable.add(InstabugStateEventBus.getInstance().getEventObservable().subscribe(new a(this, nVar)));
    }

    private void m() {
        n nVar;
        if (com.instabug.bug.n.e().c() != null) {
            com.instabug.bug.n.e().c().f("ask a question");
            String f11 = com.instabug.bug.n.e().c().f();
            if (!com.instabug.bug.n.e().c().m() && f11 != null) {
                com.instabug.bug.n.e().c().a(Uri.parse(f11), Attachment.Type.MAIN_SCREENSHOT);
            }
            WeakReference<V> weakReference = this.f34200f;
            if (!(weakReference == null || (nVar = (n) weakReference.get()) == null)) {
                nVar.D();
            }
            l();
        }
    }

    public void a(int i11) {
        n nVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (nVar = (n) weakReference.get()) != null) {
            if (i11 != 167) {
                switch (i11) {
                    case Opcodes.IF_ICMPLT:
                        nVar.E();
                        return;
                    case Opcodes.IF_ICMPGE:
                        nVar.r();
                        return;
                    case Opcodes.IF_ICMPGT:
                        m();
                        return;
                    default:
                        return;
                }
            } else {
                nVar.n();
            }
        }
    }

    public void l() {
        n nVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (nVar = (n) weakReference.get()) != null) {
            nVar.h();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n() {
        /*
            r6 = this;
            java.lang.ref.WeakReference<V> r0 = r6.f34200f
            if (r0 == 0) goto L_0x0078
            java.lang.Object r0 = r0.get()
            com.instabug.bug.view.n r0 = (com.instabug.bug.view.n) r0
            if (r0 == 0) goto L_0x0078
            com.instabug.bug.n r1 = com.instabug.bug.n.e()
            com.instabug.bug.model.d r1 = r1.c()
            if (r1 == 0) goto L_0x0078
            com.instabug.bug.n r1 = com.instabug.bug.n.e()
            com.instabug.bug.model.d r1 = r1.c()
            java.lang.String r1 = r1.i()
            int r2 = r1.hashCode()
            r3 = -191501435(0xfffffffff495eb85, float:-9.502309E31)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L_0x005b
            r3 = 97908(0x17e74, float:1.37198E-40)
            if (r2 == r3) goto L_0x0051
            r3 = 253684815(0xf1eec4f, float:7.835513E-30)
            if (r2 == r3) goto L_0x0047
            r3 = 1621082316(0x609fc0cc, float:9.20914E19)
            if (r2 == r3) goto L_0x003d
            goto L_0x0065
        L_0x003d:
            java.lang.String r2 = "ask a question"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0065
            r1 = r4
            goto L_0x0066
        L_0x0047:
            java.lang.String r2 = "not-available"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0065
            r1 = 3
            goto L_0x0066
        L_0x0051:
            java.lang.String r2 = "bug"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0065
            r1 = 0
            goto L_0x0066
        L_0x005b:
            java.lang.String r2 = "feedback"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0065
            r1 = r5
            goto L_0x0066
        L_0x0065:
            r1 = -1
        L_0x0066:
            if (r1 == 0) goto L_0x0075
            if (r1 == r5) goto L_0x0071
            if (r1 == r4) goto L_0x006d
            goto L_0x0078
        L_0x006d:
            r0.D()
            goto L_0x0078
        L_0x0071:
            r0.i()
            goto L_0x0078
        L_0x0075:
            r0.B()
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.view.reporting.b.n():void");
    }

    public void onDestroy() {
        super.onDestroy();
        CompositeDisposable compositeDisposable = this.f45875a;
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            this.f45875a.dispose();
        }
    }
}
