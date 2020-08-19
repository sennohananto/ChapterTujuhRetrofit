package com.binar.chaptertujuhretrofit.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.binar.chaptertujuhretrofit.R
import kotlinx.android.synthetic.main.activity_add_person.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class AddPersonActivity : AppCompatActivity(), AddPersonPresenter.Listener {

    val presenter: AddPersonPresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)

        btnAddPerson.setOnClickListener {
            presenter.addPerson(etFirstName.text.toString(), etLastName.text.toString())
        }
    }

    override fun onAddPersonSuccess(successMessage: String) {
        Toast.makeText(this, successMessage, Toast.LENGTH_LONG).show()
        finish()
    }

    override fun onAddPersonFailure(failureMessage: String) {
        Toast.makeText(this, failureMessage, Toast.LENGTH_LONG).show()
        finish()
    }
}