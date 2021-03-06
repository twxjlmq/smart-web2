package cn.com.smart.web.tag.bean;

import cn.com.smart.web.constant.enums.BtnPropType;

import com.mixsmart.utils.StringUtils;


/**
 * 自定义按钮
 * @author lmq
 *
 */
public class CustomBtn extends BaseBtn {
	
	protected String title;
	
	protected String width="600";
	
	protected String btnIcon="glyphicon-plus";
	
	protected String paramName = "id";
	
	
	/**
	 * 选择类型
	 * none-selected -- 不用选中数据(默认)
	 * one-selected -- 只能选中一条数据
	 * multi-selected -- 多选（一条或一条以上）
	 */
	protected String selectedType = BtnPropType.SelectType.NONE.getValue();
	
	protected String openStyle = BtnPropType.OpenStyle.OPEN_POP.getValue();
	
	protected String beforeCheck;
	
	public CustomBtn(String id,String title,String name,String uri) {
		this.id = id;
		this.title = StringUtils.isEmpty(title)?name:title;
		this.name = name;
		this.uri = uri;
	}
	
	public CustomBtn(String id,String title,String name,String uri,String btnIcon) {
		this.id = id;
		this.title = StringUtils.isEmpty(title)?name:title;
		this.name = name;
		this.uri = uri;
		this.btnIcon = btnIcon;
	}
	
	public CustomBtn(String id,String title,String name,String uri,String btnIcon,String selectedType) {
		this.id = id;
		this.title = StringUtils.isEmpty(title)?name:title;
		this.name = name;
		this.uri = uri;
		this.btnIcon = btnIcon;
		this.selectedType = selectedType;
	}
	
	public CustomBtn(String id,String title,String name,String uri,String btnIcon,String selectedType,String paramName) {
		this.id = id;
		this.title = StringUtils.isEmpty(title)?name:title;
		this.name = name;
		this.uri = uri;
		this.btnIcon = btnIcon;
		this.paramName = paramName;
		this.selectedType = selectedType;
	}
	
	public CustomBtn(String id,String title,String name,String uri,String width,String btnIcon,String selectedType,String btnStyle,String paramName) {
		this.id = id;
		this.title = StringUtils.isEmpty(title)?name:title;
		this.name = name;
		this.uri = uri;
		this.width = width;
		this.btnIcon = btnIcon;
		this.btnStyle = btnStyle;
		this.paramName = paramName;
		this.selectedType = selectedType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getBtnIcon() {
		return btnIcon;
	}

	public void setBtnIcon(String btnIcon) {
		this.btnIcon = btnIcon;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getSelectedType() {
		return selectedType;
	}

	public void setSelectedType(String selectedType) {
		this.selectedType = selectedType;
	}

	public String getOpenStyle() {
		return openStyle;
	}

	public void setOpenStyle(String openStyle) {
		this.openStyle = openStyle;
	}

	public String getBeforeCheck() {
		return beforeCheck;
	}

	public void setBeforeCheck(String beforeCheck) {
		this.beforeCheck = beforeCheck;
	}

}
