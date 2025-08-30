package com.example.swproject

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.NonCancellable.start
import android.widget.MediaController
import android.os.Handler
import android.os.Looper

class ContentDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_display)

        val type = intent.getStringExtra("type") // "post", "poster", "video"
        val contentContainer = findViewById<FrameLayout>(R.id.contentContainer)
        val loadingText = TextView(this).apply {
            text = "⏳ 콘텐츠 생성 중..."
            textSize = 18f
            setPadding(16, 16, 16, 16)
        }

        contentContainer.addView(loadingText)
        // 3초 후에 실제 콘텐츠로 교체
        Handler(Looper.getMainLooper()).postDelayed({
            contentContainer.removeAllViews() // 로딩 메시지 제거

            when (type) {
                "post" -> {
                    val textView = TextView(this).apply {
                        text = "정안식당 - 전남대학교 호동로의 맛있는 비밀!\n" +
                                "\n" +
                                "혼밥 환영, 단체 대환영!\n" +
                                "정안식당은 50대 중년 부부가 운영하는 정겨운 맛집입니다. 레트로한 분위기 속에서, 불고기 백반의 진수를 맛볼 수 있는 곳! \n" +
                                "\n" +
                                "왜 정안식당인가?\n" +
                                "혼자 와도 좋아요!\n" +
                                "혼자서도 편안하게 맛있는 한 끼를 즐기기 좋은 곳! 자주 찾아오고 싶은 따뜻한 분위기가 매력적이에요. \n" +
                                "\n" +
                                "단체 손님도 환영!\n" +
                                "여러 명이 함께 방문해도 넉넉한 공간과 맛있는 메뉴로 모두 만족할 수 있는 곳! 가족 모임이나 친구들 모임에도 완벽한 선택! \n" +
                                "\n" +
                                "레트로한 분위기\n" +
                                "정겨운 감성을 물씬 풍기는 인테리어! 고전적인 분위기에서 맛있는 음식을 즐길 수 있어요. \n" +
                                "\n" +
                                "추천 메뉴 - 불고기 백반\n" +
                                "불고기 백반은 정안식당의 대표 메뉴로, 고소한 불고기와 함께 제공되는 신선한 밑반찬들이 환상적인 조화를 이룹니다. 부드럽고 달콤한 불고기는 육즙 가득한 소고기를 사용하여 씹는 맛과 풍미가 뛰어나며, 입안에서 퍼지는 소스의 깊은 맛이 일품입니다.\n" +
                                "\n" +
                                "백반은 따뜻하고 고소한 밥과 함께 나와, 불고기와 다양한 밑반찬들이 어우러져 균형 잡힌 한 끼를 제공합니다. 김치, 나물, 고추장, 그리고 다양한 종류의 반찬들이 밥과 함께 제공되어, 정통 한식을 맛볼 수 있는 기회를 제공합니다.\n" +
                                "\n" +
                                "또한, 불고기 백반은 한 끼 식사로 충분히 배를 채울 수 있으며, 소고기의 풍미와 함께 다양한 반찬들을 즐길 수 있어 맛있는 한상을 경험할 수 있습니다.\n" +
                                "\n" +
                                "매일 신선한 재료로 정성껏 준비하는 불고기 백반은 그 풍부한 맛과 정성으로 고객들에게 꾸준한 인기를 끌고 있습니다. 이 곳의 불고기 백반을 맛보면, 그 맛에 푹 빠져 다시 오고 싶어질 것입니다.\n" +
                                "\n" +
                                "정안식당은 맛있는 음식과 함께 정겨운 분위기를 제공합니다. 혼밥이든 단체든 언제든지 편안하게 방문할 수 있는 곳! 전남대학교 근처에 오신다면 꼭 들러보세요!\n" +
                                "\n" +
                                " 방문하기\n" +
                                "위치: 전남대학교 호동로\n" +
                                "전화: 062-530-****\n"
                        textSize = 18f
                        setPadding(16, 16, 16, 16)
                    }
                    contentContainer.addView(textView)
                }

                "poster" -> {
                    val imageView = ImageView(this).apply {
                        setImageResource(R.drawable.sample_poster)
                        scaleType = ImageView.ScaleType.FIT_CENTER
                    }
                    contentContainer.addView(imageView)
                }

                "video" -> {
                    val videoView = VideoView(this).apply {
                        setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.sample_video}"))
                        setMediaController(MediaController(this@ContentDisplayActivity))
                        start()
                    }
                    contentContainer.addView(videoView)
                }
            }
        }, 3000) // 3000ms = 3초

        // 버튼들 그대로 유지
        findViewById<Button>(R.id.saveButton).setOnClickListener {
            Toast.makeText(this, "원본을 저장합니다!", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.postButton).setOnClickListener {
            Toast.makeText(this, "글을 SNS에 업로드합니다!", Toast.LENGTH_SHORT).show()
        }
    }
}