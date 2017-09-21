package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

@WebFilter("/CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {
	Logger logger = (Logger)LogManager.getLogger();
    /**
     * Default constructor. 
     */
    public CharacterEncodingFilter() {
    }
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.info("字符过滤器启动");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		chain.doFilter(request, response);
		logger.info("字符过滤器启动结束");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
