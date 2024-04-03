package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.notify.NotificationParcel;
import com.huawei.wearengine.notify.NotifySendCallback;

public interface NotifyManager extends IInterface {

    public static class Default implements NotifyManager {
        public IBinder asBinder() {
            return null;
        }

        public int notify(Device device, NotificationParcel notificationParcel, NotifySendCallback notifySendCallback) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements NotifyManager {
        private static final String DESCRIPTOR = "com.huawei.wearengine.NotifyManager";

        public static class Proxy implements NotifyManager {
            public static NotifyManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public int notify(Device device, NotificationParcel notificationParcel, NotifySendCallback notifySendCallback) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (notificationParcel != null) {
                        obtain.writeInt(1);
                        notificationParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(notifySendCallback != null ? notifySendCallback.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().notify(device, notificationParcel, notifySendCallback);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static NotifyManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof NotifyManager)) ? new Proxy(iBinder) : (NotifyManager) queryLocalInterface;
        }

        public static NotifyManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(NotifyManager notifyManager) {
            if (Proxy.sDefaultImpl != null || notifyManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = notifyManager;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                NotificationParcel notificationParcel = null;
                Device createFromParcel = parcel.readInt() != 0 ? Device.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    notificationParcel = NotificationParcel.CREATOR.createFromParcel(parcel);
                }
                int notify = notify(createFromParcel, notificationParcel, NotifySendCallback.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(notify);
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    int notify(Device device, NotificationParcel notificationParcel, NotifySendCallback notifySendCallback);
}
