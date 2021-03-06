package cn.com.smart.filter.bean;

import java.util.Map;

/**
 * 参数过滤接口
 * @author lmq
 * @version 1.0
 * @since 1.0
 * 2015年8月22日
 */
public interface IFilterParam {

	/**
	 * 参数边字符串
	 * @param varName
	 * @return String
	 */
	public String getParamToString(String varName);

	/**
	 * 转换为Map
	 * @return
	 */
	public Map<String, Object> toMap();
}
