package io.smallant.baseclasses.ui

import android.os.Bundle
import android.support.design.widget.NavigationView

/**
 * Created by jpannetier on 11/08/2017.
 */
abstract class BaseNavigationDrawerActivity : BaseDrawerActivity() {

    abstract val navigationView: NavigationView
    abstract fun onDrawerItemClicked(itemId: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDrawerContent()
    }

    fun initDrawerContent() {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            onDrawerItemClicked(menuItem.itemId)
            menuItem.isChecked = true
            drawerView.closeDrawers()
            true
        }
    }
}