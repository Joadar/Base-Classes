package io.smallant.baseclasses.ui

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import com.example.baseclasses.R

/**
 * Created by jpannetier on 11/08/2017.
 */
abstract class BaseDrawerActivity : BaseActivity() {

    lateinit var drawerToggle: ActionBarDrawerToggle

    abstract val drawerView: DrawerLayout
    abstract val containerView: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupToggle()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawerView.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupToggle() {
        drawerToggle = object : ActionBarDrawerToggle(this, drawerView, R.string.drawer_open, R.string.drawer_close) {
            override fun onDrawerClosed(view: View) {
                invalidateOptionsMenu()
            }

            override fun onDrawerOpened(drawerView: View) {
                invalidateOptionsMenu()
            }
        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerView.addDrawerListener(drawerToggle)
    }

    protected fun replaceFragmentContainer(newFragment: Fragment) {
        val fragmentContainer = supportFragmentManager.findFragmentById(containerView)
        if (fragmentContainer != null)
            supportFragmentManager
                    .beginTransaction()
                    .replace(containerView, newFragment)
                    .commitNow()
    }

}