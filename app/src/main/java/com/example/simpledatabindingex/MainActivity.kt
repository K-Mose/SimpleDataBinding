package com.example.simpledatabindingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.simpledatabindingex.databinding.ActivityMainBinding

/**
 * findViwById는 Runtime에 맞는 레이아웃을 찾아서
 * 애플리케이션의 규모가 커질 수록 성능을 저하시킨다.
 *
 * DataBinding은 binding 객체를 생성하여서 View의 모든 구성요소를
 * Binding 객체를 통해여서 접근 가능하게 한다.
 * DataBinding은 Compiletime에 생성되기 떄문에 코드작성 시에 에러를 확인 할 수 있다.
 *
 * 데이터 바인딩 하기 위해
 * app level의 gradle 파일에서 Enable data binding
 * xml 파일을 layout 태그로 warp
 * databinding object 생성
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(R.layout.activity_main)

        binding.btnSubmit.setOnClickListener {
            displayGreeting()
        }
    }

    private fun displayGreeting() {

        binding.greetingTextView.text = "Hello! " + binding.etNameText.text
    }
}