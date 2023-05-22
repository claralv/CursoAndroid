package com.example.cursostech

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cursostech.databinding.ActivityDatosBinding
import com.example.cursostech.databinding.ActivityMainBinding

class DatosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Intent llamada a número de teléfono
        binding.cardtelefono.setOnClickListener {
            val intent2= Intent(Intent.ACTION_DIAL, Uri.parse("tel:687000330"))
            startActivity(intent2)
        }

        //Intent correo electrónico
        binding.cardcorreo.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:lagunas.informatica@gmail.com"))
            startActivity(intent)
        }

        //Botón ENVIAR formulario
        binding.button2.setOnClickListener {

            //Validaciones de los campos
            if(binding.editTextNombre.text.isNotEmpty() && binding.editTextTelefono.text.isNotEmpty() && binding.editTextTextCorreo.text.isNotEmpty()
                && binding.TextoCorreo.text.isNotEmpty()  && binding.checkBox.isChecked)  {
                val correo= binding.editTextTextCorreo.text.toString()
                val comentario = binding.editTextComentario.text.toString()

                //Intent envío de los datos del formulario por correo
                val intent3 = Intent(Intent.ACTION_SEND)

                intent3.putExtra(Intent.EXTRA_EMAIL, arrayOf(correo))
                intent3.putExtra(Intent.EXTRA_SUBJECT, "Prueba")
                intent3.putExtra(Intent.EXTRA_TEXT,comentario)
                intent3.type= "message/rfc822"
                startActivity(Intent.createChooser(intent3,"Elige cliente de correo"))


            } else  {
                Toast.makeText(this, "Algún campo está vacío",Toast.LENGTH_LONG).show()

            }
        }

    }
}