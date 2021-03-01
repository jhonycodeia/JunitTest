package co.com.utility;

/**
 * DTO: Información incompleta del cliente.
 * 
 * @author fabian.aristizabala@mail.tigo.com.co
 * @version 1.0
 */
public class IncompleteDataDTO {

	private static boolean foundCustomer;
	private static boolean foundCustomerLocation;
	private static boolean foundCustomerDept;
	private static boolean foundCustomerCity;
	private static boolean foundCustomerAddress;
	private static boolean foundCustomerEmail;
	private static boolean foundCustomerTypePhone;
	private static boolean foundCustomerPhone;
	private static boolean foundCustomerName;
	private static boolean foundCustomerLastName;
	private static String responseCode;
	private static String messageCode;

	private static String dataCustomerCity;
	private static String dataCustomerDept;
	private static String dataCustomerAddress;
	private static String dataCustomerEmail;
	private static String dataCustomerPhone;
	private static String dataCustomerTypePhone;
	private static String dataCustomerName;
	private static String dataCustomerLastName;
	private static String dataCustomerLifecycleStatus;

	static {
		foundCustomer = Boolean.FALSE;
		foundCustomerLocation = Boolean.FALSE;
		foundCustomerDept = Boolean.FALSE;
		foundCustomerCity = Boolean.FALSE;
		foundCustomerAddress = Boolean.FALSE;
		foundCustomerEmail = Boolean.FALSE;
		foundCustomerTypePhone = Boolean.FALSE;
		foundCustomerPhone = Boolean.FALSE;
		foundCustomerName = Boolean.FALSE;
		foundCustomerLastName = Boolean.FALSE;
		dataCustomerCity = "";
		dataCustomerDept = "";
		dataCustomerAddress = "";
		dataCustomerEmail = "";
		dataCustomerPhone = "";
		dataCustomerTypePhone = "";
		dataCustomerName = "";
		dataCustomerLastName = "";
		dataCustomerLifecycleStatus = "";
	}

	public IncompleteDataDTO() {
		foundCustomer = Boolean.FALSE;
		foundCustomerLocation = Boolean.FALSE;
		foundCustomerDept = Boolean.FALSE;
		foundCustomerCity = Boolean.FALSE;
		foundCustomerAddress = Boolean.FALSE;
		foundCustomerEmail = Boolean.FALSE;
		foundCustomerTypePhone = Boolean.FALSE;
		foundCustomerPhone = Boolean.FALSE;
		foundCustomerName = Boolean.FALSE;
		foundCustomerLastName = Boolean.FALSE;
		dataCustomerCity = "";
		dataCustomerDept = "";
		dataCustomerAddress = "";
		dataCustomerEmail = "";
		dataCustomerPhone = "";
		dataCustomerTypePhone = "";
		dataCustomerName = "";
		dataCustomerLastName = "";
	}

	public static void validarCustomer() {
		foundCustomer= foundCustomerLocation && foundCustomerDept && foundCustomerCity && foundCustomerAddress
				&& foundCustomerEmail && foundCustomerTypePhone && foundCustomerPhone && foundCustomerName
				&& foundCustomerLastName;
	}

	public static void validarCustomerlifecycleStatus() {
		dataCustomerLifecycleStatus = dataCustomerCity.isEmpty() && dataCustomerDept.isEmpty() && dataCustomerAddress.isEmpty()
				&& dataCustomerEmail.isEmpty() && dataCustomerPhone.isEmpty() && dataCustomerName.isEmpty()
				&& dataCustomerLastName.isEmpty() ? "pendingConfirmation":"confirmed";
	}

	public static boolean isFoundCustomerLocation() {
		return foundCustomerLocation;
	}

	public static void setFoundCustomerLocation(boolean foundCustomerLocation) {
		IncompleteDataDTO.foundCustomerLocation = foundCustomerLocation;
	}

	public static boolean isFoundCustomerDept() {
		return foundCustomerDept;
	}

	public static void setFoundCustomerDept(boolean foundCustomerDept) {
		IncompleteDataDTO.foundCustomerDept = foundCustomerDept;
	}

	public static boolean isFoundCustomerCity() {
		return foundCustomerCity;
	}

	public static void setFoundCustomerCity(boolean foundCustomerCity) {
		IncompleteDataDTO.foundCustomerCity = foundCustomerCity;
	}

	public static boolean isFoundCustomerAddress() {
		return foundCustomerAddress;
	}

	public static void setFoundCustomerAddress(boolean foundCustomerAddress) {
		IncompleteDataDTO.foundCustomerAddress = foundCustomerAddress;
	}

	public static boolean isFoundCustomerEmail() {
		return foundCustomerEmail;
	}

	public static void setFoundCustomerEmail(boolean foundCustomerEmail) {
		IncompleteDataDTO.foundCustomerEmail = foundCustomerEmail;
	}

	public static boolean isFoundCustomerTypePhone() {
		return foundCustomerTypePhone;
	}

	public static void setFoundCustomerTypePhone(boolean foundCustomerTypePhone) {
		IncompleteDataDTO.foundCustomerTypePhone = foundCustomerTypePhone;
	}

	public static boolean isFoundCustomerPhone() {
		return foundCustomerPhone;
	}

	public static void setFoundCustomerPhone(boolean foundCustomerPhone) {
		IncompleteDataDTO.foundCustomerPhone = foundCustomerPhone;
	}

	public static boolean isFoundCustomerName() {
		return foundCustomerName;
	}

	public static void setFoundCustomerName(boolean foundCustomerName) {
		IncompleteDataDTO.foundCustomerName = foundCustomerName;
	}

	public static boolean isFoundCustomerLastName() {
		return foundCustomerLastName;
	}

	public static void setFoundCustomerLastName(boolean foundCustomerLastName) {
		IncompleteDataDTO.foundCustomerLastName = foundCustomerLastName;
	}

	public static boolean isFoundCustomer() {
		return foundCustomer;
	}

	public static void setFoundCustomer(boolean foundCustomer) {
		IncompleteDataDTO.foundCustomer = foundCustomer;
	}

	public static String getToString() {
		return "foundCustomer: " + foundCustomer + " " + "foundCustomerLocation: " + foundCustomerLocation + " "
				+ "foundCustomerAddress: " + foundCustomerAddress + " " + "foundCustomerTypePhone: "
				+ foundCustomerTypePhone + " " + "foundCustomerPhone: " + foundCustomerPhone + " "
				+ "foundCustomerName: " + foundCustomerName + " " + "foundCustomerLastName: " + foundCustomerLastName
				+ " " + "dataCustomerCity: " + dataCustomerCity + " " + "dataCustomerDept: " + dataCustomerDept + " "
				+ "dataCustomerAddress: " + dataCustomerAddress + " " + "dataCustomerPhone: " + dataCustomerPhone + " "
				+ "dataCustomerName: " + dataCustomerName + " " + "dataCustomerLastName: " + dataCustomerLastName + " "
				+ "dataCustomerEmail: " + dataCustomerEmail + " dataCustomerTypePhone: " + dataCustomerTypePhone;
	}

	public static String getResponseCode() {
		return responseCode;
	}

	public static void setResponseCode(String responseCode) {
		IncompleteDataDTO.responseCode = responseCode;
	}

	public static String getMessageCode() {
		return messageCode;
	}

	public static void setMessageCode(String messageCode) {
		IncompleteDataDTO.messageCode = messageCode;
	}

	public static String getDataCustomerAddress() {
		return dataCustomerAddress;
	}

	public static void setDataCustomerAddress(String dataCustomerAddress) {
		IncompleteDataDTO.dataCustomerAddress = dataCustomerAddress;
	}

	public static String getDataCustomerEmail() {
		return dataCustomerEmail;
	}

	public static void setDataCustomerEmail(String dataCustomerEmail) {
		IncompleteDataDTO.dataCustomerEmail = dataCustomerEmail;
	}

	public static String getDataCustomerPhone() {
		return dataCustomerPhone;
	}

	public static void setDataCustomerPhone(String dataCustomerPhone) {
		IncompleteDataDTO.dataCustomerPhone = dataCustomerPhone;
	}

	public static String getDataCustomerTypePhone() {
		return dataCustomerTypePhone;
	}

	public static void setDataCustomerTypePhone(String dataCustomerTypePhone) {
		IncompleteDataDTO.dataCustomerTypePhone = dataCustomerTypePhone;
	}

	public static String getDataCustomerName() {
		return dataCustomerName;
	}

	public static void setDataCustomerName(String dataCustomerName) {
		IncompleteDataDTO.dataCustomerName = dataCustomerName;
	}

	public static String getDataCustomerLastName() {
		return dataCustomerLastName;
	}

	public static void setDataCustomerLastName(String dataCustomerLastName) {
		IncompleteDataDTO.dataCustomerLastName = dataCustomerLastName;
	}

	public static String getDataCustomerCity() {
		return dataCustomerCity;
	}

	public static void setDataCustomerCity(String dataCustomerCity) {
		IncompleteDataDTO.dataCustomerCity = dataCustomerCity;
	}

	public static String getDataCustomerDept() {
		return dataCustomerDept;
	}

	public static void setDataCustomerDept(String dataCustomerDept) {
		IncompleteDataDTO.dataCustomerDept = dataCustomerDept;
	}
	
	public static String getdataCustomerLifecycleStatus() {
		return dataCustomerLifecycleStatus;
	}

	public static void setdataCustomerLifecycleStatus(String dataCustomerLifecycleStatus) {
		IncompleteDataDTO.dataCustomerLifecycleStatus = dataCustomerLifecycleStatus;
	}
}
