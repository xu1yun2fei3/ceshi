package com.xuyunfei.MySpring;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ObjectOutput;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/*
* spring ioc 原理
* xml解析
* 反射
* */
public class MyApplicationContext {

    /*
    * XML解析,将xml解析为XMLDTO类
    *
    * param:path
    * return:List<XMLDTO>
    */
    public List<XMLDTO> parseXML(String path) throws Exception{
        List<XMLDTO> xmldtos = new ArrayList<>();
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read("SpringBase\\src\\main\\resources\\"+path);
        Element rootElement = doc.getRootElement();
        //bean
        Iterator<Element> iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            XMLDTO xmldto = new XMLDTO();
            //获取bean节点列表 取到id 和 class
            Element note = iterator.next();
            xmldto.setId(note.attributeValue("id"));
            xmldto.setClazz(note.attributeValue("class"));
            //property
            //获取 property 的节点列表 取到 name和value
            Iterator<Element> properties = note.elementIterator();
            List<Map<String,String>> propertylist = new ArrayList<>();
            while (properties.hasNext()) {
                Map<String,String> property = new HashMap<>();
                Element element =  properties.next();
                property.put("name",element.attributeValue("name"));
                property.put("value",element.attributeValue("value"));
                propertylist.add(property);
            }
            xmldto.setProperties(propertylist);
            xmldtos.add(xmldto);
        }
        return xmldtos;
    }

    //根据配置文件xml 创建对象
    public void createObject(List<XMLDTO> xmldtos) throws Exception{
        for (XMLDTO xmldto : xmldtos) {
            //获取类名,创建对象
            String clazz = xmldto.getClazz();
            Class cls = Class.forName(clazz);
            Object o = cls.getConstructor(null).newInstance(null);
            //给属性赋值
            List<Map<String, String>> properties = xmldto.getProperties();
            for (Map<String, String> property : properties) {
                callSetter(o,property,cls);
            }
            //存储对象
            ioc.put(xmldto.getId(),o);
        }
    }

    public Object getBean(String id){

        return ioc.get(id);
    }


    //调用set方法给属性赋值
    public void callSetter(Object object,Map<String,String> map,Class cls) throws Exception{
        String name = map.get("name");
        String value = map.get("value");
        //获取set方法名 如 id -> setId(Interger id)
         String methodName = "set"+ name.substring(0,1).toUpperCase()+name.substring(1);
        //获取方法
        Field declaredField = cls.getDeclaredField(name);
        Method method = cls.getMethod(methodName,declaredField.getType());
        //值的类型转换
        Object val = null;
        switch (declaredField.getType().getName()){
            case "java.lang.Integer":
                val = Integer.parseInt(value);break;
            case "java.lange.Double":
                val = Double.parseDouble(value);break;
            case "java.lang.String":
                val = value;break;
        }
        //调用方法名
        method.invoke(object,val);
    }


    //构建容器
    Map<String,Object> ioc = new HashMap<>();

    public MyApplicationContext(String path){
        try {
            List<XMLDTO> xmldtos = parseXML(path);
            createObject(xmldtos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
