package com.slasher.apigateway.common;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤器类型。决定过滤器在请求的哪个生命周期中执行，这里定义为pre、routing、post、error
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序，存在多个过滤器时，根据方法返回的值依次执行，数值越小优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否被执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        log.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());

        Object token = request.getParameter("accessToken");

        if (token == null){
            log.warn("access token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");
        return null;

    }
}
