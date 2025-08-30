package com.example.lab10

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.ProgressDialog.show
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.content.DialogInterface
import android.icu.text.DateTimePatternGenerator.PatternInfo.OK
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab10.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        binding.ringtoneButton.setOnClickListener{
            val uri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val ringtone=RingtoneManager.getRingtone(applicationContext,uri)
            ringtone.play()

        }
        binding.vibratorButton.setOnClickListener{
            val vibrator=if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.S){
                val vibratorManager=this.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator;

            }else{
                getSystemService(VIBRATOR_SERVICE) as Vibrator
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE)
                )
            } else {
                vibrator.vibrate(500)
            }

        }


//        binding.alertButton.setOnClickListener{
//            AlertDialog.Builder(this).run{
//                setTitle("alert test")
//                setIcon(android.R.drawable.ic_dialog_info)
//                setMessage("정말로 종료하시겠어요?")
//                setPositiveButton("OK",object : DialogInterface.OnClickListener{
//                    override fun onClick(p0: DialogInterface?, p1: Int) {
//                        Log.d("chuchu","alert ok clicked")
//                    }
//                })
//                setNegativeButton("cancel",null)
//                show()
//            }
//        }
//        binding.itemsButton.setOnClickListener{
//            val items= arrayOf("apple","orange","banana","mango")
//            AlertDialog.Builder(this).run{
//                setTitle("items dialog test")
//                setIcon(android.R.drawable.ic_dialog_info)
//                setItems(items,object:DialogInterface.OnClickListener{
//                    override fun onClick(p0: DialogInterface?, p1: Int) {
//                        Log.d("chuchu","item: ${items[p1]}")
//                    }
//                })
//                setPositiveButton("OK",null)
//                show()
//            }
//        }
//        binding.dateButton.setOnClickListener{
//            DatePickerDialog(this, object : OnDateSetListener {
//                override fun onDateSet(view: DatePicker?, p1: Int, p2: Int, p3: Int) {
//                    Log.d("chuchu","date: $p1, ${p2+1}, $p3")
//                }
//
//            },2025,5,27).show()
//        }
//        binding.timeButton.setOnClickListener{
//            TimePickerDialog(this, object : OnTimeSetListener {
//                override fun onTimeSet(view: TimePicker?, p1: Int, p2: Int) {
//                    Log.d("chuchu","time: $p1, $p2")
//                }
//
//            },16, 0,true).show()
//        }
    }
}