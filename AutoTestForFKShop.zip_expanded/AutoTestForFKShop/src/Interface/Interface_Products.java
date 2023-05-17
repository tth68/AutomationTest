package Interface;

public class Interface_Products {
	public static String SEARCH_TXT_XPATH = "//input[@placeholder='Search']";
	public static String MSG_XPATH = "//div[@class='sort_wrapper']//p";
	
	public static String DETAIL_BTN_XPATH = "(//button[@class='list_btn'])[INDEX]";
	
	public static String KEYWORD = "Túi TiredCity";
	public static String NO_RESULT_MSG = "Sorry, no products can’t be found";
	
	public static String PRODUCT_NAME_XPATH = "//div[contains(text(),'" + KEYWORD + "')]";
}
