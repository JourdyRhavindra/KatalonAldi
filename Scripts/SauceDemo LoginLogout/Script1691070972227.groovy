import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String[] userName = ["standard_user", "problem_user", "performance_glitch_user"];

WebUI.openBrowser('https://www.saucedemo.com/') //<-- Url lebih baik di tempatkan di global variable, karna bersifat config

for(int i = 0; i < userName.size(); i++) {

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_username'), userName[i])

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_password'), 'secret_sauce') 
//<-- password lebih baik di encrypt, bisa menggunakan CryptoUtil.encode(CryptoUtil.getDefault('text yang mau di encrypt') atau bisa menggunakan Help(filebar di katalon) -> Encrypt Text. Dan jangan lupa pake WebUI.setEncryptedText

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/click_loginButton'))
//<-- Setelah login dan masuk ke dalam HomePage jangan lupa dikasih verify kalo dia berhasil login dan pindah page
//Tips. verify bebas pake apa aja yang penting bisa menyatakan kalo berhasil login..

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/click_buttonOpenMenu'))
//<-- sebelum ngeclick button open menu sebaiknya di beri perintah waitforelement supaya kalo page nya masih loading dia masih di beri kesempatan buat nunggu

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/click_listLogout'))
//<-- kalo verify kalo dia berhasil logout

//New Task
//--------------
// Tambahin user ke 2, yg error itu. Tambahin conditional discript ini, kalo dia login pake user yg error dia bakal verify pop up error nya terus ngeskip dan lanjut ke user selanjutnya
// Tips. jadi user yg di sediakan web taro semua di array terus untuk user ke 2 itu di tangkep dan di pakein if else

}