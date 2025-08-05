package com.example.estadounicda20

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {
    var loading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)
    private val auth = FirebaseAuth.getInstance()

    fun login(email: String, password: String, onSuccess: () -> Unit) {
        loading = true
        errorMessage = null
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                loading = false
                if (task.isSuccessful) {
                    onSuccess()
                } else {
                    errorMessage = task.exception?.message
                }
            }
    }

    fun register(email: String, password: String, onSuccess: () -> Unit) {
        loading = true
        errorMessage = null
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                loading = false
                if (task.isSuccessful) {
                    onSuccess()
                } else {
                    errorMessage = task.exception?.message
                }
            }
    }
}
