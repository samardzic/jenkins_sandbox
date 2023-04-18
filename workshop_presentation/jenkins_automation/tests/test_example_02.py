from time import sleep

import pytest
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import NoSuchElementException, TimeoutException


# Fixture Web Driver (Chrome, FF)
@pytest.fixture(params=["chrome"], scope="class")
def driver_init(request):
    if request.param == "chrome":
        driver = webdriver.Chrome()
        driver.implicitly_wait(10)

    request.cls.driver = driver
    yield
    driver.close()



@pytest.mark.usefixtures("driver_init")
class BaseTest:
    pass


class Test_URL(BaseTest):

    def enter_email(self):
        try:
            email_field = self.driver.find_element_by_xpath("//label[contains(text(),'Email:')]//input[@type='text']")
            email_field.click()
            email_field.send_keys('Hello World')
        except Exception:
            raise Exception("Email field text entry failed")

    def enter_mobile(self):
        try:
            mobile_field = self.driver.find_element_by_xpath("//label[contains(text(),'Mobile:')]//input[@type='text']")
            mobile_field.click()
            mobile_field.send_keys('064/55-44-123')
        except Exception:
            raise Exception("Mobile field text entry failed")


    def test_open_url(self):
        self.driver.get("http://10.247.113.246:8083/html_content/nikola.html")

        self.enter_email()
        self.enter_mobile()
        sleep(3)

