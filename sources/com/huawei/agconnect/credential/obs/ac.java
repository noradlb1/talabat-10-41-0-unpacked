package com.huawei.agconnect.credential.obs;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.annotation.Singleton;
import com.huawei.agconnect.common.api.BackendService;
import com.huawei.agconnect.common.api.Logger;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.agconnect.exception.AGCServerException;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.DateUtils;

@Singleton
public class ac implements CredentialsProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f47547a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f47548b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public aa f47549c = new aa();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f47550d;

    /* renamed from: e  reason: collision with root package name */
    private final AGConnectInstance f47551e;

    public ac(Context context, AGConnectInstance aGConnectInstance) {
        this.f47551e = aGConnectInstance;
        String identifier = aGConnectInstance.getOptions().getIdentifier();
        this.f47548b = identifier;
        ab.a().d(this.f47549c, identifier);
        ab.a().e(this.f47549c, identifier);
        ab.a().f(this.f47549c, identifier);
        this.f47547a = Executors.newSingleThreadExecutor();
    }

    /* access modifiers changed from: private */
    public void a(final TaskCompletionSource<Token> taskCompletionSource) {
        IllegalArgumentException illegalArgumentException;
        x xVar = new x(this.f47551e);
        if (TextUtils.isEmpty(xVar.getClientId())) {
            illegalArgumentException = new IllegalArgumentException("client token request miss client id, please check whether the 'agconnect-services.json' is configured correctly");
        } else if (TextUtils.isEmpty(xVar.getClientSecret())) {
            illegalArgumentException = new IllegalArgumentException("client token request miss client secret, please check whether the 'agconnect-services.json' is configured correctly");
        } else {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            BackendService.sendRequest(xVar, 1, y.class, new BackendService.Options.Builder().app(this.f47551e).clientToken(false).build()).addOnCompleteListener(TaskExecutors.immediate(), new OnCompleteListener<y>() {
                public void onComplete(Task<y> task) {
                    Logger.i("CredentialsProviderImpl", "onComplete");
                    if (!task.isSuccessful()) {
                        taskCompletionSource.setException(task.getException());
                        countDownLatch.countDown();
                        return;
                    }
                    y result = task.getResult();
                    if (result.getRet() == null || result.getRet().getCode() == 0) {
                        aa unused = ac.this.f47549c = new aa(result.getAccessToken(), result.getExpiresIn());
                        ab.a().a(ac.this.f47549c, ac.this.f47548b);
                        ab.a().b(ac.this.f47549c, ac.this.f47548b);
                        ab.a().c(ac.this.f47549c, ac.this.f47548b);
                        countDownLatch.countDown();
                        long unused2 = ac.this.f47550d = SystemClock.elapsedRealtime();
                        taskCompletionSource.setResult(ac.this.f47549c);
                        return;
                    }
                    taskCompletionSource.setException(new AGCServerException(result.getRet().getMsg(), result.getRet().getCode()));
                    countDownLatch.countDown();
                }
            });
            try {
                if (!countDownLatch.await(5, TimeUnit.SECONDS)) {
                    Logger.e("CredentialsProviderImpl", "await failed");
                    return;
                }
                return;
            } catch (InterruptedException unused) {
                Logger.e("CredentialsProviderImpl", "await InterruptedException");
                return;
            }
        }
        taskCompletionSource.setException(illegalArgumentException);
    }

    /* access modifiers changed from: private */
    public boolean a(boolean z11) {
        aa aaVar = this.f47549c;
        if (aaVar == null || !aaVar.a()) {
            return true;
        }
        return z11 && (this.f47550d == 0 || SystemClock.elapsedRealtime() - this.f47550d > DateUtils.MILLIS_PER_HOUR);
    }

    public Task<Token> getTokens() {
        return getTokens(false);
    }

    public Task<Token> getTokens(final boolean z11) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!a(z11)) {
            taskCompletionSource.setResult(this.f47549c);
        } else {
            this.f47547a.execute(new Runnable() {
                public void run() {
                    if (!ac.this.a(z11)) {
                        taskCompletionSource.setResult(ac.this.f47549c);
                    } else {
                        ac.this.a((TaskCompletionSource<Token>) taskCompletionSource);
                    }
                }
            });
        }
        return taskCompletionSource.getTask();
    }
}
