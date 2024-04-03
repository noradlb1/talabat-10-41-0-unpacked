package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface ITrustedWebActivityService extends IInterface {
    public static final String DESCRIPTOR = "android.support.customtabs.trusted.ITrustedWebActivityService";

    public static class Default implements ITrustedWebActivityService {
        public Bundle areNotificationsEnabled(Bundle bundle) throws RemoteException {
            return null;
        }

        public IBinder asBinder() {
            return null;
        }

        public void cancelNotification(Bundle bundle) throws RemoteException {
        }

        public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) throws RemoteException {
            return null;
        }

        public Bundle getActiveNotifications() throws RemoteException {
            return null;
        }

        public Bundle getSmallIconBitmap() throws RemoteException {
            return null;
        }

        public int getSmallIconId() throws RemoteException {
            return 0;
        }

        public Bundle notifyNotificationWithChannel(Bundle bundle) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITrustedWebActivityService {

        public static class Proxy implements ITrustedWebActivityService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public Bundle areNotificationsEnabled(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITrustedWebActivityService.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void cancelNotification(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITrustedWebActivityService.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITrustedWebActivityService.DESCRIPTOR);
                    obtain.writeString(str);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getActiveNotifications() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITrustedWebActivityService.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ITrustedWebActivityService.DESCRIPTOR;
            }

            public Bundle getSmallIconBitmap() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITrustedWebActivityService.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getSmallIconId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITrustedWebActivityService.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle notifyNotificationWithChannel(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITrustedWebActivityService.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITrustedWebActivityService.DESCRIPTOR);
        }

        public static ITrustedWebActivityService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ITrustedWebActivityService.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITrustedWebActivityService)) {
                return new Proxy(iBinder);
            }
            return (ITrustedWebActivityService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(ITrustedWebActivityService.DESCRIPTOR);
            }
            if (i11 != 1598968902) {
                switch (i11) {
                    case 2:
                        Bundle notifyNotificationWithChannel = notifyNotificationWithChannel((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, notifyNotificationWithChannel, 1);
                        break;
                    case 3:
                        cancelNotification((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        break;
                    case 4:
                        int smallIconId = getSmallIconId();
                        parcel2.writeNoException();
                        parcel2.writeInt(smallIconId);
                        break;
                    case 5:
                        Bundle activeNotifications = getActiveNotifications();
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, activeNotifications, 1);
                        break;
                    case 6:
                        Bundle areNotificationsEnabled = areNotificationsEnabled((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, areNotificationsEnabled, 1);
                        break;
                    case 7:
                        Bundle smallIconBitmap = getSmallIconBitmap();
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, smallIconBitmap, 1);
                        break;
                    case 9:
                        Bundle extraCommand = extraCommand(parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), parcel.readStrongBinder());
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, extraCommand, 1);
                        break;
                    default:
                        return super.onTransact(i11, parcel, parcel2, i12);
                }
                return true;
            }
            parcel2.writeString(ITrustedWebActivityService.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        /* access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t11, int i11) {
            if (t11 != null) {
                parcel.writeInt(1);
                t11.writeToParcel(parcel, i11);
                return;
            }
            parcel.writeInt(0);
        }
    }

    Bundle areNotificationsEnabled(Bundle bundle) throws RemoteException;

    void cancelNotification(Bundle bundle) throws RemoteException;

    Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) throws RemoteException;

    Bundle getActiveNotifications() throws RemoteException;

    Bundle getSmallIconBitmap() throws RemoteException;

    int getSmallIconId() throws RemoteException;

    Bundle notifyNotificationWithChannel(Bundle bundle) throws RemoteException;
}
