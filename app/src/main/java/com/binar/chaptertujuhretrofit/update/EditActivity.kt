package com.binar.chaptertujuhretrofit.update

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.binar.chaptertujuhretrofit.R
import com.binar.chaptertujuhretrofit.pojo.GetPersonsResponse
import kotlinx.android.synthetic.main.activity_edit.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class EditActivity : AppCompatActivity(), UpdatePersonPresenter.Listener {
    val presenter: UpdatePersonPresenter by inject { parametersOf(this) }
    private lateinit var result: GetPersonsResponse.Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        intent.getParcelableExtra<GetPersonsResponse.Result>("PERSON")?.let {
            result = it
        }

        etFirstName.setText(result.firstName)
        etLastName.setText(result.lastName)



        btnUpdatePerson.setOnClickListener {
            result.apply {
                firstName = etFirstName.text.toString()
                lastName = etLastName.text.toString()
            }

            presenter.updatePerson(result)
        }
    }

    override fun onUpdatePersonSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        finish()
    }

    override fun onUpdatePersonFailed(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }
}