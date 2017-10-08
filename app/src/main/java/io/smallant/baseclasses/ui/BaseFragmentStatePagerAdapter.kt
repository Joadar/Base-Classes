package io.smallant.baseclasses.ui

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager


/**
 * Created by jpannetier on 10/08/2017.
 */
class BaseFragmentStatePagerAdapter<F : BaseFragment>(manager: FragmentManager) :
        FragmentStatePagerAdapter(manager),
        ViewPager.OnPageChangeListener {

    var isSwiped = false

    private val fragments: ArrayList<F> = arrayListOf()
    private val fragmentTitles: ArrayList<String> = arrayListOf()

    private var clearInProgress = false

    override fun getPageTitle(position: Int) = fragmentTitles[position]

    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

    override fun getItemPosition(obj: Any?): Int {
        if (clearInProgress) {
            return PagerAdapter.POSITION_NONE
        } else if (fragments.contains(obj)) {
            return fragments.indexOf(obj)
        } else {
            return PagerAdapter.POSITION_NONE
        }
    }

    override fun onPageScrollStateChanged(state: Int) {
        if (ViewPager.SCROLL_STATE_DRAGGING == state) {
            isSwiped = true
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageSelected(position: Int) {}

    fun addFragment(fragment: F, title: String) {
        fragments.add(fragment)
        fragmentTitles.add(title)
        notifyDataSetChanged()
    }

    fun clear() {
        clearInProgress = true
        for (i in fragments.size - 1 downTo 0) {
            destroyItem(null, i, fragments[i])
            fragments.removeAt(i)
        }
        fragmentTitles.clear()
        clearInProgress = false
        notifyDataSetChanged()
    }

}