import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ContactTest {

  @Test
  public void contact_instantiatesCorrectly_true() {
    Contact testContact = new Contact("Jane", "Doe", "May");
    assertEquals(true, testContact instanceof Contact);
  }

  @Test
  public void contact_returnsContactFullName_JaneDoe() {
    Contact testContact = new Contact("Jane", "Doe", "May");
    assertEquals("Jane Doe", testContact.wholeName());
  }

  @Test
  public void contact_initiallyReturnsEmptyArrayList() {
    Contact testContact = new Contact("Jane", "Doe", "May");
    assertTrue(testContact.getPhone() instanceof ArrayList);
  }

  @Test
  public void all_returnsAllInstancesOfContact_true() {
    Contact firstContact = new Contact("Jane", "Doe", "May");
    Contact secondContact = new Contact("Jane", "Doe", "May");
    assertTrue(Contact.all().contains(firstContact));
    assertTrue(Contact.all().contains(secondContact));
  }
  @Test
  public void clear_removesAllContactInstancesFromMemory() {
    Contact testContact = new Contact("Jane", "Doe", "May");
    Contact.clear();
    assertEquals(Contact.all().size(), 0);
  }
  @Test
  public void find_returnsContactWithSameId() {
    Contact testContact = new Contact("Jane", "Doe", "May");
    assertEquals(Contact.find(testContact.getId()), testContact);
  }

  @Test
  public void addPhone_addPhonetoContact() {
    Contact testContact = new Contact("Jane", "Doe", "May");
    Phone homePhone = new Phone("123", "home");
    Phone workPhone = new Phone ("456", "cell");
    testContact.addPhone(homePhone);
    testContact.addPhone(workPhone);
    assertTrue(testContact.getPhone().contains(homePhone));
    assertTrue(testContact.getPhone().contains(workPhone));
  }
}
