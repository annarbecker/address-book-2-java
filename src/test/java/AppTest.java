import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;


public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("First Name");
  }

  @Test
  public void createContactTest() {
      goTo("http://localhost:4567/");
      fill("#firstName").with("Jane");
      fill("#lastName").with("Doe");
      fill("#birthMonth").with("June");
      submit(".btn");
      assertThat(pageSource()).contains("Doe");
  }
}

  // @Test
  // public void createContactTest() {
  //     goTo("http://localhost:4567/");
  //     fill("#firstName").with("Jane");
  //     fill("#lastName").with("Doe");
  //     fill("#birthMonth").with("June");
  //     submit(".btn");
  //     fill("#firstName").with("Joe");
  //     fill("#lastName").with("Doe");
  //     fill("#birthMonth").with("Jay");
  //     click("a" withText("Jane"))
  //     assertThat(pageSource()).contains("Jane");


// }
