package cn.com.smart.form.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.smart.form.bean.entity.TForm;
import cn.com.smart.form.bean.entity.TFormField;
import cn.com.smart.form.dao.FormDao;
import cn.com.smart.form.dao.FormFieldDao;

import com.mixsmart.utils.CollectionUtils;
import com.mixsmart.utils.StringUtils;

/**
 * 表单设计器管理
 * @author lmq
 *
 */
@Component
public class DynamicFormManager {

	@Autowired
	private FormDao formDao;
	@Autowired
	private FormFieldDao formFieldDao;
	
	/**
	 * 处理表单字段
	 * @param entity
	 * @param datas
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> process(TForm entity, Map<String, Object> datas) {
        Map<String, String> nameMap = new HashMap<String, String>();
        if(datas == null) {
            throw new NullPointerException();
        }
        List<TFormField> fields = new ArrayList<TFormField>();
        List<String> fieldIds = new ArrayList<String>(datas.size());
        for(Map.Entry<String, Object> entry : datas.entrySet()) {
            Map<String, String> fieldInfo = (Map<String, String>)entry.getValue();
            String bindField = fieldInfo.get("bindField");
            if(StringUtils.isEmpty(bindField)) {
            	continue;
            }
            if("listctrl".equals(fieldInfo.get("leipiplugins"))) {
            	String title = fieldInfo.get("orgtitle");
            	String fieldName = fieldInfo.get("bindField");
            	if(StringUtils.isNotEmpty(title) && StringUtils.isNotEmpty(fieldName)) {
            		String[] titles = title.split("`");
            		String[] fieldNames = fieldName.split("`");
            		for (int i = 0; i < fieldNames.length; i++) {
            			TFormField field = new TFormField();
            			field.setTitle(titles[i]);
                        field.setPlugins(fieldInfo.get("leipiplugins"));
                        field.setTableId(fieldInfo.get("bindTable"));
                        field.setTableFieldId(fieldNames[i]);
                        field.setFormId(entity.getId());
                        fields.add(field);
					}
            	}
            } else {
            	String tableFieldId = fieldInfo.get("bindField");
            	TFormField field = new TFormField();
                field.setTitle(fieldInfo.get("title"));
                field.setPlugins(fieldInfo.get("leipiplugins"));
                field.setFlow(fieldInfo.get("fieldflow"));
                field.setTableId(fieldInfo.get("bindTable"));
                field.setTableFieldId(tableFieldId);
                field.setFormId(entity.getId());
                field.setType(fieldInfo.get("orgtype"));
                field.setIsInsTitle(fieldInfo.get("institle"));
                if(CollectionUtils.isEmpty(fieldIds) || !fieldIds.contains(tableFieldId)) {
                	fields.add(field);
                    nameMap.put(entry.getKey(), field.getTableFieldId());
                    fieldIds.add(tableFieldId);
                }
            }
        }//for
        entity.setFieldNum(entity.getFieldNum() + fields.size());
        if(fields.size()>0) {
        	Map<String,Object> param = new HashMap<String, Object>();
        	param.put("formId", entity.getId());
        	formFieldDao.delete(param);
        	formFieldDao.save(fields);
        }
        return nameMap;
    }
}
