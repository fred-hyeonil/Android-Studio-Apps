package com.example.final_project

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput

class ReplyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val KEY_TEXT_REPLY = "key_text_reply"
        val replyTxt = RemoteInput.getResultsFromIntent(intent)?.getCharSequence(KEY_TEXT_REPLY)?.toString()
        val time = intent.getStringExtra("record_time") ?: "시간 없음"
        val userName = "samsung smart watch"

        if (!replyTxt.isNullOrEmpty()) {
            Log.d("ReplyReceiver", "$time - $replyTxt")

            context.openFileOutput("timelog.txt", Context.MODE_APPEND).use {
                it.write("$time - $replyTxt\n".toByteArray())
            }

            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channelId = "one-channel"

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    channelId,
                    "My Channel One",
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                    description = "My Channel One Description"
                }
                manager.createNotificationChannel(channel)
            }

            val remoteInput = RemoteInput.Builder(KEY_TEXT_REPLY)
                .setLabel("답장")
                .build()

            val replyIntent = Intent(context, ReplyReceiver::class.java).apply {
                putExtra("record_time", time)
            }

            val replyPendingIntent = PendingIntent.getBroadcast(
                context, 30, replyIntent,
                PendingIntent.FLAG_MUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )

            val style = NotificationCompat.MessagingStyle(userName)
                .setConversationTitle("스톱워치 기록")
                .addMessage("기록된 시간: $time", System.currentTimeMillis(), userName)
                .addMessage(replyTxt, System.currentTimeMillis(), "나")

            val builder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.small)
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.big))
                .setStyle(style)
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