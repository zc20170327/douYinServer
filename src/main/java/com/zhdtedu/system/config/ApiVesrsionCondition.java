package com.zhdtedu.system.config;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * api条件处理类
 * 自定义条件筛选器，让SpringMVC在原有逻辑的基本上
 * 添加一个版本号匹配的规则
 *
 */
public class ApiVesrsionCondition implements RequestCondition<ApiVesrsionCondition> {
    // 路径中版本的前缀， 这里用 /v[1-9]/的形式
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");

    private int apiVersion;

    public ApiVesrsionCondition(int apiVersion){
        this.apiVersion = apiVersion;
    }

    public ApiVesrsionCondition combine(ApiVesrsionCondition other) {
        // 采用最后定义优先原则，则方法上的定义覆盖类上面的定义
        return new ApiVesrsionCondition(other.getApiVersion());
    }

    public ApiVesrsionCondition getMatchingCondition(HttpServletRequest request) {
        String uri = request.getRequestURI();
        System.out.println("=======request.getRequestURI()======"+uri);
        Matcher m = VERSION_PREFIX_PATTERN.matcher(uri);//
        if(m.find()){
            Integer version = Integer.valueOf(m.group(1));
            if(version >= this.apiVersion) {// 如果请求的版本号大于配置版本号， 则满足
                System.out.println("=====version===="+version);
                System.out.println("====this.apiVersion======"+this.apiVersion);
                return this;
            }
        }
        return null;
    }

    public int compareTo(ApiVesrsionCondition other, HttpServletRequest request) {
        // 优先匹配最新的版本号
        return other.getApiVersion() - this.apiVersion;
    }

    public int getApiVersion() {
        return apiVersion;
    }
}

