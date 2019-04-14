package hu.bme.coctailexample


import android.app.Application
import hu.bme.coctailexample.ui.UIModule

class CoctailExampleApplication : Application() {
    lateinit var injector: CoctailExampleApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerCoctailExampleApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}
