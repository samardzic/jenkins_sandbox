from time import sleep

import pytest
from selenium import webdriver


# Fixture for Firefox
@pytest.fixture(scope="class")
def ff_driver_init(request):
    ff_driver = webdriver.Firefox()
    ff_driver.implicitly_wait(10)
    request.cls.driver = ff_driver
    yield
    ff_driver.close()


# Fixture for Chrome
@pytest.fixture(scope="class")
def chrome_driver_init(request):
    chrome_driver = webdriver.Chrome()
    chrome_driver.implicitly_wait(10)
    request.cls.driver = chrome_driver
    yield
    chrome_driver.close()


@pytest.mark.usefixtures("chrome_driver_init")
class BasicTest:
    pass


class Test_URL(BasicTest):
    def test_open_url(self):
        self.driver.get("http://10.247.113.246:8083/html_content/nikola.html")
        print(self.driver.title)
        sleep(2)


