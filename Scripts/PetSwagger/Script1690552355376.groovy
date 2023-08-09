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

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

int id = 10

String petId = 12

String status = 'available'

storeOrder = WS.sendRequest(findTestObject('POST Store Order', [('id') : id, ('petId') : petId, ('status') : status]))

WS.verifyResponseStatusCode(storeOrder, 200)

JsonSlurper jsonSlurper = new JsonSlurper()

Map resultPost = jsonSlurper.parseText(storeOrder.getResponseBodyContent())

println resultPost

assert resultPost.id == id

WS.comment(storeOrder.getResponseBodyContent())


getStoreOrder = WS.sendRequest(findTestObject('GET Store Order', [('id') : id ]))

WS.verifyResponseStatusCode(getStoreOrder, 200)

Map resultGet = jsonSlurper.parseText(getStoreOrder.getResponseBodyContent())

assert resultGet.id == id

WS.comment(getStoreOrder.getResponseBodyContent())


deleteStoreOrder = WS.sendRequest(findTestObject('DELETE Order Store', [('id') : id ]))

Map deleteResult = jsonSlurper.parseText(deleteStoreOrder.getResponseBodyContent())

getStoreAfterDelete = WS.sendRequest(findTestObject('GET Store Order', [('id') : id ]))

WS.verifyResponseStatusCode(getStoreAfterDelete, 404)

WS.verifyResponseStatusCode(deleteStoreOrder, 200)

println resultPost