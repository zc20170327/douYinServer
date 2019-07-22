package com.zhdtedu.riverchiefs.controller;

import com.zhdtedu.util.ReturnMsg;
import com.zhdtedu.util.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BaseController {

    @Autowired
    public HttpServletRequest request;

   /* protected EcUser getUserInfo(){
        Visit v = (Visit) request.getSession().getAttribute("VISIT");
        return (EcUser) v.getLoginUser();
    }

    protected EcOrgInfo getEcOrgInfo(){
        Visit v = (Visit) request.getSession().getAttribute("VISIT");
        return (EcOrgInfo) v.getLoginOrg();
    }
*/

    protected SearchCondition getSearchCondition(){
        SearchCondition sc = new SearchCondition(this.request);
//        sc.setUser(this.getUserInfo());
//        sc.setOrgInfo(this.getEcOrgInfo());
        StringBuffer sb = new StringBuffer();
        for (Iterator<?> i = this.request.getParameterMap().keySet().iterator(); i
                .hasNext();) {
            String key = (String) i.next();
            if(key.startsWith("sort")){
                sb.append(request.getParameter(key)+" ");
            }
            if(key.startsWith("order")){
                sb.append(request.getParameter(key));
            }
            if(key.startsWith("pageNo")){
                sc.setPageNo(Integer.parseInt(request.getParameter(key)));
            }
            if(key.startsWith("pageSize")){
                sc.setPageSize(Integer.parseInt(request.getParameter(key)));
            }
        }
        sc.setOrderBy(sb.toString());
        sc.getParameter().put("orderBy",sb.toString());
        return sc;
    }


//    public ReqParam getReqParam(Map<String, Object> param){
//        return new ReqParam(param);
//    }

    public ReturnMsg getReturnMsg() {
        return new ReturnMsg();
    }

    public void testRequestBodyParame(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Set<Map.Entry<String, String[]>> keSet = map.entrySet();
        for (Iterator<Map.Entry<String, String[]>> itr = keSet.iterator(); itr.hasNext();) {
            Map.Entry me = (Map.Entry) itr.next();
            Object ok = me.getKey();
            Object ov = me.getValue();
            String[] value = new String[1];
            if (ov instanceof String[]) {
                value = (String[]) ov;
            } else {
                value[0] = ov.toString();
            }
            for (int k = 0; k < value.length; k++) {
                System.out.println("************" + ok + "************" + value[k]);
            }
        }
    }


}
