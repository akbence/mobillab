package hu.bme.coctailexample.ui.coctails

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import hu.bme.coctailexample.R
import hu.bme.coctailexample.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_coctails.*

class CoctailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coctails)
        setSupportActionBar(toolbar)
        supportFragmentManager.beginTransaction().replace(R.id.fragment, CoctailsFragment.newInstance(intent.getStringExtra(MainActivity.KEY_COCTAILS))).commit()
        fab.setOnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
    }
}