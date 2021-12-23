package com.serglife.movie.presentation.ui.login.reg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.serglife.movie.R
import com.serglife.movie.data.database.AUTH
import com.serglife.movie.databinding.FragmentRegLoginBinding


class RegLoginFragment : Fragment() {
    private lateinit var binding: FragmentRegLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentRegLoginBinding.inflate(layoutInflater).also{binding = it}.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentUser = AUTH.currentUser
        if(currentUser != null){
            binding.registration.setOnClickListener {
                registerUser()
            }
        }
    }


    private fun registerUser() {
        val email = binding.regEmail.text.toString().trim()
        val password = binding.regPassword.text.toString().trim()

        if(isValidEmailAndPassport(email,password)){
            registerUserToFireBase(email,password)

        }else{
            Toast.makeText(context,"Not valid", Toast.LENGTH_SHORT).show()
        }
    }

    private fun registerUserToFireBase(email: String, password: String) {
        AUTH.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context,"You are logged in.", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.moviesFragment)

                } else {
                    Toast.makeText(context, task.exception?.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun isValidEmailAndPassport(email: String, password: String): Boolean {
        return email.isNotBlank() && password.isNotBlank()
    }

}