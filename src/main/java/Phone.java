import java.util.ArrayList;

public class Phone {
  private String mPhoneNumber;
  private int mId;
  private String mType;

  private static ArrayList<Phone> instances = new ArrayList<Phone>();

  public Phone(String phoneNumber, String type) {
    mPhoneNumber = phoneNumber;
    mType = type;
    instances.add(this);
    mId = instances.size();
  }

  public String wholePhone() {
    return mPhoneNumber + " : " + mType;
  }

  public String getPhoneNumber() {
    return mPhoneNumber;
  }

  public String getType() {
    return mType;
  }

  public static ArrayList<Phone> all() {
    return instances;
  }

  public int getId() {
    return mId;
  }

  public static Phone find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }
}
