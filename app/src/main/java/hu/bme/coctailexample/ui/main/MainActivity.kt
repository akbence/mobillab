package hu.bme.coctailexample.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import hu.bme.coctailexample.R
import hu.bme.coctailexample.injector
import hu.bme.coctailexample.ui.coctails.CoctailsActivity

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),MainScreen {
    override fun showNetworkError(coctailSearchTerm: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(this)

        btnShowArtists.setOnClickListener { mainPresenter.showCoctailsSearchList(etCoctails.text.toString()) }
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
        mainPresenter.refreshCoctails();
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }

    override fun showCoctails(coctailSearchTerm: String) {
        val intent = Intent(this, CoctailsActivity::class.java)
        intent.putExtra(KEY_ARTIST, coctailSearchTerm)
        startActivity(intent)
    }

    companion object {
        const val KEY_ARTIST = "KEY_ARTIST"
    }
}
