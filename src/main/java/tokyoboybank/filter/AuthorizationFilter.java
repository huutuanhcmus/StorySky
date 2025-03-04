package tokyoboybank.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tokyoboyband.model.UserModel;
import tokyoboyband.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

	private ServletContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if (url.startsWith(request.getContextPath() + "/admin")) {
            UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
            if (model != null) {
                if (model.getRoleid() == 2l) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (model.getRoleid() == 1) {
                    response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");
                }
            } else {
                response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");
            }
        }
        else if (url.startsWith(request.getContextPath() + "/ke-sach") || url.startsWith(request.getContextPath() + "/danh-sach-tap-truyen")|| url.startsWith(request.getContextPath() + "/chinh-sua-tap-truyen") || url.startsWith(request.getContextPath() + "/chinh-sua")|| url.startsWith(request.getContextPath() + "/xoa-truyen")|| url.startsWith(request.getContextPath() + "/them-tap-truyen")|| url.startsWith(request.getContextPath() + "/xoa-tap-truyen")) {
            UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
            if (model != null) {
                    filterChain.doFilter(servletRequest, servletResponse);
                
            } else {
                response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        
	}
	@Override
	public void destroy() {
		

	}

}
