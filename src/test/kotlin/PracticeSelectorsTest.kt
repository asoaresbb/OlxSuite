
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.RegisterExtension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.RemoteWebDriver
import pages.PracticePagePO
import utils.ScreenshotOnError
import java.time.Duration.ofSeconds

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PracticeSelectorsTest {

    private val driver = ChromeDriver()

    @RegisterExtension
    private val screenshotOnError = ScreenshotOnError.ScreenshotOnError(driver as RemoteWebDriver)

    @BeforeAll
    fun `maximize window`() {
        driver.manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(ofSeconds(5))
    }

    @Test
    fun `select by cssSelector`() {
        PracticePagePO(driver).navigateLogin()
            .`select by css - attribute placeholder`("letskodeit@gmail.com")
    }

    @Test
    fun `select by xpath - visible text`() {
        PracticePagePO(driver).navigateLogin()
            .`select by xpath with visible text`()
    }

    @Test
    fun `select by xpath - attribute`() {
        PracticePagePO(driver).navigatePracticeSelectors()
            .`select by relative xpath`()
    }

    @Test
    fun `select by visible linkText`() {
        PracticePagePO(driver).navigatePracticeSelectors()
            .`select by linkText`()

    }

    @AfterAll
    fun `close browser`() {
        driver.quit()
    }
}