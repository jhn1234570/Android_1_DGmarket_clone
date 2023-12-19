package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.carrotmarket.databinding.ActivitySignupBinding
import com.example.carrotmarket.remote.AuthService
import com.example.carrotmarket.remote.SignUpView

class SignupActivity : AppCompatActivity(), SignUpView {

    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupButtonBackground.setOnClickListener {
            val id = binding.etEmailInput.text.toString()
            val pw = binding.etPasswordInput.text.toString()
            val name = binding.etNicknameInput.text.toString()
            val authService = AuthService()
            authService.setSignUpView(this) // SignUpView 초기화 하는 것. this는 나 자신(SignupActivity) 을 뜻하며, Appcompact, SignUp을 상속받은 나를 넣어준다는 의미
            authService.signUp(id,pw,name) // authService에 signUp메서드 호출하고 파싱한 값들 집어넣는 과정
                                        // 아까만든 AuthService 호출함. String으로 파싱한 데이터가 넘어가는 과정
        }
    }

    override fun SignUpLoading() {
        //lodaing progress bar 보여주기

    }

    override fun SignUpSuccess(resp) {
        Toast.makeText(this,"회원가입 성공, 해당 계정으로 로그인 해라",Toast.LENGTH_SHORT).show()
        onBackPressed()
        binding.etPasswordInput = resp.text
    }

    override fun SignUpFaliure(code: Int, msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}