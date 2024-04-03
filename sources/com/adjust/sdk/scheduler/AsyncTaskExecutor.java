package com.adjust.sdk.scheduler;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;

public abstract class AsyncTaskExecutor<Params, Result> {

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object[] f40010a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f40011b;

        /* renamed from: com.adjust.sdk.scheduler.AsyncTaskExecutor$a$a  reason: collision with other inner class name */
        public class C0035a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Object f40013a;

            public C0035a(Object obj) {
                this.f40013a = obj;
            }

            public final void run() {
                AsyncTaskExecutor.this.onPostExecute(this.f40013a);
            }
        }

        public a(Object[] objArr, Handler handler) {
            this.f40010a = objArr;
            this.f40011b = handler;
        }

        public final void run() {
            this.f40011b.post(new C0035a(AsyncTaskExecutor.this.doInBackground(this.f40010a)));
        }
    }

    public abstract Result doInBackground(Params[] paramsArr);

    @SafeVarargs
    public final AsyncTaskExecutor<Params, Result> execute(Params... paramsArr) {
        onPreExecute();
        Executors.newSingleThreadExecutor().execute(new a(paramsArr, new Handler(Looper.getMainLooper())));
        return this;
    }

    public void onPostExecute(Result result) {
    }

    public void onPreExecute() {
    }
}
