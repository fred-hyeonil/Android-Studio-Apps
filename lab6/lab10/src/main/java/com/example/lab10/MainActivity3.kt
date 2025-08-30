package com.example.lab10

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.IconCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab10.databinding.ActivityMain2Binding
import com.example.lab10.databinding.ActivityMain3Binding
import kotlin.concurrent.thread
import androidx.core.app.Person

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val launch = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            if (it) {
                noti()
            } else {
                Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show()
            }
        }
        binding.notifyButton.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (ContextCompat.checkSelfPermission(
                        this,
                        "android.permission.POST_NOTIFICATIONS"
                    ) == PackageManager.GET_RECEIVERS
                ) {
                    noti()
                } else {
                    launch.launch("android.permission.POST_NOTIFICATIONS")
                }
            } else {
                noti()
            }
        }
    }
    fun noti(){
        val manager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder:NotificationCompat.Builder

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val chan = NotificationChannel(
                "one-channel","Channel one",NotificationManager.IMPORTANCE_HIGH
            )
            chan.description="My chan .."
            chan.setShowBadge(true)
            manager.createNotificationChannel(chan)
            builder=NotificationCompat.Builder(this,"one-channel")
        }
        else{
            builder=NotificationCompat.Builder(this)
        }
        builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
        builder.setWhen(System.currentTimeMillis())
        builder.setContentTitle("Title")
        builder.setContentText("text")

        val intent= Intent(this,SubActivity::class.java)
        val pending=PendingIntent.getActivity(this,10,intent,PendingIntent.FLAG_MUTABLE)
        builder.setContentIntent(pending)
        builder.addAction(
            NotificationCompat.Action.Builder(android.R.drawable.ic_notification_overlay,"Action",pending).build()
        )
//        builder.setProgress(100,0,false)

        val sender1= Person.Builder()
            .setName("chuse")
            .setIcon(IconCompat.createWithResource(this, android.R.drawable.sym_def_app_icon))
            .build()

        val sender2= Person.Builder()
            .setName("hyeonil")
            .setIcon(IconCompat.createWithResource(this, android.R.drawable.sym_def_app_icon))
            .build()

        val message1=NotificationCompat.MessagingStyle.Message("hello",System.currentTimeMillis(),sender1)
        val message2=NotificationCompat.MessagingStyle.Message("world",System.currentTimeMillis(),sender2)

        val messSytle=NotificationCompat.MessagingStyle(sender1)
            .addMessage(message1)
            .addMessage(message2)
        builder.setStyle(messSytle)

        manager.notify(11,builder.build())
//        thread{
//            for(i in 1 .. 10){
//                builder.setProgress(100,i,false)
//                manager.notify(11,builder.build())
//                SystemClock.sleep(100)
//            }
    }
}