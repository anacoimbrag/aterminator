package com.anacoimbra.aterminator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ReceiptFragment.OnFragmentInteractionListener,
        FactFragment.OnFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager.adapter = MainAdapter(supportFragmentManager)
    }

    override fun onNext() {
        pager.currentItem = pager.currentItem + 1
    }

    override fun onComplete() {
        AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("Atenção!")
                .setMessage("Eu me comprometo que os documentos anexados são verdadeiros, e me responsabilizo sob as penas da lei.")
                .setPositiveButton("Concordo") { d, _ -> showSendDeal();  d.dismiss() }
                .setNegativeButton("Cancelar") { d, _ -> showNotPssible(); d.dismiss() }
                .show()
    }

    private fun showNotPssible() {
        AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("Ops!")
                .setMessage("Não será possível continuar o procedimento.")
                .setPositiveButton("Ok") { d, _ ->  d.dismiss() }
                .show()
    }

    private fun showSendDeal() {
        AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("Acordo")
                .setMessage("Você gostaria de tentar um acordo com a outra parte antes de enviar para o juizado, com um prazo de 30 dias para resposta?")
                .setPositiveButton("Quero") { d, _ -> showSuccess();  d.dismiss() }
                .setNegativeButton("Não quero") { d, _ -> showSuccess(); d.dismiss() }
                .show()
    }

    private fun showSuccess() {
        AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("Pronto!")
                .setMessage("Pedimos que aguarde um período de 24h para avaliação da documentação e, com tudo certo, daremos continuação ao processo. ")
                .setPositiveButton("Ok") { d, _ ->  d.dismiss(); finish() }
                .show()
    }
}
