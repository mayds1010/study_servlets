package com.yojulab.study_servlets;

import java.util.ArrayList;
import java.util.HashMap;

import com.yojulab.beans.MemberBean;

public class DatasInfor {

    // search 인풋
    public HashMap<String, String> getSearchFormData() {

        HashMap<String, String> searchForm = new HashMap<String, String>();
        searchForm.put("search_key", "Search Title");
        searchForm.put("name", "김다솜!");
        searchForm.put("id", "ID0001");
        return searchForm;
    }

    // 테이블
    public ArrayList<String> getTablesListWithString() {
        ArrayList<String> tablesListWithString = new ArrayList<String>();
        tablesListWithString.add("@mdo");
        tablesListWithString.add("@fat");
        tablesListWithString.add("@twitter");
        return tablesListWithString;
    }

    // 다른유형 합치기
    public HashMap<String, Object> getBundlesData() {
        DatasInfor datasInfor = new DatasInfor();
        HashMap<String, String> searchForm = datasInfor.getSearchFormData();
        ArrayList<String> tablesListWithString = datasInfor.getTablesListWithString();

        // 앞에만 제대로 선언하면 가능. 둘 데이터를 합침
        HashMap<String, Object> bundlesData = new HashMap<>();
        // 키는 다른이름 가능
        bundlesData.put("searchForm", searchForm);
        bundlesData.put("tablesListWithString", tablesListWithString);

        bundlesData.put("dataWithMemberBean",datasInfor.getDataWithMemberBean());
        bundlesData.put("dataListWithMemberBean",datasInfor.getDataListWithMemberBean());

        return bundlesData;
    }

    public MemberBean getDataWithMemberBean(){
        MemberBean memberBean = new MemberBean();
        memberBean.setFirstName("Mark");
        memberBean.setSecondName("Otto");
        memberBean.setHandleName("@mdo");

        return memberBean;
    }

 public ArrayList<MemberBean> getDataListWithMemberBean(){
    ArrayList<MemberBean> membersList = new ArrayList<>(); 
    MemberBean memberBean = new MemberBean();
    memberBean.setFirstName("Mark");
    memberBean.setSecondName("Otto");
    memberBean.setHandleName("@mdo");
    membersList.add(memberBean);

    MemberBean memberBean02 = new MemberBean();
    memberBean02.setFirstName("jacob");
    memberBean02.setSecondName("Thornton");
    memberBean02.setHandleName("@mfat");
    membersList.add(memberBean02);

    MemberBean memberBean03 = new MemberBean();
    memberBean03.setFirstName("Larry");
    memberBean03.setSecondName("Bird");
    memberBean03.setHandleName("@twitter");
    membersList.add(memberBean03);

    return membersList;
 }
}
