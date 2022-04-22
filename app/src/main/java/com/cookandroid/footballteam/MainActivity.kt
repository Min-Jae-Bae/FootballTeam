package com.cookandroid.footballteam

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


/*
* 무작위로 축구 팀을 보여주는 앱
* */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            rollTeam()
        }
    }
/*
* 무작위로 굴리고 스크린에 결과 이미지를 보여준다
* */
    private fun rollTeam() {
        // 3개의 무작위 팀 객체를 생성하고 굴린다
        val team = Team(3)
        val rollteam = team.roll()

        // 이미지를 스크린에 보여준다.
        val rollImage: ImageView = findViewById(R.id.imageView)

        val drawalbeResource = when (rollteam) {
            1 -> R.drawable.arsenal
            2 -> R.drawable.manchester_united
            else -> R.drawable.southhampton
        }

        // ID 자원 그림을 올바르게 이미지에 업데이트 한다.
        rollImage.setImageResource(drawalbeResource)

        // 내용 설명을 보여준다.
        rollImage.contentDescription = rollteam.toString()
    }
}


class Team(val number: Int) {
    fun roll(): Int {
        return (1..number).random()

    }
}