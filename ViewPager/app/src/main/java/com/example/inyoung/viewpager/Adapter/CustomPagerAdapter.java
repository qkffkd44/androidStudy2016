package com.example.inyoung.viewpager.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Inyoung on 2016-06-11.
 */
/*CustomPagerAdapter는 MainActivity에 있는 클래스를 따로 외부 클래스로 정의한것
* 화면 전환 방법에서 기존의 Activity가 이동하거나 intent를 통해서 데이터를 전달하는 방식이아니라
* Fragment라는 View를 만들어서 필요할때마다 Activity위에 새로운 View를 교체하는 방식으로 변화
* 그때 Viewpager와 Fragment View를 연결 시키고관리하는 클래스가 CustomPagerAdapter이다*/

public class CustomPagerAdapter extends FragmentPagerAdapter {

    private  static int PAGE = 3;

    private ArrayList<Fragment> list_fragment;

    //타이틀(프레그먼트 이름들)을 관리하는
    private ArrayList<String> list_title;

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);

        list_fragment = new ArrayList<Fragment>(1);
        list_title = new ArrayList<String>(1);

    }

    //어렵다... 11시 35분
    public void addFragment(Fragment fr, String title){
        this.list_fragment.add(fr);
        this.list_title.add(title);
    }


    //생선된 객체 Fragment를 반환 한다. 포지션은 0번째 1번째
    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    //총 Fragment 화면의 갯수가 몇개인지
    @Override
    public int getCount() {
        return PAGE;
    }

    @Override // charsequence = String 위에 타이틀을 뭐줄지 해당 페이지에 맞춰서
    public CharSequence getPageTitle(int position) {
        return list_title.get(position);
    }
}
