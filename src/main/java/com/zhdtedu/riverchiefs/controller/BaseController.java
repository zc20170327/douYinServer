package com.zhdtedu.riverchiefs.controller;

import com.zhdtedu.util.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

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
            if(key.startsWith("page_number")){
                sc.setPageNo(Integer.parseInt(request.getParameter(key)));
            }
            if(key.startsWith("page_length")){
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
//
//    public ReturnMsg getReturnMsg() {
//        return new ReturnMsg();
//    }


}
