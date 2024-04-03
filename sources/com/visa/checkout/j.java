package com.visa.checkout;

import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import net.bytebuddy.jar.asm.Opcodes;

@Instrumented
@TargetApi(23)
public final class j extends DialogFragment implements TraceFieldInterface {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static int f235 = 0;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static int f236 = 1;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static int f237 = 61;
    public Trace _nr_trace;

    /* renamed from: ʼ  reason: contains not printable characters */
    private FingerprintManager f238;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Runnable f239 = new Runnable() {
        public final void run() {
            j.this.m6195();
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private a f240;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f241;

    /* renamed from: ˎ  reason: contains not printable characters */
    private TextView f242;

    /* renamed from: ˏ  reason: contains not printable characters */
    private ImageView f243;

    /* renamed from: ॱ  reason: contains not printable characters */
    private TextView f244;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private CancellationSignal f245;

    public interface a {
        /* renamed from: ˊ  reason: contains not printable characters */
        void m6202();

        /* renamed from: ˋ  reason: contains not printable characters */
        void m6203();
    }

    public static class e extends FingerprintManager.AuthenticationCallback {

        /* renamed from: ˎ  reason: contains not printable characters */
        private WeakReference<j> f248;

        public e(WeakReference<j> weakReference) {
            this.f248 = weakReference;
        }

        public final void onAuthenticationError(int i11, CharSequence charSequence) {
            j jVar = this.f248.get();
            if (jVar != null) {
                jVar.m6201(charSequence);
                if (i11 == 5) {
                    jVar.m6195();
                }
            }
        }

        public final void onAuthenticationFailed() {
            j jVar = this.f248.get();
            if (jVar != null) {
                jVar.m6197((CharSequence) jVar.getActivity().getResources().getString(R.string.vco_fingerprint_not_recognized));
            }
        }

        public final void onAuthenticationHelp(int i11, CharSequence charSequence) {
            j jVar = this.f248.get();
            if (jVar != null) {
                jVar.m6197(charSequence);
            }
        }

        public final void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            final j jVar = this.f248.get();
            jVar.m6199();
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    jVar.dismiss();
                }
            }, 1300);
            j.m6192(jVar).m6202();
            jVar.dismiss();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static /* synthetic */ a m6192(j jVar) {
        int i11 = f235;
        int i12 = i11 + 113;
        f236 = i12 % 128;
        int i13 = i12 % 2;
        a aVar = jVar.f240;
        int i14 = i11 + 111;
        f236 = i14 % 128;
        int i15 = i14 % 2;
        return aVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6194(CharSequence charSequence) {
        int i11 = f235 + 73;
        f236 = i11 % 128;
        if (!(i11 % 2 == 0)) {
            this.f243.setImageResource(R.drawable.ic_fingerprint_error);
            this.f242.setText(charSequence);
            TextView textView = this.f242;
            textView.setTextColor(textView.getResources().getColor(R.color.warning_color, (Resources.Theme) null));
            return;
        }
        this.f243.setImageResource(R.drawable.ic_fingerprint_error);
        this.f242.setText(charSequence);
        TextView textView2 = this.f242;
        textView2.setTextColor(textView2.getResources().getColor(R.color.warning_color, (Resources.Theme) null));
        throw null;
    }

    @TargetApi(21)
    public final void onCreate(Bundle bundle) {
        TraceMachine.startTracing(com.apptimize.j.f43085a);
        try {
            TraceMachine.enterMethod(this._nr_trace, "j#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "j#onCreate", (ArrayList<String>) null);
        }
        int i11 = f235 + 111;
        f236 = i11 % 128;
        int i12 = i11 % 2;
        super.onCreate(bundle);
        setRetainInstance(true);
        setStyle(0, 16974393);
        int i13 = f235 + 109;
        f236 = i13 % 128;
        int i14 = i13 % 2;
        TraceMachine.exitMethod();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "j#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "j#onCreateView", (ArrayList<String>) null);
        }
        View inflate = layoutInflater.inflate(R.layout.fingerprint_dialog_container, viewGroup);
        getDialog().setTitle(getString(R.string.vco_fingerprint_sign_in));
        this.f243 = (ImageView) inflate.findViewById(R.id.fingerprint_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.fingerprint_description);
        this.f244 = textView;
        textView.setText(this.f241);
        this.f242 = (TextView) inflate.findViewById(R.id.fingerprint_status);
        ((Button) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                j.this.dismiss();
            }
        });
        int i11 = f235 + 3;
        f236 = i11 % 128;
        int i12 = i11 % 2;
        TraceMachine.exitMethod();
        return inflate;
    }

    public final void onDestroy() {
        boolean z11;
        int i11 = f235 + 61;
        f236 = i11 % 128;
        if (i11 % 2 == 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            super.onDestroy();
            this.f238 = null;
            this.f244 = null;
            this.f240 = null;
            this.f241 = null;
            return;
        }
        super.onDestroy();
        this.f238 = null;
        this.f244 = null;
        this.f240 = null;
        this.f241 = null;
        throw null;
    }

    public final void onPause() {
        char c11;
        int i11 = f236 + 83;
        f235 = i11 % 128;
        if (i11 % 2 == 0) {
            super.onPause();
            CancellationSignal cancellationSignal = this.f245;
            if (cancellationSignal != null) {
                c11 = 8;
            } else {
                c11 = 28;
            }
            if (c11 == 8) {
                cancellationSignal.cancel();
                this.f245 = null;
                int i12 = f235 + 113;
                f236 = i12 % 128;
                int i13 = i12 % 2;
                return;
            }
            return;
        }
        super.onPause();
        throw null;
    }

    public final void onResume() {
        boolean z11;
        super.onResume();
        this.f245 = new CancellationSignal();
        if (getActivity().checkSelfPermission(m6193(8, "￬￪￷￵￷￮￳￹\u0006\u0013\t\u0017\u0014\u000e\tￓ\u0015\n\u0017\u0012\u000e\u0018\u0018\u000e\u0014\u0013ￓ￺￸￪\u0004￫￮￳", Opcodes.DCMPG, false, 34).intern()) == 0) {
            this.f238.authenticate((FingerprintManager.CryptoObject) null, this.f245, 0, new e(new WeakReference(this)), (Handler) null);
            int i11 = f235 + 113;
            f236 = i11 % 128;
            int i12 = i11 % 2;
        }
        int i13 = f236 + 107;
        f235 = i13 % 128;
        if (i13 % 2 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int i14 = 2 / 0;
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m6195() {
        boolean z11;
        int i11 = f236 + 103;
        f235 = i11 % 128;
        int i12 = i11 % 2;
        TextView textView = this.f242;
        textView.setTextColor(textView.getResources().getColor(R.color.hint_color, (Resources.Theme) null));
        TextView textView2 = this.f242;
        textView2.setText(textView2.getResources().getString(R.string.vco_fingerprint_hint));
        this.f243.setImageResource(R.drawable.ic_fp_40px);
        int i13 = f235 + 19;
        f236 = i13 % 128;
        if (i13 % 2 == 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            throw null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m6200(FingerprintManager fingerprintManager) {
        int i11 = f236 + 11;
        int i12 = i11 % 128;
        f235 = i12;
        int i13 = i11 % 2;
        this.f238 = fingerprintManager;
        int i14 = i12 + 101;
        f236 = i14 % 128;
        int i15 = i14 % 2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m6196(a aVar) {
        int i11 = f235 + 123;
        int i12 = i11 % 128;
        f236 = i12;
        int i13 = i11 % 2;
        this.f240 = aVar;
        int i14 = i12 + 69;
        f235 = i14 % 128;
        int i15 = i14 % 2;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m6199() {
        int i11 = f235 + 27;
        f236 = i11 % 128;
        int i12 = i11 % 2;
        this.f242.removeCallbacks(this.f239);
        this.f243.setImageResource(R.drawable.ic_fingerprint_success);
        TextView textView = this.f242;
        textView.setTextColor(textView.getResources().getColor(R.color.success_color, (Resources.Theme) null));
        TextView textView2 = this.f242;
        textView2.setText(textView2.getResources().getString(R.string.vco_fingerprint_success));
        int i13 = f235 + 5;
        f236 = i13 % 128;
        if ((i13 % 2 == 0 ? '%' : ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK) == '%') {
            throw null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m6198(String str) {
        int i11 = f235 + 93;
        int i12 = i11 % 128;
        f236 = i12;
        int i13 = i11 % 2;
        this.f241 = str;
        int i14 = i12 + 93;
        f235 = i14 % 128;
        if ((i14 % 2 != 0 ? '&' : 4) == '&') {
            throw null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m6197(CharSequence charSequence) {
        int i11 = f235 + 115;
        f236 = i11 % 128;
        int i12 = i11 % 2;
        m6194(charSequence);
        this.f242.postDelayed(this.f239, 1600);
        int i13 = f235 + 51;
        f236 = i13 % 128;
        int i14 = i13 % 2;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m6201(CharSequence charSequence) {
        int i11 = f236 + 49;
        f235 = i11 % 128;
        int i12 = i11 % 2;
        m6194(charSequence);
        this.f242.removeCallbacks(this.f239);
        int i13 = f235 + 103;
        f236 = i13 % 128;
        if (i13 % 2 == 0) {
            int i14 = 25 / 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007b, code lost:
        throw null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ॱ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6193(int r5, java.lang.String r6, int r7, boolean r8, int r9) {
        /*
            int r0 = f236
            int r0 = r0 + 97
            int r1 = r0 % 128
            f235 = r1
            int r0 = r0 % 2
            r1 = 90
            if (r0 == 0) goto L_0x0011
            r0 = 84
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            if (r0 != r1) goto L_0x007a
            if (r6 == 0) goto L_0x001a
            char[] r6 = r6.toCharArray()
        L_0x001a:
            char[] r6 = (char[]) r6
            char[] r0 = new char[r9]
            r1 = 0
            r2 = r1
        L_0x0020:
            if (r2 >= r9) goto L_0x0031
            char r3 = r6[r2]
            int r3 = r3 + r7
            char r3 = (char) r3
            r0[r2] = r3
            int r4 = f237
            int r3 = r3 - r4
            char r3 = (char) r3
            r0[r2] = r3
            int r2 = r2 + 1
            goto L_0x0020
        L_0x0031:
            r6 = 1
            if (r5 <= 0) goto L_0x0036
            r7 = r1
            goto L_0x0037
        L_0x0036:
            r7 = r6
        L_0x0037:
            if (r7 == 0) goto L_0x003a
            goto L_0x0047
        L_0x003a:
            char[] r7 = new char[r9]
            java.lang.System.arraycopy(r0, r1, r7, r1, r9)
            int r2 = r9 - r5
            java.lang.System.arraycopy(r7, r1, r0, r2, r5)
            java.lang.System.arraycopy(r7, r5, r0, r1, r2)
        L_0x0047:
            if (r8 == 0) goto L_0x0074
            char[] r5 = new char[r9]
            r7 = r1
        L_0x004c:
            if (r7 >= r9) goto L_0x0050
            r8 = r6
            goto L_0x0051
        L_0x0050:
            r8 = r1
        L_0x0051:
            if (r8 == 0) goto L_0x0073
            int r8 = f236
            int r8 = r8 + 19
            int r2 = r8 % 128
            f235 = r2
            int r8 = r8 % 2
            if (r8 == 0) goto L_0x0069
            int r8 = r9 - r7
            r8 = r8 & r1
            char r8 = r0[r8]
            r5[r7] = r8
            int r7 = r7 + 104
            goto L_0x004c
        L_0x0069:
            int r8 = r9 - r7
            int r8 = r8 - r6
            char r8 = r0[r8]
            r5[r7] = r8
            int r7 = r7 + 1
            goto L_0x004c
        L_0x0073:
            r0 = r5
        L_0x0074:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0)
            return r5
        L_0x007a:
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.j.m6193(int, java.lang.String, int, boolean, int):java.lang.String");
    }
}
