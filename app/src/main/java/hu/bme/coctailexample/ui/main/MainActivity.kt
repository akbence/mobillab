package hu.bme.coctailexample.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import hu.bme.coctailexample.R
import hu.bme.coctailexample.injector
import hu.bme.coctailexample.ui.coctails.CoctailsActivity

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),MainScreen {
    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(this)

        btnShowArtists.setOnClickListener { mainPresenter.showArtistsSearchList(etCoctails.text.toString()) }
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }

    override fun showCoctails(artistSearchTerm: String) {
        val intent = Intent(this, CoctailsActivity::class.java)
        intent.putExtra(KEY_ARTIST, artistSearchTerm)
        startActivity(intent)
    }

    companion object {
        const val KEY_ARTIST = "KEY_ARTIST"
    }
}
