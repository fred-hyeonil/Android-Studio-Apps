package com.example.doit610

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput

class ReplyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val replyTxt = RemoteInput.getResultsFromIntent(intent)
            ?.getCharSequence("key_text_reply")?.toString()

        if (!replyTxt.isNullOrEmpty()) {
            Log.d("chuchu", "replyTxt:$replyTxt")

            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.cancel(11)

            val channelId = "one-channel"
            val KEY_TEXT_REPLY = "key_text_reply"
            val remoteInput = RemoteInput.Builder(KEY_TEXT_REPLY)
                .setLabel("답장")
                .build()

            val replyIntent = Intent(context, ReplyReceiver::class.java)
            val replyPendingIntent = PendingIntent.getBroadcast(
                context, 30, replyIntent, PendingIntent.FLAG_MUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )

            val builder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.small)
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.big))
                .setContentTitle("임현일")
                .setContentText("이전 답변: $replyTxt")
                .addAction(
                    NotificationCompat.Action.Builder(
                        R.drawable.send,
                        "답장",
                        replyPendingIntent
                    ).addRemoteInput(remoteInput).build()
                )
                .setAutoCancel(false)

            manager.notify(11, builder.build())
        }
    }
}