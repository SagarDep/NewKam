package com.fastaccess.helper;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

/**
 * Created by kosh20111 on 9/8/2015. CopyRights @ Innov8tif
 */
public class NotificationHelper {

    public static final int NOTIFICATION_ID = 20111;

    public static void notifyShort(@NonNull Context context, @NonNull String title, @NonNull String msg, @DrawableRes int iconId) {
        notifyShort(context, title, msg, iconId, NOTIFICATION_ID, null);
    }

    public static void notifyShort(@NonNull Context context, @NonNull String title, @NonNull String msg, @DrawableRes int iconId,
                                   @NonNull PendingIntent pendingIntent) {
        notifyShort(context, title, msg, iconId, NOTIFICATION_ID, pendingIntent);
    }

    public static void notifyShort(@NonNull Context context, @NonNull String title, @NonNull String msg, @DrawableRes int iconId, int nId) {
        notifyShort(context, title, msg, iconId, nId, null);
    }

    public static void notifyShort(@NonNull Context context, @NonNull String title, @NonNull String msg, @DrawableRes int iconId, int nId,
                                   @Nullable PendingIntent pendingIntent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentTitle(title)
                .setContentText(msg)
                .setSmallIcon(iconId)
                .setContentIntent(pendingIntent)
                .build();
        notificationManager.notify(nId, notification);
    }

    public static void notifyShort(@NonNull Context context, @NonNull String title, String msg, @DrawableRes int iconId,
                                   @NonNull NotificationCompat.Action action) {
        notifyShort(context, title, msg, iconId, action, NOTIFICATION_ID);
    }

    public static void notifyShort(@NonNull Context context, @NonNull String title, String msg, @DrawableRes int iconId,
                                   @NonNull NotificationCompat.Action action, int nId) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentTitle(title)
                .setContentText(msg)
                .setSmallIcon(iconId)
                .addAction(action)
                .setContentIntent(action.actionIntent)
                .build();
        notificationManager.notify(nId, notification);
    }

    public static void notifyBig(@NonNull Context context, @NonNull String title, @NonNull String msg, @DrawableRes int iconId) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context)
                .setAutoCancel(true)
                .setContentTitle(title)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentText(msg)
                .setSmallIcon(iconId)
                .setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle(title).setSummaryText(msg).bigText(msg))
                .build();
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

    public static void notifyWithImage(@NonNull Context context, @NonNull String title, @NonNull String msg, @DrawableRes int iconId,
                                       @NonNull Bitmap bitmap) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentTitle(title)
                .setContentText(msg)
                .setSmallIcon(iconId)
                .setStyle(new NotificationCompat.BigPictureStyle().setBigContentTitle(title).setSummaryText(msg).bigPicture(bitmap))
                .build();
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

    public static void cancelNotification(@NonNull Context context, int id) {
        int finalId = id == 0 ? NOTIFICATION_ID : id;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(finalId);
    }

    public static void cancelAllNotifications(@NonNull Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
    }
}
