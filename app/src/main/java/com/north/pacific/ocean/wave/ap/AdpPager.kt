package com.north.pacific.ocean.wave.ap

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AdpPager(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var listOfPages = listOf<Fragment>()

    fun setPages(listOfPages: List<Fragment>) {
        this.listOfPages = listOfPages
    }

    override fun getCount() = listOfPages.size

    override fun getItem(position: Int) = listOfPages[position]

}