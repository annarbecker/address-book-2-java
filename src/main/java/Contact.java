import java.util.ArrayList;

public class Contact {
  private static ArrayList<Contact> instances = new ArrayList<Contact>();
  private String mFirst;
  private String mLast;
  private String mBirthMonth;
  private int mId;
  private ArrayList<Phone> mPhone;

  public Contact(String first, String last, String birthMonth) {
    mFirst = first;
    mLast = last;
    mBirthMonth = birthMonth;
    mPhone = new ArrayList<Phone>();
    instances.add(this);
    mId = instances.size();
  }

  public String getFirst() {
    return mFirst;
  }

  public String getLast() {
    return mLast;
  }

  public String getBirthMonth() {
    return mBirthMonth;
  }

  public String wholeName() {
    return mFirst + " "  + mLast;
  }

  public ArrayList<Phone> getPhone() {
    return mPhone;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Contact> all() {
    return instances;
  }

  public static Contact find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public void addPhone(Phone phoneNumber) {
    mPhone.add(phoneNumber);
  }

  public static void clear() {
    instances.clear();
  }

}
