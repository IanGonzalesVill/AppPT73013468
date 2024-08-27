package com.idat.apppt73013468.auth.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.idat.apppt73013468.auth.data.Paciente
import com.idat.apppt73013468.auth.viewmodel.LoginViewModel
import com.idat.apppt73013468.core.bd.PacienteEntity
import com.idat.apppt73013468.core.model.PacienteModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    modifier: Modifier,
    navigateToHome: () -> Unit = {},
    loginViewModel: LoginViewModel = viewModel()
) {
    var codpaciente by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val listaPacientes = listOf(
        Paciente("123", "pass123", "Juan Perez", "123456789"),
        Paciente("456", "pass456", "Maria Lopez", "987654321"),
        Paciente("789", "pass789", "Carlos Gomez", "456123789")
    )
    val coroutineScope = rememberCoroutineScope()
    var loginError by remember { mutableStateOf(false) }

    loginViewModel.uiState

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = codpaciente,
            onValueChange = { codpaciente = it },
            label = { Text("Código de Paciente") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val pacienteEncontrado = listaPacientes.find {
                    it.codpaciente == codpaciente && it.password == password
                }

                if (pacienteEncontrado != null) {
                    Log.i("test-pacienteEncontrado", "Paciente encontrado: $pacienteEncontrado")
                    val codigoUnico = Math.random().toInt() // temporal profe :'v luego se mete una id verdadera
                    val pacienteModel = PacienteModel(
                        //id = codigoUnico,
                        codpaciente = pacienteEncontrado.codpaciente,
                        password = pacienteEncontrado.password,
                        nombreapellido = pacienteEncontrado.nombreapellido,
                        celular = pacienteEncontrado.celular
                    )
                    coroutineScope.launch {
                        loginViewModel.onPacienteCreated(pacienteModel)
                    }

//                    coroutineScope.launch {
//                        loginViewModel.addPacient(
//                            codpaciente = pacienteEncontrado.codpaciente,
//                            password = pacienteEncontrado.password,
//                            nombreapellido = pacienteEncontrado.nombreapellido,
//                            celular = pacienteEncontrado.celular
//                        )
//                    }
                    navigateToHome()
                } else {
                    loginError = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        if (loginError) {
            Text(
                text = "Código de Paciente o Password incorrectos",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}
