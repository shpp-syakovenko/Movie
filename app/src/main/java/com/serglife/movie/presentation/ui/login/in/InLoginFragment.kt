package com.serglife.movie.presentation.ui.login.`in`

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.serglife.movie.R
import com.serglife.movie.data.database.AUTH
import com.serglife.movie.databinding.FragmentInLoginBinding

class InLoginFragment : Fragment() {

    private lateinit var binding: FragmentInLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentInLoginBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToRegister()

        binding.inLogin.setOnClickListener {
            singInUser()
        }

    }

    private fun singInUser() {
        val email = binding.inEmail.text.toString().trim()
        val password = binding.inPassword.text.toString().trim()

        if (isValidEmailAndPassport(email, password)) {
            singInUserToFireBase(email, password)
        } else {
            Toast.makeText(context, "Not valid", Toast.LENGTH_SHORT).show()
        }
    }

    private fun singInUserToFireBase(email: String, password: String) {
        AUTH.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "You are logged in.", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.moviesFragment)
                } else {
                    Toast.makeText(context, task.exception?.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }

    private fun goToRegister() {
        binding.inRegistration.setOnClickListener {
            findNavController().navigate(InLoginFragmentDirections.actionInLoginFragmentToRegLoginFragment())
        }
    }

    private fun isValidEmailAndPassport(email: String, password: String): Boolean {
        return email.isNotBlank() && password.isNotBlank()
    }

}