package co.com.utility;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



public class ConvertObject {

	private ObjectMapper mapper;
	private static final String HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";

	public ConvertObject() {
		mapper = new ObjectMapper();
	}

	@SuppressWarnings("unchecked")
	public <T> T jsonToObject(String json, Class<?> name) throws IOException {
		if (name == null || name.isInstance("String"))
			return (T) json;
		return (T) mapper.readValue(json, name);
	}

	@SuppressWarnings("unchecked")
	public <T> T jsonToObject(String json, TypeReference<?> name) throws IOException {
		if (name == null || name.getClass().isInstance("String"))
			return (T) json;
		return (T) mapper.readValue(json, name);
	}

	@SuppressWarnings("unchecked")
	public <T> T byteToObject(byte[] bytes, Class<?> name) throws IOException {
		if (name == null || name.isInstance("String"))
			return (T) bytes;
		return (T) mapper.readValue(bytes, name);
	}

	@SuppressWarnings("unchecked")
	public <T> T byteToObject(byte[] bytes, TypeReference<?> name) throws IOException {
		if (name == null || name.getClass().isInstance("byte[]"))
			return (T) bytes;
		return (T) mapper.readValue(bytes, name);
	}

	public String objectToJson(Object value) throws JsonProcessingException {
		if (value instanceof String)
			return (String) value;
		return mapper.writeValueAsString(value);
	}

	public byte[] objectToBytes(Object value) throws JsonProcessingException {
		return mapper.writeValueAsBytes(value);
	}

	@SuppressWarnings("unchecked") // Number.class
	public <T> T convertir(Object value, Class<?> name) {
		return (T) mapper.convertValue(value, name);
	}

	@SuppressWarnings("unchecked") // Number.class
	public <T> T convertirMap(Map<?, ?> value, Class<?> name) {
		return (T) mapper.convertValue(value, name);
	}

	// new TypeReference<Map<String, Object>>(){}
	public <T> T convertir(Object value, TypeReference<?> name) {
		return (T) mapper.convertValue(value, name);
	}

	// new TypeReference<Map<String, Object>>(){}
	public <T> T convertirMap(Map<?, ?> value, TypeReference<?> name) {
		return (T) mapper.convertValue(value, name);
	}

	public String objectToXML(Object value,boolean format) throws JAXBException {
		StringWriter sw = new StringWriter();
		Marshaller jaxbMarshaller = JAXBContext.newInstance(value.getClass()).createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,format);
		jaxbMarshaller.marshal(value, sw);
		
		return sw.toString();
	}
	
	public String soapToXML(String value,Class<?> name,String xml) {
		if(name!=null)
			return new StringBuilder().append(HEADER).append(value.substring(value.indexOf(nameClass(name, true)),(value.indexOf(nameClass(name, false))+nameClass(name, false).length()))).toString();
		else if(xml!=null)
			return new StringBuilder().append(HEADER).append(value.substring(value.indexOf(nameClass(xml, true)),(value.indexOf(nameClass(xml, false))+nameClass(xml, false).length()))).toString();
		else
			return "-1";
	}

	public Object xmlToObject(String value, Class<?> name) throws JAXBException {
		return JAXBContext.newInstance(name).createUnmarshaller().unmarshal(new ByteArrayInputStream(value.getBytes()));

	}
	
	private String nameClass(Class<?> name,boolean entrada) {
		String text = "";
		int i = (name.getName().length()-1);
		while(name.getName().charAt(i)!='.')
			text = name.getName().charAt(i--)+ text;
		if(entrada)
			return "<"+text+">";
		else
			return "</"+text+">";
	}
	
	private String nameClass(String name,boolean entrada) {
		if(name!=null) {
			if(entrada)
				return "<"+name+">";
			else
				return "</"+name+">";
		}
		return "-1";
	}
}
