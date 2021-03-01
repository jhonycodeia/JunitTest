package co.com.utility;

import java.lang.reflect.Method;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ValidateJsonQvantel {

	private static final String TYPE_MOBILE = "mobile";
	private static final String TYPE_FIJO = "fija";

	public static void main(String[] args) {

		try {
			String valor = jsonGet(dataJson, "contact-media").toString();
			String limpio = cleanMedia(valor).toString();
			String limpio2 = cleanMedia(dataJson, "contact-media").toString();
			// String email = arrayGet(valor, "medium.email").toString();
			System.out.println("El valor es :" + valor);
			// System.out.println("El email es: " + email);
			System.out.println("limpio " + limpio);
			System.out.println("limpio2 " + limpio2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String dataJson = "{\r\n" + "   \"code\":\"14\",\r\n"
			+ "   \"description\":\"End-query type 5. The last name entered if it matches the one registered in the database for that ID number, but the person does NOT have commercial information in the DataCrédito database. \",\r\n"
			+ "   \"identifications\":{\r\n" + "      \"identification-type\":\"CC\",\r\n"
			+ "      \"identification-id\":50000000,\r\n" + "      \"issuing-date\":\"2020-01-10\",\r\n"
			+ "      \"issuing-authority\":{\r\n" + "         \"country\":\"CO\",\r\n"
			+ "         \"state-or-province\":\"ANtioquia\",\r\n" + "         \"city\":\"MEDELLIN\"\r\n" + "      }\r\n"
			+ "   },\r\n" + "   \"individuals\":{\r\n" + "      \"given-name\":\"Alfried\",\r\n"
			+ "      \"additional-name\":\"R\",\r\n" + "      \"family-name\":\"Gruber P\",\r\n"
			+ "      \"gender\":\"male\"\r\n" + "   },\r\n" + "   \"contact-media\":[\r\n" + "      {\r\n"
			+ "         \"medium\":{\r\n" + "            \"email\":\"ag@gmail.com\"\r\n" + "         },\r\n"
			+ "         \"medium-type\":\"email-address\",\r\n" + "         \"role\":\"primary\"\r\n" + "      },\r\n"
			+ "      {\r\n" + "         \"medium\":{\r\n" + "            \"telephone-number\":3170000000,\r\n"
			+ "            \"number-type\":\"mobile\"\r\n" + "         },\r\n"
			+ "         \"medium-type\":\"telephone-number\",\r\n" + "         \"role\":\"primary\"\r\n"
			+ "      },\r\n" + "      {\r\n" + "         \"medium\":{\r\n"
			+ "            \"telephone-number\":3180000000,\r\n" + "            \"number-type\":\"mobile\"\r\n"
			+ "         },\r\n" + "         \"medium-type\":\"telephone-number\",\r\n"
			+ "         \"role\":\"marketing\"\r\n" + "      },\r\n" + "      {\r\n" + "         \"medium\":{\r\n"
			+ "            \"telephone-number\":3190000000,\r\n" + "            \"number-type\":\"mobile\"\r\n"
			+ "         },\r\n" + "         \"medium-type\":\"telephone-number\",\r\n"
			+ "         \"role\":\"marketing\"\r\n" + "      },\r\n" + "      {\r\n" + "         \"medium\":{\r\n"
			+ "            \"telephone-number\":5710000,\r\n" + "            \"number-type\":\"fixed-line\"\r\n"
			+ "         },\r\n" + "         \"medium-type\":\"telephone-number\",\r\n"
			+ "         \"role\":\"primary\"\r\n" + "      },\r\n" + "      {\r\n" + "         \"medium\":{\r\n"
			+ "            \"street\":\"Calle 1B sur\",\r\n" + "            \"postal-code\":\"fixed-line\",\r\n"
			+ "            \"state-or-province\":\"05\",\r\n" + "            \"city\":\"5001\",\r\n"
			+ "            \"county\":\"9001001\"\r\n" + "         },\r\n"
			+ "         \"medium-type\":\"postal-address\",\r\n" + "         \"role\":\"primary\"\r\n" + "      },\r\n"
			+ "      {\r\n" + "         \"medium\":{\r\n" + "            \"street\":\"Calle el Poblado\",\r\n"
			+ "            \"postal-code\":\"fixed-line\",\r\n" + "            \"state-or-province\":\"05\",\r\n"
			+ "            \"city\":\"5001\",\r\n" + "            \"county\":\"9001001\"\r\n" + "         },\r\n"
			+ "         \"medium-type\":\"postal-address\",\r\n" + "         \"role\":\"marketing\"\r\n" + "      }\r\n"
			+ "   ]\r\n" + "}";

	public static Object cleanMedia(String text, String key) throws Exception {

		Object value = "";

		try {

			JSONObject json = new JSONObject(text);
			JSONArray jsonArray = new JSONArray(cleanMedia(jsonGet(text, key).toString()).toString());

			json.put(key, jsonArray);

			value = json.toString();

		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		return value;
	}

	private static Object cleanMedia(String text) throws Exception {

		Object value = "";
		boolean hayFijo = false;
		boolean hayMobile = false;
		int indexF = 0;
		int indexM = 0;

		try {
			JSONArray newArray = new JSONArray();
			JSONArray array = new JSONArray(text);

			for (int i = array.length() - 1; i >= 0; i--) {
				Object role = jsonGet(array.get(i).toString(), "role");
				if (role.equals("primary")) {
					Object type = jsonGet(array.get(i).toString(), "medium.number-type");
					if (type == null) {
						newArray.put(array.get(i));
					} else if (type.toString().equalsIgnoreCase(TYPE_MOBILE)) {
						hayMobile = true;
						indexM = i;
					} else if (type.toString().equalsIgnoreCase(TYPE_FIJO)) {
						hayFijo = true;
						indexF = i;
					}
				}
			}

			if (hayFijo && hayMobile || hayMobile && !hayFijo) {
				newArray.put(array.get(indexM));
			} else if (hayFijo) {
				newArray.put(array.get(indexF));
			}

			value = newArray.toString();

		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		return value;
	}

	public static Object jsonArray(String text, String key) throws Exception {
		return jsonValue(text, key, true, null);
	}

	public static Object jsonGet(String text, String key) throws Exception {
		return jsonValue(text, key, false, null);
	}

	public static Object jsonGetCondition(String text, String key, List<JsonCondition> conditions) throws Exception {
		return jsonValue(text, key, false, conditions);
	}

	public static Object jsonGetConditions(String text, String key, List<JsonCondition> conditions) throws Exception {
		return jsonValue(text, key, true, conditions);
	}

	private static Object jsonValue(String text, String key, boolean isArray, List<JsonCondition> conditions)
			throws Exception {
		try {
			if (key.contains(".")) {

				text = valueGet(text, key.substring(0, key.indexOf("."))).toString();
				key = key.substring(key.indexOf(".") + 1);

				if (text.charAt(0) == '[') {
					return arrayGet(text, key, isArray, conditions);
				} else {
					return jsonValue(text, key, false, null);
				}
			}
			return valueGet(text, key);
		} catch (Exception e) {
			return null;
		}
	}

	private static Object getKeyCondition(String json, String key) throws Exception {
		Object item = null;
		try {
			item = jsonGet(json, key);

			if (item == null) {
				return getKeyCondition(json, key.substring(key.indexOf(".") + 1));
			}

		} catch (Exception e) {
			throw e;
		}
		return item;
	}

	private static boolean validaCondition(String json, List<JsonCondition> conditions) throws Exception {
		for (JsonCondition condition : conditions) {
			Object itemCondition = getKeyCondition(json, condition.getKey());
			if (itemCondition != null) {
				if (condition.getValues() != null) {
					boolean isOption = true;
					for (String value : condition.getValues()) {
						if (!itemCondition.toString().equalsIgnoreCase(value)) {
							isOption = false;
						}
					}

					if (isOption) {
						return false;
					}

				} else if (condition.getValue() != null
						&& !itemCondition.toString().equalsIgnoreCase(condition.getValue())) {
					return false;
				}

			}
		}
		return true;
	}

	private static Object arrayGet(String text, String key, boolean isArray, List<JsonCondition> conditions)
			throws Exception {

		Object value = null;

		try {
			JSONArray array = new JSONArray(text);
			JSONArray newArray = new JSONArray();

			for (int i = 0; i < array.length(); i++) {
				Object item = jsonGet(array.get(i).toString(), key);
				if (item != null) {
					if (conditions != null) {
						if (validaCondition(array.get(i).toString(), conditions)) {
							newArray.put(item);
							value = item;
							if (!isArray) {
								break;
							}
						}
					} else {
						newArray.put(item);
						value = item;
						if (!isArray) {
							break;
						}
					}
				}
			}
			if (isArray) {
				value = newArray.toString();
			}

		} catch (Exception e) {
			throw e;
		}
		return value;
	}

	private static Object valueGet(String text, String key) throws Exception {

		Object value = null;
		try {
			JSONObject json = new JSONObject(text);

			if (json.has(key)) {
				value = json.get(key);
			}

		} catch (JSONException e) {
			throw e;
		}
		return value;
	}

	private static String dataFunction(String funcion) {
		return "setData" + funcion;
	}

	private static String foundFunction(String funcion) {
		return "setFound" + funcion;
	}

	public static void executeMethod(Object value, String funcion, IncompleteDataDTO incompleteDataDTO)
			throws Exception {

		try {
			Method[] metodos = incompleteDataDTO.getClass().getMethods();
			for (Method metodo : metodos) {
				if (metodo.getName().equalsIgnoreCase(dataFunction(funcion))) {
					Method method = incompleteDataDTO.getClass().getMethod(dataFunction(funcion), String.class);
					method.invoke(incompleteDataDTO, value != null ? value.toString() : "");
				} else if (metodo.getName().equalsIgnoreCase(foundFunction(funcion))) {
					Method method = incompleteDataDTO.getClass().getMethod(foundFunction(funcion), Boolean.TYPE);
					method.invoke(incompleteDataDTO, (value != null));
				}
			}
		} catch (Exception ex) {
			throw new Exception("Error ejecuntado metodo " + funcion, ex);
		}
	}

}
