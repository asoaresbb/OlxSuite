
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.openqa.selenium.chrome.ChromeDriver
import pages.CetelemPO
import pages.MediumPO
import java.time.Duration.ofSeconds

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ActionsTest {

    private val driver = ChromeDriver()

    @BeforeAll
    fun `maximize window`() {
        driver.manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(ofSeconds(5))
    }

    @Test
    fun `hover mouse`() {
        MediumPO(driver).navigateToMedium()
            .`hover over an element`("Ivan Franchin")
    }

    @Test
    fun `ask for credit`() {
        CetelemPO(driver).navigateToCetelem()
            .`accept cookies cetelem`()
//            .`drag the slider via js`()
    }

    @Test
    fun `ask for credit2`() {
        CetelemPO(driver).navigateToOther()
            .`accept cookies empruntis`()
            .`drag the slider via selenium`()
    }

    @Test
    fun `upload file`() {
        CetelemPO(driver).navigateTopdfUpload()
            .`upload image`()
    }

    @AfterAll
    fun `close browser`() {
        driver.quit()
    }
}