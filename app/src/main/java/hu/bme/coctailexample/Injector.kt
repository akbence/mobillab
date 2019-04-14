package hu.bme.coctailexample

import android.app.Activity
import android.support.v4.app.Fragment


val Activity.injector: CoctailExampleApplicationComponent
    get() {
        return (this.applicationContext as CoctailExampleApplication).injector
    }

val Fragment.injector: CoctailExampleApplicationComponent
    get() {
        return (this.context!!.applicationContext as CoctailExampleApplication).injector
    }
