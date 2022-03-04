package br.com.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }


    private fun calculate() {
        val distanciaText = distancia.text?.toString()
        val precoText = preco.text?.toString()
        val autonomiaText = autonomia.text?.toString()

        if (distanciaText.isNullOrEmpty() || precoText.isNullOrEmpty() || autonomiaText.isNullOrEmpty()) {
            //Essa função serve para mandar uma mensgaem notificando o usuario de um erro ou algo que você queria notificar
            Toast.makeText(this, getString(R.string.preenchaTodosCampos), Toast.LENGTH_LONG).show()
            return
        }

        val distancia = distanciaText.toFloat()
        val preco = precoText.toFloat()
        val autonomia = autonomiaText.toFloat()

        if (distancia == 0f || preco == 0f || autonomia == 0f) {
            //Essa função serve para mandar uma mensgaem notificando o usuario de um erro ou algo que você queria notificar
            Toast.makeText(this, getString(R.string.notZero), Toast.LENGTH_LONG).show()
            return
        }

        val calculoFinal = (distancia * preco) / autonomia
        valorFinal.text = "R$ ${"%.2f".format(calculoFinal)}"
    }
}

