package coste.product.test.automation.commons;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;

import static io.restassured.RestAssured.given;

public class Functions extends SeleniumDriver {

	public static String verifyOS() {
		String OS = null;

		if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) {
			OS = "WINDOWS";
		} else {
			OS = "LINUX";
		}

		assertNotNull(OS);

		return OS;
	}

	public static Boolean verificaFeriado() {

		Boolean feriado = null;
		String data = "";

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-3:00"));
		data = dateFormat.format(new Date(System.currentTimeMillis())).substring(0, 10);
		System.out.println("Data de hoje " + data);

		try {
			String responseGetDia = given().when().get("http://elekto.com.br/api/Calendars/br-SP").then()
					.statusCode(200).extract().body().asString();

			System.out.println("imprimindo o get " + responseGetDia);

			if (responseGetDia.contains(data)) {
				feriado = true;
				System.out.println("Hoje é feriado em São Paulo " + data);
			} else {
				feriado = false;
				System.out.println("Hoje não é feriado em São Paulo " + data);
			}

		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static void processKill() {

		Runtime rt = Runtime.getRuntime();
		String Browser = Setup.getProp("browser");

		if (verifyOS() == "LINUX") {

			String killFirefox = "pkill firefox";
			String killFirefoxDriver = "pkill geckodriver";
			String killChrome = "pkill chrome";
			String killChromeDriver = "pkill chromedriver";
			String verifyVersionChrome = "google-chrome -version";
			String verifyVersoinFirefox = "firefox -version";

			try {

				if (Browser == "firefox") {
					rt.exec(killFirefox);
					rt.exec(killFirefoxDriver);
					rt.exec(verifyVersoinFirefox).getOutputStream().toString();
					rt.exec(verifyVersionChrome).getOutputStream();
					System.out.println(verifyVersoinFirefox);
					System.out.println(verifyVersionChrome);
					

				} else {
					rt.exec(killChrome);
					rt.exec(killChromeDriver);
					rt.exec(verifyVersoinFirefox);
					rt.exec(verifyVersionChrome);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

			String killWinFirefox = "taskkill /f /im firefox.exe";
			String killWinFirefoxDriver = "taskkill /f /im geckodriver.exe";
			String killWinChrome = "taskkill /f /im chrome.exe";
			String killWinChromeDriver = "taskkill /f /im chromedriver.exe";

			try {

				if (Browser.contains("firefox")) {
					rt.exec(killWinFirefox);
					rt.exec(killWinFirefoxDriver);
				} else {
					rt.exec(killWinChrome);
					rt.exec(killWinChromeDriver);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public static void setPropDriver() {

		processKill();

		String OS = verifyOS();

		System.out.println(OS);

		if (OS == "LINUX") {
			System.setProperty("webdriver.chrome.driver", "lib/webdriver/linux/chromedriver");
			System.setProperty("webdriver.gecko.driver", "lib/webdriver/linux/geckodriver");

		} else {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\webdriver\\chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", ".\\lib\\webdriver\\geckodriver.exe");
		}
	}

	public static void finalizaExecucao() {

		driver.quit();
		System.out.println("driver finalizado");

	}

	public static void apagaReportAntesExecucao() {
		String pathReport = "target/cucumber-reports";
		try {
			//FileUtils.deleteDirectory(new File(pathReport));
			FileUtils.forceDelete(new File(pathReport));
			System.out.println("Apagando evidências antigas");
			} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	public static void setUp() {

		apagaReportAntesExecucao();

	}
}
