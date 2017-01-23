package com.mbm.cse.encarta;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by cse on 09-Nov-16.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public String TAG = "FCM";


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
         if (remoteMessage.getNotification() != null) {
             Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

         }








        sendNotification(remoteMessage.getNotification().getBody());
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
    private void sendNotification(String message) {
        Intent intent = new Intent(this, EncarTa.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat .Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.encartaimgthree)
                .setContentTitle("Encarta")
                .setContentText(message)
                .setAutoCancel(false)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        /*if (!TextUtils.isEmpty(message.optString("img_url"))) {
            try {
                Bitmap remote_picture = BitmapFactory.decodeStream((InputStream) new URL(message.optString("img_url")).getContent());

                // Create the style object with BigPictureStyle subclass.
                NotificationCompat.BigPictureStyle pictureStyle = new NotificationCompat.BigPictureStyle();
                pictureStyle.setBigContentTitle(message.optString("title"));
                pictureStyle.setSummaryText(message.optString("description"));
                pictureStyle.bigPicture(remote_picture);

                notificationBuilder.setStyle(pictureStyle).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }
}
