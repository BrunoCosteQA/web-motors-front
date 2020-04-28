package coste.product.test.automation.commons;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static coste.product.test.automation.commons.SeleniumDriver.driver;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.cucumber.core.api.Scenario;


public class Selenium {
	
	private static String cucumberReportMessage = "";
	public static JavascriptExecutor executor = (JavascriptExecutor) driver;
	private static final Level DADOS = Level.forName("DADOS", 100);
	public static Logger logger;
	public static Boolean localized = false;
	public static Boolean[] assertObjReceved = null;
	
//	public static String historyObjects;
	

//	public static void createWebDriver() {
//		
//		Functions.processKill();
//
//		try {
//			if (driver == null) {
//
//				log("\nPreparando ambiente ******************************************************************************************");
//
//				historyObjects = "";
//				
//						
//			}
//		} catch (Exception ex) {
//			log("Falha na execução, erro ao preparar ambiente");
//			driver = null;
//			log("---> log Exception 'getMessage': " + ex.getMessage());
//			log("---> log Exception 'getStackTrace': " + ex.getStackTrace());
//			assertTrue(false);
//		}
//	}

//	 * **************** CUCUMBER REPORTS ***************
//	 * 
//	 * *************************************************
	
	public static void printScreenAfterStep(Scenario scenario) {
		
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png"); 
}

	private static void setCucumberReportMessage(String msg) {
		cucumberReportMessage = msg;
	}

	private static String getCucumberReportMessage() {
		return cucumberReportMessage;
	}

	public static void cucumberReport(String msg) {
		setCucumberReportMessage(msg);
	}

	public static void cucumberReportAfterStep(Scenario scenario) {
		scenario.write(getCucumberReportMessage());
		cucumberReportMessage="";
	}
	
	public static void log(String msg) {
		logger = LogManager.getLogger(getCallerClassName());
		logger.log(DADOS, msg);
		System.out.println(msg);
	}

	private static Class<?> getCallerClassName() {
		// TODO Auto-generated method stub
		return null;
	}

//	 * **************** URLS **************** 
//	 * 
//	 * **************************************

	public static void openUrl(String url) {
		driver.get(url);
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void get(String string) {
		// TODO Auto-generated method stub
	}

//	 * **************** WEB ELEMENT **************** 
//	 * 
//	 * *********************************************

	public static WebElement find(String name, Boolean... verify) {

		WebElement element = null;

		///////////////////////////////////////////////////////////////////////////////////////////////////
		// -----------------------------------------------------------------------------------------------//
		//////// FIND BY
		/////////////////////////////////////////////////////////////////////////////////////////////////// XPATH//////////////////////////////////////////////////////////////////////////////
		try {
			element = driver.findElement(By.xpath(name));
		} catch (Exception e) {
		}
		if (verifyElement(element, verify) == true) {
			return element;
		}

		///////////////////////////////////////////////////////////////////////////////////////////////////
		// -----------------------------------------------------------------------------------------------//
		//////// FIND BY
		/////////////////////////////////////////////////////////////////////////////////////////////////// ID/////////////////////////////////////////////////////////////////////////////////
		try {
			element = driver.findElement(By.id(name));
		} catch (Exception e) {
		}
		if (verifyElement(element) == true) {
			return element;
		}

		///////////////////////////////////////////////////////////////////////////////////////////////////
		// -----------------------------------------------------------------------------------------------//
		//////// FIND BY
		/////////////////////////////////////////////////////////////////////////////////////////////////// NAME///////////////////////////////////////////////////////////////////////////////
		try {
			element = driver.findElement(By.name(name));
		} catch (Exception e) {
		}
		if (verifyElement(element) == true) {
			return element;
		}
		return null;

	}

	public static boolean verifyElement(WebElement element, Boolean... verify) {
		if (element == null) {
			return false;
		}
		if (verifyOption(verify) == false) {
			return true;
		}
		try {
			if (element.isDisplayed() == false) {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public static boolean verifyOption(Boolean[] verify) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void alertObjFound(String obj) {
		String alertmsg = "Objeto encontrado ! {" + obj + "}";
		log(alertmsg);
	}

	public static void alertObjSearching(String obj) {
		String alertmsg = "Procurando por objeto ... {" + obj + "}";
		log(alertmsg);
	}

	public static void alertObjNotFound(String obj) {
		String alertmsg = "Não encontrado ! {" + obj + "}";
		log(alertmsg);
	}

	public static void validaElemento(String obj, Boolean[] assertObjReceved) {

		try {
			if (assertObjReceved[0] == true) {
				if (localized == true)
					System.out.println("Ação com o elemento " + obj + " efetuada com sucesso");
				else
					System.out.println("Ocorreu um problema com o elemento " + obj);
				Assert.assertTrue(localized);
			}
		} catch (Exception e1) {
			if (localized != true)
				System.out.println("Elemento " + obj + " não econtrado");
			// e1.printStackTrace();
		}

	}

	public static void borderStyle(WebElement element) {
		if (element != null) {
			executor.executeScript("arguments[0].style.border = 'medium solid red';", element);
		}
	}

	public static void clear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			System.out.println("Não foi possível apagar o campo");
		}
	}

//	private static void elementClear(WebElement element) throws CommandException {
//		try {
//			element.clear();
//		} catch (Exception e) {
//			throw new CommandException(e);
//		}
//
//	}
	
	public static boolean waitExist(String obj, Integer timeout, Boolean... assertObj) {
		WebElement element = null;
		assertObjReceved = assertObj;
		localized = false;
		for (int i = 0; i <= timeout; i++) {
			element = find(obj);
			if (element != null) {
				localized = true;
				log("Elemento " + obj + " encontrado");
				break;
			} else
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		}
		validaElemento(obj, assertObjReceved);
		return localized;
	}

	public static String waitExistGetText(String obj, Integer timeout, Boolean... assertObj) {
		WebElement element = null;
		String textoObtido ="";
		assertObjReceved = assertObj;
		localized = false;
		for (int i = 0; i <= timeout; i++) {
			element = find(obj);
			if(element != null) {
				textoObtido = element.getText().toString();
				if (textoObtido.length() > 3 ) {
					localized = true;
					log("Elemento " + obj + " encontrado");
					try {
						executor.executeScript("arguments[0].style.backgroundColor = 'yellow';", element);
					} catch (Exception e) {;
					}
					log("Texto obtido [ " + textoObtido + " ]");
					break;
				} 
			} else
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		}
		validaElemento(obj, assertObjReceved);
		return textoObtido;
	}

	public static void waitExistClick(String obj, Integer timeout, Boolean... assertObj) {
		WebElement element = null;
		assertObjReceved = assertObj;
		localized = false;
		for (int i = 0; i <= timeout; i++) {
			element = find(obj);
			if (element != null) {
				localized = true;
				log("Elemento " + obj + " encontrado");
				try {
					executor.executeScript("arguments[0].style.border = 'medium solid blue';", element);
				} catch (Exception e) {;
				}
				element.click();
				break;
			} else
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		}
		validaElemento(obj, assertObjReceved);
		
	}

	public static void waitExistSet(String obj, String conteudo , Integer timeout, Boolean... assertObj) {
		WebElement element = null;
		assertObjReceved = assertObj;
		localized = false;
		for (int i = 0; i <= timeout; i++) {
			element = find(obj);
			if (element != null) {
				localized = true;
				log("Elemento " + obj + " encontrado");
				element.sendKeys(conteudo);
				break;
			} else
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		}
		validaElemento(obj, assertObjReceved);
	}
	
	public static void waitExistClickAndPerform(String menuDropDown, String link, Integer timeout, Boolean... assertObj) {
		Actions actions = new Actions(driver);
		WebElement element1 = null;
		WebElement element2 = null;
		assertObjReceved = assertObj;
		localized = false;
		for (int i = 0; i <= timeout; i++) {
			element1 = find(menuDropDown);
			if (element1 != null) {
				localized = true;
				actions.moveToElement(element1);
				//actions.click();
				actions.perform();
				try {
					executor.executeScript("arguments[0].style.border = 'medium solid blue';", element1);
				} catch (Exception e) {;
				}
				element2 = find(link);
				waitExistClick(link, 3);
				log("Elemento " + link + " encontrado");
				//element2.click();
				break;
			} else
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		}
		validaElemento(link, assertObjReceved);
	}	
	
}