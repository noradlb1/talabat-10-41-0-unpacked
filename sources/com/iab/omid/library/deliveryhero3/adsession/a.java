package com.iab.omid.library.deliveryhero3.adsession;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.deliveryhero3.internal.c;
import com.iab.omid.library.deliveryhero3.internal.e;
import com.iab.omid.library.deliveryhero3.internal.h;
import com.iab.omid.library.deliveryhero3.publisher.AdSessionStatePublisher;
import com.iab.omid.library.deliveryhero3.publisher.b;
import com.iab.omid.library.deliveryhero3.utils.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class a extends AdSession {

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f44917l = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: a  reason: collision with root package name */
    private final AdSessionContext f44918a;

    /* renamed from: b  reason: collision with root package name */
    private final AdSessionConfiguration f44919b;

    /* renamed from: c  reason: collision with root package name */
    private final List<e> f44920c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private com.iab.omid.library.deliveryhero3.weakreference.a f44921d;

    /* renamed from: e  reason: collision with root package name */
    private AdSessionStatePublisher f44922e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f44923f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f44924g = false;

    /* renamed from: h  reason: collision with root package name */
    private final String f44925h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f44926i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f44927j;

    /* renamed from: k  reason: collision with root package name */
    private PossibleObstructionListener f44928k;

    public a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f44919b = adSessionConfiguration;
        this.f44918a = adSessionContext;
        this.f44925h = UUID.randomUUID().toString();
        d((View) null);
        this.f44922e = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.deliveryhero3.publisher.a(adSessionContext.getWebView()) : new b(adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f44922e.i();
        c.c().a(this);
        this.f44922e.a(adSessionConfiguration);
    }

    private void a() {
        if (this.f44926i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private static void a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    private void a(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 50) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
        } else if (!f44917l.matcher(str).matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
    }

    private e b(View view) {
        for (e next : this.f44920c) {
            if (next.c().get() == view) {
                return next;
            }
        }
        return null;
    }

    private void b() {
        if (this.f44927j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    private void c(View view) {
        Collection<a> b11 = c.c().b();
        if (b11 != null && !b11.isEmpty()) {
            for (a next : b11) {
                if (next != this && next.c() == view) {
                    next.f44921d.clear();
                }
            }
        }
    }

    private void d(View view) {
        this.f44921d = new com.iab.omid.library.deliveryhero3.weakreference.a(view);
    }

    public void a(List<com.iab.omid.library.deliveryhero3.weakreference.a> list) {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            for (com.iab.omid.library.deliveryhero3.weakreference.a aVar : list) {
                View view = (View) aVar.get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f44928k.onPossibleObstructionsDetected(this.f44925h, arrayList);
        }
    }

    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (!this.f44924g) {
            a(view);
            a(str);
            if (b(view) == null) {
                this.f44920c.add(new e(view, friendlyObstructionPurpose, str));
            }
        }
    }

    public void b(@NonNull JSONObject jSONObject) {
        b();
        getAdSessionStatePublisher().a(jSONObject);
        this.f44927j = true;
    }

    public View c() {
        return (View) this.f44921d.get();
    }

    public List<e> d() {
        return this.f44920c;
    }

    public boolean e() {
        return this.f44928k != null;
    }

    public void error(ErrorType errorType, String str) {
        if (!this.f44924g) {
            g.a((Object) errorType, "Error type is null");
            g.a(str, "Message is null");
            getAdSessionStatePublisher().a(errorType, str);
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    public boolean f() {
        return this.f44923f && !this.f44924g;
    }

    public void finish() {
        if (!this.f44924g) {
            this.f44921d.clear();
            removeAllFriendlyObstructions();
            this.f44924g = true;
            getAdSessionStatePublisher().f();
            c.c().b(this);
            getAdSessionStatePublisher().b();
            this.f44922e = null;
            this.f44928k = null;
        }
    }

    public boolean g() {
        return this.f44924g;
    }

    public String getAdSessionId() {
        return this.f44925h;
    }

    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f44922e;
    }

    public boolean h() {
        return this.f44919b.isNativeImpressionOwner();
    }

    public boolean i() {
        return this.f44919b.isNativeMediaEventsOwner();
    }

    public boolean j() {
        return this.f44923f;
    }

    public void k() {
        a();
        getAdSessionStatePublisher().g();
        this.f44926i = true;
    }

    public void l() {
        b();
        getAdSessionStatePublisher().h();
        this.f44927j = true;
    }

    public void registerAdView(View view) {
        if (!this.f44924g) {
            g.a((Object) view, "AdView is null");
            if (c() != view) {
                d(view);
                getAdSessionStatePublisher().a();
                c(view);
            }
        }
    }

    public void removeAllFriendlyObstructions() {
        if (!this.f44924g) {
            this.f44920c.clear();
        }
    }

    public void removeFriendlyObstruction(View view) {
        if (!this.f44924g) {
            a(view);
            e b11 = b(view);
            if (b11 != null) {
                this.f44920c.remove(b11);
            }
        }
    }

    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.f44928k = possibleObstructionListener;
    }

    public void start() {
        if (!this.f44923f) {
            this.f44923f = true;
            c.c().c(this);
            this.f44922e.a(h.c().b());
            this.f44922e.a(com.iab.omid.library.deliveryhero3.internal.a.a().b());
            this.f44922e.a(this, this.f44918a);
        }
    }
}
