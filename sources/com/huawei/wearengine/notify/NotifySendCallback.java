package com.huawei.wearengine.notify;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface NotifySendCallback extends IInterface {

    public static abstract class a extends Binder implements NotifySendCallback {

        /* renamed from: com.huawei.wearengine.notify.NotifySendCallback$a$a  reason: collision with other inner class name */
        public static class C0049a implements NotifySendCallback {

            /* renamed from: b  reason: collision with root package name */
            public static NotifySendCallback f44753b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f44754a;

            public C0049a(IBinder iBinder) {
                this.f44754a = iBinder;
            }

            public IBinder asBinder() {
                return this.f44754a;
            }

            public void onError(NotificationParcel notificationParcel, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.wearengine.notify.NotifySendCallback");
                    if (notificationParcel != null) {
                        obtain.writeInt(1);
                        notificationParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i11);
                    if (this.f44754a.transact(2, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            notificationParcel.readFromParcel(obtain2);
                        }
                    } else {
                        f44753b.onError(notificationParcel, i11);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onResult(NotificationParcel notificationParcel, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.wearengine.notify.NotifySendCallback");
                    if (notificationParcel != null) {
                        obtain.writeInt(1);
                        notificationParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i11);
                    if (this.f44754a.transact(1, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            notificationParcel.readFromParcel(obtain2);
                        }
                    } else {
                        f44753b.onResult(notificationParcel, i11);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.huawei.wearengine.notify.NotifySendCallback");
        }

        public static NotifySendCallback a() {
            return C0049a.f44753b;
        }

        public static NotifySendCallback a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.wearengine.notify.NotifySendCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof NotifySendCallback)) ? new C0049a(iBinder) : (NotifySendCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            NotificationParcel notificationParcel = null;
            if (i11 == 1) {
                parcel.enforceInterface("com.huawei.wearengine.notify.NotifySendCallback");
                if (parcel.readInt() != 0) {
                    notificationParcel = NotificationParcel.CREATOR.createFromParcel(parcel);
                }
                onResult(notificationParcel, parcel.readInt());
                parcel2.writeNoException();
                if (notificationParcel != null) {
                    parcel2.writeInt(1);
                    notificationParcel.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i11 == 2) {
                parcel.enforceInterface("com.huawei.wearengine.notify.NotifySendCallback");
                if (parcel.readInt() != 0) {
                    notificationParcel = NotificationParcel.CREATOR.createFromParcel(parcel);
                }
                onError(notificationParcel, parcel.readInt());
                parcel2.writeNoException();
                if (notificationParcel != null) {
                    parcel2.writeInt(1);
                    notificationParcel.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.huawei.wearengine.notify.NotifySendCallback");
                return true;
            }
        }
    }

    void onError(NotificationParcel notificationParcel, int i11);

    void onResult(NotificationParcel notificationParcel, int i11);
}
