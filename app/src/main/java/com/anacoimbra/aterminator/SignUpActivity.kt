package com.anacoimbra.aterminator

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), LoginFragment.OnFragmentInteractionListener,
        PersonalDataFragment.OnFragmentInteractionListener, SelfieFragment.OnFragmentInteractionListener,
        IdFragment.OnFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        pager.adapter = SignUpAdapter(supportFragmentManager)
    }

    override fun goNext() {
        pager.currentItem = pager.currentItem + 1
    }

    override fun onError() {
        Log.e("An error occurred", "login error")
    }

    override fun onNext() {
        pager.currentItem = pager.currentItem + 1
    }

    override fun start() {
        AlertDialog.Builder(this)
                .setTitle("Escolha qual o tipo de reclamação")
                .setItems(R.array.types) { _, p1 ->
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }.show()

    }


}
