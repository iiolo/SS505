package com.seoulWomenTech.ss505

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulWomenTech.ss505.databinding.FragmentCPIBinding

class CPIFragment : Fragment() {
    lateinit var fragmentCPIBinding: FragmentCPIBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        fragmentCPIBinding = FragmentCPIBinding.inflate(layoutInflater)
        mainActivity = activity as MainActivity

        val cpiChallenge = ChallengeDAO.selectData(mainActivity,mainActivity.rowPosition)

        fragmentCPIBinding.run {
            toolbarCPI.run{
                title = "Safety Seoul"

                setNavigationIcon(R.drawable.menu_24)
                setNavigationOnClickListener {
                    // 네비게이션 뷰를 보여준다.

                }

                inflateMenu(R.menu.menu_main)
            }
            CPITitle.text = cpiChallenge.name
            CPIDate.append("${cpiChallenge.progDate} ${cpiChallenge.progTime}")
            CPIMaxUser.append("${cpiChallenge.maxUser}명")
//            CPILocation.append(cpiChallenge.)
            CPIContent.append(cpiChallenge.content)
        }

        return fragmentCPIBinding.root


    }

}