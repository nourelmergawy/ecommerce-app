package com.mrg.ecommerceapp.Fragments.Authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.github.dhaval2404.imagepicker.ImagePicker
import com.mrg.ecommerceapp.ViewModel
import com.mrg.ecommerceapp.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
  private lateinit var binding: FragmentSignUpBinding
    private lateinit var etEmail: EditText
    private lateinit var etpassword : EditText
    private lateinit var etusername : EditText
    private lateinit var signUpBtn : Button
    private lateinit var profileImg : ImageButton
    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater)

        //binding views
        etEmail = binding.emailItem
        etpassword = binding.passwordItem
        signUpBtn = binding.signupBtn
        etusername = binding.userItem
        profileImg= binding.imgPicker

        profileImg.setOnClickListener {
            ImagePicker.with(this)
                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)
                .start()
        }

        signUpBtn.setOnClickListener {
            var email :String= etEmail.text.toString()
            var password : String = etpassword.text.toString()
            viewModel.fireBaseSignUpAuth(email,password,this,activity?.applicationContext!!)

            }

        return binding.root
    }


}