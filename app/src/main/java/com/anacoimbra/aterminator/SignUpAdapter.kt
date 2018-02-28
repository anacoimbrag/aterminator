package com.anacoimbra.aterminator

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by aninh on 02/25/2018.
 */
class SignUpAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val fragments = arrayListOf(LoginFragment.newInstance(), PersonalDataFragment.newInstance(),
            SelfieFragment.newInstance(), IdFragment.newInstance())

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}